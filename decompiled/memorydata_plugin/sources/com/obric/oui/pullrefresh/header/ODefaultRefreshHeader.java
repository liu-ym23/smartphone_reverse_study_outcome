package com.obric.oui.pullrefresh.header;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.RefreshState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J(\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J \u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bH\u0002J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-J6\u00102\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0012J\b\u00106\u001a\u00020\u001bH\u0002J\b\u00107\u001a\u00020\u001bH\u0002J\b\u00108\u001a\u00020\u001bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/pullrefresh/header/ODefaultRefreshHeader;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/pullrefresh/header/ORefreshHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "arrowAnimator", "Landroid/animation/ObjectAnimator;", "arrowPointUp", "", "arrowView", "Landroid/widget/ImageView;", "progressBar", "Lcom/obric/oui/progress/ODownloadProgressView;", "successView", "textPull", "", "textRefreshing", "textRelease", "textSuccess", "titleView", "Landroid/widget/TextView;", "getView", "Landroid/view/View;", "onFinish", "", "layout", "Lcom/obric/oui/pullrefresh/OPullRefreshLayout;", "success", "onPulling", "fraction", "", "offsetY", "headerHeight", "onStateChanged", "oldState", "Lcom/obric/oui/pullrefresh/RefreshState;", "newState", "rotateArrow", "pointUp", "withAnim", "setIconColor", TypedValues.Custom.S_COLOR, "", "setProgressBackgroundColor", "setTextColor", "colors", "Landroid/content/res/ColorStateList;", "setTexts", "pull", "release", "refreshing", "showArrow", "showProgress", "showSuccess", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODefaultRefreshHeader extends FrameLayout implements com.obric.oui.pullrefresh.header.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f14408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageView f14409b;
    private final ODownloadProgressView c;
    private final TextView d;
    private CharSequence e;
    private CharSequence f;
    private CharSequence g;
    private CharSequence h;
    private boolean i;
    private ObjectAnimator j;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14410a = null;

        static {
            int[] r0 = new int[RefreshState.values().length];
            r0[RefreshState.PULL_TO_REFRESH.ordinal()] = 1;
            r0[RefreshState.IDLE.ordinal()] = 2;
            r0[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            r0[RefreshState.REFRESHING.ordinal()] = 4;
            r0[RefreshState.FINISH.ordinal()] = 5;
            f14410a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ODefaultRefreshHeader(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public ODefaultRefreshHeader(Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        String r8 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_pull_to_refresh, TypedValues.Custom.S_STRING, "oui_pull_to_refresh"));
        Intrinsics.checkNotNullExpressionValue(r8, "context.getString(R.string.oui_pull_to_refresh)");
        this.e = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        String r9 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_release_to_refresh, TypedValues.Custom.S_STRING, "oui_release_to_refresh"));
        Intrinsics.checkNotNullExpressionValue(r9, "context.getString(R.string.oui_release_to_refresh)");
        this.f = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
        String r10 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_refreshing, TypedValues.Custom.S_STRING, "oui_refreshing"));
        Intrinsics.checkNotNullExpressionValue(r10, "context.getString(R.string.oui_refreshing)");
        this.g = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        String r11 = r6.getString(ZeusTransformUtils.mapRes(R.string.oui_refresh_success, TypedValues.Custom.S_STRING, "oui_refresh_success"));
        Intrinsics.checkNotNullExpressionValue(r11, "context.getString(R.string.oui_refresh_success)");
        this.h = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ZeusTransformUtils.inflate(LayoutInflater.from(r6), ZeusTransformUtils.mapRes(R.layout.o_pullrefresh_default_header, "layout", "o_pullrefresh_default_header"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_iv_arrow, OaidModel.KEY_ID, "pr_iv_arrow"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.pr_iv_arrow)");
        this.f14408a = (ImageView) ZeusTransformUtils.preCheckCast(r12, ImageView.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_iv_success, OaidModel.KEY_ID, "pr_iv_success"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.pr_iv_success)");
        this.f14409b = (ImageView) ZeusTransformUtils.preCheckCast(r13, ImageView.class, "com.obric.memorydata.plugin");
        View r14 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_progress, OaidModel.KEY_ID, "pr_progress"));
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.pr_progress)");
        this.c = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r14, ODownloadProgressView.class, "com.obric.memorydata.plugin");
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.pr_tv_title, OaidModel.KEY_ID, "pr_tv_title"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.pr_tv_title)");
        this.d = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin");
        setAlpha(0.0f);
    }

    public /* synthetic */ ODefaultRefreshHeader(Context r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    private final void a() {
        this.c.setVisibility(8);
        this.f14409b.setVisibility(8);
        this.f14408a.setVisibility(0);
    }

    private final void a(boolean r6, boolean r7) {
        if (this.i != r6) goto L5;
        return;
    L5:
        ObjectAnimator r0 = this.j;
        if (r0 == null) goto L9;
        r0.cancel();
    L9:
        float r1 = 0.0f;
        if (r6 == false) goto L12;
        float r2 = 0.0f;
    L13:
        if (r6 == false) goto L15;
        r1 = 180.0f;
    L15:
        if (r7 == false) goto L17;
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.f14408a, View.ROTATION, new float[]{r2, r1});
        r8.setDuration(200);
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r8.start();
        this.j = r8;
    L18:
        this.i = r6;
        return;
    L17:
        this.f14408a.setRotation(r1);
        goto L18
    L12:
        r2 = 180.0f;
        goto L13
    }

    private final void b() {
        this.f14409b.setVisibility(8);
        this.f14408a.setVisibility(8);
        this.c.setVisibility(0);
        setAlpha(1.0f);
    }

    private final void c() {
        this.f14408a.setVisibility(8);
        this.c.setVisibility(8);
        this.f14409b.setVisibility(0);
        setAlpha(1.0f);
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public void a(OPullRefreshLayout r1, float r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        setAlpha(RangesKt.coerceIn(r2, 0.0f, 1.0f));
        if (r1.getState() != RefreshState.IDLE) goto L5;
    L6:
        this.d.setText(this.e);
        this.c.setVisibility(8);
        this.f14409b.setVisibility(8);
        this.f14408a.setVisibility(0);
        if (this.i == false) goto L11;
        this.f14408a.setRotation(0.0f);
        this.i = false;
        return;
    L11:
        return;
    L5:
        if (r1.getState() == RefreshState.PULL_TO_REFRESH) goto L6;
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public void a(OPullRefreshLayout r3, RefreshState r4, RefreshState r5) {
        Intrinsics.checkNotNullParameter(r3, "layout");
        Intrinsics.checkNotNullParameter(r4, "oldState");
        Intrinsics.checkNotNullParameter(r5, "newState");
        int r6 = a.f14410a[r5.ordinal()];
        boolean r7 = false;
        boolean r0 = true;
        if (r6 != 1) goto L5;
    L19:
        this.d.setText(this.e);
        a();
        if (r4 == RefreshState.RELEASE_TO_REFRESH) goto L23;
        r0 = false;
    L23:
        a(false, r0);
        return;
    L5:
        if (r6 == 2) goto L19;
        if (r6 != 3) goto L9;
        this.d.setText(this.f);
        a();
        if (r4 != RefreshState.PULL_TO_REFRESH) goto L18;
        r7 = true;
    L18:
        a(true, r7);
        return;
    L9:
        if (r6 != 4) goto L11;
        this.d.setText(this.g);
        b();
        return;
    L11:
        if (r6 != 5) goto L28;
        this.d.setText(this.h);
        c();
        return;
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public void a(OPullRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        ObjectAnimator r3 = this.j;
        if (r3 == null) goto L6;
        r3.cancel();
    L6:
        this.f14408a.setRotation(0.0f);
        this.i = false;
    }

    public final void a(CharSequence r3, CharSequence r4, CharSequence r5, CharSequence r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        this.e = r7;
    L5:
        if (r8 == null) goto L7;
        this.f = r8;
    L7:
        if (r9 == null) goto L9;
        this.g = r9;
    L9:
        if (r10 == null) goto L11;
        this.h = r10;
    L11:
        TextView r11 = this.d;
        if (this.c.getVisibility() != 0) goto L15;
        CharSequence r2 = this.g;
    L21:
        r11.setText(r2);
        return;
    L15:
        if (this.f14409b.getVisibility() != 0) goto L18;
        r2 = this.h;
        goto L21
    L18:
        if (this.i == false) goto L20;
        r2 = this.f;
        goto L21
    L20:
        r2 = this.e;
        goto L21
    }

    @Override // com.obric.oui.pullrefresh.header.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    public final void setIconColor(int r2) {
        this.c.setProcessingColor(r2);
        this.f14408a.setColorFilter(r2);
        this.f14409b.setColorFilter(r2);
    }

    public final void setProgressBackgroundColor(int r1) {
        this.c.setProgressBackgroundColor(r1);
    }

    public final void setTextColor(int r1) {
        this.d.setTextColor(r1);
    }

    public final void setTextColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.d.setTextColor(r2);
    }
}
