package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u0000 &*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001&B\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B3\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\tHÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\n\u001a\u00020\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J.\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/paging/TransformablePage;", ExifInterface.GPS_DIRECTION_TRUE, "", "originalPageOffset", "", "data", "", "(ILjava/util/List;)V", "originalPageOffsets", "", "hintOriginalPageOffset", "hintOriginalIndices", "([ILjava/util/List;ILjava/util/List;)V", "getData", "()Ljava/util/List;", "getHintOriginalIndices", "getHintOriginalPageOffset", "()I", "getOriginalPageOffsets", "()[I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "viewportHintFor", "Landroidx/paging/ViewportHint$Access;", "index", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransformablePage<T> {
    public static final Companion Companion = null;
    private static final TransformablePage<Object> EMPTY_INITIAL_PAGE = null;
    private final List<T> data;
    private final List<Integer> hintOriginalIndices;
    private final int hintOriginalPageOffset;
    private final int[] originalPageOffsets;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0001\u0010\b*\u00020\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/paging/TransformablePage$Companion;", "", "()V", "EMPTY_INITIAL_PAGE", "Landroidx/paging/TransformablePage;", "getEMPTY_INITIAL_PAGE", "()Landroidx/paging/TransformablePage;", "empty", ExifInterface.GPS_DIRECTION_TRUE, "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final <T> TransformablePage<T> empty() {
            TransformablePage<T> r1 = (TransformablePage<T>) getEMPTY_INITIAL_PAGE();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.paging.TransformablePage<T of androidx.paging.TransformablePage.Companion.empty>");
            return r1;
        }

        public final TransformablePage<Object> getEMPTY_INITIAL_PAGE() {
            return TransformablePage.access$getEMPTY_INITIAL_PAGE$cp();
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY_INITIAL_PAGE = new TransformablePage(0, CollectionsKt.emptyList());
    }

    public TransformablePage(int r3, List<? extends T> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "data");
        this(new int[]{r3}, r5, r3, null);
    }

    public TransformablePage(int[] r3, List<? extends T> r4, int r5, List<Integer> r6) {
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<Integer> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(r7, "data");
        this.originalPageOffsets = r3;
        this.data = r7;
        this.hintOriginalPageOffset = r5;
        this.hintOriginalIndices = r8;
        int r2 = r3.length;
        boolean r9 = false;
        if (r2 != 0) goto L5;
        boolean r10 = true;
    L7:
        if ((!r10) == false) goto L17;
        if (r8 != null) goto L10;
    L11:
        r9 = true;
    L12:
        if (r9 == false) goto L14;
        return;
    L14:
        StringBuilder r11 = new StringBuilder().append("If originalIndices (size = ");
        Intrinsics.checkNotNull(r8);
        throw new IllegalArgumentException(r11.append(r8.size()).append(") is provided, it must be same length as data (size = ").append(r7.size()).append(')').toString().toString());
    L10:
        if (r8.size() != r7.size()) goto L12;
    L17:
        throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
    L5:
        r10 = false;
        goto L7
    }

    public static final /* synthetic */ TransformablePage access$getEMPTY_INITIAL_PAGE$cp() {
        return EMPTY_INITIAL_PAGE;
    }

    public static /* synthetic */ TransformablePage copy$default(TransformablePage r1, int[] r2, List r3, int r4, List r5, int r6, Object r7) {
        List<T> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.originalPageOffsets;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.data;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.hintOriginalPageOffset;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.hintOriginalIndices;
    L15:
        return r1.copy(r2, r8, r4, r9);
    }

    public final int[] component1() {
        return this.originalPageOffsets;
    }

    public final List<T> component2() {
        return this.data;
    }

    public final int component3() {
        return this.hintOriginalPageOffset;
    }

    public final List<Integer> component4() {
        return this.hintOriginalIndices;
    }

    public final TransformablePage<T> copy(int[] r2, List<? extends T> r3, int r4, List<Integer> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(r1, "data");
        return new TransformablePage(r2, r1, r4, r6);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
        TransformablePage r4 = (TransformablePage) ZeusTransformUtils.preCheckCast(r7, TransformablePage.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(this.originalPageOffsets, ((TransformablePage) ZeusTransformUtils.preCheckCast(r7, TransformablePage.class, "com.obric.memorydata.plugin")).originalPageOffsets) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.data, ((TransformablePage) ZeusTransformUtils.preCheckCast(r7, TransformablePage.class, "com.obric.memorydata.plugin")).data) == true) goto L19;
        return false;
    L19:
        if (this.hintOriginalPageOffset == ((TransformablePage) ZeusTransformUtils.preCheckCast(r7, TransformablePage.class, "com.obric.memorydata.plugin")).hintOriginalPageOffset) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.hintOriginalIndices, ((TransformablePage) ZeusTransformUtils.preCheckCast(r7, TransformablePage.class, "com.obric.memorydata.plugin")).hintOriginalIndices) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r3 = null;
        goto L10
    }

    public final List<T> getData() {
        return this.data;
    }

    public final List<Integer> getHintOriginalIndices() {
        return this.hintOriginalIndices;
    }

    public final int getHintOriginalPageOffset() {
        return this.hintOriginalPageOffset;
    }

    public final int[] getOriginalPageOffsets() {
        return this.originalPageOffsets;
    }

    public int hashCode() {
        int r0 = ((((Arrays.hashCode(this.originalPageOffsets) * 31) + this.data.hashCode()) * 31) + this.hintOriginalPageOffset) * 31;
        List<Integer> r2 = this.hintOriginalIndices;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.originalPageOffsets) + ", data=" + this.data + ", hintOriginalPageOffset=" + this.hintOriginalPageOffset + ", hintOriginalIndices=" + this.hintOriginalIndices + ')';
    }

    public final ViewportHint.Access viewportHintFor(int r9, int r10, int r11, int r12, int r13) {
        int r1 = this.hintOriginalPageOffset;
        List<Integer> r0 = this.hintOriginalIndices;
        boolean r2 = true;
        if (r0 == null) goto L9;
        IntRange r3 = CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L9;
        if (r3.contains(r9) != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        r9 = ((Number) ZeusTransformUtils.preCheckCast(this.hintOriginalIndices.get(r9), Number.class, "com.obric.memorydata.plugin")).intValue();
    L13:
        return new ViewportHint.Access(r1, r9, r10, r11, r12, r13);
    L9:
        r2 = false;
        goto L10
    }
}
