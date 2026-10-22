package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.browser.jsbridge.base.LiveGetInteractToolInfoResultModel;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.a30;
import com.bytedance.android.livesdk.config.b30;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.getInteractToolInfo")
public final class c6 extends w20.u2<w20.ra, LiveGetInteractToolInfoResultModel> {
    public final List<Integer> a;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final Integer d;

        public a() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L14;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r11 = this.d;
            if (r11 == null) goto L18;
            r1 = r11.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "StatusInfo(useStatus=" + this.a + ", repelStatus=" + this.b + ", isVideoMerge=" + this.c + ", countLimit=" + this.d + ")";
        }

        public a(String r1, String r2, String r3, Integer r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public c6() {
        this.a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(InteractID.InteractLoki.getValue()), Integer.valueOf(InteractID.InteractMiniApp.getValue()), Integer.valueOf(InteractID.InteractGamePlus.getValue())});
    }

    public final void invoke(Object r18, CallContext r19) {
        w20.ra r1 = (w20.ra) r18;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r19, "context");
        Integer r2 = r1.b();
        String r3 = r1.a();
        if (r2 == null) goto L176;
        if (r3 == null) goto L176;
        if (CollectionsKt.contains(this.a, r1.b()) == false) goto L176;
        LiveGetInteractToolInfoResultModel r4 = new LiveGetInteractToolInfoResultModel();
        r4.a(LiveGetInteractToolInfoResultModel.Code.Success);
        LiveGetInteractToolInfoResultModel.a r5 = new LiveGetInteractToolInfoResultModel.a();
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r6 = ILiveWrappedEffectSDKService.a.a();
        String r7 = "";
        if (r6 == null) goto L12;
        String r8 = r6.getSdkVersion();
        if (r8 == null) goto L12;
    L13:
        r5.a(r8);
        Unit r9 = Unit.INSTANCE;
        r4.b(r5);
        LiveGetInteractToolInfoResultModel.b r11 = new LiveGetInteractToolInfoResultModel.b();
        Integer r12 = null;
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r13 == null) goto L18;
        com.bytedance.live.datacontext.n r14 = r13.getDownLoadingInteractEffectId();
        if (r14 == null) goto L18;
        String r15 = (String) r14.getValue();
    L19:
        r11.b(r15);
        int r16 = r2.intValue();
        boolean r17 = true;
        boolean r21 = false;
        String r22 = "open";
        if (r16 != InteractID.InteractLoki.getValue()) goto L35;
        List<String> r23 = LiveEffectContext.h;
        List<Sticker> r24 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.d);
        Iterator<Sticker> r25 = r24.iterator();
    L23:
        if (r25.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(String.valueOf(r25.next().getId()), r3) == false) goto L23;
        r21 = true;
    L28:
        List<String> r26 = LiveEffectContext.h;
        boolean r27 = !LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.c).isEmpty();
        if ((!r24.isEmpty()) == false) goto L31;
        if (r21 == true) goto L31;
    L32:
        r7 = NewBroadcastMonitor.STAGE.EFFECT;
    L33:
        a r28 = new a(r22, r7, null, null);
    L175:
        r11.d(r28.a);
        r11.c(r28.b);
        r11.e(r28.c);
        r11.a(r28.d);
        Unit r29 = Unit.INSTANCE;
        r4.c(r11);
        finishWithResult(r4);
        return;
    L31:
        if (r27 == false) goto L33;
    L27:
        r22 = "close";
        goto L28
    L35:
        if (r16 != InteractID.InteractMiniApp.getValue()) goto L91;
        if (((Boolean) b30.a.getValue()).booleanValue() == false) goto L45;
        IBroadcastService r31 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r31 == null) goto L45;
        Set<String> r32 = r31.getRunningInteractPlugins();
        if (r32 == null) goto L45;
        if ((!r32.isEmpty()) != true) goto L45;
    L56:
        boolean r33 = true;
    L58:
        IBroadcastService r34 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r34 == null) goto L65;
        List<String> r35 = r34.getRunningInteractPluginIds();
        if (r35 == null) goto L65;
        if (r35.isEmpty() == true) goto L65;
        boolean r36 = true;
    L66:
        if (r33 == true) goto L70;
        if (r36 == true) goto L70;
        boolean r37 = false;
    L71:
        IBroadcastService r38 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r38 == null) goto L78;
        List<String> r39 = r38.getRunningInteractPluginIds();
        if (r39 == null) goto L78;
        if (r39.contains(r3) != true) goto L78;
    L79:
        if (r21 == false) goto L81;
        r7 = "repel_effect";
    L81:
        IBroadcastService r41 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r41 == null) goto L88;
        List<String> r42 = r41.getRunningInteractPluginIds();
        if (r42 == null) goto L88;
        if (r42.contains(r3) != true) goto L88;
    L89:
        r28 = new a(r22, r7, null, null);
    L88:
        r22 = "close";
    L78:
        r21 = r37;
    L70:
        r37 = true;
    L65:
        r36 = false;
    L45:
        boolean r43 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r44 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r44 == null) goto L57;
        fa0.a r45 = r44.o0();
        if (r45 == null) goto L57;
        if (r45.a == false) goto L57;
        Integer r46 = r45.getType();
        if (r46 == null) goto L57;
        if (r46.intValue() == 7) goto L56;
    L57:
        r33 = false;
        goto L58
    L91:
        if (r16 == InteractID.InteractGamePlus.getValue()) goto L93;
        r28 = new a(null, null, null, null);
        goto L175
    L93:
        if (((Boolean) b30.a.getValue()).booleanValue() == false) goto L125;
        IBroadcastService r47 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r47 == null) goto L99;
        Set<String> r48 = r47.getRunningInteractPlugins();
        if (r48 == null) goto L99;
        int r49 = r48.size();
    L100:
        IBroadcastService r110 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r110 == null) goto L103;
        boolean r111 = r110.isPluginRunning(r3);
    L104:
        boolean r112 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r113 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r113 == null) goto L123;
        fa0.a r114 = r113.o0();
        if (r114 == null) goto L123;
        if (r111 == true) goto L115;
        String r115 = r114.c;
        if (r115 == null) goto L115;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L113
        r111 = Intrinsics.areEqual(LiveSeiUtil.c(r115).optString("MiniAppID"), r3);     // Catch: Exception -> L113
    L115:
        if (r114.a == false) goto L123;
        Integer r51 = r114.getType();
        if (r51 == null) goto L123;
        if (r51.intValue() != 7) goto L123;
        r49 = r49 + 1;
    L123:
        if (r49 >= ((Integer) a30.a.getValue()).intValue()) goto L143;
    L144:
        boolean r52 = false;
    L146:
        IBroadcastService r53 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r53 == null) goto L153;
        List<String> r54 = r53.getRunningInteractPluginIds();
        if (r54 == null) goto L153;
        if (r54.isEmpty() == true) goto L153;
        boolean r55 = true;
    L154:
        if (r55 == true) goto L159;
        if (r52 == true) goto L159;
        r17 = false;
    L159:
        if (r111 == true) goto L162;
        r22 = "close";
    L162:
        if (r17 == false) goto L164;
        r7 = "plugin";
    L164:
        b30 r56 = b30.a;
        if (((Boolean) r56.getValue()).booleanValue() == false) goto L167;
        String r57 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L169:
        if (((Boolean) r56.getValue()).booleanValue() == false) goto L173;
        if (r52 == false) goto L173;
        if (r111 == true) goto L173;
        r12 = (Integer) a30.a.getValue();
    L173:
        r28 = new a(r22, r7, r57, r12);
        goto L175
    L167:
        r57 = null;
    L153:
        r55 = false;
    L143:
        r52 = true;
        goto L146
    L103:
        r111 = false;
    L99:
        r49 = 0;
        goto L100
    L125:
        boolean r58 = com.bytedance.android.live.revenue.core.util.h.a;
        fa0.c r59 = (fa0.c) com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r59 == null) goto L145;
        fa0.a r61 = r59.o0();
        if (r61 == null) goto L145;
        String r116 = r61.c;
        if (r116 != null) goto L180;
        r111 = false;
    L137:
        if (r61.a == false) goto L144;
        Integer r62 = r61.getType();
        if (r62 == null) goto L144;
        if (r62.intValue() != 7) goto L144;
    L180:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L133
        boolean r63 = Intrinsics.areEqual(LiveSeiUtil.c(r116).optString("MiniAppID"), r3);     // Catch: Exception -> L133
    L134:
        r111 = r63;
    L133:
        r63 = false;
    L145:
        r52 = false;
        r111 = false;
    L18:
        r15 = null;
    L12:
        r8 = "";
    L176:
        finishWithFailure();
    }
}
