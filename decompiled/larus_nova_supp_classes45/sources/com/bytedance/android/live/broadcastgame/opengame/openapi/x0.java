package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Base64;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x0 extends BaseOpenMethod<JSONObject> {
    public Disposable h;

    public static final class a {
    }

    public static final class b<T> implements ObservableOnSubscribe {
        public final /* synthetic */ x0 a;
        public final /* synthetic */ JSONObject b;

        public b(x0 r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<JSONObject> r11) {
            Intrinsics.checkNotNullParameter(r11, "it");
            String r0 = this.b.optString("src");
            int r1 = this.b.optInt("fontSize", 12);
            String r2 = this.b.optString("color");
            String r3 = ((BootInfoService) this.a.d.o(BootInfoService.class)).b(r0);
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            int r4 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("SecretOpenNickNameMethod", new Object[]{"src: ", r0, ", decryptSrc: ", r3});
            Paint r5 = new Paint();
            r5.setTextSize(s1.f(r1));
            r5.setFlags(1);
            int r6 = Color.parseColor(r2);     // Catch: Exception -> L8
        L9:
            r5.setColor(r6);
            Paint.FontMetrics r7 = r5.getFontMetrics();
            int r8 = (int) (r7.bottom - r7.top);
            int r9 = (int) r5.measureText(r3);
            if (r9 <= 0) goto L16;
            if (r8 <= 0) goto L16;
            Bitmap r12 = Bitmap.createBitmap(r9, r8, Bitmap.Config.ARGB_8888);
            new Canvas(r12).drawText(r3, 0.0f, r8 - r5.getFontMetrics().bottom, r5);
            ByteArrayOutputStream r13 = new ByteArrayOutputStream();
            r12.compress(Bitmap.CompressFormat.PNG, 100, r13);
            r13.flush();
            byte[] r14 = r13.toByteArray();
            JSONObject r15 = new JSONObject();
            r15.put("width", Float.valueOf(s1.G(r9)));
            r15.put("height", Float.valueOf(s1.G(r8)));
            r15.put("data", Base64.encodeToString(r14, 2));
            r11.onNext(r15);
            r11.onComplete();
            r13.close();
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L20;
            PolarisFileOutputStreamWrapper r16 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(this.a.d.getContext().getExternalFilesDir(null), "test.jpg"));
            r16.write(r14);
            r16.flush();
            r16.close();
            return;
        L20:
            return;
        L16:
            r11.onError(new Throwable("width: " + r9 + ", height: " + r8));
            return;
        L8:
            r6 = -16777216;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ x0 a;

        public c(x0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            x0 r0 = this.a;
            r0.r((JSONObject) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ x0 a;

        public d(x0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            x0 r0 = this.a;
            r0.o((Throwable) r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "drawOpenNickName";
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

    public x0(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.h = Observable.create(new b(this, r2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }
}
