package com.obric.matrix.platform.sdk.ones.location;

import android.net.Uri;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.Ext;
import com.obric.matrix.platform.sdk.ones.internal.tunnel.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002/0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102)\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\u0010\u0019JZ\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2@\u0010\u0012\u001a<\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\f0\u001dH\u0007JB\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2)\u0010!\u001a%\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\f0\u0013H\u0007¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0007J!\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020(H\u0007¢\u0006\u0002\u0010)J%\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0+H\u0007¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u00061"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/location/LocationApi;", "", "()V", "TAG", "", "locationObserver", "Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationObserver;", "getLocationObserver", "()Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationObserver;", "locationObserver$delegate", "Lkotlin/Lazy;", "decodeLocation", "", "context", "Landroid/content/Context;", "longitude", "", "latitude", "resultCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "success", "Lcom/obric/matrix/proto/LocationInfo;", "(Landroid/content/Context;DDLkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "getIntersectFences", Ext.KEY_REQUEST, "Lcom/obric/matrix/proto/GetIntersectFencesRequest;", "Lkotlin/Function3;", "Lcom/obric/matrix/proto/GetIntersectFencesResponse;", "errMsg", "getLocation", "listener", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "locationInfoToAddress", "Landroid/location/Address;", "location", "refreshLocation", "option", "Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationOption;", "(Landroid/content/Context;Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationOption;)Lkotlin/Unit;", "registerLocationChangeListener", "Lkotlin/Function0;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;", "unregisterLocationChangeListener", "(Landroid/content/Context;)Lkotlin/Unit;", "LocationObserver", "LocationOption", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8117a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f8118b = null;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.location.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/location/LocationApi$LocationObserver;", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/MatrixEventObserver;", "()V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "handleContentChange", "uri", "Landroid/net/Uri;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0404a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile Function0<Unit> f8119b;

        public C0404a() {
            super("/location/status", false, null, 4, null);
        }

        @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.c
        public void a(Uri r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            if (this.f8119b != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual(r2.getPath(), "/location/status") == false) goto L11;
            Function0<Unit> r1 = this.f8119b;
            if (r1 == null) goto L12;
            r1.invoke();
            return;
        L12:
            return;
        }
    }

    static {
        f8117a = new a();
        f8118b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(LocationApi$locationObserver$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    private a() {
    }
}
