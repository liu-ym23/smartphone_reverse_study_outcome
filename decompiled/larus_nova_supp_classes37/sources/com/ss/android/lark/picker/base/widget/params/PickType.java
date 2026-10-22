package com.ss.android.lark.picker.base.widget.params;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006%"}, d2 = {"Lcom/ss/android/lark/picker/base/widget/params/PickType;", "", "<init>", "()V", "enablePickChatter", "", "getEnablePickChatter", "()Z", "setEnablePickChatter", "(Z)V", "enablePickExternalChatter", "getEnablePickExternalChatter", "setEnablePickExternalChatter", "enablePickChat", "getEnablePickChat", "setEnablePickChat", "enablePickExternalChat", "getEnablePickExternalChat", "setEnablePickExternalChat", "enableEmailContact", "getEnableEmailContact", "setEnableEmailContact", "enableEmailSharedAccount", "getEnableEmailSharedAccount", "setEnableEmailSharedAccount", "enablePickDepartment", "getEnablePickDepartment", "setEnablePickDepartment", "enablePublicGroup", "getEnablePublicGroup", "setEnablePublicGroup", "enableSecretGroup", "getEnableSecretGroup", "setEnableSecretGroup", "enableMeetingGroup", "getEnableMeetingGroup", "setEnableMeetingGroup", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickType {
    private boolean enableEmailContact;
    private boolean enableEmailSharedAccount;
    private boolean enableMeetingGroup;
    private boolean enablePickChat;
    private boolean enablePickChatter;
    private boolean enablePickDepartment;
    private boolean enablePickExternalChat;
    private boolean enablePickExternalChatter;
    private boolean enablePublicGroup;
    private boolean enableSecretGroup;

    public PickType() {
        this.enablePickChatter = true;
        this.enablePickExternalChatter = true;
        this.enablePickChat = true;
        this.enablePickDepartment = true;
        this.enablePublicGroup = true;
        this.enableSecretGroup = true;
        this.enableMeetingGroup = true;
    }

    public final boolean getEnableEmailContact() {
        return this.enableEmailContact;
    }

    public final boolean getEnableEmailSharedAccount() {
        return this.enableEmailSharedAccount;
    }

    public final boolean getEnableMeetingGroup() {
        return this.enableMeetingGroup;
    }

    public final boolean getEnablePickChat() {
        return this.enablePickChat;
    }

    public final boolean getEnablePickChatter() {
        return this.enablePickChatter;
    }

    public final boolean getEnablePickDepartment() {
        return this.enablePickDepartment;
    }

    public final boolean getEnablePickExternalChat() {
        return this.enablePickExternalChat;
    }

    public final boolean getEnablePickExternalChatter() {
        return this.enablePickExternalChatter;
    }

    public final boolean getEnablePublicGroup() {
        return this.enablePublicGroup;
    }

    public final boolean getEnableSecretGroup() {
        return this.enableSecretGroup;
    }

    public final void setEnableEmailContact(boolean r1) {
        this.enableEmailContact = r1;
    }

    public final void setEnableEmailSharedAccount(boolean r1) {
        this.enableEmailSharedAccount = r1;
    }

    public final void setEnableMeetingGroup(boolean r1) {
        this.enableMeetingGroup = r1;
    }

    public final void setEnablePickChat(boolean r1) {
        this.enablePickChat = r1;
    }

    public final void setEnablePickChatter(boolean r1) {
        this.enablePickChatter = r1;
    }

    public final void setEnablePickDepartment(boolean r1) {
        this.enablePickDepartment = r1;
    }

    public final void setEnablePickExternalChat(boolean r1) {
        this.enablePickExternalChat = r1;
    }

    public final void setEnablePickExternalChatter(boolean r1) {
        this.enablePickExternalChatter = r1;
    }

    public final void setEnablePublicGroup(boolean r1) {
        this.enablePublicGroup = r1;
    }

    public final void setEnableSecretGroup(boolean r1) {
        this.enableSecretGroup = r1;
    }
}
