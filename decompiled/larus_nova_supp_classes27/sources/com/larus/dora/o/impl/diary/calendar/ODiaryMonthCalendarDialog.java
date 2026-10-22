package com.larus.dora.o.impl.diary.calendar;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.o.impl.diary.c0;
import com.larus.dora.o.impl.diary.i;
import com.larus.dora.o.impl.diary.week.OWeekPagerAdapter;
import com.larus.image.loader.ImageLoaderKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import w69.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0019H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/dora/o/impl/diary/calendar/ODiaryMonthCalendarDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "months", "", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$MonthData;", "selectedDate", "", "onDaySelected", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/calendar/OCalendarDataBuilder$DayCell;", "", "onReachHistoryEdge", "Lkotlin/Function0;", "sheetTitleView", "Landroid/widget/TextView;", "monthLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "monthAdapter", "Lcom/larus/dora/o/impl/diary/calendar/ODiaryMonthCalendarDialog$MonthAdapter;", "updateData", "newMonths", "newSelectedDate", "indexOfSelectedMonth", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "installTodayButton", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "onDestroyView", "formatSheetTitle", "month", "updateSheetTitle", "buildBody", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dp", "value", "Companion", "MonthAdapter", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryMonthCalendarDialog extends DialogFragment {
    public static final /* synthetic */ int k = 0;
    public List<com.larus.dora.o.impl.diary.calendar.a.b> d;
    public String e;
    public Function1<? super com.larus.dora.o.impl.diary.calendar.a.C0094a, Unit> f;
    public Function0<Unit> g;
    public TextView h;
    public LinearLayoutManager i;
    public b j;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<a> {
        public List<com.larus.dora.o.impl.diary.calendar.a.b> a;
        public String b;
        public final Function1<com.larus.dora.o.impl.diary.calendar.a.C0094a, Unit> c;

        public static final class a extends RecyclerView.ViewHolder {
            public final LinearLayout a;

            public a(LinearLayout r2) {
                Intrinsics.checkNotNullParameter(r2, "container");
                super(r2);
                this.a = r2;
            }
        }

        public final int getItemCount() {
            return this.a.size();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r22, int r23) {
            a r1 = (a) r22;
            Intrinsics.checkNotNullParameter(r1, "holder");
            com.larus.dora.o.impl.diary.calendar.a.b r2 = (com.larus.dora.o.impl.diary.calendar.a.b) ListProtector.get(this.a, r23);
            String r3 = this.b;
            final Function1<com.larus.dora.o.impl.diary.calendar.a.C0094a, Unit> r4 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "month");
            String r5 = "onDayClick";
            Intrinsics.checkNotNullParameter(r4, "onDayClick");
            r1.a.removeAllViews();
            Context r6 = r1.a.getContext();
            LinearLayout r7 = r1.a;
            TextView r8 = new TextView(r6);
            StringCompanionObject r9 = StringCompanionObject.INSTANCE;
            boolean r13 = false;
            r8.setText(String.format(Locale.getDefault(), "%d月", Arrays.copyOf(new Object[]{Integer.valueOf(r2.b)}, 1)));
            r8.setTypeface(Typeface.DEFAULT_BOLD);
            r8.setTextSize(2, 15.0f);
            r8.setTextColor(ContextCompat.getColor(r6, 2131101368));
            Intrinsics.checkNotNull(r6);
            Resources r11 = r6.getResources();
            int r12 = (int) ((WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density * 12) + 0.5f);
            Resources r14 = r6.getResources();
            r8.setPadding(0, r12, 0, (int) ((WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density * 8) + 0.5f));
            r7.addView(r8);
            LayoutInflater r10 = LayoutInflater.from(r6);
            int r15 = 7;
            Iterator r16 = CollectionsKt.chunked(r2.c, 7).iterator();
        L4:
            if (r16.hasNext() == false) goto L55;
            List r17 = (List) r16.next();
            LinearLayout r18 = new LinearLayout(r6);
            r18.setOrientation(r13 ? 1 : 0);
            int r110 = 0;
        L6:
            if (r110 >= r15) goto L54;
            View r111 = r10.inflate(2131560151, r18, r13);
            final com.larus.dora.o.impl.diary.calendar.a.C0094a r20 = (com.larus.dora.o.impl.diary.calendar.a.C0094a) CollectionsKt.getOrNull(r17, r110);
            int r112 = OWeekPagerAdapter.WeekViewHolder.b;
            Intrinsics.checkNotNull(r111);
            if (r20 != null) goto L10;
        L12:
            boolean r113 = false;
        L13:
            Intrinsics.checkNotNullParameter(r111, "dayView");
            Intrinsics.checkNotNullParameter(r4, r5);
            View r114 = r111.findViewById(2131365081);
            TextView r115 = (TextView) r111.findViewById(2131368563);
            SimpleDraweeView r0 = r111.findViewById(2131368557);
            Iterator r116 = r16;
            View r21 = r111.findViewById(2131368558);
            String r117 = r3;
            if (r20 != null) goto L16;
            r114.setBackground(null);
            r115.setText("");
            r0.setVisibility(8);
            r21.setVisibility(8);
            r111.setOnClickListener(null);
            r111.setClickable(false);
            String r118 = r5;
            Context r24 = r6;
        L53:
            r18.addView(r111);
            r110 = r110 + 1;
            r16 = r116;
            r3 = r117;
            r5 = r118;
            r6 = r24;
            r15 = 7;
            r13 = false;
            goto L6
        L16:
            Context r25 = r111.getContext();
            r118 = r5;
            r115.setText(String.valueOf(r20.b));
            i r26 = r20.e;
            if (r26 != null) goto L19;
        L26:
            String r27 = null;
        L27:
            if (r27 != null) goto L29;
        L32:
            boolean r28 = true;
        L33:
            if (r28 == true) goto L35;
            r24 = r6;
            r0.setVisibility(0);
            r21.setVisibility(8);
            ImageLoaderKt.u(r0, r27, "dora_o_diary_emoji");
        L39:
            if (r113 == false) goto L41;
            int r30 = 2131233932;
        L42:
            r114.setBackgroundResource(r30);
            if (r113 == false) goto L46;
            int r31 = 2131101355;
        L49:
            r115.setTextColor(ContextCompat.getColor(r25, r31));
            if (r20.d == false) goto L52;
            r111.setOnClickListener(null);
            r111.setClickable(false);
            goto L53
        L52:
            r111.setOnClickListener(new c(r4, r20));
            goto L53
        L46:
            if (r20.d == false) goto L48;
            r31 = 2131101369;
            goto L49
        L48:
            r31 = 2131101368;
            goto L49
        L41:
            r30 = 0;
            goto L42
        L35:
            r24 = r6;
            if (r20.d == false) goto L38;
            r0.setVisibility(8);
            r21.setVisibility(0);
            r21.setBackgroundResource(2131233930);
            goto L39
        L38:
            r0.setVisibility(8);
            r21.setVisibility(0);
            r21.setBackgroundResource(2131233931);
            goto L39
        L29:
            if (r27.length() == 0) goto L32;
            r28 = false;
            goto L33
        L19:
            if (r26.e() == true) goto L22;
            r26 = null;
        L22:
            if (r26 == null) goto L26;
            c0 r32 = r26.d();
            if (r32 == null) goto L26;
            r27 = r32.a();
            goto L27
        L10:
            if (Intrinsics.areEqual(r20.a, r3) == false) goto L12;
            r113 = true;
            goto L13
        L54:
            r18.setClipChildren(false);
            r18.setClipToPadding(false);
            r1.a.setClipChildren(false);
            r1.a.setClipToPadding(false);
            r1.a.addView(r18, new LinearLayout.LayoutParams(-1, -2));
            r16 = r16;
            r3 = r3;
            r5 = r5;
            r6 = r6;
            r15 = 7;
            r13 = false;
            goto L4
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            LinearLayout r5 = new LinearLayout(r3.getContext());
            r5.setOrientation(1);
            r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new a(r5);
        }

        public b(List r2, String r3, v69.a r4) {
            Intrinsics.checkNotNullParameter(r2, "months");
            Intrinsics.checkNotNullParameter(r4, "onDayClick");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final int V90() {
        String r0 = this.e;
        if (r0 != null) goto L5;
        return -1;
    L5:
        List r1 = StringsKt.split$default(r0, new String[]{"-"}, false, 0, 6, null);
        if (r1.size() >= 2) goto L8;
        return -1;
    L8:
        Integer r2 = StringsKt.toIntOrNull((String) ListProtector.get(r1, 0));
        if (r2 == null) goto L24;
        int r3 = r2.intValue();
        Integer r4 = StringsKt.toIntOrNull((String) ListProtector.get(r1, 1));
        if (r4 == null) goto L27;
        int r5 = r4.intValue();
        Iterator<com.larus.dora.o.impl.diary.calendar.a.b> r6 = this.d.iterator();
        int r7 = 0;
    L14:
        if (r6.hasNext() == false) goto L29;
        com.larus.dora.o.impl.diary.calendar.a.b r8 = r6.next();
        if (r8.a == r3) goto L18;
    L20:
        boolean r9 = false;
    L21:
        if (r9 == true) goto L28;
        r7 = r7 + 1;
        goto L14
    L28:
        return r7;
    L18:
        if (r8.b != r5) goto L20;
        r9 = true;
        goto L21
    L29:
        return -1;
    L27:
        return -1;
    L24:
        return -1;
    }

    public ODiaryMonthCalendarDialog() {
        this.d = CollectionsKt.emptyList();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public static void S90(ODiaryMonthCalendarDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final int T90(int r3) {
        Resources r0 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    public final String U90(com.larus.dora.o.impl.diary.calendar.a.b r5) {
        Context r0 = getContext();
        if (r0 == null) goto L5;
        String r6 = r0.getString(2131903406, new Object[]{Integer.valueOf(r5.a), Integer.valueOf(r5.b)});
    L6:
        if (r6 != null) goto L9;
        return "";
    L9:
        return r6;
    L5:
        r6 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [v69.a] */
    public final Dialog onCreateDialog(Bundle r20) {
        Context r1 = requireContext();
        OSheet r11 = new OSheet(r1, 0, false, 30);
        final LinearLayoutManager r13 = new LinearLayoutManager(r1);
        this.i = r13;
        RecyclerView r14 = new RecyclerView(r1);
        r14.setLayoutManager(r13);
        b r2 = new b(this.d, this.e, new v69.a(this));
        this.j = r2;
        r14.setAdapter(r2);
        r14.setOverScrollMode(2);
        r14.setClipChildren(false);
        r14.setClipToPadding(false);
        r14.addOnScrollListener(new ODiaryMonthCalendarDialog$onCreateDialog$recyclerView$1$3(r13, this));
        Integer r3 = Integer.valueOf(V90());
        if (r3.intValue() < 0) goto L5;
        boolean r4 = true;
    L6:
        String r5 = null;
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
        int r6 = r3.intValue();
    L13:
        final int r10 = r6;
        OSheetBase.DefaultImpls.q(r11, OSheet.HeightMode.FULL_HEIGHT);
        OSheet.Header r7 = OSheet.Header.ACTION;
        com.larus.dora.o.impl.diary.calendar.a.b r8 = (com.larus.dora.o.impl.diary.calendar.a.b) CollectionsKt.getOrNull(this.d, r10);
        if (r8 == null) goto L16;
        r5 = U90(r8);
    L16:
        if (r5 != null) goto L18;
        String r9 = "";
    L19:
        OSheetBase.DefaultImpls.o(r11, r7, null, r9, null, false, new v69.b(this), null, 16150);
        Context r12 = requireContext();
        LinearLayout r15 = new LinearLayout(r12);
        r15.setOrientation(1);
        int r16 = T90(16);
        r15.setPadding(r16, T90(8), r16, 0);
        LinearLayout r17 = new LinearLayout(r12);
        r17.setOrientation(0);
        Iterator<T> r18 = com.larus.dora.o.impl.diary.calendar.a.a.iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        String r21 = (String) r18.next();
        TextView r110 = new TextView(r12);
        r110.setText(r21);
        r110.setGravity(17);
        r110.setTextSize(2, 10.0f);
        r110.setTypeface(Typeface.create("sans-serif-medium", 0));
        r110.setTextColor(ContextCompat.getColor(r12, 2131101369));
        r17.addView(r110, new LinearLayout.LayoutParams(0, -2, 1.0f));
        goto L21
    L23:
        r15.addView(r17, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(-1, -1);
        r22.topMargin = T90(4);
        Unit r23 = Unit.INSTANCE;
        r15.addView(r14, r22);
        OSheetBase.DefaultImpls.j(r11, r15);
        TextView r24 = (TextView) r11.findViewById(2131372631);
        if (r24 != null) goto L26;
        r24 = (TextView) r11.findViewById(2131365427);
    L26:
        this.h = r24;
        View r25 = OSheetBase.DefaultImpls.d(r11);
        if (r25 == null) goto L29;
        r25.setVisibility(8);
    L29:
        ViewGroup r26 = (ViewGroup) r11.findViewById(2131378832);
        if (r26 == null) goto L34;
        View r27 = LayoutInflater.from(r11.getContext()).inflate(2131560162, r26, false);
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.obric.oui.button.OButtonGroup");
        OButtonGroup r28 = (OButtonGroup) r27;
        TextView r30 = new TextView(r11.getContext());
        r30.setText(getString(2131903863));
        r30.setTextSize(2, 16.0f);
        r30.setTypeface(Typeface.create("sans-serif-medium", 0));
        r30.setTextColor(ContextCompat.getColor(r30.getContext(), 2131101368));
        r30.setGravity(17);
        int r31 = T90(11);
        r30.setPadding(r31, 0, r31, 0);
        r28.D(r30, new ViewGroup.MarginLayoutParams(-2, -1));
        r28.setOnClickListener(new v69.d(this));
        r26.addView(r28);
    L34:
        if ((!this.d.isEmpty()) == false) goto L36;
        r14.post(new v69.c(r13, r10));
    L36:
        return r11;
    L18:
        r9 = r5;
        goto L19
    L12:
        r6 = RangesKt.coerceAtLeast(this.d.size() - 1, 0);
        goto L13
    L5:
        r4 = false;
        goto L6
    }
}
