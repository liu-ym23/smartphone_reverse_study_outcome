package com.ss.android.lark.integrator.todo.dependency;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToLocalMenuV2;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements g7c.e {

    public static final class a {
    }

    static {
    }

    public m() {
    }

    public final int c(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "keys");
        return ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDriveSdkWrapper().d0().d((String[]) r3.toArray(new String[0]));
    }

    public final void a(Context r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter("task", "mountPoint");
        Intrinsics.checkNotNullParameter(r10, "fileToken");
        SpaceThirdPartyOpenEntity r0 = new SpaceThirdPartyOpenEntity("73", r10, r11, DriveBizScene.DriveBizScene_TASK, DriveWatermarkScene.DriveWatermarkScene_TASK_ATTACHMENT_DOWNLOAD);
        r0.setMountPoint("task");
        r0.setPreviewFrom("thirdparty_attachment");
        r0.setDownloadFrom("from_docs_attachment_preview_download");
        ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDriveSdkWrapper().b(r9, r0);
    }

    public final String b(Uri r15, String r16, final g8c.c.a r17) {
        Intrinsics.checkNotNullParameter(r15, "uri");
        Intrinsics.checkNotNullParameter(r16, "fileName");
        Intrinsics.checkNotNullParameter("", "mountNodePoint");
        Intrinsics.checkNotNullParameter("task", "mountPoint");
        Intrinsics.checkNotNullParameter(r17, "callback");
        DrivePriority.UploadPriority r1 = DrivePriority.UploadPriority.DEFAULT;
        r1.getPriority();
        UploadRequestInfo.UploadType r8 = UploadRequestInfo.UploadType.DRIVE;
        UploadRequestInfo r13 = new UploadRequestInfo("", r15.toString(), r16, "", "task", "", r1.getPriority(), r8, null, null, null, new TodoCCMDependency$upload$builder$1(r17));
        return ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDriveSdkWrapper().d0().s(r13);
    }

    public final void d(Context r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter("task", "mountPoint");
        Intrinsics.checkNotNullParameter(r10, "fileToken");
        SpaceThirdPartyOpenEntity r0 = new SpaceThirdPartyOpenEntity("73", r10, r11, DriveBizScene.DriveBizScene_TASK, DriveWatermarkScene.DriveWatermarkScene_TASK_ATTACHMENT_DOWNLOAD);
        ArrayList r12 = new ArrayList();
        r12.add(new SaveToLocalMenuV2());
        r12.add(new OpenExternalMenu("LARK-PSDA-ccm_drive_todofile_openexternal"));
        SaveToSpaceMenu r13 = new SaveToSpaceMenu();
        ((BaseMoreMenuAction) r13).k = false;
        r12.add(r13);
        r0.setMoreMenuActions(r12);
        r0.setMountPoint("task");
        r0.setPreviewFrom("thirdparty_attachment");
        r0.setUseLarkPreview(true);
        ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDriveSdkWrapper().a(r9, r0);
    }

    public final String e(String r15, String r16, final g8c.c.a r17) {
        Intrinsics.checkNotNullParameter(r15, "localPath");
        Intrinsics.checkNotNullParameter(r16, "fileName");
        Intrinsics.checkNotNullParameter("", "mountNodePoint");
        Intrinsics.checkNotNullParameter("task", "mountPoint");
        Intrinsics.checkNotNullParameter(r17, "callback");
        DrivePriority.UploadPriority r1 = DrivePriority.UploadPriority.DEFAULT;
        r1.getPriority();
        UploadRequestInfo.UploadType r8 = UploadRequestInfo.UploadType.DRIVE;
        UploadRequestInfo r13 = new UploadRequestInfo(r15, "", r16, "", "task", "", r1.getPriority(), r8, null, null, null, new TodoCCMDependency$upload$uploadRequestInfo$1(r17));
        return ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDriveSdkWrapper().d0().s(r13);
    }
}
