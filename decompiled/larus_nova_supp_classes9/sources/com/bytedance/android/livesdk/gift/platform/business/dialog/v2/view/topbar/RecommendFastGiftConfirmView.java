package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/topbar/RecommendFastGiftConfirmView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "mainTextStr", BuildConfig.FLAVOR, "setMainText", "checkedStr", "setCheckedText", "leftButtonStr", "setLeftButtonText", "Landroid/view/View$OnClickListener;", "listener", "setOnClickLeftButtonListener", "rightButtonStr", "setRightButtonText", "setOnClickRightButtonListener", BuildConfig.FLAVOR, "getIsChecked", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecommendFastGiftConfirmView extends FrameLayout {
    public final TextView a;
    public final CheckBox b;
    public final TextView c;
    public final View d;
    public final TextView e;
    public final View f;
    public final TextView g;

    public RecommendFastGiftConfirmView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecommendFastGiftConfirmView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getIsChecked() {
        CheckBox r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isChecked() != true) goto L7;
        return true;
    }

    public final void setCheckedText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "checkedStr");
        TextView r0 = this.c;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setLeftButtonText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "leftButtonStr");
        TextView r0 = this.e;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setMainText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "mainTextStr");
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setOnClickLeftButtonListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        View r0 = this.d;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setOnClickRightButtonListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        View r0 = this.f;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setRightButtonText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rightButtonStr");
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public RecommendFastGiftConfirmView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131567273, this);
        this.a = (TextView) r5.findViewById(2131379475);
        this.b = (CheckBox) r5.findViewById(2131365404);
        this.c = (TextView) r5.findViewById(2131365405);
        this.d = r5.findViewById(2131377737);
        this.e = (TextView) r5.findViewById(2131377741);
        this.f = r5.findViewById(2131384558);
        this.g = (TextView) r5.findViewById(2131384562);
    }

    public /* synthetic */ RecommendFastGiftConfirmView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
