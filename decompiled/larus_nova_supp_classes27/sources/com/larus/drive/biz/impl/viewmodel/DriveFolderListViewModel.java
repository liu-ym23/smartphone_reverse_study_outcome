package com.larus.drive.biz.impl.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/DriveFolderListViewModel;", "Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "<init>", "()V", "folderName", "", "getTag", "setShowOnlyFolderValue", "", "showOnlyFolder", "", "setFolder", "folderToken", "folderDriveToken", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFolderListViewModel extends AbsDriveListViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveFolderListViewModel";
    private String folderName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel
    public String getTag() {
        return TAG;
    }

    public DriveFolderListViewModel() {
    }

    public final void setShowOnlyFolderValue(boolean r1) {
        setShowOnlyFolder(r1);
    }

    public final void setFolder(String r1, String r2, String r3) {
        setFolderToken(r1);
        this.folderName = r2;
        setFolderDriveToken(r3);
    }
}
