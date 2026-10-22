package com.obric.capability.schedulekit;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/capability/schedulekit/CapabilityScheduleSdk$queryAppIntents$2$1$1", "Lcom/obric/capabilitykit/common/IQueryAppIntentsCallback$Stub;", "onResult", "", WindowEvent.Params.RESULT, "", "Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CapabilityScheduleSdk$queryAppIntents$2$1$1 extends IQueryAppIntentsCallback.Stub {
    final /* synthetic */ i<List<AppIntentImplInfo>> $cont;

    /* JADX WARN: Multi-variable type inference failed */
    public CapabilityScheduleSdk$queryAppIntents$2$1$1(i<? super List<AppIntentImplInfo>> r1) {
        this.$cont = r1;
    }

    public void onResult(List<AppIntentImplInfo> r2) {
        if (this.$cont.isActive() == false) goto L6;
        this.$cont.resumeWith(Result.constructor-impl(r2));
        return;
    }
}
