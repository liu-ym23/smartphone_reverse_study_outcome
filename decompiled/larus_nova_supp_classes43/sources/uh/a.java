package uh;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.ec.core.report.EventUploadApi;
import com.bytedance.android.ec.sdk.helper.n;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: uh.a$a, reason: collision with other inner class name */
    public static final class C0205a {
    }

    static {
    }

    public static void a(String r10) {
        Intrinsics.checkNotNullParameter("sku", "scene");
        Intrinsics.checkNotNullParameter("freq", "eventType");
        Intrinsics.checkNotNullParameter(r10, "action");
        EventUploadApi r0 = (EventUploadApi) n.a.create("https://ecom.snssdk.com", EventUploadApi.class);
        if (r0 == null) goto L10;
        Observable<Object> r11 = r0.post("sku", "freq", r10, System.currentTimeMillis() / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR));
        if (r11 == null) goto L11;
        Observable r12 = r11.subscribeOn(Schedulers.io());
        if (r12 == null) goto L12;
        r12.subscribe(b.a, c.a);
        return;
    L12:
        return;
    L11:
        return;
    }
}
