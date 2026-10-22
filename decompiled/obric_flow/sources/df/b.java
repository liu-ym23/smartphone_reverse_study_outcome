package df;

import com.bytedance.geckox.IGeckoLowStorageConfig;
import com.bytedance.geckox.model.Resources;
import com.bytedance.iesgurd.settings.SettingsExtra;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f16644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f16645b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f16646c;
    public static boolean d;
    public static int e;
    public static int f;
    public static List g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f16647h = null;

    static {
        f16647h = new b();
        new ConcurrentHashMap();
        f16644a = new ConcurrentHashMap();
        f16645b = new ConcurrentHashMap();
        d = true;
        e = -1;
        f = -1;
    }

    public final synchronized List a() {
        monitor-enter(this);
        List r5 = g;     // Catch: Throwable -> L10
        if (r5 == null) goto L7;
        monitor-exit(this);
        return r5;
    L7:
        SettingsExtra r10 = com.bytedance.iesgurd.settings.d.f6697j;     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        g = r10.getNoLocalAk();     // Catch: Throwable -> L10
    L12:
        List r11 = g;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Pair b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f16646c == false) goto L11;
        Pair r5 = new Pair(Integer.valueOf(e), Integer.valueOf(f));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L11:
        if (d == false) goto L89;
        ServiceManager r10 = ServiceManager.a();     // Catch: Throwable -> L8
        IGeckoLowStorageConfig r11 = (IGeckoLowStorageConfig) r10.a(IGeckoLowStorageConfig.class, r10.f16217b, true);     // Catch: Throwable -> L8
        if (r11 == null) goto L89;
        e = r11.getLowStorageAvailable();     // Catch: Throwable -> L8
        f = r11.getSensitiveStorageAvailable();     // Catch: Throwable -> L8
        if (e == (-1)) goto L51;
        f16646c = true;     // Catch: Throwable -> L8
        Map<String, Resources> r12 = r11.getLowStorageWhiteList();     // Catch: Throwable -> L8
        if (r12 == null) goto L51;
        Set<Map.Entry<String, Resources>> r13 = r12.entrySet();     // Catch: Throwable -> L8
        if (r13 == null) goto L51;
        Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L8
    L22:
        if (r14.hasNext() == false) goto L51;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L8
        String r16 = (String) r15.getKey();     // Catch: Throwable -> L8
        Resources r17 = (Resources) r15.getValue();     // Catch: Throwable -> L8
        if (r17 == null) goto L32;
        List<String> r18 = r17.getGroups();     // Catch: Throwable -> L8
        if (r18 == null) goto L32;
        Object[] r19 = r18.toArray(new String[0]);     // Catch: Throwable -> L8
        if (r19 == null) goto L31;
        String[] r20 = (String[]) r19;     // Catch: Throwable -> L8
    L33:
        Resources r21 = (Resources) r15.getValue();     // Catch: Throwable -> L8
        if (r21 == null) goto L42;
        List<String> r22 = r21.getChannels();     // Catch: Throwable -> L8
        if (r22 == null) goto L42;
        Object[] r23 = r22.toArray(new String[0]);     // Catch: Throwable -> L8
        if (r23 == null) goto L41;
        String[] r24 = (String[]) r23;     // Catch: Throwable -> L8
    L43:
        ConcurrentHashMap r25 = f16644a;     // Catch: Throwable -> L8
        Resources r110 = (Resources) r25.get(r16);     // Catch: Throwable -> L8
        if (r110 != null) goto L46;
        r110 = new Resources();     // Catch: Throwable -> L8
        r25.put(r16, r110);     // Catch: Throwable -> L8
    L46:
        if (r20 == null) goto L48;
        r110.setGroups(ArraysKt.asList(r20));     // Catch: Throwable -> L8
    L48:
        if (r24 == null) goto L22;
        r110.setChannels(ArraysKt.asList(r24));     // Catch: Throwable -> L8
        goto L22
    L41:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L8
    L42:
        r24 = null;
        goto L43
    L31:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L8
    L32:
        r20 = null;
    L51:
        if (f == (-1)) goto L86;
        f16646c = true;     // Catch: Throwable -> L8
        Map<String, Resources> r26 = r11.getSensitiveStorageBlockList();     // Catch: Throwable -> L8
        if (r26 == null) goto L86;
        Set<Map.Entry<String, Resources>> r27 = r26.entrySet();     // Catch: Throwable -> L8
        if (r27 == null) goto L86;
        Iterator<T> r28 = r27.iterator();     // Catch: Throwable -> L8
    L58:
        if (r28.hasNext() == false) goto L86;
        Map.Entry r29 = (Map.Entry) r28.next();     // Catch: Throwable -> L8
        String r30 = (String) r29.getKey();     // Catch: Throwable -> L8
        Resources r31 = (Resources) r29.getValue();     // Catch: Throwable -> L8
        if (r31 == null) goto L68;
        List<String> r32 = r31.getGroups();     // Catch: Throwable -> L8
        if (r32 == null) goto L68;
        Object[] r33 = r32.toArray(new String[0]);     // Catch: Throwable -> L8
        if (r33 == null) goto L67;
        String[] r34 = (String[]) r33;     // Catch: Throwable -> L8
    L69:
        Resources r35 = (Resources) r29.getValue();     // Catch: Throwable -> L8
        if (r35 == null) goto L78;
        List<String> r36 = r35.getChannels();     // Catch: Throwable -> L8
        if (r36 == null) goto L78;
        Object[] r37 = r36.toArray(new String[0]);     // Catch: Throwable -> L8
        if (r37 == null) goto L77;
        String[] r38 = (String[]) r37;     // Catch: Throwable -> L8
    L79:
        ConcurrentHashMap r39 = f16645b;     // Catch: Throwable -> L8
        Resources r40 = (Resources) r39.get(r30);     // Catch: Throwable -> L8
        if (r40 != null) goto L82;
        r40 = new Resources();     // Catch: Throwable -> L8
        r39.put(r30, r40);     // Catch: Throwable -> L8
    L82:
        if (r34 == null) goto L84;
        r40.setGroups(ArraysKt.asList(r34));     // Catch: Throwable -> L8
    L84:
        if (r38 == null) goto L58;
        r40.setChannels(ArraysKt.asList(r38));     // Catch: Throwable -> L8
        goto L58
    L77:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L8
    L78:
        r38 = null;
        goto L79
    L67:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L8
    L68:
        r34 = null;
    L86:
        Pair r41 = new Pair(Integer.valueOf(e), Integer.valueOf(f));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r41;
    L89:
        d = false;     // Catch: Throwable -> L8
        com.bytedance.geckox.c r42 = com.bytedance.geckox.b.f4736a;     // Catch: Throwable -> L8
        Pair r43 = new Pair(-1, -1);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r43;
    }
}
