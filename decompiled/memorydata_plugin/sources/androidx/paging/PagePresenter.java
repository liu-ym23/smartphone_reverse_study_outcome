package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 8*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000289B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006B)\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u001e\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0002J\u0015\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001d\u001a\u00020\u000b¢\u0006\u0002\u0010)J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010)J\u0006\u0010,\u001a\u00020-J\u001e\u0010.\u001a\u00020\u001f2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010#\u001a\u00020$H\u0002J\u001c\u00100\u001a\u00020\u001f2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u0000022\u0006\u0010#\u001a\u00020$J\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004J\b\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bH\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006:"}, d2 = {"Landroidx/paging/PagePresenter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/NullPaddedList;", "insertEvent", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;)V", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "(Ljava/util/List;II)V", "originalPageOffsetFirst", "getOriginalPageOffsetFirst", "()I", "originalPageOffsetLast", "getOriginalPageOffsetLast", "", "<set-?>", "getPlaceholdersAfter", "getPlaceholdersBefore", "size", "getSize", "storageCount", "getStorageCount", "accessHintForPresenterIndex", "Landroidx/paging/ViewportHint$Access;", "index", "checkIndex", "", "dropPages", "drop", "Landroidx/paging/PageEvent$Drop;", "callback", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "dropPagesWithOffsets", "pageOffsetsToDrop", "Lkotlin/ranges/IntRange;", "get", "(I)Ljava/lang/Object;", "getFromStorage", "localIndex", "initializeHint", "Landroidx/paging/ViewportHint$Initial;", "insertPage", "insert", "processEvent", "pageEvent", "Landroidx/paging/PageEvent;", "snapshot", "Landroidx/paging/ItemSnapshotList;", "toString", "", "fullCount", "Companion", "ProcessPageEventCallback", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagePresenter<T> implements NullPaddedList<T> {
    public static final Companion Companion = null;
    private static final PagePresenter<Object> INITIAL = null;
    private final List<TransformablePage<T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int storageCount;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\bH\u0000¢\u0006\u0002\b\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/paging/PagePresenter$Companion;", "", "()V", "INITIAL", "Landroidx/paging/PagePresenter;", "initial", ExifInterface.GPS_DIRECTION_TRUE, "event", "Landroidx/paging/PageEvent$Insert;", "initial$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final <T> PagePresenter<T> initial$paging_common(PageEvent.Insert<T> r1) {
            if (r1 != null) goto L6;
            PagePresenter<T> r0 = PagePresenter.access$getINITIAL$cp();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.paging.PagePresenter<T of androidx.paging.PagePresenter.Companion.initial>");
            return r0;
        L6:
            return new PagePresenter(r1);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "onChanged", "", "position", "", CommonConsts.COUNT_TYPE, "onInserted", "onRemoved", "onStateUpdate", AILabCheckPermissionTask.KEY_SOURCE, "Landroidx/paging/LoadStates;", "mediator", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProcessPageEventCallback {
        void onChanged(int r1, int r2);

        void onInserted(int r1, int r2);

        void onRemoved(int r1, int r2);

        void onStateUpdate(LoadStates r1, LoadStates r2);

        void onStateUpdate(LoadType r1, boolean r2, LoadState r3);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[LoadType.values().length];
            r0[LoadType.REFRESH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[LoadType.PREPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[LoadType.APPEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
        INITIAL = new PagePresenter(PageEvent.Insert.Companion.getEMPTY_REFRESH_LOCAL());
    }

    public PagePresenter(PageEvent.Insert<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "insertEvent");
        this(r3.getPages(), r3.getPlaceholdersBefore(), r3.getPlaceholdersAfter());
    }

    public PagePresenter(List<TransformablePage<T>> r3, int r4, int r5) {
        List<TransformablePage<T>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pages");
        this.pages = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        this.storageCount = fullCount(r6);
        this.placeholdersBefore = r4;
        this.placeholdersAfter = r5;
    }

    public static final /* synthetic */ PagePresenter access$getINITIAL$cp() {
        return INITIAL;
    }

    private final void checkIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= getSize()) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException("Index: " + r4 + ", Size: " + getSize());
    }

    private final void dropPages(PageEvent.Drop<T> r8, ProcessPageEventCallback r9) {
        ProcessPageEventCallback r10 = (ProcessPageEventCallback) ZeusTransformUtils.wrapperContextForParams(r9, ProcessPageEventCallback.class, "com.obric.memorydata.plugin");
        int r0 = getSize();
        if (r8.getLoadType() != LoadType.PREPEND) goto L14;
        int r2 = getPlaceholdersBefore();
        this.storageCount = getStorageCount() - dropPagesWithOffsets(new IntRange(r8.getMinPageOffset(), r8.getMaxPageOffset()));
        this.placeholdersBefore = r8.getPlaceholdersRemaining();
        int r7 = getSize() - r0;
        if (r7 <= 0) goto L7;
        r10.onInserted(0, r7);
    L9:
        int r11 = Math.max(0, r2 + r7);
        int r12 = r8.getPlaceholdersRemaining() - r11;
        if (r12 <= 0) goto L12;
        r10.onChanged(r11, r12);
    L12:
        LoadType r13 = LoadType.PREPEND;
    L13:
        r10.onStateUpdate(r13, false, (LoadState) ZeusTransformUtils.preCheckCast(LoadState.NotLoading.Companion.getIncomplete$paging_common(), LoadState.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        if (r7 >= 0) goto L9;
        r10.onRemoved(0, -r7);
        goto L9
    L14:
        int r3 = getPlaceholdersAfter();
        this.storageCount = getStorageCount() - dropPagesWithOffsets(new IntRange(r8.getMinPageOffset(), r8.getMaxPageOffset()));
        this.placeholdersAfter = r8.getPlaceholdersRemaining();
        int r4 = getSize() - r0;
        if (r4 <= 0) goto L17;
        r10.onInserted(r0, r4);
    L19:
        if (r4 >= 0) goto L21;
        int r1 = Math.min(r3, -r4);
    L22:
        int r5 = r8.getPlaceholdersRemaining() - (r3 - r1);
        if (r5 <= 0) goto L25;
        r10.onChanged(getSize() - r8.getPlaceholdersRemaining(), r5);
    L25:
        r13 = LoadType.APPEND;
        goto L13
    L21:
        r1 = 0;
        goto L22
    L17:
        if (r4 >= 0) goto L19;
        r10.onRemoved(r0 + r4, -r4);
        goto L19
    }

    private final int dropPagesWithOffsets(IntRange r8) {
        Iterator<TransformablePage<T>> r7 = this.pages.iterator();
        int r1 = 0;
    L4:
        if (r7.hasNext() == false) goto L14;
        TransformablePage r2 = (TransformablePage) ZeusTransformUtils.preCheckCast(r7.next(), TransformablePage.class, "com.obric.memorydata.plugin");
        int[] r3 = r2.getOriginalPageOffsets();
        int r4 = r3.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L11;
        if (r8.contains(r3[r5]) == true) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L4;
        r1 = r1 + r2.getData().size();
        r7.remove();
        goto L4
    L11:
        r6 = false;
        goto L12
    L14:
        return r1;
    }

    private final int fullCount(List<TransformablePage<T>> r4) {
        Iterator<T> r3 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L6;
        r5 = r5 + ((TransformablePage) ZeusTransformUtils.preCheckCast(r3.next(), TransformablePage.class, "com.obric.memorydata.plugin")).getData().size();
        goto L4
    L6:
        return r5;
    }

    private final int getOriginalPageOffsetFirst() {
        Integer r2 = ArraysKt.minOrNull(((TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.first(this.pages), TransformablePage.class, "com.obric.memorydata.plugin")).getOriginalPageOffsets());
        Intrinsics.checkNotNull(r2);
        return r2.intValue();
    }

    private final int getOriginalPageOffsetLast() {
        Integer r2 = ArraysKt.maxOrNull(((TransformablePage) ZeusTransformUtils.preCheckCast(CollectionsKt.last(this.pages), TransformablePage.class, "com.obric.memorydata.plugin")).getOriginalPageOffsets());
        Intrinsics.checkNotNull(r2);
        return r2.intValue();
    }

    private final void insertPage(PageEvent.Insert<T> r12, ProcessPageEventCallback r13) {
        ProcessPageEventCallback r14 = (ProcessPageEventCallback) ZeusTransformUtils.wrapperContextForParams(r13, ProcessPageEventCallback.class, "com.obric.memorydata.plugin");
        int r0 = fullCount(r12.getPages());
        int r2 = getSize();
        LoadType r3 = r12.getLoadType();
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 == 1) goto L22;
        if (r4 != 2) goto L7;
        int r5 = Math.min(getPlaceholdersBefore(), r0);
        int r6 = getPlaceholdersBefore() - r5;
        int r7 = r0 - r5;
        this.pages.addAll(0, (Collection) ZeusTransformUtils.preCheckCast(r12.getPages(), Collection.class, "com.obric.memorydata.plugin"));
        this.storageCount = getStorageCount() + r0;
        this.placeholdersBefore = r12.getPlaceholdersBefore();
        r14.onChanged(r6, r5);
        r14.onInserted(0, r7);
        int r11 = (getSize() - r2) - r7;
        if (r11 <= 0) goto L17;
        r14.onInserted(0, r11);
    L19:
        r14.onStateUpdate(r12.getSourceLoadStates(), r12.getMediatorLoadStates());
        return;
    L17:
        if (r11 >= 0) goto L19;
        r14.onRemoved(0, -r11);
        goto L19
    L7:
        if (r4 != 3) goto L19;
        int r8 = Math.min(getPlaceholdersAfter(), r0);
        int r9 = getPlaceholdersBefore() + getStorageCount();
        int r10 = r0 - r8;
        List<TransformablePage<T>> r15 = this.pages;
        r15.addAll(r15.size(), (Collection) ZeusTransformUtils.preCheckCast(r12.getPages(), Collection.class, "com.obric.memorydata.plugin"));
        this.storageCount = getStorageCount() + r0;
        this.placeholdersAfter = r12.getPlaceholdersAfter();
        r14.onChanged(r9, r8);
        r14.onInserted(r9 + r8, r10);
        int r1 = (getSize() - r2) - r10;
        if (r1 <= 0) goto L12;
        r14.onInserted(getSize() - r1, r1);
        goto L19
    L12:
        if (r1 >= 0) goto L19;
        r14.onRemoved(getSize(), -r1);
        goto L19
    L22:
        throw new IllegalStateException("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    public final ViewportHint.Access accessHintForPresenterIndex(int r9) {
        int r1 = 0;
        int r3 = r9 - getPlaceholdersBefore();
    L4:
        if (r3 < ((TransformablePage) ZeusTransformUtils.preCheckCast(this.pages.get(r1), TransformablePage.class, "com.obric.memorydata.plugin")).getData().size()) goto L9;
        if (r1 >= CollectionsKt.getLastIndex(this.pages)) goto L9;
        r3 = r3 - ((TransformablePage) ZeusTransformUtils.preCheckCast(this.pages.get(r1), TransformablePage.class, "com.obric.memorydata.plugin")).getData().size();
        r1 = r1 + 1;
    L9:
        return ((TransformablePage) ZeusTransformUtils.preCheckCast(this.pages.get(r1), TransformablePage.class, "com.obric.memorydata.plugin")).viewportHintFor(r3, r9 - getPlaceholdersBefore(), ((getSize() - r9) - getPlaceholdersAfter()) - 1, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final T get(int r2) {
        checkIndex(r2);
        int r3 = r2 - getPlaceholdersBefore();
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 < getStorageCount()) goto L8;
        return null;
    L8:
        return getFromStorage(r3);
    }

    @Override // androidx.paging.NullPaddedList
    public T getFromStorage(int r6) {
        int r0 = this.pages.size();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L10;
        int r3 = ((TransformablePage) ZeusTransformUtils.preCheckCast(this.pages.get(r1), TransformablePage.class, "com.obric.memorydata.plugin")).getData().size();
        if (r3 > r6) goto L10;
        r6 = r6 - r3;
        r1 = r1 + 1;
    L10:
        return ((TransformablePage) ZeusTransformUtils.preCheckCast(this.pages.get(r1), TransformablePage.class, "com.obric.memorydata.plugin")).getData().get(r6);
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // androidx.paging.NullPaddedList
    public int getSize() {
        return (getPlaceholdersBefore() + getStorageCount()) + getPlaceholdersAfter();
    }

    @Override // androidx.paging.NullPaddedList
    public int getStorageCount() {
        return this.storageCount;
    }

    public final ViewportHint.Initial initializeHint() {
        int r0 = getStorageCount() / 2;
        return new ViewportHint.Initial(r0, r0, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final void processEvent(PageEvent<T> r3, ProcessPageEventCallback r4) {
        ProcessPageEventCallback r5 = (ProcessPageEventCallback) ZeusTransformUtils.wrapperContextForParams(r4, ProcessPageEventCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "pageEvent");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.Insert.class) == false) goto L6;
        insertPage((PageEvent.Insert) ZeusTransformUtils.preCheckCast(r3, PageEvent.Insert.class, "com.obric.memorydata.plugin"), r5);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.Drop.class) == false) goto L9;
        dropPages((PageEvent.Drop) ZeusTransformUtils.preCheckCast(r3, PageEvent.Drop.class, "com.obric.memorydata.plugin"), r5);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.LoadStateUpdate.class) == false) goto L12;
        r5.onStateUpdate(((PageEvent.LoadStateUpdate) ZeusTransformUtils.preCheckCast(r3, PageEvent.LoadStateUpdate.class, "com.obric.memorydata.plugin")).getSource(), ((PageEvent.LoadStateUpdate) ZeusTransformUtils.preCheckCast(r3, PageEvent.LoadStateUpdate.class, "com.obric.memorydata.plugin")).getMediator());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, PageEvent.StaticList.class) == true) goto L15;
        return;
    L15:
        throw new IllegalStateException("Paging received an event to display a static list, while still actively loading\nfrom an existing generation of PagingData. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
    }

    public final ItemSnapshotList<T> snapshot() {
        int r0 = getPlaceholdersBefore();
        int r1 = getPlaceholdersAfter();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.pages, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        CollectionsKt.addAll(r2, (Iterable) ZeusTransformUtils.preCheckCast(((TransformablePage) ZeusTransformUtils.preCheckCast(r7.next(), TransformablePage.class, "com.obric.memorydata.plugin")).getData(), Iterable.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        return new ItemSnapshotList(r0, r1, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
    }

    public String toString() {
        int r0 = getStorageCount();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1.add(getFromStorage(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return "[(" + getPlaceholdersBefore() + " placeholders), " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null) + ", (" + getPlaceholdersAfter() + " placeholders)]";
    }
}
