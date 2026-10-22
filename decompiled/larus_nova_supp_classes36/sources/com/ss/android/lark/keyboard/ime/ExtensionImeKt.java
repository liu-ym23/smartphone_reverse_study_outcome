package com.ss.android.lark.keyboard.ime;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ExtensionImeKt {
    public static final void a(a r10, final i r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "listener");
        ImeWrapper r0 = (ImeWrapper) r10;
        Job r12 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new ExtensionImeKt$addImeStateChangeListener$job$1(r10, r11, null), 3, null);
        c r1 = r0.v(r11);
        final Ref.BooleanRef r2 = new Ref.BooleanRef();
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        r1.f(new ExtensionImeKt$addImeStateChangeListener$1$1(r3, r11, r2));
        r1.c(new ExtensionImeKt$addImeStateChangeListener$1$2(r3, r11, r2));
        r1.d(new ExtensionImeKt$addImeStateChangeListener$1$3(r2, r11, r3));
        r1.a(new ExtensionImeKt$addImeStateChangeListener$1$4(r2, r11, r3));
        r0.getExtraMap$keyboard_base_release().put(Integer.valueOf(r11.hashCode()), r12);
    }

    public static final void b(ImeWrapper r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Object r0 = r3.getTag(r4.hashCode());
        if ((r0 instanceof Job) == false) goto L5;
        Job r1 = (Job) r0;
    L6:
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        r3.getExtraMap$keyboard_base_release().remove(Integer.valueOf(r4.hashCode()));
        r3.v(r4).clear();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
