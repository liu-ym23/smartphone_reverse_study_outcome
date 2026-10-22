package com.bytedance.android.livesdk.interactivity.api.barrage.data;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001yB\u0007¢\u0006\u0004\bw\u0010xR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR$\u00100\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R$\u00103\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\"\u00107\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001e\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R\"\u0010@\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u000b\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR\"\u0010C\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R$\u0010F\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u001e\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\"\u0010I\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\u000b\u001a\u0004\bJ\u0010\r\"\u0004\bK\u0010\u000fR*\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR0\u0010W\u001a\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020V\u0018\u00010T8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010]\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b^\u0010Q\"\u0004\b_\u0010SR\"\u0010`\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u000b\u001a\u0004\ba\u0010\r\"\u0004\bb\u0010\u000fR\"\u0010c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u000b\u001a\u0004\bd\u0010\r\"\u0004\be\u0010\u000fR$\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR0\u0010m\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010T8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bm\u0010X\u001a\u0004\bn\u0010Z\"\u0004\bo\u0010\\R$\u0010q\u001a\u0004\u0018\u00010p8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010v¨\u0006z"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/j;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "Lcom/bytedance/android/live/base/model/message/m0;", "commonData", "Lcom/bytedance/android/live/base/model/message/m0;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", BuildConfig.FLAVOR, "seqId", "J", "z", "()J", "setSeqId", "(J)V", "userStartTimestamp", "E", "setUserStartTimestamp", "userStartSecond", "getUserStartSecond", "setUserStartSecond", "duration", "getDuration", "setDuration", "minDuration", "w", "setMinDuration", BuildConfig.FLAVOR, "trayBackgroundColor", "Ljava/lang/String;", "getTrayBackgroundColor", "()Ljava/lang/String;", "setTrayBackgroundColor", "(Ljava/lang/String;)V", "trayWordColor", "getTrayWordColor", "setTrayWordColor", "Lpy/k;", "titleImage", "Lpy/k;", "D", "()Lpy/k;", "setTitleImage", "(Lpy/k;)V", "showWebp", "A", "setShowWebp", "preContent", "getPreContent", "setPreContent", "content", "getContent", "setContent", BuildConfig.FLAVOR, "supportCountDown", "Z", "C", "()Z", "setSupportCountDown", "(Z)V", "countDownContent", "r", "setCountDownContent", "countDownDuration", "s", "setCountDownDuration", "canJump", "p", "setCanJump", "schema", sz1.a.KEY_Y, "setSchema", "moveSpeed", sz1.a.KEY_X, "setMoveSpeed", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/c;", "eggItems", "Ljava/util/List;", "u", "()Ljava/util/List;", "setEggItems", "(Ljava/util/List;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/b;", "danmakuStyleMap", "Ljava/util/Map;", "t", "()Ljava/util/Map;", "setDanmakuStyleMap", "(Ljava/util/Map;)V", "eggShowRange", "v", "setEggShowRange", "usePrivilegeRegion", "getUsePrivilegeRegion", "setUsePrivilegeRegion", "canOpenContour", "q", "setCanOpenContour", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/l;", "specialDanmakuPlay", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/l;", "B", "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/l;", "setSpecialDanmakuPlay", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/data/l;)V", "remoteExtraInfo", "f", "setRemoteExtraInfo", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "highlightAreaPriorityConfig", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "<init>", "()V", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j implements com.bytedance.android.livesdk.interactivity.api.barrage.model.a, vh7.h {

    @SerializedName("can_jump")
    protected boolean canJump;

    @SerializedName("can_open_contour")
    protected long canOpenContour;

    @SerializedName("common")
    protected m0 commonData;

    @SerializedName("content")
    protected String content;

    @SerializedName("exit_content")
    protected String countDownContent;

    @SerializedName("exit_countdown_duration")
    protected long countDownDuration;

    @SerializedName("danmaku_style_map")
    protected Map<Integer, b> danmakuStyleMap;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("egg_style")
    protected List<c> eggItems;

    @SerializedName("egg_show_range")
    protected List<Long> eggShowRange;

    @SerializedName("highlight_area_priority_config")
    protected HighlightAreaPriorityConfig highlightAreaPriorityConfig;

    @SerializedName("min_remaining_duration")
    protected long minDuration;

    @SerializedName("move_speed")
    protected long moveSpeed;

    @SerializedName("pre_content")
    protected String preContent;

    @SerializedName("extra")
    protected Map<String, String> remoteExtraInfo;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("seq_id")
    protected long seqId;

    @SerializedName("show_webp")
    protected long showWebp;

    @SerializedName("special_danmaku_play")
    protected l specialDanmakuPlay;

    @SerializedName("countdown_exit")
    protected boolean supportCountDown;

    @SerializedName("title_image")
    protected py.k titleImage;

    @SerializedName("background_color")
    protected String trayBackgroundColor;

    @SerializedName("word_color")
    protected String trayWordColor;

    @SerializedName("use_privilege_region")
    protected long usePrivilegeRegion;

    @SerializedName("user_start_milliseconds")
    protected long userStartSecond;

    @SerializedName("user_start_timestamp_milliseconds")
    protected long userStartTimestamp;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final boolean a() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long h() {
        return 2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long j() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long k() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long getMessageId() {
        m0 r0 = this.commonData;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getMessageId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long n() {
        long r0 = this.userStartTimestamp;
        if (r0 != 0) goto L6;
        return this.duration;
    L6:
        return (r0 + this.duration) - (com.bytedance.android.livesdk.utils.ntp.a.a + System.currentTimeMillis());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final boolean o() {
        if (this.canOpenContour != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public j() {
        this.trayWordColor = "#FFFFFF";
    }

    public final long A() {
        return this.showWebp;
    }

    public final l B() {
        return this.specialDanmakuPlay;
    }

    public final boolean C() {
        return this.supportCountDown;
    }

    public final py.k D() {
        return this.titleImage;
    }

    public final long E() {
        return this.userStartTimestamp;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String b() {
        return this.trayBackgroundColor;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long c() {
        return this.showWebp;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long d() {
        return this.usePrivilegeRegion;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final py.k e() {
        return this.titleImage;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final Map<String, String> f() {
        return this.remoteExtraInfo;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final long g() {
        return this.moveSpeed;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final HighlightAreaPriorityConfig getHighlightAreaPriorityConfig() {
        return this.highlightAreaPriorityConfig;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String i() {
        return this.preContent;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String l() {
        return this.trayWordColor;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.barrage.model.a
    public final String m() {
        return this.content;
    }

    public final boolean p() {
        return this.canJump;
    }

    public final long q() {
        return this.canOpenContour;
    }

    public final String r() {
        return this.countDownContent;
    }

    public final long s() {
        return this.countDownDuration;
    }

    public final Map<Integer, b> t() {
        return this.danmakuStyleMap;
    }

    public final List<c> u() {
        return this.eggItems;
    }

    public final List<Long> v() {
        return this.eggShowRange;
    }

    public final long w() {
        return this.minDuration;
    }

    public final long x() {
        return this.moveSpeed;
    }

    public final String y() {
        return this.schema;
    }

    public final long z() {
        return this.seqId;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.m0, java.lang.Object] */
    public j(am3.g r13) {
        this.eggItems = new ArrayList();
        this.danmakuStyleMap = new HashMap();
        this.eggShowRange = new ArrayList();
        this.remoteExtraInfo = new HashMap();
        long r0 = r13.c();
    L3:
        int r2 = r13.f();
        if (r2 == (-1)) goto L65;
        Object r8 = null;
        switch(r2) {
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L31;
            case 20: goto L30;
            case 21: goto L28;
            case 22: goto L27;
            case 23: goto L26;
            case 24: goto L25;
            case 25: goto L9;
            case 26: goto L8;
            default: goto L7;
        };
    L8:
        this.highlightAreaPriorityConfig = new HighlightAreaPriorityConfig(r13);
        goto L3
    L9:
        long r9 = r13.c();
        Object r3 = null;
    L10:
        int r11 = r13.f();
        if (r11 == (-1)) goto L17;
        if (r11 != 1) goto L13;
        r8 = am3.h.c(r13);
        goto L10
    L13:
        if (r11 != 2) goto L14;
        r3 = am3.h.c(r13);
        goto L10
    L14:
        am3.h.e(r13);
        goto L10
    L17:
        r13.d(r9);
        Map r4 = this.remoteExtraInfo;
        if (r8 == null) goto L24;
        if (r3 == null) goto L22;
    L42:
        r4.put(r8, r3);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.specialDanmakuPlay = new l(r13);
        goto L3
    L26:
        this.canOpenContour = r13.j();
        goto L3
    L27:
        List r5 = this.eggShowRange;
        vh7.h r6 = Long.valueOf(r13.j());
    L29:
        r5.add(r6);
        goto L3
    L28:
        r5 = this.eggItems;
        r6 = new c(r13);
        goto L29
    L30:
        this.usePrivilegeRegion = r13.j();
        goto L3
    L31:
        long r10 = r13.c();
        r3 = null;
    L32:
        int r14 = r13.f();
        if (r14 == (-1)) goto L39;
        if (r14 != 1) goto L35;
        r8 = Integer.valueOf(r13.i());
        goto L32
    L35:
        if (r14 != 2) goto L36;
        r3 = new b(r13);
        goto L32
    L36:
        am3.h.e(r13);
        goto L32
    L39:
        r13.d(r10);
        r4 = this.danmakuStyleMap;
        if (r8 == null) goto L46;
        if (r3 != null) goto L42;
        throw new IllegalStateException("Value must not be null");
    L46:
        throw new IllegalStateException("Key must not be null");
    L47:
        this.moveSpeed = r13.j();
        goto L3
    L48:
        this.schema = am3.h.c(r13);
        goto L3
    L49:
        this.canJump = am3.h.a(r13);
        goto L3
    L50:
        this.countDownDuration = r13.j();
        goto L3
    L51:
        this.countDownContent = am3.h.c(r13);
        goto L3
    L52:
        this.supportCountDown = am3.h.a(r13);
        goto L3
    L53:
        this.content = am3.h.c(r13);
        goto L3
    L54:
        this.preContent = am3.h.c(r13);
        goto L3
    L55:
        this.showWebp = r13.j();
        goto L3
    L56:
        this.titleImage = vh7.f.a(r13, py.k.class);
        goto L3
    L57:
        this.trayWordColor = am3.h.c(r13);
        goto L3
    L58:
        this.trayBackgroundColor = am3.h.c(r13);
        goto L3
    L59:
        this.minDuration = r13.j();
        goto L3
    L60:
        this.duration = r13.j();
        goto L3
    L61:
        this.userStartSecond = r13.j();
        goto L3
    L62:
        this.userStartTimestamp = r13.j();
        goto L3
    L63:
        this.seqId = r13.j();
        goto L3
    L64:
        this.commonData = vh7.f.a(r13, m0.class);
        goto L3
    L7:
        am3.h.e(r13);
        goto L3
    L65:
        r13.d(r0);
        if (this.trayWordColor != null) goto L145;
        this.trayWordColor = "#FFFFFF";
        return;
    }
}
