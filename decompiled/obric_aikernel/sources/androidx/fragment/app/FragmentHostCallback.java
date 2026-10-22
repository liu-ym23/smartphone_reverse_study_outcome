package androidx.fragment.app;

import android.annotation.SuppressLint;
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

    FragmentHostCallback(@Nullable Activity r10, @NonNull Context r11, @NonNull Handler r12, int r13) {
        this.mFragmentManager = new FragmentManagerImpl();
        this.mActivity = r10;
        this.mContext = (Context) Preconditions.checkNotNull(r11, "context == null");
        this.mHandler = (Handler) Preconditions.checkNotNull(r12, "handler == null");
        this.mWindowAnimations = r13;
    }

    public FragmentHostCallback(@NonNull Context r10, @NonNull Handler r11, int r12) {
        if ((r10 instanceof Activity) == false) goto L5;
        Activity r13 = (Activity) r10;
    L6:
        this(r13, r10, r11, r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    FragmentHostCallback(@NonNull FragmentActivity r10) {
        this(r10, r10, new Handler(), 0);
    }

    @Nullable
    Activity getActivity() {
        return this.mActivity;
    }

    @NonNull
    Context getContext() {
        return this.mContext;
    }

    @NonNull
    Handler getHandler() {
        return this.mHandler;
    }

    public void onDump(@NonNull String r10, @Nullable FileDescriptor r11, @NonNull PrintWriter r12, @Nullable String[] r13) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int r10) {
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
    public void onRequestPermissionsFromFragment(@NonNull Fragment r10, @NonNull String[] r11, int r12) {
    }

    public boolean onShouldSaveFragmentState(@NonNull Fragment r10) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String r10) {
        return false;
    }

    public void onStartActivityFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) Intent r11, int r12) {
        onStartActivityFromFragment(r10, r11, r12, null);
    }

    public void onStartActivityFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) Intent r11, int r12, @Nullable Bundle r13) {
        if (r12 != (-1)) goto L7;
        ContextCompat.startActivity(this.mContext, r11, r13);
        return;
    L7:
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void onStartIntentSenderFromFragment(@NonNull Fragment r10, @SuppressLint({"UnknownNullness"}) IntentSender r11, int r12, @Nullable Intent r13, int r14, int r15, int r16, @Nullable Bundle r17) {
        if (r12 != (-1)) goto L7;
        ActivityCompat.startIntentSenderForResult(this.mActivity, r11, r12, r13, r14, r15, r16, r17);
        return;
    L7:
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}
