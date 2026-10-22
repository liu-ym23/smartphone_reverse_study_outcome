package pqa;

import com.bytedance.common.push.BaseJson;
import com.ss.alive.monitor.model.StartType;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends BaseJson {
    public StartType a;
    public boolean b;
    public String c;
    public String d;
    public StackTraceElement[] e;
    public String f;
    public long g;
    public String h;

    public final JSONObject b() {
        JSONObject r0 = new JSONObject();
        add(r0, "start_type", this.a.startType);
        if (this.b == false) goto L5;
        long r4 = 1;
    L6:
        add(r0, "is_fore_ground", r4);
        add(r0, "is_active", 0);
        add(r0, "target_pkg", this.c);
        add(r0, "target_component", this.d);
        add(r0, "client_time", this.g);
        add(r0, "process", this.h);
        JSONArray r1 = new JSONArray();
        StackTraceElement[] r2 = this.e;
        if (r2 == null) goto L11;
        int r3 = r2.length;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L11;
        StackTraceElement r6 = r2[r5];
        JSONObject r7 = new JSONObject();
        add(r7, "class_name", r6.getClassName());
        add(r7, "file_name", r6.getFileName());
        add(r7, "method_name", r6.getMethodName());
        add(r7, "line_number", r6.getLineNumber());
        r1.put(r7);
        r5 = r5 + 1;
    L11:
        add(r0, "stack_trace", r1.toString());
        return r0;
    L5:
        r4 = 0;
        goto L6
    }

    public a() {
    }
}
