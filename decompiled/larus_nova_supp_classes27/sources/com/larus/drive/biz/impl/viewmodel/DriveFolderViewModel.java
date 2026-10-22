package com.larus.drive.biz.impl.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u00020\u0007H\u0014¨\u0006\f"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/DriveFolderViewModel;", "Lcom/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel;", "<init>", "()V", "setCurrentFolderTokenValue", "", "folderToken", "", "setCurrentFolderDriveTokenValue", "driveToken", "getTag", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFolderViewModel extends AbsDrivePageViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveFolderViewModel";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larus.drive.biz.impl.viewmodel.AbsDrivePageViewModel
    public String getTag() {
        return TAG;
    }

    public DriveFolderViewModel() {
    }

    public final void setCurrentFolderDriveTokenValue(String r1) {
        setCurrentFolderDriveToken(r1);
    }

    public final void setCurrentFolderTokenValue(String r1) {
        setCurrentFolderToken(r1);
    }
}
