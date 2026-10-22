package com.suite.lark.platform.component.storage.clean.resource;

import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/UniStoreFileResource;", "Lcom/suite/lark/platform/component/storage/clean/resource/FileCleanResource;", "path", "", "biz", "Lcom/ss/android/lark/diskmanage/Biz;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/diskmanage/Biz;)V", "vfsPath", "Lcom/ss/android/lark/vfs/VFSPath;", "(Lcom/ss/android/lark/vfs/VFSPath;Lcom/ss/android/lark/diskmanage/Biz;)V", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class UniStoreFileResource extends FileCleanResource {
    public UniStoreFileResource(VFSPath r2, Biz r3) {
        Intrinsics.checkNotNullParameter(r2, "vfsPath");
        Intrinsics.checkNotNullParameter(r3, "biz");
        this(r2.getAbsolutePath(), r3);
    }

    public UniStoreFileResource(String r2, Biz r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "biz");
        super(r2, r3);
    }
}
