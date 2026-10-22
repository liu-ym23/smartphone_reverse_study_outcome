package k02;

import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import fr2.p;
import fr2.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public p a;
    public boolean b;

    /* JADX INFO: renamed from: k02.a$a, reason: collision with other inner class name */
    public static final class C0241a {
    }

    static {
    }

    public a() {
    }

    public static ca0.b a() {
        return com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a(GiftType.STICKER_GIFT);
    }

    public final boolean b(boolean r4) {
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.c() == false) goto L20;
        p r5 = this.a;
        if (r5 == null) goto L11;
        w1 r6 = r5.E();
        if (r6 == null) goto L11;
        int r7 = r6.b();
        int r2 = f.e;
        if (r7 != 1) goto L11;
        boolean r8 = true;
    L12:
        String.valueOf(r8);
        p r9 = this.a;
        if (r9 == null) goto L23;
        w1 r10 = r9.E();
        if (r10 == null) goto L24;
        int r11 = r10.b();
        int r3 = f.e;
        if (r11 != 1) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L11:
        r8 = false;
        goto L12
    L20:
        if (r4 == false) goto L22;
        LivePluginSPIManager.a().requireByUser("GiftLiveCoreRenderFilter");
    L22:
        return false;
    }
}
