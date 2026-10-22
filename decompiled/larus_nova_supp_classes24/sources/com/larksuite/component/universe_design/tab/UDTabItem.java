package com.larksuite.component.universe_design.tab;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0000X\u0081\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabItem;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "title", "", "getTitle$universe_ui_tab_release", "()Ljava/lang/CharSequence;", "icon", "Landroid/graphics/drawable/Drawable;", "getIcon$universe_ui_tab_release", "()Landroid/graphics/drawable/Drawable;", "customView", "", "getCustomView$universe_ui_tab_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDTabItem extends View {
    public final CharSequence a;
    public final Drawable b;
    public final Integer c;

    public final Integer getCustomView$universe_ui_tab_release() {
        return this.c;
    }

    public final Drawable getIcon$universe_ui_tab_release() {
        return this.b;
    }

    public final CharSequence getTitle$universe_ui_tab_release() {
        return this.a;
    }

    public UDTabItem(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public UDTabItem(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        TypedArray r4 = r2.obtainStyledAttributes(r3, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.a = r4.getText(2);
        this.b = r4.getDrawable(0);
        this.c = Integer.valueOf(r4.getResourceId(1, 0));
        r4.recycle();
    }
}
