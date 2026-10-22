package com.larus.uaigc.worldcup.component;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.api.e4;
import com.larus.platform.api.g3;
import com.larus.platform.service.c1;
import com.larus.platform.service.k2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.lynx.LynxPageData;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.uaigc.lynx.pocket.JumpSomewherePocket;
import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.uaigc.lynx.pocket.PocketDataCache;
import com.larus.uaigc.lynx.pocket.SendMsgPocket;
import com.larus.uaigc.service.IZLotteryService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.l3;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0093\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010P\u001a\u00020QH\u0016J\u0016\u0010R\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\b\u0010V\u001a\u00020QH\u0016J\u001e\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\u0006\u0010X\u001a\u000208H\u0002J\b\u0010Y\u001a\u00020QH\u0016J\b\u0010Z\u001a\u00020\u0007H\u0002J \u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010X\u001a\u000208H\u0002J8\u0010^\u001a\u00020\u00072\u0016\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010C2\u0006\u0010X\u001a\u0002082\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020aH\u0002J \u0010c\u001a\u0002082\u0016\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010CH\u0002J\u0010\u0010e\u001a\u00020Q2\u0006\u0010\\\u001a\u00020FH\u0002J\u0010\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020FH\u0016J\b\u0010h\u001a\u00020QH\u0002J\b\u0010i\u001a\u00020QH\u0002J\u0010\u0010j\u001a\u00020k2\u0006\u0010X\u001a\u000208H\u0002J\b\u0010l\u001a\u00020QH\u0016J<\u0010m\u001a\u00020Q2\u0006\u0010n\u001a\u00020o2\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0CH\u0002J\"\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020a2\u0006\u0010t\u001a\u00020a2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0010\u0010w\u001a\u00020Q2\u0006\u0010x\u001a\u00020\u0007H\u0002JF\u0010y\u001a\u00020Q2\u0006\u0010n\u001a\u00020o2\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\b\b\u0002\u0010z\u001a\u000208H\u0002JF\u0010{\u001a\u00020Q2\u0006\u0010n\u001a\u00020o2\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\b\b\u0002\u0010z\u001a\u000208H\u0002J\u0016\u0010|\u001a\u00020Q2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020Q0~H\u0002J\u0010\u0010\u007f\u001a\u00020Q2\u0006\u0010n\u001a\u00020oH\u0002J\r\u0010\u0080\u0001\u001a\u000208*\u00020oH\u0002J?\u0010\u0081\u0001\u001a\u00020Q2\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\b\b\u0002\u0010z\u001a\u000208H\u0002JA\u0010\u0082\u0001\u001a\u00020Q2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0C2\u0014\u0010q\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D0CH\u0016J\u0015\u0010\u0085\u0001\u001a\u00020Q2\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0016J\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010@H\u0016J\f\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\t\u0010\u0089\u0001\u001a\u00020QH\u0016J\u0013\u0010\u008a\u0001\u001a\u00020Q2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\u0012\u0010\u008b\u0001\u001a\u00020Q2\u0007\u0010\u008c\u0001\u001a\u00020@H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020Q2\u0007\u0010\u008c\u0001\u001a\u00020@H\u0002J\u000b\u0010\u008e\u0001\u001a\u0004\u0018\u00010@H\u0002J\u000b\u0010\u008f\u0001\u001a\u0004\u0018\u00010@H\u0002J\t\u0010\u0090\u0001\u001a\u00020QH\u0002J\t\u0010\u0091\u0001\u001a\u00020QH\u0002J\t\u0010\u0092\u0001\u001a\u00020aH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\r\u001a\u0004\b+\u0010,R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\r\u001a\u0004\b4\u00105R\u0012\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\r\u001a\u0004\bI\u0010JR\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2 = {"Lcom/larus/uaigc/worldcup/component/WorldCupLynxComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/spring/ability/MainVenueLynxAbility;", "Lcom/larus/uaigc/lynx/OnMainVenueBridgeListener;", "<init>", "()V", "TAG", "", "inputAbility", "Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "getInputAbility", "()Lcom/larus/uaigc/spring/ability/MainVenueInputAbility;", "inputAbility$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/uaigc/worldcup/component/WorldCupArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/worldcup/component/WorldCupArgumentData;", "argumentData$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "instructionAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "reportAbility", "Lcom/larus/uaigc/worldcup/ability/WorldCupReportAbility;", "getReportAbility", "()Lcom/larus/uaigc/worldcup/ability/WorldCupReportAbility;", "reportAbility$delegate", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "aiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "multiAttachmentSelectorController", "Lcom/larus/bmhome/instruction/IMultiAttachmentSelectorController;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "lynxViewLoadResult", "", "Ljava/lang/Boolean;", "lynxViewLoadErrorMsg", "onLoadStartTimeMs", "", "nativeFirstFrameTimeMs", "lynxFirstFrameTimeMs", "currClickPocketInfo", "Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "albumClickPocketInfo", "getPocketPageDataResponseDict", "", "", "rootView", "Landroid/view/View;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "mainThreadHandler", "Landroid/os/Handler;", "showLoadingRunnable", "Ljava/lang/Runnable;", "onAttach", "", "onAlbumSelected", "uriList", "", "Landroid/net/Uri;", "onCreate", "getTraceInfo", "useCache", "onResume", "getActualUrl", "initLynxView", "containerView", "pageData", "generateLynxPageDataJson", "pocketResponseDict", "cacheInvalid", "", "inputBoxShowSetting", "isPocketPageDataInValid", "pocketResponseCacheDict", "initLynx", "onViewCreated", "view", "showLoadingByDelay", "blockAndHideLoading", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "onDestroy", "pocketJumpSomeWhere", "pocket", "Lcom/larus/uaigc/lynx/pocket/Pocket;", "originData", "extra", "handleOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "handleOpenSchema", "jumpSchemaUrl", "pocketSendMsg", "isFromAvatarResult", "sendMessageWithPocket", "checkImageReadPermission", "doNext", "Lkotlin/Function0;", "prefetchPresetImage", "isPresetImageValid", "executeApplyPocket", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "onPopNativePage", "getCurrentClickPocketInfo", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "clearCurrentClickPocketInfo", "onUploadDigitalAvatarResult", "setCurrClickPocket", "clickPocket", "setAlbumClickPocketInfo", "getCurrClickPocketInfo", "getAlbumClickPocketInfo", "clearCurrClickPocketInfo", "clearAlbumClickPocketInfo", "getInputBoxShowSetting", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WorldCupLynxComponent extends BaseContentWidget implements zz9.b, com.larus.uaigc.lynx.i {
    public static final /* synthetic */ int E = 0;
    public View A;
    public final Lazy B;
    public final Handler C;
    public final k D;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public e4 t;
    public final Lazy u;
    public com.larus.bmhome.instruction.helper.f v;
    public final Lazy w;
    public ClickPocketInfo x;
    public ClickPocketInfo y;
    public Map<String, ? extends Object> z;

    public static final class a {
    }

    public static final class b implements Function0<zz9.a> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(zz9.a.class));
        }
    }

    public static final class c implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class d implements Function0<com.larus.bmhome.instruction.h> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.h.class));
        }
    }

    public static final class e implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class f implements Function0<c0a.a> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(c0a.a.class));
        }
    }

    public static final class g implements Function0<com.larus.uaigc.worldcup.component.a> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(com.larus.uaigc.worldcup.component.a.class));
        }
    }

    static {
    }

    @Override // zz9.b
    public final void K9() {
        this.x = null;
        FLogger.a.i(this.m, "[clearCurrClickPocketInfo] finish, currClickPocketInfo = null");
    }

    @Override // zz9.b
    public final void M8(Intent r1) {
    }

    @Override // zz9.b
    public final NestedFileContent T() {
        return null;
    }

    @Override // zz9.b
    public final void r3(int r1, Intent r2) {
    }

    public final com.larus.uaigc.worldcup.component.a B3() {
        return (com.larus.uaigc.worldcup.component.a) this.o.getValue();
    }

    public final void onDestroy() {
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r0 = com.larus.uaigc.lynx.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r1 = com.larus.uaigc.lynx.a.a;
        if (r1.contains(this) == false) goto L5;
        WorldCupLynxComponent r2 = this;
    L6:
        if (r2 == null) goto L8;
        r1.remove(r2);
    L8:
        com.larus.bmhome.instruction.helper.f r3 = this.v;
        if (r3 == null) goto L11;
        r3.onDestroy();
    L11:
        e4 r4 = this.t;
        if (r4 == null) goto L14;
        r4.destroy();
    L14:
        this.t = null;
        this.C.removeCallbacksAndMessages(null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onResume() {
        FLogger.a.i(this.m, "[onResume] timeMs: " + System.currentTimeMillis());
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, zz9.b.class);
        IAIChatUgcAIGCService.Companion r1 = IAIChatUgcAIGCService.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.instruction.helper.f r0 = r1.H0(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r0.b(new m(this));
        r0.c(new n(this));
        this.v = r0;
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [com.larus.uaigc.worldcup.component.k] */
    public WorldCupLynxComponent() {
        this.m = "WorldCupLynxComponent" + hashCode();
        this.n = LazyKt.lazy(new b(this));
        this.o = LazyKt.lazy(new g(this));
        this.p = LazyKt.lazy(new c(this));
        this.q = LazyKt.lazy(new d(this));
        this.r = LazyKt.lazy(new e(this));
        this.s = LazyKt.lazy(new f(this));
        this.u = LazyKt.lazy(new h());
        this.w = LazyKt.lazy(new i(this));
        this.B = LazyKt.lazy(new j(this));
        this.C = new Handler(Looper.getMainLooper());
        this.D = new k(this);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        FLogger.a.i(this.m, "[onCreate] timeMs: " + System.currentTimeMillis());
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r0 = com.larus.uaigc.lynx.a.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.uaigc.lynx.i> r1 = com.larus.uaigc.lynx.a.a;
        if ((!r1.contains(this)) == false) goto L5;
        WorldCupLynxComponent r2 = this;
    L6:
        if (r2 == null) goto L8;
        r1.add(r2);
    L8:
        zz9.a r3 = (zz9.a) this.n.getValue();
        if (r3 == null) goto L12;
        r3.T9(false);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // zz9.b
    public final ClickPocketInfo Ka() {
        return this.x;
    }

    public static void Y2(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final void h3(WorldCupLynxComponent r4) {
        r4.getClass();
        FLogger.a.i(r4.m, "[blockAndHideLoading] start");
        r4.C.removeCallbacks(r4.D);
    L7:
        e = move-exception;
        FLogger.a.e(r4.m, "[blockAndHideLoading] dismiss loadingDialog error", e);
    L9:
        FLogger.a.i(r4.m, "[blockAndHideLoading] end");
        return;
    L4:
        if (((l0) r4.B.getValue()).isShowing() == false) goto L9;
        Y2((l0) r4.B.getValue());     // Catch: Exception -> L7
        goto L9
    }

    public final Map<String, Object> C3(boolean r11) {
        com.larus.uaigc.worldcup.component.a r0 = B3();
        long r2 = -1;
        if (r0 == null) goto L11;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        long r4 = r1.getLong("click_action_bar_time");
    L8:
        Long r3 = Long.valueOf(r4);
        if (r3 == null) goto L11;
        long r5 = r3.longValue();
    L12:
        com.larus.uaigc.worldcup.component.a r6 = B3();
        if (r6 == null) goto L21;
        Bundle r7 = r6.a;
        if (r7 == null) goto L17;
        long r8 = r7.getLong("schema_handle_time");
    L18:
        Long r9 = Long.valueOf(r8);
        if (r9 == null) goto L21;
        r2 = r9.longValue();
        goto L21
    L17:
        r8 = -1;
    L21:
        Pair[] r10 = new Pair[7];
        com.larus.uaigc.worldcup.component.a r12 = B3();
        String r13 = null;
        if (r12 == null) goto L24;
        String r14 = r12.b();
    L25:
        r10[0] = TuplesKt.to("enter_method", r14);
        r10[1] = TuplesKt.to("current_page", "world_cup_2026");
        com.larus.uaigc.worldcup.component.a r15 = B3();
        if (r15 == null) goto L28;
        String r16 = r15.a();
    L29:
        r10[2] = TuplesKt.to("action_bar_key", r16);
        r10[3] = TuplesKt.to("click_action_bar_time", Long.valueOf(r5));
        r10[4] = TuplesKt.to("schema_handle_time", Long.valueOf(r2));
        if (r11 == false) goto L32;
        String r17 = "cache";
    L33:
        r10[5] = TuplesKt.to("data_source", r17);
        com.larus.uaigc.worldcup.component.a r18 = B3();
        if (r18 == null) goto L38;
        Bundle r19 = r18.a;
        if (r19 == null) goto L38;
        r13 = r19.getString("prompt_from");
    L38:
        r10[6] = TuplesKt.to("prompt_from", r13);
        return MapsKt.mapOf(r10);
    L32:
        r17 = "fetch";
        goto L33
    L28:
        r16 = null;
        goto L29
    L24:
        r14 = null;
        goto L25
    L7:
        r4 = -1;
    L11:
        r5 = -1;
        goto L12
    }

    public final void E3(List<? extends Uri> r57) {
        if (this.y != null) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        ClickPocketInfo r1 = this.y;
        Iterator<T> r2 = r57.iterator();
    L6:
        String r10 = "";
        if (r2.hasNext() == false) goto L36;
        String r4 = vqc.d.d(AppHost.a.getApplication(), (Uri) r2.next());
        ImFileUtil r5 = ImFileUtil.a;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r4);
        r5.getClass();
        UplinkEntityContent r7 = new UplinkEntityContent(null, new Image(null, ImFileUtil.g(r6), null, new ImageObj(null, 0, 0, null, null, 31, null), null, r4, null, null, null, null, null, null, null, null, 16341, null), 1, null);
        UplinkEntityType r8 = UplinkEntityType.EntityTypeImage;
        r3.add(new UplinkFileEntity(Integer.valueOf(r8.getValue()), r7, null, null, Integer.valueOf(FileReviewState.DEFAULT.getValue()), Integer.valueOf(FileParseState.DEFAULT.getValue()), 0, Integer.valueOf(UpLinkState.PROCESSING.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r4)), null, null, null, 15116, null));
        if (r1 == null) goto L15;
        Pocket r9 = r1.getPocket();
        if (r9 == null) goto L15;
        SendMsgPocket r11 = r9.getSendMsgPocket();
        if (r11 == null) goto L15;
        String r12 = r11.getPresetImageUrl();
    L16:
        if (r1 == null) goto L22;
        Pocket r13 = r1.getPocket();
        if (r13 == null) goto L22;
        SendMsgPocket r14 = r13.getSendMsgPocket();
        if (r14 == null) goto L22;
        String r15 = r14.getPresetImageUri();
    L24:
        if (o0.d(r15) == false) goto L6;
        if (o0.d(r12) == false) goto L6;
        FLogger r16 = FLogger.a;
        r16.i(this.m, "[onAlbumSelected] imageUri: " + r15 + ", imageUrl: " + r12);
        Keva r17 = e0a.b.a;
        if (r15 == null) goto L31;
        r10 = r15;
    L31:
        Intrinsics.checkNotNullParameter(r10, "key");
        String r18 = e0a.b.a.getString(r10, null);
        if (m5.c(r18) == true) goto L35;
        r18 = null;
    L35:
        r16.i(this.m, "[onAlbumSelected] localResPath: " + r18);
        r3.add(new UplinkFileEntity(Integer.valueOf(r8.getValue()), new UplinkEntityContent(null, new Image(r15, null, null, new ImageObj(r12, 0, 0, null, null, 30, null), null, r18, null, null, null, null, null, null, null, null, 16342, null), 1, null), null, null, Integer.valueOf(FileReviewState.ACCESS.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 0, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16140, null));
    L22:
        r15 = null;
    L15:
        r12 = null;
        goto L16
    L36:
        NestedFileContent r19 = new NestedFileContent(r3, null, false, null, 14, null);
        if (r1 == null) goto L39;
        Map<String, Object> r20 = r1.getExtra();
    L40:
        CustomMultiAttachmentInfo r46 = new CustomMultiAttachmentInfo("album", "world_cup_2026", r19, false, false, true, e0a.a.a(r20), null, 136, null);
        if (r1 == null) goto L48;
        Pocket r21 = r1.getPocket();
        if (r21 == null) goto L48;
        String r22 = r21.getPrompt();
        if (r22 == null) goto L48;
        String r23 = r22;
    L49:
        ICoreInputAbility.OnSendParams r24 = new ICoreInputAbility.OnSendParams(r23, "", null, null, null, null, null, null, 8888, false, null, false, false, false, null, null, null, null, false, "", null, null, null, null, null, null, r46, null, null, null, null, null, null, -67633472, 1, null);
        if (r1 == null) goto L58;
        com.larus.bmhome.instruction.g r25 = (com.larus.bmhome.instruction.g) this.r.getValue();
        if (r25 == null) goto L54;
        r25.A1();
    L54:
        G3(r1);
        this.y = null;
        c0a.a r26 = (c0a.a) this.s.getValue();
        if (r26 == null) goto L57;
        r26.O2(null);
    L57:
        FLogger.a.i(this.m, "[clearAlbumClickPocketInfo] finish, currClickPocketInfo = null");
    L58:
        zz9.a r27 = (zz9.a) this.n.getValue();
        if (r27 == null) goto L69;
        zz9.a.C0088a.a(r27, r24, "spring_guide_2026_sug", null, false, 12);
        return;
    L69:
        return;
    L48:
        r23 = "";
        goto L49
    L39:
        r20 = null;
        goto L40
    }

    public final void G3(ClickPocketInfo r4) {
        this.x = r4;
        FLogger.a.i(this.m, "[setCurrClickPocket] finish, currClickPocketInfo = " + this.x);
    }

    public final void onViewCreated(View r14) {
        Intrinsics.checkNotNullParameter(r14, "view");
        this.A = r14;
        this.C.postDelayed(this.D, 1000);
        PocketDataCache.a.getClass();
        Map<String, ? extends Object> r1 = PocketDataCache.c();
        com.larus.uaigc.lynx.j.a.getClass();
        boolean r2 = com.larus.uaigc.lynx.j.b();
        FLogger r3 = FLogger.a;
        r3.i(this.m, "[isPocketPageDataValidOptionOpen] isCacheOff = " + r2);
        String r4 = this.m;
        StringBuilder r5 = new StringBuilder("[initLynx] isInvalid = ");
        r5.append(r2);
        r5.append(", pocketResponseCacheDict.size = ");
        if (r1 == null) goto L5;
        int r6 = ((ConcurrentHashMap) r1).size();
    L6:
        r5.append(r6);
        r3.i(r4, r5.toString());
        if (r2 == false) goto L9;
        String r7 = z3(MapsKt.emptyMap(), false, 1, 0);
        D3(r14, r7, false);
        r3.e(this.m, "[initLynx] inValid: true, init lynx by empty pocketPageData");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new WorldCupLynxComponent$initLynx$1(this, 0, r7, null), 2, null);
    L18:
        System.currentTimeMillis();
        return;
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new WorldCupLynxComponent$initLynx$2(this, r14, null), 2, null);
        goto L18
    L17:
        this.z = r1;
        r3.i(this.m, "[initLynx] inValid: false, use cache pocketPageData initLynx");
        String r9 = z3(r1, true, 0, 0);
        r3.i(this.m, "[initLynx] inValid: false, cache pocketPageData pageDataJson generate = " + r9 + ", inputBoxShowSetting = 0");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new WorldCupLynxComponent$initLynx$3(this, r14, r9, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new WorldCupLynxComponent$initLynx$4(this, null), 3, null);
        goto L18
    L11:
        if (((ConcurrentHashMap) r1).isEmpty() == true) goto L14;
        r8 = false;
        goto L15
    L5:
        r6 = -1;
        goto L6
    }

    @Override // com.larus.uaigc.lynx.i
    public final void r(Activity r2) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity(), r2) == false) goto L6;
        s1a.a.getActivity(this).finish();
        return;
    }

    public final void D3(View r8, String r9, boolean r10) {
        c1 r11 = c1.a;
        if (r11.d() == true) goto L5;
        r11.f();
    L5:
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L29
        com.larus.uaigc.worldcup.component.a r2 = B3();     // Catch: Throwable -> L29
        if (r2 == null) goto L13;
        Bundle r3 = r2.a;     // Catch: Throwable -> L29
        if (r3 == null) goto L11;
        String r4 = r3.getString("enter_schema");     // Catch: Throwable -> L29
    L12:
        if (r4 == null) goto L13;
    L14:
        Uri r5 = UriProtector.parse(r4);     // Catch: Throwable -> L29
        String r6 = UriProtector.getQueryParameter(r5, "template_url");     // Catch: Throwable -> L29
        if (o0.d(r6) == false) goto L26;
        Uri.Builder r7 = new Uri.Builder().scheme("sslocal").authority("lynxview").appendQueryParameter("url", r6);     // Catch: Throwable -> L29
        Iterator r12 = UriProtector.getQueryParameterNames(r5).iterator();     // Catch: Throwable -> L29
    L18:
        if (r12.hasNext() == false) goto L25;
        String r13 = (String) r12.next();     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r13, "template_url") == true) goto L18;
        Iterator r14 = UriProtector.getQueryParameters(r5, r13).iterator();     // Catch: Throwable -> L29
    L23:
        if (r14.hasNext() == false) goto L18;
        r7.appendQueryParameter(r13, (String) r14.next());     // Catch: Throwable -> L29
        goto L23
    L25:
        String r15 = r7.build().toString();     // Catch: Throwable -> L29
        FLogger.a.i(this.m, "[getActualUrl] newSchema: " + r15);     // Catch: Throwable -> L29
    L27:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r16) == true) goto L35;
        r0 = r16;
    L35:
        e4 r17 = c1.a.g(r8.getContext(), (String) r0, r9, new q(this));
        this.t = r17;
        if (r17 == null) goto L50;
        View r18 = r17.getView();
        if (r18 == null) goto L51;
        ViewGroup r19 = (ViewGroup) r8.findViewById(2131372778);
        if ((r8 instanceof ViewGroup) == false) goto L52;
        r19.removeAllViews();
        r19.addView(r18, new ConstraintLayout.LayoutParams(-1, -1));
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L26:
        r15 = "";
        goto L27
    L11:
        r4 = null;
    L13:
        r4 = "";
    L29:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }

    @Override // com.larus.uaigc.lynx.i
    public final void b(Activity r12, Map<String, ? extends Object> r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "extra");
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity(), r12) == false) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new WorldCupLynxComponent$executeApplyPocket$1(r13, this, r14, false, null), 2, null);
        return;
    }

    public static final void m3(final WorldCupLynxComponent r14, Pocket r15, Map r16, Map r17) {
        FLogger.a.i(r14.m, "[pocketJumpSomeWhere] jumpSomewherePocket = " + r15.getJumpSomewherePocket());
        JumpSomewherePocket r1 = r15.getJumpSomewherePocket();
        if (r1 == null) goto L33;
        String r2 = r1.getJumpInstructionId();
        String r5 = null;
        if (o0.d(r2) == false) goto L27;
        int r3 = l3.e(r2, 0);
        if (r3 <= 0) goto L34;
        com.larus.bmhome.instruction.g r4 = (com.larus.bmhome.instruction.g) r14.r.getValue();
        if (r4 == null) goto L11;
        r4.A1();
    L11:
        r14.G3(new ClickPocketInfo(r15, r16, r17, null, 8, null));
        z8 r6 = (z8) r14.w.getValue();
        if (r6 == null) goto L14;
        r6.a9(true);
    L14:
        z0 r7 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(r3);
        if (r7 == null) goto L35;
        String r8 = r1.getInsertPrompt();
        if (o0.d(r8) == false) goto L19;
        String r9 = r8;
    L20:
        if (r9 == null) goto L24;
        ICoreInputAbility r10 = (ICoreInputAbility) r14.p.getValue();
        if (r10 == null) goto L24;
        ICoreInputAbility.b.d(r10, r9, false, false, null, null, false, 62);
    L24:
        com.larus.bmhome.instruction.h r11 = (com.larus.bmhome.instruction.h) r14.q.getValue();
        if (r11 == null) goto L36;
        com.larus.bmhome.instruction.h.a.a(r11, r7, 5, new o(r14), 8);
        return;
    L36:
        return;
    L19:
        r9 = null;
        goto L20
    L35:
        return;
    L34:
        return;
    L27:
        String r12 = r1.getJumpSchemaUrl();
        if (o0.d(r12) == false) goto L30;
        r5 = r12;
    L30:
        if (r5 == null) goto L38;
        Bundle r13 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("open_new_chat_page_on_send", Boolean.FALSE)});
        Uri r18 = UriProtector.parse(r5);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        com.bytedance.router.i r0 = SmartRouter.buildRoute(com.larus.ui.arch.component.internal.attach.a.b(r14, r14).getContext(), r18.buildUpon().appendQueryParameter("android_no_clear_top", "1").build().toString());
        r0.c.putExtras(r13);
        r0.e(99323);
        return;
    L38:
        return;
    }

    public final String z3(Map<String, ? extends Object> r23, boolean r24, int r25, int r26) {
        Object r3 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        IZLotteryService.a.e();     // Catch: Throwable -> L19
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L19
        FLogger.a.i(this.m, "[generateLynxPageDataJson] sendMessageStatus = 0");     // Catch: Throwable -> L19
        if (r23 != null) goto L6;
        Map<String, ? extends Object> r5 = MapsKt.emptyMap();     // Catch: Throwable -> L19
    L7:
        Map<String, Object> r11 = C3(r24);     // Catch: Throwable -> L19
        String r14 = String.valueOf(r25);     // Catch: Throwable -> L19
        com.larus.uaigc.worldcup.component.a r1 = B3();     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        Bundle r2 = r1.a;     // Catch: Throwable -> L19
        if (r2 == null) goto L12;
        String r4 = r2.getString("enter_schema");     // Catch: Throwable -> L19
    L13:
        if (r4 == null) goto L16;
        String r18 = r4;
    L17:
        Object r6 = Result.constructor-impl(((Gson) this.u.getValue()).toJson(new LynxPageData(r5, 0, 0, 0, r11, null, r13, r14, "0", "0", "0", r18, e0a.b.a() ? 1 : 0, 46, null)));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r6) == true) goto L25;
        r3 = r6;
    L25:
        String r7 = (String) r3;
        if (r7 != null) goto L29;
        return "";
    L29:
        return r7;
    L12:
        r4 = null;
    L16:
        r18 = "";
        goto L17
    L6:
        r5 = r23;
    L19:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.uaigc.worldcup.component.l] */
    public static final void p3(final WorldCupLynxComponent r46, final Pocket r47, final Map r48, final Map r49, final boolean r50) {
        FLogger r0 = FLogger.a;
        r0.i(r46.m, "[sendMessageWithPocket] sendMsgPocket = " + r47.getSendMsgPocket());
        SendMsgPocket r1 = r47.getSendMsgPocket();
        if (r1 != null) goto L5;
        r0.e(r46.m, "[sendWithOnSendParams] id = " + r47.getPocketId() + ", type = " + r47.getPocketType() + ", sendMsgPocket is null.");
        return;
    L5:
        if (Intrinsics.areEqual(r1.getAllowPhotos(), Boolean.TRUE) == true) goto L7;
        com.larus.bmhome.instruction.g r2 = (com.larus.bmhome.instruction.g) r46.r.getValue();
        if (r2 == null) goto L18;
        r2.A1();
    L18:
        r46.G3(new ClickPocketInfo(r47, r48, r49, Boolean.valueOf(r50)));
        String r10 = r47.getPrompt();
        if (r10 == null) goto L25;
        ICoreInputAbility.OnSendParams r3 = new ICoreInputAbility.OnSendParams(r10, "", null, null, null, null, null, null, 8888, false, null, false, false, false, null, null, null, null, false, "", null, null, null, null, null, null, null, null, null, null, null, null, null, -524608, 1, null);
        zz9.a r11 = (zz9.a) r46.n.getValue();
        if (r11 == null) goto L23;
        zz9.a.C0088a.a(r11, r3, "spring_guide_2026_sug", null, false, 12);
        Unit r4 = Unit.INSTANCE;
    L24:
        if (r4 == null) goto L25;
        return;
    L23:
        r4 = null;
    L25:
        r0.e(r46.m, "[sendWithOnSendParams] id = " + r47.getPocketId() + ", type = " + r47.getPocketType() + ", prompt is empty.");
        return;
    L7:
        if (r1.getSelectedPhotosCount() != null) goto L9;
        return;
    L9:
        if (r1.getSelectedPhotosCount().intValue() > 0) goto L11;
        return;
    L11:
        if (r1.getSelectedPhotosCount().intValue() <= 1) goto L13;
        final boolean r6 = true;
    L14:
        final Integer r7 = r1.getSelectedPhotosCount();
        final ?? r9 = new l(r46, r47, r48, r49, r50, r6, r7);
        k2 r5 = k2.a;
        Intrinsics.checkNotNullParameter(r46, "<this>");
        g3.a.a(com.larus.ui.arch.component.internal.attach.a.b(r46, r46), null, false, null, false, new p(r9), 30);
        return;
    L13:
        r6 = false;
        goto L14
    }
}
