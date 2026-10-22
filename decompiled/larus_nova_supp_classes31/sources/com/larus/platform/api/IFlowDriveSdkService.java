package com.larus.platform.api;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponent;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.service.FlowDriveSdkService;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u000e\u0010\u0004\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014H¦@¢\u0006\u0002\u0010\u0005JT\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H&J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H&JM\u0010(\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010,H&¢\u0006\u0002\u0010-J(\u0010.\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H&J\u0010\u00101\u001a\u00020\u00102\u0006\u0010%\u001a\u000202H&J\u0010\u00103\u001a\u00020\u00102\u0006\u0010%\u001a\u000202H&J \u00104\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001cH&JS\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020;2%\u0010<\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u0010\u0018\u00010=2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010BH&Je\u0010C\u001a\u0004\u0018\u00010\n2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020\u001f2%\b\u0002\u0010<\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u0010\u0018\u00010=2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010BH&Jj\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020;2!\u0010<\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00100=2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0010\u0018\u00010=H&J \u0010L\u001a\u0004\u0018\u00010\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010MJ\u0018\u0010N\u001a\u0004\u0018\u00010\n2\u0006\u0010O\u001a\u00020\nH¦@¢\u0006\u0002\u0010PJ\u0014\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010\nH&J\u000f\u0010T\u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0002\u0010UJ\u000f\u0010V\u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0002\u0010UJ\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\nH&J#\u0010Z\u001a\u0004\u0018\u00010\n2\b\u0010Y\u001a\u0004\u0018\u00010+2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010[J\u0019\u0010\\\u001a\u0004\u0018\u00010\u001f2\b\u0010]\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010^¨\u0006_"}, d2 = {"Lcom/larus/platform/api/IFlowDriveSdkService;", "", "supportsLocalFilePreview", "", "prepareLocalFilePreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openLocalFilePreview", "context", "Landroid/content/Context;", "filePath", "", "fileName", "localFileProviderAuthority", "isDriveAccessible", "isDriveAccessibleForColdStart", "needsInitializeWhenDriveAccessible", "", "needsInitialize", "isPickerInitialized", "getDriveStorage", "Lcom/larus/platform/api/DriveUserStorageData;", "triggerDriveFileSelection", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "scene", "Lcom/larus/platform/api/DriveFileSelectScene;", "allowDriveFileTypeList", "", "Lcom/larus/platform/api/FlowDriveFileType;", "currentSize", "", "selectionStore", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore;", "dialogParam", "Lcom/larus/platform/api/fileselect/SelectDialogParam;", "registerDriveFileSelectionCallback", "callback", "Lcom/larus/platform/api/IFlowDriveFileSelectionCallback;", "unregisterDriveFileSelectionCallback", "showChatFileSelectDialog", "conversationId", "lastChatTime", "", "Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/api/fileselect/SelectDialogParam;Ljava/lang/String;Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;)V", "showChatFileSelectedListDialog", "selectedListener", "Lcom/larus/platform/api/fileselect/IChatFileSelectedListListener;", "registerChatFileSelectionCallback", "Lcom/larus/platform/api/fileselect/IChatFileSelectionCallback;", "unregisterChatFileSelectionCallback", "dispatchChatFileSelection", "selectedList", "Lcom/larus/platform/api/FlowSelectedFileItem;", "registerDriveResource", "item", "Lcom/larus/platform/api/FlowDriveFileItem;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resourceId", "onFailure", "Lkotlin/Function0;", "getImageCoverUrl", "token", "height", "width", "url", "getUrlByObjToken", "objToken", "fileType", "error", "getUrlByObjTokenSuspend", "(Ljava/lang/String;Lcom/larus/platform/api/FlowDriveFileType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDriveVideoPreviewUrl", "fileToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDriveFileSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "jsonString", "getFloatChatShowPercent", "()Ljava/lang/Integer;", "isFloatChat", "getUploadFileTypeMobParam", "Lcom/larus/platform/api/fileselect/UploadFileTypeMobParam;", "ccmType", "getOriginFileType", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "getCcmObjType", "originFileType", "(Ljava/lang/String;)Ljava/lang/Integer;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IFlowDriveSdkService {

    public static final class a {
        public static /* synthetic */ void b(FlowDriveSdkService r7, FragmentManager r8, DriveFileSelectScene r9, com.larus.platform.api.fileselect.a r10, SelectDialogParam r11) {
            r7.k(r8, r9, null, 0, r10, r11);
        }

        public static /* synthetic */ String a(FlowDriveSdkService r7, CoroutineScope r8, String r9, int r10, int r11, com.larus.bmhome.view.resourcebar.viewholder.k r12, int r13) {
            if ((r13 & 16) == 0) goto L6;
            r12 = null;
        L6:
            return r7.f(r8, r9, r10, r11, r12, null);
        }
    }

    Integer A();

    Integer R();

    Object b(String r1, Continuation<? super String> r2);

    aq9.g c(int r1, String r2);

    Object d(Continuation<? super p> r1);

    void e(MultimodalInputComponent.c r1);

    String f(CoroutineScope r1, String r2, int r3, int r4, Function1<? super String, Unit> r5, Function0<Unit> r6);

    String g(Long r1, String r2);

    boolean h();

    Object i(String r1, FlowDriveFileType r2, Continuation<? super String> r3);

    void k(FragmentManager r1, DriveFileSelectScene r2, List r3, int r4, com.larus.platform.api.fileselect.a r5, SelectDialogParam r6);

    boolean l();

    FlowDriveFileSendInfo m(String r1);

    void n(FragmentManager r1, String r2, aq9.c r3);

    boolean o();

    Integer p(String r1);

    void q(FragmentManager r1, String r2, Long r3, SelectDialogParam r4, com.larus.bmhome.chat.component.bottom.bottommenu.d1 r5);

    void r(MultimodalInputComponent.d r1);

    boolean s(FragmentActivity r1, String r2, String r3, String r4);

    void t(s r1, LifecycleCoroutineScope r2, com.larus.bmhome.chat.component.bottom.attachment.z0 r3, com.larus.bmhome.chat.component.bottom.attachment.a1 r4);

    boolean u();

    Object v(Continuation<? super Boolean> r1);

    void w(String r1, List<u> r2);

    void x(MultimodalInputComponent.c r1);

    void y(MultimodalInputComponent.d r1);

    void z(String r1, FlowDriveFileType r2, LifecycleCoroutineScope r3, Function1 r4, Function1 r5);
}
