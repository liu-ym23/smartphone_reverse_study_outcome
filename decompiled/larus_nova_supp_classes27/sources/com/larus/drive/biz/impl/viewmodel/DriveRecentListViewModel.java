package com.larus.drive.biz.impl.viewmodel;

import com.larus.drive.biz.api.model.DriveListLoadType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/DriveRecentListViewModel;", "Lcom/larus/drive/biz/impl/viewmodel/AbsDriveListViewModel;", "<init>", "()V", "getTag", "", "driveListLoadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "getDriveListLoadType", "()Lcom/larus/drive/biz/api/model/DriveListLoadType;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveRecentListViewModel extends AbsDriveListViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveRecentListViewModel";
    private final DriveListLoadType driveListLoadType;

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

    public DriveRecentListViewModel() {
        this.driveListLoadType = DriveListLoadType.RECENT;
    }

    @Override // com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel
    public DriveListLoadType getDriveListLoadType() {
        return this.driveListLoadType;
    }
}
