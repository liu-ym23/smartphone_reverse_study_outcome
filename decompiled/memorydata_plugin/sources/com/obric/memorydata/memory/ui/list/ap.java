package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.plugin.R;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u001c\u0010\"\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$2\u0006\u0010%\u001a\u00020\u000fJ\u001c\u0010&\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$2\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\u001fR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingConfirmationSheet;", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onImpression", "Lkotlin/Function1;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "", "onConfirm", "onIgnore", "onDismiss", "Lkotlin/Function0;", "onSeen", "", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "adapter", "Lcom/obric/memorydata/memory/ui/list/PendingConfirmationAdapter;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "navigationBarBottom", "", "screenLocation", "", "visibleBounds", "Landroid/graphics/Rect;", "clipVisibleBounds", "", "rect", "setupBottomSpacing", "show", "items", "", "revision", BuildConfig.CHANNEL, "dismiss", "isShowing", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1<Long, Unit> f11197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OSheet f11198b;
    private final ao c;
    private final RecyclerView d;
    private int e;
    private final int[] f;
    private final Rect g;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/memorydata/memory/ui/list/PendingConfirmationSheet$setupBottomSpacing$1", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends RecyclerView.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ap f11200a;

        a(ap r1) {
            this.f11200a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
        public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            r2.set(0, 0, 0, 0);
            int r6 = r4.getChildAdapterPosition(r3);
            if (r6 != (-1)) goto L5;
            return;
        L5:
            if (r6 != (ap.a(this.f11200a).d() - 1)) goto L9;
            r2.bottom = MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics())) + ap.b(this.f11200a);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f11201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ap f11202b;
        final /* synthetic */ long c;

        public b(View r1, ap r2, long r3) {
            this.f11201a = r1;
            this.f11202b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ap.c(this.f11202b).isShowing() == true) goto L5;
            return;
        L5:
            if (ap.d(this.f11202b).isShown() == false) goto L9;
            ap.e(this.f11202b).invoke(Long.valueOf(this.c));
            return;
        }
    }

    public ap(Context r36, LifecycleOwner r37, Function1<? super ar, Unit> r38, Function1<? super ar, Unit> r39, Function1<? super ar, Unit> r40, Function0<Unit> r41, Function1<? super Long, Unit> r42) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.memorydata.plugin");
        LifecycleOwner r11 = (LifecycleOwner) ZeusTransformUtils.wrapperContextForParams(r37, LifecycleOwner.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r38, Function1.class, "com.obric.memorydata.plugin");
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r39, Function1.class, "com.obric.memorydata.plugin");
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r40, Function1.class, "com.obric.memorydata.plugin");
        final Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r41, Function0.class, "com.obric.memorydata.plugin");
        Function1<Long, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r42, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "onImpression");
        Intrinsics.checkNotNullParameter(r13, "onConfirm");
        Intrinsics.checkNotNullParameter(r14, "onIgnore");
        Intrinsics.checkNotNullParameter(r15, "onDismiss");
        Intrinsics.checkNotNullParameter(r3, "onSeen");
        this.f11197a = r3;
        OSheet r10 = new OSheet(r1, 0, 0, true, false, 22, null);
        this.f11198b = r10;
        ao r4 = new ao(r11, r12, (Function1) ZeusTransformUtils.preCheckCast(new PendingConfirmationSheet$adapter$1(this), Function1.class, "com.obric.memorydata.plugin"), r13, r14);
        this.c = r4;
        View r5 = ZeusTransformUtils.inflate(LayoutInflater.from(r1), ZeusTransformUtils.mapRes(R.layout.pending_personal_info_sheet_body, "layout", "pending_personal_info_sheet_body"), null, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.RecyclerView");
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5, RecyclerView.class, "com.obric.memorydata.plugin");
        this.d = r6;
        this.f = new int[2];
        this.g = new Rect();
        r6.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager(r1), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        r6.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r4, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r6.setItemAnimator(null);
        c();
        r10.a(OSheet.HeightMode.FULL_HEIGHT);
        r10.f(true);
        r10.setCanceledOnTouchOutside(true);
        com.obric.oui.sheet.v2.a.C0775a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.sheet.v2.a.class, "com.obric.memorydata.plugin"), OSheet.Header.MODAL, null, null, r1.getString(ZeusTransformUtils.mapRes(R.string.memory_pending_personal_info_title, TypedValues.Custom.S_STRING, "memory_pending_personal_info_title")), null, false, null, new $$Lambda$ap$UDmgPUa5Qp4FaFbQCUeXV1DeQDQ(this), null, null, null, null, null, null, 16134, null);
        r10.c((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        r10.a((com.obric.oui.dialog.a.c) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), com.obric.oui.dialog.a.c.class, "com.obric.memorydata.plugin"));
        r10.setOnDismissListener(new $$Lambda$ap$P9PVH56ODu5hjdgwI24XYZ6gkBk(r15));
    }

    private static final WindowInsetsCompat a(ap r1, View r2, WindowInsetsCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "insets");
        int r4 = r3.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        if (r1.e == r4) goto L5;
        r1.e = r4;
        r1.d.invalidateItemDecorations();
    L5:
        return r3;
    }

    public static final /* synthetic */ ao a(ap r0) {
        return r0.c;
    }

    private static final void a(ap r3, long r4) {
        r3.d.invalidateItemDecorations();
        View r0 = (View) ZeusTransformUtils.preCheckCast(r3.d, View.class, "com.obric.memorydata.plugin");
        OneShotPreDrawListener.add(r0, (Runnable) ZeusTransformUtils.preCheckCast(new b(r0, r3, r4), Runnable.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(ap r0, View r1) {
        r0.a();
    }

    private static final void a(Function0 r2, DialogInterface r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        r4.invoke();
    }

    private final boolean a(Rect r5) {
        if (this.f11198b.isShowing() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.d.getLocalVisibleRect(this.g) == false) goto L9;
        this.d.getLocationOnScreen(this.f);
        Rect r0 = this.g;
        int[] r2 = this.f;
        r0.offset(r2[0], r2[1]);
        Rect r1 = this.g;
        r1.bottom = Math.min(r1.bottom, (this.f[1] + this.d.getHeight()) - this.e);
        return r5.intersect(this.g);
    }

    public static final /* synthetic */ boolean a(ap r0, Rect r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ int b(ap r0) {
        return r0.e;
    }

    public static final /* synthetic */ OSheet c(ap r0) {
        return r0.f11198b;
    }

    private final void c() {
        this.d.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new a(this), RecyclerView.g.class, "com.obric.memorydata.plugin"));
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ap$xcLYBcE7TQJPbJc0E6vgwtpN54Y(this));
    }

    public static final /* synthetic */ RecyclerView d(ap r0) {
        return r0.d;
    }

    public static final /* synthetic */ Function1 e(ap r0) {
        return r0.f11197a;
    }

    public static /* synthetic */ void lambda$P9PVH56ODu5hjdgwI24XYZ6gkBk(Function0 r0, DialogInterface r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$UDmgPUa5Qp4FaFbQCUeXV1DeQDQ(ap r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$n960H2onQ-q_Ybc9qhbkd_d5k1Q, reason: not valid java name */
    public static /* synthetic */ void m933lambda$n960H2onQq_Ybc9qhbkd_d5k1Q(ap r0, long r1) {
        a(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$xcLYBcE7TQJPbJc0E6vgwtpN54Y(ap r0, View r1, WindowInsetsCompat r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        if (this.f11198b.isShowing() == false) goto L6;
        this.f11198b.dismiss();
        return;
    }

    public final void a(List<ar> r3, long r4) {
        List<ar> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "items");
        update(r5, r4);
        if (this.f11198b.isShowing() == true) goto L6;
        this.f11198b.show();
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final boolean b() {
        return this.f11198b.isShowing();
    }

    public final void update(List<ar> r4, final long r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "items");
        this.c.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), new $$Lambda$ap$n960H2onQq_Ybc9qhbkd_d5k1Q(this, r5));
    }
}
