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
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class Builder {
        private final AlertController.AlertParams P;
        private final int mTheme;

        public Builder(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this(r4, AlertDialog.resolveDialogTheme(r4, 0));
        }

        public Builder(Context r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.P = new AlertController.AlertParams(new ContextThemeWrapper(r6, AlertDialog.resolveDialogTheme(r6, r5)));
            this.mTheme = r5;
        }

        public AlertDialog create() {
            AlertDialog r0 = new AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(r0.mAlert);
            r0.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable == false) goto L5;
            r0.setCanceledOnTouchOutside(true);
        L5:
            r0.setOnCancelListener(this.P.mOnCancelListener);
            r0.setOnDismissListener(this.P.mOnDismissListener);
            if (this.P.mOnKeyListener == null) goto L8;
            r0.setOnKeyListener(this.P.mOnKeyListener);
        L8:
            return r0;
        }

        public Context getContext() {
            return this.P.mContext;
        }

        public Builder setAdapter(ListAdapter r3, DialogInterface.OnClickListener r4) {
            ListAdapter r5 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mAdapter = r5;
            this.P.mOnClickListener = r6;
            return this;
        }

        public Builder setCancelable(boolean r2) {
            this.P.mCancelable = r2;
            return this;
        }

        public Builder setCursor(Cursor r3, DialogInterface.OnClickListener r4, String r5) {
            Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mCursor = r6;
            this.P.mLabelColumn = r5;
            this.P.mOnClickListener = r7;
            return this;
        }

        public Builder setCustomTitle(View r2) {
            this.P.mCustomTitleView = r2;
            return this;
        }

        public Builder setIcon(int r2) {
            this.P.mIconId = r2;
            return this;
        }

        public Builder setIcon(Drawable r2) {
            this.P.mIcon = r2;
            return this;
        }

        public Builder setIconAttribute(int r4) {
            TypedValue r0 = new TypedValue();
            this.P.mContext.getTheme().resolveAttribute(r4, r0, true);
            AlertController.AlertParams r5 = this.P;
            r5.mIconId = r0.resourceId;
            return this;
        }

        @Deprecated
        public Builder setInverseBackgroundForced(boolean r2) {
            this.P.mForceInverseBackground = r2;
            return this;
        }

        public Builder setItems(int r4, DialogInterface.OnClickListener r5) {
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            AlertController.AlertParams r0 = this.P;
            r0.mItems = ZeusTransformUtils.getResources(r0.mContext, "com.obric.memorydata.plugin").getTextArray(r4);
            this.P.mOnClickListener = r6;
            return this;
        }

        public Builder setItems(CharSequence[] r3, DialogInterface.OnClickListener r4) {
            DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mItems = r3;
            this.P.mOnClickListener = r5;
            return this;
        }

        public Builder setMessage(int r3) {
            AlertController.AlertParams r0 = this.P;
            r0.mMessage = r0.mContext.getText(r3);
            return this;
        }

        public Builder setMessage(CharSequence r3) {
            this.P.mMessage = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setMultiChoiceItems(int r4, boolean[] r5, DialogInterface.OnMultiChoiceClickListener r6) {
            DialogInterface.OnMultiChoiceClickListener r7 = (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin");
            AlertController.AlertParams r0 = this.P;
            r0.mItems = ZeusTransformUtils.getResources(r0.mContext, "com.obric.memorydata.plugin").getTextArray(r4);
            this.P.mOnCheckboxClickListener = r7;
            this.P.mCheckedItems = r5;
            this.P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor r3, String r4, String r5, DialogInterface.OnMultiChoiceClickListener r6) {
            Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            DialogInterface.OnMultiChoiceClickListener r8 = (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin");
            this.P.mCursor = r7;
            this.P.mOnCheckboxClickListener = r8;
            this.P.mIsCheckedColumn = r4;
            this.P.mLabelColumn = r5;
            this.P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] r3, boolean[] r4, DialogInterface.OnMultiChoiceClickListener r5) {
            DialogInterface.OnMultiChoiceClickListener r6 = (DialogInterface.OnMultiChoiceClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnMultiChoiceClickListener.class, "com.obric.memorydata.plugin");
            this.P.mItems = r3;
            this.P.mOnCheckboxClickListener = r6;
            this.P.mCheckedItems = r4;
            this.P.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(int r3, DialogInterface.OnClickListener r4) {
            DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            AlertController.AlertParams r0 = this.P;
            r0.mNegativeButtonText = r0.mContext.getText(r3);
            this.P.mNegativeButtonListener = r5;
            return this;
        }

        public Builder setNegativeButton(CharSequence r3, DialogInterface.OnClickListener r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mNegativeButtonText = r5;
            this.P.mNegativeButtonListener = r6;
            return this;
        }

        public Builder setNegativeButtonIcon(Drawable r2) {
            this.P.mNegativeButtonIcon = r2;
            return this;
        }

        public Builder setNeutralButton(int r3, DialogInterface.OnClickListener r4) {
            DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            AlertController.AlertParams r0 = this.P;
            r0.mNeutralButtonText = r0.mContext.getText(r3);
            this.P.mNeutralButtonListener = r5;
            return this;
        }

        public Builder setNeutralButton(CharSequence r3, DialogInterface.OnClickListener r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mNeutralButtonText = r5;
            this.P.mNeutralButtonListener = r6;
            return this;
        }

        public Builder setNeutralButtonIcon(Drawable r2) {
            this.P.mNeutralButtonIcon = r2;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener r3) {
            this.P.mOnCancelListener = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener r3) {
            this.P.mOnDismissListener = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener r3) {
            this.P.mOnItemSelectedListener = (AdapterView.OnItemSelectedListener) ZeusTransformUtils.wrapperContextForParams(r3, AdapterView.OnItemSelectedListener.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener r3) {
            this.P.mOnKeyListener = (DialogInterface.OnKeyListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnKeyListener.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setPositiveButton(int r3, DialogInterface.OnClickListener r4) {
            DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            AlertController.AlertParams r0 = this.P;
            r0.mPositiveButtonText = r0.mContext.getText(r3);
            this.P.mPositiveButtonListener = r5;
            return this;
        }

        public Builder setPositiveButton(CharSequence r3, DialogInterface.OnClickListener r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mPositiveButtonText = r5;
            this.P.mPositiveButtonListener = r6;
            return this;
        }

        public Builder setPositiveButtonIcon(Drawable r2) {
            this.P.mPositiveButtonIcon = r2;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean r2) {
            this.P.mRecycleOnMeasure = r2;
            return this;
        }

        public Builder setSingleChoiceItems(int r4, int r5, DialogInterface.OnClickListener r6) {
            DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            AlertController.AlertParams r0 = this.P;
            r0.mItems = ZeusTransformUtils.getResources(r0.mContext, "com.obric.memorydata.plugin").getTextArray(r4);
            this.P.mOnClickListener = r7;
            this.P.mCheckedItem = r5;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor r3, int r4, String r5, DialogInterface.OnClickListener r6) {
            Cursor r7 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r8 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mCursor = r7;
            this.P.mOnClickListener = r8;
            this.P.mCheckedItem = r4;
            this.P.mLabelColumn = r5;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter r3, int r4, DialogInterface.OnClickListener r5) {
            ListAdapter r6 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.memorydata.plugin");
            DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mAdapter = r6;
            this.P.mOnClickListener = r7;
            this.P.mCheckedItem = r4;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] r3, int r4, DialogInterface.OnClickListener r5) {
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
            this.P.mItems = r3;
            this.P.mOnClickListener = r6;
            this.P.mCheckedItem = r4;
            this.P.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(int r3) {
            AlertController.AlertParams r0 = this.P;
            r0.mTitle = r0.mContext.getText(r3);
            return this;
        }

        public Builder setTitle(CharSequence r3) {
            this.P.mTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setView(int r3) {
            this.P.mView = null;
            this.P.mViewLayoutResId = r3;
            this.P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View r2) {
            this.P.mView = r2;
            this.P.mViewLayoutResId = 0;
            this.P.mViewSpacingSpecified = false;
            return this;
        }

        @Deprecated
        public Builder setView(View r2, int r3, int r4, int r5, int r6) {
            this.P.mView = r2;
            this.P.mViewLayoutResId = 0;
            this.P.mViewSpacingSpecified = true;
            this.P.mViewSpacingLeft = r3;
            this.P.mViewSpacingTop = r4;
            this.P.mViewSpacingRight = r5;
            this.P.mViewSpacingBottom = r6;
            return this;
        }

        public AlertDialog show() {
            AlertDialog r0 = create();
            r0.show();
            return r0;
        }
    }

    public AlertDialog(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 0);
    }

    public AlertDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r5, resolveDialogTheme(r5, r4));
        this.mAlert = new AlertController((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, getWindow());
    }

    public AlertDialog(Context r3, boolean r4, DialogInterface.OnCancelListener r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        DialogInterface.OnCancelListener r7 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
        this(r6, 0);
        setCancelable(r4);
        setOnCancelListener(r7);
    }

    static int resolveDialogTheme(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (((r5 >>> 24) & 255) < 1) goto L5;
        return r5;
    L5:
        TypedValue r7 = new TypedValue();
        r6.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.alertDialogTheme, "attr", "alertDialogTheme"), r7, true);
        return r7.resourceId;
    }

    public Button getButton(int r1) {
        return this.mAlert.getButton(r1);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (this.mAlert.onKeyDown(r2, r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r2, r3);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        if (this.mAlert.onKeyUp(r2, r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyUp(r2, r3);
    }

    public void setButton(int r9, CharSequence r10, DialogInterface.OnClickListener r11) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        this.mAlert.setButton(r9, r4, r5, null, null);
    }

    public void setButton(int r9, CharSequence r10, Drawable r11, DialogInterface.OnClickListener r12) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.memorydata.plugin");
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, DialogInterface.OnClickListener.class, "com.obric.memorydata.plugin");
        this.mAlert.setButton(r9, r4, r5, null, r11);
    }

    public void setButton(int r7, CharSequence r8, Message r9) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        this.mAlert.setButton(r7, r2, null, r9, null);
    }

    void setButtonPanelLayoutHint(int r1) {
        this.mAlert.setButtonPanelLayoutHint(r1);
    }

    public void setCustomTitle(View r1) {
        this.mAlert.setCustomTitle(r1);
    }

    public void setIcon(int r1) {
        this.mAlert.setIcon(r1);
    }

    public void setIcon(Drawable r1) {
        this.mAlert.setIcon(r1);
    }

    public void setIconAttribute(int r5) {
        TypedValue r0 = new TypedValue();
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().resolveAttribute(r5, r0, true);
        this.mAlert.setIcon(r0.resourceId);
    }

    public void setMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mAlert.setMessage(r4);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        super.setTitle(r4);
        this.mAlert.setTitle(r4);
    }

    public void setView(View r1) {
        this.mAlert.setView(r1);
    }

    public void setView(View r7, int r8, int r9, int r10, int r11) {
        this.mAlert.setView(r7, r8, r9, r10, r11);
    }
}
