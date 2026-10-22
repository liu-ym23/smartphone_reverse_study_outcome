package or1;

import com.bytedance.android.livehostapi.foundation.depend.OnBindPhoneListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements OnBindPhoneListener {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    public final void onBindPhone(boolean r2) {
        this.a.invoke(Boolean.valueOf(r2));
    }
}
