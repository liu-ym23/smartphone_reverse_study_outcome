package com.ss.android.lark.reaction.widget.detailwindow.bean;

import java.io.Serializable;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DetailUserInfo implements Serializable {
    private String avatarKey;
    private String avatarUrl;
    private DescriptionType descType;
    private String description;
    private boolean isRegistered;
    private String userId;
    private String userName;
    private String workStatusDesc;

    public static final enum DescriptionType extends Enum<DescriptionType> {
        public static final DescriptionType BUSINESS = null;
        public static final DescriptionType DEFAULT = null;
        public static final DescriptionType LEAVE = null;
        public static final DescriptionType MEETING = null;
        public static final /* synthetic */ DescriptionType[] a = null;

        static {
            DescriptionType r0 = new DescriptionType("DEFAULT", 0);
            DEFAULT = r0;
            DescriptionType r1 = new DescriptionType("BUSINESS", 1);
            BUSINESS = r1;
            DescriptionType r3 = new DescriptionType("LEAVE", 2);
            LEAVE = r3;
            DescriptionType r5 = new DescriptionType("MEETING", 3);
            MEETING = r5;
            a = new DescriptionType[]{r0, r1, r3, r5};
        }

        public static DescriptionType[] values() {
            return (DescriptionType[]) a.clone();
        }

        public static DescriptionType valueOf(String r1) {
            return (DescriptionType) a.a(DescriptionType.class, r1);
        }

        public DescriptionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.avatarKey, this.avatarUrl, this.userName, this.userId, Boolean.valueOf(this.isRegistered), this.description, this.descType, this.workStatusDesc});
    }

    public DetailUserInfo() {
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        this.descType = DescriptionType.DEFAULT;
        this.workStatusDesc = "";
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public DescriptionType getDescType() {
        return this.descType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWorkStatusDesc() {
        return this.workStatusDesc;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DetailUserInfo) == true) goto L8;
        return false;
    L8:
        DetailUserInfo r6 = (DetailUserInfo) r5;
        if (this.isRegistered == r6.isRegistered) goto L11;
    L25:
        return false;
    L11:
        if (Objects.equals(this.avatarKey, r6.avatarKey) == false) goto L25;
        if (Objects.equals(this.avatarUrl, r6.avatarUrl) == false) goto L25;
        if (Objects.equals(this.userName, r6.userName) == false) goto L25;
        if (Objects.equals(this.userId, r6.userId) == false) goto L25;
        if (Objects.equals(this.description, r6.description) == false) goto L25;
        if (this.descType != r6.descType) goto L25;
        if (Objects.equals(this.workStatusDesc, r6.workStatusDesc) == false) goto L25;
        return true;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setDescType(DescriptionType r1) {
        this.descType = r1;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setRegistered(boolean r1) {
        this.isRegistered = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setUserName(String r1) {
        this.userName = r1;
    }

    public void setWorkStatusDesc(String r1) {
        this.workStatusDesc = r1;
    }

    public DetailUserInfo(String r3, String r4, String r5) {
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        this.descType = DescriptionType.DEFAULT;
        this.workStatusDesc = "";
        this.avatarKey = r3;
        this.userName = r4;
        this.userId = r5;
    }

    public DetailUserInfo(String r2, String r3, String r4, String r5, boolean r6, String r7, DescriptionType r8, String r9) {
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        DescriptionType r0 = DescriptionType.DEFAULT;
        this.avatarKey = r2;
        this.avatarUrl = r3;
        this.userName = r4;
        this.userId = r5;
        this.isRegistered = r6;
        this.description = r7;
        this.descType = r8;
        this.workStatusDesc = r9;
    }
}
