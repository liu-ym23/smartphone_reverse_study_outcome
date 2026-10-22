package gh7;

import com.obric.sva.sdk.data.ISmModel;
import dh7.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n implements b {
    public final Throwable a;
    public final String b;
    public final String c;
    public final Map<String, String> d;
    public final Map<String, String> e;
    public String f;
    public final String g;
    public String h;
    public Set<String> i;
    public List<String> j;

    public n() {
        throw null;
    }

    public n(Throwable r2, String r3, String r4, Map r5, Map r6, String r7, String r8, Set r9, List r10, int r11) {
        if ((r11 & 8) == 0) goto L6;
        r5 = new LinkedHashMap();
    L6:
        if ((r11 & 16) == 0) goto L9;
        r6 = new LinkedHashMap();
    L9:
        if ((r11 & 64) == 0) goto L12;
        r7 = "";
    L12:
        if ((r11 & 128) == 0) goto L15;
        r8 = "Unknown";
    L15:
        if ((r11 & ISmModel.VERSION_0100) == 0) goto L18;
        r9 = new LinkedHashSet();
    L18:
        if ((r11 & ISmModel.VERSION_0200) == 0) goto L20;
        r10 = new ArrayList();
    L20:
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = null;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
