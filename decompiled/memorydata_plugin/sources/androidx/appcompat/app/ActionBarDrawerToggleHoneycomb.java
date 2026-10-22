package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = null;

    static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity r8) {
            Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r10 = r9.findViewById(R.id.home);
            if (r10 != null) goto L8;
            return;
        L8:
            ViewGroup r11 = (ViewGroup) ZeusTransformUtils.preCheckCast(r10.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
            if (r11.getChildCount() == 2) goto L11;
            return;
        L11:
            View r0 = r11.getChildAt(0);
            View r12 = r11.getChildAt(1);
            if (r0.getId() != 16908332) goto L15;
            r0 = r12;
        L15:
            if (ZeusTransformUtils.instanceOf(r0, ImageView.class) == false) goto L20;
            this.upIndicatorView = (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.memorydata.plugin");
            return;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity r2) {
        TypedArray r3 = ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(THEME_ATTRS);
        Drawable r0 = r3.getDrawable(0);
        r3.recycle();
        return r0;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo r3, Activity r4, int r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        r3 = new SetIndicatorInfo(r6);
    L6:
        if (r3.setHomeAsUpIndicator != null) goto L14;
    L13:
        return r3;
    L14:
        android.app.ActionBar r7 = r6.getActionBar();     // Catch: Exception -> L11
        r3.setHomeActionContentDescription.invoke(r7, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT > 19) goto L13;
        r7.setSubtitle(r7.getSubtitle());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        goto L13
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity r6, Drawable r7, int r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        SetIndicatorInfo r0 = new SetIndicatorInfo(r9);
        if (r0.setHomeAsUpIndicator == null) goto L9;
        android.app.ActionBar r10 = r9.getActionBar();     // Catch: Exception -> L6
        r0.setHomeAsUpIndicator.invoke(r10, new Object[]{r7});     // Catch: Exception -> L6
        r0.setHomeActionContentDescription.invoke(r10, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L6
    L12:
        return r0;
    L6:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
        goto L12
    L9:
        if (r0.upIndicatorView == null) goto L11;
        r0.upIndicatorView.setImageDrawable(r7);
        goto L12
    L11:
        Log.w(TAG, "Couldn't set home-as-up indicator");
        goto L12
    }
}
