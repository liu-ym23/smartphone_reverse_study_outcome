package com.larus.dora.o.impl.diary;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.chip.OChip;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0 {
    public static final List<String> o = null;
    public static final List<String> p = null;
    public final Context a;
    public final CoroutineScope b;
    public final String c;
    public final int d;
    public final int e;
    public final l0 f;
    public final Function2<String, Boolean, Unit> g;
    public final Function1<Integer, Unit> h;
    public final OSheet i;
    public final LinkedHashSet<String> j;
    public EditText k;
    public OChipGroup l;
    public TextView m;
    public boolean n;

    public static final class a {
    }

    static {
        o = CollectionsKt.listOf(new String[]{"文笔流畅", "文笔优美", "逻辑清晰", "详略得当"});
        p = CollectionsKt.listOf(new String[]{"文笔粗糙", "语句不通", "逻辑不清", "详略不当"});
    }

    public final int a(int r3) {
        Resources r0 = this.a.getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    public final void c(List<String> r7) {
        ViewGroup r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        List<String> r8 = r7;
        this.j.retainAll(CollectionsKt.toSet(r8));
        LayoutInflater r1 = LayoutInflater.from(this.a);
        Iterator<T> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L12;
        final String r2 = (String) r9.next();
        OChip r3 = r1.inflate(2131562227, r0, false);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.oui.chip.OChip");
        OChip r4 = r3;
        r4.setText(r2);
        r4.setOnCheckedListener(new f0(this, r2));
        b(r4, false);
        if (this.j.contains(r2) == false) goto L11;
        r4.performClick();
    L11:
        r0.addView(r4);
        goto L7
    }

    public final void d(int r5) {
        TextView r0 = this.m;
        if (r0 == null) goto L6;
        r0.setText(this.a.getString(2131896101, new Object[]{Integer.valueOf(r5), 100}));
        return;
    }

    public final void b(OChip r3, boolean r4) {
        if (r4 == false) goto L4;
        int r0 = 2131104819;
    L5:
        if (r4 == false) goto L7;
        int r5 = 2131105292;
    L8:
        r3.setBackgroundColor(ContextCompat.getColor(this.a, r0));
        r3.getTextView().setTextColor(ContextCompat.getColor(this.a, r5));
        return;
    L7:
        r5 = 2131104350;
        goto L8
    L4:
        r0 = 2131104318;
        goto L5
    }

    public i0(Context r17, LifecycleCoroutineScope r18, String r110, int r20, int r21, l0 r22, d r23, e r24) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "scope");
        Intrinsics.checkNotNullParameter(r110, "diaryId");
        Intrinsics.checkNotNullParameter(r22, "target");
        Intrinsics.checkNotNullParameter(r23, "onToast");
        Intrinsics.checkNotNullParameter(r24, "onSubmitted");
        this.a = r17;
        this.b = r18;
        this.c = r110;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        final OSheet r2 = new OSheet(r17, 0, false, 30);
        this.i = r2;
        this.j = new LinkedHashSet();
        OSheetBase.DefaultImpls.q(r2, OSheet.HeightMode.WRAP_HEIGHT);
        OSheet.Header r6 = OSheet.Header.MODAL;
        Context r3 = r2.getContext();
        if (r20 != 1) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        int r7 = 2131903893;
    L9:
        OSheetBase.DefaultImpls.o(r2, r6, null, r3.getString(r7), null, false, null, new g0(r2), 16134);
        LinearLayout r4 = new LinearLayout(r17);
        r4.setOrientation(1);
        r4.setPadding(a(12), a(4), a(12), a(16));
        View r8 = LayoutInflater.from(r17).inflate(2131562228, r4, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.oui.chip.OChipGroup");
        OChipGroup r9 = (OChipGroup) r8;
        this.l = r9;
        if (r9 == null) goto L19;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof LinearLayout.LayoutParams) == false) goto L14;
        LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) r10;
    L15:
        if (r11 == null) goto L17;
        r11.topMargin = a(8);
    L18:
        r9.setLayoutParams(r11);
        goto L19
    L17:
        r11 = null;
        goto L18
    L14:
        r11 = null;
    L19:
        r4.addView(this.l);
        if (r20 != 1) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        List<String> r13 = o;
    L26:
        c(r13);
        LinearLayout r14 = new LinearLayout(r17);
        r14.setOrientation(1);
        r14.setBackgroundResource(2131233936);
        r14.setPadding(a(20), a(16), a(20), a(12));
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, a(130));
        r15.topMargin = a(16);
        r14.setLayoutParams(r15);
        EditText r16 = new EditText(r17);
        r16.setHint(r16.getContext().getString(2131896103));
        r16.setBackground(null);
        r16.setPadding(0, 0, 0, 0);
        r16.setGravity(8388659);
        r16.setTextSize(15.0f);
        r16.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(100)});
        r16.setTextColor(ContextCompat.getColor(r16.getContext(), 2131101368));
        r16.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r16.addTextChangedListener(new j0(this));
        this.k = r16;
        r14.addView(r16);
        LinearLayout r25 = new LinearLayout(r17);
        r25.setOrientation(0);
        r25.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView r26 = new TextView(r17);
        r26.setText(r26.getContext().getString(2131896102, new Object[]{100}));
        r26.setTextSize(12.0f);
        r26.setTextColor(ContextCompat.getColor(r26.getContext(), 2131101369));
        r25.addView(r26, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView r27 = new TextView(r17);
        r27.setTextSize(12.0f);
        r27.setTextColor(ContextCompat.getColor(r27.getContext(), 2131101369));
        this.m = r27;
        r25.addView(r27);
        r14.addView(r25);
        r4.addView(r14);
        d(0);
        OSheetBase.DefaultImpls.j(r2, r4);
        OSheetBase.DefaultImpls.k(r2, null, false, null, r2.getContext().getString(2131896104), true, new h0(this));
        return;
    L25:
        r13 = p;
        goto L26
    L22:
        r12 = false;
        goto L23
    L8:
        r7 = 2131903885;
        goto L9
    L5:
        r5 = false;
        goto L6
    }
}
