package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/config/ScenarioConfig;", "Lcom/ss/android/lark/picker/config/BaseRecommendConfig;", "permissions", "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/config/Permissions;)V", "getPermissions", "()Lcom/ss/android/lark/picker/config/Permissions;", "showPersonnelTypeEntry", "", "getShowPersonnelTypeEntry", "()Z", "setShowPersonnelTypeEntry", "(Z)V", "showPermissionGroupEntry", "getShowPermissionGroupEntry", "setShowPermissionGroupEntry", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ScenarioConfig implements BaseRecommendConfig {
    private final Permissions permissions;
    private boolean showPermissionGroupEntry;
    private boolean showPersonnelTypeEntry;

    @Override // com.ss.android.lark.picker.config.BaseRecommendConfig
    public Permissions getPermissions() {
        return this.permissions;
    }

    public final boolean getShowPermissionGroupEntry() {
        return this.showPermissionGroupEntry;
    }

    public final boolean getShowPersonnelTypeEntry() {
        return this.showPersonnelTypeEntry;
    }

    public ScenarioConfig(Permissions r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.permissions = r2;
        this.showPersonnelTypeEntry = true;
        this.showPermissionGroupEntry = true;
    }

    public final void setShowPermissionGroupEntry(boolean r1) {
        this.showPermissionGroupEntry = r1;
    }

    public final void setShowPersonnelTypeEntry(boolean r1) {
        this.showPersonnelTypeEntry = r1;
    }
}
