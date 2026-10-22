package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common_ui.dialog.p0;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements p0 {
    public final /* synthetic */ BotAutoFillUIBinder a;
    public final /* synthetic */ Ref.ObjectRef<Job> b;

    public final void confirm() {
        this.a.c.dispatchUIAction(new a.b(true));
        BotAutoFillUIBinder r1 = this.a;
        dv8.b r2 = r1.d;
        if (r2 == null) goto L29;
        c0.I(r2.f(), r1.d.d(), r1.d.o(), r1.d.c(), "auto_fill_try", "auto_fill", r1.d.i(), r1.d.h(), r1.a, 513);
        dv8.b.C0105b r3 = r1.d.g();
        String r10 = r1.d.o();
        if (r1.d.j() == false) goto L7;
        String r5 = "1";
    L9:
        if (r1.d.q() == false) goto L11;
        String r8 = "1";
    L13:
        if ((!StringsKt.isBlank(r1.d.a.getEditParam().getDescription())) == false) goto L15;
        String r9 = "1";
    L16:
        String r6 = r1.d.f();
        String r11 = r1.d.e();
        String r19 = r1.d.l();
        boolean r7 = r1.d.a();
        String r12 = r1.d.c();
        String r13 = r1.d.d();
        Boolean r14 = r3.a;
        Integer r15 = r3.b;
        Boolean r4 = r3.c;
        SpeakerVoice r16 = r1.d.a.getEditParam().getVoice();
        if (r16 == null) goto L19;
        String r17 = r16.getId();
    L20:
        String r18 = dv8.c.b(r1.d.a.getEditParam().getVoice());
        SpeakerVoice r20 = r1.d.a.getEditParam().getVoice();
        if (r20 == null) goto L23;
        String r21 = r20.getName();
    L24:
        SpeakerVoice r22 = r1.d.a.getEditParam().getVoice();
        if (r22 == null) goto L27;
        String r23 = r22.getStyleId();
    L28:
        String r24 = r1.d.r();
        String r25 = r1.d.v();
        String r26 = r1.d.t();
        String r27 = r1.d.x();
        String r28 = r1.d.w();
        String r29 = r1.d.b();
        String r210 = r1.d.s();
        boolean r30 = r1.d.p();
        String r31 = r5;
        c0.i(r6, r31, r8, r9, r10, r11, r12, r13, r14, r15, r4, r17, r18, r19, r23, r21, Boolean.valueOf(r7), r24, r25, r26, r27, r28, r29, r210, Boolean.valueOf(r30), r1.a);
        goto L29
    L27:
        r23 = null;
        goto L28
    L23:
        r21 = null;
        goto L24
    L19:
        r17 = null;
        goto L20
    L15:
        r9 = TriggerSendLoading.NO_LOADING;
        goto L16
    L11:
        r8 = TriggerSendLoading.NO_LOADING;
        goto L13
    L7:
        r5 = TriggerSendLoading.NO_LOADING;
    L29:
        Job r32 = (Job) this.b.element;
        if (r32 == null) goto L33;
        Job.DefaultImpls.cancel$default(r32, null, 1, null);
        return;
    }

    public f(BotAutoFillUIBinder r1, Ref.ObjectRef<Job> r2) {
        this.a = r1;
        this.b = r2;
    }
}
