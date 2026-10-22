package com.bytedance.android.live.schema.vo;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b1\b\u0007\u0018\u00002\u00020\u0001:\u0001FR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u000e\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR$\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0018\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001bR$\u00104\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0018\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001bR$\u00107\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0018\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001bR$\u0010:\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0018\u001a\u0004\b;\u0010\u001a\"\u0004\b<\u0010\u001bR\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\"\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR$\u0010C\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001a\u0004\bD\u0010\u001a\"\u0004\bE\u0010\u001b¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/schema/vo/BaseHybridParamVo;", "Landroid/os/Parcelable;", "", "hideStatusBar", "Z", "e", "()Z", "F", "(Z)V", "pullDownClose", "h", "J", "", "pullDownHeight", "I", "getPullDownHeight", "()I", "K", "(I)V", "pullDownIndicatorNotShow", "i", "L", "", "indicatorColor", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "hidePoster", "getHidePoster", "E", "showClose", "k", "N", "showBack", "j", "M", "enableShare", "a", "setEnableShare", "forbidRightBack", "b", "setForbidRightBack", "hideNavBar", "d", "setHideNavBar", "transStatusBar", "t", "setTransStatusBar", "statusBarColor", "q", "R", "statusBarBgColor", "o", "O", "title", "s", "setTitle", "webBgColor", "D", "setWebBgColor", "hideLoading", "c", "setHideLoading", "supportExchangeTheme", "r", "setSupportExchangeTheme", "url", "z", "S", "HybridType", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseHybridParamVo implements Parcelable {
    public static final Parcelable.Creator<BaseHybridParamVo> CREATOR = null;
    public HybridType a;
    public String b;
    public String c;
    public Integer d;
    public final boolean e;

    @SerializedName("enable_share")
    private boolean enableShare;
    public final String f;

    @SerializedName("forbid_right_back")
    private boolean forbidRightBack;
    public boolean g;
    public final boolean h;

    @SerializedName("hide_loading")
    private boolean hideLoading;

    @SerializedName("hide_nav_bar")
    private boolean hideNavBar;

    @SerializedName("hide_poster")
    private boolean hidePoster;

    @SerializedName("hide_status_bar")
    private boolean hideStatusBar;
    public boolean i;

    @SerializedName("pull_down_indicator_color")
    private String indicatorColor;
    public final Boolean j;
    public final String k;
    public int l;
    public final int m;
    public final String n;
    public String o;

    @SerializedName("pull_down_close")
    private boolean pullDownClose;

    @SerializedName("pull_down_height")
    private int pullDownHeight;

    @SerializedName("pull_down_indicator_not_show")
    private boolean pullDownIndicatorNotShow;

    @SerializedName("show_back")
    private boolean showBack;

    @SerializedName("show_close")
    private boolean showClose;

    @SerializedName("status_bar_bg_color")
    private String statusBarBgColor;

    @SerializedName("status_bar_color")
    private String statusBarColor;

    @SerializedName("support_exchange_theme")
    private boolean supportExchangeTheme;

    @SerializedName("title")
    private String title;

    @SerializedName("trans_status_bar")
    private boolean transStatusBar;

    @SerializedName("url")
    private String url;

    @SerializedName("web_bg_color")
    private String webBgColor;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/schema/vo/BaseHybridParamVo$HybridType;", "", "H5", "LYNX", "HOST_H5", "NATIVE", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType H5 = null;
        public static final HybridType HOST_H5 = null;
        public static final HybridType LYNX = null;
        public static final HybridType NATIVE = null;
        public static final /* synthetic */ HybridType[] a = null;

        static {
            HybridType r1 = new HybridType("H5", 0);
            H5 = r1;
            HybridType r2 = new HybridType("LYNX", 1);
            LYNX = r2;
            HybridType r3 = new HybridType("HOST_H5", 2);
            HOST_H5 = r3;
            HybridType r4 = new HybridType("NATIVE", 3);
            NATIVE = r4;
            a = new HybridType[]{r1, r2, r3, r4};
        }

        public static HybridType valueOf(String r1) {
            return (HybridType) r27.a.a(HybridType.class, r1);
        }

        public static HybridType[] values() {
            return (HybridType[]) a.clone();
        }

        public HybridType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a implements Parcelable.Creator<BaseHybridParamVo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVo createFromParcel(Parcel r42) {
            Intrinsics.checkNotNullParameter(r42, "in");
            if (r42.readInt() == 0) goto L5;
            boolean r5 = true;
        L6:
            HybridType r6 = (HybridType) r27.a.a(HybridType.class, r42.readString());
            String r7 = r42.readString();
            String r8 = r42.readString();
            if (r42.readInt() == 0) goto L9;
            boolean r9 = true;
        L10:
            int r10 = r42.readInt();
            if (r42.readInt() == 0) goto L13;
            boolean r12 = true;
        L14:
            String r13 = r42.readString();
            if (r42.readInt() == 0) goto L17;
            boolean r14 = true;
        L19:
            if (r42.readInt() == 0) goto L21;
            boolean r15 = true;
        L23:
            if (r42.readInt() == 0) goto L25;
            boolean r16 = true;
        L27:
            if (r42.readInt() == 0) goto L29;
            boolean r17 = true;
        L31:
            if (r42.readInt() == 0) goto L33;
            boolean r18 = true;
        L35:
            if (r42.readInt() == 0) goto L37;
            Integer r19 = Integer.valueOf(r42.readInt());
        L39:
            if (r42.readInt() == 0) goto L41;
            boolean r20 = true;
        L43:
            if (r42.readInt() == 0) goto L45;
            boolean r22 = true;
        L46:
            String r23 = r42.readString();
            if (r42.readInt() == 0) goto L49;
            boolean r24 = true;
        L51:
            if (r42.readInt() == 0) goto L53;
            boolean r25 = true;
        L55:
            if (r42.readInt() == 0) goto L57;
            boolean r26 = true;
        L59:
            if (r42.readInt() == 0) goto L61;
            boolean r27 = true;
        L62:
            String r28 = r42.readString();
            String r29 = r42.readString();
            if (r42.readInt() != 0) goto L65;
            Boolean r210 = null;
        L70:
            String r30 = r42.readString();
            String r32 = r42.readString();
            int r33 = r42.readInt();
            String r34 = r42.readString();
            if (r42.readInt() == 0) goto L73;
            boolean r37 = true;
        L74:
            int r38 = r42.readInt();
            if (r42.readInt() == 0) goto L77;
            boolean r39 = true;
        L79:
            return new BaseHybridParamVo(r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r210, r30, r32, r33, r34, r37, r38, r39, r42.readString(), r42.readString(), r42.readString());
        L77:
            r39 = false;
            goto L79
        L73:
            r37 = false;
            goto L74
        L65:
            if (r42.readInt() == 0) goto L67;
            boolean r2 = true;
        L68:
            r210 = Boolean.valueOf(r2);
            goto L70
        L67:
            r2 = false;
            goto L68
        L61:
            r27 = false;
            goto L62
        L57:
            r26 = false;
            goto L59
        L53:
            r25 = false;
            goto L55
        L49:
            r24 = false;
            goto L51
        L45:
            r22 = false;
            goto L46
        L41:
            r20 = false;
            goto L43
        L37:
            r19 = null;
            goto L39
        L33:
            r18 = false;
            goto L35
        L29:
            r17 = false;
            goto L31
        L25:
            r16 = false;
            goto L27
        L21:
            r15 = false;
            goto L23
        L17:
            r14 = false;
            goto L19
        L13:
            r12 = false;
            goto L14
        L9:
            r9 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVo[] newArray(int r1) {
            return new BaseHybridParamVo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseHybridParamVo() {
        this(false, false, 0, false, null, false, false, false, false, false, false, false, false, null, null, null, null, null, 0, null, false, 0, false, null, null, null, -1, 3);
    }

    public final void E() {
        this.hidePoster = false;
    }

    public final void F() {
        this.hideStatusBar = false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.hideStatusBar ? 1 : 0);
        r3.writeString(this.a.name());
        r3.writeString(this.b);
        r3.writeString(this.c);
        r3.writeInt(this.pullDownClose ? 1 : 0);
        r3.writeInt(this.pullDownHeight);
        r3.writeInt(this.pullDownIndicatorNotShow ? 1 : 0);
        r3.writeString(this.indicatorColor);
        r3.writeInt(this.hidePoster ? 1 : 0);
        r3.writeInt(this.showClose ? 1 : 0);
        r3.writeInt(this.showBack ? 1 : 0);
        r3.writeInt(this.enableShare ? 1 : 0);
        r3.writeInt(this.forbidRightBack ? 1 : 0);
        Integer r5 = this.d;
        if (r5 == null) goto L5;
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
    L6:
        r3.writeInt(this.e ? 1 : 0);
        r3.writeInt(this.hideNavBar ? 1 : 0);
        r3.writeString(this.f);
        r3.writeInt(this.g ? 1 : 0);
        r3.writeInt(this.h ? 1 : 0);
        r3.writeInt(this.i ? 1 : 0);
        r3.writeInt(this.transStatusBar ? 1 : 0);
        r3.writeString(this.statusBarColor);
        r3.writeString(this.statusBarBgColor);
        Boolean r6 = this.j;
        if (r6 == null) goto L9;
        r3.writeInt(1);
        r3.writeInt(r6.booleanValue() ? 1 : 0);
    L10:
        r3.writeString(this.k);
        r3.writeString(this.title);
        r3.writeInt(this.l);
        r3.writeString(this.webBgColor);
        r3.writeInt(this.hideLoading ? 1 : 0);
        r3.writeInt(this.m);
        r3.writeInt(this.supportExchangeTheme ? 1 : 0);
        r3.writeString(this.n);
        r3.writeString(this.url);
        r3.writeString(this.o);
        return;
    L9:
        r3.writeInt(0);
        goto L10
    L5:
        r3.writeInt(0);
        goto L6
    }

    public final String toString() {
        return "BaseHybridParamVo(hideStatusBar=" + this.hideStatusBar + ", hybridType=" + this.a + ", monitorPageService=" + this.b + ", fromLabel=" + this.c + ", pullDownClose=" + this.pullDownClose + ", pullDownHeight=" + this.pullDownHeight + ", pullDownIndicatorNotShow=" + this.pullDownIndicatorNotShow + ", indicatorColor=" + this.indicatorColor + ", hidePoster=" + this.hidePoster + ", showClose=" + this.showClose + ",showBack=" + this.showBack + ", enableShare=" + this.enableShare + ", forbidRightBack=" + this.forbidRightBack + ", backgroundRes=" + this.d + ", userWebViewTitle=" + this.e + ", hideNavBar=" + this.hideNavBar + ", fromContainer=" + this.f + ", isPopUp=" + this.g + ", hideMore=" + this.h + ", isFullScreen=" + this.i + ", transStatusBar=" + this.transStatusBar + ", statusBarColor=" + this.statusBarColor + ", statusBarBgColor=" + this.statusBarBgColor + ", isOutUrl=" + this.j + ", scene=" + this.k + ", title=" + this.title + ", bundleWebBgColor=" + this.l + ", webBgColor=" + this.webBgColor + ", hideLoading=" + this.hideLoading + ", requestCode=" + this.m + ", supportExchangeTheme=" + this.supportExchangeTheme + ", injectJsonUrl=" + this.n + ", url=" + this.url + ", originSchema=" + this.o + ')';
    }

    public final String D() {
        return this.webBgColor;
    }

    public final boolean a() {
        return this.enableShare;
    }

    public final boolean b() {
        return this.forbidRightBack;
    }

    public final boolean c() {
        return this.hideLoading;
    }

    public final boolean d() {
        return this.hideNavBar;
    }

    public final boolean e() {
        return this.hideStatusBar;
    }

    public final String g() {
        return this.indicatorColor;
    }

    public final boolean h() {
        return this.pullDownClose;
    }

    public final boolean i() {
        return this.pullDownIndicatorNotShow;
    }

    public final boolean j() {
        return this.showBack;
    }

    public final boolean k() {
        return this.showClose;
    }

    public final String o() {
        return this.statusBarBgColor;
    }

    public final String q() {
        return this.statusBarColor;
    }

    public final boolean r() {
        return this.supportExchangeTheme;
    }

    public final String s() {
        return this.title;
    }

    public final boolean t() {
        return this.transStatusBar;
    }

    public final String z() {
        return this.url;
    }

    public final void I(String r1) {
        this.indicatorColor = r1;
    }

    public final void J(boolean r1) {
        this.pullDownClose = r1;
    }

    public final void K(int r1) {
        this.pullDownHeight = r1;
    }

    public final void L(boolean r1) {
        this.pullDownIndicatorNotShow = r1;
    }

    public final void M(boolean r1) {
        this.showBack = r1;
    }

    public final void N(boolean r1) {
        this.showClose = r1;
    }

    public final void O(String r1) {
        this.statusBarBgColor = r1;
    }

    public final void R(String r1) {
        this.statusBarColor = r1;
    }

    public final void S(String r1) {
        this.url = r1;
    }

    public /* synthetic */ BaseHybridParamVo(boolean r39, boolean r40, int r42, boolean r43, String r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r410, boolean r50, boolean r52, String r53, String r54, Boolean r55, String r56, String r57, int r58, String r59, boolean r510, int r60, boolean r62, String r63, String r64, String r65, int r66, int r67) {
        if ((r66 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r66 & 2) == 0) goto L9;
        HybridType r5 = HybridType.H5;
    L11:
        if ((r66 & 8) == 0) goto L13;
        String r1 = "";
    L15:
        if ((r66 & 16) == 0) goto L17;
        boolean r8 = true;
    L19:
        if ((r66 & 32) == 0) goto L21;
        int r10 = 0;
    L23:
        if ((r66 & 64) == 0) goto L25;
        boolean r12 = true;
    L27:
        if ((r66 & 128) == 0) goto L29;
        String r13 = "";
    L31:
        if ((r66 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L33;
        boolean r14 = false;
    L35:
        if ((r66 & 512) == 0) goto L37;
        boolean r15 = false;
    L39:
        if ((r66 & 1024) == 0) goto L41;
        boolean r16 = false;
    L43:
        if ((r66 & 2048) == 0) goto L45;
        boolean r2 = false;
    L47:
        if ((r66 & 4096) == 0) goto L49;
        boolean r17 = false;
    L51:
        if ((32768 & r66) == 0) goto L53;
        boolean r20 = false;
    L55:
        if ((65536 & r66) == 0) goto L57;
        String r22 = "";
    L59:
        if ((524288 & r66) == 0) goto L61;
        boolean r24 = false;
    L63:
        if ((1048576 & r66) == 0) goto L65;
        boolean r25 = false;
    L67:
        if ((2097152 & r66) == 0) goto L69;
        String r26 = "";
    L71:
        if ((4194304 & r66) == 0) goto L73;
        String r27 = "";
    L75:
        if ((8388608 & r66) == 0) goto L77;
        Boolean r28 = Boolean.FALSE;
    L79:
        if ((16777216 & r66) == 0) goto L81;
        String r29 = "";
    L83:
        if ((33554432 & r66) == 0) goto L85;
        String r30 = "";
    L87:
        if ((67108864 & r66) == 0) goto L89;
        int r32 = -1;
    L91:
        if ((134217728 & r66) == 0) goto L93;
        String r33 = "";
    L95:
        if ((268435456 & r66) == 0) goto L97;
        boolean r34 = true;
    L99:
        if ((536870912 & r66) == 0) goto L101;
        int r35 = 0;
    L103:
        if ((1073741824 & r66) == 0) goto L105;
        boolean r36 = false;
    L107:
        if ((r66 & Integer.MIN_VALUE) == 0) goto L109;
        String r0 = "";
    L111:
        if ((r67 & 1) == 0) goto L113;
        String r37 = "";
    L115:
        if ((r67 & 2) == 0) goto L117;
        String r38 = "";
    L118:
        this(r4, r5, null, r1, r8, r10, r12, r13, r14, r15, r16, r2, r17, null, false, r20, r22, false, false, r24, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35, r36, r0, r37, r38);
        return;
    L117:
        r38 = r65;
        goto L118
    L113:
        r37 = r64;
        goto L115
    L109:
        r0 = r63;
        goto L111
    L105:
        r36 = r62;
        goto L107
    L101:
        r35 = r60;
        goto L103
    L97:
        r34 = r510;
        goto L99
    L93:
        r33 = r59;
        goto L95
    L89:
        r32 = r58;
        goto L91
    L85:
        r30 = r57;
        goto L87
    L81:
        r29 = r56;
        goto L83
    L77:
        r28 = r55;
        goto L79
    L73:
        r27 = r54;
        goto L75
    L69:
        r26 = r53;
        goto L71
    L65:
        r25 = r52;
        goto L67
    L61:
        r24 = r50;
        goto L63
    L57:
        r22 = null;
        goto L59
    L53:
        r20 = r410;
        goto L55
    L49:
        r17 = r49;
        goto L51
    L45:
        r2 = r48;
        goto L47
    L41:
        r16 = r47;
        goto L43
    L37:
        r15 = r46;
        goto L39
    L33:
        r14 = r45;
        goto L35
    L29:
        r13 = r44;
        goto L31
    L25:
        r12 = r43;
        goto L27
    L21:
        r10 = r42;
        goto L23
    L17:
        r8 = r40;
        goto L19
    L13:
        r1 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = r39;
        goto L7
    }

    public BaseHybridParamVo(boolean r5, HybridType r6, String r7, String r8, boolean r9, int r10, boolean r12, String r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, Integer r19, boolean r110, boolean r20, String r22, boolean r23, boolean r24, boolean r25, boolean r26, String r27, String r28, Boolean r29, String r210, String r30, int r32, String r33, boolean r34, int r35, boolean r36, String r37, String r38, String r39) {
        Intrinsics.checkNotNullParameter(r6, "hybridType");
        Intrinsics.checkNotNullParameter(r37, "injectJsonUrl");
        this.hideStatusBar = r5;
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.pullDownClose = r9;
        this.pullDownHeight = r10;
        this.pullDownIndicatorNotShow = r12;
        this.indicatorColor = r13;
        this.hidePoster = r14;
        this.showClose = r15;
        this.showBack = r16;
        this.enableShare = r17;
        this.forbidRightBack = r18;
        this.d = r19;
        this.e = r110;
        this.hideNavBar = r20;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.transStatusBar = r26;
        this.statusBarColor = r27;
        this.statusBarBgColor = r28;
        this.j = r29;
        this.k = r210;
        this.title = r30;
        this.l = r32;
        this.webBgColor = r33;
        this.hideLoading = r34;
        this.m = r35;
        this.supportExchangeTheme = r36;
        this.n = r37;
        this.url = r38;
        this.o = r39;
    }
}
