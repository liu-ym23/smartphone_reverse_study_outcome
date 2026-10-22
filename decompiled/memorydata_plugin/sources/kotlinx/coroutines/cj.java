package kotlinx.coroutines;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", Constants.KEY_LIST, "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", "state", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class cj extends kotlinx.coroutines.internal.t implements br {
    public cj() {
    }

    public final String a(String r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append("List{");
        r0.append(r6);
        r0.append("}[");
        kotlinx.coroutines.internal.t r5 = (kotlinx.coroutines.internal.t) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.internal.t.class, "com.obric.memorydata.plugin");
        Object r7 = r5.f();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.v r8 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.internal.v.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
    L4:
        if (Intrinsics.areEqual(r8, r5) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r8, cd.class) == false) goto L12;
        cd r3 = (cd) ZeusTransformUtils.preCheckCast(r8, cd.class, "com.obric.memorydata.plugin");
        if (r2 == false) goto L10;
        r2 = false;
    L11:
        r0.append(r3);
        goto L12
    L10:
        r0.append(", ");
    L12:
        r8 = r8.g();
        goto L4
    L13:
        r0.append("]");
        String r9 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        return r9;
    }

    @Override // kotlinx.coroutines.br
    public boolean m_() {
        return true;
    }

    @Override // kotlinx.coroutines.br
    public cj n_() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.v
    public String toString() {
        if (an.b() == false) goto L6;
        return a("Active");
    L6:
        return super.toString();
    }
}
