package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B;\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJY\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0002\u0010\u00152\u0006\u0010\u0007\u001a\u00020\b26\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\r\u0010$\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\bH\u0016J\u0006\u0010'\u001a\u00020\"J\r\u0010(\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010%J\b\u0010)\u001a\u00020*H\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Landroidx/paging/PagingState;", "Key", "", "Value", "pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "anchorPosition", "", "config", "Landroidx/paging/PagingConfig;", "leadingPlaceholderCount", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", "getAnchorPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfig", "()Landroidx/paging/PagingConfig;", "getPages", "()Ljava/util/List;", "anchorPositionToPagedIndices", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "pageIndex", "index", "anchorPositionToPagedIndices$paging_common", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "closestItemToPosition", "(I)Ljava/lang/Object;", "closestPageToPosition", "equals", "", "other", "firstItemOrNull", "()Ljava/lang/Object;", "hashCode", "isEmpty", "lastItemOrNull", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagingState<Key, Value> {
    private final Integer anchorPosition;
    private final PagingConfig config;
    private final int leadingPlaceholderCount;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;

    public PagingState(List<PagingSource.LoadResult.Page<Key, Value>> r3, Integer r4, PagingConfig r5, int r6) {
        List<PagingSource.LoadResult.Page<Key, Value>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "pages");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.pages = r7;
        this.anchorPosition = r4;
        this.config = r5;
        this.leadingPlaceholderCount = r6;
    }

    public static final /* synthetic */ int access$getLeadingPlaceholderCount$p(PagingState r0) {
        return r0.leadingPlaceholderCount;
    }

    public final <T> T anchorPositionToPagedIndices$paging_common(int r5, Function2<? super Integer, ? super Integer, ? extends T> r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "block");
        int r8 = r5 - access$getLeadingPlaceholderCount$p(this);
        int r0 = 0;
    L4:
        if (r0 >= CollectionsKt.getLastIndex(getPages())) goto L9;
        if (r8 <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(getPages().get(r0), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData())) goto L9;
        r8 = r8 - ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(getPages().get(r0), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        r0 = r0 + 1;
    L9:
        return (T) r7.invoke(Integer.valueOf(r0), Integer.valueOf(r8));
    }

    public final Value closestItemToPosition(int r9) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r1.next(), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().isEmpty() == true) goto L9;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L16;
        return null;
    L16:
        int r10 = r9 - access$getLeadingPlaceholderCount$p(this);
    L18:
        if (r3 >= CollectionsKt.getLastIndex(getPages())) goto L22;
        if (r10 <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(getPages().get(r3), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData())) goto L22;
        r10 = r10 - ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(getPages().get(r3), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        r3 = r3 + 1;
    L22:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r4.hasNext() == false) goto L45;
        Object r5 = r4.next();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r5, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        PagingSource.LoadResult.Page r6 = (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r5, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
        List<PagingSource.LoadResult.Page<Key, Value>> r7 = this.pages;
        ListIterator<PagingSource.LoadResult.Page<Key, Value>> r8 = r7.listIterator(r7.size());
    L29:
        if (r8.hasPrevious() == false) goto L43;
        PagingSource.LoadResult.Page<Key, Value> r11 = r8.previous();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r11, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L29;
        PagingSource.LoadResult.Page r12 = (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r11, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
        if (r10 >= 0) goto L36;
        return (Value) CollectionsKt.first(r6.getData());
    L36:
        if (r3 != CollectionsKt.getLastIndex(this.pages)) goto L41;
        if (r10 <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.pages), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData())) goto L41;
        return (Value) CollectionsKt.last(r12.getData());
    L41:
        return ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.get(r3), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().get(r10);
    L43:
        throw new NoSuchElementException("List contains no element matching the predicate.");
    L45:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L6:
        r2 = true;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    public final PagingSource.LoadResult.Page<Key, Value> closestPageToPosition(int r7) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin");
        int r3 = 0;
        boolean r4 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r1.next(), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().isEmpty() == true) goto L9;
        r4 = false;
    L13:
        if (r4 == false) goto L16;
        return null;
    L16:
        int r8 = r7 - access$getLeadingPlaceholderCount$p(this);
    L18:
        if (r3 >= CollectionsKt.getLastIndex(getPages())) goto L22;
        if (r8 <= CollectionsKt.getLastIndex(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(getPages().get(r3), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData())) goto L22;
        r8 = r8 - ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(getPages().get(r3), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        r3 = r3 + 1;
    L22:
        List<PagingSource.LoadResult.Page<Key, Value>> r6 = this.pages;
        if (r8 >= 0) goto L25;
        Object r9 = CollectionsKt.first(r6);
    L27:
        return (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r9, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
    L25:
        r9 = r6.get(r3);
        goto L27
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, PagingState.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (Intrinsics.areEqual(this.pages, ((PagingState) ZeusTransformUtils.preCheckCast(r5, PagingState.class, "com.obric.memorydata.plugin")).pages) == false) goto L13;
        if (Intrinsics.areEqual(this.anchorPosition, ((PagingState) ZeusTransformUtils.preCheckCast(r5, PagingState.class, "com.obric.memorydata.plugin")).anchorPosition) == false) goto L13;
        if (Intrinsics.areEqual(this.config, ((PagingState) ZeusTransformUtils.preCheckCast(r5, PagingState.class, "com.obric.memorydata.plugin")).config) == false) goto L13;
        if (this.leadingPlaceholderCount != ((PagingState) ZeusTransformUtils.preCheckCast(r5, PagingState.class, "com.obric.memorydata.plugin")).leadingPlaceholderCount) goto L13;
        return true;
    }

    public final Value firstItemOrNull() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r0, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L4;
    L9:
        PagingSource.LoadResult.Page r6 = (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r0, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L18;
        List<Value> r7 = r6.getData();
        if (r7 != null) goto L14;
        return null;
    L14:
        return (Value) CollectionsKt.firstOrNull(r7);
    L18:
        return null;
    L8:
        r0 = null;
        goto L9
    }

    public final Integer getAnchorPosition() {
        return this.anchorPosition;
    }

    public final PagingConfig getConfig() {
        return this.config;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages() {
        return this.pages;
    }

    public int hashCode() {
        int r0 = this.pages.hashCode();
        Integer r1 = this.anchorPosition;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) + this.config.hashCode()) + Integer.hashCode(this.leadingPlaceholderCount);
    L5:
        r2 = 0;
        goto L7
    }

    public final boolean isEmpty() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r5.next(), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().isEmpty() == true) goto L9;
        return false;
    L18:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return true;
    }

    public final Value lastItemOrNull() {
        List<PagingSource.LoadResult.Page<Key, Value>> r5 = this.pages;
        ListIterator<PagingSource.LoadResult.Page<Key, Value>> r6 = r5.listIterator(r5.size());
    L4:
        if (r6.hasPrevious() == false) goto L8;
        PagingSource.LoadResult.Page<Key, Value> r0 = r6.previous();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r0, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L4;
    L9:
        PagingSource.LoadResult.Page r7 = (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r0, PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L18;
        List<Value> r8 = r7.getData();
        if (r8 != null) goto L14;
        return null;
    L14:
        return (Value) CollectionsKt.lastOrNull(r8);
    L18:
        return null;
    L8:
        r0 = null;
        goto L9
    }

    public String toString() {
        return "PagingState(pages=" + this.pages + ", anchorPosition=" + this.anchorPosition + ", config=" + this.config + ", leadingPlaceholderCount=" + this.leadingPlaceholderCount + ')';
    }
}
