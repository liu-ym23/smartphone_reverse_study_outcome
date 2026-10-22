package kotlin.collections;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "element", "get", "index", "(I)Ljava/lang/Boolean;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {
    final /* synthetic */ boolean[] $this_asList;

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        if (this.$this_asList.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ArraysKt___ArraysJvmKt$asList$7(boolean[] r1) {
        this.$this_asList = r1;
    }

    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof Boolean) == true) goto L7;
        return false;
    L7:
        return contains(((Boolean) r2).booleanValue());
    }

    public Boolean get(int r2) {
        return Boolean.valueOf(this.$this_asList[r2]);
    }

    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof Boolean) == true) goto L7;
        return -1;
    L7:
        return indexOf(((Boolean) r2).booleanValue());
    }

    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof Boolean) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf(((Boolean) r2).booleanValue());
    }

    public boolean contains(boolean r2) {
        return ArraysKt.contains(this.$this_asList, r2);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m29get(int r1) {
        return get(r1);
    }

    public int indexOf(boolean r2) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, r2);
    }

    public int lastIndexOf(boolean r2) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, r2);
    }
}
