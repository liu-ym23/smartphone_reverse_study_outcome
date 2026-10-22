package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import ca0.i;
import com.bytedance.android.live.browser.jsbridge.base.SendInteractEffectEventResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;
import vm2.k;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LynxEffectJsbController {
    public final Object a;

    public static final class a {
    }

    static {
    }

    public LynxEffectJsbController(com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r2) {
        Intrinsics.checkNotNullParameter(r2, "effectManager");
        this.a = r2;
    }

    public final void d(final JsonObject r8, final oh0.a r9) {
        Intrinsics.checkNotNullParameter(r9, "cb");
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxEffectJsbController$sendEffectMessage$1(this, r8, r9), 7);
    }

    public final void e(final JsonObject r9, final oh0.a r10) {
        Intrinsics.checkNotNullParameter(r10, "cb");
        ALogger.i("MicseatMixer#LynxEffectJsbController", "setEffectComposer from script, " + r9);
        if ((this.a instanceof com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a) == true) goto L6;
        ALogger.e("MicseatMixer#LynxEffectJsbController", "setEffectComposer failed, effectManager is null.");
        r10.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L6:
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxEffectJsbController$setEffectComposer$1(this, r9, r10), 7);
    }

    public final void f(JsonObject r11, final Function2<? super z9, ? super Boolean, Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "cb");
        ALogger.i("MicseatMixer#LynxEffectJsbController", "setEffectEnable from script, " + r11);
        JsonElement r2 = r11.get("params");
        if (r2 == null) goto L9;
        JsonObject r3 = r2.getAsJsonObject();
        if (r3 == null) goto L9;
        JsonElement r4 = r3.get("enable");
        if (r4 == null) goto L9;
        final boolean r6 = r4.getAsBoolean();
    L10:
        JsonElement r5 = r11.get("params");
        if (r5 == null) goto L18;
        JsonObject r7 = r5.getAsJsonObject();
        if (r7 == null) goto L18;
        JsonElement r8 = r7.get("scene");
        if (r8 == null) goto L18;
        String r9 = r8.getAsString();
        if (r9 == null) goto L18;
    L19:
        final String r10 = r9;
        if (gh0.a.d() == false) goto L29;
        JsonElement r13 = r11.get("params");
        if (r13 == null) goto L29;
        JsonObject r14 = r13.getAsJsonObject();
        if (r14 == null) goto L29;
        JsonElement r15 = r14.get("isSingleInputMode");
        if (r15 == null) goto L29;
        final int r16 = r15.getAsInt();
    L31:
        if ((this.a instanceof com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a) == true) goto L34;
        ALogger.e("MicseatMixer#LynxEffectJsbController", "setEffectEnable failed.", new Throwable());
        r12.invoke(SendInteractEffectEventResultModel.Code.Failed, Boolean.valueOf(r6));
        return;
    L34:
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxEffectJsbController$setEffectEnable$1(this, r6, r16, r10, r12), 7);
        return;
    L29:
        r16 = 0;
    L18:
        r9 = "";
    L9:
        r6 = false;
        goto L10
    }

    public final void g(final JsonObject r10, final oh0.a r11) {
        Intrinsics.checkNotNullParameter(r11, "cb");
        if (k.b() == true) goto L6;
        r11.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L6:
        ALogger.i("MicseatMixer#LynxEffectJsbController", "setMicseatMixStreamEnable from script, " + r10);
        if ((this.a instanceof com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a) == true) goto L10;
        ALogger.e("MicseatMixer#LynxEffectJsbController", "setMicseatMixStreamEnable failed, effectManager is null.");
        r11.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L10:
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxEffectJsbController$setMicseatMixStreamEnable$1(this, r10, r11), 7);
    }

    public final void h(JsonObject r10, final oh0.a r11) {
        Intrinsics.checkNotNullParameter(r11, "cb");
        if (k.b() == true) goto L6;
        r11.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L6:
        ALogger.i("MicseatMixer#LynxEffectJsbController", "updateMicseatMixStream from script, " + r10);
        if ((this.a instanceof com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a) == true) goto L10;
        ALogger.e("MicseatMixer#LynxEffectJsbController", "updateMicseatMixStream failed, effectManager is null.");
        r11.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L10:
        UtilityKotlinExtentionsKt.s(0, false, false, new LynxEffectJsbController$updateMicseatMixStream$1(r11), 7);
    }

    public static final void a(LynxEffectJsbController r10, JsonObject r11, oh0.a r12) {
        r10.getClass();
        ALogger.e("MicseatMixer#LynxEffectJsbController", "sendEffectMessage from script, " + r11);
        if (r11 == null) goto L7;
        JsonElement r13 = r11.get("params");
        if (r13 == null) goto L7;
        JsonObject r14 = r13.getAsJsonObject();
    L9:
        if (r14 == null) goto L13;
        JsonElement r2 = r14.get("msgID");
        if (r2 == null) goto L13;
        int r4 = r2.getAsInt();
    L14:
        if (r14 == null) goto L18;
        JsonElement r3 = r14.get("arg1");
        if (r3 == null) goto L18;
        int r5 = r3.getAsInt();
    L19:
        if (r14 == null) goto L23;
        JsonElement r6 = r14.get("arg2");
        if (r6 == null) goto L23;
        int r7 = r6.getAsInt();
    L25:
        if (r14 == null) goto L32;
        JsonElement r15 = r14.get("arg3");
        if (r15 == null) goto L32;
        String r16 = r15.getAsString();
        if (r16 == null) goto L32;
        String r8 = r16;
    L33:
        if (r4 > 0) goto L35;
        r12.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L35:
        Object r17 = r10.a;
        if ((r17 instanceof com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a) == true) goto L38;
        r17 = null;
    L38:
        com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r18 = (com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a) r17;
        if (r18 == null) goto L43;
        Intrinsics.checkNotNullParameter(r8, "arg3");
        long r9 = com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a.i.nextLong();
        boolean r19 = r18.c();
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "sendEffectMessage.session:" + r9 + ". useLiveCore:" + r19 + ", msgId:" + r4 + ", arg1:" + r5 + ", arg2:" + r7 + ", arg3:" + r8);
        i r20 = r18.e;
        if (r20 == null) goto L43;
        r20.b(r4, r5, r7, r8, r19);
    L43:
        r12.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L32:
        r8 = "";
    L23:
        r7 = 0;
    L18:
        r5 = 0;
    L13:
        r4 = 0;
    L7:
        r14 = null;
        goto L9
    }

    public static final void b(LynxEffectJsbController r12, JsonObject r13, com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r14, final oh0.a r15) {
        r12.getClass();
        if (r13 == null) goto L7;
        JsonElement r16 = r13.get("params");
        if (r16 == null) goto L7;
        JsonObject r17 = r16.getAsJsonObject();
    L9:
        if (r17 == null) goto L14;
        JsonElement r2 = r17.get("name");
        if (r2 == null) goto L14;
        String r3 = r2.getAsString();
        if (r3 == null) goto L14;
    L15:
        if (r17 == null) goto L20;
        JsonElement r4 = r17.get("nodeTags");
        if (r4 == null) goto L20;
        JsonArray r5 = r4.getAsJsonArray();
        if (r5 == null) goto L20;
    L22:
        if (r17 == null) goto L31;
        JsonElement r0 = r17.get("params");
        if (r0 == null) goto L31;
        JsonObject r1 = r0.getAsJsonObject();
        if (r1 == null) goto L31;
        JsonElement r6 = r1.get("scene");
        if (r6 == null) goto L31;
        String r7 = r6.getAsString();
        if (r7 == null) goto L31;
    L32:
        ArrayList r8 = new ArrayList();
        int r9 = r5.size();
        int r10 = 0;
    L33:
        if (r10 >= r9) goto L35;
        r8.add(r5.get(r10).getAsString());
        r10 = r10 + 1;
        goto L33
    L35:
        if (r17 == null) goto L40;
        JsonElement r18 = r17.get("nodePaths");
        if (r18 == null) goto L40;
        JsonArray r19 = r18.getAsJsonArray();
        if (r19 == null) goto L40;
    L41:
        ArrayList r11 = new ArrayList();
        int r20 = r19.size();
        int r21 = 0;
    L42:
        if (r21 >= r20) goto L45;
        r11.add(r19.get(r21).getAsString());
        r21 = r21 + 1;
        goto L42
    L45:
        switch(r3.hashCode()) {
            case -860210598: goto L63;
            case 1389977506: goto L60;
            case 1478557334: goto L57;
            case 2101172676: goto L48;
            default: goto L75;
        };
    L75:
        r15.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L48:
        if (r3.equals("removeComposer") == false) goto L75;
        Object[] r110 = r11.toArray(new String[0]);
        if (r110 == null) goto L55;
        String[] r111 = (String[]) r110;
        Function1<Boolean, Unit> r112 = new LynxEffectJsbController$setEffectComposerImpl$2(r15);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r111, "nodes");
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r112, "cb");
        long r22 = com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a.i.nextLong();
        boolean r113 = r14.c();
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "removeComposer.session:" + r22 + ". useLiveCore:" + r113);
        e r23 = new e(r22, r112);
        i r114 = r14.e;
        if (r114 == null) goto L79;
        r114.c(r111, r23, r113);
        return;
    L79:
        return;
    L55:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L57:
        if (r3.equals("getComposer") == false) goto L75;
        r15.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L60:
        if (r3.equals("setComposer") == false) goto L75;
        r15.a(SendInteractEffectEventResultModel.Code.Failed, "", null);
        return;
    L63:
        if (r3.equals("appendComposer") == false) goto L75;
        Object[] r115 = r11.toArray(new String[0]);
        if (r115 == null) goto L74;
        String[] r116 = (String[]) r115;
        Object[] r117 = r8.toArray(new String[0]);
        if (r117 == null) goto L72;
        String[] r118 = (String[]) r117;
        Function1<Boolean, Unit> r24 = new LynxEffectJsbController$setEffectComposerImpl$1(r15);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r116, "nodes");
        Intrinsics.checkNotNullParameter(r118, "tags");
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r24, "cb");
        long r25 = com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a.i.nextLong();
        boolean r119 = r14.c();
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "appendComposer.session:" + r25 + ". useLiveCore:" + r119 + ", nodes:" + r116[0] + ", tags:" + r118[0]);
        b r26 = new b(r25, r24);
        i r120 = r14.e;
        if (r120 == null) goto L83;
        r120.a(r116, r118, r26, r119);
        return;
    L83:
        return;
    L72:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L40:
        r19 = new JsonArray();
    L31:
        r7 = "";
    L20:
        r5 = new JsonArray();
    L14:
        r3 = "";
    L7:
        r17 = null;
        goto L9
    }

    public static final void c(LynxEffectJsbController r3, JsonObject r4, com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a r5, oh0.a r6) {
        r3.getClass();
        if (r4 == null) goto L7;
        JsonElement r7 = r4.get("params");
        if (r7 == null) goto L7;
        JsonObject r8 = r7.getAsJsonObject();
    L8:
        if (r8 == null) goto L12;
        JsonElement r0 = r8.get("enable");
        if (r0 == null) goto L12;
        boolean r1 = r0.getAsBoolean();
    L14:
        if (r8 == null) goto L19;
        JsonElement r9 = r8.get("emptySeatUrl");
        if (r9 == null) goto L19;
        String r10 = r9.getAsString();
        if (r10 == null) goto L19;
    L20:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "emptySeatUrl");
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.e.a = r10;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "setMicseatMixStreamEnable, enable: " + r1 + ", emptySeatUrl: " + r10);
        rj0.k.m2.getClass();
        rj0.k r11 = rj0.k.a.a();
        if (r11 == null) goto L23;
        r11.z0(r1, r10);
    L23:
        l.n2.getClass();
        l r12 = l.a.a();
        if (r12 == null) goto L26;
        r12.z0(r1, r10);
    L26:
        r6.a(SendInteractEffectEventResultModel.Code.Success, "", null);
        return;
    L19:
        r10 = "";
    L12:
        r1 = false;
    L7:
        r8 = null;
        goto L8
    }
}
