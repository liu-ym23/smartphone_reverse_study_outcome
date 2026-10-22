package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    @Nullable
    private final Activity mActivity;

    @NonNull
    private final Context mContext;
    final FragmentManager mFragmentManager;

    @NonNull
    private final Handler mHandler;
    private final int mWindowAnimations;

    public FragmentHostCallback(@NonNull Context r5, @NonNull Handler r10, int r11) {
        if ((r5 instanceof Activity) == false) goto L5;
        Activity r12 = (Activity) r5;
    L6:
        this(r12, r5, r10, r11);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Handler getHandler() {
        return this.mHandler;
    }

    public void onDump(@NonNull String r5, @Nullable FileDescriptor r10, @NonNull PrintWriter r11, @Nullable String[] r12) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int r5) {
        return null;
    }

    @Nullable
    public abstract E onGetHost();

    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.mContext);
    }

    public int onGetWindowAnimations() {
        return this.mWindowAnimations;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    @Deprecated
    public void onRequestPermissionsFromFragment(@NonNull Fragment r5, @NonNull String[] r10, int r11) {
    }

    public boolean onShouldSaveFragmentState(@NonNull Fragment r5) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String r5) {
        return false;
    }

    public void onStartActivityFromFragment(@NonNull Fragment r5, @NonNull Intent r10, int r11) {
        onStartActivityFromFragment(r5, r10, r11, null);
    }

    @Deprecated
    public void onStartIntentSenderFromFragment(@NonNull Fragment r10, @NonNull IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) throws IntentSender.SendIntentException {
        if (r12 != (-1)) goto L7;
        ActivityCompat.startIntentSenderForResult(this.mActivity, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    public FragmentHostCallback(@NonNull FragmentActivity r5) {
        this(r5, r5, new Handler(), 0);
    }

    public void onStartActivityFromFragment(@NonNull Fragment r5, @NonNull Intent r10, int r11, @Nullable Bundle r12) {
        if (r11 != (-1)) goto L7;
        ContextCompat.startActivity(this.mContext, r10, r12);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public FragmentHostCallback(@Nullable Activity r5, @NonNull Context r10, @NonNull Handler r11, int r12) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = r5;
        this.mContext = (Context) Preconditions.checkNotNull(r10, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(r11, "handler == null");
        this.mWindowAnimations = r12;
    }
}
