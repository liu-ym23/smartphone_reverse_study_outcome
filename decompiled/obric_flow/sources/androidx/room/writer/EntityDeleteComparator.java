package androidx.room.writer;

import androidx.room.vo.Entity;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/room/writer/EntityDeleteComparator;", "Ljava/util/Comparator;", "Landroidx/room/vo/Entity;", "Lkotlin/Comparator;", "()V", "compare", "", "lhs", "rhs", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityDeleteComparator implements Comparator<Entity> {
    public EntityDeleteComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Entity r5, Entity r10) {
        return compare2(r5, r10);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Entity r5, Entity r10) {
        Intrinsics.checkNotNullParameter(r5, "lhs");
        Intrinsics.checkNotNullParameter(r10, "rhs");
        boolean r11 = r5.shouldBeDeletedAfter(r10);
        boolean r12 = r10.shouldBeDeletedAfter(r5);
        if (r11 == r12) goto L12;
        if (r11 == false) goto L7;
        return -1;
    L7:
        if (r12 == false) goto L11;
        return 1;
    L11:
        return 0;
    L12:
        return 0;
    }
}
