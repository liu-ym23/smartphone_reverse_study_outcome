package ai0;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import jc1.k;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Ref.ObjectRef b;

    public b(Context r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        k.n(IBaseLiveActionHandler.class).handle(this.a, (String) this.b.element);
    }
}
