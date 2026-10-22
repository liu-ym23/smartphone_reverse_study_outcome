package yf0;

import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class e<V extends InteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {
    public final V b;

    public final <R> AutoDisposeConverter<R> c() {
        return this.b.S90();
    }

    public e(V r1) {
        this.b = r1;
        ((com.bytedance.android.livesdk.common.c) this).a = r1;
    }
}
