package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0015J\u0016\u0010\u0016\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002J\u0016\u0010\u0018\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/paging/FlattenedPageEventStorage;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "mediatorStates", "Landroidx/paging/LoadStates;", "pages", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "placeholdersBefore", "receivedFirstEvent", "", "sourceStates", "Landroidx/paging/MutableLoadStateCollection;", "add", "", "event", "Landroidx/paging/PageEvent;", "getAsEvents", "", "handleInsert", "Landroidx/paging/PageEvent$Insert;", "handleLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "handlePageDrop", "Landroidx/paging/PageEvent$Drop;", "handleStaticList", "Landroidx/paging/PageEvent$StaticList;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlattenedPageEventStorage<T> {
    private LoadStates mediatorStates;
    private final ArrayDeque<TransformablePage<T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private boolean receivedFirstEvent;
    private final MutableLoadStateCollection sourceStates;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.PREPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LoadType.APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LoadType.REFRESH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public FlattenedPageEventStorage() {
        this.pages = new ArrayDeque();
        this.sourceStates = new MutableLoadStateCollection();
    }

    private final void handleInsert(PageEvent.Insert<T> r6) {
        this.sourceStates.set(r6.getSourceLoadStates());
        this.mediatorStates = r6.getMediatorLoadStates();
        LoadType r0 = r6.getLoadType();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        this.placeholdersBefore = r6.getPlaceholdersBefore();
        Iterator<T> r2 = ((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.downTo(r6.getPages().size() - 1, 0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r2.hasNext() == false) goto L19;
        int r3 = ((IntIterator) ZeusTransformUtils.preCheckCast(r2, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        this.pages.addFirst(r6.getPages().get(r3));
        goto L14
    L19:
        return;
    L5:
        if (r1 != 2) goto L7;
        this.placeholdersAfter = r6.getPlaceholdersAfter();
    L11:
        this.pages.addAll((Collection) ZeusTransformUtils.preCheckCast(r6.getPages(), Collection.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        if (r1 != 3) goto L18;
        this.pages.clear();
        this.placeholdersAfter = r6.getPlaceholdersAfter();
        this.placeholdersBefore = r6.getPlaceholdersBefore();
        goto L11
    }

    private final void handleLoadStateUpdate(PageEvent.LoadStateUpdate<T> r3) {
        this.sourceStates.set(r3.getSource());
        this.mediatorStates = r3.getMediator();
    }

    private final void handlePageDrop(PageEvent.Drop<T> r6) {
        this.sourceStates.set(r6.getLoadType(), (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
        LoadType r0 = r6.getLoadType();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        int r2 = 0;
        if (r1 != 1) goto L5;
        this.placeholdersBefore = r6.getPlaceholdersRemaining();
        int r7 = r6.getPageCount();
    L12:
        if (r2 >= r7) goto L17;
        this.pages.removeFirst();
        r2 = r2 + 1;
        goto L12
    L17:
        return;
    L5:
        if (r1 != 2) goto L10;
        this.placeholdersAfter = r6.getPlaceholdersRemaining();
        int r8 = r6.getPageCount();
    L7:
        if (r2 >= r8) goto L14;
        this.pages.removeLast();
        r2 = r2 + 1;
        goto L7
    L14:
        return;
    L10:
        throw new IllegalArgumentException("Page drop type must be prepend or append");
    }

    private final void handleStaticList(PageEvent.StaticList<T> r3) {
        if (r3.getSourceLoadStates() == null) goto L6;
        this.sourceStates.set(r3.getSourceLoadStates());
    L6:
        if (r3.getMediatorLoadStates() == null) goto L8;
        this.mediatorStates = r3.getMediatorLoadStates();
    L8:
        this.pages.clear();
        this.placeholdersAfter = 0;
        this.placeholdersBefore = 0;
        this.pages.add(new TransformablePage(0, r3.getData()));
    }

    public final void add(PageEvent<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        this.receivedFirstEvent = true;
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.Insert.class) == false) goto L6;
        handleInsert((PageEvent.Insert) ZeusTransformUtils.preCheckCast(r3, PageEvent.Insert.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.Drop.class) == false) goto L9;
        handlePageDrop((PageEvent.Drop) ZeusTransformUtils.preCheckCast(r3, PageEvent.Drop.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.LoadStateUpdate.class) == false) goto L12;
        handleLoadStateUpdate((PageEvent.LoadStateUpdate) ZeusTransformUtils.preCheckCast(r3, PageEvent.LoadStateUpdate.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.StaticList.class) == false) goto L18;
        handleStaticList((PageEvent.StaticList) ZeusTransformUtils.preCheckCast(r3, PageEvent.StaticList.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final List<PageEvent<T>> getAsEvents() {
        if (this.receivedFirstEvent == false) goto L5;
        List<PageEvent<T>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        LoadStates r7 = this.sourceStates.snapshot();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.pages, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        r0.add(PageEvent.Insert.Companion.Refresh(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin")), this.placeholdersBefore, this.placeholdersAfter, r7, this.mediatorStates));
    L10:
        return r0;
    L9:
        r0.add(new PageEvent.LoadStateUpdate(r7, this.mediatorStates));
        goto L10
    L5:
        return CollectionsKt.emptyList();
    }
}
