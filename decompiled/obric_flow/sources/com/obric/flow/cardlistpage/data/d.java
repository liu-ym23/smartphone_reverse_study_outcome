package com.obric.flow.cardlistpage.data;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends EntityInsertionAdapter {
    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r5, Object r10) {
        j r11 = (j) r10;
        String r12 = r11.f11483a;
        if (r12 != null) goto L5;
        r5.bindNull(1);
    L6:
        String r13 = r11.f11484b;
        if (r13 != null) goto L9;
        r5.bindNull(2);
    L10:
        String r14 = r11.f11485c;
        if (r14 != null) goto L13;
        r5.bindNull(3);
    L14:
        String r15 = r11.d;
        if (r15 != null) goto L17;
        r5.bindNull(4);
    L18:
        String r16 = r11.e;
        if (r16 != null) goto L21;
        r5.bindNull(5);
    L22:
        r5.bindLong(6, r11.f);
        r5.bindLong(7, r11.g);
        r5.bindLong(8, r11.f11486h ? 1 : 0);
        Integer r17 = r11.f11487i;
        if (r17 != null) goto L25;
        r5.bindNull(9);
    L26:
        Long r18 = r11.f11488j;
        if (r18 != null) goto L29;
        r5.bindNull(10);
    L30:
        Long r19 = r11.f11489k;
        if (r19 != null) goto L33;
        r5.bindNull(11);
    L34:
        Integer r20 = r11.f11490l;
        if (r20 != null) goto L37;
        r5.bindNull(12);
    L38:
        String r21 = r11.f11491m;
        if (r21 != null) goto L41;
        r5.bindNull(13);
    L42:
        String r22 = r11.f11492n;
        if (r22 != null) goto L45;
        r5.bindNull(14);
    L46:
        String r23 = r11.f11493o;
        if (r23 != null) goto L49;
        r5.bindNull(15);
    L50:
        String r24 = r11.f11494p;
        if (r24 != null) goto L53;
        r5.bindNull(16);
    L54:
        String r25 = r11.f11495q;
        if (r25 != null) goto L57;
        r5.bindNull(17);
    L58:
        String r26 = r11.f11496r;
        if (r26 != null) goto L61;
        r5.bindNull(18);
        return;
    L61:
        r5.bindString(18, r26);
        return;
    L57:
        r5.bindString(17, r25);
        goto L58
    L53:
        r5.bindString(16, r24);
        goto L54
    L49:
        r5.bindString(15, r23);
        goto L50
    L45:
        r5.bindString(14, r22);
        goto L46
    L41:
        r5.bindString(13, r21);
        goto L42
    L37:
        r5.bindLong(12, r20.intValue());
        goto L38
    L33:
        r5.bindLong(11, r19.longValue());
        goto L34
    L29:
        r5.bindLong(10, r18.longValue());
        goto L30
    L25:
        r5.bindLong(9, r17.intValue());
        goto L26
    L21:
        r5.bindString(5, r16);
        goto L22
    L17:
        r5.bindString(4, r15);
        goto L18
    L13:
        r5.bindString(3, r14);
        goto L14
    L9:
        r5.bindString(2, r13);
        goto L10
    L5:
        r5.bindString(1, r12);
        goto L6
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `cards` (`id`,`originalId`,`type`,`title`,`description`,`spanX`,`spanY`,`isVisible`,`sortIndex`,`createTime`,`modifyTime`,`instanceId`,`appletId`,`widgetId`,`definitionId`,`config`,`extras`,`data`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}
