package com.bytedance.android.livesdk.gecko;

import android.util.Pair;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends GeckoUpdateListener {
    public final /* synthetic */ ObservableEmitter a;
    public final /* synthetic */ j.f b;
    public final /* synthetic */ j.a c;
    public final /* synthetic */ Function1 d;

    public final void a(boolean r4) {
        Set<j.a> r0 = d.a;
        d.a.add(this.c);
        ALogger.i("AAM.Source.GeckoHelper", "[" + this.a.hashCode() + "] update resource success[" + this.b.a + "], cache: " + r4 + " version: " + this.b.b);
        Function1 r1 = this.d;
        String r2 = this.b.a;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r3 = (String) r1.invoke(r2);
        if (r3 == null) goto L8;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r3);
        if (r5.exists() == false) goto L14;
        this.a.onNext(new j.d(r4, r5.getAbsolutePath()));
    L16:
        this.a.onComplete();
        return;
    L14:
        if (this.a.isDisposed() == true) goto L16;
        this.a.onError(new Throwable("download channel success but not exist: " + this.b.a));
        goto L16
    L8:
        if (this.a.isDisposed() == true) goto L16;
        this.a.onError(new Throwable("download channel success but not found: " + this.b.a));
        goto L16
    }

    public final void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r3, Throwable r4) {
        super.onCheckServerVersionFail(r3, r4);
        ALogger.e("AAM.Source.GeckoHelper", "[" + this.a.hashCode() + "] check version error" + this.b.b + ": " + r4);
        if (this.a.isDisposed() == true) goto L8;
        ObservableEmitter r5 = this.a;
        if (r4 != null) goto L7;
        r4 = new Throwable("update " + this.b.a + " failed");
    L7:
        r5.onError(r4);
    L8:
        this.a.onComplete();
    }

    public final void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r12, Map<String, List<UpdatePackage>> r13) {
        super.onCheckServerVersionSuccess(r12, r13);
        if (r13 == null) goto L9;
        Iterator<Map.Entry<String, List<UpdatePackage>>> r14 = r13.entrySet().iterator();
    L6:
        if (r14.hasNext() == false) goto L9;
        Map.Entry<String, List<UpdatePackage>> r0 = r14.next();
        ALogger.i("AAM.Source.GeckoHelper", r0.getKey() + ' ' + CollectionsKt.joinToString$default(r0.getValue(), "|", null, null, 0, null, null, 62, null));
    L9:
        if (r13 != null) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r15 == false) goto L19;
        a(true);
        return;
    L19:
        return;
    L11:
        if (r13.isEmpty() == true) goto L14;
        r15 = false;
        goto L15
    }

    public final void onUpdateFailed(String r3, Throwable r4) {
        super.onUpdateFailed(r3, r4);
        ALogger.e("AAM.Source.GeckoHelper", "[" + this.a.hashCode() + "] update resource error[" + r3 + "] " + this.b.b + ": " + r4);
        if (this.a.isDisposed() == true) goto L8;
        ObservableEmitter r5 = this.a;
        if (r4 != null) goto L7;
        r4 = new Throwable("update " + this.b.a + " failed");
    L7:
        r5.onError(r4);
    L8:
        this.a.onComplete();
    }

    public final void onUpdateSuccess(String r1, long r2) {
        super.onUpdateSuccess(r1, r2);
        a(false);
    }

    public b(ObservableEmitter r1, j.f r2, j.a r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
