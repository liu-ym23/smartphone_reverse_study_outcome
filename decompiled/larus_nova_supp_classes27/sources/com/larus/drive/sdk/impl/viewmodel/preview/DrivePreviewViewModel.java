package com.larus.drive.sdk.impl.viewmodel.preview;

import androidx.lifecycle.ViewModel;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.im.bean.message.ImageObj;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import y79.c;
import y79.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/larus/drive/sdk/impl/viewmodel/preview/DrivePreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "buildSendDriveFileInfo", "Lcom/larus/drive/sdk/api/file/upload/SendDriveFileInfo;", "sendText", "", "file", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewViewModel extends ViewModel {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public DrivePreviewViewModel() {
    }

    public final c buildSendDriveFileInfo(String r20, DriveFileItem r21) {
        if (r21 == null) goto L5;
        DriveFileType r1 = r21.j;
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L10;
        int r10 = 2;
    L15:
        ImageObj r3 = new ImageObj(r21.e, 0, 0, null, null, 30, null);
        return new c(r20, "keyboard", CollectionsKt.listOf(new d(r21.a, r21.b, r21.e, r21.e(), r10, r21.d, r3, r3, 768)), 2);
    L10:
        if (r2 == 3) goto L12;
        r10 = 0;
        goto L15
    L12:
        r10 = 3;
        goto L15
    L14:
        r10 = 1;
        goto L15
    L5:
        return new c(null, null, null, 15);
    }
}
