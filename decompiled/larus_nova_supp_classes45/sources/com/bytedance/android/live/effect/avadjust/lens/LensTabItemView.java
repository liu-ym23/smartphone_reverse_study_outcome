package com.bytedance.android.live.effect.avadjust.lens;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LensTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "name", "", "setTabName", "", "resId", "", "visible", "setDotVisibility", "getSelectedStatus", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LensTabItemView extends ConstraintLayout {
    public final TextView a;
    public final View b;
    public final View c;
    public boolean d;
    public final View e;
    public final View f;

    public LensTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LensTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean getSelectedStatus() {
        return this.d;
    }

    public final void R5(boolean r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        int r1 = 2131107386;
    L7:
        r0.setTextColor(s1.h(r1));
        goto L8
    L6:
        r1 = 2131107387;
    L8:
        View r2 = this.c;
        if (r2 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r2, r3);
    L11:
        this.d = r3;
    }

    public final void setDotVisibility(boolean r2) {
        View r0 = this.b;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.A(r0, r2);
        return;
    }

    public final void setTabName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    public final void setTabName(int r2) {
        TextView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setText(s1.B(r2));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LensTabItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131565840, this);
        this.a = (TextView) findViewById(2131390975);
        this.b = findViewById(2131370082);
        this.c = findViewById(2131375226);
        this.e = findViewById(2131364594);
        this.f = findViewById(2131366904);
    }

    public /* synthetic */ LensTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
