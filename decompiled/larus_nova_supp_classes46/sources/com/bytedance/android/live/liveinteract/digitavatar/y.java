package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y {
    public static final Map<AvatarGender, Sticker> a = null;
    public static Sticker b;

    public interface a {
        void a(Sticker r1);

        void onError(Exception r1);
    }

    public static final class b implements a {
        public final /* synthetic */ WeakReference a;

        public b(WeakReference r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            y.b = r2;
            WeakReference r0 = this.a;
            if (r0 == null) goto L8;
            a r1 = (a) r0.get();
            if (r1 == null) goto L9;
            r1.a(r2);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            WeakReference r0 = this.a;
            if (r0 == null) goto L8;
            a r1 = (a) r0.get();
            if (r1 == null) goto L9;
            r1.onError(r2);
            return;
        L9:
            return;
        }
    }

    public static final class c implements a {
        public final /* synthetic */ AvatarGender a;
        public final /* synthetic */ WeakReference b;

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void a(Sticker r3) {
            Intrinsics.checkNotNullParameter(r3, "sticker");
            Map<AvatarGender, Sticker> r0 = y.a;
            y.a.put(this.a, r3);
            WeakReference r1 = this.b;
            if (r1 == null) goto L8;
            a r2 = (a) r1.get();
            if (r2 == null) goto L9;
            r2.a(r3);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
        public final void onError(Exception r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            WeakReference r0 = this.b;
            if (r0 == null) goto L8;
            a r1 = (a) r0.get();
            if (r1 == null) goto L9;
            r1.onError(r2);
            return;
        L9:
            return;
        }

        public c(AvatarGender r1, WeakReference r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(a r4) {
        Sticker r0 = b;
        if (r0 == null) goto L7;
        if (r4 == null) goto L12;
        r4.a(r0);
        return;
    L12:
        return;
    L7:
        if (r4 == null) goto L9;
        WeakReference r1 = new WeakReference(r4);
    L10:
        String r5 = i.a;
        b r2 = new b(r1);
        LiveEffectContextFactoryType r3 = LiveEffectContextFactoryType.DEFAULT;
        Intrinsics.checkNotNullParameter(r3, "type");
        EffectManager r6 = jc1.k.n(IMiddlewareEffectService.class).effectContext(r3).getEffectManager();
        Intrinsics.checkNotNullParameter(r3, "type");
        jc1.k.n(IMiddlewareEffectService.class).effectContext(r3).c().a().a("livedigitavatar", new z(r5, r6, r2));
        return;
    L9:
        r1 = null;
        goto L10
    }

    @JvmStatic
    public static final void b(AvatarGender r3, a r4) {
        Intrinsics.checkNotNullParameter(r3, "gender");
        Sticker r0 = (Sticker) ((LinkedHashMap) a).get(r3);
        if (r0 == null) goto L7;
        if (r4 == null) goto L12;
        r4.a(r0);
        return;
    L12:
        return;
    L7:
        if (r4 == null) goto L9;
        WeakReference r1 = new WeakReference(r4);
    L10:
        String r5 = r3.getStickId();
        c r2 = new c(r3, r1);
        LiveEffectContextFactoryType r6 = LiveEffectContextFactoryType.DEFAULT;
        Intrinsics.checkNotNullParameter(r6, "type");
        EffectManager r7 = jc1.k.n(IMiddlewareEffectService.class).effectContext(r6).getEffectManager();
        Intrinsics.checkNotNullParameter(r6, "type");
        jc1.k.n(IMiddlewareEffectService.class).effectContext(r6).c().a().a("livedigitavatar", new z(r5, r7, r2));
        return;
    L9:
        r1 = null;
        goto L10
    }
}
