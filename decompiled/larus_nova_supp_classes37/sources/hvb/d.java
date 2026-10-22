package hvb;

import com.bytedance.lark.rustclient.api.s;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.Message;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler$sendHttpRequest$2$2$callBack$1;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ IGetDataCallback<Message<?, ?>> a;
    public final /* synthetic */ Ref.ObjectRef<Disposable> b;

    public d(MmNetRequestHandler$sendHttpRequest$2$2$callBack$1 r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        s r4 = (s) r3;
        lvb.a.a("RustSdkBridge", "[sendHttp] subscribe response=" + r4);
        int r0 = g.a;
        Intrinsics.checkNotNull(r4);
        g.a(r4, this.a, (Disposable) this.b.element);
    }
}
