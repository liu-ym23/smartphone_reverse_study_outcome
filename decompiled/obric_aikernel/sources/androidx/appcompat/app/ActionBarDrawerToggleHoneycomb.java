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
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = null;

    static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(Activity r10) {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r11 = r10.findViewById(R.id.home);
            if (r11 != null) goto L8;
            return;
        L8:
            ViewGroup r12 = (ViewGroup) r11.getParent();
            if (r12.getChildCount() == 2) goto L11;
            return;
        L11:
            View r13 = r12.getChildAt(0);
            View r14 = r12.getChildAt(1);
            if (r13.getId() != 16908332) goto L15;
            r13 = r14;
        L15:
            if ((r13 instanceof ImageView) == false) goto L20;
            this.upIndicatorView = (ImageView) r13;
            return;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity r10) {
        TypedArray r11 = r10.obtainStyledAttributes(THEME_ATTRS);
        Drawable r12 = r11.getDrawable(0);
        r11.recycle();
        return r12;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo r10, Activity r11, int r12) {
        if (r10 != null) goto L5;
        r10 = new SetIndicatorInfo(r11);
    L5:
        if (r10.setHomeAsUpIndicator != null) goto L13;
    L12:
        return r10;
    L13:
        android.app.ActionBar r13 = r11.getActionBar();     // Catch: Exception -> L10
        r10.setHomeActionContentDescription.invoke(r13, new Object[]{Integer.valueOf(r12)});     // Catch: Exception -> L10
        if (Build.VERSION.SDK_INT > 19) goto L12;
        r13.setSubtitle(r13.getSubtitle());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        goto L12
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity r10, Drawable r11, int r12) {
        SetIndicatorInfo r13 = new SetIndicatorInfo(r10);
        if (r13.setHomeAsUpIndicator != null) goto L13;
        ImageView r14 = r13.upIndicatorView;
        if (r14 == null) goto L11;
        r14.setImageDrawable(r11);
    L12:
        return r13;
    L11:
        Log.w(TAG, "Couldn't set home-as-up indicator");
        goto L12
    L13:
        android.app.ActionBar r15 = r10.getActionBar();     // Catch: Exception -> L6
        r13.setHomeAsUpIndicator.invoke(r15, new Object[]{r11});     // Catch: Exception -> L6
        r13.setHomeActionContentDescription.invoke(r15, new Object[]{Integer.valueOf(r12)});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
        goto L12
    }
}
