package com.larus.bmhome.chat.layout.holder.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.fragment.b0;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ GenerateVideoBox a;
    public final /* synthetic */ AiGenVideoContentData b;

    public /* synthetic */ b(GenerateVideoBox r1, AiGenVideoContentData r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r26) {
        GenerateVideoBox r2 = this.a;
        AiGenVideoContentData r3 = this.b;
        Intrinsics.checkNotNullParameter((SimpleDraweeView) r26, "it");
        String r4 = null;
        ChatConstraintLayout r0 = ViewExtKt.f(r2).getView();     // Catch: IllegalStateException -> L14
        if (r0 != null) goto L6;
    L16:
        r2.q();
        BotModel r1 = r2.s;
        if (r1 == null) goto L19;
        String r6 = r1.getBotId();
    L20:
        Message r5 = r2.p;
        if (r5 == null) goto L23;
        String r7 = r5.getMessageId();
    L24:
        q0.a r8 = r2.u;
        if (r8 == null) goto L29;
        y r9 = r8.u0();
        if (r9 == null) goto L29;
        BotModel r10 = r9.j0();
    L30:
        q0.a r11 = r2.u;
        if (r11 == null) goto L35;
        y r12 = r11.u0();
        if (r12 == null) goto L35;
        wc9.e r13 = r12.h();
    L36:
        Message r14 = r2.p;
        if (r14 == null) goto L39;
        String r15 = tz9.a.a(r14);
    L40:
        Message r16 = r2.p;
        if (r16 == null) goto L43;
        Boolean r17 = Boolean.valueOf(com.larus.im.bean.message.a.C0(r16));
    L44:
        c4 r18 = new c4(r6, r7, "chat", r10, r13, "click", "0", null, 1, r15, r17, null, r2.n(), null, 10368);
        AppCompatActivity r19 = r2.getContext();
        if ((r19 instanceof AppCompatActivity) == false) goto L47;
        AppCompatActivity r20 = r19;
    L48:
        if (r20 == null) goto L54;
        b0 r21 = b0.a;
        FragmentManager r22 = r20.getSupportFragmentManager();
        if (r3 != null) goto L52;
        AiGenVideoContentData r23 = new AiGenVideoContentData(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    L53:
        os8.b.a r24 = new os8.b.a(r23, r18);
        r21.getClass();
        b0.a(r22, r24);
        goto L54
    L52:
        r23 = r3;
    L54:
        if (r3 == null) goto L56;
        String r25 = r3.getVid();
    L57:
        Message r27 = r2.p;
        if (r27 == null) goto L60;
        String r28 = r27.getMessageId();
    L61:
        BotModel r29 = r2.s;
        if (r29 == null) goto L64;
        r4 = r29.getBotId();
    L64:
        a4.c(r25, r28, r4, r2.n());
        return Unit.INSTANCE;
    L60:
        r28 = null;
        goto L61
    L56:
        r25 = null;
        goto L57
    L47:
        r20 = null;
        goto L48
    L43:
        r17 = null;
        goto L44
    L39:
        r15 = null;
    L35:
        r13 = null;
    L29:
        r10 = null;
        goto L30
    L23:
        r7 = null;
        goto L24
    L19:
        r6 = null;
        goto L20
    L6:
        if ((r0 instanceof ChatConstraintLayout) == false) goto L8;
        ChatConstraintLayout r30 = r0;     // Catch: IllegalStateException -> L14
    L9:
        if (r30 == null) goto L11;
        ViewExtKt.g(r30);     // Catch: IllegalStateException -> L14
    L11:
        if (r30 == null) goto L16;
        r30.u6();     // Catch: IllegalStateException -> L14
        goto L16
    L8:
        r30 = null;
    L14:
        e = move-exception;
        FLogger.a.e(r2.y, "Image4Box findFragment found exception " + e);
        goto L16
    }
}
