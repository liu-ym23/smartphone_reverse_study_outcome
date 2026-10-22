package com.ss.android.lark.doc.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DocFeed implements Serializable {
    private long createTime;
    private List<String> docMessageIds;
    private String iconKey;
    private String id;
    private boolean isCrossTenant;
    private boolean isRemind;
    private String lastMessageId;
    private int newMessageCount;
    private String ownerId;
    private String title;
    private DocType type;
    private long updateTime;
    private String url;

    public DocFeed() {
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public List<String> getDocMessageIds() {
        return this.docMessageIds;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.id;
    }

    public String getLastMessageId() {
        return this.lastMessageId;
    }

    public int getNewMessageCount() {
        return this.newMessageCount;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getTitle() {
        return this.title;
    }

    public DocType getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof DocFeed) == true) goto L11;
        return false;
    L11:
        DocFeed r6 = (DocFeed) r5;
        String r2 = this.id;
        if (r2 == null) goto L14;
        boolean r3 = r2.equals(r6.getId());
    L18:
        if (r3 == true) goto L20;
        return false;
    L20:
        DocType r4 = this.type;
        DocType r7 = r6.getType();
        if (r4 != null) goto L25;
        if (r7 != null) goto L26;
        return true;
    L26:
        return false;
    L25:
        return r4.equals(r7);
    L14:
        if (r6.getId() != null) goto L16;
        r3 = true;
        goto L18
    L16:
        r3 = false;
        goto L18
    }

    public boolean exactlyCompare(DocFeed r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (this != r8) goto L8;
        return true;
    L8:
        String r2 = this.id;
        if (r2 == null) goto L11;
        boolean r3 = r2.equals(r8.getId());
    L15:
        if (r3 == true) goto L18;
        return false;
    L18:
        if (this.updateTime != r8.updateTime) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        return false;
    L24:
        if (this.newMessageCount != r8.getNewMessageCount()) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == true) goto L29;
        return false;
    L29:
        if (r5 == true) goto L31;
    L33:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L43;
        DocType r7 = this.type;
        DocType r9 = r8.getType();
        if (r7 != null) goto L40;
        if (r9 != null) goto L44;
    L41:
        return true;
    L44:
        return false;
    L40:
        if (r7.equals(r9) == true) goto L41;
        return false;
    L43:
        return false;
    L31:
        if (this.isRemind != r8.isRemind) goto L33;
        r6 = true;
        goto L34
    L26:
        r5 = false;
        goto L27
    L20:
        r4 = false;
        goto L21
    L11:
        if (r8.getId() != null) goto L13;
        r3 = true;
        goto L15
    L13:
        r3 = false;
        goto L15
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setCrossTenant(boolean r1) {
        this.isCrossTenant = r1;
    }

    public void setDocMessageIds(List<String> r1) {
        this.docMessageIds = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setLastMessageId(String r1) {
        this.lastMessageId = r1;
    }

    public void setNewMessageCount(int r1) {
        this.newMessageCount = r1;
    }

    public void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public void setRemind(boolean r1) {
        this.isRemind = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public void setType(DocType r1) {
        this.type = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
