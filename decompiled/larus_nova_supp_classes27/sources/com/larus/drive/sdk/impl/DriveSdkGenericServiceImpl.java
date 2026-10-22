package com.larus.drive.sdk.impl;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.larus.drive.sdk.api.IDriveSdkGenericService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.gallery.DriveGalleryHelper;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import z79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J(\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/drive/sdk/impl/DriveSdkGenericServiceImpl;", "Lcom/larus/drive/sdk/api/IDriveSdkGenericService;", "<init>", "()V", "fileService", "Lcom/larus/drive/sdk/api/service/IDriveFileService;", "getDriveFilePermission", "", "fileToken", "", "getDriveFilePermissionLiveData", "Landroidx/lifecycle/LiveData;", "getDriveMetaInfo", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "validateDriveFileInLarkSecurityControl", "", "fileType", "operation", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDriveMetaInfo", "", "info", "fetchDriveFileInfo", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "fileObjType", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkGenericServiceImpl implements IDriveSdkGenericService {
    public final e89.c a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkGenericService
    public final a89.a o() {
        a89.a r0 = com.larus.drive.sdk.impl.utils.h.a;
        return com.larus.drive.sdk.impl.utils.h.a;
    }

    public DriveSdkGenericServiceImpl() {
        this.a = com.larus.drive.sdk.impl.service.t.a();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkGenericService
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        return this.a.c(r2);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkGenericService
    public final LiveData<Boolean> d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        return this.a.d(r2);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkGenericService
    public final void n(a89.a r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        a89.a r1 = com.larus.drive.sdk.impl.utils.h.a;
        Intrinsics.checkNotNullParameter(r4, "info");
        FLogger.a.i("DriveInfoHelper", "[updateDriveMetaInfo] driveHit=" + r4.a);
        com.larus.drive.sdk.impl.utils.h.a = r4;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkGenericService
    public final void m(b r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "galleryContext");
        DriveGalleryHelper r3 = DriveGalleryHelper.a;
        DriveGalleryHelper.d(r1);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkGenericService
    public final Object b(String r2, int r3, boolean r4, Continuation<? super DriveFileItem> r5) {
        return com.larus.drive.sdk.impl.service.t.a().b(r2, r3, r4, r5);
    }
}
