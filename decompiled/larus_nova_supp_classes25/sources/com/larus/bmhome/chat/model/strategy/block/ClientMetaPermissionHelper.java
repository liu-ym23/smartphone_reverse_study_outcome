package com.larus.bmhome.chat.model.strategy.block;

import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.LocalPermission;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ClientMetaPermissionHelper {
    public static final CoroutineScope a = null;
    public static final AtomicBoolean b = null;
    public static volatile a c;
    public static final Lazy d = null;

    public static final class a {
        public final List<LocalPermission> a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "PermissionListSnapshot(permissionList=" + this.a + ", createdAt=" + this.b + ')';
        }

        public final boolean a() {
            Lazy r0 = com.larus.platform.exp.s.a;
            long r1 = com.larus.platform.exp.s.g;
            long r2 = SystemClock.elapsedRealtime() - this.b;
            if (0 <= r2) goto L5;
            return false;
        L5:
            if (r2 > r1) goto L9;
            return true;
        L9:
            return false;
        }

        public a(List<LocalPermission> r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "permissionList");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        b = new AtomicBoolean(false);
        d = LazyKt.lazy(new x());
    }

    public static List b() {
        List r0 = (List) d.getValue();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L29;
        PermissionType r3 = (PermissionType) r2.next();
        String r4 = r3.getPermissionName();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        switch(y.a[r3.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        String r5 = "android.permission.READ_CALENDAR";
    L19:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r5) != 0) goto L21;
        boolean r6 = true;
    L22:
        boolean r7 = i2.b.d(r5);
        if (r6 == false) goto L25;
        PermissionStatus r8 = PermissionStatus.GRANTED;
    L28:
        r1.add(new LocalPermission(r4, Integer.valueOf(r8.getValue())));
        goto L4
    L25:
        if (r7 == false) goto L27;
        r8 = PermissionStatus.NOT_DETERMINED;
        goto L28
    L27:
        r8 = PermissionStatus.DENIED;
        goto L28
    L21:
        r6 = false;
        goto L22
    L10:
        r5 = "android.permission.WRITE_CONTACTS";
        goto L19
    L11:
        r5 = "android.permission.CAMERA";
        goto L19
    L12:
        r5 = "android.permission.BLUETOOTH";
        goto L19
    L13:
        r5 = "android.permission.RECORD_AUDIO";
        goto L19
    L14:
        r5 = "android.permission.ACCESS_BACKGROUND_LOCATION";
        goto L19
    L15:
        r5 = "android.permission.ACCESS_COARSE_LOCATION";
        goto L19
    L16:
        r5 = "android.permission.ACCESS_FINE_LOCATION";
        goto L19
    L17:
        r5 = "";
        goto L19
    L8:
        throw new NoWhenBranchMatchedException();
    L29:
        return r1;
    }

    public static void c() {
        if (com.larus.platform.exp.s.b == true) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("start preloadPermissionList, cacheValid=");
        a r2 = c;
        if (r2 == null) goto L8;
        Boolean r3 = Boolean.valueOf(r2.a());
    L9:
        r1.append(r3);
        r0.d("SendMsgPerf", r1.toString());
        AtomicBoolean r4 = b;
        boolean r5 = true;
        if (r4.compareAndSet(false, true) == true) goto L12;
        return;
    L12:
        a r6 = c;
        if (r6 != null) goto L15;
    L17:
        r5 = false;
    L18:
        if (r5 == false) goto L21;
        r4.set(false);
        return;
    L21:
        c = null;
        BuildersKt.launch$default(a, null, null, new ClientMetaPermissionHelper$preloadPermissionList$1(null), 3, null);
        return;
    L15:
        if (r6.a() != true) goto L17;
    L8:
        r3 = null;
        goto L9
    }

    public static List a(boolean r4) {
        boolean r0 = com.larus.platform.exp.s.b;
        if (r0 == false) goto L13;
        a r1 = c;
        if (r1 == null) goto L9;
        boolean r3 = true;
        if (r1.a() != true) goto L9;
    L10:
        if (r3 == false) goto L13;
        FLogger.a.i("SendMsgPerf", "use preloadPermissionList");
        return r1.a;
    L9:
        r3 = false;
    L13:
        List r2 = b();
        if (r0 == false) goto L17;
        if (r4 == false) goto L17;
        c = new a(r2, SystemClock.elapsedRealtime());
    L17:
        return r2;
    }
}
