package t41;

import com.bytedance.android.livesdk.model.o0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import vh7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;
    public static final ReadOnlyProperty c = null;
    public static final ReadOnlyProperty d = null;
    public static final ReadOnlyProperty e = null;
    public static final ReadOnlyProperty f = null;
    public static final ReadOnlyProperty g = null;
    public static final ReadOnlyProperty h = null;
    public static final ReadOnlyProperty i = null;
    public static final ReadOnlyProperty j = null;
    public static final ReadOnlyProperty k = null;
    public static final ReadOnlyProperty l = null;
    public static final a m = null;

    public a() {
    }

    public final boolean a() {
        return ((Boolean) j.getValue(this, a[8])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f.getValue(this, a[4])).booleanValue();
    }

    static {
        KProperty[] r0 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedEggsDebug", "getLivePkFeedEggsDebug()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedEggsEnterDebug", "getLivePkFeedEggsEnterDebug()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveVideoLayoutOptValue", "getLiveVideoLayoutOptValue()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkFeedObserveMessageOpt", "getLivePkFeedObserveMessageOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pkPreviewOpt", "getPkPreviewOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePlayerRevSmoothEnterRoom", "getLivePlayerRevSmoothEnterRoom()Lcom/bytedance/android/livesdk/model/RevLivePlayerRevSmoothEnterRoomConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiPreviewEnable", "getLiveMultiPreviewEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "multiFeedViewNew", "getMultiFeedViewNew()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "feedStallOpt", "getFeedStallOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "feedPkBgEnable", "getFeedPkBgEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "screenRecordPlayerFix", "getScreenRecordPlayerFix()Z", 0))};
        a = r0;
        m = new a();
        Boolean r13 = Boolean.FALSE;
        Class r14 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r1 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_eggs_debug", r13, r14, false);
        b = UltraSettingsManager.a().a(r1.a, r1.b, r1.getType(), r1.d, r0[0]);
        Class r15 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_eggs_enter_debug", 0, r15, false);
        c = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r0[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r3 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_video_layout_optimize_value", 124, r15, false);
        d = UltraSettingsManager.a().a(r3.a, r3.b, r3.getType(), r3.d, r0[2]);
        Boolean r4 = Boolean.TRUE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r5 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_observe_message_opt", r4, r14, false);
        e = UltraSettingsManager.a().a(r5.a, r5.b, r5.getType(), r5.d, r0[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r6 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_preview_enable", r13, r14, false);
        f = UltraSettingsManager.a().a(r6.a, r6.b, r6.getType(), r6.d, r0[4]);
        Class r7 = o0.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r8 = b.a;
        Object r9 = r8.get(r7);
        if (r9 != null) goto L12;
        r9 = r7.getConstructor(new Class[0]);
        if (r9 == null) goto L11;
        Object r10 = r8.putIfAbsent(r7, r9);
        if (r10 == null) goto L12;
        r9 = r10;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r12 = ((SerializableObjectJsonAdapterBase) ((Constructor) r9).newInstance(new Object[0])).createInstance();
        if (r12 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r16 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_rev_smooth_enter_room", (o0) r12, o0.class, false);
        g = UltraSettingsManager.a().a(r16.a, r16.b, r16.getType(), r16.d, r0[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r17 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_preview_enable", r13, r14, false);
        h = UltraSettingsManager.a().a(r17.a, r17.b, r17.getType(), r17.d, r0[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r18 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_feedview_new", r4, r14, false);
        i = UltraSettingsManager.a().a(r18.a, r18.b, r18.getType(), r18.d, r0[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r19 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_feed_stall_opt", r4, r14, false);
        j = UltraSettingsManager.a().a(r19.a, r19.b, r19.getType(), r19.d, r0[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r20 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_feed_pk_bg_enable", r4, r14, false);
        k = UltraSettingsManager.a().a(r20.a, r20.b, r20.getType(), r20.d, r0[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r22 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_feed_judge_fix", r4, r14, false);
        l = UltraSettingsManager.a().a(r22.a, r22.b, r22.getType(), r22.d, r0[10]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.model.RevLivePlayerRevSmoothEnterRoomConfig");
    }
}
