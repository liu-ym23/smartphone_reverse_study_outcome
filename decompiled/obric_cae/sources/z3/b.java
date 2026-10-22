package z3;

import android.text.TextUtils;
import c4.e;
import c4.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b implements z3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o4.c f14196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y3.c f14197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile c f14198d;

    public class a implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y3.c f14199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o4.c f14200b;

        public a(y3.c r8, o4.c r10) {
            this.f14199a = r8;
            this.f14200b = r10;
        }

        @Override // c4.e.b
        public final JSONObject a() {
            JSONObject r8 = new JSONObject();
            r8.put("appId", this.f14199a.f13937m.f11401i);     // Catch: Throwable -> L5
            r8.put("config", this.f14200b.f9653c);     // Catch: Throwable -> L5
        L4:
            return r8;
        }
    }

    public b(y3.c r8, o4.c r10) {
        this.f14198d = null;
        this.f14197c = r8;
        this.f14196b = r10;
        if (l.b() == true) goto L6;
        l.c("sampling_config", new a(r8, r10));
        return;
    }

    @Override // z3.a
    public final boolean a() {
        return !(!this.f14196b.f9655e.isEmpty());
    }

    @Override // z3.a
    public final boolean b(e4.a r8, String r10, String r11) {
        if (e4.a.f7116b.equals(r8) == false) goto L5;
    L7:
        o4.c r12 = this.f14196b;
        if (this.f14198d != null) goto L11;
        this.f14198d = new c(this);
    L11:
        c r13 = this.f14198d;
        Iterator r14 = r12.f9655e.iterator();
    L13:
        if (r14.hasNext() == false) goto L48;
        o4.a r15 = (o4.a) r14.next();
        r15.getClass();
        if (TextUtils.isEmpty(r10) == true) goto L35;
        Set<String> r16 = r15.f9648b;
        if (r16 == null) goto L23;
        if (r16.contains(r10) == false) goto L23;
        boolean r17 = true;
    L36:
        if (r17 == false) goto L13;
        return r15.c(r13);
    L23:
        if (TextUtils.isEmpty(r11) == true) goto L35;
        Map<String, List<Set<String>>> r18 = r15.f9649c;
        if (r18 != null) goto L28;
    L29:
        Map<String, List<Map<String, Object>>> r19 = r15.f9650d;
        if (r19 == null) goto L35;
        if (r19.containsKey(r10) == false) goto L35;
    L40:
        r17 = r15.b(r10, new JSONObject(r11));     // Catch: Throwable -> L39
    L28:
        if (r18.containsKey(r10) == true) goto L40;
    L35:
        r17 = false;
        goto L36
    L48:
        return false;
    L5:
        if (e4.a.f7117m.equals(r8) == true) goto L7;
        return false;
    }
}
