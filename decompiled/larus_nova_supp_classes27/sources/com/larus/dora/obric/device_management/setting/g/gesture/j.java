package com.larus.dora.obric.device_management.setting.g.gesture;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.impl.databinding.LarusDoraPageObricGGestureOptionsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.lisitem.OCardListItem;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGestureOptionsFragment a;

    public j(DoraObricGGestureOptionsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        com.larus.dora.impl.device.settings.gesture.options.m r9 = (com.larus.dora.impl.device.settings.gesture.options.m) r7;
        if ((r9 instanceof com.larus.dora.impl.device.settings.gesture.options.m.b) == false) goto L31;
        WeakReference<com.obric.oui.toast.f> r10 = DoraObricToastUtils.a;
        DoraObricToastUtils.a(this.a.requireContext(), ((com.larus.dora.impl.device.settings.gesture.options.m.b) r9).a);
        DoraObricGGestureOptionsFragment r11 = this.a;
        int r12 = DoraObricGGestureOptionsFragment.j;
        com.larus.dora.impl.device.settings.gesture.options.q r13 = (com.larus.dora.impl.device.settings.gesture.options.q) r11.X90().getSelectedGestureStateFlow().getValue();
        if ((r13 instanceof com.larus.dora.impl.device.settings.gesture.options.q.b) == false) goto L43;
        LarusDoraPageObricGGestureOptionsBinding r14 = r11.f;
        if (r14 == null) goto L43;
        LinearLayout r15 = r14.d;
        if (r15 == null) goto L43;
        Sequence r16 = ViewGroupKt.getChildren(r15);
        if (r16 == null) goto L43;
        Iterator r17 = r16.iterator();
    L15:
        if (r17.hasNext() == false) goto L43;
        OCardListItem r2 = (View) r17.next();
        Object r3 = r2.getTag();
        OCardListItem r5 = null;
        if ((r3 instanceof DoraGGestureSettings) == false) goto L19;
        DoraGGestureSettings r4 = (DoraGGestureSettings) r3;
    L21:
        if ((r2 instanceof OCardListItem) == false) goto L23;
        r5 = r2;
    L23:
        if (r5 == null) goto L15;
        if (r4 != null) goto L26;
    L28:
        boolean r6 = false;
    L29:
        DoraObricGGestureOptionsFragment.Y90(r5, r6);
        goto L15
    L26:
        if (r4.d != ((com.larus.dora.impl.device.settings.gesture.options.q.b) r13).a.d) goto L28;
        r6 = true;
        goto L29
    L19:
        r4 = null;
    L43:
        return Unit.INSTANCE;
    L31:
        if ((r9 instanceof com.larus.dora.impl.device.settings.gesture.options.m.c) == false) goto L38;
        final DoraObricGGestureOptionsFragment r18 = this.a;
        final com.larus.dora.impl.device.settings.gesture.options.p r20 = ((com.larus.dora.impl.device.settings.gesture.options.m.c) r9).a;
        int r21 = DoraObricGGestureOptionsFragment.j;
        r18.getClass();
        com.obric.oui.dialog.v2.alert.g r22 = new com.obric.oui.dialog.v2.alert.g(r18.requireContext());
        ((com.obric.oui.dialog.base.i) r22).c = true;
        r22.w = false;
        String r1 = r20.a;
        r22.j = false;
        r22.h = r1;
        r22.i = r20.b;
        com.obric.oui.dialog.v2.alert.g.c(r22);
        int r0 = j0.a;
        r22.e(j0.d(2131902742), new b());
        r22.h(j0.d(2131902746), new c(r18, r20));
        com.obric.oui.dialog.v2.alert.c r23 = r22.a();
        if (DialogLancet.shouldBlockDialogShow(r23) == false) goto L47;
        DialogLancet.handleBlockedDialogShow(r23);
        goto L43
    L47:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L36:
        DialogLancet.beforeDialogShow(r23);
        r23.show();
        DialogLancet.afterDialogShow(r23);
        goto L43
    L38:
        if ((r9 instanceof com.larus.dora.impl.device.settings.gesture.options.m.a) == false) goto L45;
        FragmentActivity r24 = this.a.getActivity();
        if (r24 == null) goto L43;
        r24.finish();
        goto L43
    L45:
        throw new NoWhenBranchMatchedException();
    }
}
