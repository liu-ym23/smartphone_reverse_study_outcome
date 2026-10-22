package com.bytedance.android.live.search.impl.search;

import android.content.SharedPreferences;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.search.impl.search.helper.LiveSearchSPHelper;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static Disposable a;
    public static String b;
    public static List<ra1.c> c;
    public static final f d = null;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ List a;

        public a(List r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<Object> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            String r6 = "search_history" + TTLiveSDK.hostService().user().getCurUserId();
            monitor-enter(f.class);
            Lazy r1 = LiveSearchSPHelper.a;     // Catch: Throwable -> L12
            List r2 = this.a;     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter(r6, "key");     // Catch: Throwable -> L12
            Intrinsics.checkNotNullParameter(r2, "value");     // Catch: Throwable -> L12
            SharedPreferences.Editor r3 = LiveSearchSPHelper.b;     // Catch: Throwable -> L12
            if (r3 == null) goto L9;
            SharedPreferences.Editor r7 = r3.putString(r6, GsonProtectorUtils.toJson(GsonHelper.get(), r2));     // Catch: Throwable -> L12
            if (r7 == null) goto L9;
            r7.commit();     // Catch: Throwable -> L12
        L9:
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(f.class);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public f() {
    }

    static {
        d = new f();
        b = DataType.FALSE;
        c = new ArrayList();
    }

    public static List a() {
        String r0 = TTLiveSDK.hostService().user().getCurUserId();
        if ((!Intrinsics.areEqual(b, r0)) == false) goto L22;
        String r1 = "search_history" + r0.toString();
        if (q0.a(b) == true) goto L11;
        Lazy r3 = LiveSearchSPHelper.a;
        String r2 = "search_history" + b;
        Intrinsics.checkNotNullParameter(r2, "key");
        ArrayList r4 = new ArrayList();
        SharedPreferences.Editor r5 = LiveSearchSPHelper.b;
        if (r5 == null) goto L11;
        SharedPreferences.Editor r6 = r5.putString(r2, GsonProtectorUtils.toJson(GsonHelper.get(), r4));
        if (r6 == null) goto L11;
        r6.commit();
    L11:
        Lazy r7 = LiveSearchSPHelper.a;
        Intrinsics.checkNotNullParameter(r1, "key");
        Type r8 = new com.bytedance.android.live.search.impl.search.helper.c().getType();     // Catch: Exception -> L18
        SharedPreferences r9 = (SharedPreferences) LiveSearchSPHelper.a.getValue();     // Catch: Exception -> L18
        if (r9 == null) goto L15;
        String r10 = r9.getString(r1, "");     // Catch: Exception -> L18
    L16:
        List<ra1.c> r12 = (List) GsonHelper.get().fromJson(r10, r8);     // Catch: Exception -> L18
    L20:
        c = r12;
        b = r0;
        goto L22
    L15:
        r10 = null;
    L18:
        e = move-exception;
        Logger.e("search_sp", "gson search sp failure " + e);
        r12 = new ArrayList();
    L22:
        return c;
    }

    public static void b(List r2) {
        c = r2;
        a = Observable.create(new a(r2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(b.a, c.a);
    }
}
