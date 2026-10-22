package com.larus.bmhome.bigimg.download;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.databinding.LarusLayoutCommonDownLoadBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutCommonDownLoadBinding;", "loadingStateJob", "Lkotlinx/coroutines/Job;", "hideLoadComplete", "", "showLoading", "hideLoading", "setDownloadIcon", "resId", "setLayoutEnable", "enable", "", "onBindData", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "resourceData", "Lcom/larus/bmhome/bigimg/download/DownloadResource;", "onDestroy", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CommonDownLoadLayout extends ConstraintLayout {
    public final LarusLayoutCommonDownLoadBinding a;
    public Job b;

    public CommonDownLoadLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonDownLoadLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        this.a.c.setVisibility(8);
        this.a.b.setVisibility(0);
    }

    public final void T5() {
        this.a.c.setVisibility(0);
        this.a.b.setVisibility(4);
    }

    public final void onDestroy() {
        Job r0 = this.b;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public final void setDownloadIcon(int r2) {
        this.a.b.setImageResource(r2);
    }

    public final void setLayoutEnable(boolean r2) {
        this.a.b.setEnabled(r2);
        AppCompatTextView r0 = this.a.d;
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 0.3f;
        goto L6
    }

    public final void S5(CoroutineScope r9, d<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "resourceData");
        Job r0 = this.b;
        Job r1 = null;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L6:
        if ((r10 instanceof d.a) == false) goto L11;
        if (r9 == null) goto L9;
        r1 = BuildersKt.launch$default(r9, Dispatchers.getMain(), null, new CommonDownLoadLayout$onBindData$1(r10, this, null), 2, null);
    L9:
        this.b = r1;
        return;
    L11:
        if ((r10 instanceof d.c) == false) goto L16;
        if (r9 == null) goto L14;
        r1 = BuildersKt.launch$default(r9, Dispatchers.getMain(), null, new CommonDownLoadLayout$onBindData$2(r10, this, null), 2, null);
    L14:
        this.b = r1;
        return;
    L16:
        if ((r10 instanceof d.b) == false) goto L23;
        if (r9 == null) goto L19;
        r1 = BuildersKt.launch$default(r9, Dispatchers.getMain(), null, new CommonDownLoadLayout$onBindData$3(r10, this, null), 2, null);
    L19:
        this.b = r1;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonDownLoadLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        LayoutInflater.from(r5).inflate(2131562784, this);
        int r8 = 2131370175;
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(this, 2131370175);
        if (r0 == null) goto L20;
        r8 = 2131370176;
        ProgressBar r1 = (ProgressBar) ViewBindings.findChildViewById(this, 2131370176);
        if (r1 == null) goto L20;
        r8 = 2131370177;
        AppCompatTextView r2 = ViewBindings.findChildViewById(this, 2131370177);
        if (r2 == null) goto L20;
        this.a = new LarusLayoutCommonDownLoadBinding(this, r0, r1, r2);
        int r3 = 0;
        TypedArray r9 = r5.obtainStyledAttributes(r6, new int[]{2130972251});
    L16:
        th = move-exception;
        r9.recycle();
        throw th;
    L10:
        if (r9.getBoolean(0, true) == true) goto L13;
        r3 = 8;
    L13:
        r2.setVisibility(r3);     // Catch: Throwable -> L16
        r9.recycle();
        return;
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r8)));
    }

    public /* synthetic */ CommonDownLoadLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
