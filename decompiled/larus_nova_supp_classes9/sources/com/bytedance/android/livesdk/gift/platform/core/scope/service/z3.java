package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.interacteffect.api.MessageType;
import com.bytedance.android.live.revenue.platform.interacteffect.api.Scene;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.AtmosphereDataStore;
import com.bytedance.android.livesdk.message.model.l6;
import com.bytedance.android.livesdk.revenue.service.effect.RevStickerPanel;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z3 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public l6 b;
    public final boolean c;
    public final com.bytedance.android.livesdk.gift.configmodel.a d;
    public Disposable e;
    public final yz0.l f;
    public final com.bytedance.android.livesdk.revenue.service.effect.c g;
    public final yz0.k h;

    public static final class a implements q {
        public final /* synthetic */ z3 a;

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q
        public final void error(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public a(z3 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.q
        public final void a(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "url");
            Intrinsics.checkNotNullParameter(r9, "filePath");
            if (this.a.f() == false) goto L11;
            i12.e r0 = i12.o.b();
            if (r0 == null) goto L7;
            Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.f.class);
        L8:
            com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.f r2 = (com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.f) r1;
            if (r2 == null) goto L13;
            this.a.getClass();
            LinkedHashMap r3 = new LinkedHashMap();
            Gson r4 = GsonHelper.getDefault();
            LinkedHashMap r5 = new LinkedHashMap();
            r5.put(r8, r9);
            LinkedHashMap r10 = new LinkedHashMap();
            r10.put(sz1.a.KEY_LOCAL_ICON_BITMAP, r5);
            r3.put("arg3", GsonProtectorUtils.toJson(r4, r10));
            r3.put("arg2", 1000004);
            r3.put("arg1", 101);
            r3.put("msg_type", 40);
            String r11 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r3).toString();
            Intrinsics.checkNotNullParameter(r11, "param");
            r2.K0(new com.bytedance.android.livesdk.gift.platform.business.effect.atmosphere.g(r11));
            return;
        L13:
            return;
        L7:
            r1 = null;
            goto L8
        L11:
            ez0.b r6 = vh6.c.b(ez0.b.class);
            MessageType r7 = MessageType.MSG_TYPE_LIVE_INTERACTION;
            Scene r13 = Scene.ATMOSPHERE;
            Gson r14 = GsonHelper.getDefault();
            this.a.getClass();
            LinkedHashMap r15 = new LinkedHashMap();
            r15.put(r8, r9);
            LinkedHashMap r16 = new LinkedHashMap();
            r16.put(sz1.a.KEY_LOCAL_ICON_BITMAP, r15);
            r6.Vf(r7, r13, 1000004, GsonProtectorUtils.toJson(r14, r16));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ z3 a;

        public b(z3 r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            l6 r14 = (l6) r13;
            z3 r0 = this.a;
            if (((Boolean) r0.h.getDataCenter().get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L73;
            r0.h.getDataCenter();
            if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == true) goto L80;
            boolean r2 = false;
            Disposable r4 = null;
            Object r5 = null;
            r4 = null;
            if (r14.getAction() != 1) goto L24;
            long r6 = r14.getAssetId();
            if (r0.f() == false) goto L17;
            i12.e r15 = i12.o.b();
            if (r15 == null) goto L14;
            r5 = com.bytedance.android.scope.m.e.d(r15, AtmosphereDataStore.class);
        L14:
            AtmosphereDataStore r7 = (AtmosphereDataStore) r5;
            if (r7 == null) goto L74;
            KProperty[] r16 = AtmosphereDataStore.n;
            r7.k(r6, false);
            return;
        L74:
            return;
        L17:
            Iterator r17 = r0.g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();
        L19:
            if (r17.hasNext() == false) goto L83;
            yp2.b r1 = (yp2.b) r17.next();
            if (r1.getId() != r6) goto L19;
            r0.g.Bn(r1, RevStickerPanel.EFFECT_ATMOSPHERE);
            goto L19
        L83:
            return;
        L24:
            if (r14.getEndTime() > 0) goto L26;
        L28:
            r0.b = r14;
            if (r0.f() == false) goto L46;
            if (r0.d.a() == false) goto L46;
            Disposable r3 = r0.e;
            if (r3 != null) goto L35;
        L36:
            Observable r8 = r0.h.getAudioTalkSwitchSceneEvent();
            if (r8 == null) goto L41;
            Observable r9 = r8.subscribeOn(AndroidSchedulers.mainThread());
            if (r9 == null) goto L41;
            r4 = r9.subscribe(new b4(r0), c4.a);
        L41:
            r0.e = r4;
            if (r4 == null) goto L44;
            r0.a.add(r4);
        L44:
            long r10 = r14.getAssetId();
            x3 r11 = new x3(r0, r14);
            r0.g.h2(String.valueOf(r10), new w3(r0, r11));
            return;
        L35:
            if (r3.isDisposed() != true) goto L44;
        L46:
            if (r0.d.c() == true) goto L48;
            return;
        L48:
            if (r0.h.getLiveMode() != LiveMode.VIDEO) goto L50;
            boolean r18 = true;
        L51:
            if (r18 == true) goto L53;
            return;
        L53:
            if (r0.h.isAnchor() == false) goto L82;
            Iterator r19 = r0.g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();
        L57:
            if (r19.hasNext() == false) goto L61;
            if (((yp2.b) r19.next()).getId() != r14.getAssetId()) goto L57;
            r2 = true;
        L61:
            if (r2 == false) goto L63;
            String r110 = z3.c(r14);
            vh6.c.b(ez0.b.class).Vf(MessageType.MSG_TYPE_LIVE_INTERACTION, Scene.ATMOSPHERE, 1000000, r110);
            return;
        L63:
            long r20 = r14.getAssetId();
            y3 r21 = new y3(r0, r14);
            r0.g.h2(String.valueOf(r20), new w3(r0, r21));
            return;
        L82:
            return;
        L50:
            r18 = false;
            goto L51
        L26:
            if (r14.getEndTime() >= (com.bytedance.live.kmp.util.e.b() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L28;
            return;
        L80:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).getMessage();
        }
    }

    public final boolean f() {
        if (this.h.isAudioRoom() == true) goto L5;
        return false;
    L5:
        int r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        if (r0 != 5) goto L8;
    L15:
        return true;
    L8:
        if (r0 == 16) goto L15;
        if (r0 == 0) goto L12;
    L14:
        return false;
    L12:
        if (this.h.getRoom().isLiveTypeAudio() == false) goto L14;
        return true;
    }

    public final void onStart() {
        RxUtilKt.c(vh6.c.b(ez0.b.class).observeEffectMessage().observeOn(AndroidSchedulers.mainThread()).subscribe(new a4(this)), this.a);
        yz0.l r0 = this.f;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.S, true, 4).subscribe(new b(this), c.a), this.a);
    }

    public final void onStop() {
        this.a.clear();
    }

    public static String c(l6 r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("end_time", Long.valueOf(r3.getEndTime()));
        r0.put("effect_id", Long.valueOf(r3.getAssetId()));
        r0.put("activity_information", r3.getActivityInformation());
        r0.put("platform", 0);
        return GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r0).toString();
    }

    public z3(yz0.l r2, com.bytedance.android.livesdk.revenue.service.effect.c r3, yz0.k r4) {
        Intrinsics.checkNotNullParameter(r2, "roomMessageService");
        Intrinsics.checkNotNullParameter(r3, "effectService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new CompositeDisposable();
        this.c = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.Q.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[41])).booleanValue();
        this.d = (com.bytedance.android.livesdk.gift.configmodel.a) nz1.a.y.getValue(null, nz1.a.a[23]);
    }

    public static final void a(z3 r6, long r7, String r9) {
        if (r6.c == false) goto L21;
        List r8 = StringsKt.split$default(r9, new String[]{"/"}, false, 0, 6, null);
        ListIterator r10 = r8.listIterator(r8.size());
    L6:
        if (r10.hasPrevious() == false) goto L13;
        Object r11 = r10.previous();
        if (((String) r11).length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L6;
    L14:
        int r13 = ft1.k.a;
        HashMap r14 = new HashMap();
        r14.put("gift_float_asset", r7 + ',' + ((String) r11));
        Unit r15 = Unit.INSTANCE;
        ft1.k.a(r14);
        return;
    L10:
        r0 = false;
        goto L11
    L13:
        r11 = null;
        goto L14
    }

    public final void d(int r10, int r11, int r13, String r14) {
        if (r10 == 57) goto L5;
    L35:
        if (r10 == 57) goto L37;
        return;
    L37:
        if (r11 == Scene.GIFT.getValue()) goto L39;
        return;
    L39:
        if (r13 != 1000004) goto L62;
        if (r14 == null) goto L63;
        List<String> r15 = ((r) GsonHelper.getDefault().fromJson(r14, r.class)).a();     // Catch: Exception -> L49
        if (r15 == null) goto L64;
        Iterator<T> r16 = r15.iterator();     // Catch: Exception -> L49
    L45:
        if (r16.hasNext() == false) goto L66;
        String r17 = (String) r16.next();     // Catch: Exception -> L49
        ((w) com.bytedance.android.live.revenue.core.util.f.a(w.class)).a(r17, new a(this));     // Catch: Exception -> L49
    L66:
        return;
    L64:
        return;
    L65:
        return;
    L63:
        return;
    L62:
        return;
    L5:
        if (r11 != Scene.GIFT.getValue()) goto L35;
        if (r13 != 1000001) goto L35;
        if (r14 == null) goto L35;
        a0 r1 = (a0) GsonHelper.getDefault().fromJson(r14, a0.class);     // Catch: Exception -> L34
        if (Intrinsics.areEqual(r1.getType(), "destroy_effect") == false) goto L29;
        if (r1.a() <= 0) goto L29;
        if (f() == false) goto L22;
        i12.e r2 = i12.o.b();     // Catch: Exception -> L34
        if (r2 == null) goto L18;
        Object r3 = com.bytedance.android.scope.m.e.d(r2, AtmosphereDataStore.class);     // Catch: Exception -> L34
    L19:
        AtmosphereDataStore r4 = (AtmosphereDataStore) r3;     // Catch: Exception -> L34
        if (r4 == null) goto L29;
        long r5 = r1.a();     // Catch: Exception -> L34
        KProperty[] r6 = AtmosphereDataStore.n;     // Catch: Exception -> L34
        r4.k(r5, false);     // Catch: Exception -> L34
        goto L29
    L18:
        r3 = null;
        goto L19
    L22:
        Iterator r7 = this.g.f4(RevStickerPanel.EFFECT_ATMOSPHERE).iterator();     // Catch: Exception -> L34
    L24:
        if (r7.hasNext() == false) goto L29;
        yp2.b r8 = (yp2.b) r7.next();     // Catch: Exception -> L34
        if (r8.getId() != r1.a()) goto L24;
        this.g.Bn(r8, RevStickerPanel.EFFECT_ATMOSPHERE);     // Catch: Exception -> L34
    L29:
        if (Intrinsics.areEqual(r1.getType(), "effect_apply_succeed") == false) goto L35;
        l6 r9 = this.b;     // Catch: Exception -> L34
        if (r9 == null) goto L35;
        String r18 = c(r9);     // Catch: Exception -> L34
        vh6.c.b(ez0.b.class).Vf(MessageType.MSG_TYPE_LIVE_INTERACTION, Scene.ATMOSPHERE, 1000000, r18);     // Catch: Exception -> L34
        goto L35
    }
}
