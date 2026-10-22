package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0082\u0001\u0002\u0017\u0018¨\u0006\u0019"}, d2 = {"Landroidx/paging/ViewportHint;", "", "presentedItemsBefore", "", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "(IIII)V", "getOriginalPageOffsetFirst", "()I", "getOriginalPageOffsetLast", "getPresentedItemsAfter", "getPresentedItemsBefore", "equals", "", "other", "hashCode", "presentedItemsBeyondAnchor", "loadType", "Landroidx/paging/LoadType;", "presentedItemsBeyondAnchor$paging_common", "Access", "Initial", "Landroidx/paging/ViewportHint$Access;", "Landroidx/paging/ViewportHint$Initial;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ViewportHint {
    private final int originalPageOffsetFirst;
    private final int originalPageOffsetLast;
    private final int presentedItemsAfter;
    private final int presentedItemsBefore;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0014"}, d2 = {"Landroidx/paging/ViewportHint$Access;", "Landroidx/paging/ViewportHint;", "pageOffset", "", "indexInPage", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "(IIIIII)V", "getIndexInPage", "()I", "getPageOffset", "equals", "", "other", "", "hashCode", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Access extends ViewportHint {
        private final int indexInPage;
        private final int pageOffset;

        public Access(int r7, int r8, int r9, int r10, int r11, int r12) {
            super(r9, r10, r11, r12, null);
            this.pageOffset = r7;
            this.indexInPage = r8;
        }

        @Override // androidx.paging.ViewportHint
        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, Access.class) == true) goto L9;
            return false;
        L9:
            if (this.pageOffset != ((Access) ZeusTransformUtils.preCheckCast(r7, Access.class, "com.obric.memorydata.plugin")).pageOffset) goto L22;
            if (this.indexInPage != ((Access) ZeusTransformUtils.preCheckCast(r7, Access.class, "com.obric.memorydata.plugin")).indexInPage) goto L22;
            if (getPresentedItemsBefore() != ((Access) ZeusTransformUtils.preCheckCast(r7, Access.class, "com.obric.memorydata.plugin")).getPresentedItemsBefore()) goto L22;
            if (getPresentedItemsAfter() != ((Access) ZeusTransformUtils.preCheckCast(r7, Access.class, "com.obric.memorydata.plugin")).getPresentedItemsAfter()) goto L22;
            if (getOriginalPageOffsetFirst() != ((Access) ZeusTransformUtils.preCheckCast(r7, Access.class, "com.obric.memorydata.plugin")).getOriginalPageOffsetFirst()) goto L22;
            if (getOriginalPageOffsetLast() != ((Access) ZeusTransformUtils.preCheckCast(r7, Access.class, "com.obric.memorydata.plugin")).getOriginalPageOffsetLast()) goto L22;
            return true;
        L22:
            return false;
        }

        public final int getIndexInPage() {
            return this.indexInPage;
        }

        public final int getPageOffset() {
            return this.pageOffset;
        }

        @Override // androidx.paging.ViewportHint
        public int hashCode() {
            return (super.hashCode() + Integer.hashCode(this.pageOffset)) + Integer.hashCode(this.indexInPage);
        }

        public String toString() {
            return StringsKt.trimMargin$default("ViewportHint.Access(\n            |    pageOffset=" + this.pageOffset + ",\n            |    indexInPage=" + this.indexInPage + ",\n            |    presentedItemsBefore=" + getPresentedItemsBefore() + ",\n            |    presentedItemsAfter=" + getPresentedItemsAfter() + ",\n            |    originalPageOffsetFirst=" + getOriginalPageOffsetFirst() + ",\n            |    originalPageOffsetLast=" + getOriginalPageOffsetLast() + ",\n            |)", null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/paging/ViewportHint$Initial;", "Landroidx/paging/ViewportHint;", "presentedItemsBefore", "", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "(IIII)V", "toString", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Initial extends ViewportHint {
        public Initial(int r7, int r8, int r9, int r10) {
            super(r7, r8, r9, r10, null);
        }

        public String toString() {
            return StringsKt.trimMargin$default("ViewportHint.Initial(\n            |    presentedItemsBefore=" + getPresentedItemsBefore() + ",\n            |    presentedItemsAfter=" + getPresentedItemsAfter() + ",\n            |    originalPageOffsetFirst=" + getOriginalPageOffsetFirst() + ",\n            |    originalPageOffsetLast=" + getOriginalPageOffsetLast() + ",\n            |)", null, 1, null);
        }
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

    private ViewportHint(int r1, int r2, int r3, int r4) {
        this.presentedItemsBefore = r1;
        this.presentedItemsAfter = r2;
        this.originalPageOffsetFirst = r3;
        this.originalPageOffsetLast = r4;
    }

    public /* synthetic */ ViewportHint(int r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ViewportHint.class) == true) goto L9;
        return false;
    L9:
        if (this.presentedItemsBefore != ((ViewportHint) ZeusTransformUtils.preCheckCast(r7, ViewportHint.class, "com.obric.memorydata.plugin")).presentedItemsBefore) goto L18;
        if (this.presentedItemsAfter != ((ViewportHint) ZeusTransformUtils.preCheckCast(r7, ViewportHint.class, "com.obric.memorydata.plugin")).presentedItemsAfter) goto L18;
        if (this.originalPageOffsetFirst != ((ViewportHint) ZeusTransformUtils.preCheckCast(r7, ViewportHint.class, "com.obric.memorydata.plugin")).originalPageOffsetFirst) goto L18;
        if (this.originalPageOffsetLast != ((ViewportHint) ZeusTransformUtils.preCheckCast(r7, ViewportHint.class, "com.obric.memorydata.plugin")).originalPageOffsetLast) goto L18;
        return true;
    L18:
        return false;
    }

    public final int getOriginalPageOffsetFirst() {
        return this.originalPageOffsetFirst;
    }

    public final int getOriginalPageOffsetLast() {
        return this.originalPageOffsetLast;
    }

    public final int getPresentedItemsAfter() {
        return this.presentedItemsAfter;
    }

    public final int getPresentedItemsBefore() {
        return this.presentedItemsBefore;
    }

    public int hashCode() {
        return ((Integer.hashCode(this.presentedItemsBefore) + Integer.hashCode(this.presentedItemsAfter)) + Integer.hashCode(this.originalPageOffsetFirst)) + Integer.hashCode(this.originalPageOffsetLast);
    }

    public final int presentedItemsBeyondAnchor$paging_common(LoadType r2) {
        Intrinsics.checkNotNullParameter(r2, "loadType");
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L10;
        return this.presentedItemsAfter;
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return this.presentedItemsBefore;
    L14:
        throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
    }
}
