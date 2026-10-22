package com.larus.platform.uimodel;

import android.os.Bundle;
import com.larus.platform.api.FirstFramePreloadVideoData;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.tencent.open.log.TraceLevel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoParam {
    public final String A;
    public final String B;
    public final String C;
    public final Integer D;
    public final Integer E;
    public final ArrayList<String> F;
    public final Integer G;
    public final String H;
    public final String I;
    public final String J;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final ArrayList<String> O;
    public final Boolean P;
    public final String Q;
    public final FirstFramePreloadVideoData R;
    public final PrefetchRecommendVideoParam S;
    public final boolean T;
    public final long U;
    public final Bundle V;
    public final JSONObject W;
    public final ArrayList<MediaEntity> a;
    public final MediaEntityContainer b;
    public final Integer c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final String i;
    public final String j;
    public final String k;
    public final Map<String, Object> l;
    public final JSONObject m;
    public final int n;
    public final int o;
    public final VideoPlayerType p;
    public final boolean q;
    public final String r;
    public final String s;
    public final String t;
    public final RecommendType u;
    public final boolean v;
    public final Integer w;
    public final ArrayList<String> x;
    public final String y;
    public final String z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/uimodel/VideoParam$RecommendType;", "", "<init>", "(Ljava/lang/String;I)V", "Non", "Search", "AwemeFeed", "PoiFeed", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum RecommendType extends Enum<RecommendType> {
        public static final RecommendType AwemeFeed = null;
        public static final RecommendType Non = null;
        public static final RecommendType PoiFeed = null;
        public static final RecommendType Search = null;
        public static final /* synthetic */ RecommendType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<RecommendType> getEntries() {
            return b;
        }

        static {
            RecommendType r0 = new RecommendType("Non", 0);
            Non = r0;
            RecommendType r1 = new RecommendType("Search", 1);
            Search = r1;
            RecommendType r3 = new RecommendType("AwemeFeed", 2);
            AwemeFeed = r3;
            RecommendType r5 = new RecommendType("PoiFeed", 3);
            PoiFeed = r5;
            RecommendType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static RecommendType[] values() {
            return (RecommendType[]) a.clone();
        }

        public static RecommendType valueOf(String r1) {
            return (RecommendType) a.a(RecommendType.class, r1);
        }

        public RecommendType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/uimodel/VideoParam$UgcVideoScene;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UgcVideoScene {
        public static final a Companion = null;
        public static final int DEFAULT = 0;
        public static final int UGC_LIMIT = 1;
        public static final int UGC_UN_LIMIT = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/uimodel/VideoParam$VideoPlayerType;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO_ACTIVITY", "DOUYIN_VIDEO_ACTIVITY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum VideoPlayerType extends Enum<VideoPlayerType> {
        public static final VideoPlayerType DOUYIN_VIDEO_ACTIVITY = null;
        public static final VideoPlayerType VIDEO_ACTIVITY = null;
        public static final /* synthetic */ VideoPlayerType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<VideoPlayerType> getEntries() {
            return b;
        }

        static {
            VideoPlayerType r0 = new VideoPlayerType("VIDEO_ACTIVITY", 0);
            VIDEO_ACTIVITY = r0;
            VideoPlayerType r1 = new VideoPlayerType("DOUYIN_VIDEO_ACTIVITY", 1);
            DOUYIN_VIDEO_ACTIVITY = r1;
            VideoPlayerType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static VideoPlayerType[] values() {
            return (VideoPlayerType[]) a.clone();
        }

        public static VideoPlayerType valueOf(String r1) {
            return (VideoPlayerType) a.a(VideoPlayerType.class, r1);
        }

        public VideoPlayerType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public VideoParam() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, null, 0, 0, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, -1, 131071);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof VideoParam) == true) goto L8;
        return false;
    L8:
        VideoParam r9 = (VideoParam) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (this.q == r9.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r9.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r9.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r9.t) == true) goto L69;
        return false;
    L69:
        if (this.u == r9.u) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r9.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r9.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r9.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r9.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r9.D) == true) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r9.E) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.F, r9.F) == true) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r9.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r9.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r9.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.J, r9.J) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r9.K) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.L, r9.L) == true) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r9.M) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.N, r9.N) == true) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.O, r9.O) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.P, r9.P) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.Q, r9.Q) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.R, r9.R) == true) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.S, r9.S) == true) goto L144;
        return false;
    L144:
        if (this.T == r9.T) goto L147;
        return false;
    L147:
        if (this.U == r9.U) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.V, r9.V) == true) goto L153;
        return false;
    L153:
        if (Intrinsics.areEqual(this.W, r9.W) == true) goto L155;
        return false;
    L155:
        return true;
    }

    public final int hashCode() {
        ArrayList<MediaEntity> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        MediaEntityContainer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((((((((((r18 + r20) * 31) + this.h) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        JSONObject r22 = this.m;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (((((r21 + r23) * 31) + this.n) * 31) + this.o) * 31;
        VideoPlayerType r25 = this.p;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        int r28 = 1231;
        if (this.q == false) goto L41;
        int r29 = 1231;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.r;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.s;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.t;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (((r36 + r38) * 31) + this.u.hashCode()) * 31;
        if (this.v == false) goto L57;
        int r40 = 1231;
    L58:
        int r41 = (r39 + r40) * 31;
        Integer r42 = this.w;
        if (r42 != null) goto L61;
        int r43 = 0;
    L62:
        int r44 = (r41 + r43) * 31;
        ArrayList<String> r45 = this.x;
        if (r45 != null) goto L65;
        int r46 = 0;
    L66:
        int r47 = (r44 + r46) * 31;
        String r48 = this.y;
        if (r48 != null) goto L69;
        int r49 = 0;
    L70:
        int r50 = (r47 + r49) * 31;
        String r51 = this.z;
        if (r51 != null) goto L73;
        int r52 = 0;
    L74:
        int r53 = (r50 + r52) * 31;
        String r54 = this.A;
        if (r54 != null) goto L77;
        int r55 = 0;
    L78:
        int r56 = (r53 + r55) * 31;
        String r57 = this.B;
        if (r57 != null) goto L81;
        int r58 = 0;
    L82:
        int r59 = (r56 + r58) * 31;
        String r60 = this.C;
        if (r60 != null) goto L85;
        int r61 = 0;
    L86:
        int r62 = (r59 + r61) * 31;
        Integer r63 = this.D;
        if (r63 != null) goto L89;
        int r64 = 0;
    L90:
        int r65 = (r62 + r64) * 31;
        Integer r66 = this.E;
        if (r66 != null) goto L93;
        int r67 = 0;
    L94:
        int r68 = (r65 + r67) * 31;
        ArrayList<String> r69 = this.F;
        if (r69 != null) goto L97;
        int r70 = 0;
    L98:
        int r71 = (r68 + r70) * 31;
        Integer r72 = this.G;
        if (r72 != null) goto L101;
        int r73 = 0;
    L102:
        int r74 = (r71 + r73) * 31;
        String r75 = this.H;
        if (r75 != null) goto L105;
        int r76 = 0;
    L106:
        int r77 = (r74 + r76) * 31;
        String r78 = this.I;
        if (r78 != null) goto L109;
        int r79 = 0;
    L110:
        int r80 = (r77 + r79) * 31;
        String r81 = this.J;
        if (r81 != null) goto L113;
        int r82 = 0;
    L114:
        int r83 = (r80 + r82) * 31;
        String r84 = this.K;
        if (r84 != null) goto L117;
        int r85 = 0;
    L118:
        int r86 = (r83 + r85) * 31;
        String r87 = this.L;
        if (r87 != null) goto L121;
        int r88 = 0;
    L122:
        int r89 = (r86 + r88) * 31;
        String r90 = this.M;
        if (r90 != null) goto L125;
        int r91 = 0;
    L126:
        int r92 = (r89 + r91) * 31;
        String r93 = this.N;
        if (r93 != null) goto L129;
        int r94 = 0;
    L130:
        int r95 = (r92 + r94) * 31;
        ArrayList<String> r96 = this.O;
        if (r96 != null) goto L133;
        int r97 = 0;
    L134:
        int r98 = (r95 + r97) * 31;
        Boolean r99 = this.P;
        if (r99 != null) goto L137;
        int r100 = 0;
    L138:
        int r101 = (r98 + r100) * 31;
        String r102 = this.Q;
        if (r102 != null) goto L141;
        int r103 = 0;
    L142:
        int r104 = (r101 + r103) * 31;
        FirstFramePreloadVideoData r105 = this.R;
        if (r105 != null) goto L145;
        int r106 = 0;
    L146:
        int r107 = (r104 + r106) * 31;
        PrefetchRecommendVideoParam r108 = this.S;
        if (r108 != null) goto L149;
        int r109 = 0;
    L150:
        int r110 = (r107 + r109) * 31;
        if (this.T == true) goto L154;
        r28 = 1237;
    L154:
        long r111 = this.U;
        int r112 = (((r110 + r28) * 31) + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        Bundle r113 = this.V;
        if (r113 != null) goto L157;
        int r114 = 0;
    L158:
        int r115 = (r112 + r114) * 31;
        JSONObject r116 = this.W;
        if (r116 == null) goto L163;
        r1 = r116.hashCode();
    L163:
        return r115 + r1;
    L157:
        r114 = r113.hashCode();
        goto L158
    L149:
        r109 = r108.hashCode();
        goto L150
    L145:
        r106 = r105.hashCode();
        goto L146
    L141:
        r103 = r102.hashCode();
        goto L142
    L137:
        r100 = r99.hashCode();
        goto L138
    L133:
        r97 = r96.hashCode();
        goto L134
    L129:
        r94 = r93.hashCode();
        goto L130
    L125:
        r91 = r90.hashCode();
        goto L126
    L121:
        r88 = r87.hashCode();
        goto L122
    L117:
        r85 = r84.hashCode();
        goto L118
    L113:
        r82 = r81.hashCode();
        goto L114
    L109:
        r79 = r78.hashCode();
        goto L110
    L105:
        r76 = r75.hashCode();
        goto L106
    L101:
        r73 = r72.hashCode();
        goto L102
    L97:
        r70 = r69.hashCode();
        goto L98
    L93:
        r67 = r66.hashCode();
        goto L94
    L89:
        r64 = r63.hashCode();
        goto L90
    L85:
        r61 = r60.hashCode();
        goto L86
    L81:
        r58 = r57.hashCode();
        goto L82
    L77:
        r55 = r54.hashCode();
        goto L78
    L73:
        r52 = r51.hashCode();
        goto L74
    L69:
        r49 = r48.hashCode();
        goto L70
    L65:
        r46 = r45.hashCode();
        goto L66
    L61:
        r43 = r42.hashCode();
        goto L62
    L57:
        r40 = 1237;
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = 1237;
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoParam(item=" + this.a + ", container=" + this.b + ", soruceFrom=" + this.c + ", botId=" + this.d + ", messageId=" + this.e + ", conversationId=" + this.f + ", messageErrorMsg=" + this.g + ", videoIndex=" + this.h + ", enterVideoType=" + this.i + ", videoCoverUrl=" + this.j + ", sceneId=" + this.k + ", trackHashMap=" + this.l + ", leaveTraceInfo=" + this.m + ", videoHeight=" + this.n + ", videoWidth=" + this.o + ", videoPlayerType=" + this.p + ", newApi=" + this.q + ", sectionId=" + this.r + ", reqId=" + this.s + ", chatType=" + this.t + ", recommendType=" + this.u + ", keepAllOuterAidWhenRecommend=" + this.v + ", ugcVideoScene=" + this.w + ", query=" + this.x + ", replyId=" + this.y + ", lastMessageId=" + this.z + ", enterFrom=" + this.A + ", enterFromGroupId=" + this.B + ", agentId=" + this.C + ", imprIndex=" + this.D + ", rank=" + this.E + ", replyItemIds=" + this.F + ", streamIndex=" + this.G + ", channelId=" + this.H + ", slideMode=" + this.I + ", cardPosition=" + this.J + ", cardSubPosition=" + this.K + ", richMediaType=" + this.L + ", moduleSource=" + this.M + ", modulePosition=" + this.N + ", extraItemIdList=" + this.O + ", needLoadMore=" + this.P + ", searchId=" + this.Q + ", firstFramePreloadVideoData=" + this.R + ", preloadParam=" + this.S + ", forcePreloadRecommend=" + this.T + ", startPlayPosition=" + this.U + ", extraBundle=" + this.V + ", hostTrackParams=" + this.W + ')';
    }

    public VideoParam(ArrayList r49, MediaEntityContainer r50, Integer r51, String r52, String r53, String r54, String r55, int r56, String r57, String r58, String r59, Map r60, JSONObject r61, int r62, int r63, VideoPlayerType r64, boolean r65, String r66, String r67, String r68, RecommendType r69, boolean r70, Integer r71, ArrayList r72, String r73, String r74, String r75, String r76, String r77, Integer r78, Integer r79, ArrayList r80, Integer r81, String r82, String r83, String r84, String r85, String r86, String r87, String r88, ArrayList r89, String r90, FirstFramePreloadVideoData r91, PrefetchRecommendVideoParam r92, boolean r93, long r94, Bundle r96, JSONObject r97, int r98, int r99) {
        if ((r98 & 1) == 0) goto L5;
        ArrayList r3 = new ArrayList();
    L7:
        if ((r98 & 2) == 0) goto L9;
        MediaEntityContainer r4 = new MediaEntityContainer(null, null, null, null, false, 0, 0, null, 255, null);
    L11:
        if ((r98 & 4) == 0) goto L13;
        Integer r5 = 0;
    L15:
        if ((r98 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r98 & 16) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r98 & 32) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r98 & 64) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r98 & 128) == 0) goto L33;
        int r12 = 0;
    L35:
        if ((r98 & 256) == 0) goto L37;
        String r13 = "";
    L39:
        if ((r98 & 512) == 0) goto L41;
        String r14 = "";
    L43:
        if ((r98 & 1024) == 0) goto L45;
        String r15 = "";
    L47:
        if ((r98 & 2048) == 0) goto L49;
        Map r6 = new LinkedHashMap();
    L50:
        int r510 = r12;
        if ((r98 & 4096) == 0) goto L53;
        JSONObject r8 = null;
    L55:
        if ((r98 & 8192) == 0) goto L57;
        int r16 = 10;
    L58:
        int r511 = r16;
        if ((r98 & 16384) == 0) goto L61;
        int r17 = 10;
    L63:
        if ((r98 & 32768) == 0) goto L65;
        VideoPlayerType r18 = null;
    L67:
        if ((r98 & 65536) == 0) goto L69;
        boolean r20 = false;
    L71:
        if ((r98 & 131072) == 0) goto L73;
        String r21 = "";
    L75:
        if ((r98 & 262144) == 0) goto L77;
        String r22 = "";
    L79:
        if ((r98 & 524288) == 0) goto L81;
        String r23 = "";
    L83:
        if ((r98 & 1048576) == 0) goto L85;
        RecommendType r19 = RecommendType.Non;
    L87:
        if ((r98 & 2097152) == 0) goto L89;
        boolean r25 = false;
    L91:
        if ((r98 & 4194304) == 0) goto L93;
        Integer r27 = 0;
    L95:
        if ((r98 & 8388608) == 0) goto L97;
        ArrayList r28 = new ArrayList();
    L99:
        if ((r98 & 16777216) == 0) goto L101;
        String r29 = "";
    L103:
        if ((r98 & 33554432) == 0) goto L105;
        String r30 = "";
    L107:
        if ((r98 & 67108864) == 0) goto L109;
        String r31 = "";
    L111:
        if ((r98 & 134217728) == 0) goto L113;
        String r32 = "";
    L115:
        if ((r98 & 268435456) == 0) goto L117;
        String r33 = "";
    L119:
        if ((r98 & 536870912) == 0) goto L121;
        Integer r34 = null;
    L123:
        if ((r98 & 1073741824) == 0) goto L125;
        Integer r35 = null;
    L127:
        if ((r98 & Integer.MIN_VALUE) == 0) goto L129;
        ArrayList r1 = null;
    L131:
        if ((r99 & 1) == 0) goto L133;
        Integer r36 = null;
    L135:
        if ((r99 & 2) == 0) goto L137;
        String r37 = null;
    L139:
        if ((r99 & 4) == 0) goto L141;
        String r38 = "";
    L143:
        if ((r99 & 8) == 0) goto L145;
        String r39 = "";
    L147:
        if ((r99 & 16) == 0) goto L149;
        String r40 = "";
    L151:
        if ((r99 & 32) == 0) goto L153;
        String r41 = "";
    L155:
        if ((r99 & 64) == 0) goto L157;
        String r42 = "";
    L158:
        ArrayList r26 = r1;
        if ((r99 & 128) == 0) goto L161;
        String r2 = "";
    L162:
        String r410 = r2;
        if ((r99 & 256) == 0) goto L165;
        ArrayList r24 = null;
    L166:
        ArrayList r512 = r24;
        if ((r99 & 1024) == 0) goto L169;
        String r43 = "";
    L170:
        String r513 = r43;
        if ((r99 & 2048) == 0) goto L173;
        FirstFramePreloadVideoData r44 = null;
    L174:
        FirstFramePreloadVideoData r514 = r44;
        if ((r99 & 4096) == 0) goto L177;
        PrefetchRecommendVideoParam r45 = null;
    L178:
        PrefetchRecommendVideoParam r515 = r45;
        if ((r99 & 8192) == 0) goto L181;
        boolean r46 = false;
    L182:
        boolean r210 = r46;
        if ((r99 & 16384) == 0) goto L185;
        long r47 = 0;
    L187:
        if ((r99 & 32768) == 0) goto L189;
        Bundle r48 = null;
    L191:
        if ((r99 & 65536) == 0) goto L193;
        JSONObject r110 = null;
    L194:
        Intrinsics.checkNotNullParameter(r13, "enterVideoType");
        Intrinsics.checkNotNullParameter(r14, "videoCoverUrl");
        Intrinsics.checkNotNullParameter(r15, "sceneId");
        Intrinsics.checkNotNullParameter(r6, "trackHashMap");
        Intrinsics.checkNotNullParameter(r19, "recommendType");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r510;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r6;
        this.m = r8;
        this.n = r511;
        this.o = r17;
        this.p = r18;
        this.q = r20;
        this.r = r21;
        this.s = r22;
        this.t = r23;
        this.u = r19;
        this.v = r25;
        this.w = r27;
        this.x = r28;
        this.y = r29;
        this.z = r30;
        this.A = r31;
        this.B = r32;
        this.C = r33;
        this.D = r34;
        this.E = r35;
        this.F = r26;
        this.G = r36;
        this.H = r37;
        this.I = r38;
        this.J = r39;
        this.K = r40;
        this.L = r41;
        this.M = r42;
        this.N = r410;
        this.O = r512;
        this.P = null;
        this.Q = r513;
        this.R = r514;
        this.S = r515;
        this.T = r210;
        this.U = r47;
        this.V = r48;
        this.W = r110;
        return;
    L193:
        r110 = r97;
        goto L194
    L189:
        r48 = r96;
        goto L191
    L185:
        r47 = r94;
        goto L187
    L181:
        r46 = r93;
        goto L182
    L177:
        r45 = r92;
        goto L178
    L173:
        r44 = r91;
        goto L174
    L169:
        r43 = r90;
        goto L170
    L165:
        r24 = r89;
        goto L166
    L161:
        r2 = r88;
        goto L162
    L157:
        r42 = r87;
        goto L158
    L153:
        r41 = r86;
        goto L155
    L149:
        r40 = r85;
        goto L151
    L145:
        r39 = r84;
        goto L147
    L141:
        r38 = r83;
        goto L143
    L137:
        r37 = r82;
        goto L139
    L133:
        r36 = r81;
        goto L135
    L129:
        r1 = r80;
        goto L131
    L125:
        r35 = r79;
        goto L127
    L121:
        r34 = r78;
        goto L123
    L117:
        r33 = r77;
        goto L119
    L113:
        r32 = r76;
        goto L115
    L109:
        r31 = r75;
        goto L111
    L105:
        r30 = r74;
        goto L107
    L101:
        r29 = r73;
        goto L103
    L97:
        r28 = r72;
        goto L99
    L93:
        r27 = r71;
        goto L95
    L89:
        r25 = r70;
        goto L91
    L85:
        r19 = r69;
        goto L87
    L81:
        r23 = r68;
        goto L83
    L77:
        r22 = r67;
        goto L79
    L73:
        r21 = r66;
        goto L75
    L69:
        r20 = r65;
        goto L71
    L65:
        r18 = r64;
        goto L67
    L61:
        r17 = r63;
        goto L63
    L57:
        r16 = r62;
        goto L58
    L53:
        r8 = r61;
        goto L55
    L49:
        r6 = r60;
        goto L50
    L45:
        r15 = r59;
        goto L47
    L41:
        r14 = r58;
        goto L43
    L37:
        r13 = r57;
        goto L39
    L33:
        r12 = r56;
        goto L35
    L29:
        r11 = r55;
        goto L31
    L25:
        r10 = r54;
        goto L27
    L21:
        r9 = r53;
        goto L23
    L17:
        r7 = r52;
        goto L19
    L13:
        r5 = r51;
        goto L15
    L9:
        r4 = r50;
        goto L11
    L5:
        r3 = r49;
        goto L7
    }
}
