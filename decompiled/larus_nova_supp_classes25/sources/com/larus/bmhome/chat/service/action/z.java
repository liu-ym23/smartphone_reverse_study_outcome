package com.larus.bmhome.chat.service.action;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z implements com.larus.bmhome.chat.service.action.b {
    public static final /* synthetic */ int c = 0;
    public final com.larus.bmhome.chat.service.action.a a;
    public final ConversationFeedActionType b;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ProjectOption(projectId=" + this.a + ", projectName=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "projectId");
            Intrinsics.checkNotNullParameter(r3, "projectName");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ConversationFeedActionType.values().length];
            r0[ConversationFeedActionType.MOVE_TO_PROJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ConversationFeedActionType.REMOVE_FROM_PROJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static void b(View r6) {
        t19.s.j(t19.s.a, r6.getContext(), r6.getContext().getString(2131907222), null, false, 28);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.bmhome.chat.service.action.r, kotlin.jvm.functions.Function0] */
    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(final wh8.a r26) {
        Intrinsics.checkNotNullParameter(r26, "data");
        int r2 = c.a[this.b.ordinal()];
        boolean r16 = false;
        View r3 = null;
        if (r2 != 1) goto L5;
        com.larus.bmhome.chat.api.i r4 = this.a.a;
        wc9.e r5 = r26.a;
        if (r5 == null) goto L52;
        final String r6 = r5.a;
        if (r6 != null) goto L29;
        return;
    L29:
        if (r6.length() <= 0) goto L31;
        r16 = true;
    L31:
        if (r16 == true) goto L34;
        r6 = null;
    L34:
        if (r6 == null) goto L54;
        Function0<View> r7 = r4.f;
        if (r7 == null) goto L39;
        final View r8 = (View) r7.invoke();
        if (r8 == null) goto L39;
    L42:
        Function1 r9 = new q(r8, this, r26, r6);
        ?? r1 = new r(r8, this);
        IProjectListDataSource r10 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r10 != null) goto L45;
        FLogger.a.w("MoveToProjectActionHandler", "IProjectListDataSource not found");
        r1.invoke();
        return;
    L45:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a.a.a), null, null, new MoveToProjectConversationActionHandler$readProjectSnapshot$1(r10, r1, r9, null), 3, null);
        return;
    L39:
        r8 = r4.a.getView();
        if (r8 != null) goto L42;
        return;
    L54:
        return;
    L52:
        return;
    L5:
        if (r2 != 2) goto L56;
        final com.larus.bmhome.chat.api.i r11 = this.a.a;
        Function0<View> r12 = r11.g;
        if (r12 == null) goto L11;
        View r13 = (View) r12.invoke();
        if (r13 == null) goto L11;
    L19:
        r13.setVisibility(8);
        Context r15 = r13.getContext();
        Intrinsics.checkNotNullParameter(r15, "context");
        String r14 = r13.getContext().getString(2131907227);
        Intrinsics.checkNotNullParameter(r14, "title");
        String r17 = r13.getContext().getString(2131907226);
        Intrinsics.checkNotNullParameter(r17, "message");
        Integer r18 = Integer.valueOf(ContextCompat.getColor(r13.getContext(), v19.c.b(2130972079, r13.getContext(), 2131103136)));
        a0 r19 = new a0();
        String r20 = r13.getContext().getString(2131907225);
        Intrinsics.checkNotNullParameter(r19, "listener");
        Intrinsics.checkNotNullParameter(r20, ChatDraftItem.TYPE_TEXT);
        Integer r110 = Integer.valueOf(ContextCompat.getColor(r13.getContext(), v19.c.b(2130972123, r13.getContext(), 2131103203)));
        b0 r111 = new b0();
        String r112 = r13.getContext().getString(2131907224);
        Intrinsics.checkNotNullParameter(r111, "listener");
        Intrinsics.checkNotNullParameter(r112, ChatDraftItem.TYPE_TEXT);
        com.larus.common_ui.dialog.j r21 = new com.larus.common_ui.dialog.j(r15, new com.larus.common_ui.dialog.j.b(r14, r17, r18, r20, null, r110, true, r19, r112, Integer.valueOf(ContextCompat.getColor(r13.getContext(), v19.c.b(2130970996, r13.getContext(), 2131102650))), false, r111, false, null, null, null, 0.2f));
        r21.setOnDismissListener(new m(r11));
        if (DialogLancet.shouldBlockDialogShow(r21) == false) goto L48;
        DialogLancet.handleBlockedDialogShow(r21);
        return;
    L48:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L23:
        DialogLancet.beforeDialogShow(r21);
        r21.show();
        DialogLancet.afterDialogShow(r21);
        return;
    L11:
        Function0<View> r22 = r11.f;
        if (r22 == null) goto L14;
        r3 = (View) r22.invoke();
    L14:
        if (r3 != null) goto L18;
        r13 = r11.a.getView();
        if (r13 != null) goto L19;
        return;
    L18:
        r13 = r3;
        goto L19
    }

    public z(com.larus.bmhome.chat.service.action.a r2, ConversationFeedActionType r3) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        this.a = r2;
        this.b = r3;
    }
}
