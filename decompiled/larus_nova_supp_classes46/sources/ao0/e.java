package ao0;

import com.bytedance.android.live.api.exceptions.local.ApiLocalException;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;
import com.bytedance.android.livesdkapi.ILiveResponseExtraInfoParser;
import com.bytedance.retrofit2.SsResponse;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ILiveResponseExtraInfoParser {
    public final Set<Class<?>> a;
    public final Set<Class<? extends Throwable>> b;

    public static final class a implements ILiveResponseExtraInfo {
        public final /* synthetic */ e a;
        public final /* synthetic */ Object b;

        public final long getServerTimestamp() {
            return ((Extra) ((BaseResponse) this.b).extra).now;
        }

        public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
            e r0 = this.a;
            int r1 = ((BaseResponse) this.b).statusCode;
            r0.getClass();
            return new ao0.a(r1, "", "");
        }

        public a(e r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements ILiveResponseExtraInfo {
        public final /* synthetic */ e a;
        public final /* synthetic */ Object b;

        public final long getServerTimestamp() {
            return ((Extra) ((BaseListResponse) this.b).extra).now;
        }

        public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
            e r0 = this.a;
            int r1 = ((BaseListResponse) this.b).statusCode;
            r0.getClass();
            return new ao0.a(r1, "", "");
        }

        public b(e r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements ILiveResponseExtraInfo {
        public final /* synthetic */ e a;
        public final /* synthetic */ Object b;

        public final long getServerTimestamp() {
            return ((com.bytedance.android.live.network.response.c) this.b).a().now;
        }

        public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
            e r0 = this.a;
            int r1 = ((com.bytedance.android.live.network.response.c) this.b).getStatusCode();
            String r2 = ((com.bytedance.android.live.network.response.c) this.b).getError().message;
            String r3 = ((com.bytedance.android.live.network.response.c) this.b).getError().prompts;
            r0.getClass();
            return new ao0.a(r1, r2, r3);
        }

        public c(e r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public e() {
        this.a = SetsKt.mutableSetOf(new Class[]{ExtraResponse.class, BaseResponse.class, BaseListResponse.class});
        this.b = SetsKt.mutableSetOf(new Class[]{ApiLocalException.class, ApiServerException.class});
    }

    public final Set<Class<?>> getTargetResponseTypes() {
        return this.a;
    }

    public final Set<Class<? extends Throwable>> getTargetThrowableTypes() {
        return this.b;
    }

    public final ILiveResponseExtraInfo parseFromThrowable(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if ((r2 instanceof ResponseNoDataException) == false) goto L6;
        return new ao0.b(this, r2);
    L6:
        if ((r2 instanceof ApiLocalException) == false) goto L9;
        return new ao0.c(this, r2);
    L9:
        if ((r2 instanceof ApiServerException) == true) goto L15;
        return null;
    L15:
        return new d(this, r2);
    }

    public final ILiveResponseExtraInfo parse(String r2, SsResponse<Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "response");
        Object r4 = r3.body();
        if ((r4 instanceof BaseResponse) == false) goto L6;
        return new a(this, r4);
    L6:
        if ((r4 instanceof BaseListResponse) == false) goto L9;
        return new b(this, r4);
    L9:
        if ((r4 instanceof com.bytedance.android.live.network.response.c) == true) goto L15;
        return null;
    L15:
        return new c(this, r4);
    }
}
