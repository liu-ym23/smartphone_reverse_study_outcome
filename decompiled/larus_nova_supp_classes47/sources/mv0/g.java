package mv0;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends qs0.a<IHostCommerceServiceLive> implements qs0.e {
    public g() {
        super(jc1.k.f(IHostCommerceServiceLive.class));
    }

    @Override // qs0.e
    public final JSONObject i() {
        IHostCommerceServiceLive r0 = (IHostCommerceServiceLive) this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveShoppingData(20);
    }

    @Override // qs0.e
    public final void tryShowLiveFlashFragment(Context r2, Bundle r3, Function1<? super DialogFragment, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        IHostCommerceServiceLive r0 = (IHostCommerceServiceLive) this.a;
        if (r0 == null) goto L6;
        r0.tryShowLiveFlashFragment(r2, r3, r4);
        return;
    }
}
