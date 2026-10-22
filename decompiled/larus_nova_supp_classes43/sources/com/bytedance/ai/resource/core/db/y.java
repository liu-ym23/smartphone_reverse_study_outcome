package com.bytedance.ai.resource.core.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.AppletSettings;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.MainInitData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.ServiceInfo;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y extends EntityDeletionOrUpdateAdapter<Applet> {
    public final /* synthetic */ j a;

    public final String createQuery() {
        return "UPDATE OR ABORT `ai_applet_info` SET `applet_id` = ?,`pages` = ?,`plugins` = ?,`bot_id` = ?,`applet_entry` = ?,`runtime_entry` = ?,`botDevMode` = ?,`main_init` = ?,`services` = ?,`permissions` = ?,`dark_mode` = ?,`chat` = ?,`tool_runtime_entry` = ?,`settings` = ?,`name` = ?,`package_name` = ?,`version_code` = ?,`scm_version` = ?,`version_name` = ?,`description` = ?,`icons` = ?,`manifest_version` = ?,`prop` = ?,`recommend` = ?,`keywords` = ?,`app_group` = ?,`id` = ?,`digest` = ?,`render_type` = ?,`size` = ?,`ft` = ?,`it` = ?,`ut` = ?,`update_time` = ?,`create_time` = ?,`status` = ?,`ready_for_deleting` = ?,`runtime_version` = ?,`has_key_store` = ?,`sign_verify_switch` = ?,`app_type` = ?,`source_type` = ? WHERE `id` = ?";
    }

    public y(j r1, AIPackageDatabase r10) {
        this.a = r1;
        super(r10);
    }

    public final void bind(SupportSQLiteStatement r10, Object r11) {
        Applet r12 = (Applet) r11;
        String r0 = r12.K;
        if (r0 != null) goto L5;
        r10.bindNull(1);
    L6:
        List<Page> r1 = r12.L;
        String r13 = null;
        if (r1 != null) goto L9;
        String r14 = null;
    L11:
        if (r14 != null) goto L13;
        r10.bindNull(2);
    L14:
        List<Plugin> r15 = r12.M;
        if (r15 != null) goto L17;
        String r16 = null;
    L19:
        if (r16 != null) goto L21;
        r10.bindNull(3);
    L22:
        String r17 = r12.N;
        if (r17 != null) goto L25;
        r10.bindNull(4);
    L26:
        String r18 = r12.O;
        if (r18 != null) goto L29;
        r10.bindNull(5);
    L30:
        String r19 = r12.P;
        if (r19 != null) goto L33;
        r10.bindNull(6);
    L34:
        String r20 = r12.Q;
        if (r20 != null) goto L37;
        r10.bindNull(7);
    L38:
        h5.h r21 = this.a.d;
        MainInitData r22 = r12.U;
        r21.getClass();
        String r23 = "";
        if (r22 != null) goto L41;
        String r24 = "";
    L43:
        if (r24 != null) goto L45;
        r10.bindNull(8);
    L46:
        h5.h r25 = this.a.d;
        List<ServiceInfo> r26 = r12.V;
        r25.getClass();
        if (r26 != null) goto L49;
        String r27 = "";
    L51:
        if (r27 != null) goto L53;
        r10.bindNull(9);
    L54:
        h5.h r28 = this.a.d;
        Map<String, PermissionDetail> r29 = r12.W;
        r28.getClass();
        if (r29 != null) goto L57;
        String r30 = "";
    L59:
        if (r30 != null) goto L61;
        r10.bindNull(10);
    L62:
        r10.bindLong(11, r12.X ? 1 : 0);
        String r31 = r12.Y;
        if (r31 != null) goto L65;
        r10.bindNull(12);
    L66:
        String r32 = r12.Z;
        if (r32 != null) goto L69;
        r10.bindNull(13);
    L70:
        h5.h r33 = this.a.d;
        AppletSettings r34 = r12.k0;
        r33.getClass();
        if (r34 == null) goto L75;
        r23 = com.bytedance.ai.applet.base.gson.e.c(r34);
    L75:
        if (r23 != null) goto L77;
        r10.bindNull(14);
    L78:
        String r35 = r12.a;
        if (r35 != null) goto L81;
        r10.bindNull(15);
    L82:
        String r36 = r12.b;
        if (r36 != null) goto L85;
        r10.bindNull(16);
    L86:
        r10.bindLong(17, r12.c);
        String r37 = r12.d;
        if (r37 != null) goto L89;
        r10.bindNull(18);
    L90:
        String r38 = r12.e;
        if (r38 != null) goto L93;
        r10.bindNull(19);
    L94:
        String r39 = r12.f;
        if (r39 != null) goto L97;
        r10.bindNull(20);
    L98:
        Icons r40 = r12.g;
        if (r40 != null) goto L101;
        String r41 = null;
    L103:
        if (r41 != null) goto L105;
        r10.bindNull(21);
    L106:
        String r42 = r12.h;
        if (r42 != null) goto L109;
        r10.bindNull(22);
    L110:
        String r43 = r12.i;
        if (r43 != null) goto L113;
        r10.bindNull(23);
    L114:
        String r44 = r12.j;
        if (r44 != null) goto L117;
        r10.bindNull(24);
    L118:
        List<String> r45 = r12.k;
        if (r45 == null) goto L123;
        this.a.d.getClass();
        Intrinsics.checkNotNullParameter(r45, com.bytedance.android.ec.core.event.a.KEY_LIST);
        r13 = com.bytedance.ai.applet.base.gson.e.c(r45);
    L123:
        if (r13 != null) goto L125;
        r10.bindNull(25);
    L126:
        String r46 = r12.l;
        if (r46 != null) goto L129;
        r10.bindNull(26);
    L130:
        r10.bindLong(27, r12.m);
        String r47 = r12.n;
        if (r47 != null) goto L133;
        r10.bindNull(28);
    L134:
        String r48 = r12.o;
        if (r48 != null) goto L137;
        r10.bindNull(29);
    L138:
        r10.bindLong(30, r12.p);
        r10.bindLong(31, r12.q);
        r10.bindLong(32, r12.r);
        r10.bindLong(33, r12.s);
        r10.bindLong(34, r12.t);
        r10.bindLong(35, r12.u);
        String r49 = r12.v;
        if (r49 != null) goto L141;
        r10.bindNull(36);
    L142:
        Integer r50 = r12.w;
        if (r50 != null) goto L145;
        r10.bindNull(37);
    L146:
        String r51 = r12.C;
        if (r51 != null) goto L149;
        r10.bindNull(38);
    L150:
        r10.bindLong(39, r12.D);
        r10.bindLong(40, r12.E);
        r10.bindLong(41, r12.F);
        r10.bindLong(42, r12.G);
        r10.bindLong(43, r12.m);
        return;
    L149:
        r10.bindString(38, r51);
        goto L150
    L145:
        r10.bindLong(37, r50.intValue());
        goto L146
    L141:
        r10.bindString(36, r49);
        goto L142
    L137:
        r10.bindString(29, r48);
        goto L138
    L133:
        r10.bindString(28, r47);
        goto L134
    L129:
        r10.bindString(26, r46);
        goto L130
    L125:
        r10.bindString(25, r13);
        goto L126
    L117:
        r10.bindString(24, r44);
        goto L118
    L113:
        r10.bindString(23, r43);
        goto L114
    L109:
        r10.bindString(22, r42);
        goto L110
    L105:
        r10.bindString(21, r41);
        goto L106
    L101:
        this.a.d.getClass();
        Intrinsics.checkNotNullParameter(r40, "icons");
        r41 = com.bytedance.ai.applet.base.gson.e.c(r40);
        goto L103
    L97:
        r10.bindString(20, r39);
        goto L98
    L93:
        r10.bindString(19, r38);
        goto L94
    L89:
        r10.bindString(18, r37);
        goto L90
    L85:
        r10.bindString(16, r36);
        goto L86
    L81:
        r10.bindString(15, r35);
        goto L82
    L77:
        r10.bindString(14, r23);
        goto L78
    L69:
        r10.bindString(13, r32);
        goto L70
    L65:
        r10.bindString(12, r31);
        goto L66
    L61:
        r10.bindString(10, r30);
        goto L62
    L57:
        r30 = com.bytedance.ai.applet.base.gson.e.c(r29);
        goto L59
    L53:
        r10.bindString(9, r27);
        goto L54
    L49:
        r27 = com.bytedance.ai.applet.base.gson.e.c(r26);
        goto L51
    L45:
        r10.bindString(8, r24);
        goto L46
    L41:
        r24 = com.bytedance.ai.applet.base.gson.e.c(r22);
        goto L43
    L37:
        r10.bindString(7, r20);
        goto L38
    L33:
        r10.bindString(6, r19);
        goto L34
    L29:
        r10.bindString(5, r18);
        goto L30
    L25:
        r10.bindString(4, r17);
        goto L26
    L21:
        r10.bindString(3, r16);
        goto L22
    L17:
        this.a.d.getClass();
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r16 = com.bytedance.ai.applet.base.gson.e.c(r15);
        goto L19
    L13:
        r10.bindString(2, r14);
        goto L14
    L9:
        this.a.d.getClass();
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r14 = com.bytedance.ai.applet.base.gson.e.c(r1);
        goto L11
    L5:
        r10.bindString(1, r0);
        goto L6
    }
}
