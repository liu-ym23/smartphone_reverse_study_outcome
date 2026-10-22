package com.ss.android.lark.picker.recommand;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.feed.v1.ForwardIncludeItem;
import com.bytedance.lark.pb.feed.v1.GetRecentVisitTargetsRequestV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.AI;
import com.ss.android.lark.picker.config.Bot;
import com.ss.android.lark.picker.config.Chatter;
import com.ss.android.lark.picker.config.ChatterFilter;
import com.ss.android.lark.picker.config.Entity;
import com.ss.android.lark.picker.config.Filter;
import com.ss.android.lark.picker.config.Group;
import com.ss.android.lark.picker.config.GroupFilter;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.picker.config.condition.ChatMode;
import com.ss.android.lark.picker.config.condition.Condition;
import com.ss.android.lark.picker.config.condition.Tenant;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0015H\u0002J=\u0010\u0016\u001a\u00020\u0017\"\u0014\b\u0000\u0010\u0018*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0019*\u0004\u0018\u0001H\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00170\u001bH\u0002¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\u0010\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030 0\u0005H\u0002JB\u0010!\u001a\u0004\u0018\u0001H\"\"\f\b\u0000\u0010#*\u0006\u0012\u0002\b\u00030$\"\u0010\b\u0001\u0010\"\u0018\u0001*\b\u0012\u0004\u0012\u0002H\"0 *\u0002H#2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\"0&H\u0082\b¢\u0006\u0002\u0010'¨\u0006)"}, d2 = {"Lcom/ss/android/lark/picker/recommand/RecentVisitDataFetcher;", "", "<init>", "()V", "fetchRecentVisitData", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "config", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "(Lcom/ss/android/lark/picker/config/SearcherConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPbForwardIncludeItem", "", "Lcom/bytedance/lark/pb/feed/v1/ForwardIncludeItem$IncludeItem;", "buildGroup", "entity", "Lcom/ss/android/lark/picker/config/Group;", "buildChatter", "Lcom/ss/android/lark/picker/config/Chatter;", "buildAI", "Lcom/ss/android/lark/picker/config/AI;", "buildBot", "Lcom/ss/android/lark/picker/config/Bot;", "takeIfNotNone", "", "E", "Lcom/ss/android/lark/picker/config/Entity;", "block", "Lkotlin/Function1;", "(Lcom/ss/android/lark/picker/config/Entity;Lkotlin/jvm/functions/Function1;)V", "isNone", "", "conditions", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "match", "C", "F", "Lcom/ss/android/lark/picker/config/Filter;", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "(Lcom/ss/android/lark/picker/config/Filter;Lcom/ss/android/lark/picker/config/condition/Condition$Key;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RecentVisitDataFetcher {
    public static final Companion Companion = null;
    private static final int MAX_COUNT = 60;
    private static final String TAG = "RecentVisitDataFetcher";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/recommand/RecentVisitDataFetcher$Companion;", "", "<init>", "()V", "TAG", "", "MAX_COUNT", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[Tenant.values().length];
            r0[Tenant.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[Tenant.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[Tenant.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[ChatMode.values().length];
            r1[ChatMode.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[ChatMode.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[ChatMode.THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            $EnumSwitchMapping$1 = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RecentVisitDataFetcher() {
    }

    private final ForwardIncludeItem.IncludeItem buildAI(AI r2) {
        ForwardIncludeItem.IncludeItem r3 = new ForwardIncludeItem.IncludeItem.Builder().my_ai_configs(new ForwardIncludeItem.IncludeItem.MyAIConfig.Builder().build()).build();
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    private final ForwardIncludeItem.IncludeItem buildBot(Bot r2) {
        ForwardIncludeItem.IncludeItem r3 = new ForwardIncludeItem.IncludeItem.Builder().bot_configs(new ForwardIncludeItem.IncludeItem.BotConfig.Builder().build()).build();
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    private final ForwardIncludeItem.IncludeItem buildChatter(Chatter r6) {
        ForwardIncludeItem.IncludeItem.Builder r0 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.UserConfig.Builder r1 = new ForwardIncludeItem.IncludeItem.UserConfig.Builder().talked_status_condition(ForwardIncludeItem.TalkedStatusCondition.ALL_TALKED).work_status_condition(ForwardIncludeItem.WorkStatusCondition.NOT_RESIGNED);
        ChatterFilter r7 = r6.getFilter();
        Tenant.Key r2 = Tenant.Key.INSTANCE;
        Condition.Element r8 = (Condition.Element) CollectionsKt.firstOrNull(r7.getConditions());
        if (r8 == null) goto L5;
        Condition.Element r9 = r8.get(r2);
    L6:
        Tenant r10 = (Tenant) r9;
        int r3 = 0;
        if (r10 == null) goto L17;
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 == 1) goto L17;
        if (r11 != 2) goto L13;
        r3 = 1;
        goto L17
    L13:
        if (r11 != 3) goto L17;
        r3 = 2;
    L17:
        ForwardIncludeItem.IncludeItem r12 = r0.user_configs(r1.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r3)).user_type_condition(ForwardIncludeItem.UserTypeCondition.ALL_USER).build()).build();
        Intrinsics.checkNotNull(r12);
        return r12;
    L5:
        r9 = null;
        goto L6
    }

    private final ForwardIncludeItem.IncludeItem buildGroup(Group r10) {
        ForwardIncludeItem.IncludeItem.Builder r0 = new ForwardIncludeItem.IncludeItem.Builder();
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r1 = new ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder();
        GroupFilter r2 = r10.getFilter();
        Tenant.Key r3 = Tenant.Key.INSTANCE;
        Condition.Element r4 = (Condition.Element) CollectionsKt.firstOrNull(r2.getConditions());
        Condition.Element r5 = null;
        if (r4 == null) goto L5;
        Condition.Element r6 = r4.get(r3);
    L6:
        Tenant r7 = (Tenant) r6;
        int r8 = 2;
        int r9 = 0;
        if (r7 == null) goto L15;
        int r11 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L14;
        if (r11 != 3) goto L15;
        int r12 = 2;
    L16:
        ForwardIncludeItem.IncludeItem.GroupChatConfig.Builder r13 = r1.tenant_condition(ForwardIncludeItem.TenantCondition.fromValue(r12)).shield_type_condition(ForwardIncludeItem.ShieldTypeCondition.NORMAL);
        GroupFilter r14 = r10.getFilter();
        ChatMode.Key r15 = ChatMode.Key.INSTANCE;
        Condition.Element r16 = (Condition.Element) CollectionsKt.firstOrNull(r14.getConditions());
        if (r16 == null) goto L19;
        r5 = r16.get(r15);
    L19:
        ChatMode r17 = (ChatMode) r5;
        if (r17 == null) goto L29;
        int r18 = WhenMappings.$EnumSwitchMapping$1[r17.ordinal()];
        if (r18 == 1) goto L27;
        if (r18 == 2) goto L26;
        if (r18 != 3) goto L27;
    L28:
        r9 = r8;
        goto L29
    L26:
        r8 = 1;
    L27:
        r8 = 0;
    L29:
        ForwardIncludeItem.IncludeItem r19 = r0.group_chat_configs(r13.group_chat_type_condition(ForwardIncludeItem.GroupChatTypeCondition.fromValue(r9)).public_type_condition(ForwardIncludeItem.PublicTypeCondition.ALL_STATUS).build()).build();
        Intrinsics.checkNotNull(r19);
        return r19;
    L14:
        r12 = 1;
    L15:
        r12 = 0;
        goto L16
    L5:
        r6 = null;
        goto L6
    }

    private final List<ForwardIncludeItem.IncludeItem> getPbForwardIncludeItem(SearcherConfig r5) {
        final ArrayList r0 = new ArrayList();
        AI r1 = null;
        if (r5 == null) goto L16;
        Entity<?, ?, ?> r2 = r5.getEntities().get(Reflection.getOrCreateKotlinClass(Group.class));
        if (r2 != null) goto L7;
    L12:
        Group r3 = null;
    L14:
        if (r3 == null) goto L16;
        takeIfNotNone(r3, new AnonymousClass1(r0, this));
        goto L16
    L7:
        if ((r2 instanceof Group) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r3 = (Group) r2;
    L16:
        if (r5 == null) goto L29;
        Entity<?, ?, ?> r4 = r5.getEntities().get(Reflection.getOrCreateKotlinClass(Chatter.class));
        if (r4 != null) goto L20;
    L25:
        Chatter r6 = null;
    L27:
        if (r6 == null) goto L29;
        takeIfNotNone(r6, new AnonymousClass2(r0, this));
        goto L29
    L20:
        if ((r4 instanceof Chatter) == true) goto L23;
        r4 = null;
    L23:
        if (r4 == null) goto L25;
        r6 = (Chatter) r4;
    L29:
        if (r5 == null) goto L42;
        Entity<?, ?, ?> r7 = r5.getEntities().get(Reflection.getOrCreateKotlinClass(Bot.class));
        if (r7 != null) goto L33;
    L38:
        Bot r8 = null;
    L40:
        if (r8 == null) goto L42;
        takeIfNotNone(r8, new AnonymousClass3(r0, this));
        goto L42
    L33:
        if ((r7 instanceof Bot) == true) goto L36;
        r7 = null;
    L36:
        if (r7 == null) goto L38;
        r8 = (Bot) r7;
    L42:
        if (r5 == null) goto L54;
        Entity<?, ?, ?> r9 = r5.getEntities().get(Reflection.getOrCreateKotlinClass(AI.class));
        if (r9 == null) goto L52;
        if ((r9 instanceof AI) == true) goto L49;
        r9 = null;
    L49:
        if (r9 == null) goto L52;
        r1 = (AI) r9;
    L52:
        if (r1 == null) goto L54;
        takeIfNotNone(r1, new AnonymousClass4(r0, this));
    L54:
        return r0;
    }

    private final boolean isNone(List<? extends Condition.Element<?>> r4) {
        List<? extends Condition.Element<?>> r5 = r4;
        boolean r1 = false;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        if ((!((Condition.Element) r6.next()).isNone()) == false) goto L9;
        r1 = true;
    L14:
        return !r1;
    L5:
        if (r5.isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ ForwardIncludeItem.IncludeItem access$buildAI(RecentVisitDataFetcher r0, AI r1) {
        return r0.buildAI(r1);
    }

    public static final /* synthetic */ ForwardIncludeItem.IncludeItem access$buildBot(RecentVisitDataFetcher r0, Bot r1) {
        return r0.buildBot(r1);
    }

    public static final /* synthetic */ ForwardIncludeItem.IncludeItem access$buildChatter(RecentVisitDataFetcher r0, Chatter r1) {
        return r0.buildChatter(r1);
    }

    public static final /* synthetic */ ForwardIncludeItem.IncludeItem access$buildGroup(RecentVisitDataFetcher r0, Group r1) {
        return r0.buildGroup(r1);
    }

    private final /* synthetic */ <F extends Filter<?>, C extends Condition.Element<C>> C match(F r1, Condition.Key<C> r2) {
        Condition.Element r3 = (Condition.Element) CollectionsKt.firstOrNull(r1.getConditions());
        if (r3 != null) goto L7;
        return null;
    L7:
        return (C) r3.get(r2);
    }

    private final <E extends Entity<?, ?, ?>> void takeIfNotNone(E r2, Function1<? super E, Unit> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (isNone(r2.getFilter().getConditions()) == true) goto L9;
        r3.invoke(r2);
        return;
    }

    public final Object fetchRecentVisitData(SearcherConfig r5, Continuation<? super List<? extends SearchBaseInfo>> r6) {
        final long r0 = SystemClock.elapsedRealtime();
        GetRecentVisitTargetsRequestV2.Builder r7 = new GetRecentVisitTargetsRequestV2.Builder().limit(Boxing.boxInt(MAX_COUNT)).sync_data_strategy(SyncDataStrategy.FORCE_SERVER).include_items(getPbForwardIncludeItem(r5));
        SdkSender.IParser r2 = new RecentVisitDataFetcher$fetchRecentVisitData$parser$1(r0);
        final SafeContinuation r1 = new SafeContinuation(IntrinsicsKt.intercepted(r6));
        IGetDataCallback<List<SearchBaseInfo>> r3 = new RecentVisitDataFetcher$fetchRecentVisitData$2$innerCallback$1(r1);
        SdkSender.asynSendRequestNonWrap(Command.GET_RECENT_VISIT_TARGETS_V2, r7, r3, r2);
        Object r8 = r1.getOrThrow();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r8;
    }
}
