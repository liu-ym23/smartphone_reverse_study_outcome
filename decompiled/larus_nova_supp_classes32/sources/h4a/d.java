package h4a;

import android.app.Activity;
import com.ivy.ivykit.api.bridge.inject.IChooseMediaResultCallback;
import com.larus.xbridge.impl.choosemedia.BDXFileSelectionMethodHelper;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends BDXFileSelectionMethodHelper {
    public final /* synthetic */ Activity c;
    public final /* synthetic */ IChooseMediaResultCallback d;

    @Override // j4a.f
    public final void a(final hx7.k r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.DATA_KEY);
        Activity r0 = this.c;
        if (r0 == null) goto L6;
        final IChooseMediaResultCallback r1 = this.d;
        r0.runOnUiThread(new c(r1, r4));
        return;
    }

    @Override // j4a.f
    public final void onFailed(final int r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Activity r0 = this.c;
        if (r0 == null) goto L6;
        final IChooseMediaResultCallback r1 = this.d;
        r0.runOnUiThread(new b(r1, r4, r5));
        return;
    }

    public d(Activity r1, tx7.d.a r2, WeakReference r3) {
        this.c = r1;
        this.d = r2;
        super(r3);
    }
}
