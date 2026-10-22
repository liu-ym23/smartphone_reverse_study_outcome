package com.obric.oui.pullrefresh.header;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bs.a;
import bs.b;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.pullrefresh.OPullRefreshLayout;
import com.obric.oui.pullrefresh.RefreshState;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/pullrefresh/header/ODefaultRefreshHeader;", "Landroid/widget/FrameLayout;", "Lbs/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "", "color", "", "setTextColor", "(I)V", "Landroid/content/res/ColorStateList;", "colors", "(Landroid/content/res/ColorStateList;)V", "setIconColor", "setProgressBackgroundColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ODefaultRefreshHeader extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f14249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ODownloadProgressView f14251c;
    public final TextView d;
    public String e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObjectAnimator f14254j;

    @JvmOverloads
    public ODefaultRefreshHeader(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Override // bs.b
    public final void a(OPullRefreshLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "layout");
        ObjectAnimator r10 = this.f14254j;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        this.f14249a.setRotation(0.0f);
        this.f14253i = false;
    }

    @Override // bs.b
    public final void b(OPullRefreshLayout r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "layout");
        setAlpha(RangesKt.coerceIn(r10, 0.0f, 1.0f));
        if (r5.getState() != RefreshState.IDLE) goto L5;
    L6:
        this.d.setText(this.e);
        this.f14251c.setVisibility(8);
        this.f14250b.setVisibility(8);
        ImageView r11 = this.f14249a;
        r11.setVisibility(0);
        if (this.f14253i == false) goto L11;
        r11.setRotation(0.0f);
        this.f14253i = false;
        return;
    L11:
        return;
    L5:
        if (r5.getState() == RefreshState.PULL_TO_REFRESH) goto L6;
    }

    @Override // bs.b
    public final void c(OPullRefreshLayout r10, RefreshState r11, RefreshState r12) {
        Intrinsics.checkNotNullParameter(r10, "layout");
        Intrinsics.checkNotNullParameter(r11, "oldState");
        Intrinsics.checkNotNullParameter(r12, "newState");
        int r13 = a.f983a[r12.ordinal()];
        ImageView r14 = this.f14249a;
        ODownloadProgressView r5 = this.f14251c;
        ImageView r15 = this.f14250b;
        boolean r16 = false;
        TextView r17 = this.d;
        boolean r18 = true;
        if (r13 != 1) goto L5;
    L19:
        r17.setText(this.e);
        r5.setVisibility(8);
        r15.setVisibility(8);
        r14.setVisibility(0);
        if (r11 == RefreshState.RELEASE_TO_REFRESH) goto L23;
        r18 = false;
    L23:
        d(false, r18);
        return;
    L5:
        if (r13 == 2) goto L19;
        if (r13 != 3) goto L9;
        r17.setText(this.f);
        r5.setVisibility(8);
        r15.setVisibility(8);
        r14.setVisibility(0);
        if (r11 != RefreshState.PULL_TO_REFRESH) goto L18;
        r16 = true;
    L18:
        d(true, r16);
        return;
    L9:
        if (r13 != 4) goto L11;
        r17.setText(this.g);
        r15.setVisibility(8);
        r14.setVisibility(8);
        r5.setVisibility(0);
        setAlpha(1.0f);
        return;
    L11:
        if (r13 != 5) goto L28;
        r17.setText(this.f14252h);
        r14.setVisibility(8);
        r5.setVisibility(8);
        r15.setVisibility(0);
        setAlpha(1.0f);
        return;
    }

    public final void d(boolean r10, boolean r11) {
        if (this.f14253i != r10) goto L5;
        return;
    L5:
        ObjectAnimator r5 = this.f14254j;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        float r12 = 180.0f;
        if (r10 == false) goto L12;
        float r13 = 0.0f;
    L13:
        if (r10 == true) goto L16;
        r12 = 0.0f;
    L16:
        ImageView r14 = this.f14249a;
        if (r11 == false) goto L19;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r14, View.ROTATION, new float[]{r13, r12});
        r15.setDuration(200);
        r15.setInterpolator(new DecelerateInterpolator());
        r15.start();
        this.f14254j = r15;
    L20:
        this.f14253i = r10;
        return;
    L19:
        r14.setRotation(r12);
        goto L20
    L12:
        r13 = 180.0f;
        goto L13
    }

    @Override // bs.b
    public View getView() {
        return this;
    }

    public final void setIconColor(int r5) {
        this.f14251c.setProcessingColor(r5);
        this.f14249a.setColorFilter(r5);
        this.f14250b.setColorFilter(r5);
    }

    public final void setProgressBackgroundColor(int r5) {
        this.f14251c.setProgressBackgroundColor(r5);
    }

    public final void setTextColor(int r5) {
        this.d.setTextColor(r5);
    }

    @JvmOverloads
    public ODefaultRefreshHeader(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.e = r5.getString(R$string.oui_pull_to_refresh);
        this.f = r5.getString(R$string.oui_release_to_refresh);
        this.g = r5.getString(R$string.oui_refreshing);
        this.f14252h = r5.getString(R$string.oui_refresh_success);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(r5).inflate(R$layout.o_pullrefresh_default_header, this, true);
        this.f14249a = (ImageView) findViewById(R$id.pr_iv_arrow);
        this.f14250b = (ImageView) findViewById(R$id.pr_iv_success);
        this.f14251c = (ODownloadProgressView) findViewById(R$id.pr_progress);
        this.d = (TextView) findViewById(R$id.pr_tv_title);
        setAlpha(0.0f);
    }

    public final void setTextColor(ColorStateList r5) {
        Intrinsics.checkNotNullParameter(r5, "colors");
        this.d.setTextColor(r5);
    }
}
