package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001aE\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\rH\u0002¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0013\u001a)\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0013\u001aA\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0002\u0010\u0019\u001aM\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\rH\u0002¢\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"ENTRY_SIZE", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "insertEntryAtIndex", "", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "keyIndex", STGroup.DICT_KEY, "value", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "nodeIndex", "replaceEntryWithNode", "newNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TrieNodeKt {
    public static final int ENTRY_SIZE = 2;
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final /* synthetic */ Object[] access$insertEntryAtIndex(Object[] r5, int r10, Object r11, Object r12) {
        return insertEntryAtIndex(r5, r10, r11, r12);
    }

    public static final /* synthetic */ Object[] access$removeEntryAtIndex(Object[] r5, int r10) {
        return removeEntryAtIndex(r5, r10);
    }

    public static final /* synthetic */ Object[] access$removeNodeAtIndex(Object[] r5, int r10) {
        return removeNodeAtIndex(r5, r10);
    }

    public static final /* synthetic */ Object[] access$replaceEntryWithNode(Object[] r5, int r10, int r11, TrieNode r12) {
        return replaceEntryWithNode(r5, r10, r11, r12);
    }

    public static final /* synthetic */ Object[] access$replaceNodeWithEntry(Object[] r5, int r10, int r11, Object r12, Object r13) {
        return replaceNodeWithEntry(r5, r10, r11, r12, r13);
    }

    public static final int indexSegment(int r5, int r10) {
        return (r5 >> r10) & 31;
    }

    private static final <K, V> Object[] insertEntryAtIndex(Object[] r5, int r10, K r11, V r12) {
        Object[] r13 = new Object[r5.length + 2];
        ArraysKt.f(r5, r13, 0, r10, 6);
        ArraysKt.copyInto(r5, r13, r10 + 2, r10, r5.length);
        r13[r10] = r11;
        r13[r10 + 1] = r12;
        return r13;
    }

    private static final Object[] removeEntryAtIndex(Object[] r5, int r10) {
        Object[] r11 = new Object[r5.length - 2];
        ArraysKt.f(r5, r11, 0, r10, 6);
        ArraysKt.copyInto(r5, r11, r10, r10 + 2, r5.length);
        return r11;
    }

    private static final Object[] removeNodeAtIndex(Object[] r5, int r10) {
        Object[] r11 = new Object[r5.length - 1];
        ArraysKt.f(r5, r11, 0, r10, 6);
        ArraysKt.copyInto(r5, r11, r10, r10 + 1, r5.length);
        return r11;
    }

    private static final Object[] replaceEntryWithNode(Object[] r5, int r10, int r11, TrieNode<?, ?> r12) {
        Object[] r13 = new Object[r5.length - 1];
        ArraysKt.f(r5, r13, 0, r10, 6);
        ArraysKt.copyInto(r5, r13, r10, r10 + 2, r11);
        r13[r11 - 2] = r12;
        ArraysKt.copyInto(r5, r13, r11 - 1, r11, r5.length);
        return r13;
    }

    private static final <K, V> Object[] replaceNodeWithEntry(Object[] r5, int r10, int r11, K r12, V r13) {
        Object[] r14 = Arrays.copyOf(r5, r5.length + 1);
        ArraysKt.copyInto(r14, r14, r10 + 2, r10 + 1, r5.length);
        ArraysKt.copyInto(r14, r14, r11 + 2, r11, r10);
        r14[r11] = r12;
        r14[r11 + 1] = r13;
        return r14;
    }
}
