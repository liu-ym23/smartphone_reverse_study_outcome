package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SettingGroupDividerDrawable extends Drawable {
    public final Context a;
    public int b;
    public int c;
    public int d;
    public final Rect e;
    public final Lazy f;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return UIUtils.dp2px(this.a, 0.5f);
    }

    public SettingGroupDividerDrawable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.c = UIUtils.getColor(r2, 2131100548);
        invalidateSelf();
        this.d = UIUtils.getColor(r2, 2131103353);
        invalidateSelf();
        this.b = UIUtils.dp2px(r2, 16.0f);
        invalidateSelf();
        this.e = new Rect();
        this.f = LazyKt.lazy(SettingGroupDividerDrawable$paint$2.INSTANCE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        ((Paint) this.f.getValue()).setColor(this.c);
        r3.drawRect(getBounds(), (Paint) this.f.getValue());
        ((Paint) this.f.getValue()).setColor(this.d);
        if (this.e.isEmpty() == false) goto L5;
        return;
    L5:
        if (getBounds().contains(this.e) == false) goto L9;
        r3.drawRect(this.e, (Paint) this.f.getValue());
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r5) {
        Intrinsics.checkNotNullParameter(r5, "bounds");
        int r0 = r5.left + this.b;
        int r1 = r5.right + 0;
        this.e.set(r0, r5.top, r1, r5.bottom);
    }
}
