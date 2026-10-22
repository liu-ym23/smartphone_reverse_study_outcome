package com.larus.drive.biz.impl;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadCancelReason;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadHandle;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadLevel;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadScene;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadState;
import com.larus.drive.biz.api.DriveEnterContext;
import com.larus.drive.biz.api.DrivePreloadScene;
import com.larus.drive.biz.api.IDriveService;
import com.larus.drive.biz.impl.file.t;
import com.larus.drive.biz.impl.view.DriveMainFragment;
import com.larus.drive.biz.impl.view.space.DriveOfficeSpaceHostFragment;
import com.larus.drive.biz.impl.view.space.g;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.exp.i;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gk5.e;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J(\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/drive/biz/impl/DriveServiceImpl;", "Lcom/larus/drive/biz/api/IDriveService;", "<init>", "()V", "latestPreloadToken", "Lcom/larus/drive/biz/api/DrivePreloadToken;", "createDriveManageFragment", "Landroidx/fragment/app/Fragment;", "enterFrom", "", "context", "Lcom/larus/drive/biz/api/DriveEnterContext;", "preloadDriveManagePage", "scene", "Lcom/larus/drive/biz/api/DrivePreloadScene;", "clearOfficePreload", "", "reason", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadCancelReason;", "clearDrivePreloadCache", "clearDriveUploadTasks", "getCurrentDrivePreviousPage", "reportPreloadDecision", "preloadId", "decision", "skipReason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveServiceImpl implements IDriveService {
    public g79.a b;

    public static final class a {
    }

    static {
    }

    public DriveServiceImpl() {
    }

    @Override // com.larus.drive.biz.api.IDriveService
    public final void h() {
        Lazy r0 = t.a;
        t.b();
    }

    @Override // com.larus.drive.biz.api.IDriveService
    public final String j() {
        WeakReference<DriveOfficeSpaceHostFragment> r0 = DriveOfficeSpaceHostFragment.w;
        if (r0 == null) goto L5;
        DriveOfficeSpaceHostFragment r1 = r0.get();
    L6:
        if (r1 == null) goto L11;
        String r2 = r1.b();
        if (r2 == null) goto L11;
        return r2;
    L11:
        WeakReference<DriveMainFragment> r3 = DriveMainFragment.w;
        DriveMainFragment r4 = DriveMainFragment.a.a();
        if (r4 != null) goto L14;
        return null;
    L14:
        return r4.b();
    L5:
        r1 = null;
        goto L6
    }

    public final void a(OfficeSpacePreloadCancelReason r5) {
        Unit r0 = null;
        this.b = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        IOfficeSdkServiceV2 r2 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        e r3 = r2.q0();     // Catch: Throwable -> L12
        if (r3 == null) goto L10;
        com.bytedance.ee.bear.office.export.space.a r4 = r3.e7();     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r4.g(r5);     // Catch: Throwable -> L12
        r0 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r6 = Result.constructor-impl(r0);     // Catch: Throwable -> L12
    L14:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L20;
        FLogger.a.w("DriveServiceImpl", "release office preload failed, reason=" + r5, r7);
        return;
    L20:
        return;
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.larus.drive.biz.api.IDriveService
    public final Fragment i(String r9) {
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        g79.a r0 = this.b;
        if (r0 == null) goto L5;
        String r7 = r0.c;
    L6:
        this.b = null;
        DriveEnterContext r1 = new DriveEnterContext(r9, UUID.randomUUID().toString(), SystemClock.uptimeMillis(), r7);
        Intrinsics.checkNotNullParameter(r1, "context");
        String r2 = com.larus.drive.biz.impl.utils.e.a;
        String r3 = r1.getEnterFrom();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        com.larus.drive.biz.impl.utils.e.a = r3;
        boolean r4 = i.a.a();
        FLogger.a.i("DriveServiceImpl", "Create drive fragment is new = " + r4);
        if (r4 == false) goto L9;
        WeakReference<DriveOfficeSpaceHostFragment> r5 = DriveOfficeSpaceHostFragment.w;
        Intrinsics.checkNotNullParameter(r1, "context");
        DriveOfficeSpaceHostFragment r10 = new DriveOfficeSpaceHostFragment();
        Bundle r6 = new Bundle();
        r6.putSerializable("drive_enter_context", r1);
        r10.setArguments(r6);
        return r10;
    L9:
        a(OfficeSpacePreloadCancelReason.LARK_DRIVE_DISABLED);
        return new DriveMainFragment();
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.drive.biz.api.IDriveService
    public final g79.a k(DrivePreloadScene r110) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        String r13 = UUID.randomUUID().toString();
        if (i.a.a() == true) goto L6;
        a(OfficeSpacePreloadCancelReason.LARK_DRIVE_DISABLED);
        b(r13, r110, "skip", "LARK_DRIVE_DISABLED");
        return null;
    L6:
        IOfficeSdkServiceV2 r0 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r0 != null) goto L45;
        b(r13, r110, "skip", "OFFICE_SDK_UNAVAILABLE");
        return null;
    L45:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        IOfficeSdkServiceV2.a.b(r0, false, "drive_space_preload", 5);     // Catch: Throwable -> L17
        e r1 = r0.q0();     // Catch: Throwable -> L17
        if (r1 == null) goto L14;
        com.bytedance.ee.bear.office.export.space.a r2 = r1.e7();     // Catch: Throwable -> L17
    L15:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r3) == false) goto L22;
        r3 = null;
    L22:
        com.bytedance.ee.bear.office.export.space.a r4 = (com.bytedance.ee.bear.office.export.space.a) r3;
        if (r4 != null) goto L26;
        b(r13, r110, "skip", "OFFICE_SDK_UNAVAILABLE");
        return null;
    L26:
        String r15 = "";
        b(r13, r110, "run", "");
        OfficeSpacePreloadHandle r5 = r4.a(new OfficeSpacePreloadRequest(r13, OfficeSpacePreloadScene.OFFICE_SDK_READY, SetsKt.setOf(new OfficeSpacePreloadLevel[]{OfficeSpacePreloadLevel.INIT, OfficeSpacePreloadLevel.DB}), g.a(false), 0, 0, 48, null));
        if (r5 == null) goto L29;
        String r7 = r5.getRequestId();
    L30:
        if (r5 == null) goto L32;
        String r8 = r5.getRequestKeyHash();
    L33:
        if (r5 == null) goto L39;
        OfficeSpacePreloadState r9 = r5.getState();
        if (r9 == null) goto L39;
        Map r10 = r9.getLevelStates();
        if (r10 == null) goto L39;
        String r14 = r10.toString();
    L40:
        if (r14 == null) goto L43;
        r15 = r14;
    L43:
        g79.a r11 = new g79.a(r13, r7, r8, r15);
        this.b = r11;
        return r11;
    L39:
        r14 = null;
        goto L40
    L32:
        r8 = null;
        goto L33
    L29:
        r7 = null;
        goto L30
    L14:
        r2 = null;
    L17:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static void b(String r3, DrivePreloadScene r4, String r5, String r6) {
        FLogger.a.i("DriveServiceImpl", "office_space_preload_decision preload_id=" + r3 + " scene=" + r4 + " decision=" + r5 + " skip_reason=" + r6 + " levels=INIT,DB device_level=unknown network_type=unknown ts=" + SystemClock.elapsedRealtime());
    }
}
