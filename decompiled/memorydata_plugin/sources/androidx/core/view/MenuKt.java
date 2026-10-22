package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "removeItemAt", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<MenuItem>, KMutableIterator {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        AnonymousClass1(Menu r3) {
            this.$this_iterator = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
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
            Menu r0 = this.$this_iterator;
            int r1 = this.index;
            this.index = r1 + 1;
            MenuItem r3 = r0.getItem(r1);
            if (r3 == null) goto L6;
            return r3;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ MenuItem next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu r0 = this.$this_iterator;
            int r1 = this.index - 1;
            this.index = r1;
            MenuItem r2 = r0.getItem(r1);
            if (r2 == null) goto L5;
            r0.removeItem(r2.getItemId());
            Unit r3 = Unit.INSTANCE;
        L6:
            if (r3 == null) goto L9;
            return;
        L9:
            throw new IndexOutOfBoundsException();
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final boolean contains(Menu r4, MenuItem r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r5, MenuItem.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (Intrinsics.areEqual(r6.getItem(r2), r7) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final void forEach(Menu r3, Function1<? super MenuItem, Unit> r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r6.invoke(r5.getItem(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final void forEachIndexed(Menu r4, Function2<? super Integer, ? super MenuItem, Unit> r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.memorydata.plugin");
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r7.invoke(Integer.valueOf(r1), r6.getItem(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final MenuItem get(Menu r2, int r3) {
        return ((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).getItem(r3);
    }

    public static final Sequence<MenuItem> getChildren(Menu r2) {
        final Menu r3 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
        return (Sequence) ZeusTransformUtils.preCheckCast(new MenuKt$children$1(r3), Sequence.class, "com.obric.memorydata.plugin");
    }

    public static final int getSize(Menu r2) {
        return ((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).size();
    }

    public static final boolean isEmpty(Menu r2) {
        if (((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(Menu r2) {
        if (((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu r2) {
        return (Iterator) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")), Iterator.class, "com.obric.memorydata.plugin");
    }

    public static final void minusAssign(Menu r2, MenuItem r3) {
        ((Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin")).removeItem(((MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.memorydata.plugin")).getItemId());
    }

    public static final void removeItemAt(Menu r2, int r3) {
        Menu r4 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.memorydata.plugin");
        MenuItem r5 = r4.getItem(r3);
        if (r5 == null) goto L5;
        r4.removeItem(r5.getItemId());
        Unit r6 = Unit.INSTANCE;
    L6:
        if (r6 == null) goto L9;
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L5:
        r6 = null;
        goto L6
    }
}
