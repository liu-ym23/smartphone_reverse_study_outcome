package com.ss.android.lark.download.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.bytedance.lark.pb.media.v1.FileState;
import com.bytedance.lark.pb.media.v1.PushDownloadFileResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.download.service.DownloadProgress;
import com.ss.android.lark.download.service.FileDownloadState;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements com.ss.android.lark.sdk.f.a {
    public final /* synthetic */ e a;

    public class a implements com.ss.android.lark.sdk.g.b {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void a(byte[] r17) {
            e r2 = this.a.a;
            r2.getClass();
            PushDownloadFileResponse r0 = (PushDownloadFileResponse) PushDownloadFileResponse.ADAPTER.decode(r17);     // Catch: Exception -> L5
        L7:
            if (r0 != null) goto L10;
            return;
        L10:
            if (r0.type != File.EntityType.MESSAGE) goto L20;
            String r4 = r0.message_id;
            String r5 = r0.key;
            String r6 = r0.source_id;
            int r7 = r0.source_type.getValue();
            StringBuilder r8 = new StringBuilder(r4);
            if (TextUtils.isEmpty(r5) == true) goto L15;
            r8.append(r5);
        L15:
            if (TextUtils.isEmpty(r6) == true) goto L17;
            r8.append(r6);
        L17:
            if (r7 == 0) goto L19;
            r8.append(r7);
        L19:
            String r9 = r8.toString();
        L21:
            int r10 = r0.progress.intValue();
            long r11 = r0.rate.longValue();
            FileState r12 = r0.state;
            wbb.d.a r13 = (wbb.d.a) ((HashMap) r2.a).get(r9);
            if (r13 == null) goto L46;
            String r14 = r13.c;
            IGetDataCallback<T> r15 = r13.b;
            switch(e.a.a[r12.ordinal()]) {
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L35;
                case 4: goto L32;
                case 5: goto L29;
                case 6: goto L26;
                default: goto L46;
            };
        L26:
            if (r15 == 0) goto L28;
            ((HashMap) r2.a).remove(r9);
            Exception r16 = new Exception("unknown error");
            ErrorResult r18 = new ErrorResult(0);
            ErrorResult.access$002(r18, -439800);
            ErrorResult.access$102(r18, Error.ParameterNull);
            ErrorResult.access$202(r18, 0);
            ErrorResult.access$302(r18, r16);
            ErrorResult.access$402(r18, BuildConfig.FLAVOR);
            ErrorResult.access$502(r18, "can not download risk file.");
            ErrorResult.access$602(r18, BuildConfig.FLAVOR);
            ErrorResult.access$702(r18, BuildConfig.FLAVOR);
            ErrorResult.access$802(r18, 0);
            ErrorResult.access$902(r18, null);
            ErrorResult.access$1002(r18, null);
            ErrorResult.access$1102(r18, null);
            r15.onError(r18);
        L28:
            Log.i("DownloadFile", "onPushDownloadFileProgress-cancel_by_risk:" + r9 + "/" + r10);
            goto L46
        L29:
            if (r15 == 0) goto L31;
            ((HashMap) r2.a).remove(r9);
            r15.onError(new ErrorResult("Cancel download"));
        L31:
            Log.i("DownloadFile", "onPushDownloadFileProgress-cancel:" + r9 + "/" + r10);
            goto L46
        L32:
            if (r15 == 0) goto L34;
            ((HashMap) r2.a).remove(r9);
            r15.onSuccess(new wbb.d.b(r14, r0.is_encrypted.booleanValue()));
        L34:
            Log.i("DownloadFile", "onPushDownloadFileProgress-success:" + r9 + "/" + r10);
            goto L46
        L35:
            if (r15 == 0) goto L41;
            ((HashMap) r2.a).remove(r9);
            LarkError r19 = r0.error;
            Exception r20 = new Exception("unknown error");
            if (r19 == null) goto L39;
            int r21 = r19.status.intValue();
            int r110 = r19.code.intValue();
            String r111 = r19.display_message;
            String r22 = r19.display_title;
        L40:
            ErrorResult r112 = new ErrorResult(0);
            ErrorResult.access$002(r112, r110);
            ErrorResult.access$102(r112, Error.ParameterNull);
            ErrorResult.access$202(r112, r21);
            ErrorResult.access$302(r112, r20);
            ErrorResult.access$402(r112, r22);
            ErrorResult.access$502(r112, "network is abnormal, download failed");
            ErrorResult.access$602(r112, r111);
            ErrorResult.access$702(r112, BuildConfig.FLAVOR);
            ErrorResult.access$802(r112, 0);
            ErrorResult.access$902(r112, null);
            ErrorResult.access$1002(r112, null);
            ErrorResult.access$1102(r112, null);
            r15.onError(r112);
            goto L41
        L39:
            r110 = -1;
            r22 = BuildConfig.FLAVOR;
            r111 = r22;
            r21 = 0;
        L41:
            Log.i("DownloadFile", "onPushDownloadFileProgress-failed:" + r9 + "/" + r10);
            goto L46
        L42:
            OnUpdateProgressListener r23 = r13.a;
            if (r23 == null) goto L46;
            r23.onUpdateProgress(100, r10, r11);
            goto L46
        L45:
            Log.i("DownloadFile", "onPushDownloadFileProgress-wait:" + r9 + "/" + r10);
        L46:
            DownloadProgress r3 = new DownloadProgress();
            r3.setChannelId(r0.channel_id);
            r3.setKey(r0.key);
            r3.setMessageId(r0.message_id);
            r3.setProgress(r0.progress.intValue());
            r3.setSourceId(r0.source_id);
            r3.setState(FileDownloadState.valueOf(r0.state.getValue()));
            CoreThreadPool.getDefault().getUIExecutor().execute(new d(r2, r3));
            return;
        L20:
            r9 = r0.message_id + r0.key;
        L5:
            e = move-exception;
            Log.e(e.getMessage(), e);
            r0 = null;
            goto L7
        }
    }

    public final void a() {
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_DOWNLOAD_FILE, new a(this));
    }

    public c(e r1) {
        this.a = r1;
    }
}
