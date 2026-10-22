package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/intent/BaseAudioControlPlayIntent;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lcom/obric/capabilitykit/common/intent/Empty;", "()V", "name", "", "getName", "()Ljava/lang/String;", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public class BaseAudioControlPlayIntent implements IntentFunction<Empty, Empty> {
    private final String name;

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return false;
    }

    public BaseAudioControlPlayIntent() {
        this.name = "AudioControl_Play";
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean cancelTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public Boolean isTaskOnGoing(DispatchContext r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatchContext");
        return null;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((Empty) r1, r2, r3);
    }

    public Object doAction(Empty r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        IntentFunction.a.a();
        throw null;
    }
}
