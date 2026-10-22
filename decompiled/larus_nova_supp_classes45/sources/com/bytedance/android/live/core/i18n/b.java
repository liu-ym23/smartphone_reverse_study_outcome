package com.bytedance.android.live.core.i18n;

import android.text.TextUtils;
import androidx.room.Room;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.i18n.db.I18nDatabase;
import com.bytedance.common.utility.Logger;
import g22.e;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import w50.c;
import w50.d;
import w50.f;
import w50.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static e i;
    public static g22.b j;
    public final String a;
    public a b;
    public boolean c;
    public boolean d;
    public long e;
    public Map<String, String> f;
    public Disposable g;
    public Disposable h;

    public interface a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.core.i18n.b$b, reason: collision with other inner class name */
    public static class C0141b {
        public long a;
        public Map<String, String> b;

        public C0141b() {
        }
    }

    public final void a() {
        Logger.d("i18n_translation", "query translations");
        if (this.c == false) goto L6;
        Logger.d("i18n_translation", "is querying, return");
        return;
    L6:
        this.c = true;
        this.g = Flowable.fromCallable(new w50.b(this)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(this), new d(this));
    }

    public b(String r2, com.bytedance.android.live.core.i18n.a.b r3) {
        this.a = r2;
        this.b = r3;
        if (i != null) goto L6;
        I18nDatabase r4 = Room.databaseBuilder(s1.getContext().getApplicationContext(), I18nDatabase.class, "i18n_live").build();
        i = r4.d();
        j = r4.c();
        return;
    }

    public final void b(final long r3, final Map<String, String> r5) {
        Logger.d("i18n_translation", "update translations in db");
        if (TextUtils.isEmpty(this.a) == true) goto L15;
        if (r5 == null) goto L15;
        if (r5.isEmpty() == true) goto L15;
        if (this.d == false) goto L12;
        this.e = r3;
        this.f = r5;
        Logger.d("i18n_translation", "is updating, saved as cache and return");
        return;
    L12:
        this.d = true;
        this.h = Flowable.fromCallable(new w50.e(this, r5, r3)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new f(this), new g(this));
        return;
    L15:
        if (TextUtils.isEmpty(this.a) == false) goto L17;
        Logger.e("i18n_translation", "locale is empty, return");
        return;
    L17:
        Logger.e("i18n_translation", "translation map is empty, return");
    }
}
