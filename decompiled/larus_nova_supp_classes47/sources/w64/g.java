package w64;

import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.z0;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements IMobileResultCallback {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback
    public final void onComplete(Object r4) {
        PseudoCodeResult r5 = (PseudoCodeResult) r4;
        if (Objects.equals(r5.errorCode, Constants.StatusCode.SUCCESS) == true) goto L5;
    L7:
        KLog.w(Constants.TAGS.INIT, "sim card change error: " + r5.errorMsg);
        return;
    L5:
        if (TextUtils.isEmpty(r5.data) == true) goto L7;
        z0 r6 = d0.a;
        d0.b(23, z64.h.b.a, new f(this), true);
    }
}
