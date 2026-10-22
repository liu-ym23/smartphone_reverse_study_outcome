package com.bytedance.ai.resource.core.db;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements Callable<List<Widget>> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ j b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Widget> call2() throws Exception {
        Cursor r10 = DBUtil.query(this.b.b, this.a, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r10, "widget_id");     // Catch: Throwable -> L111
        int r11 = CursorUtil.getColumnIndexOrThrow(r10, "entry");     // Catch: Throwable -> L111
        int r12 = CursorUtil.getColumnIndexOrThrow(r10, "input");     // Catch: Throwable -> L111
        int r13 = CursorUtil.getColumnIndexOrThrow(r10, "output");     // Catch: Throwable -> L111
        int r14 = CursorUtil.getColumnIndexOrThrow(r10, "border");     // Catch: Throwable -> L111
        int r15 = CursorUtil.getColumnIndexOrThrow(r10, "box_type");     // Catch: Throwable -> L111
        int r16 = CursorUtil.getColumnIndexOrThrow(r10, "title_type");     // Catch: Throwable -> L111
        int r17 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);     // Catch: Throwable -> L111
        int r18 = CursorUtil.getColumnIndexOrThrow(r10, "package_name");     // Catch: Throwable -> L111
        int r19 = CursorUtil.getColumnIndexOrThrow(r10, "version_code");     // Catch: Throwable -> L111
        int r110 = CursorUtil.getColumnIndexOrThrow(r10, "scm_version");     // Catch: Throwable -> L111
        int r111 = CursorUtil.getColumnIndexOrThrow(r10, "version_name");     // Catch: Throwable -> L111
        int r20 = CursorUtil.getColumnIndexOrThrow(r10, "description");     // Catch: Throwable -> L111
        int r21 = CursorUtil.getColumnIndexOrThrow(r10, "icons");     // Catch: Throwable -> L111
        int r112 = CursorUtil.getColumnIndexOrThrow(r10, "manifest_version");     // Catch: Throwable -> L109
        int r113 = CursorUtil.getColumnIndexOrThrow(r10, "prop");     // Catch: Throwable -> L109
        int r114 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);     // Catch: Throwable -> L109
        int r115 = CursorUtil.getColumnIndexOrThrow(r10, "keywords");     // Catch: Throwable -> L109
        int r22 = CursorUtil.getColumnIndexOrThrow(r10, "app_group");     // Catch: Throwable -> L109
        int r23 = CursorUtil.getColumnIndexOrThrow(r10, "id");     // Catch: Throwable -> L109
        int r24 = CursorUtil.getColumnIndexOrThrow(r10, "digest");     // Catch: Throwable -> L109
        int r25 = CursorUtil.getColumnIndexOrThrow(r10, "render_type");     // Catch: Throwable -> L109
        int r26 = CursorUtil.getColumnIndexOrThrow(r10, "size");     // Catch: Throwable -> L109
        int r27 = CursorUtil.getColumnIndexOrThrow(r10, "ft");     // Catch: Throwable -> L109
        int r28 = CursorUtil.getColumnIndexOrThrow(r10, "it");     // Catch: Throwable -> L109
        int r29 = CursorUtil.getColumnIndexOrThrow(r10, "ut");     // Catch: Throwable -> L109
        int r210 = CursorUtil.getColumnIndexOrThrow(r10, "update_time");     // Catch: Throwable -> L109
        int r211 = CursorUtil.getColumnIndexOrThrow(r10, "create_time");     // Catch: Throwable -> L109
        int r30 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_STATUS);     // Catch: Throwable -> L109
        int r31 = CursorUtil.getColumnIndexOrThrow(r10, "ready_for_deleting");     // Catch: Throwable -> L109
        int r32 = CursorUtil.getColumnIndexOrThrow(r10, "runtime_version");     // Catch: Throwable -> L109
        int r33 = CursorUtil.getColumnIndexOrThrow(r10, "has_key_store");     // Catch: Throwable -> L109
        int r34 = CursorUtil.getColumnIndexOrThrow(r10, "sign_verify_switch");     // Catch: Throwable -> L109
        int r35 = CursorUtil.getColumnIndexOrThrow(r10, "app_type");     // Catch: Throwable -> L109
        int r36 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE);     // Catch: Throwable -> L109
        int r37 = r21;
        ArrayList r1 = new ArrayList(r10.getCount());     // Catch: Throwable -> L109
    L5:
        if (r10.moveToNext() == false) goto L107;
        if (r10.isNull(r0) == false) goto L10;
        String r52 = null;
    L12:
        if (r10.isNull(r11) == false) goto L14;
        String r53 = null;
    L16:
        if (r10.isNull(r12) == false) goto L18;
        String r54 = null;
    L20:
        if (r10.isNull(r13) == false) goto L22;
        String r55 = null;
    L24:
        if (r10.getInt(r14) == 0) goto L26;
        boolean r56 = true;
    L27:
        int r57 = r10.getInt(r15);     // Catch: Throwable -> L109
        if (r10.isNull(r16) == false) goto L30;
        Integer r58 = null;
    L32:
        if (r10.isNull(r17) == false) goto L34;
        String r39 = null;
    L36:
        if (r10.isNull(r18) == false) goto L38;
        String r40 = null;
    L39:
        long r41 = r10.getLong(r19);     // Catch: Throwable -> L109
        if (r10.isNull(r110) == false) goto L42;
        String r43 = null;
    L44:
        if (r10.isNull(r111) == false) goto L46;
        String r44 = null;
    L48:
        if (r10.isNull(r20) == false) goto L50;
        String r45 = null;
    L52:
        if (r10.isNull(r37) == false) goto L54;
        String r38 = null;
    L55:
        int r61 = r0;
        int r60 = r20;
        if (r38 != null) goto L58;
        Icons r46 = null;
        r r42 = this;
    L115:
        if (r10.isNull(r112) == false) goto L63;
        String r47 = null;
    L65:
        if (r10.isNull(r113) == false) goto L67;
        String r48 = null;
    L69:
        if (r10.isNull(r114) == false) goto L71;
        String r49 = null;
    L73:
        if (r10.isNull(r115) == false) goto L75;
        String r116 = null;
    L76:
        if (r116 != null) goto L78;
        List r50 = null;
    L80:
        if (r10.isNull(r22) == false) goto L82;
        String r51 = null;
    L84:
        if (r10.isNull(r32) == false) goto L86;
        String r59 = null;
    L87:
        Widget r62 = new Widget(r39, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59);     // Catch: Throwable -> L105
        int r117 = r37;
        int r310 = r12;
        int r63 = r23;
        int r212 = r11;
        r62.m = r10.getLong(r63);     // Catch: Throwable -> L105
        int r64 = r24;
        if (r10.isNull(r64) == false) goto L90;
        String r65 = null;
    L91:
        r62.i(r65);     // Catch: Throwable -> L105
        int r66 = r25;
        if (r10.isNull(r66) == false) goto L94;
        String r67 = null;
    L95:
        r62.k(r67);     // Catch: Throwable -> L105
        r24 = r64;
        int r68 = r26;
        r62.p = r10.getLong(r68);     // Catch: Throwable -> L105
        int r69 = r27;
        int r213 = r13;
        r62.q = r10.getLong(r69);     // Catch: Throwable -> L105
        int r70 = r28;
        r62.r = r10.getLong(r70);     // Catch: Throwable -> L105
        int r71 = r29;
        r62.s = r10.getLong(r71);     // Catch: Throwable -> L105
        int r72 = r210;
        r62.t = r10.getLong(r72);     // Catch: Throwable -> L105
        int r73 = r211;
        r62.u = r10.getLong(r73);     // Catch: Throwable -> L105
        int r74 = r30;
        if (r10.isNull(r74) == false) goto L98;
        String r75 = null;
    L99:
        r62.j(r75);     // Catch: Throwable -> L105
        int r76 = r31;
        if (r10.isNull(r76) == false) goto L102;
        Integer r77 = null;
    L103:
        r62.w = r77;     // Catch: Throwable -> L105
        int r78 = r33;
        r62.D = r10.getInt(r78);     // Catch: Throwable -> L105
        r33 = r78;
        int r79 = r34;
        r62.E = r10.getInt(r79);     // Catch: Throwable -> L105
        r34 = r79;
        int r80 = r35;
        r62.F = r10.getInt(r80);     // Catch: Throwable -> L105
        r35 = r80;
        int r81 = r36;
        r62.G = r10.getInt(r81);     // Catch: Throwable -> L105
        r1.add(r62);     // Catch: Throwable -> L105
        r36 = r81;
        r11 = r212;
        r23 = r63;
        r25 = r66;
        r26 = r68;
        r210 = r72;
        r20 = r60;
        r0 = r61;
        r211 = r73;
        r12 = r310;
        r29 = r71;
        r13 = r213;
        r27 = r69;
        r28 = r70;
        r37 = r117;
        r115 = r115;
        r31 = r76;
        r30 = r74;
        goto L5
    L102:
        r77 = Integer.valueOf(r10.getInt(r76));     // Catch: Throwable -> L105
        goto L103
    L98:
        r75 = r10.getString(r74);     // Catch: Throwable -> L105
        goto L99
    L94:
        r67 = r10.getString(r66);     // Catch: Throwable -> L105
        goto L95
    L90:
        r65 = r10.getString(r64);     // Catch: Throwable -> L105
        goto L91
    L86:
        r59 = r10.getString(r32);     // Catch: Throwable -> L105
        goto L87
    L82:
        r51 = r10.getString(r22);     // Catch: Throwable -> L105
        goto L84
    L78:
        r42.b.d.getClass();     // Catch: Throwable -> L105
        r50 = h5.h.b(r116);     // Catch: Throwable -> L105
        goto L80
    L75:
        r116 = r10.getString(r115);     // Catch: Throwable -> L105
        goto L76
    L71:
        r49 = r10.getString(r114);     // Catch: Throwable -> L105
        goto L73
    L67:
        r48 = r10.getString(r113);     // Catch: Throwable -> L105
        goto L69
    L63:
        r47 = r10.getString(r112);     // Catch: Throwable -> L105
    L105:
        th = th;
    L113:
        r10.close();
        r42.a.release();
        throw th;
    L58:
        r42 = this;
        r42.b.d.getClass();     // Catch: Throwable -> L105
        r46 = h5.h.a(r38);     // Catch: Throwable -> L105
        goto L115
    L54:
        r38 = r10.getString(r37);     // Catch: Throwable -> L109
        goto L55
    L50:
        r45 = r10.getString(r20);     // Catch: Throwable -> L109
        goto L52
    L46:
        r44 = r10.getString(r111);     // Catch: Throwable -> L109
        goto L48
    L42:
        r43 = r10.getString(r110);     // Catch: Throwable -> L109
        goto L44
    L38:
        r40 = r10.getString(r18);     // Catch: Throwable -> L109
        goto L39
    L34:
        r39 = r10.getString(r17);     // Catch: Throwable -> L109
        goto L36
    L30:
        r58 = Integer.valueOf(r10.getInt(r16));     // Catch: Throwable -> L109
        goto L32
    L26:
        r56 = false;
        goto L27
    L22:
        r55 = r10.getString(r13);     // Catch: Throwable -> L109
        goto L24
    L18:
        r54 = r10.getString(r12);     // Catch: Throwable -> L109
        goto L20
    L14:
        r53 = r10.getString(r11);     // Catch: Throwable -> L109
        goto L16
    L10:
        r52 = r10.getString(r0);     // Catch: Throwable -> L109
        goto L12
    L107:
        r10.close();
        this.a.release();
        return r1;
    L109:
        th = th;
        r42 = this;
    L111:
        th = th;
        r42 = this;
        goto L113
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Widget> call() throws Exception {
        return call2();
    }

    public r(j r1, RoomSQLiteQuery r10) {
        this.b = r1;
        this.a = r10;
    }
}
