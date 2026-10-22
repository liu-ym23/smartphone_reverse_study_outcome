package com.obric.capabilitykit.common.intent;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/common/intent/BasePhoneDeleteIntent;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lcom/obric/capabilitykit/common/intent/PhoneDeleteParams;", "", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "()V", "name", "", "getName", "()Ljava/lang/String;", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public class BasePhoneDeleteIntent implements IntentFunction<PhoneDeleteParams, CallHistoryEntity[]> {
    private final String name;

    @Override // com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return false;
    }

    public BasePhoneDeleteIntent() {
        this.name = "Phone_Delete";
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
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<CallHistoryEntity[]>> r3) {
        return doAction((PhoneDeleteParams) r1, r2, r3);
    }

    public Object doAction(PhoneDeleteParams r1, DispatchContext r2, Continuation<? super IntentResult<CallHistoryEntity[]>> r3) {
        IntentFunction.a.a();
        throw null;
    }
}
