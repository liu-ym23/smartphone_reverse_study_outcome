package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements EmojiCompatConfigurationView, OnReceiveContentViewBehavior, TintableBackgroundView, TintableCompoundDrawablesView {
    private final AppCompatEmojiEditTextHelper mAppCompatEmojiEditTextHelper;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    class SuperCaller {
        final /* synthetic */ AppCompatEditText this$0;

        SuperCaller(AppCompatEditText r1) {
            this.this$0 = r1;
        }

        public TextClassifier getTextClassifier() {
            return AppCompatEditText.access$001(this.this$0);
        }

        public void setTextClassifier(TextClassifier r3) {
            TextClassifier r4 = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.memorydata.plugin");
            AppCompatEditText.access$101(this.this$0, r4);
        }
    }

    public AppCompatEditText(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public AppCompatEditText(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.editTextStyle, "attr", "editTextStyle"));
    }

    public AppCompatEditText(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, r5);
        ThemeUtils.checkAppCompatTheme(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        AppCompatBackgroundHelper r8 = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = r8;
        r8.loadFromAttributes(r7, r5);
        AppCompatTextHelper r9 = new AppCompatTextHelper(this);
        this.mTextHelper = r9;
        r9.loadFromAttributes(r7, r5);
        r9.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
        AppCompatEmojiEditTextHelper r10 = new AppCompatEmojiEditTextHelper(this);
        this.mAppCompatEmojiEditTextHelper = r10;
        r10.loadFromAttributes(r7, r5);
        initEmojiKeyListener(r10);
    }

    static /* synthetic */ TextClassifier access$001(AppCompatEditText r0) {
        return super.getTextClassifier();
    }

    static /* synthetic */ void access$101(AppCompatEditText r2, TextClassifier r3) {
        super.setTextClassifier((TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.memorydata.plugin"));
    }

    private SuperCaller getSuperCaller() {
        if (this.mSuperCaller != null) goto L6;
        this.mSuperCaller = new SuperCaller(this);
    L6:
        return this.mSuperCaller;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L5;
        r0.applySupportBackgroundTint();
    L5:
        AppCompatTextHelper r1 = this.mTextHelper;
        if (r1 == null) goto L9;
        r1.applyCompoundDrawablesTints();
        return;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.unwrapCustomSelectionActionModeCallback(super.getCustomSelectionActionModeCallback());
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return super.getText();
    L7:
        return super.getEditableText();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT >= 28) goto L10;
        AppCompatTextClassifierHelper r0 = this.mTextClassifierHelper;
        if (r0 == null) goto L10;
        return r0.getTextClassifier();
    L10:
        return getSuperCaller().getTextClassifier();
    }

    void initEmojiKeyListener(AppCompatEmojiEditTextHelper r6) {
        KeyListener r0 = getKeyListener();
        if (r6.isEmojiCapableKeyListener(r0) == false) goto L9;
        boolean r1 = super.isFocusable();
        boolean r2 = super.isClickable();
        boolean r3 = super.isLongClickable();
        int r4 = super.getInputType();
        KeyListener r7 = r6.getKeyListener(r0);
        if (r7 != r0) goto L7;
        return;
    L7:
        super.setKeyListener(r7);
        super.setRawInputType(r4);
        super.setFocusable(r1);
        super.setClickable(r2);
        super.setLongClickable(r3);
        return;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.isEnabled();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r4) {
        InputConnection r0 = super.onCreateInputConnection(r4);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, r0, r4);
        InputConnection r1 = AppCompatHintHelper.onCreateInputConnection(r0, r4, this);
        if (r1 == null) goto L10;
        if (Build.VERSION.SDK_INT > 30) goto L10;
        String[] r2 = ViewCompat.getOnReceiveContentMimeTypes(this);
        if (r2 == null) goto L10;
        EditorInfoCompat.setContentMimeTypes(r4, r2);
        r1 = InputConnectionCompat.createWrapper(this, r1, r4);
    L10:
        return this.mAppCompatEmojiEditTextHelper.onCreateInputConnection(r1, r4);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent r2) {
        if (AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent(this, r2) == false) goto L7;
        return true;
    L7:
        return super.onDragEvent(r2);
    }

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public ContentInfoCompat onReceiveContent(ContentInfoCompat r2) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, r2);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r2) {
        if (AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent(this, r2) == false) goto L7;
        return true;
    L7:
        return super.onTextContextMenuItem(r2);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r1);
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        AppCompatTextHelper r0 = this.mTextHelper;
        if (r0 == null) goto L6;
        r0.onSetCompoundDrawables();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin")));
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean r1) {
        this.mAppCompatEmojiEditTextHelper.setEnabled(r1);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.memorydata.plugin");
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.getKeyListener(r4));
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r1);
        return;
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList r2) {
        this.mTextHelper.setCompoundDrawableTintList(r2);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r2) {
        this.mTextHelper.setCompoundDrawableTintMode(r2);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super.setTextAppearance(r5, r4);
        AppCompatTextHelper r2 = this.mTextHelper;
        if (r2 == null) goto L6;
        r2.onSetTextAppearance(r5, r4);
        return;
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier r3) {
        TextClassifier r4 = (TextClassifier) ZeusTransformUtils.wrapperContextForParams(r3, TextClassifier.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 28) goto L9;
        AppCompatTextClassifierHelper r0 = this.mTextClassifierHelper;
        if (r0 == null) goto L9;
        r0.setTextClassifier(r4);
        return;
    L9:
        getSuperCaller().setTextClassifier(r4);
    }
}
