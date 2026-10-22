package com.ss.android.lark.picker.base.utils;

import b4c.a;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils;", "", "<init>", "()V", "mFgService", "Lcom/ss/android/lark/search/dto/userscope/IASLFeatureGatingService;", "getMFgService", "()Lcom/ss/android/lark/search/dto/userscope/IASLFeatureGatingService;", "setMFgService", "(Lcom/ss/android/lark/search/dto/userscope/IASLFeatureGatingService;)V", "isEnable", "", "key", "", "isOrganizationNameTagFGEnable", "isUrlIconMoreTypesEnable", "isSpotlightLocalTagEnable", "isExtraInfoEnable", "enableSearchDepartment", "enableFirstMinSize", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SearchCommonFgUtils {
    public static final Companion Companion = null;
    public static final String EXTRA_INFO_UPDATE = "lark.search.mobile.extro_info.update";
    private static final String FEATURE_AVATAR_REFACTOR = "asl.search.result_item_refactor";
    private static final String FIRST_MIN_SIZE = "core.picker.first_view_min_size";
    private static final String MESSAGE_FILTER_TYPE_LINK_CARD = "search.message_filter.message_type.link_card";
    private static final String ORGANIZATION_TAG = "arch.user.organizationnametag";
    private static final String SEARCH_DEPARTMENT = "core.forward.search_department";
    private static final String SPOTLIGHT_LOCAL_TAG = "lark.search.mobile.spotlight.local_tag";
    private static final String TAG = "SearchCommonFgUtils";
    private static final String URL_ICON_MORE_TYPES = "lark.search.url_icon.support_more_types";
    private a mFgService;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/SearchCommonFgUtils$Companion;", "", "<init>", "()V", "TAG", "", "ORGANIZATION_TAG", "URL_ICON_MORE_TYPES", "SPOTLIGHT_LOCAL_TAG", "MESSAGE_FILTER_TYPE_LINK_CARD", "FEATURE_AVATAR_REFACTOR", "EXTRA_INFO_UPDATE", "SEARCH_DEPARTMENT", "FIRST_MIN_SIZE", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final boolean enableFirstMinSize() {
        this.mFgService.isEnable(FIRST_MIN_SIZE);
        return true;
    }

    public final boolean enableSearchDepartment() {
        this.mFgService.isEnable(SEARCH_DEPARTMENT);
        return false;
    }

    public final boolean isExtraInfoEnable() {
        this.mFgService.isEnable(EXTRA_INFO_UPDATE);
        return false;
    }

    public final boolean isOrganizationNameTagFGEnable() {
        this.mFgService.isEnable(ORGANIZATION_TAG);
        Log.i(TAG, "arch.user.organizationnametag enable is: false");
        return false;
    }

    public final boolean isSpotlightLocalTagEnable() {
        this.mFgService.isEnable(SPOTLIGHT_LOCAL_TAG);
        Log.i(TAG, "lark.search.mobile.spotlight.local_tag enable is: false");
        return false;
    }

    public final boolean isUrlIconMoreTypesEnable() {
        this.mFgService.isEnable(URL_ICON_MORE_TYPES);
        Log.i(TAG, "lark.search.url_icon.support_more_types enable is: false");
        return false;
    }

    public SearchCommonFgUtils() {
        this.mFgService = (a) k.a(LarkContext.getApplication(), a.class);
    }

    public final a getMFgService() {
        return this.mFgService;
    }

    public final boolean isEnable(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.mFgService.isEnable(r2);
        return false;
    }

    public final void setMFgService(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mFgService = r2;
    }
}
