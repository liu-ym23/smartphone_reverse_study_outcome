package com.bytedance.android.live.core.i18n;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Query;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class I18nUpdateManager {
    public static final long[] i = null;
    public static I18nApi j;
    public final String a;
    public final Handler b;
    public f c;
    public boolean d;
    public int e;
    public long f;
    public long g;
    public Disposable h;

    public interface I18nApi {
        @GET("/webcast/setting/i18n/package/")
        Observable<Response<w50.a>> update(@Query("locale") String r1, @Query("cur_version") long r2, @Header("x-tt-request-tag") String r4);
    }

    public class a implements Handler.Callback {
        public final /* synthetic */ I18nUpdateManager a;

        public a(I18nUpdateManager r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r3) {
            if (r3.what == 0) goto L6;
            return false;
        L6:
            I18nUpdateManager r4 = this.a;
            r4.update(r4.g);
            return true;
        }
    }

    public class b extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public b() {
        }
    }

    public class c implements Consumer<Response<w50.a>> {
        public final /* synthetic */ I18nUpdateManager a;

        public c(I18nUpdateManager r1) {
            this.a = r1;
        }

        public final void accept(Object r9) throws Exception {
            Response r11 = (Response) r9;
            I18nUpdateManager r0 = this.a;
            r0.d = false;
            if (r11 != null) goto L5;
        L39:
            I18nUpdateManager.a(r0, new Throwable("response == null || response.statusCode != 0 || response.data == null"));
            return;
        L5:
            if (((BaseResponse) r11).statusCode != 0) goto L39;
            if (((BaseResponse) r11).data == null) goto L39;
            Logger.d("i18n_translation", "update on success");
            I18nUpdateManager r2 = this.a;
            r2.e = 0;
            r2.f = SystemClock.elapsedRealtime();
            w50.a r12 = (w50.a) ((BaseResponse) r11).data;
            I18nUpdateManager r1 = this.a;
            f r3 = r1.c;
            if (r3 == null) goto L41;
            String r4 = r1.a;
            long r5 = r12.latestVersion;
            Map<String, String> r13 = r12.fullPackage;
            com.bytedance.android.live.core.i18n.a.C0140a r6 = (com.bytedance.android.live.core.i18n.a.C0140a) r3;
            if (TextUtils.isEmpty(r4) == true) goto L36;
            if (TextUtils.equals(r4, r6.a.a) == false) goto L36;
            com.bytedance.android.live.core.i18n.a r7 = r6.a;
            if (r5 != r7.b) goto L24;
            Map<String, String> r14 = r7.c;
            if (r14 != null) goto L21;
        L23:
            Logger.d("i18n_translation", "version from api is lower than or equals with version in memory");
            return;
        L21:
            if (r14.isEmpty() == false) goto L23;
            r6.a.f.a();
            goto L23
        L24:
            if (r13 != null) goto L26;
        L29:
            Map<String, String> r15 = r6.a.c;
            if (r15 != null) goto L32;
        L34:
            Logger.d("i18n_translation", "translations from api is empty, no need process");
            return;
        L32:
            if (r15.isEmpty() == false) goto L34;
            r6.a.f.a();
            goto L34
        L26:
            if (r13.isEmpty() == true) goto L29;
            com.bytedance.android.live.core.i18n.a r8 = r6.a;
            r8.b = r5;
            r8.c = r13;
            Logger.d("i18n_translation", "on api result, update translationMap in memory, version is " + r6.a.b);
            r6.a.f.b(r5, r13);
            return;
        L36:
            if (TextUtils.isEmpty(r4) == false) goto L38;
            Logger.e("i18n_translation", "locale is not matched on api result, locale in result is empty");
            return;
        L38:
            Logger.e("i18n_translation", "locale is not matched on api result, locale in result is " + r4);
            return;
        }
    }

    public class d implements Consumer<Throwable> {
        public final /* synthetic */ I18nUpdateManager a;

        public d(I18nUpdateManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) throws Exception {
            I18nUpdateManager r0 = this.a;
            r0.d = false;
            I18nUpdateManager.a(r0, (Throwable) r3);
        }
    }

    public class e implements Action {
        public final /* synthetic */ I18nUpdateManager a;

        public final void run() throws Exception {
            this.a.d = false;
        }

        public e(I18nUpdateManager r1) {
            this.a = r1;
        }
    }

    public interface f {
    }

    static {
        i = new long[]{3000, 6000, 9000, 60000, 60000, 60000, 600000};
    }

    public void update(long r7) {
        Logger.d("i18n_translation", "update is called, current version is " + r7);
        if (this.d == true) goto L20;
        if (this.b.hasMessages(0) == true) goto L20;
        long r2 = SystemClock.elapsedRealtime();
        long r4 = this.f;
        if (r2 > r4) goto L10;
    L13:
        this.g = r7;
        this.d = true;
        if (tb1.c.a == false) goto L16;
        String r0 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new b()).second;
    L17:
        this.h = j.update(this.a, r7, r0).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(this), new d(this), new e(this));
        return;
    L16:
        r0 = "";
        goto L17
    L10:
        if ((r2 - r4) >= 60000) goto L13;
        Logger.d("i18n_translation", "in freeze time, quit update");
        return;
    L20:
        if (this.d == false) goto L22;
        Logger.d("i18n_translation", "now is downloading, quit update");
        return;
    L22:
        Logger.d("i18n_translation", "now is waiting for retry, quit update");
    }

    public I18nUpdateManager(String r3, com.bytedance.android.live.core.i18n.a.C0140a r4) {
        a r0 = new a(this);
        this.h = null;
        this.a = r3;
        this.c = r4;
        this.b = new Handler(Looper.getMainLooper(), r0);
        if (j != null) goto L6;
        j = (I18nApi) com.bytedance.android.live.network.c.b().e(I18nApi.class);
        return;
    }

    public static void a(I18nUpdateManager r3, Throwable r4) {
        r3.getClass();
        Logger.e("i18n_translation", "update on error: " + r4.toString());
        int r5 = r3.e + 1;
        r3.e = r5;
        Handler r6 = r3.b;
        long[] r0 = i;
        if (r5 >= 7) goto L7;
        if (r5 < 0) goto L7;
        long r1 = r0[r5];
    L8:
        r6.sendEmptyMessageDelayed(0, r1);
        return;
    L7:
        r1 = r0[6];
        goto L8
    }
}
