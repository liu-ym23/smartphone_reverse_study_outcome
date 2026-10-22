package com.bytedance.ai.resource.core.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Widget;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x extends EntityDeletionOrUpdateAdapter<Widget> {
    public final /* synthetic */ j a;

    public final String createQuery() {
        return "UPDATE OR ABORT `ai_widget_info` SET `widget_id` = ?,`entry` = ?,`input` = ?,`output` = ?,`border` = ?,`box_type` = ?,`title_type` = ?,`name` = ?,`package_name` = ?,`version_code` = ?,`scm_version` = ?,`version_name` = ?,`description` = ?,`icons` = ?,`manifest_version` = ?,`prop` = ?,`recommend` = ?,`keywords` = ?,`app_group` = ?,`id` = ?,`digest` = ?,`render_type` = ?,`size` = ?,`ft` = ?,`it` = ?,`ut` = ?,`update_time` = ?,`create_time` = ?,`status` = ?,`ready_for_deleting` = ?,`runtime_version` = ?,`has_key_store` = ?,`sign_verify_switch` = ?,`app_type` = ?,`source_type` = ? WHERE `id` = ?";
    }

    public x(j r1, AIPackageDatabase r10) {
        this.a = r1;
        super(r10);
    }

    public final void bind(SupportSQLiteStatement r10, Object r11) {
        Widget r12 = (Widget) r11;
        String r0 = r12.K;
        if (r0 != null) goto L5;
        r10.bindNull(1);
    L6:
        String r1 = r12.L;
        if (r1 != null) goto L9;
        r10.bindNull(2);
    L10:
        String r13 = r12.M;
        if (r13 != null) goto L13;
        r10.bindNull(3);
    L14:
        String r14 = r12.N;
        if (r14 != null) goto L17;
        r10.bindNull(4);
    L18:
        r10.bindLong(5, r12.O ? 1 : 0);
        r10.bindLong(6, r12.P);
        Integer r15 = r12.Q;
        if (r15 != null) goto L21;
        r10.bindNull(7);
    L22:
        String r16 = r12.a;
        if (r16 != null) goto L25;
        r10.bindNull(8);
    L26:
        String r17 = r12.b;
        if (r17 != null) goto L29;
        r10.bindNull(9);
    L30:
        r10.bindLong(10, r12.c);
        String r18 = r12.d;
        if (r18 != null) goto L33;
        r10.bindNull(11);
    L34:
        String r19 = r12.e;
        if (r19 != null) goto L37;
        r10.bindNull(12);
    L38:
        String r20 = r12.f;
        if (r20 != null) goto L41;
        r10.bindNull(13);
    L42:
        Icons r21 = r12.g;
        String r22 = null;
        if (r21 != null) goto L45;
        String r23 = null;
    L47:
        if (r23 != null) goto L49;
        r10.bindNull(14);
    L50:
        String r24 = r12.h;
        if (r24 != null) goto L53;
        r10.bindNull(15);
    L54:
        String r25 = r12.i;
        if (r25 != null) goto L57;
        r10.bindNull(16);
    L58:
        String r26 = r12.j;
        if (r26 != null) goto L61;
        r10.bindNull(17);
    L62:
        List<String> r27 = r12.k;
        if (r27 == null) goto L67;
        this.a.d.getClass();
        Intrinsics.checkNotNullParameter(r27, com.bytedance.android.ec.core.event.a.KEY_LIST);
        r22 = com.bytedance.ai.applet.base.gson.e.c(r27);
    L67:
        if (r22 != null) goto L69;
        r10.bindNull(18);
    L70:
        String r28 = r12.l;
        if (r28 != null) goto L73;
        r10.bindNull(19);
    L74:
        r10.bindLong(20, r12.m);
        String r29 = r12.n;
        if (r29 != null) goto L77;
        r10.bindNull(21);
    L78:
        String r30 = r12.o;
        if (r30 != null) goto L81;
        r10.bindNull(22);
    L82:
        r10.bindLong(23, r12.p);
        r10.bindLong(24, r12.q);
        r10.bindLong(25, r12.r);
        r10.bindLong(26, r12.s);
        r10.bindLong(27, r12.t);
        r10.bindLong(28, r12.u);
        String r31 = r12.v;
        if (r31 != null) goto L85;
        r10.bindNull(29);
    L86:
        Integer r32 = r12.w;
        if (r32 != null) goto L89;
        r10.bindNull(30);
    L90:
        String r33 = r12.C;
        if (r33 != null) goto L93;
        r10.bindNull(31);
    L94:
        r10.bindLong(32, r12.D);
        r10.bindLong(33, r12.E);
        r10.bindLong(34, r12.F);
        r10.bindLong(35, r12.G);
        r10.bindLong(36, r12.m);
        return;
    L93:
        r10.bindString(31, r33);
        goto L94
    L89:
        r10.bindLong(30, r32.intValue());
        goto L90
    L85:
        r10.bindString(29, r31);
        goto L86
    L81:
        r10.bindString(22, r30);
        goto L82
    L77:
        r10.bindString(21, r29);
        goto L78
    L73:
        r10.bindString(19, r28);
        goto L74
    L69:
        r10.bindString(18, r22);
        goto L70
    L61:
        r10.bindString(17, r26);
        goto L62
    L57:
        r10.bindString(16, r25);
        goto L58
    L53:
        r10.bindString(15, r24);
        goto L54
    L49:
        r10.bindString(14, r23);
        goto L50
    L45:
        this.a.d.getClass();
        Intrinsics.checkNotNullParameter(r21, "icons");
        r23 = com.bytedance.ai.applet.base.gson.e.c(r21);
        goto L47
    L41:
        r10.bindString(13, r20);
        goto L42
    L37:
        r10.bindString(12, r19);
        goto L38
    L33:
        r10.bindString(11, r18);
        goto L34
    L29:
        r10.bindString(9, r17);
        goto L30
    L25:
        r10.bindString(8, r16);
        goto L26
    L21:
        r10.bindLong(7, r15.intValue());
        goto L22
    L17:
        r10.bindString(4, r14);
        goto L18
    L13:
        r10.bindString(3, r13);
        goto L14
    L9:
        r10.bindString(2, r1);
        goto L10
    L5:
        r10.bindString(1, r0);
        goto L6
    }
}
