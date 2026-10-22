package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.serialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/serialization/Interner;", ExifInterface.GPS_DIRECTION_TRUE, "", "parent", "(Lorg/jetbrains/kotlin/metadata/serialization/Interner;)V", "allInternedObjects", "", "getAllInternedObjects", "()Ljava/util/List;", "firstIndex", "", "interned", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isEmpty", "", "()Z", "find", "obj", "(Ljava/lang/Object;)Ljava/lang/Integer;", "intern", "(Ljava/lang/Object;)I", "metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Interner<T> {
    private final int firstIndex;
    private final HashMap<T, Integer> interned;
    private final Interner<T> parent;

    /* JADX WARN: Multi-variable type inference failed */
    public Interner() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Integer find(T r5) {
        Interner<T> r10 = this.parent;
        if (r10 == null) goto L5;
        int r11 = r10.interned.size() + this.parent.firstIndex;
        int r12 = this.firstIndex;
    L5:
        Interner<T> r13 = this.parent;
        if (r13 == null) goto L10;
        Integer r14 = r13.find(r5);
        if (r14 == null) goto L10;
        return r14;
    L10:
        return this.interned.get(r5);
    }

    public final List<T> getAllInternedObjects() {
        Set<T> r5 = this.interned.keySet();
        final HashMap<T, Integer> r10 = this.interned;
        return CollectionsKt.sortedWith(r5, new Interner$special$$inlined$sortedBy$1(r10));
    }

    public final int intern(T r5) {
        Integer r10 = find(r5);
        if (r10 != null) goto L7;
        int r11 = this.firstIndex + this.interned.size();
        Integer r12 = Integer.valueOf(r11);
        this.interned.put(r5, r12);
        return r11;
    L7:
        return r10.intValue();
    }

    public final boolean isEmpty() {
        if (this.interned.isEmpty() == false) goto L10;
        Interner<T> r5 = this.parent;
        if (r5 != null) goto L7;
    L9:
        return true;
    L7:
        if (r5.isEmpty() == true) goto L9;
    L10:
        return false;
    }

    public Interner(Interner<T> r5) {
        this.parent = r5;
        if (r5 == null) goto L5;
        int r10 = r5.interned.size() + r5.firstIndex;
    L6:
        this.firstIndex = r10;
        this.interned = new HashMap();
        return;
    L5:
        r10 = 0;
        goto L6
    }

    public /* synthetic */ Interner(Interner r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
