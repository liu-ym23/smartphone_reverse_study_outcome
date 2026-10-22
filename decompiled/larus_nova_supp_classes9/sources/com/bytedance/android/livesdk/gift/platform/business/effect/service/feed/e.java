package com.bytedance.android.livesdk.gift.platform.business.effect.service.feed;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import yz0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements IRevenueFeedGameEffectServiceContainer, o {
    public zy0.b a;
    public final List<Pair<String, com.bytedance.ies.web.jsbridge2.f.b>> b;
    public boolean c;
    public final List<com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a> d;
    public final CompositeDisposable e;
    public final j f;
    public final rh6.a g;
    public final vh6.b h;
    public final com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.b i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.attach();
        }
    }

    static {
    }

    public final void attach() {
        zy0.b r2 = null;
        jy0.b.c("RevenueFeedGameEffectService", "effectService attach isLiveTypeAudio: " + this.f.getRoom().isLiveTypeAudio(), null, 4);
        if (this.f.getRoom().isLiveTypeAudio() == true) goto L5;
        return;
    L5:
        if (this.a == null) goto L7;
        jy0.b.c("RevenueFeedGameEffectService", "effectService has loaded", null, 4);
        return;
    L7:
        Context r0 = (Context) this.h.a(com.bytedance.android.live.revenue.core.d.a);
        if (r0 == null) goto L45;
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        m.e.getClass();
        Object r6 = m.b(r5).a(Reflection.getOrCreateKotlinClass(vy0.c.class));
        Intrinsics.checkNotNull(r6);
        vy0.c r7 = (f80.a) r6;
        boolean r8 = false;
        String r9 = (String) g.b.getValue(null, g.a[0]);
        LinkedHashMap r10 = new LinkedHashMap();
        IRoomBase r11 = this.f.getRoom();
        if (r11 == null) goto L13;
        String r13 = r11.getIdStr();
        if (r13 == null) goto L13;
    L14:
        r10.put("room_id", r13);
        if (this.i.a == false) goto L17;
        String r14 = "0";
    L18:
        r10.put("first_feed", r14);
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r10, "params");
        if (r9.length() <= 0) goto L21;
        r8 = true;
    L21:
        if (r8 == false) goto L27;
        Uri.Builder r15 = UriProtector.parse(r9).buildUpon();
        Iterator r16 = r10.entrySet().iterator();
    L24:
        if (r16.hasNext() == false) goto L26;
        Map.Entry r17 = (Map.Entry) r16.next();
        r15.appendQueryParameter((String) r17.getKey(), (String) r17.getValue());
        goto L24
    L26:
        Uri r18 = r15.build();
    L28:
        zy0.b r1 = r7.q8(r0, r18, RevenueFeedGameEffectServiceContainer$createService$1$1.INSTANCE);
        if (r1 == null) goto L45;
        Intrinsics.checkNotNullParameter(r1, "hybridCard");
        jy0.b.c("RevenueFeedGameEffectService", "register aio link", null, 4);
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        m.e.getClass();
        Object r4 = m.b(r3).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r4);
        com.bytedance.revenue.platform.api.core.rx.f.a(((f80.a) r4).h(r1, this.g), this.e);
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r19 = ((com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a) r1).d;
        if (r19 == null) goto L33;
        r19.registerMethod("live.requireGiftEffectLynxView", new f(this));
    L33:
        Iterator r20 = ((ArrayList) this.b).iterator();
    L35:
        if (r20.hasNext() == false) goto L41;
        Pair r21 = (Pair) r20.next();
        zy0.b r23 = this.a;
        if (r23 == null) goto L35;
        xy0.a r24 = r23.g();
        if (r24 == null) goto L35;
        r24.registerMethod((String) r21.getFirst(), (com.bytedance.ies.web.jsbridge2.f.b) r21.getSecond());
        goto L35
    L41:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r25 = ((com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a) r1).d;
        if (r25 == null) goto L44;
        r25.load(null, null);
    L44:
        ((ArrayList) this.b).clear();
        r2 = r1;
        goto L45
    L27:
        r18 = Uri.EMPTY;
        goto L28
    L17:
        r14 = "1";
    L13:
        r13 = BuildConfig.FLAVOR;
    L45:
        this.a = r2;
        this.i.a = true;
    }

    public final void deattach() {
        jy0.b.c("RevenueFeedGameEffectService", "effectService deattach", null, 4);
        zy0.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
        this.e.clear();
        ((ArrayList) this.b).clear();
        ((ArrayList) this.d).clear();
        this.c = false;
    }

    public final void onMultiLinkFeedViewCreate() {
        jy0.b.c("RevenueFeedGameEffectService", "onMultiLinkFeedViewCreate", null, 4);
        this.c = true;
        com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a r0 = (com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.a) CollectionsKt.getOrNull(this.d, 0);
        if (r0 == null) goto L7;
        rh6.a r1 = this.g;
        d r2 = (d) m.e.d(r1, d.class);
        if (r2 == null) goto L7;
        r2.a(r0.a, r0.getType(), r0.c, r0.d, r0.e, r0.f, r0.g);
    L7:
        ((ArrayList) this.d).clear();
    }

    public final void onStart() {
        ReadOnlyProperty r0 = g.d;
        KProperty[] r1 = g.a;
        if (((Boolean) r0.getValue(null, r1[2])).booleanValue() == true) goto L6;
        return;
    L6:
        if (((Boolean) g.e.getValue(null, r1[3])).booleanValue() == false) goto L8;
        return;
    L8:
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(((Number) g.c.getValue(null, r1[1])).longValue(), TimeUnit.MILLISECONDS).subscribe(new b(this)), this.e);
    }

    public final void onStop() {
        deattach();
    }

    public final void onMultiLinkFeedTypeChanged(int r7) {
        jy0.b.c("RevenueFeedGameEffectService", "onMultiLinkFeedTypeChanged, uiLayout: " + r7, null, 4);
        if (r7 != 66) goto L8;
        if (((Boolean) g.e.getValue(null, g.a[3])).booleanValue() == false) goto L8;
        attach();
    L8:
        if (((Boolean) g.f.getValue(null, g.a[4])).booleanValue() == false) goto L18;
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L13
        r0.put("ui_layout", r7);     // Catch: Exception -> L13
        zy0.b r8 = this.a;     // Catch: Exception -> L13
        if (r8 == null) goto L19;
        r8.sendJsEvent("live_revenue_game_effect_multilink_feed_type_changed", r0);     // Catch: Exception -> L13
        return;
    L19:
        return;
    L13:
        e = move-exception;
        jy0.b.c("RevenueFeedGameEffectService", "json parse error, detail: " + e.getMessage(), null, 4);
        return;
    }

    public final void registerFeedJsbMethod(String r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "jsbName");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        com.bytedance.ies.web.jsbridge2.f.b r7 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getFeedMultiLinkDynamicJsbMethodProvider(r5, r6);
        xy0.a r2 = null;
        jy0.b.c("RevenueFeedGameEffectService", "registerFeedJsbMethod, " + r5 + ", " + r7, null, 4);
        zy0.b r0 = this.a;
        if (r0 == null) goto L5;
        r2 = r0.g();
    L5:
        if (r2 != null) goto L7;
        ((ArrayList) this.b).add(new Pair(r5, r7));
        return;
    L7:
        zy0.b r1 = this.a;
        if (r1 == null) goto L14;
        xy0.a r3 = r1.g();
        if (r3 == null) goto L15;
        r3.registerMethod(r5, r7);
        return;
    L15:
        return;
    }

    public e(j r2, rh6.a r3, vh6.b r4, com.bytedance.android.livesdk.gift.platform.business.effect.service.feed.b r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "dependencyResolver");
        Intrinsics.checkNotNullParameter(r5, "gameEffectGlobalService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
    }
}
