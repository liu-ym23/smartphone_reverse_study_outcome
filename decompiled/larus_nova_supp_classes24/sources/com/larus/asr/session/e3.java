package com.larus.asr.session;

import android.app.Application;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e3 implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SendMessageAsrSession c;
    public final /* synthetic */ Application d;
    public final /* synthetic */ Message e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ long j;

    public /* synthetic */ e3(String r1, String r2, SendMessageAsrSession r3, Application r4, Message r5, boolean r6, boolean r7, int r8, boolean r9, long r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public final Object invoke() {
        String r0 = this.a;
        String r1 = this.b;
        SendMessageAsrSession r2 = this.c;
        Application r3 = this.d;
        Message r4 = this.e;
        boolean r5 = this.f;
        boolean r6 = this.g;
        int r7 = this.h;
        boolean r8 = this.i;
        long r9 = this.j;
        FLogger r11 = FLogger.a;
        r11.i("SendMessageAsrSession", "[asrGlobalFail]: onSpeak #" + r0 + " onFail called, path=" + r1);
        String r13 = null;
        boolean r14 = false;
        if (r2.a.ya() == false) goto L15;
        if (com.larus.utils.f0.a(r3) == true) goto L15;
        t19.s.a.getClass();
        t19.s.b(r3, 2131908080, false);
        Function2<? super String, ? super Boolean, Unit> r10 = r2.l;
        if (r10 == null) goto L38;
        if (r4 == null) goto L10;
        r13 = r4.getContent();
    L10:
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        r10.invoke(r13, Boolean.valueOf(r5));
    L38:
        return Unit.INSTANCE;
    L15:
        if (r6 == false) goto L25;
        String r12 = r2.o;
        if (r12 != null) goto L19;
    L23:
        r11.i("SendMessageAsrSession", "[asrGlobalFail]: handsfree recorder interrupted (errorCode=" + r7 + "), delete local msg without SEND_FAILED");
        r2.e().deleteOnNoAudioContent(r4);
        return Unit.INSTANCE;
    L19:
        if ((true ^ StringsKt.isBlank(r12)) == false) goto L21;
        r13 = r12;
    L21:
        if (r13 == null) goto L23;
        r11.i("SendMessageAsrSession", "[asrGlobalFail]: handsfree recorder interrupted, backfill latest stream result");
        ((Boolean) r2.i.invoke(r13)).booleanValue();
        goto L23
    L25:
        if (r1.length() <= 0) goto L27;
        r14 = true;
    L27:
        if (r14 == false) goto L35;
        r11.e("SendMessageAsrSession", "[asrGlobalFail]: ASR failed can retry ，path  ：".concat(r1));
        if (r8 == false) goto L32;
        r11.i("SendMessageAsrSession", "[asrGlobalFail]: recorder interrupted (errorCode=" + r7 + "), delete local msg without SEND_FAILED");
        r2.e().deleteOnNoAudioContent(r4);
        return Unit.INSTANCE;
    L32:
        if (((Boolean) r2.n.invoke(new com.larus.audio.a(r4.getContent(), r5))).booleanValue() == false) goto L34;
        r2.e().deleteOnNoAudioContent(r4);
        return Unit.INSTANCE;
    L34:
        r2.e().failAudioText(r4, r1, r9);
    L37:
        return Unit.INSTANCE;
    L35:
        r11.e("SendMessageAsrSession", "[asrGlobalFail]: ASR failed with no retrying");
        r2.e().deleteOnNoAudioContent(r4);
        goto L37
    }
}
