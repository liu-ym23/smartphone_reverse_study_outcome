package y9;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements o {
    public static boolean a;
    public static final PublishSubject<Boolean> b = null;
    public static final PublishSubject<Boolean> c = null;

    public static final class a {
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ SharedPreferences a;
        public final /* synthetic */ JsonObject b;

        public b(SharedPreferences r1, JsonObject r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            SharedPreferences.Editor r0 = this.a.edit();
            r0.putString("annie_setting_from_server_key", this.b.toString());
            return Boolean.valueOf(r0.commit());
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r10) {
            Boolean r11 = (Boolean) r10;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.booleanValue() == false) goto L7;
            j.a = true;
        L7:
            j.b.onNext(r11);
        }
    }

    public static final class d<V> implements Callable {
        public final /* synthetic */ SharedPreferences a;
        public final /* synthetic */ JsonObject b;

        public d(SharedPreferences r1, JsonObject r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            SharedPreferences.Editor r0 = this.a.edit();
            r0.putString("annie_setting_from_server_key", this.b.toString());
            return Boolean.valueOf(r0.commit());
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r10) {
            Boolean r11 = (Boolean) r10;
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.booleanValue() == false) goto L7;
            j.a = true;
        L7:
            j.c.onNext(r11);
        }
    }

    public j() {
    }

    static {
        b = PublishSubject.create();
        c = PublishSubject.create();
    }

    @Override // y9.o
    public final void G(Context r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "settings");
        if (a == true) goto L8;
        SharedPreferences r12 = r10.getSharedPreferences("annie_setting_sp", 0);
        if (r12 == null) goto L9;
        Observable.fromCallable(new d(r12, r11)).subscribeOn(Schedulers.io()).subscribe(e.a);
        return;
    L9:
        return;
    }

    @Override // y9.o
    public final void x1(Context r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "settings");
        if (a == true) goto L8;
        SharedPreferences r12 = r10.getSharedPreferences("annie_setting_sp", 0);
        if (r12 == null) goto L9;
        Observable.fromCallable(new b(r12, r11)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(c.a);
        return;
    L9:
        return;
    }

    @Override // y9.o
    public final void D0(Context r10, String r11, String r12, Type r13) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r13, "type");
        h.e(r10, r11, r12, r13);
    }
}
