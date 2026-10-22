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
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(@NonNull Context r5) {
            this(r5, AlertDialog.resolveDialogTheme(r5, 0));
        }

        @NonNull
        public AlertDialog create() {
            AlertDialog r5 = new AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(r5.mAlert);
            r5.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable == false) goto L5;
            r5.setCanceledOnTouchOutside(true);
        L5:
            r5.setOnCancelListener(this.P.mOnCancelListener);
            r5.setOnDismissListener(this.P.mOnDismissListener);
            DialogInterface.OnKeyListener r10 = this.P.mOnKeyListener;
            if (r10 == null) goto L8;
            r5.setOnKeyListener(r10);
        L8:
            return r5;
        }

        @NonNull
        public Context getContext() {
            return this.P.mContext;
        }

        public Builder setAdapter(ListAdapter r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mAdapter = r5;
            r11.mOnClickListener = r10;
            return this;
        }

        public Builder setCancelable(boolean r5) {
            this.P.mCancelable = r5;
            return this;
        }

        public Builder setCursor(Cursor r5, DialogInterface.OnClickListener r10, String r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mCursor = r5;
            r12.mLabelColumn = r11;
            r12.mOnClickListener = r10;
            return this;
        }

        public Builder setCustomTitle(@Nullable View r5) {
            this.P.mCustomTitleView = r5;
            return this;
        }

        public Builder setIcon(@DrawableRes int r5) {
            this.P.mIconId = r5;
            return this;
        }

        public Builder setIconAttribute(@AttrRes int r5) {
            TypedValue r10 = new TypedValue();
            this.P.mContext.getTheme().resolveAttribute(r5, r10, true);
            AlertController.AlertParams r11 = this.P;
            r11.mIconId = r10.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean r5) {
            this.P.mForceInverseBackground = r5;
            return this;
        }

        public Builder setItems(@ArrayRes int r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mItems = r11.mContext.getResources().getTextArray(r5);
            this.P.mOnClickListener = r10;
            return this;
        }

        public Builder setMessage(@StringRes int r5) {
            AlertController.AlertParams r10 = this.P;
            r10.mMessage = r10.mContext.getText(r5);
            return this;
        }

        public Builder setMultiChoiceItems(@ArrayRes int r5, boolean[] r10, DialogInterface.OnMultiChoiceClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mItems = r12.mContext.getResources().getTextArray(r5);
            AlertController.AlertParams r13 = this.P;
            r13.mOnCheckboxClickListener = r11;
            r13.mCheckedItems = r10;
            r13.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(@StringRes int r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mNegativeButtonText = r11.mContext.getText(r5);
            this.P.mNegativeButtonListener = r10;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable r5) {
            this.P.mNegativeButtonIcon = r5;
            return this;
        }

        public Builder setNeutralButton(@StringRes int r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mNeutralButtonText = r11.mContext.getText(r5);
            this.P.mNeutralButtonListener = r10;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable r5) {
            this.P.mNeutralButtonIcon = r5;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener r5) {
            this.P.mOnCancelListener = r5;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener r5) {
            this.P.mOnDismissListener = r5;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r5) {
            this.P.mOnItemSelectedListener = r5;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener r5) {
            this.P.mOnKeyListener = r5;
            return this;
        }

        public Builder setPositiveButton(@StringRes int r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mPositiveButtonText = r11.mContext.getText(r5);
            this.P.mPositiveButtonListener = r10;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable r5) {
            this.P.mPositiveButtonIcon = r5;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setRecycleOnMeasureEnabled(boolean r5) {
            this.P.mRecycleOnMeasure = r5;
            return this;
        }

        public Builder setSingleChoiceItems(@ArrayRes int r5, int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mItems = r12.mContext.getResources().getTextArray(r5);
            AlertController.AlertParams r13 = this.P;
            r13.mOnClickListener = r11;
            r13.mCheckedItem = r10;
            r13.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(@StringRes int r5) {
            AlertController.AlertParams r10 = this.P;
            r10.mTitle = r10.mContext.getText(r5);
            return this;
        }

        public Builder setView(int r5) {
            AlertController.AlertParams r10 = this.P;
            r10.mView = null;
            r10.mViewLayoutResId = r5;
            r10.mViewSpacingSpecified = false;
            return this;
        }

        public AlertDialog show() {
            AlertDialog r5 = create();
            r5.show();
            return r5;
        }

        public Builder(@NonNull Context r5, @StyleRes int r10) {
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(r5, AlertDialog.resolveDialogTheme(r5, r10)));
            this.mTheme = r10;
        }

        public Builder setIcon(@Nullable Drawable r5) {
            this.P.mIcon = r5;
            return this;
        }

        public Builder setMessage(@Nullable CharSequence r5) {
            this.P.mMessage = r5;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence r5) {
            this.P.mTitle = r5;
            return this;
        }

        public Builder setItems(CharSequence[] r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mItems = r5;
            r11.mOnClickListener = r10;
            return this;
        }

        public Builder setNegativeButton(CharSequence r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mNegativeButtonText = r5;
            r11.mNegativeButtonListener = r10;
            return this;
        }

        public Builder setNeutralButton(CharSequence r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mNeutralButtonText = r5;
            r11.mNeutralButtonListener = r10;
            return this;
        }

        public Builder setPositiveButton(CharSequence r5, DialogInterface.OnClickListener r10) {
            AlertController.AlertParams r11 = this.P;
            r11.mPositiveButtonText = r5;
            r11.mPositiveButtonListener = r10;
            return this;
        }

        public Builder setView(View r5) {
            AlertController.AlertParams r10 = this.P;
            r10.mView = r5;
            r10.mViewLayoutResId = 0;
            r10.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] r5, boolean[] r10, DialogInterface.OnMultiChoiceClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mItems = r5;
            r12.mOnCheckboxClickListener = r11;
            r12.mCheckedItems = r10;
            r12.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor r5, int r10, String r11, DialogInterface.OnClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mCursor = r5;
            r13.mOnClickListener = r12;
            r13.mCheckedItem = r10;
            r13.mLabelColumn = r11;
            r13.mIsSingleChoice = true;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public Builder setView(View r5, int r10, int r11, int r12, int r13) {
            AlertController.AlertParams r14 = this.P;
            r14.mView = r5;
            r14.mViewLayoutResId = 0;
            r14.mViewSpacingSpecified = true;
            r14.mViewSpacingLeft = r10;
            r14.mViewSpacingTop = r11;
            r14.mViewSpacingRight = r12;
            r14.mViewSpacingBottom = r13;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor r5, String r10, String r11, DialogInterface.OnMultiChoiceClickListener r12) {
            AlertController.AlertParams r13 = this.P;
            r13.mCursor = r5;
            r13.mOnCheckboxClickListener = r12;
            r13.mIsCheckedColumn = r10;
            r13.mLabelColumn = r11;
            r13.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] r5, int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mItems = r5;
            r12.mOnClickListener = r11;
            r12.mCheckedItem = r10;
            r12.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter r5, int r10, DialogInterface.OnClickListener r11) {
            AlertController.AlertParams r12 = this.P;
            r12.mAdapter = r5;
            r12.mOnClickListener = r11;
            r12.mCheckedItem = r10;
            r12.mIsSingleChoice = true;
            return this;
        }
    }

    public AlertDialog(@NonNull Context r5) {
        this(r5, 0);
    }

    public static int resolveDialogTheme(@NonNull Context r5, @StyleRes int r10) {
        if (((r10 >>> 24) & 255) < 1) goto L5;
        return r10;
    L5:
        TypedValue r11 = new TypedValue();
        r5.getTheme().resolveAttribute(R.attr.alertDialogTheme, r11, true);
        return r11.resourceId;
    }

    public Button getButton(int r5) {
        return this.mAlert.getButton(r5);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r5, KeyEvent r10) {
        if (this.mAlert.onKeyDown(r5, r10) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r5, r10);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r5, KeyEvent r10) {
        if (this.mAlert.onKeyUp(r5, r10) == false) goto L7;
        return true;
    L7:
        return super.onKeyUp(r5, r10);
    }

    public void setButton(int r10, CharSequence r11, Message r12) {
        this.mAlert.setButton(r10, r11, null, r12, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setButtonPanelLayoutHint(int r5) {
        this.mAlert.setButtonPanelLayoutHint(r5);
    }

    public void setCustomTitle(View r5) {
        this.mAlert.setCustomTitle(r5);
    }

    public void setIcon(int r5) {
        this.mAlert.setIcon(r5);
    }

    public void setIconAttribute(int r5) {
        TypedValue r10 = new TypedValue();
        getContext().getTheme().resolveAttribute(r5, r10, true);
        this.mAlert.setIcon(r10.resourceId);
    }

    public void setMessage(CharSequence r5) {
        this.mAlert.setMessage(r5);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence r5) {
        super.setTitle(r5);
        this.mAlert.setTitle(r5);
    }

    public void setView(View r5) {
        this.mAlert.setView(r5);
    }

    public AlertDialog(@NonNull Context r5, @StyleRes int r10) {
        super(r5, resolveDialogTheme(r5, r10));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    public void setButton(int r10, CharSequence r11, DialogInterface.OnClickListener r12) {
        this.mAlert.setButton(r10, r11, r12, null, null);
    }

    public void setIcon(Drawable r5) {
        this.mAlert.setIcon(r5);
    }

    public void setView(View r10, int r11, int r12, int r13, int r14) {
        this.mAlert.setView(r10, r11, r12, r13, r14);
    }

    public void setButton(int r10, CharSequence r11, Drawable r12, DialogInterface.OnClickListener r13) {
        this.mAlert.setButton(r10, r11, r13, null, r12);
    }

    public AlertDialog(@NonNull Context r5, boolean r10, @Nullable DialogInterface.OnCancelListener r11) {
        this(r5, 0);
        setCancelable(r10);
        setOnCancelListener(r11);
    }
}
