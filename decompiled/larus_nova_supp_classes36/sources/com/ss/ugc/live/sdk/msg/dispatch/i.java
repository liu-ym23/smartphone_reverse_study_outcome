package com.ss.ugc.live.sdk.msg.dispatch;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements ulc.b {
    public final Map<Integer, String> a;
    public final Map<String, xlc.b> b;
    public final long c;
    public final vlc.c d;

    @Override // ulc.b
    public final String getName() {
        return "WRDSVersionCheck";
    }

    public static String b(tlc.d r2) {
        if ((r2 instanceof xlc.b) == true) goto L7;
        return a(r2.getMessageMethod(), null);
    L7:
        if (((xlc.b) r2).isWRDSMessage() == true) goto L11;
        return a(r2.getMessageMethod(), null);
    L11:
        return a(r2.getMessageMethod(), ((xlc.b) r2).getWRDSSubKey());
    }

    public final void d(tlc.d r4) {
        Intrinsics.checkNotNullParameter(r4, INotificationHitPoint.NoticeType.MESSAGE);
        if ((r4 instanceof xlc.b) == true) goto L6;
        return;
    L6:
        if (((xlc.b) r4).isWRDSMessage() == true) goto L8;
        return;
    L8:
        String r0 = r4.getMessageMethod();
        if (r0 == null) goto L12;
        Map<Integer, String> r1 = this.a;
        HashMap r2 = (HashMap) r1;
        r2.put(Integer.valueOf(r4.getIntType()), r0);
        Map<String, xlc.b> r3 = this.b;
        HashMap r5 = (HashMap) r3;
        r5.put(b(r4), r4);
        return;
    }

    @Override // vlc.b
    public final boolean onMessage(tlc.d r12) {
        Intrinsics.checkNotNullParameter(r12, INotificationHitPoint.NoticeType.MESSAGE);
        if ((r12 instanceof xlc.b) == true) goto L6;
        return false;
    L6:
        if (((xlc.b) r12).isWRDSMessage() == true) goto L8;
        return false;
    L8:
        boolean r1 = true;
        if (r12.getRoomId() == this.c) goto L26;
        Set<Long> r3 = j.a;
        long r4 = r12.getRoomId();
        xlc.b r5 = (xlc.b) r12;
        Intrinsics.checkNotNullParameter(r5, INotificationHitPoint.NoticeType.MESSAGE);
        Set<Long> r6 = j.a;
        CopyOnWriteArraySet r7 = (CopyOnWriteArraySet) r6;
        if (r7.contains(Long.valueOf(r4)) == false) goto L22;
        Intrinsics.checkNotNullParameter(r5, INotificationHitPoint.NoticeType.MESSAGE);
        String r8 = j.a(r5.getWRDSKey(), r5.getWRDSSubKey());
        Map<Long, Map<String, xlc.b>> r9 = j.b;
        ConcurrentHashMap r10 = (ConcurrentHashMap) r9;
        Map r11 = (Map) r10.get(Long.valueOf(r4));
        if (r11 != null) goto L17;
        r11 = new ConcurrentHashMap();
        r10.put(Long.valueOf(r4), r11);
    L17:
        xlc.b r13 = (xlc.b) r11.get(r8);
        if (r13 != null) goto L20;
    L23:
        r11.put(r8, r5);
    L24:
        vlc.c r14 = this.d;
        StringBuilder r15 = new StringBuilder("receive preload wrds: ");
        Intrinsics.checkNotNullParameter(r5, INotificationHitPoint.NoticeType.MESSAGE);
        r15.append(j.a(r5.getWRDSKey(), r5.getWRDSSubKey()));
        r15.append('_');
        r15.append(r12.getRoomId());
        r15.append(", preload: ");
        r15.append(r1);
        com.ss.ugc.live.sdk.msg.utils.a.c(r14, r15.toString());
        return false;
    L20:
        if (r5.getWRDSVersion() > r13.getWRDSVersion()) goto L23;
    L22:
        r1 = false;
        goto L24
    L26:
        Map<String, xlc.b> r0 = this.b;
        HashMap r2 = (HashMap) r0;
        xlc.b r16 = (xlc.b) r2.get(b(r12));
        if (r16 != null) goto L29;
    L31:
        return false;
    L29:
        if (((xlc.b) r12).getWRDSVersion() > r16.getWRDSVersion()) goto L31;
        return true;
    }

    public i(long r2, vlc.c r4) {
        Intrinsics.checkNotNullParameter(r4, "logger");
        this.c = r2;
        this.d = r4;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public static String a(String r1, String r2) {
        if (r1 != null) goto L5;
        r1 = "Unknown";
    L5:
        if (r2 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L14;
        return r1;
    L14:
        return r1 + "_" + r2;
    L7:
        if (r2.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    public final tlc.d c(int r3, String r4) {
        Map<Integer, String> r0 = this.a;
        HashMap r1 = (HashMap) r0;
        String r5 = (String) r1.get(Integer.valueOf(r3));
        Object r2 = null;
        if (r5 == null) goto L10;
        Map<String, xlc.b> r6 = this.b;
        HashMap r7 = (HashMap) r6;
        Object r8 = r7.get(a(r5, r4));
        if ((r8 instanceof tlc.d) == false) goto L9;
        r2 = r8;
    L9:
        return (tlc.d) r2;
    L10:
        return null;
    }
}
