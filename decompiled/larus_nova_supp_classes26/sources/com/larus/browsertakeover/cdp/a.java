package com.larus.browsertakeover.cdp;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.browsertakeover.transport.BrowserTransport;
import com.larus.browsertakeover.transport.f;
import com.larus.utils.logger.FLogger;
import iv8.i0;
import iv8.o;
import iv8.p;
import iv8.q;
import iv8.r;
import iv8.x;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements BrowserTransport.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ BrowserCdpClient b;

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onConnected() {
        if (this.a == this.b.g.get()) goto L5;
        return;
    L5:
        if (this.b.w == false) goto L7;
        return;
    L7:
        if (this.b.v == true) goto L17;
        this.b.v = true;
        this.b.H("cdp");
        if (this.b.y() == false) goto L12;
        BrowserCdpClient r0 = this.b;
        int r1 = this.a;
        r0.h.incrementAndGet();
        r0.x = "bound-page";
        r0.y = r0.G;
        r0.G = null;
        r0.F = null;
        r0.J(BrowserCdpClient.State.ATTACHING);
        r0.r("bound-page", r1);
        return;
    L12:
        BrowserCdpClient r2 = this.b;
        int r3 = this.a;
        r2.getClass();
        r2.J(BrowserCdpClient.State.ATTACHING);
        BrowserCdpClient.Y(r2, "Target.setDiscoverTargets", new JSONObject().put("discover", true), null, false, null, 28);
        r2.k(r3);
        return;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onDisconnected() {
        if (this.a == this.b.g.get()) goto L5;
        return;
    L5:
        if (this.b.w == true) goto L19;
        this.b.G("transport", "peer_disconnected");
        this.b.v = false;
        this.b.l.clear();
        BrowserCdpClient r0 = this.b;
        LinkedHashMap<Integer, String> r1 = r0.n;
        monitor-enter(r1);
        r0.n.clear();     // Catch: Throwable -> L13
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        this.b.Q();
        this.b.J(BrowserCdpClient.State.DISCONNECTED);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onError() {
        if (this.a == this.b.g.get()) goto L5;
        return;
    L5:
        if (this.b.w == true) goto L19;
        this.b.G("transport", "connection_error");
        this.b.v = false;
        this.b.l.clear();
        BrowserCdpClient r0 = this.b;
        LinkedHashMap<Integer, String> r1 = r0.n;
        monitor-enter(r1);
        r0.n.clear();     // Catch: Throwable -> L13
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r1);
        this.b.Q();
        this.b.J(BrowserCdpClient.State.ERROR);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void a(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.a == this.b.g.get()) goto L5;
        return;
    L5:
        if (this.b.w == true) goto L33;
        BrowserCdpClient r0 = this.b;
        int r7 = this.a;
        monitor-enter(r0);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (r0.n() == true) goto L11;
    L25:
        monitor-exit(r0);
        return;
    L11:
        if (r0.v == false) goto L25;
        if (r0.w("bound-page", r7) == false) goto L25;
        String r8 = r10.optString("method");     // Catch: Throwable -> L27
        BrowserCdpClient.C(r0, "cdp_receive", "event", r8, null, 24);     // Catch: Throwable -> L27
        if (r10.has("id") == false) goto L18;
    L23:
        monitor-exit(r0);
        return;
    L18:
        if (Intrinsics.areEqual(r8, "Page.screencastFrame") == false) goto L23;
        r0.o(r10.optJSONObject("params"), "bound-page", r7, true);     // Catch: Throwable -> L27
        monitor-exit(r0);
        return;
    }

    @Override // com.larus.browsertakeover.transport.BrowserTransport.a
    public final void onMessage(String r14) {
        Intrinsics.checkNotNullParameter(r14, "message");
        if (this.a == this.b.g.get()) goto L5;
        return;
    L5:
        if (this.b.w == true) goto L254;
        final BrowserCdpClient r0 = this.b;
        final int r7 = this.a;
        monitor-enter(r0);
    L245:
        th = move-exception;
        throw th;
    L9:
        if (r0.v == true) goto L11;
    L243:
        monitor-exit(r0);
        return;
    L11:
        if (r0.w == true) goto L243;
        if (r7 != r0.g.get()) goto L243;
        if (r14.length() <= 8388608) goto L252;
        FLogger.a.e("BrowserCdpClient", "CDP message exceeded limit");     // Catch: Throwable -> L245
        r0.g();     // Catch: Throwable -> L245
        r0.G("cdp", "message_too_large");     // Catch: Throwable -> L245
        r0.J(BrowserCdpClient.State.ERROR);     // Catch: Throwable -> L245
        monitor-exit(r0);
        return;
    L252:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
        Object r15 = Result.constructor-impl(new JSONObject(r14));     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r15) != null) goto L240;
        JSONObject r16 = (JSONObject) r15;     // Catch: Throwable -> L245
        boolean r9 = true;
        final String r10 = null;
        if (r16.has("id") == false) goto L77;
        int r11 = r16.optInt("id", -1);     // Catch: Throwable -> L245
        BrowserCdpClient.k r12 = r0.l.get(Integer.valueOf(r11));     // Catch: Throwable -> L245
        LinkedHashMap<Integer, String> r2 = r0.n;     // Catch: Throwable -> L245
        monitor-enter(r2);     // Catch: Throwable -> L245
        String r3 = r0.n.remove(Integer.valueOf(r11));     // Catch: Throwable -> L74
        monitor-exit(r2);     // Catch: Throwable -> L245
        if (r3 != null) goto L36;
        if (r12 == null) goto L35;
        r3 = r12.a;     // Catch: Throwable -> L245
        goto L36
    L35:
        String r4 = null;
    L37:
        if (r12 != null) goto L41;
        r0.D("cdp_response_ignored", r4);     // Catch: Throwable -> L245
        monitor-exit(r0);
        return;
    L41:
        BrowserCdpClient.C(r0, "cdp_receive", "response", r4, Integer.valueOf(r11), 16);     // Catch: Throwable -> L245
        if (r12.d == false) goto L44;
    L47:
        String r5 = r16.optString("sessionId");     // Catch: Throwable -> L245
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L245
        if ((!StringsKt.isBlank(r5)) == true) goto L51;
        r5 = null;
    L51:
        if (r5 != null) goto L54;
        r5 = "bound-page";
        if (r0.y() == true) goto L54;
    L55:
        String r6 = r12.b;     // Catch: Throwable -> L245
        if (r6 == null) goto L62;
        if (Intrinsics.areEqual(r10, r6) == true) goto L62;
        monitor-exit(r0);
        return;
    L62:
        if (r0.N(r11) == r12) goto L66;
        monitor-exit(r0);
        return;
    L66:
        if (r16.has("error") == false) goto L69;
        r0.B("cdp_command_failed", "response", r12.a, Integer.valueOf(r11), true);     // Catch: Throwable -> L245
    L71:
        r12.e.invoke(r16);     // Catch: Throwable -> L245
        monitor-exit(r0);
        return;
    L69:
        if (r12.f == null) goto L71;
        FLogger.a.i("BrowserCdpClient", "client=" + r0.o + " generation=" + r7 + " event=page_enable_ready id=" + r11 + " retries=" + (r12.f.size() - 1));     // Catch: Throwable -> L245
    L54:
        r10 = r5;
        goto L55
    L44:
        if (r12.c == r0.h.get()) goto L47;
        monitor-exit(r0);
        return;
    L36:
        r4 = r3;
        goto L37
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L245
    L77:
        String r8 = r16.optString("method");     // Catch: Throwable -> L245
        if (r0.y() == false) goto L87;
        f r13 = f.a;     // Catch: Throwable -> L245
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L245
        boolean r17 = r0.n();     // Catch: Throwable -> L245
        r13.getClass();     // Catch: Throwable -> L245
        Intrinsics.checkNotNullParameter(r8, "method");     // Catch: Throwable -> L245
        if (Intrinsics.areEqual(r8, "Page.screencastFrame") == false) goto L82;
        boolean r18 = !r17;     // Catch: Throwable -> L245
    L83:
        if (r18 == true) goto L87;
        r0.D("cdp_event_ignored", r8);     // Catch: Throwable -> L245
        monitor-exit(r0);
        return;
    L82:
        r18 = f.b.contains(r8);     // Catch: Throwable -> L245
    L87:
        BrowserCdpClient.C(r0, "cdp_receive", "event", r8, null, 24);     // Catch: Throwable -> L245
        JSONObject r19 = r16.optJSONObject("params");     // Catch: Throwable -> L245
        final String r110 = r16.optString("sessionId");     // Catch: Throwable -> L245
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L245
        if ((!StringsKt.isBlank(r110)) == true) goto L91;
        r110 = null;
    L91:
        if (r110 != null) goto L96;
        r110 = "bound-page";
        if (r0.y() == true) goto L96;
        r110 = null;
    L96:
        if (r8 != null) goto L98;
    L238:
        monitor-exit(r0);
        return;
    L98:
        switch(r8.hashCode()) {
            case -1378624189: goto L226;
            case -789158631: goto L219;
            case -654646050: goto L210;
            case -494332091: goto L185;
            case -29564360: goto L181;
            case -26394982: goto L177;
            case 793870872: goto L165;
            case 795089482: goto L150;
            case 1174023384: goto L133;
            case 1593801818: goto L127;
            case 1792618827: goto L110;
            case 1798530217: goto L101;
            default: goto L238;
        };     // Catch: Throwable -> L245
    L101:
        if (r8.equals("Inspector.detached") == false) goto L238;
        if (r110 != null) goto L107;
        monitor-exit(r0);
        return;
    L107:
        if (Intrinsics.areEqual(r110, r0.x) == false) goto L238;
        r0.d.post(new r(r0, r110, r7));     // Catch: Throwable -> L245
        goto L238
    L110:
        if (r8.equals("Target.targetDestroyed") == false) goto L238;
        if (r19 == null) goto L238;
        String r111 = r19.optString("targetId");     // Catch: Throwable -> L245
        if (r111 == null) goto L238;
        if ((!StringsKt.isBlank(r111)) == false) goto L118;
        r10 = r111;
    L118:
        if (r10 == null) goto L238;
        if (Intrinsics.areEqual(r10, r0.y) == false) goto L123;
    L125:
        r0.Q();     // Catch: Throwable -> L245
        r0.J(BrowserCdpClient.State.ATTACHING);     // Catch: Throwable -> L245
        r0.d.postDelayed(new i0(r7, r0), 250);     // Catch: Throwable -> L245
        goto L238
    L123:
        if (Intrinsics.areEqual(r10, r0.z) == true) goto L125;
    L127:
        if (r8.equals("Page.navigatedWithinDocument") == false) goto L238;
        if (Intrinsics.areEqual(r110, r0.x) == false) goto L238;
        r0.U(true);     // Catch: Throwable -> L245
        goto L238
    L133:
        if (r8.equals("Target.targetInfoChanged") == false) goto L238;
        if (r19 == null) goto L137;
        JSONObject r112 = r19.optJSONObject("targetInfo");     // Catch: Throwable -> L245
    L138:
        if (r112 == null) goto L140;
        String r20 = r112.optString("targetId");     // Catch: Throwable -> L245
    L142:
        if (Intrinsics.areEqual(r20, r0.y) == false) goto L238;
        if (r112 == null) goto L145;
        String r113 = r112.optString(ShareType.URL);     // Catch: Throwable -> L245
    L146:
        if (r113 != null) goto L148;
        r113 = "";
    L148:
        r0.I(r113, r7, r0.y, null);     // Catch: Throwable -> L245
        goto L238
    L145:
        r113 = null;
        goto L146
    L140:
        r20 = null;
        goto L142
    L137:
        r112 = null;
        goto L138
    L150:
        if (r8.equals("Target.detachedFromTarget") == false) goto L238;
        if (r19 == null) goto L238;
        String r114 = r19.optString("sessionId");     // Catch: Throwable -> L245
        if (r114 == null) goto L238;
        if ((!StringsKt.isBlank(r114)) == false) goto L158;
        r10 = r114;
    L158:
        if (r10 == null) goto L238;
        if (Intrinsics.areEqual(r10, r0.x) == false) goto L238;
        r0.Q();     // Catch: Throwable -> L245
        r0.J(BrowserCdpClient.State.ATTACHING);     // Catch: Throwable -> L245
        r0.d.postDelayed(new x(r7, r0), 250);     // Catch: Throwable -> L245
        goto L238
    L165:
        if (r8.equals("Page.screencastVisibilityChanged") == false) goto L238;
        if (Intrinsics.areEqual(r110, r0.x) == false) goto L238;
        if (r19 != null) goto L171;
    L173:
        r9 = false;
    L174:
        if (r9 == false) goto L238;
        BrowserCdpClient.a0(r0, "Page.bringToFront", new JSONObject());     // Catch: Throwable -> L245
        goto L238
    L171:
        if (r19.optBoolean("visible", true) == true) goto L173;
    L177:
        if (r8.equals("Target.targetCreated") == false) goto L238;
        r0.q(r19, r7);     // Catch: Throwable -> L245
        goto L238
    L181:
        if (r8.equals("Target.targetCrashed") == false) goto L238;
        r0.p(r19);     // Catch: Throwable -> L245
        goto L238
    L185:
        if (r8.equals("Page.frameNavigated") == false) goto L238;
        if (r19 == null) goto L191;
        JSONObject r21 = r19.optJSONObject("frame");     // Catch: Throwable -> L245
        if (r21 == null) goto L191;
        String r22 = r21.optString("parentId");     // Catch: Throwable -> L245
    L192:
        if (r22 != null) goto L194;
        r22 = "";
    L194:
        if (r110 == null) goto L238;
        if (Intrinsics.areEqual(r110, r0.x) == false) goto L238;
        if (r22.length() == 0) goto L201;
        r9 = false;
    L201:
        if (r9 == false) goto L238;
        if (r19 == null) goto L206;
        JSONObject r23 = r19.optJSONObject("frame");     // Catch: Throwable -> L245
        if (r23 == null) goto L206;
        r10 = r23.optString(ShareType.URL);     // Catch: Throwable -> L245
    L206:
        if (r10 != null) goto L208;
        r10 = "";
    L208:
        r0.d.post(new o(r0, r110, r7, r10));     // Catch: Throwable -> L245
    L191:
        r22 = null;
        goto L192
    L210:
        if (r8.equals("Inspector.targetCrashed") == false) goto L238;
        if (r110 != null) goto L216;
        monitor-exit(r0);
        return;
    L216:
        if (Intrinsics.areEqual(r110, r0.x) == false) goto L238;
        r0.d.post(new q(r0, r110, r7));     // Catch: Throwable -> L245
        goto L238
    L219:
        if (r8.equals("Page.loadEventFired") == false) goto L238;
        if (r110 != null) goto L224;
        monitor-exit(r0);
        return;
    L224:
        r0.d.postDelayed(new p(r0, r110, r7), 250);     // Catch: Throwable -> L245
        goto L238
    L226:
        if (r8.equals("Page.screencastFrame") == false) goto L238;
        if (r0.n() == false) goto L232;
        monitor-exit(r0);
        return;
    L232:
        if (r110 == null) goto L238;
        if (Intrinsics.areEqual(r110, r0.x) == false) goto L236;
        r10 = r110;
    L236:
        if (r10 == null) goto L238;
        r0.o(r19, r10, r7, false);     // Catch: Throwable -> L245
        goto L238
    L240:
        FLogger.a.e("BrowserCdpClient", "received malformed CDP JSON");     // Catch: Throwable -> L245
        monitor-exit(r0);
        return;
    L22:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L245
        r15 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L245
        goto L25
    }

    public a(int r1, BrowserCdpClient r2) {
        this.a = r1;
        this.b = r2;
    }
}
