package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(@NonNull Context r10) {
            this(r10, AlertDialog.resolveDialogTheme(r10, 0));
        }

        public Builder(@NonNull Context r10, @StyleRes int r11) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(r10, AlertDialog.resolveDialogTheme(r10, r11)));
            this.mTheme = r11;
        }

        @NonNull
        public AlertDialog create() {
            AlertDialog r10 = new AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(r10.mAlert);
            r10.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable == false) goto L5;
            r10.setCanceledOnTouchOutside(true);
        L5:
            r10.setOnCancelListener(this.P.mOnCancelListener);
            r10.setOnDismissListener(this.P.mOnDismissListener);
            DialogInterface.OnKeyListener r11 = this.P.mOnKeyListener;
            if (r11 == null) goto L8;
            r10.setOnKeyListener(r11);
        L8:
            return r10;
        }

        @NonNull
        public Context getContext() {
            return this.P.mContext;
        }

        public Builder setAdapter(ListAdapter r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mAdapter = r10;
            r12.mOnClickListener = r11;
            return this;
        }

        public Builder setCancelable(boolean r10) {
            this.P.mCancelable = r10;
            return this;
        }

        public Builder setCursor(Cursor r10, DialogInterface.OnClickListener r11, String r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mCursor = r10;
            r13.mLabelColumn = r12;
            r13.mOnClickListener = r11;
            return this;
        }

        public Builder setCustomTitle(@Nullable View r10) {
            this.P.mCustomTitleView = r10;
            return this;
        }

        public Builder setIcon(@DrawableRes int r10) {
            this.P.mIconId = r10;
            return this;
        }

        public Builder setIcon(@Nullable Drawable r10) {
            this.P.mIcon = r10;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int r10) {
            TypedValue r11 = new TypedValue();
            this.P.mContext.getTheme().resolveAttribute(r10, r11, true);
            AlertController.AlertParams r12 = this.P;
            r12.mIconId = r11.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean r10) {
            this.P.mForceInverseBackground = r10;
            return this;
        }

        public Builder setItems(@ArrayRes int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mItems = r12.mContext.getResources().getTextArray(r10);
            this.P.mOnClickListener = r11;
            return this;
        }

        public Builder setItems(CharSequence[] r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mItems = r10;
            r12.mOnClickListener = r11;
            return this;
        }

        public Builder setMessage(@StringRes int r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mMessage = r11.mContext.getText(r10);
            return this;
        }

        public Builder setMessage(@Nullable CharSequence r10) {
            this.P.mMessage = r10;
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int r10, boolean[] r11, DialogInterface.OnMultiChoiceClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mItems = r13.mContext.getResources().getTextArray(r10);
            AlertController.AlertParams r14 = this.P;
            r14.mOnCheckboxClickListener = r12;
            r14.mCheckedItems = r11;
            r14.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor r10, String r11, String r12, DialogInterface.OnMultiChoiceClickListener r13) {
            AlertController.AlertParams r14 = this.P;
            r14.mCursor = r10;
            r14.mOnCheckboxClickListener = r13;
            r14.mIsCheckedColumn = r11;
            r14.mLabelColumn = r12;
            r14.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] r10, boolean[] r11, DialogInterface.OnMultiChoiceClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mItems = r10;
            r13.mOnCheckboxClickListener = r12;
            r13.mCheckedItems = r11;
            r13.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mNegativeButtonText = r12.mContext.getText(r10);
            this.P.mNegativeButtonListener = r11;
            return this;
        }

        public Builder setNegativeButton(CharSequence r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mNegativeButtonText = r10;
            r12.mNegativeButtonListener = r11;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable r10) {
            this.P.mNegativeButtonIcon = r10;
            return this;
        }

        public Builder setNeutralButton(@StringRes int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mNeutralButtonText = r12.mContext.getText(r10);
            this.P.mNeutralButtonListener = r11;
            return this;
        }

        public Builder setNeutralButton(CharSequence r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mNeutralButtonText = r10;
            r12.mNeutralButtonListener = r11;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable r10) {
            this.P.mNeutralButtonIcon = r10;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener r10) {
            this.P.mOnCancelListener = r10;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener r10) {
            this.P.mOnDismissListener = r10;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r10) {
            this.P.mOnItemSelectedListener = r10;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener r10) {
            this.P.mOnKeyListener = r10;
            return this;
        }

        public Builder setPositiveButton(@StringRes int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mPositiveButtonText = r12.mContext.getText(r10);
            this.P.mPositiveButtonListener = r11;
            return this;
        }

        public Builder setPositiveButton(CharSequence r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mPositiveButtonText = r10;
            r12.mPositiveButtonListener = r11;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable r10) {
            this.P.mPositiveButtonIcon = r10;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean r10) {
            this.P.mRecycleOnMeasure = r10;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int r10, int r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mItems = r13.mContext.getResources().getTextArray(r10);
            AlertController.AlertParams r14 = this.P;
            r14.mOnClickListener = r12;
            r14.mCheckedItem = r11;
            r14.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor r10, int r11, String r12, DialogInterface.OnClickListener r13) {
            AlertController.AlertParams r14 = this.P;
            r14.mCursor = r10;
            r14.mOnClickListener = r13;
            r14.mCheckedItem = r11;
            r14.mLabelColumn = r12;
            r14.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter r10, int r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mAdapter = r10;
            r13.mOnClickListener = r12;
            r13.mCheckedItem = r11;
            r13.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] r10, int r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mItems = r10;
            r13.mOnClickListener = r12;
            r13.mCheckedItem = r11;
            r13.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mTitle = r11.mContext.getText(r10);
            return this;
        }

        public Builder setTitle(@Nullable CharSequence r10) {
            this.P.mTitle = r10;
            return this;
        }

        public Builder setView(int r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mView = null;
            r11.mViewLayoutResId = r10;
            r11.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mView = r10;
            r11.mViewLayoutResId = 0;
            r11.mViewSpacingSpecified = false;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public Builder setView(View r10, int r11, int r12, int r13, int r14) {
            AlertController.AlertParams r15 = this.P;
            r15.mView = r10;
            r15.mViewLayoutResId = 0;
            r15.mViewSpacingSpecified = true;
            r15.mViewSpacingLeft = r11;
            r15.mViewSpacingTop = r12;
            r15.mViewSpacingRight = r13;
            r15.mViewSpacingBottom = r14;
            return this;
        }

        public AlertDialog show() {
            AlertDialog r10 = create();
            r10.show();
            return r10;
        }
    }

    protected AlertDialog(@NonNull Context r10) {
        this(r10, 0);
    }

    protected AlertDialog(@NonNull Context r10, @StyleRes int r11) {
        super(r10, resolveDialogTheme(r10, r11));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(@NonNull Context r10, boolean r11, @Nullable DialogInterface.OnCancelListener r12) {
        this(r10, 0);
        setCancelable(r11);
        setOnCancelListener(r12);
    }

    static int resolveDialogTheme(@NonNull Context r10, @StyleRes int r11) {
        if (((r11 >>> 24) & 255) < 1) goto L5;
        return r11;
    L5:
        TypedValue r12 = new TypedValue();
        r10.getTheme().resolveAttribute(R.attr.alertDialogTheme, r12, true);
        return r12.resourceId;
    }

    public Button getButton(int r10) {
        return this.mAlert.getButton(r10);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (this.mAlert.onKeyDown(r10, r11) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r10, r11);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r10, KeyEvent r11) {
        if (this.mAlert.onKeyUp(r10, r11) == false) goto L7;
        return true;
    L7:
        return super.onKeyUp(r10, r11);
    }

    public void setButton(int r10, CharSequence r11, DialogInterface.OnClickListener r12) {
        this.mAlert.setButton(r10, r11, r12, null, null);
    }

    public void setButton(int r10, CharSequence r11, Drawable r12, DialogInterface.OnClickListener r13) {
        this.mAlert.setButton(r10, r11, r13, null, r12);
    }

    public void setButton(int r10, CharSequence r11, Message r12) {
        this.mAlert.setButton(r10, r11, null, r12, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void setButtonPanelLayoutHint(int r10) {
        this.mAlert.setButtonPanelLayoutHint(r10);
    }

    public void setCustomTitle(View r10) {
        this.mAlert.setCustomTitle(r10);
    }

    public void setIcon(int r10) {
        this.mAlert.setIcon(r10);
    }

    public void setIcon(Drawable r10) {
        this.mAlert.setIcon(r10);
    }

    public void setIconAttribute(int r10) {
        TypedValue r11 = new TypedValue();
        getContext().getTheme().resolveAttribute(r10, r11, true);
        this.mAlert.setIcon(r11.resourceId);
    }

    public void setMessage(CharSequence r10) {
        this.mAlert.setMessage(r10);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence r10) {
        super.setTitle(r10);
        this.mAlert.setTitle(r10);
    }

    public void setView(View r10) {
        this.mAlert.setView(r10);
    }

    public void setView(View r10, int r11, int r12, int r13, int r14) {
        this.mAlert.setView(r10, r11, r12, r13, r14);
    }
}
