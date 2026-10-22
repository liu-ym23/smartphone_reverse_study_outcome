package f12;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.configmodel.h1;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.scope.m;
import com.bytedance.live.kmp.core.c;
import cy0.e;
import cy0.j;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements a {
    public final Map<String, List<Long>> a;
    public final Map<Long, List<String>> b;
    public final Map<String, Long> c;
    public final h1 d;

    public b() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = (h1) com.bytedance.android.livesdk.gift.platform.business.effect.b.s.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.a[17]);
    }

    @Override // f12.a
    public final void a(o7 r11, com.bytedance.android.livesdk.gift.model.h1 r13, Function2<? super List<String>, ? super Map<String, ? extends Object>, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r13, "gift");
        Intrinsics.checkNotNullParameter(r14, "action");
        IBaseUser r0 = r11.getToUser();
        e.a.getClass();
        j r2 = e.a.a;
        m.e.getClass();
        Object r1 = m.b(r2).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r1);
        IBaseUser r3 = ((c) r1).b();
        if (r0 != null) goto L5;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L20;
        g r5 = f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), g.class);
        if (r5 != null) goto L15;
    L19:
        boolean r6 = this.d.t1();
    L21:
        if (r6 == true) goto L23;
        return;
    L23:
        List r7 = (List) ((LinkedHashMap) this.b).get(Long.valueOf(r13.getId()));
        List r8 = r7;
        if (r8 != null) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == true) goto L53;
        long r10 = r13.getId();
        StringBuilder r15 = new StringBuilder();
        r15.append(r10);
        r15.append('-');
        IBaseUser r16 = r11.getFromUser();
        String r17 = null;
        if (r16 == null) goto L34;
        String r18 = r16.getWebcastUid();
    L35:
        r15.append(r18);
        r15.append('-');
        r15.append(r11.getGroupId());
        r15.append('-');
        IBaseUser r19 = r11.getFromUser();
        if (r19 == null) goto L38;
        r17 = r19.getIdString();
    L38:
        r15.append(r17);
        String r20 = r15.toString();
        if (r11.getRepeatEnd() != 1) goto L41;
        this.c.remove(r20);
        long r21 = r11.getRepeatCount();
    L50:
        if (r21 <= 0) goto L54;
        int r23 = r11.getRepeatEnd();
        long r24 = r11.getRepeatCount();
        LinkedHashMap r110 = new LinkedHashMap();
        LinkedHashMap r25 = new LinkedHashMap();
        r25.put("gift_id", Long.valueOf(r13.getId()));
        r25.put("unit_price", Integer.valueOf(r13.getDiamondCount()));
        r25.put("count", Long.valueOf(r21));
        r25.put("repeat_end", Integer.valueOf(r23));
        r25.put("gift_type", Integer.valueOf(r13.getType()));
        r25.put("unique_combo_id", r20);
        r25.put("total_count", Long.valueOf(r24));
        r110.put("gift_message", r25);
        r14.invoke(r7, r110);
        return;
    L54:
        return;
    L41:
        Long r26 = (Long) ((LinkedHashMap) this.c).get(r20);
        if (r26 == null) goto L44;
        long r27 = r26.longValue();
    L46:
        if (r27 >= r11.getRepeatCount()) goto L48;
        r21 = r11.getRepeatCount() - r27;
        this.c.put(r20, Long.valueOf(r11.getRepeatCount()));
        goto L50
    L48:
        r21 = 0;
        goto L50
    L44:
        r27 = 0;
        goto L46
    L34:
        r18 = null;
        goto L35
    L53:
        return;
    L26:
        if (r8.isEmpty() == true) goto L29;
        r9 = false;
        goto L30
    L15:
        if (r5.isAnchor() != true) goto L19;
        if (this.d.r8() == false) goto L19;
        r6 = true;
        goto L21
    L20:
        r6 = false;
        goto L21
    L5:
        if (iz.a.a(r0) != null) goto L7;
    L9:
        r4 = false;
        goto L11
    L7:
        if (Intrinsics.areEqual(iz.a.a(r0), iz.a.a(r3)) == false) goto L9;
        goto L9
    }
}
