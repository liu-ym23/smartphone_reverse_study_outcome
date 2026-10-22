package com.larus.voicecall.impl.component.window;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bytedance.keva.Keva;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.common.ContextKt;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.j0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.m1;
import com.larus.bmhome.view.screenmenu.n1;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.CallImgConfig;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.service.audio.y0;
import com.larus.im.service.audio.z0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.IAudioAutoTestPlatform;
import com.larus.platform.service.z2;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.component.dialog.RealtimeDialogTriggerTime;
import com.larus.voicecall.impl.component.subtitle.k0;
import com.larus.voicecall.impl.continue_talk.RealtimeCallContinuousTalkComponent;
import com.larus.voicecall.impl.plugins.f2;
import com.larus.voicecall.impl.ui.VoiceCallBgLayout;
import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import com.larus.voicecall.impl.util.EarphoneChecker;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ¢\u00012\u00020\u00012\u00020\u0002:\u0002¢\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010l\u001a\u00020mH\u0016J\u0010\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020\u0007H\u0016J\b\u0010p\u001a\u00020mH\u0016J\b\u0010q\u001a\u00020mH\u0016J\u0010\u0010r\u001a\u00020m2\u0006\u0010s\u001a\u00020tH\u0016J\u0010\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020wH\u0002J\u000e\u0010x\u001a\b\u0012\u0004\u0012\u00020z0yH\u0002J\u000e\u0010{\u001a\b\u0012\u0004\u0012\u00020z0yH\u0002J\b\u0010|\u001a\u00020mH\u0002J\b\u0010}\u001a\u00020mH\u0002J\u0010\u0010~\u001a\u00020m2\u0006\u0010\u007f\u001a\u00020tH\u0002J\u0012\u0010\u0080\u0001\u001a\u00020m2\u0007\u0010\u0081\u0001\u001a\u00020tH\u0016J-\u0010\u0084\u0001\u001a\u00020m2\u0007\u0010\u0085\u0001\u001a\u00020t2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020z0y2\n\b\u0002\u0010\u0087\u0001\u001a\u00030\u0083\u0001H\u0002J\t\u0010\u0088\u0001\u001a\u00020mH\u0002J\u0013\u0010\u0089\u0001\u001a\u00020m2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\u001e\u0010\u008c\u0001\u001a\u00020m2\u0007\u0010\u008a\u0001\u001a\u00020X2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020m2\u0007\u0010\u0090\u0001\u001a\u00020TH\u0016J1\u0010\u0091\u0001\u001a\u00020m2\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0093\u00012\b\u0010\u0097\u0001\u001a\u00030\u0095\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020mH\u0016JK\u0010\u0099\u0001\u001a\u00020m2\u0007\u0010\u0081\u0001\u001a\u00020t2\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020z0y2\b\u0010\u009b\u0001\u001a\u00030\u009c\u00012\b\u0010\u009d\u0001\u001a\u00030\u009c\u00012\u0014\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020z\u0012\u0004\u0012\u00020m0\u009f\u0001H\u0016J\t\u0010 \u0001\u001a\u00020mH\u0016J\t\u0010¡\u0001\u001a\u00020mH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010*R\u001d\u0010,\u001a\u0004\u0018\u00010-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\r\u001a\u0004\b.\u0010/R\u001d\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b3\u00104R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\r\u001a\u0004\b=\u0010>R\u001d\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\r\u001a\u0004\bB\u0010CR\u001d\u0010E\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\r\u001a\u0004\bG\u0010HR\u0016\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\r\u001a\u0004\bP\u0010QR\u000e\u0010S\u001a\u00020TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010[\u001a\u0004\u0018\u00010\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\r\u001a\u0004\b]\u0010^R\u001d\u0010`\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\r\u001a\u0004\bb\u0010cR\u001d\u0010e\u001a\u0004\u0018\u00010f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\r\u001a\u0004\bg\u0010hR\u000e\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¡\u0001\u001a\u00030\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/window/RealtimeWindowComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "<init>", "()V", "backInterceptList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voicecall/impl/component/window/IRealtimeBackIntercept;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "callParam", "Lcom/larus/audio/call/RealtimeCallParam;", "getCallParam", "()Lcom/larus/audio/call/RealtimeCallParam;", "callParam$delegate", "imAbility", "Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "getImAbility", "()Lcom/larus/voicecall/impl/component/im/IRealtimeIMAbility;", "imAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "interviewAbility", "Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "getInterviewAbility", "()Lcom/larus/voicecall/impl/component/interview/IRealtimeInterviewAbility;", "interviewAbility$delegate", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "interpretAbility", "Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "getInterpretAbility", "()Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "interpretAbility$delegate", "dialogManager", "Lcom/larus/voicecall/impl/component/dialog/RealtimeDialogManager;", "getDialogManager", "()Lcom/larus/voicecall/impl/component/dialog/RealtimeDialogManager;", "realtimeDenoiseAbility", "Lcom/larus/voicecall/impl/component/denoise/IRealtimeDenoiseAbility;", "getRealtimeDenoiseAbility", "()Lcom/larus/voicecall/impl/component/denoise/IRealtimeDenoiseAbility;", "realtimeDenoiseAbility$delegate", "curSessionState", "Lcom/larus/im/internal/audio/context/SessionState;", "earChecker", "Lcom/larus/voicecall/impl/util/EarphoneChecker;", "keepScreenOnOwner", NameKeys.UnloadStrategy_No_Strategy, "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "pictureAbility", "Lcom/larus/voicecall/impl/component/picture/IRealtimePictureAbility;", "getPictureAbility", "()Lcom/larus/voicecall/impl/component/picture/IRealtimePictureAbility;", "pictureAbility$delegate", "albumAbility", "Lcom/larus/voicecall/impl/component/picture/IRealtimeAlbumAbility;", "getAlbumAbility", "()Lcom/larus/voicecall/impl/component/picture/IRealtimeAlbumAbility;", "albumAbility$delegate", "sceneChangeListener", "Lcom/larus/voicecall/impl/component/scene/RealtimeSceneChangeListener;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "addBackIntercept", "intercept", "onVContextReady", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "setDarkMode", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "getMenuList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "getBottomMoreMenuList", "setLeftTakePhotoBtn", "setMoreBtn", "onMoreBtnClicked", "moreBtn", "showBottomMoreMenu", "anchorView", "isSmall", NameKeys.UnloadStrategy_No_Strategy, "showMenu", "anchor", "menuList", "showAbove", "setBackPressListeners", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "otherEvent", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "onConnectionStateChanged", "state", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", NameKeys.UnloadStrategy_No_Strategy, "newMajorState", "newState", "performBack", "showPopMenuPanel", "menuItems", "clickX", NameKeys.UnloadStrategy_No_Strategy, "clickY", "itemClickHandler", "Lkotlin/Function1;", "onDestroy", "notifyExitRealtimeCall", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeWindowComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.window.b {
    public static final /* synthetic */ int M = 0;
    public final Lazy A;
    public final Lazy B;
    public jd9.c C;
    public EarphoneChecker D;
    public final String E;
    public FragmentExtKt.addOnBackPressed.callback.1 F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final b J;
    public boolean K;
    public volatile boolean L;
    public final List<com.larus.voicecall.impl.component.window.a> n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements l3a.c {
        public final /* synthetic */ RealtimeWindowComponent a;

        public b(RealtimeWindowComponent r1) {
            this.a = r1;
        }

        @Override // l3a.c
        public final void a(com.larus.voicecall.impl.scene.m r4) {
            FLogger.a.i("RealtimeWindowComponent", "[onSceneSelected] selected: " + r4);
            RealtimeWindowComponent r5 = this.a;
            int r0 = RealtimeWindowComponent.M;
            r5.H3();
            this.a.G3();
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.window.RealtimeWindowComponent$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.window.RealtimeWindowComponent$onCreate$1", f = "RealtimeWindowComponent.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RealtimeWindowComponent this$0;

        public AnonymousClass1(RealtimeWindowComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L29:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            Lazy r12 = NewThemeSwitchAvatar.a;
            RealtimeWindowComponent r13 = this.this$0;
            int r3 = RealtimeWindowComponent.M;
            BotModel r14 = r13.p3().H0;
            if (r14 == null) goto L13;
            CallImgConfig r15 = r14.getCallImgConfig();
            if (r15 == null) goto L13;
            String r16 = r15.getStaticAudioImgUrl();
        L14:
            String r4 = r16;
            this.label = 1;
            if (r4 != null) goto L17;
        L20:
            if (r2 == false) goto L22;
            Object r17 = Unit.INSTANCE;
        L26:
            if (r17 != r0) goto L29;
            return r0;
        L22:
            r17 = ImageLoaderKt.A(r4, "realtime_call_bot_avatar_new", null, null, new c4a.d(), this, 28);
            if (r17 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
            r17 = Unit.INSTANCE;
            goto L26
        L17:
            if (r4.length() == 0) goto L20;
            r2 = false;
        L13:
            r16 = null;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.window.RealtimeWindowComponent$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.window.RealtimeWindowComponent$onCreate$2", f = "RealtimeWindowComponent.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RealtimeWindowComponent this$0;

        public AnonymousClass2(RealtimeWindowComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RealtimeCallUtil r5 = RealtimeCallUtil.a;
            FragmentActivity r2 = RealtimeWindowComponent.m3(this.this$0);
            this.label = 1;
            r5.getClass();
            com.larus.audio.call.g r6 = com.larus.audio.call.f.a;
            Object r7 = ContextKt.a(r2, this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            r7 = Unit.INSTANCE;
        L13:
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
            r7 = Unit.INSTANCE;
        L16:
            if (r7 != r0) goto L19;
            return r0;
        }
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.o.getValue();
    }

    public final e3a.b B3() {
        return (e3a.b) this.q.getValue();
    }

    public final com.larus.voicecall.impl.component.scene.a C3() {
        return (com.larus.voicecall.impl.component.scene.a) this.z.getValue();
    }

    public final m3a.a D3() {
        return (m3a.a) this.u.getValue();
    }

    public final void E3() {
        if (this.L == true) goto L5;
        return;
    L5:
        this.L = false;
        CopyOnWriteArrayList r0 = com.larus.voicecall.impl.b0.a;
        String r1 = ((h88.a) p3()).d;
        String r2 = ((h88.a) p3()).f;
        Intrinsics.checkNotNullParameter(r1, "botId");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("notifyExitRealtimeCall,  botId=");
        r4.append(r1);
        r4.append(", conversationId=");
        r4.append(r2);
        r4.append(", listSize: ");
        CopyOnWriteArrayList r5 = com.larus.voicecall.impl.b0.a;
        r4.append(r5.size());
        r3.i("RealtimeCallStateManager", r4.toString());
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((z2a.b) r6.next()).onExitRealtimeCall(r1, r2);
        goto L7
    }

    public final void onCreate() {
        fa9.e.a.a("realtime_call", this.E);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new AnonymousClass1(this, null), 3, null);
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.v == false) goto L5;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new AnonymousClass2(this, null), 3, null);
        this.D = new EarphoneChecker(getActivity());
    L5:
        CopyOnWriteArrayList r0 = com.larus.voicecall.impl.b0.a;
        String r1 = ((h88.a) p3()).d;
        String r2 = ((h88.a) p3()).f;
        Intrinsics.checkNotNullParameter(r1, "botId");
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("notifyEnterRealtimeCall,  botId=");
        r4.append(r1);
        r4.append(", conversationId=");
        r4.append(r2);
        r4.append(", listSize: ");
        CopyOnWriteArrayList r5 = com.larus.voicecall.impl.b0.a;
        r4.append(r5.size());
        r3.i("RealtimeCallStateManager", r4.toString());
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((z2a.b) r6.next()).onEnterRealtimeCall(r1, r2);
        goto L7
    L9:
        com.larus.voicecall.impl.notification.d.a.getClass();
        com.larus.voicecall.impl.notification.d.b("call_onCreate");
        AppHost.Companion r7 = AppHost.a;
        if (r7.isTestChannel() == true) goto L12;
        return;
    L12:
        if (y0.e(((h88.b) B3()).e) == false) goto L15;
        int r8 = 2131900051;
    L21:
        String r9 = r7.getApplication().getString(r8);
        t19.s.j(t19.s.a, r7.getApplication(), r9, null, false, 28);
        return;
    L15:
        if (y0.d(((h88.b) B3()).e) == false) goto L18;
        r8 = 2131900053;
        goto L21
    L18:
        if (y0.b(((h88.b) B3()).e) == false) goto L20;
        r8 = 2131900052;
        goto L21
    L20:
        r8 = 2131900055;
        goto L21
    }

    public final void onDestroy() {
        EarphoneChecker r0 = this.D;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        E3();
        com.larus.voicecall.impl.notification.d.a.getClass();
        com.larus.voicecall.impl.notification.d.h("call_win_destroy");
        FragmentExtKt.addOnBackPressed.callback.1 r1 = this.F;
        if (r1 == null) goto L8;
        r1.remove();
    L8:
        fa9.e.a.f("realtime_call", this.E);
        com.larus.voicecall.impl.component.scene.a r2 = C3();
        if (r2 == null) goto L12;
        r2.Fk(this.J);
        return;
    }

    public final e3a.a p3() {
        return (e3a.a) this.p.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.window.b.class);
    }

    public final List<ot8.a> z3() {
        ArrayList r0 = new ArrayList();
        com.larus.voicecall.impl.component.picture.b r1 = (com.larus.voicecall.impl.component.picture.b) this.H.getValue();
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(this, "<this>");
        l0 r2 = r1.KP(3, com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getString(2131900506));
        if (r2 == null) goto L7;
        r0.add(r2);
    L7:
        com.larus.voicecall.impl.component.denoise.g r3 = (com.larus.voicecall.impl.component.denoise.g) this.B.getValue();
        if (r3 == null) goto L12;
        n1 r4 = r3.rC(new q(this));
        if (r4 == null) goto L12;
        r0.add(r4);
    L12:
        return r0;
    }

    @Override // com.larus.voicecall.impl.component.window.b
    public final void zg() {
        Iterator r0 = ((ArrayList) this.n).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.larus.voicecall.impl.component.window.a r1 = (com.larus.voicecall.impl.component.window.a) r0.next();
        if (r1.a() == false) goto L4;
        r1.b();
        return;
    L9:
        RealtimeCallService r2 = (RealtimeCallService) this.r.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter("exit_realtime_call", "reason");
        f2 r3 = (f2) LLMCallController.y(r2.u, Reflection.getOrCreateKotlinClass(f2.class));
        if (r3 == null) goto L12;
        r3.G0("exit_realtime_call");
    L12:
        E3();
        Intent r4 = new Intent();
        Pair[] r5 = new Pair[2];
        boolean r6 = false;
        r5[0] = TuplesKt.to("conversationId", ((h88.a) p3()).f);
        com.larus.voicecall.impl.component.im.a r7 = (com.larus.voicecall.impl.component.im.a) this.t.getValue();
        if (r7 != null) goto L15;
    L17:
        r5[1] = TuplesKt.to("is_need_scroll_last", Boolean.valueOf(r6));
        Intent r8 = r4.putExtras(BundleKt.bundleOf(r5));
        getActivity().setResult(100, r8);
        getActivity().finish();
        return;
    L15:
        if (r7.Pk() != true) goto L17;
        r6 = true;
        goto L17
    }

    public RealtimeWindowComponent() {
        this.n = new ArrayList();
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new a0(this));
        this.q = LazyKt.lazy(new b0(this));
        this.r = LazyKt.lazy(new d(this));
        this.s = LazyKt.lazy(new e(this));
        this.t = LazyKt.lazy(new f(this));
        this.u = LazyKt.lazy(new g(this));
        this.v = LazyKt.lazy(new h(this));
        this.w = LazyKt.lazy(new i(this));
        this.x = LazyKt.lazy(new j(this));
        this.y = LazyKt.lazy(new n(this));
        this.z = LazyKt.lazy(new u(this));
        this.A = LazyKt.lazy(new v(this));
        this.B = LazyKt.lazy(new w(this));
        this.C = jd9.c.f.c;
        this.E = "RealtimeWindowComponent-" + hashCode();
        this.G = LazyKt.lazy(new x(this));
        this.H = LazyKt.lazy(new y(this));
        this.I = LazyKt.lazy(new z(this));
        this.J = new b(this);
        this.L = true;
    }

    public final void A0() {
        getActivity();
        p3();
        B3();
        com.larus.voicecall.impl.component.im.a r0 = (com.larus.voicecall.impl.component.im.a) this.t.getValue();
    }

    public final void G3() {
        if (((h88.a) p3()).k0 == false) goto L48;
        com.larus.voicecall.impl.component.scene.a.C0016a r0 = com.larus.voicecall.impl.component.scene.a.C1;
        com.larus.voicecall.impl.component.scene.a r1 = C3();
        Integer r2 = null;
        if (r1 == null) goto L11;
        LiveData<com.larus.voicecall.impl.scene.m> r3 = r1.getCurrentScene();
        if (r3 == null) goto L11;
        com.larus.voicecall.impl.scene.m r4 = (com.larus.voicecall.impl.scene.m) r3.getValue();
        if (r4 == null) goto L11;
        SceneModel r5 = r4.a;
    L12:
        r0.getClass();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L48;
        boolean r7 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L22;
        r2 = -1;
    L22:
        Drawable r8 = AppCompatResources.getDrawable(getContext(), 2131241717);
        if (r2 == null) goto L27;
        int r9 = r2.intValue();
        if (r8 == null) goto L27;
        r8.setTint(r9);
    L27:
        m3a.a r10 = D3();
        if (r10 == null) goto L34;
        VoiceCallTopLayout r11 = r10.Fv();
        if (r11 == null) goto L34;
        ImageView r12 = r11.getLeftTakePhotoBtn();
        if (r12 == null) goto L34;
        r12.setImageDrawable(r8);
    L34:
        m3a.a r13 = D3();
        if (r13 == null) goto L41;
        VoiceCallTopLayout r14 = r13.Fv();
        if (r14 == null) goto L41;
        ImageView r15 = r14.getLeftTakePhotoBtn();
        if (r15 == null) goto L41;
        e1.x(r15);
    L41:
        m3a.a r16 = D3();
        if (r16 == null) goto L56;
        VoiceCallTopLayout r17 = r16.Fv();
        if (r17 == null) goto L57;
        ImageView r18 = r17.getLeftTakePhotoBtn();
        if (r18 == null) goto L58;
        e1.d(r18, new m(this));
        return;
    L58:
        return;
    L57:
        return;
    L56:
        return;
    L15:
        if (r5.getId() != 20) goto L17;
        r6 = true;
    L11:
        r5 = null;
    L48:
        m3a.a r19 = D3();
        if (r19 == null) goto L60;
        VoiceCallTopLayout r20 = r19.Fv();
        if (r20 == null) goto L61;
        ImageView r21 = r20.getLeftTakePhotoBtn();
        if (r21 == null) goto L62;
        e1.o(r21);
        return;
    L62:
        return;
    L61:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.larus.voicecall.impl.component.window.l, java.lang.Object] */
    public final void H3() {
        List<ot8.a> r0 = z3();
        RealtimeCallUtil.a.getClass();
        boolean r2 = false;
        if (RealtimeCallUtil.p().a() == false) goto L11;
        if (RealtimeCallUtil.A() == false) goto L11;
        if (RealtimeCallUtil.o() == false) goto L11;
        if (RealtimeCallUtil.w() == false) goto L11;
    L16:
        boolean r1 = true;
    L18:
        FLogger.a.i("RealtimeCallUtil", "isMenuEnableInner=" + RealtimeCallUtil.p().a() + " downgradeToSami=false isRtcEnable=" + RealtimeCallUtil.A() + " newThemeEnable=" + RealtimeCallUtil.o() + " isOverAndroid6=" + RealtimeCallUtil.w() + " isOpenVlm=" + RealtimeCallUtil.R + ' ');
        if (r1 == true) goto L21;
    L25:
        m3a.a r3 = D3();
        if (r3 == null) goto L30;
        VoiceCallTopLayout r4 = r3.Fv();
        if (r4 == null) goto L30;
        VoiceCallTopLayout.Y5(r4, ((h88.b) B3()).r);
    L30:
        m3a.a r5 = D3();
        if (r5 == null) goto L36;
        VoiceCallTopLayout r6 = r5.Fv();
        if (r6 == null) goto L37;
        ?? r7 = new l(this);
        Intrinsics.checkNotNullParameter(r7, "onClick");
        r6.setMoreBtnVisibility(r2);
        e1.d(r6.a.g, new com.larus.av_call.view.e1(r7));
        return;
    L37:
        return;
    L36:
        return;
    L21:
        if ((!((ArrayList) r0).isEmpty()) == false) goto L25;
        if (((h88.a) p3()).k0 == true) goto L25;
        r2 = true;
    L11:
        if (RealtimeCallUtil.R == true) goto L13;
    L17:
        r1 = false;
        goto L18
    L13:
        if (RealtimeCallUtil.p().a() == false) goto L17;
        if (RealtimeCallUtil.w() == false) goto L17;
        goto L16
    }

    public static void h3(RealtimeWindowComponent r5) {
        int r0 = ((h88.b) r5.B3()).k;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r0 != 6) goto L7;
        return;
    L7:
        if (r0 != (-1)) goto L10;
        Pair<Boolean, Boolean> r1 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.b(r5.getActivity()) == false) goto L10;
        return;
    L10:
        CommonDialog.a r2 = new CommonDialog.a();
        r2.G = true;
        r2.g(r5.getActivity().getString(2131898464));
        CommonDialog.a.f(r2, new c0(r5), r5.getActivity().getString(2131898457), false, 12);
        CommonDialog.a.e(r2, new d0(), r5.getActivity().getString(2131898456), 4);
        CommonDialog r3 = r2.a();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        FragmentManager r6 = com.larus.ui.arch.component.internal.attach.a.b(r5, r5).getChildFragmentManager();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, null, r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r3, r4) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        r3.show(r6, null);
        return;
    }

    public static final /* synthetic */ FragmentActivity m3(RealtimeWindowComponent r0) {
        return r0.getActivity();
    }

    public final void D9(z0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof pf9.o) == false) goto L8;
        h3a.c r3 = (h3a.c) s1a.d.a(this).a(h3a.c.class);
        if (r3 == null) goto L13;
        r3.a(RealtimeDialogTriggerTime.ON_CALL_STARTED);
        return;
    L13:
        return;
    L8:
        if ((r2 instanceof pf9.l) == false) goto L15;
        h3a.c r4 = (h3a.c) s1a.d.a(this).a(h3a.c.class);
        if (r4 == null) goto L16;
        r4.a(RealtimeDialogTriggerTime.ON_COMMON_AUDIO_CONFIG);
        return;
    L16:
        return;
    }

    public final void I6(final jd9.c r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        this.C = r4;
        AppHost.Companion r0 = AppHost.a;
        if (r0.isTestChannel() == false) goto L5;
    L7:
        final ouc.d0 r1 = r4.b;
        if (r1 != null) goto L10;
        return;
    L10:
        getActivity().runOnUiThread(new r(r4, this, r1));
        return;
    L5:
        if (Intrinsics.areEqual(r0.getBuildChannel(), "auto_test") == true) goto L7;
    }

    @Override // com.larus.voicecall.impl.component.window.b
    public final void gS(RealtimeCallContinuousTalkComponent.c r2) {
        Intrinsics.checkNotNullParameter(r2, "intercept");
        ((ArrayList) this.n).add(r2);
    }

    @Override // com.larus.voicecall.impl.component.window.b
    public final void oB(View r7) {
        Intrinsics.checkNotNullParameter(r7, "anchorView");
        if (z2.a.realtimeCallUseTwoLineStyle() == true) goto L6;
        FLogger.a.i("RealtimeWindowComponent", "can not click bottom more btn. because realtimeCallUseTwoLineStyle is disabled");
        return;
    L6:
        ArrayList r0 = new ArrayList();
        com.larus.voicecall.impl.component.picture.a r2 = (com.larus.voicecall.impl.component.picture.a) this.I.getValue();
        if (r2 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        l0 r3 = r2.ij(com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getString(2131900513));
        if (r3 == null) goto L11;
        r0.add(r3);
    L11:
        com.larus.voicecall.impl.component.picture.b r4 = (com.larus.voicecall.impl.component.picture.b) this.H.getValue();
        if (r4 == null) goto L17;
        Intrinsics.checkNotNullParameter(this, "<this>");
        l0 r5 = r4.KP(3, com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getString(2131900512));
        if (r5 == null) goto L17;
        r0.add(r5);
    L17:
        if (((h88.b) B3()).t == true) goto L29;
        com.larus.voicecall.impl.component.vlm.a r6 = (com.larus.voicecall.impl.component.vlm.a) s1a.d.a(this).getAbility(com.larus.voicecall.impl.component.vlm.a.class);
        if (r6 == null) goto L29;
        if (r6.H80() == false) goto L24;
        r6 = null;
    L24:
        if (r6 == null) goto L29;
        l0 r8 = r6.EY(2);
        if (r8 == null) goto L29;
        r0.add(r8);
    L29:
        if (r0.isEmpty() == false) goto L33;
        FLogger.a.i("RealtimeWindowComponent", "can not click bottom more btn. because menu list is empty");
        return;
    L33:
        if ((this.C instanceof jd9.c.a) == true) goto L35;
    L37:
        FLogger.a.i("RealtimeWindowComponent", "can not click bottom more btn. because current session state is [" + this.C + "] paused=" + ((h88.b) B3()).n);
        return;
    L35:
        if (((h88.b) B3()).n == true) goto L37;
        Q3(r7, r0, true);
    }

    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        ThemeType r5 = ((h88.b) B3()).i;
        BotModel r6 = p3().H0;
        if (r6 == null) goto L9;
        g3a.a r0 = (g3a.a) this.v.getValue();
        if (r0 == null) goto L9;
        VoiceCallBgLayout r1 = r0.Nl();
        if (r1 == null) goto L9;
        r1.R5(((h88.b) B3()).i, r6, false);
    L9:
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.F = com.larus.utils.v.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), new o(this));
        H3();
        com.larus.voicecall.impl.component.scene.a r7 = C3();
        if (r7 == null) goto L12;
        r7.yM(this.J);
    L12:
        G3();
    }

    public final void z2(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (Intrinsics.areEqual(r4, "OTHER_EVENT_RTC_ROOM_ID_GET") == true) goto L5;
        return;
    L5:
        if ((r5 instanceof String) == false) goto L7;
        final String r6 = (String) r5;
    L8:
        if (r6 != null) goto L10;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        AppHost.Companion r7 = AppHost.a;
        if (Intrinsics.areEqual(r7.getBuildChannel(), "auto_test") == false) goto L16;
        IAudioAutoTestPlatform r0 = (IAudioAutoTestPlatform) ServiceManager.get().getService(IAudioAutoTestPlatform.class);
        if (r0 == null) goto L16;
        r0.b();
    L16:
        if (r7.isTestChannel() == false) goto L18;
    L19:
        getActivity().runOnUiThread(new t(this, r6));
        return;
    L18:
        if (Intrinsics.areEqual(r7.getBuildChannel(), "auto_test") == true) goto L19;
        return;
    L7:
        r6 = null;
        goto L8
    }

    public final void Q3(final View r12, List<? extends ot8.a> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r0 == null) goto L13;
        CommonMenu r1 = new CommonMenu(r0);
        r1.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r1.h(Reflection.getOrCreateKotlinClass(n1.class), new m1());
        r1.g(r13, new p(r12, this));
        if (z2.a.getRealtimeCallNewStyleConfig().b() == false) goto L7;
        int r15 = j19.c.c(16);
    L9:
        if (r14 == false) goto L11;
        r1.d(j19.c.c(200));
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r12, CommonMenu.j(r1, Integer.valueOf(r15), Integer.valueOf(j19.c.c(12)), Integer.valueOf(j19.c.c(0)), 2), false, null, null, null, null, 124).v(r12, 0, j19.c.c(-4));
        return;
    L11:
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r12, CommonMenu.j(r1, Integer.valueOf(r15), null, null, 14), false, null, null, null, null, 124).s(r12, 0, j19.c.c(-32));
        return;
    L7:
        r15 = j19.c.c(25);
        goto L9
    }

    public final void o1(MajorState r1, int r2, MajorState r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "currentMajorState");
        Intrinsics.checkNotNullParameter(r3, "newMajorState");
        if (r4 != 1) goto L6;
        Keva r5 = vc8.e.a;
        vc8.e.a(((h88.a) p3()).d);
        return;
    }

    @Override // com.larus.voicecall.impl.component.window.b
    public final void bw(final CustomMarkdownTextView r10, List r11, float r12, float r13, final k0 r14) {
        Intrinsics.checkNotNullParameter(r10, "anchorView");
        Intrinsics.checkNotNullParameter(r11, "menuItems");
        Intrinsics.checkNotNullParameter(r14, "itemClickHandler");
        CommonMenu r2 = new CommonMenu(getContext());
        r2.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r2.h(Reflection.getOrCreateKotlinClass(com.larus.bmhome.view.screenmenu.y.class), new com.larus.bmhome.view.screenmenu.c0());
        r2.g(r11, new k(r10, r14));
        com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r10, r2.i(), false, null, null, null, null, 124).v(r10, ((int) r12) - (r10.getWidth() / 2), (int) r13);
    }
}
