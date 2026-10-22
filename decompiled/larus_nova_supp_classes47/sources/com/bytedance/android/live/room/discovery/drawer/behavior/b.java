package com.bytedance.android.live.room.discovery.drawer.behavior;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.discovery.drawer.processor.MARQUEE_TRIGGER_STYLE;
import com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveGlobalFrequencyHelper;
import com.bytedance.android.live.room.discovery.drawer.processor.d;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.smartclient.ILiveSmartClientManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.room.discovery.drawer.behavior.a {
    public Disposable a;
    public final com.bytedance.android.live.room.discovery.drawer.processor.b b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.drawer.behavior.b$b, reason: collision with other inner class name */
    public static final class C0207b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0207b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r19) {
            JSONObject r1 = (JSONObject) r19;
            List r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.optString("room_id");
        L7:
            if (r1 == null) goto L9;
            boolean r6 = r1.optBoolean("has_interaction");
        L10:
            if (r1 == null) goto L12;
            int r7 = r1.optInt("decision_is_topic");
        L13:
            d.a("LIveMoreEntranceClientModeBehavior pitayaResult:" + r1 + ", current:" + this.a.b.b().f);
            if (Intrinsics.areEqual(String.valueOf(this.a.b.b().f), r3) == false) goto L40;
            com.bytedance.android.live.room.discovery.drawer.processor.b r4 = this.a.b;
            MARQUEE_TRIGGER_STYLE r5 = MARQUEE_TRIGGER_STYLE.CLIENT_AI_TRIGGER_STYLE;
            LinkedHashMap r8 = new LinkedHashMap();
            r8.put("has_interaction", Boolean.valueOf(r6));
            Map r9 = (Map) MoreLiveGlobalFrequencyHelper.a.getValue();
            LinkedHashMap r10 = new LinkedHashMap();
            Iterator r12 = r9.entrySet().iterator();
        L16:
            boolean r13 = true;
            if (r12.hasNext() == false) goto L26;
            Map.Entry r14 = (Map.Entry) r12.next();
            long r15 = ((Number) r14.getValue()).longValue();
            if (r15 > 0) goto L21;
        L23:
            r13 = false;
        L24:
            if (r13 == false) goto L16;
            r10.put(r14.getKey(), r14.getValue());
            goto L16
        L21:
            if ((System.currentTimeMillis() - r15) >= ((Number) MoreLiveGlobalFrequencyHelper.b.getValue()).longValue()) goto L23;
        L26:
            List r16 = CollectionsKt.toList(r10.keySet());
            if ((!r16.isEmpty()) == false) goto L29;
            r2 = r16;
        L29:
            if (r2 == null) goto L32;
            String r17 = CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, null, 62, null);
            if (r17 == null) goto L32;
        L33:
            r8.put("frequency_control_entrance_list", r17);
            r8.put("display_opportunity", Integer.valueOf(r7));
            Unit r18 = Unit.INSTANCE;
            r4.a(r5, r8);
            return;
        L32:
            r17 = "";
            goto L33
        L40:
            return;
        L12:
            r7 = 0;
            goto L13
        L9:
            r6 = false;
            goto L10
        L5:
            r3 = null;
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.behavior.a
    public final void a() {
        d.a("LIveMoreEntranceClientModeBehavior unBehaviorLoad");
        if (this.b.b().a() == false) goto L8;
        Disposable r0 = this.a;
        if (r0 == null) goto L9;
        r0.dispose();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.behavior.a
    public final void b() {
        if (this.b.b().a() == false) goto L19;
        d.a("LIveMoreEntranceClientModeBehavior onBehaviorLoad");
        IHostBusiness r0 = k.f(IHostBusiness.class);
        Disposable r1 = null;
        if (r0 == null) goto L7;
        ILiveSmartClientManager r2 = r0.getLiveSmartClientManager();
    L9:
        if (r2 == null) goto L11;
        r2.cancelObserve("live_feed_drawer_live_tab_landing");
    L11:
        if (r2 == null) goto L17;
        BehaviorSubject r3 = r2.getOrObserveData("live_feed_drawer_live_tab_landing");
        if (r3 == null) goto L17;
        Observable r4 = r3.compose(RxUtil.rxSchedulerHelper());
        if (r4 == null) goto L17;
        r1 = r4.subscribe(new C0207b(this));
    L17:
        this.a = r1;
        return;
    L7:
        r2 = null;
        goto L9
    }

    public b(com.bytedance.android.live.room.discovery.drawer.processor.b r2) {
        Intrinsics.checkNotNullParameter(r2, "chain");
        this.b = r2;
    }
}
