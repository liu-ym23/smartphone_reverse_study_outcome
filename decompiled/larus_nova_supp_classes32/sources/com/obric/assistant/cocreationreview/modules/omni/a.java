package com.obric.assistant.cocreationreview.modules.omni;

import android.content.ContentValues;
import android.database.Cursor;
import com.obric.assistant.cocreationreview.ModuleKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lda.b0;
import lda.c;
import lda.e;
import lda.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final ContentValues a(b0 r6) {
        ContentValues r0 = new ContentValues();
        r0.put("record_id", r6.a);
        r0.put("task_id", r6.c);
        r0.put("created_at", Long.valueOf(r6.d));
        r0.put("user_query", r6.e);
        r0.put("dobao_answer", r6.f);
        r0.put("status", r6.g.getRaw());
        r0.put("task_trigger_type", r6.h.getRaw());
        List<c> r1 = r6.i;
        JSONArray r2 = new JSONArray();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r4 = v.a(((c) r3.next()).a);
        if ((!StringsKt.isBlank(r4)) == false) goto L4;
        r2.put(new JSONObject().put("description", r4));
        goto L4
    L8:
        r0.put("steps", r2.toString());
        r0.put("time", r6.j);
        return r0;
    }

    public static final b0 b(Cursor r18) {
        String r1 = r18.getString(r18.getColumnIndexOrThrow("record_id"));
        ModuleKey r2 = e.a.a;
        String r3 = r18.getString(r18.getColumnIndexOrThrow("task_id"));
        long r4 = r18.getLong(r18.getColumnIndexOrThrow("created_at"));
        String r6 = r18.getString(r18.getColumnIndexOrThrow("user_query"));
        String r7 = r18.getString(r18.getColumnIndexOrThrow("dobao_answer"));
        OmniTaskStatus.a r8 = OmniTaskStatus.Companion;
        String r9 = r18.getString(r18.getColumnIndexOrThrow("status"));
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "raw");
        OmniTaskStatus[] r10 = OmniTaskStatus.values();
        int r11 = r10.length;
        int r13 = 0;
    L4:
        if (r13 >= r11) goto L15;
        OmniTaskStatus r15 = r10[r13];
        if (Intrinsics.areEqual(r15.getRaw(), r9) == false) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == true) goto L16;
        r13 = r13 + 1;
    L16:
        if (r15 != null) goto L18;
        OmniTaskStatus r14 = OmniTaskStatus.SUCCESS;
    L19:
        OmniTaskTriggerType.a r16 = OmniTaskTriggerType.Companion;
        String r17 = r18.getString(r18.getColumnIndexOrThrow("task_trigger_type"));
        r16.getClass();
        OmniTaskTriggerType r19 = OmniTaskTriggerType.a.a(r17);
        JSONArray r110 = new JSONArray(r18.getString(r18.getColumnIndexOrThrow("steps")));
        ArrayList r111 = new ArrayList();
        int r112 = r110.length();
        int r113 = 0;
    L20:
        if (r113 >= r112) goto L30;
        Object r114 = r110.get(r113);
        JSONArray r115 = r110;
        if ((r114 instanceof JSONObject) == false) goto L24;
        String r116 = ((JSONObject) r114).optString("description");
    L25:
        Intrinsics.checkNotNull(r116);
        String r117 = v.a(r116);
        if ((!StringsKt.isBlank(r117)) == false) goto L28;
        r111.add(new c(r117));
    L28:
        r113 = r113 + 1;
        r110 = r115;
        goto L20
    L24:
        r116 = r114.toString();
        goto L25
    L30:
        return new b0(r1, r2, r3, r4, r6, r7, r14, r19, r111, r18.getString(r18.getColumnIndexOrThrow("time")));
    L18:
        r14 = r15;
        goto L19
    L8:
        if (StringsKt.equals(r15.name(), r9, true) == true) goto L11;
        r12 = false;
        goto L12
    L15:
        r15 = null;
        goto L16
    }

    public static final String c(String r6, int r7) {
        String r8 = StringsKt.replace$default(r6, "\n", "\\n", false, 4, null);
        if (r8.length() > r7) goto L6;
        return r8;
    L6:
        return StringsKt.take(r8, r7) + "...";
    }
}
