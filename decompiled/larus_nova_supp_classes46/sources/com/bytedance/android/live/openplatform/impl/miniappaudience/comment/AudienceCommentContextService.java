package com.bytedance.android.live.openplatform.impl.miniappaudience.comment;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdk.event.z;
import io.reactivex.functions.Predicate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/comment/AudienceCommentContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceCommentContextService extends OpenPlatformContextService {
    public final Map<Long, Integer> a;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            z r3 = (z) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if ((r3.a instanceof d0) == true) goto L5;
        L7:
            return false;
        L5:
            if (r3.b == false) goto L7;
            return true;
        }
    }

    public final void f() {
        autoDispose(m.f(b.a().b(z.class).filter(a.a), new AudienceCommentContextService$observeSendCommentEvent$2(this)));
    }

    public AudienceCommentContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new LinkedHashMap();
    }
}
