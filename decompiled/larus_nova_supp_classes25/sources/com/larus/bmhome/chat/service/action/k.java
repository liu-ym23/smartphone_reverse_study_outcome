package com.larus.bmhome.chat.service.action;

import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.InputDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements b {
    public final a a;

    public k(a r2) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        this.a = r2;
    }

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(wh8.a r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        com.larus.bmhome.chat.api.i r0 = this.a.a;
        if (ic8.n.A(r12.a) == false) goto L8;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), r0.a.getString(2131905449), null, false, 28);
        Function0<Unit> r13 = r0.i;
        if (r13 == null) goto L29;
        r13.invoke();
        return;
    L29:
        return;
    L8:
        com.larus.bmhome.chat.api.i r1 = this.a.a;
        wc9.e r2 = r12.a;
        List r3 = CollectionsKt.emptyList();
        Boolean r4 = Boolean.TRUE;
        String r5 = r1.a.getString(2131905460);
        Intrinsics.checkNotNullParameter(r5, "title");
        if (r2 == null) goto L11;
        String r7 = r2.c;
    L12:
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        i r8 = new i(this, r2, r12, r1);
        Intrinsics.checkNotNullParameter(r8, "listener");
        j r10 = new j(r2, r12, r1);
        Intrinsics.checkNotNullParameter(r10, "listener");
        InputDialog r9 = new InputDialog();
        r9.e = r4;
        r9.f = r5;
        r9.g = r7;
        r9.k = null;
        r9.l = r8;
        r9.m = null;
        r9.n = r10;
        r9.h = 40;
        r9.i = r3;
        r9.j = false;
        FragmentManager r6 = r1.a.getChildFragmentManager();
        LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, null, r11);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r9, r11) == false) goto L27;
    L19:
        int r14 = com.larus.bmhome.chat.trace.i0.a;
        int r15 = c.a;
        JSONObject r16 = c.c(r2, r12, r1.d, r1.e, r1.c);
        by7.e r17 = r1.b;
        Intrinsics.checkNotNullParameter(r16, "params");
        com.larus.bmhome.chat.trace.i0.a("click_edit_chat_name", r16, r17);
        Function2<ConversationFeedActionType, wh8.a, Unit> r18 = r0.j;
        if (r18 == null) goto L22;
        r18.invoke(ConversationFeedActionType.EDIT_NAME, r12);
    L22:
        Function0<Unit> r19 = r0.i;
        if (r19 == null) goto L30;
        r19.invoke();
        return;
    L30:
        return;
    L27:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L18:
        r9.show(r6, null);
        goto L19
    L11:
        r7 = null;
        goto L12
    }
}
