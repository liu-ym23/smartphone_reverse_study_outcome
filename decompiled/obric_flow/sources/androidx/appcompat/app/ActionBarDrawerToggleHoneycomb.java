package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHC";
    private static final int[] THEME_ATTRS = null;

    public static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        public SetIndicatorInfo(Activity r5) {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r10 = r5.findViewById(R.id.home);
            if (r10 != null) goto L8;
            return;
        L8:
            ViewGroup r11 = (ViewGroup) r10.getParent();
            if (r11.getChildCount() == 2) goto L11;
            return;
        L11:
            View r12 = r11.getChildAt(0);
            View r13 = r11.getChildAt(1);
            if (r12.getId() != 16908332) goto L15;
            r12 = r13;
        L15:
            if ((r12 instanceof ImageView) == false) goto L20;
            this.upIndicatorView = (ImageView) r12;
            return;
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    private ActionBarDrawerToggleHoneycomb() {
    }

    public static Drawable getThemeUpIndicator(Activity r5) {
        TypedArray r10 = r5.obtainStyledAttributes(THEME_ATTRS);
        Drawable r11 = r10.getDrawable(0);
        r10.recycle();
        return r11;
    }

    public static SetIndicatorInfo setActionBarDescription(SetIndicatorInfo r5, Activity r10, int r11) {
        if (r5 != null) goto L5;
        r5 = new SetIndicatorInfo(r10);
    L5:
        if (r5.setHomeAsUpIndicator != null) goto L11;
    L10:
        return r5;
    L11:
        android.app.ActionBar r12 = r10.getActionBar();     // Catch: Exception -> L8
        r5.setHomeActionContentDescription.invoke(r12, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        goto L10
    }

    public static SetIndicatorInfo setActionBarUpIndicator(Activity r5, Drawable r10, int r11) {
        SetIndicatorInfo r12 = new SetIndicatorInfo(r5);
        if (r12.setHomeAsUpIndicator != null) goto L13;
        ImageView r13 = r12.upIndicatorView;
        if (r13 == null) goto L11;
        r13.setImageDrawable(r10);
    L12:
        return r12;
    L11:
        Log.w(TAG, "Couldn't set home-as-up indicator");
        goto L12
    L13:
        android.app.ActionBar r14 = r5.getActionBar();     // Catch: Exception -> L6
        r12.setHomeAsUpIndicator.invoke(r14, new Object[]{r10});     // Catch: Exception -> L6
        r12.setHomeActionContentDescription.invoke(r14, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
        goto L12
    }
}
