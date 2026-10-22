package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l3<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsSpecialContactsFragment a;

    public l3(DoraObricEarbudsSpecialContactsFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r18, Continuation r110) {
        List r1 = (List) r18;
        final DoraObricEarbudsSpecialContactsFragment r2 = this.a;
        LinearLayout r3 = r2.h;
        int r4 = 0;
        if (r3 == null) goto L43;
        r3.removeAllViews();
        int r5 = r1.size() + 1;
        Iterator<T> r7 = r1.iterator();
        int r8 = 0;
    L6:
        ConstraintLayout.LayoutParams r12 = null;
        if (r7.hasNext() == false) goto L28;
        T r9 = r7.next();
        int r16 = r8 + 1;
        if (r8 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        final y59.a r10 = (y59.a) r9;
        if (r5 > 1) goto L14;
        int r11 = 0;
    L20:
        final OCardListItem r13 = new OCardListItem(r2.requireContext(), null, 6, 0);
        r13.setCardType(0);
        OCardListItem.h(r13, r11);
        r13.setShowCardBg(true);
        r13.p(false);
        String r14 = r10.c();
        String r15 = "";
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        r13.setTitle(r14);
        r13.s(true);
        String r17 = r10.b();
        if (r17 == null) goto L27;
        r15 = r17;
    L27:
        r13.setSubTitle(r15);
        r13.q(true);
        OTextView r111 = r13.getTitleView();
        r111.setTextSize(2, 17.0f);
        r111.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        OTextView r112 = r13.getSubTitleView();
        r112.setTextSize(2, 14.0f);
        r112.setMaxLines(1);
        r13.setDefaultCustomEndView(2);
        r13.m(Intrinsics.areEqual(r10.e(), Boolean.TRUE));
        r13.r(false);
        r2.W90(r13);
        r13.setOnContentClickListener(new d3(r13, r2, r10));
        r13.setOnContentLongClickListener(new e3(r2, r10));
        r3.addView(r13);
        r8 = r16;
        goto L6
    L14:
        if (r8 != 0) goto L17;
        r11 = 1;
        goto L20
    L17:
        if (r8 != (r5 - 1)) goto L19;
        r11 = 3;
        goto L20
    L19:
        r11 = 2;
        goto L20
    L28:
        int r20 = r1.size();
        if (r5 > 1) goto L31;
        int r113 = 0;
    L37:
        final OCardListItem r6 = new OCardListItem(r2.requireContext(), null, 6, 0);
        r6.setCardType(0);
        OCardListItem.h(r6, r113);
        r6.setShowCardBg(true);
        r6.p(false);
        r6.setTitle(r2.getString(2131902309));
        r6.s(true);
        int r21 = ContextCompat.getColor(r2.requireContext(), 2131103056);
        r6.l(r21, r21);
        r6.q(false);
        r6.m(false);
        r6.r(false);
        r2.W90(r6);
        LinearLayout r22 = r6.getTitleContainer();
        r22.setGravity(17);
        r22.setPadding(0, 0, 0, 0);
        ConstraintLayout.LayoutParams r23 = r22.getLayoutParams();
        if ((r23 instanceof ConstraintLayout.LayoutParams) == false) goto L40;
        r12 = r23;
    L40:
        if (r12 == null) goto L42;
        ((ViewGroup.MarginLayoutParams) r12).width = 0;
        r12.t = 0;
        r12.v = 0;
        r12.s = -1;
        r12.u = -1;
        r12.E = 0.5f;
        r22.setLayoutParams(r12);
    L42:
        OTextView r24 = r6.getTitleView();
        r24.setGravity(17);
        r24.setTextSize(2, 16.0f);
        r24.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r6.setOnContentClickListener(new c3(r6, r2));
        r3.addView(r6);
        goto L43
    L31:
        if (r20 != 0) goto L34;
        r113 = 1;
        goto L37
    L34:
        if (r20 != (r5 - 1)) goto L36;
        r113 = 3;
        goto L37
    L36:
        r113 = 2;
    L43:
        boolean r25 = r1.isEmpty();
        View r26 = this.a.i;
        if (r26 == null) goto L49;
        if (r25 == false) goto L47;
        int r27 = 0;
    L48:
        r26.setVisibility(r27);
        goto L49
    L47:
        r27 = 8;
    L49:
        LinearLayout r28 = this.a.h;
        if (r28 == null) goto L52;
        r28.setVisibility(0);
    L52:
        TextView r30 = this.a.j;
        if (r30 == null) goto L58;
        if (r25 == false) goto L56;
        r4 = 8;
    L56:
        r30.setVisibility(r4);
    L58:
        return Unit.INSTANCE;
    }
}
