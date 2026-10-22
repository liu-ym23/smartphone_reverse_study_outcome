package com.bytedance.android.livesdk.interactivity;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.helper.DataContextExtKt;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdk.interactivity.api.IQuickCommentService;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.ChatCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputPanelComponentSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncModel;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AIClone;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.FusionEmojiBanList;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.InputFunctionList;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.event.BackRoomViewState;
import com.bytedance.android.livesdk.interactivity.api.settings.config.z0;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdk.interactivity.comment.f1;
import com.bytedance.android.livesdk.interactivity.comment.g1;
import com.bytedance.android.livesdk.interactivity.comment.h1;
import com.bytedance.android.livesdk.interactivity.common.emoji.LowPcuGuideChatManager;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import ec2.t0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import r52.j4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\t¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0004J\u001e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bR!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R!\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018R!\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R!\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018R!\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0016\u001a\u0004\b0\u0010\u0018R!\u00105\u001a\b\u0012\u0004\u0012\u0002020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018R-\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000307068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0016\u001a\u0004\b:\u0010;R!\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010\u0018R!\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0016\u001a\u0004\bC\u0010\u0018R!\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0016\u001a\u0004\bF\u0010\u001dR!\u0010L\u001a\b\u0012\u0004\u0012\u00020H0G8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0016\u001a\u0004\bJ\u0010KR!\u0010P\u001a\b\u0012\u0004\u0012\u00020M0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0016\u001a\u0004\bO\u0010\u0018R!\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0G8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0016\u001a\u0004\bS\u0010KR!\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0016\u001a\u0004\bW\u0010\u001dR!\u0010\\\u001a\b\u0012\u0004\u0012\u00020Y0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0016\u001a\u0004\b[\u0010\u0018R!\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0016\u001a\u0004\b_\u0010\u0018R!\u0010d\u001a\b\u0012\u0004\u0012\u00020a0\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0016\u001a\u0004\bc\u0010\u001dR!\u0010h\u001a\b\u0012\u0004\u0012\u00020e0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\u0016\u001a\u0004\bg\u0010\u0018R!\u0010l\u001a\b\u0012\u0004\u0012\u00020i0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0016\u001a\u0004\bk\u0010\u0018R!\u0010p\u001a\b\u0012\u0004\u0012\u00020m0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0016\u001a\u0004\bo\u0010\u0018R!\u0010t\u001a\b\u0012\u0004\u0012\u00020q0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u0016\u001a\u0004\bs\u0010\u0018R!\u0010x\u001a\b\u0012\u0004\u0012\u00020u0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u0016\u001a\u0004\bw\u0010\u0018R!\u0010|\u001a\b\u0012\u0004\u0012\u00020y0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u0016\u001a\u0004\b{\u0010\u0018R\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020}0\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0016\u001a\u0004\b\u007f\u0010\u0018R%\u0010\u0084\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00138VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0016\u001a\u0005\b\u0083\u0001\u0010\u0018R%\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0016\u001a\u0005\b\u0087\u0001\u0010\u001dR%\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010G8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0016\u001a\u0005\b\u008b\u0001\u0010KR'\u0010\u0092\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u00018VX\u0096\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u0010\u0016\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R$\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u0093\u0001\u0010\u0016\u001a\u0005\b\u0094\u0001\u0010\u001dR%\u0010\u0098\u0001\u001a\t\u0012\u0005\u0012\u00030\u0095\u00010\u00138VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u0096\u0001\u0010\u0016\u001a\u0005\b\u0097\u0001\u0010\u0018R%\u0010\u009c\u0001\u001a\t\u0012\u0005\u0012\u00030\u0099\u00010\u00138VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u0016\u001a\u0005\b\u009b\u0001\u0010\u0018R%\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u00010G8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010\u0016\u001a\u0005\b\u009f\u0001\u0010KR$\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b¡\u0001\u0010\u0016\u001a\u0005\b¢\u0001\u0010\u001dR$\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0001\u0010\u0016\u001a\u0005\b¤\u0001\u0010\u001dR$\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u0016\u001a\u0005\b§\u0001\u0010\u001dR$\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b©\u0001\u0010\u0016\u001a\u0005\bª\u0001\u0010\u001dR%\u0010¯\u0001\u001a\t\u0012\u0005\u0012\u00030¬\u00010\u00138VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u00ad\u0001\u0010\u0016\u001a\u0005\b®\u0001\u0010\u0018R$\u0010²\u0001\u001a\b\u0012\u0004\u0012\u0002080\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b°\u0001\u0010\u0016\u001a\u0005\b±\u0001\u0010\u001dR%\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030³\u00010G8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b´\u0001\u0010\u0016\u001a\u0005\bµ\u0001\u0010KR%\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030·\u00010\u00138VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u0016\u001a\u0005\b¹\u0001\u0010\u0018R$\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b»\u0001\u0010\u0016\u001a\u0005\b¼\u0001\u0010\u001dR%\u0010Á\u0001\u001a\t\u0012\u0005\u0012\u00030¾\u00010G8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b¿\u0001\u0010\u0016\u001a\u0005\bÀ\u0001\u0010KR\u0017\u0010Â\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001¨\u0006Æ\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/InteractivityPlatformContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/h;", BuildConfig.FLAVOR, "getHasChangeOrientation", "()Ljava/lang/Boolean;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lylc/e;", "wrdsManager", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", BuildConfig.FLAVOR, "initContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/q;", "result", "handleInteractionData", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "publicScreenContext$delegate", "Lcom/bytedance/live/datacontext/p;", "getPublicScreenContext", "()Lcom/bytedance/live/datacontext/j;", "publicScreenContext", "Lcom/bytedance/live/datacontext/m;", "hasAllPluginLoaded$delegate", "getHasAllPluginLoaded", "()Lcom/bytedance/live/datacontext/m;", "hasAllPluginLoaded", "Lk22/b;", "aiCloneManager$delegate", "getAiCloneManager", "aiCloneManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/AIClone;", "aiCloneItem$delegate", "getAiCloneItem", "aiCloneItem", "Lcom/bytedance/android/livesdk/interactivity/api/like/datacontext/DiggContext;", "diggContext$delegate", "getDiggContext", "diggContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/l;", "audienceOperateManager$delegate", "getAudienceOperateManager", "audienceOperateManager", "highlightEnable$delegate", "getHighlightEnable", "highlightEnable", "Lx42/a;", "personalizedChannelManager$delegate", "getPersonalizedChannelManager", "personalizedChannelManager", "Lcom/bytedance/live/datacontext/i;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enterAnimVisibleStateStore$delegate", "getEnterAnimVisibleStateStore", "()Lcom/bytedance/live/datacontext/i;", "enterAnimVisibleStateStore", "Lh32/a;", "degradeManager$delegate", "getDegradeManager", "degradeManager", "Lcom/bytedance/android/livesdk/interactivity/api/entity/RiskAdviseSyncModel;", "riskAdviseSyncModel$delegate", "getRiskAdviseSyncModel", "riskAdviseSyncModel", "isShowingPromotionCard$delegate", "isShowingPromotionCard", "Lcom/bytedance/live/datacontext/n;", "Lf52/b;", "psTopContainer$delegate", "getPsTopContainer", "()Lcom/bytedance/live/datacontext/n;", "psTopContainer", "Lcom/bytedance/android/live/pushstream/d;", "liveStream$delegate", "getLiveStream", "liveStream", "Landroid/view/ViewGroup;", "matchTrayRootView$delegate", "getMatchTrayRootView", "matchTrayRootView", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/t;", "matchChatInfo$delegate", "getMatchChatInfo", "matchChatInfo", "Lr42/h;", "historyDataManager$delegate", "getHistoryDataManager", "historyDataManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/b;", "barrageContext$delegate", "getBarrageContext", "barrageContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/w;", "recommendShortcutEmoji$delegate", "getRecommendShortcutEmoji", "recommendShortcutEmoji", "Lcom/bytedance/android/livesdk/interactivity/api/emoji/d;", "activityEmojiManager$delegate", "getActivityEmojiManager", "activityEmojiManager", "Lcom/bytedance/android/livesdk/interactivity/api/emoji/f;", "lowPcuGuideChatManager$delegate", "getLowPcuGuideChatManager", "lowPcuGuideChatManager", "Lcom/bytedance/android/livesdk/interactivity/api/emoji/e;", "fusionEmojiManager$delegate", "getFusionEmojiManager", "fusionEmojiManager", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/InputPanelComponentSyncDataModel;", "inputPanelComponentSyncDataModelModel$delegate", "getInputPanelComponentSyncDataModelModel", "inputPanelComponentSyncDataModelModel", "Lcom/bytedance/android/livesdk/interactivity/api/comment/data/IntercomSyncDataModel;", "intercomSyncDataModel$delegate", "getIntercomSyncDataModel", "intercomSyncDataModel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/g;", "frequentChatInfo$delegate", "getFrequentChatInfo", "frequentChatInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/InputFunctionList;", "inputFunctionInfo$delegate", "getInputFunctionInfo", "inputFunctionInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/FusionEmojiBanList;", "fusionEmojiBanList$delegate", "getFusionEmojiBanList", "fusionEmojiBanList", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", "likeIconInfo$delegate", "getLikeIconInfo", "likeIconInfo", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/event/BackRoomViewState;", "backRoomViewState$delegate", "getBackRoomViewState", "backRoomViewState", "Lcom/bytedance/live/datacontext/k;", "Lo52/a;", "backRoomChanged$delegate", "getBackRoomChanged", "()Lcom/bytedance/live/datacontext/k;", "backRoomChanged", "isUserBannedTalk$delegate", "isUserBannedTalk", "La32/a;", "toolbarAndCommentShowCtrlManager$delegate", "getToolbarAndCommentShowCtrlManager", "toolbarAndCommentShowCtrlManager", "Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/f;", "quickCommentManager$delegate", "getQuickCommentManager", "quickCommentManager", "Lc32/c;", "wordAssociateResult$delegate", "getWordAssociateResult", "wordAssociateResult", "isFirstMessageConsumed$delegate", "isFirstMessageConsumed", "hasLoadModel$delegate", "getHasLoadModel", "hasLoadModel", "myLiveEntranceHasShow$delegate", "getMyLiveEntranceHasShow", "myLiveEntranceHasShow", "aiEntranceHasShow$delegate", "getAiEntranceHasShow", "aiEntranceHasShow", "Lcom/bytedance/android/livesdk/interactivity/api/base/b;", "interactivityStat$delegate", "getInteractivityStat", "interactivityStat", "sendCommentCount$delegate", "getSendCommentCount", "sendCommentCount", "Lb42/b;", "multiCameraContext$delegate", "getMultiCameraContext", "multiCameraContext", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/k;", "highlightContext$delegate", "getHighlightContext", "highlightContext", "answerQuestionShow$delegate", "getAnswerQuestionShow", "answerQuestionShow", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/i;", "voiceSceneConfig$delegate", "getVoiceSceneConfig", "voiceSceneConfig", "isAlive", "()Z", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class InteractivityPlatformContext extends DataContext implements com.bytedance.android.livesdk.interactivity.api.h {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p activityEmojiManager$delegate;
    private final com.bytedance.live.datacontext.p aiCloneItem$delegate;
    private final com.bytedance.live.datacontext.p aiCloneManager$delegate;
    private final com.bytedance.live.datacontext.p aiEntranceHasShow$delegate;
    private final com.bytedance.live.datacontext.p answerQuestionShow$delegate;
    private final com.bytedance.live.datacontext.p audienceOperateManager$delegate;
    private final com.bytedance.live.datacontext.p backRoomChanged$delegate;
    private final com.bytedance.live.datacontext.p backRoomViewState$delegate;
    private final com.bytedance.live.datacontext.p barrageContext$delegate;
    private final com.bytedance.live.datacontext.p degradeManager$delegate;
    private final com.bytedance.live.datacontext.p diggContext$delegate;
    private final com.bytedance.live.datacontext.p enterAnimVisibleStateStore$delegate;
    private final com.bytedance.live.datacontext.p frequentChatInfo$delegate;
    private final com.bytedance.live.datacontext.p fusionEmojiBanList$delegate;
    private final com.bytedance.live.datacontext.p fusionEmojiManager$delegate;
    private final com.bytedance.live.datacontext.p hasAllPluginLoaded$delegate;
    private final com.bytedance.live.datacontext.p hasLoadModel$delegate;
    private final com.bytedance.live.datacontext.p highlightContext$delegate;
    private final com.bytedance.live.datacontext.p highlightEnable$delegate;
    private final com.bytedance.live.datacontext.p historyDataManager$delegate;
    private final com.bytedance.live.datacontext.p inputFunctionInfo$delegate;
    private final com.bytedance.live.datacontext.p inputPanelComponentSyncDataModelModel$delegate;
    private final com.bytedance.live.datacontext.p interactivityStat$delegate;
    private final com.bytedance.live.datacontext.p intercomSyncDataModel$delegate;
    private final com.bytedance.live.datacontext.p isFirstMessageConsumed$delegate;
    private final com.bytedance.live.datacontext.p isShowingPromotionCard$delegate;
    private final com.bytedance.live.datacontext.p isUserBannedTalk$delegate;
    private final com.bytedance.live.datacontext.p likeIconInfo$delegate;
    private final com.bytedance.live.datacontext.p liveStream$delegate;
    private final com.bytedance.live.datacontext.p lowPcuGuideChatManager$delegate;
    private final com.bytedance.live.datacontext.p matchChatInfo$delegate;
    private final com.bytedance.live.datacontext.p matchTrayRootView$delegate;
    private final com.bytedance.live.datacontext.p multiCameraContext$delegate;
    private final com.bytedance.live.datacontext.p myLiveEntranceHasShow$delegate;
    private final com.bytedance.live.datacontext.p personalizedChannelManager$delegate;
    private final com.bytedance.live.datacontext.p psTopContainer$delegate;
    private final com.bytedance.live.datacontext.p publicScreenContext$delegate;
    private final com.bytedance.live.datacontext.p quickCommentManager$delegate;
    private final com.bytedance.live.datacontext.p recommendShortcutEmoji$delegate;
    private final com.bytedance.live.datacontext.p riskAdviseSyncModel$delegate;
    private final com.bytedance.live.datacontext.p sendCommentCount$delegate;
    private final com.bytedance.live.datacontext.p toolbarAndCommentShowCtrlManager$delegate;
    private final com.bytedance.live.datacontext.p voiceSceneConfig$delegate;
    private final com.bytedance.live.datacontext.p wordAssociateResult$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "publicScreenContext", "getPublicScreenContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "hasAllPluginLoaded", "getHasAllPluginLoaded()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "aiCloneManager", "getAiCloneManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "aiCloneItem", "getAiCloneItem()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "diggContext", "getDiggContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "audienceOperateManager", "getAudienceOperateManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "highlightEnable", "getHighlightEnable()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "personalizedChannelManager", "getPersonalizedChannelManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "enterAnimVisibleStateStore", "getEnterAnimVisibleStateStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "degradeManager", "getDegradeManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "riskAdviseSyncModel", "getRiskAdviseSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "isShowingPromotionCard", "isShowingPromotionCard()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "psTopContainer", "getPsTopContainer()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "liveStream", "getLiveStream()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "matchTrayRootView", "getMatchTrayRootView()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "matchChatInfo", "getMatchChatInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "historyDataManager", "getHistoryDataManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "barrageContext", "getBarrageContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "recommendShortcutEmoji", "getRecommendShortcutEmoji()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "activityEmojiManager", "getActivityEmojiManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "lowPcuGuideChatManager", "getLowPcuGuideChatManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "fusionEmojiManager", "getFusionEmojiManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "inputPanelComponentSyncDataModelModel", "getInputPanelComponentSyncDataModelModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "intercomSyncDataModel", "getIntercomSyncDataModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "frequentChatInfo", "getFrequentChatInfo()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "inputFunctionInfo", "getInputFunctionInfo()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "fusionEmojiBanList", "getFusionEmojiBanList()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "likeIconInfo", "getLikeIconInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "backRoomViewState", "getBackRoomViewState()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "backRoomChanged", "getBackRoomChanged()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "isUserBannedTalk", "isUserBannedTalk()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "toolbarAndCommentShowCtrlManager", "getToolbarAndCommentShowCtrlManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "quickCommentManager", "getQuickCommentManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "wordAssociateResult", "getWordAssociateResult()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "isFirstMessageConsumed", "isFirstMessageConsumed()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "hasLoadModel", "getHasLoadModel()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "myLiveEntranceHasShow", "getMyLiveEntranceHasShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "aiEntranceHasShow", "getAiEntranceHasShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "interactivityStat", "getInteractivityStat()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "sendCommentCount", "getSendCommentCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "multiCameraContext", "getMultiCameraContext()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "highlightContext", "getHighlightContext()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "answerQuestionShow", "getAnswerQuestionShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractivityPlatformContext.class, "voiceSceneConfig", "getVoiceSceneConfig()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> getActivityEmojiManager() {
        return (com.bytedance.live.datacontext.j) this.activityEmojiManager$delegate.a(this, $$delegatedProperties[19]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<AIClone> getAiCloneItem() {
        return (com.bytedance.live.datacontext.j) this.aiCloneItem$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<k22.b> getAiCloneManager() {
        return (com.bytedance.live.datacontext.j) this.aiCloneManager$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> getAiEntranceHasShow() {
        return (com.bytedance.live.datacontext.m) this.aiEntranceHasShow$delegate.a(this, $$delegatedProperties[37]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> getAnswerQuestionShow() {
        return (com.bytedance.live.datacontext.m) this.answerQuestionShow$delegate.a(this, $$delegatedProperties[42]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> getAudienceOperateManager() {
        return (com.bytedance.live.datacontext.j) this.audienceOperateManager$delegate.a(this, $$delegatedProperties[5]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.k<o52.a> getBackRoomChanged() {
        return (com.bytedance.live.datacontext.k) this.backRoomChanged$delegate.a(this, $$delegatedProperties[29]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.n<BackRoomViewState> getBackRoomViewState() {
        return (com.bytedance.live.datacontext.n) this.backRoomViewState$delegate.a(this, $$delegatedProperties[28]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> getBarrageContext() {
        return (com.bytedance.live.datacontext.j) this.barrageContext$delegate.a(this, $$delegatedProperties[17]);
    }

    public abstract /* synthetic */ l22.d getBaseUserActionCollector();

    public abstract /* synthetic */ com.bytedance.live.datacontext.m<Boolean> getChatChannelLandscapeDialogState();

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<h32.a> getDegradeManager() {
        return (com.bytedance.live.datacontext.j) this.degradeManager$delegate.a(this, $$delegatedProperties[9]);
    }

    public com.bytedance.live.datacontext.j<DiggContext> getDiggContext() {
        return (com.bytedance.live.datacontext.j) this.diggContext$delegate.a(this, $$delegatedProperties[4]);
    }

    public com.bytedance.live.datacontext.i<Map<Integer, Boolean>> getEnterAnimVisibleStateStore() {
        return (com.bytedance.live.datacontext.i) this.enterAnimVisibleStateStore$delegate.a(this, $$delegatedProperties[8]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.g> getFrequentChatInfo() {
        return (com.bytedance.live.datacontext.j) this.frequentChatInfo$delegate.a(this, $$delegatedProperties[24]);
    }

    public com.bytedance.live.datacontext.j<FusionEmojiBanList> getFusionEmojiBanList() {
        return (com.bytedance.live.datacontext.j) this.fusionEmojiBanList$delegate.a(this, $$delegatedProperties[26]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.e> getFusionEmojiManager() {
        return (com.bytedance.live.datacontext.j) this.fusionEmojiManager$delegate.a(this, $$delegatedProperties[21]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> getHasAllPluginLoaded() {
        return (com.bytedance.live.datacontext.m) this.hasAllPluginLoaded$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> getHasLoadModel() {
        return (com.bytedance.live.datacontext.m) this.hasLoadModel$delegate.a(this, $$delegatedProperties[35]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k> getHighlightContext() {
        return (com.bytedance.live.datacontext.j) this.highlightContext$delegate.a(this, $$delegatedProperties[41]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<Boolean> getHighlightEnable() {
        return (com.bytedance.live.datacontext.j) this.highlightEnable$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<r42.h> getHistoryDataManager() {
        return (com.bytedance.live.datacontext.j) this.historyDataManager$delegate.a(this, $$delegatedProperties[16]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<InputFunctionList> getInputFunctionInfo() {
        return (com.bytedance.live.datacontext.j) this.inputFunctionInfo$delegate.a(this, $$delegatedProperties[25]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<InputPanelComponentSyncDataModel> getInputPanelComponentSyncDataModelModel() {
        return (com.bytedance.live.datacontext.j) this.inputPanelComponentSyncDataModelModel$delegate.a(this, $$delegatedProperties[22]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.base.b> getInteractivityStat() {
        return (com.bytedance.live.datacontext.j) this.interactivityStat$delegate.a(this, $$delegatedProperties[38]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<IntercomSyncDataModel> getIntercomSyncDataModel() {
        return (com.bytedance.live.datacontext.j) this.intercomSyncDataModel$delegate.a(this, $$delegatedProperties[23]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r> getLikeIconInfo() {
        return (com.bytedance.live.datacontext.m) this.likeIconInfo$delegate.a(this, $$delegatedProperties[27]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> getLiveStream() {
        return (com.bytedance.live.datacontext.j) this.liveStream$delegate.a(this, $$delegatedProperties[13]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.f> getLowPcuGuideChatManager() {
        return (com.bytedance.live.datacontext.j) this.lowPcuGuideChatManager$delegate.a(this, $$delegatedProperties[20]);
    }

    public abstract /* synthetic */ com.bytedance.live.datacontext.m<Integer> getMarkHighlightStatusCode();

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t> getMatchChatInfo() {
        return (com.bytedance.live.datacontext.m) this.matchChatInfo$delegate.a(this, $$delegatedProperties[15]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.n<ViewGroup> getMatchTrayRootView() {
        return (com.bytedance.live.datacontext.n) this.matchTrayRootView$delegate.a(this, $$delegatedProperties[14]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.n<b42.b> getMultiCameraContext() {
        return (com.bytedance.live.datacontext.n) this.multiCameraContext$delegate.a(this, $$delegatedProperties[40]);
    }

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> getMultiChatTabAreaStateManager();

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> getMyLiveEntranceHasShow() {
        return (com.bytedance.live.datacontext.m) this.myLiveEntranceHasShow$delegate.a(this, $$delegatedProperties[36]);
    }

    public com.bytedance.live.datacontext.j<x42.a> getPersonalizedChannelManager() {
        return (com.bytedance.live.datacontext.j) this.personalizedChannelManager$delegate.a(this, $$delegatedProperties[7]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.n<f52.b> getPsTopContainer() {
        return (com.bytedance.live.datacontext.n) this.psTopContainer$delegate.a(this, $$delegatedProperties[12]);
    }

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<PSTopMessagePayload> getPsTopMessage();

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a> getPublicScreenAreaStateManager();

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> getPublicScreenContext() {
        return (com.bytedance.live.datacontext.j) this.publicScreenContext$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> getQuickCommentManager() {
        return (com.bytedance.live.datacontext.j) this.quickCommentManager$delegate.a(this, $$delegatedProperties[32]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w> getRecommendShortcutEmoji() {
        return (com.bytedance.live.datacontext.m) this.recommendShortcutEmoji$delegate.a(this, $$delegatedProperties[18]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<RiskAdviseSyncModel> getRiskAdviseSyncModel() {
        return (com.bytedance.live.datacontext.j) this.riskAdviseSyncModel$delegate.a(this, $$delegatedProperties[10]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Integer> getSendCommentCount() {
        return (com.bytedance.live.datacontext.m) this.sendCommentCount$delegate.a(this, $$delegatedProperties[39]);
    }

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.b> getSquareTabManager();

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.j<a32.a> getToolbarAndCommentShowCtrlManager() {
        return (com.bytedance.live.datacontext.j) this.toolbarAndCommentShowCtrlManager$delegate.a(this, $$delegatedProperties[31]);
    }

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<t22.g> getTopicTipManager();

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<Long> getUserFansCountOnStart();

    public abstract /* synthetic */ com.bytedance.live.datacontext.j<Integer> getUserHonorLevelOnStart();

    public com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.chatroom.viewmodel.i> getVoiceSceneConfig() {
        return (com.bytedance.live.datacontext.n) this.voiceSceneConfig$delegate.a(this, $$delegatedProperties[43]);
    }

    public final com.bytedance.live.datacontext.n<c32.c> getWordAssociateResult() {
        return (com.bytedance.live.datacontext.n) this.wordAssociateResult$delegate.a(this, $$delegatedProperties[33]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> isFirstMessageConsumed() {
        return (com.bytedance.live.datacontext.m) this.isFirstMessageConsumed$delegate.a(this, $$delegatedProperties[34]);
    }

    public abstract /* synthetic */ boolean isShopShow();

    public com.bytedance.live.datacontext.m<Boolean> isShowingPromotionCard() {
        return (com.bytedance.live.datacontext.m) this.isShowingPromotionCard$delegate.a(this, $$delegatedProperties[11]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public com.bytedance.live.datacontext.m<Boolean> isUserBannedTalk() {
        return (com.bytedance.live.datacontext.m) this.isUserBannedTalk$delegate.a(this, $$delegatedProperties[30]);
    }

    public InteractivityPlatformContext() {
        this.publicScreenContext$delegate = ConstantKt.c(this);
        Boolean r0 = Boolean.FALSE;
        this.hasAllPluginLoaded$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        if (ht1.a.a() == false) goto L5;
        com.bytedance.live.datacontext.p r1 = DataContextExtKt.a(this, "aiCloneManager", InteractivityPlatformContext$aiCloneManager$2.INSTANCE);
    L6:
        this.aiCloneManager$delegate = r1;
        if (ht1.a.a() == false) goto L9;
        com.bytedance.live.datacontext.p r2 = DataContextExtKt.b(this, "aiCloneItem");
    L10:
        this.aiCloneItem$delegate = r2;
        if (ht1.a.a() == false) goto L13;
        com.bytedance.live.datacontext.p r3 = DataContextExtKt.b(this, "diggContext");
    L14:
        this.diggContext$delegate = r3;
        if (ht1.a.a() == false) goto L17;
        com.bytedance.live.datacontext.p r4 = DataContextExtKt.a(this, "audienceOperateManager", InteractivityPlatformContext$audienceOperateManager$2.INSTANCE);
    L18:
        this.audienceOperateManager$delegate = r4;
        this.highlightEnable$delegate = ConstantKt.c(this);
        this.personalizedChannelManager$delegate = ConstantKt.b(this, InteractivityPlatformContext$personalizedChannelManager$2.INSTANCE);
        this.enterAnimVisibleStateStore$delegate = ConstantKt.d(this, new LinkedHashMap());
        if (ht1.a.a() == false) goto L21;
        com.bytedance.live.datacontext.p r5 = DataContextExtKt.a(this, "degradeManager", InteractivityPlatformContext$degradeManager$2.INSTANCE);
    L22:
        this.degradeManager$delegate = r5;
        if (ht1.a.a() == false) goto L25;
        com.bytedance.live.datacontext.p r6 = DataContextExtKt.b(this, "riskAdviseSyncModel");
    L26:
        this.riskAdviseSyncModel$delegate = r6;
        this.isShowingPromotionCard$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.psTopContainer$delegate = com.bytedance.live.datacontext.q.c(this);
        this.liveStream$delegate = ConstantKt.c(this);
        this.matchTrayRootView$delegate = com.bytedance.live.datacontext.q.b(this, InteractivityPlatformContext$matchTrayRootView$2.INSTANCE);
        this.matchChatInfo$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t());
        if (ht1.a.a() == false) goto L29;
        com.bytedance.live.datacontext.p r7 = DataContextExtKt.b(this, "historyDataManager");
    L30:
        this.historyDataManager$delegate = r7;
        if (ht1.a.a() == false) goto L33;
        com.bytedance.live.datacontext.p r8 = DataContextExtKt.b(this, "barrageContext");
    L34:
        this.barrageContext$delegate = r8;
        this.recommendShortcutEmoji$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w());
        if (ht1.a.a() == false) goto L37;
        com.bytedance.live.datacontext.p r9 = DataContextExtKt.b(this, "activityEmojiManager");
    L38:
        this.activityEmojiManager$delegate = r9;
        if (ht1.a.a() == false) goto L41;
        com.bytedance.live.datacontext.p r10 = DataContextExtKt.a(this, "lowPcuGuideChatManager", InteractivityPlatformContext$lowPcuGuideChatManager$2.INSTANCE);
    L42:
        this.lowPcuGuideChatManager$delegate = r10;
        if (ht1.a.a() == false) goto L45;
        com.bytedance.live.datacontext.p r11 = DataContextExtKt.b(this, "fusionEmojiManager");
    L46:
        this.fusionEmojiManager$delegate = r11;
        if (ht1.a.a() == false) goto L49;
        com.bytedance.live.datacontext.p r13 = DataContextExtKt.b(this, "inputPanelComponentSyncDataModelModel");
    L50:
        this.inputPanelComponentSyncDataModelModel$delegate = r13;
        if (ht1.a.a() == false) goto L53;
        com.bytedance.live.datacontext.p r14 = DataContextExtKt.b(this, "intercomSyncDataModel");
    L54:
        this.intercomSyncDataModel$delegate = r14;
        if (ht1.a.a() == false) goto L57;
        com.bytedance.live.datacontext.p r15 = DataContextExtKt.b(this, "frequentChatInfo");
    L58:
        this.frequentChatInfo$delegate = r15;
        if (ht1.a.a() == false) goto L61;
        com.bytedance.live.datacontext.p r16 = DataContextExtKt.b(this, "inputFunctionInfo");
    L62:
        this.inputFunctionInfo$delegate = r16;
        if (ht1.a.a() == false) goto L65;
        com.bytedance.live.datacontext.p r17 = DataContextExtKt.b(this, "fusionEmojiBanList");
    L66:
        this.fusionEmojiBanList$delegate = r17;
        this.likeIconInfo$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r());
        this.backRoomViewState$delegate = com.bytedance.live.datacontext.q.c(this);
        this.backRoomChanged$delegate = com.bytedance.live.datacontext.e.b(this);
        this.isUserBannedTalk$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.toolbarAndCommentShowCtrlManager$delegate = ConstantKt.b(this, InteractivityPlatformContext$toolbarAndCommentShowCtrlManager$2.INSTANCE);
        if (ht1.a.a() == false) goto L69;
        com.bytedance.live.datacontext.p r18 = DataContextExtKt.b(this, "quickCommentManager");
    L70:
        this.quickCommentManager$delegate = r18;
        this.wordAssociateResult$delegate = com.bytedance.live.datacontext.q.c(this);
        this.isFirstMessageConsumed$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.hasLoadModel$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.myLiveEntranceHasShow$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.aiEntranceHasShow$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        if (ht1.a.a() == false) goto L73;
        com.bytedance.live.datacontext.p r19 = DataContextExtKt.a(this, "interactivityStat", InteractivityPlatformContext$interactivityStat$2.INSTANCE);
    L74:
        this.interactivityStat$delegate = r19;
        this.sendCommentCount$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.multiCameraContext$delegate = com.bytedance.live.datacontext.q.c(this);
        this.highlightContext$delegate = ConstantKt.b(this, InteractivityPlatformContext$highlightContext$2.INSTANCE);
        this.answerQuestionShow$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.voiceSceneConfig$delegate = com.bytedance.live.datacontext.q.c(this);
        return;
    L73:
        r19 = ConstantKt.b(this, InteractivityPlatformContext$interactivityStat$3.INSTANCE);
        goto L74
    L69:
        r18 = ConstantKt.c(this);
        goto L70
    L65:
        r17 = ConstantKt.c(this);
        goto L66
    L61:
        r16 = ConstantKt.c(this);
        goto L62
    L57:
        r15 = ConstantKt.c(this);
        goto L58
    L53:
        r14 = ConstantKt.c(this);
        goto L54
    L49:
        r13 = ConstantKt.c(this);
        goto L50
    L45:
        r11 = ConstantKt.c(this);
        goto L46
    L41:
        r10 = ConstantKt.b(this, InteractivityPlatformContext$lowPcuGuideChatManager$3.INSTANCE);
        goto L42
    L37:
        r9 = ConstantKt.c(this);
        goto L38
    L33:
        r8 = ConstantKt.c(this);
        goto L34
    L29:
        r7 = ConstantKt.c(this);
        goto L30
    L25:
        r6 = ConstantKt.c(this);
        goto L26
    L21:
        r5 = ConstantKt.b(this, InteractivityPlatformContext$degradeManager$3.INSTANCE);
        goto L22
    L17:
        r4 = ConstantKt.b(this, InteractivityPlatformContext$audienceOperateManager$3.INSTANCE);
        goto L18
    L13:
        r3 = ConstantKt.c(this);
        goto L14
    L9:
        r2 = ConstantKt.c(this);
        goto L10
    L5:
        r1 = ConstantKt.b(this, InteractivityPlatformContext$aiCloneManager$3.INSTANCE);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public Boolean getHasChangeOrientation() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r0 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) getPublicScreenContext().getValue();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<? extends Boolean> r1 = r0.getHasChangeOrientation();
        if (r1 == null) goto L7;
        return (Boolean) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.h
    public boolean isAlive() {
        return !isCleared();
    }

    public final void handleInteractionData(com.bytedance.android.livesdk.interactivity.api.publicscreen.api.q r4, DataContext r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "roomContext");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        AIClone r0 = r4.aiClone;
        boolean r1 = true;
        if (r0 == null) goto L13;
        List<AICloneConvItem> r2 = r0.aiCloneList;
        if (r2 == null) goto L13;
        if ((!r2.isEmpty()) != true) goto L13;
        getAiCloneItem().d(r0);
        ICommentService r3 = (ICommentService) jc1.k.f(ICommentService.class);
        if (r3 == null) goto L13;
        k22.b r7 = r3.getAIEntranceManager(r5, r6, r0.aiCloneList);
        if (r7 == null) goto L13;
        getAiCloneManager().d(r7);
    L13:
        final com.bytedance.android.livesdk.interactivity.api.publicscreen.api.b r8 = r4.audienceMsgOptPanel;
        if (r8 == null) goto L24;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.u> r9 = r8.itemList;
        if (r9 != null) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == true) goto L24;
        getAudienceOperateManager().c(new InteractivityPlatformContext$handleInteractionData$2$1(r8));
        goto L24
    L18:
        if (r9.isEmpty() == true) goto L21;
        r10 = false;
    L24:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.h r11 = r4.highlightConfig;
        if (r11 == null) goto L32;
        com.bytedance.live.datacontext.j<Boolean> r13 = getHighlightEnable();
        if (r11.a() == 1) goto L30;
        r1 = false;
    L30:
        r13.d(Boolean.valueOf(r1));
        return;
    }

    public final void initContext(Context r7, final DataCenter r8, final ylc.e r9, final MiddlewareRoomContext r10) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "wrdsManager");
        Intrinsics.checkNotNullParameter(r10, "roomContext");
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        f1 r0 = null;
        if (r11 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r11, r8, 0, 2);
        if (r13 == null) goto L9;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L9;
        IRoom r15 = (IRoom) r14.getValue();
    L10:
        boolean r2 = false;
        if (ht1.a.a() == false) goto L34;
        getBarrageContext().e(new AnonymousClass1(r9));
        getPublicScreenContext().c(new AnonymousClass2(r9));
        getInteractivityStat().e(AnonymousClass3.INSTANCE);
        getRiskAdviseSyncModel().e(new AnonymousClass4(r9));
        final vlc.d r1 = (vlc.d) r8.get("data_message_manager");
        getActivityEmojiManager().e(new AnonymousClass5(r1));
        fc2.g.a.getClass();
        t0 r4 = t0.a;
        if (((fc2.g) r4.getValue()).b() == false) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L30;
        if (r15 == null) goto L30;
        if (r15.isMediaRoom() == true) goto L30;
        if (r15.isVsRoom() == true) goto L30;
        if (c1.b(r8) == true) goto L30;
        if (c1.c(r8) == true) goto L30;
        getLowPcuGuideChatManager().e(new AnonymousClass6(r1, r8));
    L30:
        getInputPanelComponentSyncDataModelModel().e(new AnonymousClass7(r9));
        getIntercomSyncDataModel().e(new AnonymousClass8(r9));
        Lazy r16 = PublicScreenABHelper.a;
        if (PublicScreenABHelper.b(a0.n(r8)) == false) goto L33;
        getFusionEmojiManager().e(AnonymousClass9.INSTANCE);
    L67:
        if (n52.b.a == true) goto L70;
        int r17 = n52.a.a;
    L70:
        if (jc1.k.f(IQuickCommentService.class) == null) goto L72;
        getQuickCommentManager().e(new AnonymousClass17(r10, r8));
    L72:
        int r18 = f1.d;
        int r19 = z0.a;
        Integer r20 = (Integer) j4.a.getValue();
        if (r20 != null) goto L76;
    L78:
        if (r2 == false) goto L80;
        r0 = new f1();
    L80:
        if (r0 == null) goto L83;
        RxUtilKt.c(xs2.b.a().b(m81.a.class).subscribe(new g1(r0), h1.a), r0.a);
        getToolbarAndCommentShowCtrlManager().d(r0);
        return;
    L83:
        return;
    L76:
        if (r20.intValue() != 1) goto L78;
        r2 = true;
        goto L78
    L33:
        getFusionEmojiManager().e(AnonymousClass10.INSTANCE);
        goto L67
    L15:
        if (((fc2.g) r4.getValue()).a() == true) goto L18;
        r5 = false;
        goto L19
    L34:
        getBarrageContext().d(((IBarrageService) jc1.k.n(IBarrageService.class)).createBarrageContext());
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r3 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) getBarrageContext().getValue();
        if (r3 == null) goto L39;
        com.bytedance.live.datacontext.j<ChatCarnivalDataSyncModel> r6 = r3.getChatCarnivalSyncModel();
        if (r6 == null) goto L39;
        r6.d(dc2.b.a(r9, AnonymousClass11.INSTANCE));
    L39:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r21 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) getBarrageContext().getValue();
        if (r21 == null) goto L44;
        com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r23 = r21.getGeneralCarnivalSyncModel();
        if (r23 == null) goto L44;
        r23.d(dc2.b.a(r9, AnonymousClass12.INSTANCE));
    L44:
        getPublicScreenContext().c(new AnonymousClass13(r9));
        getInteractivityStat().d(new com.bytedance.android.livesdk.interactivity.api.base.b());
        getRiskAdviseSyncModel().d(dc2.b.a(r9, AnonymousClass14.INSTANCE));
        vlc.d r24 = (vlc.d) r8.get("data_message_manager");
        getActivityEmojiManager().d(new p72.a(r24));
        fc2.g.a.getClass();
        t0 r25 = t0.a;
        if (((fc2.g) r25.getValue()).b() == false) goto L47;
    L50:
        boolean r26 = true;
    L51:
        if (r26 == false) goto L62;
        if (r15 == null) goto L62;
        if (r15.isMediaRoom() == true) goto L62;
        if (r15.isVsRoom() == true) goto L62;
        if (c1.b(r8) == true) goto L62;
        if (c1.c(r8) == true) goto L62;
        getLowPcuGuideChatManager().d(new LowPcuGuideChatManager(r24, r8));
    L62:
        getInputPanelComponentSyncDataModelModel().d(dc2.b.a(r9, AnonymousClass15.INSTANCE));
        getIntercomSyncDataModel().d(dc2.b.a(r9, AnonymousClass16.INSTANCE));
        Lazy r27 = PublicScreenABHelper.a;
        if (PublicScreenABHelper.b(a0.n(r8)) == false) goto L65;
        getFusionEmojiManager().d(new p72.c());
        goto L67
    L65:
        getFusionEmojiManager().d(new p72.b());
        goto L67
    L47:
        if (((fc2.g) r25.getValue()).a() == true) goto L50;
        r26 = false;
    L9:
        r15 = null;
        goto L10
    }
}
