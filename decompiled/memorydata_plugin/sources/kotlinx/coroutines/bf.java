package kotlinx.coroutines;

import com.bytedance.apm6.consumer.slardar.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", Constants.KEY_LIST, "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class bf implements br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17231a;

    public bf(boolean r1) {
        this.f17231a = r1;
    }

    @Override // kotlinx.coroutines.br
    public boolean m_() {
        return this.f17231a;
    }

    @Override // kotlinx.coroutines.br
    public cj n_() {
        return null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Empty{");
        if (m_() == false) goto L5;
        String r2 = "Active";
    L7:
        return r0.append(r2).append('}').toString();
    L5:
        r2 = "New";
        goto L7
    }
}
