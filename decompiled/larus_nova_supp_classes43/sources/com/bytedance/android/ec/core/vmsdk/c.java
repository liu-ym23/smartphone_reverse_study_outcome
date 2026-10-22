package com.bytedance.android.ec.core.vmsdk;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006¨\u00061"}, d2 = {"Lcom/bytedance/android/ec/core/vmsdk/c;", "", "", "ecomVmsdkVerifyBase", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ecomVmsdkVerifyLiveCheck", "g", "ecomVmsdkVerifyECRoomEnterCheck", "d", "ecomVmsdkVerifyGoodsDetailCheck", "e", "ecomVmsdkVerifyVideo", "i", "ecomEnterMall", "getEcomEnterMall", "ecomShopPage", "getEcomShopPage", "ecomWindowPage", "j", "ecomVmsdkVerifyLiveApiRequestCheck", "getEcomVmsdkVerifyLiveApiRequestCheck", "ecomVmsdkVerifyLiveRoomController", "h", "comVmsdkLiveSplicingParams", "getComVmsdkLiveSplicingParams", "ecomVmsdkBuyNowCheck", "a", "ecomVmsdkNativeMallVideo", "getEcomVmsdkNativeMallVideo", "ecomVmsdkNativeCartPage", "b", "ecomVmsdkNativeMallLive", "getEcomVmsdkNativeMallLive", "ecomVmsdkNativeMallChannel", "getEcomVmsdkNativeMallChannel", "ecomVmsdkNativeMallOneoff", "getEcomVmsdkNativeMallOneoff", "ecomVmsdkNativeMallProduct", "getEcomVmsdkNativeMallProduct", "ecomVmsdknativeMallSearch", "getEcomVmsdknativeMallSearch", "ecomVmsdkNativeMallTool", "getEcomVmsdkNativeMallTool", "ecomVmsdkVerifyLiveApiMonitorCheck", "f", "ecom_immersive_goods_feed", "k", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("ecom_vmsdk_live_splicing_params")
    private final String comVmsdkLiveSplicingParams;

    @SerializedName("ecom_enter_mall")
    private final String ecomEnterMall;

    @SerializedName("ecom_shop_page")
    private final String ecomShopPage;

    @SerializedName("ecom_vmsdk_verify_buynow_check")
    private final String ecomVmsdkBuyNowCheck;

    @SerializedName("ecom_native_cart_page")
    private final String ecomVmsdkNativeCartPage;

    @SerializedName("ecom_native_mall_channel")
    private final String ecomVmsdkNativeMallChannel;

    @SerializedName("ecom_native_mall_live")
    private final String ecomVmsdkNativeMallLive;

    @SerializedName("ecom_native_mall_oneoff")
    private final String ecomVmsdkNativeMallOneoff;

    @SerializedName("ecom_native_mall_product")
    private final String ecomVmsdkNativeMallProduct;

    @SerializedName("ecom_native_mall_tool")
    private final String ecomVmsdkNativeMallTool;

    @SerializedName("ecom_native_mall_video")
    private final String ecomVmsdkNativeMallVideo;

    @SerializedName("ecom_vmsdk_verify_base")
    private final String ecomVmsdkVerifyBase;

    @SerializedName("ecom_vmsdk_verify_ec_room_enter_check")
    private final String ecomVmsdkVerifyECRoomEnterCheck;

    @SerializedName("ecom_vmsdk_verify_goods_detail_check")
    private final String ecomVmsdkVerifyGoodsDetailCheck;

    @SerializedName("ecom_vmsdk_verify_live_api_monitor_check")
    private final String ecomVmsdkVerifyLiveApiMonitorCheck;

    @SerializedName("ecom_vmsdk_verify_live_api_request_check")
    private final String ecomVmsdkVerifyLiveApiRequestCheck;

    @SerializedName("ecom_vmsdk_verify_live_check")
    private final String ecomVmsdkVerifyLiveCheck;

    @SerializedName("ecom_vmsdk_verify_live_room_controller")
    private final String ecomVmsdkVerifyLiveRoomController;

    @SerializedName("ecom_short_video")
    private final String ecomVmsdkVerifyVideo;

    @SerializedName("ecom_native_mall_search")
    private final String ecomVmsdknativeMallSearch;

    @SerializedName("ecom_window_page")
    private final String ecomWindowPage;

    @SerializedName("ecom_immersive_goods_feed")
    private final String ecom_immersive_goods_feed;

    public c() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L50;
        c r11 = (c) r10;
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyBase, r11.ecomVmsdkVerifyBase) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveCheck, r11.ecomVmsdkVerifyLiveCheck) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyECRoomEnterCheck, r11.ecomVmsdkVerifyECRoomEnterCheck) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyGoodsDetailCheck, r11.ecomVmsdkVerifyGoodsDetailCheck) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyVideo, r11.ecomVmsdkVerifyVideo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ecomEnterMall, r11.ecomEnterMall) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ecomShopPage, r11.ecomShopPage) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ecomWindowPage, r11.ecomWindowPage) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveApiRequestCheck, r11.ecomVmsdkVerifyLiveApiRequestCheck) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveRoomController, r11.ecomVmsdkVerifyLiveRoomController) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.comVmsdkLiveSplicingParams, r11.comVmsdkLiveSplicingParams) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.ecomVmsdkBuyNowCheck, r11.ecomVmsdkBuyNowCheck) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallVideo, r11.ecomVmsdkNativeMallVideo) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeCartPage, r11.ecomVmsdkNativeCartPage) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallLive, r11.ecomVmsdkNativeMallLive) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallChannel, r11.ecomVmsdkNativeMallChannel) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallOneoff, r11.ecomVmsdkNativeMallOneoff) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallProduct, r11.ecomVmsdkNativeMallProduct) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ecomVmsdknativeMallSearch, r11.ecomVmsdknativeMallSearch) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.ecomVmsdkNativeMallTool, r11.ecomVmsdkNativeMallTool) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.ecomVmsdkVerifyLiveApiMonitorCheck, r11.ecomVmsdkVerifyLiveApiMonitorCheck) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.ecom_immersive_goods_feed, r11.ecom_immersive_goods_feed) == true) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final int hashCode() {
        String r0 = this.ecomVmsdkVerifyBase;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.ecomVmsdkVerifyLiveCheck;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.ecomVmsdkVerifyECRoomEnterCheck;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.ecomVmsdkVerifyGoodsDetailCheck;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.ecomVmsdkVerifyVideo;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.ecomEnterMall;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        String r27 = this.ecomShopPage;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.ecomWindowPage;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        String r33 = this.ecomVmsdkVerifyLiveApiRequestCheck;
        if (r33 == null) goto L37;
        int r34 = r33.hashCode();
    L38:
        int r35 = (r32 + r34) * 31;
        String r36 = this.ecomVmsdkVerifyLiveRoomController;
        if (r36 == null) goto L41;
        int r37 = r36.hashCode();
    L42:
        int r38 = (r35 + r37) * 31;
        String r39 = this.comVmsdkLiveSplicingParams;
        if (r39 == null) goto L45;
        int r40 = r39.hashCode();
    L46:
        int r41 = (r38 + r40) * 31;
        String r42 = this.ecomVmsdkBuyNowCheck;
        if (r42 == null) goto L49;
        int r43 = r42.hashCode();
    L50:
        int r44 = (r41 + r43) * 31;
        String r45 = this.ecomVmsdkNativeMallVideo;
        if (r45 == null) goto L53;
        int r46 = r45.hashCode();
    L54:
        int r47 = (r44 + r46) * 31;
        String r48 = this.ecomVmsdkNativeCartPage;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (r47 + r49) * 31;
        String r51 = this.ecomVmsdkNativeMallLive;
        if (r51 == null) goto L61;
        int r52 = r51.hashCode();
    L62:
        int r53 = (r50 + r52) * 31;
        String r54 = this.ecomVmsdkNativeMallChannel;
        if (r54 == null) goto L65;
        int r55 = r54.hashCode();
    L66:
        int r56 = (r53 + r55) * 31;
        String r57 = this.ecomVmsdkNativeMallOneoff;
        if (r57 == null) goto L69;
        int r58 = r57.hashCode();
    L70:
        int r59 = (r56 + r58) * 31;
        String r60 = this.ecomVmsdkNativeMallProduct;
        if (r60 == null) goto L73;
        int r61 = r60.hashCode();
    L74:
        int r62 = (r59 + r61) * 31;
        String r63 = this.ecomVmsdknativeMallSearch;
        if (r63 == null) goto L77;
        int r64 = r63.hashCode();
    L78:
        int r65 = (r62 + r64) * 31;
        String r66 = this.ecomVmsdkNativeMallTool;
        if (r66 == null) goto L81;
        int r67 = r66.hashCode();
    L82:
        int r68 = (r65 + r67) * 31;
        String r69 = this.ecomVmsdkVerifyLiveApiMonitorCheck;
        if (r69 == null) goto L85;
        int r70 = r69.hashCode();
    L86:
        int r71 = (r68 + r70) * 31;
        String r72 = this.ecom_immersive_goods_feed;
        if (r72 == null) goto L90;
        r1 = r72.hashCode();
    L90:
        return r71 + r1;
    L85:
        r70 = 0;
        goto L86
    L81:
        r67 = 0;
        goto L82
    L77:
        r64 = 0;
        goto L78
    L73:
        r61 = 0;
        goto L74
    L69:
        r58 = 0;
        goto L70
    L65:
        r55 = 0;
        goto L66
    L61:
        r52 = 0;
        goto L62
    L57:
        r49 = 0;
        goto L58
    L53:
        r46 = 0;
        goto L54
    L49:
        r43 = 0;
        goto L50
    L45:
        r40 = 0;
        goto L46
    L41:
        r37 = 0;
        goto L42
    L37:
        r34 = 0;
        goto L38
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "VmSdkResourceConfig(ecomVmsdkVerifyBase=" + this.ecomVmsdkVerifyBase + ", ecomVmsdkVerifyLiveCheck=" + this.ecomVmsdkVerifyLiveCheck + ", ecomVmsdkVerifyECRoomEnterCheck=" + this.ecomVmsdkVerifyECRoomEnterCheck + ", ecomVmsdkVerifyGoodsDetailCheck=" + this.ecomVmsdkVerifyGoodsDetailCheck + ", ecomVmsdkVerifyVideo=" + this.ecomVmsdkVerifyVideo + ", ecomEnterMall=" + this.ecomEnterMall + ", ecomShopPage=" + this.ecomShopPage + ", ecomWindowPage=" + this.ecomWindowPage + ", ecomVmsdkVerifyLiveApiRequestCheck=" + this.ecomVmsdkVerifyLiveApiRequestCheck + ", ecomVmsdkVerifyLiveRoomController=" + this.ecomVmsdkVerifyLiveRoomController + ", comVmsdkLiveSplicingParams=" + this.comVmsdkLiveSplicingParams + ", ecomVmsdkBuyNowCheck=" + this.ecomVmsdkBuyNowCheck + ", ecomVmsdkNativeMallVideo=" + this.ecomVmsdkNativeMallVideo + ", ecomVmsdkNativeCartPage=" + this.ecomVmsdkNativeCartPage + ", ecomVmsdkNativeMallLive=" + this.ecomVmsdkNativeMallLive + ", ecomVmsdkNativeMallChannel=" + this.ecomVmsdkNativeMallChannel + ", ecomVmsdkNativeMallOneoff=" + this.ecomVmsdkNativeMallOneoff + ", ecomVmsdkNativeMallProduct=" + this.ecomVmsdkNativeMallProduct + ", ecomVmsdknativeMallSearch=" + this.ecomVmsdknativeMallSearch + ", ecomVmsdkNativeMallTool=" + this.ecomVmsdkNativeMallTool + ", ecomVmsdkVerifyLiveApiMonitorCheck=" + this.ecomVmsdkVerifyLiveApiMonitorCheck + ", ecom_immersive_goods_feed=" + this.ecom_immersive_goods_feed + ")";
    }

    public final String a() {
        return this.ecomVmsdkBuyNowCheck;
    }

    public final String b() {
        return this.ecomVmsdkNativeCartPage;
    }

    public final String c() {
        return this.ecomVmsdkVerifyBase;
    }

    public final String d() {
        return this.ecomVmsdkVerifyECRoomEnterCheck;
    }

    public final String e() {
        return this.ecomVmsdkVerifyGoodsDetailCheck;
    }

    public final String f() {
        return this.ecomVmsdkVerifyLiveApiMonitorCheck;
    }

    public final String g() {
        return this.ecomVmsdkVerifyLiveCheck;
    }

    public final String h() {
        return this.ecomVmsdkVerifyLiveRoomController;
    }

    public final String i() {
        return this.ecomVmsdkVerifyVideo;
    }

    public final String j() {
        return this.ecomWindowPage;
    }

    public final String k() {
        return this.ecom_immersive_goods_feed;
    }

    public c(int r1) {
        this.ecomVmsdkVerifyBase = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/init.js";
        this.ecomVmsdkVerifyLiveCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/live_check.js";
        this.ecomVmsdkVerifyECRoomEnterCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk_live_enter_check/index.js";
        this.ecomVmsdkVerifyGoodsDetailCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/goods_detail_page_check.js";
        this.ecomVmsdkVerifyVideo = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/video_check.js";
        this.ecomEnterMall = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_enter_mall/index.js";
        this.ecomShopPage = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/shop_check.js";
        this.ecomWindowPage = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/window_check.js";
        this.ecomVmsdkVerifyLiveApiRequestCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/ecom_vmsdk_verify_live_api_request_check.js";
        this.ecomVmsdkVerifyLiveRoomController = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/ecom_vmsdk_verify_live_room_controller.js";
        this.comVmsdkLiveSplicingParams = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_live_splicing_params/index.js";
        this.ecomVmsdkBuyNowCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/buynow_yata_check.js";
        this.ecomVmsdkNativeMallVideo = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_video.js";
        this.ecomVmsdkNativeCartPage = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/cart_check.js";
        this.ecomVmsdkNativeMallLive = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_live.js";
        this.ecomVmsdkNativeMallChannel = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_channel.js";
        this.ecomVmsdkNativeMallOneoff = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_oneoff.js";
        this.ecomVmsdkNativeMallProduct = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_product.js";
        this.ecomVmsdknativeMallSearch = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_search.js";
        this.ecomVmsdkNativeMallTool = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_native_schema_check/ecom_native_mall_tool.js";
        this.ecomVmsdkVerifyLiveApiMonitorCheck = "https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10996/gecko/resource/ecom_vmsdk/ecom_live_api_monitor.js";
        this.ecom_immersive_goods_feed = "https://tosv.byted.org/obj/gecko-internal/10997/gecko/resource/ecom_short_video_track_event/ecom_immersive_goods_feed.js";
    }
}
