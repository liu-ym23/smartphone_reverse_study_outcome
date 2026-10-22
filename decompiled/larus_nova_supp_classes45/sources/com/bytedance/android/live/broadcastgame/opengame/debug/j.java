package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.LogLevel;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends OpenPlatformBaseDebugger implements com.bytedance.android.live.broadcastgame.opengame.j {
    public static final /* synthetic */ int d = 0;
    public final Map<PluginType, com.bytedance.android.live.broadcastgame.opengame.i> a;
    public boolean b;
    public PluginType c;

    public static final class a {
    }

    public static final class b implements OpenPlatformMiniAppDebugger.a {
        public final /* synthetic */ j a;
        public final /* synthetic */ String b;

        @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger.a
        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            f2.c("处理失败：尝试获取长链失败", 0);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger.a
        public final void onSuccess(String r6) {
            Intrinsics.checkNotNullParameter(r6, "httpsLink");
            String r7 = UriProtector.getQueryParameter(UriProtector.parse(r6), "tech_type");
            com.bytedance.android.live.broadcastgame.opengame.i r0 = null;
            if (r7 == null) goto L5;
            Integer r8 = Integer.valueOf(CastIntegerProtector.parseInt(r7));
        L6:
            PluginType.Companion.getClass();
            PluginType r9 = PluginType.a.b(r8);
            PluginType r1 = PluginType.SONIC_GAME;
            if (r9 != r1) goto L15;
            this.a.setPluginType(r9);
            com.bytedance.android.live.broadcastgame.opengame.i r2 = this.a.d(r1);
            if ((r2 instanceof OpenPlatformLiveGameDebugManager) == false) goto L12;
            r0 = r2;
        L12:
            OpenPlatformLiveGameDebugManager r3 = (OpenPlatformLiveGameDebugManager) r0;
            if (r3 == null) goto L17;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r3.e = r9;
            Method r11 = OpenPlatformLiveGameDebugManager.class.getDeclaredMethod("onScanSuccess", new Class[]{String.class});
            r11.setAccessible(true);
            r11.invoke(r3, new Object[]{this.b});
            return;
        L17:
            return;
        L15:
            f2.c("处理失败：无法处理该二维码 " + this.b, 0);
            return;
        L5:
            r8 = null;
            goto L6
        }

        public b(j r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.j
    public final void a() {
        com.bytedance.android.live.broadcastgame.opengame.i r0 = d(PluginType.LYNX);
        if ((r0 instanceof OpenPlatformLiveGameDebugManager) == true) goto L5;
        r0 = null;
    L5:
        OpenPlatformLiveGameDebugManager r1 = (OpenPlatformLiveGameDebugManager) r0;
        if (r1 == null) goto L9;
        r1.a();
        return;
    }

    public j() {
        this.a = new LinkedHashMap();
        this.b = true;
        this.c = PluginType.UNKNOWN_TYPE;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void releaseDebug() {
        super.releaseDebug();
        Iterator r0 = ((LinkedHashMap) this.a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.broadcastgame.opengame.i) ((Map.Entry) r0.next()).getValue()).releaseDebug();
        goto L4
    L6:
        ((LinkedHashMap) this.a).clear();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void stopDebug() {
        super.stopDebug();
        com.bytedance.android.live.broadcastgame.opengame.i r0 = d(PluginType.SONIC_GAME);
        if ((r0 instanceof OpenPlatformLiveGameDebugManager) == true) goto L5;
        r0 = null;
    L5:
        OpenPlatformLiveGameDebugManager r1 = (OpenPlatformLiveGameDebugManager) r0;
        if (r1 == null) goto L9;
        r1.stopDebug();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.debug.c
    public final PluginType getPluginType() {
        return this.c;
    }

    public final com.bytedance.android.live.broadcastgame.opengame.i d(PluginType r9) {
        if (((LinkedHashMap) this.a).get(r9) != null) goto L31;
        int r0 = k.a[r9.ordinal()];
        if (r0 == 1) goto L8;
        if (r0 == 2) goto L8;
        OpenPlatformLiveGameDebugManager r1 = null;
    L11:
        if (r1 == null) goto L31;
        Map r2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("appId", getAppId()), TuplesKt.to("gameId", Long.valueOf(getGameId())), TuplesKt.to("contextWeakRef", getContextWeakRef()), TuplesKt.to("containerViewWeakRef", getContainerViewWeakRef()), TuplesKt.to("pluginManager", getPluginManager())});
        if (r9 != PluginType.LYNX) goto L15;
        r2.put("lynxDebugBridge", new LynxDebugBridge(this.b));
    L15:
        Unit r3 = Unit.INSTANCE;
        Iterator r4 = r2.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L27;
        Map.Entry r5 = (Map.Entry) r4.next();
        String r6 = (String) r5.getKey();
        Class<?> r7 = r1.getClass();
    L19:
        if (r7 == null) goto L26;
        Field r8 = r7.getDeclaredField(r6);     // Catch: NoSuchFieldException -> L24
        if (r8.isAccessible() == true) goto L23;
        r8.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L23:
        r8.set(r1, r5.getValue());
    L24:
        r7 = r7.getSuperclass();
        goto L19
    L26:
        throw new NoSuchFieldException("Field " + r6 + " not found in " + r1.getClass());
    L27:
        this.a.put(r9, r1);
    L8:
        Object r11 = OpenPlatformLiveGameDebugManager.class.newInstance();
        if (r11 == null) goto L29;
        r1 = (OpenPlatformLiveGameDebugManager) r11;
        goto L11
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformLiveGameDebugManager");
    L31:
        return (com.bytedance.android.live.broadcastgame.opengame.i) ((LinkedHashMap) this.a).get(r9);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanFail(int r3) {
        f2.c("扫码失败：错误码 = " + r3, 0);
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final boolean onScanSuccess(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        f2.c("处理失败：无法处理该二维码 " + r8, 0);
        return false;
    L12:
        PluginType.Companion.getClass();
        PluginType r3 = PluginType.a.a(r8);
        if (r3 == null) goto L21;
        int r4 = k.b[r3.ordinal()];
        Object r5 = null;
        if (r4 != 1) goto L18;
    L29:
        com.bytedance.android.live.broadcastgame.opengame.i r6 = d(PluginType.LYNX);
        if ((r6 instanceof OpenPlatformLiveGameDebugManager) == true) goto L32;
        r6 = null;
    L32:
        Object r7 = (OpenPlatformLiveGameDebugManager) r6;
    L33:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.c = r3;
        if (r7 != null) goto L36;
        f2.c("处理失败：" + r3.name() + " 调试器为空", 0);
    L36:
        if (r7 == null) goto L45;
        Method r9 = r7.getClass().getDeclaredMethod("onScanSuccess", new Class[]{String.class});
        r9.setAccessible(true);
        Object r11 = r9.invoke(r7, new Object[]{r8});
        if ((r11 instanceof Boolean) == false) goto L41;
        r5 = r11;
    L41:
        Boolean r12 = (Boolean) r5;
        if (r12 != null) goto L44;
        return false;
    L44:
        return r12.booleanValue();
    L45:
        return false;
    L18:
        if (r4 == 2) goto L29;
        if (r4 != 3) goto L21;
        com.bytedance.android.live.broadcastgame.opengame.i r13 = d(PluginType.MINI_APP);
        if ((r13 instanceof OpenPlatformMiniAppDebugger) == true) goto L26;
        r13 = null;
    L26:
        OpenPlatformMiniAppDebugger r14 = (OpenPlatformMiniAppDebugger) r13;
        r7 = r14;
        if (r14 == null) goto L33;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r14.f = r3;
        r7 = r14;
    L21:
        int r0 = OpenPlatformMiniAppDebugger.h;
        OpenPlatformMiniAppDebugger.Companion.a(r8, new b(this, r8));
        return false;
    L5:
        if (r8.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger
    public final void setPluginType(PluginType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.j
    public final void b(Uri r3, Function3<? super String, ? super String, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaInfo");
        Intrinsics.checkNotNullParameter(r4, "openPanel");
        com.bytedance.android.live.broadcastgame.opengame.i r0 = d(PluginType.LYNX);
        if ((r0 instanceof OpenPlatformLiveGameDebugManager) == true) goto L5;
        r0 = null;
    L5:
        OpenPlatformLiveGameDebugManager r1 = (OpenPlatformLiveGameDebugManager) r0;
        if (r1 == null) goto L9;
        r1.b(r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.j
    public final void c(String r3, LogLevel r4) {
        Intrinsics.checkNotNullParameter(r3, "log");
        Intrinsics.checkNotNullParameter(r4, "level");
        com.bytedance.android.live.broadcastgame.opengame.i r0 = d(PluginType.LYNX);
        if ((r0 instanceof OpenPlatformLiveGameDebugManager) == true) goto L5;
        r0 = null;
    L5:
        OpenPlatformLiveGameDebugManager r1 = (OpenPlatformLiveGameDebugManager) r0;
        if (r1 == null) goto L9;
        r1.c(r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger, com.bytedance.android.live.broadcastgame.opengame.i
    public final void initDebug(Context r2, DataCenter r3, ViewGroup r4, com.bytedance.android.live.broadcastgame.api.openplatform.b r5, Map<String, ? extends Object> r6, com.bytedance.android.live.broadcastgame.opengame.i.a r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, "gameManager");
        Intrinsics.checkNotNullParameter(r6, "extraParams");
        Intrinsics.checkNotNullParameter(r7, "callback");
        super.initDebug(r2, r3, r4, r5, r6, r7);
        Object r8 = r6.get(OpenPlatformBaseDebugger.APP_ID);
        Object r9 = null;
        if ((r8 instanceof String) == true) goto L5;
        r8 = null;
    L5:
        String r11 = (String) r8;
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        setAppId(r11);
        Object r12 = r6.get("game_id");
        if ((r12 instanceof Long) == false) goto L12;
        r9 = r12;
    L12:
        Long r13 = (Long) r9;
        if (r13 == null) goto L15;
        long r14 = r13.longValue();
    L16:
        setGameId(r14);
        this.b = z.e(r3, true);
        createDebugFloatBall();
        r7.onInitSuccess();
        return;
    L15:
        r14 = 0;
        goto L16
    }
}
