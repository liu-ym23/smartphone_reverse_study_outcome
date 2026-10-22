package com.larus.drive.sdk.api;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.api.model.DriveListLoadType;
import com.larus.drive.biz.impl.file.s;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.biz.impl.viewmodel.a0;
import com.larus.drive.biz.impl.viewmodel.o;
import com.larus.drive.biz.impl.viewmodel.p;
import com.larus.drive.biz.impl.viewmodel.q;
import com.larus.drive.biz.impl.viewmodel.r;
import com.larus.drive.biz.impl.viewmodel.z;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.file.list.RequestDriveFileListRankType;
import com.larus.drive.sdk.api.file.upload.DriveUploadPriority;
import com.larus.office.base.service.ISdkLifecycleV2;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import nc5.b;
import w79.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u0000 ~2\u00020\u0001:\u0001~JP\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&Jx\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072'\b\u0002\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&J]\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&J[\u0010$\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&JS\u0010%\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#2%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&Je\u0010&\u001a\u0004\u0018\u00010\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180(2\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#21\b\u0002\u0010)\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0*¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0017H&Je\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b2%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#H&J\u0018\u00103\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u00104\u001a\u000205H&J(\u00106\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u0010/\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0007H&J\u0018\u00106\u001a\u00020\u001c2\u0006\u00104\u001a\u0002052\u0006\u00102\u001a\u00020\u0007H&J\b\u00109\u001a\u00020\tH&J:\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00180(H&J*\u0010D\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020G2\u0006\u0010\u000f\u001a\u00020HH&J6\u0010D\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010I\u001a\u00020J2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010F\u001a\u00020G2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010LH&J\u0016\u0010M\u001a\u00020\u001c2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070(H&J\u0018\u0010O\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010P\u001a\u00020QH&J6\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010F\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020UH&J\u001a\u0010V\u001a\u0004\u0018\u00010\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020UH&J^\u0010X\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u00072\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070*2\b\b\u0002\u0010F\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020]H&J\u001a\u0010^\u001a\u0004\u0018\u00010\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020]H&J\u0016\u0010_\u001a\u00020\t2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070(H&J\b\u0010`\u001a\u00020\u001cH&J\u0010\u0010a\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H&JS\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020.2%\u0010\u0016\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00172\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010#H&J\u001c\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020g2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010iH&J0\u0010e\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010j\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010h\u001a\u0004\u0018\u00010iH&J\u0010\u0010k\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020mH&J\b\u0010n\u001a\u00020mH&J\u0010\u0010o\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0007H&J*\u0010p\u001a\u0004\u0018\u00010\u00182\u0006\u0010 \u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u000b2\b\b\u0002\u0010r\u001a\u00020\tH¦@¢\u0006\u0002\u0010sJ\u0010\u0010t\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020uH&J&\u0010v\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020\u00072\u0006\u0010{\u001a\u00020|H&J\u000e\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000b0(H&¨\u0006\u007f"}, d2 = {"Lcom/larus/drive/sdk/api/IDriveSdkService;", "Lcom/larus/office/base/service/ISdkLifecycleV2;", "requestDriveFileList", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "loadType", "Lcom/larus/drive/biz/api/model/DriveListLoadType;", "parentToken", "", "onlyFolder", "", "length", "", "loadMoreLabel", "rankType", "Lcom/larus/drive/sdk/api/file/list/RequestDriveFileListRankType;", "callback", "Lcom/larus/drive/sdk/api/file/list/IRequestDriveFileListCallback;", "createDriveFile", "parentDriveToken", "type", "Lcom/larus/drive/biz/api/model/DriveFileType;", "fileName", "onSuccess", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlin/ParameterName;", "name", "file", "", "onError", "error", "moveDriveFile", "fileToken", "driveObjType", "parentFolderToken", "Lkotlin/Function0;", "renameDriveFile", "deleteDriveFile", "deleteDriveFiles", "fileList", "", "onFailure", "", "failFileWithCode", "getImageCoverUrl", "scope", "Lkotlinx/coroutines/CoroutineScope;", "token", "height", "width", "url", "loadFileTypeIcon", "imageView", "Landroid/widget/ImageView;", "loadDocumentIcon", "objType", "iconInfo", "isPickerInitialized", "attachPickerView", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerController;", "pickerScene", "Lcom/larus/drive/sdk/api/DrivePickerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "rootView", "Landroid/view/ViewGroup;", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerViewCallback;", "preSelectedDriveItems", "downloadDriveFile", "localPath", "priority", "Lcom/larus/drive/sdk/api/file/download/DriveDownloadPriority;", "Lcom/larus/drive/sdk/api/file/download/IDriveDownloadCallback;", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "cancelDownloadDriveFile", "taskKeys", "shareDriveFile", "param", "Lcom/larus/share/bean/DriveShareEventParam;", "startUploadingDriveFile", "uri", "Lcom/larus/drive/sdk/api/file/upload/DriveUploadPriority;", "Lcom/larus/drive/sdk/api/file/upload/IDriveUploadCallback;", "resumeUploadingDriveFile", "taskId", "startUploadingDriveFileToMountPoint", "mountPoint", "mountNodeToken", "uploadCode", "extraRust", "Lcom/larus/drive/sdk/api/file/upload/IDriveMountUploadCallback;", "resumeUploadingDriveFileToMountPoint", "cancelUploadDriveFile", "clearDriveUploadTasks", "refreshVisitedTime", "registerDriveResource", "item", "resourceId", "previewDriveFile", "galleryContext", "Lcom/larus/drive/sdk/api/gallery/bean/DriveGalleryContext;", "args", "Landroid/os/Bundle;", "ccmType", "updateDriveMetaInfo", "info", "Lcom/larus/drive/sdk/api/meta/DriveMetaInfo;", "getDriveMetaInfo", "getDriveFilePermission", "fetchDriveFileInfo", "fileObjType", "markVisit", "(Ljava/lang/String;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initLocalDbService", "Lcom/larus/drive/sdk/api/file/database/ILocalDatabaseCallback;", "validateDriveFileInLarkSecurityControl", "fileType", "operation", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatFileTime", "timestamp", "", "getFileTypeInList", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDriveSdkService extends ISdkLifecycleV2 {

    public static final class a {
        public static /* synthetic */ String b(DriveSdkService r7, String r8, int r9, int r10) {
            return r7.f(null, r8, r9, r10, null, null);
        }

        public static /* synthetic */ void a(DriveSdkService r6, DriveFileItem r7, FragmentActivity r8, CoroutineScope r9, Fragment r10) {
            r6.E(r7, r8, r9, DriveDownloadPriority.NORMAL, r10);
        }

        public static /* synthetic */ b c(IDriveSdkService r10, DriveListLoadType r11, String r12, boolean r13, int r14, String r15, u79.b r16, int r17) {
            RequestDriveFileListRankType r1 = null;
            if ((r17 & 2) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r17 & 4) == 0) goto L9;
            boolean r5 = false;
        L11:
            if ((r17 & 8) == 0) goto L13;
            int r6 = 20;
        L15:
            if ((r17 & 16) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r17 & 32) == 0) goto L22;
            r1 = RequestDriveFileListRankType.ACCESS_TIME;
        L22:
            return r10.B(r11, r4, r5, r6, r7, r1, r16);
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r4 = r12;
            goto L7
        }
    }

    w79.b A(DrivePickerScene r1, FragmentActivity r2, ViewGroup r3, c r4, List<DriveFileItem> r5);

    b B(DriveListLoadType r1, String r2, boolean r3, int r4, String r5, RequestDriveFileListRankType r6, u79.b r7);

    void C(DriveFileItem r1, CoroutineScope r2, Function1<? super String, Unit> r3, Function0<Unit> r4);

    void E(DriveFileItem r1, FragmentActivity r2, CoroutineScope r3, DriveDownloadPriority r4, Fragment r5);

    void F(DriveFileItem r1, ImageView r2);

    void H(String r1, String r2, Bundle r3);

    String I(String r1, s r2);

    String J(String r1, String r2, String r3, String r4, String r5, Map r6, DriveUploadPriority r7, bo9.c r8);

    b O(DriveFileItem r1, DriveListLoadType r2, o r3, p r4);

    void P(DriveFileItem r1, kw9.c r2);

    b Q(String r1, int r2, String r3, q r4, r r5);

    b R(String r1, DriveFileType r2, String r3, Function1<? super DriveFileItem, Unit> r4, Function1<? super String, Unit> r5);

    boolean S(List<String> r1);

    List<Integer> U();

    Object b(String r1, int r2, boolean r3, Continuation<? super DriveFileItem> r4);

    void e(ImageView r1, String r2);

    String f(CoroutineScope r1, String r2, int r3, int r4, Function1<? super String, Unit> r5, Function0<Unit> r6);

    void g(List<String> r1);

    void h();

    void k(AbsDriveListFragment.d r1);

    boolean l();

    void m(z79.b r1, Bundle r2);

    void o(ImageView r1, String r2, int r3, String r4);

    String p(String r1, bo9.c r2);

    b q(List<DriveFileItem> r1, DriveListLoadType r2, Function0<Unit> r3, Function1<? super Map<String, Integer>, Unit> r4);

    String r(String r1, String r2, DriveDownloadPriority r3, AbsDriveListViewModel.C05381 r4);

    String t(String r1, String r2, String r3, DriveUploadPriority r4, s r5);

    b u(String r1, int r2, String r3, z r4, a0 r5);

    Object w(Continuation r1);

    String x(long r1);

    void z(DriveFileItem r1);
}
