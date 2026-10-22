package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.TypefaceCompat;
import com.obric.memorydata.memory.databinding.MemoryCalendarDateViewBinding;
import com.obric.memorydata.memory.databinding.MemoryCalendarWeekViewBinding;
import com.obric.memorydata.memory.ui.view.MemoryDateTextView;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00012B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0019\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u001c\u0010\u001d\u001a\u00020\b2\n\u0010\u001e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u0012J\u0014\u0010\"\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150#J\u0016\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0012J\u0015\u0010'\u001a\u0004\u0018\u00010\u00122\u0006\u0010%\u001a\u00020\u0007¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020\u0012J\u0012\u0010.\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u00020\u0007H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Adapter;", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter$DateViewHolder;", "fragment", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment;", "changeCurrentDate", "Lkotlin/Function1;", "Ljava/time/LocalDate;", "", "<init>", "(Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment;Lkotlin/jvm/functions/Function1;)V", "getFragment", "()Lcom/obric/memorydata/memory/ui/list/MemoryCalendarTabFragment;", "getChangeCurrentDate", "()Lkotlin/jvm/functions/Function1;", "currentSelectDate", "todayDate", "currentSelectPosition", "", "dateList", "", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "boldTypeFace", "Landroid/graphics/Typeface;", "normalTypeFace", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemByPosition", "setDateList", "", "setTotalCount", "localDate", "totalCount", "onSelectDateChange", "(Ljava/time/LocalDate;)Ljava/lang/Integer;", "changeTodayDate", "hasDate", "", "isInitialized", "getCurrentSelectPosition", "getPositionByDate", "buildDateViews", "Landroid/widget/LinearLayout;", "getTodayDate", "DateViewHolder", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryCalendarTabFragment f11317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<LocalDate, Unit> f11318b;
    private LocalDate c;
    private LocalDate d;
    private int e;
    private final List<p> f;
    private final Typeface g;
    private final Typeface h;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter$DateViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "weekView", "Landroid/widget/LinearLayout;", "<init>", "(Lcom/obric/memorydata/memory/ui/list/MemoryCalendarAdapter;Landroid/widget/LinearLayout;)V", "getWeekView", "()Landroid/widget/LinearLayout;", "bind", "", "calendarDate", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarWeek;", "position", "", "bindDate", "dateViewBinding", "Lcom/obric/memorydata/memory/databinding/MemoryCalendarDateViewBinding;", "Lcom/obric/memorydata/memory/ui/list/MemoryCalendarDay;", "weekPosition", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class a extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f11319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinearLayout f11320b;

        public a(m r2, LinearLayout r3) {
            Intrinsics.checkNotNullParameter(r3, "weekView");
            this.f11319a = r2;
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
            this.f11320b = r3;
        }

        private final void a(MemoryCalendarDateViewBinding r7, final n r8, int r9) {
            r7.memoryDateText.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r8.a().getDayOfMonth()), CharSequence.class, "com.obric.memorydata.plugin"));
            OUIFrameLayout r0 = r7.memoryDateContainer;
            final m r1 = this.f11319a;
            r0.setOnClickListener(new $$Lambda$m$a$E7cfq0l095Sch19gqYG_tvyjNU8(r1, r8));
            if (r8.b() == false) goto L5;
            r7.memoryNotEmptyPoint.setVisibility(8);
        L13:
            if (Intrinsics.areEqual(r8.a(), m.b(this.f11319a)) == false) goto L19;
            m.a(this.f11319a, r9);
            r7.memoryDateText.setGradientEnable(false);
            if (Intrinsics.areEqual(r8.a(), m.c(this.f11319a)) == false) goto L17;
            r7.memoryDateText.setTypeface(m.d(this.f11319a));
            r7.memoryDateContainer.setBackground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.bg_memory_date_today_selected, "drawable", "bg_memory_date_today_selected")));
            MemoryDateTextView r10 = r7.memoryDateText;
            Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            int r11 = ZeusTransformUtils.mapRes(R.color.white, TypedValues.Custom.S_COLOR, "white");
        L18:
            r10.setTextColor(ContextCompat.getColor(r6, r11));
            return;
        L17:
            r7.memoryDateText.setTypeface(m.e(this.f11319a));
            r7.memoryDateContainer.setBackground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.bg_memory_date_selected, "drawable", "bg_memory_date_selected")));
            r10 = r7.memoryDateText;
            r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            r11 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1");
            goto L18
        L19:
            r7.memoryDateText.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.c.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
            r7.memoryDateContainer.setBackground(null);
            r7.memoryDateText.setTypeface(m.e(this.f11319a));
            if (Intrinsics.areEqual(m.c(this.f11319a), r8.a()) == false) goto L22;
            r7.memoryDateText.setGradientEnable(true);
            return;
        L22:
            r7.memoryDateText.setGradientEnable(false);
            return;
        L5:
            r7.memoryNotEmptyPoint.setVisibility(0);
            if (Intrinsics.areEqual(r8.a(), m.a(this.f11319a)) == true) goto L8;
        L10:
            View r2 = r7.memoryNotEmptyPoint;
            int r4 = R.drawable.bg_memory_date_point;
            String r5 = "bg_memory_date_point";
        L11:
            r2.setBackgroundResource(ZeusTransformUtils.mapRes(r4, "drawable", r5));
            goto L13
        L8:
            if (Intrinsics.areEqual(r8.a(), m.b(this.f11319a)) == false) goto L10;
            r2 = r7.memoryNotEmptyPoint;
            r4 = R.drawable.bg_memory_date_point_today;
            r5 = "bg_memory_date_point_today";
            goto L11
        }

        private static final void a(m r0, n r1, View r2) {
            r0.a().invoke(r1.a());
        }

        public static /* synthetic */ void lambda$E7cfq0l095Sch19gqYG_tvyjNU8(m r0, n r1, View r2) {
            a(r0, r1, r2);
        }

        public final void a(p r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "calendarDate");
            int r0 = this.f11320b.getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            MemoryCalendarDateViewBinding r2 = MemoryCalendarDateViewBinding.bind(this.f11320b.getChildAt(r1));
            Intrinsics.checkNotNullExpressionValue(r2, "bind(...)");
            a(r2, (n) ZeusTransformUtils.preCheckCast(r7.a().get(r1 % r0), n.class, "com.obric.memorydata.plugin"), r8);
            r1 = r1 + 1;
            goto L3
        }
    }

    public m(MemoryCalendarTabFragment r6, Function1<? super LocalDate, Unit> r7) {
        Function1<LocalDate, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r8, "changeCurrentDate");
        this.f11317a = r6;
        this.f11318b = r8;
        this.e = -1;
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Typeface r9 = TypefaceCompat.create((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Typeface.create("Olasans-sc-compact", 0), 500, false);
        Intrinsics.checkNotNullExpressionValue(r9, "create(...)");
        this.g = r9;
        Typeface r10 = TypefaceCompat.create((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Typeface.create("Olasans-sc-compact", 0), 400, false);
        Intrinsics.checkNotNullExpressionValue(r10, "create(...)");
        this.h = r10;
    }

    private final LinearLayout a(ViewGroup r5) {
        LinearLayout r4 = MemoryCalendarWeekViewBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r5, false).memoryCalendarWeekView;
        Intrinsics.checkNotNullExpressionValue(r4, "memoryCalendarWeekView");
        int r6 = 0;
    L4:
        if (r6 >= 7) goto L6;
        MemoryCalendarDateViewBinding r2 = MemoryCalendarDateViewBinding.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin"), false);
        Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
        r4.addView((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L4
    L6:
        return r4;
    }

    public static final /* synthetic */ LocalDate a(m r0) {
        return r0.d;
    }

    public static final /* synthetic */ void a(m r0, int r1) {
        r0.e = r1;
    }

    public static final /* synthetic */ LocalDate b(m r0) {
        return r0.c;
    }

    public static final /* synthetic */ LocalDate c(m r0) {
        return r0.e();
    }

    private final int d(LocalDate r9) {
        if (r9 != null) goto L5;
        return -1;
    L5:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L7:
        if (r8.hasNext() == false) goto L25;
        Object r4 = r8.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(((p) ZeusTransformUtils.preCheckCast(r4, p.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L14;
    L16:
        Iterator r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((n) ZeusTransformUtils.preCheckCast(r7.next(), n.class, "com.obric.memorydata.plugin")).a(), r9) == false) goto L18;
        boolean r10 = true;
    L22:
        if (r10 == true) goto L23;
        r3 = r5;
        goto L7
    L23:
        return r3;
    L15:
        r10 = false;
        goto L22
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L25:
        return -1;
    }

    public static final /* synthetic */ Typeface d(m r0) {
        return r0.g;
    }

    public static final /* synthetic */ Typeface e(m r0) {
        return r0.h;
    }

    private final LocalDate e() {
        LocalDate r0 = this.d;
        if (r0 != null) goto L5;
        r0 = LocalDate.now();
        this.d = r0;
    L5:
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.v a(ViewGroup r1, int r2) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(b(r1, r2), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    public final Integer a(LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "localDate");
        LocalDate r0 = this.c;
        this.c = r3;
        int r1 = d(r0);
        int r4 = d(r3);
        if (r1 == (-1)) goto L5;
        e(r1);
    L5:
        if (r4 == (-1)) goto L8;
        e(r4);
    L8:
        return Integer.valueOf(r4);
    }

    public final Function1<LocalDate, Unit> a() {
        return this.f11318b;
    }

    public void a(a r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        r3.a((p) ZeusTransformUtils.preCheckCast(this.f.get(r4), p.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void a(RecyclerView.v r3, int r4) {
        a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void a(LocalDate r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "localDate");
        int r0 = d(r10);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        p r1 = (p) ZeusTransformUtils.preCheckCast(this.f.get(r0), p.class, "com.obric.memorydata.plugin");
        Iterator<n> r2 = r1.a().iterator();
        n r5 = null;
    L7:
        if (r2.hasNext() == false) goto L11;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r2.next(), n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6.a(), r10) == false) goto L7;
        r5 = r6;
        goto L7
    L11:
        if (r5 != null) goto L13;
        return;
    L13:
        boolean r3 = r5.b();
        boolean r7 = false;
        if (r11 != 0) goto L16;
        boolean r8 = true;
    L17:
        if (r3 == r8) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == true) goto L22;
        return;
    L22:
        if (r11 != 0) goto L24;
        r7 = true;
    L24:
        n r12 = n.a(r5, null, r7, 1, null);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r1.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r9.iterator();
    L26:
        if (r14.hasNext() == false) goto L31;
        n r15 = (n) ZeusTransformUtils.preCheckCast(r14.next(), n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r15.a(), r10) == false) goto L30;
        r15 = r12;
    L30:
        r13.add(r15);
        goto L26
    L31:
        this.f.set(r0, p.a(r1, (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), null, 2, null));
        e(r0);
        return;
    L19:
        r4 = false;
        goto L20
    L16:
        r8 = false;
        goto L17
    }

    public final void a(List<p> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dateList");
        this.f.clear();
        this.f.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
        h();
    }

    public a b(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new a(this, a(r1));
    }

    public final p b(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.f.size()) goto L7;
        return null;
    L7:
        return (p) ZeusTransformUtils.preCheckCast(this.f.get(r2), p.class, "com.obric.memorydata.plugin");
    }

    public final void b(LocalDate r3) {
        Intrinsics.checkNotNullParameter(r3, "localDate");
        if (Intrinsics.areEqual(r3, this.d) == false) goto L5;
        return;
    L5:
        LocalDate r0 = this.d;
        this.d = r3;
        int r1 = d(r0);
        int r4 = d(r3);
        if (r1 == (-1)) goto L8;
        e(r1);
    L8:
        if (r4 == (-1)) goto L11;
        e(r4);
        return;
    }

    public final boolean b() {
        return !((Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    }

    public final int c() {
        return this.e;
    }

    public final boolean c(LocalDate r2) {
        Intrinsics.checkNotNullParameter(r2, "localDate");
        if (d(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int d() {
        return this.f.size();
    }
}
