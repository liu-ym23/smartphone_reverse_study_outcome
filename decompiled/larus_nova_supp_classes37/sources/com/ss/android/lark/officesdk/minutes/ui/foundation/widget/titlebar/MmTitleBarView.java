package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.style.a;
import com.ss.android.lark.officesdk.minutes.ui.style.b;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kwb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/titlebar/MmTitleBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contract", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/dialog/MmTitleBarViewContract;", "tvTitle", "Landroid/widget/TextView;", "ivClose", "Landroid/widget/ImageView;", "setTitle", "", "titleRes", "title", "", "setIncludingDivider", "includingDivider", "", "setCloseClickListener", "listener", "Landroid/view/View$OnClickListener;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmTitleBarView extends ConstraintLayout {
    public final e a;
    public final TextView b;
    public final ImageView c;

    public MmTitleBarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmTitleBarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setCloseClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        h.a(this.c, new AnonymousClass1(r3));
    }

    public final void setIncludingDivider(boolean r2) {
        View r0 = this.a.d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.b.setText(r2);
    }

    public final void setTitle(int r2) {
        this.b.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmTitleBarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        MmRecordingUILaunchMode r5 = c.a(r2);
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        e r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r5).getLayout().l(LayoutInflater.from(c.c(r2, r5)), this);
        this.a = r6;
        this.b = r6.b;
        ImageView r7 = r6.c;
        this.c = r7;
        r7.setBackground(b.a(r2).y(r2));
        r7.setImageTintList(ColorStateList.valueOf(UDColorUtils.getColor(r2, a.a(r2).a())));
        TypedArray r8 = r2.obtainStyledAttributes(r3, new int[]{2130970331, 2130974491});
        String r9 = r8.getString(1);
        if (r9 == null) goto L5;
        setTitle(r9);
    L5:
        setIncludingDivider(r8.getBoolean(0, false));
        r8.recycle();
    }

    public /* synthetic */ MmTitleBarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
