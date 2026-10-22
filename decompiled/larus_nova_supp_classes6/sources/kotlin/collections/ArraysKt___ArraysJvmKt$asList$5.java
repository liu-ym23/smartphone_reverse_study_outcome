package kotlin.collections;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.RandomAccess;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Float;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {
    final /* synthetic */ float[] $this_asList;

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        if (this.$this_asList.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ArraysKt___ArraysJvmKt$asList$5(float[] r1) {
        this.$this_asList = r1;
    }

    public boolean contains(float r8) {
        float[] r0 = this.$this_asList;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L14;
        if (Float.floatToIntBits(r0[r3]) != Float.floatToIntBits(r8)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L9;
        r3 = r3 + 1;
        goto L3
    L9:
        return true;
    L7:
        r4 = false;
        goto L8
    L14:
        return false;
    }

    public Float get(int r2) {
        return Float.valueOf(this.$this_asList[r2]);
    }

    public int indexOf(float r7) {
        float[] r0 = this.$this_asList;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        if (Float.floatToIntBits(r0[r3]) != Float.floatToIntBits(r7)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L15;
        r3 = r3 + 1;
        goto L3
    L15:
        return r3;
    L7:
        r4 = false;
        goto L8
    L11:
        return -1;
    }

    public int lastIndexOf(float r7) {
        float[] r0 = this.$this_asList;
        int r1 = r0.length - 1;
        if (r1 < 0) goto L13;
    L4:
        int r3 = r1 - 1;
        if (Float.floatToIntBits(r0[r1]) != Float.floatToIntBits(r7)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L16;
        if (r3 < 0) goto L17;
        r1 = r3;
        goto L4
    L17:
        return -1;
    L16:
        return r1;
    L7:
        r4 = false;
        goto L8
    L13:
        return -1;
    }

    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof Float) == true) goto L7;
        return false;
    L7:
        return contains(((Number) r2).floatValue());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m27get(int r1) {
        return get(r1);
    }

    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof Float) == true) goto L7;
        return -1;
    L7:
        return indexOf(((Number) r2).floatValue());
    }

    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof Float) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf(((Number) r2).floatValue());
    }
}
