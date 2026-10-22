package com.obric.assistant.interaction.impl.activityresult;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/MainActivityProxyRequestScheduler;", "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestScheduler;", "<init>", "()V", "handler", "Landroid/os/Handler;", "post", "", "block", "Ljava/lang/Runnable;", "postDelayed", "delayMs", "", "removeCallbacks", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainActivityProxyRequestScheduler implements ActivityProxyRequestScheduler {
    private final Handler handler;

    public MainActivityProxyRequestScheduler() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override // com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestScheduler
    public void post(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.handler.post(r2);
    }

    @Override // com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestScheduler
    public void removeCallbacks(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.handler.removeCallbacks(r2);
    }

    @Override // com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestScheduler
    public void postDelayed(Runnable r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.handler.postDelayed(r2, r3);
    }
}
