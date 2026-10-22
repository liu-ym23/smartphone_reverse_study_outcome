package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.config.setting.NewBroadcastSharedConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPanel")
public final class z8 extends com.bytedance.ies.web.jsbridge2.g<b, JSONObject> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/z8$b;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "enterFrom", "a", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("extra")
        private final JsonObject extra;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.enterFrom, r4.enterFrom) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.enterFrom;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            JsonObject r7 = this.extra;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Param(type=" + this.type + ", enterFrom=" + this.enterFrom + ", extra=" + this.extra + ")";
        }

        public final String a() {
            return this.enterFrom;
        }

        public final JsonObject b() {
            return this.extra;
        }

        public final String getType() {
            return this.type;
        }
    }

    static {
    }

    public z8() {
    }

    public static List j(JsonObject r2) {
        if (r2 == null) goto L4;
        ArrayList r0 = new ArrayList();
        JsonArray r3 = r2.getAsJsonArray("highlight");
        if (r3 == null) goto L11;
        Iterator r4 = r3.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        r0.add(((JsonElement) r4.next()).getAsString());
    L11:
        return r0;
    L4:
        return CollectionsKt.emptyList();
    }

    public static void k(int r2, b r3) {
        if ((!Intrinsics.areEqual(r3.a(), "newbie_task")) == false) goto L6;
        return;
    L6:
        if (NewBroadcastSharedConfig.a().booleanValue() == false) goto L10;
        g00.d r4 = (g00.d) com.bytedance.android.scope.m.e.d(f00.a.b, g00.d.class);
        if (r4 == null) goto L15;
        r4.markEnterSceneFromJsb(r2);
        return;
    L15:
        return;
    L10:
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r5 != null) goto L13;
        return;
    L13:
        r5.markEnterSceneFromJsb(r2);
    }

    public final Object invoke(Object r7, CallContext r8) {
        b r9 = (b) r7;
        Intrinsics.checkNotNullParameter(r9, "param");
        Intrinsics.checkNotNullParameter(r8, "callcontext");
        String r11 = r9.getType();
        int r0 = r11.hashCode();
        boolean r2 = true;
        int r5 = 0;
        if (r0 == (-1897185795)) goto L57;
        if (r0 == (-1624529469)) goto L46;
        if (r0 == 3579) goto L34;
        if (r0 == 1787165519) goto L12;
    L59:
        String r12 = r9.getType();
        switch(r12.hashCode()) {
            case -1890252483: goto L92;
            case -1393028996: goto L89;
            case -810698576: goto L85;
            case -365719550: goto L82;
            case -195439392: goto L79;
            case 3449699: goto L77;
            case 155698919: goto L75;
            case 545099575: goto L72;
            case 747804969: goto L69;
            case 1224424441: goto L66;
            case 1260517896: goto L63;
            default: goto L94;
        };
    L77:
        r12.equals("prop");
    L94:
        zg1.b2 r13 = null;
    L95:
        if (r13 == null) goto L97;
        xs2.b.a().post(r13);
    L97:
        return null;
    L63:
        if (r12.equals("room_intro") == false) goto L94;
        r13 = new zg1.b2(4);
        goto L95
    L66:
        if (r12.equals("webview") == false) goto L94;
        JsonObject r14 = r9.b();
        r14.get("type").toString();
        r14.get(LiveSlardarConstants.EXTRA_KEY_URL).toString();
        r14.get("level").getAsInt();
        r13 = new zg1.f2();
        goto L95
    L69:
        if (r12.equals("position") == false) goto L94;
        r13 = new zg1.b2(2);
        goto L95
    L72:
        if (r12.equals("gesture_magic") == false) goto L94;
        r13 = new zg1.z1();
        goto L95
    L75:
        if (r12.equals("gameCenter") == false) goto L94;
        zg1.b2 r15 = new b30.l(j(r9.b()));
        k(15, r9);
    L87:
        r13 = r15;
        goto L95
    L79:
        if (r12.equals("bgMusic") == false) goto L94;
        r15 = new zg1.b2(3);
        k(14, r9);
        goto L87
    L82:
        if (r12.equals("audienceConnection") == false) goto L94;
        r15 = new zg1.b2(1);
        k(19, r9);
        goto L87
    L85:
        if (r12.equals("decoration") == false) goto L94;
        r15 = new b30.j(j(r9.b()));
        goto L87
    L89:
        if (r12.equals(FileUtils.BEAUTY) == false) goto L94;
        r13 = new zg1.b2(0);
        goto L95
    L92:
        if (r12.equals("sticker") == false) goto L94;
        r13 = new zg1.c2(null);
        goto L95
    L12:
        if (r11.equals("pkStartDialog") == false) goto L59;
        JsonObject r16 = r9.b();
        if (r16 != null) goto L16;
    L22:
        int r17 = -1;
    L23:
        JsonObject r1 = r9.b();
        if (r1 != null) goto L26;
    L32:
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().b(r5, r17);
        goto L97
    L26:
        if (r1.has("tabIndex") != true) goto L32;
        JsonObject r18 = r9.b();
        if (r18 == null) goto L32;
        JsonElement r19 = r18.get("tabIndex");
        if (r19 == null) goto L32;
        r5 = r19.getAsInt();
        goto L32
    L16:
        if (r16.has("selectTopPanel") != true) goto L22;
        JsonObject r21 = r9.b();
        if (r21 == null) goto L22;
        JsonElement r22 = r21.get("selectTopPanel");
        if (r22 == null) goto L22;
        r17 = r22.getAsInt();
        goto L23
    L34:
        if (r11.equals("pk") == false) goto L59;
        if (r9.b().has("position") == false) goto L43;
        JsonObject r23 = r9.b();
        if (r23 == null) goto L43;
        JsonElement r24 = r23.get("position");
        if (r24 == null) goto L43;
        String r25 = r24.getAsString();
        if (r25 == null) goto L43;
    L44:
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().a(r25);
    L43:
        r25 = "";
        goto L44
    L46:
        if (r11.equals("link_list") == false) goto L59;
        if (r9.b() != null) goto L50;
    L54:
        r2 = false;
    L55:
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().d(r2);
        goto L97
    L50:
        if (r9.b().has("highlight") == false) goto L54;
        if (r9.b().get("highlight").getAsJsonArray() == null) goto L54;
    L57:
        if (r11.equals("startPk") == false) goto L59;
        ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPanelServiceExternal().c();
        k(17, r9);
        goto L97
    }
}
