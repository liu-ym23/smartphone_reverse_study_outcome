package com.obric.assistant.interaction.impl.activityresult;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyRequestScheduler;", "", "post", "", "block", "Ljava/lang/Runnable;", "postDelayed", "delayMs", "", "removeCallbacks", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ActivityProxyRequestScheduler {
    void post(Runnable r1);

    void postDelayed(Runnable r1, long r2);

    void removeCallbacks(Runnable r1);
}
