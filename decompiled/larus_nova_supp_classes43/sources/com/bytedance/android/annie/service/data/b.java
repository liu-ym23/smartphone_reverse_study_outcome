package com.bytedance.android.annie.service.data;

import com.bytedance.android.annie.api.data.subscribe.e;
import com.bytedance.android.annie.api.data.subscribe.g;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;
    public static final Map<String, g<?>> b = null;
    public static final Map<Character, Integer> c = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e<T> a;

        public a(e<T> r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Disposable r10 = (Disposable) r1;
            b r11 = b.a;
            b.b(this.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.data.b$b, reason: collision with other inner class name */
    public static final class C0081b implements Action {
        public final /* synthetic */ e<T> a;

        public C0081b(e<T> r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.onRelease();
            b.a.d(this.a);
        }
    }

    public b() {
    }

    static {
        a = new b();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public static g a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return (g) ((ConcurrentHashMap) b).get(r1);
    }

    public static void b(g r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        int r0 = x8.a.a;
        StringBuilder r1 = new StringBuilder("register data provider, key:");
        r1.append(r10.key());
        r1.append(", split: ");
        r1.append(r10.d());
        r1.append(", hasExist: ");
        Map<String, g<?>> r11 = b;
        ConcurrentHashMap r12 = (ConcurrentHashMap) r11;
        r1.append(r12.containsKey(r10.key()));
        x8.a.d("DataShareRegisterCenter", r1.toString(), false);
        r12.put(r10.key(), r10);
        Map<Character, Integer> r13 = c;
        ConcurrentHashMap r14 = (ConcurrentHashMap) r13;
        Integer r15 = (Integer) r14.get(Character.valueOf(r10.d()));
        if (r15 == null) goto L5;
        int r16 = r15.intValue();
        r14.put(Character.valueOf(r10.d()), Integer.valueOf(r16 + 1));
        return;
    L5:
        r14.put(Character.valueOf(r10.d()), 1);
    }

    public final synchronized <T> Observable<Unit> c(e<T> r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "state");     // Catch: Throwable -> L6
        Observable<Unit> r11 = Observable.empty().doOnSubscribe(new a(r10)).doOnDispose(new C0081b(r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(e r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "state");     // Catch: Throwable -> L15
        int r1 = x8.a.a;     // Catch: Throwable -> L15
        StringBuilder r11 = new StringBuilder("unregister data provider, key:");     // Catch: Throwable -> L15
        r11.append(r10.key());     // Catch: Throwable -> L15
        r11.append(", split: ");     // Catch: Throwable -> L15
        r11.append(r10.d());     // Catch: Throwable -> L15
        r11.append(", hashcode: ");     // Catch: Throwable -> L15
        r11.append(r10.hashCode());     // Catch: Throwable -> L15
        r11.append(", hasExist: ");     // Catch: Throwable -> L15
        Map<String, g<?>> r0 = b;     // Catch: Throwable -> L15
        ConcurrentHashMap r12 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L15
        r11.append(r12.containsKey(r10.key()));     // Catch: Throwable -> L15
        x8.a.d("DataShareRegisterCenter", r11.toString(), false);     // Catch: Throwable -> L15
        ConcurrentHashMap r13 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r13.get(r10.key()), r10) == false) goto L7;
        ConcurrentHashMap r14 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L15
        r14.remove(r10.key());     // Catch: Throwable -> L15
    L7:
        Map<Character, Integer> r15 = c;     // Catch: Throwable -> L15
        ConcurrentHashMap r16 = (ConcurrentHashMap) r15;     // Catch: Throwable -> L15
        Integer r17 = (Integer) r16.get(Character.valueOf(r10.d()));     // Catch: Throwable -> L15
        if (r17 == null) goto L13;
        int r18 = r17.intValue();     // Catch: Throwable -> L15
        if (r18 <= 1) goto L12;
        ConcurrentHashMap r19 = (ConcurrentHashMap) r15;     // Catch: Throwable -> L15
        r19.put(Character.valueOf(r10.d()), Integer.valueOf(r18 - 1));     // Catch: Throwable -> L15
        goto L13
    L12:
        ConcurrentHashMap r20 = (ConcurrentHashMap) r15;     // Catch: Throwable -> L15
        r20.remove(Character.valueOf(r10.d()));     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
