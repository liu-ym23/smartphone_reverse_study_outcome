package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocCard implements Serializable, b<DocCard> {
    private String docId;
    private Extra extra;
    private String groupId;
    private String messageId;
    private List<DocPermission> permissions;
    private DocPermission receiverPermission;
    private Boolean senderIsExternal;
    private String shareInfo;
    private long shareStatus;
    private boolean shouldRender;
    private DocPermission userPermission;

    public DocCard() {
    }

    public DocPermission getCurrentDocPerm() {
        if (this.permissions.size() == 1) goto L5;
        Iterator<DocPermission> r0 = this.permissions.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        DocPermission r2 = r0.next();
        if (r2.isSet() == false) goto L8;
        return r2;
    L12:
        DocPermission r1 = new DocPermission();
        r1.setIsSet(true);
        r1.setRead(true);
        return r1;
    L5:
        return (DocPermission) ListProtector.get(this.permissions, 0);
    }

    public List<DocPermission> getPermissions() {
        List<DocPermission> r0 = this.permissions;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new ArrayList();
    }

    public boolean getSenderIsExternal() {
        Boolean r0 = this.senderIsExternal;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public int hashCode() {
        String r0 = this.docId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        List<DocPermission> r3 = this.permissions;
        if (r3 == null) goto L12;
        Iterator<DocPermission> r4 = r3.iterator();
        int r5 = 0;
    L10:
        if (r4.hasNext() == false) goto L13;
        r5 = r5 + r4.next().hashCode();
    L13:
        int r6 = ((r2 * 31) + r5) * 31;
        String r7 = this.shareInfo;
        if (r7 == null) goto L16;
        int r8 = r7.hashCode();
    L17:
        int r9 = (r6 + r8) * 31;
        DocPermission r10 = this.userPermission;
        if (r10 == null) goto L21;
        r1 = r10.hashCode();
    L21:
        return ((r9 + r1) * 31) + ((int) this.shareStatus);
    L16:
        r8 = 0;
        goto L17
    L12:
        r5 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.messageId) == false) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.docId) == true) goto L8;
        return false;
    }

    public String toString() {
        return "shouldRender" + this.shouldRender + "sharedStatus" + this.shareStatus + "permissions().size()" + getPermissions().size();
    }

    public String getDocId() {
        return this.docId;
    }

    public Extra getExtra() {
        return this.extra;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public DocPermission getReceiverPermission() {
        return this.receiverPermission;
    }

    public String getShareInfo() {
        return this.shareInfo;
    }

    public long getShareStatus() {
        return this.shareStatus;
    }

    public DocPermission getUserPermission() {
        return this.userPermission;
    }

    public boolean isShouldRender() {
        return this.shouldRender;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return isContentSame((DocCard) r3);
    }

    public boolean isContentSame(DocCard r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.docId, r7.getDocId()) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.shareInfo, r7.getShareInfo()) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.userPermission, r7.userPermission) == true) goto L15;
        return false;
    L15:
        if (this.shareStatus == r7.getShareStatus()) goto L17;
        return false;
    L17:
        List<DocPermission> r8 = r7.getPermissions();
        if (r8 == null) goto L20;
    L22:
        if (r8 != null) goto L24;
        return false;
    L24:
        if (this.permissions == null) goto L46;
        Iterator<DocPermission> r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L21;
        DocPermission r2 = r9.next();
        Iterator<DocPermission> r3 = this.permissions.iterator();
    L30:
        if (r3.hasNext() == false) goto L34;
        if (r2.equals(r3.next()) == false) goto L30;
        boolean r4 = true;
    L35:
        if (r4 == true) goto L27;
        return false;
    L34:
        r4 = false;
    L21:
        return true;
    L46:
        return false;
    L20:
        if (this.permissions != null) goto L22;
        goto L21
    }

    public boolean isItemSame(DocCard r2) {
        String r0 = this.messageId;
        if (r2 != null) goto L5;
        String r3 = BuildConfig.FLAVOR;
    L7:
        return TextUtils.equals(r0, r3);
    L5:
        r3 = r2.getMessageId();
        goto L7
    }

    public void setDocId(String r1) {
        this.docId = r1;
    }

    public void setExtra(Extra r1) {
        this.extra = r1;
    }

    public void setGroupId(String r1) {
        this.groupId = r1;
    }

    public void setMessageId(String r1) {
        this.messageId = r1;
    }

    public void setPermissions(List<DocPermission> r1) {
        this.permissions = r1;
    }

    public void setReceiverPermission(DocPermission r1) {
        this.receiverPermission = r1;
    }

    public void setSenderIsExternal(Boolean r1) {
        this.senderIsExternal = r1;
    }

    public void setShareInfo(String r1) {
        this.shareInfo = r1;
    }

    public void setShareStatus(long r1) {
        this.shareStatus = r1;
    }

    public void setShouldRender(boolean r1) {
        this.shouldRender = r1;
    }

    public void setUserPermission(DocPermission r1) {
        this.userPermission = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((DocCard) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((DocCard) r1);
    }
}
