package r12;

import android.content.Context;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.format.jsb.FormatSendGiftResultModel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a<f, FormatSendGiftResultModel> {
    public final void onTerminate() {
    }

    public e() {
    }

    public final void invoke(Object r19, CallContext r20) {
        f r1 = (f) r19;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r20, "context");
        Integer r2 = r1.c();
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        if (r3 > 0) goto L8;
        finishWithFailure();
    L8:
        CompositeDisposable r4 = new CompositeDisposable();
        ca0.d r6 = com.bytedance.android.live.revenue.core.util.f.a(ca0.d.class);
        Context r7 = r20.getContext();
        Integer r5 = r1.c();
        if (r5 == null) goto L11;
        int r8 = r5.intValue();
    L12:
        long r9 = r8;
        Integer r10 = r1.b();
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
    L16:
        String r13 = r1.f();
        if (r13 != null) goto L19;
        String r14 = BuildConfig.FLAVOR;
    L20:
        Integer r15 = r1.d();
        if (r15 == null) goto L23;
        int r16 = r15.intValue();
    L24:
        String r17 = r1.e();
        if (r17 != null) goto L27;
        String r18 = BuildConfig.FLAVOR;
    L28:
        Integer r21 = r1.a();
        if (r21 == null) goto L31;
        int r110 = r21.intValue();
    L32:
        String r23 = r1.g();
        if (r23 != null) goto L48;
    L40:
        LinkedHashMap r24 = null;
    L41:
        Observable r25 = r6.n(r7, r9, r11, r14, r16, BuildConfig.FLAVOR, r18, r110, "not_show", r24);
        if (r25 == null) goto L51;
        Disposable r26 = r25.subscribe(new c(this), new d(this));
        if (r26 == null) goto L52;
        RxUtilKt.c(r26, r4);
        return;
    L52:
        return;
    L51:
        return;
    L48:
        JSONObject r27 = new JSONObject(r23);     // Catch: Exception -> L47
        r24 = new LinkedHashMap();     // Catch: Exception -> L47
        Iterator<String> r28 = r27.keys();     // Catch: Exception -> L47
    L37:
        if (r28.hasNext() == false) goto L41;
        String r29 = r28.next();     // Catch: Exception -> L47
        JSONObject r111 = r27;
        r24.put(r29, r27.get(r29).toString());     // Catch: Exception -> L47
        r27 = r111;
        goto L37
    L31:
        r110 = 0;
        goto L32
    L27:
        r18 = r17;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r14 = r13;
        goto L20
    L15:
        r11 = 1;
        goto L16
    L11:
        r8 = 0;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }
}
