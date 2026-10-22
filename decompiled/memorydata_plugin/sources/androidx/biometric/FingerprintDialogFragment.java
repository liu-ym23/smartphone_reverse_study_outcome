package androidx.biometric;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintDialogFragment extends DialogFragment {
    private static final String ARG_HOST_ACTIVITY = "host_activity";
    private static final int MESSAGE_DISPLAY_TIME_MS = 2000;
    static final int STATE_FINGERPRINT = 1;
    static final int STATE_FINGERPRINT_AUTHENTICATED = 3;
    static final int STATE_FINGERPRINT_ERROR = 2;
    static final int STATE_NONE = 0;
    private static final String TAG = "FingerprintFragment";
    private int mErrorTextColor;
    private ImageView mFingerprintIcon;
    final Handler mHandler;
    TextView mHelpMessageView;
    private int mNormalTextColor;
    final Runnable mResetDialogRunnable;
    BiometricViewModel mViewModel;

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void startAnimation(Drawable r2) {
            if (ZeusTransformUtils.instanceOf(r2, AnimatedVectorDrawable.class) == false) goto L6;
            ((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(r2, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin")).start();
            return;
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static int getColorErrorAttr() {
            return ZeusTransformUtils.mapRes(R.attr.colorError, "attr", "colorError");
        }
    }

    private FingerprintDialogFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mResetDialogRunnable = new AnonymousClass1(this);
    }

    private void connectViewModel() {
        BiometricViewModel r0 = BiometricPrompt.getViewModel(this, isHostedInActivity());
        this.mViewModel = r0;
        r0.getFingerprintDialogState().observe(this, new AnonymousClass3(this));
        this.mViewModel.getFingerprintDialogHelpMessage().observe(this, new AnonymousClass4(this));
    }

    private Drawable getAssetForTransition(int r6, int r7) {
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        Log.w(TAG, "Unable to get asset. Context is null.");
        return null;
    L7:
        if (r6 != 0) goto L11;
        if (r7 != 1) goto L11;
    L9:
        int r8 = ZeusTransformUtils.mapRes(R.drawable.fingerprint_dialog_fp_icon, "drawable", "fingerprint_dialog_fp_icon");
    L22:
        return ContextCompat.getDrawable(r5, r8);
    L11:
        if (r6 != 1) goto L14;
        if (r7 != 2) goto L14;
        r8 = ZeusTransformUtils.mapRes(R.drawable.fingerprint_dialog_error, "drawable", "fingerprint_dialog_error");
    L14:
        if (r6 != 2) goto L17;
        if (r7 == 1) goto L9;
    L17:
        if (r6 == 1) goto L19;
    L23:
        return null;
    L19:
        if (r7 != 3) goto L23;
        goto L23
    }

    private int getThemedColorFor(int r5) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        Log.w(TAG, "Unable to get themed color. Context or activity is null.");
        return 0;
    L6:
        TypedValue r1 = new TypedValue();
        r4.getTheme().resolveAttribute(r5, r1, true);
        TypedArray r6 = r4.obtainStyledAttributes(r1.data, new int[]{r5});
        int r7 = r6.getColor(0, 0);
        r6.recycle();
        return r7;
    }

    private boolean isHostedInActivity() {
        return getArguments().getBoolean(ARG_HOST_ACTIVITY, true);
    }

    static FingerprintDialogFragment newInstance(boolean r3) {
        FingerprintDialogFragment r0 = new FingerprintDialogFragment();
        Bundle r1 = new Bundle();
        r1.putBoolean(ARG_HOST_ACTIVITY, r3);
        r0.setArguments(r1);
        return r0;
    }

    private boolean shouldAnimateForTransition(int r3, int r4) {
        if (r3 != 0) goto L7;
        if (r4 != 1) goto L7;
        return false;
    L7:
        if (r3 != 1) goto L10;
        if (r4 != 2) goto L10;
        return true;
    L10:
        if (r3 != 2) goto L13;
        if (r4 != 1) goto L13;
        return true;
    L13:
        if (r3 == 1) goto L15;
    L16:
        return false;
    L15:
        if (r4 != 3) goto L16;
        goto L16
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r3) {
        super.onCancel((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin"));
        this.mViewModel.setFingerprintDialogCancelPending(true);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        connectViewModel();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        int r5 = getThemedColorFor(Api26Impl.getColorErrorAttr());
    L5:
        this.mErrorTextColor = r5;
        this.mNormalTextColor = getThemedColorFor(android.R.attr.textColorSecondary);
        return;
    L6:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L9;
        r5 = ContextCompat.getColor(r6, ZeusTransformUtils.mapRes(R.color.biometric_error_color, TypedValues.Custom.S_COLOR, "biometric_error_color"));
        goto L5
    L9:
        r5 = 0;
        goto L5
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r9) {
        AlertDialog.Builder r10 = new AlertDialog.Builder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r10.setTitle(this.mViewModel.getTitle());
        View r0 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.fingerprint_dialog_layout, "layout", "fingerprint_dialog_layout"), null, "com.obric.memorydata.plugin");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.fingerprint_subtitle, OaidModel.KEY_ID, "fingerprint_subtitle")), TextView.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        CharSequence r6 = this.mViewModel.getSubtitle();
        if (TextUtils.isEmpty(r6) == false) goto L7;
        r2.setVisibility(8);
        goto L8
    L7:
        r2.setVisibility(0);
        r2.setText(r6);
    L8:
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.fingerprint_description, OaidModel.KEY_ID, "fingerprint_description")), TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        CharSequence r7 = this.mViewModel.getDescription();
        if (TextUtils.isEmpty(r7) == false) goto L13;
        r3.setVisibility(8);
        goto L14
    L13:
        r3.setVisibility(0);
        r3.setText(r7);
    L14:
        this.mFingerprintIcon = (ImageView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.fingerprint_icon, OaidModel.KEY_ID, "fingerprint_icon")), ImageView.class, "com.obric.memorydata.plugin");
        this.mHelpMessageView = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.fingerprint_error, OaidModel.KEY_ID, "fingerprint_error")), TextView.class, "com.obric.memorydata.plugin");
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L17;
        CharSequence r1 = getString(ZeusTransformUtils.mapRes(R.string.confirm_device_credential_password, TypedValues.Custom.S_STRING, "confirm_device_credential_password"));
    L18:
        r10.setNegativeButton(r1, new AnonymousClass2(this));
        r10.setView(r0);
        AlertDialog r8 = r10.create();
        r8.setCanceledOnTouchOutside(false);
        return r8;
    L17:
        r1 = this.mViewModel.getNegativeButtonText();
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mViewModel.setFingerprintDialogPreviousState(0);
        this.mViewModel.setFingerprintDialogState(1);
        this.mViewModel.setFingerprintDialogHelpMessage(getString(ZeusTransformUtils.mapRes(R.string.fingerprint_dialog_touch_sensor, TypedValues.Custom.S_STRING, "fingerprint_dialog_touch_sensor")));
    }

    void resetDialog() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Log.w(TAG, "Not resetting the dialog. Context is null.");
        return;
    L6:
        this.mViewModel.setFingerprintDialogState(1);
        this.mViewModel.setFingerprintDialogHelpMessage(r0.getString(ZeusTransformUtils.mapRes(R.string.fingerprint_dialog_touch_sensor, TypedValues.Custom.S_STRING, "fingerprint_dialog_touch_sensor")));
    }

    void updateFingerprintIcon(int r4) {
        if (this.mFingerprintIcon != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L15;
        int r0 = this.mViewModel.getFingerprintDialogPreviousState();
        Drawable r1 = getAssetForTransition(r0, r4);
        if (r1 != null) goto L10;
        return;
    L10:
        this.mFingerprintIcon.setImageDrawable(r1);
        if (shouldAnimateForTransition(r0, r4) == false) goto L13;
        Api21Impl.startAnimation(r1);
    L13:
        this.mViewModel.setFingerprintDialogPreviousState(r4);
        return;
    }

    void updateHelpMessageColor(int r3) {
        TextView r0 = this.mHelpMessageView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 2) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        int r2 = this.mErrorTextColor;
    L11:
        r0.setTextColor(r2);
        return;
    L10:
        r2 = this.mNormalTextColor;
        goto L11
    L7:
        r4 = false;
        goto L8
    }

    void updateHelpMessageText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        TextView r2 = this.mHelpMessageView;
        if (r2 == null) goto L6;
        r2.setText(r4);
        return;
    }
}
