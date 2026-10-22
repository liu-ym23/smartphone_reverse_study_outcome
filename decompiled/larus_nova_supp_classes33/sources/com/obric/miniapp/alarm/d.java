package com.obric.miniapp.alarm;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d extends EntityInsertionAdapter<a> {
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `alarm` (`id`,`title`,`content`,`triggerTime`,`intervalMinutes`,`repeatCount`,`currentRepeatCount`,`isActive`,`createdAt`,`extraInfo`,`useSystemClock`,`token`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public d(AlarmDatabase r1) {
        super(r1);
    }

    public final void bind(SupportSQLiteStatement r5, Object r6) {
        a r7 = (a) r6;
        String r0 = r7.a;
        if (r0 != null) goto L5;
        r5.bindNull(1);
    L6:
        String r1 = r7.b;
        if (r1 != null) goto L9;
        r5.bindNull(2);
    L10:
        String r2 = r7.c;
        if (r2 != null) goto L13;
        r5.bindNull(3);
    L14:
        int r3 = s.a;
        Long r4 = s.a(r7.d);
        if (r4 != null) goto L17;
        r5.bindNull(4);
    L18:
        r5.bindLong(5, r7.e);
        r5.bindLong(6, r7.f);
        r5.bindLong(7, r7.g);
        r5.bindLong(8, r7.h ? 1 : 0);
        Long r8 = s.a(r7.i);
        if (r8 != null) goto L21;
        r5.bindNull(9);
    L22:
        String r9 = s.c(r7.j);
        if (r9 != null) goto L25;
        r5.bindNull(10);
    L26:
        r5.bindLong(11, r7.k ? 1 : 0);
        String r10 = r7.l;
        if (r10 != null) goto L29;
        r5.bindNull(12);
        return;
    L29:
        r5.bindString(12, r10);
        return;
    L25:
        r5.bindString(10, r9);
        goto L26
    L21:
        r5.bindLong(9, r8.longValue());
        goto L22
    L17:
        r5.bindLong(4, r4.longValue());
        goto L18
    L13:
        r5.bindString(3, r2);
        goto L14
    L9:
        r5.bindString(2, r1);
        goto L10
    L5:
        r5.bindString(1, r0);
        goto L6
    }
}
