package com.bytedance.android.annie.scheme.vo.refactor;

import android.app.Activity;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.annotations.SerializedName;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010\u0007\n\u0002\b\u0013\b\u0017\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R$\u00102\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0015\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R$\u00105\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\"\u0010H\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010:\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR$\u0010Q\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0015\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010\u0019R$\u0010T\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010\u0015\u001a\u0004\bU\u0010\u0017\"\u0004\bV\u0010\u0019R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\"\u0010Z\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010:\u001a\u0004\b[\u0010<\"\u0004\b\\\u0010>R\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0004\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR\"\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\"\u0010c\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0015\u001a\u0004\bd\u0010\u0017\"\u0004\be\u0010\u0019R\"\u0010f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010\u0004\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010\u0015\u001a\u0004\bq\u0010\u0017\"\u0004\br\u0010\u0019R\"\u0010s\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010\u0015\u001a\u0004\bt\u0010\u0017\"\u0004\bu\u0010\u0019R\"\u0010v\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010\u0015\u001a\u0004\bw\u0010\u0017\"\u0004\bx\u0010\u0019R\"\u0010y\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\by\u0010\u0004\u001a\u0004\bz\u0010\u0006\"\u0004\b{\u0010\b¨\u0006|"}, d2 = {"Lcom/bytedance/android/annie/scheme/vo/refactor/FragmentParamVoNew;", "Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;", "", "useReceivedTitle", "Z", "e2", "()Z", "M2", "(Z)V", "Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "hybridType", "Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "M1", "()Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;", "u2", "(Lcom/bytedance/android/annie/scheme/vo/refactor/BaseHybridParamVoNew$HybridType;)V", "pullDownIndicatorNotShow", "V1", "C2", "", "indicatorColor", "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "w2", "(Ljava/lang/String;)V", "showClose", "X1", "G2", "showBack", "W1", "F2", "enableShare", "I1", "q2", "forbidRightBack", "J1", "r2", "hideNavBar", "L1", "t2", "isPopUp", "f2", "B2", "isRealFullScreen", "h2", "E2", "statusBarColor", "a2", "J2", "statusBarBgColor", "Z1", "I2", "title", "c2", "L2", "", "bundleWebBgColor", "I", "z1", "()I", "k2", "(I)V", "hideLoading", "K1", "s2", "supportExchangeTheme", "b2", "K2", "closePositionRight", "A1", "l2", "iconTheme", "N1", "v2", "autoShowNavBar", "w1", "j2", "showFloatLive", "Y1", "H2", "titleColor", "d2", "setTitleColor", "navBarColor", "R1", "setNavBarColor", "disableInputScroll", "F1", "n2", "androidSoftInputMode", "u1", "i2", "lazyLoad", "Q1", "y2", "enableCardCache", "G1", "o2", "prerenderCacheKey", "U1", "setPrerenderCacheKey", "enablePadAdapter", "H1", "p2", "", "padRatio", "F", "S1", "()F", "z2", "(F)V", "containerBgColor", "C1", "m2", "pageTag", "T1", "A2", "launchMode", "P1", "x2", "isPullUpPopup", "g2", "D2", "annie_release"}, k = 1, mv = {1, 4, 3})
public class FragmentParamVoNew extends CardParamVoNew {
    public static final Parcelable.Creator<FragmentParamVoNew> CREATOR = null;

    @SerializedName("android_soft_input_mode")
    private int androidSoftInputMode;

    @SerializedName("auto_show_nav_bar")
    private boolean autoShowNavBar;

    @SerializedName("bundle_web_bg_color")
    private int bundleWebBgColor;

    @SerializedName("close_position_right")
    private boolean closePositionRight;

    @SerializedName("container_bg_color")
    private String containerBgColor;

    @SerializedName("disable_input_scroll")
    private boolean disableInputScroll;

    @SerializedName("enable_card_cache")
    private boolean enableCardCache;

    @SerializedName("enable_pad_adapter")
    private boolean enablePadAdapter;

    @SerializedName("enable_share")
    private boolean enableShare;

    @SerializedName("forbid_right_back")
    private boolean forbidRightBack;

    @SerializedName("hide_loading")
    private boolean hideLoading;

    @SerializedName("hide_nav_bar")
    private boolean hideNavBar;

    @SerializedName("hybrid_type")
    private BaseHybridParamVoNew.HybridType hybridType;

    @SerializedName("icon_theme")
    private int iconTheme;

    @SerializedName("pull_down_indicator_color")
    private String indicatorColor;

    @SerializedName("is_pop_up")
    private boolean isPopUp;

    @SerializedName("is_pull_popup")
    private boolean isPullUpPopup;

    @SerializedName("is_real_fullscreen")
    private boolean isRealFullScreen;

    @SerializedName("launch_mode")
    private String launchMode;

    @SerializedName("lazy_load")
    private boolean lazyLoad;

    @SerializedName("nav_bar_color")
    private String navBarColor;

    @SerializedName("pad_ratio")
    private float padRatio;

    @SerializedName("page_tag")
    private String pageTag;

    @SerializedName("prerender_cache_key")
    private String prerenderCacheKey;

    @SerializedName("pull_down_indicator_not_show")
    private boolean pullDownIndicatorNotShow;

    @SerializedName("show_back")
    private boolean showBack;

    @SerializedName("show_close")
    private boolean showClose;

    @SerializedName("show_float_live")
    private boolean showFloatLive;

    @SerializedName("status_bar_bg_color")
    private String statusBarBgColor;

    @SerializedName("status_bar_color")
    private String statusBarColor;

    @SerializedName("support_exchange_theme")
    private boolean supportExchangeTheme;

    @SerializedName("title")
    private String title;

    @SerializedName("title_color")
    private String titleColor;

    @SerializedName("use_received_title")
    private boolean useReceivedTitle;

    public static final class a implements Parcelable.Creator<FragmentParamVoNew> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentParamVoNew createFromParcel(Parcel r39) {
            Intrinsics.checkNotNullParameter(r39, "parcel");
            if (r39.readInt() == 0) goto L5;
            boolean r10 = true;
        L6:
            BaseHybridParamVoNew.HybridType r11 = BaseHybridParamVoNew.HybridType.valueOf(r39.readString());
            if (r39.readInt() == 0) goto L9;
            boolean r12 = true;
        L10:
            String r13 = r39.readString();
            if (r39.readInt() == 0) goto L13;
            boolean r14 = true;
        L15:
            if (r39.readInt() == 0) goto L17;
            boolean r15 = true;
        L19:
            if (r39.readInt() == 0) goto L21;
            boolean r16 = true;
        L23:
            if (r39.readInt() == 0) goto L25;
            boolean r17 = true;
        L27:
            if (r39.readInt() == 0) goto L29;
            boolean r18 = true;
        L31:
            if (r39.readInt() == 0) goto L33;
            boolean r19 = true;
        L35:
            if (r39.readInt() == 0) goto L37;
            boolean r110 = true;
        L38:
            String r111 = r39.readString();
            String r112 = r39.readString();
            String r113 = r39.readString();
            int r114 = r39.readInt();
            if (r39.readInt() == 0) goto L41;
            boolean r115 = true;
        L43:
            if (r39.readInt() == 0) goto L45;
            boolean r20 = true;
        L47:
            if (r39.readInt() == 0) goto L49;
            boolean r21 = true;
        L50:
            int r22 = r39.readInt();
            if (r39.readInt() == 0) goto L53;
            boolean r23 = true;
        L55:
            if (r39.readInt() == 0) goto L57;
            boolean r24 = true;
        L58:
            String r25 = r39.readString();
            String r26 = r39.readString();
            if (r39.readInt() == 0) goto L61;
            boolean r27 = true;
        L62:
            int r28 = r39.readInt();
            if (r39.readInt() == 0) goto L65;
            boolean r29 = true;
        L67:
            if (r39.readInt() == 0) goto L69;
            boolean r30 = true;
        L70:
            String r31 = r39.readString();
            if (r39.readInt() == 0) goto L73;
            boolean r32 = true;
        L74:
            float r33 = r39.readFloat();
            String r34 = r39.readString();
            String r35 = r39.readString();
            String r36 = r39.readString();
            if (r39.readInt() == 0) goto L77;
            boolean r37 = true;
        L79:
            return new FragmentParamVoNew(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37);
        L77:
            r37 = false;
            goto L79
        L73:
            r32 = false;
            goto L74
        L69:
            r30 = false;
            goto L70
        L65:
            r29 = false;
            goto L67
        L61:
            r27 = false;
            goto L62
        L57:
            r24 = false;
            goto L58
        L53:
            r23 = false;
            goto L55
        L49:
            r21 = false;
            goto L50
        L45:
            r20 = false;
            goto L47
        L41:
            r115 = false;
            goto L43
        L37:
            r110 = false;
            goto L38
        L33:
            r19 = false;
            goto L35
        L29:
            r18 = false;
            goto L31
        L25:
            r17 = false;
            goto L27
        L21:
            r16 = false;
            goto L23
        L17:
            r15 = false;
            goto L19
        L13:
            r14 = false;
            goto L15
        L9:
            r12 = false;
            goto L10
        L5:
            r10 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentParamVoNew[] newArray(int r1) {
            return new FragmentParamVoNew[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public FragmentParamVoNew() {
        this(0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.HybridSchemaParam, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeInt(this.useReceivedTitle ? 1 : 0);
        r1.writeString(this.hybridType.name());
        r1.writeInt(this.pullDownIndicatorNotShow ? 1 : 0);
        r1.writeString(this.indicatorColor);
        r1.writeInt(this.showClose ? 1 : 0);
        r1.writeInt(this.showBack ? 1 : 0);
        r1.writeInt(this.enableShare ? 1 : 0);
        r1.writeInt(this.forbidRightBack ? 1 : 0);
        r1.writeInt(this.hideNavBar ? 1 : 0);
        r1.writeInt(this.isPopUp ? 1 : 0);
        r1.writeInt(this.isRealFullScreen ? 1 : 0);
        r1.writeString(this.statusBarColor);
        r1.writeString(this.statusBarBgColor);
        r1.writeString(this.title);
        r1.writeInt(this.bundleWebBgColor);
        r1.writeInt(this.hideLoading ? 1 : 0);
        r1.writeInt(this.supportExchangeTheme ? 1 : 0);
        r1.writeInt(this.closePositionRight ? 1 : 0);
        r1.writeInt(this.iconTheme);
        r1.writeInt(this.autoShowNavBar ? 1 : 0);
        r1.writeInt(this.showFloatLive ? 1 : 0);
        r1.writeString(this.titleColor);
        r1.writeString(this.navBarColor);
        r1.writeInt(this.disableInputScroll ? 1 : 0);
        r1.writeInt(this.androidSoftInputMode);
        r1.writeInt(this.lazyLoad ? 1 : 0);
        r1.writeInt(this.enableCardCache ? 1 : 0);
        r1.writeString(this.prerenderCacheKey);
        r1.writeInt(this.enablePadAdapter ? 1 : 0);
        r1.writeFloat(this.padRatio);
        r1.writeString(this.containerBgColor);
        r1.writeString(this.pageTag);
        r1.writeString(this.launchMode);
        r1.writeInt(this.isPullUpPopup ? 1 : 0);
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public String toString() {
        return super.toString() + "FragmentParamVo(useReceivedTitle=" + this.useReceivedTitle + ", hybridType=" + this.hybridType + ", pullDownIndicatorNotShow=" + this.pullDownIndicatorNotShow + ", indicatorColor=" + this.indicatorColor + ", showClose=" + this.showClose + ", showBack=" + this.showBack + ", enableShare=" + this.enableShare + ", forbidRightBack=" + this.forbidRightBack + ", hideNavBar=" + this.hideNavBar + ", isPopUp=" + this.isPopUp + ", isFullScreen=" + D() + ", transStatusBar=" + r() + ", statusBarColor=" + this.statusBarColor + ", statusBarBgColor=" + this.statusBarBgColor + ", title=" + this.title + ", bundleWebBgColor=" + this.bundleWebBgColor + ", hideLoading=" + this.hideLoading + ", supportExchangeTheme=" + this.supportExchangeTheme + ", closePositionRight=" + this.closePositionRight + ", iconTheme=" + this.iconTheme + ", autoShowNavBar=" + this.autoShowNavBar + ", showFloatLive=" + this.showFloatLive + ", disableInputScroll=" + this.disableInputScroll + ", androidSoftInputMode=" + this.androidSoftInputMode + ", enablePadAdapter=" + this.enablePadAdapter + ", padRatio=" + this.padRatio + ", containerBgColor='" + this.containerBgColor + "', isPullUpPopup=" + this.isPullUpPopup + ')';
    }

    public final boolean A1() {
        return this.closePositionRight;
    }

    public final String C1() {
        return this.containerBgColor;
    }

    public final boolean F1() {
        return this.disableInputScroll;
    }

    public final boolean G1() {
        return this.enableCardCache;
    }

    public final boolean H1() {
        return this.enablePadAdapter;
    }

    public final boolean I1() {
        return this.enableShare;
    }

    public final boolean J1() {
        return this.forbidRightBack;
    }

    public final boolean K1() {
        return this.hideLoading;
    }

    public final boolean L1() {
        return this.hideNavBar;
    }

    public final BaseHybridParamVoNew.HybridType M1() {
        return this.hybridType;
    }

    public final int N1() {
        return this.iconTheme;
    }

    public final String O1() {
        return this.indicatorColor;
    }

    public final String P1() {
        return this.launchMode;
    }

    public final boolean Q1() {
        return this.lazyLoad;
    }

    public final String R1() {
        return this.navBarColor;
    }

    public final float S1() {
        return this.padRatio;
    }

    public final String T1() {
        return this.pageTag;
    }

    public final String U1() {
        return this.prerenderCacheKey;
    }

    public final boolean V1() {
        return this.pullDownIndicatorNotShow;
    }

    public final boolean W1() {
        return this.showBack;
    }

    public final boolean X1() {
        return this.showClose;
    }

    public final boolean Y1() {
        return this.showFloatLive;
    }

    public final String Z1() {
        return this.statusBarBgColor;
    }

    public final String a2() {
        return this.statusBarColor;
    }

    public final boolean b2() {
        return this.supportExchangeTheme;
    }

    public final String c2() {
        return this.title;
    }

    public final String d2() {
        return this.titleColor;
    }

    public final boolean e2() {
        return this.useReceivedTitle;
    }

    public final boolean f2() {
        return this.isPopUp;
    }

    public final boolean g2() {
        return this.isPullUpPopup;
    }

    public final boolean h2() {
        return this.isRealFullScreen;
    }

    public final int u1() {
        return this.androidSoftInputMode;
    }

    public final boolean w1() {
        return this.autoShowNavBar;
    }

    public final int z1() {
        return this.bundleWebBgColor;
    }

    public /* synthetic */ FragmentParamVoNew(int r36) {
        this(false, BaseHybridParamVoNew.HybridType.H5, true, "", false, false, false, false, false, false, false, "", "", "", -1, true, false, true, 0, false, false, "", "", false, -1, false, false, "", false, 0.0f, "", "", "", false);
    }

    public final void A2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.pageTag = r10;
    }

    public final void B2(boolean r1) {
        this.isPopUp = r1;
    }

    public final void C2(boolean r1) {
        this.pullDownIndicatorNotShow = r1;
    }

    public final void D2(boolean r1) {
        this.isPullUpPopup = r1;
    }

    public final void E2(boolean r1) {
        this.isRealFullScreen = r1;
    }

    @Override // com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew, com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew
    public void F(u8.a r37) {
        super.F(r37);
        v8.a r1 = this.T;
        if (r1 == null) goto L87;
        boolean r10 = ((Boolean) r1.b("bundle_user_webview_title", Boolean.FALSE)).booleanValue();
        String r11 = (String) r1.b("status_bar_color", "");
        String r12 = (String) r1.b("status_font_mode", "");
        String r13 = (String) r1.b("status_bar_bg_color", "");
        int r14 = ((Number) r1.b("bundle_web_view_background_color", -1)).intValue();
        String r15 = (String) r1.b("pull_down_indicator_color", "");
        String r16 = (String) r1.b("title", "");
        if (((Number) r1.b("pull_down_indicator_not_show", 0)).intValue() != 1) goto L7;
        boolean r17 = true;
    L9:
        if (((Number) r1.b("hide_loading", 1)).intValue() != 1) goto L11;
        boolean r18 = true;
    L13:
        if (((Number) r1.b("show_close", 0)).intValue() != 1) goto L15;
        boolean r19 = true;
    L17:
        if (((Number) r1.b("hide_nav_bar", 0)).intValue() != 1) goto L19;
        boolean r110 = true;
    L21:
        if (((Number) r1.b("enable_share", 0)).intValue() != 1) goto L23;
        boolean r20 = true;
    L24:
        boolean r111 = r18;
        if (((Number) r1.b("show_back", 0)).intValue() != 1) goto L27;
        boolean r112 = true;
    L29:
        if (((Number) r1.b("forbid_right_back", 0)).intValue() != 1) goto L31;
        boolean r21 = true;
    L33:
        if (((Number) r1.b("disable_back_press", 0)).intValue() != 1) goto L35;
        boolean r113 = true;
    L37:
        if (((Number) r1.b("support_exchange_theme", 0)).intValue() != 1) goto L39;
        boolean r114 = true;
    L40:
        boolean r22 = r114;
        int r23 = ((Number) r1.b("icon_theme", 0)).intValue();
        String r115 = (String) r1.b("title_color", "");
        String r116 = (String) r1.b("nav_bar_color", "");
        if (((Number) r1.b("show_float_live", 0)).intValue() != 1) goto L43;
        boolean r117 = true;
    L44:
        boolean r25 = r117;
        if (((Number) r1.b("auto_show_nav_bar", 0)).intValue() != 1) goto L47;
        boolean r118 = true;
    L48:
        boolean r26 = r118;
        if (((Number) r1.b("disable_input_scroll", 0)).intValue() != 1) goto L51;
        boolean r119 = true;
    L52:
        boolean r38 = r119;
        int r120 = ((Number) r1.b("android_soft_input_mode", -1)).intValue();
        if (((Number) r1.b("lazy_load", 0)).intValue() != 1) goto L55;
        boolean r121 = true;
    L56:
        boolean r28 = r121;
        if (((Number) r1.b("enable_card_cache", 0)).intValue() != 1) goto L59;
        boolean r122 = true;
    L60:
        String r123 = (String) r1.b("prerender_cache_key", "");
        boolean r30 = r122;
        if (((Number) r1.b("enable_pad_adapter", 0)).intValue() != 1) goto L63;
        boolean r124 = true;
    L64:
        boolean r31 = r124;
        float r125 = ((Number) r1.b("pad_ratio", Float.valueOf(0.47368422f))).floatValue();
        String r126 = (String) r1.b("container_bg_color", "");
        CharSequence r127 = (CharSequence) r1.b("page_tag", "");
        if (StringsKt.isBlank(r127) == false) goto L68;
        String r128 = this.b;
        HashMap<String, List<WeakReference<Activity>>> r33 = r7.a.a;
        Intrinsics.checkNotNullParameter(r128, com.bytedance.android.ec.core.event.a.KEY_URL);
        int r129 = x8.a.a;
        x8.a.d("FullScreenPageRecord", "begin generator url " + r128, true);
        StringsKt.isBlank(r128);
        Uri r24 = UriProtector.parse(r128);
        r127 = r24.getHost() + r24.getPath();
    L68:
        String r130 = (String) r127;
        String r27 = (String) r1.b("launch_mode", "");
        if (Intrinsics.areEqual(r12, "dark") == false) goto L72;
        String r29 = IHostContextDepend.SKIN_TYPE_BLACK;
    L79:
        this.useReceivedTitle = r10;
        this.pullDownIndicatorNotShow = r17;
        this.indicatorColor = r15;
        this.showClose = r19;
        this.showBack = r112;
        this.enableShare = r20;
        if (r21 == true) goto L84;
        if (r113 == true) goto L84;
        boolean r131 = false;
    L85:
        this.forbidRightBack = r131;
        this.hideNavBar = r110;
        this.statusBarColor = r29;
        this.statusBarBgColor = r13;
        this.title = r16;
        this.bundleWebBgColor = r14;
        this.hideLoading = r111;
        this.supportExchangeTheme = r22;
        this.iconTheme = r23;
        this.titleColor = v8.a.a(r115);
        this.navBarColor = v8.a.a(r116);
        this.autoShowNavBar = r26;
        this.showFloatLive = r25;
        this.disableInputScroll = r38;
        this.androidSoftInputMode = r120;
        this.lazyLoad = r28;
        this.enableCardCache = r30;
        this.prerenderCacheKey = r123;
        this.enablePadAdapter = r31;
        this.padRatio = r125;
        this.containerBgColor = v8.a.a(r126);
        this.pageTag = r130;
        this.launchMode = r27;
        return;
    L84:
        r131 = true;
        goto L85
    L72:
        if (Intrinsics.areEqual(r12, "light") == false) goto L76;
        r29 = IHostContextDepend.SKIN_TYPE_WHITE;
        goto L79
    L76:
        if ((!StringsKt.isBlank(r12)) == false) goto L78;
        r29 = r12;
        goto L79
    L78:
        r29 = r11;
        goto L79
    L63:
        r124 = false;
        goto L64
    L59:
        r122 = false;
        goto L60
    L55:
        r121 = false;
        goto L56
    L51:
        r119 = false;
        goto L52
    L47:
        r118 = false;
        goto L48
    L43:
        r117 = false;
        goto L44
    L39:
        r114 = false;
        goto L40
    L35:
        r113 = false;
        goto L37
    L31:
        r21 = false;
        goto L33
    L27:
        r112 = false;
        goto L29
    L23:
        r20 = false;
        goto L24
    L19:
        r110 = false;
        goto L21
    L15:
        r19 = false;
        goto L17
    L11:
        r18 = false;
        goto L13
    L7:
        r17 = false;
        goto L9
    }

    public final void F2(boolean r1) {
        this.showBack = r1;
    }

    public final void G2(boolean r1) {
        this.showClose = r1;
    }

    public final void H2(boolean r1) {
        this.showFloatLive = r1;
    }

    public final void I2(String r1) {
        this.statusBarBgColor = r1;
    }

    public final void J2(String r1) {
        this.statusBarColor = r1;
    }

    public final void K2(boolean r1) {
        this.supportExchangeTheme = r1;
    }

    public final void L2(String r1) {
        this.title = r1;
    }

    public final void M2(boolean r1) {
        this.useReceivedTitle = r1;
    }

    public final void i2(int r1) {
        this.androidSoftInputMode = r1;
    }

    public final void j2(boolean r1) {
        this.autoShowNavBar = r1;
    }

    public final void k2(int r1) {
        this.bundleWebBgColor = r1;
    }

    public final void l2(boolean r1) {
        this.closePositionRight = r1;
    }

    public final void m2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.containerBgColor = r10;
    }

    public final void n2(boolean r1) {
        this.disableInputScroll = r1;
    }

    public final void o2(boolean r1) {
        this.enableCardCache = r1;
    }

    public final void p2(boolean r1) {
        this.enablePadAdapter = r1;
    }

    public final void q2(boolean r1) {
        this.enableShare = r1;
    }

    public final void r2(boolean r1) {
        this.forbidRightBack = r1;
    }

    public final void s2(boolean r1) {
        this.hideLoading = r1;
    }

    public final void t2(boolean r1) {
        this.hideNavBar = r1;
    }

    public final void u2(BaseHybridParamVoNew.HybridType r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.hybridType = r10;
    }

    public final void v2(int r1) {
        this.iconTheme = r1;
    }

    public final void w2(String r1) {
        this.indicatorColor = r1;
    }

    public final void x2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.launchMode = r10;
    }

    public final void y2(boolean r1) {
        this.lazyLoad = r1;
    }

    public final void z2(float r1) {
        this.padRatio = r1;
    }

    public FragmentParamVoNew(boolean r10, BaseHybridParamVoNew.HybridType r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r110, String r111, String r20, String r21, int r22, boolean r23, boolean r24, boolean r25, int r26, boolean r27, boolean r28, String r29, String r30, boolean r31, int r32, boolean r33, boolean r34, String r35, boolean r36, float r37, String r38, String r39, String r40, boolean r41) {
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        Intrinsics.checkNotNullParameter(r35, "prerenderCacheKey");
        Intrinsics.checkNotNullParameter(r38, "containerBgColor");
        Intrinsics.checkNotNullParameter(r39, "pageTag");
        Intrinsics.checkNotNullParameter(r40, "launchMode");
        super(0);
        this.useReceivedTitle = r10;
        this.hybridType = r11;
        this.pullDownIndicatorNotShow = r12;
        this.indicatorColor = r13;
        this.showClose = r14;
        this.showBack = r15;
        this.enableShare = r16;
        this.forbidRightBack = r17;
        this.hideNavBar = r18;
        this.isPopUp = r19;
        this.isRealFullScreen = r110;
        this.statusBarColor = r111;
        this.statusBarBgColor = r20;
        this.title = r21;
        this.bundleWebBgColor = r22;
        this.hideLoading = r23;
        this.supportExchangeTheme = r24;
        this.closePositionRight = r25;
        this.iconTheme = r26;
        this.autoShowNavBar = r27;
        this.showFloatLive = r28;
        this.titleColor = r29;
        this.navBarColor = r30;
        this.disableInputScroll = r31;
        this.androidSoftInputMode = r32;
        this.lazyLoad = r33;
        this.enableCardCache = r34;
        this.prerenderCacheKey = r35;
        this.enablePadAdapter = r36;
        this.padRatio = r37;
        this.containerBgColor = r38;
        this.pageTag = r39;
        this.launchMode = r40;
        this.isPullUpPopup = r41;
    }
}
