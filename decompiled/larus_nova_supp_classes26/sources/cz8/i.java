package cz8;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import bz8.k;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.chat.job.impl.page.ChatJobFragment;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import va8.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements j {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public i() {
    }

    @Override // cz8.j
    public final void onDestroyView() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
    }

    public static boolean e(Fragment r2) {
        if ((r2 instanceof ChatJobFragment) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L9;
        if (r2.isVisible() == false) goto L9;
        return true;
    }

    @Override // cz8.j
    public final void b(ChatJobFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) s1a.a.g(r3).getAbility(com.larus.bmhome.instruction.g.class);
        if (r0 != null) goto L6;
        FLogger.a.e("ChatJobTaskReplyModeConfig", "onVisible skipped, IInstructionInputAbility not found");
        return;
    L6:
        c(r3, r0, false);
        f(r3, r0);
        g(r3, r0, r0.tq());
    }

    public final boolean h(final Fragment r7) {
        if (this.a == false) goto L6;
        return true;
    L6:
        if ((r7 instanceof ChatJobFragment) == true) goto L10;
        this.a = true;
        return true;
    L10:
        if (r7.getView() != null) goto L12;
        return false;
    L12:
        final com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) s1a.a.g(r7).getAbility(com.larus.bmhome.instruction.g.class);
        if (r0 != null) goto L16;
        FLogger.a.e("ChatJobTaskReplyModeConfig", "setupTaskReplyModeGuard skipped, IInstructionInputAbility not found");
        return false;
    L16:
        this.a = true;
        this.b = r0.yW();
        this.c = false;
        c(r7, r0, false);
        f(r7, r0);
        g(r7, r0, r0.tq());
        LiveData<List<z0>> r2 = r0.uE();
        if (r2 == null) goto L19;
        r2.observe(r7.getViewLifecycleOwner(), new b(new g(this, r7, r0)));
    L19:
        r0.zU().observe(r7.getViewLifecycleOwner(), new b(new h(this, r7, r0)));
        return true;
    }

    public static void f(Fragment r1, com.larus.bmhome.instruction.g r2) {
        if ((r1 instanceof ChatJobFragment) == true) goto L6;
        return;
    L6:
        if (r2.yW() == true) goto L8;
        return;
    L8:
        k r3 = s1a.a.g(r1).getAbility(k.class);
        if (r3 != null) goto L12;
        FLogger.a.e("ChatJobTaskReplyModeConfig", "refresh task actionbar filter skipped, IChatJobSkillRefreshAbility not found");
        return;
    L12:
        r3.y70();
    }

    @Override // cz8.j
    public final void a(final Fragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "root");
        if (h(r2) == true) goto L6;
        r3.post(new f(this, r2));
        return;
    }

    public final void c(Fragment r5, com.larus.bmhome.instruction.g r6, boolean r7) {
        ReplyOption r0 = gz8.i.c(r6);
        if (r0 != null) goto L7;
        this.b = false;
        return;
    L7:
        if (this.d == true) goto L9;
        d(r6, r5, r0, false);
        this.d = true;
    L9:
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r0, "targetReplyMode");
        if (Intrinsics.areEqual(r6.Ql(), r0) == false) goto L13;
        this.b = true;
        return;
    L13:
        d(r6, r5, r0, r7);
        this.b = true;
    }

    public final void g(Fragment r2, com.larus.bmhome.instruction.g r3, List<z0> r4) {
        if (e(r2) == true) goto L6;
        return;
    L6:
        if (this.c == false) goto L9;
        return;
    L9:
        if (r3.yW() == true) goto L11;
        return;
    L11:
        p0 r5 = gz8.i.a(r4);
        if (r5 == null) goto L17;
        int r6 = gz8.b.b;
        gz8.b r7 = gz8.b.a.a(r5);
        int r8 = AgentMode.MOA.getValue();
        if (r7.a.a(r8, null) == null) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L20;
        return;
    L20:
        k r10 = s1a.a.g(r2).getAbility(k.class);
        if (r10 != null) goto L24;
        FLogger.a.e("ChatJobTaskReplyModeConfig", "refresh task skill skipped, IChatJobSkillRefreshAbility not found");
        return;
    L24:
        this.c = r10.Z9();
        return;
    L17:
        r9 = false;
        goto L18
    }

    public static boolean d(com.larus.bmhome.instruction.g r3, Fragment r4, ReplyOption r5, boolean r6) {
        if (r6 == true) goto L4;
    L6:
        ReplyOption r0 = r3.Ql();
        r3.fz(r5);
        FLogger.a.i("ChatJobTaskReplyModeConfig", "apply temporary task reply mode, current=" + r0 + ", target=" + r5 + ", applied=true, showToast=" + r6);
        c0 r7 = s1a.a.g(r4).getAbility(c0.class);
        if (r7 == null) goto L11;
        r7.KY();
        return true;
    L11:
        return true;
    L4:
        if ((r4 instanceof ChatJobFragment) == false) goto L6;
        s r1 = s.a;
        Context r2 = ((ChatJobFragment) r4).getContext();
        String r8 = gz8.f.b("scheduledTasks_toast_modeUnsupported");
        r1.getClass();
        s.t(r2, r8);
        goto L6
    }
}
