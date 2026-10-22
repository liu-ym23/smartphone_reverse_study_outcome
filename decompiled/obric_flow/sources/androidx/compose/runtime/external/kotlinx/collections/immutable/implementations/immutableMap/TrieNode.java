package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\b\u0000\u0018\u0000 }*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002}~B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0091\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u0014H\u0000¢\u0006\u0002\b\u001aJ\u009c\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002JO\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0002J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J+\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010/J#\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J+\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00102J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u0005H\u0002J#\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020(2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J\r\u0010:\u001a\u00020\u0005H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\b=J%\u0010>\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010?J\u0015\u0010@\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0002J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FJ[\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u00012\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00028\u00002\u0006\u0010M\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010NJI\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010PJ=\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ8\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010$\u001a\u00020\u000bH\u0002J?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010YJ2\u0010Z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J9\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\\JQ\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010^JK\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JJ\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SJT\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002JM\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JE\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010dJ:\u0010e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J.\u0010f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002JX\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002J8\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010$\u001a\u00020\u000bH\u0002J=\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010mJ!\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u0005H\u0000¢\u0006\u0002\boJ\u0015\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bpJ9\u0010q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010rJ9\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010tJ1\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010uJ&\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J&\u0010w\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002JP\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J8\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J)\u0010z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FR0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "dataMap", "", "nodeMap", "buffer", "", "(II[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "<set-?>", "getBuffer$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "shift", "hash", "accept$runtime_release", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "bufferMoveEntryToNode", "keyIndex", "positionMask", "newKeyHash", "newKey", "newValue", "owner", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "calculateSize", "collisionContainsKey", "", STGroup.DICT_KEY, "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemoveEntryAtIndex", "i", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "elementsIdentityEquals", "otherNode", "entryCount", "entryCount$runtime_release", "entryKeyIndex", "entryKeyIndex$runtime_release", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "hasEntryAt", "hasEntryAt$runtime_release", "hasNodeAt", "insertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "keyAtIndex", "(I)Ljava/lang/Object;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPut", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemoveEntryAtIndex", "mutableInsertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePutAll", "mutablePutAllFromOtherNodeCell", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableRemoveEntryAtIndex", "mutableRemoveNodeAtIndex", "nodeIndex", "mutableReplaceNode", "targetNode", "newNode", "mutableUpdateNodeAtIndex", "mutableUpdateValueAtIndex", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "nodeAtIndex", "nodeAtIndex$runtime_release", "nodeIndex$runtime_release", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "remove", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "removeNodeAtIndex", "replaceNode", "updateNodeAtIndex", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "valueAtKeyIndex", "Companion", "ModificationResult", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTrieNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode\n+ 2 ForEachOneBit.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ForEachOneBitKt\n+ 3 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,887:1\n10#2,9:888\n10#2,9:897\n10#2,9:906\n83#3:915\n1#4:916\n26#5:917\n*S KotlinDebug\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode\n*L\n619#1:888,9\n636#1:897,9\n640#1:906,9\n688#1:915\n688#1:916\n885#1:917\n*E\n"})
public final class TrieNode<K, V> {
    public static final Companion Companion = null;
    private static final TrieNode EMPTY = null;
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.access$getEMPTY$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJD\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0010\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0011H\u0086\bø\u0001\u0000R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTrieNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,887:1\n1#2:888\n*E\n"})
    public static final class ModificationResult<K, V> {
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(TrieNode<K, V> r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "node");
            this.node = r5;
            this.sizeDelta = r10;
        }

        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final ModificationResult<K, V> replaceNode(Function1<? super TrieNode<K, V>, TrieNode<K, V>> r5) {
            Intrinsics.checkNotNullParameter(r5, "operation");
            setNode(r5.invoke(getNode()));
            return this;
        }

        public final void setNode(TrieNode<K, V> r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.node = r5;
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new TrieNode(0, 0, new Object[0]);
    }

    public TrieNode(int r5, int r10, Object[] r11, MutabilityOwnership r12) {
        Intrinsics.checkNotNullParameter(r11, "buffer");
        this.dataMap = r5;
        this.nodeMap = r10;
        this.ownedBy = r12;
        this.buffer = r11;
    }

    private final void accept(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r10, int r11, int r12) {
        r10.invoke(this, Integer.valueOf(r12), Integer.valueOf(r11), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int r5 = this.nodeMap;
    L3:
        if (r5 == 0) goto L5;
        int r13 = Integer.lowestOneBit(r5);
        int r14 = Integer.numberOfTrailingZeros(r13);
        nodeAtIndex$runtime_release(nodeIndex$runtime_release(r13)).accept(r10, (r14 << r12) + r11, r12 + 5);
        r5 = r5 - r13;
        goto L3
    }

    public static final /* synthetic */ TrieNode access$getEMPTY$cp() {
        return EMPTY;
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult(this, 0);
    }

    private final Object[] bufferMoveEntryToNode(int r11, int r12, int r13, K r14, V r15, int r16, MutabilityOwnership r17) {
        K r5 = keyAtIndex(r11);
        if (r5 == null) goto L6;
        int r10 = r5.hashCode();
    L5:
        int r18 = r10;
        TrieNode<K, V> r19 = makeNode(r18, r5, valueAtKeyIndex(r11), r13, r14, r15, r16 + 5, r17);
        int r20 = nodeIndex$runtime_release(r12) + 1;
        return TrieNodeKt.access$replaceEntryWithNode(this.buffer, r11, r20, r19);
    L6:
        r10 = 0;
        goto L5
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) goto L5;
        int r5 = Integer.bitCount(this.dataMap);
        int r10 = r5 * 2;
        int r11 = this.buffer.length;
    L7:
        if (r10 >= r11) goto L9;
        r5 = r5 + nodeAtIndex$runtime_release(r10).calculateSize();
        r10 = r10 + 1;
        goto L7
    L9:
        return r5;
    L5:
        return this.buffer.length / 2;
    }

    private final boolean collisionContainsKey(K r10) {
        IntProgression r5 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r11 = r5.getFirst();
        int r12 = r5.getLast();
        int r13 = r5.getStep();
        if (r13 <= 0) goto L5;
        if (r11 > r12) goto L5;
    L8:
        if (Intrinsics.areEqual(r10, this.buffer[r11]) == true) goto L9;
        if (r11 == r12) goto L13;
        r11 = r11 + r13;
    L13:
        return false;
    L9:
        return true;
    L5:
        if (r13 >= 0) goto L13;
        if (r12 > r11) goto L13;
        goto L13
    }

    private final V collisionGet(K r5) {
        IntProgression r10 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r11 = r10.getFirst();
        int r12 = r10.getLast();
        int r13 = r10.getStep();
        if (r13 <= 0) goto L5;
        if (r11 > r12) goto L5;
    L8:
        if (Intrinsics.areEqual(r5, keyAtIndex(r11)) == true) goto L10;
        if (r11 == r12) goto L19;
        r11 = r11 + r13;
        goto L8
    L19:
        return null;
    L10:
        return valueAtKeyIndex(r11);
    L5:
        if (r13 >= 0) goto L13;
        if (r12 <= r11) goto L8;
        return null;
    L13:
        return null;
    }

    private final ModificationResult<K, V> collisionPut(K r10, V r11) {
        IntProgression r5 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r12 = r5.getFirst();
        int r13 = r5.getLast();
        int r14 = r5.getStep();
        if (r14 <= 0) goto L5;
        if (r12 > r13) goto L5;
    L8:
        if (Intrinsics.areEqual(r10, keyAtIndex(r12)) == true) goto L10;
        if (r12 == r13) goto L18;
        r12 = r12 + r14;
    L18:
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, r10, r11)).asInsertResult();
    L10:
        if (r11 != valueAtKeyIndex(r12)) goto L13;
        return null;
    L13:
        Object[] r15 = this.buffer;
        Object[] r16 = Arrays.copyOf(r15, r15.length);
        r16[r12 + 1] = r11;
        return new TrieNode(0, 0, r16).asUpdateResult();
    L5:
        if (r14 >= 0) goto L18;
        if (r13 > r12) goto L18;
        goto L8
    }

    private final TrieNode<K, V> collisionRemove(K r5) {
        IntProgression r10 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r11 = r10.getFirst();
        int r12 = r10.getLast();
        int r13 = r10.getStep();
        if (r13 <= 0) goto L5;
        if (r11 > r12) goto L5;
    L8:
        if (Intrinsics.areEqual(r5, keyAtIndex(r11)) == true) goto L10;
        if (r11 == r12) goto L13;
        r11 = r11 + r13;
    L13:
        return this;
    L10:
        return collisionRemoveEntryAtIndex(r11);
    L5:
        if (r13 >= 0) goto L13;
        if (r12 > r11) goto L13;
        goto L13
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int r5) {
        Object[] r10 = this.buffer;
        if (r10.length != 2) goto L7;
        return null;
    L7:
        return new TrieNode(0, 0, TrieNodeKt.access$removeEntryAtIndex(r10, r5));
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (this.nodeMap == r10.nodeMap) goto L9;
        return false;
    L9:
        if (this.dataMap == r10.dataMap) goto L11;
        return false;
    L11:
        int r5 = this.buffer.length;
        int r11 = 0;
    L12:
        if (r11 >= r5) goto L17;
        if (this.buffer[r11] != r10.buffer[r11]) goto L15;
        r11 = r11 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    private final boolean hasNodeAt(int r5) {
        if ((this.nodeMap & r5) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final TrieNode<K, V> insertEntryAt(int r5, K r10, V r11) {
        int r12 = entryKeyIndex$runtime_release(r5);
        Object[] r13 = TrieNodeKt.access$insertEntryAtIndex(this.buffer, r12, r10, r11);
        return new TrieNode(r5 | this.dataMap, this.nodeMap, r13);
    }

    private final K keyAtIndex(int r5) {
        return (K) this.buffer[r5];
    }

    private final TrieNode<K, V> makeNode(int r14, K r15, V r16, int r17, K r18, V r19, int r20, MutabilityOwnership r21) {
        if (r20 > 30) goto L5;
        int r11 = TrieNodeKt.indexSegment(r14, r20);
        int r10 = TrieNodeKt.indexSegment(r17, r20);
        if (r11 == r10) goto L15;
        if (r11 >= r10) goto L11;
        Object[] r5 = {r15, r16, r18, r19};
    L13:
        return new TrieNode((1 << r11) | (1 << r10), 0, r5, r21);
    L11:
        r5 = new Object[]{r18, r19, r15, r16};
        goto L13
    L15:
        return new TrieNode(0, 1 << r11, new Object[]{makeNode(r14, r15, r16, r17, r18, r19, r20 + 5, r21)}, r21);
    L5:
        return new TrieNode(0, 0, new Object[]{r15, r16, r18, r19}, r21);
    }

    private final TrieNode<K, V> moveEntryToNode(int r10, int r11, int r12, K r13, V r14, int r15) {
        Object[] r16 = bufferMoveEntryToNode(r10, r11, r12, r13, r14, r15, null);
        return new TrieNode(this.dataMap ^ r11, this.nodeMap | r11, r16);
    }

    private final TrieNode<K, V> mutableCollisionPut(K r10, V r11, PersistentHashMapBuilder<K, V> r12) {
        IntProgression r5 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r13 = r5.getFirst();
        int r14 = r5.getLast();
        int r15 = r5.getStep();
        if (r15 <= 0) goto L5;
        if (r13 > r14) goto L5;
    L8:
        if (Intrinsics.areEqual(r10, keyAtIndex(r13)) == true) goto L9;
        if (r13 == r14) goto L17;
        r13 = r13 + r15;
    L17:
        r12.setSize(r12.size() + 1);
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, r10, r11), r12.getOwnership());
    L9:
        r12.setOperationResult$runtime_release(valueAtKeyIndex(r13));
        if (this.ownedBy != r12.getOwnership()) goto L13;
        this.buffer[r13 + 1] = r11;
        return this;
    L13:
        r12.setModCount$runtime_release(r12.getModCount$runtime_release() + 1);
        Object[] r16 = this.buffer;
        Object[] r17 = Arrays.copyOf(r16, r16.length);
        r17[r13 + 1] = r11;
        return new TrieNode(0, 0, r17, r12.getOwnership());
    L5:
        if (r15 >= 0) goto L17;
        if (r14 > r13) goto L17;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> r11, DeltaCounter r12, MutabilityOwnership r13) {
        if (this.nodeMap != 0) goto L5;
        boolean r5 = true;
    L6:
        CommonFunctionsKt.m42assert(r5);
        if (this.dataMap != 0) goto L9;
        boolean r10 = true;
    L10:
        CommonFunctionsKt.m42assert(r10);
        if (r11.nodeMap != 0) goto L13;
        boolean r14 = true;
    L14:
        CommonFunctionsKt.m42assert(r14);
        if (r11.dataMap != 0) goto L17;
        boolean r15 = true;
    L18:
        CommonFunctionsKt.m42assert(r15);
        Object[] r16 = this.buffer;
        Object[] r17 = Arrays.copyOf(r16, r16.length + r11.buffer.length);
        int r18 = this.buffer.length;
        IntProgression r19 = RangesKt.step(RangesKt.until(0, r11.buffer.length), 2);
        int r20 = r19.getFirst();
        int r21 = r19.getLast();
        int r22 = r19.getStep();
        if (r22 <= 0) goto L21;
        if (r20 > r21) goto L21;
    L24:
        if (collisionContainsKey(r11.buffer[r20]) == true) goto L26;
        Object[] r23 = r11.buffer;
        r17[r18] = r23[r20];
        r17[r18 + 1] = r23[r20 + 1];
        r18 = r18 + 2;
    L27:
        if (r20 == r21) goto L30;
        r20 = r20 + r22;
    L30:
        if (r18 != this.buffer.length) goto L33;
        return this;
    L33:
        if (r18 != r11.buffer.length) goto L36;
        return r11;
    L36:
        if (r18 != r17.length) goto L39;
        return new TrieNode(0, 0, r17, r13);
    L39:
        return new TrieNode(0, 0, Arrays.copyOf(r17, r18), r13);
    L26:
        r12.setCount(r12.getCount() + 1);
    L21:
        if (r22 >= 0) goto L30;
        if (r21 > r20) goto L30;
    L17:
        r15 = false;
        goto L18
    L13:
        r14 = false;
        goto L14
    L9:
        r10 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    private final TrieNode<K, V> mutableCollisionRemove(K r5, PersistentHashMapBuilder<K, V> r10) {
        IntProgression r11 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r12 = r11.getFirst();
        int r13 = r11.getLast();
        int r14 = r11.getStep();
        if (r14 <= 0) goto L5;
        if (r12 > r13) goto L5;
    L8:
        if (Intrinsics.areEqual(r5, keyAtIndex(r12)) == true) goto L10;
        if (r12 == r13) goto L13;
        r12 = r12 + r14;
    L13:
        return this;
    L10:
        return mutableCollisionRemoveEntryAtIndex(r12, r10);
    L5:
        if (r14 >= 0) goto L13;
        if (r13 > r12) goto L13;
        goto L13
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int r5, PersistentHashMapBuilder<K, V> r10) {
        r10.setSize(r10.size() - 1);
        r10.setOperationResult$runtime_release(valueAtKeyIndex(r5));
        if (this.buffer.length != 2) goto L7;
        return null;
    L7:
        if (this.ownedBy != r10.getOwnership()) goto L11;
        this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, r5);
        return this;
    L11:
        return new TrieNode(0, 0, TrieNodeKt.access$removeEntryAtIndex(this.buffer, r5), r10.getOwnership());
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int r5, K r10, V r11, MutabilityOwnership r12) {
        int r13 = entryKeyIndex$runtime_release(r5);
        if (this.ownedBy != r12) goto L6;
        this.buffer = TrieNodeKt.access$insertEntryAtIndex(this.buffer, r13, r10, r11);
        this.dataMap = r5 | this.dataMap;
        return this;
    L6:
        Object[] r14 = TrieNodeKt.access$insertEntryAtIndex(this.buffer, r13, r10, r11);
        return new TrieNode(r5 | this.dataMap, this.nodeMap, r14, r12);
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int r5, int r10, int r11, K r12, V r13, int r14, MutabilityOwnership r15) {
        if (this.ownedBy != r15) goto L7;
        this.buffer = bufferMoveEntryToNode(r5, r10, r11, r12, r13, r14, r15);
        this.dataMap ^= r10;
        this.nodeMap |= r10;
        return this;
    L7:
        return new TrieNode(this.dataMap ^ r10, this.nodeMap | r10, bufferMoveEntryToNode(r5, r10, r11, r12, r13, r14, r15), r15);
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> r14, int r15, int r16, DeltaCounter r17, PersistentHashMapBuilder<K, V> r18) {
        int r5 = 0;
        if (hasNodeAt(r15) == false) goto L16;
        TrieNode<K, V> r10 = nodeAtIndex$runtime_release(nodeIndex$runtime_release(r15));
        if (r14.hasNodeAt(r15) == false) goto L8;
        return r10.mutablePutAll(r14.nodeAtIndex$runtime_release(r14.nodeIndex$runtime_release(r15)), r16 + 5, r17, r18);
    L8:
        if (r14.hasEntryAt$runtime_release(r15) == false) goto L40;
        int r11 = r14.entryKeyIndex$runtime_release(r15);
        K r12 = r14.keyAtIndex(r11);
        V r13 = r14.valueAtKeyIndex(r11);
        int r19 = r18.size();
        if (r12 == null) goto L12;
        r5 = r12.hashCode();
    L12:
        TrieNode<K, V> r20 = r10.mutablePut(r5, r12, r13, r16 + 5, r18);
        if (r18.size() != r19) goto L41;
        r17.setCount(r17.getCount() + 1);
        return r20;
    L41:
        return r20;
    L40:
        return r10;
    L16:
        if (r14.hasNodeAt(r15) == false) goto L31;
        TrieNode<K, V> r21 = r14.nodeAtIndex$runtime_release(r14.nodeIndex$runtime_release(r15));
        if (hasEntryAt$runtime_release(r15) == false) goto L44;
        int r22 = entryKeyIndex$runtime_release(r15);
        K r23 = keyAtIndex(r22);
        if (r23 == null) goto L22;
        int r24 = r23.hashCode();
    L23:
        int r110 = r16 + 5;
        if (r21.containsKey(r24, r23, r110) == false) goto L26;
        r17.setCount(r17.getCount() + 1);
        goto L44
    L26:
        V r111 = valueAtKeyIndex(r22);
        if (r23 == null) goto L43;
        r5 = r23.hashCode();
    L43:
        return r21.mutablePut(r5, r23, r111, r110, r18);
    L22:
        r24 = 0;
    L44:
        return r21;
    L31:
        int r25 = entryKeyIndex$runtime_release(r15);
        K r26 = keyAtIndex(r25);
        V r27 = valueAtKeyIndex(r25);
        int r28 = r14.entryKeyIndex$runtime_release(r15);
        K r29 = r14.keyAtIndex(r28);
        V r30 = r14.valueAtKeyIndex(r28);
        if (r26 == null) goto L34;
        int r31 = r26.hashCode();
    L35:
        if (r29 == null) goto L38;
        r5 = r29.hashCode();
    L38:
        return makeNode(r31, r26, r27, r5, r29, r30, r16 + 5, r18.getOwnership());
    L34:
        r31 = 0;
        goto L35
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int r5, int r10, PersistentHashMapBuilder<K, V> r11) {
        r11.setSize(r11.size() - 1);
        r11.setOperationResult$runtime_release(valueAtKeyIndex(r5));
        if (this.buffer.length != 2) goto L7;
        return null;
    L7:
        if (this.ownedBy != r11.getOwnership()) goto L11;
        this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, r5);
        this.dataMap ^= r10;
        return this;
    L11:
        return new TrieNode(r10 ^ this.dataMap, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(this.buffer, r5), r11.getOwnership());
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int r5, int r10, MutabilityOwnership r11) {
        Object[] r12 = this.buffer;
        if (r12.length != 1) goto L7;
        return null;
    L7:
        if (this.ownedBy != r11) goto L11;
        this.buffer = TrieNodeKt.access$removeNodeAtIndex(r12, r5);
        this.nodeMap ^= r10;
        return this;
    L11:
        return new TrieNode(this.dataMap, this.nodeMap ^ r10, TrieNodeKt.access$removeNodeAtIndex(r12, r5), r11);
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> r5, TrieNode<K, V> r10, int r11, int r12, MutabilityOwnership r13) {
        if (r10 != null) goto L5;
        return mutableRemoveNodeAtIndex(r11, r12, r13);
    L5:
        if (this.ownedBy == r13) goto L8;
        if (r5 != r10) goto L8;
        return this;
    L8:
        return mutableUpdateNodeAtIndex(r11, r10, r13);
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int r5, TrieNode<K, V> r10, MutabilityOwnership r11) {
        Object[] r12 = this.buffer;
        if (r12.length != 1) goto L11;
        if (r10.buffer.length != 2) goto L11;
        if (r10.nodeMap != 0) goto L11;
        r10.dataMap = this.nodeMap;
        return r10;
    L11:
        if (this.ownedBy != r11) goto L14;
        r12[r5] = r10;
        return this;
    L14:
        Object[] r13 = Arrays.copyOf(r12, r12.length);
        r13[r5] = r10;
        return new TrieNode(this.dataMap, this.nodeMap, r13, r11);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int r5, V r10, PersistentHashMapBuilder<K, V> r11) {
        if (this.ownedBy != r11.getOwnership()) goto L6;
        this.buffer[r5 + 1] = r10;
        return this;
    L6:
        r11.setModCount$runtime_release(r11.getModCount$runtime_release() + 1);
        Object[] r12 = this.buffer;
        Object[] r13 = Arrays.copyOf(r12, r12.length);
        r13[r5 + 1] = r10;
        return new TrieNode(this.dataMap, this.nodeMap, r13, r11.getOwnership());
    }

    private final TrieNode<K, V> removeEntryAtIndex(int r5, int r10) {
        Object[] r11 = this.buffer;
        if (r11.length != 2) goto L6;
        return null;
    L6:
        Object[] r12 = TrieNodeKt.access$removeEntryAtIndex(r11, r5);
        return new TrieNode(r10 ^ this.dataMap, this.nodeMap, r12);
    }

    private final TrieNode<K, V> removeNodeAtIndex(int r5, int r10) {
        Object[] r11 = this.buffer;
        if (r11.length != 1) goto L6;
        return null;
    L6:
        Object[] r12 = TrieNodeKt.access$removeNodeAtIndex(r11, r5);
        return new TrieNode(this.dataMap, this.nodeMap ^ r10, r12);
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> r5, TrieNode<K, V> r10, int r11, int r12) {
        if (r10 == null) goto L7;
        if (r5 != r10) goto L6;
        return this;
    L6:
        return updateNodeAtIndex(r11, r12, r10);
    L7:
        return removeNodeAtIndex(r11, r12);
    }

    private final TrieNode<K, V> updateNodeAtIndex(int r5, int r10, TrieNode<K, V> r11) {
        Object[] r12 = r11.buffer;
        if (r12.length == 2) goto L5;
    L12:
        Object[] r13 = this.buffer;
        Object[] r14 = Arrays.copyOf(r13, r13.length);
        r14[r5] = r11;
        return new TrieNode(this.dataMap, this.nodeMap, r14);
    L5:
        if (r11.nodeMap != 0) goto L12;
        if (this.buffer.length != 1) goto L10;
        r11.dataMap = this.nodeMap;
        return r11;
    L10:
        int r15 = entryKeyIndex$runtime_release(r10);
        Object[] r16 = TrieNodeKt.access$replaceNodeWithEntry(this.buffer, r5, r15, r12[0], r12[1]);
        return new TrieNode(this.dataMap ^ r10, this.nodeMap ^ r10, r16);
    }

    private final TrieNode<K, V> updateValueAtIndex(int r5, V r10) {
        Object[] r11 = this.buffer;
        Object[] r12 = Arrays.copyOf(r11, r11.length);
        r12[r5 + 1] = r10;
        return new TrieNode(this.dataMap, this.nodeMap, r12);
    }

    private final V valueAtKeyIndex(int r5) {
        return (V) this.buffer[r5 + 1];
    }

    public final void accept$runtime_release(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        accept(r5, 0, 0);
    }

    public final boolean containsKey(int r5, K r10, int r11) {
        int r12 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasEntryAt$runtime_release(r12) == false) goto L7;
        return Intrinsics.areEqual(r10, keyAtIndex(entryKeyIndex$runtime_release(r12)));
    L7:
        if (hasNodeAt(r12) == false) goto L14;
        TrieNode<K, V> r13 = nodeAtIndex$runtime_release(nodeIndex$runtime_release(r12));
        if (r11 != 30) goto L13;
        return r13.collisionContainsKey(r10);
    L13:
        return r13.containsKey(r5, r10, r11 + 5);
    L14:
        return false;
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime_release(int r5) {
        return Integer.bitCount(this.dataMap & (r5 - 1)) * 2;
    }

    public final V get(int r5, K r10, int r11) {
        int r12 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasEntryAt$runtime_release(r12) == false) goto L10;
        int r13 = entryKeyIndex$runtime_release(r12);
        if (Intrinsics.areEqual(r10, keyAtIndex(r13)) == true) goto L7;
        return null;
    L7:
        return valueAtKeyIndex(r13);
    L10:
        if (hasNodeAt(r12) == false) goto L17;
        TrieNode<K, V> r14 = nodeAtIndex$runtime_release(nodeIndex$runtime_release(r12));
        if (r11 != 30) goto L16;
        return r14.collisionGet(r10);
    L16:
        return r14.get(r5, r10, r11 + 5);
    L17:
        return null;
    }

    public final Object[] getBuffer$runtime_release() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime_release(int r5) {
        if ((this.dataMap & r5) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final TrieNode<K, V> mutablePut(int r11, K r12, V r13, int r14, PersistentHashMapBuilder<K, V> r15) {
        Intrinsics.checkNotNullParameter(r15, "mutator");
        int r5 = 1 << TrieNodeKt.indexSegment(r11, r14);
        if (hasEntryAt$runtime_release(r5) == false) goto L14;
        int r10 = entryKeyIndex$runtime_release(r5);
        if (Intrinsics.areEqual(r12, keyAtIndex(r10)) == false) goto L11;
        r15.setOperationResult$runtime_release(valueAtKeyIndex(r10));
        if (valueAtKeyIndex(r10) != r13) goto L10;
        return this;
    L10:
        return mutableUpdateValueAtIndex(r10, r13, r15);
    L11:
        r15.setSize(r15.size() + 1);
        return mutableMoveEntryToNode(r10, r5, r11, r12, r13, r14, r15.getOwnership());
    L14:
        if (hasNodeAt(r5) == false) goto L23;
        int r16 = nodeIndex$runtime_release(r5);
        TrieNode<K, V> r17 = nodeAtIndex$runtime_release(r16);
        if (r14 != 30) goto L18;
        TrieNode<K, V> r18 = r17.mutableCollisionPut(r12, r13, r15);
    L19:
        if (r17 != r18) goto L22;
        return this;
    L22:
        return mutableUpdateNodeAtIndex(r16, r18, r15.getOwnership());
    L18:
        r18 = r17.mutablePut(r11, r12, r13, r14 + 5, r15);
        goto L19
    L23:
        r15.setSize(r15.size() + 1);
        return mutableInsertEntryAt(r5, r12, r13, r15.getOwnership());
    }

    public final TrieNode<K, V> mutablePutAll(TrieNode<K, V> r20, int r21, DeltaCounter r22, PersistentHashMapBuilder<K, V> r23) {
        Intrinsics.checkNotNullParameter(r20, "otherNode");
        Intrinsics.checkNotNullParameter(r22, "intersectionCounter");
        Intrinsics.checkNotNullParameter(r23, "mutator");
        if (this != r20) goto L7;
        r22.plusAssign(calculateSize());
        return this;
    L7:
        if (r21 > 30) goto L9;
        int r5 = this.nodeMap | r20.nodeMap;
        int r10 = this.dataMap;
        int r11 = r20.dataMap;
        int r12 = (r10 ^ r11) & (~r5);
        int r13 = r10 & r11;
        int r14 = r12;
    L11:
        if (r13 == 0) goto L18;
        int r15 = Integer.lowestOneBit(r13);
        if (Intrinsics.areEqual(keyAtIndex(entryKeyIndex$runtime_release(r15)), r20.keyAtIndex(r20.entryKeyIndex$runtime_release(r15))) == false) goto L15;
        r14 = r14 | r15;
    L16:
        r13 = r13 ^ r15;
        goto L11
    L15:
        r5 = r5 | r15;
        goto L16
    L18:
        if ((r5 & r14) != 0) goto L46;
        if (Intrinsics.areEqual(this.ownedBy, r23.getOwnership()) == true) goto L22;
    L26:
        TrieNode<K, V> r16 = new TrieNode(r14, r5, new Object[Integer.bitCount(r5) + (Integer.bitCount(r14) * 2)]);
    L27:
        int r17 = 0;
        int r18 = r5;
        int r19 = 0;
    L28:
        if (r18 == 0) goto L30;
        int r110 = Integer.lowestOneBit(r18);
        Object[] r24 = r16.buffer;
        r24[(r24.length - 1) - r19] = mutablePutAllFromOtherNodeCell(r20, r110, r21, r22, r23);
        r19 = r19 + 1;
        r18 = r18 ^ r110;
    L30:
        if (r14 == 0) goto L39;
        int r25 = Integer.lowestOneBit(r14);
        int r26 = r17 * 2;
        if (r20.hasEntryAt$runtime_release(r25) == true) goto L34;
        int r27 = entryKeyIndex$runtime_release(r25);
        r16.buffer[r26] = keyAtIndex(r27);
        r16.buffer[r26 + 1] = valueAtKeyIndex(r27);
    L37:
        r17 = r17 + 1;
        r14 = r14 ^ r25;
        goto L30
    L34:
        int r28 = r20.entryKeyIndex$runtime_release(r25);
        r16.buffer[r26] = r20.keyAtIndex(r28);
        r16.buffer[r26 + 1] = r20.valueAtKeyIndex(r28);
        if (hasEntryAt$runtime_release(r25) == false) goto L37;
        r22.setCount(r22.getCount() + 1);
        goto L37
    L39:
        if (elementsIdentityEquals(r16) == false) goto L42;
        return this;
    L42:
        if (r20.elementsIdentityEquals(r16) == true) goto L44;
        return r16;
    L44:
        return r20;
    L22:
        if (this.dataMap != r14) goto L26;
        if (this.nodeMap != r5) goto L26;
        r16 = this;
        goto L27
    L46:
        throw new IllegalStateException("Check failed.");
    L9:
        return mutableCollisionPutAll(r20, r22, r23.getOwnership());
    }

    public final TrieNode<K, V> mutableRemove(int r10, K r11, int r12, PersistentHashMapBuilder<K, V> r13) {
        Intrinsics.checkNotNullParameter(r13, "mutator");
        int r14 = 1 << TrieNodeKt.indexSegment(r10, r12);
        if (hasEntryAt$runtime_release(r14) == false) goto L9;
        int r15 = entryKeyIndex$runtime_release(r14);
        if (Intrinsics.areEqual(r11, keyAtIndex(r15)) == true) goto L7;
        return this;
    L7:
        return mutableRemoveEntryAtIndex(r15, r14, r13);
    L9:
        if (hasNodeAt(r14) == false) goto L18;
        int r5 = nodeIndex$runtime_release(r14);
        TrieNode<K, V> r16 = nodeAtIndex$runtime_release(r5);
        if (r12 != 30) goto L14;
        TrieNode<K, V> r17 = r16.mutableCollisionRemove(r11, r13);
    L13:
        TrieNode<K, V> r18 = r17;
        return mutableReplaceNode(r16, r18, r5, r14, r13.getOwnership());
    L14:
        r17 = r16.mutableRemove(r10, r11, r12 + 5, r13);
        goto L13
    L18:
        return this;
    }

    public final TrieNode<K, V> nodeAtIndex$runtime_release(int r5) {
        Object r10 = this.buffer[r5];
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) r10;
    }

    public final int nodeIndex$runtime_release(int r5) {
        return (this.buffer.length - 1) - Integer.bitCount(this.nodeMap & (r5 - 1));
    }

    public final ModificationResult<K, V> put(int r10, K r11, V r12, int r13) {
        int r5 = 1 << TrieNodeKt.indexSegment(r10, r13);
        if (hasEntryAt$runtime_release(r5) == false) goto L14;
        int r14 = entryKeyIndex$runtime_release(r5);
        if (Intrinsics.areEqual(r11, keyAtIndex(r14)) == false) goto L12;
        if (valueAtKeyIndex(r14) != r12) goto L10;
        return null;
    L10:
        return updateValueAtIndex(r14, r12).asUpdateResult();
    L12:
        return moveEntryToNode(r14, r5, r10, r11, r12, r13).asInsertResult();
    L14:
        if (hasNodeAt(r5) == false) goto L26;
        int r15 = nodeIndex$runtime_release(r5);
        TrieNode<K, V> r16 = nodeAtIndex$runtime_release(r15);
        if (r13 != 30) goto L20;
        ModificationResult<K, V> r17 = r16.collisionPut(r11, r12);
        if (r17 != null) goto L23;
        return null;
    L23:
        r17.setNode(updateNodeAtIndex(r15, r5, r17.getNode()));
        return r17;
    L20:
        r17 = r16.put(r10, r11, r12, r13 + 5);
        if (r17 != null) goto L23;
        return null;
    L26:
        return insertEntryAt(r5, r11, r12).asInsertResult();
    }

    public final TrieNode<K, V> remove(int r5, K r10, int r11) {
        int r12 = 1 << TrieNodeKt.indexSegment(r5, r11);
        if (hasEntryAt$runtime_release(r12) == false) goto L9;
        int r13 = entryKeyIndex$runtime_release(r12);
        if (Intrinsics.areEqual(r10, keyAtIndex(r13)) == true) goto L7;
        return this;
    L7:
        return removeEntryAtIndex(r13, r12);
    L9:
        if (hasNodeAt(r12) == false) goto L17;
        int r14 = nodeIndex$runtime_release(r12);
        TrieNode<K, V> r15 = nodeAtIndex$runtime_release(r14);
        if (r11 != 30) goto L13;
        TrieNode<K, V> r16 = r15.collisionRemove(r10);
    L15:
        return replaceNode(r15, r16, r14, r12);
    L13:
        r16 = r15.remove(r5, r10, r11 + 5);
        goto L15
    L17:
        return this;
    }

    private final TrieNode<K, V> collisionRemove(K r5, V r10) {
        IntProgression r11 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r12 = r11.getFirst();
        int r13 = r11.getLast();
        int r14 = r11.getStep();
        if (r14 <= 0) goto L5;
        if (r12 > r13) goto L5;
    L8:
        if (Intrinsics.areEqual(r5, keyAtIndex(r12)) == true) goto L10;
    L13:
        if (r12 == r13) goto L15;
        r12 = r12 + r14;
    L15:
        return this;
    L10:
        if (Intrinsics.areEqual(r10, valueAtKeyIndex(r12)) == false) goto L13;
        return collisionRemoveEntryAtIndex(r12);
    L5:
        if (r14 >= 0) goto L15;
        if (r13 > r12) goto L15;
        goto L15
    }

    private final TrieNode<K, V> mutableCollisionRemove(K r5, V r10, PersistentHashMapBuilder<K, V> r11) {
        IntProgression r12 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r13 = r12.getFirst();
        int r14 = r12.getLast();
        int r15 = r12.getStep();
        if (r15 <= 0) goto L5;
        if (r13 > r14) goto L5;
    L8:
        if (Intrinsics.areEqual(r5, keyAtIndex(r13)) == true) goto L10;
    L13:
        if (r13 == r14) goto L15;
        r13 = r13 + r15;
    L15:
        return this;
    L10:
        if (Intrinsics.areEqual(r10, valueAtKeyIndex(r13)) == false) goto L13;
        return mutableCollisionRemoveEntryAtIndex(r13, r11);
    L5:
        if (r15 >= 0) goto L15;
        if (r14 > r13) goto L15;
        goto L15
    }

    public TrieNode(int r5, int r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r11, "buffer");
        this(r5, r10, r11, null);
    }

    public final TrieNode<K, V> mutableRemove(int r10, K r11, V r12, int r13, PersistentHashMapBuilder<K, V> r14) {
        Intrinsics.checkNotNullParameter(r14, "mutator");
        int r5 = 1 << TrieNodeKt.indexSegment(r10, r13);
        if (hasEntryAt$runtime_release(r5) == false) goto L11;
        int r15 = entryKeyIndex$runtime_release(r5);
        if (Intrinsics.areEqual(r11, keyAtIndex(r15)) == true) goto L7;
        return this;
    L7:
        if (Intrinsics.areEqual(r12, valueAtKeyIndex(r15)) == true) goto L9;
        return this;
    L9:
        return mutableRemoveEntryAtIndex(r15, r5, r14);
    L11:
        if (hasNodeAt(r5) == false) goto L21;
        int r16 = nodeIndex$runtime_release(r5);
        TrieNode<K, V> r17 = nodeAtIndex$runtime_release(r16);
        if (r13 != 30) goto L16;
        TrieNode<K, V> r18 = r17.mutableCollisionRemove(r11, r12, r14);
    L15:
        TrieNode<K, V> r19 = r18;
        return mutableReplaceNode(r17, r19, r16, r5, r14.getOwnership());
    L16:
        r18 = r17.mutableRemove(r10, r11, r12, r13 + 5, r14);
        goto L15
    L21:
        return this;
    }

    public final TrieNode<K, V> remove(int r5, K r10, V r11, int r12) {
        int r13 = 1 << TrieNodeKt.indexSegment(r5, r12);
        if (hasEntryAt$runtime_release(r13) == false) goto L11;
        int r14 = entryKeyIndex$runtime_release(r13);
        if (Intrinsics.areEqual(r10, keyAtIndex(r14)) == true) goto L7;
        return this;
    L7:
        if (Intrinsics.areEqual(r11, valueAtKeyIndex(r14)) == true) goto L9;
        return this;
    L9:
        return removeEntryAtIndex(r14, r13);
    L11:
        if (hasNodeAt(r13) == false) goto L20;
        int r15 = nodeIndex$runtime_release(r13);
        TrieNode<K, V> r16 = nodeAtIndex$runtime_release(r15);
        if (r12 != 30) goto L15;
        TrieNode<K, V> r17 = r16.collisionRemove(r10, r11);
    L17:
        return replaceNode(r16, r17, r15, r13);
    L15:
        r17 = r16.remove(r5, r10, r11, r12 + 5);
        goto L17
    L20:
        return this;
    }
}
