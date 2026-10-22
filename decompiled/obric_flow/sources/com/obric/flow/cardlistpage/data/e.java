package com.obric.flow.cardlistpage.data;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends EntityDeletionOrUpdateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11474a;

    public /* synthetic */ e(RoomDatabase r5, int r10) {
        this.f11474a = r10;
        super(r5);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r5, Object r10) {
        switch(this.f11474a) {
            case 0: goto L69;
            default: goto L4;
        };
    L4:
        j r11 = (j) r10;
        String r12 = r11.f11483a;
        if (r12 != null) goto L7;
        r5.bindNull(1);
    L8:
        String r13 = r11.f11484b;
        if (r13 != null) goto L11;
        r5.bindNull(2);
    L12:
        String r14 = r11.f11485c;
        if (r14 != null) goto L15;
        r5.bindNull(3);
    L16:
        String r15 = r11.d;
        if (r15 != null) goto L19;
        r5.bindNull(4);
    L20:
        String r16 = r11.e;
        if (r16 != null) goto L23;
        r5.bindNull(5);
    L24:
        r5.bindLong(6, r11.f);
        r5.bindLong(7, r11.g);
        r5.bindLong(8, r11.f11486h ? 1 : 0);
        Integer r17 = r11.f11487i;
        if (r17 != null) goto L27;
        r5.bindNull(9);
    L28:
        Long r18 = r11.f11488j;
        if (r18 != null) goto L31;
        r5.bindNull(10);
    L32:
        Long r19 = r11.f11489k;
        if (r19 != null) goto L35;
        r5.bindNull(11);
    L36:
        Integer r20 = r11.f11490l;
        if (r20 != null) goto L39;
        r5.bindNull(12);
    L40:
        String r21 = r11.f11491m;
        if (r21 != null) goto L43;
        r5.bindNull(13);
    L44:
        String r22 = r11.f11492n;
        if (r22 != null) goto L47;
        r5.bindNull(14);
    L48:
        String r23 = r11.f11493o;
        if (r23 != null) goto L51;
        r5.bindNull(15);
    L52:
        String r24 = r11.f11494p;
        if (r24 != null) goto L55;
        r5.bindNull(16);
    L56:
        String r25 = r11.f11495q;
        if (r25 != null) goto L59;
        r5.bindNull(17);
    L60:
        String r26 = r11.f11496r;
        if (r26 != null) goto L63;
        r5.bindNull(18);
    L64:
        String r27 = r11.f11483a;
        if (r27 != null) goto L67;
        r5.bindNull(19);
        return;
    L67:
        r5.bindString(19, r27);
        return;
    L63:
        r5.bindString(18, r26);
        goto L64
    L59:
        r5.bindString(17, r25);
        goto L60
    L55:
        r5.bindString(16, r24);
        goto L56
    L51:
        r5.bindString(15, r23);
        goto L52
    L47:
        r5.bindString(14, r22);
        goto L48
    L43:
        r5.bindString(13, r21);
        goto L44
    L39:
        r5.bindLong(12, r20.intValue());
        goto L40
    L35:
        r5.bindLong(11, r19.longValue());
        goto L36
    L31:
        r5.bindLong(10, r18.longValue());
        goto L32
    L27:
        r5.bindLong(9, r17.intValue());
        goto L28
    L23:
        r5.bindString(5, r16);
        goto L24
    L19:
        r5.bindString(4, r15);
        goto L20
    L15:
        r5.bindString(3, r14);
        goto L16
    L11:
        r5.bindString(2, r13);
        goto L12
    L7:
        r5.bindString(1, r12);
        goto L8
    L69:
        String r28 = ((j) r10).f11483a;
        if (r28 != null) goto L72;
        r5.bindNull(1);
        return;
    L72:
        r5.bindString(1, r28);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch(this.f11474a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "UPDATE OR ABORT `cards` SET `id` = ?,`originalId` = ?,`type` = ?,`title` = ?,`description` = ?,`spanX` = ?,`spanY` = ?,`isVisible` = ?,`sortIndex` = ?,`createTime` = ?,`modifyTime` = ?,`instanceId` = ?,`appletId` = ?,`widgetId` = ?,`definitionId` = ?,`config` = ?,`extras` = ?,`data` = ? WHERE `id` = ?";
    L6:
        return "DELETE FROM `cards` WHERE `id` = ?";
    }
}
