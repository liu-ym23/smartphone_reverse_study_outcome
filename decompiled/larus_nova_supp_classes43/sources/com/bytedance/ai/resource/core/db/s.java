package com.bytedance.ai.resource.core.db;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s implements Callable<List<Applet>> {
    public final /* synthetic */ RoomSQLiteQuery a;
    public final /* synthetic */ j b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Applet> call2() throws Exception {
        Cursor r10 = DBUtil.query(this.b.b, this.a, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r10, "applet_id");     // Catch: Throwable -> L142
        int r11 = CursorUtil.getColumnIndexOrThrow(r10, "pages");     // Catch: Throwable -> L142
        int r12 = CursorUtil.getColumnIndexOrThrow(r10, "plugins");     // Catch: Throwable -> L142
        int r13 = CursorUtil.getColumnIndexOrThrow(r10, "bot_id");     // Catch: Throwable -> L142
        int r14 = CursorUtil.getColumnIndexOrThrow(r10, "applet_entry");     // Catch: Throwable -> L142
        int r15 = CursorUtil.getColumnIndexOrThrow(r10, "runtime_entry");     // Catch: Throwable -> L142
        int r16 = CursorUtil.getColumnIndexOrThrow(r10, "botDevMode");     // Catch: Throwable -> L142
        int r17 = CursorUtil.getColumnIndexOrThrow(r10, "main_init");     // Catch: Throwable -> L142
        int r18 = CursorUtil.getColumnIndexOrThrow(r10, "services");     // Catch: Throwable -> L142
        int r19 = CursorUtil.getColumnIndexOrThrow(r10, "permissions");     // Catch: Throwable -> L142
        int r110 = CursorUtil.getColumnIndexOrThrow(r10, "dark_mode");     // Catch: Throwable -> L142
        int r111 = CursorUtil.getColumnIndexOrThrow(r10, "chat");     // Catch: Throwable -> L142
        int r20 = CursorUtil.getColumnIndexOrThrow(r10, "tool_runtime_entry");     // Catch: Throwable -> L142
        int r112 = CursorUtil.getColumnIndexOrThrow(r10, "settings");     // Catch: Throwable -> L142
        int r21 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);     // Catch: Throwable -> L142
        int r113 = r20;
        int r22 = CursorUtil.getColumnIndexOrThrow(r10, "package_name");     // Catch: Throwable -> L142
        int r114 = r111;
        int r115 = CursorUtil.getColumnIndexOrThrow(r10, "version_code");     // Catch: Throwable -> L142
        int r116 = r110;
        int r117 = CursorUtil.getColumnIndexOrThrow(r10, "scm_version");     // Catch: Throwable -> L142
        int r23 = r19;
        int r118 = CursorUtil.getColumnIndexOrThrow(r10, "version_name");     // Catch: Throwable -> L142
        int r24 = r18;
        int r119 = CursorUtil.getColumnIndexOrThrow(r10, "description");     // Catch: Throwable -> L142
        int r25 = r17;
        int r120 = CursorUtil.getColumnIndexOrThrow(r10, "icons");     // Catch: Throwable -> L142
        int r26 = r16;
        int r27 = CursorUtil.getColumnIndexOrThrow(r10, "manifest_version");     // Catch: Throwable -> L142
        int r28 = CursorUtil.getColumnIndexOrThrow(r10, "prop");     // Catch: Throwable -> L142
        int r29 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);     // Catch: Throwable -> L142
        int r210 = CursorUtil.getColumnIndexOrThrow(r10, "keywords");     // Catch: Throwable -> L142
        int r211 = CursorUtil.getColumnIndexOrThrow(r10, "app_group");     // Catch: Throwable -> L142
        int r212 = CursorUtil.getColumnIndexOrThrow(r10, "id");     // Catch: Throwable -> L142
        int r30 = CursorUtil.getColumnIndexOrThrow(r10, "digest");     // Catch: Throwable -> L142
        int r31 = CursorUtil.getColumnIndexOrThrow(r10, "render_type");     // Catch: Throwable -> L142
        int r32 = CursorUtil.getColumnIndexOrThrow(r10, "size");     // Catch: Throwable -> L142
        int r33 = CursorUtil.getColumnIndexOrThrow(r10, "ft");     // Catch: Throwable -> L142
        int r34 = CursorUtil.getColumnIndexOrThrow(r10, "it");     // Catch: Throwable -> L142
        int r35 = CursorUtil.getColumnIndexOrThrow(r10, "ut");     // Catch: Throwable -> L142
        int r36 = CursorUtil.getColumnIndexOrThrow(r10, "update_time");     // Catch: Throwable -> L142
        int r37 = CursorUtil.getColumnIndexOrThrow(r10, "create_time");     // Catch: Throwable -> L142
        int r38 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_STATUS);     // Catch: Throwable -> L142
        int r39 = CursorUtil.getColumnIndexOrThrow(r10, "ready_for_deleting");     // Catch: Throwable -> L142
        int r40 = CursorUtil.getColumnIndexOrThrow(r10, "runtime_version");     // Catch: Throwable -> L142
        int r41 = CursorUtil.getColumnIndexOrThrow(r10, "has_key_store");     // Catch: Throwable -> L142
        int r42 = CursorUtil.getColumnIndexOrThrow(r10, "sign_verify_switch");     // Catch: Throwable -> L142
        int r43 = CursorUtil.getColumnIndexOrThrow(r10, "app_type");     // Catch: Throwable -> L142
        int r44 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE);     // Catch: Throwable -> L142
        int r45 = r120;
        ArrayList r121 = new ArrayList(r10.getCount());     // Catch: Throwable -> L142
    L4:
        if (r10.moveToNext() == false) goto L140;
        if (r10.isNull(r0) == false) goto L9;
        String r60 = null;
    L11:
        if (r10.isNull(r11) == false) goto L13;
        String r122 = null;
    L14:
        if (r122 != null) goto L16;
        List r61 = null;
    L18:
        if (r10.isNull(r12) == false) goto L20;
        String r1 = null;
    L21:
        if (r1 != null) goto L23;
        List r62 = null;
    L25:
        if (r10.isNull(r13) == false) goto L27;
        String r63 = null;
    L29:
        if (r10.isNull(r14) == false) goto L31;
        String r64 = null;
    L33:
        if (r10.isNull(r15) == false) goto L35;
        String r65 = null;
    L37:
        if (r10.isNull(r21) == false) goto L39;
        String r47 = null;
    L41:
        if (r10.isNull(r22) == false) goto L43;
        String r48 = null;
    L44:
        long r49 = r10.getLong(r115);     // Catch: Throwable -> L142
        if (r10.isNull(r117) == false) goto L47;
        String r51 = null;
    L49:
        if (r10.isNull(r118) == false) goto L51;
        String r52 = null;
    L53:
        if (r10.isNull(r119) == false) goto L55;
        String r53 = null;
    L57:
        if (r10.isNull(r45) == false) goto L59;
        String r123 = null;
    L60:
        if (r123 != null) goto L62;
        Icons r54 = null;
    L64:
        if (r10.isNull(r27) == false) goto L66;
        String r55 = null;
    L68:
        if (r10.isNull(r28) == false) goto L70;
        String r56 = null;
    L72:
        if (r10.isNull(r29) == false) goto L74;
        String r57 = null;
    L76:
        if (r10.isNull(r210) == false) goto L78;
        String r213 = null;
    L79:
        if (r213 != null) goto L81;
        List r58 = null;
    L83:
        if (r10.isNull(r211) == false) goto L85;
        String r59 = null;
    L87:
        if (r10.isNull(r40) == false) goto L89;
        String r66 = null;
    L90:
        Applet r46 = new Applet(r47, r48, r49, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66);     // Catch: Throwable -> L142
        int r214 = r22;
        int r50 = r26;
        if (r10.isNull(r50) == false) goto L93;
        String r67 = null;
    L94:
        r46.r(r67);     // Catch: Throwable -> L142
        int r68 = r25;
        if (r10.isNull(r68) == false) goto L97;
        String r215 = null;
    L98:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r46.U = h5.h.c(r215);     // Catch: Throwable -> L142
        int r69 = r24;
        if (r10.isNull(r69) == false) goto L101;
        String r216 = null;
    L102:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r46.V = h5.h.g(r216);     // Catch: Throwable -> L142
        int r70 = r23;
        if (r10.isNull(r70) == false) goto L105;
        String r217 = null;
    L106:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r46.W = h5.h.e(r217);     // Catch: Throwable -> L142
        r116 = r116;
        if (r10.getInt(r116) == 0) goto L109;
        boolean r71 = true;
    L110:
        r46.X = r71;     // Catch: Throwable -> L142
        int r72 = r114;
        if (r10.isNull(r72) == false) goto L113;
        String r73 = null;
    L114:
        r46.Y = r73;     // Catch: Throwable -> L142
        int r74 = r113;
        if (r10.isNull(r74) == false) goto L117;
        String r75 = null;
    L118:
        r46.Z = r75;     // Catch: Throwable -> L142
        int r76 = r112;
        if (r10.isNull(r76) == false) goto L121;
        String r124 = null;
    L122:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r46.k0 = h5.h.h(r124);     // Catch: Throwable -> L142
        int r125 = r11;
        int r77 = r212;
        int r218 = r21;
        r46.m = r10.getLong(r77);     // Catch: Throwable -> L142
        int r78 = r30;
        if (r10.isNull(r78) == false) goto L125;
        String r79 = null;
    L126:
        r46.i(r79);     // Catch: Throwable -> L142
        int r80 = r31;
        if (r10.isNull(r80) == false) goto L129;
        String r81 = null;
    L130:
        r46.k(r81);     // Catch: Throwable -> L142
        r30 = r78;
        int r82 = r32;
        r46.p = r10.getLong(r82);     // Catch: Throwable -> L142
        int r83 = r33;
        int r310 = r12;
        r46.q = r10.getLong(r83);     // Catch: Throwable -> L142
        int r84 = r34;
        r46.r = r10.getLong(r84);     // Catch: Throwable -> L142
        int r85 = r35;
        r46.s = r10.getLong(r85);     // Catch: Throwable -> L142
        int r86 = r36;
        r46.t = r10.getLong(r86);     // Catch: Throwable -> L142
        int r87 = r37;
        r46.u = r10.getLong(r87);     // Catch: Throwable -> L142
        int r88 = r38;
        if (r10.isNull(r88) == false) goto L133;
        String r89 = null;
    L134:
        r46.j(r89);     // Catch: Throwable -> L142
        int r90 = r39;
        if (r10.isNull(r90) == false) goto L137;
        Integer r91 = null;
    L138:
        r46.w = r91;     // Catch: Throwable -> L142
        int r92 = r41;
        r46.D = r10.getInt(r92);     // Catch: Throwable -> L142
        r41 = r92;
        int r93 = r42;
        r46.E = r10.getInt(r93);     // Catch: Throwable -> L142
        r42 = r93;
        int r94 = r43;
        r46.F = r10.getInt(r94);     // Catch: Throwable -> L142
        r43 = r94;
        int r95 = r44;
        r46.G = r10.getInt(r95);     // Catch: Throwable -> L142
        r121.add(r46);     // Catch: Throwable -> L142
        r44 = r95;
        r22 = r214;
        r21 = r218;
        r212 = r77;
        r31 = r80;
        r32 = r82;
        r36 = r86;
        r0 = r0;
        r37 = r87;
        r28 = r28;
        r11 = r125;
        r112 = r76;
        r113 = r74;
        r114 = r72;
        r23 = r70;
        r24 = r69;
        r25 = r68;
        r26 = r50;
        r35 = r85;
        r12 = r310;
        r33 = r83;
        r34 = r84;
        r39 = r90;
        r38 = r88;
        goto L4
    L137:
        r91 = Integer.valueOf(r10.getInt(r90));     // Catch: Throwable -> L142
        goto L138
    L133:
        r89 = r10.getString(r88);     // Catch: Throwable -> L142
        goto L134
    L129:
        r81 = r10.getString(r80);     // Catch: Throwable -> L142
        goto L130
    L125:
        r79 = r10.getString(r78);     // Catch: Throwable -> L142
        goto L126
    L121:
        r124 = r10.getString(r76);     // Catch: Throwable -> L142
        goto L122
    L117:
        r75 = r10.getString(r74);     // Catch: Throwable -> L142
        goto L118
    L113:
        r73 = r10.getString(r72);     // Catch: Throwable -> L142
        goto L114
    L109:
        r71 = false;
        goto L110
    L105:
        r217 = r10.getString(r70);     // Catch: Throwable -> L142
        goto L106
    L101:
        r216 = r10.getString(r69);     // Catch: Throwable -> L142
        goto L102
    L97:
        r215 = r10.getString(r68);     // Catch: Throwable -> L142
        goto L98
    L93:
        r67 = r10.getString(r50);     // Catch: Throwable -> L142
        goto L94
    L89:
        r66 = r10.getString(r40);     // Catch: Throwable -> L142
        goto L90
    L85:
        r59 = r10.getString(r211);     // Catch: Throwable -> L142
        goto L87
    L81:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r58 = h5.h.b(r213);     // Catch: Throwable -> L142
        goto L83
    L78:
        r213 = r10.getString(r210);     // Catch: Throwable -> L142
        goto L79
    L74:
        r57 = r10.getString(r29);     // Catch: Throwable -> L142
        goto L76
    L70:
        r56 = r10.getString(r28);     // Catch: Throwable -> L142
        goto L72
    L66:
        r55 = r10.getString(r27);     // Catch: Throwable -> L142
        goto L68
    L62:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r54 = h5.h.a(r123);     // Catch: Throwable -> L142
        goto L64
    L59:
        r123 = r10.getString(r45);     // Catch: Throwable -> L142
        goto L60
    L55:
        r53 = r10.getString(r119);     // Catch: Throwable -> L142
        goto L57
    L51:
        r52 = r10.getString(r118);     // Catch: Throwable -> L142
        goto L53
    L47:
        r51 = r10.getString(r117);     // Catch: Throwable -> L142
        goto L49
    L43:
        r48 = r10.getString(r22);     // Catch: Throwable -> L142
        goto L44
    L39:
        r47 = r10.getString(r21);     // Catch: Throwable -> L142
        goto L41
    L35:
        r65 = r10.getString(r15);     // Catch: Throwable -> L142
        goto L37
    L31:
        r64 = r10.getString(r14);     // Catch: Throwable -> L142
        goto L33
    L27:
        r63 = r10.getString(r13);     // Catch: Throwable -> L142
        goto L29
    L23:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r62 = h5.h.f(r1);     // Catch: Throwable -> L142
        goto L25
    L20:
        r1 = r10.getString(r12);     // Catch: Throwable -> L142
        goto L21
    L16:
        this.b.d.getClass();     // Catch: Throwable -> L142
        r61 = h5.h.d(r122);     // Catch: Throwable -> L142
        goto L18
    L13:
        r122 = r10.getString(r11);     // Catch: Throwable -> L142
        goto L14
    L9:
        r60 = r10.getString(r0);     // Catch: Throwable -> L142
        goto L11
    L140:
        r10.close();
        this.a.release();
        return r121;
    L142:
        th = move-exception;
        r10.close();
        this.a.release();
        throw th;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Applet> call() throws Exception {
        return call2();
    }

    public s(j r1, RoomSQLiteQuery r10) {
        this.b = r1;
        this.a = r10;
    }
}
