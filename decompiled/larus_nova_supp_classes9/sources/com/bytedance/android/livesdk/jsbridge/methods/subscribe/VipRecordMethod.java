package com.bytedance.android.livesdk.jsbridge.methods.subscribe;

import android.app.Activity;
import android.content.Context;
import android.media.MediaRecorder;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VipRecordMethod extends com.bytedance.android.livesdk.jsbridge.methods.subscribe.a<k, VipRecordResultModel> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
        MediaRecorder r0 = AudioRecordHelper.c;     // Catch: Throwable -> L10
        if (r0 == null) goto L5;
        r0.reset();     // Catch: Throwable -> L10
    L5:
        MediaRecorder r1 = AudioRecordHelper.c;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        com.bytedance.bpea.entry.api.mediarecorder.a.a r2 = com.bytedance.bpea.entry.api.mediarecorder.a.a;     // Catch: Throwable -> L10
        TokenCert r3 = AudioRecordHelper.a;     // Catch: Throwable -> L10
        r2.getClass();     // Catch: Throwable -> L10
        com.bytedance.bpea.entry.api.mediarecorder.a.a.b(r1, r3);     // Catch: Throwable -> L10
    L8:
        AudioRecordHelper.c = null;     // Catch: Throwable -> L10
        AudioRecordHelper.e = null;     // Catch: Throwable -> L10
        return;
    }

    public VipRecordMethod() {
    }

    public static VipRecordResultModel j(final VipRecordResultModel.Code r2) {
        Function0<String> r0 = new VipRecordMethod$generateFailResp$getMsg$1(r2);
        VipRecordResultModel r1 = new VipRecordResultModel();
        r1.a(r2);
        r1.c((String) r0.invoke());
        return r1;
    }

    public final void invoke(Object r6, CallContext r7) {
        k r8 = (k) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r9 = r8.a();
        if (r9 == null) goto L77;
        int r0 = r9.hashCode();
        if (r0 == (-1367724422)) goto L64;
        if (r0 == 3540994) goto L19;
        if (r0 != 109757538) goto L77;
        if (r9.equals("start") == false) goto L77;
        TokenCert r10 = AudioRecordHelper.a;
        Completable.fromAction(c.a).observeOn(Schedulers.io()).subscribe(j.a);
        Context r11 = r7.getContext();
        Function0<Unit> r13 = new AnonymousClass2(this);
        Function0<Unit> r1 = new AnonymousClass3(this);
        Function0<Unit> r2 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r11, "contextActivity");
        Intrinsics.checkNotNullParameter(r13, "onGrant");
        Intrinsics.checkNotNullParameter(r1, "onRequesting");
        Intrinsics.checkNotNullParameter(r2, "onReject");
        if (m60.c.d(r11, new String[]{"android.permission.RECORD_AUDIO"}) == false) goto L17;
        r13.invoke();
        return;
    L17:
        r1.invoke();
        Activity r14 = ContextUtil.contextToActivity(r11);
        SettingKey r15 = m60.i.a;
        new m60.i.b(r14).b(new b(r2), null, AudioRecordHelper.a, new String[]{"android.permission.RECORD_AUDIO"});
        return;
    L19:
        if (r9.equals("stop") == false) goto L77;
        AudioRecordHelper.d = 0;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L27
        MediaRecorder r17 = AudioRecordHelper.c;     // Catch: Throwable -> L27
        if (r17 == null) goto L24;
        com.bytedance.bpea.entry.api.mediarecorder.a.a r18 = com.bytedance.bpea.entry.api.mediarecorder.a.a;     // Catch: Throwable -> L27
        TokenCert r3 = AudioRecordHelper.a;     // Catch: Throwable -> L27
        r18.getClass();     // Catch: Throwable -> L27
        com.bytedance.bpea.entry.api.mediarecorder.a.a.d(r17, r3);     // Catch: Throwable -> L27
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L27
    L29:
        Throwable r21 = Result.exceptionOrNull-impl(r20);
        if (r21 == null) goto L80;
        ALogger.e("AudioRecordHelper", "tryStopRecorder failure", r21);
    L80:
        MediaRecorder r23 = AudioRecordHelper.c;     // Catch: Throwable -> L38
        if (r23 == null) goto L35;
        com.bytedance.bpea.entry.api.mediarecorder.a.a r4 = com.bytedance.bpea.entry.api.mediarecorder.a.a;     // Catch: Throwable -> L38
        TokenCert r5 = AudioRecordHelper.a;     // Catch: Throwable -> L38
        r4.getClass();     // Catch: Throwable -> L38
        com.bytedance.bpea.entry.api.mediarecorder.a.a.b(r23, r5);     // Catch: Throwable -> L38
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L36:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L38
    L40:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L43;
        ALogger.e("AudioRecordHelper", "tryReleaseRecorder failure", r26);
    L43:
        AudioRecordHelper.c = null;
        long r27 = SystemClock.uptimeMillis() - AudioRecordHelper.b;
        if (r27 >= IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L50;
        PolarisFileWrapper r28 = AudioRecordHelper.e;
        if (r28 == null) goto L48;
        r28.delete();
    L48:
        Pair r29 = TuplesKt.to(VipRecordResultModel.Code.DURATION_TOO_SHORT, null);
    L59:
        VipRecordResultModel.Code r30 = (VipRecordResultModel.Code) r29.component1();
        File r31 = (File) r29.component2();
        if (r31 != null) goto L62;
        finishWithResult(j(r30));
        return;
    L62:
        VipRecordResultModel r33 = new VipRecordResultModel();
        VipRecordResultModel.a r34 = new VipRecordResultModel.a();
        r34.a(r31.getAbsolutePath());
        Unit r35 = Unit.INSTANCE;
        r33.b(r34);
        finishWithResult(r33);
        return;
    L50:
        if (r27 <= 60000) goto L56;
        PolarisFileWrapper r36 = AudioRecordHelper.e;
        if (r36 == null) goto L54;
        r36.delete();
    L54:
        r29 = TuplesKt.to(VipRecordResultModel.Code.DURATION_TOO_LONG, null);
        goto L59
    L56:
        if (AudioRecordHelper.e == null) goto L58;
        r29 = TuplesKt.to(VipRecordResultModel.Code.Success, AudioRecordHelper.e);
        goto L59
    L58:
        r29 = TuplesKt.to(VipRecordResultModel.Code.Failed, AudioRecordHelper.e);
        goto L59
    L35:
        r24 = null;
    L38:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L24:
        r19 = null;
    L27:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L64:
        if (r9.equals("cancel") == false) goto L77;
        AudioRecordHelper.d = 0;
        MediaRecorder r39 = AudioRecordHelper.c;     // Catch: Throwable -> L79
        if (r39 == null) goto L69;
        r39.reset();     // Catch: Throwable -> L79
    L69:
        MediaRecorder r40 = AudioRecordHelper.c;     // Catch: Throwable -> L79
        if (r40 == null) goto L72;
        com.bytedance.bpea.entry.api.mediarecorder.a.a r41 = com.bytedance.bpea.entry.api.mediarecorder.a.a;     // Catch: Throwable -> L79
        TokenCert r43 = AudioRecordHelper.a;     // Catch: Throwable -> L79
        r41.getClass();     // Catch: Throwable -> L79
        com.bytedance.bpea.entry.api.mediarecorder.a.a.b(r40, r43);     // Catch: Throwable -> L79
    L72:
        AudioRecordHelper.c = null;     // Catch: Throwable -> L79
        AudioRecordHelper.e = null;     // Catch: Throwable -> L79
    L73:
        PolarisFileWrapper r44 = AudioRecordHelper.e;
        if (r44 == null) goto L76;
        r44.delete();
    L76:
        finishWithSuccess();
        return;
    L77:
        finishWithFailure(new Throwable("error action"));
    }
}
