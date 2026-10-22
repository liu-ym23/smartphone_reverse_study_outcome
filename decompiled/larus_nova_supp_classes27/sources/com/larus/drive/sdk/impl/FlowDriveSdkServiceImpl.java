package com.larus.drive.sdk.impl;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.attachment.a1;
import com.larus.bmhome.chat.component.bottom.attachment.z0;
import com.larus.bmhome.chat.component.bottom.bottommenu.d1;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponent;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.network.api.DriveApi;
import com.larus.drive.sdk.api.network.resp.GetUserStorageResp;
import com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator;
import com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper;
import com.larus.drive.sdk.impl.utils.RegisterDriveResourceHelper;
import com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectDialog;
import com.larus.drive.sdk.impl.view.chat.fileselect.ChatFileSelectedListDialog;
import com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog;
import com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatFileSelectedAdapter;
import com.larus.drive.sdk.impl.view.preview.DrivePreviewActivity;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.network.FlowHttpConnection;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.api.DriveFileSelectScene;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.IAiFilePreviewService;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.q0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import va8.f0;
import va8.g0;
import wa8.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 z2\u00020\u00012\u00020\u0002:\u0001zB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010(H\u0096@¢\u0006\u0002\u0010\bJ.\u0010)\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0/H\u0016J,\u00100\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\r2\b\u00104\u001a\u0004\u0018\u00010\rH\u0016JL\u00105\u001a\u00020$2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\r2\u0006\u00109\u001a\u00020:2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010D\u001a\u00020$2\u0006\u0010E\u001a\u00020\u0019H\u0016J\u0010\u0010F\u001a\u00020$2\u0006\u0010E\u001a\u00020\u0019H\u0016JG\u0010G\u001a\u00020$2\u0006\u00106\u001a\u0002072\b\u0010H\u001a\u0004\u0018\u00010\r2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u00108\u001a\u0004\u0018\u00010\r2\b\u0010E\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0002\u0010LJ$\u0010M\u001a\u00020$2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\r2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010P\u001a\u00020$2\u0006\u0010E\u001a\u00020\u001eH\u0016J\u0010\u0010Q\u001a\u00020$2\u0006\u0010E\u001a\u00020\u001eH\u0016J \u0010R\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\r2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0<H\u0016JO\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020W2\u0006\u0010*\u001a\u00020+2%\u0010X\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(\\\u0012\u0004\u0012\u00020$\u0018\u00010Y2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010/H\u0016Ja\u0010^\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010_\u001a\u00020\r2\u0006\u0010`\u001a\u00020?2\u0006\u0010a\u001a\u00020?2#\u0010X\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020$\u0018\u00010Y2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010/H\u0016JJ\u0010c\u001a\u00020$2\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020=2\u0006\u0010*\u001a\u00020+2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0Y2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$\u0018\u00010YH\u0016J \u0010f\u001a\u0004\u0018\u00010\r2\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020=H\u0096@¢\u0006\u0002\u0010gJ\u0018\u0010h\u001a\u0004\u0018\u00010\r2\u0006\u0010i\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010jJ\u0014\u0010k\u001a\u0004\u0018\u00010l2\b\u0010m\u001a\u0004\u0018\u00010\rH\u0016J\u000f\u0010n\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0002\u0010oJ\u000f\u0010p\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0002\u0010oJ\u0018\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020?2\u0006\u0010\u000e\u001a\u00020\rH\u0016J#\u0010t\u001a\u0004\u0018\u00010\r2\b\u0010s\u001a\u0004\u0018\u00010J2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010uJ\u0019\u0010v\u001a\u0004\u0018\u00010?2\b\u0010w\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020$H\u0002R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001a\u0010\u001bR'\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00180\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001f\u0010\u001b¨\u0006{"}, d2 = {"Lcom/larus/drive/sdk/impl/FlowDriveSdkServiceImpl;", "Lcom/larus/platform/api/IFlowDriveSdkService;", "Lcom/larus/platform/api/IAiFilePreviewService;", "<init>", "()V", "supportsLocalFilePreview", "", "prepareLocalFilePreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openLocalFilePreview", "context", "Landroid/content/Context;", "filePath", "", "fileName", "localFileProviderAuthority", "driveSdkService", "Lcom/larus/drive/sdk/api/IDriveSdkService;", "getDriveSdkService", "()Lcom/larus/drive/sdk/api/IDriveSdkService;", "driveSdkService$delegate", "Lkotlin/Lazy;", "driveFileSelectionCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/larus/platform/api/IFlowDriveFileSelectionCallback;", "getDriveFileSelectionCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "driveFileSelectionCallbacks$delegate", "selectionCallbacks", "Lcom/larus/platform/api/fileselect/IChatFileSelectionCallback;", "getSelectionCallbacks", "selectionCallbacks$delegate", "isDriveAccessible", "isDriveAccessibleForColdStart", "needsInitializeWhenDriveAccessible", "", "needsInitialize", "isPickerInitialized", "getDriveStorage", "Lcom/larus/platform/api/DriveUserStorageData;", "openAiFilePreview", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/larus/platform/model/office/AiFilePreviewRequest;", "fallback", "Lkotlin/Function0;", "openDriveUplinkPreview", "driveUplinkInfo", "Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "sourceConversationId", "sourceBotId", "triggerDriveFileSelection", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "scene", "Lcom/larus/platform/api/DriveFileSelectScene;", "allowDriveFileTypeList", "", "Lcom/larus/platform/api/FlowDriveFileType;", "currentSize", "", "selectionStore", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore;", "dialogParam", "Lcom/larus/platform/api/fileselect/SelectDialogParam;", "registerDriveFileSelectionCallback", "callback", "unregisterDriveFileSelectionCallback", "showChatFileSelectDialog", "conversationId", "lastChatTime", "", "Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/api/fileselect/SelectDialogParam;Ljava/lang/String;Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;)V", "showChatFileSelectedListDialog", "selectedListener", "Lcom/larus/platform/api/fileselect/IChatFileSelectedListListener;", "registerChatFileSelectionCallback", "unregisterChatFileSelectionCallback", "dispatchChatFileSelection", "selectedList", "Lcom/larus/platform/api/FlowSelectedFileItem;", "registerDriveResource", "item", "Lcom/larus/platform/api/FlowDriveFileItem;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resourceId", "onFailure", "getImageCoverUrl", "token", "height", "width", "url", "getUrlByObjToken", "objToken", "fileType", "getUrlByObjTokenSuspend", "(Ljava/lang/String;Lcom/larus/platform/api/FlowDriveFileType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDriveVideoPreviewUrl", "fileToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDriveFileSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "jsonString", "getFloatChatShowPercent", "()Ljava/lang/Integer;", "isFloatChat", "getUploadFileTypeMobParam", "Lcom/larus/platform/api/fileselect/UploadFileTypeMobParam;", "ccmType", "getOriginFileType", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "getCcmObjType", "originFileType", "(Ljava/lang/String;)Ljava/lang/Integer;", "pruneChatSelectionCallbacks", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDriveSdkServiceImpl implements IFlowDriveSdkService, IAiFilePreviewService {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowDriveFileType.values().length];
            r0[FlowDriveFileType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FlowDriveFileType.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final boolean o() {
        return true;
    }

    public final CopyOnWriteArrayList<WeakReference<aq9.d>> B() {
        return (CopyOnWriteArrayList) this.c.getValue();
    }

    public final boolean h() {
        AccountService r0 = AccountService.a;
        if (r0.a() == false) goto L6;
        return false;
    L6:
        if (AppHost.a.isOversea() == true) goto L8;
    L20:
        a89.a r1 = com.larus.drive.sdk.impl.utils.h.a;
        return com.larus.drive.sdk.impl.utils.h.a.a;
    L8:
        if (r0.isLogin().booleanValue() == false) goto L19;
        IActionBarService r2 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r2 == null) goto L17;
        Integer r3 = r2.a();
        ModelItemIdentity r4 = t0.a;
        int r5 = t0.a.getDeprecatedItemId();
        if (r3 == null) goto L17;
        if (r3.intValue() != r5) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
    L17:
        r6 = false;
    L19:
        return false;
    }

    public final boolean l() {
        IDriveSdkService r0 = (IDriveSdkService) this.a.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l();
    }

    public final boolean u() {
        if (AccountService.a.a() == false) goto L6;
        return false;
    L6:
        a89.a r0 = com.larus.drive.sdk.impl.utils.h.a;
        return com.larus.drive.sdk.impl.utils.h.a.a;
    }

    public FlowDriveSdkServiceImpl() {
        this.a = LazyKt.lazy(new m());
        this.b = LazyKt.lazy(new n());
        this.c = LazyKt.lazy(new o());
    }

    public final Integer A() {
        Fragment r0 = l89.a.a();
        if (r0 == null) goto L7;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L7;
        g0 r2 = (g0) r1.getAbility(g0.class);
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return Integer.valueOf(r2.Gt());
    L7:
        r2 = null;
        goto L8
    }

    public final Integer R() {
        Fragment r0 = l89.a.a();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isAdded() == false) goto L19;
        f0 r1 = s1a.a.g(r0).getAbility(f0.class);
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        return 1;
    L15:
        return 0;
    L9:
        if (r1.R() != true) goto L11;
        r2 = true;
        goto L12
    L19:
        return null;
    }

    public final Object d(Continuation<? super com.larus.platform.api.p> r12) {
        if ((r12 instanceof FlowDriveSdkServiceImpl$getDriveStorage$1) == false) goto L7;
        FlowDriveSdkServiceImpl$getDriveStorage$1 r0 = (FlowDriveSdkServiceImpl$getDriveStorage$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowDriveSdkServiceImpl$getDriveStorage$1 r8 = r0;
        Object r13 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        dm9.a.b r14 = (dm9.a) r13;
        if ((r14 instanceof dm9.a.a) == false) goto L22;
        FLogger.a.e("FlowDriveSdkServiceImpl", "[getDriveStorage] failed, " + r14);
        return null;
    L22:
        if ((r14 instanceof dm9.a.b) == false) goto L30;
        GetUserStorageResp r15 = (GetUserStorageResp) r14.a.getData();
        if (r15 != null) goto L27;
        FLogger.a.e("FlowDriveSdkServiceImpl", "[getDriveStorage] failed, driveStorageResp is null");
        return null;
    L27:
        FLogger.a.i("FlowDriveSdkServiceImpl", "[getDriveStorage] driveStorageResp=" + r15);
        return new com.larus.platform.api.p(r15.getShowSizeLimit(), r15.getTotalSize(), r15.getUsedSize());
    L30:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        DriveApi.a r16 = DriveApi.a;
        FlowDriveSdkServiceImpl$getDriveStorage$resp$1 r4 = new FlowDriveSdkServiceImpl$getDriveStorage$resp$1(null);
        r8.label = 1;
        r16.getClass();
        FlowHttpConnection r17 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("Basic", DriveApi.class, r4, true, "alice/aispace/facade/get_user_storage", null, null, r8, 224);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new FlowDriveSdkServiceImpl$getDriveStorage$1(this, r12);
        goto L8
    }

    public final void e(MultimodalInputComponent.c r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Iterator<T> r0 = B().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((WeakReference) r1).get(), r4) == false) goto L4;
    L9:
        WeakReference r2 = (WeakReference) r1;
        if (r2 == null) goto L12;
        B().remove(r2);
    L12:
        CollectionsKt.removeAll(B(), new p());
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final FlowDriveFileSendInfo m(String r8) {
        boolean r0 = false;
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L53;
        return null;
    L53:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L45
        FlowDriveFileSendInfo r9 = (FlowDriveFileSendInfo) new Gson().fromJson(r8, FlowDriveFileSendInfo.class);     // Catch: Throwable -> L45
        if (r9 == null) goto L42;
        String r5 = r9.getCollectionId();     // Catch: Throwable -> L45
        if (r5 != null) goto L17;
    L22:
        r5 = null;
    L23:
        String r1 = r9.getCollectionName();     // Catch: Throwable -> L45
        if (r1 != null) goto L26;
    L28:
        r1 = null;
    L29:
        String r6 = r9.getContentType();     // Catch: Throwable -> L45
        if (r6 != null) goto L32;
    L34:
        r6 = null;
    L35:
        String r7 = r9.getContentSecType();     // Catch: Throwable -> L45
        if (r7 != null) goto L38;
    L40:
        r7 = null;
    L41:
        FlowDriveFileSendInfo r10 = r9.copy(r5, r1, r6, r7);     // Catch: Throwable -> L45
    L43:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r11) == true) goto L52;
        r3 = r11;
    L52:
        return (FlowDriveFileSendInfo) r3;
    L38:
        if ((true ^ StringsKt.isBlank(r7)) == false) goto L40;
    L32:
        if ((!StringsKt.isBlank(r6)) == false) goto L34;
    L26:
        if ((!StringsKt.isBlank(r1)) == false) goto L28;
    L17:
        if (StringsKt.isBlank(r5) == true) goto L20;
        r0 = true;
    L20:
        if (Boolean.valueOf(r0).booleanValue() == false) goto L22;
    L42:
        r10 = null;
    L45:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L5:
        if (StringsKt.isBlank(r8) == true) goto L8;
        r2 = false;
        goto L9
    }

    public final Integer p(String r2) {
        if (r2 != null) goto L4;
    L26:
        return null;
    L4:
        switch(r2.hashCode()) {
            case -1418040159: goto L23;
            case -1363649724: goto L19;
            case -1218310520: goto L15;
            case -102775833: goto L11;
            case 890891481: goto L7;
            default: goto L26;
        };
    L7:
        if (r2.equals("ai_slides") == false) goto L26;
        return 30;
    L11:
        if (r2.equals("bitable") == false) goto L26;
        return 8;
    L15:
        if (r2.equals("ai_sheet") == false) goto L26;
        return 3;
    L19:
        if (r2.equals("mindnote") == false) goto L26;
        return 11;
    L23:
        if (r2.equals("ai_doc") == false) goto L26;
        return 22;
    }

    public final void r(MultimodalInputComponent.d r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Iterator r0 = ((CopyOnWriteArrayList) this.b.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((WeakReference) r1).get(), r4) == false) goto L4;
    L10:
        if (((WeakReference) r1) != null) goto L16;
        ((CopyOnWriteArrayList) this.b.getValue()).add(new WeakReference(r4));
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L10
    }

    public final Object v(Continuation<? super Boolean> r1) {
        return DriveLocalFilePreviewDelegate.b(r1);
    }

    public final void x(MultimodalInputComponent.c r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        CollectionsKt.removeAll(B(), new p());
        Iterator<T> r0 = B().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((WeakReference) r1).get(), r4) == false) goto L4;
    L10:
        if (((WeakReference) r1) != null) goto L16;
        B().add(new WeakReference(r4));
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L10
    }

    public final void y(MultimodalInputComponent.d r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Iterator r0 = ((CopyOnWriteArrayList) this.b.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((WeakReference) r1).get(), r4) == false) goto L4;
    L9:
        WeakReference r2 = (WeakReference) r1;
        if (r2 == null) goto L16;
        ((CopyOnWriteArrayList) this.b.getValue()).remove(r2);
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final Object b(String r2, Continuation<? super String> r3) {
        return com.larus.drive.sdk.impl.service.t.b().b(r2, r3);
    }

    public final aq9.g c(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "fileName");
        int r0 = com.larus.drive.sdk.impl.utils.n.a;
        DriveFileType r5 = com.larus.drive.sdk.impl.utils.n.a(Integer.valueOf(r3), r4);
        return new aq9.g(com.larus.drive.sdk.impl.utils.n.e(r5), com.larus.drive.sdk.impl.utils.n.c(r5, r4));
    }

    public final String g(Long r1, String r2) {
        return com.larus.drive.sdk.impl.utils.n.b(r1, r2).getValue();
    }

    public final void w(final String r2, final List<com.larus.platform.api.u> r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedList");
        com.larus.utils.t0.e(new q(this, r2, r3));
    }

    public final Object i(String r2, FlowDriveFileType r3, Continuation<? super String> r4) {
        return ObjTokenGetUrlHelper.a.b(r2, r3, r4);
    }

    public final void n(final FragmentManager r6, final String r7, aq9.c r8) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        if (r7 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        r7 = "ChatFileSelectedListDialog";
    L11:
        int r1 = ChatFileSelectedListDialog.i;
        if (r8 == null) goto L14;
        List<com.larus.platform.api.u> r2 = r8.b();
    L15:
        if (r2 != null) goto L17;
        r2 = CollectionsKt.emptyList();
    L17:
        Intrinsics.checkNotNullParameter(r2, "selectedList");
        final ChatFileSelectedListDialog r3 = new ChatFileSelectedListDialog();
        Intrinsics.checkNotNullParameter(r2, "list");
        r3.f = r2;
        ChatFileSelectedAdapter r4 = r3.g;
        if (r4 == null) goto L24;
        List<com.larus.platform.api.u> r5 = r2;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r10 = r5.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        r9.add(r3.S90((com.larus.platform.api.u) r10.next()));
        goto L21
    L23:
        r4.submitList(r9);
    L24:
        r3.h = r8;
        com.larus.utils.t0.e(new s(r6, r7, this, r3));
        return;
    L14:
        r2 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final boolean a(Context r110, DriveUplinkInfo r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r20, "driveUplinkInfo");
        com.larus.drive.sdk.impl.utils.k.a.getClass();
        Intrinsics.checkNotNullParameter(r110, "context");
        Intrinsics.checkNotNullParameter(r20, "driveUplinkInfo");
        if (com.larus.drive.sdk.impl.utils.k.c() == false) goto L39;
        String r2 = r20.getFileToken();
        if (r2 == null) goto L39;
        if ((!StringsKt.isBlank(r2)) == false) goto L10;
        String r6 = r2;
    L11:
        if (r6 == null) goto L39;
        String r3 = r20.getUrl();
        if (r3 == null) goto L39;
        if ((!StringsKt.isBlank(r3)) == false) goto L18;
        String r9 = r3;
    L19:
        if (r9 == null) goto L39;
        if (r20.getCcmType() == 12) goto L24;
        FLogger.a.i("DrivePreviewHelper", "skip drive uplink preview because type is unsupported");
        goto L39
    L24:
        int r7 = r20.getCcmType();
        String r4 = r20.getFileName();
        if (r4 != null) goto L27;
        r4 = "";
    L27:
        OfficeSpaceItem r5 = new OfficeSpaceItem(r6, r7, r4, r9, null, false, MapsKt.emptyMap(), null, Integer.valueOf(r20.getCcmType()), 0, 656, null);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L30
        Object r0 = Result.constructor-impl(Boolean.valueOf(com.larus.drive.sdk.impl.utils.k.d(r110, r5, null, r21, r22)));     // Catch: Throwable -> L30
    L32:
        Throwable r8 = Result.exceptionOrNull-impl(r0);
        if (r8 == null) goto L35;
        FLogger.a.e("DrivePreviewHelper", "open drive uplink preview failed, errorType=".concat(r8.getClass().getSimpleName()));
    L35:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L43;
        r0 = r10;
    L43:
        return ((Boolean) r0).booleanValue();
    L30:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L18:
        r9 = null;
        goto L19
    L10:
        r6 = null;
    L39:
        return false;
    }

    public final void j(Context r5, CoroutineScope r6, cr9.a r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "request");
        Intrinsics.checkNotNullParameter(r8, "fallback");
        int r0 = g89.a.a;
        int r1 = ja9.a.a;
        boolean r2 = false;
        if (ga9.a.b("enable_doubao_chat_file_preview", false) == true) goto L11;
        FlowFileProtectionService r3 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L11;
    L13:
        if (r2 == true) goto L16;
        FLogger.a.i("FlowDriveSdkServiceImpl", "open AI file preview, result=fallback, reason=experiment_disabled");
        ((q0) r8).invoke();
        return;
    L16:
        FLogger.a.i("FlowDriveSdkServiceImpl", "open AI file preview, result=delegate");
        AiFilePreviewCoordinator r9 = AiFilePreviewCoordinator.a;
        AiFilePreviewCoordinator.d(r5, r6, r7, (q0) r8);
        return;
    L7:
        if (r3.I0() != true) goto L9;
        r4 = true;
    L11:
        r2 = true;
        goto L13
    }

    public final boolean s(FragmentActivity r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "filePath");
        Intrinsics.checkNotNullParameter(r8, "fileName");
        Intrinsics.checkNotNullParameter(r9, "localFileProviderAuthority");
        int r4 = DriveLocalFilePreviewDelegate.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "filePath");
        Intrinsics.checkNotNullParameter(r8, "fileName");
        Intrinsics.checkNotNullParameter(r9, "localFileProviderAuthority");
    L3:
        String r1 = null;
        if ((r6 instanceof ContextWrapper) == false) goto L13;
        if ((r6 instanceof Activity) == true) goto L7;
        FragmentActivity r0 = ((ContextWrapper) r6).getBaseContext();
        if (r0 == r6) goto L15;
        Intrinsics.checkNotNull(r0);
        r6 = r0;
    L15:
        Activity r10 = null;
    L16:
        if (r10 != null) goto L19;
    L43:
        return false;
    L19:
        if (r10.isFinishing() == true) goto L43;
        if (r10.isDestroyed() == true) goto L43;
        if (StringsKt.isBlank(r8) == true) goto L43;
        File r11 = DriveLocalFilePreviewDelegate.c(r7);
        if (r11 == null) goto L43;
        String r2 = AccountService.a.getUserId();
        if ((!StringsKt.isBlank(r2)) == false) goto L31;
        r1 = r2;
    L31:
        if (r1 == null) goto L43;
        IOfficeSdkServiceV2 r3 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r3 == null) goto L43;
        if (r3.f0() == false) goto L43;
        Intent r5 = new Intent(r10, DrivePreviewActivity.class);     // Catch: Exception -> L41
        r5.putExtra("local_file_path", r11.getAbsolutePath());     // Catch: Exception -> L41
        r5.putExtra("local_file_name", r8);     // Catch: Exception -> L41
        r5.putExtra("preview_account_id", r1);     // Catch: Exception -> L41
        r5.putExtra("local_file_provider_authority", r9);     // Catch: Exception -> L41
        r10.startActivity(r5);     // Catch: Exception -> L41
        return true;
    L41:
        e = move-exception;
        FLogger.a.e("DriveLocalFilePreview", "open failed, errorType=".concat(e.getClass().getSimpleName()));
        goto L43
    L7:
        r10 = (Activity) r6;
        goto L16
    L13:
        if ((r6 instanceof Activity) == false) goto L15;
        r10 = (Activity) r6;
        goto L16
    }

    public final void t(com.larus.platform.api.s r20, LifecycleCoroutineScope r21, z0 r22, a1 r23) {
        Intrinsics.checkNotNullParameter(r20, "item");
        Intrinsics.checkNotNullParameter(r21, "scope");
        FlowDriveFileType r3 = r20.d;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        DriveFileType r5 = DriveFileType.VIDEO;
    L10:
        DriveFileType r16 = r5;
        int r6 = RegisterDriveResourceHelper.a;
        RegisterDriveResourceHelper.a(new DriveFileItem(r20.a, r20.b, "", 12, "", 0, 0, 0, "", r16, 1, null), r21, r22, r23);
        return;
    L5:
        if (r4 == 2) goto L8;
        r22.invoke(null);
        return;
    L8:
        r5 = DriveFileType.AUDIO;
        goto L10
    }

    public final void q(final FragmentManager r6, String r7, Long r8, SelectDialogParam r9, d1 r10) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        final String r0 = "MultimodalInputWrapper";
        if (StringsKt.isBlank("MultimodalInputWrapper") == false) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0 = "ChatFileSelectDialog";
    L8:
        final ChatFileSelectDialog r2 = new ChatFileSelectDialog();
        Bundle r3 = new Bundle();
        r3.putString("arg_conversation_id", r7);
        if (r8 == null) goto L11;
        r3.putLong("arg_last_chat_time", r8.longValue());
    L11:
        r3.putSerializable("arg_dialog_param", r9);
        r2.setArguments(r3);
        r2.j = r10;
        com.larus.utils.t0.e(new u(r6, r0, this, r2));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void z(String r2, FlowDriveFileType r3, LifecycleCoroutineScope r4, Function1 r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r2, "objToken");
        Intrinsics.checkNotNullParameter(r3, "fileType");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "onSuccess");
        ObjTokenGetUrlHelper r0 = ObjTokenGetUrlHelper.a;
        ObjTokenGetUrlHelper.a(r2, r3, r4, r5, r6);
    }

    public final String f(CoroutineScope r9, String r10, int r11, int r12, Function1<? super String, Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "token");
        IDriveSdkService r1 = (IDriveSdkService) this.a.getValue();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.f(r9, r10, r11, r12, r13, r14);
    }

    public final void k(FragmentManager r6, DriveFileSelectScene r7, List r8, int r9, com.larus.platform.api.fileselect.a r10, SelectDialogParam r11) {
        Intrinsics.checkNotNullParameter(r6, "fragmentManager");
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r10, "selectionStore");
        boolean r2 = false;
        if (l() == true) goto L8;
        FLogger.a.i("FlowDriveSdkServiceImpl", "[triggerDriveFileSelection] picker is not initialized");
        IOfficeSdkServiceV2 r12 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r12 == null) goto L31;
        IOfficeSdkServiceV2.a.b(r12, false, "drive_file_selection", 5);
        return;
    L31:
        return;
    L8:
        int r1 = DriveFileSelectDialog.t;
        String r3 = AppHost.a.getApplication().getString(2131905360);
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r7, "scene");
        DriveFileSelectDialog r0 = new DriveFileSelectDialog();
        Bundle r4 = new Bundle();
        r4.putString("arg_title", r3);
        r4.putString("arg_scene", r7.getValue());
        if (r8 != null) goto L11;
    L13:
        r4.putBoolean("arg_allow_file", true ^ r2);
        r4.putInt("arg_current_size", r9);
        if (r8 == null) goto L20;
        List r13 = r8;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        r14.add(((FlowDriveFileType) r15.next()).name());
        goto L17
    L19:
        ArrayList<String> r16 = new ArrayList(r14);
    L21:
        r4.putStringArrayList("arg_allow_file_type_list", r16);
        r4.putSerializable("arg_dialog_param", r11);
        r0.setArguments(r4);
        Intrinsics.checkNotNullParameter(r10, "store");
        r0.n = r10;
        r0.s = new t(this);
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "MultimodalInputWrapper", r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r0, r17) == true) goto L32;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        r0.show(r6, "MultimodalInputWrapper");
        return;
    L32:
        return;
    L20:
        r16 = null;
        goto L21
    L11:
        if (r8.contains(FlowDriveFileType.FILE) == true) goto L13;
        r2 = true;
        goto L13
    }
}
