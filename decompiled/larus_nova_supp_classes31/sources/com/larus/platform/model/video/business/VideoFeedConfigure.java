package com.larus.platform.model.video.business;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 w2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010s\u001a\u00020t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\bH\u0016J\b\u0010v\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001a\u00107\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R\u001a\u0010:\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010\fR\u001a\u0010F\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\n\"\u0004\bH\u0010\fR\u001a\u0010I\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\n\"\u0004\bK\u0010\fR\u001a\u0010L\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00101\"\u0004\bT\u00103R\u001a\u0010U\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012R\u001a\u0010X\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R\u001a\u0010[\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R\u001a\u0010^\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\u001a\u0010a\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0010\"\u0004\bc\u0010\u0012R\u001c\u0010d\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00101\"\u0004\bf\u00103R\u001c\u0010g\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00101\"\u0004\bi\u00103R\u001a\u0010j\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\n\"\u0004\bl\u0010\fR\u001a\u0010m\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010O\"\u0004\bo\u0010QR\u001a\u0010p\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010O\"\u0004\br\u0010Q¨\u0006x"}, d2 = {"Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "bottomMarginPxIfNotFullScreen", "", "getBottomMarginPxIfNotFullScreen", "()I", "setBottomMarginPxIfNotFullScreen", "(I)V", "ignoreUserPauseOrPlay", "", "getIgnoreUserPauseOrPlay", "()Z", "setIgnoreUserPauseOrPlay", "(Z)V", "ignoreReportLeaveVideoPlayer", "getIgnoreReportLeaveVideoPlayer", "setIgnoreReportLeaveVideoPlayer", "hostCommonParams", "Lorg/json/JSONObject;", "getHostCommonParams", "()Lorg/json/JSONObject;", "setHostCommonParams", "(Lorg/json/JSONObject;)V", "interactiveRecInfoParams", "getInteractiveRecInfoParams", "setInteractiveRecInfoParams", "enterVideoMethod", "Lcom/larus/platform/model/video/business/EnterVideoMethod;", "getEnterVideoMethod", "()Lcom/larus/platform/model/video/business/EnterVideoMethod;", "setEnterVideoMethod", "(Lcom/larus/platform/model/video/business/EnterVideoMethod;)V", "leavePageTrackJson", "getLeavePageTrackJson", "setLeavePageTrackJson", "itemIDList", "", "", "getItemIDList", "()Ljava/util/List;", "setItemIDList", "(Ljava/util/List;)V", "enterItemID", "getEnterItemID", "()Ljava/lang/String;", "setEnterItemID", "(Ljava/lang/String;)V", "needCachedRecommendFeed", "getNeedCachedRecommendFeed", "setNeedCachedRecommendFeed", "showLeftBackButton", "getShowLeftBackButton", "setShowLeftBackButton", "fullScreen", "getFullScreen", "setFullScreen", "hostCoverAspectRatio", "", "getHostCoverAspectRatio", "()F", "setHostCoverAspectRatio", "(F)V", "coverWidth", "getCoverWidth", "setCoverWidth", "coverHeight", "getCoverHeight", "setCoverHeight", "excludedHeight", "getExcludedHeight", "setExcludedHeight", "doubleBallLoadingDelay", "", "getDoubleBallLoadingDelay", "()J", "setDoubleBallLoadingDelay", "(J)V", "hostCoverUrl", "getHostCoverUrl", "setHostCoverUrl", "needCustomLoadMore", "getNeedCustomLoadMore", "setNeedCustomLoadMore", "needRefresh", "getNeedRefresh", "setNeedRefresh", "shouldPaddingStatusBarHeight", "getShouldPaddingStatusBarHeight", "setShouldPaddingStatusBarHeight", "showCommentSwitch", "getShowCommentSwitch", "setShowCommentSwitch", "showCollect", "getShowCollect", "setShowCollect", "eventPage", "getEventPage", "setEventPage", "sceneID", "getSceneID", "setSceneID", "commentBottomMargin", "getCommentBottomMargin", "setCommentBottomMargin", "userID", "getUserID", "setUserID", "startPlayPosition", "getStartPlayPosition", "setStartPlayPosition", "writeToParcel", "", "flags", "describeContents", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class VideoFeedConfigure implements Parcelable {
    public static final a CREATOR = null;
    public long A;
    public long B;
    public int a;
    public boolean b;
    public boolean c;
    public JSONObject d;
    public JSONObject e;
    public EnterVideoMethod f;
    public JSONObject g;
    public List<String> h;
    public String i;
    public boolean j;
    public boolean k;
    public boolean l;
    public float m;
    public int n;
    public int o;
    public int p;
    public long q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public int z;

    public static final class a implements Parcelable.Creator<VideoFeedConfigure> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoFeedConfigure createFromParcel(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            Intrinsics.checkNotNullParameter(r7, "parcel");
            VideoFeedConfigure r1 = new VideoFeedConfigure();
            r1.f = (EnterVideoMethod) r7.readParcelable(EnterVideoMethod.class.getClassLoader());
            ArrayList r0 = new ArrayList();
            r7.readStringList(r0);
            r1.h = r0;
            boolean r2 = true;
            if (r7.readByte() == 0) goto L5;
            boolean r3 = true;
        L6:
            r1.j = r3;
            if (r7.readByte() == 0) goto L9;
            boolean r4 = true;
        L10:
            r1.k = r4;
            if (r7.readByte() == 0) goto L13;
            boolean r5 = true;
        L14:
            r1.v = r5;
            if (r7.readByte() == 0) goto L17;
            boolean r6 = true;
        L18:
            r1.w = r6;
            r1.x = r7.readString();
            r1.y = r7.readString();
            r1.i = r7.readString();
            if (r7.readByte() == 0) goto L21;
            boolean r8 = true;
        L22:
            r1.s = r8;
            if (r7.readByte() == 0) goto L25;
            boolean r9 = true;
        L26:
            r1.t = r9;
            if (r7.readByte() == 0) goto L29;
            boolean r10 = true;
        L30:
            r1.u = r10;
            String r11 = r7.readString();
            String r12 = "";
            if (r11 != null) goto L33;
            r11 = "";
        L33:
            r1.d = new JSONObject(r11);
            String r13 = r7.readString();
            if (r13 == null) goto L37;
            r12 = r13;
        L37:
            r1.e = new JSONObject(r12);
            if (r7.readByte() == 0) goto L40;
            boolean r14 = true;
        L41:
            r1.l = r14;
            r1.z = r7.readInt();
            r1.a = r7.readInt();
            r1.r = r7.readString();
            r1.m = r7.readFloat();
            r1.q = r7.readLong();
            r1.o = r7.readInt();
            r1.n = r7.readInt();
            r1.p = r7.readInt();
            r1.A = r7.readLong();
            if (r7.readByte() == 0) goto L44;
            boolean r15 = true;
        L45:
            r1.b = r15;
            if (r7.readByte() != 0) goto L49;
            r2 = false;
        L49:
            r1.c = r2;
            r1.B = r7.readLong();
            return r1;
        L44:
            r15 = false;
            goto L45
        L40:
            r14 = false;
            goto L41
        L29:
            r10 = false;
            goto L30
        L25:
            r9 = false;
            goto L26
        L21:
            r8 = false;
            goto L22
        L17:
            r6 = false;
            goto L18
        L13:
            r5 = false;
            goto L14
        L9:
            r4 = false;
            goto L10
        L5:
            r3 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final VideoFeedConfigure[] newArray(int r1) {
            return new VideoFeedConfigure[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public VideoFeedConfigure() {
        this.a = -1;
        this.b = true;
        this.d = new JSONObject();
        this.e = new JSONObject();
        this.f = EnterVideoMethod.MAIN_DOUBLE_TAG;
        this.g = new JSONObject();
        this.h = CollectionsKt.emptyList();
        this.i = "";
        this.j = true;
        this.k = true;
        this.l = true;
        this.q = 300;
        this.t = true;
        this.v = true;
        this.w = true;
        this.x = "";
        this.y = "";
        this.A = -1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeParcelable(this.f, r4);
        r3.writeStringList(this.h);
        r3.writeByte(this.j ? 1 : 0);
        r3.writeByte(this.k ? 1 : 0);
        r3.writeByte(this.v ? 1 : 0);
        r3.writeByte(this.w ? 1 : 0);
        r3.writeString(this.x);
        r3.writeString(this.y);
        r3.writeString(this.i);
        r3.writeByte(this.s ? 1 : 0);
        r3.writeByte(this.t ? 1 : 0);
        r3.writeByte(this.u ? 1 : 0);
        r3.writeString(this.d.toString());
        r3.writeString(this.e.toString());
        r3.writeByte(this.l ? 1 : 0);
        r3.writeInt(this.z);
        r3.writeInt(this.a);
        r3.writeString(this.r);
        r3.writeFloat(this.m);
        r3.writeLong(this.q);
        r3.writeInt(this.o);
        r3.writeInt(this.n);
        r3.writeInt(this.p);
        r3.writeLong(this.A);
        r3.writeByte(this.b ? 1 : 0);
        r3.writeByte(this.c ? 1 : 0);
        r3.writeLong(this.B);
    }
}
