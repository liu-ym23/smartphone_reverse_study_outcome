package com.bytedance.android.livesdk.gift.platform.core.manager;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PropManager {
    public static final long d = 0;
    public static PropManager e;
    public final List<l2> a;
    public final List<a> b;
    public boolean c;

    public static final enum ExpirePropShowType extends Enum<ExpirePropShowType> {
        public static final ExpirePropShowType RED_DOT = null;
        public static final ExpirePropShowType TOAST = null;
        public static final /* synthetic */ ExpirePropShowType[] a = null;

        static {
            ExpirePropShowType r0 = new ExpirePropShowType("TOAST", 0);
            TOAST = r0;
            ExpirePropShowType r1 = new ExpirePropShowType("RED_DOT", 1);
            RED_DOT = r1;
            a = new ExpirePropShowType[]{r0, r1};
        }

        public static ExpirePropShowType[] values() {
            return (ExpirePropShowType[]) a.clone();
        }

        public static ExpirePropShowType valueOf(String r1) {
            return (ExpirePropShowType) r27.a.a(ExpirePropShowType.class, r1);
        }

        public ExpirePropShowType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a();

        void b(List r1);
    }

    static {
        d = TimeUnit.DAYS.toSeconds(1);
    }

    public static synchronized PropManager b() {
        monitor-enter(PropManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (e != null) goto L7;
        e = new PropManager();     // Catch: Throwable -> L10
    L7:
        PropManager r1 = e;     // Catch: Throwable -> L10
        monitor-exit(PropManager.class);
        return r1;
    }

    public PropManager() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = false;
    }

    public final boolean a(ExpirePropShowType r24) {
        String r1 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getCastSecUid();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        HashMap<String, String> r2 = ay1.b.s();
        HashMap r4 = (HashMap) ay1.b.Z.getValue(null, ay1.b.a[63]);
        if (ay1.b.s().containsKey(r1) == true) goto L9;
        r2.put(r1, String.valueOf(0));
        r4.put(r1, String.valueOf(0));
    L9:
        if (r24 != ExpirePropShowType.RED_DOT) goto L53;
        long r3 = CastLongProtector.parseLong(r2.get(r1));     // Catch: Throwable -> L13
    L15:
        if (r3 >= 0) goto L17;
    L50:
        return false;
    L17:
        if (((System.currentTimeMillis() / 86400000) - (r3 / 86400000)) >= 1) goto L19;
        return false;
    L19:
        Iterator r5 = ((ArrayList) this.a).iterator();
    L21:
        if (r5.hasNext() == false) goto L50;
        l2 r6 = (l2) r5.next();
        if (r6.getNextExpire() <= 0) goto L21;
        long r7 = (r6.getNextExpire() - (System.currentTimeMillis() / 1000)) - r6.getNowTimeDiff();
        if (r6.getGift().getDiamondCount() <= 0) goto L21;
        if (r7 >= (d * 2)) goto L21;
        return true;
    L13:
        r3 = 0;
        goto L15
    L53:
        long r19 = CastLongProtector.parseLong((String) r4.get(r1));     // Catch: Throwable -> L32
    L34:
        if (r19 < 0) goto L50;
        if (((System.currentTimeMillis() / 86400000) - (r19 / 86400000)) >= 1) goto L38;
        return false;
    L38:
        Iterator r8 = ((ArrayList) this.a).iterator();
    L40:
        if (r8.hasNext() == false) goto L50;
        l2 r9 = (l2) r8.next();
        if (r9.getNextExpire() <= 0) goto L40;
        long r15 = (r9.getNextExpire() - (System.currentTimeMillis() / 1000)) - r9.getNowTimeDiff();
        if (r9.getGift().getDiamondCount() <= 0) goto L40;
        if (r15 >= (d * 2)) goto L40;
        r4.put(r1, String.valueOf(System.currentTimeMillis()));
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        ay1.b.Z.setValue(null, ay1.b.a[63], r4);
        return true;
    L32:
        r19 = 0;
        goto L34
    }
}
