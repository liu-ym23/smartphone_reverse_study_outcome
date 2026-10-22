package lh0;

import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import ih0.h;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b implements c {
    public final CompositeDisposable a;
    public final Context b;
    public final DataCenter c;

    public void c() {
    }

    public final IRoom b() {
        DataCenter r0 = this.c;
        if (r0 == null) goto L7;
        IRoom r1 = a0.o(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return a0.a;
    }

    public void d() {
        this.a.clear();
    }

    public final Context getContext() {
        return this.b;
    }

    public b(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }

    @Override // lh0.c
    public final void a(h r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "updateCallback");
        c.a.a(r2, r3);
    }

    public final void e(h r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "updateCallback");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        Intrinsics.checkNotNullParameter(r3, "updateCallback");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        r3.a(UpdateLinkmicStatusResultModel.Code.Failed, r4, null);
    }
}
