package btb;

import atb.a;
import com.ss.android.lark.notification.export.AbstractNotification;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b<R extends atb.a> implements AbstractNotification.AbstractNotificationDisplayer.a<R> {
    public final Lazy<AbstractNotification.AbstractNotificationDisplayer.a<R>> a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Lazy<? extends AbstractNotification.AbstractNotificationDisplayer.a<R>> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.a = r2;
    }

    @Override // com.ss.android.lark.notification.export.AbstractNotification.AbstractNotificationDisplayer.a
    public final void a(R r2) {
        Intrinsics.checkNotNullParameter(r2, "notification");
        ((AbstractNotification.AbstractNotificationDisplayer.a) this.a.getValue()).a(r2);
    }
}
