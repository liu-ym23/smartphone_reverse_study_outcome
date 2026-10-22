package com.bytedance.android.live.browser;

import android.content.Context;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.jsbridge.newmethods.l1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.calendar.ICalendarManager;
import com.bytedance.bpea.basics.BPEAException;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ q a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ PublishSubject c;
    public final /* synthetic */ Fragment d;

    public static final class a implements ICalendarManager.IPermissionHandler {
        public final /* synthetic */ r a;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.r$a$a, reason: collision with other inner class name */
        public static final class C0128a<T> implements Predicate {
            public static final C0128a a = null;

            static {
                a = new C0128a();
            }

            public C0128a() {
            }

            public final boolean test(Object r2) {
                Pair r3 = (Pair) r2;
                Intrinsics.checkNotNullParameter(r3, "p");
                Integer r4 = (Integer) r3.first;
                if (r4 != null) goto L6;
            L8:
                return false;
            L6:
                if (r4.intValue() != 1000) goto L8;
                return true;
            }
        }

        public static final class b<T, R> implements Function {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final Object apply(Object r2) {
                Pair r3 = (Pair) r2;
                Intrinsics.checkNotNullParameter(r3, "p");
                return (int[]) r3.second;
            }
        }

        public static final class c<T> implements Predicate {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final boolean test(Object r2) {
                Pair r3 = (Pair) r2;
                Intrinsics.checkNotNullParameter(r3, "p");
                Integer r4 = (Integer) r3.first;
                if (r4 != null) goto L6;
            L8:
                return false;
            L6:
                if (r4.intValue() != 1000) goto L8;
                return true;
            }
        }

        public static final class d<T, R> implements Function {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }

            public final Object apply(Object r2) {
                Pair r3 = (Pair) r2;
                Intrinsics.checkNotNullParameter(r3, "p");
                return (int[]) r3.second;
            }
        }

        public final Single<int[]> requestCalendarPermission() {
            Single<int[]> r0 = this.a.c.filter(C0128a.a).map(b.a).firstOrError();
            Fragment r1 = this.a.d;     // Catch: BPEAException -> L8
            Object[] r2 = CollectionsKt.listOf(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}).toArray(new String[0]);     // Catch: BPEAException -> L8
            if (r2 == null) goto L7;
            g80.e.requestPermissions(r1, (String[]) r2, 1000, this.a.a.d);     // Catch: BPEAException -> L8
        L10:
            return r0;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: BPEAException -> L8
        L8:
            e = move-exception;
            ALogger.e("H5SERVICE", e);
            goto L10
        }

        public final Single<int[]> requestWriteCalendarPermission() {
            Single<int[]> r0 = this.a.c.filter(c.a).map(d.a).firstOrError();
            Fragment r1 = this.a.d;     // Catch: BPEAException -> L8
            Object[] r2 = CollectionsKt.listOf("android.permission.WRITE_CALENDAR").toArray(new String[0]);     // Catch: BPEAException -> L8
            if (r2 == null) goto L7;
            g80.e.requestPermissions(r1, (String[]) r2, 1000, this.a.a.e);     // Catch: BPEAException -> L8
        L10:
            return r0;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: BPEAException -> L8
        L8:
            e = move-exception;
            ALogger.e("H5SERVICE", e);
            goto L10
        }

        public a(r r1) {
            this.a = r1;
        }
    }

    public r(q r1, Context r2, PublishSubject r3, Fragment r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new l1(this.b, new a(this));
    }
}
