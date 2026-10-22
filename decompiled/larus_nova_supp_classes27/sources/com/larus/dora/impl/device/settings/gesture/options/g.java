package com.larus.dora.impl.device.settings.gesture.options;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.dora.impl.databinding.LarusDoraGPageOptionsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.nova.NovaApplication;
import com.larus.utils.j0;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g<T> implements FlowCollector {
    public final /* synthetic */ DoraGOptionsFragment a;

    public g(DoraGOptionsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r8, Continuation r9) {
        m r10 = (m) r8;
        if ((r10 instanceof m.b) == false) goto L26;
        s r11 = s.a;
        gd9.i r2 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r2);
        NovaApplication r3 = r2.getApplication();
        int r12 = ((m.b) r10).a;
        r11.getClass();
        s.b(r3, r12, false);
        DoraGOptionsFragment r13 = this.a;
        int r14 = DoraGOptionsFragment.i;
        q r15 = (q) r13.X90().getSelectedGestureStateFlow().getValue();
        if ((r15 instanceof q.b) == false) goto L46;
        LarusDoraGPageOptionsBinding r16 = this.a.f;
        if (r16 == null) goto L46;
        ItemGroup r17 = r16.e;
        if (r17 == null) goto L46;
        Sequence r18 = ViewGroupKt.getChildren(r17);
        if (r18 == null) goto L46;
        Iterator r20 = r18.iterator();
    L14:
        if (r20.hasNext() == false) goto L46;
        View r4 = (View) r20.next();
        Object r5 = r4.getTag();
        if ((r5 instanceof DoraGGestureSettings) == false) goto L18;
        DoraGGestureSettings r6 = (DoraGGestureSettings) r5;
    L19:
        if (r6 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        r4.setSelected(r7);
        goto L14
    L21:
        if (r6.d != ((q.b) r15).a.d) goto L23;
        r7 = true;
        goto L24
    L18:
        r6 = null;
    L46:
        return Unit.INSTANCE;
    L26:
        if ((r10 instanceof m.c) == false) goto L41;
        DoraGOptionsFragment r21 = this.a;
        p r22 = ((m.c) r10).a;
        int r23 = DoraGOptionsFragment.i;
        r21.getClass();
        CommonDialog.a r24 = new CommonDialog.a();
        r24.i(r22.a);
        r24.g(r22.b);
        Context r25 = r21.getContext();
        if (r25 == null) goto L30;
        Integer r26 = Integer.valueOf(v19.c.a(2130972081, r25, 2131103143));
    L31:
        f0 r27 = new f0(null, r26, null, 5);
        Intrinsics.checkNotNullParameter(r27, "commonDialogTextStyleConfig");
        r24.C = r27;
        j r28 = new j(r21, r22);
        int r30 = j0.a;
        CommonDialog.a.f(r24, r28, j0.d(2131902746), false, 12);
        Context r31 = r21.getContext();
        if (r31 == null) goto L34;
        Integer r32 = Integer.valueOf(v19.c.a(2130972079, r31, 2131103136));
    L35:
        f0 r0 = new f0(null, r32, null, 5);
        Intrinsics.checkNotNullParameter(r0, "commonDialogTextStyleConfig");
        r24.D = r0;
        CommonDialog.a.e(r24, new k(), j0.d(2131902742), 4);
        Context r33 = r21.getContext();
        if (r33 == null) goto L38;
        Integer r34 = Integer.valueOf(v19.c.a(2130972082, r33, 2131103146));
    L39:
        f0 r1 = new f0(null, r34, null, 5);
        Intrinsics.checkNotNullParameter(r1, "commonDialogTextStyleConfig");
        r24.E = r1;
        DoraGOptionsFragment.W90(r24.a(), r21.getChildFragmentManager(), "QuickControlGuideDialog");
        goto L46
    L38:
        r34 = null;
        goto L39
    L34:
        r32 = null;
        goto L35
    L30:
        r26 = null;
        goto L31
    L41:
        if ((r10 instanceof m.a) == false) goto L48;
        FragmentActivity r35 = this.a.getActivity();
        if (r35 == null) goto L46;
        r35.finish();
        goto L46
    L48:
        throw new NoWhenBranchMatchedException();
    }
}
