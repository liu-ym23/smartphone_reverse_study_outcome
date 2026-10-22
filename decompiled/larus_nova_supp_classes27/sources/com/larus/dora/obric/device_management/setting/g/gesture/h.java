package com.larus.dora.obric.device_management.setting.g.gesture;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageObricGGestureOptionsBinding;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGGestureOptionsFragment a;

    public h(DoraObricGGestureOptionsFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    public final Object emit(Object r24, Continuation r25) {
        List r0 = (List) r24;
        g49.d.d("DoraObricGGestureOptionsFragment", "gestureOptionsStateFlow collect: " + r0);
        final DoraObricGGestureOptionsFragment r2 = this.a;
        LarusDoraPageObricGGestureOptionsBinding r3 = r2.f;
        if (r3 == null) goto L75;
        LinearLayout r4 = r3.d;
        if (r4 == null) goto L75;
        r4.removeAllViews();
        ArrayList r5 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L8:
        boolean r6 = false;
        ?? r8 = 1;
        if (r1.hasNext() == false) goto L21;
        T r7 = r1.next();
        DoraGGestureSettings r9 = (DoraGGestureSettings) r7;
        if (r9.b == 2) goto L13;
    L19:
        if (r6 == true) goto L8;
        r5.add(r7);
        goto L8
    L13:
        if (r9.c != 2) goto L19;
        if (r9.d != 34) goto L19;
        if (DoraAdapterExtKt.x(kj4.a.g()) == true) goto L19;
        r6 = true;
        goto L19
    L21:
        Iterator r10 = r5.iterator();
        int r11 = 0;
    L23:
        if (r10.hasNext() == false) goto L75;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        final DoraGGestureSettings r14 = (DoraGGestureSettings) r12;
        int r15 = r5.size();
        if (r15 > r8) goto L30;
        int r16 = 0;
    L36:
        OCardListItem r17 = new OCardListItem(r2.requireContext(), null, 6, 0);
        r17.setCardType(0);
        OCardListItem.h(r17, r16);
        r17.setShowCardBg(r8);
        ViewGroup.LayoutParams r18 = r17.getCardContainer().getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L39;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r18;
    L40:
        if (r110 == null) goto L42;
        r110.setMarginStart(0);
        r110.setMarginEnd(0);
        r110.leftMargin = 0;
        r110.rightMargin = 0;
        r17.getCardContainer().setLayoutParams(r110);
    L42:
        r17.getCardContainer().setPadding(r2.W90(8), r2.W90(8), r2.W90(8), r2.W90(8));
        r17.getTitleContainer().setGravity(16);
        OTextView r20 = r17.getTitleView();
        r20.setGravity(8388611);
        r20.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r17.o(false);
        Iterator<T> r21 = CollectionsKt.listOf(new Drawable[]{r17.getCardContainer().getBackground(), r17.getContentContainer().getBackground()}).iterator();
    L44:
        if (r21.hasNext() == false) goto L63;
        Drawable r22 = (Drawable) r21.next();
        if ((r22 instanceof GradientDrawable) == false) goto L48;
        GradientDrawable r23 = (GradientDrawable) r22;
    L49:
        if (r23 == null) goto L44;
        float r111 = r2.W90(20);
        if (r16 != 0) goto L54;
        float[] r112 = {r111, r111, r111, r111, r111, r111, r111, r111};
    L61:
        if (r112 == null) goto L44;
        r23.setCornerRadii(r112);
        goto L44
    L54:
        if (r16 != 1) goto L56;
        r112 = new float[]{r111, r111, r111, r111, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L61
    L56:
        if (r16 == 3) goto L58;
        r112 = null;
        goto L61
    L58:
        r112 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r111, r111, r111, r111};
        goto L61
    L48:
        r23 = null;
        goto L49
    L63:
        r17.p(false);
        r17.setTitle(r14.c());
        r17.s(true);
        r17.setSubTitle(r14.b());
        r17.getSubTitleView().setMaxLines(5);
        if (r14.b().length() <= 0) goto L66;
        boolean r26 = true;
    L67:
        r17.q(r26);
        r17.setDefaultCustomEndView(2);
        com.larus.dora.impl.device.settings.gesture.options.q r27 = (com.larus.dora.impl.device.settings.gesture.options.q) r2.X90().getSelectedGestureStateFlow().getValue();
        if ((r27 instanceof com.larus.dora.impl.device.settings.gesture.options.q.b) == true) goto L70;
    L72:
        boolean r28 = false;
    L73:
        DoraObricGGestureOptionsFragment.Y90(r17, r28);
        r17.r(false);
        r17.setTag(r14);
        r17.setOnContentClickListener(new d(r2, r14));
        r4.addView(r17, new LinearLayout.LayoutParams(-1, -2));
        r11 = r13;
        r8 = 1;
        goto L23
    L70:
        if (r14.d != ((com.larus.dora.impl.device.settings.gesture.options.q.b) r27).a.d) goto L72;
        r28 = true;
        goto L73
    L66:
        r26 = false;
        goto L67
    L39:
        r110 = null;
        goto L40
    L30:
        if (r11 != 0) goto L33;
        r16 = 1;
        goto L36
    L33:
        if (r11 != (r15 - 1)) goto L35;
        r16 = 3;
        goto L36
    L35:
        r16 = 2;
    L75:
        return Unit.INSTANCE;
    }
}
