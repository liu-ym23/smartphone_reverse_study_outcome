package com.larus.business.floatchat.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.b0;
import com.larus.bmhome.chat.g4;
import com.larus.bmhome.chat.input.ChatInputPlaceholderMode;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.chat.ChatTitleBarIcon;
import com.larus.office.plugins.inputv2.coordinator.runtime.integration.OfficeChatIntegrationCoordinator;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import dw8.r;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.i5;
import va8.i;
import va8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0093\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u000347:\u0018\u0000 ¥\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004¥\u0001¦\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020=H\u0016J&\u0010A\u001a\u0004\u0018\u00010\u000f2\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020\r2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u00020GH\u0016J\b\u0010L\u001a\u00020=H\u0016J\b\u0010M\u001a\u00020=H\u0016J\b\u0010N\u001a\u00020=H\u0016J\u0014\u0010O\u001a\u00020=2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010Q\u001a\u00020G2\b\u0010P\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010R\u001a\u00020=2\u0006\u0010S\u001a\u00020\u0001H\u0002J\u0012\u0010T\u001a\u00020=2\b\u0010S\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010U\u001a\u00020=2\u0006\u0010S\u001a\u00020\u0001H\u0002J\u0010\u0010V\u001a\u00020=2\u0006\u0010S\u001a\u00020\u0001H\u0002J\u0010\u0010W\u001a\u00020=2\u0006\u0010X\u001a\u000202H\u0002J\u0018\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020,2\u0006\u0010X\u001a\u000202H\u0002J\u0010\u0010[\u001a\u00020=2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020=2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020=2\u0006\u0010b\u001a\u00020\tH\u0016J'\u0010c\u001a\u0004\u0018\u0001Hd\"\b\b\u0000\u0010d*\u00020e2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002Hd0gH\u0016¢\u0006\u0002\u0010hJ'\u0010i\u001a\u0004\u0018\u0001Hd\"\b\b\u0000\u0010d*\u00020j2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002Hd0gH\u0016¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u00020=2\u0006\u0010Z\u001a\u00020,H\u0016J\u0010\u0010m\u001a\u00020=2\u0006\u0010Z\u001a\u00020,H\u0016J\u0012\u0010n\u001a\u00020=2\b\u0010o\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010p\u001a\u00020=2\u0006\u0010X\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020=2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010s\u001a\u00020\u001cH\u0002J\u0018\u0010t\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\r2\u0006\u0010u\u001a\u00020vH\u0002J\u0010\u0010w\u001a\u00020\u001c2\u0006\u0010u\u001a\u00020vH\u0002J\b\u0010x\u001a\u00020=H\u0002J\u0010\u0010y\u001a\u00020=2\u0006\u0010z\u001a\u00020&H\u0016J\u0010\u0010{\u001a\u00020=2\u0006\u0010z\u001a\u00020&H\u0016J\u0012\u0010|\u001a\u00020=2\b\u0010}\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010~\u001a\u00020=2\u001a\u0010\u007f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001eH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020=2\u0006\u0010P\u001a\u00020 H\u0016J\u001b\u0010\u0081\u0001\u001a\u00020=2\u0007\u0010\u0082\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u00020\u001cH\u0016J\u0012\u0010\u0084\u0001\u001a\u00020=2\u0007\u0010\u0082\u0001\u001a\u00020\u001cH\u0002J\t\u0010\u0085\u0001\u001a\u00020=H\u0002J\t\u0010\u0086\u0001\u001a\u00020=H\u0016J\t\u0010\u0087\u0001\u001a\u00020=H\u0016J\u0011\u0010\u0088\u0001\u001a\u00020=2\u0006\u0010X\u001a\u00020qH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020=2\u0007\u0010\u008a\u0001\u001a\u00020\u0002H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020=2\u0007\u0010\u008a\u0001\u001a\u00020\u0002H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020=2\u0007\u0010\u008d\u0001\u001a\u00020)H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020=2\u0007\u0010\u008d\u0001\u001a\u00020)H\u0016J\t\u0010\u008f\u0001\u001a\u00020\tH\u0016J\u0014\u0010\u0090\u0001\u001a\u00020=2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0016H\u0016J\u001e\u0010\u0092\u0001\u001a\u00020=2\b\u0010S\u001a\u0004\u0018\u00010\u00012\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0016H\u0002J\f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\t\u0010\u0095\u0001\u001a\u00020\tH\u0002J\u0012\u0010\u0096\u0001\u001a\u00020=2\u0007\u0010\u0091\u0001\u001a\u00020\u0018H\u0016J\u0012\u0010\u0097\u0001\u001a\u00020=2\u0007\u0010\u0091\u0001\u001a\u00020\u001aH\u0016J\u001b\u0010\u0098\u0001\u001a\u00020=2\u0007\u0010\u0082\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u00020\u001cH\u0016J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002J\u001b\u0010\u009b\u0001\u001a\u00020=2\u0007\u0010\u009c\u0001\u001a\u00020 2\u0007\u0010\u009d\u0001\u001a\u00020 H\u0002J\t\u0010\u009e\u0001\u001a\u00020\u001cH\u0002J\f\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001H\u0002J\u0012\u0010¡\u0001\u001a\u00020=2\u0007\u0010¢\u0001\u001a\u00020\u001cH\u0016J\u001b\u0010¡\u0001\u001a\u00020=2\u0007\u0010¢\u0001\u001a\u00020\u001c2\u0007\u0010£\u0001\u001a\u000200H\u0016J\t\u0010¤\u0001\u001a\u00020=H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001f\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;¨\u0006§\u0001"}, d2 = {"Lcom/larus/business/floatchat/impl/AIFloatChatFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/larus/bmhome/ability/FloatChatWindowStateChangeListener;", "Lcom/larus/bmhome/ability/FloatChatWindowHeightChangeListener;", "Lcom/larus/business/floatchat/api/IAIChatComponentController;", "Lcom/larus/business/floatchat/api/IAIChatAbilityHost;", "<init>", "()V", "chatContainerId", "", "floatChatFragment", "boundFloatChatFragment", "chatInputBgMask", "Landroid/view/View;", "rootView", "Lcom/larus/business/floatchat/impl/TouchDelegateFrameLayout;", "lazyInputPlaceholderController", "Lcom/larus/business/floatchat/impl/AIFloatChatFragment$LazyInputPlaceholderController;", "integrateVersion", "chatContextProvider", "Lcom/larus/business/floatchat/api/ChatContextProvider;", "chatHostConfig", "Lcom/larus/business/floatchat/api/AIChatHostConfig;", "currentInputConfig", "Lcom/larus/business/floatchat/api/AIChatInputConfig;", "currentActionBarConfig", "Lcom/larus/business/floatchat/api/AIChatActionBarConfig;", "isActionBarVisible", "", "cmdBizTypePairs", "", "Lkotlin/Pair;", "", "visibilityAnimVersion", "isChatComponentVisible", "hasTrackedDialogBoxShow", "messageChangedObservers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/business/floatchat/api/OnMessageChangedObserver;", "windowStateObservers", "windowHeightObservers", "Lcom/larus/business/floatchat/api/AIChatWindowHeightObserver;", "lastMeasuredWindowHeight", "abilityHostStateListeners", "Lcom/larus/business/floatchat/api/IAIChatAbilityHostStateListener;", "conversationDeletedHandler", "Lcom/larus/business/floatchat/api/AIChatConversationDeletedHandler;", "abilityHostGeneration", "", "abilityHostState", "Lcom/larus/business/floatchat/api/AIChatAbilityHostState;", "conversationDeletedAbility", "com/larus/business/floatchat/impl/AIFloatChatFragment$conversationDeletedAbility$1", "Lcom/larus/business/floatchat/impl/AIFloatChatFragment$conversationDeletedAbility$1;", "activityLifecycleCallbacks", "com/larus/business/floatchat/impl/AIFloatChatFragment$activityLifecycleCallbacks$1", "Lcom/larus/business/floatchat/impl/AIFloatChatFragment$activityLifecycleCallbacks$1;", "backPressedCallback", "com/larus/business/floatchat/impl/AIFloatChatFragment$backPressedCallback$1", "Lcom/larus/business/floatchat/impl/AIFloatChatFragment$backPressedCallback$1;", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onSaveInstanceState", "outState", "onResume", "onDestroyView", "onDestroy", "integrateFloatChatFragment", "conversationId", "createFloatChatBundle", "bindFloatChatFragment", "fragment", "detachFloatChatFragment", "bindConversationDeletedAbilityIfNeeded", "unbindConversationDeletedAbility", "updateAbilityHostState", "state", "notifyAbilityHostStateListener", "listener", "onWindowStateChanged", "snapshot", "Lcom/larus/bmhome/ability/FloatChatWindowSnapshot;", "onWindowDragProgress", "progress", "", "onWindowHeightChanged", "heightPx", "getAbility", "T", "Lcom/larus/ui/arch/component/external/api/feature/ComponentAbility;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/larus/ui/arch/component/external/api/feature/ComponentAbility;", "getVAbility", "Lcom/larus/ui/arch/context/external/VAbility;", "(Ljava/lang/Class;)Lcom/larus/ui/arch/context/external/VAbility;", "addAbilityHostStateListener", "removeAbilityHostStateListener", "setConversationDeletedHandler", "handler", "updateWindowStateViews", "Lcom/larus/bmhome/ability/FloatChatWindowState;", "updateChatInputBgMaskProgress", "handleAiFloatChatBackPressed", "handleOutsideFloatChatTouch", "event", "Landroid/view/MotionEvent;", "isOutsideFloatChat", "hideFloatChatInput", "registerMessageChangedObserver", "changedListener", "unregisterMessageChangedObserver", "setChatContextProvider", "provider", "registerCmdBizType", "bizToTypePairs", "onConversationChange", "setVisibility", "visible", "needAnim", "notifyChatModuleVisibilityChanged", "trackDialogBoxShowIfNeeded", "expandWindow", "collapseWindow", "requestWindowState", "registerWindowStateObserver", "windowStateObserver", "unregisterWindowStateObserver", "registerWindowHeightObserver", "observer", "unregisterWindowHeightObserver", "getBottomSafeHeight", "setChatHostConfig", "config", "applyChatHostConfig", "getChatPanelInfo", "Lcom/larus/business/floatchat/api/AIChatPanelInfo;", "getVisibilityAnimDistance", "onConfigChange", "updateActionBar", "setActionBarVisible", "getFoldAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "putStringArgument", "key", "value", "shouldAdaptPadding", "getMessageLogicAbility", "Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "setLazyLoadInputEnabled", "enabled", "timeoutMillis", "notifyRealInputReady", "Companion", "LazyInputPlaceholderController", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatFragment extends Fragment implements i, va8.g, dw8.s, dw8.q {
    public static final /* synthetic */ int E = 0;
    public dw8.a A;
    public final h B;
    public final c C;
    public final AIFloatChatFragment$backPressedCallback$1 D;
    public final int d;
    public Fragment e;
    public Fragment f;
    public View g;
    public TouchDelegateFrameLayout h;
    public final b i;
    public int j;
    public dw8.p k;
    public dw8.m l;
    public AIChatInputConfig m;
    public dw8.d n;
    public boolean o;
    public List<Pair<String, String>> p;
    public int q;
    public boolean r;
    public boolean s;
    public final CopyOnWriteArraySet<dw8.t> t;
    public final CopyOnWriteArraySet<i> u;
    public final CopyOnWriteArraySet<dw8.o> v;
    public int w;
    public final CopyOnWriteArraySet<r> x;
    public dw8.h y;
    public long z;

    public static final class a {
    }

    public final class b {
        public boolean a;
        public long b;
        public boolean c;
        public boolean d;
        public View e;
        public View f;
        public ChatInputPlaceholderMode g;
        public Function0<Unit> h;
        public final /* synthetic */ AIFloatChatFragment i;

        public final ye8.a b() {
            AIChatInputConfig r0 = this.i.m;
            if (r0 != null) goto L5;
            r0 = new AIChatInputConfig(0, null, 0, false, null, 0, null, 4095);
        L5:
            ChatInputService r1 = ChatInputService.b;
            Bundle r2 = this.i.getArguments();
            String r3 = null;
            if (r2 == null) goto L11;
            String r4 = r2.getString(MusicAppletPage.KEY_CONVERSATION_ID, null);
            if (r4 == null) goto L11;
            r3 = r4;
        L14:
            String r5 = r1.i(r3, r0.b);
            boolean r6 = f();
            if (r0.f == false) goto L19;
            boolean r7 = true;
            if ((!r0.g.isEmpty()) == false) goto L19;
        L20:
            ChatInputPlaceholderMode r8 = this.g;
            if (r8 != null) goto L24;
            r8 = ChatInputPlaceholderMode.KEYBOARD;
        L24:
            return new ye8.a(r5, r6, r7, r8, r0.c);
        L19:
            r7 = false;
        L11:
            Bundle r9 = this.i.getArguments();
            if (r9 == null) goto L14;
            r3 = r9.getString("argConversationId", null);
            goto L14
        }

        public final void c() {
            Fragment r0 = this.i.getChildFragmentManager().findFragmentByTag("tag_ai_float_chat_fragment");
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("load real input, hasExistingFragment=");
            if (r0 == null) goto L5;
            boolean r3 = true;
        L6:
            r2.append(r3);
            r1.i("AIFloatChatFragment", r2.toString());
            if (r0 != null) goto L10;
            AIFloatChatFragment r4 = this.i;
            int r5 = AIFloatChatFragment.E;
            r4.Y90(null);
            return;
        L10:
            AIFloatChatFragment r6 = this.i;
            r6.e = r0;
            r6.U90(r0);
            g(r0);
            return;
        L5:
            r3 = false;
            goto L6
        }

        public final void d() {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("notify real input ready, enabled=");
            r1.append(this.a);
            r1.append(", hasPlaceholder=");
            if (this.e == null) goto L5;
            boolean r2 = true;
        L6:
            r1.append(r2);
            r1.append(", readyTriggered=");
            r1.append(this.c);
            r1.append(", revealed=");
            r1.append(this.d);
            r0.i("AIFloatChatFragment", r1.toString());
            if (this.d == false) goto L9;
            return;
        L9:
            if (this.c == false) goto L12;
            return;
        L12:
            if (this.a == false) goto L14;
        L16:
            this.c = true;
            LifecycleOwner r3 = (LifecycleOwner) this.i.getViewLifecycleOwnerLiveData().getValue();
            if (r3 != null) goto L20;
            return;
        L20:
            if (r3.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == true) goto L22;
            return;
        L22:
            c();
            return;
        L14:
            if (this.e != null) goto L16;
            return;
        L5:
            r2 = false;
            goto L6
        }

        public final boolean f() {
            AIChatInputConfig r0 = this.i.m;
            if (r0 != null) goto L6;
            r0 = new AIChatInputConfig(0, null, 0, false, null, 0, null, 4095);
        L6:
            if (r0.d == 1) goto L10;
            return false;
        L10:
            return true;
        }

        public b(AIFloatChatFragment r3) {
            this.i = r3;
            this.b = 2000;
        }

        public final void a(boolean r4) {
            Function0<Unit> r0 = this.h;
            if (r0 != null) goto L5;
            return;
        L5:
            View r1 = null;
            this.h = null;
            View r2 = this.e;
            if (r2 == null) goto L14;
            if (r4 == true) goto L9;
        L11:
            boolean r5 = false;
        L12:
            if (r5 == false) goto L14;
            r1 = r2;
            goto L14
        L9:
            if (this.d == false) goto L11;
            r5 = true;
        L14:
            r0.invoke();
            if (r1 == null) goto L18;
            e(r1);
            return;
        }

        public final void e(View r4) {
            if (this.e == r4) goto L5;
            return;
        L5:
            ViewParent r0 = r4.getParent();
            if ((r0 instanceof ViewGroup) == false) goto L8;
            ViewGroup r1 = (ViewGroup) r0;
        L9:
            if (r1 == null) goto L11;
            r1.removeView(r4);
        L11:
            this.e = null;
            this.f = null;
            this.g = null;
            AIFloatChatFragment r5 = this.i;
            TouchDelegateFrameLayout r2 = r5.h;
            if (r2 == null) goto L17;
            View r6 = r2.findViewById(r5.d);
            if (r6 == null) goto L18;
            r6.setAlpha(1.0f);
            return;
        L18:
            return;
        L17:
            return;
        L8:
            r1 = null;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v35, types: [androidx.lifecycle.Observer, com.larus.business.floatchat.impl.q] */
        /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.business.floatchat.impl.u, java.lang.Runnable] */
        public final void g(final Fragment r11) {
            final View r5 = this.e;
            if (r5 != null) goto L5;
            return;
        L5:
            boolean r0 = true;
            a(true);
            if (this.d == false) goto L10;
            e(r5);
            return;
        L10:
            if (this.e == r5) goto L12;
            return;
        L12:
            final View r3 = r11.getView();
            if (r3 != null) goto L16;
            final AIFloatChatFragment r1 = this.i;
            final ?? r2 = new q(r11, this, r5, r1);
            r11.getViewLifecycleOwnerLiveData().observe(this.i.getViewLifecycleOwner(), r2);
            this.h = new s(r11, r2);
            return;
        L16:
            final LifecycleOwner r4 = r11.getViewLifecycleOwner();
            if (this.d == true) goto L67;
            AIFloatChatFragment r6 = this.i;
            TouchDelegateFrameLayout r7 = r6.h;
            if (r7 == null) goto L54;
            LifecycleOwner r8 = (LifecycleOwner) r6.getViewLifecycleOwnerLiveData().getValue();
            if (r8 == null) goto L54;
            Lifecycle.State r9 = r8.getLifecycle().getCurrentState();
            Lifecycle.State r10 = Lifecycle.State.CREATED;
            if (r9.isAtLeast(r10) == false) goto L54;
            if (this.e != r5) goto L54;
            if (this.i.e != r11) goto L54;
            if (r11.getView() != r3) goto L54;
            if (r11.getViewLifecycleOwnerLiveData().getValue() != r4) goto L54;
            if (r4.getLifecycle().getCurrentState().isAtLeast(r10) == false) goto L54;
            View r12 = r7.findViewById(this.i.d);
            if (r12 == null) goto L46;
            r12.setAlpha(0.0f);
        L46:
            if (f() == false) goto L53;
            t1a.e r13 = s1a.a.g(r11).p(Reflection.getOrCreateKotlinClass(rp8.a.class));
            if (r13 == null) goto L50;
            r13.a(new t());
        L50:
            ICoreInputAbility r14 = s1a.a.g(r11).getAbility(ICoreInputAbility.class);
            if (r14 == null) goto L53;
            r14.Dr(true);
        L53:
            this.d = true;
        L55:
            if (r0 == false) goto L68;
            final ICoreInputAbility r15 = s1a.a.g(r11).getAbility(ICoreInputAbility.class);
            va8.o r16 = s1a.a.g(r11).getAbility(va8.o.class);
            if (r16 == null) goto L64;
            va8.b r17 = r16.rX();
            if (r17 == null) goto L64;
            View r18 = r17.b;
            if (r18 == null) goto L64;
            final View r19 = r18;
        L65:
            final Ref.ObjectRef r20 = new Ref.ObjectRef();
            final ?? r21 = new u(r15, r19, r20);
            r20.element = new v(this, r11, r3, r4, r5);
            this.h = new w(r19, r21, r20);
            r19.post(r21);
            return;
        L64:
            r19 = r3;
            goto L65
        L68:
            return;
        L54:
            r0 = false;
            goto L55
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ AIFloatChatFragment a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public c(AIFloatChatFragment r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r5) {
            Intrinsics.checkNotNullParameter(r5, "activity");
            FragmentActivity r0 = this.a.getActivity();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 != r0) goto L7;
            return;
        L7:
            if (r0.isChangingConfigurations() == true) goto L12;
            FLogger.a.i("AIFloatChatFragment", "collapse window for activity switch, host=" + r0.getClass().getName() + ", started=" + r5.getClass().getName());
            this.a.D3();
            return;
        }
    }

    public static final class d implements qy8.c {
        public final /* synthetic */ dw8.m a;

        @Override // qy8.c
        public final void b() {
        }

        @Override // qy8.c
        public final boolean a() {
            return ((Boolean) this.a.a.invoke()).booleanValue();
        }

        public d(dw8.m r1) {
            this.a = r1;
        }

        @Override // qy8.c
        public final void c(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            this.a.b.invoke();
        }
    }

    public static final class e implements qy8.d {
        public final /* synthetic */ dw8.m a;

        public e(dw8.m r1) {
            this.a = r1;
        }

        @Override // qy8.d
        public final boolean a(ChatFragment r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, ShareType.URL);
            return ((Boolean) this.a.c.invoke(r3)).booleanValue();
        }
    }

    public static final class f implements qy8.b {
        public final /* synthetic */ dw8.m a;

        public f(dw8.m r1) {
            this.a = r1;
        }

        @Override // qy8.b
        public final boolean a(Fragment r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "resourceId");
            return ((Boolean) this.a.d.invoke(r3)).booleanValue();
        }
    }

    public static final class g implements g4 {
        public final /* synthetic */ boolean a;

        public final void a() {
        }

        public final void b() {
        }

        public final boolean c() {
            return false;
        }

        public final boolean d() {
            return true;
        }

        public final void e(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public final CharSequence f() {
            return null;
        }

        public final CharSequence g() {
            return null;
        }

        public final boolean h() {
            return false;
        }

        public final boolean i() {
            return this.a;
        }

        public g(boolean r1) {
            this.a = r1;
        }

        public final boolean j(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            return false;
        }
    }

    public static final class h implements b0 {
        public final /* synthetic */ AIFloatChatFragment a;

        public h(AIFloatChatFragment r1) {
            this.a = r1;
        }

        public final boolean lg(String r6) {
            dw8.h r0 = this.a.y;
            if (r0 != null) goto L10;
            return false;
        L10:
            r0.a(r6);     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            FLogger.a.e("AIFloatChatFragment", "handle conversation deleted failed, conversationId=" + r6, th);
            return false;
        }
    }

    static {
    }

    public final void onDestroy() {
        this.y = null;
        this.l = null;
        this.x.clear();
        super.onDestroy();
    }

    @Override // dw8.s
    public final void B1() {
        this.i.d();
    }

    @Override // dw8.s
    public final void D3() {
        ba0(FloatChatWindowState.Collapsed);
    }

    @Override // dw8.s
    public final void Vv() {
        ba0(FloatChatWindowState.Expanded);
    }

    public final k W90() {
        Fragment r0 = this.e;
        if (r0 == null) goto L7;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L7;
        return r1.getAbility(k.class);
    L7:
        return null;
    }

    public final ew8.b X90() {
        Fragment r0 = this.e;
        if (r0 == null) goto L7;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L7;
        return r1.getAbility(ew8.b.class);
    L7:
        return null;
    }

    public final void ca0() {
        dw8.p r0 = this.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.s == false) goto L8;
        return;
    L8:
        if (isResumed() == true) goto L10;
        return;
    L10:
        if (this.r == false) goto L29;
        TouchDelegateFrameLayout r1 = this.h;
        boolean r2 = false;
        if (r1 != null) goto L14;
    L16:
        if (r2 == false) goto L30;
        this.s = true;
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        String r5 = r0.getPageName();
        String r6 = "";
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        r4.put("current_page", r5);
        String r7 = r0.m();
        if (r7 == null) goto L25;
        r6 = r7;
    L25:
        r4.put("origin_message_id", r6);
        Unit r8 = Unit.INSTANCE;
        r3.reportEvent("dialog_box_show", r4);
        return;
    L30:
        return;
    L14:
        if (r1.isShown() != true) goto L16;
        r2 = true;
        goto L16
    }

    public final void onDestroyView() {
        this.j++;
        b r0 = this.i;
        r0.a(true);
        r0.e = null;
        r0.f = null;
        r0.g = null;
        V90(this.e);
        this.g = null;
        this.e = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.business.floatchat.impl.AIFloatChatFragment$backPressedCallback$1] */
    public AIFloatChatFragment() {
        this.d = 2131377173;
        this.i = new b(this);
        this.o = true;
        this.r = true;
        this.t = new CopyOnWriteArraySet();
        this.u = new CopyOnWriteArraySet();
        this.v = new CopyOnWriteArraySet();
        this.x = new CopyOnWriteArraySet();
        this.A = new dw8.a(0, false);
        this.B = new h(this);
        this.C = new c(this);
        this.D = new AIFloatChatFragment$backPressedCallback$1(this);
    }

    @Override // dw8.s
    public final int c9() {
        k r0 = W90();
        if (r0 == null) goto L5;
        int r1 = r0.QK();
    L6:
        Bundle r2 = getArguments();
        int r3 = 0;
        if (r2 == null) goto L11;
        boolean r4 = true;
        if (r2.getBoolean("adapt_padding", false) != true) goto L11;
    L12:
        if (r4 == false) goto L17;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L17;
        r3 = com.larus.utils.u.b(r5);
    L17:
        return r1 + r3;
    L11:
        r4 = false;
        goto L12
    L5:
        r1 = i5.q0() + i5.c();
        goto L6
    }

    public final void onDetach() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Application r1 = r0.getApplication();
        if (r1 == null) goto L7;
        r1.unregisterActivityLifecycleCallbacks(this.C);
    L7:
        super.onDetach();
    }

    public final void onResume() {
        super.onResume();
        ca0();
    }

    @Override // dw8.s
    public final dw8.n u6() {
        k r0 = W90();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new dw8.n(RangesKt.coerceAtLeast(r0.rN(), 0), r0.getWindowState());
    }

    @Override // dw8.q
    public final void Bb(r r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.x.add(r2) == true) goto L5;
        return;
    L5:
        Z90(r2, this.A);
    }

    @Override // dw8.s
    public final void G5(dw8.t r2) {
        Intrinsics.checkNotNullParameter(r2, "changedListener");
        this.t.add(r2);
        ew8.b r0 = X90();
        if (r0 == null) goto L6;
        r0.G5(r2);
        return;
    }

    @Override // dw8.s
    public final void I8(dw8.d r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.n = r3;
        Fragment r0 = this.e;
        if (r0 == null) goto L10;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L11;
        ew8.a r2 = r1.getAbility(ew8.a.class);
        if (r2 == null) goto L12;
        r2.I8(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // dw8.s
    public final void K1(List<Pair<String, String>> r2) {
        this.p = r2;
        ew8.b r0 = X90();
        if (r0 == null) goto L6;
        r0.K1(r2);
        return;
    }

    @Override // dw8.s
    public final void K2(dw8.p r2) {
        this.k = r2;
        ew8.b r0 = X90();
        if (r0 == null) goto L5;
        r0.K2(r2);
    L5:
        ca0();
    }

    @Override // dw8.s
    public final void K4(dw8.t r2) {
        Intrinsics.checkNotNullParameter(r2, "changedListener");
        this.t.remove(r2);
        ew8.b r0 = X90();
        if (r0 == null) goto L6;
        r0.K4(r2);
        return;
    }

    public final void LS(float r4) {
        View r0 = this.g;
        if (r0 == null) goto L11;
        float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
        r0.setAlpha(r5);
        if (r5 <= 0.0f) goto L8;
        int r6 = 0;
    L9:
        r0.setVisibility(r6);
        return;
    L8:
        r6 = 8;
        goto L9
    }

    @Override // dw8.s
    public final void QL(dw8.o r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (this.v.add(r3) == true) goto L5;
        return;
    L5:
        Integer r0 = Integer.valueOf(this.w);
        if (r0.intValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L15;
        r3.l2(r0.intValue());
        return;
    L15:
        return;
    L8:
        r1 = false;
        goto L9
    }

    @Override // dw8.s
    public final void Qr(i r2) {
        Intrinsics.checkNotNullParameter(r2, "windowStateObserver");
        this.u.remove(r2);
        k r0 = W90();
        if (r0 == null) goto L6;
        r0.z40(r2);
        return;
    }

    public final void U90(Fragment r7) {
        Fragment r0 = this.f;
        if (r0 != r7) goto L5;
        return;
    L5:
        V90(r0);
        this.f = r7;
        long r1 = this.z + 1;
        this.z = r1;
        if (this.y != null) goto L40;
    L12:
        T90(r7, this.l);
        k r2 = s1a.a.g(r7).getAbility(k.class);
        if (r2 == null) goto L19;
        r2.du(this.r);
        r2.xf(this);
        r2.My(this);
        Iterator<i> r3 = this.u.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        i r4 = r3.next();
        Intrinsics.checkNotNull(r4);
        r2.xf(r4);
        goto L16
    L18:
        fa0(r2.getWindowState());
    L19:
        ew8.b r5 = s1a.a.g(r7).getAbility(ew8.b.class);
        if (r5 == null) goto L26;
        r5.K2(this.k);
        r5.K1(this.p);
        Iterator<dw8.t> r6 = this.t.iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        dw8.t r8 = r6.next();
        Intrinsics.checkNotNull(r8);
        r5.G5(r8);
        goto L23
    L25:
        CopyOnWriteArrayList<WeakReference<ew8.b>> r9 = y.a;
        Intrinsics.checkNotNullParameter(r5, "messageLogicAbility");
        y.a(r5);
        y.a.add(new WeakReference(r5));
        FLogger.a.i("AIFloatChatWindowEventDispatcher", "register messageLogicAbility=".concat(r5.getClass().getSimpleName()));
    L26:
        AIChatInputConfig r10 = this.m;
        if (r10 == null) goto L31;
        ew8.a r11 = s1a.a.g(r7).getAbility(ew8.a.class);
        if (r11 == null) goto L31;
        r11.k8(r10);
    L31:
        ea0(new dw8.a(r1, true));
        dw8.d r12 = this.n;
        if (r12 == null) goto L36;
        ew8.a r13 = s1a.a.g(r7).getAbility(ew8.a.class);
        if (r13 == null) goto L36;
        r13.I8(r12);
    L36:
        ew8.a r14 = s1a.a.g(r7).getAbility(ew8.a.class);
        if (r14 == null) goto L44;
        r14.I1(this.o, false);
        return;
    L44:
        return;
    L40:
        s1a.a.g(r7).c(this.B, b0.class);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "绑定会话删除代理失败", th);
        goto L12
    }

    @Override // dw8.q
    public final void UB(r r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.x.remove(r2);
    }

    @Override // dw8.s
    public final void UN(dw8.o r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.v.remove(r2);
    }

    public final void V90(Fragment r6) {
        if (r6 != null) goto L6;
        return;
    L6:
        if (this.f == r6) goto L32;
        return;
    L32:
        k r1 = s1a.a.g(r6).getAbility(k.class);     // Catch: Throwable -> L15
        if (r1 == null) goto L30;
        r1.z40(this);     // Catch: Throwable -> L15
        r1.Tg(this);     // Catch: Throwable -> L15
        Iterator<i> r2 = this.u.iterator();     // Catch: Throwable -> L15
    L12:
        if (r2.hasNext() == false) goto L30;
        i r3 = r2.next();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L15
        r1.z40(r3);     // Catch: Throwable -> L15
    L30:
        ew8.b r4 = s1a.a.g(r6).getAbility(ew8.b.class);     // Catch: Throwable -> L26
        if (r4 == null) goto L28;
        y.a(r4);     // Catch: Throwable -> L26
        Iterator<dw8.t> r5 = this.t.iterator();     // Catch: Throwable -> L26
    L22:
        if (r5.hasNext() == false) goto L24;
        dw8.t r7 = r5.next();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L26
        r4.K4(r7);     // Catch: Throwable -> L26
        goto L22
    L24:
        r4.K1(null);     // Catch: Throwable -> L26
        r4.K2(null);     // Catch: Throwable -> L26
    L28:
        da0(r6);
        this.f = null;
        this.w = 0;
        ea0(new dw8.a(this.A.a, false));
        return;
    L26:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "detachFloatChatFragment message logic failed", th);
    L15:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "detachFloatChatFragment fold failed", th);
        goto L30
    }

    public final void Y90(String r8) {
        b r0 = this.i;
        if (r0.e == null) goto L5;
        r0.a(true);
    L5:
        int r1 = this.j + 1;
        this.j = r1;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AIFloatChatFragment$integrateFloatChatFragment$1(this, r8, r1, null), 3, null);
    }

    @Override // dw8.s
    public final void YI(i r2) {
        Intrinsics.checkNotNullParameter(r2, "windowStateObserver");
        this.u.add(r2);
        k r0 = W90();
        if (r0 == null) goto L6;
        r0.xf(r2);
        return;
    }

    @Override // dw8.s
    public final void ZR(dw8.m r2) {
        this.l = r2;
        T90(this.f, r2);
    }

    public final void am(va8.h r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        fa0(r2.a);
    }

    public final void ba0(FloatChatWindowState r11) {
        aa0("initial_window_state", r11.name());
        k r0 = W90();
        if (r0 == null) goto L6;
        r0.hn(new va8.f(FloatChatWindowEventType.ExternalRequest, r11, null, null, null, false, 60));
        return;
    }

    public final void da0(Fragment r4) {
        t1a.b r5 = s1a.a.g(r4);     // Catch: Throwable -> L6
        if (r5.getAbility(b0.class) != this.B) goto L11;
        r5.b(b0.class);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "解绑会话删除代理失败", th);
    }

    public final void du(boolean r2) {
        if (this.r == r2) goto L7;
        this.r = r2;
        k r0 = W90();
        if (r0 == null) goto L7;
        r0.du(r2);
    L7:
        if (r2 == false) goto L10;
        ca0();
        return;
    }

    public final void ea0(dw8.a r3) {
        if (Intrinsics.areEqual(this.A, r3) == false) goto L5;
        return;
    L5:
        this.A = r3;
        Iterator<r> r0 = this.x.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r r1 = r0.next();
        Intrinsics.checkNotNull(r1);
        Z90(r1, r3);
        goto L7
    }

    public final void fa0(FloatChatWindowState r4) {
        int r1 = 0;
        if (r4 != FloatChatWindowState.Expanded) goto L5;
        boolean r5 = true;
    L6:
        View r0 = this.g;
        if (r0 == null) goto L12;
        if (r5 == false) goto L10;
        float r2 = 1.0f;
    L11:
        r0.setAlpha(r2);
        goto L12
    L10:
        r2 = 0.0f;
    L12:
        View r3 = this.g;
        if (r3 == null) goto L19;
        if (r5 == true) goto L17;
        r1 = 8;
    L17:
        r3.setVisibility(r1);
        return;
    L19:
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // dw8.s
    public final void gP(OfficeChatIntegrationCoordinator.b r4) {
        this.y = r4;
        Fragment r0 = this.f;
        if (r0 == null) goto L15;
        if (r4 != null) goto L6;
        da0(r0);
        return;
    L6:
        if (r4 == null) goto L17;
        s1a.a.g(r0).c(this.B, b0.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "绑定会话删除代理失败", th);
        return;
    L17:
        return;
    }

    @Override // dw8.q
    public final <T extends m1a.a> T getAbility(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        if (this.A.b == true) goto L14;
        return null;
    L14:
        Fragment r0 = this.f;     // Catch: Throwable -> L11
        if (r0 == null) goto L16;
        t1a.b r1 = s1a.a.g(r0);     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        return r1.getAbility(r5);
    L17:
        return null;
    L16:
        return null;
    L11:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "get ability failed, clazz=".concat(r5.getName()), th);
        return null;
    }

    @Override // dw8.s
    public final void k8(AIChatInputConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        this.m = r4;
        T90(this.f, this.l);
        b r0 = this.i;
        View r1 = r0.f;
        if (r1 == null) goto L5;
        ChatInputService.b.e(r1, r0.b());
    L5:
        Integer r2 = r4.k;
        if (r2 == null) goto L24;
        int r3 = r2.intValue();
        boolean r5 = true;
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L12;
        r5 = false;
    L12:
        if (r5 == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L24;
        int r6 = r2.intValue();
        Bundle r7 = getArguments();
        if (r7 == null) goto L19;
        r7.putInt("answer_intent_logic", r6);
    L19:
        Fragment r8 = this.e;
        if (r8 == null) goto L24;
        Bundle r9 = r8.getArguments();
        if (r9 == null) goto L24;
        r9.putInt("answer_intent_logic", r6);
    L24:
        Fragment r10 = this.e;
        if (r10 == null) goto L32;
        t1a.b r11 = s1a.a.g(r10);
        if (r11 == null) goto L33;
        ew8.a r12 = r11.getAbility(ew8.a.class);
        if (r12 == null) goto L34;
        r12.k8(r4);
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void l2(int r3) {
        this.w = RangesKt.coerceAtLeast(r3, 0);
        Iterator<dw8.o> r4 = this.v.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.next().l2(this.w);
        goto L4
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L8;
        Application r4 = r3.getApplication();
        if (r4 == null) goto L9;
        r4.registerActivityLifecycleCallbacks(this.C);
        return;
    L9:
        return;
    }

    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        super.onSaveInstanceState(r5);
        b r1 = this.i;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "outState");
        if (r1.a == false) goto L7;
        r5.putBoolean("ai_float_lazy_load_input_enabled", true);
        r5.putLong("ai_float_lazy_load_timeout_millis", r1.b);
        r5.putBoolean("ai_float_real_input_ready_triggered", r1.c);
        r5.putBoolean("ai_float_real_input_revealed", r1.d);
        return;
    }

    @Override // dw8.s
    public final void q7(String r5) {
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        aa0(MusicAppletPage.KEY_CONVERSATION_ID, r5);
        aa0("argConversationId", r5);
        b r0 = this.i;
        if (r0.a == true) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        return;
    L15:
        if (this.h != null) goto L18;
        FLogger.a.i("AIFloatChatFragment", "onConversationChange pending, view not created, conversationId=" + r5);
        return;
    L18:
        Y90(r5);
        return;
    L5:
        if (r0.d == true) goto L11;
        View r2 = r0.f;
        if (r2 == null) goto L10;
        ChatInputService.b.e(r2, r0.b());
    L10:
        r1 = !r0.c;
        goto L12
    }

    @Override // dw8.s
    public final void sa(long r8) {
        b r0 = this.i;
        r0.a = true;
        r0.b = RangesKt.coerceAtLeast(r8, 0);
        if (r0.e != null) goto L5;
        return;
    L5:
        if (r0.c == true) goto L9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0.i.getViewLifecycleOwner()), null, null, new AIFloatChatFragment$LazyInputPlaceholderController$startLazyLoadTimeout$1(r0, null), 3, null);
        return;
    }

    @Override // dw8.q
    public final <T extends t1a.a> T vw(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        if (this.A.b == true) goto L14;
        return null;
    L14:
        Fragment r0 = this.f;     // Catch: Throwable -> L11
        if (r0 == null) goto L16;
        t1a.b r1 = s1a.a.g(r0);     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        return (T) r1.getAbility(r5);
    L17:
        return null;
    L16:
        return null;
    L11:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "get VAbility failed, clazz=".concat(r5.getName()), th);
        return null;
    }

    public static void S90(AIFloatChatFragment r7, MotionEvent r8) {
        r7.getClass();
        if (r8.getActionMasked() != 0) goto L55;
        Fragment r0 = r7.e;
        boolean r1 = true;
        if (r0 == null) goto L11;
        View r2 = r0.getView();
        if (r2 == null) goto L11;
        View r3 = r2.findViewById(2131365588);
        if (r3 == null) goto L11;
    L18:
        if (r3.isShown() == true) goto L20;
    L33:
        boolean r9 = false;
    L34:
        if (r9 == false) goto L56;
        Fragment r10 = r7.e;
        if (r10 == null) goto L58;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L47
        ICoreInputAbility r12 = s1a.a.g(r10).getAbility(ICoreInputAbility.class);     // Catch: Throwable -> L47
        va8.n r13 = s1a.a.g(r10).getAbility(va8.n.class);     // Catch: Throwable -> L47
        if (r12 == null) goto L41;
        r12.qp(true);     // Catch: Throwable -> L47
    L42:
        if (r1 == true) goto L45;
        if (r13 == null) goto L45;
        r13.hideKeyboard();     // Catch: Throwable -> L47
    L45:
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L57;
        FLogger.a.e("AIFloatChatFragment", "hideFloatChatInput failed", r15);
        return;
    L57:
        return;
    L41:
        r1 = false;
    L47:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    L58:
        return;
    L56:
        return;
    L20:
        if (r3.getWidth() <= 0) goto L33;
        if (r3.getHeight() <= 0) goto L33;
        int[] r4 = new int[2];
        r3.getLocationOnScreen(r4);
        float r5 = r4[0];
        float r6 = r4[1];
        float r17 = r3.getWidth() + r5;
        float r18 = r3.getHeight() + r6;
        if (r8.getRawX() >= r5) goto L27;
    L32:
        r9 = true;
        goto L34
    L27:
        if (r8.getRawX() > r17) goto L32;
        if (r8.getRawY() < r6) goto L32;
        if (r8.getRawY() <= r18) goto L33;
    L11:
        Fragment r19 = r7.e;
        if (r19 == null) goto L14;
        r3 = r19.getView();
    L15:
        if (r3 != null) goto L18;
    L14:
        r3 = null;
        goto L15
    }

    public static void Z90(r r4, dw8.a r5) {
        r4.a(r5);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.a.e("AIFloatChatFragment", "notify ability host state failed, generation=" + r5.a + ", isReady=" + r5.b, th);
    }

    @Override // dw8.s
    public final void I1(boolean r3, boolean r4) {
        this.o = r3;
        Fragment r0 = this.e;
        if (r0 == null) goto L10;
        t1a.b r1 = s1a.a.g(r0);
        if (r1 == null) goto L11;
        ew8.a r2 = r1.getAbility(ew8.a.class);
        if (r2 == null) goto L12;
        r2.I1(r3, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void T90(Fragment r14, dw8.m r15) {
        Boolean r1 = null;
        if ((r14 instanceof xe8.a) == false) goto L5;
        xe8.a r16 = (xe8.a) r14;
    L6:
        if (r16 != null) goto L8;
        return;
    L8:
        boolean r0 = z2.a.r1();
        g r9 = new g(r0);
        if (r15 == null) goto L11;
        d r5 = new d(r15);
        if (r0 == false) goto L22;
        Set r2 = SetsKt.setOf(new ChatTitleBarIcon[]{ChatTitleBarIcon.COLLAPSE, ChatTitleBarIcon.TTS});
    L23:
        Set r8 = r2;
        e r3 = new e(r15);
        f r6 = new f(r15);
        AIChatInputConfig r4 = this.m;
        if (r4 == null) goto L26;
        r1 = r4.l;
    L26:
        r16.AY(new qy8.a(r5, null, r3, r6, false, r8, r9, r1, Boolean.valueOf(r15.e), 9118));
        return;
    L22:
        r2 = SetsKt.emptySet();
        goto L23
    L11:
        if (r0 == false) goto L13;
        Set r7 = SetsKt.setOf(new ChatTitleBarIcon[]{ChatTitleBarIcon.COLLAPSE, ChatTitleBarIcon.TTS});
    L14:
        AIChatInputConfig r10 = this.m;
        if (r10 == null) goto L17;
        r1 = r10.l;
    L17:
        r16.AY(new qy8.a(null, null, null, null, false, r7, r9, r1, Boolean.FALSE, 9215));
        return;
    L13:
        r7 = SetsKt.emptySet();
        goto L14
    L5:
        r16 = null;
        goto L6
    }

    public final void aa0(String r3, String r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Bundle r1 = getArguments();     // Catch: Throwable -> L7
        if (r1 != null) goto L5;
        r1 = new Bundle();     // Catch: Throwable -> L7
        setArguments(r1);     // Catch: Throwable -> L7
    L5:
        r1.putString(r3, r4);     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L15;
        FLogger.a.e("AIFloatChatFragment", "putStringArgument failed, key=".concat(r3), r6);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.D);
        final Fragment r1 = getChildFragmentManager().findFragmentByTag("tag_ai_float_chat_fragment");
        b r2 = this.i;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "view");
        if (r12 == null) goto L5;
        boolean r0 = r12.getBoolean("ai_float_lazy_load_input_enabled", r2.a);
    L6:
        r2.a = r0;
        boolean r4 = false;
        if (r0 == false) goto L54;
        if (r12 == null) goto L11;
        long r5 = r12.getLong("ai_float_lazy_load_timeout_millis", r2.b);
    L12:
        r2.b = r5;
        if (r12 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L20;
    L23:
        boolean r7 = true;
    L24:
        r2.c = r7;
        if (r12 != null) goto L27;
    L29:
        boolean r13 = false;
    L30:
        if (r13 == false) goto L32;
    L35:
        boolean r14 = true;
    L36:
        r2.d = r14;
        if (r14 == true) goto L54;
        View r15 = r11.findViewById(r2.i.d);
        if (r15 == null) goto L42;
        r15.setAlpha(0.0f);
    L42:
        TouchDelegateFrameLayout r16 = r2.i.h;
        if (r16 == null) goto L50;
        ChatInputService r8 = ChatInputService.b;
        r2.g = r8.j();
        View r9 = r2.i.getLayoutInflater().inflate(2131562731, r16, false);
        View r10 = r8.l(r2.i.requireContext(), r2.b());
        if (r10 == null) goto L48;
        ((FrameLayout) r9.findViewById(2131382403)).addView(r10, new FrameLayout.LayoutParams(-1, -2));
    L48:
        r2.e = r9;
        r2.f = r10;
        r16.addView(r9);
        FLogger.a.i("AIFloatChatFragment", "add input placeholder, mode=" + r2.g);
    L50:
        if (r2.c == false) goto L52;
        r2.c();
    L53:
        r4 = true;
        goto L54
    L52:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2.i.getViewLifecycleOwner()), null, null, new AIFloatChatFragment$LazyInputPlaceholderController$startLazyLoadTimeout$1(r2, null), 3, null);
        goto L53
    L32:
        if (r2.d == true) goto L35;
        r14 = false;
        goto L36
    L27:
        if (r12.getBoolean("ai_float_real_input_revealed") != true) goto L29;
        r13 = true;
        goto L30
    L20:
        if (r2.c == true) goto L23;
        r7 = false;
        goto L24
    L15:
        if (r12.getBoolean("ai_float_real_input_ready_triggered") != true) goto L17;
        r6 = true;
        goto L18
    L11:
        r5 = r2.b;
    L54:
        if (r4 == false) goto L56;
        return;
    L56:
        if (r1 != null) goto L59;
        Y90(null);
        return;
    L59:
        this.e = r1;
        final LifecycleOwner r17 = getViewLifecycleOwner();
        r11.post(new p(r17, this, r1));
        return;
    L5:
        r0 = r2.a;
        goto L6
    }

    @Override // dw8.s
    public final void s70(boolean r8, boolean r9) {
        final TouchDelegateFrameLayout r0 = this.h;
        if (r0 != null) goto L6;
        this.r = r8;
        return;
    L6:
        boolean r2 = true;
        final int r1 = this.q + 1;
        this.q = r1;
        r0.animate().cancel();
        if (r8 == false) goto L35;
        if (r0.getVisibility() != 0) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
    L20:
        e1.x(r0);
        du(true);
        if (r9 == true) goto L25;
        r0.setTranslationY(0.0f);
        return;
    L25:
        if (r0.getTranslationY() == 0.0f) goto L28;
        r2 = false;
    L28:
        if (r2 == false) goto L33;
        int r11 = c9();
        k r12 = W90();
        if (r12 == null) goto L32;
        r11 = RangesKt.coerceAtLeast(r12.rN(), r11);
    L32:
        r0.setTranslationY(r11);
    L33:
        r0.animate().translationY(0.0f).setDuration(200).withEndAction(new n(this, r1, r0)).start();
        return;
    L14:
        if (r0.getTranslationY() != 0.0f) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L20;
        du(true);
        return;
    L16:
        r13 = false;
        goto L17
    L11:
        r10 = false;
        goto L12
    L35:
        if (r0.getVisibility() == 0) goto L38;
        r2 = false;
    L38:
        if (r2 == true) goto L41;
        du(false);
        return;
    L41:
        du(false);
        ba0(FloatChatWindowState.Collapsed);
        if (r9 == true) goto L45;
        r0.setTranslationY(0.0f);
        e1.o(r0);
        return;
    L45:
        ViewPropertyAnimator r14 = r0.animate();
        int r15 = c9();
        k r3 = W90();
        if (r3 == null) goto L48;
        r15 = RangesKt.coerceAtLeast(r3.rN(), r15);
    L48:
        r14.translationY(r15).setDuration(200).withEndAction(new o(this, r1, r0)).start();
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        TouchDelegateFrameLayout r7 = new TouchDelegateFrameLayout(requireContext(), null, 6, 0);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        this.h = r7;
        View r8 = new View(requireContext());
        r8.setBackgroundResource(v19.c.b(2130972311, r8.getContext(), 2131103293));
        r8.setVisibility(8);
        r8.setOnTouchListener(new l(this));
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.setOnClickListener(new m(this));
        this.g = r8;
        TouchDelegateFrameLayout r9 = this.h;
        if (r9 == null) goto L5;
        r9.addView(r8);
    L5:
        FrameLayout r10 = new FrameLayout(requireContext());
        r10.setId(this.d);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 80));
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setOnTouchListener(new l(this));
        TouchDelegateFrameLayout r11 = this.h;
        if (r11 == null) goto L8;
        r11.addView(r10);
    L8:
        TouchDelegateFrameLayout r12 = this.h;
        if (r12 == null) goto L12;
        r12.setOnTouchListener(new l(this));
    L12:
        return this.h;
    }
}
