package n6;

import android.text.TextUtils;
import fi.h;
import fi.j;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f20206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f20207c;

    public a(HashMap r5, h r10) {
        this.f20205a = 1;
        this.f20206b = r5;
        this.f20207c = r10;
    }

    @Override // fi.j
    public final String a() {
        switch(this.f20205a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        return "text/plain";
    L5:
        return ((h) this.f20207c).f16913a;
    }

    @Override // fi.j
    public final String b() {
        switch(this.f20205a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        StringBuilder r5 = new StringBuilder(((h) this.f20207c).f16914b.getName());
        r5.append("\"");
        Iterator r10 = this.f20206b.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r11 = (Map.Entry) r10.next();
        androidx.constraintlayout.motion.widget.a.C(r5, "; ", (String) r11.getKey(), "=\"", (String) r11.getValue());
        r5.append("\"");
        goto L6
    L8:
        r5.deleteCharAt(r5.length() - 1);
        return r5.toString();
    L10:
        StringBuilder r12 = new StringBuilder("params.txt");
        r12.append("\"");
        Iterator r13 = this.f20206b.entrySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();
        androidx.constraintlayout.motion.widget.a.C(r12, "; ", (String) r14.getKey(), "=\"", (String) r14.getValue());
        r12.append("\"");
        goto L12
    L14:
        r12.deleteCharAt(r12.length() - 1);
        return r12.toString();
    }

    @Override // fi.j
    public final String d() {
        switch(this.f20205a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((h) this.f20207c).getClass();
        return null;
    L6:
        return null;
    }

    @Override // fi.j
    public final long length() {
        switch(this.f20205a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ((h) this.f20207c).f16914b.length();
    L7:
        return ((String) this.f20207c).getBytes().length;
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        switch(this.f20205a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ((h) this.f20207c).writeTo(r5);
        return;
    L6:
        r5.write(((String) this.f20207c).getBytes());
    }

    public a(String r5, HashMap r10) {
        this.f20205a = 0;
        this.f20206b = r10;
        if (TextUtils.isEmpty(r5) == false) goto L7;
        JSONObject r11 = new JSONObject();
        r11.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.f20207c = r11.toString();
        return;
    L7:
        this.f20207c = r5;
    }
}
