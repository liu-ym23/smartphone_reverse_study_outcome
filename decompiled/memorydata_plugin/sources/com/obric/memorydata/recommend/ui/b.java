package com.obric.memorydata.recommend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.g;
import com.obric.oui.button.OButton;
import com.obric.oui.c.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\rJ\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/ui/ScreenObservationDisableDialog;", "", "<init>", "()V", "disable", "", "currentDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "show", "", "context", "Landroid/content/Context;", "onDismiss", "Lkotlin/Function1;", "dismiss", "genContentView", "Landroid/view/View;", "itemList", "", "Lcom/obric/memorydata/recommend/ui/ScreenObservationDisableDialog$ActionSheetItemData;", "ActionSheetItemData", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12644b;
    private static com.obric.oui.dialog.v2.action.a c;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/recommend/ui/ScreenObservationDisableDialog$ActionSheetItemData;", "", "title", "", "isRedStyle", "", "viewClickListener", "Landroid/view/View$OnClickListener;", "<init>", "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "getTitle", "()Ljava/lang/String;", "()Z", "getViewClickListener", "()Landroid/view/View$OnClickListener;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12646b;
        private final View.OnClickListener c;

        public a(String r3, boolean r4, View.OnClickListener r5) {
            View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r6, "viewClickListener");
            this.f12645a = r3;
            this.f12646b = r4;
            this.c = r6;
        }

        public final String a() {
            return this.f12645a;
        }

        public final boolean b() {
            return this.f12646b;
        }

        public final View.OnClickListener c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12645a, r6.f12645a) == true) goto L12;
            return false;
        L12:
            if (this.f12646b == r6.f12646b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12645a.hashCode() * 31) + Boolean.hashCode(this.f12646b)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ActionSheetItemData(title=" + this.f12645a + ", isRedStyle=" + this.f12646b + ", viewClickListener=" + this.c + ')';
        }
    }

    static {
        f12643a = new b();
    }

    private b() {
    }

    private final View a(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        ScrollView r0 = new ScrollView(r13);
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.setVerticalScrollBarEnabled(true);
        LinearLayout r5 = new LinearLayout(r13);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r5.setOrientation(1);
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(b(r13), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r4 = 0;
    L4:
        if (r11.hasNext() == false) goto L16;
        Object r6 = r11.next();
        int r7 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r8 = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin");
        if (r4 <= 0) goto L12;
        View r9 = new View(r13);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()))), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r5.addView(r9);
    L12:
        if (r8.b() == false) goto L14;
        int r10 = R.style.OStyleV2_OButton_L_Standard_Red_Light;
        String r14 = "OStyleV2_OButton_L_Standard_Red_Light";
    L15:
        OButton r15 = (OButton) ZeusTransformUtils.preCheckCast(e.a(r13, ZeusTransformUtils.mapRes(r10, "style", r14), $$Lambda$b$iLRmWEdNBEThfU7rwOkaXP2U0iY.INSTANCE), OButton.class, "com.obric.memorydata.plugin");
        r15.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        r15.setOnClickListener(r8.c());
        r5.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"));
        r4 = r7;
        goto L4
    L14:
        r10 = R.style.OStyleV2_OButton_L_Standard_Neutral;
        r14 = "OStyleV2_OButton_L_Standard_Neutral";
        goto L15
    L16:
        r0.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    private static final View a(Context r2, ViewGroup r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        return f12643a.a(r4);
    }

    private static final OButton a(Context r8, int r9, int r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "styledContext");
        OButton r11 = new OButton(r1, null, 0, 0, null, 28, null);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, r10));
        return r11;
    }

    private final void a() {
        f12644b = true;
        com.obric.oui.dialog.v2.action.a r0 = c;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        c = null;
    }

    private static final void a(View r2) {
        com.obric.memorydata.recommend.feature.a.f12505a.a(0, 10);
        f12643a.a();
    }

    private static final void a(Function1 r2, DialogInterface r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        c = null;
        if (r4 == null) goto L5;
        r4.invoke(Boolean.valueOf(f12644b));
    L5:
        f12644b = false;
    }

    private final List<a> b(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        String r1 = r7.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_disable_10_minutes, TypedValues.Custom.S_STRING, "screen_memory_disable_10_minutes"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        String r2 = r7.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_disable_1_hour, TypedValues.Custom.S_STRING, "screen_memory_disable_1_hour"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        String r4 = r7.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_disable_until_6_am, TypedValues.Custom.S_STRING, "screen_memory_disable_until_6_am"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        String r9 = r7.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_disable_directly, TypedValues.Custom.S_STRING, "screen_memory_disable_directly"));
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        return CollectionsKt.listOf(new a[]{new a(r1, false, $$Lambda$b$hAjCdesBhsdi2ye8aFr8Ofet8Gk.INSTANCE), new a(r2, false, $$Lambda$b$xoj86oeRT6wQDWFnRPlPYjlvK4U.INSTANCE), new a(r4, false, $$Lambda$b$iGMC3RID3rHzRUNJhQ69HSZd0vk.INSTANCE), new a(r9, true, $$Lambda$b$tbQjYLfX3yggJAiZzNMMB4kARoE.INSTANCE)});
    }

    private static final void b(View r2) {
        com.obric.memorydata.recommend.feature.a.f12505a.a(0, 60);
        f12643a.a();
    }

    private static final void c(View r2) {
        com.obric.memorydata.recommend.feature.a.f12505a.b(6, 0);
        f12643a.a();
    }

    private static final void d(View r0) {
        com.obric.memorydata.recommend.feature.a.f12505a.d();
        f12643a.a();
    }

    public static /* synthetic */ void lambda$2aIOb8QYAMWd8lx2M3nm6hQXyCI(Function1 r0, DialogInterface r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$7b7SunGH41Szoh-fw_CSS8OM8Lw, reason: not valid java name */
    public static /* synthetic */ View m1140lambda$7b7SunGH41Szohfw_CSS8OM8Lw(Context r0, ViewGroup r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$hAjCdesBhsdi2ye8aFr8Ofet8Gk(View r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$iGMC3RID3rHzRUNJhQ69HSZd0vk(View r0) {
        c(r0);
    }

    public static /* synthetic */ OButton lambda$iLRmWEdNBEThfU7rwOkaXP2U0iY(Context r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$tbQjYLfX3yggJAiZzNMMB4kARoE(View r0) {
        d(r0);
    }

    public static /* synthetic */ void lambda$xoj86oeRT6wQDWFnRPlPYjlvK4U(View r0) {
        b(r0);
    }

    public final void a(Context r7, Function1<? super Boolean, Unit> r8) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r1 = r6.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_disable_title, TypedValues.Custom.S_STRING, "screen_memory_disable_title"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        String r3 = r6.getString(ZeusTransformUtils.mapRes(R.string.screen_memory_disable_message, TypedValues.Custom.S_STRING, "screen_memory_disable_message"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        com.obric.oui.dialog.v2.action.a r0 = new com.obric.oui.dialog.v2.action.a(r6, new com.obric.oui.dialog.v2.action.a.b(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$b$7b7SunGH41Szohfw_CSS8OM8Lw(r6)));
        r0.setOnDismissListener(new $$Lambda$b$2aIOb8QYAMWd8lx2M3nm6hQXyCI(r9));
        c = r0;
        if (r0 == null) goto L8;
        r0.show();
        Window r10 = r0.getWindow();
        if (r10 == null) goto L9;
        g.a(r10, false);
        return;
    L9:
        return;
    }
}
