package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import g8.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.d2;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.flow.o0;
import kotlinx.coroutines.flow.p2;
import kotlinx.coroutines.flow.q2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.c;
import kotlinx.coroutines.j;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.l;
import kotlinx.coroutines.l1;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.t;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u0000 Ó\u00012\u00020\u0001:\nÓ\u0001Ô\u0001Õ\u0001Ö\u0001×\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000bJ*\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0016H\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u0010J\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u0010J\u001d\u0010#\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0010¢\u0006\u0004\b!\u0010\"J\u0017\u0010&\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b'\u0010%J\u0017\u0010*\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b)\u0010%J\u0017\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020+H\u0010¢\u0006\u0004\b-\u0010.J\u0017\u00104\u001a\u00020\t2\u0006\u00101\u001a\u000200H\u0010¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\t2\u0006\u00101\u001a\u000200H\u0010¢\u0006\u0004\b5\u00103J\u001f\u0010;\u001a\u00020\t2\u0006\u00101\u001a\u0002002\u0006\u00108\u001a\u000207H\u0010¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b<\u0010%J\u0019\u0010@\u001a\u0004\u0018\u0001072\u0006\u00101\u001a\u000200H\u0010¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010AH\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bE\u0010FJ$\u0010E\u001a\u00020\t2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0GH\u0082\b¢\u0006\u0004\bE\u0010IJ\u0017\u0010L\u001a\u00020\t2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ1\u0010S\u001a\u00020\t2\n\u0010P\u001a\u00060Nj\u0002`O2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010R\u001a\u00020DH\u0002¢\u0006\u0004\bS\u0010TJ\u0011\u0010V\u001a\u0004\u0018\u00010UH\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\tH\u0002¢\u0006\u0004\bX\u0010\u0010J#\u0010]\u001a\u00020\t2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[H\u0082@ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0013\u0010_\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b_\u0010\u000bJQ\u0010h\u001a\u00020\t2<\u0010g\u001a8\b\u0001\u0012\u0004\u0012\u00020a\u0012\u0013\u0012\u00110Y¢\u0006\f\bb\u0012\b\bc\u0012\u0004\b\b(Z\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0d\u0012\u0006\u0012\u0004\u0018\u00010e0`¢\u0006\u0002\bfH\u0082@ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bj\u0010%J)\u0010m\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010kH\u0002¢\u0006\u0004\bm\u0010nJ3\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00130o2\f\u0010p\u001a\b\u0012\u0004\u0012\u0002000o2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010kH\u0002¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\tH\u0002¢\u0006\u0004\bs\u0010\u0010J#\u0010t\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\t0G2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bt\u0010uJ3\u0010v\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\t0G2\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010kH\u0002¢\u0006\u0004\bv\u0010wJ<\u0010y\u001a\u00028\u0000\"\u0004\b\u0000\u0010x2\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010k2\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0082\b¢\u0006\u0004\by\u0010zJ\u0017\u0010}\u001a\u00020\t2\u0006\u0010|\u001a\u00020{H\u0002¢\u0006\u0004\b}\u0010~R*\u0010\u0081\u0001\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u007f8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0017\u0010\u0088\u0001\u001a\u00020e8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001e\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020e0k8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0091\u0001R\u001e\u0010\u0095\u0001\u001a\t\u0012\u0004\u0012\u00020\u00130\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0091\u0001R\u001e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u0002000\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0091\u0001R4\u0010\u0099\u0001\u001a\u001f\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010e0\u0098\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002000\u008f\u00010\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R$\u0010\u009b\u0001\u001a\u000f\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002070\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009a\u0001R\"\u0010\u009c\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u0091\u0001R!\u0010\u009d\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R!\u0010\u009f\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001a\u0010¢\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0019\u0010¨\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010¥\u0001R\u001f\u0010«\u0001\u001a\n\u0012\u0005\u0012\u00030ª\u00010©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R\u001c\u0010´\u0001\u001a\u00070³\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0016\u0010\f\u001a\u00020\u00028PX\u0090\u0004¢\u0006\b\u001a\u0006\b¶\u0001\u0010²\u0001R&\u0010»\u0001\u001a\n\u0012\u0005\u0012\u00030ª\u00010·\u00018FX\u0087\u0004¢\u0006\u000f\u0012\u0005\bº\u0001\u0010\u0010\u001a\u0006\b¸\u0001\u0010¹\u0001R\u001c\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u00030ª\u00010¼\u00018F¢\u0006\b\u001a\u0006\b½\u0001\u0010¾\u0001R\u0013\u0010Á\u0001\u001a\u00020D8F¢\u0006\u0007\u001a\u0005\bÀ\u0001\u0010FR\u0018\u0010Ä\u0001\u001a\u00030¡\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0016\u0010Æ\u0001\u001a\u00020D8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010FR\u0016\u0010È\u0001\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010FR\u0016\u0010Ê\u0001\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010FR\u0016\u0010Ì\u0001\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u0010FR\u0016\u0010Î\u0001\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010FR\u0016\u0010Ð\u0001\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010FR\u0016\u0010Ò\u0001\u001a\u00020D8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ø\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "Lkotlin/coroutines/CoroutineContext;", "effectCoroutineContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/compose/runtime/RecomposerInfo;", "asRecomposerInfo", "()Landroidx/compose/runtime/RecomposerInfo;", "", "runRecomposeAndApplyChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recomposeCoroutineContext", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "()V", "close", "join", "Landroidx/compose/runtime/ControlledComposition;", "composition", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitial", "awaitIdle", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "", "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime_release", "(Ljava/util/Set;)V", "recordInspectionTable", "registerComposition$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;)V", "registerComposition", "unregisterComposition$runtime_release", "unregisterComposition", "invalidate$runtime_release", "invalidate", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "invalidateScope$runtime_release", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "invalidateScope", "Landroidx/compose/runtime/MovableContentStateReference;", "reference", "insertMovableContent$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "deletedMovableContent$runtime_release", "deletedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "data", "movableContentStateReleased$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentState;)V", "movableContentStateReleased", "reportRemovedComposition$runtime_release", "reportRemovedComposition", "movableContentStateResolve$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", "Lkotlinx/coroutines/j;", "deriveStateLocked", "()Lkotlinx/coroutines/j;", "", "recordComposerModifications", "()Z", "Lkotlin/Function1;", "onEachInvalidComposition", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/Job;", "callingJob", "registerRunnerJob", "(Lkotlinx/coroutines/Job;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failedInitialComposition", "recoverable", "processCompositionError", "(Ljava/lang/Exception;Landroidx/compose/runtime/ControlledComposition;Z)V", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "resetErrorState", "()Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "Landroidx/compose/runtime/MonotonicFrameClock;", "parentFrameClock", "Landroidx/compose/runtime/ProduceFrameSignal;", "frameSignal", "runFrameLoop", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "recompositionRunner", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performInitialMovableContentInserts", "Landroidx/compose/runtime/collection/IdentityArraySet;", "modifiedValues", "performRecompose", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;)Landroidx/compose/runtime/ControlledComposition;", "", "references", "performInsertValues", "(Ljava/util/List;Landroidx/compose/runtime/collection/IdentityArraySet;)Ljava/util/List;", "discardUnusedValues", "readObserverOf", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/jvm/functions/Function1;", "writeObserverOf", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;)Lkotlin/jvm/functions/Function1;", ExifInterface.GPS_DIRECTION_TRUE, "composing", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshot", "applyAndCheck", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "", "<set-?>", "changeCount", "J", "getChangeCount", "()J", "Landroidx/compose/runtime/BroadcastFrameClock;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "stateLock", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", "", "closeCause", "Ljava/lang/Throwable;", "", "knownCompositions", "Ljava/util/List;", "snapshotInvalidations", "Landroidx/compose/runtime/collection/IdentityArraySet;", "compositionInvalidations", "compositionsAwaitingApply", "compositionValuesAwaitingInsert", "", "Landroidx/compose/runtime/MovableContent;", "compositionValuesRemoved", "Ljava/util/Map;", "compositionValueStatesAvailable", "failedCompositions", "compositionsRemoved", "Ljava/util/Set;", "workContinuation", "Lkotlinx/coroutines/j;", "", "concurrentCompositionsOutstanding", "I", "isClosed", "Z", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "Lkotlinx/coroutines/flow/d2;", "Landroidx/compose/runtime/Recomposer$State;", "_state", "Lkotlinx/coroutines/flow/d2;", "Lkotlinx/coroutines/t;", "effectJob", "Lkotlinx/coroutines/t;", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "getRecomposeCoroutineContext$runtime_release", "Lkotlinx/coroutines/flow/g;", "getState", "()Lkotlinx/coroutines/flow/g;", "getState$annotations", "state", "Lkotlinx/coroutines/flow/p2;", "getCurrentState", "()Lkotlinx/coroutines/flow/p2;", "currentState", "getHasPendingWork", "hasPendingWork", "getCompoundHashKey$runtime_release", "()I", "compoundHashKey", "getCollectingParameterInformation$runtime_release", "collectingParameterInformation", "getHasBroadcastFrameClockAwaitersLocked", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaiters", "getShouldKeepRecomposing", "shouldKeepRecomposing", "getHasSchedulingWork", "hasSchedulingWork", "getHasFrameWorkLocked", "hasFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasConcurrentFrameWorkLocked", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 6 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 7 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 8 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1502:1\n1162#1,5:1550\n1168#1:1560\n1162#1,5:1573\n1168#1:1583\n1162#1,5:1604\n1168#1:1625\n70#2:1503\n70#2:1504\n70#2:1507\n70#2:1509\n70#2:1516\n70#2:1517\n70#2:1530\n70#2:1531\n70#2:1532\n70#2:1533\n70#2:1534\n70#2:1535\n70#2:1545\n70#2:1548\n70#2:1549\n70#2:1561\n70#2:1562\n70#2:1612\n70#2:1626\n70#2:1649\n70#2:1650\n70#2:1651\n70#2:1652\n70#2:1653\n70#2:1654\n70#2:1655\n70#2:1656\n70#2:1657\n70#2:1658\n70#2:1659\n70#2:1660\n1229#3,2:1505\n1#4:1508\n33#5,6:1510\n33#5,6:1518\n33#5,6:1524\n93#5,2:1563\n33#5,4:1565\n95#5,2:1569\n38#5:1571\n97#5:1572\n120#5,3:1584\n33#5,4:1587\n123#5,2:1591\n125#5,2:1600\n38#5:1602\n127#5:1603\n82#5,3:1613\n33#5,4:1616\n85#5,2:1620\n38#5:1622\n87#5:1623\n82#5,3:1627\n33#5,4:1630\n85#5,2:1634\n38#5:1636\n87#5:1637\n33#5,6:1638\n314#6,9:1536\n323#6,2:1546\n129#7,5:1555\n129#7,5:1578\n129#7,3:1609\n133#7:1624\n129#7,5:1644\n361#8,7:1593\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer\n*L\n1012#1:1550,5\n1012#1:1560\n1089#1:1573,5\n1089#1:1583\n1109#1:1604,5\n1109#1:1625\n282#1:1503\n332#1:1504\n426#1:1507\n430#1:1509\n451#1:1516\n456#1:1517\n482#1:1530\n689#1:1531\n725#1:1532\n737#1:1533\n754#1:1534\n890#1:1535\n902#1:1545\n977#1:1548\n993#1:1549\n1025#1:1561\n1056#1:1562\n1112#1:1612\n1125#1:1626\n1192#1:1649\n1229#1:1650\n1244#1:1651\n1270#1:1652\n1278#1:1653\n1287#1:1654\n1294#1:1655\n1301#1:1656\n1310#1:1657\n1316#1:1658\n1328#1:1659\n1062#1:1660\n333#1:1505,2\n436#1:1510,6\n469#1:1518,6\n474#1:1524,6\n1057#1:1563,2\n1057#1:1565,4\n1057#1:1569,2\n1057#1:1571\n1057#1:1572\n1106#1:1584,3\n1106#1:1587,4\n1106#1:1591,2\n1106#1:1600,2\n1106#1:1602\n1106#1:1603\n1113#1:1613,3\n1113#1:1616,4\n1113#1:1620,2\n1113#1:1622\n1113#1:1623\n1129#1:1627,3\n1129#1:1630,4\n1129#1:1634,2\n1129#1:1636\n1129#1:1637\n1136#1:1638,6\n901#1:1536,9\n901#1:1546,2\n1012#1:1555,5\n1089#1:1578,5\n1109#1:1609,3\n1109#1:1624\n1166#1:1644,5\n1106#1:1593,7\n*E\n"})
public final class Recomposer extends CompositionContext {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final AtomicReference<Boolean> _hotReloadEnabled = null;
    private static final d2 _runningRecomposers = null;
    private final d2 _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final List<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final t effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List<ControlledComposition> knownCompositions;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private IdentityArraySet<Object> snapshotInvalidations;
    private final Object stateLock;
    private j workContinuation;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0007H\u0000¢\u0006\u0004\b!\u0010\u0003R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#8F¢\u0006\u0006\u001a\u0004\b&\u0010'R4\u0010,\u001a\"\u0012\f\u0012\n **\u0004\u0018\u00010\u000b0\u000b0)j\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u000b0\u000b`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u00100\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004R\u00020\u00050/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "<init>", "()V", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "info", "", "addRunning", "(Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;)V", "removeRunning", "", "value", "setHotReloadEnabled$runtime_release", "(Z)V", "setHotReloadEnabled", "saveStateAndDisposeForHotReload$runtime_release", "()Ljava/lang/Object;", "saveStateAndDisposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "(Ljava/lang/Object;)V", "loadStateAndComposeForHotReload", "", STGroup.DICT_KEY, "invalidateGroupsWithKey$runtime_release", "(I)V", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "()Ljava/util/List;", "getCurrentErrors", "clearErrors$runtime_release", "clearErrors", "Lkotlinx/coroutines/flow/p2;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/p2;", "runningRecomposers", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/flow/d2;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "_runningRecomposers", "Lkotlinx/coroutines/flow/d2;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1502:1\n1360#2:1503\n1446#2,5:1504\n1855#2,2:1509\n1855#2,2:1523\n1855#2,2:1525\n1603#2,9:1527\n1855#2:1536\n1856#2:1538\n1612#2:1539\n1603#2,9:1540\n1855#2:1549\n1856#2:1551\n1612#2:1552\n33#3,6:1511\n33#3,6:1517\n1#4:1537\n1#4:1550\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$Companion\n*L\n1379#1:1503\n1379#1:1504,5\n1387#1:1509,2\n1396#1:1523,2\n1403#1:1525,2\n1417#1:1527,9\n1417#1:1536\n1417#1:1538\n1417#1:1539\n1422#1:1540,9\n1422#1:1549\n1422#1:1551\n1422#1:1552\n1393#1:1511,6\n1394#1:1517,6\n1417#1:1537\n1422#1:1550\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ void access$addRunning(Companion r5, RecomposerInfoImpl r10) {
            r5.addRunning(r10);
        }

        public static final /* synthetic */ void access$removeRunning(Companion r5, RecomposerInfoImpl r10) {
            r5.removeRunning(r10);
        }

        private final void addRunning(RecomposerInfoImpl r5) {
        L2:
            PersistentSet r10 = (PersistentSet) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue();
            Object r11 = r10.add(r5);
            if (r10 == r11) goto L9;
            q2 r12 = (q2) Recomposer.access$get_runningRecomposers$cp();
            r12.getClass();
            g r13 = b.f18863b;
            if (r11 != null) goto L8;
            r11 = r13;
        L8:
            if (r12.j(r10, r11) == false) goto L2;
            return;
        }

        private final void removeRunning(RecomposerInfoImpl r5) {
        L2:
            PersistentSet r10 = (PersistentSet) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue();
            Object r11 = r10.remove(r5);
            if (r10 == r11) goto L9;
            q2 r12 = (q2) Recomposer.access$get_runningRecomposers$cp();
            r12.getClass();
            g r13 = b.f18863b;
            if (r11 != null) goto L8;
            r11 = r13;
        L8:
            if (r12.j(r10, r11) == false) goto L2;
            return;
        }

        public final void clearErrors$runtime_release() {
            Iterable r5 = (Iterable) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue();
            ArrayList r10 = new ArrayList();
            Iterator r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            RecomposerErrorState r12 = ((RecomposerInfoImpl) r11.next()).resetErrorState();
            if (r12 == null) goto L4;
            r10.add(r12);
            goto L4
        }

        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable r5 = (Iterable) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue();
            ArrayList r10 = new ArrayList();
            Iterator r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            RecomposerErrorInfo r12 = ((RecomposerInfoImpl) r11.next()).getCurrentError();
            if (r12 == null) goto L4;
            r10.add(r12);
            goto L4
        L8:
            return r10;
        }

        public final p2 getRunningRecomposers() {
            return Recomposer.access$get_runningRecomposers$cp();
        }

        public final void invalidateGroupsWithKey$runtime_release(int r5) {
            Recomposer.access$get_hotReloadEnabled$cp().set(Boolean.TRUE);
            Iterator r10 = ((Iterable) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue()).iterator();
        L4:
            if (r10.hasNext() == false) goto L11;
            RecomposerInfoImpl r11 = (RecomposerInfoImpl) r10.next();
            RecomposerErrorInfo r12 = r11.getCurrentError();
            if (r12 == null) goto L10;
            if (r12.getRecoverable() == false) goto L4;
        L10:
            r11.resetErrorState();
            r11.invalidateGroupsWithKey(r5);
            r11.retryFailedCompositions();
            goto L4
        }

        public final void loadStateAndComposeForHotReload$runtime_release(Object r5) {
            Intrinsics.checkNotNullParameter(r5, "token");
            Recomposer.access$get_hotReloadEnabled$cp().set(Boolean.TRUE);
            Iterator r10 = ((Iterable) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue()).iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((RecomposerInfoImpl) r10.next()).resetErrorState();
            goto L4
        L6:
            List r11 = (List) r5;
            int r12 = r11.size();
            int r13 = 0;
            int r14 = 0;
        L7:
            if (r14 >= r12) goto L9;
            ((HotReloadable) r11.get(r14)).resetContent();
            r14 = r14 + 1;
            goto L7
        L9:
            int r15 = r11.size();
        L10:
            if (r13 >= r15) goto L12;
            ((HotReloadable) r11.get(r13)).recompose();
            r13 = r13 + 1;
            goto L10
        L12:
            Iterator r16 = ((Iterable) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue()).iterator();
        L14:
            if (r16.hasNext() == false) goto L16;
            ((RecomposerInfoImpl) r16.next()).retryFailedCompositions();
            goto L14
        }

        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer.access$get_hotReloadEnabled$cp().set(Boolean.TRUE);
            Iterable r5 = (Iterable) ((q2) Recomposer.access$get_runningRecomposers$cp()).getValue();
            ArrayList r10 = new ArrayList();
            Iterator r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            CollectionsKt.a(r10, ((RecomposerInfoImpl) r11.next()).saveStateAndDisposeForHotReload());
            goto L4
        L6:
            return r10;
        }

        public final void setHotReloadEnabled$runtime_release(boolean r5) {
            Recomposer.access$get_hotReloadEnabled$cp().set(Boolean.valueOf(r5));
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class HotReloadable {
        private Function2<? super Composer, ? super Integer, Unit> composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl r5) {
            Intrinsics.checkNotNullParameter(r5, "composition");
            this.composition = r5;
            this.composable = r5.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot() == false) goto L6;
            this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m7getLambda1$runtime_release());
            return;
        }

        public final void recompose() {
            if (this.composition.isRoot() == false) goto L6;
            this.composition.setContent(this.composable);
            return;
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean r5, Exception r10) {
            Intrinsics.checkNotNullParameter(r10, "cause");
            this.recoverable = r5;
            this.cause = r10;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public Exception getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\"\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "<init>", "(Landroidx/compose/runtime/Recomposer;)V", "", STGroup.DICT_KEY, "", "invalidateGroupsWithKey", "(I)V", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "saveStateAndDisposeForHotReload", "()Ljava/util/List;", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "resetErrorState", "()Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "()V", "Lkotlinx/coroutines/flow/g;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/g;", "state", "", "getHasPendingWork", "()Z", "hasPendingWork", "", "getChangeCount", "()J", "changeCount", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "currentError", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$RecomposerInfoImpl\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1502:1\n70#2:1503\n70#2:1504\n70#2:1523\n211#3,3:1505\n33#3,4:1508\n214#3:1512\n215#3:1514\n38#3:1515\n216#3:1516\n33#3,6:1517\n211#3,3:1524\n33#3,4:1527\n214#3:1531\n215#3:1533\n38#3:1534\n216#3:1535\n82#3,3:1536\n33#3,4:1539\n85#3:1543\n86#3:1545\n38#3:1546\n87#3:1547\n1#4:1513\n1#4:1532\n1#4:1544\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$RecomposerInfoImpl\n*L\n358#1:1503\n363#1:1504\n371#1:1523\n367#1:1505,3\n367#1:1508,4\n367#1:1512\n367#1:1514\n367#1:1515\n367#1:1516\n368#1:1517,6\n375#1:1524,3\n375#1:1527,4\n375#1:1531\n375#1:1533\n375#1:1534\n375#1:1535\n376#1:1536,3\n376#1:1539,4\n376#1:1543\n376#1:1545\n376#1:1546\n376#1:1547\n367#1:1513\n375#1:1532\n*E\n"})
    public final class RecomposerInfoImpl implements RecomposerInfo {
        final /* synthetic */ Recomposer this$0;

        public RecomposerInfoImpl(Recomposer r5) {
            this.this$0 = r5;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return this.this$0.getChangeCount();
        }

        public final RecomposerErrorInfo getCurrentError() {
            Object r5 = Recomposer.access$getStateLock$p(this.this$0);
            Recomposer r10 = this.this$0;
            monitor-enter(r5);
            RecomposerErrorState r11 = Recomposer.access$getErrorState$p(r10);     // Catch: Throwable -> L7
            monitor-exit(r5);
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return this.this$0.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public kotlinx.coroutines.flow.g getState() {
            return this.this$0.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int r10) {
            Object r5 = Recomposer.access$getStateLock$p(this.this$0);
            Recomposer r11 = this.this$0;
            monitor-enter(r5);
            List r12 = CollectionsKt.toMutableList(Recomposer.access$getKnownCompositions$p(r11));     // Catch: Throwable -> L19
            monitor-exit(r5);
            ArrayList r13 = new ArrayList(r12.size());
            int r14 = r12.size();
            int r15 = 0;
            int r16 = 0;
        L7:
            if (r16 >= r14) goto L15;
            ControlledComposition r17 = (ControlledComposition) r12.get(r16);
            if ((r17 instanceof CompositionImpl) == false) goto L11;
            CompositionImpl r18 = (CompositionImpl) r17;
        L12:
            if (r18 == null) goto L14;
            r13.add(r18);
        L14:
            r16 = r16 + 1;
            goto L7
        L11:
            r18 = null;
            goto L12
        L15:
            int r19 = r13.size();
        L16:
            if (r15 >= r19) goto L18;
            ((CompositionImpl) r13.get(r15)).invalidateGroupsWithKey(r10);
            r15 = r15 + 1;
            goto L16
        L18:
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.access$resetErrorState(this.this$0);
        }

        public final void retryFailedCompositions() {
            Recomposer.access$retryFailedCompositions(this.this$0);
        }

        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            Object r5 = Recomposer.access$getStateLock$p(this.this$0);
            Recomposer r10 = this.this$0;
            monitor-enter(r5);
            List r11 = CollectionsKt.toMutableList(Recomposer.access$getKnownCompositions$p(r10));     // Catch: Throwable -> L19
            monitor-exit(r5);
            ArrayList r12 = new ArrayList(r11.size());
            int r13 = r11.size();
            int r14 = 0;
            int r15 = 0;
        L7:
            if (r15 >= r13) goto L15;
            ControlledComposition r16 = (ControlledComposition) r11.get(r15);
            if ((r16 instanceof CompositionImpl) == false) goto L11;
            CompositionImpl r17 = (CompositionImpl) r16;
        L12:
            if (r17 == null) goto L14;
            r12.add(r17);
        L14:
            r15 = r15 + 1;
            goto L7
        L11:
            r17 = null;
            goto L12
        L15:
            ArrayList r18 = new ArrayList(r12.size());
            int r19 = r12.size();
        L16:
            if (r14 >= r19) goto L18;
            HotReloadable r20 = new HotReloadable((CompositionImpl) r12.get(r14));
            r20.clearContent();
            r18.add(r20);
            r14 = r14 + 1;
            goto L16
        L18:
            return r18;
        L19:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State Idle = null;
        public static final State Inactive = null;
        public static final State InactivePendingWork = null;
        public static final State PendingWork = null;
        public static final State ShutDown = null;
        public static final State ShuttingDown = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{ShutDown, ShuttingDown, Inactive, InactivePendingWork, Idle, PendingWork};
        }

        static {
            ShutDown = new State("ShutDown", 0);
            ShuttingDown = new State("ShuttingDown", 1);
            Inactive = new State("Inactive", 2);
            InactivePendingWork = new State("InactivePendingWork", 3);
            Idle = new State("Idle", 4);
            PendingWork = new State("PendingWork", 5);
            $VALUES = $values();
        }

        private State(String r5, int r10) {
            super(r5, r10);
        }

        public static State valueOf(String r5) {
            return (State) Enum.valueOf(State.class, r5);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$awaitIdle$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r5) {
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            AnonymousClass2 r11 = new AnonymousClass2(r10);
            r11.L$0 = r5;
            return r11;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(State r5, Continuation<? super Boolean> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (((State) this.L$0).compareTo(State.Idle) <= 0) goto L7;
            boolean r10 = true;
        L9:
            return Boxing.boxBoolean(r10);
        L7:
            r10 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(State r5, Continuation<? super Boolean> r10) {
            return invoke2(r5, r10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ST.IMPLICIT_ARG_NAME, "Landroidx/compose/runtime/Recomposer$State;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$join$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00572 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C00572(Continuation<? super C00572> r5) {
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C00572 r11 = new C00572(r10);
            r11.L$0 = r5;
            return r11;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(State r5, Continuation<? super Boolean> r10) {
            return ((C00572) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            if (((State) this.L$0) != State.ShutDown) goto L7;
            boolean r10 = true;
        L9:
            return Boxing.boxBoolean(r10);
        L7:
            r10 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(State r5, Continuation<? super Boolean> r10) {
            return invoke2(r5, r10);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {945}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$recompositionRunner$2\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,1502:1\n70#2:1503\n70#2:1510\n33#3,6:1504\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$recompositionRunner$2\n*L\n941#1:1503\n950#1:1510\n943#1:1504,6\n*E\n"})
    public static final class C00582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", i = {}, l = {946}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass3(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> r5, MonotonicFrameClock r10, Continuation<? super AnonymousClass3> r11) {
                this.$block = r5;
                this.$parentFrameClock = r10;
                super(2, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
                AnonymousClass3 r11 = new AnonymousClass3(this.$block, this.$parentFrameClock, r10);
                r11.L$0 = r5;
                return r11;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
                return invoke2(r5, r10);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r5) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r11 = this.label;
                if (r11 == 0) goto L8;
                if (r11 != 1) goto L7;
                ResultKt.throwOnFailure(r5);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                CoroutineScope r12 = (CoroutineScope) this.L$0;
                Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> r13 = this.$block;
                MonotonicFrameClock r14 = this.$parentFrameClock;
                this.label = 1;
                if (r13.invoke(r12, r14, this) != r10) goto L12;
                return r10;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
                return ((AnonymousClass3) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C00582(Recomposer r5, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> r10, MonotonicFrameClock r11, Continuation<? super C00582> r12) {
            this.this$0 = r5;
            this.$block = r10;
            this.$parentFrameClock = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C00582 r11 = new C00582(this.this$0, this.$block, this.$parentFrameClock, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L12;
            if (r11 != 1) goto L11;
            ObserverHandle r12 = (ObserverHandle) this.L$1;
            Job r13 = (Job) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
        L26:
            r12.dispose();
            Object r14 = Recomposer.access$getStateLock$p(this.this$0);
            Recomposer r15 = this.this$0;
            monitor-enter(r14);
        L31:
            th = move-exception;
            throw th;
        L29:
            if (Recomposer.access$getRunnerJob$p(r15) != r13) goto L33;
            Recomposer.access$setRunnerJob$p(r15, null);     // Catch: Throwable -> L31
        L33:
            Recomposer.access$deriveStateLocked(r15);     // Catch: Throwable -> L31
            monitor-exit(r14);
            Companion.access$removeRunning(Recomposer.Companion, Recomposer.access$getRecomposerInfo$p(this.this$0));
            return Unit.INSTANCE;
        L8:
            Throwable th2 = th;
        L42:
            r12.dispose();
            Object r16 = Recomposer.access$getStateLock$p(this.this$0);
            Recomposer r17 = this.this$0;
            monitor-enter(r16);
        L47:
            th = move-exception;
            throw th;
        L45:
            if (Recomposer.access$getRunnerJob$p(r17) != r13) goto L49;
            Recomposer.access$setRunnerJob$p(r17, null);     // Catch: Throwable -> L47
        L49:
            Recomposer.access$deriveStateLocked(r17);     // Catch: Throwable -> L47
            monitor-exit(r16);
            Companion.access$removeRunning(Recomposer.Companion, Recomposer.access$getRecomposerInfo$p(this.this$0));
            throw th2;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);
            r13 = j0.g(((CoroutineScope) this.L$0).getCoroutineContext());
            Recomposer.access$registerRunnerJob(this.this$0, r13);
            Snapshot.Companion r18 = Snapshot.Companion;
            final Recomposer r19 = this.this$0;
            ObserverHandle r110 = r18.registerApplyObserver(new Recomposer$recompositionRunner$2$unregisterApplyObserver$1(r19));
            Companion.access$addRunning(Recomposer.Companion, Recomposer.access$getRecomposerInfo$p(this.this$0));
            Object r20 = Recomposer.access$getStateLock$p(this.this$0);     // Catch: Throwable -> L20
            Recomposer r21 = this.this$0;     // Catch: Throwable -> L20
            monitor-enter(r20);     // Catch: Throwable -> L20
            List r22 = CollectionsKt.toMutableList(Recomposer.access$getKnownCompositions$p(r21));     // Catch: Throwable -> L39
            monitor-exit(r20);     // Catch: Throwable -> L20
            int r23 = r22.size();     // Catch: Throwable -> L20
            int r24 = 0;
        L18:
            if (r24 >= r23) goto L22;
            ((ControlledComposition) r22.get(r24)).invalidateAll();     // Catch: Throwable -> L20
            r24 = r24 + 1;     // Catch: Throwable -> L20
            goto L18
        L22:
            AnonymousClass3 r25 = new AnonymousClass3(this.$block, this.$parentFrameClock, null);     // Catch: Throwable -> L20
            this.L$0 = r13;     // Catch: Throwable -> L20
            this.L$1 = r110;     // Catch: Throwable -> L20
            this.label = 1;     // Catch: Throwable -> L20
            if (h0.d(r25, this) != r5) goto L25;
            return r5;
        L25:
            r12 = r110;
            goto L26
        L39:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            r12 = r110;
            th2 = th;
            goto L42
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((C00582) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {822, 829}, m = "runFrameLoop", n = {"this", "parentFrameClock", "frameSignal", "toRecompose", "toApply", "this", "parentFrameClock", "frameSignal", "toRecompose", "toApply"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class C00591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ Recomposer this$0;

        public C00591(Recomposer r5, Continuation<? super C00591> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.access$runFrameLoop(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {526, 537}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeAndApplyChanges$2\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,1502:1\n70#2:1503\n33#3,6:1504\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeAndApplyChanges$2\n*L\n519#1:1503\n520#1:1504,6\n*E\n"})
    public static final class C00612 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ Recomposer this$0;

        public C00612(Recomposer r5, Continuation<? super C00612> r10) {
            this.this$0 = r5;
            super(3, r10);
        }

        public static final /* synthetic */ void access$invokeSuspend$clearRecompositionState(List r5, List r10, List r11, Set r12, Set r13) {
            invokeSuspend$clearRecompositionState(r5, r10, r11, r12, r13);
        }

        public static final /* synthetic */ void access$invokeSuspend$fillToInsert(List r5, Recomposer r10) {
            invokeSuspend$fillToInsert(r5, r10);
        }

        private static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> r5, List<MovableContentStateReference> r10, List<ControlledComposition> r11, Set<ControlledComposition> r12, Set<ControlledComposition> r13) {
            r5.clear();
            r10.clear();
            r11.clear();
            r12.clear();
            r13.clear();
        }

        private static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> r5, Recomposer r10) {
            r5.clear();
            Object r11 = Recomposer.access$getStateLock$p(r10);
            monitor-enter(r11);
            List r12 = Recomposer.access$getCompositionValuesAwaitingInsert$p(r10);     // Catch: Throwable -> L7
            int r13 = r12.size();     // Catch: Throwable -> L7
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L9;
            r5.add((MovableContentStateReference) r12.get(r14));     // Catch: Throwable -> L7
            r14 = r14 + 1;     // Catch: Throwable -> L7
            goto L5
        L9:
            Recomposer.access$getCompositionValuesAwaitingInsert$p(r10).clear();     // Catch: Throwable -> L7
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r11);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r5, MonotonicFrameClock r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00da -> B:23:0x00de). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00e5 -> B:11:0x0086). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r20) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            int r11 = 1;
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L9;
            if (r10 != 2) goto L8;
            Set r12 = (Set) this.L$5;
            Set r13 = (Set) this.L$4;
            List r14 = (List) this.L$3;
            List r15 = (List) this.L$2;
            List r16 = (List) this.L$1;
            MonotonicFrameClock r17 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(r20);
            Set r18 = r12;
            MonotonicFrameClock r19 = r17;
            Set r21 = r13;
            List r22 = r16;
            List r23 = r14;
            List r24 = r15;
        L23:
            Recomposer.access$discardUnusedValues(this.this$0);
            r11 = 1;
        L12:
            if (Recomposer.access$getShouldKeepRecomposing(this.this$0) == false) goto L26;
            Recomposer r110 = this.this$0;
            this.L$0 = r19;
            this.L$1 = r22;
            this.L$2 = r24;
            this.L$3 = r23;
            this.L$4 = r21;
            this.L$5 = r18;
            this.label = r11;
            if (Recomposer.access$awaitWorkAvailable(r110, this) != r5) goto L16;
            return r5;
        L16:
            List r111 = r22;
            List r112 = r24;
            List r113 = r23;
            Set r114 = r21;
            Set r115 = r18;
        L18:
            if (Recomposer.access$recordComposerModifications(this.this$0) == false) goto L24;
            final Recomposer r25 = this.this$0;
            final List r26 = r111;
            final List r27 = r112;
            final Set r28 = r114;
            final Set r29 = r115;
            final List r116 = r113;
            Function1<Long, Unit> r117 = new AnonymousClass1(r25, r26, r27, r28, r116, r29);
            this.L$0 = r19;
            this.L$1 = r111;
            this.L$2 = r112;
            this.L$3 = r113;
            this.L$4 = r114;
            r18 = r29;
            this.L$5 = r18;
            this.label = 2;
            if (r19.withFrameNanos(r117, this) != r5) goto L22;
            return r5;
        L22:
            r22 = r111;
            r24 = r112;
            r23 = r113;
            r21 = r114;
            goto L23
        L24:
            r18 = r115;
            r22 = r111;
            r24 = r112;
            r23 = r113;
            r21 = r114;
            goto L12
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Set r30 = (Set) this.L$5;
            Set r31 = (Set) this.L$4;
            List r32 = (List) this.L$3;
            List r33 = (List) this.L$2;
            List r34 = (List) this.L$1;
            MonotonicFrameClock r35 = (MonotonicFrameClock) this.L$0;
            ResultKt.throwOnFailure(r20);
            r115 = r30;
            r114 = r31;
            r113 = r32;
            r112 = r33;
            r111 = r34;
            r19 = r35;
            goto L18
        L10:
            ResultKt.throwOnFailure(r20);
            r19 = (MonotonicFrameClock) this.L$0;
            r22 = new ArrayList();
            r24 = new ArrayList();
            r23 = new ArrayList();
            r21 = new LinkedHashSet();
            r18 = new LinkedHashSet();
            goto L12
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, MonotonicFrameClock r10, Continuation<? super Unit> r11) {
            C00612 r12 = new C00612(this.this$0, r11);
            r12.L$0 = r10;
            return r12.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {791, 811, 812}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeConcurrentlyAndApplyChanges$2\n+ 2 Recomposer.kt\nandroidx/compose/runtime/Recomposer\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n*L\n1#1,1502:1\n467#2,3:1503\n470#2,2:1510\n472#2,3:1513\n475#2,5:1517\n33#3,4:1506\n38#3:1512\n70#4:1516\n70#4:1522\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeConcurrentlyAndApplyChanges$2\n*L\n794#1:1503,3\n794#1:1510,2\n794#1:1513,3\n794#1:1517,5\n794#1:1506,4\n794#1:1512\n795#1:1516\n807#1:1522\n*E\n"})
    public static final class C00622 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        public C00622(CoroutineContext r5, Recomposer r10, Continuation<? super C00622> r11) {
            this.$recomposeCoroutineContext = r5;
            this.this$0 = r10;
            super(3, r11);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r5, MonotonicFrameClock r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a3 -> B:12:0x0039). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r21) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L13;
            if (r10 == 1) goto L11;
            if (r10 == 2) goto L10;
            if (r10 != 3) goto L9;
            ResultKt.throwOnFailure(r21);
        L74:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            Job r11 = (Job) this.L$0;
            ResultKt.throwOnFailure(r21);
        L67:
            this.L$0 = null;
            this.label = 3;
            r11.cancel(null);
            Object r12 = r11.join(this);
            if (r12 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L71;
            r12 = Unit.INSTANCE;
        L71:
            if (r12 != r5) goto L74;
            return r5;
        L11:
            Job r13 = (Job) this.L$2;
            ProduceFrameSignal r14 = (ProduceFrameSignal) this.L$1;
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r21);
        L12:
            CoroutineScope r16 = r15;
            Recomposer r17 = this.this$0;
            IdentityArraySet r18 = Recomposer.access$getSnapshotInvalidations$p(r17);
            if (r18.isNotEmpty() == false) goto L31;
            List r19 = Recomposer.access$getKnownCompositions$p(r17);
            int r110 = r19.size();
            int r111 = 0;
        L28:
            if (r111 >= r110) goto L30;
            ((ControlledComposition) r19.get(r111)).recordModificationsOf(r18);
            r111 = r111 + 1;
            goto L28
        L30:
            Recomposer.access$setSnapshotInvalidations$p(r17, new IdentityArraySet());
        L31:
            List r112 = Recomposer.access$getCompositionInvalidations$p(r17);
            int r113 = r112.size();
            int r114 = 0;
        L32:
            if (r114 >= r113) goto L41;
            ControlledComposition r20 = (ControlledComposition) r112.get(r114);
            Object r115 = Recomposer.access$getStateLock$p(r17);
            monitor-enter(r115);
            Recomposer.access$setConcurrentCompositionsOutstanding$p(r17, Recomposer.access$getConcurrentCompositionsOutstanding$p(r17) + 1);     // Catch: Throwable -> L38
            monitor-exit(r115);
            BuildersKt.launch$default(r16, CompositionKt.getRecomposeCoroutineContext(r20), null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(r17, r20, null), 2, null);
            r114 = r114 + 1;
            r112 = r112;
            r113 = r113;
            r17 = r17;
        L38:
            th = move-exception;
            throw th;
        L41:
            Recomposer r116 = r17;
            Recomposer.access$getCompositionInvalidations$p(r116).clear();
            if (Recomposer.access$deriveStateLocked(r116) != null) goto L59;
            Object r22 = Recomposer.access$getStateLock$p(this.this$0);
            Recomposer r23 = this.this$0;
            monitor-enter(r22);
        L49:
            th = move-exception;
            throw th;
        L46:
            if (Recomposer.access$getHasConcurrentFrameWorkLocked(r23) == false) goto L51;
            Continuation<Unit> r24 = r14.requestFrameLocked();     // Catch: Throwable -> L49
        L52:
            monitor-exit(r22);
            if (r24 == null) goto L55;
            Result.Companion r25 = Result.Companion;
            r24.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
        L55:
            r15 = r16;
        L21:
            if (Recomposer.access$getShouldKeepRecomposing(this.this$0) == false) goto L60;
            Recomposer r117 = this.this$0;
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r13;
            this.label = 1;
            if (Recomposer.access$awaitWorkAvailable(r117, this) != r5) goto L12;
            return r5;
        L60:
            Job r26 = j0.g(r15.getCoroutineContext());
            this.L$0 = r13;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            r26.cancel(null);
            Object r27 = r26.join(this);
            if (r27 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L64;
            r27 = Unit.INSTANCE;
        L64:
            if (r27 != r5) goto L66;
            return r5;
        L66:
            r11 = r13;
            goto L67
        L51:
            r24 = null;
            goto L52
        L59:
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
        L13:
            ResultKt.throwOnFailure(r21);
            CoroutineScope r28 = (CoroutineScope) this.L$0;
            MonotonicFrameClock r29 = (MonotonicFrameClock) this.L$1;
            CoroutineContext r30 = this.$recomposeCoroutineContext;
            k1 r118 = Job.Key;
            if (r30.get(r118) != null) goto L16;
            boolean r31 = true;
        L17:
            CoroutineContext r119 = this.$recomposeCoroutineContext;
            if (r31 == false) goto L76;
            c r120 = h0.a(r28.getCoroutineContext().plus(this.$recomposeCoroutineContext).plus(new l1(j0.g(r28.getCoroutineContext()))));
            ProduceFrameSignal r121 = new ProduceFrameSignal();
            r13 = BuildersKt.launch$default(r28, null, null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, r29, r121, null), 3, null);
            r15 = r120;
            r14 = r121;
            goto L21
        L76:
            throw new IllegalArgumentException(("recomposeCoroutineContext may not contain a Job; found " + r119.get(r118)).toString());
        L16:
            r31 = false;
            goto L17
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, MonotonicFrameClock r10, Continuation<? super Unit> r11) {
            C00622 r12 = new C00622(this.$recomposeCoroutineContext, this.this$0, r11);
            r12.L$0 = r5;
            r12.L$1 = r10;
            return r12.invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        _runningRecomposers = i.b(ExtensionsKt.persistentSetOf());
        _hotReloadEnabled = new AtomicReference(Boolean.FALSE);
    }

    public Recomposer(CoroutineContext r5) {
        Intrinsics.checkNotNullParameter(r5, "effectCoroutineContext");
        BroadcastFrameClock r10 = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = r10;
        this.stateLock = new Object();
        this.knownCompositions = new ArrayList();
        this.snapshotInvalidations = new IdentityArraySet();
        this.compositionInvalidations = new ArrayList();
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = i.b(State.Inactive);
        l1 r11 = new l1((Job) r5.get(Job.Key));
        r11.invokeOnCompletion(new Recomposer$effectJob$1$1(this));
        this.effectJob = r11;
        this.effectCoroutineContext = r5.plus(r10).plus(r11);
        this.recomposerInfo = new RecomposerInfoImpl(this);
    }

    public static final /* synthetic */ Object access$awaitWorkAvailable(Recomposer r5, Continuation r10) {
        return r5.awaitWorkAvailable(r10);
    }

    public static final /* synthetic */ j access$deriveStateLocked(Recomposer r5) {
        return r5.deriveStateLocked();
    }

    public static final /* synthetic */ void access$discardUnusedValues(Recomposer r5) {
        r5.discardUnusedValues();
    }

    public static final /* synthetic */ BroadcastFrameClock access$getBroadcastFrameClock$p(Recomposer r5) {
        return r5.broadcastFrameClock;
    }

    public static final /* synthetic */ Throwable access$getCloseCause$p(Recomposer r5) {
        return r5.closeCause;
    }

    public static final /* synthetic */ List access$getCompositionInvalidations$p(Recomposer r5) {
        return r5.compositionInvalidations;
    }

    public static final /* synthetic */ List access$getCompositionValuesAwaitingInsert$p(Recomposer r5) {
        return r5.compositionValuesAwaitingInsert;
    }

    public static final /* synthetic */ List access$getCompositionsAwaitingApply$p(Recomposer r5) {
        return r5.compositionsAwaitingApply;
    }

    public static final /* synthetic */ int access$getConcurrentCompositionsOutstanding$p(Recomposer r5) {
        return r5.concurrentCompositionsOutstanding;
    }

    public static final /* synthetic */ RecomposerErrorState access$getErrorState$p(Recomposer r5) {
        return r5.errorState;
    }

    public static final /* synthetic */ boolean access$getHasBroadcastFrameClockAwaiters(Recomposer r5) {
        return r5.getHasBroadcastFrameClockAwaiters();
    }

    public static final /* synthetic */ boolean access$getHasConcurrentFrameWorkLocked(Recomposer r5) {
        return r5.getHasConcurrentFrameWorkLocked();
    }

    public static final /* synthetic */ boolean access$getHasSchedulingWork(Recomposer r5) {
        return r5.getHasSchedulingWork();
    }

    public static final /* synthetic */ List access$getKnownCompositions$p(Recomposer r5) {
        return r5.knownCompositions;
    }

    public static final /* synthetic */ RecomposerInfoImpl access$getRecomposerInfo$p(Recomposer r5) {
        return r5.recomposerInfo;
    }

    public static final /* synthetic */ Job access$getRunnerJob$p(Recomposer r5) {
        return r5.runnerJob;
    }

    public static final /* synthetic */ boolean access$getShouldKeepRecomposing(Recomposer r5) {
        return r5.getShouldKeepRecomposing();
    }

    public static final /* synthetic */ IdentityArraySet access$getSnapshotInvalidations$p(Recomposer r5) {
        return r5.snapshotInvalidations;
    }

    public static final /* synthetic */ Object access$getStateLock$p(Recomposer r5) {
        return r5.stateLock;
    }

    public static final /* synthetic */ j access$getWorkContinuation$p(Recomposer r5) {
        return r5.workContinuation;
    }

    public static final /* synthetic */ AtomicReference access$get_hotReloadEnabled$cp() {
        return _hotReloadEnabled;
    }

    public static final /* synthetic */ d2 access$get_runningRecomposers$cp() {
        return _runningRecomposers;
    }

    public static final /* synthetic */ d2 access$get_state$p(Recomposer r5) {
        return r5._state;
    }

    public static final /* synthetic */ boolean access$isClosed$p(Recomposer r5) {
        return r5.isClosed;
    }

    public static final /* synthetic */ List access$performInsertValues(Recomposer r5, List r10, IdentityArraySet r11) {
        return r5.performInsertValues(r10, r11);
    }

    public static final /* synthetic */ ControlledComposition access$performRecompose(Recomposer r5, ControlledComposition r10, IdentityArraySet r11) {
        return r5.performRecompose(r10, r11);
    }

    public static final /* synthetic */ Object access$recompositionRunner(Recomposer r5, Function3 r10, Continuation r11) {
        return r5.recompositionRunner(r10, r11);
    }

    public static final /* synthetic */ boolean access$recordComposerModifications(Recomposer r5) {
        return r5.recordComposerModifications();
    }

    public static final /* synthetic */ void access$registerRunnerJob(Recomposer r5, Job r10) {
        r5.registerRunnerJob(r10);
    }

    public static final /* synthetic */ RecomposerErrorState access$resetErrorState(Recomposer r5) {
        return r5.resetErrorState();
    }

    public static final /* synthetic */ void access$retryFailedCompositions(Recomposer r5) {
        r5.retryFailedCompositions();
    }

    public static final /* synthetic */ Object access$runFrameLoop(Recomposer r5, MonotonicFrameClock r10, ProduceFrameSignal r11, Continuation r12) {
        return r5.runFrameLoop(r10, r11, r12);
    }

    public static final /* synthetic */ void access$setChangeCount$p(Recomposer r5, long r10) {
        r5.changeCount = r10;
    }

    public static final /* synthetic */ void access$setCloseCause$p(Recomposer r5, Throwable r10) {
        r5.closeCause = r10;
    }

    public static final /* synthetic */ void access$setCompositionsRemoved$p(Recomposer r5, Set r10) {
        r5.compositionsRemoved = r10;
    }

    public static final /* synthetic */ void access$setConcurrentCompositionsOutstanding$p(Recomposer r5, int r10) {
        r5.concurrentCompositionsOutstanding = r10;
    }

    public static final /* synthetic */ void access$setRunnerJob$p(Recomposer r5, Job r10) {
        r5.runnerJob = r10;
    }

    public static final /* synthetic */ void access$setSnapshotInvalidations$p(Recomposer r5, IdentityArraySet r10) {
        r5.snapshotInvalidations = r10;
    }

    public static final /* synthetic */ void access$setWorkContinuation$p(Recomposer r5, j r10) {
        r5.workContinuation = r10;
    }

    private final void applyAndCheck(MutableSnapshot r5) {
    L8:
        th = move-exception;
        r5.dispose();
        throw th;
    L3:
        if ((r5.apply() instanceof SnapshotApplyResult.Failure) == true) goto L7;
        r5.dispose();
        return;
    L7:
        throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");     // Catch: Throwable -> L8
    }

    private final Object awaitWorkAvailable(Continuation<? super Unit> r5) {
        if (getHasSchedulingWork() == true) goto L26;
        l r10 = new l(1, IntrinsicsKt.intercepted(r5));
        r10.w();
        Object r11 = access$getStateLock$p(this);
        monitor-enter(r11);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (access$getHasSchedulingWork(this) == false) goto L9;
        l r12 = r10;
    L11:
        monitor-exit(r11);
        if (r12 == null) goto L14;
        Result.Companion r13 = Result.Companion;
        r12.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
    L14:
        Object r14 = r10.v();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L18:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r14;
    L21:
        return Unit.INSTANCE;
    L9:
        access$setWorkContinuation$p(this, r10);     // Catch: Throwable -> L22
        r12 = null;
        goto L11
    L26:
        return Unit.INSTANCE;
    }

    private final <T> T composing(ControlledComposition r5, IdentityArraySet<Object> r10, Function0<? extends T> r11) {
        MutableSnapshot r12 = Snapshot.Companion.takeMutableSnapshot(readObserverOf(r5), writeObserverOf(r5, r10));
        Snapshot r13 = r12.makeCurrent();     // Catch: Throwable -> L8
        T r14 = r11.invoke();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L8
        r12.restoreCurrent(r13);     // Catch: Throwable -> L8
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L8
        InlineMarker.finallyStart(1);
        applyAndCheck(r12);
        InlineMarker.finallyEnd(1);
        return r14;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L8
        r12.restoreCurrent(r13);     // Catch: Throwable -> L8
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        applyAndCheck(r12);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final j deriveStateLocked() {
        if (((State) ((q2) this._state).getValue()).compareTo(State.ShuttingDown) > 0) goto L10;
        this.knownCompositions.clear();
        this.snapshotInvalidations = new IdentityArraySet();
        this.compositionInvalidations.clear();
        this.compositionsAwaitingApply.clear();
        this.compositionValuesAwaitingInsert.clear();
        this.failedCompositions = null;
        j r5 = this.workContinuation;
        if (r5 == null) goto L7;
        r5.cancel(null);
    L7:
        this.workContinuation = null;
        this.errorState = null;
        return null;
    L10:
        if (this.errorState == null) goto L13;
        State r10 = State.Inactive;
    L33:
        ((q2) this._state).i(r10);
        if (r10 != State.PendingWork) goto L37;
        j r11 = this.workContinuation;
        this.workContinuation = null;
        return r11;
    L37:
        return null;
    L13:
        if (this.runnerJob != null) goto L19;
        this.snapshotInvalidations = new IdentityArraySet();
        this.compositionInvalidations.clear();
        if (getHasBroadcastFrameClockAwaitersLocked() == false) goto L17;
        r10 = State.InactivePendingWork;
        goto L33
    L17:
        r10 = State.Inactive;
        goto L33
    L19:
        if (this.compositionInvalidations.isEmpty() == true) goto L21;
    L32:
        r10 = State.PendingWork;
        goto L33
    L21:
        if (this.snapshotInvalidations.isNotEmpty() == true) goto L32;
        if (this.compositionsAwaitingApply.isEmpty() == false) goto L32;
        if (this.compositionValuesAwaitingInsert.isEmpty() == false) goto L32;
        if (this.concurrentCompositionsOutstanding > 0) goto L32;
        if (getHasBroadcastFrameClockAwaitersLocked() == true) goto L32;
        r10 = State.Idle;
        goto L33
    }

    private final void discardUnusedValues() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        int r10 = 0;
        if (this.compositionValuesRemoved.isEmpty() == true) goto L12;
        List r11 = CollectionsKt.flatten(this.compositionValuesRemoved.values());     // Catch: Throwable -> L9
        this.compositionValuesRemoved.clear();     // Catch: Throwable -> L9
        List r12 = new ArrayList(r11.size());     // Catch: Throwable -> L9
        int r13 = r11.size();     // Catch: Throwable -> L9
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L11;
        MovableContentStateReference r15 = (MovableContentStateReference) r11.get(r14);     // Catch: Throwable -> L9
        r12.add(TuplesKt.to(r15, this.compositionValueStatesAvailable.get(r15)));     // Catch: Throwable -> L9
        r14 = r14 + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        this.compositionValueStatesAvailable.clear();     // Catch: Throwable -> L9
    L13:
        monitor-exit(r5);
        int r16 = r12.size();
    L15:
        if (r10 >= r16) goto L20;
        Pair r17 = (Pair) r12.get(r10);
        MovableContentStateReference r18 = (MovableContentStateReference) r17.component1();
        MovableContentState r19 = (MovableContentState) r17.component2();
        if (r19 == null) goto L19;
        r18.getComposition$runtime_release().disposeUnusedMovableContent(r19);
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        return;
    L12:
        r12 = CollectionsKt.emptyList();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private final boolean getHasBroadcastFrameClockAwaiters() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        boolean r10 = getHasBroadcastFrameClockAwaitersLocked();     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        if (this.frameClockPaused == false) goto L5;
    L7:
        return false;
    L5:
        if (this.broadcastFrameClock.getHasAwaiters() == false) goto L7;
        return true;
    }

    private final boolean getHasConcurrentFrameWorkLocked() {
        if (this.compositionsAwaitingApply.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (getHasBroadcastFrameClockAwaitersLocked() == true) goto L8;
        return false;
    }

    private final boolean getHasFrameWorkLocked() {
        if (this.compositionInvalidations.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (getHasBroadcastFrameClockAwaitersLocked() == true) goto L8;
        return false;
    }

    private final boolean getHasSchedulingWork() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.snapshotInvalidations.isNotEmpty() == false) goto L7;
    L14:
        boolean r10 = true;
    L15:
        monitor-exit(r5);
        return r10;
    L7:
        if (this.compositionInvalidations.isEmpty() == false) goto L14;
        if (getHasBroadcastFrameClockAwaitersLocked() == true) goto L14;
        r10 = false;
        goto L15
    }

    private final boolean getShouldKeepRecomposing() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        boolean r10 = this.isClosed;     // Catch: Throwable -> L16
        monitor-exit(r5);
        if (r10 == false) goto L14;
        Iterator r11 = ((r1) this.effectJob).getChildren().iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        if (((Job) r11.next()).isActive() == false) goto L9;
    L13:
        return false;
    L14:
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    private final void performInitialMovableContentInserts(ControlledComposition r10) {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        List<MovableContentStateReference> r11 = this.compositionValuesAwaitingInsert;     // Catch: Throwable -> L15
        int r12 = r11.size();     // Catch: Throwable -> L15
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L18;
        if (Intrinsics.areEqual(r11.get(r13).getComposition$runtime_release(), r10) == true) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r5);
        ArrayList r15 = new ArrayList();
        performInitialMovableContentInserts$fillToInsert(r15, this, r10);
    L12:
        if (r15.isEmpty() == true) goto L14;
        performInsertValues(r15, null);
        performInitialMovableContentInserts$fillToInsert(r15, this, r10);
        goto L12
    L14:
        return;
    L18:
        monitor-exit(r5);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> r5, Recomposer r10, ControlledComposition r11) {
        r5.clear();
        Object r12 = r10.stateLock;
        monitor-enter(r12);
        Iterator<MovableContentStateReference> r13 = r10.compositionValuesAwaitingInsert.iterator();     // Catch: Throwable -> L10
    L6:
        if (r13.hasNext() == false) goto L12;
        MovableContentStateReference r14 = r13.next();     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r14.getComposition$runtime_release(), r11) == false) goto L6;
        r5.add(r14);     // Catch: Throwable -> L10
        r13.remove();     // Catch: Throwable -> L10
        goto L6
    L12:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r12);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> r14, IdentityArraySet<Object> r15) {
        HashMap r5 = new HashMap(r14.size());
        int r10 = r14.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        MovableContentStateReference r12 = r14.get(r11);
        ControlledComposition r13 = r12.getComposition$runtime_release();
        Object r16 = r5.get(r13);
        if (r16 != null) goto L7;
        r16 = new ArrayList();
        r5.put(r13, r16);
    L7:
        ((ArrayList) r16).add(r12);
        r11 = r11 + 1;
        goto L3
    L8:
        Iterator r17 = r5.entrySet().iterator();
    L10:
        if (r17.hasNext() == false) goto L36;
        Map.Entry r18 = (Map.Entry) r17.next();
        ControlledComposition r19 = (ControlledComposition) r18.getKey();
        List r20 = (List) r18.getValue();
        ComposerKt.runtimeCheck(!r19.isComposing());
        MutableSnapshot r21 = Snapshot.Companion.takeMutableSnapshot(readObserverOf(r19), writeObserverOf(r19, r15));
        Snapshot r22 = r21.makeCurrent();     // Catch: Throwable -> L25
        Object r23 = this.stateLock;     // Catch: Throwable -> L27
        monitor-enter(r23);     // Catch: Throwable -> L27
        ArrayList r24 = new ArrayList(r20.size());     // Catch: Throwable -> L19
        int r25 = r20.size();     // Catch: Throwable -> L19
        int r26 = 0;
    L16:
        if (r26 >= r25) goto L21;
        MovableContentStateReference r110 = (MovableContentStateReference) r20.get(r26);     // Catch: Throwable -> L19
        r24.add(TuplesKt.to(r110, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, r110.getContent$runtime_release())));     // Catch: Throwable -> L19
        r26 = r26 + 1;
        goto L16
    L21:
        monitor-exit(r23);     // Catch: Throwable -> L27
        r19.insertMovableContent(r24);     // Catch: Throwable -> L27
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r21.restoreCurrent(r22);     // Catch: Throwable -> L25
        applyAndCheck(r21);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r21.restoreCurrent(r22);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        applyAndCheck(r21);
        throw th;
    L36:
        return CollectionsKt.toList(r5.keySet());
    }

    private final ControlledComposition performRecompose(final ControlledComposition r10, final IdentityArraySet<Object> r11) {
        if (r10.isComposing() == false) goto L5;
    L32:
        return null;
    L5:
        if (r10.isDisposed() == true) goto L32;
        Set<ControlledComposition> r5 = this.compositionsRemoved;
        if (r5 != null) goto L9;
    L11:
        MutableSnapshot r12 = Snapshot.Companion.takeMutableSnapshot(readObserverOf(r10), writeObserverOf(r10, r11));
        Snapshot r13 = r12.makeCurrent();     // Catch: Throwable -> L26
        if (r11 != null) goto L33;
    L19:
        boolean r14 = r10.recompose();     // Catch: Throwable -> L17
        r12.restoreCurrent(r13);     // Catch: Throwable -> L26
        applyAndCheck(r12);
        if (r14 == false) goto L25;
        return r10;
    L25:
        return null;
    L17:
        th = move-exception;
        r12.restoreCurrent(r13);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L33:
        if (r11.isNotEmpty() != true) goto L19;
        r10.prepareCompose(new Recomposer$performRecompose$1$1(r11, r10));     // Catch: Throwable -> L17
    L26:
        th = move-exception;
        applyAndCheck(r12);
        throw th;
    L9:
        if (r5.contains(r10) != true) goto L11;
        goto L11
    }

    private final void processCompositionError(Exception r5, ControlledComposition r10, boolean r11) {
        if (_hotReloadEnabled.get().booleanValue() == true) goto L5;
        throw r5;
    L5:
        if ((r5 instanceof ComposeRuntimeError) == true) goto L27;
        Object r12 = this.stateLock;
        monitor-enter(r12);
        ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", r5);     // Catch: Throwable -> L13
        this.compositionsAwaitingApply.clear();     // Catch: Throwable -> L13
        this.compositionInvalidations.clear();     // Catch: Throwable -> L13
        this.snapshotInvalidations = new IdentityArraySet();     // Catch: Throwable -> L13
        this.compositionValuesAwaitingInsert.clear();     // Catch: Throwable -> L13
        this.compositionValuesRemoved.clear();     // Catch: Throwable -> L13
        this.compositionValueStatesAvailable.clear();     // Catch: Throwable -> L13
        this.errorState = new RecomposerErrorState(r11, r5);     // Catch: Throwable -> L13
        if (r10 == null) goto L19;
        List r13 = this.failedCompositions;     // Catch: Throwable -> L13
        if (r13 != null) goto L16;
        r13 = new ArrayList();     // Catch: Throwable -> L13
        this.failedCompositions = r13;     // Catch: Throwable -> L13
    L16:
        if (r13.contains(r10) == true) goto L18;
        r13.add(r10);     // Catch: Throwable -> L13
    L18:
        this.knownCompositions.remove(r10);     // Catch: Throwable -> L13
    L19:
        deriveStateLocked();     // Catch: Throwable -> L13
        monitor-exit(r12);
        return;
    L13:
        th = move-exception;
        throw th;
    L27:
        throw r5;
    }

    public static /* synthetic */ void processCompositionError$default(Recomposer r5, Exception r10, ControlledComposition r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = false;
    L8:
        r5.processCompositionError(r10, r11, r12);
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition r5) {
        return new AnonymousClass1(r5);
    }

    private final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> r5, Continuation<? super Unit> r10) {
        MonotonicFrameClock r11 = MonotonicFrameClockKt.getMonotonicFrameClock(r10.getContext());
        Object r12 = BuildersKt.withContext(this.broadcastFrameClock, new C00582(this, r5, r11, null), r10);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    private final boolean recordComposerModifications() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.snapshotInvalidations.isEmpty() == false) goto L11;
        boolean r10 = getHasFrameWorkLocked();     // Catch: Throwable -> L9
        monitor-exit(r5);
        return r10;
    L11:
        IdentityArraySet<Object> r11 = this.snapshotInvalidations;     // Catch: Throwable -> L9
        this.snapshotInvalidations = new IdentityArraySet();     // Catch: Throwable -> L9
        monitor-exit(r5);
        Object r12 = this.stateLock;
        monitor-enter(r12);
        List r13 = CollectionsKt.toMutableList(this.knownCompositions);     // Catch: Throwable -> L46
        monitor-exit(r12);
        int r14 = r13.size();     // Catch: Throwable -> L22
        int r15 = 0;
    L18:
        if (r15 >= r14) goto L24;
        ((ControlledComposition) r13.get(r15)).recordModificationsOf(r11);     // Catch: Throwable -> L22
        if (((State) ((q2) this._state).getValue()).compareTo(State.ShuttingDown) <= 0) goto L24;
        r15 = r15 + 1;     // Catch: Throwable -> L22
    L24:
        this.snapshotInvalidations = new IdentityArraySet();     // Catch: Throwable -> L22
        Object r16 = this.stateLock;
        monitor-enter(r16);
    L32:
        th = move-exception;
        throw th;
    L28:
        if (deriveStateLocked() != null) goto L35;
        boolean r17 = getHasFrameWorkLocked();     // Catch: Throwable -> L32
        monitor-exit(r16);
        return r17;
    L35:
        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");     // Catch: Throwable -> L32
    L22:
        th = move-exception;
        monitor-enter(this.stateLock);
        this.snapshotInvalidations.addAll(r11);     // Catch: Throwable -> L43
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L43
        throw th;
    L43:
        th = move-exception;
        throw th;
    L46:
        th = move-exception;
        throw th;
    }

    private final void registerRunnerJob(Job r5) {
        Object r10 = this.stateLock;
        monitor-enter(r10);
        Throwable r11 = this.closeCause;     // Catch: Throwable -> L13
        if (r11 == null) goto L7;
        throw r11;     // Catch: Throwable -> L13
    L7:
        if (((State) ((q2) this._state).getValue()).compareTo(State.ShuttingDown) <= 0) goto L18;
        if (this.runnerJob != null) goto L16;
        this.runnerJob = r5;     // Catch: Throwable -> L13
        deriveStateLocked();     // Catch: Throwable -> L13
        monitor-exit(r10);
        return;
    L16:
        throw new IllegalStateException("Recomposer already running");     // Catch: Throwable -> L13
    L18:
        throw new IllegalStateException("Recomposer shut down");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private final RecomposerErrorState resetErrorState() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        RecomposerErrorState r10 = this.errorState;     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        this.errorState = null;     // Catch: Throwable -> L8
        deriveStateLocked();     // Catch: Throwable -> L8
    L10:
        monitor-exit(r5);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    private final void retryFailedCompositions() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        List<ControlledComposition> r10 = this.failedCompositions;     // Catch: Throwable -> L47
        this.failedCompositions = null;     // Catch: Throwable -> L47
        monitor-exit(r5);
        if (r10 != null) goto L54;
        return;
    L54:
    L15:
        th = move-exception;
        if (r10.isEmpty() == false) goto L35;
    L46:
        throw th;
    L35:
        monitor-enter(this.stateLock);
        List<ControlledComposition> r11 = this.failedCompositions;     // Catch: Throwable -> L39
        if (r11 == null) goto L41;
        r11.addAll(r10);     // Catch: Throwable -> L39
        r10 = r11;
    L41:
        this.failedCompositions = r10;     // Catch: Throwable -> L39
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    L9:
        if (r10.isEmpty() == true) goto L18;
        ControlledComposition r13 = (ControlledComposition) CollectionsKt.removeLast(r10);     // Catch: Throwable -> L15
        if ((r13 instanceof CompositionImpl) == false) goto L54;
        r13.invalidateAll();     // Catch: Throwable -> L15
        r13.setContent(((CompositionImpl) r13).getComposable());     // Catch: Throwable -> L15
        if (this.errorState == null) goto L54;
    L18:
        if (r10.isEmpty() == true) goto L31;
        Object r14 = this.stateLock;
        monitor-enter(r14);
        List<ControlledComposition> r15 = this.failedCompositions;     // Catch: Throwable -> L24
        if (r15 == null) goto L26;
        r15.addAll(r10);     // Catch: Throwable -> L24
        r10 = r15;
    L26:
        this.failedCompositions = r10;     // Catch: Throwable -> L24
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r14);
        return;
    L24:
        th = move-exception;
        throw th;
    L31:
        return;
    L47:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009f -> B:13:0x003f). Please report as a decompilation issue!!! */
    private final Object runFrameLoop(MonotonicFrameClock r10, final ProduceFrameSignal r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C00591) == false) goto L7;
        C00591 r5 = (C00591) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L17;
        if (r16 == 1) goto L16;
        if (r16 != 2) goto L15;
        final List r17 = (List) r5.L$4;
        final List r18 = (List) r5.L$3;
        r11 = (ProduceFrameSignal) r5.L$2;
        MonotonicFrameClock r19 = (MonotonicFrameClock) r5.L$1;
        final Recomposer r20 = (Recomposer) r5.L$0;
        ResultKt.throwOnFailure(r14);
    L13:
        List r21 = r18;
        r10 = r19;
        List r22 = r17;
        Recomposer this = r20;
    L18:
        Object r23 = this.stateLock;
        r5.L$0 = this;
        r5.L$1 = r10;
        r5.L$2 = r11;
        r5.L$3 = r21;
        r5.L$4 = r22;
        r5.label = 1;
        if (r11.awaitFrameRequest(r23, r5) != r15) goto L21;
        return r15;
    L21:
        r20 = this;
        r17 = r22;
        r19 = r10;
        r18 = r21;
    L22:
        Function1<Long, j> r24 = new C00602(r20, r18, r17, r11);
        r5.L$0 = r20;
        r5.L$1 = r19;
        r5.L$2 = r11;
        r5.L$3 = r18;
        r5.L$4 = r17;
        r5.label = 2;
        if (r19.withFrameNanos(r24, r5) != r15) goto L13;
        return r15;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r17 = (List) r5.L$4;
        r18 = (List) r5.L$3;
        r11 = (ProduceFrameSignal) r5.L$2;
        r19 = (MonotonicFrameClock) r5.L$1;
        r20 = (Recomposer) r5.L$0;
        ResultKt.throwOnFailure(r14);
        goto L22
    L17:
        ResultKt.throwOnFailure(r14);
        r21 = new ArrayList();
        r22 = new ArrayList();
    L7:
        r5 = new C00591(this, r12);
        goto L8
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition r5, final IdentityArraySet<Object> r10) {
        return new C00631(r5, r10);
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    public final Object awaitIdle(Continuation<? super Unit> r5) {
        Object r10 = new o0(getCurrentState(), new AnonymousClass2(null)).collect(kotlinx.coroutines.flow.internal.t.f18883a, r5);
        if (r10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r10 = Unit.INSTANCE;
    L7:
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r10;
    L10:
        return Unit.INSTANCE;
    }

    public final void cancel() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (((State) ((q2) this._state).getValue()).compareTo(State.Idle) < 0) goto L9;
        d2 r10 = this._state;     // Catch: Throwable -> L7
        q2 r11 = (q2) r10;     // Catch: Throwable -> L7
        r11.i(State.ShuttingDown);     // Catch: Throwable -> L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
        ((r1) this.effectJob).cancel(null);
    }

    public final void close() {
        l1 r5 = (l1) this.effectJob;
        r5.getClass();
        if (r5.N(Unit.INSTANCE) == false) goto L13;
        Object r10 = this.stateLock;
        monitor-enter(r10);
        this.isClosed = true;     // Catch: Throwable -> L10
        monitor-exit(r10);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.CompositionContext
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime_release(ControlledComposition r10, Function2<? super Composer, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "composition");
        Intrinsics.checkNotNullParameter(r11, "content");
        boolean r5 = r10.isComposing();
        Snapshot.Companion r12 = Snapshot.Companion;     // Catch: Exception -> L34
        MutableSnapshot r13 = r12.takeMutableSnapshot(readObserverOf(r10), writeObserverOf(r10, null));     // Catch: Exception -> L34
        Snapshot r14 = r13.makeCurrent();     // Catch: Throwable -> L36
        r10.composeContent(r11);     // Catch: Throwable -> L38
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r13.restoreCurrent(r14);     // Catch: Throwable -> L36
        applyAndCheck(r13);     // Catch: Exception -> L34
        if (r5 == true) goto L10;
        r12.notifyObjectsInitialized();
    L10:
        Object r16 = this.stateLock;
        monitor-enter(r16);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (((State) ((q2) this._state).getValue()).compareTo(State.ShuttingDown) > 0) goto L15;
    L20:
        monitor-exit(r16);
        performInitialMovableContentInserts(r10);     // Catch: Exception -> L29
        r10.applyChanges();     // Catch: Exception -> L26
        r10.applyLateChanges();     // Catch: Exception -> L26
        if (r5 == true) goto L55;
        r12.notifyObjectsInitialized();
        return;
    L55:
        return;
    L26:
        e = move-exception;
        processCompositionError$default(this, e, null, false, 6, null);
        return;
    L29:
        e = move-exception;
        processCompositionError(e, r10, true);
        return;
    L15:
        if (this.knownCompositions.contains(r10) == true) goto L20;
        this.knownCompositions.add(r10);     // Catch: Throwable -> L18
        goto L20
    L38:
        th = move-exception;
        r13.restoreCurrent(r14);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        applyAndCheck(r13);     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    L34:
        e = move-exception;
        processCompositionError(e, r10, true);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(MovableContentStateReference r5) {
        Intrinsics.checkNotNullParameter(r5, "reference");
        Object r10 = this.stateLock;
        monitor-enter(r10);
        RecomposerKt.addMultiValue(this.compositionValuesRemoved, r5.getContent$runtime_release(), r5);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    public final p2 getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasPendingWork() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.snapshotInvalidations.isNotEmpty() == false) goto L7;
    L18:
        boolean r10 = true;
    L19:
        monitor-exit(r5);
        return r10;
    L7:
        if (this.compositionInvalidations.isEmpty() == false) goto L18;
        if (this.concurrentCompositionsOutstanding > 0) goto L18;
        if (this.compositionsAwaitingApply.isEmpty() == false) goto L18;
        if (getHasBroadcastFrameClockAwaitersLocked() == true) goto L18;
        r10 = false;
        goto L19
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final kotlinx.coroutines.flow.g getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference r5) {
        Intrinsics.checkNotNullParameter(r5, "reference");
        Object r10 = this.stateLock;
        monitor-enter(r10);
        this.compositionValuesAwaitingInsert.add(r5);     // Catch: Throwable -> L9
        j r11 = deriveStateLocked();     // Catch: Throwable -> L9
        monitor-exit(r10);
        if (r11 == null) goto L14;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition r5) {
        Intrinsics.checkNotNullParameter(r5, "composition");
        Object r10 = this.stateLock;
        monitor-enter(r10);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.compositionInvalidations.contains(r5) == true) goto L10;
        this.compositionInvalidations.add(r5);     // Catch: Throwable -> L8
        j r11 = deriveStateLocked();     // Catch: Throwable -> L8
    L11:
        monitor-exit(r10);
        if (r11 == null) goto L19;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
        return;
    L19:
        return;
    L10:
        r11 = null;
        goto L11
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(RecomposeScopeImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Object r10 = this.stateLock;
        monitor-enter(r10);
        this.snapshotInvalidations.add(r5);     // Catch: Throwable -> L9
        j r11 = deriveStateLocked();     // Catch: Throwable -> L9
        monitor-exit(r10);
        if (r11 == null) goto L14;
        Result.Companion r12 = Result.Companion;
        r11.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final Object join(Continuation<? super Unit> r5) {
        Object r10 = i.l(getCurrentState(), new C00572(null), r5);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(MovableContentStateReference r5, MovableContentState r10) {
        Intrinsics.checkNotNullParameter(r5, "reference");
        Intrinsics.checkNotNullParameter(r10, "data");
        Object r11 = this.stateLock;
        monitor-enter(r11);
        this.compositionValueStatesAvailable.put(r5, r10);     // Catch: Throwable -> L7
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference r5) {
        Intrinsics.checkNotNullParameter(r5, "reference");
        Object r10 = this.stateLock;
        monitor-enter(r10);
        MovableContentState r11 = this.compositionValueStatesAvailable.remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final void pauseCompositionFrameClock() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
        this.frameClockPaused = true;     // Catch: Throwable -> L8
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> r5) {
        Intrinsics.checkNotNullParameter(r5, "table");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(ControlledComposition r5) {
        Intrinsics.checkNotNullParameter(r5, "composition");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition r5) {
        Intrinsics.checkNotNullParameter(r5, "composition");
        Object r10 = this.stateLock;
        monitor-enter(r10);
        Set r11 = this.compositionsRemoved;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        r11 = new LinkedHashSet();     // Catch: Throwable -> L7
        this.compositionsRemoved = r11;     // Catch: Throwable -> L7
    L9:
        r11.add(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void resumeCompositionFrameClock() {
        Object r5 = this.stateLock;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.frameClockPaused == false) goto L10;
        this.frameClockPaused = false;     // Catch: Throwable -> L8
        j r10 = deriveStateLocked();     // Catch: Throwable -> L8
    L11:
        monitor-exit(r5);
        if (r10 == null) goto L19;
        Result.Companion r11 = Result.Companion;
        r10.resumeWith(Result.m124constructorimpl(Unit.INSTANCE));
        return;
    L19:
        return;
    L10:
        r10 = null;
        goto L11
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> r5) {
        Object r10 = recompositionRunner(new C00612(this, null), r5);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    @ExperimentalComposeApi
    public final Object runRecomposeConcurrentlyAndApplyChanges(CoroutineContext r5, Continuation<? super Unit> r10) {
        Object r11 = recompositionRunner(new C00622(r5, this, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition r5) {
        Intrinsics.checkNotNullParameter(r5, "composition");
        Object r10 = this.stateLock;
        monitor-enter(r10);
        this.knownCompositions.remove(r5);     // Catch: Throwable -> L7
        this.compositionInvalidations.remove(r5);     // Catch: Throwable -> L7
        this.compositionsAwaitingApply.remove(r5);     // Catch: Throwable -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> r10) {
        IdentityArraySet r5 = access$getSnapshotInvalidations$p(this);
        int r11 = 0;
        if (r5.isNotEmpty() == false) goto L8;
        List r12 = access$getKnownCompositions$p(this);
        int r13 = r12.size();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        ((ControlledComposition) r12.get(r14)).recordModificationsOf(r5);
        r14 = r14 + 1;
        goto L5
    L7:
        access$setSnapshotInvalidations$p(this, new IdentityArraySet());
    L8:
        List r15 = access$getCompositionInvalidations$p(this);
        int r16 = r15.size();
    L9:
        if (r11 >= r16) goto L11;
        r10.invoke(r15.get(r11));
        r11 = r11 + 1;
        goto L9
    L11:
        access$getCompositionInvalidations$p(this).clear();
        if (access$deriveStateLocked(this) != null) goto L15;
        return;
    L15:
        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
    }
}
