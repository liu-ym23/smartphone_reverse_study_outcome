package com.larksuite.component.universe_design.icon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J$\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\tH\u0007J\"\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007J,\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/universe_design/icon/UDIconUtils;", "", "<init>", "()V", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "drawableRes", "", "color", "size", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getIconDrawableByToken", "token", "", "translateTokenToIdentifier", "universe-ui-icon_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDIconUtils {
    public static final int $stable = 0;
    public static final UDIconUtils INSTANCE = null;

    static {
        INSTANCE = new UDIconUtils();
    }

    private UDIconUtils() {
    }

    private final String translateTokenToIdentifier(String r9) {
        return "ud_icon" + StringsKt.replace$default(r9, '-', '_', false, 4, null);
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Drawable r4 = AppCompatResources.getDrawable(r2, r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r3));
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "token");
        int r5 = r3.getResources().getIdentifier(INSTANCE.translateTokenToIdentifier(r4), "drawable", r3.getPackageName());
        if (r5 != 0) goto L7;
        return null;
    L7:
        return getIconDrawable(r3, r5);
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r1, int r2, UDDimension r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "size");
        Drawable r4 = getIconDrawable(r1, r2);
        r4.mutate();
        int r5 = (int) r3.toPixels(r1);
        r4.setBounds(0, 0, r5, r5);
        return r4;
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r1, String r2, UDDimension r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "size");
        Drawable r4 = getIconDrawableByToken(r1, r2);
        if (r4 == null) goto L5;
        r4.mutate();
        int r5 = (int) r3.toPixels(r1);
        r4.setBounds(0, 0, r5, r5);
        return r4;
    L5:
        return null;
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Drawable r4 = getIconDrawable(r1, r2);
        r4.mutate();
        r4.setTint(r3);
        return r4;
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "token");
        Drawable r4 = getIconDrawableByToken(r1, r2);
        if (r4 == null) goto L5;
        r4.mutate();
        r4.setTint(r3);
        return r4;
    L5:
        return null;
    }

    @JvmStatic
    public static final Drawable getIconDrawable(Context r1, int r2, int r3, UDDimension r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "size");
        Drawable r5 = getIconDrawable(r1, r2);
        r5.mutate();
        r5.setTint(r3);
        int r6 = (int) r4.toPixels(r1);
        r5.setBounds(0, 0, r6, r6);
        return r5;
    }

    @JvmStatic
    public static final Drawable getIconDrawableByToken(Context r1, String r2, int r3, UDDimension r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r4, "size");
        Drawable r5 = getIconDrawableByToken(r1, r2);
        if (r5 == null) goto L5;
        r5.mutate();
        r5.setTint(r3);
        int r6 = (int) r4.toPixels(r1);
        r5.setBounds(0, 0, r6, r6);
        return r5;
    L5:
        return null;
    }
}
