package obric.flow.basics.impl.appcontext;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DefaultContextImpl$metaData$2 extends Lambda implements Function0<Bundle> {
    public static final DefaultContextImpl$metaData$2 INSTANCE = null;

    static {
        INSTANCE = new DefaultContextImpl$metaData$2();
    }

    public DefaultContextImpl$metaData$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Bundle invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        iu.a r5 = iu.a.f18214a;     // Catch: Exception -> L4
        return r5.getContext().getPackageManager().getApplicationInfo(r5.getPackageName(), 128).metaData;
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
