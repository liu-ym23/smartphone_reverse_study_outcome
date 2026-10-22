package com.obric.assistant.interaction.impl.activityresult;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelCallback;", "", "onProxyCanceled", "", WindowEvent.Params.REASON, "Lcom/obric/assistant/interaction/impl/activityresult/ActivityProxyCancelReason;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ActivityProxyCancelCallback {
    void onProxyCanceled(ActivityProxyCancelReason r1);
}
