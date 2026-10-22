package com.obric.flow.cardlistpage.data;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import cn.nubia.neopush.commons.Constant;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f11472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f11473c;

    public /* synthetic */ c(h r5, RoomSQLiteQuery r10, int r11) {
        this.f11471a = r11;
        this.f11473c = r5;
        this.f11472b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch(this.f11471a) {
            case 0: goto L98;
            case 1: goto L18;
            default: goto L4;
        };
    L4:
        CardDatabase_Impl r5 = this.f11473c.f11479a;
        RoomSQLiteQuery r10 = this.f11472b;
        Integer r11 = null;
        Cursor r12 = DBUtil.query(r5, r10, false, null);
    L12:
        th = move-exception;
        r12.close();
        r10.release();
        throw th;
    L6:
        if (r12.moveToFirst() == true) goto L8;
    L14:
        r12.close();
        r10.release();
        return r11;
    L8:
        if (r12.isNull(0) == true) goto L14;
        r11 = Integer.valueOf(r12.getInt(0));     // Catch: Throwable -> L12
        goto L14
    L18:
        Cursor r13 = DBUtil.query(this.f11473c.f11479a, this.f11472b, false, null);
        int r14 = CursorUtil.getColumnIndexOrThrow(r13, "id");     // Catch: Throwable -> L92
        int r15 = CursorUtil.getColumnIndexOrThrow(r13, "originalId");     // Catch: Throwable -> L92
        int r16 = CursorUtil.getColumnIndexOrThrow(r13, "type");     // Catch: Throwable -> L92
        int r17 = CursorUtil.getColumnIndexOrThrow(r13, Constant.TITLE);     // Catch: Throwable -> L92
        int r18 = CursorUtil.getColumnIndexOrThrow(r13, Constant.DESCRIPTION);     // Catch: Throwable -> L92
        int r19 = CursorUtil.getColumnIndexOrThrow(r13, "spanX");     // Catch: Throwable -> L92
        int r20 = CursorUtil.getColumnIndexOrThrow(r13, "spanY");     // Catch: Throwable -> L92
        int r110 = CursorUtil.getColumnIndexOrThrow(r13, "isVisible");     // Catch: Throwable -> L92
        int r111 = CursorUtil.getColumnIndexOrThrow(r13, "sortIndex");     // Catch: Throwable -> L92
        int r112 = CursorUtil.getColumnIndexOrThrow(r13, "createTime");     // Catch: Throwable -> L92
        int r113 = CursorUtil.getColumnIndexOrThrow(r13, "modifyTime");     // Catch: Throwable -> L92
        int r114 = CursorUtil.getColumnIndexOrThrow(r13, "instanceId");     // Catch: Throwable -> L92
        int r115 = CursorUtil.getColumnIndexOrThrow(r13, "appletId");     // Catch: Throwable -> L92
        int r21 = CursorUtil.getColumnIndexOrThrow(r13, "widgetId");     // Catch: Throwable -> L92
        int r116 = CursorUtil.getColumnIndexOrThrow(r13, "definitionId");     // Catch: Throwable -> L92
        int r117 = CursorUtil.getColumnIndexOrThrow(r13, "config");     // Catch: Throwable -> L92
        int r118 = CursorUtil.getColumnIndexOrThrow(r13, "extras");     // Catch: Throwable -> L92
        int r119 = CursorUtil.getColumnIndexOrThrow(r13, "data");     // Catch: Throwable -> L92
        int r22 = r21;
        ArrayList r23 = new ArrayList(r13.getCount());     // Catch: Throwable -> L92
    L20:
        if (r13.moveToNext() == false) goto L94;
        if (r13.isNull(r14) == false) goto L25;
        String r24 = null;
    L27:
        if (r13.isNull(r15) == false) goto L29;
        String r25 = null;
    L31:
        if (r13.isNull(r16) == false) goto L33;
        String r26 = null;
    L35:
        if (r13.isNull(r17) == false) goto L37;
        String r27 = null;
    L39:
        if (r13.isNull(r18) == false) goto L41;
        String r28 = null;
    L42:
        int r29 = r13.getInt(r19);     // Catch: Throwable -> L92
        int r210 = r13.getInt(r20);     // Catch: Throwable -> L92
        if (r13.getInt(r110) == 0) goto L45;
        boolean r211 = true;
    L47:
        if (r13.isNull(r111) == false) goto L49;
        Integer r30 = null;
    L51:
        if (r13.isNull(r112) == false) goto L53;
        Long r31 = null;
    L55:
        if (r13.isNull(r113) == false) goto L57;
        Long r32 = null;
    L59:
        if (r13.isNull(r114) == false) goto L61;
        Integer r33 = null;
    L63:
        if (r13.isNull(r115) == false) goto L65;
        String r34 = null;
    L67:
        if (r13.isNull(r22) == false) goto L70;
        String r35 = null;
    L69:
        int r40 = r116;
        int r120 = r14;
        if (r13.isNull(r40) == false) goto L75;
        String r36 = null;
    L74:
        int r41 = r117;
        if (r13.isNull(r41) == false) goto L80;
        String r37 = null;
    L79:
        int r42 = r118;
        if (r13.isNull(r42) == false) goto L85;
        String r38 = null;
    L84:
        int r43 = r119;
        if (r13.isNull(r43) == false) goto L89;
        String r39 = null;
    L90:
        r23.add(new j(r24, r25, r26, r27, r28, r29, r210, r211, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39));     // Catch: Throwable -> L92
        r14 = r120;
        r116 = r40;
        r117 = r41;
        r118 = r42;
        r119 = r43;
        r22 = r22;
        goto L20
    L89:
        r39 = r13.getString(r43);     // Catch: Throwable -> L92
        goto L90
    L85:
        r38 = r13.getString(r42);     // Catch: Throwable -> L92
        goto L84
    L80:
        r37 = r13.getString(r41);     // Catch: Throwable -> L92
        goto L79
    L75:
        r36 = r13.getString(r40);     // Catch: Throwable -> L92
        goto L74
    L70:
        r35 = r13.getString(r22);     // Catch: Throwable -> L92
        goto L69
    L65:
        r34 = r13.getString(r115);     // Catch: Throwable -> L92
        goto L67
    L61:
        r33 = Integer.valueOf(r13.getInt(r114));     // Catch: Throwable -> L92
        goto L63
    L57:
        r32 = Long.valueOf(r13.getLong(r113));     // Catch: Throwable -> L92
        goto L59
    L53:
        r31 = Long.valueOf(r13.getLong(r112));     // Catch: Throwable -> L92
        goto L55
    L49:
        r30 = Integer.valueOf(r13.getInt(r111));     // Catch: Throwable -> L92
        goto L51
    L45:
        r211 = false;
        goto L47
    L41:
        r28 = r13.getString(r18);     // Catch: Throwable -> L92
        goto L42
    L37:
        r27 = r13.getString(r17);     // Catch: Throwable -> L92
        goto L39
    L33:
        r26 = r13.getString(r16);     // Catch: Throwable -> L92
        goto L35
    L29:
        r25 = r13.getString(r15);     // Catch: Throwable -> L92
        goto L31
    L25:
        r24 = r13.getString(r14);     // Catch: Throwable -> L92
        goto L27
    L94:
        r13.close();
        return r23;
    L92:
        th = move-exception;
        r13.close();
        throw th;
    L98:
        Cursor r44 = DBUtil.query(this.f11473c.f11479a, this.f11472b, false, null);
        int r45 = CursorUtil.getColumnIndexOrThrow(r44, "id");     // Catch: Throwable -> L172
        int r46 = CursorUtil.getColumnIndexOrThrow(r44, "originalId");     // Catch: Throwable -> L172
        int r47 = CursorUtil.getColumnIndexOrThrow(r44, "type");     // Catch: Throwable -> L172
        int r48 = CursorUtil.getColumnIndexOrThrow(r44, Constant.TITLE);     // Catch: Throwable -> L172
        int r49 = CursorUtil.getColumnIndexOrThrow(r44, Constant.DESCRIPTION);     // Catch: Throwable -> L172
        int r50 = CursorUtil.getColumnIndexOrThrow(r44, "spanX");     // Catch: Throwable -> L172
        int r51 = CursorUtil.getColumnIndexOrThrow(r44, "spanY");     // Catch: Throwable -> L172
        int r121 = CursorUtil.getColumnIndexOrThrow(r44, "isVisible");     // Catch: Throwable -> L172
        int r122 = CursorUtil.getColumnIndexOrThrow(r44, "sortIndex");     // Catch: Throwable -> L172
        int r123 = CursorUtil.getColumnIndexOrThrow(r44, "createTime");     // Catch: Throwable -> L172
        int r124 = CursorUtil.getColumnIndexOrThrow(r44, "modifyTime");     // Catch: Throwable -> L172
        int r125 = CursorUtil.getColumnIndexOrThrow(r44, "instanceId");     // Catch: Throwable -> L172
        int r126 = CursorUtil.getColumnIndexOrThrow(r44, "appletId");     // Catch: Throwable -> L172
        int r52 = CursorUtil.getColumnIndexOrThrow(r44, "widgetId");     // Catch: Throwable -> L172
        int r127 = CursorUtil.getColumnIndexOrThrow(r44, "definitionId");     // Catch: Throwable -> L172
        int r128 = CursorUtil.getColumnIndexOrThrow(r44, "config");     // Catch: Throwable -> L172
        int r129 = CursorUtil.getColumnIndexOrThrow(r44, "extras");     // Catch: Throwable -> L172
        int r130 = CursorUtil.getColumnIndexOrThrow(r44, "data");     // Catch: Throwable -> L172
        int r212 = r52;
        ArrayList r53 = new ArrayList(r44.getCount());     // Catch: Throwable -> L172
    L100:
        if (r44.moveToNext() == false) goto L174;
        if (r44.isNull(r45) == false) goto L105;
        String r213 = null;
    L107:
        if (r44.isNull(r46) == false) goto L109;
        String r214 = null;
    L111:
        if (r44.isNull(r47) == false) goto L113;
        String r215 = null;
    L115:
        if (r44.isNull(r48) == false) goto L117;
        String r216 = null;
    L119:
        if (r44.isNull(r49) == false) goto L121;
        String r217 = null;
    L122:
        int r218 = r44.getInt(r50);     // Catch: Throwable -> L172
        int r219 = r44.getInt(r51);     // Catch: Throwable -> L172
        if (r44.getInt(r121) == 0) goto L125;
        boolean r220 = true;
    L127:
        if (r44.isNull(r122) == false) goto L129;
        Integer r310 = null;
    L131:
        if (r44.isNull(r123) == false) goto L133;
        Long r311 = null;
    L135:
        if (r44.isNull(r124) == false) goto L137;
        Long r312 = null;
    L139:
        if (r44.isNull(r125) == false) goto L141;
        Integer r313 = null;
    L143:
        if (r44.isNull(r126) == false) goto L145;
        String r314 = null;
    L147:
        if (r44.isNull(r212) == false) goto L150;
        String r315 = null;
    L149:
        int r410 = r127;
        int r131 = r45;
        if (r44.isNull(r410) == false) goto L155;
        String r316 = null;
    L154:
        int r411 = r128;
        if (r44.isNull(r411) == false) goto L160;
        String r317 = null;
    L159:
        int r412 = r129;
        if (r44.isNull(r412) == false) goto L165;
        String r318 = null;
    L164:
        int r413 = r130;
        if (r44.isNull(r413) == false) goto L169;
        String r319 = null;
    L170:
        r53.add(new j(r213, r214, r215, r216, r217, r218, r219, r220, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319));     // Catch: Throwable -> L172
        r45 = r131;
        r127 = r410;
        r128 = r411;
        r129 = r412;
        r130 = r413;
        r212 = r212;
        goto L100
    L169:
        r319 = r44.getString(r413);     // Catch: Throwable -> L172
        goto L170
    L165:
        r318 = r44.getString(r412);     // Catch: Throwable -> L172
        goto L164
    L160:
        r317 = r44.getString(r411);     // Catch: Throwable -> L172
        goto L159
    L155:
        r316 = r44.getString(r410);     // Catch: Throwable -> L172
        goto L154
    L150:
        r315 = r44.getString(r212);     // Catch: Throwable -> L172
        goto L149
    L145:
        r314 = r44.getString(r126);     // Catch: Throwable -> L172
        goto L147
    L141:
        r313 = Integer.valueOf(r44.getInt(r125));     // Catch: Throwable -> L172
        goto L143
    L137:
        r312 = Long.valueOf(r44.getLong(r124));     // Catch: Throwable -> L172
        goto L139
    L133:
        r311 = Long.valueOf(r44.getLong(r123));     // Catch: Throwable -> L172
        goto L135
    L129:
        r310 = Integer.valueOf(r44.getInt(r122));     // Catch: Throwable -> L172
        goto L131
    L125:
        r220 = false;
        goto L127
    L121:
        r217 = r44.getString(r49);     // Catch: Throwable -> L172
        goto L122
    L117:
        r216 = r44.getString(r48);     // Catch: Throwable -> L172
        goto L119
    L113:
        r215 = r44.getString(r47);     // Catch: Throwable -> L172
        goto L115
    L109:
        r214 = r44.getString(r46);     // Catch: Throwable -> L172
        goto L111
    L105:
        r213 = r44.getString(r45);     // Catch: Throwable -> L172
        goto L107
    L174:
        r44.close();
        return r53;
    L172:
        th = move-exception;
        r44.close();
        throw th;
    }

    public void finalize() {
        switch(this.f11471a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.finalize();
        return;
    L6:
        this.f11472b.release();
        return;
    L8:
        this.f11472b.release();
    }
}
