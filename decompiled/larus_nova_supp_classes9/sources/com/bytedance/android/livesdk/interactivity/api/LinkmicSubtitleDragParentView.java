package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/LinkmicSubtitleDragParentView;", "Lcom/bytedance/android/livesdk/interactivity/api/DragParentView;", "Ls52/a;", BuildConfig.FLAVOR, "disableDelete", BuildConfig.FLAVOR, "setDisableDelete", "q", "Z", "getMDisableDelete", "()Z", "setMDisableDelete", "(Z)V", "mDisableDelete", BuildConfig.FLAVOR, "r", "I", "getDeleteAreaViewHeight", "()I", "setDeleteAreaViewHeight", "(I)V", "deleteAreaViewHeight", "s", "getForbiddenAreaViewHeight", "setForbiddenAreaViewHeight", "forbiddenAreaViewHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicSubtitleDragParentView extends DragParentView implements s52.a {
    public boolean q;
    public int r;
    public int s;

    public LinkmicSubtitleDragParentView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LinkmicSubtitleDragParentView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getDeleteAreaViewHeight() {
        return this.r;
    }

    public final int getForbiddenAreaViewHeight() {
        return this.s;
    }

    public final boolean getMDisableDelete() {
        return this.q;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "dragView");
        addView(r3, new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final Pair h(DragContainer r4) {
        Intrinsics.checkNotNullParameter(r4, "dragView");
        return TuplesKt.to(Float.valueOf(r4.getX() / getWidth()), Float.valueOf((r4.getY() - this.r) / ((getHeight() - this.r) - this.s)));
    }

    public final void setDeleteAreaViewHeight(int r1) {
        this.r = r1;
    }

    @Override // s52.a
    public void setDisableDelete(boolean r1) {
        this.q = r1;
    }

    public final void setForbiddenAreaViewHeight(int r1) {
        this.s = r1;
    }

    public final void setMDisableDelete(boolean r1) {
        this.q = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final void d(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deleteView");
        super.d(r2, r3);
        this.r = r3;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final boolean i(float r3, float r4) {
        if (this.q == false) goto L12;
        if (r3 >= ((getTop() + this.r) + getMDragAreaMarginTop())) goto L7;
    L9:
        return false;
    L7:
        if ((r3 + r4) > ((getBottom() - this.s) - getMDragAreaMarginBottom())) goto L9;
        return true;
    L12:
        return super.i(r3, r4);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.DragParentView, d42.d
    public final void j(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "forbiddenView");
        super.j(r2, r3);
        this.s = r3;
    }

    public LinkmicSubtitleDragParentView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ LinkmicSubtitleDragParentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
