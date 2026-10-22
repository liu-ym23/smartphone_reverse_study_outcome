package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean getIncludeFontPadding(TextView r0) {
            return r0.getIncludeFontPadding();
        }

        static int getMaxLines(TextView r0) {
            return r0.getMaxLines();
        }

        static int getMinLines(TextView r0) {
            return r0.getMinLines();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Drawable[] getCompoundDrawablesRelative(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }

        static int getLayoutDirection(View r0) {
            return r0.getLayoutDirection();
        }

        static int getTextDirection(View r0) {
            return r0.getTextDirection();
        }

        static Locale getTextLocale(TextView r0) {
            return r0.getTextLocale();
        }

        static void setCompoundDrawablesRelative(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelative(r1, r2, r3, r4);
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static void setTextDirection(View r0, int r1) {
            r0.setTextDirection(r1);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getBreakStrategy(TextView r0) {
            return r0.getBreakStrategy();
        }

        static ColorStateList getCompoundDrawableTintList(TextView r0) {
            return r0.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode getCompoundDrawableTintMode(TextView r0) {
            return r0.getCompoundDrawableTintMode();
        }

        static int getHyphenationFrequency(TextView r0) {
            return r0.getHyphenationFrequency();
        }

        static void setBreakStrategy(TextView r0, int r1) {
            r0.setBreakStrategy(r1);
        }

        static void setCompoundDrawableTintList(TextView r0, ColorStateList r1) {
            r0.setCompoundDrawableTintList(r1);
        }

        static void setCompoundDrawableTintMode(TextView r0, PorterDuff.Mode r1) {
            r0.setCompoundDrawableTintMode(r1);
        }

        static void setHyphenationFrequency(TextView r0, int r1) {
            r0.setHyphenationFrequency(r1);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static DecimalFormatSymbols getInstance(Locale r0) {
            return DecimalFormatSymbols.getInstance(r0);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static int getAutoSizeMaxTextSize(TextView r0) {
            return r0.getAutoSizeMaxTextSize();
        }

        static int getAutoSizeMinTextSize(TextView r0) {
            return r0.getAutoSizeMinTextSize();
        }

        static int getAutoSizeStepGranularity(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        static int[] getAutoSizeTextAvailableSizes(TextView r0) {
            return r0.getAutoSizeTextAvailableSizes();
        }

        static int getAutoSizeTextType(TextView r0) {
            return r0.getAutoSizeTextType();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }

        static void setAutoSizeTextTypeWithDefaults(TextView r0, int r1) {
            r0.setAutoSizeTextTypeWithDefaults(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence castToCharSequence(PrecomputedText r0) {
            return r0;
        }

        static String[] getDigitStrings(DecimalFormatSymbols r0) {
            return r0.getDigitStrings();
        }

        static PrecomputedText.Params getTextMetricsParams(TextView r0) {
            return r0.getTextMetricsParams();
        }

        static void setFirstBaselineToTopHeight(TextView r0, int r1) {
            r0.setFirstBaselineToTopHeight(r1);
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        public static void setLineHeight(TextView r0, int r1, float r2) {
            r0.setLineHeight(r1, r2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    private static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback r3, TextView r4) {
            this.mCallback = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
            this.mTextView = r4;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r2, TextView r3) {
            return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r3)).setClassName(r2.activityInfo.packageName, r2.activityInfo.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context r5, PackageManager r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            ArrayList r0 = new ArrayList();
            if (ZeusTransformUtils.instanceOf(r7, Activity.class) == true) goto L5;
            return r0;
        L5:
            Iterator<ResolveInfo> r8 = r6.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r8.hasNext() == false) goto L11;
            ResolveInfo r2 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r8.next(), ResolveInfo.class, "com.obric.memorydata.plugin");
            if (isSupportedActivity(r2, r7) == false) goto L7;
            r0.add(r2);
            goto L7
        L11:
            return r0;
        }

        private boolean isEditable(TextView r1) {
            if (ZeusTransformUtils.instanceOf(r1, Editable.class) == true) goto L5;
        L9:
            return false;
        L5:
            if (r1.onCheckIsTextEditor() == false) goto L9;
            if (r1.isEnabled() == false) goto L9;
            return true;
        }

        private boolean isSupportedActivity(ResolveInfo r3, Context r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            if (r2.getPackageName().equals(r3.activityInfo.packageName) == false) goto L6;
            return true;
        L6:
            if (r3.activityInfo.exported == true) goto L9;
            return false;
        L9:
            if (r3.activityInfo.permission != null) goto L11;
            return true;
        L11:
            if (r2.checkSelfPermission(r3.activityInfo.permission) != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private void recomputeProcessTextMenuItems(Menu r10) {
            Menu r11 = (Menu) ZeusTransformUtils.wrapperContextForParams(r10, Menu.class, "com.obric.memorydata.plugin");
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mTextView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            PackageManager r2 = r0.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L30;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r3 = ZeusTransformUtils.forName("com.android.internal.view.menu.MenuBuilder", "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r3;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r3.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L30:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r4 = r11.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r5 = r11.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r5 < 0) goto L22;
            MenuItem r7 = r11.getItem(r5);     // Catch: Throwable -> L27
            if (r7.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r7.getIntent().getAction()) == false) goto L21;
            r4.invoke(r11, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L27
        L21:
            r5 = r5 - 1;
            goto L15
        L22:
            List<ResolveInfo> r1 = getSupportedActivities(r0, r2);
            int r6 = 0;
        L24:
            if (r6 >= r1.size()) goto L37;
            ResolveInfo r8 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r1.get(r6), ResolveInfo.class, "com.obric.memorydata.plugin");
            r11.add(0, 0, r6 + 100, r8.loadLabel(r2)).setIntent(createProcessTextIntentForResolveInfo(r8, this.mTextView)).setShowAsAction(1);
            r6 = r6 + 1;
            goto L24
        L37:
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(this.mMenuBuilderClass, r11) == false) goto L13;
            r4 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r3, MenuItem r4) {
            MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
            return this.mCallback.onActionItemClicked(r3, r5);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            return this.mCallback.onCreateActionMode(r3, r5);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r1) {
            this.mCallback.onDestroyActionMode(r1);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
            recomputeProcessTextMenuItems(r5);
            return this.mCallback.onPrepareActionMode(r3, r5);
        }
    }

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMaxTextSize(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).getAutoSizeMaxTextSize();
    }

    public static int getAutoSizeMinTextSize(TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMinTextSize(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).getAutoSizeMinTextSize();
    }

    public static int getAutoSizeStepGranularity(TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeStepGranularity(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).getAutoSizeStepGranularity();
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextAvailableSizes(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == false) goto L11;
        return ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    }

    public static int getAutoSizeTextType(TextView r2) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextType(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == true) goto L9;
        return 0;
    L9:
        return ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).getAutoSizeTextType();
    }

    public static ColorStateList getCompoundDrawableTintList(TextView r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintList(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundDrawablesView.class) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) ZeusTransformUtils.preCheckCast(r2, TintableCompoundDrawablesView.class, "com.obric.memorydata.plugin")).getSupportCompoundDrawablesTintList();
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView r2) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintMode(r2);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundDrawablesView.class) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) ZeusTransformUtils.preCheckCast(r2, TintableCompoundDrawablesView.class, "com.obric.memorydata.plugin")).getSupportCompoundDrawablesTintMode();
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView r4) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return Api17Impl.getCompoundDrawablesRelative(r4);
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L17;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r4) == 1) goto L12;
        r1 = false;
    L12:
        Drawable[] r5 = r4.getCompoundDrawables();
        if (r1 == false) goto L15;
        Drawable r2 = r5[2];
        Drawable r3 = r5[0];
        r5[0] = r2;
        r5[2] = r3;
    L15:
        return r5;
    L17:
        return r4.getCompoundDrawables();
    }

    public static int getFirstBaselineToTopHeight(TextView r1) {
        return r1.getPaddingTop() - r1.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView r1) {
        return r1.getPaddingBottom() + r1.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(TextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMaxLines(r2);
    L7:
        if (sMaxModeFieldFetched == true) goto L9;
        sMaxModeField = retrieveField("mMaxMode");
        sMaxModeFieldFetched = true;
    L9:
        Field r0 = sMaxModeField;
        if (r0 != null) goto L12;
        return -1;
    L12:
        if (retrieveIntFromField(r0, r2) == 1) goto L14;
        return -1;
    L14:
        if (sMaximumFieldFetched == true) goto L16;
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
    L16:
        Field r1 = sMaximumField;
        if (r1 != null) goto L19;
        return -1;
    L19:
        return retrieveIntFromField(r1, r2);
    }

    public static int getMinLines(TextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinLines(r2);
    L7:
        if (sMinModeFieldFetched == true) goto L9;
        sMinModeField = retrieveField("mMinMode");
        sMinModeFieldFetched = true;
    L9:
        Field r0 = sMinModeField;
        if (r0 != null) goto L12;
        return -1;
    L12:
        if (retrieveIntFromField(r0, r2) == 1) goto L14;
        return -1;
    L14:
        if (sMinimumFieldFetched == true) goto L16;
        sMinimumField = retrieveField("mMinimum");
        sMinimumFieldFetched = true;
    L16:
        Field r1 = sMinimumField;
        if (r1 != null) goto L19;
        return -1;
    L19:
        return retrieveIntFromField(r1, r2);
    }

    private static int getTextDirection(TextDirectionHeuristic r2) {
        TextDirectionHeuristic r3 = (TextDirectionHeuristic) ZeusTransformUtils.wrapperContextForParams(r2, TextDirectionHeuristic.class, "com.obric.memorydata.plugin");
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
        return 1;
    L6:
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L9;
        return 1;
    L9:
        if (r3 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r3 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r3 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r3 != TextDirectionHeuristics.LOCALE) goto L25;
        return 5;
    L25:
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L29;
        return 6;
    L29:
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L32;
        return 7;
    L32:
        return 1;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView r4) {
        if (ZeusTransformUtils.instanceOf(r4.getTransformationMethod(), PasswordTransformationMethod.class) == true) goto L5;
        boolean r2 = false;
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if ((r4.getInputType() & 15) != 3) goto L20;
        byte r5 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(Api17Impl.getTextLocale(r4)))[0].codePointAt(0));
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L18;
        return TextDirectionHeuristics.LTR;
    L18:
        return TextDirectionHeuristics.RTL;
    L20:
        if (Api17Impl.getLayoutDirection(r4) != 1) goto L23;
        r2 = true;
    L23:
        switch(Api17Impl.getTextDirection(r4)) {
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            default: goto L24;
        };
    L24:
        if (r2 == false) goto L39;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L39:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L27:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L29:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L31:
        return TextDirectionHeuristics.LOCALE;
    L33:
        return TextDirectionHeuristics.RTL;
    L35:
        return TextDirectionHeuristics.LTR;
    L37:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L5:
        return TextDirectionHeuristics.LTR;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        PrecomputedTextCompat.Params.Builder r0 = new PrecomputedTextCompat.Params.Builder(new TextPaint(r3.getPaint()));
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0.setBreakStrategy(Api23Impl.getBreakStrategy(r3));
        r0.setHyphenationFrequency(Api23Impl.getHyphenationFrequency(r3));
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L13;
        r0.setTextDirection(getTextDirectionHeuristic(r3));
    L13:
        return r0.build();
    L5:
        return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(r3));
    }

    private static Field retrieveField(String r3) {
        Field r0 = null;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r0;
    L5:
        Log.e(LOG_TAG, "Could not retrieve " + r3 + " field.");
        return r0;
    }

    private static int retrieveIntFromField(Field r1, TextView r2) {
        return r1.getInt(r2);
    L4:
        Log.d(LOG_TAG, "Could not retrieve value of " + r1.getName() + " field.");
        return -1;
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r2, r3, r4, r5, r6);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == false) goto L10;
        ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).setAutoSizeTextTypeUniformWithConfiguration(r3, r4, r5, r6);
        return;
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r2, int[] r3, int r4) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r2, r3, r4);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == false) goto L10;
        ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).setAutoSizeTextTypeUniformWithPresetSizes(r3, r4);
        return;
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView r2, int r3) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeWithDefaults(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, AutoSizeableTextView.class) == false) goto L10;
        ((AutoSizeableTextView) ZeusTransformUtils.preCheckCast(r2, AutoSizeableTextView.class, "com.obric.memorydata.plugin")).setAutoSizeTextTypeWithDefaults(r3);
        return;
    }

    public static void setCompoundDrawableTintList(TextView r2, ColorStateList r3) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintList(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundDrawablesView.class) == false) goto L10;
        ((TintableCompoundDrawablesView) ZeusTransformUtils.preCheckCast(r2, TintableCompoundDrawablesView.class, "com.obric.memorydata.plugin")).setSupportCompoundDrawablesTintList(r3);
        return;
    }

    public static void setCompoundDrawableTintMode(TextView r2, PorterDuff.Mode r3) {
        Preconditions.checkNotNull(r2);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintMode(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, TintableCompoundDrawablesView.class) == false) goto L10;
        ((TintableCompoundDrawablesView) ZeusTransformUtils.preCheckCast(r2, TintableCompoundDrawablesView.class, "com.obric.memorydata.plugin")).setSupportCompoundDrawablesTintMode(r3);
        return;
    }

    public static void setCompoundDrawablesRelative(TextView r2, Drawable r3, Drawable r4, Drawable r5, Drawable r6) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelative(r2, r3, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L18;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        Drawable r0 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawables(r0, r4, r3, r6);
        return;
    L13:
        r0 = r3;
        goto L14
    L18:
        r2.setCompoundDrawables(r3, r4, r5, r6);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r2, int r3, int r4, int r5, int r6) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r2, r3, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L18;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        int r0 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawablesWithIntrinsicBounds(r0, r4, r3, r6);
        return;
    L13:
        r0 = r3;
        goto L14
    L18:
        r2.setCompoundDrawablesWithIntrinsicBounds(r3, r4, r5, r6);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r2, Drawable r3, Drawable r4, Drawable r5, Drawable r6) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r2, r3, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L18;
        boolean r1 = true;
        if (Api17Impl.getLayoutDirection(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        Drawable r0 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawablesWithIntrinsicBounds(r0, r4, r3, r6);
        return;
    L13:
        r0 = r3;
        goto L14
    L18:
        r2.setCompoundDrawablesWithIntrinsicBounds(r3, r4, r5, r6);
    }

    public static void setCustomSelectionActionModeCallback(TextView r2, ActionMode.Callback r3) {
        r2.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r2, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin")));
    }

    public static void setFirstBaselineToTopHeight(TextView r3, int r4) {
        Preconditions.checkArgumentNonnegative(r4);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setFirstBaselineToTopHeight(r3, r4);
        return;
    L6:
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) goto L9;
    L12:
        int r1 = r0.top;
    L14:
        if (r4 <= Math.abs(r1)) goto L17;
        int r5 = r4 + r1;
        r3.setPadding(r3.getPaddingLeft(), r5, r3.getPaddingRight(), r3.getPaddingBottom());
        return;
    L17:
        return;
    L9:
        if (Api16Impl.getIncludeFontPadding(r3) == true) goto L12;
        r1 = r0.ascent;
        goto L14
    }

    public static void setLastBaselineToBottomHeight(TextView r3, int r4) {
        Preconditions.checkArgumentNonnegative(r4);
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L8:
        int r1 = r0.bottom;
    L10:
        if (r4 <= Math.abs(r1)) goto L13;
        int r5 = r4 - r1;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r5);
        return;
    L13:
        return;
    L5:
        if (Api16Impl.getIncludeFontPadding(r3) == true) goto L8;
        r1 = r0.descent;
        goto L10
    }

    public static void setLineHeight(TextView r2, int r3) {
        Preconditions.checkArgumentNonnegative(r3);
        int r0 = r2.getPaint().getFontMetricsInt(null);
        if (r3 == r0) goto L6;
        r2.setLineSpacing(r3 - r0, 1.0f);
        return;
    }

    public static void setLineHeight(TextView r2, int r3, float r4) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setLineHeight(r2, r3, r4);
        return;
    L5:
        setLineHeight(r2, Math.round(TypedValue.applyDimension(r3, r4, ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics())));
    }

    public static void setPrecomputedText(TextView r2, PrecomputedTextCompat r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        CharSequence r4 = Api28Impl.castToCharSequence(r3.getPrecomputedText());
    L5:
        r2.setText(r4);
        return;
    L6:
        boolean r0 = getTextMetricsParams(r2).equalsWithoutTextDirection(r3.getParams());
        r4 = r3;
        if (r0 == true) goto L5;
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static void setTextAppearance(TextView r3, int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.setTextAppearance(r4);
        return;
    L5:
        r3.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    public static void setTextMetricsParams(TextView r2, PrecomputedTextCompat.Params r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api17Impl.setTextDirection(r2, getTextDirection(r3.getTextDirection()));
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        float r0 = r3.getTextPaint().getTextScaleX();
        r2.getPaint().set(r3.getTextPaint());
        if (r0 != r2.getTextScaleX()) goto L10;
        r2.setTextScaleX((r0 / 2.0f) + 1.0f);
    L10:
        r2.setTextScaleX(r0);
        return;
    L11:
        r2.getPaint().set(r3.getTextPaint());
        Api23Impl.setBreakStrategy(r2, r3.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(r2, r3.getHyphenationFrequency());
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, OreoCallback.class) == true) goto L5;
        return r4;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return r4;
    L7:
        return ((OreoCallback) ZeusTransformUtils.preCheckCast(r4, OreoCallback.class, "com.obric.memorydata.plugin")).getWrappedCallback();
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView r2, ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L12:
        return r4;
    L5:
        if (Build.VERSION.SDK_INT > 27) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, OreoCallback.class) == true) goto L12;
        if (r4 == null) goto L12;
        return new OreoCallback(r4, r2);
    }
}
