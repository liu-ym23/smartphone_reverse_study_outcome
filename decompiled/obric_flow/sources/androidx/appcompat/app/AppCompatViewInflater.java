package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final int[] sAccessibilityHeading = null;
    private static final int[] sAccessibilityPaneTitle = null;
    private static final String[] sClassPrefixList = null;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = null;
    private static final Class<?>[] sConstructorSignature = null;
    private static final int[] sOnClickAttrs = null;
    private static final int[] sScreenReaderFocusable = null;
    private final Object[] mConstructorArgs;

    public static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(@NonNull View r5, @NonNull String r10) {
            this.mHostView = r5;
            this.mMethodName = r10;
        }

        private void resolveMethod(@Nullable Context r5) {
        L2:
            if (r5 == null) goto L13;
            if (r5.isRestricted() == true) goto L10;
            Method r10 = r5.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L19
            if (r10 == null) goto L10;
            this.mResolvedMethod = r10;     // Catch: NoSuchMethodException -> L19
            this.mResolvedContext = r5;     // Catch: NoSuchMethodException -> L19
            return;
        L10:
            if ((r5 instanceof ContextWrapper) == true) goto L11;
            r5 = null;
            goto L2
        L11:
            r5 = ((ContextWrapper) r5).getBaseContext();
            goto L2
        L13:
            int r11 = this.mHostView.getId();
            if (r11 != (-1)) goto L16;
            String r12 = "";
        L18:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r12);
        L16:
            r12 = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(r11) + "'";
            goto L18
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View r5) {
            if (this.mResolvedMethod != null) goto L15;
            resolveMethod(this.mHostView.getContext());
        L15:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r5});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
            return;
        L9:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L7:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }
    }

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{R.attr.onClick};
        sAccessibilityHeading = new int[]{R.attr.accessibilityHeading};
        sAccessibilityPaneTitle = new int[]{R.attr.accessibilityPaneTitle};
        sScreenReaderFocusable = new int[]{R.attr.screenReaderFocusable};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    public AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }

    private void backportAccessibilityAttributes(@NonNull Context r5, @NonNull View r10, @NonNull AttributeSet r11) {
    }

    private void checkOnClickListener(View r5, AttributeSet r10) {
        Context r11 = r5.getContext();
        if ((r11 instanceof ContextWrapper) == true) goto L5;
        return;
    L5:
        if (ViewCompat.hasOnClickListeners(r5) == false) goto L13;
        TypedArray r12 = r11.obtainStyledAttributes(r10, sOnClickAttrs);
        String r13 = r12.getString(0);
        if (r13 == null) goto L10;
        r5.setOnClickListener(new DeclaredOnClickListener(r5, r13));
    L10:
        r12.recycle();
        return;
    }

    private View createViewByPrefix(Context r5, String r10, String r11) throws ClassNotFoundException, InflateException {
        SimpleArrayMap<String, Constructor<? extends View>> r12 = sConstructorMap;
        Constructor<? extends View> r13 = r12.get(r10);
        if (r13 != null) goto L8;
        if (r11 != null) goto L12;
        String r14 = r10;
    L7:
        r13 = Class.forName(r14, false, r5.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);     // Catch: Exception -> L10
        r12.put(r10, r13);     // Catch: Exception -> L10
        goto L8
    L12:
        r14 = r11 + r10;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r13.setAccessible(true);     // Catch: Exception -> L10
        return r13.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context r10, String r11, AttributeSet r12) {
        if (r11.equals("view") == false) goto L27;
        r11 = r12.getAttributeValue(null, "class");
    L27:
        Object[] r5 = this.mConstructorArgs;     // Catch: Throwable -> L16 Exception -> L25
        r5[0] = r10;     // Catch: Throwable -> L16 Exception -> L25
        r5[1] = r12;     // Catch: Throwable -> L16 Exception -> L25
        if ((-1) != r11.indexOf(46)) goto L20;
        int r13 = 0;
    L9:
        String[] r14 = sClassPrefixList;     // Catch: Throwable -> L16 Exception -> L25
        if (r13 >= r14.length) goto L18;
        View r15 = createViewByPrefix(r10, r11, r14[r13]);     // Catch: Throwable -> L16 Exception -> L25
        if (r15 != null) goto L13;
        r13 = r13 + 1;
        goto L9
    L13:
        Object[] r16 = this.mConstructorArgs;
        r16[0] = null;
        r16[1] = null;
        return r15;
    L18:
        Object[] r17 = this.mConstructorArgs;
        r17[0] = null;
        r17[1] = null;
        return null;
    L20:
        View r18 = createViewByPrefix(r10, r11, null);     // Catch: Throwable -> L16 Exception -> L25
        Object[] r19 = this.mConstructorArgs;
        r19[0] = null;
        r19[1] = null;
        return r18;
    L25:
        Object[] r20 = this.mConstructorArgs;
        r20[0] = null;
        r20[1] = null;
        return null;
    L16:
        th = move-exception;
        Object[] r21 = this.mConstructorArgs;
        r21[0] = null;
        r21[1] = null;
        throw th;
    }

    private static Context themifyContext(Context r5, AttributeSet r10, boolean r11, boolean r12) {
        TypedArray r13 = r5.obtainStyledAttributes(r10, androidx.appcompat.R.styleable.View, 0, 0);
        if (r11 == false) goto L5;
        int r14 = r13.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0);
    L6:
        if (r12 == false) goto L11;
        if (r14 != 0) goto L11;
        r14 = r13.getResourceId(androidx.appcompat.R.styleable.View_theme, 0);
        if (r14 == 0) goto L11;
        Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
    L11:
        r13.recycle();
        if (r14 != 0) goto L14;
        return r5;
    L14:
        if ((r5 instanceof ContextThemeWrapper) == false) goto L18;
        if (((ContextThemeWrapper) r5).getThemeResId() != r14) goto L18;
        return r5;
    L18:
        return new ContextThemeWrapper(r5, r14);
    L5:
        r14 = 0;
        goto L6
    }

    private void verifyNotNull(View r5, String r10) {
        if (r5 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r10 + ">, but returned null");
    }

    @NonNull
    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r5, AttributeSet r10) {
        return new AppCompatAutoCompleteTextView(r5, r10);
    }

    @NonNull
    public AppCompatButton createButton(Context r5, AttributeSet r10) {
        return new AppCompatButton(r5, r10);
    }

    @NonNull
    public AppCompatCheckBox createCheckBox(Context r5, AttributeSet r10) {
        return new AppCompatCheckBox(r5, r10);
    }

    @NonNull
    public AppCompatCheckedTextView createCheckedTextView(Context r5, AttributeSet r10) {
        return new AppCompatCheckedTextView(r5, r10);
    }

    @NonNull
    public AppCompatEditText createEditText(Context r5, AttributeSet r10) {
        return new AppCompatEditText(r5, r10);
    }

    @NonNull
    public AppCompatImageButton createImageButton(Context r5, AttributeSet r10) {
        return new AppCompatImageButton(r5, r10);
    }

    @NonNull
    public AppCompatImageView createImageView(Context r5, AttributeSet r10) {
        return new AppCompatImageView(r5, r10);
    }

    @NonNull
    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r5, AttributeSet r10) {
        return new AppCompatMultiAutoCompleteTextView(r5, r10);
    }

    @NonNull
    public AppCompatRadioButton createRadioButton(Context r5, AttributeSet r10) {
        return new AppCompatRadioButton(r5, r10);
    }

    @NonNull
    public AppCompatRatingBar createRatingBar(Context r5, AttributeSet r10) {
        return new AppCompatRatingBar(r5, r10);
    }

    @NonNull
    public AppCompatSeekBar createSeekBar(Context r5, AttributeSet r10) {
        return new AppCompatSeekBar(r5, r10);
    }

    @NonNull
    public AppCompatSpinner createSpinner(Context r5, AttributeSet r10) {
        return new AppCompatSpinner(r5, r10);
    }

    @NonNull
    public AppCompatTextView createTextView(Context r5, AttributeSet r10) {
        return new AppCompatTextView(r5, r10);
    }

    @NonNull
    public AppCompatToggleButton createToggleButton(Context r5, AttributeSet r10) {
        return new AppCompatToggleButton(r5, r10);
    }

    @Nullable
    public View createView(Context r5, String r10, AttributeSet r11) {
        return null;
    }

    @Nullable
    public final View createView(@Nullable View r5, @NonNull String r10, @NonNull Context r11, @NonNull AttributeSet r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        if (r13 == false) goto L5;
        if (r5 == null) goto L5;
        Context r17 = r5.getContext();
    L6:
        if (r14 == true) goto L8;
        if (r15 == true) goto L8;
    L9:
        if (r16 == false) goto L11;
        r17 = TintContextWrapper.wrap(r17);
    L11:
        r10.getClass();
        byte r18 = -1;
        switch(r10.hashCode()) {
            case -1946472170: goto L67;
            case -1455429095: goto L63;
            case -1346021293: goto L59;
            case -938935918: goto L55;
            case -937446323: goto L51;
            case -658531749: goto L47;
            case -339785223: goto L43;
            case 776382189: goto L39;
            case 799298502: goto L35;
            case 1125864064: goto L31;
            case 1413872058: goto L27;
            case 1601505219: goto L23;
            case 1666676343: goto L19;
            case 2001146706: goto L15;
            default: goto L70;
        };
    L70:
        switch(r18) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L73;
            case 13: goto L72;
            default: goto L71;
        };
    L71:
        View r19 = createView(r17, r10, r12);
    L86:
        if (r19 != null) goto L89;
        if (r11 == r17) goto L89;
        r19 = createViewFromTag(r17, r10, r12);
    L89:
        if (r19 == null) goto L91;
        checkOnClickListener(r19, r12);
        backportAccessibilityAttributes(r17, r19, r12);
    L91:
        return r19;
    L72:
        r19 = createButton(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L73:
        r19 = createEditText(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L74:
        r19 = createCheckBox(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L75:
        r19 = createAutoCompleteTextView(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L76:
        r19 = createImageView(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L77:
        r19 = createToggleButton(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L78:
        r19 = createRadioButton(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L79:
        r19 = createSpinner(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L80:
        r19 = createSeekBar(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L81:
        r19 = createImageButton(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L82:
        r19 = createTextView(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L83:
        r19 = createMultiAutoCompleteTextView(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L84:
        r19 = createCheckedTextView(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L85:
        r19 = createRatingBar(r17, r12);
        verifyNotNull(r19, r10);
        goto L86
    L15:
        if (r10.equals("Button") == false) goto L70;
        r18 = 13;
        goto L70
    L19:
        if (r10.equals("EditText") == false) goto L70;
        r18 = 12;
        goto L70
    L23:
        if (r10.equals("CheckBox") == false) goto L70;
        r18 = 11;
        goto L70
    L27:
        if (r10.equals("AutoCompleteTextView") == false) goto L70;
        r18 = 10;
        goto L70
    L31:
        if (r10.equals("ImageView") == false) goto L70;
        r18 = 9;
        goto L70
    L35:
        if (r10.equals("ToggleButton") == false) goto L70;
        r18 = 8;
        goto L70
    L39:
        if (r10.equals("RadioButton") == false) goto L70;
        r18 = 7;
        goto L70
    L43:
        if (r10.equals("Spinner") == false) goto L70;
        r18 = 6;
        goto L70
    L47:
        if (r10.equals("SeekBar") == false) goto L70;
        r18 = 5;
        goto L70
    L51:
        if (r10.equals("ImageButton") == false) goto L70;
        r18 = 4;
        goto L70
    L55:
        if (r10.equals("TextView") == false) goto L70;
        r18 = 3;
        goto L70
    L59:
        if (r10.equals("MultiAutoCompleteTextView") == false) goto L70;
        r18 = 2;
        goto L70
    L63:
        if (r10.equals("CheckedTextView") == false) goto L70;
        r18 = 1;
        goto L70
    L67:
        if (r10.equals("RatingBar") == false) goto L70;
        r18 = 0;
    L8:
        r17 = themifyContext(r17, r12, r14, r15);
    L5:
        r17 = r11;
        goto L6
    }
}
