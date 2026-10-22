package kotlinx.coroutines.internal;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public /* synthetic */ class LockFreeLinkedListNode$toString$1 extends PropertyReference0Impl {
    public LockFreeLinkedListNode$toString$1(Object r7) {
        super(r7, b0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
    }

    public Object get() {
        return ((CallableReference) this).receiver.getClass().getSimpleName();
    }
}
