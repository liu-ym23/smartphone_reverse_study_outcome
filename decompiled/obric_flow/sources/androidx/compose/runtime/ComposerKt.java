package androidx.compose.runtime;

import ai.j0;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0000\u001a(\u0010C\u001a\u0004\u0018\u00010\u00012\b\u0010D\u001a\u0004\u0018\u00010\u00012\b\u0010E\u001a\u0004\u0018\u00010\u00012\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010G\u001a\u00020HH\u0007\u001aP\u0010I\u001a>\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010MH\u0002\u001a\u0010\u0010P\u001a\u00020\u00172\u0006\u0010D\u001a\u00020HH\u0000\u001a\"\u0010P\u001a\u00020\u00172\u0006\u0010D\u001a\u00020H2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00010RH\u0080\bø\u0001\u0000\u001a\u0018\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020U2\u0006\u0010S\u001a\u00020BH\u0007\u001a\u0010\u0010V\u001a\u00020\u00172\u0006\u0010T\u001a\u00020UH\u0007\u001a \u0010W\u001a\u00020\u00172\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010S\u001a\u00020BH\u0007\u001a\b\u0010Y\u001a\u00020\u0017H\u0007\u001a(\u0010Z\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020BH\u0007\u001a\u0018\u0010Z\u001a\u00020\u00172\u0006\u0010X\u001a\u00020\u00072\u0006\u0010]\u001a\u00020BH\u0007\u001a\f\u0010^\u001a\u00020H*\u00020\u0007H\u0002\u001a\f\u0010_\u001a\u00020\u0007*\u00020HH\u0002\u001a6\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a*\u00020U2\u0006\u0010b\u001a\u00020H2\u0011\u0010c\u001a\r\u0012\u0004\u0012\u0002Ha0R¢\u0006\u0002\bdH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010e\u001a\u001c\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010g*\u00020h2\u0006\u0010i\u001a\u00020jH\u0002\u001a\u001c\u0010k\u001a\u00020\u0007*\u00020l2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0002\u001a(\u0010o\u001a\b\u0012\u0004\u0012\u00020q0p*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002\u001a\u001a\u0010t\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u0007H\u0002\u001a\u001a\u0010v\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u0007H\u0002\u001a$\u0010w\u001a\u0004\u0018\u00010q*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002\u001a,\u0010x\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u00072\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010\u0001H\u0002\u001a$\u0010|\u001a\u00020\u0007*\u00020l2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0007H\u0002\u001a[\u0010\u0080\u0001\u001a\u0004\u0018\u0001HM\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010M*4\u0012\u0004\u0012\u0002HK\u0012\n\u0012\b\u0012\u0004\u0012\u0002HM0L0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O2\u0006\u0010X\u001a\u0002HKH\u0002¢\u0006\u0003\u0010\u0081\u0001\u001aa\u0010\u0082\u0001\u001a\u00020H\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010M*4\u0012\u0004\u0012\u0002HK\u0012\n\u0012\b\u0012\u0004\u0012\u0002HM0L0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O2\u0006\u0010X\u001a\u0002HK2\u0006\u0010D\u001a\u0002HMH\u0002¢\u0006\u0003\u0010\u0083\u0001\u001ac\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0000\u0010K\"\u0004\b\u0001\u0010M*4\u0012\u0004\u0012\u0002HK\u0012\n\u0012\b\u0012\u0004\u0012\u0002HM0L0Jj\u001e\u0012\u0004\u0012\u0002HK\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HM0Lj\b\u0012\u0004\u0012\u0002HM`N`O2\u0006\u0010X\u001a\u0002HK2\u0006\u0010D\u001a\u0002HMH\u0002¢\u0006\u0003\u0010\u0085\u0001\u001a\u0015\u0010\u0086\u0001\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u001a\u001d\u0010\u0087\u0001\u001a\u0004\u0018\u00010q*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010u\u001a\u00020\u0007H\u0002\u001a#\u0010\u0088\u0001\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020q0p2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u0007H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"[\u0010\r\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u001a\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0016\u0010\u001d\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0003\"\u000e\u0010\u001f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010 \u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u0005\"\u0016\u0010#\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u0003\"\u001c\u0010%\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u0005\"\u0016\u0010(\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u0003\"\u001c\u0010*\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\u0005\"\u0016\u0010-\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b.\u0010\u0003\"\u001c\u0010/\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010\u0005\"\u0016\u00102\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b3\u0010\u0003\"[\u00104\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"[\u00105\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u00106\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b7\u0010\u0003\"\u000e\u00108\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"[\u00109\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"[\u0010:\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010;\u001a\u00020\u0001*\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>*\u009f\u0001\b\u0000\u0010\u0089\u0001\"K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e2K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "endGroupInstance", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Lkotlin/ParameterName;", "name", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "removeCurrentGroupInstance", "resetSlotsInstance", "reuseKey", "getReuseKey$annotations", "rootKey", "skipToGroupEndInstance", "startRootGroup", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "getKey", "value", OpenPageMethod.ALIGN_LEFT, "right", "isTraceInProgress", "", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", STGroup.DICT_KEY, "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", ExifInterface.GPS_DIRECTION_TRUE, "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "filterToRange", "", "Landroidx/compose/runtime/Invalidation;", "start", "end", "findInsertLocation", "location", "findLocation", "firstInRange", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeLocation", "removeRange", "Change", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n*L\n1#1,4563:1\n4548#1,5:4580\n1#2:4564\n361#3,7:4565\n146#4,8:4572\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n4554#1:4580,5\n4288#1:4565,7\n4402#1:4572,8\n*E\n"})
public final class ComposerKt {
    private static final Object compositionLocalMap = null;
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> endGroupInstance = null;
    private static final int invalidGroupLocation = -2;
    private static final Object invocation = null;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final Object provider = null;
    public static final int providerKey = 201;
    private static final Object providerMaps = null;
    public static final int providerMapsKey = 204;
    private static final Object providerValues = null;
    public static final int providerValuesKey = 203;
    private static final Object reference = null;
    public static final int referenceKey = 206;
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> removeCurrentGroupInstance = null;
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> resetSlotsInstance = null;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> skipToGroupEndInstance = null;
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> startRootGroup = null;

    static {
        removeCurrentGroupInstance = ComposerKt$removeCurrentGroupInstance$1.INSTANCE;
        skipToGroupEndInstance = ComposerKt$skipToGroupEndInstance$1.INSTANCE;
        endGroupInstance = ComposerKt$endGroupInstance$1.INSTANCE;
        startRootGroup = ComposerKt$startRootGroup$1.INSTANCE;
        resetSlotsInstance = ComposerKt$resetSlotsInstance$1.INSTANCE;
        invocation = new OpaqueKey("provider");
        provider = new OpaqueKey("provider");
        compositionLocalMap = new OpaqueKey("compositionLocalMap");
        providerValues = new OpaqueKey("providerValues");
        providerMaps = new OpaqueKey("providers");
        reference = new OpaqueKey("reference");
    }

    public static final /* synthetic */ boolean access$asBool(int r5) {
        return asBool(r5);
    }

    public static final /* synthetic */ int access$asInt(boolean r5) {
        return asInt(r5);
    }

    public static final /* synthetic */ List access$collectNodesFrom(SlotTable r5, Anchor r10) {
        return collectNodesFrom(r5, r10);
    }

    public static final /* synthetic */ List access$filterToRange(List r5, int r10, int r11) {
        return filterToRange(r5, r10, r11);
    }

    public static final /* synthetic */ Invalidation access$firstInRange(List r5, int r10, int r11) {
        return firstInRange(r5, r10, r11);
    }

    public static final /* synthetic */ Function3 access$getEndGroupInstance$p() {
        return endGroupInstance;
    }

    public static final /* synthetic */ Object access$getJoinedKey(KeyInfo r5) {
        return getJoinedKey(r5);
    }

    public static final /* synthetic */ Object access$getKey(Object r5, Object r10, Object r11) {
        return getKey(r5, r10, r11);
    }

    public static final /* synthetic */ Function3 access$getRemoveCurrentGroupInstance$p() {
        return removeCurrentGroupInstance;
    }

    public static final /* synthetic */ Function3 access$getResetSlotsInstance$p() {
        return resetSlotsInstance;
    }

    public static final /* synthetic */ Function3 access$getSkipToGroupEndInstance$p() {
        return skipToGroupEndInstance;
    }

    public static final /* synthetic */ Function3 access$getStartRootGroup$p() {
        return startRootGroup;
    }

    public static final /* synthetic */ void access$insertIfMissing(List r5, int r10, RecomposeScopeImpl r11, Object r12) {
        insertIfMissing(r5, r10, r11, r12);
    }

    public static final /* synthetic */ HashMap access$multiMap() {
        return multiMap();
    }

    public static final /* synthetic */ int access$nearestCommonRootOf(SlotReader r5, int r10, int r11, int r12) {
        return nearestCommonRootOf(r5, r10, r11, r12);
    }

    public static final /* synthetic */ Object access$pop(HashMap r5, Object r10) {
        return pop(r5, r10);
    }

    public static final /* synthetic */ boolean access$put(HashMap r5, Object r10, Object r11) {
        return put(r5, r10, r11);
    }

    public static final /* synthetic */ Invalidation access$removeLocation(List r5, int r10) {
        return removeLocation(r5, r10);
    }

    public static final /* synthetic */ void access$removeRange(List r5, int r10, int r11) {
        removeRange(r5, r10, r11);
    }

    public static final /* synthetic */ void access$setCompositionTracer$p(CompositionTracer r5) {
        compositionTracer = r5;
    }

    private static final boolean asBool(int r5) {
        if (r5 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    private static final int asInt(boolean r5) {
        return r5 ? 1 : 0;
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer r5, boolean r10, Function0<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        T r12 = (T) r5.rememberedValue();
        if (r10 == false) goto L5;
    L6:
        T r13 = r11.invoke();
        r5.updateRememberedValue(r13);
        return r13;
    L5:
        if (r12 == Composer.Companion.getEmpty()) goto L6;
        return r12;
    }

    private static final List<Object> collectNodesFrom(SlotTable r5, Anchor r10) {
        ArrayList r11 = new ArrayList();
        SlotReader r12 = r5.openReader();
        collectNodesFrom$lambda$9$collectFromGroup(r12, r11, r5.anchorIndex(r10));     // Catch: Throwable -> L6
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r12.close();
        return r11;
    L6:
        th = move-exception;
        r12.close();
        throw th;
    }

    private static final void collectNodesFrom$lambda$9$collectFromGroup(SlotReader r5, List<Object> r10, int r11) {
        if (r5.isNode(r11) == false) goto L5;
        r10.add(r5.node(r11));
        return;
    L5:
        int r12 = r11 + 1;
        int r13 = r5.groupSize(r11) + r11;
    L6:
        if (r12 >= r13) goto L10;
        collectNodesFrom$lambda$9$collectFromGroup(r5, r10, r12);
        r12 = r12 + r5.groupSize(r12);
        goto L6
    }

    public static final Void composeRuntimeError(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        throw new ComposeRuntimeError(j0.k("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", r5, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    private static final int distanceFrom(SlotReader r5, int r10, int r11) {
        int r12 = 0;
    L3:
        if (r10 <= 0) goto L6;
        if (r10 == r11) goto L6;
        r10 = r5.parent(r10);
        r12 = r12 + 1;
    L6:
        return r12;
    }

    private static final List<Invalidation> filterToRange(List<Invalidation> r5, int r10, int r11) {
        ArrayList r12 = new ArrayList();
        int r13 = findInsertLocation(r5, r10);
    L4:
        if (r13 >= r5.size()) goto L8;
        Invalidation r14 = r5.get(r13);
        if (r14.getLocation() >= r11) goto L8;
        r12.add(r14);
        r13 = r13 + 1;
    L8:
        return r12;
    }

    private static final int findInsertLocation(List<Invalidation> r5, int r10) {
        int r11 = findLocation(r5, r10);
        if (r11 < 0) goto L5;
        return r11;
    L5:
        return -(r11 + 1);
    }

    private static final int findLocation(List<Invalidation> r5, int r10) {
        int r11 = r5.size() - 1;
        int r12 = 0;
    L3:
        if (r12 > r11) goto L11;
        int r13 = (r12 + r11) >>> 1;
        int r14 = Intrinsics.compare(r5.get(r13).getLocation(), r10);
        if (r14 < 0) goto L6;
        if (r14 <= 0) goto L9;
        r11 = r13 - 1;
        goto L3
    L9:
        return r13;
    L6:
        r12 = r13 + 1;
        goto L3
    L11:
        return -(r12 + 1);
    }

    private static final Invalidation firstInRange(List<Invalidation> r5, int r10, int r11) {
        int r12 = findInsertLocation(r5, r10);
        if (r12 >= r5.size()) goto L7;
        Invalidation r13 = r5.get(r12);
        if (r13.getLocation() >= r11) goto L9;
        return r13;
    L9:
        return null;
    L7:
        return null;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    @PublishedApi
    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static final Object getInvocation() {
        return invocation;
    }

    @PublishedApi
    public static /* synthetic */ void getInvocation$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    private static final Object getJoinedKey(KeyInfo r5) {
        if (r5.getObjectKey() == null) goto L6;
        return new JoinedKey(Integer.valueOf(r5.getKey()), r5.getObjectKey());
    L6:
        return Integer.valueOf(r5.getKey());
    }

    private static final Object getKey(Object r5, Object r10, Object r11) {
        if ((r5 instanceof JoinedKey) == false) goto L5;
        JoinedKey r12 = (JoinedKey) r5;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r12.getLeft(), r10) == true) goto L10;
    L12:
        r5 = getKey(r12.getLeft(), r10, r11);
        if (r5 != null) goto L16;
        r5 = getKey(r12.getRight(), r10, r11);
    L16:
        return r5;
    L10:
        if (Intrinsics.areEqual(r12.getRight(), r11) == false) goto L12;
    L5:
        r12 = null;
        goto L6
    }

    public static final Object getProvider() {
        return provider;
    }

    @PublishedApi
    public static /* synthetic */ void getProvider$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    @PublishedApi
    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    @PublishedApi
    public static /* synthetic */ void getProviderValues$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static final Object getReference() {
        return reference;
    }

    @PublishedApi
    public static /* synthetic */ void getReference$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReuseKey$annotations() {
    }

    private static final void insertIfMissing(List<Invalidation> r5, int r10, RecomposeScopeImpl r11, Object r12) {
        int r13 = findLocation(r5, r10);
        IdentityArraySet r14 = null;
        if (r13 >= 0) goto L8;
        int r15 = -(r13 + 1);
        if (r12 == null) goto L7;
        r14 = new IdentityArraySet();
        r14.add(r12);
    L7:
        r5.add(r15, new Invalidation(r11, r10, r14));
        return;
    L8:
        if (r12 != null) goto L10;
        r5.get(r13).setInstances(null);
        return;
    L10:
        IdentityArraySet<Object> r16 = r5.get(r13).getInstances();
        if (r16 == null) goto L16;
        r16.add(r12);
        return;
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer r5 = compositionTracer;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isTraceInProgress() == false) goto L7;
        return true;
    }

    private static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap();
    }

    private static final int nearestCommonRootOf(SlotReader r5, int r10, int r11, int r12) {
        if (r10 != r11) goto L4;
        return r10;
    L4:
        if (r10 == r12) goto L26;
        if (r11 == r12) goto L26;
        if (r5.parent(r10) != r11) goto L11;
        return r11;
    L11:
        if (r5.parent(r11) != r10) goto L14;
        return r10;
    L14:
        if (r5.parent(r10) == r5.parent(r11)) goto L16;
        int r13 = distanceFrom(r5, r10, r12);
        int r14 = distanceFrom(r5, r11, r12);
        int r15 = r13 - r14;
        int r16 = 0;
        int r17 = 0;
    L18:
        if (r17 >= r15) goto L20;
        r10 = r5.parent(r10);
        r17 = r17 + 1;
        goto L18
    L20:
        int r18 = r14 - r13;
    L21:
        if (r16 >= r18) goto L23;
        r11 = r5.parent(r11);
        r16 = r16 + 1;
    L23:
        if (r10 == r11) goto L25;
        r10 = r5.parent(r10);
        r11 = r5.parent(r11);
        goto L23
    L25:
        return r10;
    L16:
        return r5.parent(r10);
    L26:
        return r12;
    }

    private static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> r5, K r10) {
        LinkedHashSet<V> r11 = r5.get(r10);
        if (r11 == null) goto L7;
        V r12 = (V) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L7;
        remove(r5, r10, r12);
        return r12;
    L7:
        return null;
    }

    private static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> r5, K r10, V r11) {
        LinkedHashSet<V> r12 = r5.get(r10);
        if (r12 != null) goto L6;
        r12 = new LinkedHashSet();
        r5.put(r10, r12);
    L6:
        return r12.add(r11);
    }

    private static final <K, V> Unit remove(HashMap<K, LinkedHashSet<V>> r5, K r10, V r11) {
        LinkedHashSet<V> r12 = r5.get(r10);
        if (r12 == null) goto L8;
        r12.remove(r11);
        if (r12.isEmpty() == false) goto L10;
        r5.remove(r10);
    L10:
        return Unit.INSTANCE;
    L8:
        return null;
    }

    public static final void removeCurrentGroup(SlotWriter r5, RememberManager r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "rememberManager");
        Iterator<Object> r11 = r5.groupSlots();
    L4:
        if (r11.hasNext() == false) goto L14;
        Object r12 = r11.next();
        if ((r12 instanceof ComposeNodeLifecycleCallback) == false) goto L9;
        r10.releasing((ComposeNodeLifecycleCallback) r12);
    L9:
        if ((r12 instanceof RememberObserver) == false) goto L12;
        r10.forgetting((RememberObserver) r12);
    L12:
        if ((r12 instanceof RecomposeScopeImpl) == false) goto L4;
        ((RecomposeScopeImpl) r12).release();
        goto L4
    L14:
        r5.removeGroup();
    }

    private static final Invalidation removeLocation(List<Invalidation> r5, int r10) {
        int r11 = findLocation(r5, r10);
        if (r11 >= 0) goto L7;
        return null;
    L7:
        return r5.remove(r11);
    }

    private static final void removeRange(List<Invalidation> r5, int r10, int r11) {
        int r12 = findInsertLocation(r5, r10);
    L4:
        if (r12 >= r5.size()) goto L8;
        if (r5.get(r12).getLocation() >= r11) goto L11;
        r5.remove(r12);
        goto L4
    L11:
        return;
    }

    public static final void runtimeCheck(boolean r5, Function0<? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "lazyMessage");
        if (r5 == false) goto L5;
        return;
    L5:
        composeRuntimeError(r10.invoke().toString());
        throw new KotlinNothingValueException();
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Intrinsics.checkNotNullParameter(r10, "sourceInformation");
        r5.sourceInformation(r10);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer r5) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        r5.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer r5, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Intrinsics.checkNotNullParameter(r11, "sourceInformation");
        r5.sourceInformationMarkerStart(r10, r11);
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer r5 = compositionTracer;
        if (r5 == null) goto L6;
        r5.traceEventEnd();
        return;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload with $dirty metadata instead", replaceWith = @ReplaceWith(expression = "traceEventStart(key, dirty1, dirty2, info)", imports = {}))
    @ComposeCompilerApi
    public static final /* synthetic */ void traceEventStart(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "info");
        traceEventStart(r5, -1, -1, r10);
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int r5, int r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "info");
        CompositionTracer r13 = compositionTracer;
        if (r13 == null) goto L6;
        r13.traceEventStart(r5, r10, r11, r12);
        return;
    }

    public static final void runtimeCheck(boolean r5) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw j0.z("Check failed");
    }
}
