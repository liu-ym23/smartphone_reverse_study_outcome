package com.obric.memorydata.memory.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.selection.SelectionPanelView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 32\u00020\u0001:\u00013B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u001dJ\r\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J8\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u001f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u001fH\u0002R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/CalendarDialog;", "", "positiveBtnClickListener", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getPositiveBtnClickListener", "()Lkotlin/jvm/functions/Function0;", "dialog", "Lcom/obric/oui/sheet/v2/OSheet;", "getDialog", "()Lcom/obric/oui/sheet/v2/OSheet;", "setDialog", "(Lcom/obric/oui/sheet/v2/OSheet;)V", "panelView", "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "Lcom/obric/memorydata/memory/ui/detail/CalendarSelectionPanelItemView;", "getPanelView", "()Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView;", "setPanelView", "(Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView;)V", "positiveBtn", "Lcom/obric/oui/button/OButton;", "showSelection", "context", "Landroid/content/Context;", "items", "", "createFooterView", "Landroid/view/View;", "createFooterButton", "styleRes", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "updateItems", "getSelectedData", "selectAll", "()Lkotlin/Unit;", "closePanel", "updateBodyHeightIfNeeded", "logBodyState", "from", "bodyView", "selectionPanel", "sheet", "findRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "view", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10848a = null;
    private static final b f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Unit> f10849b;
    private OSheet c;
    private SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> d;
    private OButton e;

    @Metadata(d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003*\u0001\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/CalendarDialog$Companion;", "", "<init>", "()V", "TAG", "", "diffCallback", "com/obric/memorydata/memory/ui/detail/CalendarDialog$Companion$diffCallback$1", "Lcom/obric/memorydata/memory/ui/detail/CalendarDialog$Companion$diffCallback$1;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/detail/CalendarDialog$Companion$diffCallback$1", "Lcom/obric/memorydata/memory/ui/selection/SelectionDiffCallback;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.memorydata.memory.ui.selection.f<com.obric.memorydata.memory.ui.data.a.c> {
        b() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(com.obric.memorydata.memory.ui.data.a.c r3, com.obric.memorydata.memory.ui.data.a.c r4) {
            Intrinsics.checkNotNullParameter(r3, "oldItem");
            Intrinsics.checkNotNullParameter(r4, "newItem");
            if (r3.b().getId() != r4.b().getId()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.memorydata.memory.ui.selection.f
        public /* synthetic */ boolean a(com.obric.memorydata.memory.ui.data.a.c r3, com.obric.memorydata.memory.ui.data.a.c r4) {
            return a2((com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
        public boolean b2(com.obric.memorydata.memory.ui.data.a.c r1, com.obric.memorydata.memory.ui.data.a.c r2) {
            Intrinsics.checkNotNullParameter(r1, "oldItem");
            Intrinsics.checkNotNullParameter(r2, "newItem");
            return Intrinsics.areEqual(r1.b(), r2.b());
        }

        @Override // com.obric.memorydata.memory.ui.selection.f
        public /* synthetic */ boolean b(com.obric.memorydata.memory.ui.data.a.c r3, com.obric.memorydata.memory.ui.data.a.c r4) {
            return b2((com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.memory.ui.data.a.c) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.data.a.c.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/detail/CalendarDialog$showSelection$2$2", "Lcom/obric/memorydata/memory/ui/selection/SelectionPanelView$SelectionChangedListener;", "Lcom/obric/memorydata/memory/ui/detail/CalendarSelectionPanelItemView;", "onSelectionChanged", "", "selectedItems", "", "Lkotlin/Pair;", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0554c implements SelectionPanelView.b<CalendarSelectionPanelItemView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10850a;

        C0554c(c r1) {
            this.f10850a = r1;
        }

        @Override // com.obric.memorydata.memory.ui.selection.SelectionPanelView.b
        public void a(List<? extends Pair<Integer, ? extends CalendarSelectionPanelItemView>> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "selectedItems");
            OButton r2 = c.a(this.f10850a);
            if (r2 == null) goto L6;
            r2.setEnabled(!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty());
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/ui/detail/CalendarDialog$showSelection$4", "Lcom/obric/oui/dialog/DialogExtInterface$OnShowAnimListener;", "onShowAnimStart", "", "dialog", "Landroid/app/Dialog;", "onShowAnimEnd", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.oui.dialog.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f10852b;
        final /* synthetic */ SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        d(c r1, View r2, SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r3, int r4, int r5, int r6, int r7) {
            this.f10851a = r1;
            this.f10852b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        @Override // com.obric.oui.dialog.a.c
        public void a(Dialog r6) {
            Intrinsics.checkNotNullParameter(r6, "dialog");
            if (ZeusTransformUtils.instanceOf(r6, OSheet.class) == false) goto L5;
            OSheet r7 = (OSheet) ZeusTransformUtils.preCheckCast(r6, OSheet.class, "com.obric.memorydata.plugin");
        L6:
            if (r7 != null) goto L8;
            return;
        L8:
            c r0 = this.f10851a;
            View r1 = this.f10852b;
            Intrinsics.checkNotNull(r1);
            SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r2 = this.c;
            Intrinsics.checkNotNull(r2);
            c.a(r0, "onShowAnimStart:beforeMaxHeight", r1, r2, r7);
            c.a(this.f10852b, this.d, this.e, this.f, this.g);
            if (r7.t() == false) goto L15;
            int r3 = r7.s();
            if (r3 <= 0) goto L15;
            SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r4 = this.f10851a.a();
            if (r4 == null) goto L15;
            r4.setMaxHeight(r3);
        L15:
            c r5 = this.f10851a;
            View r8 = this.f10852b;
            Intrinsics.checkNotNull(r8);
            SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r9 = this.c;
            Intrinsics.checkNotNull(r9);
            c.a(r5, "onShowAnimStart:afterMaxHeight", r8, r9, r7);
            return;
        L5:
            r7 = null;
            goto L6
        }

        @Override // com.obric.oui.dialog.a.c
        public void b(Dialog r6) {
            Intrinsics.checkNotNullParameter(r6, "dialog");
            c.a(this.f10852b, this.d, this.e, this.f, this.g);
            c r0 = this.f10851a;
            View r1 = this.f10852b;
            Intrinsics.checkNotNull(r1);
            SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r5 = this.c;
            Intrinsics.checkNotNull(r5);
            if (ZeusTransformUtils.instanceOf(r6, OSheet.class) == false) goto L5;
            OSheet r7 = (OSheet) ZeusTransformUtils.preCheckCast(r6, OSheet.class, "com.obric.memorydata.plugin");
        L6:
            c.a(r0, "onShowAnimEnd", r1, r5, r7);
            return;
        L5:
            r7 = null;
            goto L6
        }
    }

    static {
        f10848a = new a(null);
        f = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public c(Function0<Unit> r3) {
        this.f10849b = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ c(Function0 r2, int r3, DefaultConstructorMarker r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    private final View a(Context r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        LinearLayout r0 = new LinearLayout(r15);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.setOrientation(0);
        int r3 = ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_large_1, "dimen", "oui_p_container_large_1"));
        float r4 = 8;
        r0.setPadding(r3, MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())), r3, MathKt.roundToInt(TypedValue.applyDimension(1, r4, Resources.getSystem().getDisplayMetrics())));
        int r5 = ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Neutral, "style", "OStyleV2_OButton_L_Standard_Neutral");
        String r6 = r15.getString(ZeusTransformUtils.mapRes(R.string.memory_calendar_dialog_cancel_button, TypedValues.Custom.S_STRING, "memory_calendar_dialog_cancel_button"));
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        OButton r7 = a(r15, r5, r6);
        r7.setId(ZeusTransformUtils.mapRes(R.id.btn_negative, OaidModel.KEY_ID, "btn_negative"));
        r7.setOnClickListener(new $$Lambda$c$G38aShUcWMt_MOEyFMa2PfwPdBQ(this));
        r0.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        r0.addView(new View(r15), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()))), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        int r8 = ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary_Light, "style", "OStyleV2_OButton_L_Standard_Primary_Light");
        String r9 = r15.getString(ZeusTransformUtils.mapRes(R.string.memory_calendar_dialog_create_button, TypedValues.Custom.S_STRING, "memory_calendar_dialog_create_button"));
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        OButton r16 = a(r15, r8, r9);
        r16.setId(ZeusTransformUtils.mapRes(R.id.btn_positive, OaidModel.KEY_ID, "btn_positive"));
        r16.setEnabled(false);
        r16.setOnClickListener(new $$Lambda$c$6BqASTfbn2wtufrIqHggIJulb7k(this));
        this.e = r16;
        r0.addView((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    private final RecyclerView a(View r6) {
        if (ZeusTransformUtils.instanceOf(r6, RecyclerView.class) == false) goto L7;
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r6, RecyclerView.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L14;
        int r0 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L9:
        if (r0 >= r2) goto L18;
        View r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        RecyclerView r4 = a(r3);
        if (r4 != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r4;
    L18:
        return null;
    L14:
        return null;
    }

    private static final CalendarSelectionPanelItemView a(Context r6, com.obric.memorydata.memory.ui.data.a.c r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r7, "item");
        return new CalendarSelectionPanelItemView(r1, null, 0, 6, null);
    }

    private final OButton a(Context r5, int r6, String r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6 != ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary_Light, "style", "OStyleV2_OButton_L_Standard_Primary_Light")) goto L5;
        int r8 = R.layout.item_calendar_footer_primary_light_button;
        String r9 = "item_calendar_footer_primary_light_button";
    L6:
        int r10 = ZeusTransformUtils.mapRes(r8, "layout", r9);
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r4), r10, null, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r12 = (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.memorydata.plugin");
        r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        r12.setMaxLines(1);
        r12.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_h_l1, "dimen", "oui_h_l1")), 1.0f), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return r12;
    L5:
        r8 = R.layout.item_calendar_footer_neutral_button;
        r9 = "item_calendar_footer_neutral_button";
        goto L6
    }

    public static final /* synthetic */ OButton a(c r0) {
        return r0.e;
    }

    public static final /* synthetic */ void a(View r0, int r1, int r2, int r3, int r4) {
        b(r0, r1, r2, r3, r4);
    }

    private static final void a(c r0, View r1) {
        r0.d();
    }

    private static final void a(c r7, View r8, SelectionPanelView r9, int r10, int r11, int r12, int r13) {
        b(r8, r10, r11, r12, r13);
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        a(r7, "afterSetBodyViewPost", r8, r9, null, 8, null);
    }

    public static final /* synthetic */ void a(c r0, String r1, View r2, SelectionPanelView r3, OSheet r4) {
        r0.a(r1, r2, r3, r4);
    }

    static /* synthetic */ void a(c r0, String r1, View r2, SelectionPanelView r3, OSheet r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = r0.c;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    private final void a(String r5, View r6, SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r7, OSheet r8) {
        RecyclerView r4 = a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"));
        StringBuilder r0 = new StringBuilder();
        StringBuilder r9 = r0.append("from=").append(r5).append(", sheetShowing=");
        Boolean r1 = null;
        if (r8 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r8.isShowing());
    L6:
        StringBuilder r10 = r9.append(r2).append(", sheetIsMax=");
        if (r8 == null) goto L9;
        Boolean r3 = Boolean.valueOf(r8.t());
    L10:
        StringBuilder r11 = r10.append(r3).append(", maxBodyHeight=");
        if (r8 == null) goto L13;
        Integer r12 = Integer.valueOf(r8.s());
    L14:
        StringBuilder r13 = r11.append(r12).append(", bodyContainerPadding=");
        if (r8 == null) goto L19;
        FrameLayout r14 = r8.getBodyContainer();
        if (r14 == null) goto L19;
        Integer r15 = Integer.valueOf(r14.getPaddingLeft());
    L20:
        StringBuilder r16 = r13.append(r15).append(',');
        if (r8 == null) goto L25;
        FrameLayout r17 = r8.getBodyContainer();
        if (r17 == null) goto L25;
        Integer r18 = Integer.valueOf(r17.getPaddingTop());
    L26:
        StringBuilder r19 = r16.append(r18).append(',');
        if (r8 == null) goto L31;
        FrameLayout r20 = r8.getBodyContainer();
        if (r20 == null) goto L31;
        Integer r21 = Integer.valueOf(r20.getPaddingRight());
    L32:
        StringBuilder r22 = r19.append(r21).append(',');
        if (r8 == null) goto L37;
        FrameLayout r23 = r8.getBodyContainer();
        if (r23 == null) goto L37;
        Integer r24 = Integer.valueOf(r23.getPaddingBottom());
    L38:
        r22.append(r24).append(", bodySize=").append(r6.getWidth()).append('x').append(r6.getHeight()).append(", bodyPadding=").append(r6.getPaddingLeft()).append(',');
        StringBuilder r25 = r0.append(r6.getPaddingTop()).append(',').append(r6.getPaddingRight()).append(',').append(r6.getPaddingBottom()).append(", bodyLp=");
        ViewGroup.LayoutParams r26 = r6.getLayoutParams();
        if (r26 == null) goto L41;
        Integer r27 = Integer.valueOf(r26.width);
    L42:
        StringBuilder r28 = r25.append(r27).append('x');
        ViewGroup.LayoutParams r29 = r6.getLayoutParams();
        if (r29 == null) goto L45;
        Integer r30 = Integer.valueOf(r29.height);
    L46:
        r28.append(r30).append(", panelSize=").append(r7.getWidth()).append('x').append(r7.getHeight()).append(", panelPadding=").append(r7.getPaddingLeft()).append(',').append(r7.getPaddingTop()).append(',').append(r7.getPaddingRight()).append(',').append(r7.getPaddingBottom()).append(", panelMaxHeight=").append(r7.getMaxHeight());
        StringBuilder r31 = r0.append(", rvSize=");
        if (r4 == null) goto L49;
        Integer r32 = Integer.valueOf(r4.getWidth());
    L50:
        StringBuilder r33 = r31.append(r32).append('x');
        if (r4 == null) goto L53;
        Integer r34 = Integer.valueOf(r4.getHeight());
    L54:
        StringBuilder r35 = r33.append(r34).append(", rvPadding=");
        if (r4 == null) goto L57;
        Integer r36 = Integer.valueOf(r4.getPaddingLeft());
    L58:
        StringBuilder r37 = r35.append(r36).append(',');
        if (r4 == null) goto L61;
        Integer r38 = Integer.valueOf(r4.getPaddingTop());
    L62:
        StringBuilder r39 = r37.append(r38).append(',');
        if (r4 == null) goto L65;
        Integer r40 = Integer.valueOf(r4.getPaddingRight());
    L66:
        StringBuilder r41 = r39.append(r40).append(',');
        if (r4 == null) goto L69;
        Integer r42 = Integer.valueOf(r4.getPaddingBottom());
    L70:
        StringBuilder r43 = r41.append(r42).append(", rvCanScrollDown=");
        if (r4 == null) goto L73;
        Boolean r44 = Boolean.valueOf(r4.canScrollVertically(1));
    L74:
        StringBuilder r45 = r43.append(r44).append(", rvCanScrollUp=");
        if (r4 == null) goto L77;
        r1 = Boolean.valueOf(r4.canScrollVertically(-1));
    L77:
        r45.append(r1);
        Log.d("CalendarDialog", r0.toString());
        return;
    L73:
        r44 = null;
        goto L74
    L69:
        r42 = null;
        goto L70
    L65:
        r40 = null;
        goto L66
    L61:
        r38 = null;
        goto L62
    L57:
        r36 = null;
        goto L58
    L53:
        r34 = null;
        goto L54
    L49:
        r32 = null;
        goto L50
    L45:
        r30 = null;
        goto L46
    L41:
        r27 = null;
    L37:
        r24 = null;
    L31:
        r21 = null;
    L25:
        r18 = null;
    L19:
        r15 = null;
        goto L20
    L13:
        r12 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    private static final void b(View r0, int r1, int r2, int r3, int r4) {
        r0.setPadding(r1, r2, r3, r4);
    }

    private static final void b(c r0) {
        r0.e();
    }

    private static final void b(c r0, View r1) {
        r0.d();
        Function0<Unit> r2 = r0.f10849b;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    private final void d() {
        OSheet r2 = this.c;     // Catch: Exception -> L6
        if (r2 == null) goto L11;
        r2.dismiss();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Log.e("OUI", "showSelection: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void e() {
        OSheet r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.t() == false) goto L12;
        int r1 = r0.s();
        if (r1 <= 0) goto L17;
        SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r2 = this.d;
        if (r2 == null) goto L18;
    L15:
        r2.setMaxHeight(r1);
        return;
    L18:
        return;
    L17:
        return;
    L12:
        r2 = this.d;
        if (r2 == null) goto L19;
        r1 = -1;
        goto L15
    }

    public static /* synthetic */ void lambda$3iuq7Stsi_IChzRQPTR8lnjswFY(c r0) {
        b(r0);
    }

    public static /* synthetic */ CalendarSelectionPanelItemView lambda$4jh4tyVQvoaNjrBQf4jPctyYCbI(Context r0, com.obric.memorydata.memory.ui.data.a.c r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$6BqASTfbn2wtufrIqHggIJulb7k(c r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$G38aShUcWMt_MOEyFMa2PfwPdBQ(c r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$svv5xXEWV3wWkmoOHS7DNAs5WsI(c r0, View r1, SelectionPanelView r2, int r3, int r4, int r5, int r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    public final SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> a() {
        return this.d;
    }

    public final void a(Context r28, List<com.obric.memorydata.memory.ui.data.a.c> r29) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r28, Context.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.memorydata.memory.ui.data.a.c> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r8, "items");
        if (this.c != null) goto L5;
        OSheet r2 = new OSheet(r1, 0, 0, false, false, 30, null);
        int r3 = ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_2, "dimen", "oui_p_container_2"));
        int r4 = ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_tiny_2, "dimen", "oui_p_container_tiny_2"));
        r2.getBodyContainer().setPadding(r3, r4, r3, r4);
        r2.a(OSheet.HeightMode.WRAP_HEIGHT);
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), OSheet.Header.ONLY_TITLE, null, null, r1.getString(ZeusTransformUtils.mapRes(R.string.memory_calendar_dialog_create_schedule_todo_title, TypedValues.Custom.S_STRING, "memory_calendar_dialog_create_schedule_todo_title")), null, false, null, null, null, null, null, null, null, null, 16134, null);
        r2.d(a(r1));
        this.c = r2;
    L5:
        final View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r1), ZeusTransformUtils.mapRes(R.layout.memory_calendar_dialog_body, "layout", "memory_calendar_dialog_body"), null, false, "com.obric.memorydata.plugin");
        final int r12 = r11.getPaddingLeft();
        final int r13 = r11.getPaddingTop();
        final int r14 = r11.getPaddingRight();
        final int r15 = r11.getPaddingBottom();
        final SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r7 = (SelectionPanelView) ZeusTransformUtils.preCheckCast(r11.findViewById(ZeusTransformUtils.mapRes(R.id.calendar_selection_panel, OaidModel.KEY_ID, "calendar_selection_panel")), SelectionPanelView.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r7);
        a(this, "afterInflate", r11, r7, null, 8, null);
        this.d = r7;
        r7.setMaxHeight(-1);
        r7.setMultiSelect(true);
        r7.a(true, ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_line_1, TypedValues.Custom.S_COLOR, "oui_basic_line_1")), MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 28, Resources.getSystem().getDisplayMetrics())), 0);
        r7.setDiffCallback((com.obric.memorydata.memory.ui.selection.f) ZeusTransformUtils.preCheckCast(f, com.obric.memorydata.memory.ui.selection.f.class, "com.obric.memorydata.plugin"));
        r7.a(r8, $$Lambda$c$4jh4tyVQvoaNjrBQf4jPctyYCbI.INSTANCE);
        r7.setSelectionChangedListener((SelectionPanelView.b) ZeusTransformUtils.preCheckCast(new C0554c(this), SelectionPanelView.b.class, "com.obric.memorydata.plugin"));
        a(this, "afterSetItems", r11, r7, null, 8, null);
        OSheet r5 = this.c;
        if (r5 == null) goto L8;
        r5.c(r11);
    L8:
        a(this, "afterSetBodyView", r11, r7, null, 8, null);
        r11.post(new $$Lambda$c$svv5xXEWV3wWkmoOHS7DNAs5WsI(this, r11, r7, r12, r13, r14, r15));
        OSheet r6 = this.c;
        if (r6 == null) goto L27;
        r6.e(false);
    L27:
        OSheet r9 = this.c;     // Catch: Exception -> L23
        if (r9 == null) goto L16;
        String r10 = "com.obric.memorydata.plugin";
        r9.a((com.obric.oui.dialog.a.c) ZeusTransformUtils.preCheckCast(new d(this, r11, r7, r12, r13, r14, r15), com.obric.oui.dialog.a.c.class, r10));     // Catch: Exception -> L21
    L17:
        OSheet r0 = this.c;     // Catch: Exception -> L21
        if (r0 == null) goto L31;
        r0.show();     // Catch: Exception -> L21
        return;
    L31:
        return;
    L21:
        e = e;
    L25:
        Log.e("OUI", "showSelection: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r10));
        return;
    L16:
        r10 = "com.obric.memorydata.plugin";
    L23:
        e = e;
        r10 = "com.obric.memorydata.plugin";
        goto L25
    }

    public final void a(List<com.obric.memorydata.memory.ui.data.a.c> r3) {
        List<? extends com.obric.memorydata.memory.ui.data.a.c> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "items");
        SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r0 = this.d;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r5 = this.d;
        if (r5 == null) goto L9;
        r5.post(new $$Lambda$c$3iuq7Stsi_IChzRQPTR8lnjswFY(this));
        return;
    }

    public final List<com.obric.memorydata.memory.ui.data.a.c> b() {
        SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r0 = this.d;
        if (r0 == null) goto L7;
        List<com.obric.memorydata.memory.ui.data.a.c> r1 = r0.getSelectedData();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final Unit c() {
        SelectionPanelView<com.obric.memorydata.memory.ui.data.a.c, CalendarSelectionPanelItemView> r0 = this.d;
        if (r0 == null) goto L5;
        r0.b();
        return Unit.INSTANCE;
    L5:
        return null;
    }
}
