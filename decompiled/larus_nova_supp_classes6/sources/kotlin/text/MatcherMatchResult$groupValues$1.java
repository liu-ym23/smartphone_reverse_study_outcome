package kotlin.text;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {
    final /* synthetic */ MatcherMatchResult this$0;

    public int getSize() {
        return MatcherMatchResult.access$getMatchResult(this.this$0).groupCount() + 1;
    }

    public MatcherMatchResult$groupValues$1(MatcherMatchResult r1) {
        this.this$0 = r1;
    }

    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return contains((String) r2);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m755get(int r2) {
        String r3 = MatcherMatchResult.access$getMatchResult(this.this$0).group(r2);
        if (r3 != null) goto L6;
        return "";
    L6:
        return r3;
    }

    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return -1;
    L7:
        return indexOf((String) r2);
    }

    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((String) r2);
    }

    public /* bridge */ boolean contains(String r1) {
        return super/*kotlin.collections.AbstractCollection*/.contains(r1);
    }

    public /* bridge */ /* synthetic */ Object get(int r1) {
        return m755get(r1);
    }

    public /* bridge */ int indexOf(String r1) {
        return super.indexOf(r1);
    }

    public /* bridge */ int lastIndexOf(String r1) {
        return super.lastIndexOf(r1);
    }
}
