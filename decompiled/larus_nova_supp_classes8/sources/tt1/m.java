package tt1;

import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends com.bytedance.android.livesdk.user.h<FollowPair> {
    public final /* synthetic */ o a;
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback b;

    public final void onComplete() {
        IBaseCallbackSchemaHandler.SchemaCallback r0 = this.b;
        if (r0 == null) goto L6;
        r0.onComplete();
        return;
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        Lazy r0 = DispatchLogUtil.a;
        DispatchLogUtil.d(8, DispatchLogUtil.InstanceType.FOLLOW);
        IBaseCallbackSchemaHandler.SchemaCallback r1 = this.b;
        if (r1 == null) goto L6;
        r1.onFailure(r3);
        return;
    }

    public final void onNext(Object r3) {
        FollowPair r4 = (FollowPair) r3;
        Intrinsics.checkNotNullParameter(r4, "followPair");
        Lazy r0 = DispatchLogUtil.a;
        DispatchLogUtil.d(6, DispatchLogUtil.InstanceType.FOLLOW);
        IBaseCallbackSchemaHandler.SchemaCallback r1 = this.b;
        if (r1 == null) goto L6;
        r1.onSuccess(Integer.valueOf(r4.followStatus), "");
        return;
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.a = r2;
    }

    public m(o r1, IBaseCallbackSchemaHandler.SchemaCallback r2) {
        this.a = r1;
        this.b = r2;
    }
}
