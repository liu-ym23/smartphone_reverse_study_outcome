package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.view.binder.bridge.DefaultItemViewBridgeFactory;
import com.ss.android.lark.picker.base.view.binder.bridge.IItemViewBridgeFactory;
import com.ss.android.lark.search.dto.info.SearchAiKnowledgeInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchCalendarEventInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import com.ss.android.lark.search.dto.info.SearchCustomInfo;
import com.ss.android.lark.search.dto.info.SearchCustomizationInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchFileInfo;
import com.ss.android.lark.search.dto.info.SearchHelpDeskInfo;
import com.ss.android.lark.search.dto.info.SearchLinkInfo;
import com.ss.android.lark.search.dto.info.SearchLoadingFooterInfo;
import com.ss.android.lark.search.dto.info.SearchMailContactInfo;
import com.ss.android.lark.search.dto.info.SearchMessageInfo;
import com.ss.android.lark.search.dto.info.SearchOpenAppInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import com.ss.android.lark.search.dto.info.SearchReplyInThreadInfo;
import com.ss.android.lark.search.dto.info.SearchSecretP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchThreadInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.search.dto.info.SearchWikiSpaceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import v3c.g;
import v3c.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000Ò\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ±\u00012\u00020\u0001:\u0002±\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001aJ\u0016\u0010!\u001a\u00020\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010#J \u0010\u008c\u0001\u001a\u00020\u001f2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u008d\u0001J\u0012\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00122\u0007\u0010\u008f\u0001\u001a\u00020\u0015J\"\u0010\u0090\u0001\u001a\u00020\u00152\u0007\u0010\u0091\u0001\u001a\u00020U2\u0007\u0010\u0092\u0001\u001a\u00020\u00152\u0007\u0010\u0093\u0001\u001a\u00020\u0015J\u001a\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0091\u0001\u001a\u00020UH\u0002¢\u0006\u0003\u0010\u0095\u0001J\u0012\u0010\u0096\u0001\u001a\u00020\u00152\u0007\u0010\u0097\u0001\u001a\u00020\u0015H\u0002J\u0011\u0010\u0098\u0001\u001a\u00020\u001f2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\u0011\u0010\u009b\u0001\u001a\u00020\u001f2\b\u0010\u009c\u0001\u001a\u00030\u009a\u0001J\u0011\u0010\u009d\u0001\u001a\u00020\u001f2\b\u0010\u009e\u0001\u001a\u00030\u009a\u0001J\u0011\u0010\u009f\u0001\u001a\u00020\u001f2\b\u0010 \u0001\u001a\u00030\u009a\u0001J\u0011\u0010¡\u0001\u001a\u00020\u001f2\b\u0010¡\u0001\u001a\u00030\u009a\u0001J\u0011\u0010¢\u0001\u001a\u00020\u001f2\b\u0010¢\u0001\u001a\u00030\u009a\u0001J\u0011\u0010£\u0001\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0011\u0010¤\u0001\u001a\u00020\u001f2\b\u0010¥\u0001\u001a\u00030\u009a\u0001J\u0011\u0010¦\u0001\u001a\u00020\u001f2\b\u0010§\u0001\u001a\u00030¨\u0001J4\u0010©\u0001\u001a\u00020\u001f2+\u0010ª\u0001\u001a&\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u00120#¢\u0006\u000e\b¬\u0001\u0012\t\b\u00ad\u0001\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u001f0«\u0001J#\u0010®\u0001\u001a\u0003H¯\u0001\"\u000b\b\u0000\u0010¯\u0001\u0018\u0001*\u00020\u0012*\u0003H¯\u0001H\u0082\b¢\u0006\u0003\u0010°\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020A¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010L\u001a\u00020M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010P\u001a\u00020Q¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0016¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010\\\u001a\u00020]¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0011\u0010`\u001a\u00020a¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0011\u0010d\u001a\u00020e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0011\u0010h\u001a\u00020i¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0011\u0010l\u001a\u00020m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0011\u0010p\u001a\u00020q¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0011\u0010t\u001a\u00020u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0011\u0010x\u001a\u00020y¢\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u0010|\u001a\u00020}¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u007fR\u0015\u0010\u0080\u0001\u001a\u00030\u0081\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0015\u0010\u0084\u0001\u001a\u00030\u0085\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0015\u0010\u0088\u0001\u001a\u00030\u0089\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001¨\u0006²\u0001"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/BinderRepo;", "", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "updateHistoryListener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;", "itemViewBridgeFactory", "Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnUpdateHistoryListener;Lcom/ss/android/lark/picker/base/view/binder/bridge/IItemViewBridgeFactory;)V", "getMOnItemClickHandler", "()Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "setMOnItemClickHandler", "(Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "binders", "", "Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", "customBinders", "", "", "Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "customViewTypeResolvers", "Lcom/ss/android/lark/picker/base/view/binder/ICustomViewTypeResolver;", "customBinderForViewType", "Lcom/ss/android/lark/picker/base/view/binder/ICustomBinder;", "itemViewBridgeFactoryInternal", "onBusinessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "setCustomBinderForViewType", "", "customBinder", "setCustomViewTypeResolvers", "resolvers", "", "emailBinder", "Lcom/ss/android/lark/picker/base/view/binder/EmailBinder;", "getEmailBinder", "()Lcom/ss/android/lark/picker/base/view/binder/EmailBinder;", "phoneBinder", "Lcom/ss/android/lark/picker/base/view/binder/PhoneBinder;", "getPhoneBinder", "()Lcom/ss/android/lark/picker/base/view/binder/PhoneBinder;", "chatterBinder", "Lcom/ss/android/lark/picker/base/view/binder/ChatterBinder;", "getChatterBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ChatterBinder;", "userTeamBinder", "Lcom/ss/android/lark/picker/base/view/binder/UserTeamBinder;", "getUserTeamBinder", "()Lcom/ss/android/lark/picker/base/view/binder/UserTeamBinder;", "shieldP2PChatBinder", "Lcom/ss/android/lark/picker/base/view/binder/ShieldP2PChatBinder;", "getShieldP2PChatBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ShieldP2PChatBinder;", "chatBinder", "Lcom/ss/android/lark/picker/base/view/binder/ChatBinder;", "getChatBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ChatBinder;", "messageBinder", "Lcom/ss/android/lark/picker/base/view/binder/MessageBinder;", "getMessageBinder", "()Lcom/ss/android/lark/picker/base/view/binder/MessageBinder;", "departmentBinder", "Lcom/ss/android/lark/picker/base/view/binder/DepartmentBinder;", "getDepartmentBinder", "()Lcom/ss/android/lark/picker/base/view/binder/DepartmentBinder;", "ccmBinder", "Lcom/ss/android/lark/picker/base/view/binder/CCMBinder;", "getCcmBinder", "()Lcom/ss/android/lark/picker/base/view/binder/CCMBinder;", "wikiSpaceBinder", "Lcom/ss/android/lark/picker/base/view/binder/WikiSpaceBinder;", "getWikiSpaceBinder", "()Lcom/ss/android/lark/picker/base/view/binder/WikiSpaceBinder;", "threadBinder", "Lcom/ss/android/lark/picker/base/view/binder/ThreadBinder;", "getThreadBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ThreadBinder;", "calendarEventBinder", "Lcom/ss/android/lark/picker/base/view/binder/CalendarEventBinder;", "getCalendarEventBinder", "()Lcom/ss/android/lark/picker/base/view/binder/CalendarEventBinder;", "commonBinder", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getCommonBinder", "()Lcom/ss/android/lark/picker/base/view/binder/CommonBinder;", "emptyBuilder", "Lcom/ss/android/lark/picker/base/view/binder/EmptyBinder;", "getEmptyBuilder", "()Lcom/ss/android/lark/picker/base/view/binder/EmptyBinder;", "helpDeskBinder", "Lcom/ss/android/lark/picker/base/view/binder/HelpDeskBinder;", "getHelpDeskBinder", "()Lcom/ss/android/lark/picker/base/view/binder/HelpDeskBinder;", "openAppBinder", "Lcom/ss/android/lark/picker/base/view/binder/OpenAppBinder;", "getOpenAppBinder", "()Lcom/ss/android/lark/picker/base/view/binder/OpenAppBinder;", "linkBinder", "Lcom/ss/android/lark/picker/base/view/binder/LinkBinder;", "getLinkBinder", "()Lcom/ss/android/lark/picker/base/view/binder/LinkBinder;", "openSearchBinder", "Lcom/ss/android/lark/picker/base/view/binder/OpenSearchBinder;", "getOpenSearchBinder", "()Lcom/ss/android/lark/picker/base/view/binder/OpenSearchBinder;", "mailContactBinder", "Lcom/ss/android/lark/picker/base/view/binder/MailContactBinder;", "getMailContactBinder", "()Lcom/ss/android/lark/picker/base/view/binder/MailContactBinder;", "replyInThreadBinder", "Lcom/ss/android/lark/picker/base/view/binder/ReplyInThreadBinder;", "getReplyInThreadBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ReplyInThreadBinder;", "userGroupBinder", "Lcom/ss/android/lark/picker/base/view/binder/UserGroupBinder;", "getUserGroupBinder", "()Lcom/ss/android/lark/picker/base/view/binder/UserGroupBinder;", "coldAndHotBinder", "Lcom/ss/android/lark/picker/base/view/binder/ColdAndHotBinder;", "getColdAndHotBinder", "()Lcom/ss/android/lark/picker/base/view/binder/ColdAndHotBinder;", "loadingBinder", "Lcom/ss/android/lark/picker/base/view/binder/LoadingBinder;", "getLoadingBinder", "()Lcom/ss/android/lark/picker/base/view/binder/LoadingBinder;", "aiKnowledgeBinder", "Lcom/ss/android/lark/picker/base/view/binder/AiKnowledgeBinder;", "getAiKnowledgeBinder", "()Lcom/ss/android/lark/picker/base/view/binder/AiKnowledgeBinder;", "personnelTypeBinder", "Lcom/ss/android/lark/picker/base/view/binder/PersonnelTypeBinder;", "getPersonnelTypeBinder", "()Lcom/ss/android/lark/picker/base/view/binder/PersonnelTypeBinder;", "permissionGroupBinder", "Lcom/ss/android/lark/picker/base/view/binder/PermissionGroupBinder;", "getPermissionGroupBinder", "()Lcom/ss/android/lark/picker/base/view/binder/PermissionGroupBinder;", "registerCustomBinders", "", "getBinderForViewType", "viewType", "resolveItemViewType", "item", "position", "defaultViewType", "resolveBuiltInViewType", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;)Ljava/lang/Integer;", "normalizeCustomViewType", "raw", "switchMultiple", "isMultiple", "", "setSingleChoiceMode", "isSingleChoice", "setDisableRightViewHolder", "disableRightViewHolder", "setDisableExtraInfoSummary", "disableExtraInfoSummary", "disableExternalChatter", "disableExternalChat", "setOnBusinessConsumeItem", "switchFoldUnFold", "isFold", "setProfileClickListener", "listener", "Lcom/ss/android/lark/picker/base/view/binder/IOnProfileClickListener;", "custom", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppbrandHostConstants.Schema_Meta.NAME, "addToList", "BINDER", "(Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;)Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class BinderRepo {
    private static final IntRange BUILT_IN_VIEW_TYPE_RANGE = null;
    private static final int CUSTOM_VIEW_TYPE_OFFSET = 1000;
    private static final Companion Companion = null;
    private static final String TAG = "Picker.BinderRepo";
    private final AiKnowledgeBinder aiKnowledgeBinder;
    private final List<IViewBinder> binders;
    private final CalendarEventBinder calendarEventBinder;
    private final CCMBinder ccmBinder;
    private final ChatBinder chatBinder;
    private final ChatterBinder chatterBinder;
    private final ColdAndHotBinder coldAndHotBinder;
    private final CommonBinder<SearchBaseInfo> commonBinder;
    private ICustomBinder customBinderForViewType;
    private final Map<Integer, CommonBinder<?>> customBinders;
    private final List<ICustomViewTypeResolver> customViewTypeResolvers;
    private final DepartmentBinder departmentBinder;
    private final EmailBinder emailBinder;
    private final EmptyBinder emptyBuilder;
    private final HelpDeskBinder helpDeskBinder;
    private final IItemViewBridgeFactory itemViewBridgeFactoryInternal;
    private final LinkBinder linkBinder;
    private final LoadingBinder loadingBinder;
    private g mOnItemClickHandler;
    private final MailContactBinder mailContactBinder;
    private final MessageBinder messageBinder;
    private SearchResultView.IOnBusinessConsumeItem onBusinessConsumeItem;
    private final OpenAppBinder openAppBinder;
    private final OpenSearchBinder openSearchBinder;
    private final PermissionGroupBinder permissionGroupBinder;
    private final PersonnelTypeBinder personnelTypeBinder;
    private final PhoneBinder phoneBinder;
    private final ReplyInThreadBinder replyInThreadBinder;
    private final ShieldP2PChatBinder shieldP2PChatBinder;
    private final ThreadBinder threadBinder;
    private final UserGroupBinder userGroupBinder;
    private final UserTeamBinder userTeamBinder;
    private final WikiSpaceBinder wikiSpaceBinder;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/BinderRepo$Companion;", "", "<init>", "()V", "TAG", "", "CUSTOM_VIEW_TYPE_OFFSET", "", "BUILT_IN_VIEW_TYPE_RANGE", "Lkotlin/ranges/IntRange;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public BinderRepo(Context r9, g r10) {
        Intrinsics.checkNotNullParameter(r9, "mContext");
        Intrinsics.checkNotNullParameter(r10, "mOnItemClickHandler");
        this(r9, r10, null, null, 12, null);
    }

    public BinderRepo(Context r9, g r10, i r11) {
        Intrinsics.checkNotNullParameter(r9, "mContext");
        Intrinsics.checkNotNullParameter(r10, "mOnItemClickHandler");
        this(r9, r10, r11, null, 8, null);
    }

    static {
        Companion = new Companion(null);
        BUILT_IN_VIEW_TYPE_RANGE = new IntRange(0, 48);
    }

    public final AiKnowledgeBinder getAiKnowledgeBinder() {
        return this.aiKnowledgeBinder;
    }

    public final CalendarEventBinder getCalendarEventBinder() {
        return this.calendarEventBinder;
    }

    public final CCMBinder getCcmBinder() {
        return this.ccmBinder;
    }

    public final ChatBinder getChatBinder() {
        return this.chatBinder;
    }

    public final ChatterBinder getChatterBinder() {
        return this.chatterBinder;
    }

    public final ColdAndHotBinder getColdAndHotBinder() {
        return this.coldAndHotBinder;
    }

    public final CommonBinder<SearchBaseInfo> getCommonBinder() {
        return this.commonBinder;
    }

    public final DepartmentBinder getDepartmentBinder() {
        return this.departmentBinder;
    }

    public final EmailBinder getEmailBinder() {
        return this.emailBinder;
    }

    public final EmptyBinder getEmptyBuilder() {
        return this.emptyBuilder;
    }

    public final HelpDeskBinder getHelpDeskBinder() {
        return this.helpDeskBinder;
    }

    public final LinkBinder getLinkBinder() {
        return this.linkBinder;
    }

    public final LoadingBinder getLoadingBinder() {
        return this.loadingBinder;
    }

    public final g getMOnItemClickHandler() {
        return this.mOnItemClickHandler;
    }

    public final MailContactBinder getMailContactBinder() {
        return this.mailContactBinder;
    }

    public final MessageBinder getMessageBinder() {
        return this.messageBinder;
    }

    public final OpenAppBinder getOpenAppBinder() {
        return this.openAppBinder;
    }

    public final OpenSearchBinder getOpenSearchBinder() {
        return this.openSearchBinder;
    }

    public final PermissionGroupBinder getPermissionGroupBinder() {
        return this.permissionGroupBinder;
    }

    public final PersonnelTypeBinder getPersonnelTypeBinder() {
        return this.personnelTypeBinder;
    }

    public final PhoneBinder getPhoneBinder() {
        return this.phoneBinder;
    }

    public final ReplyInThreadBinder getReplyInThreadBinder() {
        return this.replyInThreadBinder;
    }

    public final ShieldP2PChatBinder getShieldP2PChatBinder() {
        return this.shieldP2PChatBinder;
    }

    public final ThreadBinder getThreadBinder() {
        return this.threadBinder;
    }

    public final UserGroupBinder getUserGroupBinder() {
        return this.userGroupBinder;
    }

    public final UserTeamBinder getUserTeamBinder() {
        return this.userTeamBinder;
    }

    public final WikiSpaceBinder getWikiSpaceBinder() {
        return this.wikiSpaceBinder;
    }

    private final /* synthetic */ <BINDER extends IViewBinder> BINDER addToList(BINDER r2) {
        this.binders.add(r2);
        return r2;
    }

    private final int normalizeCustomViewType(int r4) {
        if (r4 < 0) goto L15;
        IntRange r0 = BUILT_IN_VIEW_TYPE_RANGE;
        int r1 = r0.getFirst();
        boolean r2 = false;
        if (r4 > r0.getLast()) goto L8;
        if (r1 > r4) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L11;
        return r4;
    L11:
        if (r4 < CUSTOM_VIEW_TYPE_OFFSET) goto L14;
        return r4;
    L14:
        return r4 + CUSTOM_VIEW_TYPE_OFFSET;
    L15:
        return r4;
    }

    private final Integer resolveBuiltInViewType(SearchBaseInfo r3) {
        if ((r3 instanceof SearchShieldP2PChatInfo) == false) goto L6;
        return 34;
    L6:
        if ((r3 instanceof SearchChatterInfo) == true) goto L72;
        if ((r3 instanceof SearchSecretP2PChatInfo) == true) goto L72;
        if ((r3 instanceof SearchChatInfo) == false) goto L14;
        return 1;
    L14:
        if ((r3 instanceof SearchMessageInfo) == true) goto L91;
        if ((r3 instanceof SearchFileInfo) == true) goto L91;
        if ((r3 instanceof SearchSpaceInfo) == true) goto L90;
        if ((r3 instanceof SearchWikiInfo) == true) goto L90;
        if ((r3 instanceof SearchThreadInfo) == false) goto L27;
        return 7;
    L27:
        if ((r3 instanceof SearchReplyInThreadInfo) == false) goto L30;
        return 33;
    L30:
        if ((r3 instanceof SearchCalendarEventInfo) == false) goto L33;
        return 8;
    L33:
        if ((r3 instanceof SearchHelpDeskInfo) == false) goto L36;
        return 9;
    L36:
        if ((r3 instanceof SearchOpenAppInfo) == false) goto L39;
        return 10;
    L39:
        if ((r3 instanceof SearchOpenSearchInfo) == false) goto L42;
        return 15;
    L42:
        if ((r3 instanceof SearchDepartmentInfo) == false) goto L45;
        return 2;
    L45:
        if ((r3 instanceof SearchLinkInfo) == false) goto L48;
        return 13;
    L48:
        if ((r3 instanceof SearchMailContactInfo) == false) goto L51;
        return 29;
    L51:
        if ((r3 instanceof SearchWikiSpaceInfo) == false) goto L54;
        return 35;
    L54:
        if ((r3 instanceof SearchColdAndHotInfo) == false) goto L57;
        return 36;
    L57:
        if ((r3 instanceof SearchUserGroupInfo) == false) goto L60;
        return 40;
    L60:
        if ((r3 instanceof SearchLoadingFooterInfo) == false) goto L63;
        return 44;
    L63:
        if ((r3 instanceof SearchAiKnowledgeInfo) == false) goto L66;
        return 45;
    L66:
        if ((r3 instanceof SearchCustomInfo) == true) goto L89;
        boolean r4 = r3 instanceof SearchCustomizationInfo;
    L89:
        return null;
    L90:
        return 6;
    L91:
        return 5;
    L72:
        return 0;
    }

    public final void custom(Function1<? super List<? extends IViewBinder>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        r2.invoke(this.binders);
    }

    public final void disableExternalChat(boolean r2) {
        this.chatBinder.disableExternalChat(r2);
    }

    public final void disableExternalChatter(boolean r2) {
        this.chatterBinder.disableExternalChatter(r2);
    }

    public final IViewBinder getBinderForViewType(int r2) {
        CommonBinder<?> r3 = this.customBinders.get(Integer.valueOf(r2));
        if (r3 == null) goto L5;
        return r3;
    L5:
        return null;
    }

    public final void registerCustomBinders(Map<Integer, ? extends CommonBinder<?>> r7) {
        Intrinsics.checkNotNullParameter(r7, "customBinders");
        Iterator<Map.Entry<Integer, ? extends CommonBinder<?>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L22;
        Map.Entry<Integer, ? extends CommonBinder<?>> r0 = r8.next();
        int r1 = r0.getKey().intValue();
        CommonBinder<?> r2 = r0.getValue();
        int r3 = normalizeCustomViewType(r1);
        IntRange r4 = BUILT_IN_VIEW_TYPE_RANGE;
        int r5 = r4.getFirst();
        boolean r6 = false;
        if (r3 > r4.getLast()) goto L10;
        if (r5 > r3) goto L10;
        r6 = true;
    L10:
        if (r6 == false) goto L12;
        Log.w(TAG, "registerCustomBinders: overriding built-in viewType=" + r3 + " (raw=" + r1 + ')');
    L14:
        CommonBinder<?> r9 = this.customBinders.put(Integer.valueOf(r3), r2);
        if (r9 == null) goto L19;
        if (r9 == r2) goto L19;
        Log.w(TAG, "registerCustomBinders: viewType=" + r3 + " is overwritten. prev=" + r9.getClass().getName() + ", new=" + r2.getClass().getName());
    L19:
        if (this.binders.contains(r2) == true) goto L21;
        this.binders.add(r2);
    L21:
        r2.setAdapterClickHandler(this.mOnItemClickHandler);
        r2.setOnBusinessConsumeItem(this.onBusinessConsumeItem);
        goto L4
    L12:
        if (r3 == r1) goto L14;
        Log.w(TAG, "registerCustomBinders: normalize viewType raw=" + r1 + " -> normalized=" + r3);
        goto L14
    }

    public final void setCustomBinderForViewType(ICustomBinder r1) {
        this.customBinderForViewType = r1;
    }

    public final void setCustomViewTypeResolvers(List<? extends ICustomViewTypeResolver> r2) {
        this.customViewTypeResolvers.clear();
        List<? extends ICustomViewTypeResolver> r3 = r2;
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        this.customViewTypeResolvers.addAll(r3);
        return;
    L12:
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    public final void setDisableExtraInfoSummary(boolean r4) {
        Iterator<T> r0 = this.binders.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IViewBinder r1 = (IViewBinder) r0.next();
        if ((r1 instanceof CommonBinder) == false) goto L4;
        ((CommonBinder) r1).setDisableExtraInfoSummary(r4);
        goto L4
    }

    public final void setDisableRightViewHolder(boolean r2) {
        this.chatterBinder.setDisableRightViewHolder(r2);
        this.userTeamBinder.setDisableRightViewHolder(r2);
    }

    public final void setMOnItemClickHandler(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mOnItemClickHandler = r2;
    }

    public final void setOnBusinessConsumeItem(SearchResultView.IOnBusinessConsumeItem r3) {
        this.chatterBinder.setOnBusinessConsumeItem(r3);
        this.chatBinder.setOnBusinessConsumeItem(r3);
        this.shieldP2PChatBinder.setOnBusinessConsumeItem(r3);
        this.messageBinder.setOnBusinessConsumeItem(r3);
        this.departmentBinder.setOnBusinessConsumeItem(r3);
        this.ccmBinder.setOnBusinessConsumeItem(r3);
        this.threadBinder.setOnBusinessConsumeItem(r3);
        this.calendarEventBinder.setOnBusinessConsumeItem(r3);
        this.commonBinder.setOnBusinessConsumeItem(r3);
        this.helpDeskBinder.setOnBusinessConsumeItem(r3);
        this.openAppBinder.setOnBusinessConsumeItem(r3);
        this.mailContactBinder.setOnBusinessConsumeItem(r3);
        this.replyInThreadBinder.setOnBusinessConsumeItem(r3);
        this.wikiSpaceBinder.setOnBusinessConsumeItem(r3);
        this.userGroupBinder.setOnBusinessConsumeItem(r3);
        this.personnelTypeBinder.setOnBusinessConsumeItem(r3);
        this.permissionGroupBinder.setOnBusinessConsumeItem(r3);
        this.onBusinessConsumeItem = r3;
        Iterator<T> r0 = this.customBinders.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((CommonBinder) r0.next()).setOnBusinessConsumeItem(r3);
        goto L4
    }

    public final void setProfileClickListener(IOnProfileClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.chatterBinder.setOnProfileClickListener(r2);
        this.shieldP2PChatBinder.setOnProfileClickListener(r2);
    }

    public final void setSingleChoiceMode(boolean r3) {
        this.chatterBinder.setSingleChoiceMode(r3);
        this.userTeamBinder.setSingleChoiceMode(r3);
        this.chatBinder.setSingleChoiceMode(r3);
        this.shieldP2PChatBinder.setSingleChoiceMode(r3);
        this.messageBinder.setSingleChoiceMode(r3);
        this.departmentBinder.setSingleChoiceMode(r3);
        this.ccmBinder.setSingleChoiceMode(r3);
        this.threadBinder.setSingleChoiceMode(r3);
        this.calendarEventBinder.setSingleChoiceMode(r3);
        this.commonBinder.setSingleChoiceMode(r3);
        this.helpDeskBinder.setSingleChoiceMode(r3);
        this.openAppBinder.setSingleChoiceMode(r3);
        this.mailContactBinder.setSingleChoiceMode(r3);
        this.replyInThreadBinder.setSingleChoiceMode(r3);
        this.wikiSpaceBinder.setSingleChoiceMode(r3);
        this.openSearchBinder.setSingleChoiceMode(r3);
        this.userGroupBinder.setSingleChoiceMode(r3);
        this.aiKnowledgeBinder.switchMultiple(r3);
        Iterator<T> r0 = this.customBinders.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((CommonBinder) r0.next()).setSingleChoiceMode(r3);
        goto L4
    }

    public final void switchFoldUnFold(boolean r4) {
        Iterator<T> r0 = this.binders.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        IViewBinder r1 = (IViewBinder) r0.next();
        if ((r1 instanceof CommonBinder) == false) goto L4;
        ((CommonBinder) r1).setFold(r4);
        goto L4
    }

    public final void switchMultiple(boolean r3) {
        this.emailBinder.switchMultiple(r3);
        this.phoneBinder.switchMultiple(r3);
        this.chatterBinder.switchMultiple(r3);
        this.userTeamBinder.switchMultiple(r3);
        this.chatBinder.switchMultiple(r3);
        this.shieldP2PChatBinder.switchMultiple(r3);
        this.messageBinder.switchMultiple(r3);
        this.departmentBinder.switchMultiple(r3);
        this.ccmBinder.switchMultiple(r3);
        this.threadBinder.switchMultiple(r3);
        this.calendarEventBinder.switchMultiple(r3);
        this.commonBinder.switchMultiple(r3);
        this.helpDeskBinder.switchMultiple(r3);
        this.openAppBinder.switchMultiple(r3);
        this.mailContactBinder.switchMultiple(r3);
        this.replyInThreadBinder.switchMultiple(r3);
        this.wikiSpaceBinder.switchMultiple(r3);
        this.openSearchBinder.switchMultiple(r3);
        this.userGroupBinder.switchMultiple(r3);
        this.aiKnowledgeBinder.switchMultiple(r3);
        Iterator<T> r0 = this.customBinders.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((CommonBinder) r0.next()).switchMultiple(r3);
        goto L4
    }

    public final int resolveItemViewType(SearchBaseInfo r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (Intrinsics.areEqual(r3.getClass(), SearchBaseInfo.class) == false) goto L5;
        return r5;
    L5:
        Iterator<T> r0 = this.customViewTypeResolvers.iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        Integer r1 = ((ICustomViewTypeResolver) r0.next()).getItemViewType(r3, r4);
        if (r1 == null) goto L7;
        return normalizeCustomViewType(r1.intValue());
    L12:
        Integer r6 = resolveBuiltInViewType(r3);
        if (r6 != null) goto L15;
        ICustomBinder r7 = this.customBinderForViewType;
        if (r7 != null) goto L19;
        return r5;
    L19:
        return normalizeCustomViewType(r7.getItemViewType(r4));
    L15:
        return r6.intValue();
    }

    public BinderRepo(Context r3, g r4, i r5, IItemViewBridgeFactory r6) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "mOnItemClickHandler");
        Intrinsics.checkNotNullParameter(r6, "itemViewBridgeFactory");
        this.mOnItemClickHandler = r4;
        ArrayList r7 = new ArrayList();
        this.binders = r7;
        this.customBinders = new LinkedHashMap();
        this.customViewTypeResolvers = new ArrayList();
        this.itemViewBridgeFactoryInternal = r6;
        EmailBinder r0 = new EmailBinder(r3, this.mOnItemClickHandler);
        r7.add(r0);
        this.emailBinder = r0;
        PhoneBinder r1 = new PhoneBinder(r3, this.mOnItemClickHandler);
        r7.add(r1);
        this.phoneBinder = r1;
        ChatterBinder r2 = new ChatterBinder(r3, this.mOnItemClickHandler, r5);
        r7.add(r2);
        this.chatterBinder = r2;
        UserTeamBinder r8 = new UserTeamBinder(r3, this.mOnItemClickHandler);
        r7.add(r8);
        this.userTeamBinder = r8;
        ShieldP2PChatBinder r9 = new ShieldP2PChatBinder(r3, this.mOnItemClickHandler, r5);
        r7.add(r9);
        this.shieldP2PChatBinder = r9;
        ChatBinder r10 = new ChatBinder(r3, this.mOnItemClickHandler);
        r7.add(r10);
        this.chatBinder = r10;
        MessageBinder r11 = new MessageBinder(r3, this.mOnItemClickHandler);
        r7.add(r11);
        this.messageBinder = r11;
        DepartmentBinder r12 = new DepartmentBinder(r3, this.mOnItemClickHandler);
        r7.add(r12);
        this.departmentBinder = r12;
        CCMBinder r13 = new CCMBinder(r3, this.mOnItemClickHandler);
        r7.add(r13);
        this.ccmBinder = r13;
        WikiSpaceBinder r14 = new WikiSpaceBinder(r3, this.mOnItemClickHandler);
        r7.add(r14);
        this.wikiSpaceBinder = r14;
        ThreadBinder r15 = new ThreadBinder(r3, this.mOnItemClickHandler);
        r7.add(r15);
        this.threadBinder = r15;
        CalendarEventBinder r16 = new CalendarEventBinder(r3, this.mOnItemClickHandler);
        r7.add(r16);
        this.calendarEventBinder = r16;
        CommonBinder<SearchBaseInfo> r17 = new CommonBinder(r3, this.mOnItemClickHandler, r6);
        r7.add(r17);
        this.commonBinder = r17;
        EmptyBinder r18 = new EmptyBinder();
        r7.add(r18);
        this.emptyBuilder = r18;
        HelpDeskBinder r19 = new HelpDeskBinder(r3, this.mOnItemClickHandler);
        r7.add(r19);
        this.helpDeskBinder = r19;
        OpenAppBinder r20 = new OpenAppBinder(r3, this.mOnItemClickHandler);
        r7.add(r20);
        this.openAppBinder = r20;
        LinkBinder r21 = new LinkBinder(r3, this.mOnItemClickHandler);
        r7.add(r21);
        this.linkBinder = r21;
        OpenSearchBinder r22 = new OpenSearchBinder(r3, this.mOnItemClickHandler);
        r7.add(r22);
        this.openSearchBinder = r22;
        MailContactBinder r23 = new MailContactBinder(r3, this.mOnItemClickHandler);
        r7.add(r23);
        this.mailContactBinder = r23;
        ReplyInThreadBinder r24 = new ReplyInThreadBinder(r3, this.mOnItemClickHandler);
        r7.add(r24);
        this.replyInThreadBinder = r24;
        UserGroupBinder r25 = new UserGroupBinder(r3, this.mOnItemClickHandler);
        r7.add(r25);
        this.userGroupBinder = r25;
        ColdAndHotBinder r26 = new ColdAndHotBinder(r3, this.mOnItemClickHandler);
        r7.add(r26);
        this.coldAndHotBinder = r26;
        LoadingBinder r27 = new LoadingBinder(r3);
        r7.add(r27);
        this.loadingBinder = r27;
        AiKnowledgeBinder r28 = new AiKnowledgeBinder(r3, this.mOnItemClickHandler);
        r7.add(r28);
        this.aiKnowledgeBinder = r28;
        PersonnelTypeBinder r29 = new PersonnelTypeBinder(r3, this.mOnItemClickHandler);
        r7.add(r29);
        this.personnelTypeBinder = r29;
        PermissionGroupBinder r30 = new PermissionGroupBinder(r3, this.mOnItemClickHandler);
        r7.add(r30);
        this.permissionGroupBinder = r30;
    }

    public /* synthetic */ BinderRepo(Context r1, g r2, i r3, IItemViewBridgeFactory r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = new DefaultItemViewBridgeFactory();
    L8:
        this(r1, r2, r3, r4);
    }
}
