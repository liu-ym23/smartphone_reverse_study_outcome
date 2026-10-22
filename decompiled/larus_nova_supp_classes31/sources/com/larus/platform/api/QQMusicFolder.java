package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/platform/api/QQMusicFolder;", "", "type", "", "id", "", "mainTitle", "subTitle", "picUrl", "isSongFolder", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getType", "()I", "getId", "()Ljava/lang/String;", "getMainTitle", "getSubTitle", "getPicUrl", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class QQMusicFolder {
    private final String id;
    private final boolean isSongFolder;
    private final String mainTitle;
    private final String picUrl;
    private final String subTitle;
    private final int type;

    public QQMusicFolder() {
        this(0, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ QQMusicFolder copy$default(QQMusicFolder r4, int r5, String r6, String r7, String r8, String r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.type;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.id;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.mainTitle;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.subTitle;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.picUrl;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.isSongFolder;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.id;
    }

    public final String component3() {
        return this.mainTitle;
    }

    public final String component4() {
        return this.subTitle;
    }

    public final String component5() {
        return this.picUrl;
    }

    public final boolean component6() {
        return this.isSongFolder;
    }

    public final QQMusicFolder copy(int r9, String r10, String r11, String r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r11, "mainTitle");
        Intrinsics.checkNotNullParameter(r13, "picUrl");
        return new QQMusicFolder(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QQMusicFolder) == true) goto L8;
        return false;
    L8:
        QQMusicFolder r6 = (QQMusicFolder) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainTitle, r6.mainTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.picUrl, r6.picUrl) == true) goto L24;
        return false;
    L24:
        if (this.isSongFolder == r6.isSongFolder) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.type * 31) + this.id.hashCode()) * 31) + this.mainTitle.hashCode()) * 31;
        String r1 = this.subTitle;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.picUrl.hashCode()) * 31;
        if (this.isSongFolder == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "QQMusicFolder(type=" + this.type + ", id=" + this.id + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", picUrl=" + this.picUrl + ", isSongFolder=" + this.isSongFolder + ')';
    }

    public final String getId() {
        return this.id;
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isSongFolder() {
        return this.isSongFolder;
    }

    public QQMusicFolder(int r2, String r3, String r4, String r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "id");
        Intrinsics.checkNotNullParameter(r4, "mainTitle");
        Intrinsics.checkNotNullParameter(r6, "picUrl");
        this.type = r2;
        this.id = r3;
        this.mainTitle = r4;
        this.subTitle = r5;
        this.picUrl = r6;
        this.isSongFolder = r7;
    }

    public /* synthetic */ QQMusicFolder(int r6, String r7, String r8, String r9, String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        int r14 = 0;
    L6:
        String r1 = "";
        if ((r12 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r3 = "";
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r4 = "";
    L19:
        if ((r12 & 16) != 0) goto L23;
        r1 = r10;
    L23:
        if ((r12 & 32) == 0) goto L25;
        boolean r15 = false;
    L26:
        this(r14, r2, r3, r4, r1, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L17:
        r4 = r9;
        goto L19
    L13:
        r3 = r8;
        goto L15
    L9:
        r2 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L6
    }
}
