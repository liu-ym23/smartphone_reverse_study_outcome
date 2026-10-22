package com.ss.android.lark.picker.base.utils;

import android.content.Context;
import c7c.b;
import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterCustomStatus;
import com.ss.android.lark.chat.entity.chatter.TimeZone;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import com.ss.android.lark.search.dto.info.SearchFeedbackInfo;
import com.ss.android.lark.search.dto.info.SearchMoreInfo;
import com.ss.android.lark.search.dto.info.SearchPlaceholderInfo;
import com.ss.android.lark.search.dto.info.SearchUserGroupInfo;
import com.ss.android.lark.search.dto.info.a;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0007J+\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010'\u001a\u00020!H\u0007J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020!H\u0007J\u000e\u0010*\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/picker/base/utils/SearchCommonUtils;", "", "<init>", "()V", "TAG", "", "generateStackTraceString", "getSearchResultTime", "context", "Landroid/content/Context;", "timeSec", "", "is24HourTime", "", "parseFromChatterEntity", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "deniedReasons", "", "Lcom/bytedance/lark/pb/basic/v1/DeniedReason;", "mail", "parseFromChatEntity", "Lcom/ss/android/lark/search/dto/info/SearchChatInfo;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "parseFromDepartmentId", "Lcom/ss/android/lark/search/dto/info/SearchDepartmentInfo;", "departmentId", "parseFromDepartment", "id", AppbrandHostConstants.Schema_Meta.NAME, "numberCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/search/dto/info/SearchDepartmentInfo;", "getSearchResultTimeForLong", "parseFromUserGroupInfo", "Lcom/ss/android/lark/search/dto/info/SearchUserGroupInfo;", "userGroupId", "groupType", "getCountString", "count", "isDarkMode", "isUIData", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchCommonUtils {
    public static final SearchCommonUtils INSTANCE = null;
    private static final String TAG = "LarkSearch.Common.SearchCommonUtils";

    static {
        INSTANCE = new SearchCommonUtils();
    }

    private SearchCommonUtils() {
    }

    @JvmStatic
    public static final SearchChatterInfo parseFromChatterEntity(Chatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
        return parseFromChatterEntity$default(r2, null, null, 6, null);
    }

    @JvmStatic
    public static final SearchChatterInfo parseFromChatterEntity(Chatter r2, List<? extends DeniedReason> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
        return parseFromChatterEntity$default(r2, r3, null, 4, null);
    }

    @JvmStatic
    public static final String generateStackTraceString() {
        StackTraceElement[] r0 = ThreadMethodProxy.currentThread().getStackTrace();
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = ArrayIteratorKt.iterator(r0);
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.append(((StackTraceElement) r2.next()).toString());
        r1.append("\n");
        goto L4
    L7:
        return r1.toString();
    }

    @JvmStatic
    public static final String getCountString(int r2) {
        return "(" + r2 + ')';
    }

    @JvmStatic
    public static final SearchChatInfo parseFromChatEntity(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        SearchChatInfo r0 = new SearchChatInfo();
        r0.setId(r2.getId());
        r0.setType(2);
        r0.setAvatarKey(r2.getAvatarKey());
        r0.setTitle(r2.getName());
        r0.setSubTitle("");
        r0.setChatType(r2.getType());
        r0.setChatMode(r2.getChatMode());
        r0.setCrossTenant(r2.isCrossTenant());
        r0.setDelayed(r2.isDeleted());
        r0.setDepartment(r2.is_department());
        r0.setMemberCount(r2.getMemberCount());
        r0.setUserCount(r2.getUserCount());
        r0.setRemind(r2.isRemind());
        r0.setSecretChat(r2.isSecret());
        r0.setPublic(r2.isPublic());
        r0.setOfficialOnCall(r2.isOfficialOncall());
        r0.setLastMessagePosition(r2.getLastMessagePosition());
        r0.setMeeting(r2.isMeeting());
        r0.setTagData(r2.getTagData());
        r0.setShield(false);
        return r0;
    }

    @JvmStatic
    public static final SearchDepartmentInfo parseFromDepartmentId(String r1) {
        SearchDepartmentInfo r0 = new SearchDepartmentInfo();
        r0.setId(r1);
        r0.setType(17);
        return r0;
    }

    public final boolean isDarkMode(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((r2.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUIData(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if ((r2 instanceof SearchPlaceholderInfo) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r2 instanceof SearchMoreInfo) == true) goto L12;
        if ((r2 instanceof SearchFeedbackInfo) == true) goto L12;
        if ((r2 instanceof a) == true) goto L12;
        return false;
    }

    @JvmStatic
    public static final String getSearchResultTime(Context r12, long r13, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        c7c.a r0 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r0.b(DisplayPattern.RELATIVE);
        r0.c(LengthType.SHORT);
        r0.h = !r15;
        r0.d(TimePreciseness.MINUTE);
        return b.c(r12, new Date(((long) 1000) * r13), r0);
    }

    @JvmStatic
    public static final String getSearchResultTimeForLong(Context r12, long r13, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        c7c.a r0 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r0.b(DisplayPattern.RELATIVE);
        r0.c(LengthType.LONG);
        r0.h = !r15;
        r0.d(TimePreciseness.MINUTE);
        return b.c(r12, new Date(((long) 1000) * r13), r0);
    }

    @JvmStatic
    public static final SearchChatterInfo parseFromChatterEntity(Chatter r4, List<? extends DeniedReason> r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "chatter");
        Intrinsics.checkNotNullParameter(r6, "mail");
        SearchChatterInfo r0 = new SearchChatterInfo();
        r0.setId(r4.getId());
        boolean r1 = true;
        r0.setType(1);
        r0.setAvatarKey(r4.getAvatarKey());
        r0.setTitle(PickerBaseModuleDependency.getDependency().getNameWithAnotherName(r4));
        r0.setSubTitle("");
        r0.setChatterType(r4.getType());
        ChatterCustomStatus.a r2 = ChatterCustomStatus.Companion;
        List r3 = r4.getCustomStatus();
        r2.getClass();
        r0.setStatusList(ChatterCustomStatus.a.c(r3));
        r0.setChatterDescription(r4.getDescription());
        r0.setRegistered(r4.getRegistered());
        r0.setInContacts(r4.isInContacts());
        r0.setCanJoinGroup(r4.isCanJoinGroup());
        r0.setTenantId(r4.getTenantId());
        r0.setWorkStatus(r4.getWorkStatus());
        r0.setZenModeEndTime(r4.getZenModeEndTime());
        TimeZone r7 = r4.getTimeZone();
        if (r7 == null) goto L5;
        r7.setTimeZoneId(r7.getTimeZoneId());
    L5:
        String r8 = PickerBaseModuleDependency.getDependency().getLoginUserTenantId();
        r0.setCrossTenant(!Intrinsics.areEqual(r8, r4.getTenantId()));
        r0.customer(Intrinsics.areEqual(UserInfo.NONE_NAME_CARD_ID, r8));
        r0.setTagData(r4.getTagData());
        String r9 = r4.getLocalizedName();
        if (r9 != null) goto L8;
    L11:
        if (r1 == false) goto L13;
        r9 = r4.getName();
    L13:
        r0.setName(r9);
        r0.setDeniedReasons(r5);
        r0.setMailAddress(r6);
        r0.setEnterpriseMailAddress(r6);
        r0.setBotExtType(r4.getBotExtraType());
        r0.setAgent(r4.isAgent());
        return r0;
    L8:
        if (r9.length() == 0) goto L11;
        r1 = false;
        goto L11
    }

    @JvmStatic
    public static final SearchDepartmentInfo parseFromDepartment(String r2, String r3, Integer r4) {
        SearchDepartmentInfo r0 = new SearchDepartmentInfo();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setId(r2);
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.setTitle(r3);
        if (r4 == null) goto L11;
        int r5 = r4.intValue();
    L12:
        r0.setMemberCount(r5);
        r0.setType(17);
        return r0;
    L11:
        r5 = 0;
        goto L12
    }

    @JvmStatic
    public static final SearchUserGroupInfo parseFromUserGroupInfo(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "userGroupId");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.Schema_Meta.NAME);
        SearchUserGroupInfo r0 = new SearchUserGroupInfo(r3, "", r4);
        r0.setId(r2);
        r0.setType(100000028);
        return r0;
    }

    public static /* synthetic */ SearchChatterInfo parseFromChatterEntity$default(Chatter r0, List r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 4) == 0) goto L9;
        r2 = "";
    L9:
        return parseFromChatterEntity(r0, r1, r2);
    }
}
