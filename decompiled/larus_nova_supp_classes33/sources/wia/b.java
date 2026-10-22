package wia;

import com.obric.capabilitykit.ActionDispatcher;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements ThreadFactory {
    public /* synthetic */ b() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r1) {
        return ActionDispatcher.a(r1);
    }
}
