package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h0 implements View.OnTouchListener {
    public final /* synthetic */ i0 a;

    public h0(i0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r13, MotionEvent r14) {
        if (r14.getAction() != 1) goto L43;
        DressSuitInfo r0 = this.a.f.getTargetUser().getDressSuitInfo();
        if (r0 == null) goto L8;
        String r1 = r0.getUserSuitId();
        if (r1 == null) goto L8;
    L9:
        List r2 = (List) ((Map) rs0.c.a.getValue()).get(r1);
        if (r2 != null) goto L12;
        r2 = CollectionsKt.listOf(new Float[]{Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)});
    L12:
        int r7 = com.bytedance.android.live.profile.j.a.a;
        Intrinsics.checkNotNullParameter(r2, "array");
        float r8 = ((Number) ListProtector.get(r2, 0)).floatValue();
        float r9 = ((Number) ListProtector.get(r2, 1)).floatValue();
        float r10 = ((Number) ListProtector.get(r2, 2)).floatValue();
        float r3 = ((Number) ListProtector.get(r2, 3)).floatValue();
        Pair r15 = TuplesKt.to(Float.valueOf(r14.getX()), Float.valueOf(r14.getY()));
        Intrinsics.checkNotNullParameter(r15, "point");
        Intrinsics.checkNotNullParameter(r13, "view");
        float r12 = r13.getX() + (r13.getMeasuredWidth() * r8);
        float r16 = r13.getY() + (r13.getMeasuredHeight() * r9);
        float r17 = r13.getMeasuredWidth() * r10;
        float r18 = r13.getMeasuredHeight() * r3;
        if (((Number) r15.getFirst()).floatValue() >= r12) goto L15;
    L21:
        boolean r19 = false;
    L22:
        if (r19 == false) goto L43;
        com.bytedance.android.livesdk.log.j0 r110 = com.bytedance.android.livesdk.log.j0.l();
        Pair[] r111 = new Pair[4];
        r111[0] = TuplesKt.to("click_position", "background");
        r111[1] = TuplesKt.to("package_id", r1);
        if (com.bytedance.android.live.profile.ui.base.i.m(this.a.f) == false) goto L26;
        String r4 = DataType.TRUE;
    L27:
        r111[2] = TuplesKt.to("is_self", r4);
        com.bytedance.android.live.profile.ui.base.h r5 = this.a.f;
        Intrinsics.checkNotNullParameter(r5, "$this$targetUserId");
        r111[3] = TuplesKt.to("to_user_id", r5.getPageTypeUseCase().h.toString());
        Map r112 = MapsKt.mutableMapOf(r111);
        DressSuitInfo r6 = this.a.f.getTargetUser().getDressSuitInfo();
        if (r6 == null) goto L41;
        String r20 = r6.getExtra();
        if (r20 == null) goto L41;
        Map r22 = null;
        JsonObject r23 = (JsonObject) GsonHelper.get().fromJson(r20, JsonObject.class);     // Catch: Exception -> L34
    L35:
        if (r23 == null) goto L40;
        GsonMap r24 = UtilsKt.i(r23);
        r22 = new LinkedHashMap(MapsKt.mapCapacity(r24.size()));
        Iterator r25 = r24.entrySet().iterator();
    L38:
        if (r25.hasNext() == false) goto L40;
        Map.Entry r26 = (Map.Entry) r25.next();
        r22.put(r26.getKey(), String.valueOf(r26.getValue()));
    L40:
        if (r22 == null) goto L41;
    L42:
        r112.putAll(r22);
        Unit r27 = Unit.INSTANCE;
        r110.sendLog("livesdk_profile_card_package_skin_click", r112, new Object[]{am2.x.class, IRoom.class});
    L34:
        r23 = null;
    L41:
        r22 = MapsKt.emptyMap();
        goto L42
    L26:
        r4 = DataType.FALSE;
        goto L27
    L15:
        if (((Number) r15.getSecond()).floatValue() < r16) goto L21;
        if (((Number) r15.getFirst()).floatValue() > (r12 + r17)) goto L21;
        if (((Number) r15.getSecond()).floatValue() > (r16 + r18)) goto L21;
        r19 = true;
    L8:
        r1 = "";
    L43:
        return true;
    }
}
