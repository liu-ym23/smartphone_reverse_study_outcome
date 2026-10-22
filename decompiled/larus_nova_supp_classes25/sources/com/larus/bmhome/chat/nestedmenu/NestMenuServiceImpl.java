package com.larus.bmhome.chat.nestedmenu;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ixigua.lib.track.TrackParams;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.a2;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.o1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.s0;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.u0;
import com.larus.bmhome.actionbar.model.u1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.actionbar.model.z1;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.banner.i;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.nestedmenu.ui.NestedMenuPopup;
import com.larus.bmhome.chat.nestedmenu.ui.OfficeTaskDeviceSwitchDialogFragment;
import com.larus.bmhome.chat.nestedmenu.ui.q;
import com.larus.bmhome.clarification.h1;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.taskskill.interaction.PcDeviceSelectionHandler;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.bmhome.taskskill.service.IPcDevicePanelService;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.n3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import di8.c0;
import di8.d0;
import di8.f0;
import di8.g;
import di8.h;
import di8.i0;
import di8.j;
import di8.j0;
import di8.k;
import di8.k0;
import di8.l;
import di8.l0;
import di8.m0;
import di8.n0;
import di8.o;
import di8.o0;
import di8.p;
import di8.t;
import di8.u;
import di8.v;
import di8.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import t19.s;
import tx9.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u0000 |2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0082\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010'\u001a\u00020$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J:\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0-H\u0016J:\u0010/\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0-H\u0002J$\u00100\u001a\u00020$*\u0002012\u0006\u00102\u001a\u0002032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0002J0\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0\"2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020$0-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020$0-H\u0002J.\u00107\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020$0\"H\u0016J^\u00109\u001a2\u0012\b\u0012\u00060\u0014j\u0002`;\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0:j\u0018\u0012\b\u0012\u00060\u0014j\u0002`;\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<`>2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016Jf\u00109\u001a2\u0012\b\u0012\u00060\u0014j\u0002`;\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0:j\u0018\u0012\b\u0012\u00060\u0014j\u0002`;\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<`>2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020AH\u0002J*\u0010B\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020#2\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010-H\u0002J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010@\u001a\u00020AH\u0002J \u0010F\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020#2\u0006\u0010G\u001a\u00020\u0010H\u0002J(\u0010H\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020#2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010-H\u0002J\u0018\u0010I\u001a\u00020\u00102\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020#H\u0002J(\u0010J\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010K\u001a\u00020L2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010-H\u0002J0\u0010M\u001a\u00020\u00142\u0006\u0010N\u001a\u00020O2\u0006\u0010@\u001a\u00020A2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010Q2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010S\u001a\u0004\u0018\u0001052\u0006\u0010@\u001a\u00020AH\u0002J\u0012\u0010T\u001a\u0004\u0018\u00010\u00142\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010U\u001a\u00020$2\u0006\u0010@\u001a\u00020AH\u0002J\u0018\u0010V\u001a\u00020\u00102\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020#H\u0002J\b\u0010W\u001a\u00020\u0010H\u0002J\u0018\u0010X\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010C\u001a\u00020#H\u0002J\u001a\u0010Y\u001a\u0004\u0018\u00010\u001e2\u0006\u0010C\u001a\u00020#2\u0006\u0010K\u001a\u00020ZH\u0002J8\u0010[\u001a\u00020O2\u0006\u0010C\u001a\u00020#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002J\u0014\u0010b\u001a\u0004\u0018\u00010\u00142\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0014\u0010c\u001a\u0004\u0018\u00010\u00142\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u001c\u0010d\u001a\u00020\u00142\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\u0018\u0010g\u001a\u00020$2\u0006\u0010C\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010h\u001a\u0004\u0018\u00010\u00142\f\u0010i\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002J \u0010j\u001a\u0004\u0018\u00010k2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010l\u001a\u00020mH\u0002J \u0010n\u001a\u0004\u0018\u00010_2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010l\u001a\u00020mH\u0002J \u0010o\u001a\u0004\u0018\u00010]2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010p\u001a\u00020\u0014H\u0002J\u0010\u0010q\u001a\u0004\u0018\u00010Z*\u0004\u0018\u00010rH\u0002J\u0014\u0010s\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002JB\u0010t\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010u\u001a\u0004\u0018\u00010\u001e2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140w2\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010H\u0002J6\u0010z\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140w2\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010H\u0002J\f\u0010{\u001a\u00020\u0014*\u00020\u0012H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006}"}, d2 = {"Lcom/larus/bmhome/chat/nestedmenu/NestMenuServiceImpl;", "Lcom/larus/bmhome/chat/nestedmenu/IMainBotNestedMenuService;", "<init>", "()V", "pcDeviceListProvider", "Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "getPcDeviceListProvider", "()Lcom/larus/bmhome/taskskill/service/PcDeviceListProviderInterface;", "pcDeviceListProvider$delegate", "Lkotlin/Lazy;", "pcDeviceSelectionHandler", "Lcom/larus/bmhome/taskskill/interaction/PcDeviceSelectionHandler;", "getPcDeviceSelectionHandler", "()Lcom/larus/bmhome/taskskill/interaction/PcDeviceSelectionHandler;", "pcDeviceSelectionHandler$delegate", "showActionBarNestedMenu", "", "scene", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuScene;", "enterFrom", "", "hostView", "Landroid/view/View;", "sourceView", "popupHostView", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "uiConfig", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuUiConfig;", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "hostVContext", "Lcom/larus/ui/arch/context/external/VContext;", "onUnEnableClick", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuClickResult;", "", "onClick", "updateIfNeeded", "dismiss", "interceptOfflineOfficeTaskDevice", "conversationId", "localMessageIds", "", "onContinue", "Lkotlin/Function0;", "onCancel", "showOfflineOfficeTaskDeviceDialog", "bindTaskSelection", "Lcom/larus/bmhome/chat/nestedmenu/ui/OfficeTaskDeviceSwitchDialogFragment;", "hostFragment", "Landroidx/fragment/app/Fragment;", "skillAbility", "Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "sendResultListener", "resolveAutoRouteTaskReplyOption", "onResolved", "generateMenuItemModels", "Ljava/util/LinkedHashMap;", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuSectionName;", "", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuItemModel;", "Lkotlin/collections/LinkedHashMap;", "validateActionBarConfig", "config", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuConfig;", "onClickMenuItem", "result", "doNext", "showMenuAndTrackConversationFork", "trackConversationForkModePanelClick", "isDisabled", "handleConversationForkSelection", "handleConversationForkUpgradeIfNeeded", "handleCurrentConversationDeviceSelection", "payload", "Lcom/larus/bmhome/chat/nestedmenu/OfficeTaskComputerPayload;", "makeConversationForkTaskParam", "runtimeType", "", "device", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "sourceTaskParam", "resolveSkillAbility", "resolveConversationForkSourceTaskParam", "showConversationForkUnavailable", "handleConnectGuideClick", "onlyRetainMoaMode", "mobActionBarOptionClick", "getClickedReplyOption", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuActionBarPayload;", "getAgentMode", "modePayload", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuActionBarPayload$ModePayload;", "modelPayload", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuActionBarPayload$ModelPayload;", "reasoningEffortPayload", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuActionBarPayload$ReasoningEffortPayload;", "getComputerType", "getComputerStatus", "getIsCurrentDevice", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "updateQueryOption", "findSelectedModeId", "models", "findModelItem", "Lcom/larus/bmhome/actionbar/model/SwitchMenuItem;", "identity", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "findModelPayload", "findModePayload", "modeId", "toActionBarPayload", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuItemPayload;", "getSwitchState", "resolveConversationForkSourceReplyOption", "fallbackReplyOption", "sourceExt", "", "useMessageAnchor", "allowCurrentConversationFallback", "resolveConversationForkSourceIsTask", "toReasoningEffortEntrySource", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NestMenuServiceImpl implements IMainBotNestedMenuService {
    public static final /* synthetic */ int d = 0;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
        public static final boolean a() {
            int r0 = NestMenuServiceImpl.d;
            return Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread());
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NestedMenuScene.values().length];
            r0[NestedMenuScene.SETTINGS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NestedMenuScene.ACTION_BAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements PcDeviceSelectionHandler.a {
        public final /* synthetic */ com.larus.bmhome.chat.nestedmenu.c a;
        public final /* synthetic */ NestMenuServiceImpl b;
        public final /* synthetic */ c0 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Function0<Unit> e;

        public final void b(String r1) {
        }

        public final void a(PcDevice r6) {
            Intrinsics.checkNotNullParameter(r6, "device");
            com.larus.bmhome.chat.nestedmenu.c r0 = this.a;
            NestMenuServiceImpl r1 = this.b;
            c0 r2 = this.c;
            String r3 = this.d;
            int r4 = NestMenuServiceImpl.d;
            r1.getClass();
            r0.g = NestMenuServiceImpl.i(2, r2, r6, r3);
            Function0<Unit> r7 = this.e;
            if (r7 == null) goto L6;
            r7.invoke();
            return;
        }

        public final void c(PcDevice r5) {
            Intrinsics.checkNotNullParameter(r5, "device");
            NestMenuServiceImpl r0 = this.b;
            int r1 = NestMenuServiceImpl.d;
            ((com.larus.bmhome.taskskill.service.d) r0.b.getValue()).c(r5);
            com.larus.bmhome.chat.nestedmenu.c r2 = this.a;
            NestMenuServiceImpl r3 = this.b;
            c0 r4 = this.c;
            String r6 = this.d;
            r3.getClass();
            r2.g = NestMenuServiceImpl.i(2, r4, r5, r6);
            Function0<Unit> r7 = this.e;
            if (r7 == null) goto L6;
            r7.invoke();
            return;
        }

        public c(com.larus.bmhome.chat.nestedmenu.c r1, NestMenuServiceImpl r2, c0 r3, String r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class d implements PcDeviceSelectionHandler.a {
        public final /* synthetic */ be8.a a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ NestMenuServiceImpl c;

        public final void b(String r1) {
        }

        public final void a(PcDevice r3) {
            Intrinsics.checkNotNullParameter(r3, "device");
            be8.a r0 = this.a;
            if (r0 == null) goto L5;
            r0.N10(r3.s(), false);
        L5:
            Function0<Unit> r4 = this.b;
            if (r4 == null) goto L9;
            r4.invoke();
            return;
        }

        public final void c(PcDevice r4) {
            Intrinsics.checkNotNullParameter(r4, "device");
            be8.a r0 = this.a;
            if (r0 == null) goto L5;
            r0.N10(r4.s(), false);
        L5:
            NestMenuServiceImpl r1 = this.c;
            int r2 = NestMenuServiceImpl.d;
            ((com.larus.bmhome.taskskill.service.d) r1.b.getValue()).c(r4);
            Function0<Unit> r5 = this.b;
            if (r5 == null) goto L9;
            r5.invoke();
            return;
        }

        public d(be8.a r1, Function0<Unit> r2, NestMenuServiceImpl r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        new a();
    }

    public static boolean k() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L13;
        r0.P();
        Fragment r1 = ChatServiceImpl.a.f();
        if (r1 == null) goto L13;
        t1a.b r2 = s1a.a.g(r1);
        if (r2 == null) goto L13;
        be8.a r3 = r2.getAbility(be8.a.class);
        if (r3 == null) goto L13;
        if (r3.YD() != true) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L20;
        return true;
    L20:
        return false;
    L13:
        r4 = false;
        goto L14
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final void O8() {
        Intrinsics.checkNotNullParameter("action_bar_banner_request", "enterFrom");
        if (a.a() == true) goto L6;
        y.c(new u());
        return;
    L6:
        f.h("action_bar_banner_request");
    }

    public final PcDeviceSelectionHandler e() {
        return (PcDeviceSelectionHandler) this.c.getValue();
    }

    public NestMenuServiceImpl() {
        this.b = LazyKt.lazy(new di8.f());
        this.c = LazyKt.lazy(new o());
    }

    public static String d(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L28;
        d0 r0 = (d0) r3.next();
        if (r0.getRight().a == false) goto L16;
        com.larus.bmhome.chat.nestedmenu.b r1 = o(r0.c());
        if (r1 == null) goto L16;
        com.larus.bmhome.chat.nestedmenu.b.a r4 = r1.c;
        if (r4 == null) goto L16;
        t0 r5 = r4.a;
        if (r5 == null) goto L16;
        String r6 = r5.a;
        if (r6 == null) goto L16;
        return r6;
    L16:
        n0 r7 = r0.getSubMenu();
        if (r7 == null) goto L4;
        Map<String, List<d0>> r8 = r7.a;
        if (r8 == null) goto L4;
        Collection<List<d0>> r9 = r8.values();
        if (r9 == null) goto L4;
        Iterator<T> r10 = r9.iterator();
    L24:
        if (r10.hasNext() == false) goto L4;
        String r11 = d((List) r10.next());
        if (r11 == null) goto L24;
        return r11;
    L28:
        return null;
    }

    public static ReplyOption f(z0 r4) {
        IActionBarService r0 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r0 == null) goto L20;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L13;
        r2.P();
        Fragment r3 = ChatServiceImpl.a.f();
        if (r3 == null) goto L13;
        t1a.b r5 = s1a.a.g(r3);
        if (r5 == null) goto L13;
        com.larus.bmhome.chat.component.cvs.y r6 = r5.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r6 == null) goto L13;
        String r7 = r6.getBotId();
    L14:
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        ReplyOption r1 = r0.h(r7, ActiveSwitchType.DEEPTHINK.getValue());
        if (r1 == null) goto L20;
        return r1;
    L13:
        r7 = null;
    L20:
        if (r4 == null) goto L26;
        p0 r8 = r4.o;
        if (r8 != null) goto L24;
        return null;
    L24:
        return r8.b();
    L26:
        return null;
    }

    public static void l(c0 r3) {
        s.a.g(r3.c.getContext(), 2131906590, false);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [di8.l0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [di8.i0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [di8.j0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [di8.k0] */
    public static boolean m(final c0 r11) {
        List<ei8.c> r0 = f.a;
        Intrinsics.checkNotNullParameter(r11, "config");
        f.c();
        boolean r2 = false;
        if (r11.g.i == false) goto L31;
        m0 r1 = f.d;
        if (r1 != null) goto L7;
    L48:
        if (r2 == true) goto L50;
    L69:
        return r2;
    L50:
        if ((!r11.g.g.isEmpty()) == false) goto L69;
        o0 r3 = r11.g;
        if (r3.h != null) goto L69;
        Map<String, String> r4 = r3.g;
        ReplyOption r5 = r11.l;
        String r6 = null;
        if (r5 == null) goto L56;
        String r7 = r5.getModeId();
    L57:
        ReplyOption r12 = r11.l;
        if (r12 == null) goto L62;
        ModelItemIdentity r13 = r12.getModel();
        if (r13 == null) goto L62;
        r6 = r13.getKey();
    L62:
        Map r14 = h0.a;
        Intrinsics.checkNotNullParameter(r4, "baseParams");
        JSONObject r15 = h0.e(r4);
        r15.remove("chat_type");
        if (r7 != null) goto L65;
        r7 = "";
    L65:
        r15.put("mode_id", r7);
        if (r6 != null) goto L68;
        r6 = "";
    L68:
        r15.put("model_item_key", r6);
        h0.b("fork_mode_panel_show", r15);
        goto L69
    L56:
        r7 = null;
        goto L57
    L7:
        if (f.e == true) goto L48;
        if (Intrinsics.areEqual(r1.a.b, r11.b) == false) goto L48;
        c0 r8 = r1.a;
        if (r8.c != r11.c) goto L48;
        if (r8.d != r11.d) goto L48;
        r8.f = r11.f;
        r8.l = r11.l;
        o0 r9 = r11.g;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.g = r9;
        LinkedHashMap<String, List<d0>> r10 = f.d(r1.a);
        int r16 = com.larus.bmhome.chat.nestedmenu.ui.a.a;
        List<? extends q> r17 = com.larus.bmhome.chat.nestedmenu.ui.a.a(r10, r1.a.g.j, r10);
        if (((ArrayList) r17).isEmpty() == false) goto L18;
    L30:
        f.b();
        goto L48
    L18:
        if (r1.c.update(r17) == false) goto L30;
        f.d = m0.a(r1, r10);
        f.f(r17, r1.a);
        List<ei8.c> r18 = f.a;
        ArrayList r19 = new ArrayList();
        Iterator r20 = ((ArrayList) r18).iterator();
    L22:
        if (r20.hasNext() == false) goto L26;
        Object r21 = r20.next();
        if ((r21 instanceof ei8.b) == false) goto L22;
        r19.add(r21);
        goto L22
    L26:
        Iterator r22 = r19.iterator();
    L28:
        if (r22.hasNext() == false) goto L47;
        ((ei8.b) r22.next()).d(r10, r1.a);
    L47:
        r2 = true;
        goto L48
    L31:
        LinkedHashMap<String, List<d0>> r23 = f.d(r11);
        int r24 = com.larus.bmhome.chat.nestedmenu.ui.a.a;
        List r25 = com.larus.bmhome.chat.nestedmenu.ui.a.a(r23, r11.g.j, r23);
        if (((ArrayList) r25).isEmpty() == true) goto L48;
        f.b();
        f.e = false;
        NestedMenuPopup r26 = new NestedMenuPopup(r11, r25, new i0(r11), new j0(r11), new k0(r11), new l0(r11));
        f.d = new m0(r11, r23, r26);
        if (r26.o() == true) goto L37;
        f.a(r11, false);
        goto L48
    L37:
        List<ei8.c> r27 = f.a;
        ArrayList r28 = new ArrayList();
        Iterator r29 = ((ArrayList) r27).iterator();
    L39:
        if (r29.hasNext() == false) goto L43;
        Object r30 = r29.next();
        if ((r30 instanceof ei8.b) == false) goto L39;
        r28.add(r30);
        goto L39
    L43:
        Iterator r31 = r28.iterator();
    L45:
        if (r31.hasNext() == false) goto L47;
        ((ei8.b) r31.next()).b(r23, r11);
        goto L45
    }

    public static com.larus.bmhome.chat.nestedmenu.b o(f0 r1) {
        if ((r1 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L6;
        return (com.larus.bmhome.chat.nestedmenu.b) r1;
    L6:
        if ((r1 instanceof di8.p0) == false) goto L10;
        f0 r2 = ((di8.p0) r1).a;
        if ((r2 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L10;
        return (com.larus.bmhome.chat.nestedmenu.b) r2;
    L10:
        return null;
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final void g0(final String r2) {
        if (a.a() == true) goto L6;
        y.c(new v(r2));
        return;
    L6:
        f.b();
    }

    public static com.larus.bmhome.chat.nestedmenu.b.a a(List r4, String r5) {
        Iterator r6 = r4.iterator();
    L3:
        com.larus.bmhome.chat.nestedmenu.b.a r1 = null;
        String r2 = null;
        r2 = null;
        if (r6.hasNext() == false) goto L27;
        d0 r0 = (d0) r6.next();
        com.larus.bmhome.chat.nestedmenu.b r3 = o(r0.c());
        if (r3 == null) goto L8;
        com.larus.bmhome.chat.nestedmenu.b.a r7 = r3.c;
    L9:
        if (r7 == null) goto L14;
        t0 r8 = r7.a;
        if (r8 == null) goto L14;
        r2 = r8.a;
    L14:
        if (Intrinsics.areEqual(r2, r5) == true) goto L15;
        n0 r9 = r0.getSubMenu();
        if (r9 == null) goto L3;
        Map<String, List<d0>> r10 = r9.a;
        if (r10 == null) goto L3;
        Collection<List<d0>> r11 = r10.values();
        if (r11 == null) goto L3;
        Iterator<T> r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L3;
        r1 = a((List) r12.next(), r5);
        if (r1 == null) goto L24;
    L15:
        return r7;
    L8:
        r7 = null;
    L27:
        return r1;
    }

    public static b2 b(List r3, ModelItemIdentity r4) {
        Iterator r5 = r3.iterator();
    L3:
        ModelItemIdentity r1 = null;
        if (r5.hasNext() == false) goto L26;
        d0 r0 = (d0) r5.next();
        com.larus.bmhome.chat.nestedmenu.b r2 = o(r0.c());
        if (r2 == null) goto L8;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r6 = r2.a;
    L9:
        if (r6 == null) goto L12;
        r1 = r6.b;
    L12:
        if (Intrinsics.areEqual(r1, r4) == true) goto L14;
        n0 r7 = r0.getSubMenu();
        if (r7 == null) goto L3;
        Map<String, List<d0>> r8 = r7.a;
        if (r8 == null) goto L3;
        Collection<List<d0>> r9 = r8.values();
        if (r9 == null) goto L3;
        Iterator<T> r10 = r9.iterator();
    L23:
        if (r10.hasNext() == false) goto L3;
        r1 = b((List) r10.next(), r4);
        if (r1 == null) goto L23;
    L14:
        return r6.a;
    L8:
        r6 = null;
    L26:
        return r1;
    }

    public static com.larus.bmhome.chat.nestedmenu.b.C0068b c(List r3, ModelItemIdentity r4) {
        Iterator r5 = r3.iterator();
    L3:
        ModelItemIdentity r1 = null;
        if (r5.hasNext() == false) goto L25;
        d0 r0 = (d0) r5.next();
        com.larus.bmhome.chat.nestedmenu.b r2 = o(r0.c());
        if (r2 == null) goto L8;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r6 = r2.a;
    L9:
        if (r6 == null) goto L12;
        r1 = r6.b;
    L12:
        if (Intrinsics.areEqual(r1, r4) == true) goto L13;
        n0 r7 = r0.getSubMenu();
        if (r7 == null) goto L3;
        Map<String, List<d0>> r8 = r7.a;
        if (r8 == null) goto L3;
        Collection<List<d0>> r9 = r8.values();
        if (r9 == null) goto L3;
        Iterator<T> r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L3;
        r1 = c((List) r10.next(), r4);
        if (r1 == null) goto L22;
    L13:
        return r6;
    L8:
        r6 = null;
    L25:
        return r1;
    }

    public static void p(c0 r7, com.larus.bmhome.chat.nestedmenu.c r8, boolean r9) {
        Map<String, String> r0 = r7.g.g;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        f0 r1 = r8.d.c();
        String r3 = null;
        if ((r1 instanceof di8.p0) == false) goto L8;
        di8.p0 r2 = (di8.p0) r1;
    L9:
        boolean r4 = false;
        if (r2 == null) goto L14;
        boolean r5 = true;
        if (r2.g != true) goto L14;
    L15:
        if (r5 == false) goto L17;
        return;
    L17:
        f0 r10 = r8.d.c();
        if ((r10 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L20;
        com.larus.bmhome.chat.nestedmenu.b r11 = (com.larus.bmhome.chat.nestedmenu.b) r10;
    L21:
        if (r11 != null) goto L31;
        if (r2 == null) goto L24;
        f0 r12 = r2.a;
    L26:
        if ((r12 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L28;
        r11 = (com.larus.bmhome.chat.nestedmenu.b) r12;
    L29:
        if (r11 != null) goto L31;
        return;
    L28:
        r11 = null;
        goto L29
    L24:
        r12 = null;
    L31:
        com.larus.bmhome.chat.nestedmenu.b.a r6 = r11.c;
        if (r6 == null) goto L34;
        t0 r13 = r6.a;
    L35:
        com.larus.bmhome.chat.nestedmenu.b.C0068b r14 = r11.a;
        com.larus.bmhome.chat.nestedmenu.b.c r15 = r11.b;
        if (r13 == null) goto L38;
        String r16 = r13.a;
    L65:
        if (r13 == null) goto L67;
        String r17 = r13.a;
    L68:
        ReplyOption r18 = r7.l;
        if (r18 == null) goto L71;
        String r19 = r18.getModeId();
    L73:
        if (Intrinsics.areEqual(r17, r19) == false) goto L79;
        ReplyOption r20 = r7.l;
        if (r20 == null) goto L92;
        ModelItemIdentity r21 = r20.getModel();
        if (r21 == null) goto L92;
        r3 = r21.getKey();
    L92:
        Map r22 = h0.a;
        Intrinsics.checkNotNullParameter(r0, "baseParams");
        JSONObject r23 = h0.e(r0);
        r23.remove("previous_page");
        r23.remove("chat_type");
        if (r16 != null) goto L95;
        r16 = "";
    L95:
        r23.put("mode_id", r16);
        if (r3 != null) goto L98;
        r3 = "";
    L98:
        r23.put("model_item_key", r3);
        r23.put("is_disabled", r9);
        h0.b("fork_mode_panel_click", r23);
        return;
    L79:
        if (r13 == null) goto L83;
        o1 r24 = r13.m;
        if (r24 == null) goto L92;
        r3 = r24.a().getKey();
        goto L92
    L83:
        if (r14 == null) goto L85;
        r3 = r14.b.getKey();
        goto L92
    L85:
        if (r15 == null) goto L87;
        r3 = r15.b.getKey();
        goto L92
    L87:
        ReplyOption r25 = r7.l;
        if (r25 == null) goto L92;
        ModelItemIdentity r26 = r25.getModel();
        if (r26 == null) goto L92;
        r3 = r26.getKey();
        goto L92
    L71:
        r19 = null;
        goto L73
    L67:
        r17 = null;
        goto L68
    L38:
        if (r14 == null) goto L59;
        z0 r27 = r7.f;
        if (r27 == null) goto L44;
        p0 r28 = r27.o;
        if (r28 == null) goto L44;
        boolean r29 = Intrinsics.areEqual(r28.k, Boolean.TRUE);
    L45:
        if (r29 == false) goto L59;
        z0 r30 = r7.f;
        if (r30 == null) goto L53;
        p0 r31 = r30.o;
        if (r31 == null) goto L53;
        s0 r32 = r31.j;
        if (r32 == null) goto L53;
        r4 = Intrinsics.areEqual(r32.d, Boolean.TRUE);
    L53:
        if (r4 == false) goto L55;
    L56:
        ReplyOption r33 = r7.l;
        if (r33 == null) goto L64;
        r16 = r33.getModeId();
    L64:
        r16 = null;
        goto L65
    L55:
        if (k() == false) goto L59;
    L44:
        r29 = false;
    L59:
        if (r14 == null) goto L61;
        r16 = r14.a.s;
        goto L65
    L61:
        ReplyOption r34 = r7.l;
        if (r34 == null) goto L64;
        r16 = r34.getModeId();
        goto L65
    L34:
        r13 = null;
        goto L35
    L20:
        r11 = null;
    L14:
        r5 = false;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final LinkedHashMap P8(NestedMenuScene r16, z0 r17, ReplyOption r18) {
        Intrinsics.checkNotNullParameter(r16, "scene");
        View r5 = new View(AppHost.a.getApplication());
        return f.d(new c0(r16, "", r5, r5, r5, r17, null, new g(), null, null, r18, null, 5824));
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final boolean Q8(View r38, z0 r39, final h1 r40) {
        Intrinsics.checkNotNullParameter(r38, "hostView");
        Intrinsics.checkNotNullParameter(r40, "onResolved");
        ReplyOption r1 = f(r39);
        c0 r15 = new c0(NestedMenuScene.ACTION_BAR, "clarification_auto_route", r38, r38, r38, r39, new o0(true, false, null, false, null, 0, 0, false, null, null, null, null, null, null, false, false, null, null, null, 33554430), new j(), null, null, r1, null, 5760);
        LinkedHashMap r20 = f.d(r15);
        Iterator r2 = SequencesKt.flatMap(CollectionsKt.asSequence(r20.entrySet()), new k()).iterator();
    L3:
        Object r6 = null;
        if (r2.hasNext() == false) goto L47;
        Object r3 = r2.next();
        f0 r7 = ((d0) ((Pair) r3).component2()).c();
        if ((r7 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L8;
        com.larus.bmhome.chat.nestedmenu.b r8 = (com.larus.bmhome.chat.nestedmenu.b) r7;
    L9:
        if (r8 == null) goto L43;
        com.larus.bmhome.chat.nestedmenu.b.a r9 = r8.c;
        if (r9 == null) goto L21;
        t0 r10 = r9.a;
        if (r10 == null) goto L21;
        Integer r11 = r10.j;
        int r12 = AgentMode.MOA.getValue();
        if (r11 == null) goto L21;
        if (r11.intValue() != r12) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == true) goto L44;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r14 = r8.a;
        if (r14 == null) goto L33;
        b2 r16 = r14.a;
        if (r16 == null) goto L33;
        Integer r17 = r16.l;
        int r18 = AgentMode.MOA.getValue();
        if (r17 == null) goto L33;
        if (r17.intValue() != r18) goto L33;
        boolean r19 = true;
    L34:
        if (r19 == true) goto L44;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r21 = r8.a;
        if (r21 == null) goto L41;
        b2 r22 = r21.a;
        if (r22 == null) goto L41;
        r6 = r22.s;
    L41:
        if (Intrinsics.areEqual(r6, "3") == false) goto L43;
    L33:
        r19 = false;
    L44:
        boolean r23 = true;
    L45:
        if (r23 == false) goto L3;
        r6 = r3;
    L21:
        r13 = false;
    L43:
        r23 = false;
        goto L45
    L8:
        r8 = null;
    L47:
        Pair r24 = (Pair) r6;
        if (r24 != null) goto L50;
        return false;
    L50:
        String r110 = (String) r24.component1();
        d0 r4 = (d0) r24.component2();
        if (r4.getEnabled() == true) goto L53;
        return false;
    L53:
        final com.larus.bmhome.chat.nestedmenu.c r5 = new com.larus.bmhome.chat.nestedmenu.c(r15.a, r110, r20, r4, null, DoraCallStateCode.DOUBAO_CMD_12);
        if (r4.getRight().a == false) goto L58;
        if (r1 == null) goto L58;
        r40.invoke(r1);
        return true;
    L58:
        j(r15, r5, new l(r5, r40));
        if (r5.f != null) goto L68;
        return false;
    L68:
        return true;
    }

    public final void g(c0 r12, com.larus.bmhome.chat.nestedmenu.c r13, Function0<Unit> r14) {
        IActionBarService r0 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        com.larus.bmhome.chat.nestedmenu.b r3 = o(r13.d.c());
        LifecycleCoroutineScope r4 = null;
        if (r3 == null) goto L11;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r5 = r3.a;
    L12:
        if (r3 == null) goto L16;
        com.larus.bmhome.chat.nestedmenu.b.a r6 = r3.c;
        if (r6 == null) goto L16;
        t0 r7 = r6.a;
    L17:
        if (r5 == null) goto L20;
        ModelItemIdentity r8 = r5.b;
        if (r8 == null) goto L20;
    L28:
        if (r7 == null) goto L31;
        String r9 = r7.a;
        if (r9 == null) goto L31;
    L35:
        String r10 = "";
        if (r5 == null) goto L39;
        b2 r11 = r5.a;
        if (r11 == null) goto L39;
    L72:
        z1 r15 = r11.n;
        if (r15 == null) goto L75;
        boolean r16 = Intrinsics.areEqual(r15.b, Boolean.TRUE);
    L76:
        if (r16 == true) goto L78;
    L77:
        boolean r17 = false;
    L92:
        if (r17 == false) goto L94;
        return;
    L94:
        if (r2 == true) goto L97;
        r14.invoke();
        return;
    L97:
        IFlowSdkDepend r18 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r18 == null) goto L106;
        r18.P();
        Fragment r19 = ChatServiceImpl.a.f();
        if (r19 == null) goto L106;
        t1a.b r20 = s1a.a.g(r19);
        if (r20 == null) goto L106;
        com.larus.bmhome.chat.component.cvs.y r21 = r20.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r21 == null) goto L106;
        wc9.e r22 = r21.h();
    L203:
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L116
        if (r22 == null) goto L110;
        String r24 = r22.r;     // Catch: Throwable -> L116
    L111:
        if (r24 == null) goto L114;
        r10 = r24;
    L114:
        Object r25 = Result.constructor-impl(new JSONObject(r10));     // Catch: Throwable -> L116
    L118:
        JSONObject r26 = new JSONObject();
        if (Result.isFailure-impl(r25) == false) goto L121;
        r25 = r26;
    L121:
        JSONObject r27 = (JSONObject) r25;
        String r28 = r12.g.e.get("agent_task_param");
        if (r28 != null) goto L124;
    L126:
        r28 = null;
    L128:
        if (r12.g.f == true) goto L135;
        if (r28 != null) goto L135;
        r28 = r27.optString("agent_task_param");
        Intrinsics.checkNotNull(r28);
        if ((!StringsKt.isBlank(r28)) == true) goto L135;
        String r29 = null;
    L136:
        f0 r30 = r13.d.c();
        if ((r30 instanceof di8.p0) == false) goto L139;
        di8.p0 r31 = (di8.p0) r30;
    L141:
        if (r12.g.b == false) goto L152;
        if (r31 != null) goto L152;
        if (r29 != null) goto L145;
    L146:
        r1 = true;
    L147:
        if (r1 == false) goto L150;
        l(r12);
        return;
    L150:
        r13.g = r29;
        r14.invoke();
        return;
    L145:
        if (StringsKt.isBlank(r29) == false) goto L147;
    L152:
        if (r31 == null) goto L154;
        PcDevice r32 = r31.c;
    L155:
        if (r32 != null) goto L158;
        r13.g = i(1, r12, null, r29);
        r14.invoke();
        return;
    L158:
        String r33 = r32.getDeviceId();
        if (r33 != null) goto L161;
    L163:
        r33 = null;
    L164:
        if (r33 != null) goto L167;
        l(r12);
        return;
    L167:
        bs8.e r34 = ((com.larus.bmhome.taskskill.service.d) this.b.getValue()).b();
        if (r34 == null) goto L179;
        List r35 = r34.a();
        if (r35 == null) goto L179;
        Iterator r36 = r35.iterator();
    L173:
        if (r36.hasNext() == false) goto L177;
        Object r37 = r36.next();
        if (Intrinsics.areEqual(((PcDevice) r37).getDeviceId(), r33) == false) goto L173;
    L178:
        PcDevice r38 = (PcDevice) r37;
    L180:
        if (r38 != null) goto L205;
        l(r12);
        return;
    L205:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L185
        Object r40 = Result.constructor-impl(CompatKt.findFragment(r12.c));     // Catch: Throwable -> L185
    L188:
        if (Result.isFailure-impl(r40) == false) goto L190;
        r40 = null;
    L190:
        Fragment r41 = (Fragment) r40;
        IFlowSdkDepend r42 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r42 == null) goto L193;
        r42.P();
        Fragment r43 = ChatServiceImpl.a.f();
    L194:
        if (r41 != null) goto L196;
        r41 = r43;
    L196:
        if (r41 == null) goto L198;
        r4 = LifecycleOwnerKt.getLifecycleScope(r41);
    L198:
        if (r4 != null) goto L201;
        FLogger.a.w("NestMenuServiceImpl", "[handleConversationForkSelection] no available coroutine scope");
        l(r12);
        return;
    L201:
        e().b = new c(r13, this, r12, r29, r14);
        e().b(r12.c.getContext(), r4, r38);
        return;
    L193:
        r43 = null;
    L185:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L188
    L177:
        r37 = null;
    L179:
        r38 = null;
        goto L180
    L161:
        if ((!StringsKt.isBlank(r33)) == false) goto L163;
    L154:
        r32 = null;
        goto L155
    L139:
        r31 = null;
    L135:
        r29 = r28;
        goto L136
    L124:
        if ((!StringsKt.isBlank(r28)) == false) goto L126;
    L110:
        r24 = null;
    L116:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L106:
        r22 = null;
        goto L203
    L78:
        String r46 = r15.a;
        if (r46 != null) goto L81;
        r46 = "";
    L81:
        s.a.g(r12.c.getContext(), 2131907771, false);
        int r47 = n3.a;
        n3.a(r12.c.getContext(), r46);
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r48 = ICommerceMembershipService.a.a();
        if (r48 == null) goto L91;
        if (r8 == null) goto L86;
        String r49 = r8.getKey();
        if (r49 == null) goto L86;
    L90:
        r48.w(r46, r49);
    L86:
        ModelItemIdentity r50 = r11.b();
        if (r50 == null) goto L89;
        r49 = r50.getKey();
        goto L90
    L89:
        r49 = null;
    L91:
        r17 = true;
        goto L92
    L75:
        r16 = false;
    L39:
        if (r7 == null) goto L43;
        a2 r51 = r7.r;
        if (r51 == null) goto L43;
        List r52 = r51.a;
    L44:
        if (r52 != null) goto L46;
        r52 = CollectionsKt.emptyList();
    L46:
        Iterator r53 = r52.iterator();
    L48:
        if (r53.hasNext() == false) goto L52;
        Object r54 = r53.next();
        if (Intrinsics.areEqual(((b2) r54).b(), r8) == false) goto L48;
    L53:
        r11 = (b2) r54;
        if (r11 != null) goto L72;
        Iterator<T> r55 = com.larus.bmhome.chat.nestedmenu.a.a(r12.f, r9).c.iterator();
    L57:
        if (r55.hasNext() == false) goto L61;
        Object r56 = r55.next();
        if (Intrinsics.areEqual(((b2) r56).b(), r8) == false) goto L57;
    L62:
        r11 = (b2) r56;
        if (r11 != null) goto L72;
        com.larus.bmhome.chat.nestedmenu.b r57 = r13.a("model");
        if (r57 == null) goto L69;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r58 = r57.a;
        if (r58 == null) goto L69;
        r11 = r58.a;
    L70:
        if (r11 != null) goto L72;
    L69:
        r11 = null;
        goto L70
    L61:
        r56 = null;
        goto L62
    L52:
        r54 = null;
    L43:
        r52 = null;
    L31:
        ReplyOption r59 = r13.f;
        if (r59 == null) goto L34;
        r9 = r59.getModeId();
        goto L35
    L34:
        r9 = null;
    L20:
        if (r7 == null) goto L24;
        o1 r60 = r7.m;
        if (r60 == null) goto L24;
        r8 = r60.a();
    L24:
        ReplyOption r61 = r13.f;
        if (r61 == null) goto L27;
        r8 = r61.getModel();
        goto L28
    L27:
        r8 = null;
    L16:
        r7 = null;
        goto L17
    L11:
        r5 = null;
        goto L12
    L5:
        if (r0.m(r13.f) != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void h(c0 r7, di8.p0 r8, Function0<Unit> r9) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        LifecycleCoroutineScope r1 = null;
        if (r0 == null) goto L5;
        r0.P();
        Fragment r2 = ChatServiceImpl.a.f();
    L42:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(CompatKt.findFragment(r7.c));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = null;
    L13:
        Fragment r5 = (Fragment) r4;
        if (r5 == null) goto L18;
        t1a.b r6 = s1a.a.g(r5);
        if (r6 == null) goto L18;
        be8.a r10 = (be8.a) r6.getAbility(be8.a.class);
    L19:
        if (r2 == null) goto L23;
        t1a.b r11 = s1a.a.g(r2);
        if (r11 == null) goto L23;
        be8.a r12 = (be8.a) r11.getAbility(be8.a.class);
    L24:
        if (r10 == null) goto L27;
        r12 = r10;
    L27:
        if (r10 == null) goto L29;
        r2 = r5;
    L29:
        PcDevice r13 = r8.c;
        if (r13 != null) goto L35;
        if (r12 == null) goto L33;
        r12.N10(null, r8.b);
    L33:
        r9.invoke();
        return;
    L35:
        if (r2 == null) goto L37;
        r1 = LifecycleOwnerKt.getLifecycleScope(r2);
    L37:
        if (r1 != null) goto L40;
        FLogger.a.w("NestMenuServiceImpl", "[handleCurrentConversationDeviceSelection] no available coroutine scope");
        return;
    L40:
        e().b = new d(r12, r9, this);
        e().b(r7.c.getContext(), r1, r13);
        return;
    L23:
        r12 = null;
    L18:
        r10 = null;
    L8:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L5:
        r2 = null;
        goto L42
    }

    public final void j(c0 r49, com.larus.bmhome.chat.nestedmenu.c r50, Function0<Unit> r51) {
        NestedMenuScene r0 = r49.a;
        NestedMenuScene r5 = NestedMenuScene.ACTION_BAR;
        Integer r47 = null;
        if (r0 != r5) goto L258;
        if (r0 != r5) goto L258;
        z0 r1 = r49.f;
        if (r1 == null) goto L258;
        f0 r6 = r50.d.c();
        if ((r6 instanceof di8.p0) == false) goto L12;
        di8.p0 r7 = (di8.p0) r6;
    L13:
        f0 r8 = r50.d.c();
        if ((r8 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L16;
        com.larus.bmhome.chat.nestedmenu.b r9 = (com.larus.bmhome.chat.nestedmenu.b) r8;
    L17:
        if (r9 != null) goto L27;
        if (r7 == null) goto L20;
        f0 r10 = r7.a;
    L22:
        if ((r10 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L24;
        r9 = (com.larus.bmhome.chat.nestedmenu.b) r10;
    L25:
        if (r9 != null) goto L27;
    L24:
        r9 = null;
        goto L25
    L20:
        r10 = null;
    L27:
        com.larus.bmhome.chat.nestedmenu.b.a r11 = r9.c;
        com.larus.bmhome.chat.nestedmenu.b.C0068b r12 = r9.a;
        com.larus.bmhome.chat.nestedmenu.b.c r13 = r9.b;
        if (r11 == null) goto L30;
        boolean r14 = true;
    L31:
        if (r12 == null) goto L33;
        boolean r15 = true;
    L34:
        if (r11 == null) goto L55;
        t0 r16 = r11.a;
        if (r16 == null) goto L55;
        o1 r17 = r16.m;
        if (r17 == null) goto L40;
        ModelItemIdentity r18 = r17.a();
    L41:
        com.larus.bmhome.chat.nestedmenu.b.a r19 = r11;
        if (r18 == null) goto L51;
        List<d0> r20 = r50.c.get("model");
        if (r20 != null) goto L46;
        r20 = CollectionsKt.emptyList();
    L46:
        b2 r21 = b(r20, r18);
        if (r21 == null) goto L51;
        u1 r22 = r21.t;
        if (r22 == null) goto L51;
        Integer r23 = r22.b;
    L52:
        if (r18 == null) goto L54;
        ReplyOption r2 = new ReplyOption(r18, r16.a, r23);
    L67:
        ReplyOption r110 = r2;
    L69:
        if (r110 == null) goto L74;
        String r24 = ObricTaskSkillDelegate.b.e(r49.l, r110.getModel());
        if (r24 == null) goto L75;
        r110 = ReplyOption.copy$default(r110, null, r24, null, 5, null);
    L75:
        if (r14 == false) goto L85;
        if (r15 == true) goto L85;
        if (r110 == null) goto L84;
        ModelItemIdentity r3 = r110.getModel();
        if (r3 == null) goto L84;
        List<d0> r25 = r50.c.get("model");
        if (r25 != null) goto L83;
        r25 = CollectionsKt.emptyList();
    L83:
        r12 = c(r25, r3);
    L95:
        com.larus.bmhome.chat.nestedmenu.b.a r26 = r19;
    L97:
        if (Intrinsics.areEqual(r50.b, "mode") == false) goto L100;
        String r38 = "mode";
    L103:
        if (r110 == null) goto L107;
        ModelItemIdentity r4 = r110.getModel();
        if (r4 == null) goto L107;
        String r36 = r4.getKey();
    L108:
        IFlowSdkDepend r27 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r27 == null) goto L111;
        r27.P();
        Fragment r28 = ChatServiceImpl.a.f();
    L112:
        t1a.b r29 = r49.m;
        if (r29 == null) goto L117;
        com.larus.bmhome.chat.component.cvs.y r30 = (com.larus.bmhome.chat.component.cvs.y) r29.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r30 == null) goto L117;
    L122:
        if (r30 == null) goto L124;
        wc9.e r31 = r30.h();
    L125:
        if (r7 != null) goto L127;
    L146:
        String r32 = "0";
    L147:
        String r44 = r32;
        if (r30 == null) goto L150;
        String r33 = r30.getBotId();
    L152:
        if ((r28 instanceof xe8.a) == false) goto L154;
        xe8.a r34 = (xe8.a) r28;
    L155:
        if (r34 == null) goto L157;
        long r111 = r34.getChatUniqueKey();
        LruCache r35 = ko8.a.a;
        String r37 = ko8.a.e(r111);
    L158:
        r r39 = r1.q;
        if (r39 == null) goto L161;
        String r112 = r39.g;
    L162:
        if (r39 == null) goto L166;
        Integer r40 = r39.a;
        if (r40 == null) goto L166;
        int r41 = r40.intValue();
    L167:
        String r42 = String.valueOf(r41);
        String r43 = r1.b;
        if (r12 == null) goto L172;
        String r113 = r12.a.b;
        if (r113 == null) goto L181;
    L180:
        String r210 = r113;
    L182:
        Integer r114 = r49.g.x;
        if (r110 == null) goto L190;
        ModelItemIdentity r115 = r110.getModel();
        if (r115 == null) goto L190;
        String r116 = r115.getKey();
        if (r116 == null) goto L190;
        String r310 = r116;
    L191:
        if (r110 == null) goto L195;
        ModelItemIdentity r117 = r110.getModel();
        if (r117 == null) goto L195;
        Boolean r311 = Boolean.valueOf(r117.isCustomModel());
    L196:
        boolean r45 = r9.d;
        if (r110 == null) goto L199;
        String r46 = r110.getModeId();
    L200:
        if (r26 == null) goto L206;
        t0 r48 = r26.a;
        if (r48 == null) goto L206;
        Integer r52 = r48.j;
        if (r52 == null) goto L206;
    L233:
        int r53 = r52.intValue();
    L235:
        if (r110 == null) goto L237;
        Integer r410 = r110.getReasoningEffort();
    L238:
        if (r7 != null) goto L241;
        String r411 = null;
    L245:
        if (r7 == null) goto L253;
        PcDevice r118 = r7.c;
        if (r118 == null) goto L253;
        if (Intrinsics.areEqual(r118.r(), Boolean.TRUE) == true) goto L254;
        String r54 = "offline";
    L256:
        tx9.b.e(r33, r37, r112, r42, r43, "", null, r210, "", 0, 0, r114, "", r310, null, null, null, "original", null, null, null, null, "chat", null, null, null, r311, Boolean.valueOf(r45), r36, "click_action_bar_button", r38, r46, Integer.valueOf(r53), r410, r411, r54, r44, 393986112, 0);
    L254:
        r54 = "online";
    L253:
        if (r7 != null) goto L254;
        r54 = null;
        goto L256
    L241:
        if (r7.c == null) goto L243;
        String r119 = "local";
    L244:
        r411 = r119;
        goto L245
    L243:
        r119 = "cloud";
        goto L244
    L237:
        r410 = null;
    L206:
        if (r110 == null) goto L217;
        String r55 = r110.getModeId();
        if (r55 == null) goto L217;
        List<d0> r120 = r50.c.get("mode");
        if (r120 != null) goto L212;
        r120 = CollectionsKt.emptyList();
    L212:
        com.larus.bmhome.chat.nestedmenu.b.a r56 = a(r120, r55);
        if (r56 == null) goto L217;
        t0 r57 = r56.a;
        if (r57 == null) goto L217;
        r52 = r57.j;
    L218:
        if (r52 != null) goto L233;
        if (r12 == null) goto L224;
        b2 r58 = r12.a;
        if (r58 == null) goto L224;
        r52 = r58.l;
    L225:
        if (r52 != null) goto L233;
        if (r13 == null) goto L231;
        b2 r59 = r13.a;
        if (r59 == null) goto L231;
        r52 = r59.l;
    L232:
        if (r52 != null) goto L233;
        r53 = AgentMode.UNKNOWN.getValue();
    L231:
        r52 = null;
    L224:
        r52 = null;
    L217:
        r52 = null;
        goto L218
    L199:
        r46 = null;
    L195:
        r311 = null;
    L190:
        r310 = "";
    L181:
        r210 = "";
        goto L182
    L172:
        if (r26 == null) goto L176;
        r113 = r26.a.b;
        if (r113 != null) goto L180;
    L176:
        if (r13 == null) goto L181;
        r113 = r13.a.b;
        if (r113 != null) goto L180;
    L166:
        r41 = 0;
        goto L167
    L161:
        r112 = null;
        goto L162
    L157:
        r37 = null;
        goto L158
    L154:
        r34 = null;
        goto L155
    L150:
        r33 = null;
        goto L152
    L127:
        if (r7.g == true) goto L146;
        SkillServiceDelegate r121 = SkillServiceDelegate.a;
        bs8.a.a r122 = bs8.a.h;
        if (r31 == null) goto L132;
        String r60 = r31.r;
    L133:
        r122.getClass();
        String r61 = r121.j(bs8.a.a.a(r60));
        if (r61 != null) goto L136;
    L138:
        r61 = null;
    L139:
        PcDevice r123 = r7.c;
        if (r123 == null) goto L142;
        String r124 = r123.getDeviceId();
    L144:
        if (Intrinsics.areEqual(r124, r61) == false) goto L146;
        r32 = "1";
        goto L147
    L142:
        r124 = null;
        goto L144
    L136:
        if ((!StringsKt.isBlank(r61)) == false) goto L138;
    L132:
        r60 = null;
        goto L133
    L124:
        r31 = null;
    L117:
        if (r28 == null) goto L121;
        t1a.b r62 = s1a.a.g(r28);
        if (r62 == null) goto L121;
        r30 = (com.larus.bmhome.chat.component.cvs.y) r62.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
    L121:
        r30 = null;
        goto L122
    L111:
        r28 = null;
    L107:
        r36 = null;
        goto L108
    L100:
        if (Intrinsics.areEqual(r50.b, "model") == false) goto L102;
        r38 = "model";
        goto L103
    L102:
        r38 = null;
    L84:
        r12 = null;
    L85:
        if (r14 == true) goto L95;
        if (r15 == false) goto L95;
        if (r110 == null) goto L94;
        String r63 = r110.getModeId();
        if (r63 == null) goto L94;
        List<d0> r64 = r50.c.get("mode");
        if (r64 != null) goto L93;
        r64 = CollectionsKt.emptyList();
    L93:
        r26 = a(r64, r63);
    L94:
        r26 = null;
        goto L97
    L74:
        r110 = null;
        goto L75
    L54:
        r2 = null;
    L51:
        r23 = null;
        goto L52
    L40:
        r18 = null;
    L55:
        r19 = r11;
        if (r13 == null) goto L61;
        ModelItemIdentity r65 = r13.b;
        List<d0> r66 = r50.c.get("mode");
        if (r66 != null) goto L60;
        r66 = CollectionsKt.emptyList();
    L60:
        r2 = new ReplyOption(r65, d(r66), Integer.valueOf(r13.d));
        goto L67
    L61:
        if (r12 == null) goto L68;
        ModelItemIdentity r67 = r12.b;
        b2 r68 = r12.a;
        String r69 = r68.s;
        u1 r70 = r68.t;
        if (r70 == null) goto L65;
        Integer r71 = r70.b;
    L66:
        r2 = new ReplyOption(r67, r69, r71);
        goto L67
    L65:
        r71 = null;
        goto L66
    L68:
        r110 = null;
        goto L69
    L33:
        r15 = false;
        goto L34
    L30:
        r14 = false;
        goto L31
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
    L258:
        p(r49, r50, false);
        f0 r72 = r50.d.c();
        if ((r72 instanceof di8.p0) == false) goto L261;
        di8.p0 r73 = (di8.p0) r72;
    L262:
        if (r73 != null) goto L265;
    L266:
        boolean r74 = false;
    L287:
        if (r74 == false) goto L289;
        return;
    L289:
        String r75 = r50.b;
        int r76 = r75.hashCode();
        if (r76 == (-1396342996)) goto L459;
        if (r76 == 3357091) goto L392;
        if (r76 == 104069929) goto L297;
    L460:
        return;
    L297:
        if (r75.equals("model") == false) goto L460;
        if (r50.d.getRight().a == true) goto L302;
    L304:
        f0 r77 = r50.d.c();
        if ((r77 instanceof di8.p0) == false) goto L307;
        di8.p0 r78 = (di8.p0) r77;
    L308:
        f0 r79 = r50.d.c();
        if ((r79 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L311;
        com.larus.bmhome.chat.nestedmenu.b r80 = (com.larus.bmhome.chat.nestedmenu.b) r79;
    L312:
        if (r80 != null) goto L322;
        if (r78 == null) goto L315;
        f0 r81 = r78.a;
    L317:
        if ((r81 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L319;
        r80 = (com.larus.bmhome.chat.nestedmenu.b) r81;
    L320:
        if (r80 != null) goto L322;
        return;
    L319:
        r80 = null;
        goto L320
    L315:
        r81 = null;
    L322:
        com.larus.bmhome.chat.nestedmenu.b.c r82 = r80.b;
        if (r82 == null) goto L349;
        List<d0> r83 = r50.c.get("mode");
        if (r83 != null) goto L327;
        r83 = CollectionsKt.emptyList();
    L327:
        String r84 = d(r83);
        r50.f = new ReplyOption(r82.b, r84, Integer.valueOf(r82.d));
        Integer r85 = Integer.valueOf(r82.d);
        ReplyOption r86 = r49.l;
        if (r86 == null) goto L330;
        r47 = r86.getReasoningEffort();
    L330:
        String r87 = r82.b.getKey();
        int r88 = b.a[r49.a.ordinal()];
        if (r88 != 1) goto L333;
        String r89 = "setting";
    L338:
        JSONObject r90 = new JSONObject();
        Intrinsics.checkNotNullParameter(r90, "params");
        if (r85 == null) goto L341;
        r90.put("reasoning_effort", r85.intValue());
    L341:
        if (r47 == null) goto L343;
        r90.put("previous_reasoning_effort", r47.intValue());
    L343:
        if (r87 == null) goto L345;
        r90.put("model_item_key", r87);
    L345:
        if (r84 == null) goto L347;
        r90.put("mode_id", r84);
    L347:
        r90.put("entry_source", r89);
        TrackParams r91 = new TrackParams().merge(r90);
        by7.a r92 = new by7.a("reasoning_effort_switch_click");
        r92.a.merge(r91);
        r92.b();
        r51.invoke();
        return;
    L333:
        if (r88 != 2) goto L336;
        r89 = "action_bar";
        goto L338
    L336:
        throw new NoWhenBranchMatchedException();
    L349:
        com.larus.bmhome.chat.nestedmenu.b.C0068b r93 = r80.a;
        if (r93 == null) goto L460;
        z0 r94 = r49.f;
        if (r94 == null) goto L356;
        p0 r95 = r94.o;
        if (r95 == null) goto L356;
        boolean r96 = Intrinsics.areEqual(r95.k, Boolean.TRUE);
    L357:
        if (r96 == false) goto L373;
        z0 r97 = r49.f;
        if (r97 == null) goto L365;
        p0 r99 = r97.o;
        if (r99 == null) goto L365;
        s0 r100 = r99.j;
        if (r100 == null) goto L365;
        boolean r101 = Intrinsics.areEqual(r100.d, Boolean.TRUE);
    L366:
        if (r101 == false) goto L368;
    L369:
        ReplyOption r102 = r49.l;
        if (r102 == null) goto L372;
        String r103 = r102.getModeId();
    L374:
        String r104 = ObricTaskSkillDelegate.b.e(r49.l, r93.b);
        ModelItemIdentity r105 = r93.b;
        if (r104 == null) goto L378;
        r103 = r104;
    L378:
        u1 r106 = r93.a.t;
        if (r106 == null) goto L381;
        Integer r107 = r106.b;
    L382:
        r50.f = new ReplyOption(r105, r103, r107);
        if (r49.g.a == false) goto L386;
        g(r49, r50, r51);
        return;
    L386:
        if (r78 == null) goto L389;
        h(r49, r78, r51);
        return;
    L389:
        r51.invoke();
        return;
    L381:
        r107 = null;
        goto L382
    L372:
        r103 = null;
        goto L374
    L368:
        if (k() == false) goto L373;
    L365:
        r101 = false;
    L373:
        r103 = r93.a.s;
    L356:
        r96 = false;
        goto L357
    L311:
        r80 = null;
        goto L312
    L307:
        r78 = null;
        goto L308
    L302:
        if (r49.g.a == true) goto L304;
        return;
    L392:
        if (r75.equals(r15) == true) goto L395;
        return;
    L395:
        if (r50.d.getRight().a == true) goto L397;
    L399:
        f0 r108 = r50.d.c();
        if ((r108 instanceof di8.p0) == false) goto L402;
        di8.p0 r109 = (di8.p0) r108;
    L403:
        if (r109 != null) goto L407;
        f0 r125 = r50.d.c();
        if ((r125 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L410;
        com.larus.bmhome.chat.nestedmenu.b r126 = (com.larus.bmhome.chat.nestedmenu.b) r125;
    L411:
        if (r126 == null) goto L457;
        com.larus.bmhome.chat.nestedmenu.b.a r127 = r126.c;
        if (r127 == null) goto L479;
        t0 r128 = r127.a;
        if (r128 == null) goto L480;
        ReplyOption r129 = r49.g.c;
        if (r129 != null) goto L420;
        r129 = r49.l;
    L420:
        String r130 = r128.a;
        if (r129 == null) goto L423;
        String r131 = r129.getModeId();
    L425:
        if (Intrinsics.areEqual(r130, r131) == false) goto L427;
        r50.f = r129;
    L450:
        if (r49.g.a == false) goto L453;
        g(r49, r50, r51);
        return;
    L453:
        if (r109 == null) goto L456;
        h(r49, r109, r51);
        return;
    L456:
        r51.invoke();
        return;
    L427:
        ObricTaskSkillDelegate r132 = ObricTaskSkillDelegate.b;
        ReplyOption r133 = r49.l;
        if (r133 == null) goto L430;
        ModelItemIdentity r134 = r133.getModel();
    L431:
        ModelItemIdentity r135 = r132.g(r134, r128);
        if (r135 != null) goto L439;
        o1 r136 = r128.m;
        if (r136 == null) goto L436;
        r135 = r136.a();
    L437:
        if (r135 != null) goto L439;
        return;
    L436:
        r135 = null;
    L439:
        List<d0> r137 = r50.c.get(r12);
        if (r137 != null) goto L442;
        r137 = CollectionsKt.emptyList();
    L442:
        b2 r138 = b(r137, r135);
        if (r138 == null) goto L447;
        u1 r139 = r138.t;
        if (r139 == null) goto L447;
        Integer r140 = r139.b;
    L448:
        r50.f = new ReplyOption(r135, r128.a, r140);
    L447:
        r140 = null;
        goto L448
    L430:
        r134 = null;
        goto L431
    L423:
        r131 = null;
        goto L425
    L480:
        return;
    L479:
        return;
    L457:
        return;
    L410:
        r126 = null;
        goto L411
    L407:
        f0 r141 = r109.a;
        if ((r141 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L410;
        r126 = (com.larus.bmhome.chat.nestedmenu.b) r141;
        goto L411
    L402:
        r109 = null;
        goto L403
    L397:
        if (r49.g.a == true) goto L399;
        return;
    L459:
        if (r75.equals("banner") == false) goto L482;
        f0 r142 = r50.d.c();
        if ((r142 instanceof i) == false) goto L464;
        i r143 = (i) r142;
    L465:
        if (r143 != null) goto L467;
        return;
    L467:
        int r144 = gi8.c.a;
        Intrinsics.checkNotNullParameter(r143, "item");
        gi8.c.a(r143, true);
        String r145 = r143.e();
        if (r145 != null) goto L470;
        return;
    L470:
        if ((true ^ StringsKt.isBlank(r145)) == true) goto L473;
        r145 = null;
    L473:
        if (r145 == null) goto L485;
        int r146 = n3.a;
        n3.a(r49.c.getContext(), r145);
        return;
    L485:
        return;
    L464:
        r143 = null;
        goto L465
    L482:
        return;
    L265:
        if (r73.g == false) goto L266;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L269
        Object r148 = Result.constructor-impl(CompatKt.findFragment(r49.c));     // Catch: Throwable -> L269
    L272:
        if (Result.isFailure-impl(r148) == false) goto L274;
        r148 = null;
    L274:
        Fragment r149 = (Fragment) r148;
        IFlowSdkDepend r150 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r150 == null) goto L277;
        r150.P();
        Fragment r151 = ChatServiceImpl.a.f();
    L278:
        if (r149 != null) goto L280;
        r149 = r151;
    L280:
        IPcDevicePanelService r152 = (IPcDevicePanelService) ServiceManager.get().getService(IPcDevicePanelService.class);
        if (r149 == null) goto L285;
        if (r152 == null) goto L285;
        r152.c(r149);
    L286:
        r74 = true;
    L285:
        FLogger.a.w("NestMenuServiceImpl", "[handleConnectGuideClick] guide host or panel service unavailable");
        goto L286
    L277:
        r151 = null;
    L269:
        th = move-exception;
        Result.Companion r153 = Result.Companion;
        r148 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L272
    L261:
        r73 = null;
        goto L262
    }

    /* JADX WARN: Type inference failed for: r2v15, types: [di8.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19, types: [di8.i, java.lang.Object] */
    public final boolean n(String r18, final Function0 r19, final Function0 r20) {
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L163;
        r2.P();
        final Fragment r8 = ChatServiceImpl.a.f();
        if (r8 == null) goto L163;
        View r3 = r8.getView();
        if (r3 == null) goto L163;
        OfficeTaskDeviceSwitchDialogFragment r5 = null;
        if (r3.isAttachedToWindow() == false) goto L12;
        final View r7 = r3;
    L13:
        if (r7 == null) goto L163;
        t1a.b r4 = s1a.a.g(r8);
        com.larus.bmhome.chat.component.cvs.y r6 = r4.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r6 == null) goto L20;
        wc9.e r9 = r6.h();
        if (r9 == null) goto L20;
        String r10 = r9.a;
    L22:
        if (Intrinsics.areEqual(r10, r18) == true) goto L24;
        return false;
    L24:
        final be8.a r11 = r4.getAbility(be8.a.class);
        if (r11 != null) goto L27;
        return false;
    L27:
        String r12 = r11.dC();
        if (r12 == null) goto L163;
        if ((!StringsKt.isBlank(r12)) == true) goto L33;
        r12 = null;
    L33:
        if (r12 == null) goto L163;
        com.larus.bmhome.instruction.g r13 = r4.getAbility(com.larus.bmhome.instruction.g.class);
        if (r13 == null) goto L38;
        z0 r14 = r13.un(ActiveSwitchType.DEEPTHINK, null);
    L39:
        if (r14 != null) goto L41;
        return false;
    L41:
        List r15 = f.e(r7, r14);
        Iterator r16 = r15.iterator();
    L43:
        if (r16.hasNext() == false) goto L57;
        Object r17 = r16.next();
        f0 r110 = ((d0) r17).c();
        if ((r110 instanceof di8.p0) == false) goto L47;
        di8.p0 r111 = (di8.p0) r110;
    L48:
        if (r111 == null) goto L50;
        PcDevice r112 = r111.c;
    L51:
        if (r112 == null) goto L53;
        String r113 = r112.getDeviceId();
    L55:
        if (Intrinsics.areEqual(r113, r12) == false) goto L43;
    L58:
        d0 r114 = (d0) r17;
        if (r114 == null) goto L61;
        f0 r115 = r114.c();
    L63:
        if ((r115 instanceof di8.p0) == false) goto L65;
        di8.p0 r116 = (di8.p0) r115;
    L66:
        if (r116 == null) goto L68;
        PcDevice r117 = r116.c;
    L69:
        if (r117 != null) goto L94;
        List<ei8.c> r118 = f.a;
        Intrinsics.checkNotNullParameter(r7, "hostView");
        Intrinsics.checkNotNullParameter(r14, "actionBarItem");
        fi8.a r119 = f.b;
        Context r120 = r7.getContext();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r120, "context");
        Iterator r21 = ((ArrayList) fi8.a.g(r120, com.larus.bmhome.chat.nestedmenu.a.a(r14, null).a, false, null)).iterator();
    L72:
        if (r21.hasNext() == false) goto L91;
        Object r121 = r21.next();
        f0 r122 = ((d0) r121).c();
        if ((r122 instanceof com.larus.bmhome.chat.nestedmenu.b) == false) goto L76;
        com.larus.bmhome.chat.nestedmenu.b r123 = (com.larus.bmhome.chat.nestedmenu.b) r122;
    L77:
        if (r123 == null) goto L88;
        com.larus.bmhome.chat.nestedmenu.b.a r124 = r123.c;
        if (r124 == null) goto L88;
        t0 r125 = r124.a;
        if (r125 == null) goto L88;
        Integer r126 = r125.j;
        int r127 = AgentMode.MOA.getValue();
        if (r126 == null) goto L88;
        if (r126.intValue() != r127) goto L88;
        boolean r128 = true;
    L89:
        if (r128 == false) goto L72;
    L92:
        r114 = (d0) r121;
    L97:
        if (r114 != null) goto L99;
        return false;
    L99:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r15.iterator();
    L101:
        if (r23.hasNext() == false) goto L118;
        Object r129 = r23.next();
        f0 r130 = ((d0) r129).c();
        if ((r130 instanceof di8.p0) == false) goto L105;
        di8.p0 r131 = (di8.p0) r130;
    L106:
        if (r131 == null) goto L108;
        PcDevice r132 = r131.c;
    L109:
        if (r132 != null) goto L111;
    L115:
        boolean r133 = false;
    L116:
        if (r133 == false) goto L101;
        r22.add(r129);
        goto L101
    L111:
        if (Intrinsics.areEqual(r132.getDeviceId(), r12) == true) goto L115;
        if (SetsKt.setOf(new PcDeviceUiState[]{PcDeviceUiState.AUTHORIZED_AVAILABLE, PcDeviceUiState.UNAUTHORIZED_AVAILABLE}).contains(bs8.g.b(r132)) == false) goto L115;
        r133 = true;
        goto L116
    L108:
        r132 = null;
        goto L109
    L105:
        r131 = null;
        goto L106
    L118:
        FragmentManager r134 = r8.getChildFragmentManager();
        if (r134.isStateSaved() == false) goto L121;
        return false;
    L121:
        Fragment r24 = r134.findFragmentByTag("OfficeTaskDeviceSwitchDialogFragment");
        if ((r24 instanceof OfficeTaskDeviceSwitchDialogFragment) == false) goto L124;
        r5 = (OfficeTaskDeviceSwitchDialogFragment) r24;
    L124:
        final OfficeTaskDeviceSwitchDialogFragment r135 = r5;
        if (r135 == null) goto L134;
        Intrinsics.checkNotNullParameter(r114, "taskModeModel");
        Intrinsics.checkNotNullParameter(r22, "localTaskModels");
        r135.h = r114;
        r135.i = r22;
        if (r135.getView() == null) goto L129;
        r135.T90();
    L129:
        Function1<? super PcDevice, Unit> r25 = new h(r135, this, r7, r8, r11);
        Intrinsics.checkNotNullParameter(r25, "listener");
        r135.d = r25;
        ?? r26 = new di8.i(r19, r20);
        Intrinsics.checkNotNullParameter(r26, "listener");
        Boolean r0 = r135.f;
        if (r0 != null) goto L132;
        ((ArrayList) r135.e).add(r26);
    L133:
        return true;
    L132:
        r26.invoke(r0);
        goto L133
    L134:
        int r136 = OfficeTaskDeviceSwitchDialogFragment.k;
        if (r117 == null) goto L138;
        String r137 = r117.d();
        if (r137 == null) goto L138;
    L141:
        Intrinsics.checkNotNullParameter(r12, "offlineDeviceId");
        Intrinsics.checkNotNullParameter(r137, "offlineDeviceName");
        Intrinsics.checkNotNullParameter(r114, "taskModeModel");
        Intrinsics.checkNotNullParameter(r22, "localTaskModels");
        final OfficeTaskDeviceSwitchDialogFragment r138 = new OfficeTaskDeviceSwitchDialogFragment();
        Bundle r139 = new Bundle();
        r139.putString("offline_device_id", r12);
        r139.putString("offline_device_name", r137);
        r138.setArguments(r139);
        Intrinsics.checkNotNullParameter(r114, "taskModeModel");
        Intrinsics.checkNotNullParameter(r22, "localTaskModels");
        r138.h = r114;
        r138.i = r22;
        if (r138.getView() == null) goto L144;
        r138.T90();
    L144:
        Function1<? super PcDevice, Unit> r27 = new h(r138, this, r7, r8, r11);
        Intrinsics.checkNotNullParameter(r27, "listener");
        r138.d = r27;
        ?? r28 = new di8.i(r19, r20);
        Intrinsics.checkNotNullParameter(r28, "listener");
        Boolean r1 = r138.f;
        if (r1 != null) goto L147;
        ((ArrayList) r138.e).add(r28);
    L165:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L155
        LandscapeRestrictionOperation r30 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Throwable -> L155
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r138, "OfficeTaskDeviceSwitchDialogFragment", r30);     // Catch: Throwable -> L155
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r134, r138, r30) == false) goto L167;
    L153:
        Object r31 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L155
    L157:
        Throwable r32 = Result.exceptionOrNull-impl(r31);
        if (r32 == null) goto L162;
        FLogger.a.w("NestMenuServiceImpl", "[showOfflineOfficeTaskDeviceDialog] show failed", r32);
        r31 = Boolean.FALSE;
    L162:
        return ((Boolean) r31).booleanValue();
    L167:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L164 Throwable -> L155
    L152:
        r138.showNow(r134, "OfficeTaskDeviceSwitchDialogFragment");     // Catch: Throwable -> L155
    L155:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L157
    L147:
        r28.invoke(r1);
    L138:
        r137 = r11.nF();
        if (r137 != null) goto L141;
        r137 = "";
    L88:
        r128 = false;
        goto L89
    L76:
        r123 = null;
        goto L77
    L91:
        r121 = null;
        goto L92
    L94:
        if (bs8.g.b(r117) == PcDeviceUiState.OFFLINE) goto L97;
        r114 = null;
        goto L97
    L68:
        r117 = null;
        goto L69
    L65:
        r116 = null;
        goto L66
    L61:
        r115 = null;
        goto L63
    L53:
        r113 = null;
        goto L55
    L50:
        r112 = null;
        goto L51
    L47:
        r111 = null;
        goto L48
    L57:
        r17 = null;
        goto L58
    L38:
        r14 = null;
    L20:
        r10 = null;
        goto L22
    L12:
        r7 = null;
    L163:
        return false;
    }

    public static String i(int r6, c0 r7, PcDevice r8, String r9) {
        t1a.b r0 = r7.m;
        String r1 = null;
        if (r0 == null) goto L104;
        be8.a r2 = (be8.a) r0.getAbility(be8.a.class);
        if (r2 == null) goto L104;
    L30:
        if (r2 == null) goto L32;
        be8.e r10 = r2.getSelectedFolder();
    L102:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L39
        if (r9 != null) goto L36;
        String r4 = "";
    L37:
        Object r5 = Result.constructor-impl(new JSONObject(r4));     // Catch: Throwable -> L39
    L41:
        JSONObject r11 = new JSONObject();
        if (Result.isFailure-impl(r5) == false) goto L44;
        r5 = r11;
    L44:
        JSONObject r12 = ((JSONObject) r5).put("runtime_type", r6);
        if (r8 != null) goto L48;
        r12.remove("local_device_id");
        r12.remove("device_name");
    L48:
        if (r8 == null) goto L57;
        String r13 = r8.getDeviceId();
        if (r13 == null) goto L57;
        if ((!StringsKt.isBlank(r13)) == true) goto L55;
        r13 = null;
    L55:
        if (r13 == null) goto L57;
        r12.put("local_device_id", r13);
    L57:
        if (r8 == null) goto L67;
        String r14 = r8.d();
        if (r14 == null) goto L67;
        if ((!StringsKt.isBlank(r14)) == true) goto L64;
        r14 = null;
    L64:
        if (r14 == null) goto L67;
        if (r12.put("device_name", r14) == null) goto L67;
    L76:
        if (r9 != null) goto L78;
    L81:
        boolean r15 = true;
    L82:
        if (r15 == false) goto L101;
        if (r10 == null) goto L92;
        String r16 = r10.a;
        if (r16 == null) goto L92;
        if ((!StringsKt.isBlank(r16)) == true) goto L90;
        r16 = null;
    L90:
        if (r16 == null) goto L92;
        r12.put("folder_name", r16);
    L92:
        if (r10 == null) goto L101;
        String r17 = r10.b;
        if (r17 == null) goto L101;
        if ((!StringsKt.isBlank(r17)) == false) goto L98;
        r1 = r17;
    L98:
        if (r1 == null) goto L101;
        r12.put("workspace", r1);
    L101:
        return r12.toString();
    L78:
        if (StringsKt.isBlank(r9) == true) goto L81;
        r15 = false;
    L67:
        if (r8 == null) goto L76;
        String r18 = r8.getDeviceId();
        if (r18 == null) goto L76;
        if ((!StringsKt.isBlank(r18)) == true) goto L74;
        r18 = null;
    L74:
        if (r18 == null) goto L76;
        r12.put("device_name", r18);
        goto L76
    L36:
        r4 = r9;
    L39:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L32:
        r10 = null;
    L104:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L9
        Object r21 = Result.constructor-impl(CompatKt.findFragment(r7.c));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r21) == false) goto L14;
        r21 = null;
    L14:
        Fragment r22 = (Fragment) r21;
        if (r22 == null) goto L22;
        t1a.b r23 = s1a.a.g(r22);
        if (r23 == null) goto L22;
        be8.a r24 = (be8.a) r23.getAbility(be8.a.class);
        if (r24 == null) goto L22;
    L21:
        r2 = r24;
    L22:
        IFlowSdkDepend r25 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r25 == null) goto L29;
        r25.P();
        Fragment r26 = ChatServiceImpl.a.f();
        if (r26 == null) goto L29;
        t1a.b r27 = s1a.a.g(r26);
        if (r27 == null) goto L29;
        r24 = (be8.a) r27.getAbility(be8.a.class);
    L29:
        r2 = null;
    L9:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final LinkedHashMap R8(NestedMenuScene r16, z0 r17, ReplyOption r18, View r19) {
        Intrinsics.checkNotNullParameter(r16, "scene");
        Intrinsics.checkNotNullParameter(r19, "hostView");
        View r5 = new View(AppHost.a.getApplication());
        return f.d(new c0(r16, "", r19, r5, r5, r17, null, new w(), null, null, r18, null, 5824));
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final void S8(final String r8, final Collection<String> r9, final Function0<Unit> r10, final Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r8, "conversationId");
        Intrinsics.checkNotNullParameter(r9, "localMessageIds");
        Intrinsics.checkNotNullParameter(r10, "onContinue");
        Intrinsics.checkNotNullParameter(r11, "onCancel");
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == true) goto L7;
        r10.invoke();
        return;
    L7:
        if (a.a() == true) goto L11;
        y.c(new t(this, r8, r9, r10, r11));
        return;
    L11:
        if (n(r8, r10, r11) == true) goto L14;
        r10.invoke();
        return;
    }

    @Override // com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService
    public final boolean T8(NestedMenuScene r49, String r50, View r51, View r52, View r53, z0 r54, o0 r55, ReplyOption r56, t1a.b r57, Function1<? super com.larus.bmhome.chat.nestedmenu.c, Unit> r58, Function1<? super com.larus.bmhome.chat.nestedmenu.c, Unit> r59) {
        String r7 = "scene";
        Intrinsics.checkNotNullParameter(r49, "scene");
        String r6 = "hostView";
        Intrinsics.checkNotNullParameter(r51, "hostView");
        Intrinsics.checkNotNullParameter(r52, "sourceView");
        Intrinsics.checkNotNullParameter(r53, "popupHostView");
        Intrinsics.checkNotNullParameter(r55, "uiConfig");
        Intrinsics.checkNotNullParameter(r59, "onClick");
        if (Intrinsics.areEqual(r50, "fork_conv") == true) goto L5;
    L8:
        if (r56 != null) goto L10;
        ReplyOption r17 = f(r54);
    L12:
        if (r49 == NestedMenuScene.SETTINGS) goto L14;
    L17:
        boolean r19 = true;
    L18:
        boolean r20 = !r55.f;
        if (r55.a == false) goto L199;
        Map<String, String> r15 = r55.e;
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L23;
        r0.P();
        Fragment r1 = ChatServiceImpl.a.f();
    L24:
        if (r1 == null) goto L30;
        t1a.b r2 = s1a.a.g(r1);
        if (r2 == null) goto L30;
        com.larus.bmhome.chat.component.cvs.y r3 = r2.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r3 == null) goto L30;
        wc9.e r4 = r3.h();
    L31:
        if (r19 == true) goto L326;
    L65:
        String r23 = "sourceView";
    L83:
        String r24 = "hostView";
        String r25 = "scene";
        ReplyOption r5 = r17;
    L198:
        ReplyOption r8 = r5;
    L201:
        if (r55.a == false) goto L295;
        Map<String, String> r9 = r55.e;
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L205;
        r10.P();
        Fragment r11 = ChatServiceImpl.a.f();
    L206:
        if (r11 == null) goto L212;
        t1a.b r12 = s1a.a.g(r11);
        if (r12 == null) goto L212;
        com.larus.bmhome.chat.component.cvs.y r13 = r12.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r13 == null) goto L212;
        wc9.e r14 = r13.h();
    L328:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L221
        if (r14 == null) goto L216;
        String r18 = r14.r;     // Catch: Throwable -> L221
    L217:
        if (r18 != null) goto L219;
        r18 = "";
    L219:
        Object r21 = Result.constructor-impl(new JSONObject(r18));     // Catch: Throwable -> L221
    L223:
        JSONObject r22 = new JSONObject();
        if (Result.isFailure-impl(r21) == false) goto L226;
        r21 = r22;
    L226:
        JSONObject r26 = (JSONObject) r21;
        String r27 = r9.get("agent_task_param");
        if (r27 == null) goto L231;
        boolean r28 = true;
        if ((!StringsKt.isBlank(r27)) == true) goto L233;
    L232:
        r27 = null;
    L233:
        if (r19 == true) goto L237;
        r27 = r26.optString("agent_task_param");
        Intrinsics.checkNotNull(r27);
        if ((StringsKt.isBlank(r27) ^ r28) == true) goto L243;
    L242:
        r27 = null;
    L243:
        if (r27 == null) goto L245;
        bs8.a.a r29 = bs8.a.h;
        String r30 = new JSONObject().put("agent_task_param", r27).toString();
        r29.getClass();
        bs8.a r31 = bs8.a.a.a(r30);
    L246:
        if (r31 == null) goto L250;
        boolean r32 = true;
        if (r31.b() != true) goto L251;
        boolean r210 = true;
    L252:
        if (r210 == true) goto L266;
        if (r31 != null) goto L255;
    L257:
        boolean r33 = false;
    L258:
        if (r33 == true) goto L266;
        IActionBarService r34 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r34 != null) goto L263;
    L265:
        boolean r35 = false;
    L267:
        if (r54 == null) goto L269;
        p0 r36 = r54.o;
    L270:
        if (r36 == null) goto L272;
        boolean r37 = Intrinsics.areEqual(r36.n, Boolean.TRUE);
    L273:
        if (r37 == false) goto L288;
        if (Intrinsics.areEqual(r36.k, Boolean.TRUE) == false) goto L288;
        s0 r38 = r36.j;
        if (r38 == null) goto L281;
        u0 r39 = r38.a;
        if (r39 == null) goto L281;
        List r40 = r39.a;
    L282:
        if (r40 != null) goto L285;
        r40 = CollectionsKt.emptyList();
    L285:
        if ((!r40.isEmpty()) == false) goto L288;
        boolean r41 = true;
    L290:
        if (r55.d == false) goto L293;
        if (r41 == false) goto L293;
        boolean r42 = true;
    L294:
        boolean r110 = false;
        c0 r111 = null;
        boolean r112 = true;
        o0 r43 = o0.a(r55, r35, r8, r42, null, false, 33554417);
    L296:
        String r113 = r23;
        String r114 = r24;
        String r211 = r25;
        final c0 r44 = new c0(r49, r50, r51, r52, r53, r54, r43, r59, r58, r43.w, r17, r57, 128);
        if ((!r44.g.g.isEmpty()) == false) goto L302;
        o0 r45 = r44.g;
        if (r45.i == true) goto L302;
        Map<String, String> r46 = r45.g;
        Map r47 = h0.a;
        Intrinsics.checkNotNullParameter(r46, "baseParams");
        h0.b("fork_entry_click", h0.e(r46));
    L302:
        if (r44.c.isAttachedToWindow() == true) goto L304;
    L309:
        FLogger.a.i("NestMenuServiceImpl", "Anchor view is not attached");
        boolean r115 = false;
    L310:
        if (r115 == true) goto L312;
        return r110;
    L312:
        final Ref.ObjectRef r48 = new Ref.ObjectRef();
        Function1 r60 = new p(this, r48, r44);
        Function1 r61 = new di8.q(this, r48, r44);
        NestedMenuScene r62 = r44.a;
        String r63 = r44.b;
        View r64 = r44.c;
        View r65 = r44.d;
        View r66 = r44.e;
        z0 r116 = r44.f;
        o0 r117 = r44.g;
        List<String> r118 = r44.h;
        Function0<Unit> r119 = r44.k;
        ReplyOption r120 = r44.l;
        t1a.b r67 = r44.m;
        Intrinsics.checkNotNullParameter(r62, r211);
        Intrinsics.checkNotNullParameter(r64, r114);
        Intrinsics.checkNotNullParameter(r65, r113);
        Intrinsics.checkNotNullParameter(r66, "popupHostView");
        Intrinsics.checkNotNullParameter(r117, "uiConfig");
        Intrinsics.checkNotNullParameter(r118, "sectionOrder");
        Intrinsics.checkNotNullParameter(r60, "onClick");
        r48.element = new c0(r62, r63, r64, r65, r66, r116, r117, r118, r60, r61, r119, r120, r67);
        if (a.a() == true) goto L320;
        Object r68 = r48.element;
        if (r68 != null) goto L317;
        Intrinsics.throwUninitializedPropertyAccessException("wrappedConfig");
        c0 r121 = r111;
    L318:
        r121.c.post(new di8.r(this, r48));
        return r112;
    L317:
        r121 = (c0) r68;
        goto L318
    L320:
        Object r69 = r48.element;
        if (r69 != null) goto L323;
        Intrinsics.throwUninitializedPropertyAccessException("wrappedConfig");
        c0 r122 = r111;
    L325:
        return m(r122);
    L323:
        r122 = (c0) r69;
        goto L325
    L304:
        if (r44.d.isAttachedToWindow() == false) goto L309;
        if (r44.e.isAttachedToWindow() == false) goto L309;
        r115 = true;
    L293:
        r42 = false;
    L281:
        r40 = null;
    L288:
        r41 = false;
        goto L290
    L272:
        r37 = false;
        goto L273
    L269:
        r36 = null;
        goto L270
    L263:
        if (r34.m(r8) != true) goto L265;
    L255:
        if (r31.c() != r32) goto L257;
        r33 = true;
    L266:
        r35 = true;
    L251:
        r210 = false;
        goto L252
    L250:
        r32 = true;
        goto L251
    L245:
        r31 = null;
        goto L246
    L237:
        if (r27 != null) goto L243;
        if (r20 == false) goto L242;
        r27 = r26.optString("agent_task_param");
        Intrinsics.checkNotNull(r27);
        if ((StringsKt.isBlank(r27) ^ r28) == false) goto L242;
    L231:
        r28 = true;
        goto L232
    L216:
        r18 = null;
    L221:
        th = move-exception;
        Result.Companion r70 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L212:
        r14 = null;
        goto L328
    L205:
        r11 = null;
        goto L206
    L295:
        r111 = null;
        r112 = true;
        r110 = false;
        r43 = r55;
        goto L296
    L326:
        Result.Companion r71 = Result.Companion;     // Catch: Throwable -> L41
        if (r4 == null) goto L36;
        String r72 = r4.r;     // Catch: Throwable -> L41
    L37:
        if (r72 != null) goto L39;
        r72 = "";
    L39:
        Object r73 = Result.constructor-impl(new JSONObject(r72));     // Catch: Throwable -> L41
    L43:
        JSONObject r74 = new JSONObject();
        if (Result.isFailure-impl(r73) == false) goto L46;
        r73 = r74;
    L46:
        JSONObject r75 = (JSONObject) r73;
        String r212 = r15.get("reply_mode");
        if (r212 == null) goto L52;
        if ((!StringsKt.isBlank(r212)) == false) goto L52;
    L53:
        if (r19 == true) goto L57;
        String r76 = r75.optString("reply_mode");
        Intrinsics.checkNotNull(r76);
        if ((!StringsKt.isBlank(r76)) == false) goto L62;
    L56:
        r212 = r76;
    L63:
        String r77 = r212;
    L64:
        if (r77 == null) goto L65;
        r23 = "sourceView";
        di8.a r78 = com.larus.bmhome.chat.nestedmenu.a.a(r54, null);
        Iterator<T> r123 = r78.c.iterator();
    L68:
        if (r123.hasNext() == false) goto L77;
        Object r213 = r123.next();
        ModelItemIdentity r214 = ((b2) r213).b();
        if (r214 == null) goto L72;
        String r79 = r214.getKey();
    L74:
        if (Intrinsics.areEqual(r79, r77) == false) goto L68;
    L78:
        b2 r80 = (b2) r213;
        if (r80 == null) goto L83;
        ModelItemIdentity r81 = r80.b();
        if (r81 == null) goto L83;
        String r124 = r15.get("agent_task_param");
        if (r124 == null) goto L90;
        if ((!StringsKt.isBlank(r124)) == false) goto L90;
    L91:
        if (r19 == true) goto L95;
        r124 = r75.optString("agent_task_param");
        Intrinsics.checkNotNull(r124);
        if ((!StringsKt.isBlank(r124)) == true) goto L101;
    L100:
        r124 = null;
    L101:
        if (r124 == null) goto L103;
        bs8.a.a r82 = bs8.a.h;
        String r125 = new JSONObject().put("agent_task_param", r124).toString();
        r82.getClass();
        bs8.a r83 = bs8.a.a.a(r125);
    L104:
        if (r83 == null) goto L108;
        boolean r126 = true;
        if (r83.b() != true) goto L109;
        boolean r215 = true;
    L110:
        if (r215 == true) goto L119;
        if (r83 != null) goto L113;
    L115:
        boolean r84 = false;
    L116:
        if (r84 == true) goto L119;
        int r85 = AgentMode.CHAT.getValue();
    L120:
        if (r54 == null) goto L124;
        p0 r127 = r54.o;
        if (r127 == null) goto L124;
        boolean r128 = Intrinsics.areEqual(r127.k, Boolean.TRUE);
    L125:
        if (r128 == false) goto L187;
        List<t0> r129 = r78.a;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L128:
        if (r131.hasNext() == false) goto L139;
        String r216 = r6;
        Object r86 = r131.next();
        String r217 = r7;
        Integer r87 = ((t0) r86).j;
        if (r87 != null) goto L133;
    L135:
        boolean r88 = false;
    L136:
        if (r88 == false) goto L138;
        r130.add(r86);
    L138:
        r6 = r216;
        r7 = r217;
        goto L128
    L133:
        if (r87.intValue() != r85) goto L135;
        r88 = true;
        goto L136
    L139:
        r24 = r6;
        r25 = r7;
        Iterator r89 = r130.iterator();
    L141:
        if (r89.hasNext() == false) goto L170;
        Object r90 = r89.next();
        t0 r132 = (t0) r90;
        List<o1> r133 = r132.n;
        if (r133 != null) goto L145;
        r133 = CollectionsKt.emptyList();
    L145:
        List<o1> r134 = r133;
        Iterator r218 = r89;
        if ((r134 instanceof Collection) == true) goto L148;
    L150:
        Iterator<T> r91 = r134.iterator();
    L152:
        if (r91.hasNext() == false) goto L156;
        if (Intrinsics.areEqual(((o1) r91.next()).a(), r81) == false) goto L152;
        boolean r92 = true;
    L157:
        if (r92 == true) goto L166;
        o1 r93 = r132.m;
        if (r93 == null) goto L161;
        ModelItemIdentity r94 = r93.a();
    L163:
        if (Intrinsics.areEqual(r94, r81) == true) goto L166;
        boolean r95 = false;
    L167:
        if (r95 == true) goto L171;
        r89 = r218;
    L171:
        t0 r96 = (t0) r90;
        if (r96 != null) goto L189;
        Iterator<T> r97 = r78.a.iterator();
    L175:
        if (r97.hasNext() == false) goto L185;
        Object r99 = r97.next();
        Integer r100 = ((t0) r99).j;
        if (r100 != null) goto L180;
    L182:
        boolean r101 = false;
    L183:
        if (r101 == false) goto L175;
    L186:
        r96 = (t0) r99;
        goto L189
    L180:
        if (r100.intValue() != r85) goto L182;
        r101 = true;
        goto L183
    L185:
        r99 = null;
    L189:
        if (r96 == null) goto L192;
        String r102 = r96.a;
        if (r102 == null) goto L192;
    L193:
        u1 r103 = r80.t;
        if (r103 == null) goto L196;
        Integer r104 = r103.b;
    L197:
        r5 = new ReplyOption(r81, r102, r104);
        goto L198
    L196:
        r104 = null;
    L192:
        r102 = r80.s;
        goto L193
    L161:
        r94 = null;
    L166:
        r95 = true;
    L156:
        r92 = false;
        goto L157
    L148:
        if (r134.isEmpty() == false) goto L150;
    L170:
        r90 = null;
        goto L171
    L187:
        r24 = "hostView";
        r25 = "scene";
        r96 = null;
    L124:
        r128 = false;
        goto L125
    L113:
        if (r83.c() != r126) goto L115;
        r84 = true;
    L119:
        r85 = AgentMode.MOA.getValue();
    L109:
        r215 = false;
        goto L110
    L108:
        r126 = true;
        goto L109
    L103:
        r83 = null;
        goto L104
    L95:
        if (r124 != null) goto L101;
        if (r20 == false) goto L100;
        r124 = r75.optString("agent_task_param");
        Intrinsics.checkNotNull(r124);
        if ((!StringsKt.isBlank(r124)) == false) goto L100;
    L90:
        r124 = null;
        goto L91
    L72:
        r79 = null;
        goto L74
    L77:
        r213 = null;
    L62:
        r77 = null;
        goto L64
    L57:
        if (r212 != null) goto L63;
        if (r20 == false) goto L62;
        r76 = r75.optString("reply_mode");
        Intrinsics.checkNotNull(r76);
        if ((!StringsKt.isBlank(r76)) == false) goto L62;
    L52:
        r212 = null;
        goto L53
    L36:
        r72 = null;
    L41:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r73 = Result.constructor-impl(ResultKt.createFailure(th));
    L30:
        r4 = null;
        goto L31
    L23:
        r1 = null;
        goto L24
    L199:
        r23 = "sourceView";
        r24 = "hostView";
        r25 = "scene";
        r8 = r17;
        goto L201
    L14:
        if (r55.f == true) goto L17;
        r19 = false;
        goto L18
    L10:
        r17 = r56;
        goto L12
    L5:
        if (z2.a.J3() == true) goto L8;
        FLogger.a.d("NestMenuServiceImpl", "conversation fork menu blocked: settings disabled");
        s r106 = s.a;
        Context r107 = r51.getContext();
        r106.getClass();
        s.b(r107, 2131905626, false);
        return false;
    }
}
