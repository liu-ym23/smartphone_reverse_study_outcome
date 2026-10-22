package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010+\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0018\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001d\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J=\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0-H\u0002¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0002\b2JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u00107J[\u00103\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010<J/\u0010=\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010@J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000BH\u0096\u0002J\u001e\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070D2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0016J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010!\u001a\u00020\u000bH\u0016J'\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010HJ-\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010NJ5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010PJ?\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ/\u0010U\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010VJM\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0014\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070-H\u0002¢\u0006\u0002\u0010YJE\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0007H\u0002¢\u0006\u0002\u0010[J?\u0010\\\u001a\u00020 2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010_J?\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010aJu\u0010b\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u0002062\u0014\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070i2\u0014\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070iH\u0002¢\u0006\u0002\u0010jJ\u001c\u0010k\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002¢\u0006\u0002\u0010lJ\u0016\u0010k\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J,\u0010m\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002J\u001a\u0010o\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dJ\u0015\u0010p\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0002\u00100J=\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ9\u0010r\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010sJ/\u0010t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\b\u0010R\u001a\u00020\u000bH\u0002J\u001e\u0010u\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010vJE\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010x\u001a\u00028\u00002\u0006\u0010y\u001a\u000206H\u0002¢\u0006\u0002\u00107JU\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010{\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0002\u0010|Jl\u0010}\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u007f\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0002¢\u0006\u0003\u0010\u0080\u0001J\b\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R0\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", "tail", "getTail$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPersistentVectorBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistentVectorBuilder.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,991:1\n26#2:992\n*S KotlinDebug\n*F\n+ 1 PersistentVectorBuilder.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder\n*L\n622#1:992\n*E\n"})
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList<? extends E> vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;

    public PersistentVectorBuilder(PersistentList<? extends E> r5, Object[] r10, Object[] r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "vector");
        Intrinsics.checkNotNullParameter(r11, "vectorTail");
        this.vector = r5;
        this.vectorRoot = r10;
        this.vectorTail = r11;
        this.rootShift = r12;
        this.ownership = new MutabilityOwnership();
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    private final Object[] bufferFor(int r5) {
        if (rootSize() <= r5) goto L5;
        Object[] r10 = this.root;
        Intrinsics.checkNotNull(r10);
        int r11 = this.rootShift;
    L7:
        if (r11 <= 0) goto L9;
        Object[] r12 = r10[UtilsKt.indexSegment(r5, r11)];
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r10 = r12;
        r11 = r11 - 5;
        goto L7
    L9:
        return r10;
    L5:
        return this.tail;
    }

    private final Object[] copyToBuffer(Object[] r5, int r10, Iterator<? extends Object> r11) {
    L3:
        if (r10 >= 32) goto L7;
        if (r11.hasNext() == false) goto L7;
        r5[r10] = r11.next();
        r10 = r10 + 1;
    L7:
        return r5;
    }

    private final Object[] insertIntoRoot(Object[] r10, int r11, int r12, Object r13, ObjectRef r14) {
        int r5 = UtilsKt.indexSegment(r12, r11);
        if (r11 != 0) goto L6;
        r14.setValue(r10[31]);
        Object[] r15 = ArraysKt.copyInto(r10, makeMutable(r10), r5 + 1, r5, 31);
        r15[r5] = r13;
        return r15;
    L6:
        Object[] r16 = makeMutable(r10);
        int r17 = r11 - 5;
        Object r18 = r16[r5];
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r16[r5] = insertIntoRoot((Object[]) r18, r17, r12, r13, r14);
    L7:
        r5 = r5 + 1;
        if (r5 >= 32) goto L12;
        Object r19 = r16[r5];
        if (r19 == null) goto L12;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r16[r5] = insertIntoRoot((Object[]) r19, r17, 0, r14.getValue(), r14);
    L12:
        return r16;
    }

    private final void insertIntoTail(Object[] r10, int r11, E r12) {
        int r5 = tailSize();
        Object[] r13 = makeMutable(this.tail);
        if (r5 >= 32) goto L5;
        ArraysKt.copyInto(this.tail, r13, r11 + 1, r11, r5);
        r13[r11] = r12;
        this.root = r10;
        this.tail = r13;
        this.size = size() + 1;
        return;
    L5:
        Object[] r14 = this.tail;
        Object r15 = r14[31];
        ArraysKt.copyInto(r14, r13, r11 + 1, r11, 31);
        r13[r11] = r12;
        pushFilledTail(r10, r13, mutableBufferWith(r15));
    }

    private final boolean isMutable(Object[] r5) {
        if (r5.length == 33) goto L5;
    L7:
        return false;
    L5:
        if (r5[32] != this.ownership) goto L7;
        return true;
    }

    private final ListIterator<Object[]> leafBufferIterator(int r5) {
        if (this.root == null) goto L11;
        int r10 = rootSize() >> 5;
        ListImplementation.checkPositionIndex$runtime_release(r5, r10);
        int r11 = this.rootShift;
        if (r11 != 0) goto L8;
        Object[] r12 = this.root;
        Intrinsics.checkNotNull(r12);
        return new SingleElementListIterator(r12, r5);
    L8:
        Object[] r13 = this.root;
        Intrinsics.checkNotNull(r13);
        return new TrieIterator(r13, r5, r10, r11 / 5);
    L11:
        throw new IllegalStateException("Required value was null.");
    }

    private final Object[] makeMutable(Object[] r5) {
        if (r5 != null) goto L6;
        return mutableBuffer();
    L6:
        if (isMutable(r5) == false) goto L9;
        return r5;
    L9:
        return ArraysKt.f(r5, mutableBuffer(), 0, RangesKt.coerceAtMost(r5.length, 32), 6);
    }

    private final Object[] makeMutableShiftingRight(Object[] r5, int r10) {
        if (isMutable(r5) == false) goto L7;
        return ArraysKt.copyInto(r5, r5, r10, 0, 32 - r10);
    L7:
        return ArraysKt.copyInto(r5, mutableBuffer(), r10, 0, 32 - r10);
    }

    private final Object[] mutableBuffer() {
        Object[] r5 = new Object[33];
        r5[32] = this.ownership;
        return r5;
    }

    private final Object[] mutableBufferWith(Object r5) {
        Object[] r10 = new Object[33];
        r10[0] = r5;
        r10[32] = this.ownership;
        return r10;
    }

    private final Object[] nullifyAfter(Object[] r5, int r10, int r11) {
        if (r11 < 0) goto L18;
        if (r11 != 0) goto L5;
        return r5;
    L5:
        int r12 = UtilsKt.indexSegment(r10, r11);
        Object r13 = r5[r12];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object r14 = nullifyAfter((Object[]) r13, r10, r11 - 5);
        if (r12 >= 31) goto L14;
        int r15 = r12 + 1;
        if (r5[r15] == null) goto L14;
        if (isMutable(r5) == false) goto L12;
        ArraysKt.fill(r5, null, r15, 32);
    L12:
        r5 = ArraysKt.copyInto(r5, mutableBuffer(), 0, 0, r15);
    L14:
        if (r14 == r5[r12]) goto L19;
        Object[] r16 = makeMutable(r5);
        r16[r12] = r14;
        return r16;
    L19:
        return r5;
    L18:
        throw new IllegalStateException("Check failed.");
    }

    private final Object[] pullLastBuffer(Object[] r10, int r11, int r12, ObjectRef r13) {
        int r5 = UtilsKt.indexSegment(r12 - 1, r11);
        if (r11 != 5) goto L5;
        r13.setValue(r10[r5]);
        Object[] r14 = null;
    L6:
        if (r14 != null) goto L9;
        if (r5 != 0) goto L9;
        return null;
    L9:
        Object[] r15 = makeMutable(r10);
        r15[r5] = r14;
        return r15;
    L5:
        Object r16 = r10[r5];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r14 = pullLastBuffer((Object[]) r16, r11 - 5, r12, r13);
        goto L6
    }

    private final void pullLastBufferFromRoot(Object[] r5, int r10, int r11) {
        if (r11 != 0) goto L9;
        this.root = null;
        if (r5 != null) goto L7;
        r5 = new Object[0];
    L7:
        this.tail = r5;
        this.size = r10;
        this.rootShift = r11;
        return;
    L9:
        ObjectRef r12 = new ObjectRef(null);
        Intrinsics.checkNotNull(r5);
        Object[] r13 = pullLastBuffer(r5, r11, r10, r12);
        Intrinsics.checkNotNull(r13);
        Object r14 = r12.getValue();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) r14;
        this.size = r10;
        if (r13[1] != null) goto L12;
        this.root = (Object[]) r13[0];
        this.rootShift = r11 - 5;
        return;
    L12:
        this.root = r13;
        this.rootShift = r11;
    }

    private final Object[] pushBuffers(Object[] r5, int r10, int r11, Iterator<Object[]> r12) {
        if (r12.hasNext() == false) goto L18;
        if (r11 < 0) goto L16;
        if (r11 == 0) goto L7;
        Object[] r13 = makeMutable(r5);
        int r14 = UtilsKt.indexSegment(r10, r11);
        int r15 = r11 - 5;
        r13[r14] = pushBuffers((Object[]) r13[r14], r10, r15, r12);
    L9:
        r14 = r14 + 1;
        if (r14 >= 32) goto L14;
        if (r12.hasNext() == false) goto L14;
        r13[r14] = pushBuffers((Object[]) r13[r14], 0, r15, r12);
    L14:
        return r13;
    L7:
        return r12.next();
    L16:
        throw new IllegalStateException("Check failed.");
    L18:
        throw new IllegalStateException("Check failed.");
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] r5, int r10, Object[][] r11) {
        Iterator<Object[]> r12 = ArrayIteratorKt.iterator(r11);
        int r13 = r10 >> 5;
        int r14 = this.rootShift;
        if (r13 >= (1 << r14)) goto L5;
        Object[] r15 = pushBuffers(r5, r10, r14, r12);
    L7:
        if (r12.hasNext() == false) goto L9;
        this.rootShift += 5;
        r15 = mutableBufferWith(r15);
        int r16 = this.rootShift;
        pushBuffers(r15, 1 << r16, r16, r12);
        goto L7
    L9:
        return r15;
    L5:
        r15 = makeMutable(r5);
        goto L7
    }

    private final void pushFilledTail(Object[] r5, Object[] r10, Object[] r11) {
        int r12 = size() >> 5;
        int r13 = this.rootShift;
        if (r12 <= (1 << r13)) goto L5;
        this.root = pushTail(mutableBufferWith(r5), r10, this.rootShift + 5);
        this.tail = r11;
        this.rootShift += 5;
        this.size = size() + 1;
        return;
    L5:
        if (r5 != null) goto L7;
        this.root = r10;
        this.tail = r11;
        this.size = size() + 1;
        return;
    L7:
        this.root = pushTail(r5, r10, r13);
        this.tail = r11;
        this.size = size() + 1;
    }

    private final Object[] pushTail(Object[] r5, Object[] r10, int r11) {
        int r12 = UtilsKt.indexSegment(size() - 1, r11);
        Object[] r13 = makeMutable(r5);
        if (r11 != 5) goto L5;
        r13[r12] = r10;
    L6:
        return r13;
    L5:
        r13[r12] = pushTail((Object[]) r13[r12], r10, r11 - 5);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int recyclableRemoveAll(Function1<? super E, Boolean> r10, Object[] r11, int r12, int r13, ObjectRef r14, List<Object[]> r15, List<Object[]> r16) {
        if (isMutable(r11) == false) goto L5;
        r15.add(r11);
    L5:
        Object r5 = r14.getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r17 = (Object[]) r5;
        Object[] r18 = r17;
        int r19 = 0;
    L6:
        if (r19 >= r12) goto L19;
        Object r20 = r11[r19];
        if (r10.invoke(r20).booleanValue() == true) goto L18;
        if (r13 == 32) goto L12;
    L17:
        r18[r13] = r20;
        r13 = r13 + 1;
        goto L18
    L12:
        if (r15.isEmpty() == true) goto L15;
        Object[] r110 = r15.remove(r15.size() - 1);
    L14:
        r18 = r110;
        r13 = 0;
        goto L17
    L15:
        r110 = mutableBuffer();
    L18:
        r19 = r19 + 1;
        goto L6
    L19:
        r14.setValue(r18);
        if (r17 == r14.getValue()) goto L22;
        r16.add(r17);
    L22:
        return r13;
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> r5, int r10, ObjectRef r11) {
        int r12 = removeAll(r5, this.tail, r10, r11);
        if (r12 == r10) goto L5;
        Object r13 = r11.getValue();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r14 = (Object[]) r13;
        ArraysKt.fill(r14, null, r12, r10);
        this.tail = r14;
        this.size = size() - (r10 - r12);
        return r12;
    L5:
        if (r11.getValue() != this.tail) goto L7;
        boolean r15 = true;
    L8:
        CommonFunctionsKt.m42assert(r15);
        return r10;
    L7:
        r15 = false;
        goto L8
    }

    private final Object[] removeFromRootAt(Object[] r10, int r11, int r12, ObjectRef r13) {
        int r5 = UtilsKt.indexSegment(r12, r11);
        int r14 = 31;
        if (r11 != 0) goto L7;
        Object r15 = r10[r5];
        Object[] r16 = ArraysKt.copyInto(r10, makeMutable(r10), r5, r5 + 1, 32);
        r16[31] = r13.getValue();
        r13.setValue(r15);
        return r16;
    L7:
        if (r10[31] != null) goto L9;
        r14 = UtilsKt.indexSegment(rootSize() - 1, r11);
    L9:
        Object[] r17 = makeMutable(r10);
        int r18 = r11 - 5;
        int r19 = r5 + 1;
        if (r19 > r14) goto L14;
    L11:
        Object r20 = r17[r14];
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r17[r14] = removeFromRootAt((Object[]) r20, r18, 0, r13);
        if (r14 == r19) goto L14;
        r14 = r14 - 1;
    L14:
        Object r21 = r17[r5];
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r17[r5] = removeFromRootAt((Object[]) r21, r18, r12, r13);
        return r17;
    }

    private final Object removeFromTailAt(Object[] r10, int r11, int r12, int r13) {
        int r5 = size() - r11;
        if (r13 >= r5) goto L5;
        boolean r14 = true;
    L6:
        CommonFunctionsKt.m42assert(r14);
        if (r5 != 1) goto L9;
        Object r15 = this.tail[0];
        pullLastBufferFromRoot(r10, r11, r12);
        return r15;
    L9:
        Object[] r16 = this.tail;
        Object r17 = r16[r13];
        Object[] r18 = ArraysKt.copyInto(r16, makeMutable(r16), r13, r13 + 1, r5);
        r18[r5 - 1] = null;
        this.root = r10;
        this.tail = r18;
        this.size = (r11 + r5) - 1;
        this.rootShift = r12;
        return r17;
    L5:
        r14 = false;
        goto L6
    }

    private final Object[] retainFirst(Object[] r5, int r10) {
        if ((r10 & 31) != 0) goto L15;
        if (r10 != 0) goto L8;
        this.rootShift = 0;
        return null;
    L8:
        int r11 = r10 - 1;
    L9:
        int r12 = this.rootShift;
        if ((r11 >> r12) != 0) goto L13;
        this.rootShift = r12 - 5;
        Object[] r13 = r5[0];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r5 = r13;
        goto L9
    L13:
        return nullifyAfter(r5, r11, r12);
    L15:
        throw new IllegalStateException("Check failed.");
    }

    private final int rootSize() {
        if (size() > 32) goto L7;
        return 0;
    L7:
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] r10, int r11, int r12, E r13, ObjectRef r14) {
        int r5 = UtilsKt.indexSegment(r12, r11);
        Object[] r15 = makeMutable(r10);
        if (r11 != 0) goto L8;
        if (r15 == r10) goto L6;
        ((AbstractList) this).modCount++;
    L6:
        r14.setValue(r15[r5]);
        r15[r5] = r13;
        return r15;
    L8:
        Object r16 = r15[r5];
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r15[r5] = setInRoot((Object[]) r16, r11 - 5, r12, r13, r14);
        return r15;
    }

    private final Object[] shiftLeafBuffers(int r10, int r11, Object[][] r12, int r13, Object[] r14) {
        if (this.root == null) goto L11;
        ListIterator<Object[]> r5 = leafBufferIterator(rootSize() >> 5);
    L6:
        if (r5.previousIndex() == r10) goto L9;
        Object[] r15 = r5.previous();
        ArraysKt.copyInto(r15, r14, 0, 32 - r11, 32);
        r14 = makeMutableShiftingRight(r15, r11);
        r13 = r13 - 1;
        r12[r13] = r14;
        goto L6
    L9:
        return r5.previous();
    L11:
        throw new IllegalStateException("Required value was null.");
    }

    private final void splitToBuffers(Collection<? extends E> r10, int r11, Object[] r12, int r13, Object[][] r14, int r15, Object[] r16) {
        int r5 = 1;
        if (r15 < 1) goto L18;
        Object[] r17 = makeMutable(r12);
        r14[0] = r17;
        int r18 = r11 & 31;
        int r19 = ((r10.size() + r11) - 1) & 31;
        int r20 = (r13 - r18) + r19;
        if (r20 >= 32) goto L7;
        ArraysKt.copyInto(r17, r16, r19 + 1, r18, r13);
    L12:
        Iterator<? extends E> r21 = r10.iterator();
        copyToBuffer(r17, r18, r21);
    L13:
        if (r5 >= r15) goto L15;
        r14[r5] = copyToBuffer(mutableBuffer(), 0, r21);
        r5 = r5 + 1;
        goto L13
    L15:
        copyToBuffer(r16, 0, r21);
        return;
    L7:
        int r22 = r20 - 31;
        if (r15 != 1) goto L10;
        Object[] r23 = r17;
    L11:
        int r24 = r13 - r22;
        ArraysKt.copyInto(r17, r16, 0, r24, r13);
        ArraysKt.copyInto(r17, r23, r19 + 1, r18, r24);
        r16 = r23;
        goto L12
    L10:
        r23 = mutableBuffer();
        r15 = r15 - 1;
        r14[r15] = r23;
        goto L11
    L18:
        throw new IllegalStateException("Check failed.");
    }

    private final int tailSize(int r5) {
        if (r5 > 32) goto L6;
        return r5;
    L6:
        return r5 - UtilsKt.rootSize(r5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r5) {
        ((AbstractList) this).modCount++;
        int r10 = tailSize();
        if (r10 >= 32) goto L5;
        Object[] r11 = makeMutable(this.tail);
        r11[r10] = r5;
        this.tail = r11;
        this.size = size() + 1;
    L6:
        return true;
    L5:
        pushFilledTail(this.root, this.tail, mutableBufferWith(r5));
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        ((AbstractList) this).modCount++;
        int r5 = tailSize();
        Iterator<? extends E> r11 = r10.iterator();
        if ((32 - r5) < r10.size()) goto L8;
        this.tail = copyToBuffer(makeMutable(this.tail), r5, r11);
        this.size = r10.size() + size();
    L12:
        return true;
    L8:
        int r12 = ((r10.size() + r5) - 1) / 32;
        Object[][] r13 = new Object[r12][];
        r13[0] = copyToBuffer(makeMutable(this.tail), r5, r11);
        int r14 = 1;
    L9:
        if (r14 >= r12) goto L11;
        r13[r14] = copyToBuffer(mutableBuffer(), 0, r11);
        r14 = r14 + 1;
        goto L9
    L11:
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), r13);
        this.tail = copyToBuffer(mutableBuffer(), 0, r11);
        this.size = r10.size() + size();
        goto L12
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public /* bridge */ /* synthetic */ PersistentCollection build() {
        return build();
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r5) {
        ListImplementation.checkElementIndex$runtime_release(r5, size());
        return (E) bufferFor(r5)[r5 & 31];
    }

    public final int getModCount$runtime_release() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] getRoot$runtime_release() {
        return this.root;
    }

    public final int getRootShift$runtime_release() {
        return this.rootShift;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public final Object[] getTail$runtime_release() {
        return this.tail;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return removeAllWithPredicate(new AnonymousClass1(r5));
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        boolean r10 = removeAll(r5);
        if (r10 == false) goto L5;
        ((AbstractList) this).modCount++;
    L5:
        return r10;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r10) {
        ListImplementation.checkElementIndex$runtime_release(r10, size());
        ((AbstractList) this).modCount++;
        int r5 = rootSize();
        if (r10 >= r5) goto L5;
        ObjectRef r11 = new ObjectRef(this.tail[0]);
        Object[] r12 = this.root;
        Intrinsics.checkNotNull(r12);
        removeFromTailAt(removeFromRootAt(r12, this.rootShift, r10, r11), r5, this.rootShift, 0);
        return (E) r11.getValue();
    L5:
        return (E) removeFromTailAt(this.root, r5, this.rootShift, r10 - r5);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        ListImplementation.checkElementIndex$runtime_release(r10, size());
        if (rootSize() > r10) goto L9;
        Object[] r5 = makeMutable(this.tail);
        if (r5 == this.tail) goto L7;
        ((AbstractList) this).modCount++;
    L7:
        int r12 = r10 & 31;
        E r13 = (E) r5[r12];
        r5[r12] = r11;
        this.tail = r5;
        return r13;
    L9:
        ObjectRef r14 = new ObjectRef(null);
        Object[] r15 = this.root;
        Intrinsics.checkNotNull(r15);
        this.root = setInRoot(r15, this.rootShift, r10, r11, r14);
        return (E) r14.getValue();
    }

    public final void setRootShift$runtime_release(int r5) {
        this.rootShift = r5;
    }

    private final boolean removeAll(Function1<? super E, Boolean> r19) {
        int r10 = tailSize();
        ObjectRef r11 = new ObjectRef(null);
        if (this.root == null) goto L5;
        ListIterator<Object[]> r14 = leafBufferIterator(0);
        int r5 = 32;
    L9:
        if (r5 != 32) goto L13;
        if (r14.hasNext() == false) goto L13;
        r5 = removeAll(r19, r14.next(), 32, r11);
    L13:
        if (r5 != 32) goto L20;
        CommonFunctionsKt.m42assert(!r14.hasNext());
        int r12 = removeAllFromTail(r19, r10, r11);
        if (r12 != 0) goto L17;
        pullLastBufferFromRoot(this.root, size(), this.rootShift);
    L17:
        if (r12 != r10) goto L19;
        return false;
    L19:
        return true;
    L20:
        int r13 = r14.previousIndex() << 5;
        ArrayList r16 = new ArrayList();
        List<Object[]> r17 = new ArrayList();
        int r15 = r5;
    L22:
        if (r14.hasNext() == false) goto L24;
        r15 = recyclableRemoveAll(r19, r14.next(), 32, r15, r11, r17, r16);
        r13 = r13;
        goto L22
    L24:
        int r18 = r13;
        int r20 = recyclableRemoveAll(r19, this.tail, r10, r15, r11, r17, r16);
        Object r21 = r11.getValue();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] r22 = (Object[]) r21;
        ArraysKt.fill(r22, null, r20, 32);
        if (r16.isEmpty() == false) goto L27;
        Object[] r23 = this.root;
        Intrinsics.checkNotNull(r23);
    L28:
        int r24 = r18 + (r16.size() << 5);
        this.root = retainFirst(r23, r24);
        this.tail = r22;
        this.size = r24 + r20;
        return true;
    L27:
        r23 = pushBuffers(this.root, r18, this.rootShift, r16.iterator());
        goto L28
    L5:
        if (removeAllFromTail(r19, r10, r11) != r10) goto L7;
        return false;
    L7:
        return true;
    }

    private final int tailSize() {
        return tailSize(size());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentList<E> build() {
        if (this.root == this.vectorRoot) goto L5;
    L7:
        this.ownership = new MutabilityOwnership();
        Object[] r5 = this.root;
        this.vectorRoot = r5;
        Object[] r10 = this.tail;
        this.vectorTail = r10;
        if (r5 == null) goto L10;
        Object[] r11 = this.root;
        Intrinsics.checkNotNull(r11);
        PersistentVector r12 = new PersistentVector(r11, this.tail, size(), this.rootShift);
    L14:
        this.vector = r12;
        return (PersistentList<E>) r12;
    L10:
        if (r10.length != 0) goto L12;
        r12 = UtilsKt.persistentVectorOf();
        goto L14
    L12:
        r12 = new SmallPersistentVector(Arrays.copyOf(this.tail, size()));
        goto L14
    L5:
        if (this.tail != this.vectorTail) goto L7;
        r12 = this.vector;
        goto L14
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int r5) {
        ListImplementation.checkPositionIndex$runtime_release(r5, size());
        return new PersistentVectorMutableIterator(this, r5);
    }

    private final void insertIntoRoot(Collection<? extends E> r10, int r11, int r12, Object[][] r13, int r14, Object[] r15) {
        if (this.root == null) goto L10;
        int r5 = r11 >> 5;
        Object[] r16 = shiftLeafBuffers(r5, r12, r13, r14, r15);
        int r17 = r14 - (((rootSize() >> 5) - 1) - r5);
        if (r17 >= r14) goto L7;
        r15 = r13[r17];
        Intrinsics.checkNotNull(r15);
    L7:
        splitToBuffers(r10, r11, r16, 32, r13, r17, r15);
        return;
    L10:
        throw new IllegalStateException("Required value was null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        ListImplementation.checkPositionIndex$runtime_release(r10, size());
        if (r10 != size()) goto L6;
        add(r11);
        return;
    L6:
        ((AbstractList) this).modCount++;
        int r5 = rootSize();
        if (r10 < r5) goto L10;
        insertIntoTail(this.root, r10 - r5, r11);
        return;
    L10:
        ObjectRef r12 = new ObjectRef(null);
        Object[] r13 = this.root;
        Intrinsics.checkNotNull(r13);
        insertIntoTail(insertIntoRoot(r13, this.rootShift, r10, r11, r12), 0, r12.getValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r15, Collection<? extends E> r16) {
        Intrinsics.checkNotNullParameter(r16, "elements");
        ListImplementation.checkPositionIndex$runtime_release(r15, size());
        if (r15 == size()) goto L5;
        boolean r5 = false;
        if (r16.isEmpty() == false) goto L9;
        return false;
    L9:
        ((AbstractList) this).modCount++;
        int r11 = (r15 >> 5) << 5;
        int r10 = ((r16.size() + (size() - r11)) - 1) / 32;
        if (r10 == 0) goto L12;
        Object[][] r12 = new Object[r10][];
        int r13 = tailSize();
        int r14 = tailSize(r16.size() + size());
        if (r15 < rootSize()) goto L19;
        Object[] r17 = mutableBuffer();
        splitToBuffers(r16, r15, this.tail, r13, r12, r10, r17);
    L22:
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, r11, r12);
        this.tail = r17;
        this.size = r16.size() + size();
        return true;
    L19:
        if (r14 <= r13) goto L21;
        int r18 = r14 - r13;
        r17 = makeMutableShiftingRight(this.tail, r18);
        insertIntoRoot(r16, r15, r18, r12, r10, r17);
        goto L22
    L21:
        int r19 = r13 - r14;
        r17 = ArraysKt.copyInto(this.tail, mutableBuffer(), 0, r19, r13);
        int r20 = 32 - r19;
        Object[] r21 = makeMutableShiftingRight(this.tail, r20);
        int r22 = r10 - 1;
        r12[r22] = r21;
        insertIntoRoot(r16, r15, r20, r12, r22, r21);
        goto L22
    L12:
        if (r15 < rootSize()) goto L14;
        r5 = true;
    L14:
        CommonFunctionsKt.m42assert(r5);
        int r23 = r15 & 31;
        int r24 = ((r16.size() + r15) - 1) & 31;
        Object[] r25 = this.tail;
        Object[] r26 = ArraysKt.copyInto(r25, makeMutable(r25), r24 + 1, r23, tailSize());
        copyToBuffer(r26, r23, r16.iterator());
        this.tail = r26;
        this.size = r16.size() + size();
        return true;
    L5:
        return addAll(r16);
    }

    private final int removeAll(Function1<? super E, Boolean> r10, Object[] r11, int r12, ObjectRef r13) {
        int r5 = 0;
        Object[] r14 = r11;
        int r15 = r12;
        boolean r16 = false;
    L3:
        if (r5 >= r12) goto L11;
        Object r17 = r11[r5];
        if (r10.invoke(r17).booleanValue() == false) goto L8;
        if (r16 == true) goto L10;
        r14 = makeMutable(r11);
        r16 = true;
        r15 = r5;
    L10:
        r5 = r5 + 1;
        goto L3
    L8:
        if (r16 == false) goto L10;
        r14[r15] = r17;
        r15 = r15 + 1;
        goto L10
    L11:
        r13.setValue(r14);
        return r15;
    }
}
