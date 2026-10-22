package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import am2.x;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r6, n5 r7) {
        HashMap r0 = new HashMap();
        String r1 = r7.getScene();
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r0.put("scene", r1);
        String r3 = r7.getSubScene();
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.put("sub_scene", r2);
        r0.put("duration", String.valueOf(f.a(r7)));
        Intrinsics.checkNotNullParameter(r7, "$this$isAssemble");
        n5.e r4 = r7.getDynamicConfig();
        if (r4 == null) goto L12;
        boolean r5 = r4.isAssemble;
    L13:
        String r8 = "1";
        if (r5 == false) goto L16;
        Object r9 = "1";
    L17:
        r0.put("is_assemble", r9);
        n5.e r10 = r7.getDynamicConfig();
        if (r10 == null) goto L20;
        n5.b r11 = r10.comboInfo;
    L21:
        if (r11 != null) goto L24;
        r8 = "0";
    L24:
        r0.put("has_combo", r8);
        Intrinsics.checkNotNullParameter(r7, "$this$displayEffectType");
        n5.e r13 = r7.getDynamicConfig();
        if (r13 == null) goto L27;
        int r14 = r13.displayEffectType;
    L28:
        r0.put("display_effect_type", String.valueOf(r14));
        Intrinsics.checkNotNullParameter(r7, "$this$showPriority");
        n5.f r15 = r7.getPriorityConfig();
        if (r15 == null) goto L31;
        int r16 = r15.priority;
    L32:
        r0.put("priority", String.valueOf(r16));
        Intrinsics.checkNotNullParameter(r7, "$this$priorityLowerStrategy");
        n5.f r17 = r7.getPriorityConfig();
        if (r17 == null) goto L35;
        int r18 = r17.priorityLowerStrategy;
    L36:
        r0.put("priority_lower_strategy", String.valueOf(r18));
        Intrinsics.checkNotNullParameter(r7, "$this$priorityEqualStrategy");
        n5.f r19 = r7.getPriorityConfig();
        if (r19 == null) goto L39;
        int r20 = r19.priorityEqualStrategy;
    L40:
        r0.put("priority_equal_strategy", String.valueOf(r20));
        Intrinsics.checkNotNullParameter(r7, "$this$priorityHigherStrategy");
        n5.f r21 = r7.getPriorityConfig();
        if (r21 == null) goto L43;
        int r23 = r21.priorityHigherStrategy;
    L44:
        r0.put("priority_higher_strategy", String.valueOf(r23));
        Map r24 = r7.getEventParams();
        if (r24 != null) goto L47;
        r24 = MapsKt.emptyMap();
    L47:
        r0.putAll(r24);
        j0.l().sendLog(r6, r0, new Object[]{IRoom.class, x.class});
        return;
    L43:
        r23 = 2;
        goto L44
    L39:
        r20 = 1;
        goto L40
    L35:
        r18 = 0;
        goto L36
    L31:
        r16 = 0;
        goto L32
    L27:
        r14 = 0;
        goto L28
    L20:
        r11 = null;
        goto L21
    L16:
        r9 = "0";
        goto L17
    L12:
        r5 = false;
        goto L13
    }
}
