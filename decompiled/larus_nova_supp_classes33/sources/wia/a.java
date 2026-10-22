package wia;

import com.obric.capabilitykit.ActionDispatcher;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements ThreadFactory {
    public /* synthetic */ a() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r1) {
        return ActionDispatcher.b(r1);
    }
}
