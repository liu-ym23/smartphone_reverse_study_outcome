package com.ss.android.lark.contact.export;

import android.text.TextUtils;
import com.larksuite.framework.utils.f0;
import java.io.Serializable;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Department implements Serializable, Comparable<Department>, b<Department> {
    private String chatId;
    private String duty;
    private boolean hasLeaderPermission;
    private boolean hasSubDepartments;
    private String id;
    private boolean isSelected;
    private String leaderId;
    private String mRefParentId;
    private int memberCount;
    public int memberCountByDisplayRule;
    private String name;
    private String namePinyin;
    private String parentId;
    private String section;
    private boolean showMemberCount;
    private int status;

    public int hashCode() {
        String r0 = this.id;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public Department() {
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getDuty() {
        return this.duty;
    }

    public String getId() {
        return this.id;
    }

    public String getLeaderId() {
        return this.leaderId;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getName() {
        return this.name;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getRefParentId() {
        return this.mRefParentId;
    }

    public String getSection() {
        return this.section;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean hasSubDepartments() {
        return this.hasSubDepartments;
    }

    public boolean isHasLeaderPermission() {
        return this.hasLeaderPermission;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShowMemberCount() {
        return this.showMemberCount;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Department r4) {
        if (getNamePinyin() != null) goto L5;
    L17:
        return 1;
    L5:
        if (r4.getNamePinyin() == null) goto L17;
        boolean r0 = f0.b(getName());
        boolean r2 = f0.b(r4.getName());
        if (r0 == false) goto L12;
        if (r2 == true) goto L12;
        return -1;
    L12:
        if (r0 == true) goto L16;
        if (r2 == false) goto L16;
        return 1;
    L16:
        return getNamePinyin().compareTo(r4.getNamePinyin());
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Department) == true) goto L7;
        return false;
    L7:
        return TextUtils.equals(this.id, ((Department) r2).id);
    }

    public boolean isContentSame(Department r4) {
        String r0 = this.name;
        if (r0 != null) goto L8;
        if (r4.name != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r0, r4.name) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isItemSame(Department r4) {
        String r0 = this.id;
        if (r0 != null) goto L8;
        if (r4.id != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r0, r4.id) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void setChatId(String r1) {
        this.chatId = r1;
    }

    public void setDuty(String r1) {
        this.duty = r1;
    }

    public void setHasLeaderPermission(boolean r1) {
        this.hasLeaderPermission = r1;
    }

    public void setHasSubDepartments(boolean r1) {
        this.hasSubDepartments = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setLeaderId(String r1) {
        this.leaderId = r1;
    }

    public void setMemberCount(int r1) {
        this.memberCount = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNamePinyin(String r1) {
        this.namePinyin = r1;
    }

    public void setParentId(String r1) {
        this.parentId = r1;
    }

    public void setRefParentId(String r1) {
        this.mRefParentId = r1;
    }

    public void setSection(String r1) {
        this.section = r1;
    }

    public void setSelected(boolean r1) {
        this.isSelected = r1;
    }

    public void setShowMemberCount(boolean r1) {
        this.showMemberCount = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Department r1) {
        return compareTo2(r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Department) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Department) r1);
    }
}
