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
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int getBreakStrategy(TextView r5) {
            return r5.getBreakStrategy();
        }

        @DoNotInline
        public static ColorStateList getCompoundDrawableTintList(TextView r5) {
            return r5.getCompoundDrawableTintList();
        }

        @DoNotInline
        public static PorterDuff.Mode getCompoundDrawableTintMode(TextView r5) {
            return r5.getCompoundDrawableTintMode();
        }

        @DoNotInline
        public static int getHyphenationFrequency(TextView r5) {
            return r5.getHyphenationFrequency();
        }

        @DoNotInline
        public static void setBreakStrategy(TextView r5, int r10) {
            r5.setBreakStrategy(r10);
        }

        @DoNotInline
        public static void setCompoundDrawableTintList(TextView r5, ColorStateList r10) {
            r5.setCompoundDrawableTintList(r10);
        }

        @DoNotInline
        public static void setCompoundDrawableTintMode(TextView r5, PorterDuff.Mode r10) {
            r5.setCompoundDrawableTintMode(r10);
        }

        @DoNotInline
        public static void setHyphenationFrequency(TextView r5, int r10) {
            r5.setHyphenationFrequency(r10);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static DecimalFormatSymbols getInstance(Locale r5) {
            return DecimalFormatSymbols.getInstance(r5);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static int getAutoSizeMaxTextSize(TextView r5) {
            return r5.getAutoSizeMaxTextSize();
        }

        @DoNotInline
        public static int getAutoSizeMinTextSize(TextView r5) {
            return r5.getAutoSizeMinTextSize();
        }

        @DoNotInline
        public static int getAutoSizeStepGranularity(TextView r5) {
            return r5.getAutoSizeStepGranularity();
        }

        @DoNotInline
        public static int[] getAutoSizeTextAvailableSizes(TextView r5) {
            return r5.getAutoSizeTextAvailableSizes();
        }

        @DoNotInline
        public static int getAutoSizeTextType(TextView r5) {
            return r5.getAutoSizeTextType();
        }

        @DoNotInline
        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView r5, int r10, int r11, int r12, int r13) {
            r5.setAutoSizeTextTypeUniformWithConfiguration(r10, r11, r12, r13);
        }

        @DoNotInline
        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r5, int[] r10, int r11) {
            r5.setAutoSizeTextTypeUniformWithPresetSizes(r10, r11);
        }

        @DoNotInline
        public static void setAutoSizeTextTypeWithDefaults(TextView r5, int r10) {
            r5.setAutoSizeTextTypeWithDefaults(r10);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static CharSequence castToCharSequence(PrecomputedText r5) {
            return r5;
        }

        @DoNotInline
        public static String[] getDigitStrings(DecimalFormatSymbols r5) {
            return r5.getDigitStrings();
        }

        @DoNotInline
        public static PrecomputedText.Params getTextMetricsParams(TextView r5) {
            return r5.getTextMetricsParams();
        }

        @DoNotInline
        public static void setFirstBaselineToTopHeight(TextView r5, int r10) {
            r5.setFirstBaselineToTopHeight(r10);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static void setLineHeight(@NonNull TextView r5, int r10, @FloatRange(from = 0.0d) float r11) {
            r5.setLineHeight(r10, r11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface AutoSizeTextType {
    }

    @RequiresApi(26)
    public static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        public OreoCallback(ActionMode.Callback r5, TextView r10) {
            this.mCallback = r5;
            this.mTextView = r10;
            this.mInitializedMenuBuilderReferences = false;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r5, TextView r10) {
            Intent r11 = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r10));
            ActivityInfo r12 = r5.activityInfo;
            return r11.setClassName(r12.packageName, r12.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context r5, PackageManager r10) {
            ArrayList r11 = new ArrayList();
            if ((r5 instanceof Activity) == true) goto L5;
            return r11;
        L5:
            Iterator<ResolveInfo> r12 = r10.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r12.hasNext() == false) goto L11;
            ResolveInfo r13 = r12.next();
            if (isSupportedActivity(r13, r5) == false) goto L7;
            r11.add(r13);
            goto L7
        L11:
            return r11;
        }

        private boolean isEditable(TextView r5) {
            if ((r5 instanceof Editable) == true) goto L5;
        L9:
            return false;
        L5:
            if (r5.onCheckIsTextEditor() == false) goto L9;
            if (r5.isEnabled() == false) goto L9;
            return true;
        }

        private boolean isSupportedActivity(ResolveInfo r5, Context r10) {
            if (r10.getPackageName().equals(r5.activityInfo.packageName) == false) goto L5;
            return true;
        L5:
            ActivityInfo r11 = r5.activityInfo;
            if (r11.exported == true) goto L8;
            return false;
        L8:
            String r12 = r11.permission;
            if (r12 != null) goto L11;
            return true;
        L11:
            if (r10.checkSelfPermission(r12) != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private void recomputeProcessTextMenuItems(Menu r10) {
            Context r5 = this.mTextView.getContext();
            PackageManager r11 = r5.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L28;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r12 = Class.forName("com.android.internal.view.menu.MenuBuilder");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r12;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r12.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L28:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r13 = r10.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r14 = r10.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r14 < 0) goto L22;
            MenuItem r15 = r10.getItem(r14);     // Catch: Throwable -> L27
            if (r15.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r15.getIntent().getAction()) == false) goto L21;
            r13.invoke(r10, new Object[]{Integer.valueOf(r14)});     // Catch: Throwable -> L27
        L21:
            r14 = r14 - 1;
            goto L15
        L22:
            List<ResolveInfo> r16 = getSupportedActivities(r5, r11);
            int r17 = 0;
        L24:
            if (r17 >= r16.size()) goto L37;
            ResolveInfo r18 = r16.get(r17);
            r10.add(0, 0, r17 + 100, r18.loadLabel(r11)).setIntent(createProcessTextIntentForResolveInfo(r18, this.mTextView)).setShowAsAction(1);
            r17 = r17 + 1;
            goto L24
        L37:
            return;
        L11:
            if (this.mMenuBuilderClass.isInstance(r10) == false) goto L13;
            r13 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        @NonNull
        public ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r5, MenuItem r10) {
            return this.mCallback.onActionItemClicked(r5, r10);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r5, Menu r10) {
            return this.mCallback.onCreateActionMode(r5, r10);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r5) {
            this.mCallback.onDestroyActionMode(r5);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r5, Menu r10) {
            recomputeProcessTextMenuItems(r10);
            return this.mCallback.onPrepareActionMode(r5, r10);
        }
    }

    private TextViewCompat() {
    }

    public static int getAutoSizeMaxTextSize(@NonNull TextView r5) {
        return Api26Impl.getAutoSizeMaxTextSize(r5);
    }

    public static int getAutoSizeMinTextSize(@NonNull TextView r5) {
        return Api26Impl.getAutoSizeMinTextSize(r5);
    }

    public static int getAutoSizeStepGranularity(@NonNull TextView r5) {
        return Api26Impl.getAutoSizeStepGranularity(r5);
    }

    @NonNull
    public static int[] getAutoSizeTextAvailableSizes(@NonNull TextView r5) {
        return Api26Impl.getAutoSizeTextAvailableSizes(r5);
    }

    public static int getAutoSizeTextType(@NonNull TextView r5) {
        return Api26Impl.getAutoSizeTextType(r5);
    }

    @Nullable
    public static ColorStateList getCompoundDrawableTintList(@NonNull TextView r5) {
        Preconditions.checkNotNull(r5);
        return Api23Impl.getCompoundDrawableTintList(r5);
    }

    @Nullable
    public static PorterDuff.Mode getCompoundDrawableTintMode(@NonNull TextView r5) {
        Preconditions.checkNotNull(r5);
        return Api23Impl.getCompoundDrawableTintMode(r5);
    }

    @NonNull
    public static Drawable[] getCompoundDrawablesRelative(@NonNull TextView r5) {
        return r5.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(@NonNull TextView r5) {
        return r5.getPaddingTop() - r5.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(@NonNull TextView r5) {
        return r5.getPaddingBottom() + r5.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(@NonNull TextView r5) {
        return r5.getMaxLines();
    }

    public static int getMinLines(@NonNull TextView r5) {
        return r5.getMinLines();
    }

    private static int getTextDirection(@NonNull TextDirectionHeuristic r5) {
        TextDirectionHeuristic r10 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (r5 != r10) goto L5;
        return 1;
    L5:
        TextDirectionHeuristic r11 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (r5 != r11) goto L9;
        return 1;
    L9:
        if (r5 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r5 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r5 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r5 != TextDirectionHeuristics.LOCALE) goto L24;
        return 5;
    L24:
        if (r5 != r11) goto L27;
        return 6;
    L27:
        if (r5 != r10) goto L30;
        return 7;
    L30:
        return 1;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(@NonNull TextView r5) {
        if ((r5.getTransformationMethod() instanceof PasswordTransformationMethod) == true) goto L5;
        boolean r10 = true;
        if ((r5.getInputType() & 15) != 3) goto L18;
        byte r11 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(r5.getTextLocale()))[0].codePointAt(0));
        if (r11 == 1) goto L16;
        if (r11 == 2) goto L16;
        return TextDirectionHeuristics.LTR;
    L16:
        return TextDirectionHeuristics.RTL;
    L18:
        if (r5.getLayoutDirection() == 1) goto L22;
        r10 = false;
    L22:
        switch(r5.getTextDirection()) {
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L28;
            default: goto L23;
        };
    L23:
        if (r10 == false) goto L26;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L26:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L28:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L30:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L32:
        return TextDirectionHeuristics.LOCALE;
    L34:
        return TextDirectionHeuristics.RTL;
    L36:
        return TextDirectionHeuristics.LTR;
    L38:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L5:
        return TextDirectionHeuristics.LTR;
    }

    @NonNull
    public static PrecomputedTextCompat.Params getTextMetricsParams(@NonNull TextView r5) {
        return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(r5));
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(@NonNull TextView r5, int r10, int r11, int r12, int r13) throws IllegalArgumentException {
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r5, r10, r11, r12, r13);
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull TextView r5, @NonNull int[] r10, int r11) throws IllegalArgumentException {
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r5, r10, r11);
    }

    public static void setAutoSizeTextTypeWithDefaults(@NonNull TextView r5, int r10) {
        Api26Impl.setAutoSizeTextTypeWithDefaults(r5, r10);
    }

    public static void setCompoundDrawableTintList(@NonNull TextView r5, @Nullable ColorStateList r10) {
        Preconditions.checkNotNull(r5);
        Api23Impl.setCompoundDrawableTintList(r5, r10);
    }

    public static void setCompoundDrawableTintMode(@NonNull TextView r5, @Nullable PorterDuff.Mode r10) {
        Preconditions.checkNotNull(r5);
        Api23Impl.setCompoundDrawableTintMode(r5, r10);
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        r5.setCompoundDrawablesRelative(r10, r11, r12, r13);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r5, @Nullable Drawable r10, @Nullable Drawable r11, @Nullable Drawable r12, @Nullable Drawable r13) {
        r5.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
    }

    public static void setCustomSelectionActionModeCallback(@NonNull TextView r5, @NonNull ActionMode.Callback r10) {
        r5.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r5, r10));
    }

    public static void setFirstBaselineToTopHeight(@NonNull TextView r5, @IntRange(from = 0) @Px int r10) {
        Preconditions.checkArgumentNonnegative(r10);
        Api28Impl.setFirstBaselineToTopHeight(r5, r10);
    }

    public static void setLastBaselineToBottomHeight(@NonNull TextView r5, @IntRange(from = 0) @Px int r10) {
        Preconditions.checkArgumentNonnegative(r10);
        Paint.FontMetricsInt r11 = r5.getPaint().getFontMetricsInt();
        if (r5.getIncludeFontPadding() == false) goto L5;
        int r12 = r11.bottom;
    L7:
        if (r10 <= Math.abs(r12)) goto L10;
        int r13 = r10 - r12;
        r5.setPadding(r5.getPaddingLeft(), r5.getPaddingTop(), r5.getPaddingRight(), r13);
        return;
    L10:
        return;
    L5:
        r12 = r11.descent;
        goto L7
    }

    public static void setLineHeight(@NonNull TextView r5, @IntRange(from = 0) @Px int r10) {
        Preconditions.checkArgumentNonnegative(r10);
        int r11 = r5.getPaint().getFontMetricsInt(null);
        if (r10 == r11) goto L6;
        r5.setLineSpacing(r10 - r11, 1.0f);
        return;
    }

    public static void setPrecomputedText(@NonNull TextView r5, @NonNull PrecomputedTextCompat r10) {
        r5.setText(Api28Impl.castToCharSequence(r10.getPrecomputedText()));
    }

    public static void setTextAppearance(@NonNull TextView r5, @StyleRes int r10) {
        r5.setTextAppearance(r10);
    }

    public static void setTextMetricsParams(@NonNull TextView r5, @NonNull PrecomputedTextCompat.Params r10) {
        r5.setTextDirection(getTextDirection(r10.getTextDirection()));
        r5.getPaint().set(r10.getTextPaint());
        Api23Impl.setBreakStrategy(r5, r10.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(r5, r10.getHyphenationFrequency());
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(@Nullable ActionMode.Callback r5) {
        if ((r5 instanceof OreoCallback) == true) goto L5;
        return r5;
    L5:
        return ((OreoCallback) r5).getWrappedCallback();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(@NonNull TextView r5, @Nullable ActionMode.Callback r10) {
        return r10;
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView r5, @DrawableRes int r10, @DrawableRes int r11, @DrawableRes int r12, @DrawableRes int r13) {
        r5.setCompoundDrawablesRelativeWithIntrinsicBounds(r10, r11, r12, r13);
    }

    public static void setLineHeight(@NonNull TextView r5, int r10, @FloatRange(from = 0.0d) float r11) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setLineHeight(r5, r10, r11);
        return;
    L5:
        setLineHeight(r5, Math.round(TypedValue.applyDimension(r10, r11, r5.getResources().getDisplayMetrics())));
    }
}
