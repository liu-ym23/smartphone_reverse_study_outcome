package v0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.applog.c;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.bdinstall.Api;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import l1.e;
import l1.g;
import o1.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f13157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f13158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f13159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f13160d;

    static class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f13161c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l1.b f13162g;

        a(c r10, l1.b r11) {
            this.f13161c = r10;
            this.f13162g = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13161c.P().t(b.a(), "Start to do migrate stay duration data task...", new Object[0]);
            SQLiteDatabase r10 = new v0.a(this.f13161c.w(), "ss_app_log.db").getWritableDatabase();
            int r11 = 2;
            HashMap r12 = new HashMap(2);
            Cursor r13 = null;
            r10.beginTransaction();     // Catch: Throwable -> L48
            Cursor r14 = r10.rawQuery("select p.name, p.duration, s.value, s.timestamp from page p left join session as s on p.session_id  = s._id where s.value is not null and s.timestamp is not null", null);     // Catch: Throwable -> L48
        L78:
        L45:
            th = th;
            Cursor r17 = r14;
        L47:
            r13 = r17;
        L88:
            this.f13161c.P().u(b.a(), "Cannot migrate old applog sd data", th, new Object[0]);     // Catch: Throwable -> L58
            this.f13161c.R().h(MonitorKey.migrate_old, MonitorState.f_migrate_old_sd_failed);     // Catch: Throwable -> L58
            if (r10.inTransaction() == false) goto L54;
            r10.endTransaction();
        L54:
            if (r13 == null) goto L86;
            r13.close();     // Catch: Throwable -> L66
        L74:
        L58:
            th = move-exception;
            if (r10.inTransaction() == false) goto L62;
            r10.endTransaction();
        L62:
            if (r13 != null) goto L84;
        L72:
            r10.close();     // Catch: Throwable -> L69
            throw th;
        L99:
            throw th;
        L84:
            r13.close();     // Catch: Throwable -> L68
            goto L72
        L5:
            if (r14.moveToNext() == false) goto L23;
            String r15 = r14.getString(0);     // Catch: Throwable -> L45
            long r16 = r14.getLong(1);     // Catch: Throwable -> L45
            String r18 = r14.getString(r11);     // Catch: Throwable -> L45
            long r19 = r14.getLong(3);     // Catch: Throwable -> L45
            JSONObject r110 = (JSONObject) r12.get(r18);     // Catch: Throwable -> L45
            if (r110 == null) goto L91;
        L12:
            JSONObject r20 = r110;
            r17 = r14;
            r20.put("duration", r20.optLong("duration", 0) + r16);     // Catch: Throwable -> L43
            r20.put("datetime", d.b().format(new Date(r19)));     // Catch: Throwable -> L43
            r20.put("session_id", r18);     // Catch: Throwable -> L43
            r20.put("local_time_ms", r19);     // Catch: Throwable -> L43
            if (TextUtils.isEmpty(this.f13161c.m()) == true) goto L17;
            r20.put("ab_sdk_version", this.f13161c.m());     // Catch: Throwable -> L43
        L17:
            if (TextUtils.isEmpty(this.f13161c.W()) == true) goto L19;
            r20.put(Api.KEY_USER_UNIQUE_ID, this.f13161c.W());     // Catch: Throwable -> L43
        L19:
            r20.put("tea_event_index", 0);     // Catch: Throwable -> L43
            JSONArray r21 = r20.optJSONArray("activites");     // Catch: Throwable -> L43
            if (r21 != null) goto L22;
            r21 = new JSONArray();     // Catch: Throwable -> L43
        L22:
            JSONArray r22 = new JSONArray();     // Catch: Throwable -> L43
            r22.put(0, r15);     // Catch: Throwable -> L43
            r22.put(1, r16);     // Catch: Throwable -> L43
            r21.put(r22);     // Catch: Throwable -> L43
            r20.put("activites", r21);     // Catch: Throwable -> L43
            r12.put(r18, r20);     // Catch: Throwable -> L43
            r14 = r17;
            r11 = 2;
        L43:
            th = th;
            goto L47
        L91:
            r110 = new JSONObject();     // Catch: Throwable -> L10
        L10:
            th = th;
            r13 = r14;
            goto L88
        L23:
            Cursor r111 = r14;
            this.f13161c.P().t(b.a(), "Total {} terminate found.", new Object[]{Integer.valueOf(r12.size())});     // Catch: Throwable -> L43
            if (r12.isEmpty() == false) goto L32;
            this.f13161c.P().t(b.a(), "No terminate found.", new Object[0]);     // Catch: Throwable -> L43
            r10.setTransactionSuccessful();     // Catch: Throwable -> L43
            if (r10.inTransaction() == false) goto L80;
            r10.endTransaction();
        L80:
            r111.close();     // Catch: Throwable -> L70
        L82:
            r10.close();     // Catch: Throwable -> L71
            return;
        L97:
            return;
        L32:
            JSONArray r23 = new JSONArray();     // Catch: Throwable -> L43
            Iterator r24 = r12.values().iterator();     // Catch: Throwable -> L43
        L34:
            if (r24.hasNext() == false) goto L36;
            r23.put((JSONObject) r24.next());     // Catch: Throwable -> L43
            this.f13161c.R().h(MonitorKey.terminate, MonitorState.init);     // Catch: Throwable -> L43
            goto L34
        L36:
            this.f13162g.k(g.H(this.f13161c.getAppId(), this.f13161c.I(), r23, 11), true, null, true, null);     // Catch: Throwable -> L43
            this.f13161c.P().t(b.a(), "Pack saved.", new Object[0]);     // Catch: Throwable -> L43
            int r25 = r10.delete("page", null, null);     // Catch: Throwable -> L43
            this.f13161c.P().t(b.a(), "Old {} pages deleted.", new Object[]{Integer.valueOf(r25)});     // Catch: Throwable -> L43
            r10.setTransactionSuccessful();     // Catch: Throwable -> L43
            if (r10.inTransaction() == false) goto L40;
            r10.endTransaction();
        L40:
            r111.close();     // Catch: Throwable -> L66
        L48:
            th = th;
        L86:
            r10.close();     // Catch: Throwable -> L67
            return;
        }
    }

    /* JADX INFO: renamed from: v0.b$b, reason: collision with other inner class name */
    static class RunnableC0302b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f13163c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ l1.b f13164g;

        RunnableC0302b(c r10, l1.b r11) {
            this.f13163c = r10;
            this.f13164g = r11;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [l1.b] */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v11 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v34, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v57 */
        /* JADX WARN: Type inference failed for: r2v62 */
        /* JADX WARN: Type inference failed for: r2v63 */
        /* JADX WARN: Type inference failed for: r2v64 */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r2v66 */
        /* JADX WARN: Type inference failed for: r2v67 */
        /* JADX WARN: Type inference failed for: r2v68 */
        /* JADX WARN: Type inference failed for: r2v69 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v70 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r30v0 */
        /* JADX WARN: Type inference failed for: r30v1 */
        /* JADX WARN: Type inference failed for: r30v10 */
        /* JADX WARN: Type inference failed for: r30v11 */
        /* JADX WARN: Type inference failed for: r30v12 */
        /* JADX WARN: Type inference failed for: r30v13 */
        /* JADX WARN: Type inference failed for: r30v14 */
        /* JADX WARN: Type inference failed for: r30v15 */
        /* JADX WARN: Type inference failed for: r30v17 */
        /* JADX WARN: Type inference failed for: r30v18 */
        /* JADX WARN: Type inference failed for: r30v19 */
        /* JADX WARN: Type inference failed for: r30v2 */
        /* JADX WARN: Type inference failed for: r30v20 */
        /* JADX WARN: Type inference failed for: r30v21 */
        /* JADX WARN: Type inference failed for: r30v3 */
        /* JADX WARN: Type inference failed for: r30v4 */
        /* JADX WARN: Type inference failed for: r30v5 */
        /* JADX WARN: Type inference failed for: r30v6 */
        /* JADX WARN: Type inference failed for: r37v0 */
        /* JADX WARN: Type inference failed for: r37v1 */
        /* JADX WARN: Type inference failed for: r37v10 */
        /* JADX WARN: Type inference failed for: r37v13 */
        /* JADX WARN: Type inference failed for: r37v14 */
        /* JADX WARN: Type inference failed for: r37v17 */
        /* JADX WARN: Type inference failed for: r37v19 */
        /* JADX WARN: Type inference failed for: r37v2 */
        /* JADX WARN: Type inference failed for: r37v20 */
        /* JADX WARN: Type inference failed for: r37v21 */
        /* JADX WARN: Type inference failed for: r37v22 */
        /* JADX WARN: Type inference failed for: r37v3 */
        /* JADX WARN: Type inference failed for: r37v4 */
        /* JADX WARN: Type inference failed for: r37v5 */
        /* JADX WARN: Type inference failed for: r37v6 */
        /* JADX WARN: Type inference failed for: r37v7 */
        /* JADX WARN: Type inference failed for: r37v8 */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [long] */
        /* JADX WARN: Type inference failed for: r3v16 */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v24, types: [long] */
        /* JADX WARN: Type inference failed for: r3v25, types: [long] */
        /* JADX WARN: Type inference failed for: r3v26 */
        /* JADX WARN: Type inference failed for: r3v27 */
        /* JADX WARN: Type inference failed for: r3v28 */
        /* JADX WARN: Type inference failed for: r3v29 */
        /* JADX WARN: Type inference failed for: r3v30 */
        /* JADX WARN: Type inference failed for: r3v31 */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v23 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r9v10 */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r9v5 */
        /* JADX WARN: Type inference failed for: r9v6, types: [org.json.JSONObject] */
        /* JADX WARN: Type inference failed for: r9v8, types: [org.json.JSONObject] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            String r10 = "_event_v3";
            ?? r11 = "ab_sdk_version";
            String r12 = "nt";
            int r13 = 0;
            this.f13163c.P().t(b.a(), "Start to do migrate events task...", new Object[0]);
            SQLiteDatabase r14 = new v0.a(this.f13163c.w(), "ss_app_log.db").getWritableDatabase();
            ArrayList r15 = new ArrayList();
            r14.beginTransaction();     // Catch: Throwable -> L194
            int r16 = 1;
            Cursor r17 = r14.rawQuery("SELECT event._id as _id, category, tag, label, event.value, ext_value, ext_json, user_id, event.timestamp, event.event_index as event_index, user_type, user_is_login, user_is_auth, uid, disable_personalization, s.value as session_id FROM event left join session s on event.session_id  = s._id order by event._id asc limit ?", new String[]{String.valueOf(b.b())});     // Catch: Throwable -> L194
            long r18 = 0;
            ?? r37 = r11;
            ?? r19 = r12;
            ?? r20 = r15;
        L273:
        L191:
            th = th;
            ?? r21 = r20;
            Cursor r38 = r17;
        L193:
            Cursor r22 = r38;
            r11 = r21;
        L235:
            this.f13163c.P().u(b.a(), "Cannot migrate old events", th, new Object[0]);     // Catch: Throwable -> L210
            this.f13163c.R().h(MonitorKey.migrate_old, MonitorState.f_migrate_old_events_failed);     // Catch: Throwable -> L210
            if (r14.inTransaction() == false) goto L200;
            r14.endTransaction();
        L200:
            if (r22 == null) goto L264;
            r22.close();     // Catch: Throwable -> L220
            r11 = r11;
        L259:
        L210:
            th = move-exception;
            if (r14.inTransaction() == false) goto L214;
            r14.endTransaction();
        L214:
            if (r22 == null) goto L257;
            r22.close();     // Catch: Throwable -> L223
        L257:
            r14.close();     // Catch: Throwable -> L224
            throw th;
        L287:
            throw th;
        L6:
            if (r17.moveToNext() == false) goto L169;
            long r110 = r17.getLong(r13);     // Catch: Throwable -> L191
            long r111 = Math.max(r110, r18);     // Catch: Throwable -> L191
            f1.g r112 = this.f13163c.P();     // Catch: Throwable -> L191
            List<String> r23 = b.a();     // Catch: Throwable -> L191
            Object[] r24 = new Object[r16];     // Catch: Throwable -> L191
            r24[0] = Long.valueOf(r110);     // Catch: Throwable -> L191
            r112.t(r23, "Start to do migrate event:{}...", r24);     // Catch: Throwable -> L191
            String r25 = r17.getString(r16);     // Catch: Throwable -> L165
            String r26 = r17.getString(2);     // Catch: Throwable -> L165
            if (TextUtils.isEmpty(r26) == false) goto L12;
            r10 = r10;
            r37 = r37;
            ?? r30 = r19;
            SQLiteDatabase r27 = r14;
            r21 = r20;
            r38 = r17;
            long r28 = r111;
        L168:
            r20 = r21;
            r14 = r27;
            r18 = r28;
            r19 = r30;
            r10 = r10;
            r37 = r37;
            r17 = r38;
            r13 = 0;
            r16 = 1;
            goto L273
        L12:
            if (r17.isNull(3) == true) goto L14;
            String r113 = r17.getString(3);     // Catch: Throwable -> L165
        L16:
            if (r17.isNull(4) == true) goto L18;
            long r29 = r17.getLong(4);     // Catch: Throwable -> L165
        L20:
            if (r17.isNull(5) == true) goto L22;
            long r210 = r17.getLong(5);     // Catch: Throwable -> L165
        L24:
            if (r17.isNull(6) == true) goto L28;
            String r114 = r17.getString(6);     // Catch: Throwable -> L165
            if (TextUtils.isEmpty(r114) == true) goto L28;
            ?? r31 = new JSONObject(r114);     // Catch: Throwable -> L165
        L29:
            if (r31 != 0) goto L32;
            r31 = new JSONObject();     // Catch: Throwable -> L165
        L32:
            r28 = r111;
            r31.put("_applog_old", 1);     // Catch: Throwable -> L164
            if (r17.isNull(7) == true) goto L36;
            long r115 = r17.getLong(7);     // Catch: Throwable -> L164
        L37:
            String r116 = r113;
            long r117 = r17.getLong(8);     // Catch: Throwable -> L164
            r27 = r14;
            long r118 = r17.getLong(9);     // Catch: Throwable -> L162
            if (r17.isNull(10) == true) goto L43;
            int r32 = r17.getInt(10);     // Catch: Throwable -> L162
        L270:
            if (r17.isNull(11) == true) goto L48;
            int r33 = r17.getInt(11);     // Catch: Throwable -> L160
        L50:
            if (r17.isNull(12) == true) goto L52;
            int r34 = r17.getInt(12);     // Catch: Throwable -> L160
        L54:
            if (r17.isNull(12) == true) goto L56;
            long r40 = r115;
            long r119 = r17.getLong(12);     // Catch: Throwable -> L160
            long r35 = r40;
        L57:
            String r36 = r17.getString(14);     // Catch: Throwable -> L160
            int r39 = r32;
            String r310 = "";
            if (r17.isNull(15) == true) goto L61;
            String r41 = r17.getString(15);     // Catch: Throwable -> L160
        L62:
            int r311 = NetworkUtils.NetworkType.UNKNOWN.getValue();     // Catch: Throwable -> L160
            r38 = r17;
            if ("event_v3".equalsIgnoreCase(r25) == false) goto L106;
            if (r31.optInt(r10, 0) != 1) goto L106;
            r31.remove(r10);     // Catch: Throwable -> L158
            if (r31.has(r19) == false) goto L71;
            r311 = r31.optInt(r19);     // Catch: Throwable -> L158
            r31.remove(r19);     // Catch: Throwable -> L158
        L71:
            int r42 = r311;
            if (r31.has(r37) == false) goto L74;
            r310 = r31.optString(r37);     // Catch: Throwable -> L158
            r31.remove(r37);     // Catch: Throwable -> L158
        L74:
            r10 = r10;
            String r43 = r310;
            r37 = r37;
            e r44 = new e(this.f13163c.getAppId(), r26);     // Catch: Throwable -> L225
            r44.f10835n = r42;     // Catch: Throwable -> L225
            r44.x(r117);     // Catch: Throwable -> L225
            r44.f10834m = r43;     // Catch: Throwable -> L225
            r44.f10829h = r118;     // Catch: Throwable -> L225
            r44.f10830i = r41;     // Catch: Throwable -> L225
            r44.C = r36;     // Catch: Throwable -> L225
            r44.G(r31.toString());     // Catch: Throwable -> L225
            if (this.f13163c.D() == false) goto L80;
        L81:
            r44.f10832k = r119;     // Catch: Throwable -> L225
        L83:
            if (this.f13163c.D() == true) goto L85;
            if (r39 > 0) goto L85;
        L87:
            if (this.f13163c.D() == false) goto L89;
        L90:
            r44.f10831j = r35;     // Catch: Throwable -> L225
        L91:
            int r45 = r34;
            if (this.f13163c.D() == true) goto L94;
            if (r45 > 0) goto L94;
        L96:
            if (this.f13163c.D() == true) goto L98;
            if (r33 > 0) goto L98;
        L100:
            if (TextUtils.isEmpty(this.f13163c.W()) == true) goto L102;
            r44.f10833l = this.f13163c.W();     // Catch: Throwable -> L225
        L102:
            ?? r120 = r20;
            r120.add(r44);     // Catch: Throwable -> L156
            r30 = r19;
            r21 = r120;
            r19 = r110;
            r120 = 0;
            ?? r46 = r19;
            r37 = r37;
        L253:
            this.f13163c.P().t(b.a(), "Event:{} move step over.", new Object[]{Long.valueOf(r46)});     // Catch: Throwable -> L219
        L272:
            this.f13163c.P().m(b.a(), "Cannot move event to bdtracker.", new Object[]{Long.valueOf(r46)});     // Catch: Throwable -> L189
        L189:
            th = th;
            r14 = r27;
        L156:
            r30 = r19;
        L157:
            ?? r47 = r120;
            ?? r312 = r30;
            ?? r313 = r37;
        L163:
            r46 = r110;
            r21 = r47;
            r30 = r312;
            r37 = r313;
        L98:
            r44.f10837p = r33;     // Catch: Throwable -> L225
        L94:
            r44.f10838q = r45;     // Catch: Throwable -> L225
            goto L96
        L89:
            if (r35 <= 0) goto L91;
        L85:
            r44.f10836o = r39;     // Catch: Throwable -> L225
            goto L87
        L80:
            if (r119 <= 0) goto L83;
        L161:
            r21 = r20;
            r30 = r19;
            r46 = r110;
        L159:
            r37 = r37;
        L106:
            r120 = r20;
            int r121 = r33;
            int r48 = r34;
            long r49 = r35;
            r30 = r19;
            l1.c r50 = new l1.c(this.f13163c.getAppId(), r25, r26);     // Catch: Throwable -> L154
            r50.f10830i = r41;     // Catch: Throwable -> L154
            r50.x(r117);     // Catch: Throwable -> L154
            r46 = r110;
            r50.f10829h = r46;     // Catch: Throwable -> L228
            r50.C = r31.toString();     // Catch: Throwable -> L228
            if (TextUtils.isEmpty(r116) == true) goto L115;
            r50.B = r116;     // Catch: Throwable -> L228
        L115:
            long r122 = r29;
            if (r122 != 0) goto L241;
        L121:
            long r123 = r210;
            if (r123 == 0) goto L125;
            r50.E = r123;     // Catch: Throwable -> L228
        L125:
            if (this.f13163c.D() == false) goto L127;
        L128:
            r50.f10832k = r119;     // Catch: Throwable -> L228
        L130:
            if (this.f13163c.D() == true) goto L132;
            if (r39 > 0) goto L132;
        L135:
            if (this.f13163c.D() == false) goto L137;
        L138:
            r50.f10831j = r49;     // Catch: Throwable -> L227
        L243:
            if (this.f13163c.D() == true) goto L142;
            if (r48 > 0) goto L142;
        L144:
            if (this.f13163c.D() == true) goto L146;
            if (r121 > 0) goto L146;
        L148:
            if (TextUtils.isEmpty(this.f13163c.W()) == true) goto L150;
            r50.f10833l = this.f13163c.W();     // Catch: Throwable -> L227
        L150:
            ?? r51 = r120;
            r51.add(r50);     // Catch: Throwable -> L219
            r21 = r51;
            r46 = r46;
            r30 = r30;
            r37 = r37;
        L146:
            r50.f10837p = r121;     // Catch: Throwable -> L227
        L142:
            r50.f10838q = r48;     // Catch: Throwable -> L227
        L120:
            r21 = r120;
            goto L272
        L137:
            if (r49 <= 0) goto L243;
        L132:
            r50.f10836o = r39;     // Catch: Throwable -> L228
            goto L135
        L127:
            if (r119 <= 0) goto L130;
        L241:
            r50.D = r122;     // Catch: Throwable -> L119
        L155:
            r21 = r120;
            r46 = r46;
            r30 = r30;
            r37 = r37;
        L154:
            r46 = r110;
        L158:
            r10 = r10;
            goto L159
        L61:
            r41 = "";
            goto L62
        L56:
            r35 = r115;
            r119 = 0;
            goto L57
        L52:
            r34 = 0;
            goto L54
        L48:
            r33 = 0;
        L160:
            r10 = r10;
            r37 = r37;
            r38 = r17;
            goto L161
        L43:
            r32 = 0;
        L162:
            r10 = r10;
            r313 = r37;
            r312 = r19;
            r47 = r20;
            r38 = r17;
            goto L163
        L36:
            r115 = 0;
        L164:
            r10 = r10;
            r37 = r37;
            r30 = r19;
            r27 = r14;
            r21 = r20;
            r38 = r17;
            r46 = r110;
        L28:
            r31 = 0;
            goto L29
        L22:
            r210 = 0;
            goto L24
        L18:
            r29 = 0;
            goto L20
        L14:
            r113 = null;
        L165:
            r10 = r10;
            r37 = r37;
            r30 = r19;
            r27 = r14;
            r21 = r20;
            r38 = r17;
            r46 = r110;
            r28 = r111;
            goto L272
        L169:
            SQLiteDatabase r211 = r14;
            r21 = r20;
            r38 = r17;
            if (r21.size() != 0) goto L178;
            this.f13163c.P().t(b.a(), "Not Found any event to move.", new Object[0]);     // Catch: Throwable -> L189
            r211.setTransactionSuccessful();     // Catch: Throwable -> L189
            if (r211.inTransaction() == false) goto L278;
            r211.endTransaction();
        L278:
            r38.close();     // Catch: Throwable -> L229
        L231:
            r211.close();     // Catch: Throwable -> L230
            return;
        L286:
            return;
        L178:
            this.f13163c.P().t(b.a(), "Found {} event to move...", new Object[]{Integer.valueOf(r21.size())});     // Catch: Throwable -> L189
            this.f13164g.E(r21);     // Catch: Throwable -> L189
            r14 = r211;
            int r52 = r14.delete(NotificationCompat.CATEGORY_EVENT, "_id <= ?", new String[]{String.valueOf(r18)});     // Catch: Throwable -> L187
            r14.setTransactionSuccessful();     // Catch: Throwable -> L187
            this.f13163c.P().t(b.a(), "Move events to bdtracker completed with {} rows and {} events success.", new Object[]{Integer.valueOf(r52), Integer.valueOf(r21.size())});     // Catch: Throwable -> L187
            if (r14.inTransaction() == false) goto L184;
            r14.endTransaction();
        L184:
            r38.close();     // Catch: Throwable -> L220
            r11 = r21;
        L187:
            th = th;
        L194:
            th = th;
            r11 = r15;
            r22 = null;
        L264:
            r14.close();     // Catch: Throwable -> L221
        L204:
            if (r11.size() >= b.b()) goto L239;
            return;
        L239:
            Thread.sleep(2000);     // Catch: InterruptedException -> L222
        L208:
            this.f13163c.P().t(b.a(), "Retry migrate events...", new Object[0]);
            b.c(this.f13163c, this.f13164g);
        }
    }

    static {
        f13157a = Collections.singletonList("OldAppLogDataMigrator");
        f13158b = 1000;
        f13159c = false;
        f13160d = false;
    }

    static /* synthetic */ List a() {
        return f13157a;
    }

    static /* synthetic */ int b() {
        return f13158b;
    }

    public static void c(c r10, l1.b r11) {
        if (f13159c == true) goto L5;
        return;
    L5:
        if (r10.h0() == false) goto L10;
        r10.P().t(f13157a, "Start to migrate events...", new Object[0]);
        z0.a.d().submit(new RunnableC0302b(r10, r11));
        return;
    }

    public static void d(c r10, l1.b r11) {
        if (f13160d == true) goto L5;
        return;
    L5:
        if (r10.h0() == false) goto L10;
        r10.P().t(f13157a, "Start to migrate stay duration data with pages...", new Object[0]);
        z0.a.d().submit(new a(r10, r11));
        return;
    }
}
