package com.ss.android.lark.chameleon.widgetv2.titlebar;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IActionTitlebar {

    public interface Action {
        int getBackground();

        int getDrawableRes();

        Object getTag();

        String getText();

        void performAction(View r1);

        Action setTag(Object r1);
    }

    public static class BaseAction implements Action {
        private Object mTag;

        public BaseAction() {
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public int getBackground() {
            return 0;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public int getDrawableRes() {
            return 0;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public String getText() {
            return null;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public void performAction(View r1) {
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public Object getTag() {
            return this.mTag;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public Action setTag(Object r1) {
            this.mTag = r1;
            return this;
        }
    }

    public static class ImageAction extends BaseAction {
        private Drawable mDrawable;
        private int mDrawableRes;
        private OnDrawableUpdateListener mOnDrawableUpdateListener;
        private int mTintRes;

        public interface OnDrawableUpdateListener {
            void onDrawableResUpdated(int r1);

            void onDrawableUpdated(Drawable r1);
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.BaseAction, com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public int getDrawableRes() {
            return this.mDrawableRes;
        }

        public int getTintRes() {
            return this.mTintRes;
        }

        public ImageAction(Drawable r1) {
            this.mDrawable = r1;
        }

        public void setOnDrawableUpdateListener(OnDrawableUpdateListener r1) {
            this.mOnDrawableUpdateListener = r1;
        }

        public void updateDrawable(Drawable r2) {
            this.mDrawableRes = 0;
            this.mDrawable = r2;
            OnDrawableUpdateListener r0 = this.mOnDrawableUpdateListener;
            if (r0 == null) goto L6;
            r0.onDrawableUpdated(r2);
            return;
        }

        public void updateDrawableResource(int r2) {
            this.mDrawableRes = r2;
            this.mDrawable = null;
            OnDrawableUpdateListener r0 = this.mOnDrawableUpdateListener;
            if (r0 == null) goto L6;
            r0.onDrawableResUpdated(r2);
            return;
        }

        public ImageAction(int r2) {
            this(r2, 0);
        }

        public ImageAction(int r1, int r2) {
            this.mDrawableRes = r1;
            this.mTintRes = r2;
        }
    }

    public static class TextAction extends BaseAction {
        private int mColor;
        private OnTextChangeListener mOnTextChangeListener;
        private OnTextColorChangedListener mOnTextColorChangedListener;
        private String mText;
        private int mTextSize;

        public interface OnTextChangeListener {
            void onTextChange(String r1);
        }

        public interface OnTextColorChangedListener {
            void onTextColorChange(int r1);
        }

        public int getColor() {
            return this.mColor;
        }

        @Override // com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.BaseAction, com.ss.android.lark.chameleon.widgetv2.titlebar.IActionTitlebar.Action
        public String getText() {
            return this.mText;
        }

        public int getTextSize() {
            return this.mTextSize;
        }

        public TextAction(String r2) {
            this.mColor = -1;
            this.mTextSize = CommonTitleBarConstants.DEFAULT_ACTION_TEXT_SIZE;
            this.mText = r2;
        }

        public void setOnTextChangedListener(OnTextChangeListener r1) {
            this.mOnTextChangeListener = r1;
        }

        public void setOnTextColorChangedListener(OnTextColorChangedListener r1) {
            this.mOnTextColorChangedListener = r1;
        }

        public void updateText(String r2) {
            this.mText = r2;
            OnTextChangeListener r0 = this.mOnTextChangeListener;
            if (r0 == null) goto L6;
            r0.onTextChange(r2);
            return;
        }

        public void updateTextColor(int r2) {
            this.mColor = r2;
            OnTextColorChangedListener r0 = this.mOnTextColorChangedListener;
            if (r0 == null) goto L6;
            r0.onTextColorChange(r2);
            return;
        }

        public TextAction(String r2, int r3) {
            this.mColor = -1;
            this.mTextSize = CommonTitleBarConstants.DEFAULT_ACTION_TEXT_SIZE;
            this.mText = r2;
            this.mColor = r3;
        }

        public TextAction(String r2, int r3, int r4) {
            this.mColor = -1;
            int r0 = CommonTitleBarConstants.DEFAULT_LEFT_TEXT_SIZE;
            this.mText = r2;
            this.mColor = r3;
            this.mTextSize = r4;
        }
    }

    public static class ViewAction extends BaseAction {
        private final View mView;

        public View getView() {
            return this.mView;
        }

        public ViewAction(View r1) {
            this.mView = r1;
        }
    }

    View addAction(Action r1);

    void removeAllActions();

    void setTitle(CharSequence r1);
}
