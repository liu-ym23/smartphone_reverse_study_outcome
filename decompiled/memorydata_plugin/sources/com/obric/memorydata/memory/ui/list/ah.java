package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001&B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0002J\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceSheet;", "", "context", "Landroid/content/Context;", "onSourceClick", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/list/MemorySourceFilter;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "adapter", "Lcom/obric/memorydata/memory/ui/list/MemorySourceSheetAdapter;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "bodyPaddingLeft", "", "bodyPaddingTop", "bodyPaddingRight", "bodyPaddingBottom", "navigationBarBottom", "lastRestoredPaddingTop", "show", "", "items", "", "selectedKey", "", BuildConfig.CHANNEL, "dismiss", "isShowing", "resetBodyHeight", "from", "updateBodyHeight", "limitWhenContentExceedsMax", "restoreBodyBottomPadding", "logSheetState", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11179a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<MemorySourceFilter, Unit> f11180b;
    private final OSheet c;
    private final ai d;
    private final RecyclerView e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private int j;
    private int k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourceSheet$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah f11182a;

        public b(ah r1) {
            this.f11182a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            ah.a(this.f11182a, BuildConfig.CHANNEL, true);
        }
    }

    static {
        f11179a = new a(null);
    }

    public ah(Context r30, Function1<? super MemorySourceFilter, Unit> r31) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.memorydata.plugin");
        Function1<MemorySourceFilter, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r31, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "onSourceClick");
        this.f11180b = r3;
        OSheet r11 = new OSheet(r1, 0, 0, true, false, 22, null);
        this.c = r11;
        ai r4 = new ai(new $$Lambda$ah$rV_yoAiYh2rU5E6GwLqh6v9Iz4(this));
        this.d = r4;
        View r5 = ZeusTransformUtils.inflate(LayoutInflater.from(r1), ZeusTransformUtils.mapRes(R.layout.memory_source_sheet_body, "layout", "memory_source_sheet_body"), null, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.RecyclerView");
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5, RecyclerView.class, "com.obric.memorydata.plugin");
        this.e = r6;
        this.f = r6.getPaddingLeft();
        int r7 = r6.getPaddingTop();
        this.g = r7;
        this.h = r6.getPaddingRight();
        this.i = r6.getPaddingBottom();
        this.k = r7;
        r6.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager(r1), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r6.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r4, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r6.setItemAnimator(null);
        r6.setClipToPadding(false);
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ah$fmB7dQrUqERTCPTrhRT4ED_7efo(this));
        r11.a(OSheet.HeightMode.WRAP_HEIGHT);
        r11.f(true);
        r11.setCanceledOnTouchOutside(true);
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r11, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), OSheet.Header.MODAL, null, null, r1.getString(ZeusTransformUtils.mapRes(R.string.memory_source_sheet_title, TypedValues.Custom.S_STRING, "memory_source_sheet_title")), null, false, null, new $$Lambda$ah$hdMgm9H2NE8MGmi_rV0ho3xugEM(this), null, null, null, null, null, null, 16134, null);
        r11.c((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        r11.a((com.obric.oui.dialog.a.c) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), com.obric.oui.dialog.a.c.class, "com.obric.memorydata.plugin"));
    }

    private static final WindowInsetsCompat a(ah r3, View r4, WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "insets");
        int r0 = r5.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        r3.j = r0;
        int r6 = r3.i + r0;
        r4.setPadding(r4.getPaddingLeft(), r4.getPaddingTop(), r4.getPaddingRight(), r6);
        return r5;
    }

    private static final Unit a(ah r1, MemorySourceFilter r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.f11180b.invoke(r2);
        r1.a();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(ah r0) {
        r0.c();
    }

    private static final void a(ah r0, View r1) {
        r0.a();
    }

    public static final /* synthetic */ void a(ah r0, String r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(ah r0, String r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(ah r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.a(r1, r2);
    }

    private final void a(String r4) {
        RecyclerView r0 = this.e;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = -1;
        r1.height = -2;
        r0.setLayoutParams(r1);
        c();
        b("resetBodyHeight:" + r4);
    }

    private final void a(String r4, boolean r5) {
        int r0 = this.c.s();
        if (this.c.t() == true) goto L10;
        if (r5 == false) goto L9;
        if (r0 <= 0) goto L9;
        if (this.e.getHeight() > r0) goto L10;
    L9:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L14;
        a(r4);
        return;
    L14:
        if (r0 <= 0) goto L16;
        RecyclerView r7 = this.e;
        ViewGroup.LayoutParams r1 = r7.getLayoutParams();
        r1.width = -1;
        r1.height = r0;
        r7.setLayoutParams(r1);
        c();
    L16:
        b("updateBodyHeight:" + r4);
        return;
    L10:
        r6 = true;
        goto L11
    }

    private static final void b(ah r4) {
        r4.a(BuildConfig.CHANNEL);
        View r1 = (View) ZeusTransformUtils.preCheckCast(r4.e, View.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r1) == true) goto L5;
    L7:
        r1.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new b(r4), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        if (r1.isLayoutRequested() == true) goto L7;
        a(r4, BuildConfig.CHANNEL, true);
    }

    private final void b(String r4) {
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder();
        StringBuilder r5 = r1.append("from=").append(r4).append(", isShowing=").append(this.c.isShowing()).append(", isMax=").append(this.c.t()).append(", maxBodyHeight=").append(this.c.s()).append(", rvHeight=").append(this.e.getHeight()).append(", lpHeight=");
        ViewGroup.LayoutParams r2 = this.e.getLayoutParams();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.height);
    L6:
        r5.append(r3).append(", paddingTop=").append(this.e.getPaddingTop()).append(", bodyPaddingTop=").append(this.g).append(", lastRestoredPaddingTop=").append(this.k).append(", paddingBottom=").append(this.e.getPaddingBottom()).append(", itemCount=").append(this.d.d()).append(", canScrollDown=");
        r1.append(this.e.canScrollVertically(1)).append(", canScrollUp=").append(this.e.canScrollVertically(-1));
        r0.debug("MemorySourceSheet", r1.toString());
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void c() {
        int r0 = this.e.getPaddingTop();
        if (r0 != this.k) goto L5;
        r0 = RangesKt.coerceAtLeast(r0 - this.g, 0);
    L5:
        int r1 = r0 + this.g;
        this.k = r1;
        this.e.setPadding(this.f, r1, this.h, this.i + this.j);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$fmB7dQrUqERTCPTrhRT4ED_7efo(ah r0, View r1, WindowInsetsCompat r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$fyuEVrkUkPFrlfL6ha2A7zD-zio, reason: not valid java name */
    public static /* synthetic */ void m929lambda$fyuEVrkUkPFrlfL6ha2A7zDzio(ah r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$hdMgm9H2NE8MGmi_rV0ho3xugEM(ah r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$rV_yoAiYh2rU-5E6GwLqh6v9Iz4, reason: not valid java name */
    public static /* synthetic */ Unit m930lambda$rV_yoAiYh2rU5E6GwLqh6v9Iz4(ah r0, MemorySourceFilter r1) {
        return a(r0, r1);
    }

    public final void a() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ((ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin")).c.dismiss();     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L12;
        RunLog.INSTANCE.error("MemorySourceSheet", "dismiss failed", r4);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final boolean a(List<MemorySourceFilter> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "items");
        Intrinsics.checkNotNullParameter(r4, "selectedKey");
        this.d.a(r4);
        this.d.b(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")));
        a("show");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L8
        ah r2 = (ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r2.c.show();     // Catch: Throwable -> L8
        Window r7 = r2.c.getWindow();     // Catch: Throwable -> L8
        if (r7 == null) goto L6;
        com.obric.memorydata.ui.g.a(r7, NavigationBarScheme.B1);     // Catch: Throwable -> L8
    L6:
        Object r8 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L15;
        RunLog.INSTANCE.error("MemorySourceSheet", "show failed", r9);
        r8 = false;
    L15:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final boolean b() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m1421constructorimpl(Boolean.valueOf(((ah) ZeusTransformUtils.preCheckCast(this, ah.class, "com.obric.memorydata.plugin")).c.isShowing()));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r3) == false) goto L11;
        r3 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void update(List<MemorySourceFilter> r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "items");
        Intrinsics.checkNotNullParameter(r4, "selectedKey");
        this.d.a(r4);
        this.d.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$ah$fyuEVrkUkPFrlfL6ha2A7zDzio(this));
    }
}
