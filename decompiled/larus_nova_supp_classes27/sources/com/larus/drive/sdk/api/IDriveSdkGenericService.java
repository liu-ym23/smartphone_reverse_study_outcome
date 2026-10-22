package com.larus.drive.sdk.api;

import a89.a;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import z79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH&J*\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/larus/drive/sdk/api/IDriveSdkGenericService;", "", "getDriveFilePermission", "", "fileToken", "", "getDriveFilePermissionLiveData", "Landroidx/lifecycle/LiveData;", "getDriveMetaInfo", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "updateDriveMetaInfo", "", "info", "fetchDriveFileInfo", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "fileObjType", "", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateDriveFileInLarkSecurityControl", "fileType", "operation", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDriveSdkGenericService {
    Object b(String r1, int r2, boolean r3, Continuation<? super DriveFileItem> r4);

    boolean c(String r1);

    LiveData<Boolean> d(String r1);

    void m(b r1, Bundle r2);

    void n(a r1);

    a o();
}
