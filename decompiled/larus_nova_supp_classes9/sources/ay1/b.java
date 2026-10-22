package ay1;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a A = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a A0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a B = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a B0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a C = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a D = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a E = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a F = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a G = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a H = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a I = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a J = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a K = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a L = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a M = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a N = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a O = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a P = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a Q = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a R = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a S = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a T = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a U = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a V = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a W = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a X = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a Y = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a Z = null;
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a a0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a c0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a d0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a e0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a g = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a g0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a h = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a h0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a i = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a i0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a j = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a j0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a k = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a k0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a l = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a l0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a m = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a m0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a n = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a n0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a o = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a o0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a p = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a p0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a q = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a q0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a r = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a r0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a s = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a s0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a t = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a t0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a u = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a u0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a v = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a v0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a w = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a w0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a x = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a x0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a y = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a y0 = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a z = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a z0 = null;

    public static final void A(boolean r3) {
        U.setValue(null, a[58], Boolean.valueOf(r3));
    }

    public static final void B(boolean r3) {
        V.setValue(null, a[59], Boolean.valueOf(r3));
    }

    public static final void C(boolean r3) {
        D.setValue(null, a[34], Boolean.valueOf(r3));
    }

    public static final int a() {
        return ((Number) k.getValue(null, a[10])).intValue();
    }

    public static final Map<String, ArrayList<String>> b() {
        return (Map) y.getValue(null, a[27]);
    }

    public static final HashMap<String, String> c() {
        return (HashMap) G.getValue(null, a[37]);
    }

    public static final HashMap<String, String> d() {
        return (HashMap) H.getValue(null, a[38]);
    }

    public static final HashMap<String, String> e() {
        return (HashMap) F.getValue(null, a[36]);
    }

    public static final HashMap<String, String> f() {
        return (HashMap) A.getValue(null, a[29]);
    }

    public static final HashMap<String, String> g() {
        return (HashMap) z.getValue(null, a[28]);
    }

    public static final HashMap<String, String> h() {
        return (HashMap) B.getValue(null, a[30]);
    }

    public static final HashMap<String, Boolean> i() {
        return (HashMap) i0.getValue(null, a[72]);
    }

    public static final HashSet<String> j() {
        return (HashSet) o.getValue(null, a[17]);
    }

    public static final HashSet<String> k() {
        return (HashSet) w.getValue(null, a[25]);
    }

    public static final HashMap<String, String> l() {
        return (HashMap) q.getValue(null, a[19]);
    }

    public static final Map<String, Boolean> m() {
        return (Map) v.getValue(null, a[24]);
    }

    public static final boolean n() {
        return ((Boolean) u.getValue(null, a[23])).booleanValue();
    }

    public static final boolean o() {
        return ((Boolean) l.getValue(null, a[14])).booleanValue();
    }

    public static final boolean p() {
        return ((Boolean) b0.getValue(null, a[65])).booleanValue();
    }

    public static final boolean q() {
        return ((Boolean) q0.getValue(null, a[82])).booleanValue();
    }

    public static final HashMap<Long, Pair<Integer, Integer>> r() {
        return (HashMap) o0.getValue(null, a[79]);
    }

    public static final HashMap<String, String> s() {
        return (HashMap) Y.getValue(null, a[62]);
    }

    public static final HashSet<Long> t() {
        return (HashSet) M.getValue(null, a[46]);
    }

    public static final int u() {
        return ((Number) b.getValue(null, a[0])).intValue();
    }

    public static final boolean v() {
        return ((Boolean) D.getValue(null, a[34])).booleanValue();
    }

    public static final void w(long r3) {
        K.setValue(null, a[42], Long.valueOf(r3));
    }

    public static final void x(HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        F.setValue(null, a[36], r3);
    }

    public static final void y(HashSet<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        w.setValue(null, a[25], r3);
    }

    public static final void z() {
        c0.setValue(null, a[66], Boolean.TRUE);
    }

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "REQUEST_USER_CONSUME_INFO_LEVEL", "getREQUEST_USER_CONSUME_INFO_LEVEL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_LIVE_ROOM_GUIDE_IS_SHOWED", "getGROUP_LIVE_ROOM_GUIDE_IS_SHOWED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PRICE_ON_GIFT_GUIDE_DIALOG", "getGIFT_PRICE_ON_GIFT_GUIDE_DIALOG()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "HAS_SHOW_GIFT_GUIDE", "getHAS_SHOW_GIFT_GUIDE()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_FAST_GIFT_CONFIRM_RECORD", "getRECOMMEND_FAST_GIFT_CONFIRM_RECORD()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_FAST_GIFT_SHOW_TIMES", "getRECOMMEND_FAST_GIFT_SHOW_TIMES()Lkotlin/Pair;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_TOPICS_DEFAULT_SHOW_RECORD", "getRECOMMEND_TOPICS_DEFAULT_SHOW_RECORD()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "RECOMMEND_TOPICS_LAST_SHOW_TYPE", "getRECOMMEND_TOPICS_LAST_SHOW_TYPE()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "COMMENT_GIFT_GUIDE_CHECK_TIME", "getCOMMENT_GIFT_GUIDE_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "COMMENT_GIFT_GUIDE_DISPLAY_TIME_CURRENT_DAY", "getCOMMENT_GIFT_GUIDE_DISPLAY_TIME_CURRENT_DAY()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "COMMENT_GIFT_GUIDE_DISPLAY_TIME_TOTAL", "getCOMMENT_GIFT_GUIDE_DISPLAY_TIME_TOTAL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOOLBAR_OPEN_ALERT_DIALOG_TOTAL", "getGIFT_TOOLBAR_OPEN_ALERT_DIALOG_TOTAL()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOOLBAR_OPEN_ALERT_DIALOG_LAST_TIME", "getGIFT_TOOLBAR_OPEN_ALERT_DIALOG_LAST_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOOLBAR_OPEN_ALERT_DIALOG_IS_NEW_DIAMOND", "getGIFT_TOOLBAR_OPEN_ALERT_DIALOG_IS_NEW_DIAMOND()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "HAS_PLAY_GIFT_FAILURE_ON_MEDIAPLAYER", "getHAS_PLAY_GIFT_FAILURE_ON_MEDIAPLAYER()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PANEL_SHOWED_MANUAL", "getGIFT_PANEL_SHOWED_MANUAL()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PANEL_OPENED_GUIDE_URL", "getGIFT_PANEL_OPENED_GUIDE_URL()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_HAS_SEND_IN_CLIENT", "getGIFT_HAS_SEND_IN_CLIENT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_HAS_SELECTED_BY_USER_IN_CLIENT", "getGIFT_HAS_SELECTED_BY_USER_IN_CLIENT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_SWEEP_LIGHT_SHOW_TIMES", "getGIFT_SWEEP_LIGHT_SHOW_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_AUDIO_SWITCH_GUIDE_SHOWED", "getLIVE_GIFT_AUDIO_SWITCH_GUIDE_SHOWED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_VIBRATE_SWITCH_GUIDE_SHOWED", "getLIVE_GIFT_VIBRATE_SWITCH_GUIDE_SHOWED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_BUFF_CARD_DETAIL_CLICKED", "getLIVE_BUFF_CARD_DETAIL_CLICKED()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_HIDE_CONFIRM_GIFT", "getGROUP_GIFT_HIDE_CONFIRM_GIFT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_HIDE_CONFIRM_BUFF_GIFT", "getGROUP_GIFT_HIDE_CONFIRM_BUFF_GIFT()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_LIST_TYPE", "getGIFT_LIST_TYPE()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_LIST_TYPE_VS", "getGIFT_LIST_TYPE_VS()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "DIY_GIFT_TOOLBAR_CACHE", "getDIY_GIFT_TOOLBAR_CACHE()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_DIY_CARD_LAST_SEND_IDS", "getGIFT_DIY_CARD_LAST_SEND_IDS()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_DIY_CARD_LAST_SEND_CARD_NAME", "getGIFT_DIY_CARD_LAST_SEND_CARD_NAME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_DIY_CARD_LAST_SEND_TIME", "getGIFT_DIY_CARD_LAST_SEND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_LAST_RECEIVER", "getLIVE_GIFT_LAST_RECEIVER()Lkotlin/Pair;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "SHOW_GIFT_TOOLBAR_RED_DOT", "getSHOW_GIFT_TOOLBAR_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "CLICK_GIFT_TOOLBAR_RED_DOT", "getCLICK_GIFT_TOOLBAR_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "SHOW_GIFT_DIALOG_PROP_RED_DOT", "getSHOW_GIFT_DIALOG_PROP_RED_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_SHOW_SEND_PROPS_TO_LINKER_TIPS", "getLIVE_SHOW_SEND_PROPS_TO_LINKER_TIPS()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_BUFF_CARD_SWEEP_LIGHT_SHOW_TIMES", "getGIFT_BUFF_CARD_SWEEP_LIGHT_SHOW_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_BUFF_CARD_LAST_SEND_IDS", "getGIFT_BUFF_CARD_LAST_SEND_IDS()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_BUFF_CARD_LAST_SEND_TIME", "getGIFT_BUFF_CARD_LAST_SEND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_CUSTOM_GIFT_CARD_HAS_REMIND", "getLIVE_GIFT_CUSTOM_GIFT_CARD_HAS_REMIND()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_PREVIEW_IN_ROOM", "getGIFT_PREVIEW_IN_ROOM()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_ASSET_PREVIEW_IN_ROOM", "getGIFT_ASSET_PREVIEW_IN_ROOM()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "ASSETS_CACHE_LAST_CHECK_TIME", "getASSETS_CACHE_LAST_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "ASSETS_ROOM_DELETE_LAST_CHECK_TIME", "getASSETS_ROOM_DELETE_LAST_CHECK_TIME()J", 1)), Reflection.property0(new PropertyReference0Impl(b.class, "ASSETS_UGC_LAST_CLEAR_CHECK_TIME", "getASSETS_UGC_LAST_CLEAR_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_PANEL_SEND_GIFT_RELATION", "getLIVE_GIFT_PANEL_SEND_GIFT_RELATION()Ljava/util/ArrayList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "PROP_PANEL_SHOWED_RED_POINT", "getPROP_PANEL_SHOWED_RED_POINT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GESTURE_GIFT_RECOGNIZED_MAP", "getLIVE_GESTURE_GIFT_RECOGNIZED_MAP()Ljava/util/List;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "TOOLBAR_GIFT_OPEN_PANEL_PARAMS", "getTOOLBAR_GIFT_OPEN_PANEL_PARAMS()Ljava/util/Map;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_TOP_LYNX_TOUCH_FRE_LIST", "getGIFT_TOP_LYNX_TOUCH_FRE_LIST()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GUEST_BATTLE_SEND_GIFT_HINT_SHOWN", "getGUEST_BATTLE_SEND_GIFT_HINT_SHOWN()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "MIC_ROOM_GIFT_NOTIFY", "getMIC_ROOM_GIFT_NOTIFY()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_ANIMATION_ENABLE_LANDSCAPE", "getGIFT_ANIMATION_ENABLE_LANDSCAPE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "ASSETS_DOWNLOAD_MODEL", "getASSETS_DOWNLOAD_MODEL()Ljava/util/concurrent/ConcurrentHashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_TODAY_FIRST_PLAY_TIME", "getLIVE_TODAY_FIRST_PLAY_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_TODAY_ENTERROOM_MONITOR_FLAG", "getLIVE_TODAY_ENTERROOM_MONITOR_FLAG()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_REPORT_APPASSET_DIR_SIZE_TIME", "getLIVE_REPORT_APPASSET_DIR_SIZE_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_SETTING_AUDIENCE_GIFT_OPEN_VALUE", "getLIVE_SETTING_AUDIENCE_GIFT_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE", "getLIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE_FOR_ANCHOR", "getLIVE_GIFT_SOUND_AND_VIBRATION_OPEN_VALUE_FOR_ANCHOR()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_SOUND_AND_VIBRATION_TOAST_SHOW_STATUS", "getLIVE_GIFT_SOUND_AND_VIBRATION_TOAST_SHOW_STATUS()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PROP_EXPIRE_TIP_TIME", "getLIVE_PROP_EXPIRE_TIP_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PROP_EXPIRE_TIP_TIME_REDDOT", "getLIVE_PROP_EXPIRE_TIP_TIME_REDDOT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PROP_EXPIRE_TIP_TIME_TOAST", "getLIVE_PROP_EXPIRE_TIP_TIME_TOAST()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_IS_CLEAR_SCREEN_OPTIMIZE", "getLIVE_IS_CLEAR_SCREEN_OPTIMIZE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "IN_BYTE_CAST_SCREEN_MODE", "getIN_BYTE_CAST_SCREEN_MODE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_GUIDE_HINT", "getGROUP_GIFT_GUIDE_HINT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GROUP_GIFT_PROP_GUIDE_HINT", "getGROUP_GIFT_PROP_GUIDE_HINT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_CYCLE_RELEASE_ID", "getGIFT_CYCLE_RELEASE_ID()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_CYCLE_RELEASE_GIFT_ID", "getGIFT_CYCLE_RELEASE_GIFT_ID()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "PRIVILEGE_PANEL_SHOWED_RED_POINT", "getPRIVILEGE_PANEL_SHOWED_RED_POINT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "PRIVILEGE_RED_POINT_FIRST_TIME", "getPRIVILEGE_RED_POINT_FIRST_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "GIFT_FIRST_TIME_COMBO_HINT", "getGIFT_FIRST_TIME_COMBO_HINT()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_NOTICED_ROOM", "getLIVE_GIFT_RECEIVER_NOTICED_ROOM()Ljava/util/ArrayList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_NOTICE_COUNT", "getLIVE_GIFT_RECEIVER_NOTICE_COUNT()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_RECEIVER_LAST_NOTICE_TIME", "getLIVE_GIFT_RECEIVER_LAST_NOTICE_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_MINOR_NOTICE_TEXT", "getLIVE_GIFT_MINOR_NOTICE_TEXT()Ljava/lang/String;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_CUSTOM_GIFT_CARD_REMIND_TIME", "getLIVE_GIFT_CUSTOM_GIFT_CARD_REMIND_TIME()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_ANCHOR_TAG", "getLIVE_ANCHOR_TAG()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GOLD_ROCKET_FIRST_TIME_HINT_TIMES", "getLIVE_GOLD_ROCKET_FIRST_TIME_HINT_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_EXPOSURE_ANIM_FREQUENCY", "getLIVE_GIFT_EXPOSURE_ANIM_FREQUENCY()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_FIRST_RECEIVE_INTERACT_GIFT", "getLIVE_GIFT_FIRST_RECEIVE_INTERACT_GIFT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_GIFT_TOOLBAR_SHOW_DOT", "getLIVE_GIFT_INTERACT_GIFT_TOOLBAR_SHOW_DOT()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_INTERACT_GIFT_NOTICE_TIME", "getLIVE_INTERACT_GIFT_NOTICE_TIME()I", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_BATTLE_PROP_LYNX_VIEW_HAS_SHOW", "getLIVE_BATTLE_PROP_LYNX_VIEW_HAS_SHOW()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_EFFECT_DEGRADE_NOTICE_WINDOW_SWITCH", "getLIVE_EFFECT_DEGRADE_NOTICE_WINDOW_SWITCH()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_ASSETS_LRU_CACHE", "getLIVE_ASSETS_LRU_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_PK_PROPCARD_CACHE", "getLIVE_PK_PROPCARD_CACHE()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "MostlyUsedTabNotClicked", "getMostlyUsedTabNotClicked()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_LAST_FREQUENCY_CHECK_TIME", "getLIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_LAST_FREQUENCY_CHECK_TIME()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_SHOW_TIMES", "getLIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_SHOW_TIMES()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_HAS_ENTER_INTERACT_PAGE", "getLIVE_GIFT_INTERACT_PAGE_SCROLL_GUIDE_HAS_ENTER_INTERACT_PAGE()Z", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_ASSET_CLEAN__CACHE_PUSH_SHOW_TIME", "getLIVE_ASSET_CLEAN__CACHE_PUSH_SHOW_TIME()Ljava/util/LinkedList;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_PRICE_OVER_LIMIT", "getLIVE_GIFT_PRICE_OVER_LIMIT()Ljava/util/HashSet;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "LIVE_GIFT_GAME_EFFECT_RED_DOT", "getLIVE_GIFT_GAME_EFFECT_RED_DOT()Z", 1))};
        com.bytedance.tools.kcp.spongepreference.runtime.b r1 = SpongePreferenceManager.a();
        Class r2 = Integer.TYPE;
        b = r1.a("request_user_consume_info_level", -1, r2);
        com.bytedance.tools.kcp.spongepreference.runtime.b r3 = SpongePreferenceManager.a();
        Boolean r4 = Boolean.FALSE;
        Class r5 = Boolean.TYPE;
        r3.a("group_live_room_guide_is_showed", r4, r5);
        c = SpongePreferenceManager.a().a("gift_price_on_gift_guide_dialog", new HashSet(), ql3.a.R);
        d = SpongePreferenceManager.a().a("gift_guide_flag", BuildConfig.FLAVOR, String.class);
        com.bytedance.tools.kcp.spongepreference.runtime.b r6 = SpongePreferenceManager.a();
        Class r7 = Long.TYPE;
        e = r6.a("recommend_fast_gift_confirm_record", 0L, r7);
        f = SpongePreferenceManager.a().a("recommend_fast_gift_show_times", new Pair(0L, 0), ql3.a.S);
        g = SpongePreferenceManager.a().a("recommend_topics_default_show_record", 0L, r7);
        h = SpongePreferenceManager.a().a("recommend_topics_last_show_type", BuildConfig.FLAVOR, String.class);
        i = SpongePreferenceManager.a().a("comment_gift_guide_check_time", 0L, r7);
        j = SpongePreferenceManager.a().a("comment_gift_guide_display_time_current_day", 0, r2);
        k = SpongePreferenceManager.a().a("comment_gift_guide_display_time_total", 0, r2);
        SpongePreferenceManager.a().a("gift_toolbar_open_alert_dialog_total", 0, r2);
        SpongePreferenceManager.a().a("gift_toolbar_open_alert_dialog_last_time", 0L, r7);
        SpongePreferenceManager.a().a("gift_toolbar_open_alert_dialog_is_new_diamond", r4, r5);
        l = SpongePreferenceManager.a().a("has_play_gift_failure_on_mediaplayer", r4, r5);
        m = SpongePreferenceManager.a().a("gift_panel_showed_manual", new HashSet(), ql3.a.s);
        n = SpongePreferenceManager.a().a("gift_panel_opened_guide_url", new HashSet(), ql3.a.n);
        o = SpongePreferenceManager.a().a("gift_has_send_in_client", new HashSet(), ql3.a.O);
        p = SpongePreferenceManager.a().a("gift_has_selected_by_user_in_client_str", new HashSet(), ql3.a.d);
        q = SpongePreferenceManager.a().a("gift_sweep_light_show_times", new HashMap(), ql3.a.k);
        r = SpongePreferenceManager.a().a("live_gift_audio_switch_guide_showed", r4, r5);
        s = SpongePreferenceManager.a().a("live_gift_vibrate_switch_guide_showed", r4, r5);
        t = SpongePreferenceManager.a().a("live_buff_card_detail_clicked", r4, r5);
        u = SpongePreferenceManager.a().a("group_gift_hide_confirm_gift", r4, r5);
        v = SpongePreferenceManager.a().a("group_gift_hide_confirm_buff_gift", MapsKt.emptyMap(), ql3.a.T);
        w = SpongePreferenceManager.a().a("gift_list_type", new HashSet(), ql3.a.y);
        x = SpongePreferenceManager.a().a("gift_list_type_vs", new HashSet(), ql3.a.g);
        y = SpongePreferenceManager.a().a("diy_gift_toolbar_cache", new LinkedHashMap(), ql3.a.l);
        z = SpongePreferenceManager.a().a("gift_diy_card_last_send_ids", new HashMap(), ql3.a.E);
        A = SpongePreferenceManager.a().a("gift_diy_card_last_send_card_name", new HashMap(), ql3.a.v);
        B = SpongePreferenceManager.a().a("gift_diy_card_last_send_time", new HashMap(), ql3.a.p);
        SpongePreferenceManager.a().a("live_gift_last_receiver_cache", new Pair("0", "0"), ql3.a.c);
        SpongePreferenceManager.a().a("show_gift_toolbar_red_dot", r4, r5);
        C = SpongePreferenceManager.a().a("click_gift_toolbar_red_dot", r4, r5);
        D = SpongePreferenceManager.a().a("show_gift_dialog_prop_red_dot", r4, r5);
        E = SpongePreferenceManager.a().a("live_show_send_props_to_linker_tips", r4, r5);
        F = SpongePreferenceManager.a().a("gift_buff_card_sweep_light_show_times", new HashMap(), ql3.a.o);
        G = SpongePreferenceManager.a().a("gift_buff_card_last_send_ids", new HashMap(), ql3.a.r);
        H = SpongePreferenceManager.a().a("gift_buff_card_last_send_time", new HashMap(), ql3.a.A);
        SpongePreferenceManager.a().a("live_gift_custom_gift_card_has_remind", new HashSet(), ql3.a.N);
        I = SpongePreferenceManager.a().a("gift_preview_in_room", r4, r5);
        J = SpongePreferenceManager.a().a("gift_asset_preview_in_room", r4, r5);
        K = SpongePreferenceManager.a().a("assets_cache_last_check_time", 0L, r7);
        SpongePreferenceManager.a().a("assets_room_delete_last_check_time", 0L, r7);
        SpongePreferenceManager.a().a("assets_ugc_gift_last_clear_check_time", 0L, r7);
        L = SpongePreferenceManager.a().a("live_gift_panel_send_gift_relation", new ArrayList(), ql3.a.B);
        M = SpongePreferenceManager.a().a("prop_panel_showed_red_point", new HashSet(), ql3.a.q);
        SpongePreferenceManager.a().a("live_gesture_gift_recognized_map", new ArrayList(), ql3.a.Q);
        N = SpongePreferenceManager.a().a("toolbar_gift_open_panel_params", new HashMap(), ql3.a.P);
        O = SpongePreferenceManager.a().a("gift_top_lynx_touch_fre_list", new HashMap(), ql3.a.b);
        SpongePreferenceManager.a().a("guest_battle_send_gift_shown", r4, r5);
        SpongePreferenceManager.a().a("mic_room_gift_notify", r4, r5);
        com.bytedance.tools.kcp.spongepreference.runtime.b r8 = SpongePreferenceManager.a();
        Boolean r9 = Boolean.TRUE;
        P = r8.a("gift_animation_enable_landscape", r9, r5);
        SpongePreferenceManager.a().a("assets_download_model", new ConcurrentHashMap(), ql3.a.u);
        Q = SpongePreferenceManager.a().a("live_today_first_play_time", 0L, r7);
        R = SpongePreferenceManager.a().a("live_today_enterroom_monitor_flag", r4, r5);
        S = SpongePreferenceManager.a().a("live_report_appasset_dir_size_time", 0L, r7);
        T = SpongePreferenceManager.a().a("live_setting_audience_gift_open_value", r9, r5);
        U = SpongePreferenceManager.a().a("live_gift_sound_and_vibration_open_value", r9, r5);
        V = SpongePreferenceManager.a().a("live_gift_sound_and_vibration_open_value_for_anchor", r9, r5);
        W = SpongePreferenceManager.a().a("live_gift_soound_and_vibration_toast_show_status", r4, r5);
        X = SpongePreferenceManager.a().a("live_prop_expire_tip_time", 0L, r7);
        Y = SpongePreferenceManager.a().a("live_prop_expire_tip_time_reddot", new HashMap(), ql3.a.M);
        Z = SpongePreferenceManager.a().a("live_prop_expire_tip_time_toast", new HashMap(), ql3.a.i);
        a0 = SpongePreferenceManager.a().a("live_clear_screen_optimize", r4, r5);
        b0 = SpongePreferenceManager.a().a("in_byte_cast_screen_mode", r4, r5);
        c0 = SpongePreferenceManager.a().a("group_gift_guide_hint", r4, r5);
        d0 = SpongePreferenceManager.a().a("group_gift_prop_guide_hint", r4, r5);
        e0 = SpongePreferenceManager.a().a("gift_cycle_release_id", -1L, r7);
        f0 = SpongePreferenceManager.a().a("gift_cycle_release_gift_id", -1L, r7);
        g0 = SpongePreferenceManager.a().a("privilege_panel_lock_showed_red_point", new HashSet(), ql3.a.D);
        h0 = SpongePreferenceManager.a().a("privilege_red_point_first_time", 0L, r7);
        i0 = SpongePreferenceManager.a().a("gift_first_time_combo_hint", new HashMap(), ql3.a.e);
        j0 = SpongePreferenceManager.a().a("live_gift_receiver_notice_room", new ArrayList(), ql3.a.h);
        k0 = SpongePreferenceManager.a().a("live_gift_receiver_notice_count", 0, r2);
        l0 = SpongePreferenceManager.a().a("live_gift_receiver_last_notice_time", 0L, r7);
        m0 = SpongePreferenceManager.a().a("live_gift_minor_notice_text", BuildConfig.FLAVOR, String.class);
        n0 = SpongePreferenceManager.a().a("live_gift_custom_gift_card_remind_time", new HashMap(), ql3.a.H);
        SpongePreferenceManager.a().a("live_anchor_tag", r4, r5);
        o0 = SpongePreferenceManager.a().a("live_gold_rocket_first_time_hint_times", new HashMap(), ql3.a.f);
        p0 = SpongePreferenceManager.a().a("live_gift_exposure_anim_frequency", new HashMap(), ql3.a.t);
        SpongePreferenceManager.a().a("live_gift_first_receive_interact_gift", r4, r5);
        q0 = SpongePreferenceManager.a().a("live_gift_interact_gift_toolbar_show_dot", r9, r5);
        r0 = SpongePreferenceManager.a().a("live_interact_gift_notice_time", 0, r2);
        s0 = SpongePreferenceManager.a().a("live_battle_prop_lynx_view_has_show", new HashMap(), ql3.a.a);
        SpongePreferenceManager.a().a("live_effect_degrade_notice_window_switch", r4, r5);
        t0 = SpongePreferenceManager.a().a("live_assets_lru_cache", new HashMap(), ql3.a.m);
        u0 = SpongePreferenceManager.a().a("live_pk_propcard_cache", new HashMap(), ql3.a.x);
        v0 = SpongePreferenceManager.a().a("mostly_used_tab_not_clicked", r9, r5);
        w0 = SpongePreferenceManager.a().a("live_gift_interact_page_scroll_guide_last_frequency_check_time", 0L, r7);
        x0 = SpongePreferenceManager.a().a("live_gift_interact_page_scroll_guide_show_times", new HashMap(), ql3.a.G);
        y0 = SpongePreferenceManager.a().a("live_gift_interact_page_scroll_guide_has_enter_interact_page", r4, r5);
        z0 = SpongePreferenceManager.a().a("live_asset_clean_cache_push_show_time", new LinkedList(), ql3.a.C);
        A0 = SpongePreferenceManager.a().a("live_gift_price_over_limit", new HashSet(), ql3.a.F);
        B0 = SpongePreferenceManager.a().a("live_gift_game_effect_red_dot", r9, r5);
    }
}
