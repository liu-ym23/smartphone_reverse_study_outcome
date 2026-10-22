package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/suite/lark/platform/component/widget/floatingpanel/impl/FloatingPanelImpl;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FloatingPanelService$showCards$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ List<yoc.c> $cards;

    /* JADX WARN: Multi-variable type inference failed */
    public FloatingPanelService$showCards$1(List<? extends yoc.c> r1) {
        this.$cards = r1;
        super(1);
    }

    public final void invoke(a r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$runOnMain");
        List<yoc.c> r0 = this.$cards;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "cards");
        final c r11 = r10.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "cards");
        Log.i("FloatingPanelPresenter", "showCards, " + r0.size());
        final ArrayList r1 = new ArrayList();
        Iterator<yoc.c> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        yoc.c r3 = r2.next();
        int r4 = FloatingCardItem.h;
        String r5 = FloatingCardItem.a.a(r3);
        Iterator r6 = ((ArrayList) r11.f).iterator();
        int r7 = 0;
    L7:
        if (r6.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((FloatingCardItem) r6.next()).e, r5) == true) goto L13;
        r7 = r7 + 1;
    L13:
        if (r7 >= 0) goto L4;
        FloatingCardItem<?> r8 = new FloatingCardItem(r3, r11.a);
        r11.d(r8);
        ListProtector.add(r11.f, 0, r8);
        r1.add(r8);
        goto L4
    L12:
        r7 = -1;
        goto L13
    L16:
        r11.k(new FloatingPanelPresenter$showCards$2(r11, r1));
        Long r9 = FloatPanelHitPoint.a;
        FloatPanelHitPoint.b(r0.size(), ((ArrayList) r11.f).size());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
