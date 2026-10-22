package androidx.room.compiler.processing;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b`\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u001c\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XEquality;", "", "equalityItems", "", "getEqualityItems", "()[Ljava/lang/Object;", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XEquality {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J/\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00072\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/room/compiler/processing/XEquality$Companion;", "", "()V", "equals", "", "first", "second", "", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "hashCode", "", "elements", "([Ljava/lang/Object;)I", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final boolean equals(Object r5, Object r10) {
            if ((r5 instanceof XEquality) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof XEquality) == true) goto L8;
            return false;
        L8:
            return equals(((XEquality) r5).getEqualityItems(), ((XEquality) r10).getEqualityItems());
        }

        public final int hashCode(Object[] r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            return Arrays.hashCode(r5);
        }

        public final boolean equals(Object[] r5, Object[] r10) {
            Intrinsics.checkNotNullParameter(r5, "first");
            Intrinsics.checkNotNullParameter(r10, "second");
            if (r5.length == r10.length) goto L5;
            return false;
        L5:
            int r11 = r5.length;
            int r12 = 0;
        L6:
            if (r12 >= r11) goto L11;
            if (Intrinsics.areEqual(r5[r12], r10[r12]) == false) goto L9;
            r12 = r12 + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Object[] getEqualityItems();
}
