package com.obric.lifelog.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\fHÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006,"}, d2 = {"Lcom/obric/lifelog/data/Lifelog;", "", "timestamp", "", "uid", "title", "", "contentAM", "contentPM", "finalContent", "imageUrl", "retryTime", "", "status", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getTimestamp", "()J", "getUid", "getTitle", "()Ljava/lang/String;", "getContentAM", "getContentPM", "getFinalContent", "getImageUrl", "getRetryTime", "()I", "getStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "lifelog_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Lifelog {
    public static final a Companion = null;
    private final String contentAM;
    private final String contentPM;
    private final String finalContent;
    private final String imageUrl;
    private final int retryTime;
    private final int status;
    private final long timestamp;
    private final String title;
    private final long uid;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/lifelog/data/Lifelog$Companion;", "", "<init>", "()V", "fromMap", "Lcom/obric/lifelog/data/Lifelog;", "map", "", "", "lifelog_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public Lifelog(long r2, long r4, String r6, String r7, String r8, String r9, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r7, "contentAM");
        Intrinsics.checkNotNullParameter(r8, "contentPM");
        Intrinsics.checkNotNullParameter(r9, "finalContent");
        Intrinsics.checkNotNullParameter(r10, "imageUrl");
        this.timestamp = r2;
        this.uid = r4;
        this.title = r6;
        this.contentAM = r7;
        this.contentPM = r8;
        this.finalContent = r9;
        this.imageUrl = r10;
        this.retryTime = r11;
        this.status = r12;
    }

    public static /* synthetic */ Lifelog copy$default(Lifelog r12, long r13, long r15, String r17, String r18, String r19, String r20, String r21, int r22, int r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        long r2 = r12.timestamp;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r4 = r12.uid;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r6 = r12.title;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = r12.contentAM;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r8 = r12.contentPM;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r9 = r12.finalContent;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r10 = r12.imageUrl;
    L31:
        if ((r24 & 128) == 0) goto L33;
        int r11 = r12.retryTime;
    L35:
        if ((r24 & 256) == 0) goto L37;
        int r1 = r12.status;
    L39:
        return r12.copy(r2, r4, r6, r7, r8, r9, r10, r11, r1);
    L37:
        r1 = r23;
        goto L39
    L33:
        r11 = r22;
        goto L35
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r4 = r15;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final long component1() {
        return this.timestamp;
    }

    public final long component2() {
        return this.uid;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.contentAM;
    }

    public final String component5() {
        return this.contentPM;
    }

    public final String component6() {
        return this.finalContent;
    }

    public final String component7() {
        return this.imageUrl;
    }

    public final int component8() {
        return this.retryTime;
    }

    public final int component9() {
        return this.status;
    }

    public final Lifelog copy(long r14, long r16, String r18, String r19, String r20, String r21, String r22, int r23, int r24) {
        Intrinsics.checkNotNullParameter(r18, "title");
        Intrinsics.checkNotNullParameter(r19, "contentAM");
        Intrinsics.checkNotNullParameter(r20, "contentPM");
        Intrinsics.checkNotNullParameter(r21, "finalContent");
        Intrinsics.checkNotNullParameter(r22, "imageUrl");
        return new Lifelog(r14, r16, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Lifelog.class) == true) goto L8;
        return false;
    L8:
        Lifelog r10 = (Lifelog) ZeusTransformUtils.preCheckCast(r9, Lifelog.class, "com.obric.memorydata.plugin");
        if (this.timestamp == r10.timestamp) goto L12;
        return false;
    L12:
        if (this.uid == r10.uid) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentAM, r10.contentAM) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contentPM, r10.contentPM) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.finalContent, r10.finalContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageUrl, r10.imageUrl) == true) goto L30;
        return false;
    L30:
        if (this.retryTime == r10.retryTime) goto L33;
        return false;
    L33:
        if (this.status == r10.status) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getContentAM() {
        return this.contentAM;
    }

    public final String getContentPM() {
        return this.contentPM;
    }

    public final String getFinalContent() {
        return this.finalContent;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getRetryTime() {
        return this.retryTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.timestamp) * 31) + Long.hashCode(this.uid)) * 31) + this.title.hashCode()) * 31) + this.contentAM.hashCode()) * 31) + this.contentPM.hashCode()) * 31) + this.finalContent.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + Integer.hashCode(this.retryTime)) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        return "Lifelog(timestamp=" + this.timestamp + ", uid=" + this.uid + ", title=" + this.title + ", contentAM=" + this.contentAM + ", contentPM=" + this.contentPM + ", finalContent=" + this.finalContent + ", imageUrl=" + this.imageUrl + ", retryTime=" + this.retryTime + ", status=" + this.status + ')';
    }
}
