package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(View r1, String r2) {
            this.mHostView = r1;
            this.mMethodName = r2;
        }

        private void resolveMethod(Context r7) {
            Object r8 = ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        L3:
            Context r9 = (Context) r8;
        L4:
            if (r9 == null) goto L15;
            if (r9.isRestricted() == true) goto L12;
            Method r0 = r9.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L21
            if (r0 == null) goto L12;
            this.mResolvedMethod = r0;     // Catch: NoSuchMethodException -> L21
            this.mResolvedContext = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");     // Catch: NoSuchMethodException -> L21
            return;
        L12:
            if (ZeusTransformUtils.instanceOf(r9, ContextWrapper.class) == true) goto L13;
            r9 = null;
            goto L4
        L13:
            r8 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r9, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            goto L3
        L15:
            int r10 = this.mHostView.getId();
            if (r10 != (-1)) goto L18;
            String r11 = "";
        L20:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r11);
        L18:
            r11 = " with id '" + ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHostView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r10) + "'";
            goto L20
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r4) {
            if (this.mResolvedMethod != null) goto L13;
            resolveMethod((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHostView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        L13:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r4});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L10
            return;
        L10:
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

    private void backportAccessibilityAttributes(Context r3, View r4, AttributeSet r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT > 28) goto L19;
        TypedArray r7 = r2.obtainStyledAttributes(r6, sAccessibilityHeading);
        if (r7.hasValue(0) == false) goto L10;
        ViewCompat.setAccessibilityHeading(r4, r7.getBoolean(0, false));
    L10:
        r7.recycle();
        TypedArray r8 = r2.obtainStyledAttributes(r6, sAccessibilityPaneTitle);
        if (r8.hasValue(0) == false) goto L13;
        ViewCompat.setAccessibilityPaneTitle(r4, r8.getString(0));
    L13:
        r8.recycle();
        TypedArray r9 = r2.obtainStyledAttributes(r6, sScreenReaderFocusable);
        if (r9.hasValue(0) == false) goto L16;
        ViewCompat.setScreenReaderFocusable(r4, r9.getBoolean(0, false));
    L16:
        r9.recycle();
        return;
    }

    private void checkOnClickListener(View r3, AttributeSet r4) {
        AttributeSet r2 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ContextWrapper.class) == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 15) goto L7;
    L9:
        TypedArray r6 = r5.obtainStyledAttributes(r2, sOnClickAttrs);
        String r7 = r6.getString(0);
        if (r7 == null) goto L12;
        r3.setOnClickListener(new DeclaredOnClickListener(r3, r7));
    L12:
        r6.recycle();
        return;
    L7:
        if (ViewCompat.hasOnClickListeners(r3) == true) goto L9;
    }

    private View createViewByPrefix(Context r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        SimpleArrayMap<String, Constructor<? extends View>> r0 = sConstructorMap;
        Constructor<? extends View> r2 = (Constructor) ZeusTransformUtils.preCheckCast(r0.get(r6), Constructor.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        if (r7 != null) goto L12;
        String r9 = r6;
    L7:
        r2 = Class.forName(r9, false, r8.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);     // Catch: Exception -> L10
        r0.put(r6, r2);     // Catch: Exception -> L10
        goto L8
    L12:
        r9 = r7 + r6;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r2.setAccessible(true);     // Catch: Exception -> L10
        return (View) ZeusTransformUtils.preCheckCast(r2.newInstance(this.mConstructorArgs), View.class, "com.obric.memorydata.plugin");
    }

    private View createViewFromTag(Context r6, String r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r7.equals("view") == false) goto L26;
        r7 = r10.getAttributeValue(null, "class");
    L26:
        Object[] r3 = this.mConstructorArgs;     // Catch: Throwable -> L21 Exception -> L24
        r3[0] = r9;     // Catch: Throwable -> L21 Exception -> L24
        r3[1] = r10;     // Catch: Throwable -> L21 Exception -> L24
        if ((-1) != r7.indexOf(46)) goto L18;
        int r11 = 0;
    L9:
        String[] r4 = sClassPrefixList;     // Catch: Throwable -> L21 Exception -> L24
        if (r11 >= r4.length) goto L16;
        View r5 = createViewByPrefix(r9, r7, r4[r11]);     // Catch: Throwable -> L21 Exception -> L24
        if (r5 != null) goto L13;
        r11 = r11 + 1;
        goto L9
    L13:
        Object[] r12 = this.mConstructorArgs;
        r12[0] = null;
        r12[1] = null;
        return r5;
    L16:
        Object[] r13 = this.mConstructorArgs;
        r13[0] = null;
        r13[1] = null;
        return null;
    L18:
        View r14 = createViewByPrefix(r9, r7, null);     // Catch: Throwable -> L21 Exception -> L24
        Object[] r15 = this.mConstructorArgs;
        r15[0] = null;
        r15[1] = null;
        return r14;
    L24:
        Object[] r16 = this.mConstructorArgs;
        r16[0] = null;
        r16[1] = null;
        return null;
    L21:
        th = move-exception;
        Object[] r17 = this.mConstructorArgs;
        r17[0] = null;
        r17[1] = null;
        throw th;
    }

    private static Context themifyContext(Context r4, AttributeSet r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        TypedArray r9 = r8.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.View, 0, 0);
        if (r6 == false) goto L5;
        int r10 = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.View_android_theme, "styleable", "View_android_theme"), 0);
    L6:
        if (r7 == false) goto L11;
        if (r10 != 0) goto L11;
        r10 = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.View_theme, "styleable", "View_theme"), 0);
        if (r10 == 0) goto L11;
        Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
    L11:
        r9.recycle();
        if (r10 != 0) goto L14;
        return r8;
    L14:
        if (ZeusTransformUtils.instanceOf(r8, ContextThemeWrapper.class) == false) goto L18;
        if (((ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r8, ContextThemeWrapper.class, "com.obric.memorydata.plugin")).getThemeResId() != r10) goto L18;
        return r8;
    L18:
        return new ContextThemeWrapper(r8, r10);
    L5:
        r10 = 0;
        goto L6
    }

    private void verifyNotNull(View r2, String r3) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r3 + ">, but returned null");
    }

    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r2, AttributeSet r3) {
        return new AppCompatAutoCompleteTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatButton createButton(Context r2, AttributeSet r3) {
        return new AppCompatButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatCheckBox createCheckBox(Context r2, AttributeSet r3) {
        return new AppCompatCheckBox((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatCheckedTextView createCheckedTextView(Context r2, AttributeSet r3) {
        return new AppCompatCheckedTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatEditText createEditText(Context r2, AttributeSet r3) {
        return new AppCompatEditText((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatImageButton createImageButton(Context r2, AttributeSet r3) {
        return new AppCompatImageButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatImageView createImageView(Context r2, AttributeSet r3) {
        return new AppCompatImageView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r2, AttributeSet r3) {
        return new AppCompatMultiAutoCompleteTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatRadioButton createRadioButton(Context r2, AttributeSet r3) {
        return new AppCompatRadioButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatRatingBar createRatingBar(Context r2, AttributeSet r3) {
        return new AppCompatRatingBar((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatSeekBar createSeekBar(Context r2, AttributeSet r3) {
        return new AppCompatSeekBar((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatSpinner createSpinner(Context r2, AttributeSet r3) {
        return new AppCompatSpinner((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatTextView createTextView(Context r2, AttributeSet r3) {
        return new AppCompatTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public AppCompatToggleButton createToggleButton(Context r2, AttributeSet r3) {
        return new AppCompatToggleButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    public View createView(Context r1, String r2, AttributeSet r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        return null;
    }

    public final View createView(View r3, String r4, Context r5, AttributeSet r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L6;
        if (r3 == null) goto L6;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L7:
        if (r8 == true) goto L9;
        if (r9 == true) goto L9;
    L10:
        if (r10 == false) goto L12;
        r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r13), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L12:
        r4.hashCode();
        byte r14 = -1;
        switch(r4.hashCode()) {
            case -1946472170: goto L68;
            case -1455429095: goto L64;
            case -1346021293: goto L60;
            case -938935918: goto L56;
            case -937446323: goto L52;
            case -658531749: goto L48;
            case -339785223: goto L44;
            case 776382189: goto L40;
            case 799298502: goto L36;
            case 1125864064: goto L32;
            case 1413872058: goto L28;
            case 1601505219: goto L24;
            case 1666676343: goto L20;
            case 2001146706: goto L16;
            default: goto L71;
        };
    L71:
        switch(r14) {
            case 0: goto L87;
            case 1: goto L86;
            case 2: goto L85;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L77;
            case 10: goto L76;
            case 11: goto L75;
            case 12: goto L74;
            case 13: goto L73;
            default: goto L72;
        };
    L72:
        View r15 = createView(r13, r4, r12);
    L88:
        if (r15 != null) goto L91;
        if (r11 == r13) goto L91;
        r15 = createViewFromTag(r13, r4, r12);
    L91:
        if (r15 == null) goto L93;
        checkOnClickListener(r15, r12);
        backportAccessibilityAttributes(r13, r15, r12);
    L93:
        return r15;
    L73:
        r15 = createButton(r13, r12);
    L84:
        verifyNotNull(r15, r4);
        goto L88
    L74:
        r15 = createEditText(r13, r12);
        goto L84
    L75:
        r15 = createCheckBox(r13, r12);
        goto L84
    L76:
        r15 = createAutoCompleteTextView(r13, r12);
        goto L84
    L77:
        r15 = createImageView(r13, r12);
        goto L84
    L78:
        r15 = createToggleButton(r13, r12);
        goto L84
    L79:
        r15 = createRadioButton(r13, r12);
        goto L84
    L80:
        r15 = createSpinner(r13, r12);
        goto L84
    L81:
        r15 = createSeekBar(r13, r12);
        goto L84
    L82:
        r15 = createImageButton(r13, r12);
        goto L84
    L83:
        r15 = createTextView(r13, r12);
        goto L84
    L85:
        r15 = createMultiAutoCompleteTextView(r13, r12);
        goto L84
    L86:
        r15 = createCheckedTextView(r13, r12);
        goto L84
    L87:
        r15 = createRatingBar(r13, r12);
        goto L84
    L16:
        if (r4.equals("Button") == false) goto L71;
        r14 = 13;
        goto L71
    L20:
        if (r4.equals("EditText") == false) goto L71;
        r14 = 12;
        goto L71
    L24:
        if (r4.equals("CheckBox") == false) goto L71;
        r14 = 11;
        goto L71
    L28:
        if (r4.equals("AutoCompleteTextView") == false) goto L71;
        r14 = 10;
        goto L71
    L32:
        if (r4.equals("ImageView") == false) goto L71;
        r14 = 9;
        goto L71
    L36:
        if (r4.equals("ToggleButton") == false) goto L71;
        r14 = 8;
        goto L71
    L40:
        if (r4.equals("RadioButton") == false) goto L71;
        r14 = 7;
        goto L71
    L44:
        if (r4.equals("Spinner") == false) goto L71;
        r14 = 6;
        goto L71
    L48:
        if (r4.equals("SeekBar") == false) goto L71;
        r14 = 5;
        goto L71
    L52:
        if (r4.equals("ImageButton") == false) goto L71;
        r14 = 4;
        goto L71
    L56:
        if (r4.equals("TextView") == false) goto L71;
        r14 = 3;
        goto L71
    L60:
        if (r4.equals("MultiAutoCompleteTextView") == false) goto L71;
        r14 = 2;
        goto L71
    L64:
        if (r4.equals("CheckedTextView") == false) goto L71;
        r14 = 1;
        goto L71
    L68:
        if (r4.equals("RatingBar") == false) goto L71;
        r14 = 0;
    L9:
        r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(themifyContext(r13, r12, r8, r9), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L6:
        r13 = r11;
        goto L7
    }
}
