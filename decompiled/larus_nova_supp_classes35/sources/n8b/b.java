package n8b;

import com.ss.android.lark.conditional.access.network.model.response.BindDeviceData;
import com.ss.android.lark.security.compliance.infra.network.NetworkErrorResult;
import com.ss.android.lark.security.compliance.infra.network.service.NetworkErrorResultException;
import com.tencent.qqmusic.third.api.contract.Keys;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.userscpoe.a a;
    public final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g b;

    public static final class a implements com.ss.android.lark.security.compliance.infra.network.d<T> {
        public final /* synthetic */ ObservableEmitter a;

        public final Type b() {
            return BindDeviceData.class;
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

    public b(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r1, com.ss.android.lark.security.compliance.infra.network.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<com.ss.android.lark.security.compliance.infra.network.h<T>> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        this.a.a(this.b, new a(r4));
    }
}
