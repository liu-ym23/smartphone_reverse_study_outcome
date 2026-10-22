package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class Permissions {
    static final Impl IMPL = null;

    public static class BaseImpl implements Impl {
        final Handler mHandler;

        public BaseImpl() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r8, final String[] r10, final Callback r11) {
            this.mHandler.post(new AnonymousClass1(this, r11, r10));
        }
    }

    public interface Callback {
        void onRequestPermissionResult(String[] r8, int[] r10);
    }

    public interface Impl {
        void requestPermissions(Activity r8, String[] r10, Callback r11);
    }

    public static class MarshmallowImpl implements Impl {
        public MarshmallowImpl() {
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r8, String[] r10, Callback r11) {
            if (((PermissionFragment) r8.getFragmentManager().findFragmentByTag("permissions")) != null) goto L6;
            PermissionFragment r12 = new PermissionFragment();
            Bundle r13 = new Bundle();
            r13.putStringArray("permissions", r10);
            r12.setArguments(r13);
            r12.mCallback = r11;
            r8.getFragmentManager().beginTransaction().add(r12, "permissions").commitAllowingStateLoss();
            return;
        }
    }

    static {
        if (systemSupportsRuntimePermission() == false) goto L5;
        Impl r8 = new MarshmallowImpl();
    L6:
        IMPL = r8;
        return;
    L5:
        r8 = new BaseImpl();
        goto L6
    }

    public Permissions() {
    }

    public static void requestPermissions(Activity r8, String[] r10, Callback r11) {
        IMPL.requestPermissions(r8, r10, r11);
    }

    public static boolean systemSupportsRuntimePermission() {
        return true;
    }
}
