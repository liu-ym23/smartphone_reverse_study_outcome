package com.larus.canvas.feature.component.instruction.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget;
import com.larus.canvas.feature.component.instruction.model.UIOptionItem;
import com.larus.canvas.feature.component.instruction.model.UIOptionStatus;
import com.larus.canvas.feature.component.instruction.ui.DropdownBoxSelectAdapter;
import com.larus.canvas.impl.databinding.LarusInstructionTabItemViewBinding;
import com.larus.canvas.service.bean.Icon;
import com.larus.canvas.service.bean.OptionExtra;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.canvas.service.bean.TabLabel;
import com.larus.utils.e1;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;
import v19.h;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DropDownBoxWidget extends AbstractInstructionTabWidget {
    public static final /* synthetic */ int l = 0;
    public Balloon g;
    public final int[] h;
    public final Rect i;
    public long j;
    public final DropDownBoxWidget$widthFixItemDecoration$1 k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final boolean m() {
        return false;
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget, com.larus.canvas.feature.component.instruction.b
    public final String a() {
        StringBuilder r0 = new StringBuilder();
        r0.append(i().getTabName());
        r0.append(';');
        LarusInstructionTabItemViewBinding r1 = this.e;
        if (r1 == null) goto L7;
        AppCompatTextView r2 = r1.e;
        if (r2 == null) goto L7;
        CharSequence r3 = r2.getText();
    L8:
        r0.append(r3);
        return r0.toString();
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void g() {
        LarusInstructionTabItemViewBinding r0 = this.e;
        if (r0 == null) goto L20;
        e1.o(r0.c);
        e1.x(r0.d);
        r0.d.setText(i().getTabName());
        e1.o(r0.e);
        e1.x(r0.b);
        if (Intrinsics.areEqual(i().getTabLabel(), TabLabel.LABEL_RADIO) == true) goto L9;
        if (Intrinsics.areEqual(i().getTabLabel(), TabLabel.LABEL_MODEL) == true) goto L9;
        return;
    L9:
        if (k().getUiOptionList().size() < 1) goto L22;
        e1.x(r0.e);
        AppCompatTextView r1 = r0.e;
        List<OptionItem> r2 = i().getOptionList();
        if (r2 == null) goto L17;
        OptionItem r3 = (OptionItem) CollectionsKt.getOrNull(r2, 0);
        if (r3 == null) goto L17;
        String r4 = r3.getDisplayText();
        if (r4 == null) goto L17;
    L18:
        r1.setText(r4);
        q(0);
        UIOptionItem r5 = (UIOptionItem) ListProtector.get(k().getUiOptionList(), 0);
        ListProtector.set(k().getUiOptionList(), 0, UIOptionItem.copy$default(r5, 0, null, false, UIOptionStatus.SELECTED, 7, null));
        return;
    L17:
        r4 = "";
        goto L18
    L22:
        return;
    }

    @Override // com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget
    public final void n() {
        LarusInstructionTabItemViewBinding r1 = this.e;
        if (r1 == null) goto L126;
        LinearLayout r2 = r1.a;
        if (r2 != null) goto L8;
        return;
    L8:
        if (k().getUiOptionList().isEmpty() == false) goto L10;
        return;
    L10:
        r2.getLocationOnScreen(this.h);
        r2.getWindowVisibleDisplayFrame(this.i);
        Rect r3 = this.i;
        int r4 = (r3.bottom - r3.top) - i5.d0();
        int r5 = j19.c.c(560);
        int r12 = this.i.bottom - this.h[1];
        List<OptionItem> r6 = i().getOptionList();
        if (r6 == null) goto L13;
        int r7 = r6.size();
    L14:
        Context r8 = null;
        if ((r7 * i5.d0()) >= RangesKt.coerceAtMost(r4, r5)) goto L17;
        Integer r9 = null;
    L18:
        if (r9 != null) goto L21;
    L22:
        boolean r14 = false;
    L24:
        View r10 = LayoutInflater.from(h().getContext()).inflate(2131562715, null);
        final RecyclerView r11 = r10.findViewById(2131382753);
        DropdownBoxSelectAdapter r13 = new DropdownBoxSelectAdapter();
        final ArrayList r15 = new ArrayList();
        List<OptionItem> r16 = i().getOptionList();
        if (r16 != null) goto L27;
    L29:
        boolean r17 = false;
    L30:
        if (r17 == false) goto L70;
        List<OptionItem> r18 = i().getOptionList();
        if (r18 == null) goto L70;
        Iterator<T> r19 = r18.iterator();
        int r20 = 0;
    L36:
        if (r19.hasNext() == false) goto L70;
        Object r21 = r19.next();
        int r110 = r20 + 1;
        if (r20 >= 0) goto L40;
        CollectionsKt.throwIndexOverflow();
    L40:
        OptionItem r22 = (OptionItem) r21;
        UIOptionItem r111 = (UIOptionItem) ListProtector.get(k().getUiOptionList(), r20);
        if (r111.getVisible() == false) goto L69;
        boolean r112 = h.a;
        if (h.a(r8) == false) goto L46;
        Icon r113 = r22.getDarkModeIcon();
    L47:
        Icon r27 = r113;
        if (r111.getUiStatus() != UIOptionStatus.SELECTED) goto L50;
        boolean r26 = true;
    L51:
        long r23 = r22.getId();
        String r114 = r22.getDisplayText();
        if (r114 != null) goto L54;
        String r24 = "";
    L55:
        OptionExtra r25 = r22.getExtra();
        if (r25 == null) goto L61;
        String r28 = r25.getSubDisplay();
        if (r28 == null) goto L61;
        String r29 = r28;
    L62:
        List<OptionItem> r30 = i().getOptionList();
        if (r30 != null) goto L65;
    L67:
        boolean r31 = false;
    L68:
        r15.add(new jy8.e(r23, r24, r29, r26, r27, !r31));
        goto L69
    L65:
        if (r20 != (r30.size() - 1)) goto L67;
        r31 = true;
    L61:
        r29 = "";
        goto L62
    L54:
        r24 = r114;
        goto L55
    L50:
        r26 = false;
        goto L51
    L46:
        r113 = r22.getIcon();
    L69:
        r20 = r110;
        r8 = null;
    L70:
        r13.submitList(r15);
        Function2<? super Integer, ? super jy8.e, Unit> r32 = new c(this);
        Intrinsics.checkNotNullParameter(r32, "listener");
        r13.b = r32;
        r11.setAdapter(r13);
        y6.d(r11, null, null, null, new d(r15, this), 15);
        Balloon r33 = this.g;
        if (r33 == null) goto L73;
        r33.h();
    L73:
        this.g = null;
        com.larus.bmhome.view.screenmenu.d r34 = com.larus.bmhome.view.screenmenu.d.a;
        Intrinsics.checkNotNull(r10);
        if (r9 != null) goto L76;
    L81:
        Integer r35 = null;
    L82:
        this.g = com.larus.bmhome.view.screenmenu.d.a(r34, r2, r10, false, r35, null, null, new e(this, r11), 48);
        Iterator<UIOptionItem> r36 = k().getUiOptionList().iterator();
        int r37 = 0;
    L84:
        if (r36.hasNext() == false) goto L92;
        if (r36.next().getUiStatus() != UIOptionStatus.SELECTED) goto L88;
        boolean r38 = true;
    L89:
        if (r38 == true) goto L93;
        r37 = r37 + 1;
    L93:
        if (r37 >= 0) goto L95;
    L97:
        boolean r39 = false;
    L98:
        if (r39 == false) goto L100;
        r37 = 0;
    L100:
        r11.scrollToPosition(r37);
        int r40 = r11.getItemDecorationCount();
        int r41 = 0;
        boolean r42 = false;
    L101:
        if (r41 >= r40) goto L106;
        if (Intrinsics.areEqual(r11.getItemDecorationAt(r41), this.k) == false) goto L105;
        r42 = true;
    L105:
        r41 = r41 + 1;
        goto L101
    L106:
        if (r42 == true) goto L109;
        r11.addItemDecoration(this.k);
    L109:
        if ((SystemClock.elapsedRealtime() - this.j) <= 500) goto L127;
        Balloon r43 = this.g;
        if (r43 != null) goto L113;
        return;
    L113:
        if (r14 == true) goto L116;
        r12 = 0;
    L116:
        r43.v(r2, 0, r12);
        return;
    L127:
        return;
    L95:
        if (r37 >= k().getUiOptionList().size()) goto L97;
        r39 = true;
        goto L98
    L88:
        r38 = false;
        goto L89
    L92:
        r37 = -1;
        goto L93
    L76:
        if (r9.intValue() <= 0) goto L78;
        boolean r44 = true;
    L79:
        if (r44 == false) goto L81;
        r35 = r9;
        goto L82
    L78:
        r44 = false;
        goto L79
    L27:
        if (r16.size() != k().getUiOptionList().size()) goto L29;
        r17 = true;
        goto L30
    L21:
        if (r9.intValue() < ((int) c7.d(Integer.valueOf(r4)))) goto L22;
        r14 = true;
        goto L24
    L17:
        r9 = Integer.valueOf(RangesKt.coerceAtMost((int) c7.d(Integer.valueOf(r4)), (int) c7.d(Integer.valueOf(r5))));
        goto L18
    L13:
        r7 = 0;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.canvas.feature.component.instruction.widget.DropDownBoxWidget$widthFixItemDecoration$1] */
    public DropDownBoxWidget() {
        this.h = new int[2];
        this.i = new Rect();
        this.k = new DropDownBoxWidget$widthFixItemDecoration$1(this);
    }

    public final boolean r() {
        if (k().getUiOptionList().isEmpty() == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(i().getTabLabel(), TabLabel.LABEL_RADIO) == true) goto L8;
        return false;
    L8:
        if (k().getUiOptionList().isEmpty() == false) goto L11;
        return false;
    L11:
        if (((UIOptionItem) ListProtector.get(k().getUiOptionList(), 0)).getUiStatus() != UIOptionStatus.SELECTED) goto L15;
        return true;
    L15:
        return false;
    }

    public final void q(int r3) {
        if (Intrinsics.areEqual(i().getTabLabel(), TabLabel.LABEL_RADIO) == false) goto L19;
        if (r3 != 0) goto L19;
        LarusInstructionTabItemViewBinding r4 = this.e;
        if (r4 == null) goto L10;
        AppCompatTextView r5 = r4.d;
        if (r5 == null) goto L10;
        e1.o(r5);
    L10:
        LarusInstructionTabItemViewBinding r6 = this.e;
        if (r6 == null) goto L33;
        AppCompatTextView r7 = r6.e;
        if (r7 == null) goto L34;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 == null) goto L18;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.setMarginStart(0);
        r7.setLayoutParams(r1);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        return;
    L33:
        return;
    L19:
        LarusInstructionTabItemViewBinding r8 = this.e;
        if (r8 == null) goto L24;
        AppCompatTextView r9 = r8.d;
        if (r9 == null) goto L24;
        e1.x(r9);
    L24:
        LarusInstructionTabItemViewBinding r10 = this.e;
        if (r10 == null) goto L36;
        AppCompatTextView r11 = r10.e;
        if (r11 == null) goto L37;
        ViewGroup.LayoutParams r2 = r11.getLayoutParams();
        if (r2 == null) goto L32;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r2;
        r12.setMarginStart(i5.Y());
        r11.setLayoutParams(r12);
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L37:
        return;
    }
}
