package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005:\u0001YB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fB\u0015\b\u0012\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\u000eJ+\u00100\u001a\u0002012\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0000¢\u0006\u0002\b4J\u0018\u00105\u001a\u0004\u0018\u00018\u00002\u0006\u00106\u001a\u00020\bH\u0096\u0002¢\u0006\u0002\u00107J\u0015\u00108\u001a\u00028\u00002\u0006\u00109\u001a\u00020\bH\u0016¢\u0006\u0002\u00107J\u001a\u0010:\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010;2\u0006\u0010<\u001a\u00020=JD\u0010>\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J:\u0010>\u001a\u0002012\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0002J\u0016\u0010C\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bJ\u0016\u0010D\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bJ+\u0010E\u001a\u0002012\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0000¢\u0006\u0002\bFJ\u001e\u0010G\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010J\u001a\u00020KH\u0016J`\u0010L\u001a\u0002HM\"\u0004\b\u0001\u0010M2\u0006\u00109\u001a\u00020\b2B\b\u0004\u0010N\u001a<\u0012\u001d\u0012\u001b\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\b¢\u0006\f\bP\u0012\b\bQ\u0012\u0004\b\b(R\u0012\u0004\u0012\u0002HM0OH\u0082\b¢\u0006\u0002\u0010SJ-\u0010T\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bVJ-\u0010W\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\bXR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00028\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00028\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u001d\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u001e\u0010!\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001e\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u001e\u0010(\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0013R\u0014\u0010,\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0017R\u001e\u0010.\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017¨\u0006Z"}, d2 = {"Landroidx/paging/PagedStorage;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/AbstractList;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/NullPaddedList;", "()V", "leadingNulls", "", "page", "Landroidx/paging/PagingSource$LoadResult$Page;", "trailingNulls", "(ILandroidx/paging/PagingSource$LoadResult$Page;I)V", "other", "(Landroidx/paging/PagedStorage;)V", "counted", "", "firstLoadedItem", "getFirstLoadedItem$paging_common", "()Ljava/lang/Object;", EventBody.KEY_VALUE, "lastLoadAroundIndex", "getLastLoadAroundIndex", "()I", "setLastLoadAroundIndex", "(I)V", "lastLoadAroundLocalIndex", "lastLoadedItem", "getLastLoadedItem$paging_common", "middleOfLoadedRange", "getMiddleOfLoadedRange", "nextKey", "getNextKey", "pages", "", "<set-?>", "placeholdersAfter", "getPlaceholdersAfter", "placeholdersBefore", "getPlaceholdersBefore", "positionOffset", "getPositionOffset", "prevKey", "getPrevKey", "size", "getSize", "storageCount", "getStorageCount", "appendPage", "", "callback", "Landroidx/paging/PagedStorage$Callback;", "appendPage$paging_common", "get", "index", "(I)Ljava/lang/Object;", "getFromStorage", "localIndex", "getRefreshKeyInfo", "Landroidx/paging/PagingState;", "config", "Landroidx/paging/PagedList$Config;", CommonConsts.APM_INNER_EVENT_COST_INIT, "needsTrim", "maxSize", "requiredRemaining", "localPageIndex", "needsTrimFromEnd", "needsTrimFromFront", "prependPage", "prependPage$paging_common", "shouldPreTrimNewPage", "countToBeAdded", "snapshot", "toString", "", "traversePages", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "onLastPage", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "pageInternalIndex", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "trimFromEnd", "insertNulls", "trimFromEnd$paging_common", "trimFromFront", "trimFromFront$paging_common", "Callback", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, NullPaddedList<T> {
    private boolean counted;
    private int lastLoadAroundLocalIndex;
    private final List<PagingSource.LoadResult.Page<?, T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int positionOffset;
    private int storageCount;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/paging/PagedStorage$Callback;", "", "onInitialized", "", CommonConsts.COUNT_TYPE, "", "onPageAppended", "endPosition", "changed", "added", "onPagePrepended", "leadingNulls", "onPagesRemoved", "startOfDrops", "onPagesSwappedToPlaceholder", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Callback {
        void onInitialized(int r1);

        void onPageAppended(int r1, int r2, int r3);

        void onPagePrepended(int r1, int r2, int r3);

        void onPagesRemoved(int r1, int r2);

        void onPagesSwappedToPlaceholder(int r1, int r2);
    }

    public PagedStorage() {
        this.pages = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.counted = true;
    }

    public PagedStorage(int r8, PagingSource.LoadResult.Page<?, T> r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "page");
        this();
        init(r8, r9, r10, 0, true);
    }

    private PagedStorage(PagedStorage<T> r5) {
        List<PagingSource.LoadResult.Page<?, T>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.pages = r0;
        this.counted = true;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r5.pages, Collection.class, "com.obric.memorydata.plugin"));
        this.placeholdersBefore = r5.getPlaceholdersBefore();
        this.placeholdersAfter = r5.getPlaceholdersAfter();
        this.positionOffset = r5.positionOffset;
        this.counted = r5.counted;
        this.storageCount = r5.getStorageCount();
        this.lastLoadAroundLocalIndex = r5.lastLoadAroundLocalIndex;
    }

    public static /* synthetic */ void appendPage$paging_common$default(PagedStorage r1, PagingSource.LoadResult.Page r2, Callback r3, int r4, Object r5) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.appendPage$paging_common(r2, r6);
    }

    private final void init(int r1, PagingSource.LoadResult.Page<?, T> r2, int r3, int r4, boolean r5) {
        this.placeholdersBefore = r1;
        this.pages.clear();
        this.pages.add(r2);
        this.placeholdersAfter = r3;
        this.positionOffset = r4;
        this.storageCount = r2.getData().size();
        this.counted = r5;
        this.lastLoadAroundLocalIndex = r2.getData().size() / 2;
    }

    public static /* synthetic */ void init$default(PagedStorage r7, int r8, PagingSource.LoadResult.Page r9, int r10, int r11, Callback r12, boolean r13, int r14, Object r15) {
        Callback r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r12, Callback.class, "com.obric.memorydata.plugin");
        if ((r14 & 32) == 0) goto L5;
        r13 = true;
    L5:
        r7.init(r8, r9, r10, r11, r5, r13);
    }

    private final boolean needsTrim(int r3, int r4, int r5) {
        PagingSource.LoadResult.Page r6 = (PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.get(r5), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin");
        if (getStorageCount() > r3) goto L5;
    L9:
        return false;
    L5:
        if (this.pages.size() <= 2) goto L9;
        if ((getStorageCount() - r6.getData().size()) < r4) goto L9;
        return true;
    }

    public static /* synthetic */ void prependPage$paging_common$default(PagedStorage r1, PagingSource.LoadResult.Page r2, Callback r3, int r4, Object r5) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.prependPage$paging_common(r2, r6);
    }

    private final <V> V traversePages(int r6, Function2<? super PagingSource.LoadResult.Page<?, T>, ? super Integer, ? extends V> r7) {
        Function2 r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        int r0 = this.pages.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int r3 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.get(r2), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        if (r3 > r6) goto L9;
        r6 = r6 - r3;
        r2 = r2 + 1;
    L9:
        return (V) r8.invoke(this.pages.get(r2), Integer.valueOf(r6));
    }

    public final void appendPage$paging_common(PagingSource.LoadResult.Page<?, T> r4, Callback r5) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r5, Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "page");
        int r0 = r4.getData().size();
        if (r0 != 0) goto L5;
        return;
    L5:
        this.pages.add(r4);
        this.storageCount = getStorageCount() + r0;
        int r7 = Math.min(getPlaceholdersAfter(), r0);
        int r1 = r0 - r7;
        if (r7 == 0) goto L8;
        this.placeholdersAfter = getPlaceholdersAfter() - r7;
    L8:
        if (r6 == null) goto L11;
        r6.onPageAppended((getPlaceholdersBefore() + getStorageCount()) - r0, r7, r1);
        return;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r4) {
        int r0 = r4 - getPlaceholdersBefore();
        if (r4 < 0) goto L14;
        if (r4 >= size()) goto L14;
        if (r0 >= 0) goto L8;
    L11:
        return null;
    L8:
        if (r0 >= getStorageCount()) goto L11;
        return getFromStorage(r0);
    L14:
        throw new IndexOutOfBoundsException("Index: " + r4 + ", Size: " + size());
    }

    public final T getFirstLoadedItem$paging_common() {
        return (T) CollectionsKt.first(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.first(this.pages), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData());
    }

    @Override // androidx.paging.NullPaddedList
    public T getFromStorage(int r6) {
        int r0 = this.pages.size();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L10;
        int r3 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.get(r1), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        if (r3 > r6) goto L10;
        r6 = r6 - r3;
        r1 = r1 + 1;
    L10:
        return (T) ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.get(r1), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().get(r6);
    }

    public final int getLastLoadAroundIndex() {
        return getPlaceholdersBefore() + this.lastLoadAroundLocalIndex;
    }

    public final T getLastLoadedItem$paging_common() {
        return (T) CollectionsKt.last(((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.pages), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData());
    }

    public final int getMiddleOfLoadedRange() {
        return getPlaceholdersBefore() + (getStorageCount() / 2);
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object getNextKey() {
        if (this.counted == false) goto L9;
        if (getPlaceholdersAfter() > 0) goto L9;
        return null;
    L9:
        return ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.pages), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getNextKey();
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final int getPositionOffset() {
        return this.positionOffset;
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object getPrevKey() {
        if (this.counted == false) goto L9;
        if ((getPlaceholdersBefore() + this.positionOffset) > 0) goto L9;
        return null;
    L9:
        return ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(CollectionsKt.first(this.pages), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getPrevKey();
    }

    public final PagingState<?, T> getRefreshKeyInfo(PagedList.Config r14) {
        Intrinsics.checkNotNullParameter(r14, "config");
        if (this.pages.isEmpty() == false) goto L6;
        return null;
    L6:
        List r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T of androidx.paging.PagedStorage>>");
        return new PagingState(r1, Integer.valueOf(getLastLoadAroundIndex()), new PagingConfig(r14.pageSize, r14.prefetchDistance, r14.enablePlaceholders, r14.initialLoadSizeHint, r14.maxSize, 0, 32, null), getPlaceholdersBefore());
    }

    @Override // androidx.paging.NullPaddedList
    public int getSize() {
        return (getPlaceholdersBefore() + getStorageCount()) + getPlaceholdersAfter();
    }

    @Override // androidx.paging.NullPaddedList
    public int getStorageCount() {
        return this.storageCount;
    }

    public final void init(int r7, PagingSource.LoadResult.Page<?, T> r8, int r9, int r10, Callback r11, boolean r12) {
        Callback r13 = (Callback) ZeusTransformUtils.wrapperContextForParams(r11, Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "page");
        Intrinsics.checkNotNullParameter(r13, "callback");
        init(r7, r8, r9, r10, r12);
        r13.onInitialized(size());
    }

    public final boolean needsTrimFromEnd(int r2, int r3) {
        return needsTrim(r2, r3, this.pages.size() - 1);
    }

    public final boolean needsTrimFromFront(int r2, int r3) {
        return needsTrim(r2, r3, 0);
    }

    public final void prependPage$paging_common(PagingSource.LoadResult.Page<?, T> r4, Callback r5) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r5, Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "page");
        int r0 = r4.getData().size();
        if (r0 != 0) goto L5;
        return;
    L5:
        this.pages.add(0, r4);
        this.storageCount = getStorageCount() + r0;
        int r7 = Math.min(getPlaceholdersBefore(), r0);
        int r1 = r0 - r7;
        if (r7 == 0) goto L8;
        this.placeholdersBefore = getPlaceholdersBefore() - r7;
    L8:
        this.positionOffset -= r1;
        if (r6 == null) goto L12;
        r6.onPagePrepended(getPlaceholdersBefore(), r7, r1);
        return;
    }

    @Override // java.util.AbstractList, java.util.List
    public final T remove(int r1) {
        return (T) removeAt(r1);
    }

    public Object removeAt(int r1) {
        return super.remove(r1);
    }

    public final void setLastLoadAroundIndex(int r3) {
        this.lastLoadAroundLocalIndex = RangesKt.coerceIn(r3 - getPlaceholdersBefore(), 0, getStorageCount() - 1);
    }

    public final boolean shouldPreTrimNewPage(int r2, int r3, int r4) {
        if ((getStorageCount() + r4) > r2) goto L5;
    L9:
        return false;
    L5:
        if (this.pages.size() <= 1) goto L9;
        if (getStorageCount() < r3) goto L9;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return getSize();
    }

    public final PagedStorage<T> snapshot() {
        return new PagedStorage(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "leading " + getPlaceholdersBefore() + ", storage " + getStorageCount() + ", trailing " + getPlaceholdersAfter() + ' ' + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    }

    public final boolean trimFromEnd$paging_common(boolean r7, int r8, int r9, Callback r10) {
        Callback r11 = (Callback) ZeusTransformUtils.wrapperContextForParams(r10, Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "callback");
        int r2 = 0;
    L4:
        if (needsTrimFromEnd(r8, r9) == false) goto L6;
        List<PagingSource.LoadResult.Page<?, T>> r3 = this.pages;
        int r4 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(r3.remove(r3.size() - 1), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        r2 = r2 + r4;
        this.storageCount = getStorageCount() - r4;
        goto L4
    L6:
        this.lastLoadAroundLocalIndex = RangesKt.coerceAtMost(this.lastLoadAroundLocalIndex, getStorageCount() - 1);
        if (r2 <= 0) goto L12;
        int r12 = getPlaceholdersBefore() + getStorageCount();
        if (r7 == false) goto L11;
        this.placeholdersAfter = getPlaceholdersAfter() + r2;
        r11.onPagesSwappedToPlaceholder(r12, r2);
        goto L12
    L11:
        r11.onPagesRemoved(r12, r2);
    L12:
        if (r2 > 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean trimFromFront$paging_common(boolean r6, int r7, int r8, Callback r9) {
        Callback r10 = (Callback) ZeusTransformUtils.wrapperContextForParams(r9, Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "callback");
        int r2 = 0;
    L4:
        if (needsTrimFromFront(r7, r8) == false) goto L6;
        int r3 = ((PagingSource.LoadResult.Page) ZeusTransformUtils.preCheckCast(this.pages.remove(0), PagingSource.LoadResult.Page.class, "com.obric.memorydata.plugin")).getData().size();
        r2 = r2 + r3;
        this.storageCount = getStorageCount() - r3;
        goto L4
    L6:
        this.lastLoadAroundLocalIndex = RangesKt.coerceAtLeast(this.lastLoadAroundLocalIndex - r2, 0);
        if (r2 <= 0) goto L11;
        if (r6 == false) goto L10;
        int r11 = getPlaceholdersBefore();
        this.placeholdersBefore = getPlaceholdersBefore() + r2;
        r10.onPagesSwappedToPlaceholder(r11, r2);
        goto L11
    L10:
        this.positionOffset += r2;
        r10.onPagesRemoved(getPlaceholdersBefore(), r2);
    L11:
        if (r2 <= 0) goto L15;
        return true;
    L15:
        return false;
    }
}
