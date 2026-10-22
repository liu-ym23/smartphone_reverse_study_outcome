package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.graphics.BitmapFactory;
import android.util.Base64;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w0 extends BaseOpenMethod<JSONObject> {
    public Disposable h;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<JSONObject> r9) {
            Intrinsics.checkNotNullParameter(r9, "it");
            URL r0 = new URL(this.a);
            String r4 = r0.getHost();     // Catch: Throwable -> L8 IOException -> L19
            String r5 = r0.getPath();     // Catch: Throwable -> L8 IOException -> L19
            if (com.obric.assistant.network.okhttp.a.c(r4, r5) == false) goto L10;
            FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r4 + " path=" + r5);     // Catch: Throwable -> L8 IOException -> L19
            com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r4, r5), r4, r5);     // Catch: Throwable -> L8 IOException -> L19
            throw new IOException("[NetGuard] dropped " + r0);     // Catch: Throwable -> L8 IOException -> L19
        L10:
            URLConnection r1 = r0.openConnection();
            if (r1 == null) goto L18;
            HttpURLConnection r2 = (HttpURLConnection) r1;
            r2.connect();
            int r3 = r2.getResponseCode();
            int r6 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("SecretOpenAvatarMethod", new Object[]{"response code: " + r3});
            if ((r3 / 100) != 2) goto L15;
            byte[] r7 = u10.d.a(r2.getInputStream());
            BitmapFactory.Options r8 = new BitmapFactory.Options();
            r8.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(r7, 0, r7.length, r8);
            JSONObject r11 = new JSONObject();
            r11.put("data", Base64.encodeToString(r7, 2));
            r11.put("width", r8.outWidth);
            r11.put("height", r8.outHeight);
            r9.onNext(r11);
            r9.onComplete();
            return;
        L15:
            r9.onError(new NetworkErrorException(r3, "network error"));
            return;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        L19:
            e = move-exception;
            throw e;
        L8:
            th = move-exception;
            FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ w0 a;

        public c(w0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            w0 r0 = this.a;
            r0.r((JSONObject) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ w0 a;

        public d(w0 r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Throwable r7 = (Throwable) r6;
            if ((r7 instanceof SocketTimeoutException) == false) goto L5;
        L10:
            int r0 = x10.e.a;
            x10.e.a(this.a.d, 100002, r7.toString(), "/drawOpenAvatar/", null);
        L11:
            this.a.o(r7);
            return;
        L5:
            if ((r7 instanceof IOException) == true) goto L10;
            if ((r7 instanceof NetworkErrorException) == false) goto L11;
            int r1 = x10.e.a;
            x10.e.a(this.a.d, ((NetworkErrorException) r7).statusCode, r7.getMessage(), "/drawOpenAvatar/", null);
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "drawOpenAvatar";
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final void l() {
        super.l();
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        r0.dispose();
        return;
    }

    public w0(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r4, CallContext r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r6 = r4.optString("src");
        String r7 = ((BootInfoService) this.d.o(BootInfoService.class)).b(r6);
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("SecretOpenAvatarMethod", new Object[]{"src: ", r6, ", decryptSrc: ", r7});
        this.h = Observable.create(new b(r7)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
