package com.bytedance.android.live.emoji.online.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B9\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003JC\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmojiRes;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "component4", "component5", "id", "createTime", "updateTime", "resourceUrl", "md5", "copy", "toString", "hashCode", "", "other", "", "equals", "I", "getId", "()I", "Ljava/lang/String;", "getCreateTime", "()Ljava/lang/String;", "getUpdateTime", "getResourceUrl", "getMd5", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public final class OnlineSmallEmojiRes implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("id")
    private final int id;

    @SerializedName("md5")
    private final String md5;

    @SerializedName("resource_url")
    private final String resourceUrl;

    @SerializedName("update_time")
    private final String updateTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ OnlineSmallEmojiRes copy$default(OnlineSmallEmojiRes r3, int r4, String r5, String r6, String r7, String r8, int r9, Object r11) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.id;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.createTime;
    L8:
        String r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.updateTime;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.resourceUrl;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.md5;
    L17:
        int r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.createTime;
    }

    public final String component3() {
        return this.updateTime;
    }

    public final String component4() {
        return this.resourceUrl;
    }

    public final String component5() {
        return this.md5;
    }

    public final OnlineSmallEmojiRes copy(int r8, String r9, String r11, String r12, String r13) {
        return new OnlineSmallEmojiRes(r8, r9, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OnlineSmallEmojiRes) == false) goto L16;
        OnlineSmallEmojiRes r4 = (OnlineSmallEmojiRes) r3;
        if (this.id == r4.id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.createTime, r4.createTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.updateTime, r4.updateTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceUrl, r4.resourceUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.md5, r4.md5) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.id * 31;
        String r1 = this.createTime;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.updateTime;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.resourceUrl;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r11 = (r7 + r9) * 31;
        String r12 = this.md5;
        if (r12 == null) goto L18;
        r2 = r12.hashCode();
    L18:
        return r11 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "OnlineSmallEmojiRes(id=" + this.id + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", resourceUrl=" + this.resourceUrl + ", md5=" + this.md5 + ")";
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public OnlineSmallEmojiRes(int r1, String r2, String r3, String r4, String r5) {
        this.id = r1;
        this.createTime = r2;
        this.updateTime = r3;
        this.resourceUrl = r4;
        this.md5 = r5;
    }

    public /* synthetic */ OnlineSmallEmojiRes(int r7, String r8, String r9, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        int r1 = 0;
    L6:
        this(r1, r8, r9, r11, r12);
        return;
    L5:
        r1 = r7;
        goto L6
    }
}
