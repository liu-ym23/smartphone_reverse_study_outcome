package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
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

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static boolean getIncludeFontPadding(TextView r10) {
            return r10.getIncludeFontPadding();
        }

        @DoNotInline
        static int getMaxLines(TextView r10) {
            return r10.getMaxLines();
        }

        @DoNotInline
        static int getMinLines(TextView r10) {
            return r10.getMinLines();
        }
    }

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static Drawable[] getCompoundDrawablesRelative(TextView r10) {
            return r10.getCompoundDrawablesRelative();
        }

        @DoNotInline
        static int getLayoutDirection(View r10) {
            return r10.getLayoutDirection();
        }

        @DoNotInline
        static int getTextDirection(View r10) {
            return r10.getTextDirection();
        }

        @DoNotInline
        static Locale getTextLocale(TextView r10) {
            return r10.getTextLocale();
        }

        @DoNotInline
        static void setCompoundDrawablesRelative(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
            r10.setCompoundDrawablesRelative(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r10, int r11, int r12, int r13, int r14) {
            r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r10, Drawable r11, Drawable r12, Drawable r13, Drawable r14) {
            r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setTextDirection(View r10, int r11) {
            r10.setTextDirection(r11);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getBreakStrategy(TextView r10) {
            return r10.getBreakStrategy();
        }

        @DoNotInline
        static ColorStateList getCompoundDrawableTintList(TextView r10) {
            return r10.getCompoundDrawableTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getCompoundDrawableTintMode(TextView r10) {
            return r10.getCompoundDrawableTintMode();
        }

        @DoNotInline
        static int getHyphenationFrequency(TextView r10) {
            return r10.getHyphenationFrequency();
        }

        @DoNotInline
        static void setBreakStrategy(TextView r10, int r11) {
            r10.setBreakStrategy(r11);
        }

        @DoNotInline
        static void setCompoundDrawableTintList(TextView r10, ColorStateList r11) {
            r10.setCompoundDrawableTintList(r11);
        }

        @DoNotInline
        static void setCompoundDrawableTintMode(TextView r10, PorterDuff.Mode r11) {
            r10.setCompoundDrawableTintMode(r11);
        }

        @DoNotInline
        static void setHyphenationFrequency(TextView r10, int r11) {
            r10.setHyphenationFrequency(r11);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static DecimalFormatSymbols getInstance(Locale r10) {
            return DecimalFormatSymbols.getInstance(r10);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAutoSizeMaxTextSize(TextView r10) {
            return r10.getAutoSizeMaxTextSize();
        }

        @DoNotInline
        static int getAutoSizeMinTextSize(TextView r10) {
            return r10.getAutoSizeMinTextSize();
        }

        @DoNotInline
        static int getAutoSizeStepGranularity(TextView r10) {
            return r10.getAutoSizeStepGranularity();
        }

        @DoNotInline
        static int[] getAutoSizeTextAvailableSizes(TextView r10) {
            return r10.getAutoSizeTextAvailableSizes();
        }

        @DoNotInline
        static int getAutoSizeTextType(TextView r10) {
            return r10.getAutoSizeTextType();
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r10, int r11, int r12, int r13, int r14) {
            r10.setAutoSizeTextTypeUniformWithConfiguration(r11, r12, r13, r14);
        }

        @DoNotInline
        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r10, int[] r11, int r12) {
            r10.setAutoSizeTextTypeUniformWithPresetSizes(r11, r12);
        }

        @DoNotInline
        static void setAutoSizeTextTypeWithDefaults(TextView r10, int r11) {
            r10.setAutoSizeTextTypeWithDefaults(r11);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String[] getDigitStrings(DecimalFormatSymbols r10) {
            return r10.getDigitStrings();
        }

        @DoNotInline
        static PrecomputedText.Params getTextMetricsParams(TextView r10) {
            return r10.getTextMetricsParams();
        }

        @DoNotInline
        static void setFirstBaselineToTopHeight(TextView r10, int r11) {
            r10.setFirstBaselineToTopHeight(r11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    private static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback r10, TextView r11) {
            this.mCallback = r10;
            this.mTextView = r11;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r10, TextView r11) {
            Intent r12 = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r11));
            ActivityInfo r13 = r10.activityInfo;
            return r12.setClassName(r13.packageName, r13.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context r10, PackageManager r11) {
            ArrayList r12 = new ArrayList();
            if ((r10 instanceof Activity) == true) goto L5;
            return r12;
        L5:
            Iterator<ResolveInfo> r13 = r11.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r13.hasNext() == false) goto L11;
            ResolveInfo r14 = r13.next();
            if (isSupportedActivity(r14, r10) == false) goto L7;
            r12.add(r14);
            goto L7
        L11:
            return r12;
        }

        private boolean isEditable(TextView r10) {
            if ((r10 instanceof Editable) == true) goto L5;
        L9:
            return false;
        L5:
            if (r10.onCheckIsTextEditor() == false) goto L9;
            if (r10.isEnabled() == false) goto L9;
            return true;
        }

        private boolean isSupportedActivity(ResolveInfo r10, Context r11) {
            if (r11.getPackageName().equals(r10.activityInfo.packageName) == false) goto L5;
            return true;
        L5:
            ActivityInfo r12 = r10.activityInfo;
            if (r12.exported == true) goto L8;
            return false;
        L8:
            String r13 = r12.permission;
            if (r13 != null) goto L11;
            return true;
        L11:
            if (r11.checkSelfPermission(r13) != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private void recomputeProcessTextMenuItems(Menu r10) {
            Context r11 = this.mTextView.getContext();
            PackageManager r12 = r11.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L28;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r13 = Class.forName("com.android.internal.view.menu.MenuBuilder");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r13;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r13.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L28:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r14 = r10.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r15 = r10.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r15 < 0) goto L22;
            MenuItem r16 = r10.getItem(r15);     // Catch: Throwable -> L27
            if (r16.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r16.getIntent().getAction()) == false) goto L21;
            r14.invoke(r10, new Object[]{Integer.valueOf(r15)});     // Catch: Throwable -> L27
        L21:
            r15 = r15 - 1;
            goto L15
        L22:
            List<ResolveInfo> r17 = getSupportedActivities(r11, r12);
            int r18 = 0;
        L24:
            if (r18 >= r17.size()) goto L37;
            ResolveInfo r19 = r17.get(r18);
            r10.add(0, 0, r18 + 100, r19.loadLabel(r12)).setIntent(createProcessTextIntentForResolveInfo(r19, this.mTextView)).setShowAsAction(1);
            r18 = r18 + 1;
            goto L24
        L37:
            return;
        L11:
            if (this.mMenuBuilderClass.isInstance(r10) == false) goto L13;
            r14 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        @NonNull
        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r10, MenuItem r11) {
            return this.mCallback.onActionItemClicked(r10, r11);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r10, Menu r11) {
            return this.mCallback.onCreateActionMode(r10, r11);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r10) {
            this.mCallback.onDestroyActionMode(r10);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r10, Menu r11) {
            recomputeProcessTextMenuItems(r11);
            return this.mCallback.onPrepareActionMode(r10, r11);
        }
    }

    private TextViewCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMaxTextSize(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMaxTextSize(r10);
    L7:
        if ((r10 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r10).getAutoSizeMaxTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMinTextSize(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMinTextSize(r10);
    L7:
        if ((r10 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r10).getAutoSizeMinTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeStepGranularity(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeStepGranularity(r10);
    L7:
        if ((r10 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r10).getAutoSizeStepGranularity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextAvailableSizes(r10);
    L7:
        if ((r10 instanceof AutoSizeableTextView) == false) goto L11;
        return ((AutoSizeableTextView) r10).getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeTextType(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextType(r10);
    L7:
        if ((r10 instanceof AutoSizeableTextView) == true) goto L9;
        return 0;
    L9:
        return ((AutoSizeableTextView) r10).getAutoSizeTextType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintList(r10);
    L7:
        if ((r10 instanceof TintableCompoundDrawablesView) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) r10).getSupportCompoundDrawablesTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView r10) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintMode(r10);
    L7:
        if ((r10 instanceof TintableCompoundDrawablesView) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) r10).getSupportCompoundDrawablesTintMode();
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 18) goto L7;
        return Api17Impl.getCompoundDrawablesRelative(r10);
    L7:
        if (r11 < 17) goto L17;
        boolean r12 = true;
        if (Api17Impl.getLayoutDirection(r10) == 1) goto L12;
        r12 = false;
    L12:
        Drawable[] r13 = r10.getCompoundDrawables();
        if (r12 == false) goto L15;
        Drawable r14 = r13[2];
        Drawable r15 = r13[0];
        r13[0] = r14;
        r13[2] = r15;
    L15:
        return r13;
    L17:
        return r10.getCompoundDrawables();
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView r10) {
        return r10.getPaddingTop() - r10.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView r10) {
        return r10.getPaddingBottom() + r10.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMaxLines(r10);
    L7:
        if (sMaxModeFieldFetched == true) goto L9;
        sMaxModeField = retrieveField("mMaxMode");
        sMaxModeFieldFetched = true;
    L9:
        Field r11 = sMaxModeField;
        if (r11 != null) goto L12;
        return -1;
    L12:
        if (retrieveIntFromField(r11, r10) == 1) goto L14;
        return -1;
    L14:
        if (sMaximumFieldFetched == true) goto L16;
        sMaximumField = retrieveField("mMaximum");
        sMaximumFieldFetched = true;
    L16:
        Field r12 = sMaximumField;
        if (r12 != null) goto L19;
        return -1;
    L19:
        return retrieveIntFromField(r12, r10);
    }

    public static int getMinLines(@NonNull TextView r10) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.getMinLines(r10);
    L7:
        if (sMinModeFieldFetched == true) goto L9;
        sMinModeField = retrieveField("mMinMode");
        sMinModeFieldFetched = true;
    L9:
        Field r11 = sMinModeField;
        if (r11 != null) goto L12;
        return -1;
    L12:
        if (retrieveIntFromField(r11, r10) == 1) goto L14;
        return -1;
    L14:
        if (sMinimumFieldFetched == true) goto L16;
        sMinimumField = retrieveField("mMinimum");
        sMinimumFieldFetched = true;
    L16:
        Field r12 = sMinimumField;
        if (r12 != null) goto L19;
        return -1;
    L19:
        return retrieveIntFromField(r12, r10);
    }

    @RequiresApi(18)
    private static int getTextDirection(@NonNull TextDirectionHeuristic r10) {
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
        return 1;
    L6:
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L9;
        return 1;
    L9:
        if (r10 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r10 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r10 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r10 != TextDirectionHeuristics.LOCALE) goto L25;
        return 5;
    L25:
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L29;
        return 6;
    L29:
        if (r10 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L32;
        return 7;
    L32:
        return 1;
    }

    @RequiresApi(18)
    private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView r10) {
        if ((r10.getTransformationMethod() instanceof PasswordTransformationMethod) == true) goto L5;
        boolean r11 = false;
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if ((r10.getInputType() & 15) != 3) goto L20;
        byte r12 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(Api17Impl.getTextLocale(r10)))[0].codePointAt(0));
        if (r12 == 1) goto L18;
        if (r12 == 2) goto L18;
        return TextDirectionHeuristics.LTR;
    L18:
        return TextDirectionHeuristics.RTL;
    L20:
        if (Api17Impl.getLayoutDirection(r10) != 1) goto L23;
        r11 = true;
    L23:
        switch(Api17Impl.getTextDirection(r10)) {
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            default: goto L24;
        };
    L24:
        if (r11 == false) goto L39;
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

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 >= 28) goto L5;
        PrecomputedTextCompat.Params.Builder r12 = new PrecomputedTextCompat.Params.Builder(new TextPaint(r10.getPaint()));
        if (r11 < 23) goto L10;
        r12.setBreakStrategy(Api23Impl.getBreakStrategy(r10));
        r12.setHyphenationFrequency(Api23Impl.getHyphenationFrequency(r10));
    L10:
        if (r11 < 18) goto L13;
        r12.setTextDirection(getTextDirectionHeuristic(r10));
    L13:
        return r12.build();
    L5:
        return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(r10));
    }

    private static Field retrieveField(String r10) {
        Field r11 = null;
        r11 = TextView.class.getDeclaredField(r10);     // Catch: NoSuchFieldException -> L5
        r11.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r11;
    L5:
        Log.e(LOG_TAG, "Could not retrieve " + r10 + " field.");
        return r11;
    }

    private static int retrieveIntFromField(Field r10, TextView r11) {
        return r10.getInt(r11);
    L4:
        Log.d(LOG_TAG, "Could not retrieve value of " + r10.getName() + " field.");
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView r10, int r11, int r12, int r13, int r14) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13, r14);
        return;
    L6:
        if ((r10 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r10).setAutoSizeTextTypeUniformWithConfiguration(r11, r12, r13, r14);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView r10, @NonNull int[] r11, int r12) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11, r12);
        return;
    L6:
        if ((r10 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r10).setAutoSizeTextTypeUniformWithPresetSizes(r11, r12);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView r10, int r11) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeWithDefaults(r10, r11);
        return;
    L6:
        if ((r10 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r10).setAutoSizeTextTypeWithDefaults(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintList(@NonNull TextView r10, @Nullable ColorStateList r11) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintList(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintableCompoundDrawablesView) == false) goto L10;
        ((TintableCompoundDrawablesView) r10).setSupportCompoundDrawablesTintList(r11);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintMode(@NonNull TextView r10, @Nullable PorterDuff.Mode r11) {
        Preconditions.checkNotNull(r10);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintMode(r10, r11);
        return;
    L6:
        if ((r10 instanceof TintableCompoundDrawablesView) == false) goto L10;
        ((TintableCompoundDrawablesView) r10).setSupportCompoundDrawablesTintMode(r11);
        return;
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13, @Nullable Drawable r14) {
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelative(r10, r11, r12, r13, r14);
        return;
    L6:
        if (r15 < 17) goto L18;
        boolean r16 = true;
        if (Api17Impl.getLayoutDirection(r10) == 1) goto L11;
        r16 = false;
    L11:
        if (r16 == false) goto L13;
        Drawable r17 = r13;
    L14:
        if (r16 == true) goto L17;
        r11 = r13;
    L17:
        r10.setCompoundDrawables(r17, r12, r11, r14);
        return;
    L13:
        r17 = r11;
        goto L14
    L18:
        r10.setCompoundDrawables(r11, r12, r13, r14);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r10, @DrawableRes int r11, @DrawableRes int r12, @DrawableRes int r13, @DrawableRes int r14) {
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13, r14);
        return;
    L6:
        if (r15 < 17) goto L18;
        boolean r16 = true;
        if (Api17Impl.getLayoutDirection(r10) == 1) goto L11;
        r16 = false;
    L11:
        if (r16 == false) goto L13;
        int r17 = r13;
    L14:
        if (r16 == true) goto L17;
        r11 = r13;
    L17:
        r10.setCompoundDrawablesWithIntrinsicBounds(r17, r12, r11, r14);
        return;
    L13:
        r17 = r11;
        goto L14
    L18:
        r10.setCompoundDrawablesWithIntrinsicBounds(r11, r12, r13, r14);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13, @Nullable Drawable r14) {
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 18) goto L6;
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13, r14);
        return;
    L6:
        if (r15 < 17) goto L18;
        boolean r16 = true;
        if (Api17Impl.getLayoutDirection(r10) == 1) goto L11;
        r16 = false;
    L11:
        if (r16 == false) goto L13;
        Drawable r17 = r13;
    L14:
        if (r16 == true) goto L17;
        r11 = r13;
    L17:
        r10.setCompoundDrawablesWithIntrinsicBounds(r17, r12, r11, r14);
        return;
    L13:
        r17 = r11;
        goto L14
    L18:
        r10.setCompoundDrawablesWithIntrinsicBounds(r11, r12, r13, r14);
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView r10, @NonNull ActionMode.Callback r11) {
        r10.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r10, r11));
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView r10, @IntRange(from = 0) @Px int r11) {
        Preconditions.checkArgumentNonnegative(r11);
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 28) goto L6;
        Api28Impl.setFirstBaselineToTopHeight(r10, r11);
        return;
    L6:
        Paint.FontMetricsInt r13 = r10.getPaint().getFontMetricsInt();
        if (r12 >= 16) goto L9;
    L12:
        int r14 = r13.top;
    L14:
        if (r11 <= Math.abs(r14)) goto L17;
        int r15 = r11 + r14;
        r10.setPadding(r10.getPaddingLeft(), r15, r10.getPaddingRight(), r10.getPaddingBottom());
        return;
    L17:
        return;
    L9:
        if (Api16Impl.getIncludeFontPadding(r10) == true) goto L12;
        r14 = r13.ascent;
        goto L14
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView r10, @IntRange(from = 0) @Px int r11) {
        Preconditions.checkArgumentNonnegative(r11);
        Paint.FontMetricsInt r12 = r10.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L8:
        int r13 = r12.bottom;
    L10:
        if (r11 <= Math.abs(r13)) goto L13;
        int r14 = r11 - r13;
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r14);
        return;
    L13:
        return;
    L5:
        if (Api16Impl.getIncludeFontPadding(r10) == true) goto L8;
        r13 = r12.descent;
        goto L10
    }

    public static void setLineHeight(@NonNull TextView r10, @IntRange(from = 0) @Px int r11) {
        Preconditions.checkArgumentNonnegative(r11);
        int r12 = r10.getPaint().getFontMetricsInt(null);
        if (r11 == r12) goto L6;
        r10.setLineSpacing(r11 - r12, 1.0f);
        return;
    }

    public static void setPrecomputedText(@NonNull TextView r10, @NonNull PrecomputedTextCompat r11) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        PrecomputedTextCompat r12 = r11.getPrecomputedText();
    L5:
        r10.setText(r12);
        return;
    L6:
        boolean r13 = getTextMetricsParams(r10).equalsWithoutTextDirection(r11.getParams());
        r12 = r11;
        if (r13 == true) goto L5;
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static void setTextAppearance(@NonNull TextView r10, @StyleRes int r11) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r10.setTextAppearance(r11);
        return;
    L5:
        r10.setTextAppearance(r10.getContext(), r11);
    }

    public static void setTextMetricsParams(@NonNull TextView r10, @NonNull PrecomputedTextCompat.Params r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 18) goto L6;
        Api17Impl.setTextDirection(r10, getTextDirection(r11.getTextDirection()));
    L6:
        if (r12 >= 23) goto L11;
        float r13 = r11.getTextPaint().getTextScaleX();
        r10.getPaint().set(r11.getTextPaint());
        if (r13 != r10.getTextScaleX()) goto L10;
        r10.setTextScaleX((r13 / 2.0f) + 1.0f);
    L10:
        r10.setTextScaleX(r13);
        return;
    L11:
        r10.getPaint().set(r11.getTextPaint());
        Api23Impl.setBreakStrategy(r10, r11.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(r10, r11.getHyphenationFrequency());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r10) {
        if ((r10 instanceof OreoCallback) == true) goto L5;
        return r10;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return r10;
    L7:
        return ((OreoCallback) r10).getWrappedCallback();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView r10, @Nullable ActionMode.Callback r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 26) goto L5;
    L12:
        return r11;
    L5:
        if (r12 > 27) goto L12;
        if ((r11 instanceof OreoCallback) == true) goto L12;
        if (r11 == null) goto L12;
        return new OreoCallback(r11, r10);
    }
}
