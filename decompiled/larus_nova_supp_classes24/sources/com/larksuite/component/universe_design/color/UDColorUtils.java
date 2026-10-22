package com.larksuite.component.universe_design.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import androidx.collection.LruCache;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u000bH\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u000bH\u0007J$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0017\u001a\u00020\u000bH\u0007J\u001e\u0010\u0018\u001a\u00020\u000b2\n\u0010\u0019\u001a\u00060\u001aR\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u000bH\u0007J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u001fH\u0007J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/larksuite/component/universe_design/color/UDColorUtils;", "", "<init>", "()V", "sTmpValue", "Landroid/util/TypedValue;", "getSTmpValue", "()Landroid/util/TypedValue;", "sTmpValue$delegate", "Lkotlin/Lazy;", "getAlphaColor", "", "baseColor", "alpha", "", "context", "Landroid/content/Context;", "baseColorId", "getColor", "getColorStateList", "Landroid/content/res/ColorStateList;", "colorId", "getAttrAlphaColor", "attrRes", "getAttrColor", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "attr", "tokenIdCache", "Landroidx/collection/LruCache;", "", "getTokenIdCache", "()Landroidx/collection/LruCache;", "tokenIdCache$delegate", "getColorIdByToken", "token", "convertToken", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDColorUtils {
    public static final int $stable = 0;
    public static final UDColorUtils INSTANCE = null;
    private static final Lazy sTmpValue$delegate = null;
    private static final Lazy tokenIdCache$delegate = null;

    private UDColorUtils() {
    }

    static {
        INSTANCE = new UDColorUtils();
        sTmpValue$delegate = LazyKt.lazy(UDColorUtils$sTmpValue$2.INSTANCE);
        tokenIdCache$delegate = LazyKt.lazy(UDColorUtils$tokenIdCache$2.INSTANCE);
        $stable = 8;
    }

    private final TypedValue getSTmpValue() {
        return (TypedValue) sTmpValue$delegate.getValue();
    }

    private final LruCache<String, Integer> getTokenIdCache() {
        return (LruCache) tokenIdCache$delegate.getValue();
    }

    @JvmStatic
    private static final String convertToken(String r6) {
        return StringsKt.replace$default(r6, "-", "_", false, 4, null);
    }

    @JvmStatic
    public static final int getAlphaColor(int r2, float r3) {
        return Color.argb((int) (255 * r3), Color.red(r2), Color.green(r2), Color.blue(r2));
    }

    @JvmStatic
    public static final int getAttrColor(Resources.Theme r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "theme");
        UDColorUtils r0 = INSTANCE;
        if (r3.resolveAttribute(r4, r0.getSTmpValue(), true) == true) goto L7;
        return 0;
    L7:
        if (r0.getSTmpValue().type != 2) goto L10;
        return getAttrColor(r3, r0.getSTmpValue().data);
    L10:
        return r0.getSTmpValue().data;
    }

    @JvmStatic
    public static final int getColor(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return r1.getResources().getColor(r2);
    }

    @JvmStatic
    public static final int getColorIdByToken(Context r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "token");
        UDColorUtils r0 = INSTANCE;
        Integer r1 = (Integer) r0.getTokenIdCache().get(r5);
        if (r1 != null) goto L5;
        String r2 = convertToken(r5);
        String r3 = r4.getPackageName();
        int r6 = r4.getResources().getIdentifier(r2, "color", r3);
        r0.getTokenIdCache().put(r5, Integer.valueOf(r6));
        return r6;
    L5:
        return r1.intValue();
    }

    @JvmStatic
    public static final ColorStateList getColorStateList(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        ColorStateList r4 = r2.getResources().getColorStateList(r3, r2.getTheme());
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        ColorStateList r5 = r2.getResources().getColorStateList(r3);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    @JvmStatic
    public static final int getAttrColor(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return getAttrColor(r1.getTheme(), r2);
    }

    @JvmStatic
    public static final int getAlphaColor(Context r1, int r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return getAlphaColor(r1.getResources().getColor(r2), r3);
    }

    @JvmStatic
    public static final int getAttrAlphaColor(Context r1, int r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return getAlphaColor(getAttrColor(r1, r2), r3);
    }
}
