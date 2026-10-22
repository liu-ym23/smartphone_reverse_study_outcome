package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import aq9.c;
import aq9.g;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.bottommenu.d1;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponent;
import com.larus.platform.api.DriveFileSelectScene;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.IAiFilePreviewService;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.api.p;
import com.larus.platform.api.s;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096@¢\u0006\u0002\u0010\u0011J,\u0010!\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0'J\u0012\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0016J0\u0010+\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0016JL\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020?H\u0016JG\u0010A\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\b\u0010B\u001a\u0004\u0018\u00010\u00162\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010>\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0002\u0010FJ$\u0010G\u001a\u00020\u001c2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010J\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020KH\u0016J \u0010M\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u00010\u00162\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O05H\u0016JO\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\"\u001a\u00020#2%\u0010S\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0004\u0012\u00020\u001c\u0018\u00010T2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016Ja\u0010Y\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010Z\u001a\u00020\u00162\u0006\u0010[\u001a\u0002082\u0006\u0010\\\u001a\u0002082#\u0010S\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u001c\u0018\u00010T2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016JJ\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u0002062\u0006\u0010\"\u001a\u00020#2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c0T2\u0014\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010TH\u0016J \u0010a\u001a\u0004\u0018\u00010\u00162\u0006\u0010_\u001a\u00020\u00162\u0006\u0010`\u001a\u000206H\u0096@¢\u0006\u0002\u0010bJ\u0018\u0010c\u001a\u0004\u0018\u00010\u00162\u0006\u0010d\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010eJ\u0014\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010\u0016H\u0016J\u000f\u0010i\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0002\u0010jJ\u000f\u0010k\u001a\u0004\u0018\u000108H\u0016¢\u0006\u0002\u0010jJ\u0018\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u0002082\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J#\u0010o\u001a\u0004\u0018\u00010\u00162\b\u0010n\u001a\u0004\u0018\u00010D2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010pJ\u0019\u0010q\u001a\u0004\u0018\u0001082\b\u0010r\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010sR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006t"}, d2 = {"Lcom/larus/platform/service/FlowDriveSdkService;", "Lcom/larus/platform/api/IFlowDriveSdkService;", "<init>", "()V", "service", "getService", "()Lcom/larus/platform/api/IFlowDriveSdkService;", "service$delegate", "Lkotlin/Lazy;", "aiFilePreviewService", "Lcom/larus/platform/api/IAiFilePreviewService;", "getAiFilePreviewService", "()Lcom/larus/platform/api/IAiFilePreviewService;", "aiFilePreviewService$delegate", "supportsLocalFilePreview", "", "prepareLocalFilePreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openLocalFilePreview", "context", "Landroid/content/Context;", "filePath", "", "fileName", "localFileProviderAuthority", "isDriveAccessible", "isDriveAccessibleForColdStart", "needsInitializeWhenDriveAccessible", "", "needsInitialize", "isPickerInitialized", "getDriveStorage", "Lcom/larus/platform/api/DriveUserStorageData;", "openAiFilePreview", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/larus/platform/model/office/AiFilePreviewRequest;", "fallback", "Lkotlin/Function0;", "parseDriveUplinkInfo", "Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "rawInfo", "openDriveUplinkPreview", "sourceConversationId", "sourceBotId", "triggerDriveFileSelection", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "scene", "Lcom/larus/platform/api/DriveFileSelectScene;", "allowDriveFileTypeList", "", "Lcom/larus/platform/api/FlowDriveFileType;", "currentSize", "", "selectionStore", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore;", "dialogParam", "Lcom/larus/platform/api/fileselect/SelectDialogParam;", "registerDriveFileSelectionCallback", "callback", "Lcom/larus/platform/api/IFlowDriveFileSelectionCallback;", "unregisterDriveFileSelectionCallback", "showChatFileSelectDialog", "conversationId", "lastChatTime", "", "Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/platform/api/fileselect/SelectDialogParam;Ljava/lang/String;Lcom/larus/platform/api/fileselect/IChatFileSelectCallback;)V", "showChatFileSelectedListDialog", "selectedListener", "Lcom/larus/platform/api/fileselect/IChatFileSelectedListListener;", "registerChatFileSelectionCallback", "Lcom/larus/platform/api/fileselect/IChatFileSelectionCallback;", "unregisterChatFileSelectionCallback", "dispatchChatFileSelection", "selectedList", "Lcom/larus/platform/api/FlowSelectedFileItem;", "registerDriveResource", "item", "Lcom/larus/platform/api/FlowDriveFileItem;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resourceId", "onFailure", "getImageCoverUrl", "token", "height", "width", "url", "getUrlByObjToken", "objToken", "fileType", "getUrlByObjTokenSuspend", "(Ljava/lang/String;Lcom/larus/platform/api/FlowDriveFileType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchDriveVideoPreviewUrl", "fileToken", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDriveFileSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "jsonString", "getFloatChatShowPercent", "()Ljava/lang/Integer;", "isFloatChat", "getUploadFileTypeMobParam", "Lcom/larus/platform/api/fileselect/UploadFileTypeMobParam;", "ccmType", "getOriginFileType", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "getCcmObjType", "originFileType", "(Ljava/lang/String;)Ljava/lang/Integer;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class FlowDriveSdkService implements IFlowDriveSdkService {
    public static final FlowDriveSdkService a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    private FlowDriveSdkService() {
    }

    static {
        a = new FlowDriveSdkService();
        b = LazyKt.lazy(new o0());
        c = LazyKt.lazy(new p0());
    }

    public static IFlowDriveSdkService a() {
        return (IFlowDriveSdkService) b.getValue();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Integer A() {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.A();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Integer R() {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.R();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean h() {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.h();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean l() {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean o() {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.o();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean u() {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.u();
    }

    public static DriveUplinkInfo C(String r4) {
        if (r4 == null) goto L42;
        boolean r2 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L45;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl((DriveUplinkInfo) new Gson().fromJson(r4, DriveUplinkInfo.class));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = null;
    L17:
        DriveUplinkInfo r6 = (DriveUplinkInfo) r5;
        if (r6 == null) goto L43;
        String r3 = r6.getFileToken();
        if (r3 != null) goto L22;
    L25:
        boolean r7 = true;
    L26:
        if (r7 == false) goto L37;
        String r8 = r6.getUrl();
        if (r8 != null) goto L30;
    L33:
        boolean r9 = true;
    L34:
        if (r9 == false) goto L37;
        r2 = false;
        goto L37
    L30:
        if (StringsKt.isBlank(r8) == true) goto L33;
        r9 = false;
    L37:
        if (r2 == true) goto L39;
        return null;
    L39:
        return r6;
    L22:
        if (StringsKt.isBlank(r3) == true) goto L25;
        r7 = false;
        goto L26
    L43:
        return null;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L45:
        return null;
    L42:
        return null;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object d(Continuation<? super p> r2) {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.d(r2);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void e(MultimodalInputComponent.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final FlowDriveFileSendInfo m(String r2) {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m(r2);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Integer p(String r2) {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p(r2);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void r(MultimodalInputComponent.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.r(r2);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object v(Continuation<? super Boolean> r5) {
        if ((r5 instanceof FlowDriveSdkService$prepareLocalFilePreview$1) == false) goto L7;
        FlowDriveSdkService$prepareLocalFilePreview$1 r0 = (FlowDriveSdkService$prepareLocalFilePreview$1) r5;
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
        boolean r7 = ((Boolean) r6).booleanValue();
    L22:
        return Boxing.boxBoolean(r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        IFlowDriveSdkService r8 = a();
        if (r8 == null) goto L20;
        r0.label = 1;
        r6 = r8.v(r0);
        if (r6 != r2) goto L19;
        return r2;
    L20:
        r7 = false;
    L7:
        r0 = new FlowDriveSdkService$prepareLocalFilePreview$1(this, r5);
        goto L8
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void x(MultimodalInputComponent.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.x(r2);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void y(MultimodalInputComponent.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.y(r2);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object b(String r2, Continuation<? super String> r3) {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b(r2, r3);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final g c(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileName");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L7;
        g r4 = r0.c(r2, r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return new g(null, null);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final String g(Long r2, String r3) {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(r2, r3);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void w(String r2, List<com.larus.platform.api.u> r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedList");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.w(r2, r3);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final Object i(String r2, FlowDriveFileType r3, Continuation<? super String> r4) {
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.i(r2, r3, r4);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void n(FragmentManager r2, String r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.n(r2, r3, r4);
        return;
    }

    public static boolean B(Context r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        DriveUplinkInfo r6 = C(r3);
        if (r6 != null) goto L5;
        return false;
    L5:
        IAiFilePreviewService r1 = (IAiFilePreviewService) c.getValue();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.a(r2, r6, r4, r5) != true) goto L12;
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.platform.service.q0, kotlin.jvm.functions.Function0] */
    public final void j(Context r3, final CoroutineScope r4, cr9.a r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, "fallback");
        final AtomicBoolean r0 = new AtomicBoolean(false);
        ?? r1 = new q0(r4, r0, r6);
        boolean r7 = !StringsKt.isBlank(r5.a);
        IAiFilePreviewService r2 = (IAiFilePreviewService) c.getValue();
        if (r7 == false) goto L8;
        if (r2 == 0) goto L8;
        r2.j(r3, r4, r5, r1);
        return;
    L8:
        r1.invoke();
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final boolean s(FragmentActivity r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "filePath");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "localFileProviderAuthority");
        IFlowDriveSdkService r0 = a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.s(r2, r3, r4, r5);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void t(s r2, LifecycleCoroutineScope r3, com.larus.bmhome.chat.component.bottom.attachment.z0 r4, com.larus.bmhome.chat.component.bottom.attachment.a1 r5) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "scope");
        IFlowDriveSdkService r0 = a();
        if (r0 == null) goto L6;
        r0.t(r2, r3, r4, r5);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void q(FragmentManager r8, String r9, Long r10, SelectDialogParam r11, d1 r12) {
        Intrinsics.checkNotNullParameter(r8, "fragmentManager");
        IFlowDriveSdkService r1 = a();
        if (r1 == null) goto L6;
        r1.q(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void z(String r8, FlowDriveFileType r9, LifecycleCoroutineScope r10, Function1 r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r8, "objToken");
        Intrinsics.checkNotNullParameter(r9, "fileType");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        IFlowDriveSdkService r1 = a();
        if (r1 == null) goto L6;
        r1.z(r8, r9, r10, r11, r12);
        return;
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final String f(CoroutineScope r9, String r10, int r11, int r12, Function1<? super String, Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "token");
        IFlowDriveSdkService r1 = a();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.f(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.larus.platform.api.IFlowDriveSdkService
    public final void k(FragmentManager r9, DriveFileSelectScene r10, List r11, int r12, com.larus.platform.api.fileselect.a r13, SelectDialogParam r14) {
        Intrinsics.checkNotNullParameter(r9, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r13, "selectionStore");
        IFlowDriveSdkService r1 = a();
        if (r1 == null) goto L6;
        r1.k(r9, r10, r11, r12, r13, r14);
        return;
    }
}
