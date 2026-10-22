package ed;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.core.c;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.f;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.core.kit.bridge.b;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.utils.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.b f16820c;
    public final String d;
    public final IBridgeMethod$Access e;

    public a(rb.b r5, int r10) {
        this.f16819b = r10;
        switch(r10) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f16820c = r5;
        this.e = IBridgeMethod$Access.f5959a;
        this.d = "bullet.startRecord";
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f16820c = r5;
        this.e = IBridgeMethod$Access.f5959a;
        this.d = "bullet.getVisibleInfo";
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        super(r5);
        this.f16820c = r5;
        this.d = "bullet.setTracert";
        this.e = IBridgeMethod$Access.f5959a;
    }

    private final void h() {
    }

    private final void i() {
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final void a(JSONObject r23, sc.a r24) {
        boolean r5 = false;
        e r10 = null;
        String r11 = null;
        r11 = null;
        int r12 = this.f16819b;
        Intrinsics.checkNotNullParameter(r23, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r24, "callback");
        switch(r12) {
            case 0: goto L48;
            case 1: goto L20;
            default: goto L4;
        };
    L4:
        com.bytedance.ies.bullet.core.container.e r13 = (com.bytedance.ies.bullet.core.container.e) this.f16820c.a(com.bytedance.ies.bullet.core.container.e.class);
        if (r13 == null) goto L7;
        e r14 = r13.getBulletContext();
    L8:
        if (r14 == null) goto L13;
        c r15 = r14.f5308w;
        if (r15 == null) goto L13;
        r11 = r15.g;
    L13:
        if (r11 != null) goto L15;
    L18:
        JSONObject r16 = new JSONObject();
        r16.put("code", 1);
        JSONObject r17 = new JSONObject();
        r17.put("visible", Intrinsics.areEqual("-1", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
        Unit r18 = Unit.INSTANCE;
        r16.put("data", r17);
        r24.a(r16);
        return;
    L15:
        if (r11.length() == 0) goto L18;
        JSONObject r19 = new JSONObject();
        r19.put("code", 1);
        JSONObject r20 = new JSONObject();
        r20.put("visible", Intrinsics.areEqual(r11, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST));
        Unit r21 = Unit.INSTANCE;
        r19.put("data", r20);
        r24.a(r19);
        return;
    L7:
        r14 = null;
        goto L8
    L20:
        rb.b r22 = this.f16820c;
        com.bytedance.ies.bullet.core.container.e r110 = (com.bytedance.ies.bullet.core.container.e) r22.a(com.bytedance.ies.bullet.core.container.e.class);
        if (r110 == null) goto L23;
        e r111 = r110.getBulletContext();
    L24:
        if (r111 == null) goto L26;
        String r112 = r111.getSessionId();
    L27:
        if (r112 != null) goto L29;
        r24.onError(-1, "no sessionId");
        return;
    L29:
        Object r25 = r23.opt("categoryDict");
        if ((r25 instanceof JSONObject) == false) goto L32;
        JSONObject r26 = (JSONObject) r25;
    L33:
        Object r27 = r23.opt("timelineDict");
        if ((r27 instanceof JSONObject) == false) goto L36;
        JSONObject r28 = (JSONObject) r27;
    L37:
        com.bytedance.ies.bullet.core.container.e r29 = (com.bytedance.ies.bullet.core.container.e) r22.a(com.bytedance.ies.bullet.core.container.e.class);
        if (r29 == null) goto L40;
        r10 = r29.getBulletContext();
    L40:
        if (r10 == null) goto L44;
        k r30 = r10.d;
        if (r30 == null) goto L44;
        r5 = r30.b(r26, r28);
    L44:
        if (r5 == false) goto L46;
        JSONObject r31 = new JSONObject();
        r31.put("code", 1);
        r24.a(r31);
        return;
    L46:
        JSONObject r32 = new JSONObject();
        r32.put("code", 2);
        r24.a(r32);
        return;
    L36:
        r28 = null;
        goto L37
    L32:
        r26 = null;
        goto L33
    L26:
        r112 = null;
        goto L27
    L23:
        r111 = null;
        goto L24
    L48:
        com.bytedance.ies.bullet.core.container.e r113 = (com.bytedance.ies.bullet.core.container.e) this.f16820c.a(com.bytedance.ies.bullet.core.container.e.class);
        if (r113 == null) goto L51;
        e r114 = r113.getBulletContext();
    L52:
        if (r114 == null) goto L54;
        String r115 = r114.getSessionId();
    L55:
        if (r115 != null) goto L57;
        r24.onError(-1, "no sessionId");
        return;
    L57:
        boolean r33 = r23.optBoolean("once");
        String r116 = r23.optString(STGroup.DICT_KEY);
        Object r117 = r23.opt("frequency");
        Object r34 = r23.opt("category");
        if ((r34 instanceof Map) == false) goto L60;
        Map r35 = (Map) r34;
    L61:
        com.bytedance.ies.bullet.core.container.e r36 = (com.bytedance.ies.bullet.core.container.e) this.f16820c.a(com.bytedance.ies.bullet.core.container.e.class);
        if (r36 == null) goto L64;
        e r37 = r36.getBulletContext();
    L65:
        if (r37 == null) goto L72;
        com.bytedance.ies.bullet.service.monitor.b r38 = r37.f5293c;
        if (r38 == null) goto L72;
        if (r35 == null) goto L70;
        JSONObject r39 = new JSONObject(r35);
    L71:
        r38.k("", r39, null);
        goto L72
    L70:
        r39 = null;
    L72:
        if (r116 == null) goto L129;
        ConcurrentHashMap r40 = dd.c.f16640b;
        JSONObject r41 = d.k("user_interactive_key", r116);
        if (r117 == null) goto L76;
        r41.put("frequency", r117);
    L76:
        r41.put("once", r33);
        Unit r42 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r115, "sessionId");
        Intrinsics.checkNotNullParameter(r41, "json");
        Lazy r43 = f.f5312b;
        f r44 = td.b.b();
        r44.getClass();
        Intrinsics.checkNotNullParameter(r115, "sessionId");
        e r45 = (e) r44.f5313a.get(r115);
        if (r45 == null) goto L81;
        c r46 = r45.f5308w;
        if (r46 == null) goto L81;
        z4.a r47 = r46.f5278i;
    L82:
        if (r47 != null) goto L85;
        r47 = null;
    L85:
        if (r47 == null) goto L128;
        AtomicBoolean r48 = (AtomicBoolean) r47.f23391c;
        if (r48 == null) goto L128;
        if (r48.get() != true) goto L128;
        String r49 = r41.getString("user_interactive_key");
        if (r41.getBoolean("once") == false) goto L93;
        dd.c.c(r115, r49);
        goto L128
    L93:
        ScheduledExecutorService r50 = Executors.newSingleThreadScheduledExecutor();
        if (r50 == null) goto L128;
        dd.c.f16640b.put(r49, r50);
        f r51 = td.b.b();
        r51.getClass();
        Intrinsics.checkNotNullParameter(r115, "sessionId");
        e r52 = (e) r51.f5313a.get(r115);
        if (r52 == null) goto L100;
        c r53 = r52.f5308w;
        if (r53 == null) goto L100;
        z4.a r54 = r53.f5278i;
    L101:
        if (r54 == null) goto L103;
        z4.a r118 = r54;
    L104:
        if (r118 == null) goto L128;
        AtomicBoolean r55 = (AtomicBoolean) r118.f23391c;
        if (r55 != null) goto L108;
    L110:
        long r56 = dd.c.f16639a;
        if (r56 == (-1)) goto L114;
        r118.c(r56, r115, "memory_warning");
    L114:
        if (r41.opt("frequency") == null) goto L116;
        Object r57 = r41.opt("frequency");
        Intrinsics.checkNotNull(r57, "null cannot be cast to non-null type kotlin.Number");
        Number r58 = (Number) r57;
    L125:
        if (Intrinsics.areEqual(r58, 0) == true) goto L128;
        r50.scheduleAtFixedRate(new com.bytedance.apm.e(new Ref.IntRef(), r118, r115, r41.optString("user_interactive_key"), 10), r58.longValue(), r58.longValue(), TimeUnit.SECONDS);
        goto L128
    L116:
        tc.c r59 = tc.c.f22119c;
        com.bytedance.ies.bullet.settings.b r60 = (com.bytedance.ies.bullet.settings.b) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.settings.b.class, com.bytedance.ies.bullet.settings.b.class);
        if (r60 == null) goto L123;
        com.bytedance.ies.bullet.service.base.d r61 = (com.bytedance.ies.bullet.service.base.d) r60.f6163b.getValue();
        if (r61 == null) goto L123;
        r58 = r61.d;
        if (r58 != null) goto L125;
    L123:
        r58 = 0;
        goto L125
    L108:
        if (r55.get() == true) goto L110;
    L103:
        r118 = null;
    L100:
        r54 = null;
    L128:
        JSONObject r62 = new JSONObject();
        r62.put("code", 1);
        r24.a(r62);
        return;
    L81:
        r47 = null;
        goto L82
    L129:
        JSONObject r63 = new JSONObject();
        r63.put("code", 0);
        r24.a(r63);
        return;
    L64:
        r37 = null;
        goto L65
    L60:
        r35 = null;
        goto L61
    L54:
        r115 = null;
        goto L55
    L51:
        r114 = null;
        goto L52
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final IBridgeMethod$Access f() {
        switch(this.f16819b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.e;
    L7:
        return this.e;
    L9:
        return this.e;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b
    public final String g() {
        switch(this.f16819b) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return this.d;
    L7:
        return this.d;
    L9:
        return this.d;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.b, com.bytedance.ies.bullet.service.base.m
    public void release() {
        int r5 = this.f16819b;
    }
}
