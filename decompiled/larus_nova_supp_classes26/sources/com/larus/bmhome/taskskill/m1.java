package com.larus.bmhome.taskskill;

import android.content.Context;
import android.view.View;
import com.bytedance.keva.Keva;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.platform.service.AccountService;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class m1 implements Function1 {
    public final /* synthetic */ View a;
    public final /* synthetic */ SkillComponent b;

    public /* synthetic */ m1(View r1, SkillComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r26) {
        View r1 = this.a;
        final SkillComponent r2 = this.b;
        int r3 = ((Integer) r26).intValue();
        Regex r4 = SkillComponent.F2;
        com.larus.bmhome.view.screenmenu.d r5 = com.larus.bmhome.view.screenmenu.d.a;
        com.larus.bmhome.view.screenmenu.d.b(r1);
        RemoteControlAuthorizationMode.Companion.getClass();
        RemoteControlAuthorizationMode r6 = RemoteControlAuthorizationMode.a.a(r3);
        if (r6 == null) goto L38;
        j r7 = r2.X3();
        if (r7 == null) goto L38;
        if (r6 == r7.b) goto L38;
        if (r7.a.contains(r6) == false) goto L38;
        a r8 = r2.B3(r7.c);
        if (r6 != RemoteControlAuthorizationMode.FULL_ACCESS) goto L36;
        String r9 = AccountService.a.getSecUserId();
        boolean r10 = true;
        if ((!StringsKt.isBlank(r9)) == true) goto L19;
        r9 = null;
    L19:
        if (r9 != null) goto L21;
        boolean r11 = false;
    L22:
        if (r11 == true) goto L36;
        com.larus.common_ui.dialog.j r12 = r2.Y;
        if (r12 != null) goto L26;
    L28:
        r10 = false;
    L29:
        if (r10 == true) goto L38;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Context r13 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2).requireContext();
        int r14 = v19.c.a(2130972079, r13, 2131103136);
        int r15 = v19.c.a(2130970996, r13, 2131102650);
        int r16 = v19.c.a(2130972082, r13, 2131103146);
        int r17 = v19.c.a(2130970533, r13, 2131102542);
        Intrinsics.checkNotNullParameter(r13, "context");
        String r18 = r13.getString(2131908307);
        Intrinsics.checkNotNullParameter(r18, "title");
        String r19 = r13.getString(2131908298);
        Intrinsics.checkNotNullParameter(r19, "message");
        Integer r20 = Integer.valueOf(r14);
        u1 r110 = new u1(r2, r8);
        String r111 = r13.getString(2131908306);
        Intrinsics.checkNotNullParameter(r110, "listener");
        Intrinsics.checkNotNullParameter(r111, ShareType.TEXT);
        Integer r21 = Integer.valueOf(r15);
        Integer r112 = Integer.valueOf(r17);
        v1 r113 = new v1();
        String r22 = r13.getString(2131908304);
        Intrinsics.checkNotNullParameter(r113, "listener");
        Intrinsics.checkNotNullParameter(r22, ShareType.TEXT);
        final com.larus.common_ui.dialog.j r23 = new com.larus.common_ui.dialog.j(r13, new com.larus.common_ui.dialog.j.b(r18, r19, r20, r111, r21, r112, false, r110, r22, Integer.valueOf(r16), false, r113, false, null, null, null, 0.2f));
        r2.Y = r23;
        r23.setOnDismissListener(new p1(r2, r23));
        if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r23);
        goto L38
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L35:
        DialogLancet.beforeDialogShow(r23);
        r23.show();
        DialogLancet.afterDialogShow(r23);
        goto L38
    L26:
        if (r12.isShowing() != true) goto L28;
    L21:
        r11 = ((Keva) r2.Q1.getValue()).getBoolean("presented_".concat(r9), false);
    L36:
        r2.h3(r6, r8);
    L38:
        return Unit.INSTANCE;
    }
}
