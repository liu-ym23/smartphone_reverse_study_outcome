package com.larus.bot.impl.feature.edit.component;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.trace.tracknode.TraceFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ BotCreateTitleComponent a;
    public final /* synthetic */ BotCreateViewModel b;

    public final void confirm() {
        this.a.bb();
        dv8.b.C0105b r1 = this.b.getBotCreateTrace().g();
        String r11 = this.b.getBotCreateTrace().o();
        if (this.b.getBotCreateTrace().j() == false) goto L5;
        String r6 = "1";
    L7:
        if (this.b.getBotCreateTrace().q() == false) goto L9;
        String r8 = "1";
    L10:
        boolean r5 = true;
        if ((!StringsKt.isBlank(this.b.getEditParam().getDescription())) == false) goto L13;
        String r9 = "1";
    L14:
        ru8.a r2 = this.a.F2();
        if (r2 == null) goto L17;
        String r3 = r2.n6();
    L18:
        ru8.a r10 = this.a.F2();
        if (r10 == null) goto L21;
        String r12 = r10.Wc();
    L22:
        String r13 = this.b.getBotCreateTrace().e();
        ru8.a r14 = this.a.F2();
        if (r14 != null) goto L25;
    L27:
        r5 = false;
    L28:
        if (r5 == false) goto L30;
        String r15 = "1";
    L31:
        BotCreateViewModel r7 = this.b;
        if (r7 == null) goto L36;
        BotEditParam r16 = r7.getEditParam();
        if (r16 == null) goto L36;
        boolean r17 = Intrinsics.areEqual(r16.getEnableWebSearch(), Boolean.TRUE);
    L37:
        if (r17 == false) goto L39;
        String r18 = "1";
    L40:
        BotCreateViewModel r19 = this.b;
        if (r19 == null) goto L45;
        BotEditParam r110 = r19.getEditParam();
        if (r110 == null) goto L45;
        boolean r20 = Intrinsics.areEqual(r110.getEnableGenPic(), Boolean.TRUE);
    L46:
        if (r20 == false) goto L48;
        String r21 = "1";
    L49:
        String r111 = this.b.getBotCreateTrace().c();
        String r112 = this.b.getBotCreateTrace().d();
        Boolean r4 = r1.a;
        Integer r22 = r1.b;
        Boolean r23 = r1.c;
        String r113 = this.b.getBotCreateTrace().i();
        String r24 = this.b.getBotCreateTrace().h();
        String r25 = this.b.getBotCreateTrace().l();
        BgImage r114 = this.b.getEditParam().getBgImage();
        if (r114 == null) goto L56;
        BgImageInfo r115 = r114.bgImageInfo;
        if (r115 == null) goto L56;
        Boolean r116 = r115.getBgImgOpen();
        if (r116 == null) goto L56;
        boolean r117 = r116.booleanValue();
    L57:
        SpeakerVoice r26 = this.b.getEditParam().getVoice();
        if (r26 == null) goto L60;
        String r39 = r26.getId();
    L61:
        String r27 = dv8.c.b(this.b.getEditParam().getVoice());
        String r28 = this.b.getBotCreateTrace().r();
        String r29 = this.b.getBotCreateTrace().v();
        String r210 = this.b.getBotCreateTrace().t();
        String r211 = this.b.getBotCreateTrace().x();
        String r212 = this.b.getBotCreateTrace().w();
        String r213 = this.b.getBotCreateTrace().b();
        String r30 = this.b.getBotCreateTrace().s();
        boolean r31 = this.b.getBotCreateTrace().p();
        boolean r32 = this.b.getBotCreateTrace().k();
        int r33 = this.b.getBotCreateTrace().m();
        String r34 = this.b.getBotCreateTrace().n();
        String r35 = this.b.getPrivateStatusString();
        boolean r118 = this.b.polishUseInternet();
        boolean r119 = this.b.autoFillUseInternet();
        TraceFragment r120 = s1a.a.c(this.a);
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.larus.trace.tracknode.TraceFragment");
        String r36 = r3;
        String r37 = r12;
        String r121 = r15;
        String r214 = r39;
        tx9.v.a(r36, r37, r18, r6, r21, r8, r9, r121, r11, r13, r111, r112, r4, r22, r23, r113, r24, r25, Boolean.valueOf(r117), r214, r27, r28, r29, r210, r211, r212, r213, r30, Boolean.valueOf(r31), Boolean.valueOf(r32), Integer.valueOf(r33), r34, r35, Boolean.valueOf(r118), Boolean.valueOf(r119), r120);
        return;
    L60:
        r39 = null;
    L56:
        r117 = false;
        goto L57
    L48:
        r21 = TriggerSendLoading.NO_LOADING;
    L45:
        r20 = false;
        goto L46
    L39:
        r18 = TriggerSendLoading.NO_LOADING;
    L36:
        r17 = false;
        goto L37
    L30:
        r15 = TriggerSendLoading.NO_LOADING;
        goto L31
    L25:
        if (r14.na() != true) goto L27;
    L21:
        r12 = null;
        goto L22
    L17:
        r3 = null;
        goto L18
    L13:
        r9 = TriggerSendLoading.NO_LOADING;
        goto L14
    L9:
        r8 = TriggerSendLoading.NO_LOADING;
        goto L10
    L5:
        r6 = TriggerSendLoading.NO_LOADING;
        goto L7
    }

    public o0(BotCreateTitleComponent r1, BotCreateViewModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
