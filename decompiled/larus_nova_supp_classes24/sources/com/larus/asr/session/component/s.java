package com.larus.asr.session.component;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class s implements Function0 {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ AsrMessageResultPostComponent b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ s(f0 r1, AsrMessageResultPostComponent r2, Message r3, boolean r4, boolean r5, String r6, long r7, boolean r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r9;
    }

    public final Object invoke() {
        f0 r0 = this.a;
        AsrMessageResultPostComponent r1 = this.b;
        Message r2 = this.c;
        boolean r7 = this.d;
        boolean r3 = this.e;
        String r4 = this.f;
        long r5 = this.g;
        boolean r8 = this.h;
        if (r0.a() == false) goto L35;
        boolean r10 = false;
        if (r1.a.ya() == false) goto L17;
        int r9 = com.larus.utils.f0.a;
        AppHost.Companion r11 = AppHost.a;
        if (com.larus.utils.f0.a(r11.getApplication()) == true) goto L17;
        t19.s r6 = t19.s.a;
        Application r12 = r11.getApplication();
        r6.getClass();
        t19.s.b(r12, 2131908080, false);
        Function2<? super String, ? super Boolean, Unit> r13 = r1.m;
        if (r13 == null) goto L36;
        String r14 = r2.getContent();
        if (r14 != null) goto L14;
        r14 = "";
    L14:
        r13.invoke(r14, Boolean.valueOf(r7));
    L36:
        return Unit.INSTANCE;
    L17:
        if (r3 == false) goto L28;
        String r15 = r0.i;
        if (r15 != null) goto L21;
    L26:
        r1.n().deleteOnNoAudioContent(r2);
        return Unit.INSTANCE;
    L21:
        if ((!StringsKt.isBlank(r15)) == true) goto L24;
        r15 = null;
    L24:
        if (r15 == null) goto L26;
        Boolean r16 = (Boolean) r1.g.invoke(r15);
        goto L26
    L28:
        if (r4.length() <= 0) goto L30;
        r10 = true;
    L30:
        if (r10 == false) goto L32;
        r1.p(r2, r4, r5, r8, r7);
    L34:
        return Unit.INSTANCE;
    L32:
        r1.n().deleteOnNoAudioContent(r2);
        goto L34
    L35:
        return Unit.INSTANCE;
    }
}
