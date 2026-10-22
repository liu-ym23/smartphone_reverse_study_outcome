package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.ContentValues;
import android.database.Cursor;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.assistant.cocreationreview.ModuleKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static final ContentValues a(c0 r15) {
        ContentValues r0 = new ContentValues();
        r0.put("record_id", r15.a);
        r0.put("created_at", Long.valueOf(r15.c));
        r0.put("user_question", r15.g);
        r0.put("answer_text", r15.i);
        r0.put("answer_summary", r15.h);
        List<s> r1 = r15.j;
        JSONArray r2 = new JSONArray();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        s r4 = (s) r3.next();
        JSONObject r5 = new JSONObject().put("title", r4.a).put("description", r4.b).put("source_type", r4.c).put("entity_type", r4.d).put("entity_id", r4.e).put("entity_package_name", r4.f).put("index", r4.g).put("image_uris", new JSONArray(r4.h));
        List<r> r6 = r4.i;
        JSONArray r10 = new JSONArray();
        Iterator<T> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        r r11 = (r) r7.next();
        r10.put(new JSONObject().put("res_uri", r11.a).put("entity_type", r11.b).put("entity_id", r11.c).put("entity_package_name", r11.d).put("index", r11.e).put("is_video", r11.f));
        goto L7
    L9:
        r2.put(r5.put("images", r10).put(LynxEventReporter.PROP_NAME_URL, r4.j));
        goto L4
    L10:
        r0.put("local_references", r2.toString());
        r0.put("log_id", r15.k);
        return r0;
    }

    public static final c0 b(Cursor r44) {
        long r5 = r44.getLong(r44.getColumnIndexOrThrow("created_at"));
        String r3 = r44.getString(r44.getColumnIndexOrThrow("record_id"));
        ModuleKey r4 = h.a.a;
        String r7 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(r5));
        String r8 = r44.getString(r44.getColumnIndexOrThrow("user_question"));
        String r9 = r44.getString(r44.getColumnIndexOrThrow("answer_summary"));
        String r10 = r44.getString(r44.getColumnIndexOrThrow("answer_text"));
        JSONArray r11 = new JSONArray(r44.getString(r44.getColumnIndexOrThrow("local_references")));
        ArrayList r12 = new ArrayList();
        int r2 = r11.length();
        int r14 = 0;
    L3:
        if (r14 >= r2) goto L89;
        JSONObject r15 = r11.optJSONObject(r14);
        if (r15 == null) goto L12;
        String r13 = r15.optString("title");
        Intrinsics.checkNotNull(r13);
        if ((!StringsKt.isBlank(r13)) == false) goto L10;
        String r20 = r13;
    L11:
        if (r20 == null) goto L12;
        String r21 = r15.optString("description");
        String r22 = r15.optString("source_type");
        String r16 = r15.optString("entity_type");
        Intrinsics.checkNotNull(r16);
        if ((!StringsKt.isBlank(r16)) == false) goto L16;
        String r23 = r16;
    L17:
        String r19 = r15.optString("entity_id");
        Intrinsics.checkNotNull(r19);
        if ((!StringsKt.isBlank(r19)) == false) goto L20;
        String r24 = r19;
    L21:
        String r110 = r15.optString("entity_package_name");
        Intrinsics.checkNotNull(r110);
        if ((!StringsKt.isBlank(r110)) == false) goto L24;
        String r25 = r110;
    L25:
        Integer r111 = Integer.valueOf(r15.optInt("index"));
        if (r111.intValue() <= 0) goto L28;
        boolean r26 = true;
    L30:
        if (r26 == false) goto L32;
        Integer r27 = r111;
    L33:
        JSONArray r17 = r15.optJSONArray("image_uris");
        if (r17 != null) goto L36;
        List r28 = CollectionsKt.emptyList();
    L46:
        JSONArray r6 = r15.optJSONArray("images");
        if (r6 != null) goto L49;
        List r29 = CollectionsKt.emptyList();
    L82:
        String r18 = r15.optString(LynxEventReporter.PROP_NAME_URL);
        Intrinsics.checkNotNull(r18);
        if ((!StringsKt.isBlank(r18)) == false) goto L85;
        String r210 = r18;
    L86:
        r12.add(new s(r20, r21, r22, r23, r24, r25, r27, r28, r29, r210));
    L87:
        r14 = r14 + 1;
        r2 = r2;
        r11 = r11;
        r10 = r10;
        r9 = r9;
        r8 = r8;
        r7 = r7;
        r5 = r5;
        goto L3
    L85:
        r210 = null;
        goto L86
    L49:
        ArrayList r30 = new ArrayList();
        int r31 = r6.length();
        int r32 = 0;
    L50:
        if (r32 >= r31) goto L81;
        JSONObject r33 = r6.optJSONObject(r32);
        JSONArray r112 = r6;
        if (r33 == null) goto L80;
        String r34 = r33.optString("res_uri");
        Intrinsics.checkNotNull(r34);
        if ((!StringsKt.isBlank(r34)) == false) goto L57;
        String r38 = r34;
    L58:
        if (r38 == null) goto L80;
        String r35 = r33.optString("entity_type");
        Intrinsics.checkNotNull(r35);
        if ((!StringsKt.isBlank(r35)) == false) goto L63;
        String r39 = r35;
    L64:
        String r36 = r33.optString("entity_id");
        Intrinsics.checkNotNull(r36);
        if ((!StringsKt.isBlank(r36)) == false) goto L67;
        String r40 = r36;
    L68:
        String r37 = r33.optString("entity_package_name");
        Intrinsics.checkNotNull(r37);
        if ((!StringsKt.isBlank(r37)) == false) goto L71;
        String r41 = r37;
    L72:
        Integer r42 = Integer.valueOf(r33.optInt("index"));
        if (r42.intValue() <= 0) goto L75;
        boolean r211 = true;
    L76:
        if (r211 == false) goto L78;
        Integer r43 = r42;
    L79:
        r30.add(new r(r38, r39, r40, r41, r43, r33.optBoolean("is_video")));
        goto L80
    L78:
        r43 = null;
        goto L79
    L75:
        r211 = false;
        goto L76
    L71:
        r41 = null;
        goto L72
    L67:
        r40 = null;
        goto L68
    L63:
        r39 = null;
        goto L64
    L57:
        r38 = null;
    L80:
        r32 = r32 + 1;
        r6 = r112;
        goto L50
    L81:
        r29 = r30;
        goto L82
    L36:
        List r45 = CollectionsKt.createListBuilder();
        int r46 = r17.length();
        int r47 = 0;
    L37:
        if (r47 >= r46) goto L45;
        String r48 = r17.optString(r47);
        Intrinsics.checkNotNull(r48);
        if ((!StringsKt.isBlank(r48)) == true) goto L42;
        r48 = null;
    L42:
        if (r48 == null) goto L44;
        r45.add(r48);
    L44:
        r47 = r47 + 1;
        goto L37
    L45:
        r28 = CollectionsKt.build(r45);
        goto L46
    L32:
        r27 = null;
        goto L33
    L28:
        r26 = false;
        goto L30
    L24:
        r25 = null;
        goto L25
    L20:
        r24 = null;
        goto L21
    L16:
        r23 = null;
        goto L17
    L10:
        r20 = null;
    L12:
        r2 = r2;
        r5 = r5;
        r7 = r7;
        r8 = r8;
        goto L87
    L89:
        return new c0(r3, r4, r5, r7, r8, r9, r10, r12, r44.getString(r44.getColumnIndexOrThrow("log_id")), null, 6144);
    }
}
