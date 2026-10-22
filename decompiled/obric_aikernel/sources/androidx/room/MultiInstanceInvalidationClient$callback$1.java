package androidx.room;

import java.util.Arrays;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient r10) {
        this.this$0 = r10;
    }

    public static /* synthetic */ void U0(MultiInstanceInvalidationClient r10, String[] r11) {
        onInvalidation$lambda$0(r10, r11);
    }

    private static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$tables");
        r10.getInvalidationTracker().notifyObserversByTableNames((String[]) Arrays.copyOf(r11, r11.length));
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(final String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "tables");
        Executor r11 = this.this$0.getExecutor();
        final MultiInstanceInvalidationClient r12 = this.this$0;
        r11.execute(new f(r12, r10));
    }
}
