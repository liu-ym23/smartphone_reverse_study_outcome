package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.params.AddressBookEntryType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/ss/android/lark/picker/config/AddressBookConfig;", "Lcom/ss/android/lark/picker/config/BaseRecommendConfig;", "permissions", "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/config/Permissions;)V", "getPermissions", "()Lcom/ss/android/lark/picker/config/Permissions;", "entriesVisibility", "", "", "", "getEntriesVisibility$picker_release", "()Ljava/util/Map;", "userGroupVisibility", "Lcom/ss/android/lark/picker/config/UserGroupVisibility;", "getUserGroupVisibility", "()Lcom/ss/android/lark/picker/config/UserGroupVisibility;", "setUserGroupVisibility", "(Lcom/ss/android/lark/picker/config/UserGroupVisibility;)V", "recommendItems", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "getRecommendItems", "()Ljava/util/List;", "setRecommendItems", "(Ljava/util/List;)V", "isDepartmentSelectable", "()Z", "setDepartmentSelectable", "(Z)V", "needEnterpriseEmail", "getNeedEnterpriseEmail", "setNeedEnterpriseEmail", "departmentSelectableScene", "Lcom/ss/android/lark/picker/config/DepartmentSelectableScene;", "getDepartmentSelectableScene", "()Lcom/ss/android/lark/picker/config/DepartmentSelectableScene;", "setDepartmentSelectableScene", "(Lcom/ss/android/lark/picker/config/DepartmentSelectableScene;)V", "changeEntryVisibility", "", "entry", "isVisible", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class AddressBookConfig implements BaseRecommendConfig {
    private DepartmentSelectableScene departmentSelectableScene;
    private final Map<Integer, Boolean> entriesVisibility;
    private boolean isDepartmentSelectable;
    private boolean needEnterpriseEmail;
    private final Permissions permissions;
    private List<? extends SearchBaseInfo> recommendItems;
    private UserGroupVisibility userGroupVisibility;

    public final DepartmentSelectableScene getDepartmentSelectableScene() {
        return this.departmentSelectableScene;
    }

    public final Map<Integer, Boolean> getEntriesVisibility$picker_release() {
        return this.entriesVisibility;
    }

    public final boolean getNeedEnterpriseEmail() {
        return this.needEnterpriseEmail;
    }

    @Override // com.ss.android.lark.picker.config.BaseRecommendConfig
    public Permissions getPermissions() {
        return this.permissions;
    }

    public final List<SearchBaseInfo> getRecommendItems() {
        return this.recommendItems;
    }

    public final UserGroupVisibility getUserGroupVisibility() {
        return this.userGroupVisibility;
    }

    public final boolean isDepartmentSelectable() {
        return this.isDepartmentSelectable;
    }

    public AddressBookConfig(Permissions r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.permissions = r2;
        this.entriesVisibility = new LinkedHashMap();
        this.userGroupVisibility = UserGroupVisibility.Invisible.INSTANCE;
        this.departmentSelectableScene = DepartmentSelectableScene.ONLY_OWNER_OR_LEADER;
    }

    public final void setDepartmentSelectable(boolean r1) {
        this.isDepartmentSelectable = r1;
    }

    public final void setDepartmentSelectableScene(DepartmentSelectableScene r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departmentSelectableScene = r2;
    }

    public final void setNeedEnterpriseEmail(boolean r1) {
        this.needEnterpriseEmail = r1;
    }

    public final void setRecommendItems(List<? extends SearchBaseInfo> r1) {
        this.recommendItems = r1;
    }

    public final void setUserGroupVisibility(UserGroupVisibility r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userGroupVisibility = r2;
    }

    public final void changeEntryVisibility(@AddressBookEntryType int r2, boolean r3) {
        Integer r4 = Integer.valueOf(r2);
        Boolean r5 = Boolean.valueOf(r3);
        this.entriesVisibility.put(r4, r5);
    }
}
