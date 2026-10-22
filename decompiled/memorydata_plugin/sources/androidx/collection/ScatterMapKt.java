package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001e\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u0017\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u0019\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u001b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\bH\u0080\b\u001a\u0011\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0080\b\u001a\u0011\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0080\b\u001a\u0013\u0010\u001f\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0010H\u0080\b\u001a\u0019\u0010\"\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0019\u0010%\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0011\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u0001H\u0081\b\u001a\u0019\u0010&\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010$\u001a\u00020\bH\u0080\b\u001a\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0000\u001a\u001e\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u000f\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u0019\u001aO\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190\u000f\"\u0004\b\u0000\u0010\u0018\"\u0004\b\u0001\u0010\u00192*\u0010+\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190-0,\"\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00190-¢\u0006\u0002\u0010.\u001a\u0010\u0010/\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0000\u001a\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0000\u001a\u0019\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\bH\u0081\b\u001a\u0010\u00104\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0000\u001a!\u00105\u001a\u0002062\u0006\u00103\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0001H\u0080\b\u001a\u0011\u00107\u001a\u00020\b*\u00060\u0001j\u0002`8H\u0080\b\u001a\u0011\u00109\u001a\u00020#*\u00060\u0001j\u0002`8H\u0080\b\u001a\u0011\u0010:\u001a\u00020\b*\u00060\u0001j\u0002`;H\u0081\b\u001a\u0015\u0010<\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001bH\u0080\b\u001a\u0015\u0010=\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001bH\u0081\b\u001a\u001d\u0010>\u001a\u00060\u0001j\u0002`8*\u00060\u0001j\u0002`\u001b2\u0006\u0010?\u001a\u00020\bH\u0081\b\u001a\u0011\u0010@\u001a\u00020\u0001*\u00060\u0001j\u0002`8H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0004*\f\b\u0000\u0010A\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010B\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010C\"\u00020\u00012\u00020\u0001¨\u0006D"}, d2 = {"AllEmpty", "", "BitmaskLsb", "getBitmaskLsb$annotations", "()V", "BitmaskMsb", "getBitmaskMsb$annotations", "ClonedMetadataCount", "", "DefaultScatterCapacity", "Deleted", "Empty", "EmptyGroup", "", "EmptyScatterMap", "Landroidx/collection/MutableScatterMap;", "", "", "GroupWidth", "MurmurHashC1", "Sentinel", "getSentinel$annotations", "emptyScatterMap", "Landroidx/collection/ScatterMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "group", "Landroidx/collection/Group;", "metadata", TypedValues.CycleType.S_WAVE_OFFSET, "h1", "hash", "h2", "k", "isDeleted", "", "index", "isEmpty", "isFull", EventBody.KEY_VALUE, "loadedCapacity", "capacity", "mutableScatterMapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/collection/MutableScatterMap;", "nextCapacity", "normalizeCapacity", "n", "readRawMetadata", "data", "unloadedCapacity", "writeRawMetadata", "", "get", "Landroidx/collection/Bitmask;", "hasNext", "lowestBitSet", "Landroidx/collection/StaticBitmask;", "maskEmpty", "maskEmptyOrDeleted", "match", "m", "next", "Bitmask", "Group", "StaticBitmask", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = null;
    private static final MutableScatterMap EmptyScatterMap = null;
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    static {
        EmptyGroup = new long[]{-9187201950435737345L, -1};
        EmptyScatterMap = new MutableScatterMap(0);
    }

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap r0 = EmptyScatterMap;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.collection.ScatterMap<K of androidx.collection.ScatterMapKt.emptyScatterMap, V of androidx.collection.ScatterMapKt.emptyScatterMap>");
        return (ScatterMap) ZeusTransformUtils.preCheckCast(r0, ScatterMap.class, "com.obric.memorydata.plugin");
    }

    public static final int get(long r0) {
        return Long.numberOfTrailingZeros(r0) >> 3;
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final long group(long[] r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "metadata");
        int r0 = r6 >> 3;
        int r7 = (r6 & 7) << 3;
        return (((-r7) >> 63) & (r5[r0 + 1] << (64 - r7))) | (r5[r0] >>> r7);
    }

    public static final int h1(int r0) {
        return r0 >>> 7;
    }

    public static final int h2(int r0) {
        return r0 & 127;
    }

    public static final boolean hasNext(long r2) {
        if (r2 == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int hash(Object r1) {
        if (r1 == null) goto L4;
        int r2 = r1.hashCode();
    L5:
        int r3 = r2 * MurmurHashC1;
        return r3 ^ (r3 << 16);
    L4:
        r2 = 0;
        goto L5
    }

    public static final boolean isDeleted(long[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "metadata");
        if (((r2[r3 >> 3] >> ((r3 & 7) << 3)) & 255) != 254) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isEmpty(long[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "metadata");
        if (((r2[r3 >> 3] >> ((r3 & 7) << 3)) & 255) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isFull(long r2) {
        if (r2 >= 128) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isFull(long[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "metadata");
        if (((r2[r3 >> 3] >> ((r3 & 7) << 3)) & 255) >= 128) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int loadedCapacity(int r1) {
        if (r1 != 7) goto L7;
        return 6;
    L7:
        return r1 - (r1 / 8);
    }

    public static final int lowestBitSet(long r0) {
        return Long.numberOfTrailingZeros(r0) >> 3;
    }

    public static final long maskEmpty(long r3) {
        return (r3 & ((~r3) << 6)) & (-9187201950435737472L);
    }

    public static final long maskEmptyOrDeleted(long r3) {
        return (r3 & ((~r3) << 7)) & (-9187201950435737472L);
    }

    public static final long match(long r4, int r6) {
        long r5 = r4 ^ (((long) r6) * BitmaskLsb);
        long r0 = r5 - BitmaskLsb;
        return ((~r5) & r0) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap(0, 1, null);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(Pair<? extends K, ? extends V>... r2) {
        Intrinsics.checkNotNullParameter(r2, "pairs");
        MutableScatterMap<K, V> r0 = new MutableScatterMap(r2.length);
        r0.putAll(r2);
        return r0;
    }

    public static final long next(long r2) {
        return r2 & (r2 - 1);
    }

    public static final int nextCapacity(int r0) {
        if (r0 != 0) goto L5;
        return 6;
    L5:
        return (r0 * 2) + 1;
    }

    public static final int normalizeCapacity(int r1) {
        if (r1 > 0) goto L6;
        return 0;
    L6:
        return (-1) >>> Integer.numberOfLeadingZeros(r1);
    }

    public static final long readRawMetadata(long[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return (r2[r3 >> 3] >> ((r3 & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int r2) {
        if (r2 != 7) goto L7;
        return 8;
    L7:
        return r2 + ((r2 - 1) / 7);
    }

    public static final void writeRawMetadata(long[] r5, int r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        int r0 = r6 >> 3;
        int r8 = (r6 & 7) << 3;
        long r1 = r5[r0] & (~(255 << r8));
        r5[r0] = (r7 << r8) | r1;
    }
}
