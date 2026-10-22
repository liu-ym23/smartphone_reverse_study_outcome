package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Permissions {
    static final Impl IMPL = null;

    static class BaseImpl implements Impl {
        final Handler mHandler;

        BaseImpl() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r3, final String[] r4, Callback r5) {
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            final Callback r7 = (Callback) ZeusTransformUtils.wrapperContextForParams(r5, Callback.class, "com.obric.memorydata.plugin");
            this.mHandler.post(new AnonymousClass1(this, r7, r4));
        }
    }

    public interface Callback {
        void onRequestPermissionResult(String[] r1, int[] r2);
    }

    interface Impl {
        void requestPermissions(Activity r1, String[] r2, Callback r3);
    }

    static class MarshmallowImpl implements Impl {
        MarshmallowImpl() {
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r4, String[] r5, Callback r6) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
            Callback r7 = (Callback) ZeusTransformUtils.wrapperContextForParams(r6, Callback.class, "com.obric.memorydata.plugin");
            if (((PermissionFragment) ZeusTransformUtils.preCheckCast(r3.getFragmentManager().findFragmentByTag("permissions"), PermissionFragment.class, "com.obric.memorydata.plugin")) != null) goto L6;
            PermissionFragment r8 = new PermissionFragment();
            Bundle r0 = new Bundle();
            r0.putStringArray("permissions", r5);
            r8.setArguments(r0);
            r8.mCallback = r7;
            r3.getFragmentManager().beginTransaction().add(r8, "permissions").commitAllowingStateLoss();
            return;
        }
    }

    static {
        if (systemSupportsRuntimePermission() == false) goto L5;
        Impl r0 = new MarshmallowImpl();
    L6:
        IMPL = r0;
        return;
    L5:
        r0 = new BaseImpl();
        goto L6
    }

    public Permissions() {
    }

    public static void requestPermissions(Activity r2, String[] r3, Callback r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
        IMPL.requestPermissions(r5, r3, r6);
    }

    public static boolean systemSupportsRuntimePermission() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }
}
