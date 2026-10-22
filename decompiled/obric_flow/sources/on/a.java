package on;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20778c;
    public String d;
    public String e;

    public a(String r5, String r10, String r11, String r12, String r13) {
        this.f20776a = r5;
        this.f20777b = r10;
        this.f20778c = r11;
        this.d = r12;
        this.e = r13;
    }

    public static HashMap a(ReadableArray r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r5 = new HashMap();
        int r11 = 0;
    L7:
        if (r11 >= r10.size()) goto L22;
        ReadableMap r12 = r10.getMap(r11);
        String r13 = r12.getString("name");
        a r14 = (a) r5.get(r13);
        if (r14 != null) goto L12;
        r14 = new a(r13, r12.getString("type"), r12.getString("function"), r12.getString("lepusType"), r12.getString("lepusFunction"));
    L21:
        r5.put(r14.f20776a, r14);
        r11 = r11 + 1;
        goto L7
    L12:
        if (r14.f20777b != null) goto L17;
        if (r14.f20778c != null) goto L17;
        r14.f20777b = r12.getString("type");
        r14.f20778c = r12.getString("function");
    L17:
        if (r14.d != null) goto L21;
        if (r14.e != null) goto L21;
        r14.d = r12.getString("lepusType");
        r14.e = r12.getString("lepusFunction");
        goto L21
    L22:
        return r5;
    }
}
