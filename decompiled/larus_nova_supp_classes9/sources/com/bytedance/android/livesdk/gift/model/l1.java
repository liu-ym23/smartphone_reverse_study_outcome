package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001VR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R*\u0010\u0015\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0019\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R*\u0010\u001d\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R&\u0010%\u001a\u00060\u001ej\u0002`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\b\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u00100\u001a\u00060\u001ej\u0002`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\b\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R&\u00104\u001a\u00060\u001ej\u0002`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R>\u0010:\u001a&\u0012\u0004\u0012\u00020&\u0012\b\u0012\u00060\u001ej\u0002`\u001f05j\u0012\u0012\u0004\u0012\u00020&\u0012\b\u0012\u00060\u001ej\u0002`\u001f`68&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\b\u001a\u0004\b7\u00108R\"\u0010>\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\b\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u0010\u0006R$\u0010E\u001a\u0004\u0018\u00010?8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bD\u0010\b\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR&\u0010I\u001a\u00060\u001ej\u0002`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bH\u0010\b\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R*\u0010M\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bL\u0010\b\u001a\u0004\bJ\u0010\u0011\"\u0004\bK\u0010\u0013R\"\u0010P\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\b\u001a\u0004\bN\u0010\u0011R:\u0010T\u001a\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020Q\u0018\u000105j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020Q\u0018\u0001`68&X§\u0004¢\u0006\f\u0012\u0004\bS\u0010\b\u001a\u0004\bR\u00108¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/l1;", "Lvh7/c;", BuildConfig.FLAVOR, "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getText$annotations", "()V", "text", "getTextColor", "setTextColor", "getTextColor$annotations", "textColor", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "getBgImg$annotations", "bgImg", "getSweepLightImg", "setSweepLightImg", "getSweepLightImg$annotations", "sweepLightImg", "getBuffDescribeImg", "setBuffDescribeImg", "getBuffDescribeImg$annotations", "buffDescribeImg", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getBuffGiftId", "()J", "setBuffGiftId", "(J)V", "getBuffGiftId$annotations", "buffGiftId", BuildConfig.FLAVOR, "getBuffLevel", "()I", "setBuffLevel", "(I)V", "getBuffLevel$annotations", "buffLevel", "getBuffDiamondCount", "setBuffDiamondCount", "getBuffDiamondCount$annotations", "buffDiamondCount", "getDefaultChose", "setDefaultChose", "getDefaultChose$annotations", "defaultChose", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPageTypeToDefaultChoseActionMap", "()Ljava/util/Map;", "getPageTypeToDefaultChoseActionMap$annotations", "pageTypeToDefaultChoseActionMap", "getLockToast", "setLockToast", "getLockToast$annotations", "lockToast", "Lcom/bytedance/android/livesdk/gift/model/i;", "getLockInfo", "()Lcom/bytedance/android/livesdk/gift/model/i;", "setLockInfo", "(Lcom/bytedance/android/livesdk/gift/model/i;)V", "getLockInfo$annotations", "lockInfo", "getStartTime", "setStartTime", "getStartTime$annotations", "startTime", "getBgImgV2", "setBgImgV2", "getBgImgV2$annotations", "bgImgV2", "getDynamicGiftIcon", "getDynamicGiftIcon$annotations", "dynamicGiftIcon", "Lcom/bytedance/android/livesdk/gift/model/b2;", "getDefaultGiftTextMap", "getDefaultGiftTextMap$annotations", "defaultGiftTextMap", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l1 extends vh7.c<l1> {
    public static final int CHANGE_PANEL_ICON_AFTER_SEND_CARD = 4;
    public static final int CHANGE_PANEL_ICON_BEFORE_SEND_CARD = 1;
    public static final int CHANGE_PANEL_ICON_NO_CARE_SEND_CARD = 16;
    public static final int CHANGE_PANEL_NAME_AFTER_SEND_CARD = 8;
    public static final int CHANGE_PANEL_NAME_BEFORE_SEND_CARD = 2;
    public static final int CHANGE_PANEL_NAME_NO_CARD_SEND_CARD = 32;
    public static final a Companion = null;
    public static final int USE_BASE_GIFT_DIAMOND = 64;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static boolean a(int r0, l1 r1) {
            if ((g(r0, r1) & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean b(int r0, l1 r1) {
            if ((g(r0, r1) & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public static boolean c(int r1, l1 r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if ((g(r1, r2) & 16) != 16) goto L9;
            return true;
        L9:
            return false;
        }

        public static boolean d(int r0, l1 r1) {
            if ((g(r0, r1) & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean e(int r0, l1 r1) {
            if ((g(r0, r1) & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean f(int r1, l1 r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if ((g(r1, r2) & 32) != 32) goto L9;
            return true;
        L9:
            return false;
        }

        public static int g(int r0, l1 r1) {
            if (r1 == null) goto L8;
            Map<Integer, Long> r2 = r1.getPageTypeToDefaultChoseActionMap();
            if (r2 == null) goto L8;
            Long r3 = r2.get(Integer.valueOf(r0));
            if (r3 == null) goto L8;
            return (int) r3.longValue();
        L8:
            return 0;
        }

        public static boolean h(int r1, l1 r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if ((g(r1, r2) & 64) != 64) goto L9;
            return true;
        L9:
            return false;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "bg_img")
    py.k getBgImg();

    @FieldName(name = "bg_img_v2")
    py.k getBgImgV2();

    @FieldName(name = "buff_gift_describe_img")
    py.k getBuffDescribeImg();

    @FieldName(name = "buff_diamond_count")
    long getBuffDiamondCount();

    @FieldName(name = "buff_gift_id")
    long getBuffGiftId();

    @FieldName(name = "buff_level")
    int getBuffLevel();

    @FieldName(name = "default_chose_action")
    long getDefaultChose();

    @FieldName(name = "default_gift_text")
    Map<Integer, b2> getDefaultGiftTextMap();

    @FieldName(name = "gift_icon_asset_img")
    py.k getDynamicGiftIcon();

    @FieldName(name = "buff_lock_info")
    i getLockInfo();

    @FieldName(name = "lock_toast")
    String getLockToast();

    @FieldName(name = "tab_chose_action")
    Map<Integer, Long> getPageTypeToDefaultChoseActionMap();

    @FieldName(name = "start_time")
    long getStartTime();

    @FieldName(name = "sweep_light_img")
    py.k getSweepLightImg();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "text_color")
    String getTextColor();

    @FieldName(name = "bg_img#setter")
    void setBgImg(py.k r1);

    @FieldName(name = "bg_img_v2#setter")
    void setBgImgV2(py.k r1);

    @FieldName(name = "buff_gift_describe_img#setter")
    void setBuffDescribeImg(py.k r1);

    @FieldName(name = "buff_diamond_count#setter")
    void setBuffDiamondCount(long r1);

    @FieldName(name = "buff_gift_id#setter")
    void setBuffGiftId(long r1);

    @FieldName(name = "buff_level#setter")
    void setBuffLevel(int r1);

    @FieldName(name = "default_chose_action#setter")
    void setDefaultChose(long r1);

    @FieldName(name = "buff_lock_info#setter")
    void setLockInfo(i r1);

    @FieldName(name = "lock_toast#setter")
    void setLockToast(String r1);

    @FieldName(name = "start_time#setter")
    void setStartTime(long r1);

    @FieldName(name = "sweep_light_img#setter")
    void setSweepLightImg(py.k r1);

    @FieldName(name = "text#setter")
    void setText(String r1);

    @FieldName(name = "text_color#setter")
    void setTextColor(String r1);
}
