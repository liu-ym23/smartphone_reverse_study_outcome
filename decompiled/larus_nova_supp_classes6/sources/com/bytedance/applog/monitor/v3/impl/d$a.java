package com.bytedance.applog.monitor.v3.impl;

import android.text.TextUtils;
import com.bytedance.applog.monitor.v3.EventStage;
import ex3.i;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class d$a {
    public static final List<EventStage> e = null;
    public final i a;
    public EventStage b;
    public boolean c;
    public final JSONObject d;

    static {
        e = Arrays.asList(new EventStage[]{EventStage.COLLECTED, EventStage.PROCESS_END, EventStage.DB_SAVE_END, EventStage.PACK_INSERT_END, EventStage.POST_ISOLATE, EventStage.POST_FAILED, EventStage.POST_START, EventStage.REPORT_END});
    }

    public final String b() {
        StringBuilder r0 = new StringBuilder("v4|");
        if (TextUtils.isEmpty(this.a.e) == false) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        r0.append("|");
        r0.append(this.a.f);
        r0.append("|");
        r0.append(this.b.name());
        r0.append("|");
        r0.append(this.a.a);
        r0.append("|");
        r0.append(this.a.c);
        r0.append("|");
        r0.append(this.a.d.name());
        r0.append("|");
        r0.append(this.d);
        return r0.toString();
    L5:
        r1 = this.a.e;
        goto L6
    }

    public final void a(JSONObject r5) {
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        if (this.d.has(r1) == true) goto L4;
        this.d.put(r1, r5.get(r1));     // Catch: JSONException -> L10
        goto L4
    }

    public d$a(EventStage r2, i r3) {
        this.c = false;
        this.d = new JSONObject();
        this.b = r2;
        this.a = r3;
    }
}
