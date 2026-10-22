package com.bytedance.android.live.platformplayer.effect;

import android.content.Context;
import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.r;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.player.LivePlayerClient;
import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.PlayerError;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectCallback;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectMessageListener;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectResourceFinder;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.android.livesdkapi.vr.VrEffectResourceLoadResult;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class VrEffectDownloader {
    public static final Set<String> g = null;
    public static String h;
    public long a;
    public long b;
    public long c;
    public long d;
    public boolean e;
    public String f;

    public static final class a {
    }

    public static final class b implements VideoEffectCallback {
        public final /* synthetic */ VrEffectDownloader a;
        public final /* synthetic */ WeakReference b;
        public final /* synthetic */ ILivePlayerClient c;

        public final void onResult(PlayerError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            if (r4.getErrorCode() == 0) goto L5;
            com.bytedance.android.live.player.utils.b.e("error=" + r4);
            return;
        L5:
            ILivePlayerClient r5 = (ILivePlayerClient) this.b.get();
            if (r5 == null) goto L20;
            boolean r0 = r5.isVrEffectPlusVersion();
            r5.setVrEffectLiteMode(r5.getVideoEffectSixDofLiteModeParams());
            boolean r1 = true;
            r5.setEnable(true, 2);
            if (r0 == false) goto L15;
            this.a.getClass();
            u r2 = j0.l().c(IRoom.class);
            if (r2 == null) goto L15;
            if ((r2 instanceof u) == false) goto L15;
            r2.x();
        L15:
            if (this.a.f.length() > 0) goto L18;
            r1 = false;
        L18:
            if (r1 == false) goto L20;
            VrEffectDownloader r3 = this.a;
            VrEffectDownloader.a(r3, r5, r3.f, CollectionsKt.emptyList());
        L20:
            com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "init success set enable,player=" + this.c);
        }

        public b(VrEffectDownloader r1, WeakReference r2, ILivePlayerClient r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements VideoEffectMessageListener {
        public final /* synthetic */ WeakReference a;

        public c(WeakReference r1) {
            this.a = r1;
        }

        public final void onMessage(int r5, long r6, long r8, String r10) {
            com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "onMessage=" + r5 + ',' + r6 + ',' + r8 + '.' + r10);
            if (r5 == 40) goto L5;
            return;
        L5:
            if (r6 == 104) goto L7;
            return;
        L7:
            if (r8 != 1000001) goto L17;
            if (r10 != null) goto L10;
            return;
        L10:
            ILivePlayerClient r7 = (ILivePlayerClient) this.a.get();
            VrEffectResourceLoadResult r9 = (VrEffectResourceLoadResult) GsonProtectorUtils.fromJson(new Gson(), r10, VrEffectResourceLoadResult.class);
            if (r7 == null) goto L13;
            r7.updateVrEffectContextId(r9.getUnicId());
        L13:
            com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "message to setup layer,unicId=" + r9.getUnicId() + ",player=" + r7);
            return;
        }
    }

    public static final class d implements VideoEffectResourceFinder {
        public final long createNativeResourceFinder(long r1) {
            return 0;
        }

        public final void release(long r1) {
        }

        public d() {
        }
    }

    static {
        g = new LinkedHashSet();
        h = "";
    }

    public VrEffectDownloader() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = "";
    }

    public final VideoEffectInitConfigBuilder f(ILivePlayerClient r13) {
        Intrinsics.checkNotNullParameter(r13, "player");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L5;
        return null;
    L5:
        WeakReference r0 = new WeakReference(r13);
        b r9 = new b(this, r0, r13);
        c r8 = new c(r0);
        int r14 = com.bytedance.android.live.effect.a.a;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r15 = ILiveWrappedEffectSDKService.a.a();
        if (r15 == null) goto L8;
        r15.providerResourceFinder();
    L8:
        d r10 = new d();
        com.bytedance.android.live.platformplayer.service.a r16 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r16 == null) goto L14;
        com.bytedance.android.live.platformplayer.effect.b r2 = r16.c4();
        if (r2 != null) goto L13;
        return null;
    L13:
        return com.bytedance.android.live.platformplayer.effect.b.a.a(r2, null, false, null, null, null, r8, r9, r10, 31);
    L14:
        return null;
    }

    public final void c(ILivePlayerClient r7, LiveVrEffectInfo r8) {
        Intrinsics.checkNotNullParameter(r7, "playerClient");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L6;
        return;
    L6:
        if (r8.getVrTransferType() <= 0) goto L8;
        boolean r0 = true;
    L10:
        if (r8.getMaterialId() > 0) goto L13;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "illegal material id");
        return;
    L13:
        if (r0 == false) goto L16;
        d(r7, String.valueOf(r8.getMaterialId()));
        return;
    L16:
        return;
    L8:
        r0 = false;
        goto L10
    }

    public final void d(final ILivePlayerClient r8, final String r9) {
        Intrinsics.checkNotNullParameter(r8, "playerClient");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "effectid=" + r9);
        if (r9 != null) goto L8;
        r9 = h;
    L10:
        if (r9.length() != 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L15;
        return;
    L15:
        final boolean r1 = r8.isVrEffectPlusVersion();
        if (r1 == false) goto L23;
        u r2 = j0.l().c(IRoom.class);
        if (r2 == null) goto L23;
        if ((r2 instanceof u) == false) goto L23;
        r2.x();
    L23:
        if (this.a >= 0) goto L25;
        this.a = System.currentTimeMillis();
    L25:
        boolean r3 = tb1.c.c;
        if (r3 == false) goto L28;
    L33:
        Context r4 = null;
        if ((r8 instanceof LivePlayerClient) == true) goto L36;
        ILivePlayerClient r5 = null;
    L37:
        LivePlayerClient r6 = (LivePlayerClient) r5;
        if (r6 == null) goto L42;
        LivePlayerContext r7 = r6.getPlayerContext();
        if (r7 == null) goto L42;
        r4 = r7.getContext();
    L42:
        Function0<Unit> r10 = new VrEffectDownloader$checkAndUpdateVrEffectResource$1(this, r8, r9, r1);
        Intrinsics.checkNotNullParameter(r10, "effectConsummer");
        if (r3 == true) goto L49;
        if (tb1.c.e == true) goto L49;
        if (tb1.c.f == true) goto L49;
        return;
    L49:
        if (k.n(IMiddlewareHostApp.class).isToolsPluginReady() == false) goto L51;
        com.bytedance.android.live.player.utils.b.g("LiveVrEffect_VrEffectDownloader", "tools plugin is ready");
        r10.invoke();
        return;
    L51:
        Intrinsics.checkNotNullParameter("LiveVrEffect_VrEffectDownloader", "tag");
        ILivePlayerHostService r11 = is0.c.c().hostService();
        if (r11 == null) goto L56;
        ILivePlayerALogger r12 = r11.alog();
        if (r12 == null) goto L56;
        r12.w("LiveVrEffect_VrEffectDownloader", "tools plugin is not ready try install");
    L57:
        IMiddlewareHostApp r13 = k.f(IMiddlewareHostApp.class);
        if (r13 == null) goto L64;
        r13.installToolsPlugin(r4, new com.bytedance.android.live.platformplayer.effect.c(r10));
        return;
    L64:
        return;
    L56:
        Intrinsics.checkNotNull("tools plugin is not ready try install");
        goto L57
    L36:
        r5 = r8;
        goto L37
    L28:
        if (tb1.c.e == true) goto L33;
        if (tb1.c.f == true) goto L33;
        e(r8, r9, r1);
        return;
    L12:
        r0 = false;
        goto L13
    L8:
        h = r9;
        goto L10
    }

    public final void e(ILivePlayerClient r4, final String r5, final boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "playerClient");
        Intrinsics.checkNotNullParameter(r5, "effectId");
        IMiddlewareEffectService r0 = k.f(IMiddlewareEffectService.class);
        if (r0 == null) goto L5;
        r r1 = r0.vrEffectService();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "do download effect");
        r1.a(r5, new VrEffectDownloader$doDownloadEffect$1(this, r4), new VrEffectDownloader$doDownloadEffect$2(this, r5, r6));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(VrEffectDownloader r6, ILivePlayerClient r7, String r8, List r9) {
        r6.getClass();
        if (r9 == null) goto L5;
        int r1 = r9.size();
    L7:
        if (r1 > 0) goto L9;
        String[] r10 = {""};
    L16:
        Object[] r0 = CollectionsKt.listOf(r8).toArray(new String[0]);
        if (r0 == null) goto L24;
        String[] r2 = (String[]) r0;
        com.bytedance.android.live.player.utils.b.c("LiveVrEffect_VrEffectDownloader", "setEffectResource,path=" + r8 + ",player=" + r7);
        g.add(r8);
        if (r6.c >= 0) goto L21;
        r6.c = System.currentTimeMillis();
    L21:
        r6.f = r8;
        r7.appendComposerNodes(r2, r10, new com.bytedance.android.live.platformplayer.effect.d(r6, r7, r7.isVrEffectPlusVersion()));
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        if (r9 == null) goto L15;
        Object[] r11 = r9.toArray(new String[0]);
        if (r11 == null) goto L14;
        r10 = (String[]) r11;
        goto L16
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L15:
        r10 = new String[]{""};
        goto L16
    L5:
        r1 = 0;
        goto L7
    }

    public static final void b(VrEffectDownloader r10, String r11, boolean r12, boolean r13) {
        if (r10.e == true) goto L27;
        r10.e = true;
        long r0 = r10.d;
        long r2 = r0 - r10.c;
        long r4 = r10.b;
        long r6 = r10.a;
        long r5 = r4 - r6;
        long r1 = r0 - r6;
        if (r2 < 0) goto L24;
        long r8 = 10000000;
        if (r2 <= r8) goto L10;
        return;
    L10:
        if (r5 >= 0) goto L12;
        return;
    L12:
        if (r5 > r8) goto L28;
        HashMap r14 = new HashMap();
        if (r13 == false) goto L17;
        String r15 = "6dof";
    L18:
        r14.put("vr_6dof_type", r15);
        r14.put("material_duration_all", String.valueOf(r1));
        r14.put("sever_material_duration", String.valueOf(r5));
        r14.put("client_material_duration", String.valueOf(r2));
        if (r12 == false) goto L21;
        String r16 = "1";
    L22:
        r14.put("material_load_state", r16);
        r14.put("material_id", r11);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_vr_effect_duration", r14, new Object[0]);
        return;
    L21:
        r16 = "0";
        goto L22
    L17:
        r15 = "non_6dof";
        goto L18
    L28:
        return;
    L24:
        return;
    }
}
