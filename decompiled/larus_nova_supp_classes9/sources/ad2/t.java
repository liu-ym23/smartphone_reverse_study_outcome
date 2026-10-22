package ad2;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.bduploader.BDImageUploader;
import com.ss.bduploader.BDVideoUploader;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "uploadMedia")
public final class t extends ad2.a<c0, UploadMediaResultModel> {
    public final CompositeDisposable a;

    public static final class a {
    }

    static {
    }

    public t() {
        this.a = new CompositeDisposable();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.dispose();
    }

    public final void invoke(Object r21, CallContext r23) {
        c0 r1 = (c0) r21;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r23, "context");
        if (Intrinsics.areEqual(r1.c(), "image") == true) goto L5;
    L19:
        String r9 = null;
        if (Intrinsics.areEqual(r1.c(), "video") == false) goto L40;
        if (Intrinsics.areEqual(r1.f(), Boolean.TRUE) == false) goto L40;
        c0.a r2 = r1.a();
        k r11 = new k();
        Boolean r18 = r1.d();
        List<String> r3 = r1.b();
        if (r3 == null) goto L26;
        r9 = (String) ListProtector.get(r3, 0);
    L26:
        String r13 = r9;
        CallContext r4 = getCallContext();
        Intrinsics.checkNotNullParameter(r4, "callContext");
        if (r2 == null) goto L38;
        String r14 = r2.a();
        String r15 = r2.b();
        String r16 = r2.d();
        String r17 = r2.c();
        if (r13 == null) goto L36;
        if (r14 == null) goto L36;
        if (r15 == null) goto L36;
        if (r16 == null) goto L36;
        if (r17 == null) goto L36;
        BDVideoUploader r5 = new BDVideoUploader();
        RxUtilKt.c(RxUtilKt.i(Single.create(new r(r11, r13, r5, r14, r15, r16, r17, r18, r4)).doOnDispose(new s(r5))).subscribe(new w(this), new x(this)), this.a);
        return;
    L36:
        throw new Throwable("some params is empty");
    L38:
        throw new Throwable("imageAuthInfo null");
    L40:
        if (Intrinsics.areEqual(r1.c(), "video") == false) goto L70;
        List<String> r6 = r1.b();
        if (r6 == null) goto L44;
        String r19 = (String) CollectionsKt.first(r6);
    L45:
        c0.a r7 = r1.a();
        if (r7 == null) goto L48;
        String r110 = r7.a();
    L49:
        c0.a r8 = r1.a();
        if (r8 == null) goto L52;
        String r111 = r8.b();
    L53:
        c0.a r10 = r1.a();
        if (r10 == null) goto L56;
        String r112 = r10.d();
    L57:
        c0.a r20 = r1.a();
        if (r20 == null) goto L60;
        r9 = r20.c();
    L60:
        String r113 = r9;
        String r114 = r1.g();
        if (r19 == null) goto L68;
        if (r110 == null) goto L68;
        if (r111 == null) goto L68;
        if (r112 == null) goto L68;
        if (r113 == null) goto L68;
        c r115 = new c();
        com.bytedance.android.livesdk.jsbridge.methods.upload.models.c r24 = new com.bytedance.android.livesdk.jsbridge.methods.upload.models.c(r110, r111, r112, r113, r114);
        CallContext r116 = getCallContext();
        Intrinsics.checkNotNullParameter(r19, "path");
        Intrinsics.checkNotNullParameter(r24, "videoUploadConfig");
        Intrinsics.checkNotNullParameter(r116, "callContext");
        BDVideoUploader r25 = new BDVideoUploader();
        RxUtilKt.c(RxUtilKt.h(Observable.create(new i(r115, r19, r25, r24, r116)).doOnDispose(new j(r25)).subscribeOn(Schedulers.io())).subscribe(new y(this), new z(this)), this.a);
        return;
    L68:
        finishWithFailure(new Throwable("some params is empty"));
        return;
    L56:
        r112 = null;
        goto L57
    L52:
        r111 = null;
        goto L53
    L48:
        r110 = null;
        goto L49
    L44:
        r19 = null;
        goto L45
    L70:
        if (Intrinsics.areEqual(r1.c(), "image") == false) goto L77;
        String r26 = r1.e();
        List<String> r27 = r1.b();
        if (r26 == null) goto L76;
        if (r27 == null) goto L76;
        CallContext r28 = getCallContext();
        Intrinsics.checkNotNullParameter(r26, "uploadPath");
        Intrinsics.checkNotNullParameter(r27, "uploadFilePathList");
        Intrinsics.checkNotNullParameter(r28, "callContext");
        RxUtilKt.c(RxUtilKt.i(Observable.fromIterable(r27).observeOn(Schedulers.io()).flatMap(new f(r26, new AtomicInteger(0), r28, r27.size()), 3).toList().map(new h(r27))).subscribe(new a0(this), new b0(this)), this.a);
        return;
    L76:
        finishWithFailure(new Throwable("some params is empty"));
        return;
    L77:
        finishWithFailure(new Throwable("unknown type"));
        return;
    L5:
        if (Intrinsics.areEqual(r1.f(), Boolean.TRUE) == false) goto L19;
        c0.a r29 = r1.a();
        k r30 = new k();
        Boolean r117 = r1.d();
        List<String> r118 = r1.b();
        CallContext r31 = getCallContext();
        Intrinsics.checkNotNullParameter(r31, "callContext");
        if (r29 == null) goto L18;
        String r119 = r29.a();
        String r120 = r29.b();
        String r121 = r29.d();
        String r122 = r29.c();
        if (r118 == null) goto L16;
        if (r119 == null) goto L16;
        if (r120 == null) goto L16;
        if (r121 == null) goto L16;
        if (r122 == null) goto L16;
        BDImageUploader r33 = new BDImageUploader();
        RxUtilKt.c(RxUtilKt.i(Observable.create(new n(r30, r33, r118, r119, r120, r121, r122, r117, r31)).doOnDispose(new o(r33)).toList().map(q.a).subscribeOn(Schedulers.io())).subscribe(new u(this), new v(this)), this.a);
        return;
    L16:
        throw new Throwable("some params is empty");
    L18:
        throw new Throwable("imageAuthInfo null");
    }
}
