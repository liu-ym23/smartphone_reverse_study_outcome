package x2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.frameworks.baselib.network.http.util.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f13490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f13492c = null;

    static {
        f13492c = new ReentrantReadWriteLock();
    }

    private c() {
    }

    public static c b() {
        if (f13490a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13490a != null) goto L9;
        f13490a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f13490a;
    }

    private List<n4.b> c(n4.c r10, d r11, b r12) {
        ArrayList r13 = null;
        if (r10 == null) goto L40;
        if (r11 == null) goto L40;
        if (r12 == null) goto L40;
        if (com.bytedance.common.utility.collection.a.a(r11.f13496d) == false) goto L12;
        if (r11.f13495c != null) goto L12;
    L13:
        return null;
    L12:
        if (r11.f13495c.isEmpty() == true) goto L13;
        ArrayList r14 = new ArrayList();
        HashSet r15 = new HashSet();
        if (com.bytedance.common.utility.collection.a.a(r11.f13496d) == true) goto L25;
        if (r10.v().isEmpty() == true) goto L25;
        Iterator<String> r16 = r11.f13496d.iterator();
    L20:
        if (r16.hasNext() == false) goto L25;
        String r17 = r16.next();
        List<n4.b> r18 = r10.H(r17);
        if (r18 == null) goto L20;
        r14.addAll(r18);
        r15.add(r17);
    L25:
        if (r15.isEmpty() == true) goto L27;
        r12.f13488d = r15;
        r13 = new ArrayList(r10.v());
        r13.removeAll(r14);
    L27:
        Map<String, String> r19 = r11.f13495c;
        if (r19 == null) goto L40;
        if (r19.isEmpty() == true) goto L40;
        if (r13 != null) goto L33;
        r13 = new ArrayList(r10.v());
    L33:
        HashSet r20 = new HashSet();
        Iterator<Map.Entry<String, String>> r21 = r11.f13495c.entrySet().iterator();
    L35:
        if (r21.hasNext() == false) goto L38;
        Map.Entry<String, String> r22 = r21.next();
        r13.add(new n4.b(r22.getKey(), r22.getValue()));
        r20.add(r22.getKey());
        goto L35
    L38:
        if (r20.isEmpty() == true) goto L40;
        r12.f13487c = r20;
    L40:
        return r13;
    }

    private void d(Map<String, List<String>> r10, d r11, b r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L45;
        if (r11 == null) goto L46;
        if (r12 != null) goto L9;
        return;
    L9:
        if (com.bytedance.common.utility.collection.a.a(r11.f13494b) == true) goto L26;
        HashSet r13 = new HashSet();
        Iterator<String> r14 = r11.f13494b.iterator();
    L12:
        if (r14.hasNext() == false) goto L24;
        String r15 = r14.next();
        String r16 = URLDecoder.decode(r15, "UTF-8");     // Catch: UnsupportedEncodingException -> L20
        if (TextUtils.isEmpty(r16) == true) goto L12;
        if (r10.containsKey(r16) == false) goto L12;
        r10.remove(r16);
        r13.add(r15);
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L24:
        if (r13.isEmpty() == true) goto L26;
        r12.f13486b = r13;
    L26:
        HashSet r17 = new HashSet();
        Iterator<Map.Entry<String, String>> r18 = r11.f13493a.entrySet().iterator();
    L28:
        if (r18.hasNext() == false) goto L31;
        Map.Entry<String, String> r19 = r18.next();
        r10.put(r19.getKey(), Collections.singletonList(r19.getValue()));
        r17.add(r19.getKey());
        goto L28
    L31:
        if (r17.isEmpty() == true) goto L47;
        r12.f13485a = r17;
        return;
    L47:
        return;
    L46:
        return;
    }

    public static void e(JSONObject r10) {
        ReentrantReadWriteLock r11 = f13492c;     // Catch: Throwable -> L16
        r11.writeLock().lock();     // Catch: Throwable -> L16
        a r12 = new a();     // Catch: Throwable -> L16
        f13491b = r12;     // Catch: Throwable -> L16
        if (r10 != null) goto L7;
        r11.writeLock().unlock();
        return;
    L7:
        if (r12.h(r10) == true) goto L9;
        f13491b.i(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<l2.a, d>> r13 = f13491b.c();     // Catch: Throwable -> L16
        if (r13 != null) goto L12;
    L13:
        f13491b.i(false);     // Catch: Throwable -> L16
    L14:
        r11.writeLock().unlock();
        return;
    L12:
        if (r13.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        f13492c.writeLock().unlock();
        throw th;
    }

    public String a(String r10, n4.c r11, b r12, List<n4.b> r13) {
        LinkedHashMap r14 = new LinkedHashMap();
        Pair<String, String> r15 = null;
        ReentrantReadWriteLock r16 = f13492c;     // Catch: Throwable -> L16
        r16.readLock().lock();     // Catch: Throwable -> L16
        a r17 = f13491b;     // Catch: Throwable -> L16
        if (r17 != null) goto L6;
    L10:
        r16.readLock().unlock();
        return r10;
    L6:
        if (r17.d() == false) goto L10;
        d r18 = f13491b.b(r10);     // Catch: Throwable -> L16
        if (r18 == null) goto L10;
        r15 = k.k(r10, r14);     // Catch: Throwable -> L16
        d(r14, r18, r12);     // Catch: Throwable -> L16
        List<n4.b> r19 = c(r11, r18, r12);     // Catch: Throwable -> L16
        if (com.bytedance.common.utility.collection.a.a(r19) == true) goto L15;
        r13.addAll(r19);     // Catch: Throwable -> L16
    L15:
        ReentrantReadWriteLock.ReadLock r20 = r16.readLock();
    L19:
        r20.unlock();
        if (r15 != null) goto L51;
        return r10;
    L51:
        j r21 = new j(((String) r15.first) + ((String) r15.second));     // Catch: Throwable -> L45
        if (r14.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, List<String>>> r22 = r14.entrySet().iterator();     // Catch: Throwable -> L45
    L26:
        if (r22.hasNext() == false) goto L41;
        Map.Entry<String, List<String>> r23 = r22.next();     // Catch: Throwable -> L45
        if (r23 == null) goto L26;
        if (TextUtils.isEmpty(r23.getKey()) == true) goto L26;
        List<String> r24 = r23.getValue();     // Catch: Throwable -> L45
        if (r24 == null) goto L26;
        if (r24.isEmpty() == true) goto L26;
        Iterator<String> r25 = r24.iterator();     // Catch: Throwable -> L45
    L39:
        if (r25.hasNext() == false) goto L26;
        r21.b(r23.getKey(), r25.next());     // Catch: Throwable -> L45
    L41:
        String r26 = r21.c();     // Catch: Throwable -> L45
        String r27 = Uri.parse(r10).getEncodedFragment();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r27) == true) goto L68;
        return r26 + "#" + r27;
    L68:
        return r26;
    L45:
        return r10;
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L46
        r20 = f13492c.readLock();
    L46:
        th = move-exception;
        f13492c.readLock().unlock();
        throw th;
    }
}
