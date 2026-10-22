package com.obric.assistant.component;

import android.app.Application;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.assistant.ability.ObricSpecialInputScene;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import com.obric.assistant.actionbar.statemanager.state.ObricTaskMode;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.settings.LocalDataSearchConfirmFragment;
import com.obric.assistant.settings.LocalDataSearchConfirmViewModel;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.ReferenceScreenContentConfirmFragment;
import com.obric.assistant.special_input.ObricComplexTaskPanelType;
import com.obric.assistant.spi.keyguard.IKeyguardService$a;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.UiType;
import com.obric.eventkit.eventstaskmanager.ConditionGroup;
import com.obric.eventkit.eventstaskmanager.ConditionTask;
import com.obric.eventkit.eventstaskmanager.PeriodicPolicy;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 \u0088\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0088\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u00020QH\u0016J\u0017\u0010R\u001a\u00020M2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0002\u0010UJ\u001a\u0010V\u001a\u00020M2\b\u0010W\u001a\u0004\u0018\u00010O2\u0006\u0010X\u001a\u00020YH\u0016J$\u0010Z\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010W\u001a\u0004\u0018\u00010O2\u0006\u0010X\u001a\u00020YH\u0002J$\u0010]\u001a\u00020Q2\b\u0010W\u001a\u0004\u0018\u00010O2\u0006\u0010^\u001a\u00020Y2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020MH\u0016J\b\u0010b\u001a\u00020MH\u0016J\b\u0010c\u001a\u00020QH\u0016J\b\u0010d\u001a\u00020MH\u0016J\u0010\u0010e\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010f\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010g\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010h\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0016J\u0018\u0010i\u001a\u00020M2\u0006\u0010X\u001a\u00020Y2\u0006\u0010j\u001a\u00020kH\u0016J\u0016\u0010l\u001a\u00020M2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020M0nH\u0002J\u0010\u0010o\u001a\u00020p2\u0006\u0010j\u001a\u00020kH\u0002J\b\u0010q\u001a\u00020MH\u0002J\b\u0010r\u001a\u00020MH\u0002J(\u0010s\u001a\u00020M2\u0006\u0010t\u001a\u00020p2\u0006\u0010j\u001a\u00020k2\u0006\u0010X\u001a\u00020Y2\u0006\u0010u\u001a\u00020pH\u0002J\u0010\u0010v\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010w\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0002J2\u0010x\u001a\u00020M2\u0006\u0010t\u001a\u00020p2\b\u0010y\u001a\u0004\u0018\u00010p2\u0006\u0010j\u001a\u00020k2\u0006\u0010X\u001a\u00020Y2\u0006\u0010u\u001a\u00020pH\u0002J2\u0010z\u001a\u00020M2\u0006\u0010t\u001a\u00020p2\b\u0010y\u001a\u0004\u0018\u00010p2\u0006\u0010j\u001a\u00020k2\u0006\u0010X\u001a\u00020Y2\u0006\u0010u\u001a\u00020pH\u0002J\u0010\u0010{\u001a\u00020p2\u0006\u0010j\u001a\u00020kH\u0002J\u0012\u0010|\u001a\u00020M2\b\u0010y\u001a\u0004\u0018\u00010pH\u0002J\u001a\u0010}\u001a\u00020M2\b\u0010y\u001a\u0004\u0018\u00010p2\u0006\u0010~\u001a\u00020pH\u0002J\u0019\u0010\u007f\u001a\u00020M2\u0007\u0010\u0080\u0001\u001a\u00020k2\u0006\u0010X\u001a\u00020YH\u0016J \u0010\u0081\u0001\u001a\u00020M2\u0006\u0010X\u001a\u00020Y2\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020M0nH\u0002J\t\u0010\u0083\u0001\u001a\u00020MH\u0016J\t\u0010\u0084\u0001\u001a\u00020QH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020M2\u0006\u0010X\u001a\u00020YH\u0016J\t\u0010\u0086\u0001\u001a\u00020MH\u0016J\t\u0010\u0087\u0001\u001a\u00020QH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/obric/assistant/component/ObricPhotoActionComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "Lcom/obric/assistant/view/actionbar/secondarymenu/ISecondaryMenuItemClickCallback;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "continuousTalkUIAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "getContinuousTalkUIAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "continuousTalkUIAbility$delegate", "pageStateComponent", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateComponent", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateComponent$delegate", "obricVariantInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getObricVariantInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "obricVariantInputAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "obricChatInputLogicAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputLogicAbility;", "getObricChatInputLogicAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricChatInputLogicAbility;", "obricChatInputLogicAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "filePerceiveSceneFileSize", "Ljava/util/concurrent/atomic/AtomicLong;", "secondaryMenu", "Lcom/obric/assistant/view/actionbar/secondarymenu/SecondaryMenuPopupWindow;", "onViewCreated", "", "view", "Landroid/view/View;", "isFileOverSize", "", "setFilePerceiveSceneFileSize", "fileSize", "", "(Ljava/lang/Long;)V", "onPhoneOperationBarClick", "anchorView", "customActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "openSpecialInputPanel", "taskStatus", "Lcom/obric/assistant/actionbar/statemanager/interfaces/ObricTaskStatus;", "openSecondaryMenu", "item", "secondaryMenuButton", "Landroidx/appcompat/widget/AppCompatImageView;", "onResume", "closeSecondaryMenu", "isSecondaryMenuOpen", "openVirtualScreen", "goToAIBeautify", "goToPictureDynamic", "goToPictureQA", "goToIMScreenQA", "sendQuery", "secondMenuButtonId", "", "ensureReferenceScreenContentEnabled", "onEnabled", "Lkotlin/Function0;", "getFromObricActionBarType", "", "goToAIBeautifyPageWithScreenShot", "goToPictureDynamicPageWithScreenShot", "sendFinalQueryWithScreenShot", "content", "fromActionBarType", "goToAIBeautifyPageWithPhotoPerceive", "goToPictureDynamicPageWithPhotoPerceive", "sendFinalQueryWithPhotoPerceive", "uri", "sendFinalQuery", "getFinalQueryContent", "goToPictureDynamicPageFinal", "goToAIBeautifyPageFinal", "from", "onMenuItemClick", "itemId", "handleScreenShotMenuAction", "action", "goToOautoTasksList", "isChatWindow", "goToOautoNewTask", "openOautoNewRepeatTask", "isChatWindowOrIntercom", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPhotoActionComponent extends BaseContentWidget implements laa.h, rha.a {
    public static final /* synthetic */ int B = 0;
    public rha.n A;
    public final Lazy m;
    public final Lazy n;
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
    public final AtomicLong z;

    public static final class a {
    }

    public static final class b implements zs8.a {
        public final /* synthetic */ String a;

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return null;
        }

        public final String p() {
            return null;
        }

        public final String getEnterMethod() {
            return this.a;
        }

        public b(String r1) {
            this.a = r1;
        }
    }

    public static final class c implements oga.a {
        public final /* synthetic */ ObricPhotoActionComponent a;

        @Override // oga.a
        public final void onDismissFailed() {
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            IOAutoApi r1 = com.obric.assistant.oauto.b.a();     // Catch: Throwable -> L15
            if (r1 == null) goto L9;
            Application r2 = s1a.a.c(this.a).getActivity();     // Catch: Throwable -> L15
            if (r2 != null) goto L8;
            r2 = AppHost.a.getApplication();     // Catch: Throwable -> L15
        L8:
            r1.h(r2, false);     // Catch: Throwable -> L15
        L9:
            ObricPhotoActionComponent r3 = this.a;     // Catch: Throwable -> L15
            int r4 = ObricPhotoActionComponent.B;     // Catch: Throwable -> L15
            if (r3.aF() == false) goto L19;
            FragmentActivity r5 = s1a.a.c(this.a).getActivity();     // Catch: Throwable -> L15
            if (r5 == null) goto L20;
            r5.finish();     // Catch: Throwable -> L15
            return;
        L20:
            return;
        L19:
            return;
        L15:
            t19.s.a.g(AppHost.a.getApplication(), 2131911903, false);
        }

        public c(ObricPhotoActionComponent r1) {
            this.a = r1;
        }
    }

    public static final class d implements zs8.a {
        public d() {
        }

        public final String Y1() {
            return null;
        }

        public final String a() {
            return null;
        }

        public final String b() {
            return "chat";
        }

        public final String c() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final String e() {
            return null;
        }

        public final String f() {
            return null;
        }

        public final String g() {
            return null;
        }

        public final String getBotId() {
            return null;
        }

        public final String getChatType() {
            return null;
        }

        public final String getClickFrom() {
            return "";
        }

        public final String getTemplateType() {
            return null;
        }

        public final String h() {
            return null;
        }

        public final String i() {
            return null;
        }

        public final String j() {
            return null;
        }

        public final String k() {
            return null;
        }

        public final boolean l() {
            return false;
        }

        public final String m() {
            return null;
        }

        public final String n() {
            return null;
        }

        public final String o() {
            return "album";
        }

        public final String p() {
            return null;
        }

        public final String getEnterMethod() {
            return ObricActionBarTrackType.OBRIC_PICTURE_DYNAMIC.getStringValue();
        }
    }

    public static final class e implements oga.a {
        public final /* synthetic */ ObricPhotoActionComponent a;

        @Override // oga.a
        public final void onDismissFailed() {
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            ObricPhotoActionComponent r0 = this.a;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
            IOAutoApi r4 = com.obric.assistant.oauto.b.a();     // Catch: Throwable -> L19
            if (r4 == null) goto L12;
            Application r5 = s1a.a.c(r0).getActivity();     // Catch: Throwable -> L19
            if (r5 != null) goto L8;
            r5 = AppHost.a.getApplication();     // Catch: Throwable -> L19
        L8:
            Intent r6 = new Intent();     // Catch: Throwable -> L19
            ObricTaskStatusManager.a.getClass();     // Catch: Throwable -> L19
            if (ObricTaskMode.PRO.isComplexTask() == false) goto L11;
            ConditionTask r15 = new ConditionTask(null, null, null, null, null, null, CollectionsKt.emptyList(), new ConditionGroup("and", new ArrayList()), new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null), null, 0, 1568, null);     // Catch: Throwable -> L19
            r15.setTaskMode(1);     // Catch: Throwable -> L19
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r6.putExtra("key_event_task", r15);     // Catch: Throwable -> L19
        L11:
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r4.e(r5, r6);     // Catch: Throwable -> L19
        L12:
            int r9 = ObricPhotoActionComponent.B;     // Catch: Throwable -> L19
            if (r0.aF() == false) goto L17;
            FLogger.a.i("ObricPhotoActionComponent", "dismiss chat window after open oauto new repeat task");     // Catch: Throwable -> L19
            Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Throwable -> L19
            FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(r0, r0).getActivity();     // Catch: Throwable -> L19
            if (r1 == null) goto L17;
            r1.finish();     // Catch: Throwable -> L19
        L17:
            Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Throwable r10 = Result.exceptionOrNull-impl(r2);
            if (r10 == null) goto L25;
            FLogger.a.e("ObricPhotoActionComponent", "openOautoNewRepeatTask failed", r10);
        L25:
            if (Result.isSuccess-impl(r2) == false) goto L30;
            Unit r11 = (Unit) r2;
            FLogger.a.i("ObricPhotoActionComponent", "openOautoNewRepeatTask success");
            return;
        L30:
            return;
        L19:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r2 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        }

        public e(ObricPhotoActionComponent r1) {
            this.a = r1;
        }
    }

    public static final class f implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public f(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class g implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class h implements Function0<ada.b> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ada.b.class));
        }
    }

    public static final class i implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class j implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
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

    public static final class l implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class m implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class n implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class o implements Function0<com.obric.audio.continuous_talk.c> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    public static final class p implements Function0<com.obric.audio.continuous_talk.b> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.b.class));
        }
    }

    public static final class q implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class r implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    static {
    }

    public final void onResume() {
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final boolean Vf() {
        if ((this.z.get() / ((long) UiType.FLAG_APP_CHOOSER_CARD)) <= 100) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean W10() {
        rha.n r0 = this.A;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void X30() {
        rha.n r0 = this.A;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final ICoreInputAbility h3() {
        return (ICoreInputAbility) this.m.getValue();
    }

    public final void hx() {
        IKeyguardService$a.a(KeyguardService.a, new c(this), false, false, false, false, null, 62);
    }

    public final laa.d m3() {
        return (laa.d) this.t.getValue();
    }

    public final void zG() {
        IKeyguardService$a.a(KeyguardService.a, new e(this), false, false, false, false, null, 62);
    }

    public ObricPhotoActionComponent() {
        this.m = LazyKt.lazy(new j(this));
        this.n = LazyKt.lazy(new k(this));
        this.o = LazyKt.lazy(new l(this));
        this.p = LazyKt.lazy(new m(this));
        this.q = LazyKt.lazy(new n(this));
        this.r = LazyKt.lazy(new o(this));
        this.s = LazyKt.lazy(new p(this));
        this.t = LazyKt.lazy(new q(this));
        this.u = LazyKt.lazy(new r(this));
        this.v = LazyKt.lazy(new g(this));
        this.w = LazyKt.lazy(new h(this));
        this.x = LazyKt.lazy(new i(this));
        this.y = LazyKt.lazy(new f3(this));
        this.z = new AtomicLong(0);
    }

    public final boolean B3() {
        if (aF() == true) goto L16;
        laa.d r0 = m3();
        if (r0 == null) goto L11;
        ObricFloatChatPageState r1 = r0.getPageState();
        if (r1 == null) goto L11;
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof com.obric.assistant.data.a) != true) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        r2 = false;
        goto L12
    L16:
        return true;
    }

    public final boolean aF() {
        laa.d r0 = m3();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.aF() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void Y2(final Function0<Unit> r3) {
        if (com.obric.assistant.t1.a.I1() == false) goto L6;
        r3.invoke();
        return;
    L6:
        int r0 = ReferenceScreenContentConfirmFragment.f;
        MutableLiveData r1 = ReferenceScreenContentConfirmFragment.a.a(s1a.a.getActivity(this));
        if (r1 == null) goto L10;
        r1.observe(this, new f(new r3(this, r3)));
        return;
    }

    public final void hK(Long r4) {
        AtomicLong r0 = this.z;
        if (r4 == null) goto L5;
        long r1 = r4.longValue();
    L6:
        r0.set(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void z3(String r58) {
        if (r58 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("ObricPhotoActionComponent", "goToPictureDynamicPage: uri is null");
        return;
    L12:
        com.larus.bmhome.instruction.g r2 = (com.larus.bmhome.instruction.g) this.n.getValue();
        String r3 = null;
        if (r2 == null) goto L17;
        Pair r4 = r2.A7();
        if (r4 == null) goto L17;
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) r4.getFirst();
    L18:
        IUgcAIGCService r6 = (IUgcAIGCService) ServiceManager.get().getService(IUgcAIGCService.class);
        if (r6 == null) goto L29;
        FragmentActivity r54 = s1a.a.getActivity(this);
        if (r5 == null) goto L30;
        com.larus.bmhome.actionbar.model.z0 r7 = com.larus.bmhome.actionbar.model.z0.a(r5, null, null, null, null, AppHost.a.getApplication().getString(2131912063), null, null, null, null, null, null, null, false, -17);
        com.larus.bmhome.chat.component.cvs.y r8 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r8 == null) goto L27;
        BotModel r9 = r8.j0();
        if (r9 == null) goto L27;
        r3 = r9.getBotId();
    L27:
        r6.W(new ny9.b(false, r54, r7, new ChatParam(null, r3, null, null, null, 253), false, false, null, null, null, null, null, null, null, null, null, null, null, r58, null, false, false, new d(), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -19005455, 262143));
        return;
    L30:
        return;
    L29:
        return;
    L17:
        r5 = null;
        goto L18
    L5:
        if (StringsKt.isBlank(r58) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void zw(com.larus.bmhome.actionbar.model.z0 r6) {
        Intrinsics.checkNotNullParameter(r6, "customActionBarItem");
        FLogger r0 = FLogger.a;
        r0.i("ObricPhotoActionComponent", "goToAIBeautify");
        String r1 = r6.b;
        if (Intrinsics.areEqual(r1, "obric_photo_perception") == false) goto L8;
        Uri r7 = com.larus.utils.y0.j(qha.f.a(r6));
        if (r7 == null) goto L11;
        r0.i("ObricPhotoActionComponent", "goToAIBeautifyPageWithPhotoPerceive with uri = " + r7);
        p3(r7.toString(), "obric_photo_perception");
        return;
    L11:
        return;
    L8:
        if (Intrinsics.areEqual(r1, "obric_screen_qa") == false) goto L13;
        r0.i("ObricPhotoActionComponent", "goToAIBeautify: screen shot");
        Y2(new p3(this));
        return;
    }

    public final void C3(View r9, com.larus.bmhome.actionbar.model.z0 r10) {
        FLogger.a.i("ObricPhotoActionComponent", "openSpecialInputPanel: taskStatus = null, anchorView = " + r9 + ", customActionBarItem = " + r10);
        laa.j r0 = (laa.j) this.u.getValue();
        if (r0 == null) goto L6;
        laa.j.a.a(r0, false, null, null, qha.o.a(getContext(), r10), false, true, 54);
        return;
    }

    public final void Hh(final View r6, final com.larus.bmhome.actionbar.model.z0 r7) {
        Intrinsics.checkNotNullParameter(r7, "customActionBarItem");
        FLogger.a.i("ObricPhotoActionComponent", "onPhoneOperationBarClick: customActionBarItem = " + r7);
        if (ObricPersonalContextSettingApiDelegate.b.q() == true) goto L17;
        int r0 = LocalDataSearchConfirmFragment.f;
        FragmentActivity r1 = s1a.a.getActivity(this);
        Intrinsics.checkNotNullParameter(r1, "activity");
        LocalDataSearchConfirmFragment r2 = new LocalDataSearchConfirmFragment();     // Catch: Exception -> L12
        LocalDataSearchConfirmViewModel r3 = (LocalDataSearchConfirmViewModel) new ViewModelProvider(r1).get(LocalDataSearchConfirmViewModel.class);     // Catch: Exception -> L12
        r3.setResult(new MutableLiveData());     // Catch: Exception -> L12
        FragmentManager r4 = r1.getSupportFragmentManager();     // Catch: Exception -> L12
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L12
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LocalDataSearchConfirmFragment", r5);     // Catch: Exception -> L12
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r2, r5) == false) goto L20;
    L10:
        MutableLiveData<Boolean> r8 = r3.getResult();     // Catch: Exception -> L12
    L14:
        if (r8 == null) goto L24;
        r8.observe(this, new f(new o3(this, r6, r7)));
        return;
    L24:
        return;
    L20:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L9:
        r2.show(r4, "LocalDataSearchConfirmFragment");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        FLogger.a.e("LocalDataSearchConfirmFragment", "find LocalDataSearchConfirmFragment exception: " + e);
        r8 = null;
        goto L14
    L17:
        C3(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.assistant.component.w3, kotlin.jvm.functions.Function0] */
    @Override // rha.a
    public final void M0(final int r22, final com.larus.bmhome.actionbar.model.z0 r23) {
        Intrinsics.checkNotNullParameter(r23, "customActionBarItem");
        FLogger r3 = FLogger.a;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: itemId = " + r22);
        if (r22 != 2131381150) goto L6;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToAIBeautify");
        zw(r23);
        return;
    L6:
        if (r22 != 2131381149) goto L8;
    L93:
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: sendQuery");
        ?? r2 = new w3(this, r23, r22);
        if (Intrinsics.areEqual(r23.b, "obric_screen_qa") == false) goto L96;
        Y2(r2);
        return;
    L96:
        r2.invoke();
        return;
    L8:
        if (r22 == 2131381279) goto L93;
        if (r22 == 2131381191) goto L93;
        if (r22 == 2131381264) goto L93;
        if (r22 != 2131381235) goto L24;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToPictureDynamic");
        Intrinsics.checkNotNullParameter(r23, "customActionBarItem");
        r3.i("ObricPhotoActionComponent", "goToPictureDynamic");
        String r1 = r23.b;
        if (Intrinsics.areEqual(r1, "obric_photo_perception") == false) goto L22;
        Uri r4 = com.larus.utils.y0.j(qha.f.a(r23));
        if (r4 == null) goto L99;
        r3.i("ObricPhotoActionComponent", "goToPictureDynamicPageWithPhotoPerceive with uri = " + r4);
        z3(r4.toString());
        return;
    L99:
        return;
    L22:
        if (Intrinsics.areEqual(r1, "obric_screen_qa") == false) goto L101;
        r3.i("ObricPhotoActionComponent", "goToPictureDynamic: screen shot");
        Y2(new h3(this));
        return;
    L101:
        return;
    L24:
        boolean r5 = false;
        Long r13 = null;
        if (r22 != 2131381236) goto L35;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToPictureQA");
        Intrinsics.checkNotNullParameter(r23, "customActionBarItem");
        ICoreInputAbility r6 = h3();
        if (r6 == null) goto L29;
        r6.C1(false, false, "picture_qa");
    L29:
        Uri r7 = com.larus.utils.y0.j(qha.f.a(r23));
        if (r7 == null) goto L103;
        com.larus.bmhome.chat.component.bottom.multimodal.g r8 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.p.getValue();
        if (r8 == null) goto L104;
        r8.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r7, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_picture_qa"), TuplesKt.to("is_from_obric_action_bar", "obric_picture_qa")}), null, 20));
        return;
    L104:
        return;
    L103:
        return;
    L35:
        if (r22 != 2131381199) goto L45;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToIMScreenQA");
        Intrinsics.checkNotNullParameter(r23, "customActionBarItem");
        ICoreInputAbility r9 = h3();
        if (r9 == null) goto L39;
        r9.C1(false, false, "picture_qa");
    L39:
        Uri r10 = com.larus.utils.y0.j(qha.f.a(r23));
        if (r10 == null) goto L106;
        com.larus.bmhome.chat.component.bottom.multimodal.g r11 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.p.getValue();
        if (r11 == null) goto L107;
        r11.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r10, null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_im_screen_qa"), TuplesKt.to("is_from_obric_action_bar", "obric_im_screen_qa")}), null, 20));
        return;
    L107:
        return;
    L106:
        return;
    L45:
        if (r22 != 2131381230) goto L48;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToOautoTasksList");
        hx();
        return;
    L48:
        if (r22 != 2131381229) goto L53;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToOautoNewTask");
        Intrinsics.checkNotNullParameter(r23, "customActionBarItem");
        r3.i("ObricPhotoActionComponent", "goToOautoNewTask: customActionBarItem = " + r23);
        laa.j r12 = (laa.j) this.u.getValue();
        if (r12 == null) goto L110;
        laa.j.a.a(r12, B3(), null, ObricSpecialInputScene.OAUTO_GUI, r23, false, false, 114);
        return;
    L110:
        return;
    L53:
        if (r22 != 2131381177) goto L64;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToComplexTaskOver");
        ada.b r14 = (ada.b) this.w.getValue();
        if (r14 == null) goto L59;
        String r15 = r14.St();
        if (r15 == null) goto L59;
        r13 = Long.valueOf(CastLongProtector.parseLong(r15));
    L59:
        if (r13 == null) goto L112;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: notifyStopComplexTaskByHttp");
        ObricTaskStatusManager.a.getClass();
        ObricTaskStatusManager.e.set(SystemClock.elapsedRealtime());
        IObricNetworkService r16 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r16 == null) goto L113;
        r16.q(r13.longValue(), "complex_task_over_button");
        return;
    L113:
        return;
    L112:
        return;
    L64:
        if (r22 != 2131381176) goto L69;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToComplexTaskAddition");
        laa.j r17 = (laa.j) this.u.getValue();
        if (r17 == null) goto L115;
        laa.j.a.a(r17, B3(), com.obric.assistant.special_input.util.j.d(ObricComplexTaskPanelType.ADDITION.getValue(), false, MapsKt.mapOf(TuplesKt.to("source_from", "virtual_screen")), null, null, 26), ObricSpecialInputScene.COMPLEX_TASK, r23, false, false, ErrorCode.DEVICE_LOCK_ERROR);
        return;
    L115:
        return;
    L69:
        if (r22 != 2131381178) goto L71;
        return;
    L71:
        if (r22 != 2131381180) goto L73;
    L74:
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: goToComplexTaskSearch");
        laa.d r18 = m3();
        if (r18 != null) goto L77;
    L79:
        if (r5 == false) goto L83;
        r3.i("ObricPhotoActionComponent", "onMenuItemClick: change to half");
        laa.d r19 = m3();
        if (r19 == null) goto L83;
        laa.d.a.d(r19, false, com.obric.assistant.util.m2.b, null, false, false, null, 61);
    L83:
        ada.b r20 = (ada.b) this.w.getValue();
        if (r20 == null) goto L119;
        String r21 = r20.St();
        if (r21 == null) goto L120;
        laa.j r24 = (laa.j) this.u.getValue();
        if (r24 == null) goto L90;
        r24.ph();
    L90:
        u7 r25 = (u7) this.v.getValue();
        if (r25 == null) goto L121;
        r25.kx(r21, true);
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L77:
        if (r18.aF() != true) goto L79;
        r5 = true;
        goto L79
    L73:
        if (r22 == 2131381179) goto L74;
    }

    public final void p3(String r59, String r60) {
        if (r59 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        FLogger.a.i("ObricPhotoActionComponent", "goToAIBeautifyPage: uri is null");
        return;
    L12:
        com.larus.bmhome.instruction.g r2 = (com.larus.bmhome.instruction.g) this.n.getValue();
        String r3 = null;
        if (r2 == null) goto L17;
        Pair r4 = r2.jo();
        if (r4 == null) goto L17;
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) r4.getFirst();
    L18:
        IUgcAIGCService r6 = (IUgcAIGCService) ServiceManager.get().getService(IUgcAIGCService.class);
        if (r6 == null) goto L30;
        FragmentActivity r54 = s1a.a.getActivity(this);
        if (r5 != null) goto L23;
        return;
    L23:
        com.larus.bmhome.chat.component.cvs.y r7 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r7 == null) goto L28;
        BotModel r8 = r7.j0();
        if (r8 == null) goto L28;
        r3 = r8.getBotId();
    L28:
        r6.W(new ny9.b(false, r54, r5, new ChatParam(null, r3, null, null, null, 253), false, false, null, null, null, null, null, null, null, null, null, null, null, r59, null, false, false, new b(r60), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -19005455, 262143));
        return;
    L30:
        return;
    L17:
        r5 = null;
        goto L18
    L5:
        if (StringsKt.isBlank(r59) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final void D3(String r11, String r12, String r13) {
        if (r12 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        FLogger.a.i("ObricPhotoActionComponent", "sendFinalQueryWithAction: uri is null");
        return;
    L13:
        FLogger.a.i("ObricPhotoActionComponent", "onReceivedFinalQueryUri: " + r12);
        com.larus.bmhome.chat.component.bottom.multimodal.g r2 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.p.getValue();
        if (r2 == null) goto L17;
        r2.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(com.larus.utils.y0.j(r12), null, 2)), new com.larus.bmhome.chat.component.bottom.multimodal.g1(false, MultimodalBizScene.ObricSpecialType, false), new com.larus.bmhome.chat.component.bottom.multimodal.h1(r11, MapsKt.mapOf(TuplesKt.to("action_bar_key", r13)), null, 4), null, null, 24));
        return;
    L17:
        return;
    L5:
        if (StringsKt.isBlank(r12) == true) goto L8;
        r1 = false;
        goto L10
    }

    public final boolean Hi(View r17, com.larus.bmhome.actionbar.model.z0 r18, AppCompatImageView r19) {
        Intrinsics.checkNotNullParameter(r18, "item");
        if (r17 != null) goto L5;
        return false;
    L5:
        rha.n r2 = this.A;
        if (r2 == null) goto L16;
        Intrinsics.checkNotNullParameter(r18, "newItem");
        if ((SystemClock.elapsedRealtime() - r2.n) <= 100) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        return false;
    L19:
        View r5 = LayoutInflater.from(r17.getContext()).inflate(2131563977, null, false);
        int r6 = 2131379904;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131379904)) == null) goto L127;
        if (ViewBindings.findChildViewById(r5, 2131379926) == null) goto L125;
        LinearLayout r14 = (LinearLayout) r5;
        FragmentActivity r7 = s1a.a.getActivity(this);
        com.larus.bmhome.chat.component.cvs.y r8 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        String r15 = "";
        if (r8 == null) goto L29;
        String r9 = r8.getBotId();
        if (r9 == null) goto L29;
        String r10 = r9;
    L30:
        com.larus.bmhome.chat.component.cvs.y r11 = (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
        if (r11 == null) goto L35;
        wc9.e r12 = r11.h();
        if (r12 == null) goto L35;
        String r13 = r12.a;
    L36:
        String r16 = String.valueOf(r13);
        LinkedHashMap r20 = new LinkedHashMap();
        ada.b r21 = (ada.b) this.w.getValue();
        if (r21 == null) goto L48;
        String r22 = r21.vx();
        if (r22 == null) goto L48;
        r20.put("reference_message", r22);
        ObricTaskStatusManager.a.getClass();
        DMTaskState r23 = ObricTaskStatusManager.c();
        if (r23 == null) goto L46;
        Map r24 = r23.getExtra();
        if (r24 == null) goto L46;
        String r25 = (String) r24.get("clarify_message_content");
        if (r25 == null) goto L46;
    L47:
        r20.put("clarify_message", r25);
    L46:
        r25 = "";
    L48:
        Unit r26 = Unit.INSTANCE;
        rha.r r27 = new rha.r(r7, r17, r19, r18, r10, r16, r20);
        ViewGroup r0 = (ViewGroup) this.y.getValue();
        va8.m r28 = (va8.m) this.x.getValue();
        if (r28 == null) goto L53;
        va8.l r29 = r28.iX();
        if (r29 == null) goto L53;
        FrameLayout r30 = r29.getTitleContainer();
    L54:
        rha.n r31 = new rha.n(r14, r27, r0, r30);
        this.A = r31;
        Intrinsics.checkNotNullParameter(this, "callback");
        r31.g = this;
        rha.n r1 = this.A;
        if (r1 == null) goto L57;
        r1.o = new q3(this);
    L57:
        final rha.n r32 = this.A;
        if (r32 != null) goto L60;
    L121:
        laa.d r33 = m3();
        if (r33 == null) goto L124;
        r33.zf(true);
    L124:
        return true;
    L60:
        if (Intrinsics.areEqual(r32.c.b, "obric_phone_operation") == true) goto L66;
        ObricActionBarTrackServiceExtDelegate r34 = ObricActionBarTrackServiceExtDelegate.b;
        com.larus.bmhome.actionbar.model.z0 r35 = r32.c;
        String r36 = r32.d;
        if (r36 == null) goto L65;
        r15 = r36;
    L65:
        r34.g(r35, r15, rha.n.a.a(r32.e));
    L66:
        r32.setFocusable(false);
        r32.setTouchable(true);
        r32.setOutsideTouchable(true);
        r32.setOnDismissListener(new rha.l(r32));
        r32.setTouchInterceptor(new rha.m(r32));
        r32.a.addOnAttachStateChangeListener(new rha.o(r32));
        r32.a.getViewTreeObserver().addOnGlobalLayoutListener(r32.p);
        ShadowLayout r37 = r32.j;
        if (r37 == null) goto L69;
        com.larus.utils.e1.d(r37, new rha.j(r32));
    L69:
        FLogger r38 = FLogger.a;
        r38.i("SecondaryMenuPopupWindow", "setMenuItems: itemsOfScene = " + ((Set) r32.m.getValue()));
        r32.i.removeAllViews();
        r38.i("SecondaryMenuPopupWindow", "actionBarKey: " + r32.c.b + ", currentTaskStatus =");
        Set r39 = (Set) r32.m.getValue();
        if (r39 == null) goto L105;
        Iterator r40 = r39.iterator();
        int r41 = 0;
    L73:
        if (r40.hasNext() == false) goto L106;
        Object r42 = r40.next();
        int r43 = r41 + 1;
        if (r41 >= 0) goto L77;
        CollectionsKt.throwIndexOverflow();
    L77:
        final int r44 = ((Number) r42).intValue();
        rha.g r45 = (rha.g) ((Map) rha.f.d.getValue()).get(Integer.valueOf(r44));
        if (r45 != null) goto L80;
        FLogger.a.e("SecondaryMenuPopupWindow", "setMenuItem: itemConfig is null, itemId = " + r44);
    L102:
        r41 = r43;
        goto L73
    L80:
        ItemTextView r46 = LayoutInflater.from(r32.i.getContext()).inflate(2131563979, r32.i, false);
        if (r46 == null) goto L104;
        final ItemTextView r47 = r46;
        r47.setId(r45.a);
        r47.setImageSrc(r45.b);
        r47.setText(r45.c);
        if (r41 != 0) goto L89;
        if (r39.size() != 1) goto L87;
        r47.setBackgroundResource(2131247652);
        r47.getTextView().setVisibility(0);
        r47.getLayoutParams().width = i5.B();
    L92:
        com.larus.utils.e1.d(r47, new rha.k(r44, r32, r47));
        r32.i.addView(r47);
        if (Intrinsics.areEqual(r32.c.b, "obric_oauto") == true) goto L96;
        ObricActionBarTrackServiceExtDelegate r48 = ObricActionBarTrackServiceExtDelegate.b;
        r48.o(r48.u(r45.a));
    L96:
        if (r41 == (r39.size() - 1)) goto L102;
        LinearLayout r49 = r32.i;
        View r50 = LayoutInflater.from(r49.getContext()).inflate(2131563978, r32.i, false);
        if (r50 == null) goto L101;
        r49.addView((LinearLayout) r50);
        goto L102
    L101:
        throw new NullPointerException("rootView");
    L87:
        r47.setBackgroundResource(2131247653);
        goto L92
    L89:
        if (r41 != (r39.size() - 1)) goto L91;
        r47.setBackgroundResource(2131247651);
        goto L92
    L91:
        r47.setBackgroundResource(2131247650);
        goto L92
    L104:
        throw new NullPointerException("rootView");
    L106:
        ShadowLayout r51 = r32.h.findViewById(2131379926);
        r51.setShadowSize(i5.h());
        r51.setShadowColor(ContextCompat.getColor(r32.a.getContext(), 2131103875));
        r51.setShadowOffset(new Point(0, i5.j0()));
        r51.setShadowRadius(i5.h());
        Pair<Integer, Integer> r52 = r32.b();
        int r110 = ((Number) r52.component1()).intValue();
        int r53 = ((Number) r52.component2()).intValue();
        if (r32.a.isAttachedToWindow() == false) goto L121;
        View r111 = r32.a;     // Catch: Exception -> L119
        if (PopupWindowLancet.hasSubWindowToken(r111) == false) goto L112;
    L128:
        goto L121
    L112:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r32) == false) goto L114;
        r32.showAtLocation(r111, 0, r110, r53);     // Catch: Exception -> L119
        goto L128
    L114:
        OverlaySource r112 = PopupWindowLancet.resolveSource(r111);     // Catch: Exception -> L119
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r32, r111, r112, 0, r110, r53) == true) goto L128;
        r32.showAtLocation(r111, 0, r110, r53);     // Catch: Exception -> L119
        PopupWindowLancet.trackAfterShow(r32, r112, r111);     // Catch: Exception -> L119
    L119:
        e = move-exception;
        FLogger.a.e("SecondaryMenuPopupWindow", "doOnShowMenu: showAtLocation error", e);
        goto L121
    L105:
        r38.e("SecondaryMenuPopupWindow", "setMenuItems: itemsOfScene is null");
    L53:
        r30 = null;
    L35:
        r13 = null;
    L29:
        r10 = "";
        goto L30
    L125:
        r6 = 2131379926;
    L127:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    L10:
        if (Intrinsics.areEqual(r18.b, r2.c.b) == false) goto L13;
        r3 = false;
    L16:
        r4 = false;
        goto L17
    }
}
