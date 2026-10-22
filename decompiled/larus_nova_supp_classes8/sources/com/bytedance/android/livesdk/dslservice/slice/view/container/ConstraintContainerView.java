package com.bytedance.android.livesdk.dslservice.slice.view.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.d;
import zt1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\r\u0010\u0011R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/dslservice/slice/view/container/ConstraintContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lyt1/d;", "Lzt1/a;", "a", "Lzt1/a;", "getContainerData", "()Lzt1/a;", "setContainerData", "(Lzt1/a;)V", "containerData", "Landroid/content/Context;", "mContext", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "mAttributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dslservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConstraintContainerView extends ConstraintLayout implements d {
    public a a;

    @Override // yt1.d
    public a getContainerData() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // yt1.d
    public final void release() {
        removeAllViews();
    }

    public ConstraintContainerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        super(r2);
    }

    @Override // yt1.d
    public void setContainerData(a r1) {
        this.a = r1;
    }

    public ConstraintContainerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mAttributeSet");
        super(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r7, int r8) {
        int r0 = View.MeasureSpec.getMode(r7);
        int r9 = View.MeasureSpec.getSize(r7);
        int r1 = View.MeasureSpec.getMode(r8);
        int r10 = View.MeasureSpec.getSize(r8);
        if (r0 == Integer.MIN_VALUE) goto L5;
    L7:
        if (r1 == Integer.MIN_VALUE) goto L9;
    L11:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r9, r0), View.MeasureSpec.makeMeasureSpec(r10, r1));
        if (v.a() == false) goto L15;
        ALogger.i("ConstraintContainerView", "widthMode = " + r0 + " widthSize =" + r9 + " hMode=" + r1 + " hSize=" + r10 + " fw=" + getMeasuredWidth() + " fh=" + getMeasuredHeight());
        return;
    L15:
        return;
    L9:
        if (getChildCount() != 0) goto L11;
        r10 = 0;
        goto L11
    L5:
        if (getChildCount() != 0) goto L7;
        r9 = 0;
        goto L7
    }
}
