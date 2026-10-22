package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/picker/config/GroupExtra;", "Lcom/ss/android/lark/picker/config/Extra;", "<init>", "()V", "isReturnInTeamId", "", "()Ljava/lang/String;", "setReturnInTeamId", "(Ljava/lang/String;)V", "isReturnRelationTag", "", "()Z", "setReturnRelationTag", "(Z)V", "showEnterpriseEmail", "getShowEnterpriseEmail", "()Ljava/lang/Boolean;", "setShowEnterpriseEmail", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "closeSearchByUser", "getCloseSearchByUser", "setCloseSearchByUser", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class GroupExtra implements Extra {
    private Boolean closeSearchByUser;
    private String isReturnInTeamId;
    private boolean isReturnRelationTag;
    private Boolean showEnterpriseEmail;

    public GroupExtra() {
        this.isReturnRelationTag = true;
    }

    public final Boolean getCloseSearchByUser() {
        return this.closeSearchByUser;
    }

    public final Boolean getShowEnterpriseEmail() {
        return this.showEnterpriseEmail;
    }

    public final String isReturnInTeamId() {
        return this.isReturnInTeamId;
    }

    public final boolean isReturnRelationTag() {
        return this.isReturnRelationTag;
    }

    public final void setCloseSearchByUser(Boolean r1) {
        this.closeSearchByUser = r1;
    }

    public final void setReturnInTeamId(String r1) {
        this.isReturnInTeamId = r1;
    }

    public final void setReturnRelationTag(boolean r1) {
        this.isReturnRelationTag = r1;
    }

    public final void setShowEnterpriseEmail(Boolean r1) {
        this.showEnterpriseEmail = r1;
    }
}
