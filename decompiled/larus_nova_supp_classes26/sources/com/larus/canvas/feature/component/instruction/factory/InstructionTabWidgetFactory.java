package com.larus.canvas.feature.component.instruction.factory;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.canvas.feature.component.input.v;
import com.larus.canvas.service.bean.InstructionTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class InstructionTabWidgetFactory {
    public Fragment a;
    public ViewGroup b;
    public ViewGroup c;
    public final List<InstructionTab> d;
    public final LinkedHashMap<InstructionTab, com.larus.canvas.feature.component.instruction.b> e;
    public Function0<String> f;
    public Map<String, String> g;
    public boolean h;
    public ValueAnimator i;

    public final void b() {
        ViewGroup r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L10;
        r1.height = 0;
        r0.setLayoutParams(r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public InstructionTabWidgetFactory() {
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
    }

    public final void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "tabLabel");
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((InstructionTab) r1).getTabLabel(), r10) == false) goto L4;
    L9:
        InstructionTab r2 = (InstructionTab) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        if (this.e.get(r2) == null) goto L28;
        ViewGroup r11 = this.c;
        if (r11 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        r11 = null;
    L16:
        ViewGroup.LayoutParams r3 = r11.getLayoutParams();
        if (r3 == null) goto L23;
        r3.height = -2;
        r11.setLayoutParams(r3);
        LifecycleOwner r12 = this.a;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        r12 = null;
    L21:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new InstructionTabWidgetFactory$selectInstructionTab$3$1$2(r2, null), 3, null);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void a(Fragment r7, ViewGroup r8, ViewGroup r9, v r10, Map r11) {
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r8, "tabContainer");
        Intrinsics.checkNotNullParameter(r9, "customAreaContainer");
        Intrinsics.checkNotNullParameter(r10, "getCurrentPrompt");
        Intrinsics.checkNotNullParameter(r11, "traceMap");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.f = r10;
        this.g = r11;
        b();
        LifecycleOwner r12 = this.a;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        r12 = null;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1(this, null), 3, null);
    }
}
