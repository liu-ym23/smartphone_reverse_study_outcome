package com.bytedance.android.live.ktv.common.commonui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kb0.a;
import kb0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/commonui/CustomViewTab;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkb0/a;", "", "tabName", "", "setTabName", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomViewTab extends ConstraintLayout implements a {
    public final Map<String, View> a;
    public final c b;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomViewTab(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = new LinkedHashMap();
        c r0 = new c(r3);
        this.b = r0;
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        R5(r0, "TabTextView");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kb0.a
    public final void G5(int r3) {
        Intrinsics.checkNotNullParameter("YellowDotView", "customViewName");
        View r0 = getChildAt(indexOfChild((View) ((LinkedHashMap) this.a).get("YellowDotView")));
        if (r0 == null) goto L6;
        r0.setVisibility(r3);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kb0.a
    public final void c4(boolean r3) {
        this.b.a(false);
        if (r3 == false) goto L6;
        setBackgroundResource(2131238419);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kb0.a
    public final void onSelected(boolean r3) {
        this.b.a(true);
        if (r3 == false) goto L6;
        setBackgroundResource(2131238418);
        return;
    }

    @Override // kb0.a
    public void setTabName(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tabName");
        c r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "tabName");
        r1.setText(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "customView");
        Intrinsics.checkNotNullParameter(r3, "customViewName");
        removeView(r2);
        addView(r2);
        this.a.put(r3, r2);
    }
}
