package com.ss.android.lark.picker;

import android.os.SystemClock;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.DocSortRuleType;
import com.bytedance.lark.pb.basic.v1.UserGroupSceneType;
import com.bytedance.lark.pb.search.v1.ChatterPermissionsRequest;
import com.bytedance.lark.pb.search.v2.BaseEntity;
import com.bytedance.lark.pb.search.v2.BaseEnum;
import com.bytedance.lark.pb.search.v2.SearchCommonRequestHeader;
import com.bytedance.lark.pb.search.v2.SearchEntityType;
import com.bytedance.lark.pb.search.v2.SearchScene;
import com.bytedance.lark.pb.search.v2.UniversalFilters;
import com.bytedance.lark.pb.search.v2.UniversalSearchRequest;
import com.bytedance.lark.pb.search.v2.UniversalSelectors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.statistics.PickerTracker;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.utils.FG;
import com.ss.android.lark.picker.config.AI;
import com.ss.android.lark.picker.config.AIFilter;
import com.ss.android.lark.picker.config.Bot;
import com.ss.android.lark.picker.config.BotFilter;
import com.ss.android.lark.picker.config.Chatter;
import com.ss.android.lark.picker.config.ChatterExtra;
import com.ss.android.lark.picker.config.ChatterFilter;
import com.ss.android.lark.picker.config.Department;
import com.ss.android.lark.picker.config.DepartmentFilter;
import com.ss.android.lark.picker.config.Doc;
import com.ss.android.lark.picker.config.DocExtra;
import com.ss.android.lark.picker.config.DocFilter;
import com.ss.android.lark.picker.config.Entity;
import com.ss.android.lark.picker.config.ExtendedSearch;
import com.ss.android.lark.picker.config.Filter;
import com.ss.android.lark.picker.config.Group;
import com.ss.android.lark.picker.config.GroupExtra;
import com.ss.android.lark.picker.config.GroupFilter;
import com.ss.android.lark.picker.config.MailContact;
import com.ss.android.lark.picker.config.MailUser;
import com.ss.android.lark.picker.config.MailUserExtra;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.picker.config.ShieldP2P;
import com.ss.android.lark.picker.config.ShieldP2PExtra;
import com.ss.android.lark.picker.config.Thread;
import com.ss.android.lark.picker.config.TopExtra;
import com.ss.android.lark.picker.config.UserGroup;
import com.ss.android.lark.picker.config.UserGroupExtra;
import com.ss.android.lark.picker.config.UserGroupFilter;
import com.ss.android.lark.picker.config.Wiki;
import com.ss.android.lark.picker.config.WikiExtra;
import com.ss.android.lark.picker.config.WikiFilter;
import com.ss.android.lark.picker.config.WikiSpace;
import com.ss.android.lark.picker.config.WikiSpaceFilter;
import com.ss.android.lark.picker.config.condition.AICondition;
import com.ss.android.lark.picker.config.condition.ChatIds;
import com.ss.android.lark.picker.config.condition.ChatMode;
import com.ss.android.lark.picker.config.condition.ChatterCondition;
import com.ss.android.lark.picker.config.condition.ChatterFoldCondition;
import com.ss.android.lark.picker.config.condition.Condition;
import com.ss.android.lark.picker.config.condition.Contact;
import com.ss.android.lark.picker.config.condition.ContainMemberIds;
import com.ss.android.lark.picker.config.condition.CreatorIds;
import com.ss.android.lark.picker.config.condition.CryptoStatus;
import com.ss.android.lark.picker.config.condition.DocType;
import com.ss.android.lark.picker.config.condition.DocTypes;
import com.ss.android.lark.picker.config.condition.Folders;
import com.ss.android.lark.picker.config.condition.FromUserIds;
import com.ss.android.lark.picker.config.condition.FrozenChat;
import com.ss.android.lark.picker.config.condition.GroupCondition;
import com.ss.android.lark.picker.config.condition.GroupFoldCondition;
import com.ss.android.lark.picker.config.condition.GroupPrivacy;
import com.ss.android.lark.picker.config.condition.JobStatus;
import com.ss.android.lark.picker.config.condition.JoinStatus;
import com.ss.android.lark.picker.config.condition.ManageStatus;
import com.ss.android.lark.picker.config.condition.MatchScope;
import com.ss.android.lark.picker.config.condition.SharerIds;
import com.ss.android.lark.picker.config.condition.ShieldStatus;
import com.ss.android.lark.picker.config.condition.TalkStatus;
import com.ss.android.lark.picker.config.condition.Tenant;
import com.ss.android.lark.picker.config.condition.TimeRange;
import com.ss.android.lark.picker.config.condition.UserGroupType;
import com.ss.android.lark.picker.config.condition.WikiSpaceType;
import com.ss.android.lark.picker.config.condition.WikiSpaces;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.android.lark.search.parser.e;
import com.ss.android.lark.search.parser.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import z5c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0093\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000f\u0018\u0000 n2\u00020\u0001:\u0001nB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J>\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020!2\u0006\u0010(\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\b\u0012\u0004\u0012\u00020!002\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020!2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u0010\"\u001a\u00020#H\u0002J!\u0010N\u001a\u00020O2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010P\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010QJ\u001c\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030UH\u0002J\u0010\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u0016H\u0002J\u001c\u0010Y\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\n\u0010T\u001a\u0006\u0012\u0002\b\u00030ZH\u0002J\u0016\u0010[\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\\J\u001a\u0010]\u001a\u00020\u00162\u0010\u0010^\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030_00H\u0002J=\u0010`\u001a\u00020a\"\u0014\b\u0000\u0010b*\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030c*\u0004\u0018\u0001Hb2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u0002Hb\u0012\u0004\u0012\u00020a0eH\u0002¢\u0006\u0002\u0010fJB\u0010g\u001a\u0004\u0018\u0001Hh\"\f\b\u0000\u0010i*\u0006\u0012\u0002\b\u00030j\"\u0010\b\u0001\u0010h\u0018\u0001*\b\u0012\u0004\u0012\u0002Hh0_*\u0002Hi2\f\u0010k\u001a\b\u0012\u0004\u0012\u0002Hh0lH\u0082\b¢\u0006\u0002\u0010mR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/ss/android/lark/picker/Searcher;", "", "prickerTracker", "Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "<init>", "(Lcom/ss/android/lark/picker/base/statistics/PickerTracker;)V", "keyword", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "seqId", "", "pageToken", "config", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "parserDependency", "com/ss/android/lark/picker/Searcher$parserDependency$1", "Lcom/ss/android/lark/picker/Searcher$parserDependency$1;", "universalSearchResponseParser", "Lcom/ss/android/lark/search/parser/UniversalSearchResponseParser;", "spotlightUniversalSearchResponseParser", "Lcom/ss/android/lark/search/parser/UniversalSpotlightSearchResponseParser;", "isSpotlight", "", "forceServer", "search", "Lcom/ss/android/lark/search/dto/SearchResponse;", "requestId", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/picker/config/SearcherConfig;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchInternal", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/picker/config/SearcherConfig;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildRequest", "Lcom/bytedance/lark/pb/search/v2/UniversalSearchRequest$Builder;", "buildChatter", "Lcom/bytedance/lark/pb/search/v2/BaseEntity$EntityItem;", "chatter", "Lcom/ss/android/lark/picker/config/Chatter;", "buildGroup", "group", "Lcom/ss/android/lark/picker/config/Group;", "buildDoc", "doc", "Lcom/ss/android/lark/picker/config/Doc;", "buildWiki", "Lcom/ss/android/lark/picker/config/Wiki;", "buildWikiSpace", "wikiSpace", "Lcom/ss/android/lark/picker/config/WikiSpace;", "buildUserGroup", "", "userGroup", "Lcom/ss/android/lark/picker/config/UserGroup;", "buildUserGroupEntity", "userGroupType", "Lcom/bytedance/lark/pb/basic/v1/UserGroupType;", "groupSceneTypeValue", "buildShieldP2P", "shieldP2P", "Lcom/ss/android/lark/picker/config/ShieldP2P;", "buildDepartment", "department", "Lcom/ss/android/lark/picker/config/Department;", "buildBot", "bot", "Lcom/ss/android/lark/picker/config/Bot;", "buildMailContact", "mailContact", "Lcom/ss/android/lark/picker/config/MailContact;", "buildMailUser", "mailUser", "Lcom/ss/android/lark/picker/config/MailUser;", "buildAI", "ai", "Lcom/ss/android/lark/picker/config/AI;", "buildThread", "thread", "Lcom/ss/android/lark/picker/config/Thread;", "buildCommonFilter", "Lcom/bytedance/lark/pb/search/v2/UniversalFilters$CommonFilter;", "buildExtra", "Lcom/bytedance/lark/pb/search/v2/BaseEntity$SearchExtras;", "needInsertDoubaoWork", "(Lcom/ss/android/lark/picker/config/Chatter;Ljava/lang/Boolean;)Lcom/bytedance/lark/pb/search/v2/BaseEntity$SearchExtras;", "handleChatterLine", "line", "condition", "Lcom/ss/android/lark/picker/config/condition/ChatterCondition;", "getMergePolicy", "Lcom/bytedance/lark/pb/search/v2/BaseEnum$MergePolicy;", "isSpotLight", "handleGroupLine", "Lcom/ss/android/lark/picker/config/condition/GroupCondition;", "loadMore", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNone", "conditions", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "takeIfNotNone", "", "E", "Lcom/ss/android/lark/picker/config/Entity;", "block", "Lkotlin/Function1;", "(Lcom/ss/android/lark/picker/config/Entity;Lkotlin/jvm/functions/Function1;)V", "match", "C", "F", "Lcom/ss/android/lark/picker/config/Filter;", "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "(Lcom/ss/android/lark/picker/config/Filter;Lcom/ss/android/lark/picker/config/condition/Condition$Key;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class Searcher {
    public static final Companion Companion = null;
    private static final BaseEnum.MergePolicy MERGE_POLICY = null;
    private static final String TAG = "Searcher";
    private SearcherConfig config;
    private boolean forceServer;
    private boolean isSpotlight;
    private String keyword;
    private String pageToken;
    private Searcher$parserDependency$1 parserDependency;
    private final PickerTracker prickerTracker;
    private int seqId;
    private String session;
    private f spotlightUniversalSearchResponseParser;
    private e universalSearchResponseParser;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/Searcher$Companion;", "", "<init>", "()V", "TAG", "", "MERGE_POLICY", "Lcom/bytedance/lark/pb/search/v2/BaseEnum$MergePolicy;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
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
        public static final /* synthetic */ int[] $EnumSwitchMapping$10 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$9 = null;

        static {
            int[] r0 = new int[ManageStatus.values().length];
            r0[ManageStatus.MY_MANAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L56
        L120:
            r0[ManageStatus.NOT_MY_MANAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L57
        L130:
            r0[ManageStatus.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L58
        L142:
            r0[ManageStatus.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L59
        L10:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[ChatMode.values().length];
            r1[ChatMode.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L60
        L158:
            r1[ChatMode.THREAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L61
        L94:
            r1[ChatMode.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L62
        L104:
            r1[ChatMode.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L63
        L15:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[MatchScope.values().length];
            r2[MatchScope.ONLY_TITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L64
        L134:
            r2[MatchScope.ONLY_COMMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L65
        L146:
            r2[MatchScope.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L66
        L19:
            $EnumSwitchMapping$2 = r2;
            int[] r3 = new int[WikiSpaceType.values().length];
            r3[WikiSpaceType.TEAM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L67
        L98:
            r3[WikiSpaceType.PERSONAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L68
        L108:
            r3[WikiSpaceType.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L69
        L116:
            r3[WikiSpaceType.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L70
        L24:
            $EnumSwitchMapping$3 = r3;
            int[] r4 = new int[UserGroupType.values().length];
            r4[UserGroupType.STATIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L71
        L148:
            r4[UserGroupType.DYNAMIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L72
        L156:
            r4[UserGroupType.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L73
        L164:
            r4[UserGroupType.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L74
        L29:
            $EnumSwitchMapping$4 = r4;
            int[] r5 = new int[TalkStatus.values().length];
            r5[TalkStatus.TALKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L75
        L126:
            r5[TalkStatus.UN_TALKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L76
        L138:
            r5[TalkStatus.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L77
        L150:
            r5[TalkStatus.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L78
        L34:
            $EnumSwitchMapping$5 = r5;
            int[] r6 = new int[JobStatus.values().length];
            r6[JobStatus.ON_JOB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L79
        L100:
            r6[JobStatus.RESIGNED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L80
        L112:
            r6[JobStatus.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L81
        L38:
            $EnumSwitchMapping$6 = r6;
            int[] r7 = new int[JoinStatus.values().length];
            r7[JoinStatus.JOINED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L82
        L140:
            r7[JoinStatus.UN_JOINED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L83
        L152:
            r7[JoinStatus.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L84
        L42:
            $EnumSwitchMapping$7 = r7;
            int[] r8 = new int[GroupPrivacy.values().length];
            r8[GroupPrivacy.PRIVATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L85
        L102:
            r8[GroupPrivacy.PUBLIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L86
        L114:
            r8[GroupPrivacy.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L87
        L46:
            $EnumSwitchMapping$8 = r8;
            int[] r9 = new int[Tenant.values().length];
            r9[Tenant.OUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L88
        L132:
            r9[Tenant.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L89
        L144:
            r9[Tenant.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L90
        L50:
            $EnumSwitchMapping$9 = r9;
            int[] r10 = new int[CryptoStatus.values().length];
            r10[CryptoStatus.CRYPTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L91
        L96:
            r10[CryptoStatus.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L92
        L106:
            r10[CryptoStatus.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L93
        L54:
            $EnumSwitchMapping$10 = r10;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.Searcher$searchInternal$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/search/dto/SearchResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.picker.Searcher$searchInternal$2", f = "Searcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponse>, Object> {
        final /* synthetic */ SearcherConfig $config;
        final /* synthetic */ boolean $isSpotlight;
        final /* synthetic */ String $keyword;
        final /* synthetic */ String $requestId;
        int label;
        final /* synthetic */ Searcher this$0;

        public AnonymousClass2(Searcher r1, String r2, SearcherConfig r3, boolean r4, String r5, Continuation<? super AnonymousClass2> r6) {
            this.this$0 = r1;
            this.$keyword = r2;
            this.$config = r3;
            this.$isSpotlight = r4;
            this.$requestId = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass2(this.this$0, this.$keyword, this.$config, this.$isSpotlight, this.$requestId, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super SearchResponse> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r13);
            long r0 = SystemClock.elapsedRealtime();
            PickerTracker r2 = Searcher.access$getPrickerTracker$p(this.this$0);
            if (r2 == null) goto L7;
            PickerTracker.trackSearch$default(r2, a.e, 0, 2, null);
        L7:
            StringBuilder r14 = new StringBuilder("keyword is empty: ");
            String r3 = this.$keyword;
            if (r3 != null) goto L10;
        L13:
            boolean r4 = true;
        L14:
            r14.append(r4);
            r14.append(", search config: ");
            r14.append(ConfigSerializationKt.serialize(this.$config));
            r14.append(", isSpotlight: ");
            r14.append(this.$isSpotlight);
            Log.i(Searcher.TAG, r14.toString());
            final UniversalSearchRequest.Builder r15 = Searcher.access$buildRequest(this.this$0, this.$keyword, this.$config, this.$isSpotlight);
            Command r5 = Command.UNIVERSAL_SEARCH;
            final String r6 = this.$requestId;
            final SearcherConfig r7 = this.$config;
            final boolean r8 = this.$isSpotlight;
            final Searcher r9 = this.this$0;
            SdkSender.d r16 = SdkSender.syncSendMayError(r5, r15, r6, new Searcher$searchInternal$2$sdkResult$1(r7, r8, r9, r6, r15));
            SearchResponse r10 = (SearchResponse) r16.a;
            ErrorResult r17 = r16.b;
            if (r10 == null) goto L22;
            if (r17 != null) goto L22;
            Searcher.access$setPageToken$p(this.this$0, r10.getPageToken());
            PickerTracker r18 = Searcher.access$getPrickerTracker$p(this.this$0);
            if (r18 == null) goto L21;
            r18.trackSearch(a.f, SystemClock.elapsedRealtime() - r0);
        L21:
            return r10;
        L22:
            if (r17 == null) goto L27;
            String r1 = r17.getDisplayMsg();
            if (r1 != null) goto L26;
            r1 = "search error";
        L26:
            Log.e(Searcher.TAG, r1, r17.getException());
        L27:
            PickerTracker r11 = Searcher.access$getPrickerTracker$p(this.this$0);
            if (r11 == null) goto L30;
            PickerTracker.trackSearch$default(r11, a.g, 0, 2, null);
        L30:
            if (r17 == null) goto L33;
            throw r17;
        L33:
            throw new UnknownError("Unknown Error");
        L10:
            if (r3.length() == 0) goto L13;
            r4 = false;
            goto L14
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public Searcher() {
        PickerTracker r0 = null;
        this(r0, 1, r0);
    }

    static {
        Companion = new Companion(null);
        MERGE_POLICY = BaseEnum.MergePolicy.COMBINE_LOCAL_AND_SERVER;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.ss.android.lark.picker.Searcher$parserDependency$1] */
    public Searcher(PickerTracker r3) {
        this.prickerTracker = r3;
        StringBuilder r4 = new StringBuilder();
        r4.append(System.currentTimeMillis());
        r4.append('_');
        r4.append(UUID.randomUUID());
        this.session = r4.toString();
        this.parserDependency = new Searcher$parserDependency$1();
        this.universalSearchResponseParser = new e(this.parserDependency);
        this.spotlightUniversalSearchResponseParser = new f(this.parserDependency);
    }

    public static final /* synthetic */ PickerTracker access$getPrickerTracker$p(Searcher r0) {
        return r0.prickerTracker;
    }

    public static final /* synthetic */ f access$getSpotlightUniversalSearchResponseParser$p(Searcher r0) {
        return r0.spotlightUniversalSearchResponseParser;
    }

    public static final /* synthetic */ e access$getUniversalSearchResponseParser$p(Searcher r0) {
        return r0.universalSearchResponseParser;
    }

    private final BaseEntity.EntityItem buildAI(AI r5) {
        AIFilter r0 = r5.getFilter();
        r5.getExtra();
        BaseEntity.EntityItem.Builder r6 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.MY_AI);
        BaseEntity.EntityFilter.Builder r1 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.MyAIFilter.Builder r2 = new UniversalFilters.MyAIFilter.Builder();
        AICondition r3 = (AICondition) CollectionsKt.firstOrNull(r0.getConditions());
        if (r3 == null) goto L20;
        TalkStatus r4 = (TalkStatus) r3.get(TalkStatus.Key.INSTANCE);
        if (r4 == null) goto L20;
        int r7 = WhenMappings.$EnumSwitchMapping$5[r4.ordinal()];
        if (r7 != 1) goto L9;
        r2.must_have_chat(Boolean.TRUE);
        goto L20
    L9:
        if (r7 != 2) goto L11;
        r2.must_have_chat(Boolean.FALSE);
        goto L20
    L11:
        if (r7 != 3) goto L13;
        r2.must_have_chat(Boolean.FALSE);
        goto L20
    L13:
        if (r7 != 4) goto L16;
        Unit r8 = Unit.INSTANCE;
        goto L20
    L16:
        throw new NoWhenBranchMatchedException();
    L20:
        Unit r9 = Unit.INSTANCE;
        return r6.entity_filter(r1.my_ai_filter(r2.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    }

    private final BaseEntity.EntityItem buildBot(Bot r8) {
        BotFilter r0 = r8.getFilter();
        r8.getExtra();
        BaseEntity.EntityItem.Builder r9 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.BOT);
        BaseEntity.EntityFilter.Builder r1 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.BotFilter.Builder r2 = new UniversalFilters.BotFilter.Builder();
        TalkStatus.Key r3 = TalkStatus.Key.INSTANCE;
        Condition.Element r4 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        List r5 = null;
        if (r4 == null) goto L5;
        Condition.Element r6 = r4.get(r3);
    L6:
        TalkStatus r7 = (TalkStatus) r6;
        if (r7 == null) goto L24;
        int r10 = WhenMappings.$EnumSwitchMapping$5[r7.ordinal()];
        if (r10 != 1) goto L11;
        r5 = CollectionsKt.listOf(Integer.valueOf(UniversalFilters.BotFilter.SearchType.TALKED.getValue()));
    L22:
        if (r5 == null) goto L24;
        r2.search_type(r5);
        goto L24
    L11:
        if (r10 != 2) goto L13;
        r5 = CollectionsKt.listOf(Integer.valueOf(UniversalFilters.BotFilter.SearchType.UN_TALKED.getValue()));
        goto L22
    L13:
        if (r10 != 3) goto L15;
        r5 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(UniversalFilters.BotFilter.SearchType.TALKED.getValue()), Integer.valueOf(UniversalFilters.BotFilter.SearchType.UN_TALKED.getValue())});
        goto L22
    L15:
        if (r10 == 4) goto L22;
        throw new NoWhenBranchMatchedException();
    L24:
        Unit r11 = Unit.INSTANCE;
        return r9.entity_filter(r1.bot_filter(r2.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L5:
        r6 = null;
        goto L6
    }

    private final BaseEntity.EntityItem buildChatter(Chatter r15) {
        ChatterFilter r0 = r15.getFilter();
        ChatterExtra r16 = r15.getExtra();
        BaseEntity.EntityItem.Builder r1 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.USER);
        BaseEntity.EntityFilter.Builder r2 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.UserFilter.Builder r3 = new UniversalFilters.UserFilter.Builder();
        ArrayList r4 = new ArrayList();
        Iterator<ChatterCondition<?>> r5 = r0.getConditions().iterator();
    L3:
        boolean r7 = false;
        int r8 = 0;
        if (r5.hasNext() == false) goto L14;
        ChatterCondition<?> r6 = r5.next();
        if ((r6 instanceof ChatterFoldCondition) == false) goto L11;
        Iterator r9 = ((Iterable) r6).iterator();
    L9:
        if (r9.hasNext() == false) goto L12;
        r8 = handleChatterLine(r8, (ChatterCondition) r9.next());
    L12:
        if (r8 == 0) goto L3;
        r4.add(Integer.valueOf(r8));
        goto L3
    L11:
        r8 = handleChatterLine(0, r6);
        goto L12
    L14:
        r3.search_type(r4);
        List r10 = r3.search_type;
        if (r10 == null) goto L37;
        Iterator r11 = r10.iterator();
        int r12 = -1;
        int r13 = 0;
        int r14 = -1;
    L18:
        if (r11.hasNext() == false) goto L30;
        int r17 = r13 + 1;
        Integer r18 = (Integer) r11.next();
        if ((r18.intValue() & UniversalFilters.UserFilter.SearchType.UN_RESIGNED.getValue()) == 0) goto L25;
        if ((r18.intValue() & UniversalFilters.UserFilter.SearchType.RESIGNED.getValue()) != 0) goto L25;
        r12 = r13;
    L29:
        r13 = r17;
    L25:
        if ((r18.intValue() & UniversalFilters.UserFilter.SearchType.TALKED.getValue()) == 0) goto L29;
        if ((r18.intValue() & UniversalFilters.UserFilter.SearchType.UN_TALKED.getValue()) != 0) goto L29;
        r14 = r13;
        goto L29
    L30:
        if (r12 == (-1)) goto L37;
        if (r14 == (-1)) goto L37;
        List r19 = r3.search_type;
        int r20 = ((Number) ListProtector.get(r19, r12)).intValue();
        UniversalFilters.UserFilter.SearchType r21 = UniversalFilters.UserFilter.SearchType.UN_RESIGNED;
        int r22 = r20 & (~r21.getValue());
        UniversalFilters.UserFilter.SearchType r110 = UniversalFilters.UserFilter.SearchType.TALKED;
        int r23 = r22 & (~r110.getValue());
        UniversalFilters.UserFilter.SearchType r111 = UniversalFilters.UserFilter.SearchType.RESIGNED;
        ListProtector.set(r19, r12, Integer.valueOf((r23 | r111.getValue()) | UniversalFilters.UserFilter.SearchType.UN_TALKED.getValue()));
        int r24 = ((Number) ListProtector.get(r3.search_type, r14)).intValue() & (~r110.getValue());
        if (r24 != 0) goto L35;
        ListProtector.remove(r3.search_type, r14);
    L36:
        r3.exclude(Boolean.TRUE);
        goto L37
    L35:
        ListProtector.set(r3.search_type, r14, Integer.valueOf((r24 & (~r21.getValue())) & (~r111.getValue())));
    L37:
        Unit r25 = Unit.INSTANCE;
        Contact.Key r26 = Contact.Key.INSTANCE;
        Condition.Element r27 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r27 == null) goto L40;
        Condition.Element r28 = r27.get(r26);
    L41:
        Contact r29 = (Contact) r28;
        if (r29 != null) goto L44;
    L47:
        Boolean r30 = r16.getExistsEnterpriseEmail();
        if (r30 == null) goto L50;
        r3.exists_enterprise_email(Boolean.valueOf(r30.booleanValue()));
    L50:
        List<Long> r31 = r16.getInUserIds();
        if (r31 == null) goto L53;
        r3.in_user_ids(r31);
    L53:
        BaseEntity.EntityItem.Builder r32 = r1.entity_filter(r2.user_filter(r3.build()).build());
        BaseEntity.EntitySelector.Builder r33 = new BaseEntity.EntitySelector.Builder();
        UniversalSelectors.UserSelector.Builder r34 = new UniversalSelectors.UserSelector.Builder();
        String r35 = r16.isReturnInChatId();
        if (r35 == null) goto L56;
        r34.is_in_chat_id = r35;
    L56:
        Boolean r36 = r16.isEnableFuzzySearch();
        if (r36 == null) goto L59;
        r34.is_fuzzy_user = Boolean.valueOf(r36.booleanValue());
    L59:
        r34.relation_tag = Boolean.valueOf(r16.isReturnRelationTag());
        String r112 = r16.isReturnInTeamId();
        if (r112 == null) goto L63;
        r34.is_directly_in_team_id = r112;
    L63:
        return r32.entity_selector(r33.user_selector(r34.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L44:
        if (r29 != Contact.INNER) goto L46;
        r7 = true;
    L46:
        r3.exclude_outer_contact(Boolean.valueOf(r7));
        goto L47
    L40:
        r28 = null;
        goto L41
    }

    private final UniversalFilters.CommonFilter buildCommonFilter(Chatter r3) {
        ChatterFilter r0 = r3.getFilter();
        r3.getExtra();
        UniversalFilters.CommonFilter.Builder r4 = new UniversalFilters.CommonFilter.Builder();
        Tenant.Key r1 = Tenant.Key.INSTANCE;
        Condition.Element r2 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r2 == null) goto L5;
        Condition.Element r5 = r2.get(r1);
    L6:
        Tenant r6 = (Tenant) r5;
        if (r6 == null) goto L17;
        if (r6 != Tenant.OUT) goto L11;
    L14:
        boolean r7 = true;
    L15:
        r4.include_outer_tenant(Boolean.valueOf(r7));
        goto L17
    L11:
        if (r6 == Tenant.ALL) goto L14;
        r7 = false;
    L17:
        return r4.build();
    L5:
        r5 = null;
        goto L6
    }

    private final BaseEntity.EntityItem buildDepartment(Department r5) {
        DepartmentFilter r0 = r5.getFilter();
        r5.getExtra();
        BaseEntity.EntityItem.Builder r6 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.DEPARTMENT);
        BaseEntity.EntityFilter.Builder r1 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.DepartmentFilter.Builder r2 = new UniversalFilters.DepartmentFilter.Builder();
        ManageStatus.Key r3 = ManageStatus.Key.INSTANCE;
        Condition.Element r4 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r4 == null) goto L5;
        Condition.Element r7 = r4.get(r3);
    L6:
        ManageStatus r8 = (ManageStatus) r7;
        if (r8 == null) goto L22;
        int r9 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r9 != 1) goto L11;
        r2.addable_as_user(Boolean.TRUE);
        goto L22
    L11:
        if (r9 != 2) goto L13;
        r2.addable_as_user(Boolean.FALSE);
        goto L22
    L13:
        if (r9 != 3) goto L15;
        r2.addable_as_user(Boolean.FALSE);
        goto L22
    L15:
        if (r9 != 4) goto L18;
        Unit r10 = Unit.INSTANCE;
        goto L22
    L18:
        throw new NoWhenBranchMatchedException();
    L22:
        Unit r11 = Unit.INSTANCE;
        return r6.entity_filter(r1.department_filter(r2.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L5:
        r7 = null;
        goto L6
    }

    private final BaseEntity.EntityItem buildDoc(Doc r10) {
        DocFilter r0 = r10.getFilter();
        DocExtra r11 = r10.getExtra();
        BaseEntity.EntityItem.Builder r1 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.DOC);
        BaseEntity.EntityFilter.Builder r2 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.DocFilter.Builder r3 = new UniversalFilters.DocFilter.Builder();
        CreatorIds.Key r4 = CreatorIds.Key;
        Condition.Element r5 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        Folders r6 = null;
        if (r5 == null) goto L5;
        Condition.Element r7 = r5.get(r4);
    L6:
        CreatorIds r8 = (CreatorIds) r7;
        if (r8 != null) goto L9;
    L14:
        ChatIds.Key r9 = ChatIds.Key;
        Condition.Element r12 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r12 == null) goto L17;
        Condition.Element r13 = r12.get(r9);
    L18:
        ChatIds r14 = (ChatIds) r13;
        if (r14 != null) goto L21;
    L26:
        DocTypes.Key r15 = DocTypes.Key.INSTANCE;
        Condition.Element r16 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r16 == null) goto L29;
        Condition.Element r17 = r16.get(r15);
    L30:
        DocTypes r18 = (DocTypes) r17;
        if (r18 != null) goto L33;
    L41:
        TimeRange.Key r19 = TimeRange.Key;
        Condition.Element r20 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r20 == null) goto L44;
        Condition.Element r21 = r20.get(r19);
    L45:
        TimeRange r22 = (TimeRange) r21;
        if (r22 == null) goto L48;
        r3.review_time_range(new UniversalFilters.TimeRange.Builder().start_time(Long.valueOf(r22.getStartTime())).end_time(Long.valueOf(r22.getEndTime())).build());
    L48:
        MatchScope.Key r23 = MatchScope.Key.INSTANCE;
        Condition.Element r24 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r24 == null) goto L51;
        Condition.Element r25 = r24.get(r23);
    L52:
        MatchScope r26 = (MatchScope) r25;
        if (r26 == null) goto L64;
        int r27 = WhenMappings.$EnumSwitchMapping$2[r26.ordinal()];
        if (r27 != 1) goto L57;
        r3.search_content_types(CollectionsKt.listOf(UniversalFilters.DocFilter.SearchContentType.ONLY_TITLE));
        goto L64
    L57:
        if (r27 != 2) goto L59;
        r3.search_content_types(CollectionsKt.listOf(UniversalFilters.DocFilter.SearchContentType.ONLY_COMMENT));
        goto L64
    L59:
        if (r27 == 3) goto L61;
        Unit r28 = Unit.INSTANCE;
        goto L64
    L61:
        r3.search_content_types(CollectionsKt.listOf(UniversalFilters.DocFilter.SearchContentType.FULL_CONTENT));
    L64:
        SharerIds.Key r29 = SharerIds.Key;
        Condition.Element r30 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r30 == null) goto L67;
        Condition.Element r31 = r30.get(r29);
    L68:
        SharerIds r32 = (SharerIds) r31;
        if (r32 != null) goto L71;
    L76:
        FromUserIds.Key r33 = FromUserIds.Key;
        Condition.Element r34 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r34 == null) goto L79;
        Condition.Element r35 = r34.get(r33);
    L80:
        FromUserIds r36 = (FromUserIds) r35;
        if (r36 != null) goto L83;
    L88:
        Folders.Key r37 = Folders.Key;
        Condition.Element r38 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r38 == null) goto L91;
        Condition.Element r39 = r38.get(r37);
    L92:
        Folders r40 = (Folders) r39;
        if (r40 != null) goto L95;
    L99:
        DocSortRuleType r41 = r11.getSortRule();
        if (r41 == null) goto L102;
        r3.sortType(r41);
    L102:
        Boolean r42 = r11.isEnableCrossLanguage();
        if (r42 == null) goto L105;
        r3.cross_language(Boolean.valueOf(r42.booleanValue()));
    L105:
        ExtendedSearch r43 = r11.getExtendedSearch();
        if (r43 != null) goto L108;
    L118:
        Unit r44 = Unit.INSTANCE;
        return r1.entity_filter(r2.doc_filter(r3.build()).build()).entity_selector(new BaseEntity.EntitySelector.Builder().doc_selector(new UniversalSelectors.DocSelector.Builder().relation_tag(Boolean.valueOf(r11.isReturnRelationTag())).build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L108:
        if ((r43 instanceof ExtendedSearch.CLOSE) == false) goto L111;
        r3.use_extended_search_v2(Boolean.TRUE);
        r3.enable_extended_search(Boolean.FALSE);
        goto L118
    L111:
        if ((r43 instanceof ExtendedSearch.OPEN) == false) goto L117;
        if (((ExtendedSearch.OPEN) r43).isUseV2() == false) goto L115;
        Boolean r45 = Boolean.TRUE;
        r3.use_extended_search_v2(r45);
        r3.enable_extended_search(r45);
        goto L118
    L115:
        r3.use_extended_search_v2(Boolean.FALSE);
        goto L118
    L117:
        throw new NoWhenBranchMatchedException();
    L95:
        if ((r40 instanceof Folders.IN) == false) goto L97;
        r6 = r40;
    L97:
        if (r6 == null) goto L99;
        r3.folder_tokens(CollectionsKt.toList(r6.getIds()));
        goto L99
    L91:
        r39 = null;
        goto L92
    L83:
        if ((r36 instanceof FromUserIds.IN) == true) goto L86;
        r36 = null;
    L86:
        if (r36 == null) goto L88;
        r3.from_ids(CollectionsKt.toList(r36.getIds()));
        goto L88
    L79:
        r35 = null;
        goto L80
    L71:
        if ((r32 instanceof SharerIds.IN) == true) goto L74;
        r32 = null;
    L74:
        if (r32 == null) goto L76;
        r3.sharer_ids(CollectionsKt.toList(r32.getIds()));
        goto L76
    L67:
        r31 = null;
        goto L68
    L51:
        r25 = null;
        goto L52
    L44:
        r21 = null;
        goto L45
    L33:
        if (Intrinsics.areEqual(r18, DocTypes.ALL.INSTANCE) == false) goto L35;
        List r46 = ArraysKt.toList(com.bytedance.lark.pb.basic.v1.Doc.Type.values());
    L40:
        r3.types(r46);
        goto L41
    L35:
        Set<DocType> r47 = r18.getTypes();
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator<T> r49 = r47.iterator();
    L37:
        if (r49.hasNext() == false) goto L39;
        r48.add(com.bytedance.lark.pb.basic.v1.Doc.Type.values()[((DocType) r49.next()).ordinal()]);
        goto L37
    L39:
        r46 = r48;
        goto L40
    L29:
        r17 = null;
        goto L30
    L21:
        if ((r14 instanceof ChatIds.IN) == true) goto L24;
        r14 = null;
    L24:
        if (r14 == null) goto L26;
        r3.chat_ids(CollectionsKt.toList(r14.getIds()));
        goto L26
    L17:
        r13 = null;
        goto L18
    L9:
        if ((r8 instanceof CreatorIds.IN) == true) goto L12;
        r8 = null;
    L12:
        if (r8 == null) goto L14;
        r3.creator_ids(CollectionsKt.toList(r8.getIds()));
        goto L14
    L5:
        r7 = null;
        goto L6
    }

    private final BaseEntity.EntityItem buildGroup(Group r12) {
        GroupFilter r0 = r12.getFilter();
        GroupExtra r13 = r12.getExtra();
        BaseEntity.EntityItem.Builder r1 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.GROUP_CHAT);
        BaseEntity.EntityFilter.Builder r2 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.ChatFilter.Builder r3 = new UniversalFilters.ChatFilter.Builder();
        ArrayList r4 = new ArrayList();
        Iterator<GroupCondition<?>> r5 = r0.getConditions().iterator();
    L3:
        boolean r7 = false;
        int r8 = 0;
        if (r5.hasNext() == false) goto L14;
        GroupCondition<?> r6 = r5.next();
        if ((r6 instanceof GroupFoldCondition) == false) goto L11;
        Iterator r9 = ((Iterable) r6).iterator();
    L9:
        if (r9.hasNext() == false) goto L12;
        r8 = handleGroupLine(r8, (GroupCondition) r9.next());
    L12:
        if (r8 == 0) goto L3;
        r4.add(Integer.valueOf(r8));
        goto L3
    L11:
        r8 = handleGroupLine(0, r6);
        goto L12
    L14:
        r3.search_types(r4);
        ContainMemberIds.Key r10 = ContainMemberIds.Key.INSTANCE;
        Condition.Element r11 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        Condition.Element r14 = null;
        if (r11 == null) goto L17;
        Condition.Element r15 = r11.get(r10);
    L18:
        ContainMemberIds r16 = (ContainMemberIds) r15;
        if (r16 != null) goto L21;
    L23:
        ChatIds.Key r17 = ChatIds.Key;
        Condition.Element r18 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r18 == null) goto L26;
        Condition.Element r19 = r18.get(r17);
    L27:
        ChatIds r20 = (ChatIds) r19;
        if (r20 != null) goto L30;
    L32:
        ManageStatus.Key r21 = ManageStatus.Key.INSTANCE;
        Condition.Element r22 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r22 == null) goto L35;
        Condition.Element r23 = r22.get(r21);
    L36:
        ManageStatus r24 = (ManageStatus) r23;
        if (r24 == null) goto L46;
        int r25 = WhenMappings.$EnumSwitchMapping$0[r24.ordinal()];
        if (r25 == 1) goto L45;
        if (r25 == 2) goto L44;
        if (r25 == 3) goto L43;
        Unit r26 = Unit.INSTANCE;
        goto L46
    L43:
        r3.addable_as_user(Boolean.FALSE);
        goto L46
    L44:
        r3.addable_as_user(Boolean.FALSE);
        goto L46
    L45:
        r3.addable_as_user(Boolean.TRUE);
    L46:
        ShieldStatus.Key r27 = ShieldStatus.Key.INSTANCE;
        Condition.Element r110 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r110 == null) goto L49;
        Condition.Element r28 = r110.get(r27);
    L50:
        ShieldStatus r29 = (ShieldStatus) r28;
        if (r29 != null) goto L53;
    L60:
        FrozenChat.Key r30 = FrozenChat.Key.INSTANCE;
        Condition.Element r111 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r111 == null) goto L63;
        Condition.Element r31 = r111.get(r30);
    L64:
        FrozenChat r32 = (FrozenChat) r31;
        if (r32 != null) goto L67;
    L72:
        ChatMode.Key r33 = ChatMode.Key.INSTANCE;
        Condition.Element r34 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r34 == null) goto L75;
        r14 = r34.get(r33);
    L75:
        ChatMode r35 = (ChatMode) r14;
        if (r35 == null) goto L90;
        ArrayList r36 = new ArrayList();
        int r37 = WhenMappings.$EnumSwitchMapping$1[r35.ordinal()];
        if (r37 == 1) goto L88;
        if (r37 == 2) goto L87;
        if (r37 != 3) goto L82;
        r36.add(Chat.ChatMode.DEFAULT);
        r36.add(Chat.ChatMode.THREAD_V2);
    L89:
        r3.chat_modes(r36);
        goto L90
    L82:
        if (r37 == 4) goto L89;
        throw new NoWhenBranchMatchedException();
    L87:
        r36.add(Chat.ChatMode.THREAD_V2);
        goto L89
    L88:
        r36.add(Chat.ChatMode.DEFAULT);
    L90:
        Boolean r38 = r13.getCloseSearchByUser();
        if (r38 == null) goto L93;
        r3.close_search_by_user(Boolean.valueOf(r38.booleanValue()));
    L93:
        Unit r39 = Unit.INSTANCE;
        BaseEntity.EntityItem.Builder r40 = r1.entity_filter(r2.group_chat_filter(r3.build()).build());
        BaseEntity.EntitySelector.Builder r41 = new BaseEntity.EntitySelector.Builder();
        UniversalSelectors.GroupChatSelector.Builder r42 = new UniversalSelectors.GroupChatSelector.Builder();
        r42.is_in_team_id(r13.isReturnInTeamId());
        r42.relation_tag(Boolean.valueOf(r13.isReturnRelationTag()));
        Boolean r112 = r13.getShowEnterpriseEmail();
        if (r112 == null) goto L97;
        r42.show_enterprise_email(Boolean.valueOf(r112.booleanValue()));
    L97:
        return r40.entity_selector(r41.group_chat_selector(r42.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L67:
        if (r32 != FrozenChat.FROZEN) goto L69;
    L70:
        r7 = true;
    L71:
        r3.need_frozen_chat(Boolean.valueOf(r7));
        goto L72
    L69:
        if (r32 != FrozenChat.ALL) goto L71;
    L63:
        r31 = null;
        goto L64
    L53:
        if (r29 != ShieldStatus.SHIELD) goto L55;
    L58:
        boolean r43 = true;
    L59:
        r3.search_shield(Boolean.valueOf(r43));
        goto L60
    L55:
        if (r29 == ShieldStatus.ALL) goto L58;
        r43 = false;
        goto L59
    L49:
        r28 = null;
        goto L50
    L35:
        r23 = null;
        goto L36
    L30:
        if ((r20 instanceof ChatIds.OUT) == false) goto L32;
        r3.excluded_chat_ids(CollectionsKt.toList(r20.getIds()));
        goto L32
    L26:
        r19 = null;
        goto L27
    L21:
        if ((r16 instanceof ContainMemberIds.NEW) == false) goto L23;
        r3.chat_member_ids(CollectionsKt.toList(r16.getIncludes()));
        goto L23
    L17:
        r15 = null;
        goto L18
    }

    private final BaseEntity.EntityItem buildMailContact(MailContact r2) {
        r2.getFilter();
        r2.getExtra();
        return new BaseEntity.EntityItem.Builder().type(SearchEntityType.MAIL_CONTACT).merge_policy(MERGE_POLICY).build();
    }

    private final BaseEntity.EntityItem buildMailUser(MailUser r3) {
        r3.getFilter();
        MailUserExtra r4 = r3.getExtra();
        return new BaseEntity.EntityItem.Builder().type(SearchEntityType.MAIL_USER).merge_policy(MERGE_POLICY).extras(r4.getExtraMap()).build();
    }

    private final BaseEntity.EntityItem buildShieldP2P(ShieldP2P r4) {
        r4.getFilter();
        ShieldP2PExtra r5 = r4.getExtra();
        BaseEntity.EntityItem.Builder r0 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.SHIELD_P2P_CHAT);
        BaseEntity.EntitySelector.Builder r1 = new BaseEntity.EntitySelector.Builder();
        UniversalSelectors.ShieldP2PChatSelector.Builder r2 = new UniversalSelectors.ShieldP2PChatSelector.Builder();
        r2.relation_tag(Boolean.valueOf(r5.isReturnRelationTag()));
        Unit r6 = Unit.INSTANCE;
        return r0.entity_selector(r1.shield_p2p_chat_selector(r2.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    }

    private final BaseEntity.EntityItem buildThread(Thread r2) {
        r2.getFilter();
        r2.getExtra();
        return new BaseEntity.EntityItem.Builder().type(SearchEntityType.THREAD).merge_policy(getMergePolicy(this.isSpotlight)).build();
    }

    private final List<BaseEntity.EntityItem> buildUserGroup(UserGroup r9) {
        UserGroupFilter r0 = r9.getFilter();
        UserGroupExtra r10 = r9.getExtra();
        ArrayList r1 = new ArrayList();
        if (r10.getScene() == UserGroupScene.NONE) goto L25;
        UserGroupType.Key r2 = UserGroupType.Key.INSTANCE;
        Condition.Element r3 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r3 == null) goto L8;
        Condition.Element r4 = r3.get(r2);
    L9:
        UserGroupType r5 = (UserGroupType) r4;
        if (r5 == null) goto L25;
        int r6 = WhenMappings.$EnumSwitchMapping$4[r5.ordinal()];
        if (r6 != 1) goto L14;
        r1.add(buildUserGroupEntity(com.bytedance.lark.pb.basic.v1.UserGroupType.UserGroupType_ASSIGN, r10.getScene().getValue()));
        goto L25
    L14:
        if (r6 != 2) goto L16;
        r1.add(buildUserGroupEntity(com.bytedance.lark.pb.basic.v1.UserGroupType.UserGroupType_DYNAMIC, r10.getScene().getValue()));
        goto L25
    L16:
        if (r6 != 3) goto L18;
        r1.add(new BaseEntity.EntityItem.Builder().type(SearchEntityType.NEW_USER_GROUP).merge_policy(getMergePolicy(this.isSpotlight)).entity_filter(new BaseEntity.EntityFilter.Builder().new_user_group_filter(new UniversalFilters.NewUserGroupFilter.Builder().user_group_types(CollectionsKt.listOf(new com.bytedance.lark.pb.basic.v1.UserGroupType[]{com.bytedance.lark.pb.basic.v1.UserGroupType.UserGroupType_ASSIGN, com.bytedance.lark.pb.basic.v1.UserGroupType.UserGroupType_DYNAMIC})).namespaces(CollectionsKt.listOf(new UniversalFilters.NewUserGroupFilter.Namespace.Builder().name("admin").visibility_types(CollectionsKt.listOf(UserGroupSceneType.fromValue(r10.getScene().getValue()))).build())).build()).build()).build());
        goto L25
    L18:
        if (r6 == 4) goto L25;
        throw new NoWhenBranchMatchedException();
    L8:
        r4 = null;
    L25:
        return r1;
    }

    private final BaseEntity.EntityItem buildWiki(Wiki r10) {
        WikiFilter r0 = r10.getFilter();
        WikiExtra r11 = r10.getExtra();
        BaseEntity.EntityItem.Builder r1 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.WIKI);
        BaseEntity.EntityFilter.Builder r2 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.WikiFilter.Builder r3 = new UniversalFilters.WikiFilter.Builder();
        CreatorIds.Key r4 = CreatorIds.Key;
        Condition.Element r5 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        WikiSpaces r6 = null;
        if (r5 == null) goto L5;
        Condition.Element r7 = r5.get(r4);
    L6:
        CreatorIds r8 = (CreatorIds) r7;
        if (r8 != null) goto L9;
    L14:
        ChatIds.Key r9 = ChatIds.Key;
        Condition.Element r12 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r12 == null) goto L17;
        Condition.Element r13 = r12.get(r9);
    L18:
        ChatIds r14 = (ChatIds) r13;
        if (r14 != null) goto L21;
    L26:
        DocTypes.Key r15 = DocTypes.Key.INSTANCE;
        Condition.Element r16 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r16 == null) goto L29;
        Condition.Element r17 = r16.get(r15);
    L30:
        DocTypes r18 = (DocTypes) r17;
        if (r18 != null) goto L33;
    L41:
        TimeRange.Key r19 = TimeRange.Key;
        Condition.Element r20 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r20 == null) goto L44;
        Condition.Element r21 = r20.get(r19);
    L45:
        TimeRange r22 = (TimeRange) r21;
        if (r22 == null) goto L48;
        r3.review_time_range(new UniversalFilters.TimeRange.Builder().start_time(Long.valueOf(r22.getStartTime())).end_time(Long.valueOf(r22.getEndTime())).build());
    L48:
        MatchScope.Key r23 = MatchScope.Key.INSTANCE;
        Condition.Element r24 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r24 == null) goto L51;
        Condition.Element r25 = r24.get(r23);
    L52:
        MatchScope r26 = (MatchScope) r25;
        if (r26 == null) goto L64;
        int r27 = WhenMappings.$EnumSwitchMapping$2[r26.ordinal()];
        if (r27 != 1) goto L57;
        r3.search_content_types(CollectionsKt.listOf(UniversalFilters.WikiFilter.SearchContentType.ONLY_TITLE));
        goto L64
    L57:
        if (r27 != 2) goto L59;
        r3.search_content_types(CollectionsKt.listOf(UniversalFilters.WikiFilter.SearchContentType.ONLY_COMMENT));
        goto L64
    L59:
        if (r27 == 3) goto L61;
        Unit r28 = Unit.INSTANCE;
        goto L64
    L61:
        r3.search_content_types(CollectionsKt.listOf(UniversalFilters.WikiFilter.SearchContentType.FULL_CONTENT));
    L64:
        SharerIds.Key r29 = SharerIds.Key;
        Condition.Element r30 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r30 == null) goto L67;
        Condition.Element r31 = r30.get(r29);
    L68:
        SharerIds r32 = (SharerIds) r31;
        if (r32 != null) goto L71;
    L76:
        FromUserIds.Key r33 = FromUserIds.Key;
        Condition.Element r34 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r34 == null) goto L79;
        Condition.Element r35 = r34.get(r33);
    L80:
        FromUserIds r36 = (FromUserIds) r35;
        if (r36 != null) goto L83;
    L88:
        WikiSpaces.Key r37 = WikiSpaces.Key;
        Condition.Element r38 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r38 == null) goto L91;
        Condition.Element r39 = r38.get(r37);
    L92:
        WikiSpaces r40 = (WikiSpaces) r39;
        if (r40 != null) goto L95;
    L99:
        DocSortRuleType r41 = r11.getSortRule();
        if (r41 == null) goto L102;
        r3.sortType(r41);
    L102:
        Boolean r42 = r11.isEnableCrossLanguage();
        if (r42 == null) goto L105;
        r3.cross_language(Boolean.valueOf(r42.booleanValue()));
    L105:
        ExtendedSearch r43 = r11.getExtendedSearch();
        if (r43 != null) goto L108;
    L118:
        Unit r44 = Unit.INSTANCE;
        return r1.entity_filter(r2.wiki_filter(r3.build()).build()).entity_selector(new BaseEntity.EntitySelector.Builder().wiki_selector(new UniversalSelectors.WikiSelector.Builder().need_owner(Boolean.valueOf(r11.isNeedWikiOwner())).relation_tag(Boolean.valueOf(r11.isReturnRelationTag())).build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L108:
        if ((r43 instanceof ExtendedSearch.CLOSE) == false) goto L111;
        r3.use_extended_search_v2(Boolean.TRUE);
        r3.enable_extended_search(Boolean.FALSE);
        goto L118
    L111:
        if ((r43 instanceof ExtendedSearch.OPEN) == false) goto L117;
        if (((ExtendedSearch.OPEN) r43).isUseV2() == false) goto L115;
        Boolean r45 = Boolean.TRUE;
        r3.use_extended_search_v2(r45);
        r3.enable_extended_search(r45);
        goto L118
    L115:
        r3.use_extended_search_v2(Boolean.FALSE);
        goto L118
    L117:
        throw new NoWhenBranchMatchedException();
    L95:
        if ((r40 instanceof WikiSpaces.IN) == false) goto L97;
        r6 = r40;
    L97:
        if (r6 == null) goto L99;
        r3.space_ids(CollectionsKt.toList(r6.getIds()));
        goto L99
    L91:
        r39 = null;
        goto L92
    L83:
        if ((r36 instanceof FromUserIds.IN) == true) goto L86;
        r36 = null;
    L86:
        if (r36 == null) goto L88;
        r3.from_ids(CollectionsKt.toList(r36.getIds()));
        goto L88
    L79:
        r35 = null;
        goto L80
    L71:
        if ((r32 instanceof SharerIds.IN) == true) goto L74;
        r32 = null;
    L74:
        if (r32 == null) goto L76;
        r3.sharer_ids(CollectionsKt.toList(r32.getIds()));
        goto L76
    L67:
        r31 = null;
        goto L68
    L51:
        r25 = null;
        goto L52
    L44:
        r21 = null;
        goto L45
    L33:
        if (Intrinsics.areEqual(r18, DocTypes.ALL.INSTANCE) == false) goto L35;
        List r46 = ArraysKt.toList(com.bytedance.lark.pb.basic.v1.Doc.Type.values());
    L40:
        r3.types(r46);
        goto L41
    L35:
        Set<DocType> r47 = r18.getTypes();
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator<T> r49 = r47.iterator();
    L37:
        if (r49.hasNext() == false) goto L39;
        r48.add(com.bytedance.lark.pb.basic.v1.Doc.Type.values()[((DocType) r49.next()).ordinal()]);
        goto L37
    L39:
        r46 = r48;
        goto L40
    L29:
        r17 = null;
        goto L30
    L21:
        if ((r14 instanceof ChatIds.IN) == true) goto L24;
        r14 = null;
    L24:
        if (r14 == null) goto L26;
        r3.chat_ids(CollectionsKt.toList(r14.getIds()));
        goto L26
    L17:
        r13 = null;
        goto L18
    L9:
        if ((r8 instanceof CreatorIds.IN) == true) goto L12;
        r8 = null;
    L12:
        if (r8 == null) goto L14;
        r3.creator_ids(CollectionsKt.toList(r8.getIds()));
        goto L14
    L5:
        r7 = null;
        goto L6
    }

    private final BaseEntity.EntityItem buildWikiSpace(WikiSpace r7) {
        WikiSpaceFilter r0 = r7.getFilter();
        r7.getExtra();
        BaseEntity.EntityItem.Builder r8 = new BaseEntity.EntityItem.Builder().type(SearchEntityType.WIKI_SPACE);
        BaseEntity.EntityFilter.Builder r1 = new BaseEntity.EntityFilter.Builder();
        UniversalFilters.WikiSpaceFilter.Builder r2 = new UniversalFilters.WikiSpaceFilter.Builder();
        WikiSpaceType.Key r3 = WikiSpaceType.Key.INSTANCE;
        Condition.Element r4 = (Condition.Element) CollectionsKt.firstOrNull(r0.getConditions());
        if (r4 == null) goto L5;
        Condition.Element r5 = r4.get(r3);
    L6:
        WikiSpaceType r6 = (WikiSpaceType) r5;
        if (r6 == null) goto L22;
        int r9 = WhenMappings.$EnumSwitchMapping$3[r6.ordinal()];
        if (r9 != 1) goto L11;
        r2.wiki_space_types(CollectionsKt.listOf(UniversalFilters.WikiSpaceFilter.SpaceType.Team));
        goto L22
    L11:
        if (r9 != 2) goto L13;
        r2.wiki_space_types(CollectionsKt.listOf(UniversalFilters.WikiSpaceFilter.SpaceType.Personal));
        goto L22
    L13:
        if (r9 != 3) goto L15;
        r2.wiki_space_types(CollectionsKt.listOf(new UniversalFilters.WikiSpaceFilter.SpaceType[]{UniversalFilters.WikiSpaceFilter.SpaceType.Team, UniversalFilters.WikiSpaceFilter.SpaceType.Personal}));
        goto L22
    L15:
        if (r9 != 4) goto L18;
        Unit r10 = Unit.INSTANCE;
        goto L22
    L18:
        throw new NoWhenBranchMatchedException();
    L22:
        Unit r11 = Unit.INSTANCE;
        return r8.entity_filter(r1.wiki_space_filter(r2.build()).build()).merge_policy(getMergePolicy(this.isSpotlight)).build();
    L5:
        r5 = null;
        goto L6
    }

    private final BaseEnum.MergePolicy getMergePolicy(boolean r1) {
        if (r1 == false) goto L5;
        return BaseEnum.MergePolicy.LOCAL_ONLY;
    L5:
        return BaseEnum.MergePolicy.COMBINE_LOCAL_AND_SERVER;
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

    public static final /* synthetic */ BaseEntity.EntityItem access$buildAI(Searcher r0, AI r1) {
        return r0.buildAI(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildBot(Searcher r0, Bot r1) {
        return r0.buildBot(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildChatter(Searcher r0, Chatter r1) {
        return r0.buildChatter(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildDepartment(Searcher r0, Department r1) {
        return r0.buildDepartment(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildDoc(Searcher r0, Doc r1) {
        return r0.buildDoc(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildGroup(Searcher r0, Group r1) {
        return r0.buildGroup(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildMailContact(Searcher r0, MailContact r1) {
        return r0.buildMailContact(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildMailUser(Searcher r0, MailUser r1) {
        return r0.buildMailUser(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildShieldP2P(Searcher r0, ShieldP2P r1) {
        return r0.buildShieldP2P(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildThread(Searcher r0, Thread r1) {
        return r0.buildThread(r1);
    }

    public static final /* synthetic */ List access$buildUserGroup(Searcher r0, UserGroup r1) {
        return r0.buildUserGroup(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildWiki(Searcher r0, Wiki r1) {
        return r0.buildWiki(r1);
    }

    public static final /* synthetic */ BaseEntity.EntityItem access$buildWikiSpace(Searcher r0, WikiSpace r1) {
        return r0.buildWikiSpace(r1);
    }

    public static final /* synthetic */ void access$setPageToken$p(Searcher r0, String r1) {
        r0.pageToken = r1;
    }

    private final BaseEntity.SearchExtras buildExtra(Chatter r2, Boolean r3) {
        BaseEntity.SearchExtras.Builder r0 = new BaseEntity.SearchExtras.Builder();
        if (r3 == null) goto L5;
        r0.need_insert_doubao_work(Boolean.valueOf(r3.booleanValue()));
    L5:
        if (r2 == null) goto L12;
        ChatterExtra r4 = r2.getExtra();
        if (r4 == null) goto L12;
        List<ActionType> r5 = r4.isReturnPermissionsResult$picker_release();
        if (r5 == null) goto L12;
        r0.chatter_permissions(new ChatterPermissionsRequest.Builder().actions(r5).build());
    L12:
        return r0.build();
    }

    private final BaseEntity.EntityItem buildUserGroupEntity(com.bytedance.lark.pb.basic.v1.UserGroupType r5, int r6) {
        return new BaseEntity.EntityItem.Builder().type(SearchEntityType.NEW_USER_GROUP).merge_policy(getMergePolicy(this.isSpotlight)).entity_filter(new BaseEntity.EntityFilter.Builder().new_user_group_filter(new UniversalFilters.NewUserGroupFilter.Builder().user_group_types(CollectionsKt.listOf(r5)).namespaces(CollectionsKt.listOf(new UniversalFilters.NewUserGroupFilter.Namespace.Builder().name("admin").visibility_types(CollectionsKt.listOf(UserGroupSceneType.fromValue(r6))).build())).build()).build()).build();
    }

    private final int handleChatterLine(int r5, ChatterCondition<?> r6) {
        if ((r6 instanceof TalkStatus) == false) goto L14;
        int r7 = WhenMappings.$EnumSwitchMapping$5[((TalkStatus) r6).ordinal()];
        if (r7 == 1) goto L11;
        if (r7 == 2) goto L10;
        if (r7 != 3) goto L25;
        r5 = r5 | UniversalFilters.UserFilter.SearchType.TALKED.getValue();
        int r8 = UniversalFilters.UserFilter.SearchType.UN_TALKED.getValue();
    L23:
        return r5 | r8;
    L25:
        return r5;
    L10:
        r8 = UniversalFilters.UserFilter.SearchType.UN_TALKED.getValue();
        goto L23
    L11:
        r8 = UniversalFilters.UserFilter.SearchType.TALKED.getValue();
        goto L23
    L14:
        if ((r6 instanceof JobStatus) == false) goto L24;
        int r9 = WhenMappings.$EnumSwitchMapping$6[((JobStatus) r6).ordinal()];
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L21;
        if (r9 != 3) goto L26;
        r5 = r5 | UniversalFilters.UserFilter.SearchType.UN_RESIGNED.getValue();
        r8 = UniversalFilters.UserFilter.SearchType.RESIGNED.getValue();
        goto L23
    L26:
        return r5;
    L21:
        r8 = UniversalFilters.UserFilter.SearchType.RESIGNED.getValue();
        goto L23
    L22:
        r8 = UniversalFilters.UserFilter.SearchType.UN_RESIGNED.getValue();
        goto L23
    L24:
        return r5;
    }

    private final int handleGroupLine(int r5, GroupCondition<?> r6) {
        if ((r6 instanceof JoinStatus) == false) goto L14;
        int r7 = WhenMappings.$EnumSwitchMapping$7[((JoinStatus) r6).ordinal()];
        if (r7 == 1) goto L11;
        if (r7 == 2) goto L10;
        if (r7 != 3) goto L45;
        r5 = r5 | UniversalFilters.ChatFilter.SearchType.JOINED.getValue();
        int r8 = UniversalFilters.ChatFilter.SearchType.UN_JOINED.getValue();
    L43:
        return r5 | r8;
    L45:
        return r5;
    L10:
        r8 = UniversalFilters.ChatFilter.SearchType.UN_JOINED.getValue();
        goto L43
    L11:
        r8 = UniversalFilters.ChatFilter.SearchType.JOINED.getValue();
        goto L43
    L14:
        if ((r6 instanceof GroupPrivacy) == false) goto L24;
        int r9 = WhenMappings.$EnumSwitchMapping$8[((GroupPrivacy) r6).ordinal()];
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L21;
        if (r9 != 3) goto L46;
        r5 = r5 | UniversalFilters.ChatFilter.SearchType.PRIVATE.getValue();
        r8 = UniversalFilters.ChatFilter.SearchType.PUBLIC.getValue();
        goto L43
    L46:
        return r5;
    L21:
        r8 = UniversalFilters.ChatFilter.SearchType.PUBLIC.getValue();
        goto L43
    L22:
        r8 = UniversalFilters.ChatFilter.SearchType.PRIVATE.getValue();
        goto L43
    L24:
        if ((r6 instanceof Tenant) == false) goto L34;
        int r10 = WhenMappings.$EnumSwitchMapping$9[((Tenant) r6).ordinal()];
        if (r10 == 1) goto L32;
        if (r10 == 2) goto L31;
        if (r10 != 3) goto L47;
        r5 = r5 | UniversalFilters.ChatFilter.SearchType.CROSS_TENANT.getValue();
        r8 = UniversalFilters.ChatFilter.SearchType.UN_CROSS_TENANT.getValue();
        goto L43
    L47:
        return r5;
    L31:
        r8 = UniversalFilters.ChatFilter.SearchType.UN_CROSS_TENANT.getValue();
        goto L43
    L32:
        r8 = UniversalFilters.ChatFilter.SearchType.CROSS_TENANT.getValue();
        goto L43
    L34:
        if ((r6 instanceof CryptoStatus) == false) goto L44;
        int r11 = WhenMappings.$EnumSwitchMapping$10[((CryptoStatus) r6).ordinal()];
        if (r11 == 1) goto L42;
        if (r11 == 2) goto L41;
        if (r11 != 3) goto L48;
        r5 = r5 | UniversalFilters.ChatFilter.SearchType.CRYPTO.getValue();
        r8 = UniversalFilters.ChatFilter.SearchType.NORMAL.getValue();
        goto L43
    L48:
        return r5;
    L41:
        r8 = UniversalFilters.ChatFilter.SearchType.NORMAL.getValue();
        goto L43
    L42:
        r8 = UniversalFilters.ChatFilter.SearchType.CRYPTO.getValue();
        goto L43
    L44:
        return r5;
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

    public final Object loadMore(String r8, Continuation<? super SearchResponse> r9) {
        this.seqId++;
        return searchInternal(r8, this.keyword, this.config, false, r9);
    }

    public /* synthetic */ Searcher(PickerTracker r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    private final UniversalSearchRequest.Builder buildRequest(String r8, SearcherConfig r9, boolean r10) {
        this.isSpotlight = r10;
        UniversalSearchRequest.Builder r0 = new UniversalSearchRequest.Builder();
        SearchCommonRequestHeader.Builder r11 = new SearchCommonRequestHeader.Builder().query(r8).search_session(this.session).session_seq_id(Integer.valueOf(this.seqId)).pagination_token(this.pageToken);
        BaseEntity.SearchContext.Builder r1 = new BaseEntity.SearchContext.Builder();
        Boolean r2 = null;
        final ArrayList r3 = new ArrayList();     // Catch: Throwable -> L162
        if (r9 == null) goto L148;
        Entity<?, ?, ?> r4 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Chatter.class));     // Catch: Throwable -> L162
        if (r4 != null) goto L8;
    L13:
        Chatter r5 = null;
    L14:
        if (r5 == null) goto L16;
        takeIfNotNone(r5, new Searcher$buildRequest$1$1(r3, this));     // Catch: Throwable -> L162
    L16:
        Entity<?, ?, ?> r6 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Group.class));     // Catch: Throwable -> L162
        if (r6 != null) goto L19;
    L24:
        Group r7 = null;
    L25:
        if (r7 == null) goto L27;
        takeIfNotNone(r7, new Searcher$buildRequest$1$2(r3, this));     // Catch: Throwable -> L162
    L27:
        Entity<?, ?, ?> r12 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Doc.class));     // Catch: Throwable -> L162
        if (r12 != null) goto L30;
    L35:
        Doc r13 = null;
    L36:
        if (r13 == null) goto L38;
        takeIfNotNone(r13, new Searcher$buildRequest$1$3(r3, this));     // Catch: Throwable -> L162
    L38:
        Entity<?, ?, ?> r14 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Wiki.class));     // Catch: Throwable -> L162
        if (r14 != null) goto L41;
    L46:
        Wiki r15 = null;
    L47:
        if (r15 == null) goto L49;
        takeIfNotNone(r15, new Searcher$buildRequest$1$4(r3, this));     // Catch: Throwable -> L162
    L49:
        Entity<?, ?, ?> r16 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(WikiSpace.class));     // Catch: Throwable -> L162
        if (r16 != null) goto L52;
    L57:
        WikiSpace r17 = null;
    L58:
        if (r17 == null) goto L60;
        takeIfNotNone(r17, new Searcher$buildRequest$1$5(r3, this));     // Catch: Throwable -> L162
    L60:
        Entity<?, ?, ?> r18 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(UserGroup.class));     // Catch: Throwable -> L162
        if (r18 != null) goto L63;
    L68:
        UserGroup r19 = null;
    L69:
        if (r19 == null) goto L71;
        takeIfNotNone(r19, new Searcher$buildRequest$1$6(r3, this));     // Catch: Throwable -> L162
    L71:
        Entity<?, ?, ?> r20 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(ShieldP2P.class));     // Catch: Throwable -> L162
        if (r20 != null) goto L74;
    L79:
        ShieldP2P r21 = null;
    L80:
        if (r21 == null) goto L82;
        takeIfNotNone(r21, new Searcher$buildRequest$1$7(r3, this));     // Catch: Throwable -> L162
    L82:
        Entity<?, ?, ?> r22 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Department.class));     // Catch: Throwable -> L162
        if (r22 != null) goto L85;
    L90:
        Department r23 = null;
    L91:
        if (r23 == null) goto L93;
        takeIfNotNone(r23, new Searcher$buildRequest$1$8(r3, this));     // Catch: Throwable -> L162
    L93:
        Entity<?, ?, ?> r24 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Bot.class));     // Catch: Throwable -> L162
        if (r24 != null) goto L96;
    L101:
        Bot r25 = null;
    L102:
        if (r25 == null) goto L104;
        takeIfNotNone(r25, new Searcher$buildRequest$1$9(r3, this));     // Catch: Throwable -> L162
    L104:
        Entity<?, ?, ?> r26 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(MailContact.class));     // Catch: Throwable -> L162
        if (r26 != null) goto L107;
    L112:
        MailContact r27 = null;
    L113:
        if (r27 == null) goto L115;
        takeIfNotNone(r27, new Searcher$buildRequest$1$10(r3, this));     // Catch: Throwable -> L162
    L115:
        Entity<?, ?, ?> r28 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(MailUser.class));     // Catch: Throwable -> L162
        if (r28 != null) goto L118;
    L123:
        MailUser r29 = null;
    L124:
        if (r29 == null) goto L126;
        takeIfNotNone(r29, new Searcher$buildRequest$1$11(r3, this));     // Catch: Throwable -> L162
    L126:
        Entity<?, ?, ?> r30 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(AI.class));     // Catch: Throwable -> L162
        if (r30 != null) goto L129;
    L134:
        AI r31 = null;
    L135:
        if (r31 == null) goto L137;
        takeIfNotNone(r31, new Searcher$buildRequest$1$12(r3, this));     // Catch: Throwable -> L162
    L137:
        Entity<?, ?, ?> r32 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Thread.class));     // Catch: Throwable -> L162
        if (r32 != null) goto L140;
    L145:
        Thread r33 = null;
    L146:
        if (r33 == null) goto L148;
        takeIfNotNone(r33, new Searcher$buildRequest$1$13(r3, this));     // Catch: Throwable -> L162
        goto L148
    L140:
        if ((r32 instanceof Thread) == true) goto L143;
        r32 = null;
    L143:
        if (r32 == null) goto L145;
        r33 = (Thread) r32;     // Catch: Throwable -> L162
        goto L146
    L129:
        if ((r30 instanceof AI) == true) goto L132;
        r30 = null;
    L132:
        if (r30 == null) goto L134;
        r31 = (AI) r30;     // Catch: Throwable -> L162
        goto L135
    L118:
        if ((r28 instanceof MailUser) == true) goto L121;
        r28 = null;
    L121:
        if (r28 == null) goto L123;
        r29 = (MailUser) r28;     // Catch: Throwable -> L162
        goto L124
    L107:
        if ((r26 instanceof MailContact) == true) goto L110;
        r26 = null;
    L110:
        if (r26 == null) goto L112;
        r27 = (MailContact) r26;     // Catch: Throwable -> L162
        goto L113
    L96:
        if ((r24 instanceof Bot) == true) goto L99;
        r24 = null;
    L99:
        if (r24 == null) goto L101;
        r25 = (Bot) r24;     // Catch: Throwable -> L162
        goto L102
    L85:
        if ((r22 instanceof Department) == true) goto L88;
        r22 = null;
    L88:
        if (r22 == null) goto L90;
        r23 = (Department) r22;     // Catch: Throwable -> L162
        goto L91
    L74:
        if ((r20 instanceof ShieldP2P) == true) goto L77;
        r20 = null;
    L77:
        if (r20 == null) goto L79;
        r21 = (ShieldP2P) r20;     // Catch: Throwable -> L162
        goto L80
    L63:
        if ((r18 instanceof UserGroup) == true) goto L66;
        r18 = null;
    L66:
        if (r18 == null) goto L68;
        r19 = (UserGroup) r18;     // Catch: Throwable -> L162
        goto L69
    L52:
        if ((r16 instanceof WikiSpace) == true) goto L55;
        r16 = null;
    L55:
        if (r16 == null) goto L57;
        r17 = (WikiSpace) r16;     // Catch: Throwable -> L162
        goto L58
    L41:
        if ((r14 instanceof Wiki) == true) goto L44;
        r14 = null;
    L44:
        if (r14 == null) goto L46;
        r15 = (Wiki) r14;     // Catch: Throwable -> L162
        goto L47
    L30:
        if ((r12 instanceof Doc) == true) goto L33;
        r12 = null;
    L33:
        if (r12 == null) goto L35;
        r13 = (Doc) r12;     // Catch: Throwable -> L162
        goto L36
    L19:
        if ((r6 instanceof Group) == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L24;
        r7 = (Group) r6;     // Catch: Throwable -> L162
        goto L25
    L8:
        if ((r4 instanceof Chatter) == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L13;
        r5 = (Chatter) r4;     // Catch: Throwable -> L162
    L148:
        r1.entity_items(r3);     // Catch: Throwable -> L162
        if (r9 == null) goto L164;
        Entity<?, ?, ?> r34 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Chatter.class));     // Catch: Throwable -> L162
        if (r34 != null) goto L153;
    L158:
        Chatter r35 = null;
    L159:
        if (r35 == null) goto L164;
        r1.common_filter(buildCommonFilter(r35));     // Catch: Throwable -> L162
        goto L164
    L153:
        if ((r34 instanceof Chatter) == true) goto L156;
        r34 = null;
    L156:
        if (r34 == null) goto L158;
        r35 = (Chatter) r34;     // Catch: Throwable -> L162
    L164:
        Unit r36 = Unit.INSTANCE;
        if (r9 == null) goto L179;
        Entity<?, ?, ?> r37 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Doc.class));
        if (r37 != null) goto L169;
    L174:
        Doc r38 = null;
    L175:
        if (r38 == null) goto L179;
        DocExtra r39 = r38.getExtra();
        if (r39 == null) goto L179;
        String r40 = r39.getTagName();
    L180:
        if (r40 != null) goto L186;
        if (r9 == null) goto L185;
        TopExtra r41 = r9.getExtra();
        if (r41 == null) goto L185;
        String r42 = r41.getSpotlightTag();
    L187:
        r1.tag_name(r42);
        if (this.forceServer == true) goto L204;
        boolean r43 = false;
        if (r9 == null) goto L196;
        TopExtra r44 = r9.getExtra();
        if (r44 == null) goto L196;
        if (r44.isForceServer() != true) goto L196;
        r43 = true;
    L196:
        if (r43 == true) goto L204;
        if (r40 != null) goto L204;
        if (r10 == false) goto L202;
        r1.request_source(BaseEntity.SearchContext.RequestSource.SPOTLIGHT_ONLY);
    L205:
        SearchCommonRequestHeader.Builder r45 = r11.search_context(r1.build());
        if (r9 == null) goto L215;
        Entity<?, ?, ?> r46 = r9.getEntities().get(Reflection.getOrCreateKotlinClass(Chatter.class));
        if (r46 == null) goto L215;
        if ((r46 instanceof Chatter) == true) goto L213;
        r46 = null;
    L213:
        if (r46 == null) goto L215;
        Chatter r47 = (Chatter) r46;
    L216:
        if (r9 == null) goto L220;
        TopExtra r48 = r9.getExtra();
        if (r48 == null) goto L220;
        r2 = r48.getNeedInsertDoubaoWork();
    L220:
        if (r47 != null) goto L222;
        if (r2 != null) goto L222;
    L223:
        if (r10 == false) goto L226;
        r45.search_scene(SearchScene.UD);
    L226:
        return r0.header(r45.page_size(20).is_force(Boolean.TRUE).build());
    L222:
        r45.extra_params(buildExtra(r47, r2));
    L215:
        r47 = null;
        goto L216
    L202:
        if (FG.INSTANCE.isCurrentEnable(FG.FEATURE_KEY_ENABLE_SDK_PARAM_OPT) == false) goto L205;
        r1.request_source(BaseEntity.SearchContext.RequestSource.COMBINE_SERVER_AND_HOLD);
    L204:
        r1.request_source(BaseEntity.SearchContext.RequestSource.SERVER_ONLY);
    L185:
        r42 = null;
        goto L187
    L186:
        r42 = r40;
        goto L187
    L169:
        if ((r37 instanceof Doc) == true) goto L172;
        r37 = null;
    L172:
        if (r37 == null) goto L174;
        r38 = (Doc) r37;
    L179:
        r40 = null;
    L162:
        th = move-exception;
        Log.e(TAG, "Config search params error", th);
        goto L164
    }

    public static final /* synthetic */ UniversalSearchRequest.Builder access$buildRequest(Searcher r0, String r1, SearcherConfig r2, boolean r3) {
        return r0.buildRequest(r1, r2, r3);
    }

    private final Object searchInternal(String r10, String r11, SearcherConfig r12, boolean r13, Continuation<? super SearchResponse> r14) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r11, r12, r13, r10, null), r14);
    }

    public static final /* synthetic */ Object access$searchInternal(Searcher r0, String r1, String r2, SearcherConfig r3, boolean r4, Continuation r5) {
        return r0.searchInternal(r1, r2, r3, r4, r5);
    }

    public final Object search(String r7, String r8, SearcherConfig r9, boolean r10, boolean r11, Continuation<? super SearchResponse> r12) {
        this.keyword = r8;
        this.config = r9;
        this.pageToken = null;
        this.seqId = 0;
        this.forceServer = r11;
        return searchInternal(r7, r8, r9, r10, r12);
    }

    public static /* synthetic */ Object search$default(Searcher r9, String r10, String r11, SearcherConfig r12, boolean r13, boolean r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        boolean r6 = false;
    L7:
        if ((r16 & 16) == 0) goto L9;
        boolean r7 = false;
    L11:
        return r9.search(r10, r11, r12, r6, r7, r15);
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }
}
