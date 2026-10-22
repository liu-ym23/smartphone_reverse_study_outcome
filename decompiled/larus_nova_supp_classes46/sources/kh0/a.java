package kh0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.api.h0;
import com.bytedance.android.live.effect.api.o;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final Map<String, Boolean> a;
    public String b;
    public final d c;
    public final e d;
    public final boolean e;
    public final InterfaceC0226a f;
    public final String g;
    public final c h;

    /* JADX INFO: renamed from: kh0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0226a {
        boolean a();
    }

    public static final class b {
    }

    public interface c {
        boolean a();

        boolean b();
    }

    public static final class d implements o.a {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void a(String r3, Sticker r4) {
            ALogger.w("CommonLokiEffectManager", "beforeAdd : panel " + r3 + " sticker " + r4);
        }

        public final void b(boolean r4, String r5, Sticker r6) {
            ALogger.w("CommonLokiEffectManager", "onChange : isAdd " + r4 + " panel " + r5 + " sticker " + r6 + ' ');
            if ((!Intrinsics.areEqual(r5, this.a.g)) == false) goto L5;
            return;
        L5:
            if (r6 == null) goto L18;
            String r7 = r6.getEffectId();
            if (r7 == null) goto L18;
            Iterator r8 = MapsKt.asSequence(kh0.c.a).iterator();
        L10:
            if (r8.hasNext() == false) goto L14;
            Object r0 = r8.next();
            if (Intrinsics.areEqual(((Sticker) ((Map.Entry) r0).getValue()).getEffectId(), r7) == false) goto L10;
        L15:
            Map.Entry r1 = (Map.Entry) r0;
            if (r1 == null) goto L18;
            this.a.a.put((String) r1.getKey(), Boolean.valueOf(r4));
            goto L18
        L14:
            r0 = null;
        L18:
            ALogger.w("CommonLokiEffectManager", "update lokiLoadMap : " + this.a.a);
        }
    }

    public static final class e implements kh0.c.a {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // kh0.c.a
        public final void a(Sticker r4) {
            Intrinsics.checkNotNullParameter(r4, "sticker");
            this.a.a();
            ALogger.w("CommonLokiEffectManager", "sticker download success: " + r4.getId() + ", " + r4.getEffectId());
        }

        @Override // kh0.c.a
        public final void onError(Exception r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            ALogger.w("CommonLokiEffectManager", "sticker download error: " + r3);
        }
    }

    static {
    }

    public final void a() {
        String r0 = this.b;
        if (r0 == null) goto L6;
        e(r0);
        return;
    }

    public final void b() {
        this.b = "";
        e("");
        ((LinkedHashMap) this.a).clear();
        o r0 = kh0.b.a(this.e);
        if (r0 == null) goto L5;
        r0.f(this.c);
    L5:
        ALogger.i("CommonLokiEffectManager", "[unregistEffectListener]");
    }

    public final void d() {
        o r0 = kh0.b.a(this.e);
        if (r0 == null) goto L5;
        r0.f(this.c);
    L5:
        o r1 = kh0.b.a(this.e);
        if (r1 == null) goto L8;
        r1.d(this.c);
    L8:
        ALogger.i("CommonLokiEffectManager", "[registEffectListener]");
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "effectName");
        c r0 = this.h;
        if (r0 == null) goto L8;
        if (r0.a() == true) goto L10;
        return;
    L10:
        if (r3 == null) goto L12;
        this.b = r3;
        e(r3);
    L12:
        ALogger.i("CommonLokiEffectManager", "[handleRankLokiEffect] select effectName: " + r3);
        return;
    L8:
        if (je0.d.O() == true) goto L10;
    }

    public final void e(String r7) {
        h0 r0 = kh0.b.a(this.e);
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.a).get(r7), Boolean.TRUE) == true) goto L47;
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        boolean r2 = true;
        if (r1 != null) goto L11;
    L12:
        c r3 = this.h;
        if (r3 != null) goto L15;
    L17:
        r2 = false;
    L18:
        if (r2 == true) goto L20;
        return;
    L20:
        h0 r4 = r0;
        r4.b(this.g, "CommonLokiEffectManager_setLokiEffect");
        if (TextUtils.isEmpty(r7) == false) goto L23;
        return;
    L23:
        InterfaceC0226a r5 = this.f;
        if (r5 != null) goto L26;
    L29:
        LinkedHashMap r6 = (LinkedHashMap) kh0.c.a;
        Sticker r8 = (Sticker) r6.get(r7);
        if (r8 == null) goto L32;
        ALogger.i("CommonLokiEffectManager", "use sticker catch:" + r8.getEffectId());
        r4.d(this.c);
        r4.a(this.g, r8, "CommonLokiEffectManager_setLokiEffect");
    L44:
        ALogger.w("CommonLokiEffectManager", "[setLokiEffect] effect: " + r7 + " done");
        return;
    L32:
        String r9 = this.g;
        e r10 = this.d;
        Intrinsics.checkNotNullParameter(r9, "panelId");
        Intrinsics.checkNotNullParameter(r7, "effectName");
        if (TextUtils.isEmpty(r7) == true) goto L44;
        ALogger.d("CommonStickerManager", "#RevenueStickerDebug# [downGuestBattleSticker] download effectName: " + r7);
        Sticker r11 = (Sticker) r6.get(r7);
        if (r11 == null) goto L40;
        if (r10 == null) goto L39;
        r10.a(r11);
    L39:
        ALogger.d("CommonStickerManager", "#RevenueStickerDebug# [downGuestBattleSticker] cached effectName: " + r7);
        goto L44
    L40:
        if (r10 == null) goto L42;
        WeakReference r12 = new WeakReference(r10);
    L43:
        kh0.d r13 = new kh0.d(r7, r12);
        LiveEffectContextFactoryType r14 = LiveEffectContextFactoryType.DEFAULT;
        Intrinsics.checkNotNullParameter(r14, "type");
        EffectManager r15 = k.n(IMiddlewareEffectService.class).effectContext(r14).getEffectManager();
        Intrinsics.checkNotNullParameter(r14, "type");
        k.n(IMiddlewareEffectService.class).effectContext(r14).c().a().a(r9, new f(r7, r9, r15, r13));
        goto L44
    L42:
        r12 = null;
        goto L43
    L26:
        if (r5.a() == true) goto L29;
        ALogger.w("CommonLokiEffectManager", "[setLokiEffect] battle is finish, but set " + r7);
        return;
    L15:
        if (r3.b() != true) goto L17;
    L11:
        if (r1.intValue() == 2) goto L18;
    }

    public a(boolean r2, InterfaceC0226a r3, String r4, c r5) {
        Intrinsics.checkNotNullParameter(r4, "panelId");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = new LinkedHashMap();
        this.b = "";
        this.c = new d(this);
        this.d = new e(this);
    }
}
