package com.obric.memorydata.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u001a\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\b\u0010\f\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"TAG", "", "isMainThread", "", "runInNonMainThread", "", "action", "Lkotlin/Function0;", "isSameDay", "ts1", "", "ts2", "isApiLevelGreaterThanAndroid13", "gpsToAddressLineByGcj02", "latitude", "", "longitude", "gpsToAddressByGcj02", "Landroid/location/Address;", "gpsToAddress", "addressToGps", "Lkotlin/Pair;", "addressName", "isNetworkAvailable", "context", "Landroid/content/Context;", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class h {
    public static final Pair<Double, Double> a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "addressName");
        return (Pair) ZeusTransformUtils.preCheckCast(y.a(null, new $$Lambda$h$PFcGZYFm_2AM4a2gxwUwuLiClis(r2), 1, null), Pair.class, "com.obric.memorydata.plugin");
    }

    public static final void a(Function0<Unit> r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "action");
        if (a() == false) goto L6;
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$h$Lg34b8grNIISkP8clr7kFTr8es(r3));
        return;
    L6:
        r3.invoke();
    }

    public static final boolean a() {
        return Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    public static final boolean a(long r1, long r3) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r3);
        if (r0.get(1) == r2.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r0.get(6) != r2.get(6)) goto L7;
        return true;
    }

    public static final boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r5 = r4.getSystemService("connectivity");     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L9
        NetworkInfo r6 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r5, ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r6 == null) goto L12;
        if (r6.isConnected() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    private static final Pair b(String r5) {
        if (a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L5;
        return null;
    L5:
        boolean r3 = true;
        List<Address> r6 = new Geocoder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Locale.CHINA).getFromLocationName(r5, 1);
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
    L11:
        if (r3 == false) goto L13;
        return null;
    L13:
        Address r7 = (Address) ZeusTransformUtils.preCheckCast(r6.get(0), Address.class, "com.obric.memorydata.plugin");
        return new Pair(Double.valueOf(r7.getLongitude()), Double.valueOf(r7.getLatitude()));
    L8:
        if (r0.isEmpty() == true) goto L11;
        r3 = false;
        goto L11
    }

    private static final void b(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    /* JADX INFO: renamed from: lambda$Lg34b8grNIISkP8clr7-kFTr8es, reason: not valid java name */
    public static /* synthetic */ void m1247lambda$Lg34b8grNIISkP8clr7kFTr8es(Function0 r0) {
        b(r0);
    }

    public static /* synthetic */ Pair lambda$PFcGZYFm_2AM4a2gxwUwuLiClis(String r0) {
        return b(r0);
    }
}
