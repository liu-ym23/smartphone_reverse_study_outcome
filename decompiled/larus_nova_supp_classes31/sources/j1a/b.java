package j1a;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.larus.ui.arch.component.internal.control.ComponentStateController;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final void a(final Attachable r4, Composer r5, final int r6) {
        Intrinsics.checkNotNullParameter(r4, "attachable");
        Composer r7 = r5.startRestartGroup(684427853);
        if ((r6 & 6) == 0) goto L5;
        int r1 = r6;
    L11:
        if ((r1 & 3) != 2) goto L17;
        if (r7.getSkipping() == false) goto L17;
        r7.skipToGroupEnd();
    L22:
        ScopeUpdateScope r8 = r7.endRestartGroup();
        if (r8 == null) goto L26;
        r8.updateScope(new a(r4, r6));
        return;
    L26:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(684427853, r1, -1, "com.larus.ui.arch.CreateStateControllerComposable (AttachableExt.kt:173)");
    L19:
        y1a.a.a("attach", "create stateController composable");
        LifecycleOwner r0 = (LifecycleOwner) r7.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner());
        ComponentStateController r2 = new ComponentStateController(r0, Unit.INSTANCE);
        r2.b(r0);
        r4.putComponentStateController$component_release(r0, r2);
        if (ComposerKt.isTraceInProgress() == false) goto L22;
        ComposerKt.traceEventEnd();
        goto L22
    L5:
        if (r7.changedInstance(r4) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r6;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }
}
