package com.larus.dora.o.impl.health.calendar;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J$\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\bH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "selectedDate", "", "onDaySelected", "Lkotlin/Function1;", "", "months", "", "Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarModels$MonthData;", "sheetTitleView", "Landroid/widget/TextView;", "monthLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "monthAdapter", "Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarDialog$MonthAdapter;", "noMore", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "initMonths", "indexOfSelectedMonth", "", "loadVisibleMonths", "loadMonthIfNeeded", "month", "updateMonth", "key", "transform", "markState", "state", "Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarModels$LoadState;", "maybeExtendEarlier", "formatSheetTitle", "updateSheetTitle", "buildBody", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dp", "value", "Companion", "MonthAdapter", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OHealthCalendarDialog extends DialogFragment {
    public static final /* synthetic */ int k = 0;
    public String d;
    public Function1<? super String, Unit> e;
    public final List<OHealthCalendarModels.b> f;
    public TextView g;
    public LinearLayoutManager h;
    public b i;
    public boolean j;

    public static final class a {
    }

    public static final class b extends RecyclerView.Adapter<a> {
        public final List<OHealthCalendarModels.b> a;
        public final String b;
        public final Function1<OHealthCalendarModels.a, Unit> c;

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
            OHealthCalendarModels.b r2 = (OHealthCalendarModels.b) ListProtector.get(this.a, r23);
            String r3 = this.b;
            final Function1<OHealthCalendarModels.a, Unit> r4 = this.c;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "month");
            Intrinsics.checkNotNullParameter(r3, "selectedDate");
            Intrinsics.checkNotNullParameter(r4, "onDayClick");
            r1.a.removeAllViews();
            Context r5 = r1.a.getContext();
            LinearLayout r6 = r1.a;
            TextView r7 = new TextView(r5);
            StringCompanionObject r8 = StringCompanionObject.INSTANCE;
            boolean r12 = false;
            r7.setText(String.format(Locale.getDefault(), "%d月", Arrays.copyOf(new Object[]{Integer.valueOf(r2.b)}, 1)));
            r7.setTypeface(Typeface.create("sans-serif-medium", 0));
            r7.setTextSize(2, 20.0f);
            r7.setTextColor(ContextCompat.getColor(r5, 2131101368));
            Intrinsics.checkNotNull(r5);
            Resources r11 = r5.getResources();
            int r13 = (int) ((WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density * 18) + 0.5f);
            Resources r14 = r5.getResources();
            r7.setPadding(0, r13, 0, (int) ((WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density * 10) + 0.5f));
            r6.addView(r7);
            LayoutInflater r9 = LayoutInflater.from(r5);
            int r10 = 7;
            Iterator r15 = CollectionsKt.chunked(r2.c, 7).iterator();
        L4:
            if (r15.hasNext() == false) goto L78;
            List r16 = (List) r15.next();
            LinearLayout r17 = new LinearLayout(r5);
            r17.setOrientation(r12 ? 1 : 0);
            r17.setClipChildren(r12);
            r17.setClipToPadding(r12);
            int r18 = 0;
        L6:
            if (r18 >= r10) goto L77;
            View r20 = r9.inflate(2131562231, r17, r12);
            final OHealthCalendarModels.a r21 = (OHealthCalendarModels.a) CollectionsKt.getOrNull(r16, r18);
            Intrinsics.checkNotNull(r20);
            if (r21 != null) goto L10;
        L12:
            boolean r110 = false;
        L13:
            View r111 = r20.findViewById(2131369768);
            TextView r24 = (TextView) r20.findViewById(2131369771);
            View r112 = r20.findViewById(2131369769);
            TextView r0 = (TextView) r20.findViewById(2131369770);
            Iterator r113 = r15;
            String r25 = r3;
            if (r21 != null) goto L16;
            r111.setVisibility(4);
            r20.setOnClickListener(null);
            r20.setClickable(false);
        L76:
            r17.addView(r20);
            r18 = r18 + 1;
            r5 = r5;
            r15 = r113;
            r3 = r25;
            r10 = 7;
            r12 = false;
            goto L6
        L16:
            r111.setVisibility(0);
            Context r26 = r20.getContext();
            if (r21.c == true) goto L19;
        L21:
            boolean r114 = false;
        L22:
            if (r114 == false) goto L24;
            String r27 = r26.getString(2131896109);
        L25:
            r24.setText(r27);
            if (r114 == false) goto L28;
            float r28 = 15.0f;
        L29:
            r24.setTextSize(2, r28);
            if (r110 == false) goto L33;
            r24.setBackgroundResource(2131240539);
            r24.setTextColor(-1);
        L37:
            if (r114 == false) goto L39;
            r112.setVisibility(8);
            r0.setVisibility(0);
        L71:
            boolean r30 = r21.d;
            r20.setClickable(r30);
            if (r30 == false) goto L74;
            View.OnClickListener r31 = new i(r4, r21);
        L75:
            r20.setOnClickListener(r31);
            goto L76
        L74:
            r31 = null;
            goto L75
        L39:
            r0.setVisibility(8);
            if (r21.d == false) goto L42;
            int r32 = 0;
        L43:
            r112.setVisibility(r32);
            if (r21.d == false) goto L71;
            GradientDrawable r33 = new GradientDrawable();
            r33.setShape(1);
            List<Pair<Integer, Integer>> r34 = OHealthCalendarModels.a;
            Integer r35 = r21.e;
            if (r35 != null) goto L48;
        L66:
            Integer r36 = null;
        L67:
            if (r36 == null) goto L69;
            int r37 = r36.intValue();
        L70:
            r33.setColor(r37);
            r112.setBackground(r33);
            goto L71
        L69:
            r37 = OHealthCalendarModels.b;
            goto L70
        L48:
            if (r35.intValue() <= 0) goto L66;
            Iterator<T> r115 = OHealthCalendarModels.a.iterator();
        L52:
            if (r115.hasNext() == false) goto L60;
            Object r116 = r115.next();
            if (r35.intValue() < ((Number) ((Pair) r116).getFirst()).intValue()) goto L56;
            boolean r38 = true;
        L57:
            if (r38 == false) goto L52;
        L61:
            Pair r117 = (Pair) r116;
            if (r117 == null) goto L64;
            Object r40 = r117.getSecond();
        L65:
            r36 = Integer.valueOf(((Number) r40).intValue());
            goto L67
        L64:
            r40 = ((Pair) CollectionsKt.last(OHealthCalendarModels.a)).getSecond();
            goto L65
        L56:
            r38 = false;
            goto L57
        L60:
            r116 = null;
            goto L61
        L42:
            r32 = 4;
            goto L43
        L33:
            if (r21.d == false) goto L35;
            r24.setBackground(null);
            r24.setTextColor(ContextCompat.getColor(r26, 2131101368));
            goto L37
        L35:
            r24.setBackground(null);
            r24.setTextColor(ContextCompat.getColor(r26, 2131101359));
            goto L37
        L28:
            r28 = 16.0f;
            goto L29
        L24:
            r27 = String.valueOf(r21.b);
            goto L25
        L19:
            if (r21.d == true) goto L21;
            r114 = true;
            goto L22
        L10:
            if (Intrinsics.areEqual(r21.a, r3) == false) goto L12;
            r110 = true;
            goto L13
        L77:
            r1.a.addView(r17, new LinearLayout.LayoutParams(-1, -2));
            r5 = r5;
            r15 = r15;
            r3 = r3;
            r10 = 7;
            r12 = false;
            goto L4
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            LinearLayout r5 = new LinearLayout(r3.getContext());
            r5.setOrientation(1);
            r5.setClipChildren(false);
            r5.setClipToPadding(false);
            r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new a(r5);
        }

        public b(List r2, String r3, f r4) {
            Intrinsics.checkNotNullParameter(r2, "months");
            Intrinsics.checkNotNullParameter(r3, "selectedDate");
            Intrinsics.checkNotNullParameter(r4, "onDayClick");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public final void Y90() {
        LinearLayoutManager r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.findFirstVisibleItemPosition();
        int r2 = r0.findLastVisibleItemPosition();
        if (r1 == (-1)) goto L15;
        if (r2 == (-1)) goto L18;
        if (r1 > r2) goto L17;
    L10:
        OHealthCalendarModels.b r3 = (OHealthCalendarModels.b) CollectionsKt.getOrNull(this.f, r1);
        if (r3 == null) goto L13;
        X90(r3);
    L13:
        if (r1 == r2) goto L19;
        r1 = r1 + 1;
        goto L10
    L19:
        return;
    L17:
        return;
    L18:
        return;
    }

    public OHealthCalendarDialog() {
        this.d = "";
        this.f = new ArrayList();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g = null;
        this.h = null;
        this.i = null;
    }

    public static void S90(OHealthCalendarDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final void T90(OHealthCalendarDialog r12) {
        if (r12.j == false) goto L5;
        return;
    L5:
        if (((ArrayList) r12.f).size() >= 36) goto L99;
        List r0 = CollectionsKt.take(r12.f, 2);
        List r2 = r0;
        boolean r3 = r2 instanceof Collection;
        if (r3 == true) goto L10;
    L12:
        Iterator r6 = r2.iterator();
    L14:
        if (r6.hasNext() == false) goto L21;
        if (((OHealthCalendarModels.b) r6.next()).d == OHealthCalendarModels.LoadState.LOADED) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L14;
        boolean r8 = true;
    L22:
        if (r8 == false) goto L27;
        Iterator r1 = r2.iterator();
    L25:
        if (r1.hasNext() == false) goto L101;
        r12.X90((OHealthCalendarModels.b) r1.next());
        goto L25
    L101:
        return;
    L27:
        if (r3 == true) goto L29;
    L31:
        Iterator r4 = r2.iterator();
    L33:
        if (r4.hasNext() == false) goto L58;
        OHealthCalendarModels.b r5 = (OHealthCalendarModels.b) r4.next();
        if (r5.d != OHealthCalendarModels.LoadState.LOADED) goto L55;
        List<OHealthCalendarModels.a> r9 = r5.c;
        if ((r9 instanceof Collection) == true) goto L39;
    L41:
        Iterator<T> r10 = r9.iterator();
    L43:
        if (r10.hasNext() == false) goto L52;
        OHealthCalendarModels.a r11 = (OHealthCalendarModels.a) r10.next();
        if (r11 != null) goto L47;
    L49:
        boolean r13 = false;
    L50:
        if (r13 == false) goto L43;
        boolean r14 = false;
    L53:
        if (r14 == false) goto L55;
        boolean r15 = true;
    L56:
        if (r15 == true) goto L33;
        boolean r16 = false;
    L59:
        if (r16 == false) goto L61;
        r12.j = true;
        FLogger.a.i("OHealthCalendarDialog", "no data before " + ((OHealthCalendarModels.b) CollectionsKt.first(r0)).b() + ", stop extending");
        return;
    L61:
        LinearLayoutManager r17 = r12.h;
        if (r17 == null) goto L100;
        int r18 = RangesKt.coerceAtLeast(r17.findFirstVisibleItemPosition(), 0);
        View r20 = r17.findViewByPosition(r18);
        if (r20 == null) goto L67;
        int r21 = r20.getTop();
    L68:
        OHealthCalendarModels.b r22 = (OHealthCalendarModels.b) CollectionsKt.first(r12.f);
        int r23 = Math.min(3, 36 - ((ArrayList) r12.f).size());
        String r24 = OHealthCalendarModels.d();
        IntRange r25 = new IntRange(1, r23);
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        IntIterator r27 = r25.iterator();
    L70:
        if (r27.hasNext() == false) goto L72;
        int r28 = r27.nextInt();
        List<Pair<Integer, Integer>> r30 = OHealthCalendarModels.a;
        Pair r31 = OHealthCalendarModels.c(r22.a, r22.b, -r28);
        r26.add(OHealthCalendarModels.a(((Number) r31.component1()).intValue(), ((Number) r31.component2()).intValue(), null, OHealthCalendarModels.LoadState.NOT_LOADED, r24));
        goto L70
    L72:
        List r32 = CollectionsKt.reversed(r26);
        ((ArrayList) r12.f).addAll(0, r32);
        b r33 = r12.i;
        if (r33 == null) goto L75;
        r33.notifyItemRangeInserted(0, r32.size());
    L75:
        r17.scrollToPositionWithOffset(r18 + r32.size(), r21);
        Iterator r34 = r32.iterator();
    L77:
        if (r34.hasNext() == false) goto L102;
        r12.X90((OHealthCalendarModels.b) r34.next());
        goto L77
    L102:
        return;
    L67:
        r21 = 0;
        goto L68
    L100:
        return;
    L47:
        if (r11.d != true) goto L49;
        r13 = true;
    L52:
        r14 = true;
        goto L53
    L39:
        if (r9.isEmpty() == false) goto L41;
    L55:
        r15 = false;
    L58:
        r16 = true;
        goto L59
    L29:
        if (r2.isEmpty() == false) goto L31;
    L18:
        r7 = false;
    L21:
        r8 = false;
        goto L22
    L10:
        if (r2.isEmpty() == false) goto L12;
    }

    public final int V90(int r3) {
        Resources r0 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3) + 0.5f);
    }

    public final String W90(OHealthCalendarModels.b r5) {
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

    public final void X90(OHealthCalendarModels.b r7) {
        OHealthCalendarModels.LoadState r0 = r7.d;
        OHealthCalendarModels.LoadState r1 = OHealthCalendarModels.LoadState.LOADING;
        if (r0 != r1) goto L5;
        return;
    L5:
        if (r0 == OHealthCalendarModels.LoadState.LOADED) goto L23;
        String r2 = r7.b();
        Iterator r3 = ((ArrayList) this.f).iterator();
        int r4 = 0;
    L9:
        if (r3.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(((OHealthCalendarModels.b) r3.next()).b(), r2) == true) goto L15;
        r4 = r4 + 1;
    L15:
        if (r4 < 0) goto L18;
        List<OHealthCalendarModels.b> r5 = this.f;
        ListProtector.set(r5, r4, OHealthCalendarModels.b.a((OHealthCalendarModels.b) ListProtector.get(r5, r4), r1));
    L18:
        String r8 = r7.b();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new OHealthCalendarDialog$loadMonthIfNeeded$1(r8, this, null), 2, null);
        return;
    L14:
        r4 = -1;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [com.larus.dora.o.impl.health.calendar.f] */
    public final Dialog onCreateDialog(Bundle r20) {
        Context r1 = requireContext();
        if (this.e != null) goto L6;
        S90(this);
        return super.onCreateDialog(r20);
    L6:
        String r2 = OHealthCalendarModels.d();
        Pair r3 = OHealthCalendarModels.b(r2);
        String r4 = null;
        if (r3 == null) goto L17;
        int r7 = ((Number) r3.component1()).intValue();
        int r5 = ((Number) r3.component2()).intValue();
        Pair r8 = OHealthCalendarModels.b(this.d);
        int r9 = 12;
        if (r8 == null) goto L14;
        int r10 = ((r7 - ((Number) r8.component1()).intValue()) * 12) + (r5 - ((Number) r8.component2()).intValue());
        if (r10 <= 0) goto L14;
        r9 = Math.max(12, r10 + 1);
    L14:
        int r11 = Math.min(r9, 36);
        ((ArrayList) this.f).clear();
        int r12 = r11 - 1;
    L15:
        if ((-1) >= r12) goto L17;
        Pair r13 = OHealthCalendarModels.c(r7, r5, -r12);
        int r14 = ((Number) r13.component1()).intValue();
        int r15 = ((Number) r13.component2()).intValue();
        ((ArrayList) this.f).add(OHealthCalendarModels.a(r14, r15, null, OHealthCalendarModels.LoadState.NOT_LOADED, r2));
        r12 = r12 - 1;
    L17:
        OSheet r6 = new OSheet(r1, 0, false, 30);
        final LinearLayoutManager r16 = new LinearLayoutManager(r1);
        this.h = r16;
        RecyclerView r17 = new RecyclerView(r1);
        r17.setLayoutManager(r16);
        b r18 = new b(this.f, this.d, new f(this));
        this.i = r18;
        r17.setAdapter(r18);
        r17.setOverScrollMode(2);
        r17.setClipChildren(false);
        r17.setClipToPadding(false);
        r17.addOnScrollListener(new OHealthCalendarDialog$onCreateDialog$recyclerView$1$3(r16, this));
        List<Pair<Integer, Integer>> r21 = OHealthCalendarModels.a;
        Pair r22 = OHealthCalendarModels.b(this.d);
        if (r22 == null) goto L32;
        int r110 = ((Number) r22.component1()).intValue();
        int r23 = ((Number) r22.component2()).intValue();
        Iterator r111 = ((ArrayList) this.f).iterator();
        int r112 = 0;
    L22:
        if (r111.hasNext() == false) goto L32;
        OHealthCalendarModels.b r113 = (OHealthCalendarModels.b) r111.next();
        if (r113.a == r110) goto L26;
    L28:
        boolean r114 = false;
    L29:
        if (r114 == true) goto L33;
        r112 = r112 + 1;
    L33:
        Integer r24 = Integer.valueOf(r112);
        if (r24.intValue() < 0) goto L36;
        boolean r115 = true;
    L37:
        if (r115 == true) goto L40;
        r24 = null;
    L40:
        if (r24 == null) goto L42;
        int r25 = r24.intValue();
    L43:
        int r116 = r25;
        OSheetBase.DefaultImpls.q(r6, OSheet.HeightMode.FULL_HEIGHT);
        OSheet.Header r117 = OSheet.Header.ACTION;
        OHealthCalendarModels.b r26 = (OHealthCalendarModels.b) CollectionsKt.getOrNull(this.f, r116);
        if (r26 == null) goto L46;
        r4 = W90(r26);
    L46:
        if (r4 != null) goto L48;
        r4 = "";
    L48:
        OSheetBase.DefaultImpls.o(r6, r117, null, r4, null, false, new g(this), null, 16150);
        Context r27 = requireContext();
        LinearLayout r28 = new LinearLayout(r27);
        r28.setOrientation(1);
        LinearLayout r118 = new LinearLayout(r27);
        r118.setOrientation(0);
        r118.setPadding(V90(24), 0, V90(24), 0);
        Iterator<T> r119 = com.larus.dora.o.impl.diary.calendar.a.a.iterator();
    L50:
        if (r119.hasNext() == false) goto L52;
        String r120 = (String) r119.next();
        TextView r121 = new TextView(r27);
        r121.setText(r120);
        r121.setGravity(17);
        r121.setTextSize(2, 13.0f);
        r121.setTextColor(ContextCompat.getColor(r27, 2131101368));
        r118.addView(r121, new LinearLayout.LayoutParams(0, -1, 1.0f));
        goto L50
    L52:
        r28.addView(r118, new LinearLayout.LayoutParams(-1, V90(42)));
        View r30 = new View(r27);
        r30.setBackgroundColor(ContextCompat.getColor(r27, 2131101358));
        r28.addView(r30, new LinearLayout.LayoutParams(-1, 1));
        r17.setPadding(V90(24), 0, V90(24), V90(24));
        r28.addView(r17, new LinearLayout.LayoutParams(-1, -1));
        OSheetBase.DefaultImpls.j(r6, r28);
        TextView r31 = (TextView) r6.findViewById(2131372631);
        if (r31 != null) goto L55;
        r31 = (TextView) r6.findViewById(2131365427);
    L55:
        this.g = r31;
        View r32 = OSheetBase.DefaultImpls.d(r6);
        if (r32 == null) goto L58;
        r32.setVisibility(8);
    L58:
        r16.scrollToPosition(r116);
        r17.post(new h(this));
        return r6;
    L42:
        r25 = RangesKt.coerceAtLeast(((ArrayList) this.f).size() - 1, 0);
        goto L43
    L36:
        r115 = false;
        goto L37
    L26:
        if (r113.b != r23) goto L28;
        r114 = true;
    L32:
        r112 = -1;
        goto L33
    }

    public static final void U90(OHealthCalendarDialog r3, String r4, Function1 r5) {
        Iterator r0 = ((ArrayList) r3.f).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((OHealthCalendarModels.b) r0.next()).b(), r4) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L19;
        List<OHealthCalendarModels.b> r6 = r3.f;
        ListProtector.set(r6, r1, r5.invoke(ListProtector.get(r6, r1)));
        b r7 = r3.i;
        if (r7 == null) goto L18;
        r7.notifyItemChanged(r1);
        return;
    L18:
        return;
    L19:
        return;
    L9:
        r1 = -1;
        goto L10
    }
}
