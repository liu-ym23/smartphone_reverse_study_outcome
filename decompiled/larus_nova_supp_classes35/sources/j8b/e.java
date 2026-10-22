package j8b;

import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.manager.RequestManager;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g a;

    public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {
        public final /* synthetic */ ObservableEmitter a;

        public final Type b() {
            return j.class;
        }

        public a(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void a(NetworkErrorResult r3) {
            Intrinsics.checkNotNullParameter(r3, "networkErrorResult");
            if (this.a.isDisposed() == true) goto L6;
            this.a.onError(new NetworkErrorResultException(r3));
            return;
        }

        public final void c(com.ss.android.lark.security.compliance.infra.network.h<T> r2) {
            Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
            if (this.a.isDisposed() == true) goto L6;
            this.a.onNext(r2);
            this.a.onComplete();
            return;
        }
    }

    public e(com.ss.android.lark.security.compliance.infra.network.a r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<com.ss.android.lark.security.compliance.infra.network.h<T>> r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        com.ss.android.lark.security.compliance.infra.network.f r0 = RequestManager.a;
        RequestManager.a(this.a, new a(r3));
    }
}
