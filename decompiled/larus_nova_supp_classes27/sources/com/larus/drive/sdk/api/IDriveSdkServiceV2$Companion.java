package com.larus.drive.sdk.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.larus.drive.biz.impl.utils.i;
import com.larus.drive.biz.impl.utils.j;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.office.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001Jq\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00142%\u0010\u0015\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t\u0018\u00010\u00162#\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016H\u0096\u0001Jy\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2%\u0010\u0015\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\t\u0018\u00010\u00162#\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016H\u0096\u0001J+\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J;\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010'\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010.\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0001J!\u0010/\u001a\u0002002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0007H\u0096\u0001J!\u0010/\u001a\u0002002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0006\u0010 \u001a\u000203H\u0096\u0001J!\u00104\u001a\u0002002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0096\u0001J\t\u00106\u001a\u00020\tH\u0096\u0001J\u0011\u00107\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u00068"}, d2 = {"Lcom/larus/drive/sdk/api/IDriveSdkServiceV2$Companion;", "Lcom/larus/drive/sdk/api/IDriveSdkServiceV2;", "<init>", "()V", "acquireOfficeFilePreviewRequest", "Lcom/bytedance/ee/drive/preview/DrivePreviewOpenRequest;", "requestId", "", "clearDriveCacheForDebug", "", "scope", "Lcom/bytedance/ee/drive/preview/DriveCacheDebugCleanScope;", "callback", "Lcom/bytedance/ee/drive/preview/DriveCacheDebugCallback;", "createAndPreviewBlankOfficeFile", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "context", "Landroid/content/Context;", "parentDriveToken", "type", "Lcom/larus/drive/biz/api/model/DriveFileType;", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlin/ParameterName;", "name", "file", "onError", "error", "createAndPreviewOfficeSpaceDocument", "documentType", "", "source", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceHeaderEventSource;", "createOfficeDrivePreviewAiAbilityList", "", "Lcom/bytedance/ee/bear/browser/plugin/PluginHostAbility;", "parentFragment", "Landroidx/fragment/app/Fragment;", "sourceConversationId", "sourceBotId", "createOfficeFilePreviewFragment", "request", "extraHostAbility", "reloadInterceptor", "Lcom/bytedance/ee/bear/container/ContainerReloadInterceptor;", "getDriveCleanableCacheSizeForDebug", "openOfficeSpacePreview", "", "item", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceItem;", "Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceEventSource;", "openOfficeUrlPreview", "url", "registerDiskCacheHandler", "releaseOfficeFilePreviewRequest", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IDriveSdkServiceV2$Companion implements IDriveSdkServiceV2 {
    public static final /* synthetic */ IDriveSdkServiceV2$Companion c = null;
    public final /* synthetic */ IDriveSdkServiceV2 b;

    static {
        c = new IDriveSdkServiceV2$Companion();
    }

    public final boolean a(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "source");
        return this.b.a(r2, r3, r4);
    }

    public final boolean b(Context r2, DriveFileItem r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "source");
        return this.b.b(r2, r3, r4);
    }

    public final boolean c(Context r2, OfficeSpaceItem r3, OfficeSpaceEventSource r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "source");
        return this.b.c(r2, r3, r4);
    }

    public final b d(Context r9, String r10, int r11, OfficeSpaceHeaderEventSource r12, i r13, j r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r12, "source");
        return this.b.d(r9, r10, r11, r12, r13, r14);
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        this.b.e(r2);
    }

    public final List<com.bytedance.ee.bear.browser.plugin.i> f(Fragment r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "parentFragment");
        return this.b.f(r2, r3, r4);
    }

    public final Fragment g(DrivePreviewOpenRequest r8, h r9, com.larus.office.container.impl.applet.i r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "request");
        return this.b.g(r8, r9, r10, r11, r12);
    }

    public final void h() {
        this.b.h();
    }

    public final DrivePreviewOpenRequest i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestId");
        return this.b.i(r2);
    }

    private IDriveSdkServiceV2$Companion() {
        this.b = (IDriveSdkServiceV2) ServiceManager.get().getService(IDriveSdkServiceV2.class);
    }
}
