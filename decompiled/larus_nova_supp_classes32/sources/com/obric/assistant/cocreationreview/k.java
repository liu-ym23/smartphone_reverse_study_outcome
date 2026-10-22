package com.obric.assistant.cocreationreview;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static final ContentValues b(a5 r9) {
        ContentValues r0 = new ContentValues();
        r0.put("record_id", r9.a);
        r0.put("created_at", Long.valueOf(r9.f));
        Vote r1 = r9.b;
        if (r1 == null) goto L5;
        String r2 = r1.getRaw();
    L6:
        r0.put("vote", r2);
        Set<String> r3 = r9.c;
        JSONArray r4 = new JSONArray();
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.put((String) r5.next());
        goto L8
    L10:
        r0.put("reasons", r4.toString());
        r0.put("comment", r9.d);
        List<b5> r6 = r9.g;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        JsonArray r7 = new JsonArray();
        ArrayList r8 = new ArrayList();
        Iterator<T> r10 = r6.iterator();
    L12:
        if (r10.hasNext() == false) goto L26;
        Object r11 = r10.next();
        b5 r12 = (b5) r11;
        boolean r13 = false;
        if (r12.h != FeedbackMediaUploadState.UPLOADED) goto L24;
        String r14 = r12.k;
        if (r14 != null) goto L18;
    L21:
        boolean r15 = true;
    L22:
        if (r15 == true) goto L24;
        r13 = true;
        goto L24
    L18:
        if (StringsKt.isBlank(r14) == true) goto L21;
        r15 = false;
    L24:
        if (r13 == false) goto L12;
        r8.add(r11);
        goto L12
    L26:
        Iterator r16 = r8.iterator();
    L28:
        if (r16.hasNext() == false) goto L30;
        b5 r17 = (b5) r16.next();
        JsonObject r18 = new JsonObject();
        r18.addProperty("id", r17.a);
        r18.addProperty("local_uri", r17.b);
        r18.addProperty("type", r17.getType().name());
        r18.addProperty("display_name", r17.d);
        r18.addProperty("duration_ms", Long.valueOf(r17.e));
        r18.addProperty("remote_uri", r17.k);
        r7.add(r18);
        goto L28
    L30:
        r0.put("media_json", r7.toString());
        r0.put("feedback_value", r9.h);
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public static final a5 c(Cursor r27) {
        Vote.a r0 = Vote.Companion;
        int r2 = r27.getColumnIndexOrThrow("vote");
        if (r27.isNull(r2) == false) goto L5;
        String r3 = null;
    L6:
        r0.getClass();
        Vote r7 = Vote.a.a(r3);
        JSONArray r4 = new JSONArray(r27.getString(r27.getColumnIndexOrThrow("reasons")));
        LinkedHashSet r8 = new LinkedHashSet();
        int r1 = r4.length();
        int r5 = 0;
    L8:
        if (r5 >= r1) goto L13;
        String r9 = r4.optString(r5);
        Intrinsics.checkNotNull(r9);
        if ((true ^ StringsKt.isBlank(r9)) == false) goto L12;
        r8.add(r9);
    L12:
        r5 = r5 + 1;
        goto L8
    L13:
        String r6 = r27.getString(r27.getColumnIndexOrThrow("record_id"));
        String r10 = r27.getString(r27.getColumnIndexOrThrow("comment"));
        if (r7 != null) goto L16;
    L18:
        boolean r11 = false;
    L19:
        long r12 = r27.getLong(r27.getColumnIndexOrThrow("created_at"));
        String r13 = r27.getString(r27.getColumnIndexOrThrow("media_json"));
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L22
        Object r15 = Result.constructor-impl(JsonParser.parseString(r13).getAsJsonArray());     // Catch: Throwable -> L22
    L24:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L28;
        int r17 = s3.a;
        s3.c("feedback.media.persistence", "parse failed message=" + r16.getMessage());
    L28:
        if (Result.isFailure-impl(r15) == false) goto L30;
        r15 = null;
    L30:
        JsonArray r18 = (JsonArray) r15;
        if (r18 != null) goto L33;
        List r19 = CollectionsKt.emptyList();
    L75:
        int r20 = r27.getColumnIndexOrThrow("feedback_value");
        if (r27.isNull(r20) == true) goto L86;
        Integer r21 = Integer.valueOf(r27.getInt(r20));
        int r22 = r21.intValue();
        if (r22 >= 0) goto L81;
    L83:
        boolean r23 = false;
    L84:
        if (r23 == false) goto L86;
        Integer r110 = r21;
    L88:
        return new a5(r6, r7, r8, r10, r11, r12, r19, r110);
    L81:
        if (r22 >= 10000) goto L83;
        r23 = true;
    L86:
        r110 = null;
        goto L88
    L33:
        ArrayList r24 = new ArrayList();
        Iterator r111 = r18.iterator();
    L35:
        if (r111.hasNext() == false) goto L74;
        JsonElement r112 = (JsonElement) r111.next();
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L62
        JsonObject r26 = r112.getAsJsonObject();     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r26);     // Catch: Throwable -> L62
        String r113 = m.a(r26, "id");     // Catch: Throwable -> L62
        String r114 = m.a(r26, "local_uri");     // Catch: Throwable -> L62
        FeedbackMediaType r115 = FeedbackMediaType.valueOf(m.a(r26, "type"));     // Catch: Throwable -> L62
        String r28 = m.a(r26, "remote_uri");     // Catch: Throwable -> L62
        JsonElement r29 = r26.get("display_name");     // Catch: Throwable -> L62
        if (r29 != null) goto L40;
    L45:
        String r30 = null;
    L46:
        if (r30 != null) goto L48;
        r30 = NameKeys.UnloadStrategy_No_Strategy;
    L48:
        String r210 = r30;
        JsonElement r31 = r26.get("duration_ms");     // Catch: Throwable -> L62
        if (r31 != null) goto L51;
    L56:
        Long r32 = null;
    L57:
        if (r32 == null) goto L59;
        long r211 = r32.longValue();     // Catch: Throwable -> L62
    L60:
        Object r33 = Result.constructor-impl(new b5(r113, r114, r115, r210, r211, FeedbackMediaUploadState.UPLOADED, 100, r28, 2656));     // Catch: Throwable -> L62
    L64:
        Throwable r34 = Result.exceptionOrNull-impl(r33);
        if (r34 == null) goto L68;
        int r35 = s3.a;
        s3.c("feedback.media.persistence", "drop invalid item message=" + r34.getMessage() + ", item=" + StringsKt.take(r112.toString(), 200));
    L68:
        if (Result.isFailure-impl(r33) == false) goto L70;
        r33 = null;
    L70:
        b5 r36 = (b5) r33;
        if (r36 == null) goto L35;
        r24.add(r36);
        goto L35
    L59:
        r211 = 0;
        goto L60
    L51:
        if (r31.isJsonNull() == false) goto L54;
        r31 = null;
    L54:
        if (r31 == null) goto L56;
        r32 = Long.valueOf(r31.getAsLong());     // Catch: Throwable -> L62
        goto L57
    L40:
        if (r29.isJsonNull() == false) goto L43;
        r29 = null;
    L43:
        if (r29 == null) goto L45;
        r30 = r29.getAsString();     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L74:
        r19 = r24;
    L22:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L16:
        if ((!r8.isEmpty()) == false) goto L18;
        r11 = true;
        goto L19
    L5:
        r3 = r27.getString(r2);
        goto L6
    }

    public static final boolean a(SQLiteDatabase r4, String r5) {
        Cursor r6 = r4.rawQuery("PRAGMA table_info(feedback_data)", null);
        Cursor r0 = r6;     // Catch: Throwable -> L12
        int r2 = r0.getColumnIndexOrThrow(EasyGoDbTable.Server.NAME);     // Catch: Throwable -> L12
    L5:
        if (r0.moveToNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.getString(r2), r5) == false) goto L5;
        boolean r7 = true;
    L10:
        CloseableKt.closeFinally(r6, null);
        return r7;
    L9:
        r7 = false;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }
}
