package kotlinx.coroutines;

import com.bytedance.apm6.consumer.slardar.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/InactiveNodeList;", "Lkotlinx/coroutines/Incomplete;", Constants.KEY_LIST, "Lkotlinx/coroutines/NodeList;", "(Lkotlinx/coroutines/NodeList;)V", "isActive", "", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class bq implements br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cj f17246a;

    public bq(cj r1) {
        this.f17246a = r1;
    }

    @Override // kotlinx.coroutines.br
    public boolean m_() {
        return false;
    }

    @Override // kotlinx.coroutines.br
    public cj n_() {
        return this.f17246a;
    }

    public String toString() {
        if (an.b() == false) goto L6;
        return n_().a("New");
    L6:
        return super.toString();
    }
}
