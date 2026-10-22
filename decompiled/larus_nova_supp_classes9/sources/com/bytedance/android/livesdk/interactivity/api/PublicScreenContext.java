package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$InterceptorType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.Store;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.ChatLikeLinkedHashMap;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.PublicScreenFeaturePluginStore;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager;
import com.bytedance.android.livesdk.m4;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAudiencePanelConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0013\u0012\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\b\u0001\u0012\u00020\u00120\u0010H\u0016J\u001e\u0010\u0014\u001a\u00020\t2\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\b\u0001\u0012\u00020\u00120\u0010H\u0016J \u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010!2\u0006\u0010\u0016\u001a\u00020 H\u0016J\u000e\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020#J\u000e\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020#J\u0010\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0016R!\u0010/\u001a\b\u0012\u0004\u0012\u00020,0+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R!\u00102\u001a\b\u0012\u0004\u0012\u00020,0+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R!\u00105\u001a\b\u0012\u0004\u0012\u00020\u00180+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00100R!\u00109\u001a\b\u0012\u0004\u0012\u0002060+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010.\u001a\u0004\b8\u00100R!\u0010=\u001a\b\u0012\u0004\u0012\u00020:0+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010.\u001a\u0004\b<\u00100R!\u0010A\u001a\b\u0012\u0004\u0012\u00020>0+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010.\u001a\u0004\b@\u00100R!\u0010E\u001a\b\u0012\u0004\u0012\u00020B0+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010.\u001a\u0004\bD\u00100R-\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0G0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010.\u001a\u0004\bK\u0010LR!\u0010S\u001a\b\u0012\u0004\u0012\u00020O0N8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010.\u001a\u0004\bQ\u0010RR=\u0010Y\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020T\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u001b\u0012\u0006\b\u0001\u0012\u00020V0U0G0F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bW\u0010.\u001a\u0004\bX\u0010LR!\u0010\\\u001a\b\u0012\u0004\u0012\u00020,0+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010.\u001a\u0004\b[\u00100R-\u0010a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020^0G0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010.\u001a\u0004\b`\u0010LR'\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0b0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u0010.\u001a\u0004\bd\u0010LR'\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0f0N8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bh\u0010.\u001a\u0004\bi\u0010RR!\u0010n\u001a\b\u0012\u0004\u0012\u00020k0F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010.\u001a\u0004\bm\u0010LR!\u0010r\u001a\b\u0012\u0004\u0012\u00020o0N8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bp\u0010.\u001a\u0004\bq\u0010RR!\u0010v\u001a\b\u0012\u0004\u0012\u00020s0N8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010.\u001a\u0004\bu\u0010RR!\u0010z\u001a\b\u0012\u0004\u0012\u00020w0F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010.\u001a\u0004\by\u0010LR!\u0010~\u001a\b\u0012\u0004\u0012\u00020{0F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010.\u001a\u0004\b}\u0010LR$\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0F8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010.\u001a\u0005\b\u0081\u0001\u0010LR%\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0083\u00010N8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010.\u001a\u0005\b\u0085\u0001\u0010RR%\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010F8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010.\u001a\u0005\b\u0089\u0001\u0010LR%\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010F8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010.\u001a\u0005\b\u008d\u0001\u0010LR$\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0N8VX\u0096\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010.\u001a\u0005\b\u0090\u0001\u0010R¨\u0006\u0096\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Le52/a;", "getTextConfig", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/x;", "plugin", BuildConfig.FLAVOR, "registerPlugin", BuildConfig.FLAVOR, "uniqueId", "getMessagePlugin", "Lv42/a;", "registerFeaturePlugin", "Lh52/a;", "Lh52/d;", "Lh52/c;", "registerMessagePlugin", "unregisterMessagePlugin", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/config/MessagePluginType;", "type", "getMessagePluginByType", BuildConfig.FLAVOR, "Lh52/b;", "getViewBinderPluginByItemType", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/i;", "messageModel", "insertMessage", "deleteMessage", "modifyMessage", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$MessageModelType;", BuildConfig.FLAVOR, "findMessageByType", "Ls42/b;", "listener", "addMessageListener", "removeMessageListener", "data", "insertMessageSourceData", "t", "onChanged", "Lcom/bytedance/live/datacontext/m;", BuildConfig.FLAVOR, "isMessageListEmpty$delegate", "Lcom/bytedance/live/datacontext/p;", "isMessageListEmpty", "()Lcom/bytedance/live/datacontext/m;", "isHotState$delegate", "isHotState", "waitMessageCount$delegate", "getWaitMessageCount", "waitMessageCount", BuildConfig.FLAVOR, "messageShowDelay$delegate", "getMessageShowDelay", "messageShowDelay", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/PublicScreenHeatState;", "messageHeat$delegate", "getMessageHeat", "messageHeat", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/model/f;", "waitMessageState$delegate", "getWaitMessageState", "waitMessageState", "Lcom/bytedance/android/livesdk/interactivity/api/entity/PSMessageHeatState;", "messageHeatState$delegate", "getMessageHeatState", "messageHeatState", "Lcom/bytedance/live/datacontext/i;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/Store;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/i$a;", "modelFactoryStore$delegate", "getModelFactoryStore", "()Lcom/bytedance/live/datacontext/i;", "modelFactoryStore", "Lcom/bytedance/live/datacontext/j;", "Lu42/c;", "pinManager$delegate", "getPinManager", "()Lcom/bytedance/live/datacontext/j;", "pinManager", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$ViewBinderType;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/j;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PSMessageViewHolder;", "viewBinderStore$delegate", "getViewBinderStore", "viewBinderStore", "hasChangeOrientation$delegate", "getHasChangeOrientation", "hasChangeOrientation", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/PublicScreenConfig$InterceptorType;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/h;", "interceptorStore$delegate", "getInterceptorStore", "interceptorStore", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners$delegate", "getListeners", "listeners", BuildConfig.FLAVOR, "Ltlc/d;", "historyMentionChat$delegate", "getHistoryMentionChat", "historyMentionChat", "Lcom/bytedance/android/livesdk/interactivity/api/PSMessageRepositoryStore;", "repository$delegate", "getRepository", "repository", "Lq92/a;", "config$delegate", "getConfig", "config", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager;", "messageRepoManager$delegate", "getMessageRepoManager", "messageRepoManager", "Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenPluginStore;", "pluginStore$delegate", "getPluginStore", "pluginStore", "Lcom/bytedance/android/livesdk/interactivity/api/PublicScreenMessagePluginStore;", "messagePluginStore$delegate", "getMessagePluginStore", "messagePluginStore", "Lcom/bytedance/android/livesdk/interactivity/api/j;", "featurePluginStore$delegate", "getFeaturePluginStore", "featurePluginStore", "Lcom/bytedance/android/livesdk/interactivity/api/l;", "messageLogicFacade$delegate", "getMessageLogicFacade", "messageLogicFacade", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/g;", "messageSourceManager$delegate", "getMessageSourceManager", "messageSourceManager", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/panel/ChatLikeLinkedHashMap;", "localLikeStatusInfoMap$delegate", "getLocalLikeStatusInfoMap", "localLikeStatusInfoMap", "likeEggSyncModel$delegate", "getLikeEggSyncModel", "likeEggSyncModel", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dc", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenContext extends DataContext implements com.bytedance.android.livesdk.interactivity.api.publicscreen.l, Observer<KVData> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p config$delegate;
    private final com.bytedance.live.datacontext.p featurePluginStore$delegate;
    private final com.bytedance.live.datacontext.p hasChangeOrientation$delegate;
    private final com.bytedance.live.datacontext.p historyMentionChat$delegate;
    private final com.bytedance.live.datacontext.p interceptorStore$delegate;
    private final com.bytedance.live.datacontext.p isHotState$delegate;
    private final com.bytedance.live.datacontext.p isMessageListEmpty$delegate;
    private final com.bytedance.live.datacontext.p likeEggSyncModel$delegate;
    private final com.bytedance.live.datacontext.p listeners$delegate;
    private final com.bytedance.live.datacontext.p localLikeStatusInfoMap$delegate;
    private final com.bytedance.live.datacontext.p messageHeat$delegate;
    private final com.bytedance.live.datacontext.p messageHeatState$delegate;
    private final com.bytedance.live.datacontext.p messageLogicFacade$delegate;
    private final com.bytedance.live.datacontext.p messagePluginStore$delegate;
    private final com.bytedance.live.datacontext.p messageRepoManager$delegate;
    private final com.bytedance.live.datacontext.p messageShowDelay$delegate;
    private final com.bytedance.live.datacontext.p messageSourceManager$delegate;
    private final com.bytedance.live.datacontext.p modelFactoryStore$delegate;
    private final com.bytedance.live.datacontext.p pinManager$delegate;
    private final com.bytedance.live.datacontext.p pluginStore$delegate;
    private final com.bytedance.live.datacontext.p repository$delegate;
    private final com.bytedance.live.datacontext.p viewBinderStore$delegate;
    private final com.bytedance.live.datacontext.p waitMessageCount$delegate;
    private final com.bytedance.live.datacontext.p waitMessageState$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "isMessageListEmpty", "isMessageListEmpty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "isHotState", "isHotState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "waitMessageCount", "getWaitMessageCount()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messageShowDelay", "getMessageShowDelay()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messageHeat", "getMessageHeat()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "waitMessageState", "getWaitMessageState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messageHeatState", "getMessageHeatState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "modelFactoryStore", "getModelFactoryStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "pinManager", "getPinManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "viewBinderStore", "getViewBinderStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "hasChangeOrientation", "getHasChangeOrientation()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "interceptorStore", "getInterceptorStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "listeners", "getListeners()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "historyMentionChat", "getHistoryMentionChat()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "repository", "getRepository()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "config", "getConfig()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messageRepoManager", "getMessageRepoManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "pluginStore", "getPluginStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messagePluginStore", "getMessagePluginStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "featurePluginStore", "getFeaturePluginStore()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messageLogicFacade", "getMessageLogicFacade()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "messageSourceManager", "getMessageSourceManager()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "localLikeStatusInfoMap", "getLocalLikeStatusInfoMap()Lcom/bytedance/live/datacontext/IConstantNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(PublicScreenContext.class, "likeEggSyncModel", "getLikeEggSyncModel()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
    }

    private final com.bytedance.live.datacontext.i<PublicScreenMessagePluginStore> getMessagePluginStore() {
        return (com.bytedance.live.datacontext.i) this.messagePluginStore$delegate.a(this, $$delegatedProperties[18]);
    }

    private final com.bytedance.live.datacontext.i<PublicScreenPluginStore> getPluginStore() {
        return (com.bytedance.live.datacontext.i) this.pluginStore$delegate.a(this, $$delegatedProperties[17]);
    }

    public final com.bytedance.live.datacontext.j<q92.a> getConfig() {
        return (com.bytedance.live.datacontext.j) this.config$delegate.a(this, $$delegatedProperties[15]);
    }

    public final com.bytedance.live.datacontext.i<j> getFeaturePluginStore() {
        return (com.bytedance.live.datacontext.i) this.featurePluginStore$delegate.a(this, $$delegatedProperties[19]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.m<Boolean> getHasChangeOrientation() {
        return (com.bytedance.live.datacontext.m) this.hasChangeOrientation$delegate.a(this, $$delegatedProperties[10]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.j<List<tlc.d>> getHistoryMentionChat() {
        return (com.bytedance.live.datacontext.j) this.historyMentionChat$delegate.a(this, $$delegatedProperties[13]);
    }

    public final com.bytedance.live.datacontext.i<Store<PublicScreenConfig$InterceptorType, com.bytedance.android.livesdk.interactivity.api.publicscreen.h>> getInterceptorStore() {
        return (com.bytedance.live.datacontext.i) this.interceptorStore$delegate.a(this, $$delegatedProperties[11]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.j<Object> getLikeEggSyncModel() {
        return (com.bytedance.live.datacontext.j) this.likeEggSyncModel$delegate.a(this, $$delegatedProperties[23]);
    }

    public final com.bytedance.live.datacontext.i<CopyOnWriteArrayList<s42.b>> getListeners() {
        return (com.bytedance.live.datacontext.i) this.listeners$delegate.a(this, $$delegatedProperties[12]);
    }

    public final com.bytedance.live.datacontext.i<ChatLikeLinkedHashMap> getLocalLikeStatusInfoMap() {
        return (com.bytedance.live.datacontext.i) this.localLikeStatusInfoMap$delegate.a(this, $$delegatedProperties[22]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.m<PublicScreenHeatState> getMessageHeat() {
        return (com.bytedance.live.datacontext.m) this.messageHeat$delegate.a(this, $$delegatedProperties[4]);
    }

    public com.bytedance.live.datacontext.m<PSMessageHeatState> getMessageHeatState() {
        return (com.bytedance.live.datacontext.m) this.messageHeatState$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.j<l> getMessageLogicFacade() {
        return (com.bytedance.live.datacontext.j) this.messageLogicFacade$delegate.a(this, $$delegatedProperties[20]);
    }

    public final com.bytedance.live.datacontext.j<IPSMessageRepoManager> getMessageRepoManager() {
        return (com.bytedance.live.datacontext.j) this.messageRepoManager$delegate.a(this, $$delegatedProperties[16]);
    }

    public com.bytedance.live.datacontext.m<Long> getMessageShowDelay() {
        return (com.bytedance.live.datacontext.m) this.messageShowDelay$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.i<com.bytedance.android.livesdk.interactivity.api.publicscreen.g> getMessageSourceManager() {
        return (com.bytedance.live.datacontext.i) this.messageSourceManager$delegate.a(this, $$delegatedProperties[21]);
    }

    public final com.bytedance.live.datacontext.i<Store<String, com.bytedance.android.livesdk.interactivity.api.publicscreen.i.a>> getModelFactoryStore() {
        return (com.bytedance.live.datacontext.i) this.modelFactoryStore$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.j<u42.c> getPinManager() {
        return (com.bytedance.live.datacontext.j) this.pinManager$delegate.a(this, $$delegatedProperties[8]);
    }

    public final com.bytedance.live.datacontext.i<PSMessageRepositoryStore> getRepository() {
        return (com.bytedance.live.datacontext.i) this.repository$delegate.a(this, $$delegatedProperties[14]);
    }

    public com.bytedance.live.datacontext.i<Store<PublicScreenConfig$ViewBinderType, com.bytedance.android.livesdk.interactivity.api.publicscreen.j<? extends com.bytedance.android.livesdk.interactivity.api.publicscreen.i, ? extends PSMessageViewHolder>>> getViewBinderStore() {
        return (com.bytedance.live.datacontext.i) this.viewBinderStore$delegate.a(this, $$delegatedProperties[9]);
    }

    public com.bytedance.live.datacontext.m<Integer> getWaitMessageCount() {
        return (com.bytedance.live.datacontext.m) this.waitMessageCount$delegate.a(this, $$delegatedProperties[2]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f> getWaitMessageState() {
        return (com.bytedance.live.datacontext.m) this.waitMessageState$delegate.a(this, $$delegatedProperties[5]);
    }

    public com.bytedance.live.datacontext.m<Boolean> isHotState() {
        return (com.bytedance.live.datacontext.m) this.isHotState$delegate.a(this, $$delegatedProperties[1]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public com.bytedance.live.datacontext.m<Boolean> isMessageListEmpty() {
        return (com.bytedance.live.datacontext.m) this.isMessageListEmpty$delegate.a(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public e52.a getTextConfig() {
        return (e52.a) getConfig().getValue();
    }

    public PublicScreenContext(final DataCenter r11) {
        Intrinsics.checkNotNullParameter(r11, "dc");
        this.isMessageListEmpty$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.TRUE);
        Boolean r0 = Boolean.FALSE;
        this.isHotState$delegate = com.bytedance.live.datacontext.q.d(this, r0);
        this.waitMessageCount$delegate = com.bytedance.live.datacontext.q.d(this, 0);
        this.messageShowDelay$delegate = com.bytedance.live.datacontext.q.d(this, 0L);
        this.messageHeat$delegate = com.bytedance.live.datacontext.q.d(this, PublicScreenHeatState.DEFAULT);
        this.waitMessageState$delegate = com.bytedance.live.datacontext.q.d(this, new com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f(0));
        this.messageHeatState$delegate = com.bytedance.live.datacontext.q.d(this, PSMessageHeatState.NORMAL);
        this.modelFactoryStore$delegate = ConstantKt.d(this, new Store());
        this.pinManager$delegate = ConstantKt.c(this);
        Store r1 = new Store();
        r1.add(PublicScreenConfig$ViewBinderType.COMMON_TEXT, v.b);
        Unit r2 = Unit.INSTANCE;
        this.viewBinderStore$delegate = ConstantKt.d(this, r1);
        this.hasChangeOrientation$delegate = com.bytedance.live.datacontext.q.a(this, r0, new PublicScreenContext$hasChangeOrientation$2(this, r11));
        this.interceptorStore$delegate = ConstantKt.d(this, new Store());
        this.listeners$delegate = ConstantKt.a(this, new CopyOnWriteArrayList(), PublicScreenContext$listeners$2.INSTANCE);
        this.historyMentionChat$delegate = ConstantKt.c(this);
        this.repository$delegate = ConstantKt.d(this, new PSMessageRepositoryStore());
        this.config$delegate = ConstantKt.c(this);
        this.messageRepoManager$delegate = ConstantKt.c(this);
        this.pluginStore$delegate = ConstantKt.d(this, new PublicScreenPluginStore(this));
        this.messagePluginStore$delegate = ConstantKt.d(this, new PublicScreenMessagePluginStore(this));
        this.featurePluginStore$delegate = ConstantKt.d(this, new PublicScreenFeaturePluginStore());
        this.messageLogicFacade$delegate = ConstantKt.c(this);
        this.messageSourceManager$delegate = ConstantKt.d(this, new p92.a());
        this.localLikeStatusInfoMap$delegate = ConstantKt.d(this, new ChatLikeLinkedHashMap(((LiveAudiencePanelConfig) m4.a.getValue()).getLocalStoreSize(), 0, 0.0f, false, 14, null));
        this.likeEggSyncModel$delegate = ConstantKt.c(this);
    }

    public final void addMessageListener(s42.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) getListeners().getValue()).add(r2);
    }

    public void deleteMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r2) {
        Intrinsics.checkNotNullParameter(r2, "messageModel");
        ((PSMessageRepositoryStore) getRepository().getValue()).deleteMessage(r2);
    }

    public List<com.bytedance.android.livesdk.interactivity.api.publicscreen.i> findMessageByType(PublicScreenConfig$MessageModelType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return ((PSMessageRepositoryStore) getRepository().getValue()).findMessageByType(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public x getMessagePlugin(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        return ((PublicScreenPluginStore) getPluginStore().getValue()).getPlugin(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public h52.a<h52.d, ? extends h52.c> getMessagePluginByType(MessagePluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return ((PublicScreenMessagePluginStore) getMessagePluginStore().getValue()).getPluginByType(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public h52.b<? extends h52.c> getViewBinderPluginByItemType(int r2) {
        return ((PublicScreenMessagePluginStore) getMessagePluginStore().getValue()).getViewBinderByType(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public void insertMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r2) {
        Intrinsics.checkNotNullParameter(r2, "messageModel");
        ((PSMessageRepositoryStore) getRepository().getValue()).insertMessage(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public void insertMessageSourceData(h52.d r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        ((com.bytedance.android.livesdk.interactivity.api.publicscreen.g) getMessageSourceManager().getValue()).c(r2);
    }

    public void modifyMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.i r2) {
        Intrinsics.checkNotNullParameter(r2, "messageModel");
        ((PSMessageRepositoryStore) getRepository().getValue()).modifyMessage(r2);
    }

    public void onChanged(KVData r2) {
        if (r2 == null) goto L4;
        String r3 = r2.getKey();
    L6:
        if (Intrinsics.areEqual("data_screen_change_status", r3) == false) goto L9;
        getHasChangeOrientation().setValue(Boolean.TRUE);
        return;
    L9:
        return;
    L4:
        r3 = null;
        goto L6
    }

    public void registerFeaturePlugin(v42.a r2) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        ((j) getFeaturePluginStore().getValue()).registerPlugin(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public void registerMessagePlugin(h52.a<h52.d, ? extends h52.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "plugin");
        ((PublicScreenMessagePluginStore) getMessagePluginStore().getValue()).register(r3.getPluginType(), r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public void registerPlugin(x r3) {
        Intrinsics.checkNotNullParameter(r3, "plugin");
        ((PublicScreenPluginStore) getPluginStore().getValue()).load(r3.getClass(), r3);
    }

    public final void removeMessageListener(s42.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((CopyOnWriteArrayList) getListeners().getValue()).remove(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.l
    public void unregisterMessagePlugin(h52.a<h52.d, ? extends h52.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        ((PublicScreenMessagePluginStore) getMessagePluginStore().getValue()).unregister(r2.getPluginType());
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((KVData) r1);
    }
}
