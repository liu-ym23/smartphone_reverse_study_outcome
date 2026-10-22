package com.larus.bmhome.view.actionbar.custom;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.reflect.TypeToken;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.actionbar.custom.cache.ActionBarCacheStore;
import com.larus.bmhome.view.actionbar.custom.cache.IActionBarRedDotChecker;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.bean.message.Message;
import com.larus.instruction.service.IInstructionService;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.ISdkMinutesService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ¡\u00012\u00020\u0001:\u0002¡\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0006\u00101\u001a\u00020\u001dJ\b\u0010B\u001a\u0004\u0018\u00010\u001dJ4\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010\u001d2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020/2\b\b\u0002\u0010M\u001a\u00020/J(\u0010N\u001a\u00020F2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010O\u001a\u00020K2\u0006\u0010P\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0012\u0010S\u001a\u00020F2\b\u0010T\u001a\u0004\u0018\u00010RH\u0002J\u001e\u0010U\u001a\u00020F2\u0006\u0010V\u001a\u00020\u001d2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#J&\u0010X\u001a\u00020F2\u0006\u0010V\u001a\u00020\u001d2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0082@¢\u0006\u0002\u0010YJ\u0006\u0010Z\u001a\u00020[J\b\u0010\\\u001a\u00020\u001dH\u0002J\u0018\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0017\u0010_\u001a\u00020/2\b\u0010`\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0002\u0010aJ&\u0010b\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u001dJF\u0010e\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u001d2\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020/\u0018\u00010gJ\u0015\u0010h\u001a\u00020F2\b\u00101\u001a\u0004\u0018\u000103¢\u0006\u0002\u0010iJ\u0010\u0010j\u001a\u00020$2\u0006\u0010k\u001a\u00020$H\u0002J\u0016\u0010l\u001a\u00020F2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010m\u001a\u000203J\u001e\u0010n\u001a\u00020F2\u0006\u00101\u001a\u00020\u001d2\u000e\u0010o\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010#J\u0016\u0010q\u001a\u00020F2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010r\u001a\u00020\u001dJ\u001e\u0010s\u001a\u00020F2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010r\u001a\u00020\u001d2\u0006\u0010m\u001a\u000203J\u000e\u0010t\u001a\u00020F2\u0006\u0010u\u001a\u00020\u001dJ\u001e\u0010v\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001d\u0018\u00010w2\b\u0010x\u001a\u0004\u0018\u00010\u001dJ\u0018\u0010y\u001a\u00020F2\u0006\u0010O\u001a\u00020K2\u0006\u0010P\u001a\u00020/H\u0002J\u000e\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020/J\u0006\u0010|\u001a\u00020FJ\u000e\u0010y\u001a\u00020F2\u0006\u0010O\u001a\u00020KJ\u0010\u0010}\u001a\u00020F2\u0006\u0010O\u001a\u00020KH\u0002J!\u0010~\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020$2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0003\u0010\u0081\u0001JY\u0010\u0082\u0001\u001a\u00020F2\u0011\u0010\u0083\u0001\u001a\f\u0018\u00010\u0084\u0001j\u0005\u0018\u0001`\u0085\u00012\u0006\u0010\u007f\u001a\u00020$2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010/2\t\b\u0002\u0010\u0086\u0001\u001a\u00020/2\f\b\u0002\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001d¢\u0006\u0003\u0010\u008a\u0001J\"\u0010\u008b\u0001\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020$2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0003\u0010\u0081\u0001J$\u0010\u008c\u0001\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020$2\u0011\u0010\u0083\u0001\u001a\f\u0018\u00010\u0084\u0001j\u0005\u0018\u0001`\u0085\u0001H\u0002J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001dJE\u0010\u008e\u0001\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020$2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010/2\t\b\u0002\u0010\u008f\u0001\u001a\u00020/2\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001d2\t\b\u0002\u0010\u0091\u0001\u001a\u00020/H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u0015\u0010\u0093\u0001\u001a\u00020F2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J3\u0010\u0096\u0001\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020$2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001d2\u0013\b\u0002\u0010\u0083\u0001\u001a\f\u0018\u00010\u0084\u0001j\u0005\u0018\u0001`\u0085\u0001H\u0002J2\u0010\u0097\u0001\u001a\u00020F2\u0006\u0010\u007f\u001a\u00020$2\u0011\u0010\u0083\u0001\u001a\f\u0018\u00010\u0084\u0001j\u0005\u0018\u0001`\u0085\u00012\f\b\u0002\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0002J\u0010\u0010\u0098\u0001\u001a\u00020/H\u0086@¢\u0006\u0003\u0010\u0099\u0001J\u0010\u0010\u009a\u0001\u001a\u00020F2\u0007\u0010\u009b\u0001\u001a\u00020$J\u000f\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\u0002J1\u0010\u009d\u0001\u001a\n\u0012\u0004\u0012\u00020$\u0018\u0001052\u000f\u0010\u009e\u0001\u001a\n\u0012\u0004\u0012\u00020$\u0018\u0001052\r\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0#H\u0002J\u0007\u0010 \u0001\u001a\u00020\u001dR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020$\u0018\u00010#0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001f\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020$\u0018\u00010#0)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002030-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u00020$\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R.\u0010;\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R$\u0010>\u001a\u0004\u0018\u00010/2\b\u00107\u001a\u0004\u0018\u00010/@BX\u0086\u000e¢\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u0010\u0010C\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "actionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarRedDotCacheHelper;", "getActionBarRedDotCacheHelper", "()Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarRedDotCacheHelper;", "actionBarRedDotCacheHelper$delegate", "Lkotlin/Lazy;", "actionBarMenuRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarMenuRedDotCacheHelper;", "getActionBarMenuRedDotCacheHelper", "()Lcom/larus/bmhome/view/actionbar/custom/cache/ActionBarMenuRedDotCacheHelper;", "actionBarMenuRedDotCacheHelper$delegate", "sdkMinutesService", "Lcom/larus/platform/api/ISdkMinutesService;", "getSdkMinutesService", "()Lcom/larus/platform/api/ISdkMinutesService;", "sdkMinutesService$delegate", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "repo", "Lcom/larus/bmhome/chat/model/repo/BotRepo;", "conversationId", "", "langCode", "botId", "scene", "_actionBarConfList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "get_actionBarConfList", "()Landroidx/lifecycle/MutableLiveData;", "_actionBarConfList$delegate", "actionBarConfList", "Landroidx/lifecycle/LiveData;", "getActionBarConfList", "()Landroidx/lifecycle/LiveData;", "_actionBarLoadingMap", "", "Lkotlinx/coroutines/flow/StateFlow;", "", "getActionBarLoadingStatusFlow", "itemId", "actionBarReportVersionMap", "", "remoteActionBarList", "", "disableClientReorder", "value", "requestLogId", "getRequestLogId", "()Ljava/lang/String;", "remoteActionbarList", "getRemoteActionbarList", "()Ljava/util/List;", "actionBarAlwaysOnTop", "getActionBarAlwaysOnTop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConversationId", "lastClickActionBarKey", "lastNewRecordActionBarClickAtMs", "updateChatParam", "", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "pageScene", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "skipRefresh", "forceUpdateScene", "refreshScene", "lifecycleScope", "forceRemote", "currentConversation", "Lcom/larus/im/bean/conversation/Conversation;", "checkSaaSSubConversation", "conversation", "updateLocalCache", "lang", "actionBarItemList", "updateLocalCacheFromRemote", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeepThinkPosition", "", "getSceneString", "getActionBarRankCacheKey", "curUid", "actionMatchLibra", "actionType", "(Ljava/lang/Integer;)Z", "hasMemoryCache", "specifyBotId", "specifyScene", "getCacheConfig", "filter", "Lkotlin/Function1;", "updateOnItemClick", "(Ljava/lang/Long;)V", "handleRedDotItemHasClicked", "customActionBarItem", "reportRedDotExposure", "version", "checkAndUpdateMenuHasRedDot", "itemList", "Lcom/larus/bmhome/actionbar/model/SwitchMenuItem;", "handleMenuRedDotItemHasClicked", "menuItemId", "reportMenuRedDotExposure", "setCotExceedQuotaConfig", "cotExceedQuotaConfig", "getCotExceedQuotaConfig", "Lkotlin/Pair;", "itemKey", "updateConfigFromRemote", "reRefreshActionHiddenStatus", "hidden", "reCheckAndUpdateHasRedDot", "refreshStylePromptList", "updateSwitchStateInCache", "item", "switchCheckState", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;)V", "executeOnClickAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "notReport", "bizArgs", "Landroid/os/Bundle;", "sendMsgMenuKey", "(Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "handleRecordActionBarClick", "handleMultiSuggestActionBarClick", "getBotLanguageCode", "reportActionBarOpResult", "ignoreResult", "msgId", "showLoading", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLjava/lang/String;Z)V", "handleActionBarOpResult", "opResult", "Lcom/larus/bmhome/actionbar/model/CustomActionBarOpResult;", "handleUserSendMsg", "handleOpenSchema", "checkCoCoCOnvRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveActionBarNewRank", "clickedActionBar", "getActionBarRankCache", "resortActionBarItems", "originActionBarList", "actionBarUniqueIdRank", "getLastClickActionBarKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomActionBarViewModel extends ViewModel {
    public static final String CACHE_FILE = "custom_action_bar_conf";
    public static final a Companion = null;
    private static final long NEW_RECORD_ACTION_BAR_CLICK_INTERVAL_MS = 3000;
    private static final String POPUP_TYPE_INTERPRET_CLOSE_CONFIRM = "interpret_close_confirm";
    public static final String SCENE_TOUTIAO = "toutiao_conversation";
    private static final String TAG = "CustomActionBarViewModel";
    private final Lazy _actionBarConfList$delegate;
    private final Map<String, kotlinx.coroutines.flow.i1<Boolean>> _actionBarLoadingMap;
    private Boolean actionBarAlwaysOnTop;
    private final LiveData<List<com.larus.bmhome.actionbar.model.z0>> actionBarConfList;
    private final Lazy actionBarMenuRedDotCacheHelper$delegate;
    private final Lazy actionBarRedDotCacheHelper$delegate;
    private final Map<String, Long> actionBarReportVersionMap;
    private String botId;
    private final Lazy cache$delegate;
    private String conversationId;
    private boolean disableClientReorder;
    private String langCode;
    private String lastClickActionBarKey;
    private long lastNewRecordActionBarClickAtMs;
    private List<com.larus.bmhome.actionbar.model.z0> remoteActionBarList;
    private List<com.larus.bmhome.actionbar.model.z0> remoteActionbarList;
    private final BotRepo repo;
    private String requestLogId;
    private String scene;
    private final Lazy sdkMinutesService$delegate;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/view/actionbar/custom/CustomActionBarViewModel$getActionBarRankCache$cacheList$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public static final class c implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CustomActionBarViewModel b;

        public final void confirm() {
            boolean r2 = true;
            if (this.a == false) goto L7;
            com.larus.platform.service.o.a.b("popup_click", com.larus.utils.f.c(new Pair[]{TuplesKt.to("popup_type", CustomActionBarViewModel.POPUP_TYPE_INTERPRET_CLOSE_CONFIRM), TuplesKt.to("click_from", "close")}));
            ISdkMinutesService r0 = CustomActionBarViewModel.access$getSdkMinutesService(this.b);
            if (r0 == null) goto L22;
            r0.a("action_bar_recording_popup_window");
            return;
        L22:
            return;
        L7:
            AudioServiceDelegate.a.w();
            IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r1 == null) goto L10;
            com.larus.home.impl.sdk.s r3 = r1.s0();
        L11:
            if (r3 != null) goto L13;
        L15:
            r2 = false;
        L16:
            if (r2 == false) goto L18;
            r3.U("action_bar_recording_popup_window");
            return;
        L18:
            ISdkMinutesService r4 = CustomActionBarViewModel.access$getSdkMinutesService(this.b);
            if (r4 == null) goto L25;
            r4.a("action_bar_recording_popup_window");
            return;
        L25:
            return;
        L13:
            if (r3.K() != true) goto L15;
        L10:
            r3 = null;
            goto L11
        }

        public c(boolean r1, CustomActionBarViewModel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$checkCoCoCOnvRemote$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel", f = "CustomActionBarViewModel.kt", i = {}, l = {951, 956}, m = "checkCoCoCOnvRemote", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CustomActionBarViewModel this$0;

        public AnonymousClass1(CustomActionBarViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.checkCoCoCOnvRemote(this);
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public final /* synthetic */ boolean a;

        public final void cancel() {
            if (this.a == false) goto L6;
            com.larus.platform.service.o.a.b("popup_click", com.larus.utils.f.c(new Pair[]{TuplesKt.to("popup_type", CustomActionBarViewModel.POPUP_TYPE_INTERPRET_CLOSE_CONFIRM), TuplesKt.to("click_from", "cancel")}));
            return;
        }

        public d(boolean r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$executeOnClickAction$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$executeOnClickAction$3", f = "CustomActionBarViewModel.kt", i = {}, l = {569, 579}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $bizArgs;
        final /* synthetic */ BaseContentWidget $component;
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
        final /* synthetic */ Boolean $switchCheckState;
        int label;
        final /* synthetic */ CustomActionBarViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$executeOnClickAction$3$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$executeOnClickAction$3$2", f = "CustomActionBarViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Bundle $bizArgs;
            final /* synthetic */ BaseContentWidget $component;
            final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
            final /* synthetic */ Boolean $switchCheckState;
            int label;
            final /* synthetic */ CustomActionBarViewModel this$0;

            public AnonymousClass2(CustomActionBarViewModel r1, com.larus.bmhome.actionbar.model.z0 r2, BaseContentWidget r3, Bundle r4, Boolean r5, Continuation<? super AnonymousClass2> r6) {
                this.this$0 = r1;
                this.$item = r2;
                this.$component = r3;
                this.$bizArgs = r4;
                this.$switchCheckState = r5;
                super(2, r6);
            }

            public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
                return new AnonymousClass2(this.this$0, this.$item, this.$component, this.$bizArgs, this.$switchCheckState, r9);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r12) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r12);
                CustomActionBarViewModel.access$handleOpenSchema(this.this$0, this.$item, this.$component, this.$bizArgs);
                CustomActionBarViewModel.reportActionBarOpResult$default(this.this$0, this.$item, this.$switchCheckState, false, null, false, 28, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass3(com.larus.bmhome.actionbar.model.z0 r1, CustomActionBarViewModel r2, BaseContentWidget r3, Bundle r4, Boolean r5, Continuation<? super AnonymousClass3> r6) {
            this.$item = r1;
            this.this$0 = r2;
            this.$component = r3;
            this.$bizArgs = r4;
            this.$switchCheckState = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass3(this.$item, this.this$0, this.$component, this.$bizArgs, this.$switchCheckState, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r12);
        L31:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L25
        L22:
            if (((Boolean) r12).booleanValue() == true) goto L27;
            FLogger.a.d(CustomActionBarViewModel.TAG, "reject jump! check remote conv failed!");     // Catch: Throwable -> L25
            return Unit.INSTANCE;
        L27:
            MainCoroutineDispatcher r13 = Dispatchers.getMain();
            AnonymousClass2 r2 = new AnonymousClass2(this.this$0, this.$item, this.$component, this.$bizArgs, this.$switchCheckState, null);
            this.label = 2;
            if (BuildersKt.withContext(r13, r2, this) != r0) goto L31;
            return r0;
        L11:
            ResultKt.throwOnFailure(r12);
            com.larus.bmhome.actionbar.model.e0 r14 = this.$item.m;     // Catch: Throwable -> L25
            if (r14 == null) goto L27;
            String r15 = r14.a;     // Catch: Throwable -> L25
            if (r15 == null) goto L27;
            CustomActionBarViewModel r3 = this.this$0;     // Catch: Throwable -> L25
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r15), "force_create_coo_sub"), "true") == false) goto L27;
            this.label = 1;     // Catch: Throwable -> L25
            r12 = r3.checkCoCoCOnvRemote(this);     // Catch: Throwable -> L25
            if (r12 != r0) goto L22;
            return r0;
        L25:
            th = move-exception;
            FLogger.a.e(CustomActionBarViewModel.TAG, "check schema err! msg=" + th.getMessage());
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$refreshStylePromptList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$refreshStylePromptList$1", f = "CustomActionBarViewModel.kt", i = {}, l = {495}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $languageCode;
        private /* synthetic */ Object L$0;
        int label;

        public C01521(String r1, Continuation<? super C01521> r2) {
            this.$languageCode = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C01521 r0 = new C01521(this.$languageCode, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L9;
            if (r2 != 1) goto L8;
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
        L13:
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L21;
            FLogger.a.e(CustomActionBarViewModel.TAG, "refreshStylePromptList failed, msg=" + r9.getMessage());
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            CoroutineScope r10 = (CoroutineScope) this.L$0;
            String r11 = this.$languageCode;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
            FLogger.a.i(CustomActionBarViewModel.TAG, "refreshStylePromptList, languageCode=" + r11);     // Catch: Throwable -> L15
            IInstructionService.Companion r0 = IInstructionService.a;     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            if (r0.d(r11, this) != r1) goto L13;
            return r1;
        L15:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$reportActionBarOpResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$reportActionBarOpResult$1", f = "CustomActionBarViewModel.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {768, 774, 789}, m = "invokeSuspend", n = {"itemId", "it", "currentVersion", "itemId", "currentVersion", "itemId", "reportActionBarOpResult"}, s = {"L$0", "L$3", "J$0", "L$0", "J$0", "L$0", "L$1"})
    public static final class C01531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $ignoreResult;
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $item;
        final /* synthetic */ String $msgId;
        final /* synthetic */ boolean $showLoading;
        final /* synthetic */ Boolean $switchCheckState;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ CustomActionBarViewModel this$0;

        public C01531(com.larus.bmhome.actionbar.model.z0 r1, CustomActionBarViewModel r2, boolean r3, Boolean r4, String r5, boolean r6, Continuation<? super C01531> r7) {
            this.$item = r1;
            this.this$0 = r2;
            this.$showLoading = r3;
            this.$switchCheckState = r4;
            this.$msgId = r5;
            this.$ignoreResult = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C01531(this.$item, this.this$0, this.$showLoading, this.$switchCheckState, this.$msgId, this.$ignoreResult, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r29) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            kotlinx.coroutines.flow.z0 r12 = null;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            kotlinx.coroutines.flow.i1 r3 = (kotlinx.coroutines.flow.i1) this.L$2;
            com.larus.network.http.a r4 = (com.larus.network.http.a) this.L$1;
            String r5 = (String) this.L$0;
            ResultKt.throwOnFailure(r29);
        L75:
            String r6 = r5;
            com.larus.network.http.a r7 = r4;
        L76:
            FLogger.a.i(CustomActionBarViewModel.TAG, "hideLoading:" + r6);
        L78:
            if (this.$ignoreResult == false) goto L82;
            return Unit.INSTANCE;
        L82:
            if ((r7 instanceof com.larus.network.http.y) == false) goto L85;
            CustomActionBarViewModel.access$handleActionBarOpResult(this.this$0, (com.larus.bmhome.actionbar.model.a1) ((com.larus.network.http.a) ((com.larus.network.http.y) r7)).b);
            FLogger.a.i(CustomActionBarViewModel.TAG, "reportActionBarOpResult, report Success");
        L100:
            return Unit.INSTANCE;
        L85:
            if ((r7 instanceof com.larus.network.http.f) == false) goto L100;
            if (this.$switchCheckState == null) goto L89;
            FLogger r8 = FLogger.a;
            StringBuilder r9 = new StringBuilder("reportActionBarOpResult, report Fail, switchCheckState=");
            r9.append(!this.$switchCheckState.booleanValue());
            r8.e(CustomActionBarViewModel.TAG, r9.toString());
            CustomActionBarViewModel r10 = this.this$0;
            com.larus.bmhome.actionbar.model.z0 r11 = this.$item;
            CustomActionBarViewModel.access$handleActionBarOpResult(r10, new com.larus.bmhome.actionbar.model.a1(r11.a, r11.b, new com.larus.bmhome.actionbar.model.h0(Boxing.boxBoolean(!this.$switchCheckState.booleanValue())), null, 8));
        L90:
            Integer r13 = this.$item.g;
            int r14 = ActionBarExecutionType.BOT_SEND_MSG.getValue();
            if (r13 == null) goto L100;
            if (r13.intValue() != r14) goto L100;
            if (Intrinsics.areEqual(this.$item.b, "coco_spring_festival_2025") == false) goto L98;
            FLogger.a.e(CustomActionBarViewModel.TAG, "report error");
            goto L100
        L98:
            t19.s r15 = t19.s.a;
            Application r16 = AppHost.a.getApplication();
            r15.getClass();
            t19.s.b(r16, 2131906830, false);
            goto L100
        L89:
            CustomActionBarViewModel r17 = this.this$0;
            com.larus.bmhome.actionbar.model.z0 r18 = this.$item;
            CustomActionBarViewModel.access$handleActionBarOpResult(r17, new com.larus.bmhome.actionbar.model.a1(r18.a, r18.b, null, r18.v, 4));
            goto L90
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            long r19 = this.J$0;
            String r20 = (String) this.L$0;
            ResultKt.throwOnFailure(r29);
            r6 = r20;
            Object r21 = r29;
        L57:
            r7 = (com.larus.network.http.a) r21;
            if (this.$showLoading == false) goto L78;
            Long r22 = (Long) CustomActionBarViewModel.access$getActionBarReportVersionMap$p(this.this$0).get(r6);
            if (r22 == null) goto L62;
            long r110 = r22.longValue();
        L64:
            if (r110 != (r19 + 1)) goto L78;
            kotlinx.coroutines.flow.z0 r23 = (kotlinx.coroutines.flow.i1) CustomActionBarViewModel.access$get_actionBarLoadingMap$p(this.this$0).get(r6);
            if (r23 == null) goto L78;
            if ((r23 instanceof kotlinx.coroutines.flow.z0) == false) goto L70;
            r12 = r23;
        L70:
            if (r12 == null) goto L76;
            Boolean r24 = Boxing.boxBoolean(false);
            this.L$0 = r6;
            this.L$1 = r7;
            this.L$2 = r23;
            this.label = 3;
            if (r12.emit(r24, this) != r1) goto L74;
            return r1;
        L74:
            r4 = r7;
            r5 = r6;
            goto L75
        L62:
            r110 = 0;
            goto L64
        L11:
            r19 = this.J$0;
            kotlinx.coroutines.flow.i1 r25 = (kotlinx.coroutines.flow.i1) this.L$3;
            CustomActionBarViewModel r111 = (CustomActionBarViewModel) this.L$2;
            kotlinx.coroutines.flow.i1 r26 = (kotlinx.coroutines.flow.i1) this.L$1;
            r6 = (String) this.L$0;
            ResultKt.throwOnFailure(r29);
        L29:
            CustomActionBarViewModel.access$get_actionBarLoadingMap$p(r111).put(r6, r25);
            CustomActionBarViewModel.access$getActionBarReportVersionMap$p(this.this$0).put(r6, Boxing.boxLong(r19 + 1));
            FLogger.a.i(CustomActionBarViewModel.TAG, "showLoading:" + r6);
        L30:
            BotRepo r27 = CustomActionBarViewModel.access$getRepo$p(this.this$0);
            String r28 = CustomActionBarViewModel.access$getLangCode$p(this.this$0);
            if (r28 != null) goto L33;
            String r112 = "";
        L34:
            String r30 = CustomActionBarViewModel.access$getBotId$p(this.this$0);
            if (r30 != null) goto L37;
            String r210 = "";
        L38:
            String r31 = CustomActionBarViewModel.access$getConversationId$p(this.this$0);
            if (r31 != null) goto L41;
            String r211 = "";
        L42:
            com.larus.bmhome.actionbar.model.z0 r32 = this.$item;
            String r113 = r32.b;
            if (r113 != null) goto L45;
            String r212 = "";
        L46:
            String r114 = r32.i;
            if (r114 != null) goto L49;
            String r213 = "";
        L50:
            Boolean r115 = this.$switchCheckState;
            com.larus.bmhome.actionbar.model.r r33 = r32.q;
            if (r33 == null) goto L53;
            Integer r214 = r33.a;
        L54:
            IBotRepoService.d r34 = new IBotRepoService.d(r112, r210, r211, r212, r213, r115, r214, this.$msgId, CustomActionBarViewModel.access$getScene$p(this.this$0));
            this.L$0 = r6;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.J$0 = r19;
            this.label = 2;
            r27.getClass();
            BotRepo.a().getClass();
            r21 = BotApi.b(r34, this);
            if (r21 != r1) goto L57;
            return r1;
        L53:
            r214 = null;
            goto L54
        L49:
            r213 = r114;
            goto L50
        L45:
            r212 = r113;
            goto L46
        L41:
            r211 = r31;
            goto L42
        L37:
            r210 = r30;
            goto L38
        L33:
            r112 = r28;
            goto L34
        L12:
            ResultKt.throwOnFailure(r29);
            r6 = String.valueOf(this.$item.a);
            Long r35 = (Long) CustomActionBarViewModel.access$getActionBarReportVersionMap$p(this.this$0).get(r6);
            if (r35 == null) goto L15;
            r19 = r35.longValue();
        L17:
            if (this.$showLoading == false) goto L30;
            r25 = (kotlinx.coroutines.flow.i1) CustomActionBarViewModel.access$get_actionBarLoadingMap$p(this.this$0).get(r6);
            if (r25 != null) goto L21;
            r25 = kotlinx.coroutines.flow.j1.a(Boxing.boxBoolean(false));
        L21:
            r111 = this.this$0;
            if ((r25 instanceof kotlinx.coroutines.flow.z0) == false) goto L24;
            kotlinx.coroutines.flow.z0 r36 = (kotlinx.coroutines.flow.z0) r25;
        L25:
            if (r36 == null) goto L29;
            Boolean r37 = Boxing.boxBoolean(true);
            this.L$0 = r6;
            this.L$1 = r25;
            this.L$2 = r111;
            this.L$3 = r25;
            this.J$0 = r19;
            this.label = 1;
            if (r36.emit(r37, this) != r1) goto L29;
            return r1;
        L24:
            r36 = null;
            goto L25
        L15:
            r19 = 0;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$updateConfigFromRemote$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarViewModel$updateConfigFromRemote$1", f = "CustomActionBarViewModel.kt", i = {1, 1}, l = {425, 471}, m = "invokeSuspend", n = {"actionBarConfResult", "resortData"}, s = {"L$0", "L$1"})
    public static final class C01541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CustomActionBarViewModel this$0;

        public C01541(CustomActionBarViewModel r1, Continuation<? super C01541> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01541(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            boolean r7 = true;
            String r8 = "";
            String r9 = null;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            List<com.larus.bmhome.actionbar.model.z0> r3 = (List) this.L$1;
            com.larus.network.http.a r4 = (com.larus.network.http.a) this.L$0;
            ResultKt.throwOnFailure(r18);
        L212:
            CustomActionBarViewModel.access$get_actionBarConfList(this.this$0).postValue(r3);
        L213:
            ActionBarCacheStore r5 = ActionBarCacheStore.a;
            String r6 = CustomActionBarViewModel.access$getLangCode$p(this.this$0);
            if (r6 != null) goto L216;
            r6 = "";
        L216:
            String r10 = CustomActionBarViewModel.access$getBotId$p(this.this$0);
            String r11 = CustomActionBarViewModel.access$getScene$p(this.this$0);
            com.larus.bmhome.actionbar.model.x0 r12 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) ((com.larus.network.http.y) r4)).b;
            if (r12 == null) goto L219;
            r9 = r12.f;
        L219:
            Intrinsics.checkNotNullParameter(r6, "langCode");
            FLogger.a.i("ActionBarCacheStore", "store throughToken=" + r9 + ", bot=" + r10 + " scene=" + r11);
            if (r10 == null) goto L242;
            String r13 = com.larus.utils.p0.a(r9);
            if (r13 == null) goto L242;
            String r14 = AccountService.a.getUserId();
            if (r11 == null) goto L228;
            r8 = r11;
        L228:
            String r15 = ActionBarCacheStore.f(r14, r6, r10, r8);
            ActionBarCacheStore.b.storeString(r15 + "-action_bar_through_token", r13);
        L242:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r18);
            Object r16 = r18;
        L41:
            r4 = (com.larus.network.http.a) r16;
            if ((r4 instanceof com.larus.network.http.y) == false) goto L229;
            com.larus.network.http.y r17 = (com.larus.network.http.y) r4;
            com.larus.bmhome.actionbar.model.x0 r19 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            FLogger r110 = FLogger.a;
            StringBuilder r111 = new StringBuilder("actionBarConfResult success, itemSize=");
            if (r19 == null) goto L48;
            ArrayList r112 = r19.a;
            if (r112 == null) goto L48;
            Integer r113 = Boxing.boxInt(r112.size());
        L49:
            r111.append(r113);
            r111.append(", token=");
            if (r19 == null) goto L52;
            String r114 = r19.f;
        L53:
            r111.append(r114);
            r111.append(", offline=");
            if (r19 == null) goto L56;
            Boolean r115 = r19.g;
        L57:
            r111.append(r115);
            r111.append(", actionBarAlwaysOnTop:");
            r111.append(this.this$0.getActionBarAlwaysOnTop());
            r110.i(CustomActionBarViewModel.TAG, r111.toString());
            com.larus.bmhome.actionbar.model.x0 r116 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            if (r116 == null) goto L78;
            ArrayList r117 = r116.a;
            if (r117 == null) goto L78;
            if (r117.isEmpty() == true) goto L78;
            Iterator r118 = r117.iterator();
        L66:
            if (r118.hasNext() == false) goto L78;
            com.larus.bmhome.actionbar.model.p0 r119 = ((com.larus.bmhome.actionbar.model.z0) r118.next()).o;
            if (r119 == null) goto L75;
            Integer r120 = r119.a;
            int r121 = ActiveSwitchType.DEEPTHINK.getValue();
            if (r120 == null) goto L75;
            if (r120.intValue() != r121) goto L75;
            boolean r122 = true;
        L76:
            if (r122 == false) goto L66;
            boolean r123 = true;
        L79:
            if (r123 == true) goto L92;
            String r124 = CustomActionBarViewModel.access$getScene$p(this.this$0);
            if (r124 != null) goto L83;
        L86:
            boolean r125 = true;
        L87:
            if (r125 == false) goto L92;
            com.larus.bmhome.instruction.c r126 = com.larus.bmhome.instruction.c.a;
            String r127 = CustomActionBarViewModel.access$getBotId$p(this.this$0);
            if (r127 != null) goto L91;
            r127 = "";
        L91:
            int r128 = ActiveSwitchType.DEEPTHINK.getValue();
            Intrinsics.checkNotNullParameter(r127, "botId");
            String r129 = com.larus.bmhome.instruction.c.b(r127, r128);
            com.larus.bmhome.instruction.c.c.remove(r129);
            com.larus.bmhome.instruction.c.d.remove(r129);
            goto L92
        L83:
            if (r124.length() == 0) goto L86;
            r125 = false;
        L92:
            String r130 = wa8.n0.a;
            com.larus.bmhome.actionbar.model.x0 r131 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            if (r131 == null) goto L95;
            String r132 = r131.e;
        L96:
            wa8.n0.a = r132;
            com.larus.im.internal.delegate.c0.b.d("ActionBarRedDot", "set redDotText = " + r132);
            CustomActionBarViewModel r133 = this.this$0;
            com.larus.bmhome.actionbar.model.x0 r134 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            if (r134 == null) goto L101;
            Boolean r135 = r134.c;
            if (r135 == null) goto L101;
            boolean r136 = r135.booleanValue();
        L102:
            CustomActionBarViewModel.access$setDisableClientReorder$p(r133, r136);
            CustomActionBarViewModel r137 = this.this$0;
            int r138 = y2.a;
            com.larus.bmhome.actionbar.model.x0 r139 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            if (r139 == null) goto L105;
            ArrayList r140 = r139.a;
        L106:
            y2.a(r140);
            CustomActionBarViewModel.access$setRemoteActionbarList$p(r137, r140);
            CopyOnWriteArraySet<rs8.f> r141 = s1.a;
            List<com.larus.bmhome.actionbar.model.z0> r142 = this.this$0.getRemoteActionbarList();
            Iterator<rs8.f> r143 = s1.a.iterator();
        L108:
            if (r143.hasNext() == false) goto L110;
            r143.next().z1(r142);
            goto L108
        L110:
            List<com.larus.bmhome.actionbar.model.z0> r144 = this.this$0.getRemoteActionbarList();
            if (r144 == null) goto L136;
            CustomActionBarViewModel r145 = this.this$0;
            ArrayList r146 = new ArrayList();
            Iterator<T> r147 = r144.iterator();
        L114:
            if (r147.hasNext() == false) goto L118;
            Object r148 = r147.next();
            if (CustomActionBarViewModel.access$actionMatchLibra(r145, ((com.larus.bmhome.actionbar.model.z0) r148).g) == false) goto L114;
            r146.add(r148);
            goto L114
        L118:
            ArrayList r149 = new ArrayList();
            Iterator r150 = r146.iterator();
        L120:
            if (r150.hasNext() == false) goto L124;
            Object r151 = r150.next();
            if (com.larus.utils.o0.d(((com.larus.bmhome.actionbar.model.z0) r151).e) == false) goto L120;
            r149.add(r151);
            goto L120
        L124:
            ArrayList r152 = new ArrayList();
            Iterator r153 = r149.iterator();
        L126:
            if (r153.hasNext() == false) goto L137;
            Object r154 = r153.next();
            if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r154).s, Boxing.boxBoolean(true)) == true) goto L130;
        L133:
            boolean r155 = true;
        L134:
            if (r155 == false) goto L126;
            r152.add(r154);
            goto L126
        L130:
            if (i3.a.f() == false) goto L133;
            r155 = false;
        L137:
            CustomActionBarViewModel r156 = this.this$0;
            if (r152 == null) goto L140;
            List r157 = CollectionsKt.toMutableList(r152);
        L141:
            CustomActionBarViewModel.access$setRemoteActionBarList$p(r156, r157);
            CustomActionBarViewModel r158 = this.this$0;
            com.larus.bmhome.actionbar.model.x0 r159 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            if (r159 == null) goto L144;
            Boolean r160 = r159.d;
        L145:
            CustomActionBarViewModel.access$setActionBarAlwaysOnTop$p(r158, r160);
            CustomActionBarViewModel r161 = this.this$0;
            com.larus.bmhome.actionbar.model.x0 r20 = (com.larus.bmhome.actionbar.model.x0) ((com.larus.network.http.a) r17).b;
            if (r20 == null) goto L148;
            String r21 = r20.b;
        L149:
            CustomActionBarViewModel.access$setRequestLogId$p(r161, String.valueOf(r21));
            if (CustomActionBarViewModel.access$getDisableClientReorder$p(this.this$0) == false) goto L152;
            List<com.larus.bmhome.actionbar.model.z0> r22 = r152;
        L157:
            FLogger r162 = FLogger.a;
            StringBuilder r163 = new StringBuilder("remote (");
            List<com.larus.bmhome.actionbar.model.z0> r164 = this.this$0.getRemoteActionbarList();
            if (r164 == null) goto L160;
            Integer r165 = Boxing.boxInt(r164.size());
        L161:
            r163.append(r165);
            r163.append("), filter result(");
            if (r152 == null) goto L164;
            Integer r166 = Boxing.boxInt(r152.size());
        L165:
            r163.append(r166);
            r163.append("), resortData(");
            if (r22 == null) goto L168;
            Integer r167 = Boxing.boxInt(r22.size());
        L169:
            r163.append(r167);
            r163.append(')');
            r162.i(CustomActionBarViewModel.TAG, r163.toString());
            com.larus.bmhome.view.actionbar.custom.cache.j r168 = CustomActionBarViewModel.access$getActionBarRedDotCacheHelper(this.this$0);
            String r169 = CustomActionBarViewModel.access$getBotId$p(this.this$0);
            if (r169 != null) goto L172;
            r169 = "";
        L172:
            r168.b(r22, r169);
            if (r22 == null) goto L178;
            CustomActionBarViewModel r170 = this.this$0;
            Iterator<T> r171 = r22.iterator();
        L176:
            if (r171.hasNext() == false) goto L178;
            ((com.larus.bmhome.actionbar.model.z0) r171.next()).A = r170.getRequestLogId();
        L178:
            List<com.larus.bmhome.actionbar.model.z0> r172 = r22;
            if (r172 != null) goto L181;
        L184:
            boolean r173 = true;
        L185:
            if (r173 == false) goto L205;
            if (r19 == null) goto L188;
            boolean r174 = Intrinsics.areEqual(r19.g, Boxing.boxBoolean(true));
        L189:
            if (r174 == true) goto L205;
            ActionBarCacheStore r23 = ActionBarCacheStore.a;
            String r24 = CustomActionBarViewModel.access$getLangCode$p(this.this$0);
            if (r24 != null) goto L193;
            r24 = "";
        L193:
            List r25 = ActionBarCacheStore.c(r24, CustomActionBarViewModel.access$getBotId$p(this.this$0), CustomActionBarViewModel.access$getScene$p(this.this$0), null, 8);
            FLogger r26 = FLogger.a;
            StringBuilder r175 = new StringBuilder("empty action data but no need offline action bar, cacheListSize=");
            if (r25 == null) goto L196;
            Integer r176 = Boxing.boxInt(r25.size());
        L197:
            r175.append(r176);
            r26.e(CustomActionBarViewModel.TAG, r175.toString());
            List r27 = r25;
            if (r27 != null) goto L200;
        L203:
            if (r7 == true) goto L213;
            CustomActionBarViewModel.access$get_actionBarConfList(this.this$0).postValue(r25);
            goto L213
        L200:
            if (r27.isEmpty() == true) goto L203;
            r7 = false;
            goto L203
        L196:
            r176 = null;
            goto L197
        L188:
            r174 = false;
        L205:
            CustomActionBarViewModel r28 = this.this$0;
            String r29 = CustomActionBarViewModel.access$getLangCode$p(r28);
            if (r29 != null) goto L208;
            r29 = "";
        L208:
            this.L$0 = r4;
            this.L$1 = r22;
            this.label = 2;
            if (CustomActionBarViewModel.access$updateLocalCacheFromRemote(r28, r29, r22, this) != r1) goto L211;
            return r1;
        L211:
            r3 = r22;
            goto L212
        L181:
            if (r172.isEmpty() == true) goto L184;
            r173 = false;
            goto L185
        L168:
            r167 = null;
            goto L169
        L164:
            r166 = null;
            goto L165
        L160:
            r165 = null;
            goto L161
        L152:
            CustomActionBarViewModel r30 = this.this$0;
            if (r152 == null) goto L155;
            List r177 = CollectionsKt.toMutableList(r152);
        L156:
            r22 = CustomActionBarViewModel.access$resortActionBarItems(r30, r177, CustomActionBarViewModel.access$getActionBarRankCache(this.this$0));
            goto L157
        L155:
            r177 = null;
            goto L156
        L148:
            r21 = null;
            goto L149
        L144:
            r160 = null;
            goto L145
        L140:
            r157 = null;
            goto L141
        L136:
            r152 = null;
            goto L137
        L105:
            r140 = null;
        L101:
            r136 = true;
            goto L102
        L95:
            r132 = null;
        L75:
            r122 = false;
        L78:
            r123 = false;
            goto L79
        L56:
            r115 = null;
            goto L57
        L52:
            r114 = null;
        L48:
            r113 = null;
            goto L49
        L229:
            FLogger r31 = FLogger.a;
            StringBuilder r32 = new StringBuilder("action bar list request failed, ");
            if ((r4 instanceof com.larus.network.http.f) == false) goto L232;
            com.larus.network.http.f r33 = (com.larus.network.http.f) r4;
        L233:
            if (r33 == null) goto L235;
            r9 = r33.toString();
        L235:
            r32.append(r9);
            r31.e(CustomActionBarViewModel.TAG, r32.toString());
            if (com.larus.platform.service.z2.a.V1() == false) goto L242;
            MutableLiveData r34 = CustomActionBarViewModel.access$get_actionBarConfList(this.this$0);
            CustomActionBarViewModel r35 = this.this$0;
            int r36 = CustomActionBar.c0;
            List r37 = CustomActionBarViewModel.getCacheConfig$default(r35, CustomActionBar.b.a(), null, null, null, 14, null);
            if (r37 != null) goto L240;
            r37 = CollectionsKt.emptyList();
        L240:
            r34.postValue(r37);
            goto L242
        L232:
            r33 = null;
            goto L233
        L10:
            ResultKt.throwOnFailure(r18);
            ActionBarCacheStore r38 = ActionBarCacheStore.a;
            String r39 = CustomActionBarViewModel.access$getLangCode$p(this.this$0);
            if (r39 != null) goto L13;
            r39 = "";
        L13:
            String r178 = CustomActionBarViewModel.access$getBotId$p(this.this$0);
            String r179 = CustomActionBarViewModel.access$getScene$p(this.this$0);
            Intrinsics.checkNotNullParameter(r39, "langCode");
            String r180 = AccountService.a.getUserId();
            if (r178 != null) goto L17;
        L18:
            String r181 = null;
        L22:
            FLogger.a.i(CustomActionBarViewModel.TAG, "updateConfigFromRemote, reqThroughToken = " + r181);
            BotRepo r40 = CustomActionBarViewModel.access$getRepo$p(this.this$0);
            String r182 = CustomActionBarViewModel.access$getLangCode$p(this.this$0);
            if (r182 != null) goto L25;
            String r183 = "";
        L26:
            String r184 = CustomActionBarViewModel.access$getBotId$p(this.this$0);
            if (r184 != null) goto L29;
            String r185 = "";
        L30:
            String r186 = CustomActionBarViewModel.access$getConversationId$p(this.this$0);
            if (r186 != null) goto L33;
            String r187 = "";
        L34:
            String r188 = CustomActionBarViewModel.access$getScene$p(this.this$0);
            if (r188 != null) goto L37;
            String r189 = "";
        L38:
            IBotRepoService.a r190 = new IBotRepoService.a(r183, r185, r187, r189, r181);
            this.label = 1;
            r16 = r40.b(r190, this);
            if (r16 != r1) goto L41;
            return r1;
        L37:
            r189 = r188;
            goto L38
        L33:
            r187 = r186;
            goto L34
        L29:
            r185 = r184;
            goto L30
        L25:
            r183 = r182;
            goto L26
        L17:
            if (ActionBarCacheStore.i(r179) == true) goto L18;
            if (r179 != null) goto L21;
            r179 = "";
        L21:
            String r41 = ActionBarCacheStore.f(r180, r39, r178, r179);
            r181 = ActionBarCacheStore.b.getString(r41 + "-action_bar_through_token", null);
            goto L22
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ com.larus.bmhome.view.actionbar.custom.cache.j Mo() {
        return actionBarRedDotCacheHelper_delegate$lambda$0();
    }

    public static /* synthetic */ Unit No() {
        return executeOnClickAction$lambda$19();
    }

    public static /* synthetic */ Unit Oo(CustomActionBarViewModel r0, String r1, List r2) {
        return updateLocalCacheFromRemote$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ Keva Po() {
        return cache_delegate$lambda$3();
    }

    public static /* synthetic */ com.larus.bmhome.view.actionbar.custom.cache.d Qo() {
        return actionBarMenuRedDotCacheHelper_delegate$lambda$1();
    }

    public static /* synthetic */ MutableLiveData So() {
        return _actionBarConfList_delegate$lambda$4();
    }

    public static /* synthetic */ boolean To(CustomActionBarViewModel r0, Function1 r1, com.larus.bmhome.actionbar.model.z0 r2) {
        return getCacheConfig$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ ISdkMinutesService yo() {
        return sdkMinutesService_delegate$lambda$2();
    }

    private static final MutableLiveData _actionBarConfList_delegate$lambda$4() {
        return new MutableLiveData();
    }

    private static final com.larus.bmhome.view.actionbar.custom.cache.d actionBarMenuRedDotCacheHelper_delegate$lambda$1() {
        return new com.larus.bmhome.view.actionbar.custom.cache.d();
    }

    private static final com.larus.bmhome.view.actionbar.custom.cache.j actionBarRedDotCacheHelper_delegate$lambda$0() {
        return new com.larus.bmhome.view.actionbar.custom.cache.j();
    }

    private static final Keva cache_delegate$lambda$3() {
        return Keva.getRepo(CACHE_FILE);
    }

    private static final Unit executeOnClickAction$lambda$19() {
        t19.s r0 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        r0.getClass();
        t19.s.b(r1, 2131908080, false);
        return Unit.INSTANCE;
    }

    private final com.larus.bmhome.view.actionbar.custom.cache.d getActionBarMenuRedDotCacheHelper() {
        return (com.larus.bmhome.view.actionbar.custom.cache.d) this.actionBarMenuRedDotCacheHelper$delegate.getValue();
    }

    private final List<String> getActionBarRankCache() {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "getActionBarRankCache");
        String r1 = this.botId;
        if (r1 == null) goto L5;
        String r2 = getCache().getString(getActionBarRankCacheKey(AccountService.a.getUserId(), r1), "");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        r0.i(TAG, "getActionBarRankCache, has no cache");
        return CollectionsKt.emptyList();
    L16:
        ArrayList r4 = new ArrayList();
        r4.addAll((List) HttpExtKt.f.fromJson(r2, new b().getType()));     // Catch: Exception -> L19
    L21:
        FLogger.a.i(TAG, "getActionBarRankCache resort uniqueId: " + CollectionsKt.joinToString$default(r4, ", ", null, null, 0, null, null, 62, null));
        return r4;
    L19:
        e = move-exception;
        FLogger.a.e(TAG, "getActionBarRankCache, err.msg=" + e.getMessage());
        goto L21
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        return CollectionsKt.emptyList();
    }

    private final com.larus.bmhome.view.actionbar.custom.cache.j getActionBarRedDotCacheHelper() {
        return (com.larus.bmhome.view.actionbar.custom.cache.j) this.actionBarRedDotCacheHelper$delegate.getValue();
    }

    private final Keva getCache() {
        return (Keva) this.cache$delegate.getValue();
    }

    private final String getSceneString() {
        String r0 = this.scene;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final ISdkMinutesService getSdkMinutesService() {
        return (ISdkMinutesService) this.sdkMinutesService$delegate.getValue();
    }

    private final MutableLiveData<List<com.larus.bmhome.actionbar.model.z0>> get_actionBarConfList() {
        return (MutableLiveData) this._actionBarConfList$delegate.getValue();
    }

    private static final ISdkMinutesService sdkMinutesService_delegate$lambda$2() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L5;
        r0.y();
        return com.larus.home.impl.sdk.t1.a;
    L5:
        return null;
    }

    public final String getLastClickActionBarKey() {
        String r0 = this.lastClickActionBarKey;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final void reCheckAndUpdateHasRedDot() {
        com.larus.bmhome.view.actionbar.custom.cache.j r1 = getActionBarRedDotCacheHelper();
        String r2 = this.botId;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "botId");
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((LinkedHashMap) r1.b).entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L23;
        Map.Entry r5 = (Map.Entry) r4.next();
        long r6 = ((Number) r5.getKey()).longValue();
        com.larus.bmhome.actionbar.model.z0 r7 = (com.larus.bmhome.actionbar.model.z0) r5.getValue();
        com.larus.bmhome.view.actionbar.custom.cache.g r8 = r1.c(r2, String.valueOf(r7.a));
        Long r9 = r7.t;
        if (r9 == null) goto L11;
        long r10 = r9.longValue();
    L13:
        if (r8.c() >= r10) goto L15;
    L20:
        boolean r11 = true;
    L21:
        if (r11 == true) goto L7;
        r7.y = false;
        r3.add(Long.valueOf(r6));
        goto L7
    L15:
        if (r8.c() == r10) goto L17;
    L19:
        r11 = false;
        goto L21
    L17:
        if (r8.b() >= r1.d) goto L19;
    L11:
        r10 = 0;
        goto L13
    L23:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r3.iterator();
    L25:
        if (r13.hasNext() == false) goto L31;
        long r14 = ((Number) r13.next()).longValue();
        Map<Long, com.larus.bmhome.actionbar.model.z0> r15 = r1.b;
        LinkedHashMap r16 = (LinkedHashMap) r15;
        com.larus.bmhome.actionbar.model.z0 r17 = (com.larus.bmhome.actionbar.model.z0) r16.get(Long.valueOf(r14));
        if (r17 == null) goto L25;
        r1.b.remove(Long.valueOf(r14));
        r1.a.remove(String.valueOf(r17.a));
        Long r18 = r17.a;
        if (r18 == null) goto L25;
        r12.add(Long.valueOf(r18.longValue()));
        goto L25
    L31:
        List r19 = (List) this.actionBarConfList.getValue();
        if (r19 == null) goto L61;
        List r20 = r19;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L35:
        if (r22.hasNext() == false) goto L45;
        com.larus.bmhome.actionbar.model.z0 r23 = (com.larus.bmhome.actionbar.model.z0) r22.next();
        if (CollectionsKt.contains(r12, r23.a) == false) goto L39;
        com.larus.bmhome.actionbar.model.z0 r24 = com.larus.bmhome.actionbar.model.z0.a(r23, null, null, null, null, null, null, null, null, null, null, null, null, false, -16777217);
    L40:
        Iterator r25 = ((Set) com.larus.bmhome.view.actionbar.custom.cache.j.h.getValue()).iterator();
    L42:
        if (r25.hasNext() == false) goto L44;
        ((IActionBarRedDotChecker) r25.next()).b();
        goto L42
    L44:
        r21.add(r24);
        goto L35
    L39:
        r24 = com.larus.bmhome.actionbar.model.z0.a(r23, null, null, null, null, null, null, null, null, null, null, null, null, false, -1);
        goto L40
    L45:
        get_actionBarConfList().setValue(r21);
        return;
    }

    public CustomActionBarViewModel() {
        this.actionBarRedDotCacheHelper$delegate = LazyKt.lazy(new r2());
        this.actionBarMenuRedDotCacheHelper$delegate = LazyKt.lazy(new s2());
        this.sdkMinutesService$delegate = LazyKt.lazy(new t2());
        this.cache$delegate = LazyKt.lazy(new u2());
        RepoDispatcher.a.getClass();
        this.repo = RepoDispatcher.g;
        this.conversationId = "";
        this._actionBarConfList$delegate = LazyKt.lazy(new v2());
        this.actionBarConfList = get_actionBarConfList();
        this._actionBarLoadingMap = new LinkedHashMap();
        this.actionBarReportVersionMap = new LinkedHashMap();
        this.disableClientReorder = true;
        this.requestLogId = "";
    }

    public final int getDeepThinkPosition() {
        List r0 = (List) get_actionBarConfList().getValue();
        if (r0 == null) goto L22;
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L26;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.larus.bmhome.actionbar.model.p0 r5 = ((com.larus.bmhome.actionbar.model.z0) r3).o;
        if (r5 == null) goto L18;
        Integer r6 = r5.a;
        int r7 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r6 == null) goto L18;
        if (r6.intValue() != r7) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L20;
        r2 = r4;
        goto L6
    L20:
        return r2;
    L18:
        r8 = false;
        goto L19
    L26:
        return -1;
    L22:
        return -1;
    }

    public final Boolean getActionBarAlwaysOnTop() {
        return this.actionBarAlwaysOnTop;
    }

    public final LiveData<List<com.larus.bmhome.actionbar.model.z0>> getActionBarConfList() {
        return this.actionBarConfList;
    }

    public final String getBotLanguageCode() {
        return this.langCode;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final List<com.larus.bmhome.actionbar.model.z0> getRemoteActionbarList() {
        return this.remoteActionbarList;
    }

    public final String getRequestLogId() {
        return this.requestLogId;
    }

    public static final /* synthetic */ List access$getActionBarRankCache(CustomActionBarViewModel r0) {
        return r0.getActionBarRankCache();
    }

    public static final /* synthetic */ com.larus.bmhome.view.actionbar.custom.cache.j access$getActionBarRedDotCacheHelper(CustomActionBarViewModel r0) {
        return r0.getActionBarRedDotCacheHelper();
    }

    public static final /* synthetic */ Map access$getActionBarReportVersionMap$p(CustomActionBarViewModel r0) {
        return r0.actionBarReportVersionMap;
    }

    public static final /* synthetic */ String access$getBotId$p(CustomActionBarViewModel r0) {
        return r0.botId;
    }

    public static final /* synthetic */ String access$getConversationId$p(CustomActionBarViewModel r0) {
        return r0.conversationId;
    }

    public static final /* synthetic */ boolean access$getDisableClientReorder$p(CustomActionBarViewModel r0) {
        return r0.disableClientReorder;
    }

    public static final /* synthetic */ String access$getLangCode$p(CustomActionBarViewModel r0) {
        return r0.langCode;
    }

    public static final /* synthetic */ BotRepo access$getRepo$p(CustomActionBarViewModel r0) {
        return r0.repo;
    }

    public static final /* synthetic */ String access$getScene$p(CustomActionBarViewModel r0) {
        return r0.scene;
    }

    public static final /* synthetic */ ISdkMinutesService access$getSdkMinutesService(CustomActionBarViewModel r0) {
        return r0.getSdkMinutesService();
    }

    public static final /* synthetic */ MutableLiveData access$get_actionBarConfList(CustomActionBarViewModel r0) {
        return r0.get_actionBarConfList();
    }

    public static final /* synthetic */ Map access$get_actionBarLoadingMap$p(CustomActionBarViewModel r0) {
        return r0._actionBarLoadingMap;
    }

    private final boolean actionMatchLibra(Integer r4) {
        int r0 = ActionBarExecutionType.COMPLEX_SEARCH.getValue();
        if (r4 != null) goto L6;
    L8:
        return true;
    L6:
        if (r4.intValue() != r0) goto L8;
        CoroutineScope r5 = ExpertSwitchManager.a;
        boolean r6 = FeatureKitDelegate.b.Y().b();
        FLogger.a.w(TAG, "complex search matched = " + r6);
        return r6;
    }

    private final void checkSaaSSubConversation(wc9.e r3) {
        if (ic8.n.v(r3) == false) goto L7;
        FLogger.a.i(TAG, "checkSaaSSubConversation is main conversation");
        return;
    L7:
        if (ic8.n.E(r3) == false) goto L10;
        FLogger.a.i(TAG, "checkSaaSSubConversation is toutiao conversation");
        this.scene = SCENE_TOUTIAO;
        return;
    }

    private final void handleActionBarOpResult(com.larus.bmhome.actionbar.model.a1 r24) {
        if (r24 != null) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("actionBarOpResult key=");
        r3.append(r24.b);
        r3.append(", opResult=");
        com.larus.bmhome.actionbar.model.h0 r4 = r24.c;
        Integer r5 = null;
        if (r4 == null) goto L8;
        Boolean r6 = r4.a;
    L9:
        r3.append(r6);
        r2.i(TAG, r3.toString());
        List r7 = (List) this.actionBarConfList.getValue();
        if (r7 == null) goto L22;
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L13:
        if (r10.hasNext() == false) goto L21;
        com.larus.bmhome.actionbar.model.z0 r11 = (com.larus.bmhome.actionbar.model.z0) r10.next();
        if (Intrinsics.areEqual(r11.a, r24.a) == false) goto L18;
        r11 = com.larus.bmhome.actionbar.model.z0.a(handleRedDotItemHasClicked(r11), null, null, null, null, null, null, null, r24.c, null, null, null, r24.d, false, -2105345);
    L20:
        r9.add(r11);
        goto L13
    L18:
        if (Intrinsics.areEqual(r11.b, r24.b) == false) goto L20;
        r11 = com.larus.bmhome.actionbar.model.z0.a(r11, null, null, null, null, null, null, null, r24.c, null, null, null, null, false, -8193);
        goto L20
    L21:
        get_actionBarConfList().setValue(r9);
    L22:
        List r12 = (List) get_actionBarConfList().getValue();
        if (r12 == null) goto L33;
        Iterator r13 = r12.iterator();
        int r14 = 0;
    L26:
        if (r13.hasNext() == false) goto L31;
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r13.next()).b, r24.b) == true) goto L32;
        r14 = r14 + 1;
    L32:
        r5 = Integer.valueOf(r14);
        goto L33
    L31:
        r14 = -1;
    L33:
        FLogger.a.i(TAG, "initBar, actionBarCofList actionBarOpResult, position=" + r5);
        return;
    L8:
        r6 = null;
        goto L9
    }

    private final com.larus.bmhome.actionbar.model.z0 handleRedDotItemHasClicked(com.larus.bmhome.actionbar.model.z0 r17) {
        if (r17.y == true) goto L5;
        return r17;
    L5:
        com.larus.bmhome.view.actionbar.custom.cache.j r1 = getActionBarRedDotCacheHelper();
        String r2 = this.botId;
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        return com.larus.bmhome.actionbar.model.z0.a(r17, null, null, null, null, null, null, null, null, null, null, null, null, r1.a(r2, String.valueOf(r17.a)), -16777217);
    }

    private final void refreshStylePromptList(LifecycleCoroutineScope r8) {
        if (com.larus.platform.service.z2.a.A1() == false) goto L5;
        return;
    L5:
        String r0 = this.langCode;
        if (r0 != null) goto L8;
        int r1 = CustomActionBar.c0;
        r0 = CustomActionBar.b.a();
    L8:
        BuildersKt.launch$default(r8, Dispatchers.getIO(), null, new C01521(r0, null), 2, null);
    }

    public final Object checkCoCoCOnvRemote(Continuation<? super Boolean> r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r11 = r0;
        Object r16 = r11.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r11.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L47:
        wc9.e r17 = (wc9.e) r16;
        if (r17 == null) goto L52;
        this.conversationId = r17.a;
        return Boxing.boxBoolean(true);
    L52:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
    L27:
        wc9.e r18 = (wc9.e) r16;
    L29:
        if (ic8.n.D(r18) == false) goto L31;
        wc9.e r4 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r4 == null) goto L35;
        String r5 = r4.a;
    L36:
        String r6 = r5;
        RepoDispatcher.a.getClass();
        ConversationRepo r7 = RepoDispatcher.f;
        String r8 = this.botId;
        if (r8 != null) goto L39;
        r8 = "";
    L39:
        if (r18 == null) goto L43;
        Integer r19 = r18.v;
        if (r19 == null) goto L43;
        int r9 = r19.intValue();
    L44:
        r11.label = 2;
        r16 = IConversationRepoService.a.a(r7, r8, r9, r6, null, false, null, null, null, null, r11, 504);
        if (r16 != r2) goto L47;
        return r2;
    L43:
        r9 = 2;
        goto L44
    L35:
        r5 = null;
        goto L36
    L31:
        return Boxing.boxBoolean(true);
    L16:
        ResultKt.throwOnFailure(r16);
        Lazy r110 = com.larus.im.j.a;
        if (com.larus.im.j.f(this.conversationId) == false) goto L54;
        r18 = IAIChatControlTraceService.a.h(ChatControlTrace.b, this.conversationId);
        if (r18 != null) goto L29;
        RepoDispatcher.a.getClass();
        ConversationRepo r10 = RepoDispatcher.f;
        String r111 = this.conversationId;
        if (r111 != null) goto L23;
        String r12 = "";
    L24:
        r11.label = 1;
        r16 = IConversationRepoService.a.c(r10, r12, true, null, r11, 4);
        if (r16 != r2) goto L27;
        return r2;
    L23:
        r12 = r111;
        goto L24
    L54:
        return Boxing.boxBoolean(true);
    L7:
        r0 = new AnonymousClass1(this, r15);
        goto L8
    }

    public final kotlinx.coroutines.flow.i1<Boolean> getActionBarLoadingStatusFlow(String r3) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        if (this._actionBarLoadingMap.get(r3) != null) goto L6;
        this._actionBarLoadingMap.put(r3, kotlinx.coroutines.flow.j1.a(Boolean.FALSE));
    L6:
        return this._actionBarLoadingMap.get(r3);
    }

    public final Pair<Boolean, String> getCotExceedQuotaConfig(String r9) {
        com.larus.bmhome.view.actionbar.custom.cache.d r0 = getActionBarMenuRedDotCacheHelper();
        if (r9 != null) goto L5;
        r0.getClass();
    L21:
        return null;
    L5:
        String r2 = r0.b().getString(((String) r0.d.getValue()) + "-cot_exceed_quota_config-" + r9, "");
        Intrinsics.checkNotNull(r2);
        boolean r1 = false;
        if (r2.length() != 0) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L21;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L19
        List r12 = StringsKt.split$default(r2, new String[]{"&"}, false, 0, 6, null);     // Catch: Throwable -> L19
        if (r12.size() == 2) goto L14;
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        goto L21
    L14:
        if (System.currentTimeMillis() < CastLongProtector.parseLong((String) ListProtector.get(r12, 0))) goto L24;
        r1 = true;
    L24:
        return TuplesKt.to(Boolean.valueOf(r1), ListProtector.get(r12, 1));
    L19:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L8:
        r10 = false;
        goto L9
    }

    public final void reRefreshActionHiddenStatus(boolean r20) {
        List r1 = (List) this.actionBarConfList.getValue();
        if (r1 == null) goto L16;
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        com.larus.bmhome.actionbar.model.z0 r5 = (com.larus.bmhome.actionbar.model.z0) r4.next();
        if (Intrinsics.areEqual(r5.b, "coco_spring_pocket") == false) goto L10;
        r5 = com.larus.bmhome.actionbar.model.z0.a(r5, null, null, null, null, null, null, null, null, null, Boolean.valueOf(r20), null, null, false, -131073);
    L10:
        r3.add(r5);
        goto L6
    L11:
        get_actionBarConfList().setValue(r3);
        return;
    }

    public final void saveActionBarNewRank(com.larus.bmhome.actionbar.model.z0 r15) {
        Intrinsics.checkNotNullParameter(r15, "clickedActionBar");
        if (this.disableClientReorder == false) goto L5;
        return;
    L5:
        String r0 = this.botId;
        if (r0 != null) goto L8;
        return;
    L8:
        FLogger.a.i(TAG, "saveActionBarNewRank, actionbar(" + wa8.k1.a(r15) + ')');
        String r1 = (String) CollectionsKt.firstOrNull(getActionBarRankCache());
        if (Intrinsics.areEqual(wa8.k1.a(r15), r1) == false) goto L11;
        return;
    L11:
        ArrayList r5 = CollectionsKt.arrayListOf(new String[]{wa8.k1.a(r15)});
        if (r1 == null) goto L25;
        r5.add(r1);
    L25:
        getCache().storeString(getActionBarRankCacheKey(AccountService.a.getUserId(), r0), HttpExtKt.f.toJson(r5));     // Catch: Exception -> L16
    L18:
        FLogger.a.i(TAG, "saveActionBarNewRank, resort uniqueId: " + CollectionsKt.joinToString$default(r5, ", ", null, null, 0, null, null, 62, null));
        List<com.larus.bmhome.actionbar.model.z0> r16 = this.remoteActionBarList;
        if (r16 == null) goto L27;
        List<com.larus.bmhome.actionbar.model.z0> r17 = resortActionBarItems(r16, getActionBarRankCache());
        String r2 = this.langCode;
        if (r2 != null) goto L23;
        r2 = "";
    L23:
        updateLocalCache(r2, r17);
        return;
    L27:
        return;
    L16:
        e = move-exception;
        FLogger.a.e(TAG, "saveActionBarRank, error=" + e.getMessage());
        goto L18
    }

    public final void setCotExceedQuotaConfig(String r17) {
        Intrinsics.checkNotNullParameter(r17, "cotExceedQuotaConfig");
        com.larus.bmhome.view.actionbar.custom.cache.d r2 = getActionBarMenuRedDotCacheHelper();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r17, "cotExceedQuotaConfig");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        JSONArray r0 = new JSONObject(r17).optJSONArray("exceed_detail");     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        int r3 = r0.length();     // Catch: Throwable -> L10
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L8;
        JSONObject r6 = JSONArrayProtectorUtils.getJSONObject(r0, r5);     // Catch: Throwable -> L10
        ModelItemIdentity r9 = new ModelItemIdentity(r6.optString("item_key", ""), Integer.valueOf(r6.optInt("item", -1)));     // Catch: Throwable -> L10
        long r7 = r6.optLong("waiting_dur_ms", -1);     // Catch: Throwable -> L10
        String r8 = r6.optString("starling_key", "");     // Catch: Throwable -> L10
        Keva r10 = r2.b();     // Catch: Throwable -> L10
        String r11 = ((String) r2.d.getValue()) + "-cot_exceed_quota_config-" + r9.getKey();     // Catch: Throwable -> L10
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L10
        Calendar r13 = Calendar.getInstance();     // Catch: Throwable -> L10
        r13.add(6, 1);     // Catch: Throwable -> L10
        r13.set(11, 0);     // Catch: Throwable -> L10
        r13.set(12, 0);     // Catch: Throwable -> L10
        r13.set(13, 0);     // Catch: Throwable -> L10
        r13.set(14, 0);     // Catch: Throwable -> L10
        r12.append(Math.min(r13.getTimeInMillis(), System.currentTimeMillis() + r7));     // Catch: Throwable -> L10
        r12.append('&');     // Catch: Throwable -> L10
        r12.append(r8);     // Catch: Throwable -> L10
        r10.storeString(r11, r12.toString());     // Catch: Throwable -> L10
        r5 = r5 + 1;     // Catch: Throwable -> L10
    L8:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void updateConfigFromRemote(LifecycleCoroutineScope r8) {
        Intrinsics.checkNotNullParameter(r8, "lifecycleScope");
        refreshStylePromptList(r8);
        BuildersKt.launch$default(r8, null, null, new C01541(this, null), 3, null);
    }

    public final void updateOnItemClick(Long r5) {
        if (r5 == null) goto L21;
        r5.longValue();
        List r0 = (List) this.actionBarConfList.getValue();
        if (r0 == null) goto L22;
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L15;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) r3.next();
        if (Intrinsics.areEqual(r4.a, r5) == false) goto L14;
        com.larus.bmhome.actionbar.model.z0 r6 = handleRedDotItemHasClicked(r4);
        if (r6 == null) goto L14;
        r4 = r6;
    L14:
        r2.add(r4);
        goto L7
    L15:
        get_actionBarConfList().setValue(r2);
        return;
    L22:
        return;
    }

    public static final /* synthetic */ boolean access$actionMatchLibra(CustomActionBarViewModel r0, Integer r1) {
        return r0.actionMatchLibra(r1);
    }

    public static final /* synthetic */ void access$handleActionBarOpResult(CustomActionBarViewModel r0, com.larus.bmhome.actionbar.model.a1 r1) {
        r0.handleActionBarOpResult(r1);
    }

    public static final /* synthetic */ void access$setActionBarAlwaysOnTop$p(CustomActionBarViewModel r0, Boolean r1) {
        r0.actionBarAlwaysOnTop = r1;
    }

    public static final /* synthetic */ void access$setDisableClientReorder$p(CustomActionBarViewModel r0, boolean r1) {
        r0.disableClientReorder = r1;
    }

    public static final /* synthetic */ void access$setRemoteActionBarList$p(CustomActionBarViewModel r0, List r1) {
        r0.remoteActionBarList = r1;
    }

    public static final /* synthetic */ void access$setRemoteActionbarList$p(CustomActionBarViewModel r0, List r1) {
        r0.remoteActionbarList = r1;
    }

    public static final /* synthetic */ void access$setRequestLogId$p(CustomActionBarViewModel r0, String r1) {
        r0.requestLogId = r1;
    }

    private final String getActionBarRankCacheKey(String r3, String r4) {
        IActionBarService r0 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r0 == null) goto L5;
        String r1 = r0.n();
    L7:
        return r3 + '-' + r4 + '-' + getSceneString() + "-actionbar-rank" + r1;
    L5:
        r1 = null;
        goto L7
    }

    private final void handleMultiSuggestActionBarClick(com.larus.bmhome.actionbar.model.z0 r9, BaseContentWidget r10) {
        reportActionBarOpResult$default(this, r9, null, false, null, false, 28, null);
        if (r10 == null) goto L8;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Fragment r11 = com.larus.ui.arch.component.internal.attach.a.b(r10, r10);
        if (r11 == null) goto L9;
        o r0 = new o(r11, r9.v);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0.a), Dispatchers.getIO(), null, new ActionBarSuggestActionHelper$doDispatch$1(r0, null), 2, null);
        return;
    L9:
        return;
    }

    private final void handleRecordActionBarClick(com.larus.bmhome.actionbar.model.z0 r19, Boolean r20) {
        boolean r0 = Intrinsics.areEqual(r19.b, "coco_ai_simul_interpret");
        AudioServiceDelegate r9 = AudioServiceDelegate.a;
        boolean r1 = r9.P().g();
        ISdkMinutesService r2 = getSdkMinutesService();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L17;
        ISdkMinutesService r4 = getSdkMinutesService();
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L17;
        boolean r6 = true;
    L18:
        if (r1 == true) goto L56;
        if (r3 == true) goto L56;
        int r7 = 2131907353;
        if (r9.y0() == false) goto L28;
        t19.s r8 = t19.s.a;
        Application r10 = AppHost.a.getApplication();
        if (r0 == false) goto L26;
        r7 = 2131898365;
    L26:
        r8.getClass();
        t19.s.s(r10, r7);
        return;
    L28:
        if (r0 == false) goto L30;
    L33:
        boolean r11 = true;
    L34:
        if (r11 == false) goto L44;
        long r12 = SystemClock.elapsedRealtime();
        long r14 = this.lastNewRecordActionBarClickAtMs;
        this.lastNewRecordActionBarClickAtMs = r12;
        if (r14 == 0) goto L44;
        if ((r12 - r14) >= NEW_RECORD_ACTION_BAR_CLICK_INTERVAL_MS) goto L44;
        FLogger.a.w(TAG, "Ignore repeated new recording action bar click");
        t19.s r13 = t19.s.a;
        Application r15 = AppHost.a.getApplication();
        if (r0 == false) goto L42;
        r7 = 2131898365;
    L42:
        r13.getClass();
        t19.s.s(r15, r7);
        return;
    L44:
        String r16 = this.conversationId;
        if (r16 == null) goto L49;
        ISdkMinutesService r17 = getSdkMinutesService();
        if (r17 == null) goto L49;
        r17.o(r16, r0);
    L49:
        handleUserSendMsg$default(this, r19, null, null, 6, null);
        reportActionBarOpResult$default(this, r19, r20, true, null, false, 24, null);
        if (r11 == false) goto L54;
        ISdkMinutesService r18 = getSdkMinutesService();
        if (r18 == null) goto L86;
        r18.B0();
        return;
    L86:
        return;
    L54:
        r9.t(true);
        return;
    L30:
        if (com.larus.platform.service.z2.a.getAudioRecordConfig().a() == true) goto L33;
        r11 = false;
    L56:
        if (r0 == r6) goto L63;
        int r21 = com.larus.utils.j0.a;
        if (r0 == false) goto L60;
        int r22 = 2131898357;
    L61:
        String r23 = com.larus.utils.j0.d(r22);
        t19.s r24 = t19.s.a;
        Application r25 = AppHost.a.getApplication();
        r24.getClass();
        t19.s.t(r25, r23);
        return;
    L60:
        r22 = 2131898364;
        goto L61
    L63:
        FragmentActivity r26 = AppHost.a.a().getCurrentActivity();
        if ((r26 instanceof FragmentActivity) == false) goto L66;
        FragmentActivity r27 = r26;
    L67:
        if (r27 == null) goto L88;
        FragmentManager r28 = r27.getSupportFragmentManager();
        if (r28 == null) goto L89;
        CommonDialog.a r29 = new CommonDialog.a();
        if (r0 == false) goto L73;
        int r30 = com.larus.utils.j0.a;
        r29.i(com.larus.utils.j0.d(2131898373));
        r29.b = false;
    L74:
        c r31 = new c(r0, this);
        int r32 = com.larus.utils.j0.a;
        if (r0 == false) goto L77;
        int r33 = 2131898375;
    L78:
        CommonDialog.a.f(r29, r31, com.larus.utils.j0.d(r33), false, 12);
        d r34 = new d(r0);
        if (r0 == false) goto L81;
        int r35 = 2131898372;
    L82:
        CommonDialog.a.e(r29, r34, com.larus.utils.j0.d(r35), 4);
        INVOKEVIRTUAL_com_larus_bmhome_view_actionbar_custom_CustomActionBarViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r29.a(), r28, null);
        if (r0 == false) goto L90;
        com.larus.platform.service.o.a.b("popup_show", com.larus.utils.f.c(new Pair[]{TuplesKt.to("popup_type", POPUP_TYPE_INTERPRET_CLOSE_CONFIRM)}));
        return;
    L90:
        return;
    L81:
        r35 = 2131907330;
        goto L82
    L77:
        r33 = 2131907331;
        goto L78
    L73:
        int r36 = com.larus.utils.j0.a;
        r29.i(com.larus.utils.j0.d(2131907333));
        r29.g(com.larus.utils.j0.d(2131907332));
        goto L74
    L89:
        return;
    L88:
        return;
    L66:
        r27 = null;
        goto L67
    L12:
        if (r4.j() != true) goto L14;
        r5 = true;
    L17:
        r6 = false;
        goto L18
    L5:
        if (r2.y0() != true) goto L7;
        r3 = true;
        goto L8
    }

    private final List<com.larus.bmhome.actionbar.model.z0> resortActionBarItems(List<com.larus.bmhome.actionbar.model.z0> r12, List<String> r13) {
        if (r13.isEmpty() == false) goto L5;
        return r12;
    L5:
        List<com.larus.bmhome.actionbar.model.z0> r0 = r12;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L13:
        if (r1 == false) goto L15;
        return null;
    L15:
        ArrayList r2 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L46;
        List r4 = StringsKt.split$default((String) r14.next(), new String[]{"&"}, false, 0, 6, null);
        if (r4.isEmpty() == true) goto L45;
        if (r4.size() <= 1) goto L45;
        String r5 = (String) ListProtector.get(r4, 0);
        String r6 = (String) ListProtector.get(r4, 1);
        if (r12 == null) goto L17;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r12.iterator();
    L27:
        if (r8.hasNext() == false) goto L42;
        Object r9 = r8.next();
        com.larus.bmhome.actionbar.model.z0 r10 = (com.larus.bmhome.actionbar.model.z0) r9;
        if (Intrinsics.areEqual(r10.b, r5) == false) goto L39;
        com.larus.bmhome.actionbar.model.r r11 = r10.q;
        if (r11 == null) goto L35;
        Integer r15 = r11.a;
        if (r15 == null) goto L35;
        String r16 = r15.toString();
    L37:
        if (Intrinsics.areEqual(r6, r16) == false) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == false) goto L27;
        r7.add(r9);
    L35:
        r16 = null;
    L39:
        r17 = false;
        goto L40
    L42:
        com.larus.bmhome.actionbar.model.z0 r18 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r7, 0);
        if (r18 == null) goto L17;
        r2.add(r18);
    L45:
        return r12;
    L46:
        if (r12 == null) goto L48;
        r12.removeAll(r2);
    L48:
        if (r12 == null) goto L50;
        r2.addAll(r12);
    L50:
        return r2;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L13
    }

    private final void updateConfigFromRemote(LifecycleCoroutineScope r8, boolean r9) {
        if (r9 == false) goto L4;
        updateConfigFromRemote(r8);
        return;
    L4:
        MutableLiveData<List<com.larus.bmhome.actionbar.model.z0>> r10 = get_actionBarConfList();
        int r11 = CustomActionBar.c0;
        List r12 = getCacheConfig$default(this, CustomActionBar.b.a(), null, null, null, 14, null);
        if (r12 != null) goto L7;
        r12 = CollectionsKt.emptyList();
    L7:
        r10.postValue(r12);
    }

    private final void updateSwitchStateInCache(com.larus.bmhome.actionbar.model.z0 r6, Boolean r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        List r0 = (List) this.actionBarConfList.getValue();
        if (r0 == null) goto L15;
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L16;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) r3.next();
        if (Intrinsics.areEqual(r4.b, r6.b) == false) goto L14;
        com.larus.bmhome.actionbar.model.h0 r5 = r4.n;
        if (r5 == null) goto L14;
        r5.a = r7;
    L14:
        r2.add(r4);
    L16:
        String r8 = this.langCode;
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        updateLocalCache(r8, r2);
        return;
    L15:
        r2 = null;
        goto L16
    }

    public final void checkAndUpdateMenuHasRedDot(String r13, List<com.larus.bmhome.actionbar.model.b2> r14) {
        Intrinsics.checkNotNullParameter(r13, "itemId");
        com.larus.bmhome.view.actionbar.custom.cache.d r0 = getActionBarMenuRedDotCacheHelper();
        String r1 = this.botId;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, "itemKey");
        Intrinsics.checkNotNullParameter(r1, "botId");
        if (r14 == null) goto L25;
        Iterator<T> r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L38;
        com.larus.bmhome.actionbar.model.b2 r2 = (com.larus.bmhome.actionbar.model.b2) r15.next();
        ModelItemIdentity r3 = r2.b();
        if (r3 == null) goto L9;
        String r4 = r3.getKey();
        if (r4 == null) goto L9;
        Long r5 = r2.i;
        if (r5 == null) goto L17;
        long r6 = r5.longValue();
    L18:
        long r8 = r6;
        com.larus.bmhome.view.actionbar.custom.cache.g r7 = r0.d(r1, r13.toString(), r4);
        r2.u = r0.a(r7, r8);
        FLogger r9 = FLogger.a;
        r9.i("ActionBarMenuRedDotCacheHelper", "cache itemId=" + r13 + ", menuItemId=" + r4 + ", itemVersion=" + r7.c() + ", redDotVersion=" + r2.i + ", hasRedDot=" + r2.u + ",maxExposureTimes:" + r0.b + ",itemRedEntity.exposureTimes:" + r7.b() + ' ');
        String r10 = com.larus.bmhome.view.actionbar.custom.cache.d.c(r13, r4, r1);
        if (r8 == r7.c()) goto L9;
        String r11 = HttpExtKt.f.toJson(com.larus.bmhome.view.actionbar.custom.cache.g.a(r7, null, r8, 0, 1));     // Catch: Exception -> L23
        r0.b().storeString(r10, r11);     // Catch: Exception -> L23
        r9.i("ActionBarMenuRedDotCacheHelper", "checkAndUpdateHasRedDot save cache newEntityString=" + r11);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        FLogger.a.e("ActionBarMenuRedDotCacheHelper", "checkAndUpdateHasRedDot save cache error=" + e.getMessage());
        goto L9
    L17:
        r6 = 0;
        goto L18
    L38:
        return;
    }

    public final void handleMenuRedDotItemHasClicked(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "itemId");
        Intrinsics.checkNotNullParameter(r13, "menuItemId");
        com.larus.bmhome.view.actionbar.custom.cache.d r1 = getActionBarMenuRedDotCacheHelper();
        String r2 = this.botId;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r12, "itemKey");
        Intrinsics.checkNotNullParameter(r13, "menuItemId");
        String r0 = com.larus.bmhome.view.actionbar.custom.cache.d.c(r12, r13, r2);
        String r14 = HttpExtKt.f.toJson(com.larus.bmhome.view.actionbar.custom.cache.g.a(r1.d(r2, r12, r13), null, 0, 99999999, 3));     // Catch: Exception -> L8
        r1.b().storeString(r0, r14);     // Catch: Exception -> L8
        FLogger.a.i("ActionBarMenuRedDotCacheHelper", "setItemHasClicked save cache newEntityString=" + r14);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("ActionBarMenuRedDotCacheHelper", "setItemHasClicked save cache error=" + e.getMessage());
    }

    public final void reportRedDotExposure(String r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "itemId");
        com.larus.bmhome.view.actionbar.custom.cache.j r1 = getActionBarRedDotCacheHelper();
        String r2 = this.botId;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r12, "itemId");
        if (r1.a.contains(r12) == false) goto L8;
        FLogger.a.i("ActionBarRedDotCacheHelper", "hasCountItemList.contains(itemId), itemId=" + r12 + ", itemVersion=" + r13);
        return;
    L8:
        com.larus.bmhome.view.actionbar.custom.cache.g r5 = r1.c(r2, r12);
        if (r13 == r5.c()) goto L11;
        com.larus.bmhome.view.actionbar.custom.cache.g r6 = new com.larus.bmhome.view.actionbar.custom.cache.g(r12, r13, 1);
    L12:
        String r14 = com.larus.bmhome.view.actionbar.custom.cache.j.d(r12, r2);
        String r15 = HttpExtKt.f.toJson(r6);     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r15);     // Catch: Exception -> L15
        r1.f(r14, r6, r15);     // Catch: Exception -> L15
        r1.a.add(r12);     // Catch: Exception -> L15
        FLogger.a.i("ActionBarRedDotCacheHelper", "reportRedDotExposure save cache newEntityString=" + r15);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.a.e("ActionBarRedDotCacheHelper", "reportRedDotExposure save cache error=" + e.getMessage());
        return;
    L11:
        r6 = com.larus.bmhome.view.actionbar.custom.cache.g.a(r5, r12, 0, r5.b() + 1, 2);
        goto L12
    }

    public final void updateLocalCache(String r6, List<com.larus.bmhome.actionbar.model.z0> r7) {
        Intrinsics.checkNotNullParameter(r6, "lang");
        if (r7 != null) goto L5;
        return;
    L5:
        ActionBarCacheStore r0 = ActionBarCacheStore.a;
        String r1 = this.botId;
        String r2 = this.scene;
        Intrinsics.checkNotNullParameter(r6, "langCode");
        Intrinsics.checkNotNullParameter(r7, "actionBarItemList");
        String r3 = AccountService.a.getUserId();
        if (r1 == null) goto L16;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        String r4 = ActionBarCacheStore.f(r3, r6, r1, r2);
        FLogger.a.i("ActionBarCacheStore", "storeDisk, cacheKey=" + r4 + " actionBarItemSize=" + r7.size());
        ActionBarCacheStore.b.storeString(r4, HttpExtKt.f.toJson(r7));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        FLogger.a.e("ActionBarCacheStore", "save cache error=" + e.getMessage());
    L16:
        if (com.larus.platform.exp.a.a == true) goto L18;
    L20:
        ActionBarCacheStore r5 = ActionBarCacheStore.a;
        ActionBarCacheStore.a(r6, this.botId, this.scene);
        if (ObricFeatureServiceDelegate.b.a() == false) goto L27;
        ActionBarCacheStore.k(r6, this.botId, this.scene, r7);
        return;
    L27:
        return;
    L18:
        if (com.larus.platform.exp.a.b == false) goto L20;
        ActionBarCacheStore r8 = ActionBarCacheStore.a;
        ActionBarCacheStore.k(r6, this.botId, this.scene, r7);
    }

    public static void INVOKEVIRTUAL_com_larus_bmhome_view_actionbar_custom_CustomActionBarViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(CommonDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        CommonDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static final /* synthetic */ List access$resortActionBarItems(CustomActionBarViewModel r0, List r1, List r2) {
        return r0.resortActionBarItems(r1, r2);
    }

    private static final boolean getCacheConfig$lambda$8(CustomActionBarViewModel r4, Function1 r5, com.larus.bmhome.actionbar.model.z0 r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        boolean r7 = r4.actionMatchLibra(r6.g);
        if (com.larus.platform.service.z2.a.m3() == false) goto L6;
    L4:
        boolean r0 = true;
    L9:
        if (r7 == false) goto L17;
        if (r0 == false) goto L18;
        if (r5 == null) goto L13;
        boolean r8 = ((Boolean) r5.invoke(r6)).booleanValue();
    L14:
        if (r8 == false) goto L19;
        return true;
    L19:
        return false;
    L13:
        r8 = true;
        goto L14
    L18:
        return false;
    L17:
        return false;
    L6:
        if (Intrinsics.areEqual(r6.b, "coco_call") == false) goto L4;
        r0 = false;
        goto L9
    }

    private final void handleOpenSchema(com.larus.bmhome.actionbar.model.z0 r9, BaseContentWidget r10, Bundle r11) {
        com.larus.bmhome.actionbar.model.e0 r0 = r9.m;
        if (r0 == null) goto L48;
        String r1 = r0.a;
        if (r1 == null) goto L49;
        ChatFragment r3 = null;
        if (Intrinsics.areEqual(r9.b, "coco_spring_pocket") == false) goto L18;
        if (r10 == null) goto L11;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(r10, r10);
    L13:
        if ((r2 instanceof ChatFragment) == false) goto L15;
        ChatFragment r4 = (ChatFragment) r2;
    L16:
        if (r4 == null) goto L18;
        r4.g();
        goto L18
    L15:
        r4 = null;
        goto L16
    L11:
        r2 = null;
    L18:
        FLogger.a.i(TAG, "[handleOpenSchema] schemaUrl=".concat(r1));
        Pair[] r5 = new Pair[11];
        r5[0] = TuplesKt.to("enter_from", "chat");
        r5[1] = TuplesKt.to("enter_method", "chat_action_bar");
        r5[2] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, this.conversationId);
        r5[3] = TuplesKt.to("argConversationId", this.conversationId);
        r5[4] = TuplesKt.to("bot_id", this.botId);
        r5[5] = TuplesKt.to("action_bar_key", r9.b);
        r5[6] = TuplesKt.to("action_bar_recommend_from", "chat_action_bar");
        r5[7] = TuplesKt.to("req_id", r9.A);
        r5[8] = TuplesKt.to("action_bar_item_id", r9.a);
        com.larus.bmhome.actionbar.model.e0 r12 = r9.m;
        if (r12 == null) goto L21;
        SceneModel r13 = r12.b;
    L22:
        r5[9] = TuplesKt.to("realtime_call_scene_model", r13);
        r5[10] = TuplesKt.to("click_action_bar_time", Long.valueOf(System.currentTimeMillis()));
        Bundle r14 = com.larus.utils.f.c(r5);
        if (r10 == null) goto L25;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Fragment r6 = com.larus.ui.arch.component.internal.attach.a.b(r10, r10);
    L27:
        if ((r6 instanceof ChatFragment) == false) goto L29;
        r3 = (ChatFragment) r6;
    L29:
        if (r3 == null) goto L31;
        by7.h.k(r14, r3);
    L31:
        if (r11 == null) goto L33;
        r14.putAll(r11);
    L33:
        Iterator<com.larus.bmhome.view.actionbar.custom.router.b> r15 = com.larus.bmhome.view.actionbar.custom.router.c.a.iterator();
    L35:
        if (r15.hasNext() == false) goto L50;
        com.larus.bmhome.view.actionbar.custom.router.b r7 = r15.next();
        if (r7.b(r1) == false) goto L35;
        if (r7.a(r10, r1, r14) == false) goto L35;
        FLogger.a.i(TAG, "[handleOpenSchema] handled by " + Reflection.getOrCreateKotlinClass(r7.getClass()).getSimpleName());
        return;
    L50:
        return;
    L25:
        r6 = null;
        goto L27
    L21:
        r13 = null;
        goto L22
    L49:
        return;
    }

    private final void handleUserSendMsg(com.larus.bmhome.actionbar.model.z0 r24, String r25, BaseContentWidget r26) {
        com.larus.bmhome.actionbar.model.n0 r2 = r24.l;
        ChatPageContext r3 = null;
        if (r2 == null) goto L5;
        ArrayList r4 = r2.b;
    L7:
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        String r6 = "";
        if (r5 == false) goto L16;
    L41:
        String r7 = r24.b;
        if (r7 != null) goto L44;
        r7 = "";
    L44:
        com.larus.bmhome.actionbar.model.n0 r0 = r24.l;
        if (r0 == null) goto L47;
        String r1 = r0.a;
    L48:
        String r8 = r1;
        String r9 = r7;
    L50:
        if (com.larus.utils.o0.d(r8) == false) goto L80;
        String r14 = UUID.randomUUID().toString();
        com.larus.bmhome.chat.trace.z.a.d(r14);
        String r10 = this.conversationId;
        if (r10 == null) goto L84;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CustomActionBarViewModel$handleUserSendMsg$1$1(r10, null), 3, null);
        if (r8 == null) goto L85;
        LinkedHashMap r11 = new LinkedHashMap();
        ChatSendUtils r12 = ChatSendUtils.a;
        Pair[] r13 = new Pair[1];
        if (r9 != null) goto L58;
        String r15 = "";
    L59:
        r13[0] = TuplesKt.to("action_bar_key", r15);
        r12.getClass();
        r11.putAll(ChatSendUtils.p(r13));
        if (r26 == null) goto L71;
        Intrinsics.checkNotNullParameter(r26, "<this>");
        Fragment r16 = com.larus.ui.arch.component.internal.attach.a.b(r26, r26);
        if (r16 == null) goto L71;
        t1a.b r17 = s1a.a.g(r16);
        if (r17 == null) goto L71;
        va8.l0 r18 = r17.getAbility(va8.l0.class);
        if (r18 == null) goto L71;
        if (r9 == null) goto L70;
        r6 = r9;
    L70:
        r18.D7(r11, r6);
    L71:
        RepoDispatcher.a.getClass();
        ChatSender r19 = RepoDispatcher.d.e;
        if (r26 == null) goto L78;
        Intrinsics.checkNotNullParameter(r26, "<this>");
        Fragment r20 = com.larus.ui.arch.component.internal.attach.a.b(r26, r26);
        if (r20 == null) goto L78;
        t1a.b r21 = s1a.a.g(r20);
        if (r21 == null) goto L78;
        r3 = (ChatPageContext) r21.a(ChatPageContext.class);
    L78:
        com.larus.bmhome.chat.model.repo.u1.a.f(r19, r8, r10, "chat_action_bar", r11, null, null, r14, false, null, "CustomActionBarViewModel#handleUserSendMsg", null, r3, null, false, 27496);
        return;
    L58:
        r15 = r9;
        goto L59
    L85:
        return;
    L84:
        return;
    L80:
        return;
    L47:
        r1 = null;
        goto L48
    L16:
        if (com.larus.utils.o0.d(r25) == false) goto L41;
        com.larus.bmhome.actionbar.model.n0 r22 = r24.l;
        if (r22 == null) goto L33;
        ArrayList r23 = r22.b;
        if (r23 == null) goto L33;
        Iterator r27 = r23.iterator();
    L23:
        if (r27.hasNext() == false) goto L31;
        Object r28 = r27.next();
        com.larus.bmhome.actionbar.model.x1 r29 = (com.larus.bmhome.actionbar.model.x1) r28;
        if (r29 == null) goto L27;
        String r30 = r29.c;
    L29:
        if (Intrinsics.areEqual(r30, r25) == false) goto L23;
    L32:
        com.larus.bmhome.actionbar.model.x1 r31 = (com.larus.bmhome.actionbar.model.x1) r28;
    L34:
        if (r31 == null) goto L36;
        r9 = r31.c;
    L37:
        if (r31 == null) goto L39;
        String r32 = r31.b;
    L40:
        r8 = r32;
        goto L50
    L39:
        r32 = null;
        goto L40
    L36:
        r9 = null;
        goto L37
    L27:
        r30 = null;
        goto L29
    L31:
        r28 = null;
    L33:
        r31 = null;
        goto L34
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r4 = null;
        goto L7
    }

    private final Object updateLocalCacheFromRemote(final String r3, final List<com.larus.bmhome.actionbar.model.z0> r4, Continuation<? super Unit> r5) {
        boolean r0 = com.larus.platform.exp.a.a;
        if (com.larus.platform.exp.a.c == false) goto L9;
        Object r6 = ActionBarCacheStore.a.j(new p2(this, r3, r4), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r6;
    L8:
        return Unit.INSTANCE;
    L9:
        updateLocalCache(r3, r4);
        return Unit.INSTANCE;
    }

    private static final Unit updateLocalCacheFromRemote$lambda$6(CustomActionBarViewModel r0, String r1, List r2) {
        r0.updateLocalCache(r1, r2);
        return Unit.INSTANCE;
    }

    public final boolean hasMemoryCache(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "langCode");
        ActionBarCacheStore r0 = ActionBarCacheStore.a;
        if (r5 != null) goto L5;
        r5 = this.botId;
    L5:
        if (r6 != null) goto L7;
        r6 = this.scene;
    L7:
        Intrinsics.checkNotNullParameter(r4, "langCode");
        String r1 = AccountService.a.getUserId();
        boolean r2 = false;
        if (r5 != null) goto L11;
    L29:
        return r2;
    L11:
        if (ActionBarCacheStore.i(r6) == true) goto L29;
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        String r7 = ActionBarCacheStore.f(r1, r4, r5, r6);
        if (com.larus.platform.exp.a.a == false) goto L27;
        Object r8 = ActionBarCacheStore.e;
        monitor-enter(r8);
        if (ActionBarCacheStore.d.get(r7) == null) goto L22;
        r2 = true;
    L22:
        monitor-exit(r8);
    L28:
        FLogger.a.i("ActionBarCacheStore", "getCacheConfig, cacheKey=" + r7 + ", hasMemCache=" + r2);
    L24:
        th = move-exception;
        throw th;
    L27:
        r2 = ActionBarCacheStore.g().containsKey(r7);
        goto L28
    }

    public final void reportMenuRedDotExposure(String r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r15, "itemId");
        Intrinsics.checkNotNullParameter(r16, "menuItemId");
        com.larus.bmhome.view.actionbar.custom.cache.d r8 = getActionBarMenuRedDotCacheHelper();
        String r5 = this.botId;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        String r10 = r5;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r15, "itemId");
        Intrinsics.checkNotNullParameter(r16, "menuItemId");
        com.larus.bmhome.view.actionbar.custom.cache.g r3 = r8.d(r10, r15, r16);
        if (r8.a(r3, r17) == true) goto L9;
        return;
    L9:
        if (r17 == r3.c()) goto L11;
        com.larus.bmhome.view.actionbar.custom.cache.g r4 = new com.larus.bmhome.view.actionbar.custom.cache.g(r15, r17, 1);
    L12:
        String r0 = com.larus.bmhome.view.actionbar.custom.cache.d.c(r15, r16, r10);
        String r1 = HttpExtKt.f.toJson(r4);     // Catch: Exception -> L15
        r8.b().storeString(r0, r1);     // Catch: Exception -> L15
        FLogger.a.i("ActionBarMenuRedDotCacheHelper", "reportRedDotExposure save cache newEntityString=" + r1);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.a.e("ActionBarMenuRedDotCacheHelper", "reportRedDotExposure save cache error=" + e.getMessage());
        return;
    L11:
        r4 = com.larus.bmhome.view.actionbar.custom.cache.g.a(r3, r15, 0, 1 + r3.b(), 2);
        goto L12
    }

    public static final /* synthetic */ void access$handleOpenSchema(CustomActionBarViewModel r0, com.larus.bmhome.actionbar.model.z0 r1, BaseContentWidget r2, Bundle r3) {
        r0.handleOpenSchema(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$updateLocalCacheFromRemote(CustomActionBarViewModel r0, String r1, List r2, Continuation r3) {
        return r0.updateLocalCacheFromRemote(r1, r2, r3);
    }

    public final List<com.larus.bmhome.actionbar.model.z0> getCacheConfig(String r2, String r3, String r4, final Function1<? super com.larus.bmhome.actionbar.model.z0, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "langCode");
        if (r3 != null) goto L8;
        r3 = this.botId;
        if (r3 != null) goto L8;
        return null;
    L8:
        if (r4 != null) goto L10;
        r4 = this.scene;
    L10:
        ActionBarCacheStore r0 = ActionBarCacheStore.a;
        List<com.larus.bmhome.actionbar.model.z0> r6 = ActionBarCacheStore.b(r2, r3, r4, new q2(this, r5));
        getActionBarRedDotCacheHelper().b(r6, r3);
        return r6;
    }

    public final void refreshScene(String r2, LifecycleCoroutineScope r3, boolean r4, wc9.e r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        this.scene = r2;
        checkSaaSSubConversation(r5);
        updateConfigFromRemote(r3, r4);
    }

    private final void reportActionBarOpResult(com.larus.bmhome.actionbar.model.z0 r13, Boolean r14, boolean r15, String r16, boolean r17) {
        FLogger.a.i(TAG, "reportActionBarOpResult, actionBarKey=" + r13.b + ", switchCheckState=" + r14 + ", notReportApi:" + r13.D);
        if (r13.D == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01531(r13, this, r17, r14, r16, r15, null), 3, null);
    }

    public final void updateChatParam(ChatParam r4, String r5, LifecycleCoroutineScope r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "lifecycleCoroutineScope");
        String r0 = this.conversationId;
        String r1 = null;
        if (r4 == null) goto L5;
        String r2 = r4.a;
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L18;
        String r3 = this.botId;
        if (r4 == null) goto L11;
        String r9 = r4.b;
    L13:
        if (Intrinsics.areEqual(r3, r9) == false) goto L18;
        if (r8 == true) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(this.scene, r5) == false) goto L18;
        return;
    L11:
        r9 = null;
    L18:
        if (r4 == null) goto L20;
        String r10 = r4.a;
    L21:
        this.conversationId = r10;
        if (r4 == null) goto L24;
        r1 = r4.b;
    L24:
        this.botId = r1;
        int r11 = CustomActionBar.c0;
        this.langCode = CustomActionBar.b.a();
        this.scene = r5;
        FLogger.a.i(TAG, "updateChatParam, cvsId=" + this.conversationId + ", botId=" + this.botId + ", langCode=" + this.langCode + ", pageScene = " + this.scene);
        if (r7 == false) goto L27;
        return;
    L27:
        updateConfigFromRemote(r6);
        return;
    L20:
        r10 = null;
        goto L21
    L5:
        r2 = null;
        goto L7
    }

    public static /* synthetic */ void handleOpenSchema$default(CustomActionBarViewModel r0, com.larus.bmhome.actionbar.model.z0 r1, BaseContentWidget r2, Bundle r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.handleOpenSchema(r1, r2, r3);
    }

    public static /* synthetic */ void handleUserSendMsg$default(CustomActionBarViewModel r1, com.larus.bmhome.actionbar.model.z0 r2, String r3, BaseContentWidget r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.handleUserSendMsg(r2, r3, r4);
    }

    public static /* synthetic */ boolean hasMemoryCache$default(CustomActionBarViewModel r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.hasMemoryCache(r2, r3, r4);
    }

    public final void executeOnClickAction(BaseContentWidget r18, com.larus.bmhome.actionbar.model.z0 r19, Boolean r20, boolean r21, Bundle r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "item");
        FLogger.a.i(TAG, "executeOnClickAction, begin, actionType=" + r19.g + ", switchCheckState=" + r20);
        this.lastClickActionBarKey = r19.b;
        Integer r2 = r19.g;
        int r4 = ActionBarExecutionType.BOT_SEND_MSG.getValue();
        boolean r7 = true;
        boolean r9 = false;
        ChatFragment r10 = null;
        if (r2 != null) goto L6;
    L102:
        int r0 = ActionBarExecutionType.USER_SEND_MSG.getValue();
        if (r2 != null) goto L106;
    L116:
        int r1 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r2 != null) goto L120;
    L140:
        int r3 = ActionBarExecutionType.SWITCH_SYNC.getValue();
        if (r2 != null) goto L144;
    L146:
        int r5 = ActionBarExecutionType.COMPLEX_SEARCH.getValue();
        if (r2 != null) goto L150;
    L152:
        int r6 = ActionBarExecutionType.RECORD.getValue();
        if (r2 != null) goto L156;
    L166:
        int r8 = ActionBarExecutionType.MULTI_SUGGEST_ACTION.getValue();
        if (r2 != null) goto L170;
    L172:
        int r11 = ActionBarExecutionType.SWITCH_STATUS.getValue();
        if (r2 != null) goto L176;
    L178:
        reportActionBarOpResult$default(this, r19, r20, false, null, false, 28, null);
        return;
    L176:
        if (r2.intValue() != r11) goto L178;
        reportActionBarOpResult$default(this, r19, r20, true, null, false, 24, null);
        return;
    L170:
        if (r2.intValue() != r8) goto L172;
        handleMultiSuggestActionBarClick(r19, r18);
        return;
    L156:
        if (r2.intValue() != r6) goto L166;
        if (r18 == null) goto L159;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Fragment r12 = com.larus.ui.arch.component.internal.attach.a.b(r18, r18);
    L161:
        if ((r12 instanceof ChatFragment) == false) goto L163;
        r10 = (ChatFragment) r12;
    L163:
        if (r10 == null) goto L165;
        r10.m8();
    L165:
        handleRecordActionBarClick(r19, r20);
        return;
    L159:
        r12 = null;
        goto L161
    L150:
        if (r2.intValue() != r5) goto L152;
        reportActionBarOpResult$default(this, r19, r20, true, null, false, 24, null);
        return;
    L144:
        if (r2.intValue() != r3) goto L146;
        updateSwitchStateInCache(r19, r20);
        reportActionBarOpResult$default(this, r19, r20, false, null, false, 28, null);
        return;
    L120:
        if (r2.intValue() != r1) goto L140;
        com.larus.bmhome.actionbar.model.r r13 = r19.q;
        if (r13 == null) goto L129;
        Integer r14 = r13.a;
        if (r14 == null) goto L129;
        if (r14.intValue() != 11) goto L129;
    L130:
        if (r7 == false) goto L136;
        com.larus.bmhome.actionbar.model.r r15 = r19.q;
        if (r15 == null) goto L134;
        r9 = Intrinsics.areEqual(r15.j, Boolean.TRUE);
    L134:
        if (r9 == false) goto L136;
        return;
    L136:
        if (r18 == null) goto L188;
        LifecycleCoroutineScope r16 = LifecycleOwnerKt.getLifecycleScope(r18);
        if (r16 == null) goto L189;
        BuildersKt.launch$default(r16, null, null, new AnonymousClass3(r19, this, r18, r22, r20, null), 3, null);
        return;
    L189:
        return;
    L188:
        return;
    L129:
        r7 = false;
        goto L130
    L106:
        if (r2.intValue() != r0) goto L116;
        if (r18 == null) goto L109;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Fragment r17 = com.larus.ui.arch.component.internal.attach.a.b(r18, r18);
    L111:
        if ((r17 instanceof ChatFragment) == false) goto L113;
        r10 = (ChatFragment) r17;
    L113:
        if (r10 == null) goto L115;
        r10.m8();
    L115:
        handleUserSendMsg(r19, r23, r18);
        reportActionBarOpResult$default(this, r19, r20, false, null, false, 28, null);
        return;
    L109:
        r17 = null;
        goto L111
    L6:
        if (r2.intValue() != r4) goto L102;
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L10;
        com.larus.utils.l0.b(new o2());
        return;
    L10:
        String r24 = this.conversationId;
        if (r24 == null) goto L13;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CustomActionBarViewModel$executeOnClickAction$2$1(r24, null), 3, null);
    L13:
        if (r18 == null) goto L19;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Fragment r25 = com.larus.ui.arch.component.internal.attach.a.b(r18, r18);
        if (r25 == null) goto L19;
        t1a.b r26 = s1a.a.g(r25);
        if (r26 == null) goto L19;
        u7 r27 = (u7) r26.getAbility(u7.class);
    L20:
        Intrinsics.checkNotNullParameter(r19, "item");
        if (r27 == null) goto L38;
        List r28 = r27.zj();
        if (r28 == null) goto L38;
        Iterator r29 = r28.iterator();
    L26:
        if (r29.hasNext() == false) goto L36;
        Object r30 = r29.next();
        Integer r110 = com.larus.bmhome.social.userchat.model.b0.c((Message) r30);
        if (r110 != null) goto L31;
    L32:
        boolean r111 = true;
    L34:
        if (r111 == false) goto L26;
    L37:
        Message r31 = (Message) r30;
    L40:
        if (r31 != null) goto L42;
        dt8.a.a("no valid message_id, because: latestMessage is null");
    L67:
        String r32 = null;
    L68:
        if (r32 != null) goto L70;
    L73:
        boolean r112 = true;
    L74:
        if (r112 == false) goto L87;
        if (r27 == null) goto L77;
        r27.BN();
    L77:
        if (r18 == null) goto L79;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Fragment r33 = com.larus.ui.arch.component.internal.attach.a.b(r18, r18);
    L81:
        if ((r33 instanceof ChatFragment) == false) goto L83;
        r10 = (ChatFragment) r33;
    L83:
        if (r10 == null) goto L92;
        u7 r34 = r10.u3();
        if (r34 == null) goto L92;
        r34.BN();
    L92:
        if (Intrinsics.areEqual(r19.b, "coco_spring_festival_2025") == false) goto L101;
        if (r32 != null) goto L95;
    L98:
        boolean r35 = true;
    L99:
        if (r35 == true) goto L101;
        r9 = true;
        goto L101
    L95:
        if (r32.length() == 0) goto L98;
        r35 = false;
    L101:
        reportActionBarOpResult$default(this, r19, r20, false, r32, r9, 4, null);
        return;
    L79:
        r33 = null;
        goto L81
    L87:
        if (r27 == null) goto L89;
        r27.O5(false);
    L89:
        if (r27 == null) goto L92;
        r27.U1();
        goto L92
    L70:
        if (r32.length() == 0) goto L73;
        r112 = false;
        goto L74
    L42:
        PagingAdapter r113 = r27.MF();
        if ((r113 instanceof MessageAdapter) == true) goto L46;
        r113 = null;
    L46:
        if (r113 == null) goto L50;
        List r114 = r113.z2();
        if (r114 == null) goto L50;
        xc8.b r115 = (xc8.b) CollectionsKt.firstOrNull(r114);
    L52:
        if ((r115 instanceof com.larus.bmhome.chat.list.cell.prompt.w0) == true) goto L54;
        dt8.a.a("no valid message_id, because: lastUIMessageState is not PromptCellState");
        goto L67
    L54:
        Map r116 = r31.getExt();
        if (r116 == null) goto L57;
        String r117 = (String) r116.get("action_bar_key");
    L59:
        if (Intrinsics.areEqual(r117, "coco_spring_festival_2025") == false) goto L66;
        int r118 = dt8.a.a;
        dt8.a.a("item action bar key:" + r19.b + "; return latestMessageId:" + r31.getMessageId());
        Intrinsics.checkNotNullParameter(r31, "<this>");
        String r36 = r31.getMessageId();
        if (r36 == null) goto L63;
        r32 = StringsKt.removeSuffix(r36, ":fake_message:1");
    L64:
        if (r32 != null) goto L68;
        r32 = "";
        goto L68
    L63:
        r32 = null;
        goto L64
    L66:
        dt8.a.a("no valid message_id, because: latestMessage is not spring festival");
        goto L67
    L57:
        r117 = null;
    L50:
        r115 = null;
        goto L52
    L31:
        if (r110.intValue() != 14) goto L32;
        r111 = false;
        goto L34
    L36:
        r30 = null;
    L38:
        r31 = null;
    L19:
        r27 = null;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List getCacheConfig$default(CustomActionBarViewModel r1, String r2, String r3, String r4, Function1 r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = null;
    L12:
        return r1.getCacheConfig(r2, r3, r4, r5);
    }

    public static /* synthetic */ void reportActionBarOpResult$default(CustomActionBarViewModel r7, com.larus.bmhome.actionbar.model.z0 r8, Boolean r9, boolean r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r13 & 8) == 0) goto L9;
        r11 = null;
    L9:
        String r5 = r11;
        if ((r13 & 16) == 0) goto L12;
        boolean r6 = false;
    L13:
        r7.reportActionBarOpResult(r8, r9, r4, r5, r6);
        return;
    L12:
        r6 = r12;
        goto L13
    L5:
        r4 = r10;
        goto L7
    }

    public static /* synthetic */ void updateChatParam$default(CustomActionBarViewModel r6, ChatParam r7, String r8, LifecycleCoroutineScope r9, boolean r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        boolean r5 = false;
    L6:
        r6.updateChatParam(r7, r8, r9, r10, r5);
        return;
    L5:
        r5 = r11;
        goto L6
    }

    public static /* synthetic */ void executeOnClickAction$default(CustomActionBarViewModel r7, BaseContentWidget r8, com.larus.bmhome.actionbar.model.z0 r9, Boolean r10, boolean r11, Bundle r12, String r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r14 & 16) == 0) goto L9;
        Bundle r5 = null;
    L11:
        if ((r14 & 32) == 0) goto L13;
        String r6 = null;
    L14:
        r7.executeOnClickAction(r8, r9, r10, r4, r5, r6);
        return;
    L13:
        r6 = r13;
        goto L14
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }
}
