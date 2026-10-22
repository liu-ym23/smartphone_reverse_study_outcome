package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.concurrent.Callable;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class sd implements vlc.l {
    public final /* synthetic */ zd a;
    public final /* synthetic */ String b;

    public static final class a<V> implements Callable {
        public final /* synthetic */ tlc.d a;

        public a(tlc.d r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final String call() {
            return GsonProtectorUtils.toJson(GsonHelper.get(), this.a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ sd a;

        public b(sd r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            String r8 = (String) r7;
            zd r0 = this.a.a;
            String r1 = "longLinkMessageReceived, type: " + this.a.b;
            r0.getClass();
            zd.b(r1);
            com.bytedance.ies.web.jsbridge2.d0 r2 = this.a.a.b;
            if (r2 != null) goto L5;
        L7:
            IHybridComponent r3 = this.a.a.c;
            if (r3 == null) goto L11;
            JSONObject r4 = new JSONObject();
            r4.put("type", this.a.b);
            r4.put("data", r8);
            Unit r9 = Unit.INSTANCE;
            r3.sendJsEvent("longLinkMessageReceived", r4);
            return;
        L11:
            return;
        L5:
            if (r2.f == true) goto L7;
            JSONObject r5 = new JSONObject();
            r5.put("type", this.a.b);
            r5.put("data", r8);
            Unit r6 = Unit.INSTANCE;
            r2.f("longLinkMessageReceived", r5);
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ sd a;

        public c(sd r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            zd r0 = this.a.a;
            StringBuilder r1 = new StringBuilder("on message error: ");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            String r7 = r1.toString();
            r0.getClass();
            zd.b(r7);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public sd(zd r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onMessage(tlc.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Single.fromCallable(new a(r3)).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), new c(this));
    }
}
