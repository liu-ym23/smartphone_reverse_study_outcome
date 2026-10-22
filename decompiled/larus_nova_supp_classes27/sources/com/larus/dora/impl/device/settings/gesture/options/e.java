package com.larus.dora.impl.device.settings.gesture.options;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.bmhome.view.item.ItemTextDescSelector;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraGPageOptionsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e<T> implements FlowCollector {
    public final /* synthetic */ DoraGOptionsFragment a;

    public e(DoraGOptionsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r13, Continuation r14) {
        List r15 = (List) r13;
        g49.d.d("DoraGOptionsFragment", "gestureOptionsStateFlow collect: " + r15);
        final DoraGOptionsFragment r16 = this.a;
        LarusDoraGPageOptionsBinding r0 = r16.f;
        if (r0 == null) goto L41;
        Context r1 = r16.getContext();
        if (r1 == null) goto L39;
        r0.e.removeAllViews();
        int r2 = r15.size();
        Iterator<T> r17 = r15.iterator();
        int r4 = 0;
    L9:
        if (r17.hasNext() == false) goto L39;
        int r5 = r4 + 1;
        final DoraGGestureSettings r6 = (DoraGGestureSettings) r17.next();
        if (r6.b == 2) goto L13;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == true) goto L38;
        ItemTextDescSelector r8 = new ItemTextDescSelector(r1);
        r8.setText(r6.c());
        r8.setDescText(r6.b());
        r8.setTextFontWeight(500);
        r8.setTag(r6);
        if ((r16.X90().getSelectedGestureStateFlow().getValue() instanceof q.b) == false) goto L29;
        byte r9 = r6.d;
        Object r10 = r16.X90().getSelectedGestureStateFlow().getValue();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.gesture.options.SelectedGestureState.Success");
        if (r9 != ((q.b) r10).a.d) goto L27;
        boolean r11 = true;
    L28:
        r8.setSelected(r11);
        goto L29
    L27:
        r11 = false;
    L29:
        if (r2 != 1) goto L31;
        int r12 = 2131239210;
    L37:
        r8.setBackgroundResource(r12);
        e1.d(r8, new d(r16, r6));
        r0.e.addView(r8, new ViewGroup.LayoutParams(-1, -1));
        goto L38
    L31:
        if (r4 != 0) goto L34;
        r12 = 2131239212;
        goto L37
    L34:
        if (r4 != (r2 - 1)) goto L36;
        r12 = 2131239215;
        goto L37
    L36:
        r12 = 2131239218;
    L38:
        r4 = r5;
        goto L9
    L13:
        if (r6.c != 2) goto L19;
        if (r6.d != 34) goto L19;
        if (DoraAdapterExtKt.x(kj4.a.g()) == true) goto L19;
        r7 = true;
    L39:
        Unit r18 = Unit.INSTANCE;
    L41:
        return Unit.INSTANCE;
    }
}
