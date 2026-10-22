package com.bytedance.android.annie.scheme.vo.refactor;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.annie.resource.n;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR$\u0010#\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u0010,\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR$\u00105\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0012\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\"\u0010>\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\"\u0010B\u001a\u00020A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0012\u001a\u0004\bI\u0010\u0014\"\u0004\bJ\u0010\u0016R\"\u0010K\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000b\u001a\u0004\bL\u0010\r\"\u0004\bM\u0010\u000f¨\u0006N"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "pageType", "Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "I0", "()Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;", "l1", "(Lcom/bytedance/android/annie/scheme/vo/refactor/PageType;)V", "", "enableAppCache", "Z", "i0", "()Z", "T0", "(Z)V", "", "headStr", "Ljava/lang/String;", "C0", "()Ljava/lang/String;", "e1", "(Ljava/lang/String;)V", "loadNoCache", "G0", "g1", "disableHostJsbMethod", "c0", "R0", "disableThreadSpread", "f0", "S0", "createViewAsync", "b0", "O0", "enableFontScale", "o0", "Z0", "enableViewZoom", "v0", "c1", "hidePoster", "F0", "f1", "scene", "K0", "r1", "enableCodeCache", "j0", "X0", "enableResourceLock", "p0", "b1", "forestSessionID", "y0", "d1", "isSetScreenSize", "N0", "s1", "monitorReportPerf", "H0", "h1", "forestDownloadEngine", "w0", "setForestDownloadEngine", "", "webForestMode", "I", "M0", "()I", "setWebForestMode", "(I)V", "referer", "J0", "o1", "useScreenHeight", "L0", "setUseScreenHeight", "annie_release"}, k = 1, mv = {1, 4, 3})
public class CardParamVoNew extends BaseHybridParamVoNew {
    public static final Parcelable.Creator<CardParamVoNew> CREATOR = null;

    @SerializedName("create_view_async")
    private boolean createViewAsync;

    @SerializedName("disable_host_jsb_method")
    private boolean disableHostJsbMethod;

    @SerializedName("disable_thread_spread")
    private boolean disableThreadSpread;

    @SerializedName("enable_app_cache")
    private boolean enableAppCache;

    @SerializedName("enable_code_cache")
    private boolean enableCodeCache;

    @SerializedName("enable_font_scale")
    private String enableFontScale;

    @SerializedName("lock_resource")
    private boolean enableResourceLock;

    @SerializedName("enable_view_zoom")
    private boolean enableViewZoom;

    @SerializedName("forest_download_engine")
    private String forestDownloadEngine;

    @SerializedName("forest_session_id")
    private String forestSessionID;

    @SerializedName("head_str")
    private String headStr;

    @SerializedName("hide_poster")
    private boolean hidePoster;

    @SerializedName("screen_size_adaptation")
    private boolean isSetScreenSize;

    @SerializedName("load_no_cache")
    private boolean loadNoCache;

    @SerializedName("monitor_report_perf")
    private String monitorReportPerf;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE)
    private PageType pageType;

    @SerializedName("referer")
    private String referer;

    @SerializedName("scene")
    private String scene;

    @SerializedName("use_screen_height")
    private boolean useScreenHeight;

    @SerializedName("web_forest_mode")
    private int webForestMode;

    public static final class a implements Parcelable.Creator<CardParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CardParamVoNew createFromParcel(Parcel r25) {
            Intrinsics.checkNotNullParameter(r25, "parcel");
            PageType r10 = PageType.valueOf(r25.readString());
            if (r25.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            String r12 = r25.readString();
            if (r25.readInt() == 0) goto L9;
            boolean r13 = true;
        L11:
            if (r25.readInt() == 0) goto L13;
            boolean r14 = true;
        L15:
            if (r25.readInt() == 0) goto L17;
            boolean r15 = true;
        L19:
            if (r25.readInt() == 0) goto L21;
            boolean r16 = true;
        L22:
            String r17 = r25.readString();
            if (r25.readInt() == 0) goto L25;
            boolean r18 = true;
        L27:
            if (r25.readInt() == 0) goto L29;
            boolean r19 = true;
        L30:
            String r110 = r25.readString();
            if (r25.readInt() == 0) goto L33;
            boolean r111 = true;
        L35:
            if (r25.readInt() == 0) goto L37;
            boolean r112 = true;
        L38:
            String r113 = r25.readString();
            if (r25.readInt() == 0) goto L41;
            boolean r114 = true;
        L42:
            String r115 = r25.readString();
            String r20 = r25.readString();
            int r21 = r25.readInt();
            String r22 = r25.readString();
            if (r25.readInt() == 0) goto L45;
            boolean r23 = true;
        L47:
            return new CardParamVoNew(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r22, r23);
        L45:
            r23 = false;
            goto L47
        L41:
            r114 = false;
            goto L42
        L37:
            r112 = false;
            goto L38
        L33:
            r111 = false;
            goto L35
        L29:
            r19 = false;
            goto L30
        L25:
            r18 = false;
            goto L27
        L21:
            r16 = false;
            goto L22
        L17:
            r15 = false;
            goto L19
        L13:
            r14 = false;
            goto L15
        L9:
            r13 = false;
            goto L11
        L5:
            r11 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CardParamVoNew[] newArray(int r1) {
            return new CardParamVoNew[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public CardParamVoNew() {
        this(0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.pageType.name());
        r1.writeInt(this.enableAppCache ? 1 : 0);
        r1.writeString(this.headStr);
        r1.writeInt(this.loadNoCache ? 1 : 0);
        r1.writeInt(this.disableHostJsbMethod ? 1 : 0);
        r1.writeInt(this.disableThreadSpread ? 1 : 0);
        r1.writeInt(this.createViewAsync ? 1 : 0);
        r1.writeString(this.enableFontScale);
        r1.writeInt(this.enableViewZoom ? 1 : 0);
        r1.writeInt(this.hidePoster ? 1 : 0);
        r1.writeString(this.scene);
        r1.writeInt(this.enableCodeCache ? 1 : 0);
        r1.writeInt(this.enableResourceLock ? 1 : 0);
        r1.writeString(this.forestSessionID);
        r1.writeInt(this.isSetScreenSize ? 1 : 0);
        r1.writeString(this.monitorReportPerf);
        r1.writeString(this.forestDownloadEngine);
        r1.writeInt(this.webForestMode);
        r1.writeString(this.referer);
        r1.writeInt(this.useScreenHeight ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append("\nCardParamVo(enableAppCache=");
        r0.append(this.enableAppCache);
        r0.append(", headStr=");
        r0.append(this.headStr);
        r0.append(", loadNoCache=");
        r0.append(this.loadNoCache);
        r0.append(", offlineEnable=");
        r0.append(!this.f);
        r0.append(", disableHostJsbMethod=");
        r0.append(this.disableHostJsbMethod);
        r0.append(", referer=");
        r0.append(this.referer);
        r0.append(", disableThreadSpread=");
        r0.append(this.disableThreadSpread);
        r0.append(", presetWidth=");
        r0.append(this.y);
        r0.append(", createViewAsync=");
        r0.append(this.createViewAsync);
        r0.append(", isSetScreenSize=");
        r0.append(this.isSetScreenSize);
        r0.append(", monitorReportPerf=");
        r0.append(this.monitorReportPerf);
        r0.append(", enableFontScale=");
        r0.append(this.enableFontScale);
        r0.append(", enableViewZoom=");
        r0.append(this.enableViewZoom);
        r0.append(", hidePoster=");
        r0.append(this.hidePoster);
        r0.append(", enableCodeCache=");
        r0.append(this.enableCodeCache);
        r0.append(", forestSessionID=");
        r0.append(this.forestSessionID);
        r0.append(", enableResourceLock=");
        r0.append(this.enableResourceLock);
        r0.append(", useScreenHeight=");
        r0.append(this.useScreenHeight);
        r0.append(')');
        return r0.toString();
    }

    public final String C0() {
        return this.headStr;
    }

    public final boolean F0() {
        return this.hidePoster;
    }

    public final boolean G0() {
        return this.loadNoCache;
    }

    public final String H0() {
        return this.monitorReportPerf;
    }

    public final PageType I0() {
        return this.pageType;
    }

    public final String J0() {
        return this.referer;
    }

    public final String K0() {
        return this.scene;
    }

    public final boolean L0() {
        return this.useScreenHeight;
    }

    public final int M0() {
        return this.webForestMode;
    }

    public final boolean N0() {
        return this.isSetScreenSize;
    }

    public final boolean b0() {
        return this.createViewAsync;
    }

    public final boolean c0() {
        return this.disableHostJsbMethod;
    }

    public final boolean f0() {
        return this.disableThreadSpread;
    }

    public final boolean i0() {
        return this.enableAppCache;
    }

    public final boolean j0() {
        return this.enableCodeCache;
    }

    public final String o0() {
        return this.enableFontScale;
    }

    public final boolean p0() {
        return this.enableResourceLock;
    }

    public final boolean v0() {
        return this.enableViewZoom;
    }

    public final String w0() {
        return this.forestDownloadEngine;
    }

    public final String y0() {
        return this.forestSessionID;
    }

    public /* synthetic */ CardParamVoNew(int r22) {
        this(PageType.CARD, false, "", false, false, false, false, null, false, false, "", false, false, "", false, "", "", 0, "", false);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public void F(u8.a r24) {
        super.F(r24);
        v8.a r1 = this.T;
        if (r1 == null) goto L46;
        String r10 = (String) r1.b("referer", "");
        Boolean r11 = Boolean.FALSE;
        boolean r12 = ((Boolean) r1.b("bundle_enable_app_cache", r11)).booleanValue();
        String r13 = (String) r1.b("wap_headers", "");
        boolean r14 = ((Boolean) r1.b("bundle_load_no_cache", r11)).booleanValue();
        if (((Number) r1.b("disable_host_jsb_method", 0)).intValue() != 1) goto L7;
        boolean r15 = true;
    L9:
        if (((Number) r1.b("disable_thread_spread", 0)).intValue() != 1) goto L11;
        boolean r16 = true;
    L13:
        if (((Number) r1.b("create_view_sync", 0)).intValue() != 1) goto L15;
        boolean r17 = true;
    L16:
        String r18 = (String) r1.b("enable_font_scale", "");
        if (((Number) r1.b("enable_view_zoom", 0)).intValue() != 1) goto L19;
        boolean r19 = true;
    L21:
        if (((Number) r1.b("hide_system_video_poster", 0)).intValue() != 1) goto L23;
        boolean r110 = true;
    L24:
        String r111 = (String) r1.b("is_out_scene", "");
        if (((Number) r1.b("enable_code_cache", 0)).intValue() != 1) goto L27;
        boolean r20 = true;
    L28:
        boolean r112 = r20;
        if (((Number) r1.b("lock_resource", 0)).intValue() != 1) goto L31;
        boolean r21 = true;
    L32:
        String r22 = (String) r1.b("forest_session_id", "");
        boolean r113 = r21;
        if (((Number) r1.b("screen_size_adaptation", 0)).intValue() != 1) goto L35;
        boolean r23 = true;
    L36:
        String r25 = (String) r1.b("monitor_report_perf", "");
        String r26 = (String) r1.b("forest_download_engine", "ttnet");
        int r27 = ((Number) r1.b("web_forest_mode", 0)).intValue();
        if (((Number) r1.b("use_screen_height", 0)).intValue() != 1) goto L39;
        boolean r28 = true;
    L40:
        this.enableAppCache = r12;
        this.headStr = r13;
        this.loadNoCache = r14;
        this.disableHostJsbMethod = r15;
        this.disableThreadSpread = r16;
        this.createViewAsync = r17;
        this.enableFontScale = r18;
        this.enableViewZoom = r19;
        this.hidePoster = r110;
        this.scene = r111;
        this.enableCodeCache = r112;
        this.enableResourceLock = r113;
        this.forestSessionID = r22;
        this.isSetScreenSize = r23;
        this.monitorReportPerf = r25;
        this.referer = r10;
        if (n.f(this.b) == false) goto L43;
        String r29 = "downloader";
    L44:
        this.forestDownloadEngine = r29;
        this.webForestMode = r27;
        this.useScreenHeight = r28;
        return;
    L43:
        r29 = r26;
        goto L44
    L39:
        r28 = false;
        goto L40
    L35:
        r23 = false;
        goto L36
    L31:
        r21 = false;
        goto L32
    L27:
        r20 = false;
        goto L28
    L23:
        r110 = false;
        goto L24
    L19:
        r19 = false;
        goto L21
    L15:
        r17 = false;
        goto L16
    L11:
        r16 = false;
        goto L13
    L7:
        r15 = false;
        goto L9
    }

    public final void O0(boolean r1) {
        this.createViewAsync = r1;
    }

    public final void R0(boolean r1) {
        this.disableHostJsbMethod = r1;
    }

    public final void S0(boolean r1) {
        this.disableThreadSpread = r1;
    }

    public final void T0(boolean r1) {
        this.enableAppCache = r1;
    }

    public final void X0(boolean r1) {
        this.enableCodeCache = r1;
    }

    public final void Z0(String r1) {
        this.enableFontScale = r1;
    }

    public final void b1(boolean r1) {
        this.enableResourceLock = r1;
    }

    public final void c1(boolean r1) {
        this.enableViewZoom = r1;
    }

    public final void d1(String r1) {
        this.forestSessionID = r1;
    }

    public final void e1(String r1) {
        this.headStr = r1;
    }

    public final void f1(boolean r1) {
        this.hidePoster = r1;
    }

    public final void g1(boolean r1) {
        this.loadNoCache = r1;
    }

    public final void h1(String r1) {
        this.monitorReportPerf = r1;
    }

    public final void l1(PageType r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.pageType = r10;
    }

    public final void o1(String r1) {
        this.referer = r1;
    }

    public final void r1(String r1) {
        this.scene = r1;
    }

    public final void s1(boolean r1) {
        this.isSetScreenSize = r1;
    }

    public CardParamVoNew(PageType r10, boolean r11, String r12, boolean r13, boolean r14, boolean r15, boolean r16, String r17, boolean r18, boolean r19, String r110, boolean r111, boolean r112, String r113, boolean r114, String r20, String r21, int r22, String r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r10, "pageType");
        Intrinsics.checkNotNullParameter(r21, "forestDownloadEngine");
        super(0);
        this.pageType = r10;
        this.enableAppCache = r11;
        this.headStr = r12;
        this.loadNoCache = r13;
        this.disableHostJsbMethod = r14;
        this.disableThreadSpread = r15;
        this.createViewAsync = r16;
        this.enableFontScale = r17;
        this.enableViewZoom = r18;
        this.hidePoster = r19;
        this.scene = r110;
        this.enableCodeCache = r111;
        this.enableResourceLock = r112;
        this.forestSessionID = r113;
        this.isSetScreenSize = r114;
        this.monitorReportPerf = r20;
        this.forestDownloadEngine = r21;
        this.webForestMode = r22;
        this.referer = r23;
        this.useScreenHeight = r24;
    }
}
