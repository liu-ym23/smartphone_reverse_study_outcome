package com.ss.android.lark.doc.entity;

import android.text.TextUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class Doc implements Serializable, b<Doc> {
    private String abstractUrl;
    private long createTime;
    private DocType docType;
    private Icon icon;
    private String iconKey;
    private String id;
    private String name;
    private String ownerId;
    private String ownerName;
    private ThumbnailDetail thumbnailDetail;
    private long updateTime;
    private String url;

    public Doc() {
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.abstractUrl;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.id);
    }

    public String getAbstract() {
        return this.abstractUrl;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public DocType getDocType() {
        return this.docType;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public ThumbnailDetail getThumbnaimDetail() {
        return this.thumbnailDetail;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L33:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L33;
        Doc r6 = (Doc) r5;
        String r2 = this.id;
        if (r2 == null) goto L16;
        if (r2.equals(r6.id) == false) goto L17;
    L18:
        String r3 = this.url;
        if (r3 == null) goto L24;
        if (r3.equals(r6.url) == false) goto L25;
    L26:
        String r4 = this.abstractUrl;
        String r7 = r6.abstractUrl;
        if (r4 != null) goto L34;
        if (r7 == null) goto L35;
        return false;
    L35:
        return true;
    L34:
        return r4.equals(r7);
    L25:
        return false;
    L24:
        if (r6.url == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.id == null) goto L18;
        goto L17
    }

    public boolean isContentSame(Doc r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(this.ownerName, r6.getOwnerName()) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.url, r6.getUrl()) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(this.name, r6.getName()) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(this.abstractUrl, r6.getAbstract()) == true) goto L18;
        return false;
    L18:
        if (this.updateTime == r6.getUpdateTime()) goto L20;
        return false;
    L20:
        return true;
    }

    public boolean isItemSame(Doc r2) {
        String r0 = this.id;
        if (r2 != null) goto L5;
        String r3 = BuildConfig.FLAVOR;
    L7:
        return TextUtils.equals(r0, r3);
    L5:
        r3 = r2.getId();
        goto L7
    }

    public void setAbstract(String r1) {
        this.abstractUrl = r1;
    }

    public void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public void setDocType(DocType r1) {
        this.docType = r1;
    }

    public void setIcon(Icon r1) {
        this.icon = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public void setOwnerName(String r1) {
        this.ownerName = r1;
    }

    public void setThumbnaimDetail(ThumbnailDetail r1) {
        this.thumbnailDetail = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Doc) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Doc) r1);
    }
}
