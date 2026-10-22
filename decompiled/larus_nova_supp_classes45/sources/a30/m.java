package a30;

import com.bytedance.android.live.gift.GiftType;
import fr2.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import uf2.d0;
import uf2.r0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static final or2.a a() {
        return vh6.c.b(or2.e.class).getCurrentClient();
    }

    public static final r0 b() {
        com.bytedance.android.livesdk.revenue.room.a r0 = g02.a.d();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j r1 = r0.getLiveStream();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.revenue.pushstream.a r2 = (com.bytedance.android.livesdk.revenue.pushstream.a) r1.getValue();
        if (r2 == null) goto L9;
        d0 r3 = r2.A();
    L10:
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.E();
    L9:
        r3 = null;
        goto L10
    }

    public static final ca0.b c() {
        return com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a(GiftType.STICKER_GIFT);
    }

    public static final boolean d() {
        if (e() == true) goto L6;
        return false;
    L6:
        if (g() == false) goto L10;
        r0 r0 = b();
        if (r0 != null) goto L15;
        return false;
    L15:
        return r0.isEnable();
    L10:
        or2.a r1 = a();
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.M();
    }

    public static final boolean e() {
        if (g() == false) goto L9;
        r0 r0 = b();
        if (r0 == null) goto L13;
        int r1 = r0.getStatus();
        int r2 = t.a;
        if (r1 != 1) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L9:
        or2.a r3 = a();
        if (r3 != null) goto L12;
        return false;
    L12:
        return r3.isEffectInited();
    }

    public static final boolean g() {
        com.bytedance.android.livesdk.revenue.room.a r0 = g02.a.d();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L8;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L8;
        return true;
    L8:
        qr2.c r2 = vh6.c.b(qr2.c.class);
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.isInSelfAnchorLink() != true) goto L13;
        return true;
    }

    public static final List<String> f(List<String> r8) {
        ArrayList r0 = new ArrayList();
        if (r8 == null) goto L8;
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        r0.add(StringsKt.replace$default((String) r9.next(), "file://", "", false, 4, null));
    L8:
        return r0;
    }
}
