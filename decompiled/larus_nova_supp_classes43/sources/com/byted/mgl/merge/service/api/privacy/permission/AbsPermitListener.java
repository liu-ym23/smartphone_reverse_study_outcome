package com.byted.mgl.merge.service.api.privacy.permission;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AbsPermitListener {
    private static final String TAG = "PermissionsResultListener";
    private boolean mAnyPermissionDenied;
    private Looper mLooper;
    private final Set<String> mPermissions;
    private final List<PermitResult> mResultList;

    public abstract void onDenied(List<PermitResult> r1);

    public abstract void onGranted();

    public synchronized boolean shouldInvokeImmediatelyWhenDenied() {
        monitor-enter(this);
        monitor-exit(this);
        return true;
    }

    public AbsPermitListener() {
        this.mPermissions = new HashSet(1);
        this.mResultList = new ArrayList();
        this.mAnyPermissionDenied = false;
        this.mLooper = Looper.getMainLooper();
    }

    public AbsPermitListener(Looper r10) {
        this.mPermissions = new HashSet(1);
        this.mResultList = new ArrayList();
        this.mAnyPermissionDenied = false;
        Looper.getMainLooper();
        this.mLooper = r10;
    }

    public static /* synthetic */ List access$000(AbsPermitListener r0) {
        return r0.mResultList;
    }

    public final synchronized void registerPermissions(Set<String> r10) {
        monitor-enter(this);
        this.mPermissions.addAll(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean shouldIgnorePermissionNotFound(String r10) {
        monitor-enter(this);
        BdpManager.getInst().getService(BdpLogService.class).d(TAG, "Permission not found: " + r10);     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isDenied(String r10, PermitResult.Type r11) {
        if (r11 != PermitResult.Type.DENIED) goto L5;
    L10:
        return true;
    L5:
        if (shouldIgnorePermissionNotFound(r10) == false) goto L7;
    L9:
        return false;
    L7:
        if (r11 != PermitResult.Type.NOT_FOUND) goto L9;
        goto L9
    }

    public final synchronized boolean onResult(String r10, PermitResult.Type r11, boolean r12) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.mPermissions.remove(r10) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        PermitResult r0 = new PermitResult(r10, r11, r12);     // Catch: Throwable -> L26
        this.mResultList.add(r0);     // Catch: Throwable -> L26
        boolean r13 = isDenied(r10, r0.resultType);     // Catch: Throwable -> L26
        if (shouldInvokeImmediatelyWhenDenied() == false) goto L14;
        if (r13 == false) goto L14;
        new Handler(this.mLooper).post(new AnonymousClass1(this));     // Catch: Throwable -> L26
        monitor-exit(this);
        return true;
    L14:
        if (r13 == false) goto L17;
        this.mAnyPermissionDenied = true;     // Catch: Throwable -> L26
    L17:
        if (this.mPermissions.isEmpty() == true) goto L19;
        monitor-exit(this);
        return false;
    L19:
        if (this.mAnyPermissionDenied == false) goto L21;
        new Handler(this.mLooper).post(new AnonymousClass2(this));     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return true;
    L21:
        new Handler(this.mLooper).post(new AnonymousClass3(this));     // Catch: Throwable -> L26
        goto L22
    }

    public final synchronized boolean onResult(String r1, int r10, boolean r11) {
        monitor-enter(this);
        if (r10 != 0) goto L7;
        boolean r12 = onResult(r1, PermitResult.Type.GRANTED, r11);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L7:
        boolean r13 = onResult(r1, PermitResult.Type.DENIED, r11);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r13;
    L10:
        th = move-exception;
        throw th;
    }
}
