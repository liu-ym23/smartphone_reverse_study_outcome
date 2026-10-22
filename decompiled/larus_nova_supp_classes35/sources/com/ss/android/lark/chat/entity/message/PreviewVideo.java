package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/PreviewVideo;", "Ljava/io/Serializable;", "site", "Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;", "vid", BuildConfig.FLAVOR, "iFrameUrl", "<init>", "(Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;Ljava/lang/String;Ljava/lang/String;)V", "getSite", "()Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;", "getVid", "()Ljava/lang/String;", "getIFrameUrl", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Site", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewVideo implements Serializable {
    private final String iFrameUrl;
    private final Site site;
    private final String vid;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "XIGUA", "DOUYIN", "HUOSHAN", "YOUTUBE", "IQIYI", "YOUKU", "QQ", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Site extends Enum<Site> {
        public static final Site DOUYIN = null;
        public static final Site HUOSHAN = null;
        public static final Site IQIYI = null;
        public static final Site QQ = null;
        public static final Site UNKNOWN = null;
        public static final Site XIGUA = null;
        public static final Site YOUKU = null;
        public static final Site YOUTUBE = null;
        public static final /* synthetic */ Site[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<Site> getEntries() {
            return b;
        }

        static {
            Site r0 = new Site("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Site r1 = new Site("XIGUA", 1, 1);
            XIGUA = r1;
            Site r3 = new Site("DOUYIN", 2, 2);
            DOUYIN = r3;
            Site r5 = new Site("HUOSHAN", 3, 3);
            HUOSHAN = r5;
            Site r7 = new Site("YOUTUBE", 4, 4);
            YOUTUBE = r7;
            Site r9 = new Site("IQIYI", 5, 5);
            IQIYI = r9;
            Site r11 = new Site("YOUKU", 6, 6);
            YOUKU = r11;
            Site r13 = new Site("QQ", 7, 7);
            QQ = r13;
            Site[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
        }

        public static Site[] values() {
            return (Site[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Site valueOf(String r1) {
            return (Site) r27.a.a(Site.class, r1);
        }

        public Site(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ PreviewVideo copy$default(PreviewVideo r0, Site r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.site;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.vid;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.iFrameUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Site component1() {
        return this.site;
    }

    public final String component2() {
        return this.vid;
    }

    public final String component3() {
        return this.iFrameUrl;
    }

    public final PreviewVideo copy(Site r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "site");
        return new PreviewVideo(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PreviewVideo) == true) goto L8;
        return false;
    L8:
        PreviewVideo r6 = (PreviewVideo) r5;
        if (this.site == r6.site) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iFrameUrl, r6.iFrameUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.site.hashCode() * 31;
        String r1 = this.vid;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.iFrameUrl;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PreviewVideo(site=" + this.site + ", vid=" + this.vid + ", iFrameUrl=" + this.iFrameUrl + ')';
    }

    public final String getIFrameUrl() {
        return this.iFrameUrl;
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getVid() {
        return this.vid;
    }

    public PreviewVideo(Site r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "site");
        this.site = r2;
        this.vid = r3;
        this.iFrameUrl = r4;
    }
}
