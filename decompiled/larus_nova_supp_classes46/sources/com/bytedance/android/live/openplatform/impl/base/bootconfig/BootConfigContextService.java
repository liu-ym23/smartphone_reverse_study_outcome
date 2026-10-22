package com.bytedance.android.live.openplatform.impl.base.bootconfig;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/bootconfig/BootConfigContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BootConfigContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int b = 0;
    public final Map<String, com.bytedance.android.live.openplatform.impl.base.api.response.a> a;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b;
        }

        public final String toString() {
            return "FrequencyLimit(maxTimes=" + this.a + ", unitTime=" + this.b + ")";
        }

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public BootConfigContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new LinkedHashMap();
    }

    public final b f(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "method");
        com.bytedance.android.live.openplatform.impl.base.api.response.a r5 = (com.bytedance.android.live.openplatform.impl.base.api.response.a) ((LinkedHashMap) this.a).get(r3);
        if (r5 == null) goto L13;
        List<com.bytedance.android.live.openplatform.impl.base.api.response.a.C0140a> r6 = r5.a();
        if (r6 == null) goto L18;
        Iterator<T> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L19;
        com.bytedance.android.live.openplatform.impl.base.api.response.a.C0140a r0 = (com.bytedance.android.live.openplatform.impl.base.api.response.a.C0140a) r7.next();
        if (Intrinsics.areEqual(r4, r0.b()) == false) goto L8;
        return new b(r0.a(), r0.c());
    L19:
        return null;
    L18:
        return null;
    L13:
        return null;
    }
}
