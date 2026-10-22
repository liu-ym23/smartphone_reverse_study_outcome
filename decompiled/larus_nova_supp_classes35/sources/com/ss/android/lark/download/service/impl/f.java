package com.ss.android.lark.download.service.impl;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.media.v1.DownloadFileRequest;
import com.bytedance.lark.pb.media.v1.DownloadFileScene;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class f implements AuthorizationServiceV2.b {
    public final /* synthetic */ j a;
    public final /* synthetic */ long b;
    public final /* synthetic */ IGetDataCallback c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ String m;
    public final /* synthetic */ OnUpdateProgressListener n;

    public /* synthetic */ f(j r1, long r2, FlowImageLoaderUtils.downloadVideo.2.downloadPath.1.1 r4, String r5, String r6, String r7, int r8, int r9, String r10, String r11, String r12) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = BuildConfig.FLAVOR;
        this.l = r12;
        this.m = BuildConfig.FLAVOR;
        this.n = null;
    }

    public final void a(ValidateResult r19) {
        final j r2 = this.a;
        long r3 = this.b;
        final IGetDataCallback r1 = this.c;
        String r5 = this.d;
        String r6 = this.e;
        String r7 = this.f;
        int r8 = this.g;
        int r9 = this.h;
        String r10 = this.i;
        String r11 = this.j;
        String r12 = this.k;
        String r13 = this.l;
        String r14 = this.m;
        final OnUpdateProgressListener r15 = this.n;
        r2.getClass();
        Log.i("AuthorizationServiceV2", "check downloadAuth cost time: " + String.valueOf(System.currentTimeMillis() - r3));
        if (owa.a.c().isAuthorizationPassed(r19) == true) goto L6;
        if (r1 == null) goto L23;
        r1.onError(new ErrorResult("no authorization"));
        return;
    L23:
        return;
    L6:
        final IGetDataCallback<wbb.d.b> r0 = new DownloadService$3(r2, r1);
        DownloadFileRequest.Builder r4 = new DownloadFileRequest.Builder().action(DownloadFileRequest.Action.DOWNLOAD).message_id(r5).source_id(r6).path(r10).channel_id(r7);
        if (r10 != null) goto L9;
        boolean r16 = true;
    L10:
        DownloadFileRequest.Builder r17 = r4.is_cache(Boolean.valueOf(r16)).key(r11).options(j.b(r12, r13, r14)).type(File.EntityType.MESSAGE);
        r17.source_type(Message.SourceType.fromValue(r8));
        StringBuilder r18 = new StringBuilder(r5);
        if (TextUtils.isEmpty(r11) == true) goto L14;
        r18.append(r11);
    L14:
        if (TextUtils.isEmpty(r6) == true) goto L16;
        r18.append(r6);
    L16:
        if (r8 == 0) goto L18;
        r18.append(r8);
    L18:
        final String r20 = r18.toString();
        Log.i("DownloadFile", "downloadMessageFile:" + r20);
        if (r9 == (-99)) goto L21;
        r17.scene(DownloadFileScene.fromValue(r9));
    L21:
        Log.i("DownloadFile", "downloadFileScene:" + r9);
        Map<String, wbb.d.a<wbb.d.b>> r21 = r2.a.a;
        StringBuilder r22 = new StringBuilder("messageId2CallbackItemMap length = ");
        final HashMap r23 = (HashMap) r21;
        r22.append(r23.size());
        Log.d(r22.toString());
        SdkSender.asynSendRequestNonWrap(Command.DOWNLOAD_FILE, r17, new DownloadService$10(r2, r23, r20, r15, r0), new g());
        a r24 = a.c.a;
        return;
    L9:
        r16 = false;
        goto L10
    }
}
