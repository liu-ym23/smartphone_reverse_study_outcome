package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarComponentCheckManager {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final HashSet<Integer> c = null;
    public static final SparseArray<ToolbarComponentCheckInterface> d = null;
    public static final HashMap<NewToolbarButtonConstants, Runnable> e = null;
    public static final Map<DataCenter, y> f = null;

    public ToolbarComponentCheckManager() {
    }

    static {
        a = LazyKt.lazy(ToolbarComponentCheckManager$fixSingleton$2.INSTANCE);
        b = LazyKt.lazy(ToolbarComponentCheckManager$fixMml$2.INSTANCE);
        c = new HashSet();
        d = new SparseArray();
        e = new HashMap();
        f = new LinkedHashMap();
    }

    public static void b(final DataCenter r2) {
        n r0 = d(r2);
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        h(r2, ToolbarComponentCheckManager$clear$1.INSTANCE, new ToolbarComponentCheckManager$clear$2(r2));
        if (r2 == null) goto L9;
        f.remove(r2);
        return;
    }

    public static void c(DataCenter r3) {
        h(r3, ToolbarComponentCheckManager$clearCheckList$1.INSTANCE, ToolbarComponentCheckManager$clearCheckList$2.INSTANCE);
        if (((Boolean) b.getValue()).booleanValue() == false) goto L13;
        Map<DataCenter, y> r0 = f;
        if (r0 == null) goto L12;
        TypeIntrinsics.asMutableMap(r0).remove(r3);
        Iterator r4 = ((LinkedHashMap) r0).entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        y r1 = (y) ((Map.Entry) r4.next()).getValue();
        ALogger.i(r1.d, "CheckManager clear check list");
        r1.b.clear();
        r1.c.clear();
        goto L8
    L10:
        ((LinkedHashMap) f).clear();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public static n d(DataCenter r4) {
        if (r4 != null) goto L5;
        ALogger.e("NewToolbarLog", "dataCenter is null.");
    L5:
        boolean r2 = false;
        if (((Boolean) LiveInfraSettingKeys.LIVE_USE_ROOM_TOOLBAR_CHECK_MANAGER.getValue()).booleanValue() == false) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L17;
        if (r4 != null) goto L15;
    L16:
        r2 = true;
        goto L17
    L15:
        if (com.bytedance.android.live.core.utils.a0.d(r4, false) != true) goto L16;
    L17:
        if (r2 == false) goto L22;
        n.a.getClass();
        n r5 = n.a.a(r4);
        if (r5 != null) goto L21;
        ALogger.e("NewToolbarLog", "NewCheckManager is null.");
    L21:
        return r5;
    L22:
        return null;
    L8:
        if (((Boolean) LiveInfraSettingKeys.LIVE_DYNAMIC_TOOLBAR_MODIFY_PERMUTATION.getValue()).booleanValue() == true) goto L11;
        r1 = false;
        goto L12
    }

    public static void f(DataCenter r2, final NewToolbarButtonConstants r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        h(r2, new ToolbarComponentCheckManager$registerPlaceHolder$1(r3), new ToolbarComponentCheckManager$registerPlaceHolder$2(r3));
    }

    public static void g(final DataCenter r2, final NewToolbarButtonConstants r3) {
        Intrinsics.checkNotNullParameter(r3, "toolbarButton");
        n r0 = d(r2);
        if (r0 == null) goto L5;
        r0.d(r3);
    L5:
        h(r2, new ToolbarComponentCheckManager$unregisterFilterService$1(r3), new ToolbarComponentCheckManager$unregisterFilterService$2(r2, r3));
    }

    public static final void a(s r2, Function0 r3, Function1 r4) {
        ToolbarComponentCheckInterface r0 = d.get(r2.a);
        if (r0 == null) goto L5;
        Boolean r5 = Boolean.valueOf(r0.checkThenLoad(r2, r3, r4));
    L6:
        Boolean r1 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r5, r1)) == false) goto L10;
        r3.invoke();
    L10:
        if (Intrinsics.areEqual(r5, r1) == false) goto L13;
        ALogger.i("NewToolbarLog", "component handle! - " + r2);
        return;
    L13:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L15;
        ALogger.i("NewToolbarLog", "component don't handle! - " + r2);
        return;
    L15:
        if (r5 != null) goto L20;
        ALogger.i("NewToolbarLog", "no component filter - " + r2);
        return;
    L20:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static void e(final DataCenter r2, final NewToolbarButtonConstants r3, final ToolbarComponentCheckInterface r4) {
        Intrinsics.checkNotNullParameter(r3, "toolbarButton");
        Intrinsics.checkNotNullParameter(r4, "service");
        n r0 = d(r2);
        if (r0 == null) goto L5;
        r0.b(r3, r4);
    L5:
        ALogger.i("NewToolbarLog", "register filter - " + r3);
        h(r2, new ToolbarComponentCheckManager$registerFilterService$1(r3, r4), new ToolbarComponentCheckManager$registerFilterService$2(r2, r3, r4));
    }

    public static void h(DataCenter r1, Function0 r2, Function1 r3) {
        if (((Boolean) a.getValue()).booleanValue() == true) goto L5;
        r2.invoke();
        return;
    L5:
        if (r1 == null) goto L10;
        Map<DataCenter, y> r4 = f;
        y r0 = (y) ((LinkedHashMap) r4).get(r1);
        if (r0 != null) goto L9;
        r0 = new y();
        r4.put(r1, r0);
    L9:
        r3.invoke(r0);
        return;
    L10:
        SafetyGuard.a(null, null, "ToolbarComponentCheckManager with proxy fail, datacenter is null");
        ALogger.e("NewToolbarLog", "dataCenter is null.");
    }
}
