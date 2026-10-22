package r00;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.fh;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s00.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements s00.d {
    public LinkedList<b> a;
    public final HashSet<s00.c> b;
    public final HashSet<s00.c> c;
    public final Handler d;
    public final HashMap<r00.a, Long> e;
    public final CompositeDisposable f;
    public final HashMap<r00.a, ArrayList<Function0<Unit>>> g;
    public final String h;

    public static final class a implements Runnable {
        public final /* synthetic */ Throwable a;

        public a(Throwable r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        L3:
            throw new Exception(this.a);     // Catch: Throwable -> L4
        }
    }

    public final b d() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        b r1 = (b) r0.next();
        Iterator<T> r3 = r1.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L17;
        r00.a r4 = (r00.a) r3.next();
        Iterator<T> r5 = this.c.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((s00.c) r6).getName(), r4) == false) goto L10;
    L15:
        if (r6 != null) goto L7;
    L14:
        r6 = null;
        goto L15
    L17:
        return r1;
    L18:
        return null;
    }

    public final void f() {
        this.d.removeCallbacksAndMessages(null);
        this.f.clear();
        if (((Boolean) fh.a.getValue()).booleanValue() == false) goto L6;
        this.g.clear();
        return;
    }

    public final void g() {
        if (this.a.isEmpty() == false) goto L7;
        ALogger.i(this.h, "all task is completed.");
        return;
    L7:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        b r0 = d();
        if (r0 == null) goto L14;
        this.a.remove(r0);
        e(r0.a);
        return;
    L14:
        return;
    L12:
        this.d.post(new e(this));
    }

    public d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tagName");
        this.h = r2;
        this.a = new LinkedList();
        this.b = new HashSet();
        this.c = new HashSet();
        this.d = new Handler(Looper.getMainLooper());
        this.e = new HashMap();
        this.f = new CompositeDisposable();
        this.g = new HashMap();
    }

    @Override // s00.d
    public final void a(s00.b r4) {
        Intrinsics.checkNotNullParameter(r4, "stateTask");
        ALogger.i(this.h, r4.getName() + " is error.");
        this.b.remove(r4);
        this.c.add(r4);
    }

    @Override // s00.d
    public final void b(s00.c r4) {
        Intrinsics.checkNotNullParameter(r4, "stateTask");
        ALogger.i(this.h, r4.getName() + " is success.");
        this.b.remove(r4);
        this.c.add(r4);
        g();
    }

    public final void e(s00.c r11) {
        if ((r11 instanceof s00.b) == false) goto L33;
        if (r11 == null) goto L32;
        s00.b r12 = (s00.b) r11;
        long r4 = System.currentTimeMillis();
        this.e.put(r12.getName(), Long.valueOf(r4));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(r12.a(this));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r1);
        if (r6 == null) goto L17;
        ALogger.e(this.h, "run StateTask " + r12.getName() + " error. " + r6);
        SafetyGuard.a(null, r6, "LiveStateTaskExecutorError");
        if (v.a() == false) goto L16;
        MainThreadPostUtils.b(new c(r6));
    L16:
        r1 = new f.a();
    L17:
        f r2 = (f) r1;
        long r3 = System.currentTimeMillis();
        ALogger.i(this.h, "run state task " + r12.getName() + " spending " + (r3 - r4) + " ms, return " + r2.getClass().getSimpleName());
        if ((r2 instanceof f.b) == false) goto L26;
        if (this.c.contains(r12) == true) goto L22;
        this.b.add(r12);
        g();
    L22:
        Disposable r13 = r12.a;
        if (r13 == null) goto L54;
        RxUtilKt.c(r13, this.f);
        return;
    L54:
        return;
    L26:
        if ((r2 instanceof f.c) == false) goto L29;
        b(r12);
        return;
    L29:
        if ((r2 instanceof f.a) == false) goto L57;
        a(r12);
        g();
        return;
    L57:
        return;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.corepath.base.AbsPreviewStateTask");
    L33:
        long r5 = System.currentTimeMillis();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L36
        r11.run();     // Catch: Throwable -> L36
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r14 = Result.exceptionOrNull-impl(r9);
        if (r14 == null) goto L43;
        ALogger.e(this.h, "run task " + r11.getName() + " error. " + r14);
        SafetyGuard.a(null, r14, "LiveTaskExecutorError");
        if (v.a() == false) goto L43;
        MainThreadPostUtils.b(new a(r14));
    L43:
        long r15 = System.currentTimeMillis();
        ALogger.i(this.h, "run normal task " + r11.getName() + " spending " + (r15 - r5) + " ms.");
        if ((r11 instanceof s00.a) == false) goto L48;
        Disposable r16 = ((s00.a) r11).a;
        if (r16 == null) goto L48;
        this.f.add(r16);
    L48:
        this.b.remove(r11);
        this.c.add(r11);
        g();
        return;
    L36:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    }

    public final void c(List<? extends s00.c> r18, HashMap<s00.c, ArrayList<r00.a>> r19) {
        List r1 = r18;
        Intrinsics.checkNotNullParameter(r1, "list");
        String r3 = this.h;
        StringBuilder r4 = new StringBuilder("task size = ");
        ArrayList r5 = (ArrayList) r1;
        r4.append(r5.size());
        ALogger.i(r3, r4.toString());
        int r6 = com.bytedance.android.live.broadcast.corepath.util.a.a;
        Intrinsics.checkNotNullParameter(r1, "compConfigList");
        if (r19 == null) goto L51;
        if (r5.isEmpty() == true) goto L51;
        ArrayList r7 = new ArrayList();
        HashMap r8 = new HashMap();
        LinkedList r9 = new LinkedList();
        Iterator<T> r11 = r18.iterator();
    L8:
        int r12 = 0;
        if (r11.hasNext() == false) goto L21;
        s00.c r13 = (s00.c) r11.next();
        r00.a r14 = r13.getName();
        ArrayList<r00.a> r15 = r19.get(r13);
        if (r15 == null) goto L13;
        r12 = r15.size();
    L13:
        r8.put(r14, Integer.valueOf(r12));
        if (r19.get(r13) == null) goto L19;
        ArrayList<r00.a> r16 = r19.get(r13);
        if (r16 == null) goto L8;
        if (r16.isEmpty() != true) goto L8;
    L19:
        r9.add(r13);
    L21:
        if ((!r9.isEmpty()) == false) goto L42;
        s00.c r17 = (s00.c) r9.poll();
        if (r17 == null) goto L21;
        r7.add(r17);
        Iterator<T> r21 = r18.iterator();
    L26:
        if (r21.hasNext() == false) goto L21;
        s00.c r110 = (s00.c) r21.next();
        ArrayList<r00.a> r111 = r19.get(r110);
        if (r111 == null) goto L26;
        if (r111.contains(r17.getName()) != true) goto L26;
        r00.a r112 = r110.getName();
        Integer r113 = (Integer) r8.get(r112);
        if (r113 == null) goto L34;
        int r114 = r113.intValue() - 1;
    L35:
        r8.put(r112, Integer.valueOf(r114));
        Integer r115 = (Integer) r8.get(r112);
        if (r115 == null) goto L26;
        if (r115.intValue() != 0) goto L26;
        r9.add(r110);
        goto L26
    L34:
        r114 = 0;
        goto L35
    L42:
        if (r7.size() == r5.size()) goto L48;
        StringBuilder r22 = new StringBuilder("Error : + ");
        List r2 = CollectionsKt.minus(r1, r7);
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r24 = r2.iterator();
    L45:
        if (r24.hasNext() == false) goto L47;
        r23.add(((s00.c) r24.next()).getName());
        goto L45
    L47:
        r22.append(CollectionsKt.joinToString$default(r23, ", ", null, null, 0, null, null, 62, null));
        ALogger.e("topologicalSort", r22.toString());
    L49:
        r1 = r7;
        goto L51
    L48:
        ALogger.e("topologicalSort", "Success.");
    L51:
        if (r1.isEmpty() == false) goto L54;
        ALogger.i(this.h, "sortList is empty");
        return;
    L54:
        ALogger.i(this.h, "sorted task size = " + r1.size());
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r26 = r1.iterator();
    L56:
        if (r26.hasNext() == false) goto L63;
        s00.c r27 = (s00.c) r26.next();
        if (r19 == null) goto L61;
        ArrayList<r00.a> r28 = r19.get(r27);
        if (r28 == null) goto L61;
    L62:
        r25.add(new b(r27, r28));
    L61:
        r28 = new ArrayList();
        goto L62
    L63:
        this.a = new LinkedList(r25);
        g();
    }
}
