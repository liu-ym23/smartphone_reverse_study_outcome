package com.larus.drive.biz.impl.sdk;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveListLoadType;
import com.larus.drive.biz.impl.file.s;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.a0;
import com.larus.drive.biz.impl.viewmodel.o;
import com.larus.drive.biz.impl.viewmodel.p;
import com.larus.drive.biz.impl.viewmodel.q;
import com.larus.drive.biz.impl.viewmodel.r;
import com.larus.drive.biz.impl.viewmodel.z;
import com.larus.drive.sdk.api.DrivePickerScene;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.list.RequestDriveFileListRankType;
import com.larus.drive.sdk.api.file.upload.DriveUploadPriority;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kw9.c;
import z79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016JF\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016JT\u0010!\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0016\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010(\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016JJ\u0010*\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00132\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016JH\u0010/\u001a\u0004\u0018\u00010\u00152\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00132\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016J@\u00100\u001a\u0004\u0018\u00010\u00152\u0006\u00101\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016JR\u00102\u001a\u0004\u0018\u00010\u00152\f\u00103\u001a\b\u0012\u0004\u0012\u00020(042\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.2 \u00105\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001106\u0012\u0004\u0012\u00020\n\u0018\u00010'H\u0016Ja\u00107\u001a\u0004\u0018\u00010\u00132\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00112#\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.H\u0016J\u0018\u0010@\u001a\u00020\n2\u0006\u00101\u001a\u00020(2\u0006\u0010A\u001a\u00020BH\u0016J(\u0010C\u001a\u00020\n2\u0006\u0010A\u001a\u00020B2\u0006\u0010:\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0018\u0010C\u001a\u00020\n2\u0006\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020\u0013H\u0016J\b\u0010F\u001a\u00020\u001aH\u0016J8\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010\u001f\u001a\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020(04H\u0016J*\u0010Q\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020T2\u0006\u0010\u001f\u001a\u00020UH\u0016J2\u0010Q\u001a\u00020\n2\u0006\u00101\u001a\u00020(2\u0006\u0010V\u001a\u00020W2\u0006\u00108\u001a\u0002092\u0006\u0010S\u001a\u00020T2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\u0016\u0010Z\u001a\u00020\n2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001304H\u0016J\u0018\u0010\\\u001a\u00020\n2\u0006\u00101\u001a\u00020(2\u0006\u0010]\u001a\u00020^H\u0016J2\u0010_\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010S\u001a\u00020a2\u0006\u0010\u001f\u001a\u00020bH\u0016J\u001a\u0010c\u001a\u0004\u0018\u00010\u00132\u0006\u0010d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020bH\u0016JX\u0010e\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u00132\u0006\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020\u00132\b\u0010h\u001a\u0004\u0018\u00010\u00132\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013062\u0006\u0010S\u001a\u00020a2\u0006\u0010\u001f\u001a\u00020jH\u0016J\u001a\u0010k\u001a\u0004\u0018\u00010\u00132\u0006\u0010d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020jH\u0016J\u0016\u0010l\u001a\u00020\u001a2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001304H\u0016J\b\u0010m\u001a\u00020\nH\u0016J\u0010\u0010n\u001a\u00020\n2\u0006\u00101\u001a\u00020(H\u0016JO\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020(2\u0006\u00108\u001a\u0002092%\u0010&\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010.H\u0016J\u001a\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J,\u0010r\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010w\u001a\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u00132\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0010\u0010x\u001a\u00020\n2\u0006\u0010y\u001a\u00020zH\u0016J\b\u0010{\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0013H\u0016J)\u0010}\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010~\u001a\u00020\u00112\u0006\u0010\u007f\u001a\u00020\u001aH\u0096@¢\u0006\u0003\u0010\u0080\u0001J\u0012\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u001f\u001a\u00030\u0082\u0001H\u0016J*\u0010\u0083\u0001\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00132\u0007\u0010\u0084\u0001\u001a\u00020\u00112\u0007\u0010\u0085\u0001\u001a\u00020\u0013H\u0096@¢\u0006\u0003\u0010\u0086\u0001J\u0013\u0010\u0087\u0001\u001a\u00020\u00132\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\u000f\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\u001104H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u008b\u0001"}, d2 = {"Lcom/larus/drive/biz/impl/sdk/DriveSdkService;", "Lcom/larus/drive/sdk/api/IDriveSdkService;", "<init>", "()V", "service", "getService", "()Lcom/larus/drive/sdk/api/IDriveSdkService;", "service$delegate", "Lkotlin/Lazy;", "preInitDocSdk", "", "officeSDKUserApi", "Lcom/ss/android/lark/officesdk/api/api/OfficeSDKUserApi;", "initDocSdk", "postInitDocSdk", "destroyDocSdk", "lifecycleOrder", "", "lifecycleCategory", "", "requestDriveFileList", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "loadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "parentToken", "onlyFolder", "", "length", "loadMoreLabel", "rankType", "Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "callback", "Lcom/larus/drive/sdk/api/file/list/IRequestDriveFileListCallback;", "createDriveFile", "parentDriveToken", "type", "Lcom/larus/drive/biz/api/model/DriveFileType;", "fileName", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "onError", "moveDriveFile", "fileToken", "driveObjType", "parentFolderToken", "Lkotlin/Function0;", "renameDriveFile", "deleteDriveFile", "file", "deleteDriveFiles", "fileList", "", "onFailure", "", "getImageCoverUrl", "scope", "Lkotlinx/coroutines/CoroutineScope;", "token", "height", "width", "Lkotlin/ParameterName;", "name", "url", "loadFileTypeIcon", "imageView", "Landroid/widget/ImageView;", "loadDocumentIcon", "objType", "iconInfo", "isPickerInitialized", "attachPickerView", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerController;", "pickerScene", "Lcom/larus/drive/sdk/api/DrivePickerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "rootView", "Landroid/view/ViewGroup;", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerViewCallback;", "preSelectedDriveItems", "downloadDriveFile", "localPath", "priority", "Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "Lcom/larus/drive/sdk/api/file/download/IDriveDownloadCallback;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "cancelDownloadDriveFile", "taskKeys", "shareDriveFile", "param", "Lcom/larus/share/bean/DriveShareEventParam;", "startUploadingDriveFile", "uri", "Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "Lcom/larus/drive/sdk/api/file/upload/IDriveUploadCallback;", "resumeUploadingDriveFile", "taskId", "startUploadingDriveFileToMountPoint", "mountPoint", "mountNodeToken", "uploadCode", "extraRust", "Lcom/larus/drive/sdk/api/file/upload/IDriveMountUploadCallback;", "resumeUploadingDriveFileToMountPoint", "cancelUploadDriveFile", "clearDriveUploadTasks", "refreshVisitedTime", "registerDriveResource", "item", "resourceId", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "ccmType", "updateDriveMetaInfo", "info", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "getDriveMetaInfo", "getDriveFilePermission", "fetchDriveFileInfo", "fileObjType", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLocalDbService", "Lcom/larus/drive/sdk/api/file/database/ILocalDatabaseCallback;", "validateDriveFileInLarkSecurityControl", "fileType", "operation", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatFileTime", "timestamp", "", "getFileTypeInList", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkService implements IDriveSdkService {
    public static final DriveSdkService a = null;
    public static final Lazy b = null;

    private DriveSdkService() {
    }

    static {
        a = new DriveSdkService();
        b = LazyKt.lazy(new a());
    }

    public static IDriveSdkService V() {
        return (IDriveSdkService) b.getValue();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final List<Integer> U() {
        IDriveSdkService r0 = V();
        if (r0 == null) goto L7;
        List<Integer> r1 = r0.U();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
    }

    public final void destroyDocSdk() {
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.destroyDocSdk();
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void h() {
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.h();
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final boolean l() {
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l();
    }

    public final String lifecycleCategory() {
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        String r1 = r0.lifecycleCategory();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "drive";
    }

    public final int lifecycleOrder() {
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return 3;
    L7:
        return r0.lifecycleOrder();
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final boolean S(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "taskKeys");
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.S(r2);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void g(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "taskKeys");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    public final void initDocSdk(OfficeSDKUserApi r2) {
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.initDocSdk(r2);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void k(AbsDriveListFragment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.k(r2);
        return;
    }

    public final void postInitDocSdk(OfficeSDKUserApi r2) {
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.postInitDocSdk(r2);
        return;
    }

    public final void preInitDocSdk(OfficeSDKUserApi r2) {
        Intrinsics.checkNotNullParameter(r2, "officeSDKUserApi");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.preInitDocSdk(r2);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final Object w(Continuation r5) {
        if ((r5 instanceof DriveSdkService$validateDriveFileInLarkSecurityControl$1) == false) goto L7;
        DriveSdkService$validateDriveFileInLarkSecurityControl$1 r0 = (DriveSdkService$validateDriveFileInLarkSecurityControl$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        int r7 = ((Number) r6).intValue();
    L22:
        return Boxing.boxInt(r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        IDriveSdkService r8 = V();
        if (r8 == null) goto L20;
        r0.label = 1;
        r6 = r8.w(r0);
        if (r6 != r2) goto L19;
        return r2;
    L20:
        r7 = AbsDriveListViewModel.MENU_ID_DOWNLOAD;
    L7:
        r0 = new DriveSdkService$validateDriveFileInLarkSecurityControl$1(this, r5);
        goto L8
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String x(long r2) {
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        String r3 = r0.x(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void z(DriveFileItem r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.z(r2);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void F(DriveFileItem r2, ImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.F(r2, r3);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String I(String r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.I(r2, r3);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void P(DriveFileItem r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "param");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.P(r2, r3);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void e(ImageView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        Intrinsics.checkNotNullParameter(r3, "url");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.e(r2, r3);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void m(b r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.m(r2, r3);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String p(String r2, bo9.c r3) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p(r2, r3);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void H(String r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.H(r2, r3, r4);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void C(DriveFileItem r2, CoroutineScope r3, Function1<? super String, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "scope");
        IDriveSdkService r0 = V();
        if (r0 == null) goto L6;
        r0.C(r2, r3, r4, r5);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b O(DriveFileItem r2, DriveListLoadType r3, o r4, p r5) {
        Intrinsics.checkNotNullParameter(r2, "file");
        Intrinsics.checkNotNullParameter(r3, "loadType");
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.O(r2, r3, r4, r5);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final Object b(String r2, int r3, boolean r4, Continuation<? super DriveFileItem> r5) {
        IDriveSdkService r0 = V();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b(r2, r3, r4, r5);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void o(ImageView r1, String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "imageView");
        Intrinsics.checkNotNullParameter("", "token");
        Intrinsics.checkNotNullParameter("", "iconInfo");
        IDriveSdkService r5 = V();
        if (r5 == null) goto L6;
        r5.o(r1, "", r3, "");
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b q(List<DriveFileItem> r2, DriveListLoadType r3, Function0<Unit> r4, Function1<? super Map<String, Integer>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "fileList");
        Intrinsics.checkNotNullParameter(r3, "loadType");
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.q(r2, r3, r4, r5);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String r(String r2, String r3, DriveDownloadPriority r4, AbsDriveListViewModel.C05381 r5) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r3, "localPath");
        Intrinsics.checkNotNullParameter(r4, "priority");
        Intrinsics.checkNotNullParameter(r5, "callback");
        IDriveSdkService r0 = V();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r(r2, r3, r4, r5);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final w79.b A(DrivePickerScene r8, FragmentActivity r9, ViewGroup r10, w79.c r11, List<DriveFileItem> r12) {
        Intrinsics.checkNotNullParameter(r8, "pickerScene");
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, "rootView");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "preSelectedDriveItems");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.A(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final void E(DriveFileItem r8, FragmentActivity r9, CoroutineScope r10, DriveDownloadPriority r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r8, "file");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "priority");
        IDriveSdkService r1 = V();
        if (r1 == null) goto L6;
        r1.E(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b Q(String r8, int r9, String r10, q r11, r r12) {
        Intrinsics.checkNotNullParameter(r8, "fileToken");
        Intrinsics.checkNotNullParameter(r10, "fileName");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.Q(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b R(String r8, DriveFileType r9, String r10, Function1<? super DriveFileItem, Unit> r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "type");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.R(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String t(String r8, String r9, String r10, DriveUploadPriority r11, s r12) {
        Intrinsics.checkNotNullParameter(r8, "fileName");
        Intrinsics.checkNotNullParameter(r9, "uri");
        Intrinsics.checkNotNullParameter(r10, "parentDriveToken");
        Intrinsics.checkNotNullParameter(r11, "priority");
        Intrinsics.checkNotNullParameter(r12, "callback");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.t(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b u(String r8, int r9, String r10, z r11, a0 r12) {
        Intrinsics.checkNotNullParameter(r8, "fileToken");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.u(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String f(CoroutineScope r9, String r10, int r11, int r12, Function1<? super String, Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "token");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.f(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final nc5.b B(DriveListLoadType r10, String r11, boolean r12, int r13, String r14, RequestDriveFileListRankType r15, u79.b r16) {
        Intrinsics.checkNotNullParameter(r10, "loadType");
        Intrinsics.checkNotNullParameter(r15, "rankType");
        Intrinsics.checkNotNullParameter(r16, "callback");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.B(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.larus.drive.sdk.api.IDriveSdkService
    public final String J(String r11, String r12, String r13, String r14, String r15, Map r16, DriveUploadPriority r17, bo9.c r18) {
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r12, "uri");
        Intrinsics.checkNotNullParameter(r13, "mountPoint");
        Intrinsics.checkNotNullParameter(r14, "mountNodeToken");
        Intrinsics.checkNotNullParameter(r16, "extraRust");
        Intrinsics.checkNotNullParameter(r17, "priority");
        Intrinsics.checkNotNullParameter(r18, "callback");
        IDriveSdkService r1 = V();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.J(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
