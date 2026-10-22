package com.bytedance.ai.resource.core.db;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends AIPackageDao {
    public final RoomDatabase b;
    public final com.bytedance.ai.resource.core.db.n c;
    public final h5.h d;
    public final com.bytedance.ai.resource.core.db.q e;
    public final com.bytedance.ai.resource.core.db.t f;
    public final w g;
    public final x h;
    public final y i;
    public final z j;
    public final b0 k;
    public final com.bytedance.ai.resource.core.db.e l;
    public final com.bytedance.ai.resource.core.db.g m;

    public class a implements Callable<Unit> {
        public final /* synthetic */ Widget a;
        public final /* synthetic */ j b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.b.b.beginTransaction();
            this.b.f.handle(this.a);     // Catch: Throwable -> L6
            this.b.b.setTransactionSuccessful();     // Catch: Throwable -> L6
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
            this.b.b.endTransaction();
            return r0;
        L6:
            th = move-exception;
            this.b.b.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public a(j r1, Widget r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class b implements Callable<Unit> {
        public final /* synthetic */ Applet a;
        public final /* synthetic */ j b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            this.b.b.beginTransaction();
            this.b.g.handle(this.a);     // Catch: Throwable -> L6
            this.b.b.setTransactionSuccessful();     // Catch: Throwable -> L6
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
            this.b.b.endTransaction();
            return r0;
        L6:
            th = move-exception;
            this.b.b.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public b(j r1, Applet r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class c implements Callable<Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r0 = this.c.j.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            String r10 = this.b;
            if (r10 != null) goto L9;
            r0.bindNull(2);
        L10:
            this.c.b.beginTransaction();
            r0.executeUpdateDelete();     // Catch: Throwable -> L14
            this.c.b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.c.b.endTransaction();
            this.c.j.release(r0);
            return r11;
        L14:
            th = move-exception;
            this.c.b.endTransaction();
            this.c.j.release(r0);
            throw th;
        L9:
            r0.bindString(2, r10);
            goto L10
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public c(j r1, String r10, String r11) {
            this.c = r1;
            this.a = r10;
            this.b = r11;
        }
    }

    public class d implements Callable<Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r0 = this.c.k.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            String r10 = this.b;
            if (r10 != null) goto L9;
            r0.bindNull(2);
        L10:
            this.c.b.beginTransaction();
            r0.executeUpdateDelete();     // Catch: Throwable -> L14
            this.c.b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.c.b.endTransaction();
            this.c.k.release(r0);
            return r11;
        L14:
            th = move-exception;
            this.c.b.endTransaction();
            this.c.k.release(r0);
            throw th;
        L9:
            r0.bindString(2, r10);
            goto L10
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public d(j r1, String r10, String r11) {
            this.c = r1;
            this.a = r10;
            this.b = r11;
        }
    }

    public class e implements Callable<Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r0 = this.c.l.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            String r10 = this.b;
            if (r10 != null) goto L9;
            r0.bindNull(2);
        L10:
            this.c.b.beginTransaction();
            r0.executeUpdateDelete();     // Catch: Throwable -> L14
            this.c.b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.c.b.endTransaction();
            this.c.l.release(r0);
            return r11;
        L14:
            th = move-exception;
            this.c.b.endTransaction();
            this.c.l.release(r0);
            throw th;
        L9:
            r0.bindString(2, r10);
            goto L10
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public e(j r1, String r10, String r11) {
            this.c = r1;
            this.a = r10;
            this.b = r11;
        }
    }

    public class f implements Callable<Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ j c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Unit call2() throws Exception {
            SupportSQLiteStatement r0 = this.c.m.acquire();
            String r1 = this.a;
            if (r1 != null) goto L5;
            r0.bindNull(1);
        L6:
            String r10 = this.b;
            if (r10 != null) goto L9;
            r0.bindNull(2);
        L10:
            this.c.b.beginTransaction();
            r0.executeUpdateDelete();     // Catch: Throwable -> L14
            this.c.b.setTransactionSuccessful();     // Catch: Throwable -> L14
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L14
            this.c.b.endTransaction();
            this.c.m.release(r0);
            return r11;
        L14:
            th = move-exception;
            this.c.b.endTransaction();
            this.c.m.release(r0);
            throw th;
        L9:
            r0.bindString(2, r10);
            goto L10
        L5:
            r0.bindString(1, r1);
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() throws Exception {
            return call2();
        }

        public f(j r1, String r10, String r11) {
            this.c = r1;
            this.a = r10;
            this.b = r11;
        }
    }

    public class g implements Callable<List<Widget>> {
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
            g r42 = this;
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

        public g(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class h implements Callable<Widget> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ j b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Widget call() throws Exception {
            Cursor r10 = DBUtil.query(this.b.b, this.a, false, null);
            int r0 = CursorUtil.getColumnIndexOrThrow(r10, "widget_id");     // Catch: Throwable -> L110
            int r11 = CursorUtil.getColumnIndexOrThrow(r10, "entry");     // Catch: Throwable -> L110
            int r12 = CursorUtil.getColumnIndexOrThrow(r10, "input");     // Catch: Throwable -> L110
            int r13 = CursorUtil.getColumnIndexOrThrow(r10, "output");     // Catch: Throwable -> L110
            int r14 = CursorUtil.getColumnIndexOrThrow(r10, "border");     // Catch: Throwable -> L110
            int r15 = CursorUtil.getColumnIndexOrThrow(r10, "box_type");     // Catch: Throwable -> L110
            int r16 = CursorUtil.getColumnIndexOrThrow(r10, "title_type");     // Catch: Throwable -> L110
            int r17 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);     // Catch: Throwable -> L110
            int r18 = CursorUtil.getColumnIndexOrThrow(r10, "package_name");     // Catch: Throwable -> L110
            int r19 = CursorUtil.getColumnIndexOrThrow(r10, "version_code");     // Catch: Throwable -> L110
            int r110 = CursorUtil.getColumnIndexOrThrow(r10, "scm_version");     // Catch: Throwable -> L110
            int r111 = CursorUtil.getColumnIndexOrThrow(r10, "version_name");     // Catch: Throwable -> L110
            int r20 = CursorUtil.getColumnIndexOrThrow(r10, "description");     // Catch: Throwable -> L110
            int r21 = CursorUtil.getColumnIndexOrThrow(r10, "icons");     // Catch: Throwable -> L110
            int r1 = CursorUtil.getColumnIndexOrThrow(r10, "manifest_version");     // Catch: Throwable -> L108
            int r22 = CursorUtil.getColumnIndexOrThrow(r10, "prop");     // Catch: Throwable -> L108
            int r23 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);     // Catch: Throwable -> L108
            int r24 = CursorUtil.getColumnIndexOrThrow(r10, "keywords");     // Catch: Throwable -> L108
            int r25 = CursorUtil.getColumnIndexOrThrow(r10, "app_group");     // Catch: Throwable -> L108
            int r26 = CursorUtil.getColumnIndexOrThrow(r10, "id");     // Catch: Throwable -> L108
            int r27 = CursorUtil.getColumnIndexOrThrow(r10, "digest");     // Catch: Throwable -> L108
            int r28 = CursorUtil.getColumnIndexOrThrow(r10, "render_type");     // Catch: Throwable -> L108
            int r29 = CursorUtil.getColumnIndexOrThrow(r10, "size");     // Catch: Throwable -> L108
            int r30 = CursorUtil.getColumnIndexOrThrow(r10, "ft");     // Catch: Throwable -> L108
            int r31 = CursorUtil.getColumnIndexOrThrow(r10, "it");     // Catch: Throwable -> L108
            int r32 = CursorUtil.getColumnIndexOrThrow(r10, "ut");     // Catch: Throwable -> L108
            int r33 = CursorUtil.getColumnIndexOrThrow(r10, "update_time");     // Catch: Throwable -> L108
            int r34 = CursorUtil.getColumnIndexOrThrow(r10, "create_time");     // Catch: Throwable -> L108
            int r35 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_STATUS);     // Catch: Throwable -> L108
            int r36 = CursorUtil.getColumnIndexOrThrow(r10, "ready_for_deleting");     // Catch: Throwable -> L108
            int r37 = CursorUtil.getColumnIndexOrThrow(r10, "runtime_version");     // Catch: Throwable -> L108
            int r38 = CursorUtil.getColumnIndexOrThrow(r10, "has_key_store");     // Catch: Throwable -> L108
            int r39 = CursorUtil.getColumnIndexOrThrow(r10, "sign_verify_switch");     // Catch: Throwable -> L108
            int r40 = CursorUtil.getColumnIndexOrThrow(r10, "app_type");     // Catch: Throwable -> L108
            int r41 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE);     // Catch: Throwable -> L108
            if (r10.moveToFirst() == true) goto L7;
            h r42 = this;
            Widget r43 = null;
        L106:
            r10.close();
            r42.a.release();
            return r43;
        L7:
            if (r10.isNull(r0) == false) goto L9;
            String r50 = null;
        L11:
            if (r10.isNull(r11) == false) goto L13;
            String r51 = null;
        L15:
            if (r10.isNull(r12) == false) goto L17;
            String r52 = null;
        L19:
            if (r10.isNull(r13) == false) goto L21;
            String r53 = null;
        L23:
            if (r10.getInt(r14) == 0) goto L25;
            boolean r54 = true;
        L26:
            int r55 = r10.getInt(r15);     // Catch: Throwable -> L108
            if (r10.isNull(r16) == false) goto L29;
            Integer r56 = null;
        L31:
            if (r10.isNull(r17) == false) goto L33;
            String r310 = null;
        L35:
            if (r10.isNull(r18) == false) goto L37;
            String r311 = null;
        L38:
            long r312 = r10.getLong(r19);     // Catch: Throwable -> L108
            if (r10.isNull(r110) == false) goto L41;
            String r44 = null;
        L43:
            if (r10.isNull(r111) == false) goto L45;
            String r45 = null;
        L47:
            if (r10.isNull(r20) == false) goto L49;
            String r46 = null;
        L51:
            if (r10.isNull(r21) == false) goto L53;
            String r47 = null;
        L54:
            if (r47 != null) goto L56;
            Icons r48 = null;
            r42 = this;
        L59:
            if (r10.isNull(r1) == false) goto L61;
            String r49 = null;
        L63:
            if (r10.isNull(r17) == false) goto L65;
            String r410 = null;
        L67:
            if (r10.isNull(r18) == false) goto L69;
            String r411 = null;
        L71:
            if (r10.isNull(r19) == false) goto L73;
            String r57 = null;
        L74:
            if (r57 != null) goto L76;
            List r412 = null;
        L78:
            if (r10.isNull(r20) == false) goto L80;
            String r413 = null;
        L82:
            if (r10.isNull(r32) == false) goto L84;
            String r58 = null;
        L85:
            Widget r59 = new Widget(r310, r311, r312, r44, r45, r46, r48, r49, r410, r411, r412, r413, r50, r51, r52, r53, r54, r55, r56, r58);     // Catch: Throwable -> L103
            r59.m = r10.getLong(r26);     // Catch: Throwable -> L103
            if (r10.isNull(r27) == false) goto L88;
            String r60 = null;
        L89:
            r59.i(r60);     // Catch: Throwable -> L103
            if (r10.isNull(r28) == false) goto L92;
            String r61 = null;
        L93:
            r59.k(r61);     // Catch: Throwable -> L103
            r59.p = r10.getLong(r29);     // Catch: Throwable -> L103
            r59.q = r10.getLong(r30);     // Catch: Throwable -> L103
            r59.r = r10.getLong(r31);     // Catch: Throwable -> L103
            r59.s = r10.getLong(r32);     // Catch: Throwable -> L103
            r59.t = r10.getLong(r33);     // Catch: Throwable -> L103
            r59.u = r10.getLong(r34);     // Catch: Throwable -> L103
            if (r10.isNull(r35) == false) goto L96;
            String r62 = null;
        L97:
            r59.j(r62);     // Catch: Throwable -> L103
            if (r10.isNull(r36) == false) goto L100;
            Integer r63 = null;
        L101:
            r59.w = r63;     // Catch: Throwable -> L103
            r59.D = r10.getInt(r38);     // Catch: Throwable -> L103
            r59.E = r10.getInt(r39);     // Catch: Throwable -> L103
            r59.F = r10.getInt(r40);     // Catch: Throwable -> L103
            r59.G = r10.getInt(r41);     // Catch: Throwable -> L103
            r43 = r59;
        L103:
            th = th;
        L112:
            r10.close();
            r42.a.release();
            throw th;
        L100:
            r63 = Integer.valueOf(r10.getInt(r36));     // Catch: Throwable -> L103
            goto L101
        L96:
            r62 = r10.getString(r35);     // Catch: Throwable -> L103
            goto L97
        L92:
            r61 = r10.getString(r28);     // Catch: Throwable -> L103
            goto L93
        L88:
            r60 = r10.getString(r27);     // Catch: Throwable -> L103
            goto L89
        L84:
            r58 = r10.getString(r37);     // Catch: Throwable -> L103
            goto L85
        L80:
            r413 = r10.getString(r25);     // Catch: Throwable -> L103
            goto L82
        L76:
            r42.b.d.getClass();     // Catch: Throwable -> L103
            r412 = h5.h.b(r57);     // Catch: Throwable -> L103
            goto L78
        L73:
            r57 = r10.getString(r24);     // Catch: Throwable -> L103
            goto L74
        L69:
            r411 = r10.getString(r23);     // Catch: Throwable -> L103
            goto L71
        L65:
            r410 = r10.getString(r22);     // Catch: Throwable -> L103
            goto L67
        L61:
            r49 = r10.getString(r1);     // Catch: Throwable -> L103
            goto L63
        L56:
            r42 = this;
            r42.b.d.getClass();     // Catch: Throwable -> L103
            r48 = h5.h.a(r47);     // Catch: Throwable -> L103
            goto L59
        L53:
            r47 = r10.getString(r21);     // Catch: Throwable -> L108
            goto L54
        L49:
            r46 = r10.getString(r20);     // Catch: Throwable -> L108
            goto L51
        L45:
            r45 = r10.getString(r111);     // Catch: Throwable -> L108
            goto L47
        L41:
            r44 = r10.getString(r110);     // Catch: Throwable -> L108
            goto L43
        L37:
            r311 = r10.getString(r18);     // Catch: Throwable -> L108
            goto L38
        L33:
            r310 = r10.getString(r17);     // Catch: Throwable -> L108
            goto L35
        L29:
            r56 = Integer.valueOf(r10.getInt(r16));     // Catch: Throwable -> L108
            goto L31
        L25:
            r54 = false;
            goto L26
        L21:
            r53 = r10.getString(r13);     // Catch: Throwable -> L108
            goto L23
        L17:
            r52 = r10.getString(r12);     // Catch: Throwable -> L108
            goto L19
        L13:
            r51 = r10.getString(r11);     // Catch: Throwable -> L108
            goto L15
        L9:
            r50 = r10.getString(r0);     // Catch: Throwable -> L108
        L108:
            th = th;
            r42 = this;
        L110:
            th = th;
            r42 = this;
            goto L112
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Widget call() throws Exception {
            return call();
        }

        public h(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class i implements Callable<List<Widget>> {
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
            i r42 = this;
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

        public i(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.resource.core.db.j$j, reason: collision with other inner class name */
    public class CallableC0048j implements Callable<List<Widget>> {
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
            CallableC0048j r42 = this;
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

        public CallableC0048j(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class k implements Callable<List<Widget>> {
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
            k r42 = this;
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

        public k(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class l implements Callable<List<Widget>> {
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
            l r42 = this;
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

        public l(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class m implements Callable<List<Widget>> {
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
            m r42 = this;
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

        public m(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class n implements Callable<List<Widget>> {
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
            n r42 = this;
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

        public n(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class o implements Callable<List<Applet>> {
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

        public o(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class p implements Callable<Applet> {
        public final /* synthetic */ RoomSQLiteQuery a;
        public final /* synthetic */ j b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Applet call() throws Exception {
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
            int r21 = CursorUtil.getColumnIndexOrThrow(r10, "settings");     // Catch: Throwable -> L142
            int r22 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);     // Catch: Throwable -> L142
            int r23 = CursorUtil.getColumnIndexOrThrow(r10, "package_name");     // Catch: Throwable -> L142
            int r112 = CursorUtil.getColumnIndexOrThrow(r10, "version_code");     // Catch: Throwable -> L142
            int r113 = CursorUtil.getColumnIndexOrThrow(r10, "scm_version");     // Catch: Throwable -> L142
            int r114 = CursorUtil.getColumnIndexOrThrow(r10, "version_name");     // Catch: Throwable -> L142
            int r115 = CursorUtil.getColumnIndexOrThrow(r10, "description");     // Catch: Throwable -> L142
            int r116 = CursorUtil.getColumnIndexOrThrow(r10, "icons");     // Catch: Throwable -> L142
            int r117 = CursorUtil.getColumnIndexOrThrow(r10, "manifest_version");     // Catch: Throwable -> L142
            int r118 = CursorUtil.getColumnIndexOrThrow(r10, "prop");     // Catch: Throwable -> L142
            int r119 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);     // Catch: Throwable -> L142
            int r120 = CursorUtil.getColumnIndexOrThrow(r10, "keywords");     // Catch: Throwable -> L142
            int r121 = CursorUtil.getColumnIndexOrThrow(r10, "app_group");     // Catch: Throwable -> L142
            int r122 = CursorUtil.getColumnIndexOrThrow(r10, "id");     // Catch: Throwable -> L142
            int r123 = CursorUtil.getColumnIndexOrThrow(r10, "digest");     // Catch: Throwable -> L142
            int r124 = CursorUtil.getColumnIndexOrThrow(r10, "render_type");     // Catch: Throwable -> L142
            int r125 = CursorUtil.getColumnIndexOrThrow(r10, "size");     // Catch: Throwable -> L142
            int r126 = CursorUtil.getColumnIndexOrThrow(r10, "ft");     // Catch: Throwable -> L142
            int r127 = CursorUtil.getColumnIndexOrThrow(r10, "it");     // Catch: Throwable -> L142
            int r128 = CursorUtil.getColumnIndexOrThrow(r10, "ut");     // Catch: Throwable -> L142
            int r129 = CursorUtil.getColumnIndexOrThrow(r10, "update_time");     // Catch: Throwable -> L142
            int r130 = CursorUtil.getColumnIndexOrThrow(r10, "create_time");     // Catch: Throwable -> L142
            int r131 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_STATUS);     // Catch: Throwable -> L142
            int r132 = CursorUtil.getColumnIndexOrThrow(r10, "ready_for_deleting");     // Catch: Throwable -> L142
            int r133 = CursorUtil.getColumnIndexOrThrow(r10, "runtime_version");     // Catch: Throwable -> L142
            int r134 = CursorUtil.getColumnIndexOrThrow(r10, "has_key_store");     // Catch: Throwable -> L142
            int r135 = CursorUtil.getColumnIndexOrThrow(r10, "sign_verify_switch");     // Catch: Throwable -> L142
            int r136 = CursorUtil.getColumnIndexOrThrow(r10, "app_type");     // Catch: Throwable -> L142
            int r137 = CursorUtil.getColumnIndexOrThrow(r10, com.bytedance.android.ec.core.event.a.KEY_SOURCE_TYPE);     // Catch: Throwable -> L142
            if (r10.moveToFirst() == true) goto L6;
            Applet r24 = null;
        L140:
            r10.close();
            this.a.release();
            return r24;
        L6:
            if (r10.isNull(r0) == false) goto L8;
            String r58 = null;
        L10:
            if (r10.isNull(r11) == false) goto L12;
            String r1 = null;
        L13:
            if (r1 != null) goto L15;
            List r59 = null;
        L17:
            if (r10.isNull(r12) == false) goto L19;
            String r25 = null;
        L20:
            if (r25 != null) goto L22;
            List r60 = null;
        L24:
            if (r10.isNull(r13) == false) goto L26;
            String r61 = null;
        L28:
            if (r10.isNull(r14) == false) goto L30;
            String r62 = null;
        L32:
            if (r10.isNull(r15) == false) goto L34;
            String r63 = null;
        L36:
            if (r10.isNull(r22) == false) goto L38;
            String r45 = null;
        L40:
            if (r10.isNull(r23) == false) goto L42;
            String r46 = null;
        L43:
            long r47 = r10.getLong(r112);     // Catch: Throwable -> L142
            if (r10.isNull(r113) == false) goto L46;
            String r49 = null;
        L48:
            if (r10.isNull(r114) == false) goto L50;
            String r50 = null;
        L52:
            if (r10.isNull(r115) == false) goto L54;
            String r51 = null;
        L56:
            if (r10.isNull(r116) == false) goto L58;
            String r26 = null;
        L59:
            if (r26 != null) goto L61;
            Icons r52 = null;
        L63:
            if (r10.isNull(r24) == false) goto L65;
            String r53 = null;
        L67:
            if (r10.isNull(r25) == false) goto L69;
            String r54 = null;
        L71:
            if (r10.isNull(r26) == false) goto L73;
            String r55 = null;
        L75:
            if (r10.isNull(r27) == false) goto L77;
            String r27 = null;
        L78:
            if (r27 != null) goto L80;
            List r56 = null;
        L82:
            if (r10.isNull(r28) == false) goto L84;
            String r57 = null;
        L86:
            if (r10.isNull(r40) == false) goto L88;
            String r64 = null;
        L89:
            Applet r28 = new Applet(r45, r46, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64);     // Catch: Throwable -> L142
            if (r10.isNull(r16) == false) goto L92;
            String r29 = null;
        L93:
            r28.r(r29);     // Catch: Throwable -> L142
            if (r10.isNull(r17) == false) goto L96;
            String r30 = null;
        L97:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r28.U = h5.h.c(r30);     // Catch: Throwable -> L142
            if (r10.isNull(r18) == false) goto L100;
            String r31 = null;
        L101:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r28.V = h5.h.g(r31);     // Catch: Throwable -> L142
            if (r10.isNull(r19) == false) goto L104;
            String r32 = null;
        L105:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r28.W = h5.h.e(r32);     // Catch: Throwable -> L142
            if (r10.getInt(r110) == 0) goto L108;
            boolean r33 = true;
        L109:
            r28.X = r33;     // Catch: Throwable -> L142
            if (r10.isNull(r111) == false) goto L112;
            String r34 = null;
        L113:
            r28.Y = r34;     // Catch: Throwable -> L142
            if (r10.isNull(r20) == false) goto L116;
            String r35 = null;
        L117:
            r28.Z = r35;     // Catch: Throwable -> L142
            if (r10.isNull(r21) == false) goto L120;
            String r36 = null;
        L121:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r28.k0 = h5.h.h(r36);     // Catch: Throwable -> L142
            r28.m = r10.getLong(r122);     // Catch: Throwable -> L142
            if (r10.isNull(r123) == false) goto L124;
            String r37 = null;
        L125:
            r28.i(r37);     // Catch: Throwable -> L142
            if (r10.isNull(r124) == false) goto L128;
            String r38 = null;
        L129:
            r28.k(r38);     // Catch: Throwable -> L142
            r28.p = r10.getLong(r125);     // Catch: Throwable -> L142
            r28.q = r10.getLong(r126);     // Catch: Throwable -> L142
            r28.r = r10.getLong(r127);     // Catch: Throwable -> L142
            r28.s = r10.getLong(r128);     // Catch: Throwable -> L142
            r28.t = r10.getLong(r129);     // Catch: Throwable -> L142
            r28.u = r10.getLong(r130);     // Catch: Throwable -> L142
            if (r10.isNull(r131) == false) goto L132;
            String r39 = null;
        L133:
            r28.j(r39);     // Catch: Throwable -> L142
            if (r10.isNull(r132) == false) goto L136;
            Integer r40 = null;
        L137:
            r28.w = r40;     // Catch: Throwable -> L142
            r28.D = r10.getInt(r134);     // Catch: Throwable -> L142
            r28.E = r10.getInt(r135);     // Catch: Throwable -> L142
            r28.F = r10.getInt(r136);     // Catch: Throwable -> L142
            r28.G = r10.getInt(r137);     // Catch: Throwable -> L142
            r24 = r28;
            goto L140
        L136:
            r40 = Integer.valueOf(r10.getInt(r132));     // Catch: Throwable -> L142
            goto L137
        L132:
            r39 = r10.getString(r131);     // Catch: Throwable -> L142
            goto L133
        L128:
            r38 = r10.getString(r124);     // Catch: Throwable -> L142
            goto L129
        L124:
            r37 = r10.getString(r123);     // Catch: Throwable -> L142
            goto L125
        L120:
            r36 = r10.getString(r21);     // Catch: Throwable -> L142
            goto L121
        L116:
            r35 = r10.getString(r20);     // Catch: Throwable -> L142
            goto L117
        L112:
            r34 = r10.getString(r111);     // Catch: Throwable -> L142
            goto L113
        L108:
            r33 = false;
            goto L109
        L104:
            r32 = r10.getString(r19);     // Catch: Throwable -> L142
            goto L105
        L100:
            r31 = r10.getString(r18);     // Catch: Throwable -> L142
            goto L101
        L96:
            r30 = r10.getString(r17);     // Catch: Throwable -> L142
            goto L97
        L92:
            r29 = r10.getString(r16);     // Catch: Throwable -> L142
            goto L93
        L88:
            r64 = r10.getString(r133);     // Catch: Throwable -> L142
            goto L89
        L84:
            r57 = r10.getString(r121);     // Catch: Throwable -> L142
            goto L86
        L80:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r56 = h5.h.b(r27);     // Catch: Throwable -> L142
            goto L82
        L77:
            r27 = r10.getString(r120);     // Catch: Throwable -> L142
            goto L78
        L73:
            r55 = r10.getString(r119);     // Catch: Throwable -> L142
            goto L75
        L69:
            r54 = r10.getString(r118);     // Catch: Throwable -> L142
            goto L71
        L65:
            r53 = r10.getString(r117);     // Catch: Throwable -> L142
            goto L67
        L61:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r52 = h5.h.a(r26);     // Catch: Throwable -> L142
            goto L63
        L58:
            r26 = r10.getString(r116);     // Catch: Throwable -> L142
            goto L59
        L54:
            r51 = r10.getString(r115);     // Catch: Throwable -> L142
            goto L56
        L50:
            r50 = r10.getString(r114);     // Catch: Throwable -> L142
            goto L52
        L46:
            r49 = r10.getString(r113);     // Catch: Throwable -> L142
            goto L48
        L42:
            r46 = r10.getString(r23);     // Catch: Throwable -> L142
            goto L43
        L38:
            r45 = r10.getString(r22);     // Catch: Throwable -> L142
            goto L40
        L34:
            r63 = r10.getString(r15);     // Catch: Throwable -> L142
            goto L36
        L30:
            r62 = r10.getString(r14);     // Catch: Throwable -> L142
            goto L32
        L26:
            r61 = r10.getString(r13);     // Catch: Throwable -> L142
            goto L28
        L22:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r60 = h5.h.f(r25);     // Catch: Throwable -> L142
            goto L24
        L19:
            r25 = r10.getString(r12);     // Catch: Throwable -> L142
            goto L20
        L15:
            this.b.d.getClass();     // Catch: Throwable -> L142
            r59 = h5.h.d(r1);     // Catch: Throwable -> L142
            goto L17
        L12:
            r1 = r10.getString(r11);     // Catch: Throwable -> L142
            goto L13
        L8:
            r58 = r10.getString(r0);     // Catch: Throwable -> L142
        L142:
            th = move-exception;
            r10.close();
            this.a.release();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Applet call() throws Exception {
            return call();
        }

        public p(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class q implements Callable<List<Applet>> {
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

        public q(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class r implements Callable<List<Applet>> {
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

        public r(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class s implements Callable<List<Applet>> {
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

    public class t implements Callable<List<Applet>> {
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

        public t(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class u implements Callable<List<Applet>> {
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

        public u(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public class v implements Callable<List<Applet>> {
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

        public v(j r1, RoomSQLiteQuery r10) {
            this.b = r1;
            this.a = r10;
        }
    }

    public j(AIPackageDatabase r10) {
        this.d = new h5.h();
        this.b = r10;
        this.c = new com.bytedance.ai.resource.core.db.n(this, r10);
        this.e = new com.bytedance.ai.resource.core.db.q(this, r10);
        this.f = new com.bytedance.ai.resource.core.db.t(r10);
        this.g = new w(r10);
        this.h = new x(this, r10);
        this.i = new y(this, r10);
        this.j = new z(r10);
        new a0(r10);
        this.k = new b0(r10);
        this.l = new com.bytedance.ai.resource.core.db.e(r10);
        new com.bytedance.ai.resource.core.db.f(r10);
        this.m = new com.bytedance.ai.resource.core.db.g(r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object A(Continuation<? super List<Applet>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'installed' AND ready_for_deleting = 0", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new u(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object D(Continuation<? super List<? extends Widget>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE status = 'installed' AND ready_for_deleting = 0", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new m(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object L(Continuation<? super List<? extends Widget>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE ready_for_deleting = 1", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new n(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object o(Continuation<? super List<Applet>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new r(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object p(Continuation<? super List<? extends Widget>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new CallableC0048j(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object q(Continuation r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'installed' AND bot_id = ?", 1);
        r0.bindNull(1);
        CancellationSignal r1 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r1, new com.bytedance.ai.resource.core.db.v(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object u(Continuation<? super List<Applet>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE ready_for_deleting = 1", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new v(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object w(Continuation<? super List<Applet>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE status = 'inactive'", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new s(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object y(Continuation<? super List<? extends Widget>> r10) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE status = 'inactive'", 0);
        CancellationSignal r11 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r11, new k(this, r0), r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object B(String r10, Continuation<? super List<Applet>> r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0", 1);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r12, new q(this, r0), r11);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object E(String r10, Continuation<? super List<? extends Widget>> r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0", 1);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r12, new i(this, r0), r11);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object N(Applet[] r10, ContinuationImpl r11) {
        return CoroutinesRoom.execute(this.b, true, new com.bytedance.ai.resource.core.db.o(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object O(Widget[] r10, ContinuationImpl r11) {
        return CoroutinesRoom.execute(this.b, true, new com.bytedance.ai.resource.core.db.m(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object b(Applet r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.b, true, new b(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object d(List r10, ContinuationImpl r11) {
        return CoroutinesRoom.execute(this.b, true, new com.bytedance.ai.resource.core.db.l(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object e(Widget r10, Continuation<? super Unit> r11) {
        return CoroutinesRoom.execute(this.b, true, new a(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object g(List r10, ContinuationImpl r11) {
        return CoroutinesRoom.execute(this.b, true, new com.bytedance.ai.resource.core.db.k(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object h(Applet r10, ContinuationImpl r11) {
        return CoroutinesRoom.execute(this.b, true, new com.bytedance.ai.resource.core.db.i(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object i(final Applet r10, Continuation<? super Unit> r11) {
        return RoomDatabaseKt.withTransaction(this.b, new com.bytedance.ai.resource.core.db.c(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object k(final Widget r10, Continuation<? super Unit> r11) {
        return RoomDatabaseKt.withTransaction(this.b, new com.bytedance.ai.resource.core.db.a(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object l(Widget r10, ContinuationImpl r11) {
        return CoroutinesRoom.execute(this.b, true, new com.bytedance.ai.resource.core.db.h(this, r10), r11);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object v(String r10, Continuation<? super List<Applet>> r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'inactive' AND ready_for_deleting = 0", 1);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r12, new t(this, r0), r11);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object x(String r10, Continuation<? super List<? extends Widget>> r11) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'inactive' AND ready_for_deleting = 0", 1);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        CancellationSignal r12 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r12, new l(this, r0), r11);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    public static /* synthetic */ Object P(j r0, Widget r1, Continuation r10) {
        return super.k(r1, r10);
    }

    public static /* synthetic */ Object Q(j r0, Applet r1, Continuation r10) {
        return super.i(r1, r10);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object C(String r10, long r11, ContinuationImpl r12) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0 AND version_code = ?", 2);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r11);
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r13, new com.bytedance.ai.resource.core.db.r(this, r0), r12);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object K(String r10, String r11, Continuation<? super List<? extends Widget>> r12) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? ORDER BY ut DESC", 2);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r11 != null) goto L8;
        r0.bindNull(2);
    L9:
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r13, new g(this, r0), r12);
    L8:
        r0.bindString(2, r11);
        goto L9
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object c(String r10, String r11, Continuation<? super Unit> r12) {
        return CoroutinesRoom.execute(this.b, true, new e(this, r10, r11), r12);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object f(String r10, String r11, Continuation<? super Unit> r12) {
        return CoroutinesRoom.execute(this.b, true, new c(this, r10, r11), r12);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object m(String r10, String r11, Continuation<? super Unit> r12) {
        return CoroutinesRoom.execute(this.b, true, new f(this, r10, r11), r12);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object n(String r10, String r11, Continuation<? super Unit> r12) {
        return CoroutinesRoom.execute(this.b, true, new d(this, r10, r11), r12);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object t(String r10, String r11, Continuation<? super List<Applet>> r12) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? ORDER BY ut DESC", 2);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r11 != null) goto L8;
        r0.bindNull(2);
    L9:
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r13, new o(this, r0), r12);
    L8:
        r0.bindString(2, r11);
        goto L9
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object z(String r10, long r11, ContinuationImpl r12) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE package_name = ? AND status = 'installed' AND ready_for_deleting = 0 AND version_code = ?", 2);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r11);
        CancellationSignal r13 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r13, new com.bytedance.ai.resource.core.db.u(this, r0), r12);
    L5:
        r0.bindString(1, r10);
        goto L6
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object G(final String r10, final String r11, final long r12, Continuation<? super Applet> r13) {
        return RoomDatabaseKt.withTransaction(this.b, new com.bytedance.ai.resource.core.db.b(this, r10, r11, r12), r13);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object H(final String r10, final String r11, final long r12, Continuation<? super Widget> r13) {
        return RoomDatabaseKt.withTransaction(this.b, new com.bytedance.ai.resource.core.db.d(this, r10, r11, r12), r13);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object J(String r10, String r11, String r12, ContinuationImpl r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? AND status = ? ORDER BY ut DESC", 3);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r11 != null) goto L9;
        r0.bindNull(2);
    L10:
        if (r12 != null) goto L12;
        r0.bindNull(3);
    L13:
        CancellationSignal r14 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r14, new com.bytedance.ai.resource.core.db.p(this, r0), r13);
    L12:
        r0.bindString(3, r12);
        goto L13
    L9:
        r0.bindString(2, r11);
        goto L10
    L5:
        r0.bindString(1, r10);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object s(String r10, String r11, String r12, ContinuationImpl r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? AND status = ? ORDER BY ut DESC", 3);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r11 != null) goto L9;
        r0.bindNull(2);
    L10:
        if (r12 != null) goto L12;
        r0.bindNull(3);
    L13:
        CancellationSignal r14 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r14, new com.bytedance.ai.resource.core.db.s(this, r0), r13);
    L12:
        r0.bindString(3, r12);
        goto L13
    L9:
        r0.bindString(2, r11);
        goto L10
    L5:
        r0.bindString(1, r10);
        goto L7
    }

    public static /* synthetic */ Object R(j r0, String r1, String r10, long r11, Continuation r12) {
        return super.H(r1, r10, r11, r12);
    }

    public static /* synthetic */ Object S(j r0, String r1, String r10, long r11, Continuation r12) {
        return super.G(r1, r10, r11, r12);
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object I(String r10, String r11, String r12, long r13, Continuation<? super Widget> r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_widget_info WHERE widget_id = ? AND package_name = ? AND status = ? AND version_code = ?", 4);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r11 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r12 != null) goto L13;
        r0.bindNull(3);
    L14:
        r0.bindLong(4, r13);
        CancellationSignal r15 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r15, new h(this, r0), r14);
    L13:
        r0.bindString(3, r12);
        goto L14
    L9:
        r0.bindString(2, r11);
        goto L11
    L5:
        r0.bindString(1, r10);
        goto L7
    }

    @Override // com.bytedance.ai.resource.core.db.AIPackageDao
    public final Object r(String r10, String r11, String r12, long r13, Continuation<? super Applet> r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ai_applet_info WHERE applet_id = ? AND package_name = ? AND status = ? AND version_code = ?", 4);
        if (r10 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r11 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r12 != null) goto L13;
        r0.bindNull(3);
    L14:
        r0.bindLong(4, r13);
        CancellationSignal r15 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.b, false, r15, new p(this, r0), r14);
    L13:
        r0.bindString(3, r12);
        goto L14
    L9:
        r0.bindString(2, r11);
        goto L11
    L5:
        r0.bindString(1, r10);
        goto L7
    }
}
