package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@SourceDebugExtension({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    @SourceDebugExtension({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n+ 2 Menu.kt\nandroidx/core/view/MenuKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n83#2:91\n1#3:92\n*S KotlinDebug\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt$iterator$1\n*L\n74#1:91\n74#1:92\n*E\n"})
    public static final class AnonymousClass1 implements Iterator<MenuItem>, KMutableIterator {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        AnonymousClass1(Menu r10) {
            this.$this_iterator = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu r10 = this.$this_iterator;
            int r11 = this.index;
            this.index = r11 + 1;
            MenuItem r12 = r10.getItem(r11);
            if (r12 == null) goto L6;
            return r12;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ MenuItem next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu r10 = this.$this_iterator;
            int r11 = this.index - 1;
            this.index = r11;
            MenuItem r12 = r10.getItem(r11);
            if (r12 == null) goto L5;
            Intrinsics.checkNotNullExpressionValue(r12, "getItem(index)");
            r10.removeItem(r12.getItemId());
            Unit r13 = Unit.INSTANCE;
        L6:
            if (r13 == null) goto L9;
            return;
        L9:
            throw new IndexOutOfBoundsException();
        L5:
            r13 = null;
            goto L6
        }
    }

    public static final boolean contains(Menu r10, MenuItem r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "item");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (Intrinsics.areEqual(r10.getItem(r13), r11) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final void forEach(Menu r10, Function1<? super MenuItem, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        MenuItem r14 = r10.getItem(r13);
        Intrinsics.checkNotNullExpressionValue(r14, "getItem(index)");
        r11.invoke(r14);
        r13 = r13 + 1;
        goto L3
    }

    public static final void forEachIndexed(Menu r10, Function2<? super Integer, ? super MenuItem, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Integer r14 = Integer.valueOf(r13);
        MenuItem r15 = r10.getItem(r13);
        Intrinsics.checkNotNullExpressionValue(r15, "getItem(index)");
        r11.invoke(r14, r15);
        r13 = r13 + 1;
        goto L3
    }

    public static final MenuItem get(Menu r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        MenuItem r12 = r10.getItem(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "getItem(index)");
        return r12;
    }

    public static final Sequence<MenuItem> getChildren(final Menu r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new MenuKt$children$1(r10);
    }

    public static final int getSize(Menu r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    public static final boolean isEmpty(Menu r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(Menu r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new AnonymousClass1(r10);
    }

    public static final void minusAssign(Menu r10, MenuItem r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "item");
        r10.removeItem(r11.getItemId());
    }

    public static final void removeItemAt(Menu r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        MenuItem r12 = r10.getItem(r11);
        if (r12 == null) goto L5;
        r10.removeItem(r12.getItemId());
        Unit r13 = Unit.INSTANCE;
    L6:
        if (r13 == null) goto L9;
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L5:
        r13 = null;
        goto L6
    }
}
