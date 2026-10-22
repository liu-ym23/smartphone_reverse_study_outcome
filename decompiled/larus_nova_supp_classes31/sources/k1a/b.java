package k1a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.ui.arch.component.external.delegate.BaseComponentWidget;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final void a(Fragment r1, Function1<? super Attachable, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "init");
        FragmentAttachExtKt.c(r1, r2);
    }

    public static final void b(BaseComponentWidget<Object> r4, Function1<? super Attachable, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "init");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "init");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.a(r4, r4);
        Attachable.Companion.getClass();
        Attachable r1 = Attachable.a.a(r0);
        if (r1.getComponentStateController$component_release(r4) != null) goto L12;
        int r2 = y1a.a.a;
        y1a.a.a("attach", "create stateController ".concat(r4.getClass().getSimpleName()));
        ComponentStateController r3 = new ComponentStateController(r4, r0);
        if (r4.j == null) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        r3.b(r4.F2());
    L11:
        r1.putComponentStateController$component_release(r4, r3);
        goto L12
    L10:
        r3.b(null);
        r1a.b r7 = new r1a.b(r4, r3);
        Intrinsics.checkNotNullParameter(r7, "listener");
        r4.h.add(r7);
        goto L11
    L7:
        r6 = false;
    L12:
        r5.invoke(r1);
    }
}
