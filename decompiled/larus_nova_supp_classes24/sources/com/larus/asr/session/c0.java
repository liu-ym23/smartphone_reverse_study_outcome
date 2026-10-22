package com.larus.asr.session;

import android.app.Application;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class c0 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ InputTextAsrSession2 c;
    public final /* synthetic */ Application d;
    public final /* synthetic */ Message e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ long g;

    public /* synthetic */ c0(String r1, String r2, InputTextAsrSession2 r3, Application r4, Message r5, boolean r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        InputTextAsrSession2 r2 = this.c;
        Application r3 = this.d;
        Message r4 = this.e;
        boolean r5 = this.f;
        long r6 = this.g;
        FLogger r8 = FLogger.a;
        r8.i("InputTextAsrSession2", "[asrGlobalFail]: onSpeak #" + r0 + " onFail called, path=" + r1);
        boolean r10 = false;
        if (r2.a.ya() == false) goto L16;
        if (NetworkUtils.isNetworkAvailable(r3) == true) goto L16;
        t19.s.a.getClass();
        t19.s.b(r3, 2131908080, false);
        Function2<? super String, ? super Boolean, Unit> r7 = r2.j;
        if (r7 == null) goto L26;
        if (r4 == null) goto L10;
        String r9 = r4.getContent();
    L11:
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        r7.invoke(r9, Boolean.valueOf(r5));
        goto L26
    L10:
        r9 = null;
    L26:
        return Unit.INSTANCE;
    L16:
        if (r1.length() <= 0) goto L18;
        r10 = true;
    L18:
        if (r10 == false) goto L23;
        r8.e("InputTextAsrSession2", "[asrGlobalFail]: ASR failed can retry ，path  ：".concat(r1));
        if (((Boolean) r2.l.invoke(new com.larus.audio.a(r4.getContent(), r5))).booleanValue() == false) goto L22;
        r2.b().deleteOnNoAudioContent(r4);
        return Unit.INSTANCE;
    L22:
        r2.b().failAudioText(r4, r1, r6);
    L25:
        return Unit.INSTANCE;
    L23:
        r8.e("InputTextAsrSession2", "[asrGlobalFail]: ASR failed with no retrying");
        r2.b().deleteOnNoAudioContent(r4);
        goto L25
    }
}
