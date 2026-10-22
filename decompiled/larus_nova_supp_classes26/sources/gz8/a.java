package gz8;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {

    /* JADX INFO: renamed from: gz8.a$a, reason: collision with other inner class name */
    public static final class C0111a implements p0 {
        public final /* synthetic */ Function0<Unit> a;

        public final void confirm() {
            this.a.invoke();
        }

        public C0111a(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final class b implements u {
        public final /* synthetic */ Function0<Unit> a;

        public final void cancel() {
            this.a.invoke();
        }

        public b(Function0<Unit> r1) {
            this.a = r1;
        }
    }

    public static final void a(Fragment r5, int r6, Function0<Unit> r7, Function0<Unit> r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r7, "onShow");
        Intrinsics.checkNotNullParameter(r8, "onConfirm");
        Intrinsics.checkNotNullParameter(r9, "onCancel");
        if (r5.isAdded() == true) goto L5;
        return;
    L5:
        FragmentManager r0 = r5.getChildFragmentManager();
        if (r0.findFragmentByTag("chat_job_delete_confirm_dialog") == null) goto L8;
        return;
    L8:
        CommonDialog.a r2 = new CommonDialog.a();
        int r3 = f.a;
        if (r6 != 3) goto L11;
        String r4 = f.b("triggerTasks_dialog_Title_deleteTask");
    L12:
        r2.i(r4);
        if (r6 != 3) goto L15;
        String r10 = f.b("triggerTasks_dialog_desc_canNotRecover");
    L16:
        r2.g(r10);
        int r11 = g.a;
        Context r12 = r5.requireContext();
        Intrinsics.checkNotNullParameter(r12, "context");
        r2.q = v19.c.a(2130970996, r12, 2131102650);
        CommonDialog.a.f(r2, new C0111a(r8), f.b("button_delete"), false, 12);
        CommonDialog.a.e(r2, new b(r9), f.b("button_cancel"), 4);
        r2.z = false;
        CommonDialog r13 = r2.a();
        if (r0.isStateSaved() == false) goto L19;
        r13.T90(r0, "chat_job_delete_confirm_dialog");
    L24:
        r7.invoke();
        return;
    L19:
        LandscapeRestrictionOperation r14 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r13, "chat_job_delete_confirm_dialog", r14);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r13, r14) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L23:
        r13.show(r0, "chat_job_delete_confirm_dialog");
        goto L24
    L15:
        r10 = f.b("scheduledTasks_dialog_desc_canNotRecover");
        goto L16
    L11:
        r4 = f.b("scheduledTasks_dialog_Title_deleteTask");
        goto L12
    }
}
