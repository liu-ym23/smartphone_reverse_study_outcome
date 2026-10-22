package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/BeautifyTabItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "name", "", "setTabName", "", "resId", "", "visible", "setDotVisibility", "getSelectedStatus", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautifyTabItemView extends ConstraintLayout {
    public static final int g = 0;
    public final TextView a;
    public final View b;
    public final View c;
    public boolean d;
    public final View e;
    public final View f;

    public static final class a {
    }

    public BeautifyTabItemView(Context r3) {
        this(r3, false, false, 62);
    }

    static {
        g = (int) (s1.t() * 0.032f);
    }

    public final boolean getSelectedStatus() {
        return this.d;
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
    public BeautifyTabItemView(Context r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 16) == 0) goto L8;
        r5 = false;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        if (r4 == true) goto L13;
        if (r5 == true) goto L13;
        LayoutInflater.from(r3).inflate(2131565843, this);
    L14:
        TextView r7 = (TextView) findViewById(2131390975);
        this.a = r7;
        this.b = findViewById(2131370082);
        this.c = findViewById(2131375226);
        View r8 = findViewById(2131364594);
        this.e = r8;
        this.f = findViewById(2131366904);
        if (r5 == false) goto L25;
        if (r4 == true) goto L26;
        if (r8 == null) goto L19;
        a1.p(r8, 0);
    L19:
        int r9 = g;
        if (r7 == null) goto L22;
        a1.m(r7, r9);
    L22:
        if (r7 == null) goto L27;
        a1.n(r7, r9);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L13:
        LayoutInflater.from(r3).inflate(2131565842, this);
        goto L14
    }
}
