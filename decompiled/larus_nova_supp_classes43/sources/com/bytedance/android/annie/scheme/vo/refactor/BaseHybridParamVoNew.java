package com.bytedance.android.annie.scheme.vo.refactor;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\n\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001FR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u0005\u0010\tR\"\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\"\u0010+\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\"\u0010.\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\"\u00101\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR\"\u00104\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R$\u00107\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001d\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R$\u0010:\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\"\u0010>\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\t¨\u0006G"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/HybridSchemaParam;", "Lcom/bytedance/android/annie/scheme/vo/refactor/RealBaseParamVo;", "", "hideStatusBar", "Z", "i", "()Z", "O", "(Z)V", "isFullScreen", "D", "L", "transStatusBar", "r", "pullDownClose", "q", "Y", "enableEngineViewScroll", "c", "setEnableEngineViewScroll", "isOutUrl", "Ljava/lang/Boolean;", "E", "()Ljava/lang/Boolean;", "W", "(Ljava/lang/Boolean;)V", "", "originSchema", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "U", "(Ljava/lang/String;)V", "enableViewRemove", "d", "J", "loaderName", "j", "R", "errorPageTheme", "e", "K", "openContainerID", "k", "S", "webNestedScroll", "t", "setWebNestedScroll", "closeAfterSuccess", "a", "I", "xBridgeRegisterStrategy", "z", "setXBridgeRegisterStrategy", "webBgColor", "s", "a0", "gradientBgColor", "g", "M", "", "gradientColorPercent", "h", "()I", "N", "(I)V", "disableWebviewSelectMenus", "b", "setDisableWebviewSelectMenus", "HybridType", "annie_release"}, k = 1, mv = {1, 4, 3})
public class BaseHybridParamVoNew extends HybridSchemaParam {
    public static final Parcelable.Creator<BaseHybridParamVoNew> CREATOR = null;
    public final Lazy R;
    public final Lazy S;
    public v8.a T;

    @SerializedName("_close_after_open_success")
    private boolean closeAfterSuccess;

    @SerializedName("disable_webview_select_menus")
    private boolean disableWebviewSelectMenus;

    @SerializedName("enable_engine_view_scroll")
    private boolean enableEngineViewScroll;

    @SerializedName("live_enable_view_remove")
    private boolean enableViewRemove;

    @SerializedName("error_page_theme")
    private String errorPageTheme;

    @SerializedName("gradient_bg_color")
    private String gradientBgColor;

    @SerializedName("gradient_color_percent")
    private int gradientColorPercent;

    @SerializedName("hide_status_bar")
    private boolean hideStatusBar;

    @SerializedName("is_full_screen")
    private boolean isFullScreen;

    @SerializedName("is_out_url")
    private Boolean isOutUrl;

    @SerializedName("loader_name")
    private String loaderName;

    @SerializedName("_open_container_id")
    private String openContainerID;

    @SerializedName("origin_schema")
    private String originSchema;

    @SerializedName("pull_down_close")
    private boolean pullDownClose;

    @SerializedName("trans_status_bar")
    private boolean transStatusBar;

    @SerializedName("web_bg_color")
    private String webBgColor;

    @SerializedName("web_nested_scroll")
    private boolean webNestedScroll;

    @SerializedName("xbridge_register_strategy")
    private String xBridgeRegisterStrategy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "", "", "toMonitorString", "H5", "LYNX", "HOST_H5", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum HybridType extends Enum<HybridType> {
        public static final HybridType H5 = null;
        public static final HybridType HOST_H5 = null;
        public static final HybridType LYNX = null;
        public static final /* synthetic */ HybridType[] a = null;

        public static HybridType valueOf(String r1) {
            return (HybridType) r27.a.a(HybridType.class, r1);
        }

        public static HybridType[] values() {
            return (HybridType[]) a.clone();
        }

        static {
            HybridType r0 = new HybridType("H5", 0);
            H5 = r0;
            HybridType r1 = new HybridType("LYNX", 1);
            LYNX = r1;
            HybridType r10 = new HybridType("HOST_H5", 2);
            HOST_H5 = r10;
            a = new HybridType[]{r0, r1, r10};
        }

        public final String toMonitorString() {
            if (this != LYNX) goto L5;
            return "lynx";
        L5:
            return "web";
        }

        public HybridType(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a implements Parcelable.Creator<BaseHybridParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVoNew createFromParcel(Parcel r23) {
            Intrinsics.checkNotNullParameter(r23, "parcel");
            if (r23.readInt() == 0) goto L5;
            boolean r10 = true;
        L7:
            if (r23.readInt() == 0) goto L9;
            boolean r11 = true;
        L11:
            if (r23.readInt() == 0) goto L13;
            boolean r12 = true;
        L15:
            if (r23.readInt() == 0) goto L17;
            boolean r13 = true;
        L19:
            if (r23.readInt() == 0) goto L21;
            boolean r14 = true;
        L23:
            if (r23.readInt() != 0) goto L26;
            Boolean r15 = null;
        L30:
            String r16 = r23.readString();
            if (r23.readInt() == 0) goto L33;
            boolean r17 = true;
        L34:
            String r18 = r23.readString();
            String r19 = r23.readString();
            String r110 = r23.readString();
            if (r23.readInt() == 0) goto L37;
            boolean r111 = true;
        L39:
            if (r23.readInt() == 0) goto L41;
            boolean r112 = true;
        L42:
            String r113 = r23.readString();
            String r114 = r23.readString();
            String r115 = r23.readString();
            int r20 = r23.readInt();
            if (r23.readInt() == 0) goto L45;
            boolean r21 = true;
        L47:
            return new BaseHybridParamVoNew(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21);
        L45:
            r21 = false;
            goto L47
        L41:
            r112 = false;
            goto L42
        L37:
            r111 = false;
            goto L39
        L33:
            r17 = false;
            goto L34
        L26:
            if (r23.readInt() == 0) goto L28;
            boolean r22 = true;
        L29:
            r15 = Boolean.valueOf(r22);
            goto L30
        L28:
            r22 = false;
            goto L29
        L21:
            r14 = false;
            goto L23
        L17:
            r13 = false;
            goto L19
        L13:
            r12 = false;
            goto L15
        L9:
            r11 = false;
            goto L11
        L5:
            r10 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BaseHybridParamVoNew[] newArray(int r1) {
            return new BaseHybridParamVoNew[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BaseHybridParamVoNew() {
        this(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    @Override // com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "out");
        r10.writeInt(this.hideStatusBar ? 1 : 0);
        r10.writeInt(this.isFullScreen ? 1 : 0);
        r10.writeInt(this.transStatusBar ? 1 : 0);
        r10.writeInt(this.pullDownClose ? 1 : 0);
        r10.writeInt(this.enableEngineViewScroll ? 1 : 0);
        Boolean r12 = this.isOutUrl;
        if (r12 != null) goto L6;
        ?? r13 = 0;
    L5:
        r10.writeInt(r13);
        r10.writeString(this.originSchema);
        r10.writeInt(this.enableViewRemove ? 1 : 0);
        r10.writeString(this.loaderName);
        r10.writeString(this.errorPageTheme);
        r10.writeString(this.openContainerID);
        r10.writeInt(this.webNestedScroll ? 1 : 0);
        r10.writeInt(this.closeAfterSuccess ? 1 : 0);
        r10.writeString(this.xBridgeRegisterStrategy);
        r10.writeString(this.webBgColor);
        r10.writeString(this.gradientBgColor);
        r10.writeInt(this.gradientColorPercent);
        r10.writeInt(this.disableWebviewSelectMenus ? 1 : 0);
        return;
    L6:
        r10.writeInt(1);
        r13 = r12.booleanValue();
        goto L5
    }

    public String toString() {
        return super.toString() + "BaseHybridParamVo(hideStatusBar=" + this.hideStatusBar + ", hybridType=" + this.a + ", pullDownClose=" + this.pullDownClose + ", enableEngineViewScroll=" + this.enableEngineViewScroll + ", isOutUrl=" + this.isOutUrl + ", url=" + this.b + ", originSchema=" + this.originSchema + ", loaderName='" + this.loaderName + "', fallbackSchema=" + this.c + ", webBgColor=" + this.webBgColor + ", gradientBgColor=" + this.gradientBgColor + ", gradientColorPercent=" + this.gradientColorPercent + ')';
    }

    public final boolean D() {
        return this.isFullScreen;
    }

    public final Boolean E() {
        return this.isOutUrl;
    }

    public final boolean a() {
        return this.closeAfterSuccess;
    }

    public final boolean b() {
        return this.disableWebviewSelectMenus;
    }

    public final boolean c() {
        return this.enableEngineViewScroll;
    }

    public final boolean d() {
        return this.enableViewRemove;
    }

    public final String e() {
        return this.errorPageTheme;
    }

    public final String g() {
        return this.gradientBgColor;
    }

    public final int h() {
        return this.gradientColorPercent;
    }

    public final boolean i() {
        return this.hideStatusBar;
    }

    public final String j() {
        return this.loaderName;
    }

    public final String k() {
        return this.openContainerID;
    }

    public final String o() {
        return this.originSchema;
    }

    public final boolean q() {
        return this.pullDownClose;
    }

    public final boolean r() {
        return this.transStatusBar;
    }

    public final String s() {
        return this.webBgColor;
    }

    public final boolean t() {
        return this.webNestedScroll;
    }

    public final String z() {
        return this.xBridgeRegisterStrategy;
    }

    public /* synthetic */ BaseHybridParamVoNew(int r20) {
        this(false, false, false, false, false, Boolean.FALSE, "", false, "", "default", "", false, false, "all", "", "", 0, false);
    }

    public void F(u8.a r31) {
        v8.a r10 = r31.e;
        if (r10 != null) goto L5;
        r10 = new v8.a(r31.b, r31.a, r31.c);
    L5:
        this.T = r10;
        String r11 = r31.a;
        if (r11 != null) goto L8;
        r11 = (String) r10.b(com.bytedance.android.ec.core.event.a.KEY_URL, "");
    L8:
        String r12 = (String) r10.b(com.bytedance.android.ec.core.event.a.KEY_ENTER_FROM, "");
        String r13 = (String) r10.b("is_out_url", "");
        if (((Number) r10.b("hide_status_bar", 0)).intValue() != 1) goto L11;
        boolean r14 = true;
    L13:
        if (((Number) r10.b("pull_down_close", 0)).intValue() != 1) goto L15;
        boolean r15 = true;
    L17:
        if (((Number) r10.b("enable_pull_down_close", 0)).intValue() != 1) goto L19;
        boolean r16 = true;
    L21:
        if (((Number) r10.b("enable_engine_view_scroll", 0)).intValue() != 1) goto L23;
        boolean r17 = true;
    L25:
        if (((Number) r10.b("live_enable_view_remove", 0)).intValue() != 1) goto L27;
        boolean r18 = true;
    L28:
        ((Number) r10.b("enable_prefetch", 0)).intValue();
        String r19 = (String) r10.b("loader_name", "");
        String r20 = (String) r10.b("error_page_theme", "default");
        boolean r21 = ((Boolean) r10.b("bundle_live_webview_offline_enable", Boolean.TRUE)).booleanValue();
        String r110 = (String) r10.b("_open_container_id", "");
        String r111 = r11;
        if (((Number) r10.b("_close_after_open_success", 0)).intValue() != 1) goto L31;
        boolean r22 = true;
    L32:
        String r23 = (String) r10.b("fallback_url", "");
        String r24 = (String) r10.b("bundle_fallback_url", "");
        boolean r25 = r22;
        String r26 = (String) r10.b("xbridge_register_strategy", "all");
        Uri r27 = r31.b;
        if (r27 == null) goto L38;
        String r28 = r27.toString();
        if (r28 == null) goto L38;
    L39:
        boolean r29 = ((Boolean) r10.b("is_fullScreen", Boolean.FALSE)).booleanValue();
        if (((Number) r10.b("trans_status_bar", 0)).intValue() != 1) goto L42;
        boolean r30 = true;
    L43:
        boolean r210 = r30;
        int r32 = ((Number) r10.b("preset_width_px", -1)).intValue();
        int r33 = ((Number) r10.b("lynx_thread", 0)).intValue();
        String r112 = (String) r10.b("web_bg_color", "");
        String r34 = (String) r10.b("gradient_bg_color", "");
        int r35 = ((Number) r10.b("gradient_color_percent", 0)).intValue();
        if (((Number) r10.b("disable_webview_select_menus", 0)).intValue() != 1) goto L46;
        boolean r36 = true;
    L48:
        if (r31.d != HybridTypeNew.Lynx) goto L50;
        HybridKitType r1 = HybridKitType.LYNX;
    L51:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.a = r1;
        this.hideStatusBar = r14;
        if (r15 == true) goto L56;
        if (r16 == true) goto L56;
        boolean r37 = false;
    L57:
        this.pullDownClose = r37;
        this.enableEngineViewScroll = r17;
        if (Intrinsics.areEqual("is_from_out_scene", r13) == false) goto L60;
    L63:
        boolean r38 = true;
    L64:
        this.isOutUrl = Boolean.valueOf(r38);
        this.originSchema = r28;
        this.enableViewRemove = r18;
        this.loaderName = r19;
        this.errorPageTheme = r20;
        this.openContainerID = r110;
        this.closeAfterSuccess = r25;
        this.xBridgeRegisterStrategy = r26;
        if (r23.length() != 0) goto L67;
        boolean r39 = true;
    L68:
        if (r39 == false) goto L70;
        String r40 = r24;
    L71:
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        this.c = r40;
        this.isFullScreen = r29;
        this.transStatusBar = r210;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        this.b = r111;
        this.f = !r21;
        this.y = r32;
        this.D = r33;
        this.webBgColor = r112;
        if (((Number) r10.b("web_nested_scroll", 0)).intValue() != 1) goto L74;
        boolean r41 = true;
    L75:
        this.webNestedScroll = r41;
        this.gradientBgColor = r34;
        this.gradientColorPercent = r35;
        this.disableWebviewSelectMenus = r36;
        return;
    L74:
        r41 = false;
        goto L75
    L70:
        r40 = r23;
        goto L71
    L67:
        r39 = false;
        goto L68
    L60:
        if (Intrinsics.areEqual("deeplink", r12) == true) goto L63;
        r38 = false;
    L56:
        r37 = true;
        goto L57
    L50:
        r1 = HybridKitType.WEB;
        goto L51
    L46:
        r36 = false;
        goto L48
    L42:
        r30 = false;
    L38:
        r28 = "";
        goto L39
    L31:
        r22 = false;
        goto L32
    L27:
        r18 = false;
        goto L28
    L23:
        r17 = false;
        goto L25
    L19:
        r16 = false;
        goto L21
    L15:
        r15 = false;
        goto L17
    L11:
        r14 = false;
        goto L13
    }

    public final void I(boolean r1) {
        this.closeAfterSuccess = r1;
    }

    public final void J(boolean r1) {
        this.enableViewRemove = r1;
    }

    public final void K(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.errorPageTheme = r10;
    }

    public final void L(boolean r1) {
        this.isFullScreen = r1;
    }

    public final void M(String r1) {
        this.gradientBgColor = r1;
    }

    public final void N(int r1) {
        this.gradientColorPercent = r1;
    }

    public final void O(boolean r1) {
        this.hideStatusBar = r1;
    }

    public final void R(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.loaderName = r10;
    }

    public final void S(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.openContainerID = r10;
    }

    public final void U(String r1) {
        this.originSchema = r1;
    }

    public final void W(Boolean r1) {
        this.isOutUrl = r1;
    }

    public final void Y(boolean r1) {
        this.pullDownClose = r1;
    }

    public final void Z(boolean r1) {
        this.transStatusBar = r1;
    }

    public final void a0(String r1) {
        this.webBgColor = r1;
    }

    public BaseHybridParamVoNew(boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, Boolean r15, String r16, boolean r17, String r18, String r19, String r110, boolean r111, boolean r112, String r20, String r21, String r22, int r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r18, "loaderName");
        Intrinsics.checkNotNullParameter(r19, "errorPageTheme");
        Intrinsics.checkNotNullParameter(r110, "openContainerID");
        Intrinsics.checkNotNullParameter(r20, "xBridgeRegisterStrategy");
        super(0);
        this.hideStatusBar = r10;
        this.isFullScreen = r11;
        this.transStatusBar = r12;
        this.pullDownClose = r13;
        this.enableEngineViewScroll = r14;
        this.isOutUrl = r15;
        this.originSchema = r16;
        this.enableViewRemove = r17;
        this.loaderName = r18;
        this.errorPageTheme = r19;
        this.openContainerID = r110;
        this.webNestedScroll = r111;
        this.closeAfterSuccess = r112;
        this.xBridgeRegisterStrategy = r20;
        this.webBgColor = r21;
        this.gradientBgColor = r22;
        this.gradientColorPercent = r23;
        this.disableWebviewSelectMenus = r24;
        this.R = LazyKt.lazy(new BaseHybridParamVoNew$noQueryUrl$2(this));
        this.S = LazyKt.lazy(new BaseHybridParamVoNew$noQueryUrlWithID$2(this));
    }
}
