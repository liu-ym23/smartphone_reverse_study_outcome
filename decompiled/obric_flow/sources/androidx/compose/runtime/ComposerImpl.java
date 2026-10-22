package androidx.compose.runtime;

import ai.j0;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000í\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\b5\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)*\u0001H\b\u0000\u0018\u00002\u00020\u0001:\u0004ð\u0002ñ\u0002Bí\u0001\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012Y\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012Y\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\t\u0010\u0099\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u009a\u0001\u001a\u00020\u0014H\u0002JK\u0010\u009b\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u009c\u0001\"\u0005\b\u0001\u0010\u009d\u00012\b\u0010\u009e\u0001\u001a\u0003H\u009c\u00012\"\u0010\u009f\u0001\u001a\u001d\u0012\u0005\u0012\u0003H\u009d\u0001\u0012\u0005\u0012\u0003H\u009c\u0001\u0012\u0004\u0012\u00020\u00140 \u0001¢\u0006\u0003\b¡\u0001H\u0016¢\u0006\u0003\u0010¢\u0001J\t\u0010£\u0001\u001a\u00020\u0005H\u0016J5\u0010¤\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0000\u0010\u009d\u00012\u0007\u0010¥\u0001\u001a\u00020!2\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¦\u0001H\u0087\bø\u0001\u0000¢\u0006\u0003\u0010§\u0001J\u0014\u0010¨\u0001\u001a\u00020!2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0017J\u0012\u0010¨\u0001\u001a\u00020!2\u0007\u0010\u009e\u0001\u001a\u00020!H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030©\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030ª\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030«\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030¬\u0001H\u0017J\u0012\u0010¨\u0001\u001a\u00020!2\u0007\u0010\u009e\u0001\u001a\u00020%H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030\u00ad\u0001H\u0017J\u0013\u0010¨\u0001\u001a\u00020!2\b\u0010\u009e\u0001\u001a\u00030®\u0001H\u0017J\u0014\u0010¯\u0001\u001a\u00020!2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0017J\u000f\u0010°\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\b±\u0001J\t\u0010²\u0001\u001a\u00020\u0014H\u0002J\t\u0010³\u0001\u001a\u00020\u0014H\u0002J\t\u0010´\u0001\u001a\u00020\u0014H\u0016JG\u0010µ\u0001\u001a\u00020\u00142\u001d\u0010¶\u0001\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010·\u00012\u0014\u0010¹\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u00140¦\u0001¢\u0006\u0003\bº\u0001H\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J$\u0010½\u0001\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010¿\u0001\u001a\u00020%2\u0007\u0010À\u0001\u001a\u00020%H\u0002J(\u0010Á\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0000\u0010\u009d\u00012\u000f\u0010Â\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010Ã\u0001H\u0017¢\u0006\u0003\u0010Ä\u0001J\t\u0010Å\u0001\u001a\u00020\u0014H\u0002J!\u0010Æ\u0001\u001a\u00020\u0014\"\u0005\b\u0000\u0010\u009d\u00012\u000f\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¦\u0001H\u0016J\t\u0010È\u0001\u001a\u00020tH\u0002J\u0012\u0010È\u0001\u001a\u00020t2\u0007\u0010¾\u0001\u001a\u00020%H\u0002J\u0012\u0010É\u0001\u001a\u00020\u00142\u0007\u0010¨\u0001\u001a\u00020!H\u0017J\t\u0010Ê\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ë\u0001\u001a\u00020\u0014H\u0016J\u000f\u0010Ì\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0003\bÍ\u0001JF\u0010Î\u0001\u001a\u00020\u00142\u001d\u0010¶\u0001\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010·\u00012\u0016\u0010¹\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010¦\u0001¢\u0006\u0003\bº\u0001H\u0002¢\u0006\u0003\u0010¼\u0001J\u001b\u0010Ï\u0001\u001a\u00020\u00142\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010Ð\u0001\u001a\u00020%H\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0014H\u0016J\u0012\u0010Ò\u0001\u001a\u00020\u00142\u0007\u0010Ó\u0001\u001a\u00020!H\u0002J\t\u0010Ô\u0001\u001a\u00020\u0014H\u0017J\t\u0010Õ\u0001\u001a\u00020\u0014H\u0002J\t\u0010Ö\u0001\u001a\u00020\u0014H\u0017J\t\u0010×\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ø\u0001\u001a\u00020\u0014H\u0017J\t\u0010Ù\u0001\u001a\u00020\u0014H\u0017J\f\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001H\u0017J\t\u0010Ü\u0001\u001a\u00020\u0014H\u0016J\t\u0010Ý\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010Þ\u0001\u001a\u00020\u00142\u0007\u0010ß\u0001\u001a\u00020%H\u0016J\t\u0010à\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010á\u0001\u001a\u00020\u00142\u0007\u0010Ó\u0001\u001a\u00020!2\t\u0010â\u0001\u001a\u0004\u0018\u00010vH\u0002J\u001a\u0010ã\u0001\u001a\u00020\u00142\u0007\u0010ä\u0001\u001a\u00020%2\u0006\u0010a\u001a\u00020!H\u0002J\t\u0010å\u0001\u001a\u00020\u0014H\u0002J\u000e\u0010O\u001a\u00020!H\u0000¢\u0006\u0003\bæ\u0001J\"\u0010ç\u0001\u001a\u00020\u00142\f\u0010\u009e\u0001\u001a\u0007\u0012\u0002\b\u00030è\u00012\t\u0010é\u0001\u001a\u0004\u0018\u00010LH\u0017J*\u0010ê\u0001\u001a\u00020\u00142\u001f\u0010ë\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030î\u0001\u0012\u0007\u0012\u0005\u0018\u00010î\u00010í\u00010ì\u0001H\u0002J*\u0010ï\u0001\u001a\u00020\u00142\u001f\u0010ë\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030î\u0001\u0012\u0007\u0012\u0005\u0018\u00010î\u00010í\u00010ì\u0001H\u0017J\u0012\u0010ð\u0001\u001a\u00020%2\u0007\u0010ñ\u0001\u001a\u00020%H\u0002J8\u0010ò\u0001\u001a\u00020\u00142\u0010\u0010¹\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010L0è\u00012\u0007\u0010ó\u0001\u001a\u00020t2\t\u0010é\u0001\u001a\u0004\u0018\u00010L2\u0007\u0010ô\u0001\u001a\u00020!H\u0002J\u001f\u0010õ\u0001\u001a\u00020L2\t\u0010ö\u0001\u001a\u0004\u0018\u00010L2\t\u0010÷\u0001\u001a\u0004\u0018\u00010LH\u0017J\u000b\u0010ø\u0001\u001a\u0004\u0018\u00010LH\u0001J-\u0010ù\u0001\u001a\u00020%2\u0007\u0010ú\u0001\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010¿\u0001\u001a\u00020%2\u0007\u0010û\u0001\u001a\u00020%H\u0002J\u000f\u0010ü\u0001\u001a\u00020%H\u0000¢\u0006\u0003\bý\u0001J\u001f\u0010þ\u0001\u001a\u00020\u00142\u000e\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140¦\u0001H\u0000¢\u0006\u0003\bÿ\u0001J\t\u0010\u0080\u0002\u001a\u00020\u0014H\u0002J!\u0010\u0080\u0002\u001a\u00020\u00142\u0010\u0010\u0081\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010L0\u0082\u0002H\u0002¢\u0006\u0003\u0010\u0083\u0002J\t\u0010\u0084\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0085\u0002\u001a\u00020\u00142\t\b\u0002\u0010\u0086\u0002\u001a\u00020!H\u0002J\t\u0010\u0087\u0002\u001a\u00020\u0014H\u0002J.\u0010\u0088\u0002\u001a\u00020!2\u001d\u0010¶\u0001\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010·\u0001H\u0000¢\u0006\u0003\b\u0089\u0002Jv\u0010\u008a\u0002\u001a\u0003H\u008b\u0002\"\u0005\b\u0000\u0010\u008b\u00022\u000b\b\u0002\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010ñ\u0001\u001a\u0004\u0018\u00010%2%\b\u0002\u0010e\u001a\u001f\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020<\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020L\u0018\u00010¸\u00010í\u00010ì\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008b\u00020¦\u0001H\u0002¢\u0006\u0003\u0010\u008e\u0002J\t\u0010\u008f\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0090\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J_\u0010\u0092\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010\u0093\u0002\u001a\u00020\u0014H\u0002J\u0014\u0010\u0094\u0002\u001a\u00020\u00142\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010\u0095\u0002\u001a\u00020\u0014H\u0002J\t\u0010\u0096\u0002\u001a\u00020\u0014H\u0002J_\u0010\u0097\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\u0012\u0010\u0098\u0002\u001a\u00020\u00142\u0007\u0010\u0099\u0002\u001a\u00020YH\u0002J_\u0010\u009a\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J$\u0010\u009b\u0002\u001a\u00020\u00142\u0007\u0010\u008c\u0002\u001a\u00020%2\u0007\u0010\u008d\u0002\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020%H\u0002J\u0012\u0010\u009d\u0002\u001a\u00020\u00142\u0007\u0010\u009e\u0002\u001a\u00020%H\u0002J\u001a\u0010\u009f\u0002\u001a\u00020\u00142\u0006\u0010q\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020%H\u0002J\u0019\u0010 \u0002\u001a\u00020\u00142\u000e\u0010¡\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140¦\u0001H\u0016J\t\u0010¢\u0002\u001a\u00020\u0014H\u0002J_\u0010£\u0002\u001a\u00020\u00142T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002Jj\u0010¤\u0002\u001a\u00020\u00142\t\b\u0002\u0010\u0086\u0002\u001a\u00020!2T\u0010\u0091\u0002\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015H\u0002J\t\u0010¥\u0002\u001a\u00020\u0014H\u0002J$\u0010¦\u0002\u001a\u00020\u00142\u0007\u0010§\u0002\u001a\u00020%2\u0007\u0010¨\u0002\u001a\u00020%2\u0007\u0010©\u0002\u001a\u00020%H\u0002J\u0013\u0010ª\u0002\u001a\u00020\u00142\b\u0010«\u0002\u001a\u00030\u0085\u0001H\u0016J\t\u0010¬\u0002\u001a\u00020\u0014H\u0002J\u001b\u0010\u00ad\u0002\u001a\u00020\u00142\b\u0010®\u0002\u001a\u00030î\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000b\u0010¯\u0002\u001a\u0004\u0018\u00010LH\u0016J\t\u0010°\u0002\u001a\u00020\u0014H\u0002J\u0012\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020%H\u0002J\t\u0010³\u0002\u001a\u00020\u0014H\u0017J\t\u0010´\u0002\u001a\u00020\u0014H\u0002J\t\u0010µ\u0002\u001a\u00020\u0014H\u0002J\t\u0010¶\u0002\u001a\u00020\u0014H\u0017J\u0013\u0010·\u0002\u001a\u00020\u00142\b\u0010·\u0002\u001a\u00030¸\u0002H\u0017J\t\u0010¹\u0002\u001a\u00020\u0014H\u0017J\u001c\u0010º\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\b\u0010·\u0002\u001a\u00030¸\u0002H\u0017JA\u0010»\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010¼\u0002\u001a\u0004\u0018\u00010L2\b\u0010½\u0002\u001a\u00030¾\u00022\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\bÀ\u0002\u0010Á\u0002J\t\u0010Â\u0002\u001a\u00020\u0014H\u0017J\u0012\u0010Ã\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%H\u0002J\u001d\u0010Ã\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010LH\u0002J\u001d\u0010Å\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010LH\u0017J\t\u0010Æ\u0002\u001a\u00020\u0014H\u0016J&\u0010Ç\u0002\u001a\u00020\u00142\u0015\u0010È\u0002\u001a\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030É\u00020\u0082\u0002H\u0017¢\u0006\u0003\u0010Ê\u0002J\u001d\u0010Ë\u0002\u001a\u00020\u00142\u0007\u0010Ó\u0001\u001a\u00020!2\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010Ì\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%H\u0017J\u0012\u0010Í\u0002\u001a\u00020\u00012\u0007\u0010Â\u0001\u001a\u00020%H\u0017J\u001d\u0010Î\u0002\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010LH\u0016J\t\u0010Ï\u0002\u001a\u00020\u0014H\u0016J\t\u0010Ð\u0002\u001a\u00020\u0014H\u0002J#\u0010Ñ\u0002\u001a\u00020!2\u0007\u0010«\u0002\u001a\u00020<2\t\u0010Ò\u0002\u001a\u0004\u0018\u00010LH\u0000¢\u0006\u0003\bÓ\u0002J\u0014\u0010Ô\u0002\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0001J(\u0010Õ\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0002\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010L2\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010×\u0002\u001a\u00020\u00142\u0007\u0010Ø\u0002\u001a\u00020%H\u0002J(\u0010Ù\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0002\u001a\u00020%2\t\u0010Ä\u0002\u001a\u0004\u0018\u00010L2\t\u0010¿\u0002\u001a\u0004\u0018\u00010LH\u0002J\u0012\u0010Ú\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0002\u001a\u00020%H\u0002J\u001b\u0010Û\u0002\u001a\u00020\u00142\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010\u009c\u0002\u001a\u00020%H\u0002J\u001b\u0010Ü\u0002\u001a\u00020\u00142\u0007\u0010¾\u0001\u001a\u00020%2\u0007\u0010Ý\u0002\u001a\u00020%H\u0002J\u001b\u0010Þ\u0002\u001a\u00020t2\u0007\u0010ß\u0002\u001a\u00020t2\u0007\u0010à\u0002\u001a\u00020tH\u0002J\u0014\u0010á\u0002\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0016J\u0014\u0010â\u0002\u001a\u00020\u00142\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010LH\u0001J\u0012\u0010ã\u0002\u001a\u00020%2\u0007\u0010¾\u0001\u001a\u00020%H\u0002J\t\u0010ä\u0002\u001a\u00020\u0014H\u0016J\t\u0010å\u0002\u001a\u00020\u0014H\u0002J\t\u0010æ\u0002\u001a\u00020\u0014H\u0002J\u000f\u0010ç\u0002\u001a\u00020\u0014H\u0000¢\u0006\u0003\bè\u0002J\u0085\u0001\u0010é\u0002\u001a\u0003H\u008b\u0002\"\u0005\b\u0000\u0010\u008b\u00022Z\u0010ê\u0002\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\f2\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008b\u00020¦\u0001H\u0082\b¢\u0006\u0003\u0010ë\u0002J3\u0010ì\u0002\u001a\u0003H\u008b\u0002\"\u0005\b\u0000\u0010\u008b\u00022\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u000f\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H\u008b\u00020¦\u0001H\u0082\b¢\u0006\u0003\u0010í\u0002J\u0017\u0010î\u0002\u001a\u00020%*\u00030\u0083\u00012\u0007\u0010¾\u0001\u001a\u00020%H\u0002J\u0019\u0010ï\u0002\u001a\u0004\u0018\u00010L*\u00030\u0083\u00012\u0007\u0010ñ\u0001\u001a\u00020%H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'Ra\u0010\u000b\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R&\u00101\u001a\u00020%2\u0006\u00100\u001a\u00020%8\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b2\u00103\u001a\u0004\b4\u0010'R\u0014\u00105\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010'R\u0016\u0010;\u001a\u0004\u0018\u00010<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020!8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u00103\u001a\u0004\bA\u0010#Ro\u0010B\u001aW\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u0015\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010IR\u0016\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010S\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\bT\u0010#R\u0014\u0010U\u001a\u00020!8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010#R\u000e\u0010W\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u000e¢\u0006\u0002\n\u0000Ra\u0010Z\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_Ra\u0010`\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150KX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010a\u001a\u00020!2\u0006\u00100\u001a\u00020!8\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\bb\u00103\u001a\u0004\bc\u0010#R\u0014\u0010d\u001a\b\u0012\u0004\u0012\u00020<0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010g\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bh\u0010#R\u001e\u0010i\u001a\u00020!2\u0006\u00100\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010#Ra\u0010\u0016\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\rj\u0002`\u00150\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010m\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010nj\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u0001`oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020t0\u007fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u0088\u0001\u001a\u0004\u0018\u00010L8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u000f\u0010\u008b\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008d\u0001\u001a\u00020!8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\b\u008e\u0001\u00103\u001a\u0005\b\u008f\u0001\u0010#R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0096\u0001\u001a\u0004\u0018\u00010L*\u00030\u0083\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006ò\u0002"}, d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Ljava/util/List;Ljava/util/List;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Ljava/util/List;", "setDeferredChanges$runtime_release", "(Ljava/util/List;)V", "derivedStateObserver", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "downNodes", "Landroidx/compose/runtime/Stack;", "", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "groupNodeCountStack", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "implicitRootStart", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "insertUpFixups", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "invalidations", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nodeExpected", "nodeIndex", "nodeIndexStack", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "pendingUps", "previousCount", "previousMoveFrom", "previousMoveTo", "previousRemove", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "reader", "Landroidx/compose/runtime/SlotReader;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "sourceInformationEnabled", "startedGroup", "startedGroups", "writer", "writerHasAProvider", "writersReaderDelta", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "addRecomposeScope", "apply", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/IdentityArrayMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", STGroup.DICT_KEY, "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", OpenPageMethod.ALIGN_LEFT, "right", "nextSlot", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "realizeDowns", "nodes", "", "([Ljava/lang/Object;)V", "realizeMovement", "realizeOperationLocation", "forParent", "realizeUps", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "record", "change", "recordApplierOperation", "recordDelete", "recordDown", "recordEndGroup", "recordEndRoot", "recordFixup", "recordInsert", "anchor", "recordInsertUpFixup", "recordMoveNode", "count", "recordReaderMoving", "location", "recordRemoveNode", "recordSideEffect", "effect", "recordSlotEditing", "recordSlotEditingOperation", "recordSlotTableOperation", "recordUp", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "registerInsertUpFixup", "releaseMovableGroupAtCurrent", "reference", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProviders", "values", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withChanges", "newChanges", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 SlotTable.kt\nandroidx/compose/runtime/SlotTable\n+ 4 Trace.kt\nandroidx/compose/runtime/TraceKt\n+ 5 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 6 CompositionLocalMap.kt\nandroidx/compose/runtime/CompositionLocalMapKt\n+ 7 Composer.kt\nandroidx/compose/runtime/GroupKind\n+ 8 BitwiseOperators.kt\nandroidx/compose/runtime/BitwiseOperatorsKt\n+ 9 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 10 IdentityArraySet.kt\nandroidx/compose/runtime/collection/IdentityArraySet\n+ 11 IdentityArrayMap.kt\nandroidx/compose/runtime/collection/IdentityArrayMap\n+ 12 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 13 DerivedState.kt\nandroidx/compose/runtime/SnapshotStateKt__DerivedStateKt\n+ 14 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,4563:1\n3187#1,4:4602\n3197#1,6:4622\n3187#1,6:4628\n3204#1,2:4634\n3192#1:4640\n3187#1,6:4727\n1#2:4564\n146#3,8:4565\n146#3,8:4610\n146#3,4:4618\n151#3,3:4636\n162#3,8:4707\n162#3,8:4715\n146#3,4:4723\n151#3,3:4733\n46#4,5:4573\n46#4,3:4673\n50#4:4679\n4548#5,5:4578\n4548#5,5:4583\n4548#5,5:4592\n4548#5,5:4597\n4548#5,5:4653\n4548#5,5:4658\n4548#5,5:4663\n4548#5,5:4668\n4548#5,5:4692\n4548#5,5:4697\n4548#5,5:4702\n4548#5,5:4736\n4548#5,5:4741\n4548#5,5:4746\n4548#5,5:4751\n73#6:4588\n4478#7:4589\n4479#7:4590\n26#8:4591\n26#8:4756\n22#8:4757\n33#9,4:4606\n38#9:4639\n33#9,4:4641\n38#9:4652\n82#9,3:4758\n33#9,4:4761\n85#9,2:4765\n38#9:4767\n87#9:4768\n108#10,7:4645\n153#11,3:4676\n157#11:4680\n1002#12,2:4681\n1855#12,2:4769\n377#13,6:4683\n383#13,2:4690\n48#14:4689\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl\n*L\n3032#1:4602,4\n3141#1:4622,6\n3147#1:4628,6\n3141#1:4634,2\n3032#1:4640\n3804#1:4727,6\n1292#1:4565,8\n3060#1:4610,8\n3140#1:4618,4\n3140#1:4636,3\n3716#1:4707,8\n3783#1:4715,8\n3802#1:4723,4\n3802#1:4733,3\n1535#1:4573,5\n3314#1:4673,3\n3314#1:4679\n1604#1:4578,5\n1631#1:4583,5\n2753#1:4592,5\n2766#1:4597,5\n3272#1:4653,5\n3277#1:4658,5\n3293#1:4663,5\n3313#1:4668,5\n3372#1:4692,5\n3379#1:4697,5\n3516#1:4702,5\n3851#1:4736,5\n3867#1:4741,5\n3868#1:4746,5\n3896#1:4751,5\n1979#1:4588\n2128#1:4589\n2152#1:4590\n2676#1:4591\n4096#1:4756\n4112#1:4757\n3034#1:4606,4\n3034#1:4639\n3223#1:4641,4\n3223#1:4652\n3616#1:4758,3\n3616#1:4761,4\n3616#1:4765,2\n3616#1:4767\n3616#1:4768\n3225#1:4645,7\n3317#1:4676,3\n3317#1:4680\n3321#1:4681,2\n3652#1:4769,2\n3337#1:4683,6\n3337#1:4690,2\n3337#1:4689\n*E\n"})
public final class ComposerImpl implements Composer {
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    private int childrenComposing;
    private final ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges;
    private final ComposerImpl$derivedStateObserver$1 derivedStateObserver;
    private Stack<Object> downNodes;
    private final IntStack entersStack;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private IntStack groupNodeCountStack;
    private boolean implicitRootStart;
    private Anchor insertAnchor;
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertFixups;
    private SlotTable insertTable;
    private final Stack<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> insertUpFixups;
    private boolean inserting;
    private final Stack<RecomposeScopeImpl> invalidateStack;
    private final List<Invalidation> invalidations;
    private boolean isComposing;
    private boolean isDisposed;
    private List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    private int[] nodeCountOverrides;
    private HashMap<Integer, Integer> nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private IntStack nodeIndexStack;
    private final CompositionContext parentContext;
    private PersistentCompositionLocalMap parentProvider;
    private Pending pending;
    private final Stack<Pending> pendingStack;
    private int pendingUps;
    private int previousCount;
    private int previousMoveFrom;
    private int previousMoveTo;
    private int previousRemove;
    private PersistentCompositionLocalMap providerCache;
    private final IntMap<PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack;
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup;
    private final SlotTable slotTable;
    private boolean sourceInformationEnabled;
    private boolean startedGroup;
    private final IntStack startedGroups;
    private SlotWriter writer;
    private boolean writerHasAProvider;
    private int writersReaderDelta;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CompositionContextHolder implements RememberObserver {
        private final CompositionContextImpl ref;

        public CompositionContextHolder(CompositionContextImpl r5) {
            Intrinsics.checkNotNullParameter(r5, "ref");
            this.ref = r5;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void onRemembered() {
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J*\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020'0+¢\u0006\u0002\b,H\u0010¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020'J\r\u00104\u001a\u00020'H\u0010¢\u0006\u0002\b5J\r\u0010\u0011\u001a\u00020\u000fH\u0010¢\u0006\u0002\b6J\u0015\u00107\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\b:J\u0015\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0010¢\u0006\u0002\b>J\u001d\u0010?\u001a\u00020'2\u0006\u00100\u001a\u0002012\u0006\u0010@\u001a\u00020AH\u0010¢\u0006\u0002\bBJ\u0017\u0010C\u001a\u0004\u0018\u00010A2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\bDJ\u001b\u0010E\u001a\u00020'2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001e0\nH\u0010¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020JH\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\bOJ\r\u0010P\u001a\u00020'H\u0010¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020'2\u0006\u0010I\u001a\u00020JH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0010¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020'2\u0006\u0010<\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\n\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001a8PX\u0090\u0004¢\u0006\f\u0012\u0004\b#\u0010$\u001a\u0004\b%\u0010\u001c¨\u0006W"}, d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "(Landroidx/compose/runtime/ComposerImpl;IZ)V", "getCollectingParameterInformation$runtime_release", "()Z", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nComposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl$CompositionContextImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,4563:1\n1855#2,2:4564\n81#3:4566\n107#3,2:4567\n*S KotlinDebug\n*F\n+ 1 Composer.kt\nandroidx/compose/runtime/ComposerImpl$CompositionContextImpl\n*L\n3982#1:4564,2\n4032#1:4566\n4032#1:4567,2\n*E\n"})
    public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final Set<ComposerImpl> composers;
        private final MutableState compositionLocalScope$delegate;
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;
        final /* synthetic */ ComposerImpl this$0;

        public CompositionContextImpl(ComposerImpl r5, int r10, boolean r11) {
            this.this$0 = r5;
            this.compoundHashKey = r10;
            this.collectingParameterInformation = r11;
            this.composers = new LinkedHashSet();
            this.compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf$default(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), null, 2, null);
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return (PersistentCompositionLocalMap) this.compositionLocalScope$delegate.getValue();
        }

        public static /* synthetic */ void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap r5) {
            this.compositionLocalScope$delegate.setValue(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        @ComposableInferredTarget(scheme = "[0[0]]")
        public void composeInitial$runtime_release(ControlledComposition r5, Function2<? super Composer, ? super Integer, Unit> r10) {
            Intrinsics.checkNotNullParameter(r5, "composition");
            Intrinsics.checkNotNullParameter(r10, "content");
            ComposerImpl.access$getParentContext$p(this.this$0).composeInitial$runtime_release(r5, r10);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime_release(MovableContentStateReference r5) {
            Intrinsics.checkNotNullParameter(r5, "reference");
            ComposerImpl.access$getParentContext$p(this.this$0).deletedMovableContent$runtime_release(r5);
        }

        public final void dispose() {
            if (this.composers.isEmpty() == true) goto L17;
            Set<Set<CompositionData>> r5 = this.inspectionTables;
            if (r5 == null) goto L13;
            Iterator<ComposerImpl> r10 = this.composers.iterator();
        L8:
            if (r10.hasNext() == false) goto L13;
            ComposerImpl r11 = r10.next();
            Iterator<Set<CompositionData>> r12 = r5.iterator();
        L11:
            if (r12.hasNext() == false) goto L8;
            r12.next().remove(ComposerImpl.access$getSlotTable$p(r11));
        L13:
            this.composers.clear();
            return;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            ComposerImpl r5 = this.this$0;
            ComposerImpl.access$setChildrenComposing$p(r5, ComposerImpl.access$getChildrenComposing$p(r5) - 1);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        public final Set<ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.access$getParentContext$p(this.this$0).getEffectCoroutineContext();
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(this.this$0.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(MovableContentStateReference r5) {
            Intrinsics.checkNotNullParameter(r5, "reference");
            ComposerImpl.access$getParentContext$p(this.this$0).insertMovableContent$runtime_release(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(ControlledComposition r5) {
            Intrinsics.checkNotNullParameter(r5, "composition");
            ComposerImpl.access$getParentContext$p(this.this$0).invalidate$runtime_release(this.this$0.getComposition());
            ComposerImpl.access$getParentContext$p(this.this$0).invalidate$runtime_release(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime_release(RecomposeScopeImpl r5) {
            Intrinsics.checkNotNullParameter(r5, "scope");
            ComposerImpl.access$getParentContext$p(this.this$0).invalidateScope$runtime_release(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime_release(MovableContentStateReference r5, MovableContentState r10) {
            Intrinsics.checkNotNullParameter(r5, "reference");
            Intrinsics.checkNotNullParameter(r10, "data");
            ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateReleased$runtime_release(r5, r10);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference r5) {
            Intrinsics.checkNotNullParameter(r5, "reference");
            return ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateResolve$runtime_release(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void recordInspectionTable$runtime_release(Set<CompositionData> r5) {
            Intrinsics.checkNotNullParameter(r5, "table");
            Set r10 = this.inspectionTables;
            if (r10 != null) goto L5;
            r10 = new HashSet();
            this.inspectionTables = r10;
        L5:
            r10.add(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(Composer r5) {
            Intrinsics.checkNotNullParameter(r5, "composer");
            super.registerComposer$runtime_release((ComposerImpl) r5);
            this.composers.add(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime_release(ControlledComposition r5) {
            Intrinsics.checkNotNullParameter(r5, "composition");
            ComposerImpl.access$getParentContext$p(this.this$0).registerComposition$runtime_release(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime_release(ControlledComposition r5) {
            Intrinsics.checkNotNullParameter(r5, "composition");
            ComposerImpl.access$getParentContext$p(this.this$0).reportRemovedComposition$runtime_release(r5);
        }

        public final void setInspectionTables(Set<Set<CompositionData>> r5) {
            this.inspectionTables = r5;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            ComposerImpl r5 = this.this$0;
            ComposerImpl.access$setChildrenComposing$p(r5, ComposerImpl.access$getChildrenComposing$p(r5) + 1);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(Composer r5) {
            Intrinsics.checkNotNullParameter(r5, "composer");
            Set<Set<CompositionData>> r10 = this.inspectionTables;
            if (r10 == null) goto L8;
            Iterator<T> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            ((Set) r11.next()).remove(ComposerImpl.access$getSlotTable$p((ComposerImpl) r5));
        L8:
            TypeIntrinsics.asMutableCollection(this.composers).remove(r5);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(ControlledComposition r5) {
            Intrinsics.checkNotNullParameter(r5, "composition");
            ComposerImpl.access$getParentContext$p(this.this$0).unregisterComposition$runtime_release(r5);
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap r5) {
            Intrinsics.checkNotNullParameter(r5, "scope");
            setCompositionLocalScope(r5);
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(Applier<?> r5, CompositionContext r10, SlotTable r11, Set<RememberObserver> r12, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r13, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r14, ControlledComposition r15) {
        Intrinsics.checkNotNullParameter(r5, "applier");
        Intrinsics.checkNotNullParameter(r10, "parentContext");
        Intrinsics.checkNotNullParameter(r11, "slotTable");
        Intrinsics.checkNotNullParameter(r12, "abandonSet");
        Intrinsics.checkNotNullParameter(r13, "changes");
        Intrinsics.checkNotNullParameter(r14, "lateChanges");
        Intrinsics.checkNotNullParameter(r15, "composition");
        this.applier = r5;
        this.parentContext = r10;
        this.slotTable = r11;
        this.abandonSet = r12;
        this.changes = r13;
        this.lateChanges = r14;
        this.composition = r15;
        this.pendingStack = new Stack();
        this.nodeIndexStack = new IntStack();
        this.groupNodeCountStack = new IntStack();
        this.invalidations = new ArrayList();
        this.entersStack = new IntStack();
        this.parentProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        this.providerUpdates = new IntMap(0, 1, null);
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        this.sourceInformationEnabled = true;
        this.derivedStateObserver = new ComposerImpl$derivedStateObserver$1(this);
        this.invalidateStack = new Stack();
        SlotReader r16 = r11.openReader();
        r16.close();
        this.reader = r16;
        SlotTable r17 = new SlotTable();
        this.insertTable = r17;
        SlotWriter r18 = r17.openWriter();
        r18.close();
        this.writer = r18;
        SlotReader r19 = this.insertTable.openReader();
        Anchor r20 = r19.anchor(0);     // Catch: Throwable -> L6
        r19.close();
        this.insertAnchor = r20;
        this.insertFixups = new ArrayList();
        this.downNodes = new Stack();
        this.implicitRootStart = true;
        this.startedGroups = new IntStack();
        this.insertUpFixups = new Stack();
        this.previousRemove = -1;
        this.previousMoveFrom = -1;
        this.previousMoveTo = -1;
        return;
    L6:
        th = move-exception;
        r19.close();
        throw th;
    }

    private final void abortRoot() {
        cleanUpCompose();
        this.pendingStack.clear();
        this.nodeIndexStack.clear();
        this.groupNodeCountStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates.clear();
        if (this.reader.getClosed() == true) goto L6;
        this.reader.close();
    L6:
        if (this.writer.getClosed() == true) goto L8;
        this.writer.close();
    L8:
        this.insertFixups.clear();
        createFreshInsertTable();
        this.compoundKeyHash = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
    }

    public static final /* synthetic */ List access$getChanges$p(ComposerImpl r5) {
        return r5.changes;
    }

    public static final /* synthetic */ int access$getChildrenComposing$p(ComposerImpl r5) {
        return r5.childrenComposing;
    }

    public static final /* synthetic */ int[] access$getNodeCountOverrides$p(ComposerImpl r5) {
        return r5.nodeCountOverrides;
    }

    public static final /* synthetic */ CompositionContext access$getParentContext$p(ComposerImpl r5) {
        return r5.parentContext;
    }

    public static final /* synthetic */ SlotReader access$getReader$p(ComposerImpl r5) {
        return r5.reader;
    }

    public static final /* synthetic */ SlotTable access$getSlotTable$p(ComposerImpl r5) {
        return r5.slotTable;
    }

    public static final /* synthetic */ int access$insertMovableContentGuarded$positionToInsert(SlotWriter r5, Anchor r10, Applier r11) {
        return insertMovableContentGuarded$positionToInsert(r5, r10, r11);
    }

    public static final /* synthetic */ void access$insertMovableContentGuarded$positionToParentOf(SlotWriter r5, Applier r10, int r11) {
        insertMovableContentGuarded$positionToParentOf(r5, r10, r11);
    }

    public static final /* synthetic */ void access$invokeMovableContentLambda(ComposerImpl r5, MovableContent r10, PersistentCompositionLocalMap r11, Object r12, boolean r13) {
        r5.invokeMovableContentLambda(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$releaseMovableGroupAtCurrent(ComposerImpl r5, MovableContentStateReference r10, SlotWriter r11) {
        r5.releaseMovableGroupAtCurrent(r10, r11);
    }

    public static final /* synthetic */ void access$setChanges$p(ComposerImpl r5, List r10) {
        r5.changes = r10;
    }

    public static final /* synthetic */ void access$setChildrenComposing$p(ComposerImpl r5, int r10) {
        r5.childrenComposing = r10;
    }

    public static final /* synthetic */ void access$setNodeCountOverrides$p(ComposerImpl r5, int[] r10) {
        r5.nodeCountOverrides = r10;
    }

    public static final /* synthetic */ void access$setReader$p(ComposerImpl r5, SlotReader r10) {
        r5.reader = r10;
    }

    private final void addRecomposeScope() {
        if (getInserting() == false) goto L5;
        ControlledComposition r5 = getComposition();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        RecomposeScopeImpl r10 = new RecomposeScopeImpl((CompositionImpl) r5);
        this.invalidateStack.push(r10);
        updateValue(r10);
        r10.start(this.compositionToken);
        return;
    L5:
        Invalidation r11 = ComposerKt.access$removeLocation(this.invalidations, this.reader.getParent());
        Object r12 = this.reader.next();
        if (Intrinsics.areEqual(r12, Composer.Companion.getEmpty()) == false) goto L8;
        ControlledComposition r13 = getComposition();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        RecomposeScopeImpl r14 = new RecomposeScopeImpl((CompositionImpl) r13);
        updateValue(r14);
    L9:
        if (r11 == null) goto L11;
        boolean r15 = true;
    L12:
        r14.setRequiresRecompose(r15);
        this.invalidateStack.push(r14);
        r14.start(this.compositionToken);
        return;
    L11:
        r15 = false;
        goto L12
    L8:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
        r14 = (RecomposeScopeImpl) r12;
        goto L9
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.writersReaderDelta = 0;
        this.compoundKeyHash = 0;
        this.nodeExpected = false;
        this.startedGroup = false;
        this.startedGroups.clear();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    private final int compoundKeyOf(int r5, int r10, int r11) {
        if (r5 == r10) goto L10;
        int r12 = groupCompoundKeyPart(this.reader, r5);
        if (r12 != 126665345) goto L8;
        return r12;
    L8:
        return Integer.rotateLeft(compoundKeyOf(this.reader.parent(r5), r10, r11), 3) ^ r12;
    L10:
        return r11;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        SlotTable r5 = new SlotTable();
        this.insertTable = r5;
        SlotWriter r10 = r5.openWriter();
        r10.close();
        this.writer = r10;
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap r5 = this.providerCache;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return currentCompositionLocalScope(this.reader.getParent());
    }

    private final void doCompose(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r11, Function2<? super Composer, ? super Integer, Unit> r12) {
        if (this.isComposing == true) goto L51;
        Object r5 = Trace.INSTANCE.beginSection("Compose:recompose");
        this.compositionToken = SnapshotKt.currentSnapshot().getId();     // Catch: Throwable -> L11
        this.providerUpdates.clear();     // Catch: Throwable -> L11
        int r10 = r11.getSize();     // Catch: Throwable -> L11
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L15;
        Object r14 = r11.getKeys()[r13];     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");     // Catch: Throwable -> L11
        IdentityArraySet r15 = (IdentityArraySet) r11.getValues()[r13];     // Catch: Throwable -> L11
        RecomposeScopeImpl r16 = (RecomposeScopeImpl) r14;     // Catch: Throwable -> L11
        Anchor r17 = r16.getAnchor();     // Catch: Throwable -> L11
        if (r17 == null) goto L13;
        this.invalidations.add(new Invalidation(r16, r17.getLocation$runtime_release(), r15));     // Catch: Throwable -> L11
        r13 = r13 + 1;
        goto L6
    L13:
        Trace.INSTANCE.endSection(r5);
        return;
    L15:
        List<Invalidation> r18 = this.invalidations;     // Catch: Throwable -> L11
        if (r18.size() <= 1) goto L18;
        CollectionsKt.sortWith(r18, new ComposerImpl$doCompose$lambda$38$$inlined$sortBy$1());     // Catch: Throwable -> L11
    L18:
        this.nodeIndex = 0;     // Catch: Throwable -> L11
        this.isComposing = true;     // Catch: Throwable -> L11
        startRoot();     // Catch: Throwable -> L23
        Object r19 = nextSlot();     // Catch: Throwable -> L23
        if (r19 == r12) goto L25;
        if (r12 == null) goto L25;
        Function2<? super Composer, ? super Integer, Unit> r20 = r12;     // Catch: Throwable -> L23
        updateValue(r12);     // Catch: Throwable -> L23
    L25:
        ComposerImpl$derivedStateObserver$1 r21 = this.derivedStateObserver;     // Catch: Throwable -> L23
        MutableVector<DerivedStateObserver> r22 = SnapshotStateKt.derivedStateObservers();     // Catch: Throwable -> L23
        r22.add(r21);     // Catch: Throwable -> L29
        if (r12 == null) goto L32;
        startGroup(200, ComposerKt.getInvocation());     // Catch: Throwable -> L29
        ActualJvm_jvmKt.invokeComposable(this, r12);     // Catch: Throwable -> L29
        endGroup();     // Catch: Throwable -> L29
    L40:
        r22.removeAt(r22.getSize() - 1);     // Catch: Throwable -> L23
        endRoot();     // Catch: Throwable -> L23
        this.isComposing = false;     // Catch: Throwable -> L11
        this.invalidations.clear();     // Catch: Throwable -> L11
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L11
        Trace.INSTANCE.endSection(r5);
        return;
    L32:
        if (this.forciblyRecompose == false) goto L34;
    L35:
        if (r19 != null) goto L37;
    L39:
        skipCurrentGroup();     // Catch: Throwable -> L29
        goto L40
    L37:
        if (Intrinsics.areEqual(r19, Composer.Companion.getEmpty()) == true) goto L39;
        startGroup(200, ComposerKt.getInvocation());     // Catch: Throwable -> L29
        ActualJvm_jvmKt.invokeComposable(this, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r19, 2));     // Catch: Throwable -> L29
        endGroup();     // Catch: Throwable -> L29
        goto L40
    L34:
        if (this.providersInvalid == false) goto L39;
    L29:
        th = move-exception;
        r22.removeAt(r22.getSize() - 1);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.isComposing = false;     // Catch: Throwable -> L11
        this.invalidations.clear();     // Catch: Throwable -> L11
        abortRoot();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Trace.INSTANCE.endSection(r5);
        throw th;
    L51:
        throw j0.z("Reentrant composition is not supported");
    }

    private final void doRecordDownsFor(int r5, int r10) {
        if (r5 <= 0) goto L8;
        if (r5 == r10) goto L9;
        doRecordDownsFor(this.reader.parent(r5), r10);
        if (this.reader.isNode(r5) == false) goto L10;
        recordDown(nodeAt(this.reader, r5));
        return;
    L10:
        return;
    L9:
        return;
    }

    private final void end(boolean r19) {
        if (getInserting() == false) goto L5;
        int r5 = this.writer.getParent();
        updateCompoundKeyWhenWeExitGroup(this.writer.groupKey(r5), this.writer.groupObjectKey(r5), this.writer.groupAux(r5));
    L6:
        int r10 = this.groupNodeCount;
        Pending r11 = this.pending;
        int r12 = 0;
        if (r11 != null) goto L9;
    L32:
        int r13 = this.nodeIndex;
    L34:
        if (this.reader.isGroupEnd() == true) goto L36;
        int r14 = this.reader.getCurrentGroup();
        recordDelete();
        recordRemoveNode(r13, this.reader.skipGroup());
        ComposerKt.access$removeRange(this.invalidations, r14, this.reader.getCurrentGroup());
        goto L34
    L36:
        boolean r15 = getInserting();
        if (r15 == false) goto L45;
        if (r19 == false) goto L40;
        registerInsertUpFixup();
        r10 = 1;
    L40:
        this.reader.endEmpty();
        int r16 = this.writer.getParent();
        this.writer.endGroup();
        if (this.reader.getInEmpty() == true) goto L53;
        int r17 = insertedGroupVirtualIndex(r16);
        this.writer.endInsert();
        this.writer.close();
        recordInsert(this.insertAnchor);
        this.inserting = false;
        if (this.slotTable.isEmpty() == true) goto L53;
        updateNodeCount(r17, 0);
        updateNodeCountOverrides(r17, r10);
    L53:
        exitGroup(r10, r15);
        return;
    L45:
        if (r19 == false) goto L47;
        recordUp();
    L47:
        recordEndGroup();
        int r18 = this.reader.getParent();
        if (r10 == updatedNodeCount(r18)) goto L50;
        updateNodeCountOverrides(r18, r10);
    L50:
        if (r19 == false) goto L52;
        r10 = 1;
    L52:
        this.reader.endGroup();
        realizeMovement();
        goto L53
    L9:
        if (r11.getKeyInfos().size() <= 0) goto L32;
        List<KeyInfo> r20 = r11.getKeyInfos();
        List<KeyInfo> r21 = r11.getUsed();
        Set r22 = ListUtilsKt.fastToSet(r21);
        LinkedHashSet r23 = new LinkedHashSet();
        int r24 = r21.size();
        int r25 = r20.size();
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
    L11:
        if (r110 >= r25) goto L29;
        KeyInfo r113 = r20.get(r110);
        if (r22.contains(r113) == true) goto L18;
        recordRemoveNode(r11.nodePositionOf(r113) + r11.getStartIndex(), r113.getNodes());
        r11.updateNodeCount(r113.getLocation(), r12);
        recordReaderMoving(r113.getLocation());
        this.reader.reposition(r113.getLocation());
        recordDelete();
        this.reader.skipGroup();
        ComposerKt.access$removeRange(this.invalidations, r113.getLocation(), this.reader.groupSize(r113.getLocation()) + r113.getLocation());
    L15:
        r110 = r110 + 1;
    L16:
        r12 = 0;
        goto L11
    L18:
        if (r23.contains(r113) == true) goto L15;
        if (r111 >= r24) goto L16;
        KeyInfo r26 = r21.get(r111);
        if (r26 == r113) goto L27;
        int r114 = r11.nodePositionOf(r26);
        r23.add(r26);
        if (r114 == r112) goto L28;
        int r115 = r11.updatedNodeCountOf(r26);
        recordMoveNode(r11.getStartIndex() + r114, r112 + r11.getStartIndex(), r115);
        r11.registerMoveNode(r114, r112, r115);
    L28:
        r111 = r111 + 1;
        r112 = r112 + r11.updatedNodeCountOf(r26);
        r21 = r21;
        goto L16
    L27:
        r110 = r110 + 1;
        goto L28
    L29:
        realizeMovement();
        if (r20.size() <= 0) goto L32;
        recordReaderMoving(this.reader.getGroupEnd());
        this.reader.skipToGroupEnd();
        goto L32
    L5:
        int r27 = this.reader.getParent();
        updateCompoundKeyWhenWeExitGroup(this.reader.groupKey(r27), this.reader.groupObjectKey(r27), this.reader.groupAux(r27));
        goto L6
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        recordEndRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
    }

    private final void ensureWriter() {
        if (this.writer.getClosed() == false) goto L6;
        SlotWriter r5 = this.insertTable.openWriter();
        this.writer = r5;
        r5.skipToGroupEnd();
        this.writerHasAProvider = false;
        this.providerCache = null;
        return;
    }

    private final void enterGroup(boolean r5, Pending r10) {
        this.pendingStack.push(this.pending);
        this.pending = r10;
        this.nodeIndexStack.push(this.nodeIndex);
        if (r5 == false) goto L5;
        this.nodeIndex = 0;
    L5:
        this.groupNodeCountStack.push(this.groupNodeCount);
        this.groupNodeCount = 0;
    }

    private final void exitGroup(int r5, boolean r10) {
        Pending r11 = this.pendingStack.pop();
        if (r11 == null) goto L6;
        if (r10 == true) goto L6;
        r11.setGroupIndex(r11.getGroupIndex() + 1);
    L6:
        this.pending = r11;
        this.nodeIndex = this.nodeIndexStack.pop() + r5;
        this.groupNodeCount = this.groupNodeCountStack.pop() + r5;
    }

    private final void finalizeCompose() {
        realizeUps();
        if (this.pendingStack.isEmpty() == false) goto L11;
        if (this.startedGroups.isEmpty() == false) goto L9;
        cleanUpCompose();
        return;
    L9:
        throw j0.z("Missed recording an endGroup()");
    L11:
        throw j0.z("Start/end imbalance");
    }

    @InternalComposeApi
    public static /* synthetic */ void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getInserting$annotations() {
    }

    private final Object getNode(SlotReader r5) {
        return r5.node(r5.getParent());
    }

    @ComposeCompilerApi
    public static /* synthetic */ void getSkipping$annotations() {
    }

    private final int groupCompoundKeyPart(SlotReader r5, int r10) {
        if (r5.hasObjectKey(r10) == false) goto L14;
        Object r11 = r5.groupObjectKey(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        if ((r11 instanceof Enum) == false) goto L10;
        return ((Enum) r11).ordinal();
    L10:
        if ((r11 instanceof MovableContent) == false) goto L25;
        return MovableContentKt.movableContentKey;
    L25:
        return r11.hashCode();
    L14:
        int r12 = r5.groupKey(r10);
        if (r12 != 207) goto L27;
        Object r13 = r5.groupAux(r10);
        if (r13 != null) goto L19;
        return r12;
    L19:
        if (Intrinsics.areEqual(r13, Composer.Companion.getEmpty()) == false) goto L22;
        return r12;
    L22:
        return r13.hashCode();
    L27:
        return r12;
    }

    private final void insertMovableContentGuarded(List<Pair<MovableContentStateReference, MovableContentStateReference>> r20) {
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r5 = this.lateChanges;
        List r10 = access$getChanges$p(this);
        access$setChanges$p(this, r5);     // Catch: Throwable -> L10
        record(ComposerKt.access$getResetSlotsInstance$p());     // Catch: Throwable -> L10
        int r11 = r20.size();     // Catch: Throwable -> L10
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r11) goto L66;
        Pair<MovableContentStateReference, MovableContentStateReference> r14 = r20.get(r13);     // Catch: Throwable -> L10
        final MovableContentStateReference r15 = r14.component1();     // Catch: Throwable -> L10
        final MovableContentStateReference r16 = r14.component2();     // Catch: Throwable -> L10
        final Anchor r17 = r15.getAnchor$runtime_release();     // Catch: Throwable -> L10
        int r18 = r15.getSlotTable$runtime_release().anchorIndex(r17);     // Catch: Throwable -> L10
        final Ref.IntRef r19 = new Ref.IntRef();     // Catch: Throwable -> L10
        realizeUps();     // Catch: Throwable -> L10
        record(new ComposerImpl$insertMovableContentGuarded$1$1$1(r19, r17));     // Catch: Throwable -> L10
        if (r16 == null) goto L8;
        final MovableContentState r21 = this.parentContext.movableContentStateResolve$runtime_release(r16);     // Catch: Throwable -> L10
        if (r21 == null) goto L26;
        SlotTable r22 = r21.getSlotTable$runtime_release();     // Catch: Throwable -> L10
        if (r22 == null) goto L26;
    L27:
        if (r21 == null) goto L32;
        SlotTable r23 = r21.getSlotTable$runtime_release();     // Catch: Throwable -> L10
        if (r23 == null) goto L32;
        Anchor r24 = r23.anchor(r12);     // Catch: Throwable -> L10
        if (r24 == null) goto L32;
    L33:
        final List r25 = ComposerKt.access$collectNodesFrom(r22, r24);     // Catch: Throwable -> L10
        if (r25.isEmpty() == true) goto L38;
        record(new ComposerImpl$insertMovableContentGuarded$1$1$3(r19, r25));     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r15.getSlotTable$runtime_release(), this.slotTable) == false) goto L38;
        int r26 = this.slotTable.anchorIndex(r17);     // Catch: Throwable -> L10
        updateNodeCount(r26, updatedNodeCount(r26) + r25.size());     // Catch: Throwable -> L10
    L38:
        record(new ComposerImpl$insertMovableContentGuarded$1$1$4(r21, this, r16, r15));     // Catch: Throwable -> L10
        SlotReader r27 = r22.openReader();     // Catch: Throwable -> L10
        SlotReader r28 = access$getReader$p(this);     // Catch: Throwable -> L54
        int[] r110 = access$getNodeCountOverrides$p(this);     // Catch: Throwable -> L54
        access$setNodeCountOverrides$p(this, null);     // Catch: Throwable -> L54
        access$setReader$p(this, r27);     // Catch: Throwable -> L48
        int r29 = r22.anchorIndex(r24);     // Catch: Throwable -> L48
        r27.reposition(r29);     // Catch: Throwable -> L48
        this.writersReaderDelta = r29;     // Catch: Throwable -> L48
        final ArrayList r30 = new ArrayList();     // Catch: Throwable -> L48
        List r31 = access$getChanges$p(this);     // Catch: Throwable -> L48
        access$setChanges$p(this, r30);     // Catch: Throwable -> L58
        List r111 = r31;
        recomposeMovableContent(r16.getComposition$runtime_release(), r15.getComposition$runtime_release(), Integer.valueOf(r27.getCurrentGroup()), r16.getInvalidations$runtime_release(), new ComposerImpl$insertMovableContentGuarded$1$1$5$1$1$1(this, r15));     // Catch: Throwable -> L56
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L56
        access$setChanges$p(this, r111);     // Catch: Throwable -> L48
        if (r30.isEmpty() == true) goto L50;
        record(new ComposerImpl$insertMovableContentGuarded$1$1$5$1$2(r19, r30));     // Catch: Throwable -> L48
    L50:
        access$setReader$p(this, r28);     // Catch: Throwable -> L54
        access$setNodeCountOverrides$p(this, r110);     // Catch: Throwable -> L54
        r27.close();     // Catch: Throwable -> L10
    L52:
        record(ComposerKt.access$getSkipToGroupEndInstance$p());     // Catch: Throwable -> L10
        r13 = r13 + 1;
        r12 = 0;
    L56:
        th = th;
    L60:
        access$setChanges$p(this, r111);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L58:
        th = th;
        r111 = r31;
    L48:
        th = move-exception;
        access$setReader$p(this, r28);     // Catch: Throwable -> L54
        access$setNodeCountOverrides$p(this, r110);     // Catch: Throwable -> L54
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r27.close();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L32:
        r24 = r16.getAnchor$runtime_release();     // Catch: Throwable -> L10
    L26:
        r22 = r16.getSlotTable$runtime_release();     // Catch: Throwable -> L10
        goto L27
    L8:
        if (Intrinsics.areEqual(r15.getSlotTable$runtime_release(), this.insertTable) == false) goto L12;
        createFreshInsertTable();     // Catch: Throwable -> L10
    L12:
        final SlotReader r112 = r15.getSlotTable$runtime_release().openReader();     // Catch: Throwable -> L10
        r112.reposition(r18);     // Catch: Throwable -> L16
        this.writersReaderDelta = r18;     // Catch: Throwable -> L16
        final ArrayList r33 = new ArrayList();     // Catch: Throwable -> L16
        recomposeMovableContent$default(this, null, null, null, null, new ComposerImpl$insertMovableContentGuarded$1$1$2$1(this, r33, r112, r15), 15, null);     // Catch: Throwable -> L16
        if (r33.isEmpty() == true) goto L18;
        record(new ComposerImpl$insertMovableContentGuarded$1$1$2$2(r19, r33));     // Catch: Throwable -> L16
    L18:
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r112.close();     // Catch: Throwable -> L10
        goto L52
    L16:
        th = move-exception;
        r112.close();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L66:
        record(ComposerImpl$insertMovableContentGuarded$1$2.INSTANCE);     // Catch: Throwable -> L10
        this.writersReaderDelta = 0;     // Catch: Throwable -> L10
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L10
        access$setChanges$p(this, r10);
        return;
    L10:
        th = move-exception;
        access$setChanges$p(this, r10);
        throw th;
    }

    private static final int insertMovableContentGuarded$currentNodeIndex(SlotWriter r10) {
        int r5 = r10.getCurrentGroup();
        int r11 = r10.getParent();
    L3:
        if (r11 < 0) goto L7;
        if (r10.isNode(r11) == true) goto L7;
        r11 = r10.parent(r11);
    L7:
        int r12 = r11 + 1;
        int r13 = 0;
    L8:
        if (r12 >= r5) goto L20;
        if (r10.indexInGroup(r5, r12) == true) goto L12;
        if (r10.isNode(r12) == false) goto L18;
        int r14 = 1;
    L19:
        r13 = r13 + r14;
        r12 = r12 + r10.groupSize(r12);
        goto L8
    L18:
        r14 = r10.nodeCount(r12);
        goto L19
    L12:
        if (r10.isNode(r12) == false) goto L14;
        r13 = 0;
    L14:
        r12 = r12 + 1;
        goto L8
    L20:
        return r13;
    }

    private static final int insertMovableContentGuarded$positionToInsert(SlotWriter r5, Anchor r10, Applier<Object> r11) {
        int r12 = r5.anchorIndex(r10);
        boolean r13 = true;
        if (r5.getCurrentGroup() >= r12) goto L5;
        boolean r14 = true;
    L6:
        ComposerKt.runtimeCheck(r14);
        insertMovableContentGuarded$positionToParentOf(r5, r11, r12);
        int r15 = insertMovableContentGuarded$currentNodeIndex(r5);
    L8:
        if (r5.getCurrentGroup() >= r12) goto L17;
        if (r5.indexInCurrentGroup(r12) == true) goto L12;
        r15 = r15 + r5.skipGroup();
        goto L8
    L12:
        if (r5.isNode() == false) goto L14;
        r11.down(r5.node(r5.getCurrentGroup()));
        r15 = 0;
    L14:
        r5.startGroup();
        goto L8
    L17:
        if (r5.getCurrentGroup() == r12) goto L20;
        r13 = false;
    L20:
        ComposerKt.runtimeCheck(r13);
        return r15;
    L5:
        r14 = false;
        goto L6
    }

    private static final void insertMovableContentGuarded$positionToParentOf(SlotWriter r5, Applier<Object> r10, int r11) {
    L3:
        if (r5.indexInParent(r11) == true) goto L8;
        r5.skipToGroupEnd();
        if (r5.isNode(r5.getParent()) == false) goto L7;
        r10.up();
    L7:
        r5.endGroup();
        goto L3
    }

    private final int insertedGroupVirtualIndex(int r5) {
        return (-2) - r5;
    }

    private final void invokeMovableContentLambda(final MovableContent<Object> r11, PersistentCompositionLocalMap r12, final Object r13, boolean r14) {
        startMovableGroup(MovableContentKt.movableContentKey, r11);
        changed(r13);
        int r5 = getCompoundKeyHash();
        this.compoundKeyHash = MovableContentKt.movableContentKey;     // Catch: Throwable -> L6
        boolean r10 = false;
        if (getInserting() == false) goto L9;
        SlotWriter.markGroup$default(this.writer, 0, 1, null);     // Catch: Throwable -> L6
    L9:
        if (getInserting() == false) goto L12;
    L14:
        if (r10 == false) goto L16;
        this.providerUpdates.set(this.reader.getCurrentGroup(), r12);     // Catch: Throwable -> L6
    L16:
        m8startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m18getGroupULZAiWs(), r12);     // Catch: Throwable -> L6
        if (getInserting() == false) goto L20;
        if (r14 == true) goto L20;
        this.writerHasAProvider = true;     // Catch: Throwable -> L6
        this.providerCache = null;     // Catch: Throwable -> L6
        SlotWriter r15 = this.writer;     // Catch: Throwable -> L6
        this.parentContext.insertMovableContent$runtime_release(new MovableContentStateReference(r11, r13, getComposition(), this.insertTable, r15.anchor(r15.parent(r15.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope()));     // Catch: Throwable -> L6
    L21:
        endGroup();
        this.compoundKeyHash = r5;
        endMovableGroup();
        return;
    L20:
        boolean r16 = this.providersInvalid;     // Catch: Throwable -> L6
        this.providersInvalid = r10;     // Catch: Throwable -> L6
        ActualJvm_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(316014703, true, new AnonymousClass1(r11, r13)));     // Catch: Throwable -> L6
        this.providersInvalid = r16;     // Catch: Throwable -> L6
        goto L21
    L12:
        if (Intrinsics.areEqual(this.reader.getGroupAux(), r12) == true) goto L14;
        r10 = true;
    L6:
        th = move-exception;
        endGroup();
        this.compoundKeyHash = r5;
        endMovableGroup();
        throw th;
    }

    private final Object nodeAt(SlotReader r5, int r10) {
        return r5.node(r10);
    }

    private final int nodeIndexOf(int r5, int r10, int r11, int r12) {
        int r13 = this.reader.parent(r10);
    L3:
        if (r13 == r11) goto L8;
        if (this.reader.isNode(r13) == true) goto L8;
        r13 = this.reader.parent(r13);
    L8:
        if (this.reader.isNode(r13) == false) goto L10;
        r12 = 0;
    L10:
        if (r13 != r10) goto L12;
        return r12;
    L12:
        int r14 = (updatedNodeCount(r13) - this.reader.nodeCount(r10)) + r12;
    L13:
        if (r12 >= r14) goto L20;
        if (r13 == r5) goto L20;
        r13 = r13 + 1;
    L16:
        if (r13 >= r5) goto L20;
        int r15 = this.reader.groupSize(r13) + r13;
        if (r5 < r15) goto L13;
        r12 = r12 + updatedNodeCount(r13);
        r13 = r15;
    L20:
        return r12;
    }

    private final void realizeDowns(final Object[] r5) {
        record(new C00391(r5));
    }

    private final void realizeMovement() {
        final int r5 = this.previousCount;
        this.previousCount = 0;
        if (r5 <= 0) goto L9;
        final int r10 = this.previousRemove;
        if (r10 < 0) goto L7;
        this.previousRemove = -1;
        recordApplierOperation(new C00401(r10, r5));
        return;
    L7:
        final int r11 = this.previousMoveFrom;
        this.previousMoveFrom = -1;
        final int r12 = this.previousMoveTo;
        this.previousMoveTo = -1;
        recordApplierOperation(new C00412(r11, r12, r5));
        return;
    }

    private final void realizeOperationLocation(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = this.reader.getParent();
    L5:
        final int r11 = r10 - this.writersReaderDelta;
        if (r11 < 0) goto L8;
        boolean r12 = true;
    L9:
        if (r12 == false) goto L14;
        if (r11 <= 0) goto L15;
        record(new C00422(r11));
        this.writersReaderDelta = r10;
        return;
    L15:
        return;
    L14:
        throw j0.z("Tried to seek backward");
    L8:
        r12 = false;
        goto L9
    L4:
        r10 = this.reader.getCurrentGroup();
        goto L5
    }

    public static /* synthetic */ void realizeOperationLocation$default(ComposerImpl r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = false;
    L5:
        r5.realizeOperationLocation(r10);
    }

    private final void realizeUps() {
        final int r5 = this.pendingUps;
        if (r5 <= 0) goto L6;
        this.pendingUps = 0;
        record(new C00431(r5));
        return;
    }

    private final <R> R recomposeMovableContent(ControlledComposition r16, ControlledComposition r17, Integer r18, List<Pair<RecomposeScopeImpl, IdentityArraySet<Object>>> r19, Function0<? extends R> r20) {
        boolean r5 = this.implicitRootStart;
        boolean r10 = this.isComposing;
        int r11 = this.nodeIndex;
        this.implicitRootStart = false;     // Catch: Throwable -> L10
        this.isComposing = true;     // Catch: Throwable -> L10
        this.nodeIndex = 0;     // Catch: Throwable -> L10
        int r12 = r19.size();     // Catch: Throwable -> L10
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L14;
        Pair<RecomposeScopeImpl, IdentityArraySet<Object>> r14 = r19.get(r13);     // Catch: Throwable -> L10
        RecomposeScopeImpl r15 = r14.component1();     // Catch: Throwable -> L10
        IdentityArraySet<Object> r21 = r14.component2();     // Catch: Throwable -> L10
        if (r21 == null) goto L12;
        Object[] r110 = r21.getValues();     // Catch: Throwable -> L10
        int r22 = r21.size();     // Catch: Throwable -> L10
        int r111 = 0;
    L8:
        if (r111 >= r22) goto L13;
        Object r112 = r110[r111];     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");     // Catch: Throwable -> L10
        tryImminentInvalidation$runtime_release(r15, r112);     // Catch: Throwable -> L10
        r111 = r111 + 1;     // Catch: Throwable -> L10
    L13:
        r13 = r13 + 1;     // Catch: Throwable -> L10
        goto L4
    L12:
        tryImminentInvalidation$runtime_release(r15, null);     // Catch: Throwable -> L10
        goto L13
    L14:
        if (r16 == null) goto L23;
        if (r18 == null) goto L18;
        int r23 = r18.intValue();     // Catch: Throwable -> L10
    L19:
        R r24 = (R) r16.delegateInvalidations(r17, r23, r20);
        if (r24 == null) goto L23;
    L24:
        this.implicitRootStart = r5;
        this.isComposing = r10;
        this.nodeIndex = r11;
        return r24;
    L18:
        r23 = -1;
    L23:
        r24 = r20.invoke();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.implicitRootStart = r5;
        this.isComposing = r10;
        this.nodeIndex = r11;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object recomposeMovableContent$default(ComposerImpl r10, ControlledComposition r11, ControlledComposition r12, Integer r13, List r14, Function0 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        ControlledComposition r5 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        ControlledComposition r18 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        Integer r19 = null;
    L15:
        if ((r16 & 8) == 0) goto L18;
        r14 = CollectionsKt.emptyList();
    L18:
        return r10.recomposeMovableContent(r5, r18, r19, r14, r15);
    L13:
        r19 = r13;
        goto L15
    L9:
        r18 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    private final void recomposeToGroupEnd() {
        boolean r5 = this.isComposing;
        this.isComposing = true;
        int r10 = this.reader.getParent();
        int r11 = this.reader.groupSize(r10) + r10;
        int r12 = this.nodeIndex;
        int r13 = getCompoundKeyHash();
        int r14 = this.groupNodeCount;
        Invalidation r15 = ComposerKt.access$firstInRange(this.invalidations, this.reader.getCurrentGroup(), r11);
        boolean r16 = false;
        int r17 = r10;
    L3:
        if (r15 == null) goto L9;
        int r18 = r15.getLocation();
        ComposerKt.access$removeLocation(this.invalidations, r18);
        if (r15.isInvalid() == false) goto L7;
        this.reader.reposition(r18);
        int r19 = this.reader.getCurrentGroup();
        recordUpsAndDowns(r17, r19, r10);
        this.nodeIndex = nodeIndexOf(r18, r19, r10, r12);
        this.compoundKeyHash = compoundKeyOf(this.reader.parent(r19), r10, r13);
        this.providerCache = null;
        r15.getScope().compose(this);
        this.providerCache = null;
        this.reader.restoreParent(r10);
        r17 = r19;
        r16 = true;
    L8:
        r15 = ComposerKt.access$firstInRange(this.invalidations, this.reader.getCurrentGroup(), r11);
        goto L3
    L7:
        this.invalidateStack.push(r15.getScope());
        r15.getScope().rereadTrackedInstances();
        this.invalidateStack.pop();
        goto L8
    L9:
        if (r16 == false) goto L11;
        recordUpsAndDowns(r17, r10, r10);
        this.reader.skipToGroupEnd();
        int r20 = updatedNodeCount(r10);
        this.nodeIndex = r12 + r20;
        this.groupNodeCount = r14 + r20;
    L12:
        this.compoundKeyHash = r13;
        this.isComposing = r5;
        return;
    L11:
        skipReaderToGroupEnd();
        goto L12
    }

    private final void record(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> r5) {
        this.changes.add(r5);
    }

    private final void recordApplierOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> r5) {
        realizeUps();
        realizeDowns();
        record(r5);
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        recordSlotEditingOperation(ComposerKt.access$getRemoveCurrentGroupInstance$p());
        int r5 = this.writersReaderDelta;
        this.writersReaderDelta = this.reader.getGroupSize() + r5;
    }

    private final void recordDown(Object r5) {
        this.downNodes.push(r5);
    }

    private final void recordEndGroup() {
        int r5 = this.reader.getParent();
        if (this.startedGroups.peekOr(-1) > r5) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L12;
        if (this.startedGroups.peekOr(-1) != r5) goto L13;
        this.startedGroups.pop();
        recordSlotTableOperation$default(this, false, ComposerKt.access$getEndGroupInstance$p(), 1, null);
        return;
    L13:
        return;
    L12:
        throw j0.z("Missed recording an endGroup");
    L5:
        r10 = false;
        goto L6
    }

    private final void recordEndRoot() {
        if (this.startedGroup == false) goto L6;
        recordSlotTableOperation$default(this, false, ComposerKt.access$getEndGroupInstance$p(), 1, null);
        this.startedGroup = false;
        return;
    }

    private final void recordFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> r5) {
        this.insertFixups.add(r5);
    }

    private final void recordInsert(final Anchor r5) {
        if (this.insertFixups.isEmpty() == false) goto L5;
        final SlotTable r10 = this.insertTable;
        recordSlotEditingOperation(new C00441(r10, r5));
        return;
    L5:
        final List r11 = CollectionsKt.toMutableList(this.insertFixups);
        this.insertFixups.clear();
        realizeUps();
        realizeDowns();
        final SlotTable r12 = this.insertTable;
        recordSlotEditingOperation(new C00452(r12, r5, r11));
    }

    private final void recordInsertUpFixup(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> r5) {
        this.insertUpFixups.push(r5);
    }

    private final void recordMoveNode(int r5, int r10, int r11) {
        if (r11 <= 0) goto L12;
        int r12 = this.previousCount;
        if (r12 > 0) goto L6;
    L10:
        realizeMovement();
        this.previousMoveFrom = r5;
        this.previousMoveTo = r10;
        this.previousCount = r11;
        return;
    L6:
        if (this.previousMoveFrom != (r5 - r12)) goto L10;
        if (this.previousMoveTo != (r10 - r12)) goto L10;
        this.previousCount = r12 + r11;
        return;
    }

    private final void recordReaderMoving(int r5) {
        this.writersReaderDelta = r5 - (this.reader.getCurrentGroup() - this.writersReaderDelta);
    }

    private final void recordRemoveNode(int r5, int r10) {
        if (r10 <= 0) goto L13;
        if (r5 < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
        ComposerKt.composeRuntimeError(("Invalid remove index " + r5).toString());
        throw new KotlinNothingValueException();
    L8:
        if (this.previousRemove != r5) goto L10;
        this.previousCount += r10;
        return;
    L10:
        realizeMovement();
        this.previousRemove = r5;
        this.previousCount = r10;
        return;
    L5:
        r11 = false;
        goto L6
    }

    private final void recordSlotEditing() {
        if (this.reader.getSize() <= 0) goto L14;
        SlotReader r5 = this.reader;
        int r10 = r5.getParent();
        if (this.startedGroups.peekOr(-2) != r10) goto L7;
        return;
    L7:
        if (this.startedGroup == false) goto L9;
    L11:
        if (r10 <= 0) goto L16;
        final Anchor r11 = r5.anchor(r10);
        this.startedGroups.push(r10);
        recordSlotTableOperation$default(this, false, new C00471(r11), 1, null);
        return;
    L16:
        return;
    L9:
        if (this.implicitRootStart == false) goto L11;
        recordSlotTableOperation$default(this, false, ComposerKt.access$getStartRootGroup$p(), 1, null);
        this.startedGroup = true;
        goto L11
    }

    private final void recordSlotEditingOperation(Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> r5) {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
        record(r5);
    }

    private final void recordSlotTableOperation(boolean r5, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> r10) {
        realizeOperationLocation(r5);
        record(r10);
    }

    public static /* synthetic */ void recordSlotTableOperation$default(ComposerImpl r5, boolean r10, Function3 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = false;
    L5:
        r5.recordSlotTableOperation(r10, r11);
    }

    private final void recordUp() {
        if (this.downNodes.isNotEmpty() == false) goto L5;
        this.downNodes.pop();
        return;
    L5:
        this.pendingUps++;
    }

    private final void recordUpsAndDowns(int r5, int r10, int r11) {
        SlotReader r12 = this.reader;
        int r13 = ComposerKt.access$nearestCommonRootOf(r12, r5, r10, r11);
    L3:
        if (r5 <= 0) goto L9;
        if (r5 == r13) goto L9;
        if (r12.isNode(r5) == false) goto L8;
        recordUp();
    L8:
        r5 = r12.parent(r5);
    L9:
        doRecordDownsFor(r10, r13);
    }

    private final void registerInsertUpFixup() {
        this.insertFixups.add(this.insertUpFixups.pop());
    }

    private final void releaseMovableGroupAtCurrent(final MovableContentStateReference r10, SlotWriter r11) {
        SlotTable r5 = new SlotTable();
        SlotWriter r12 = r5.openWriter();
        r12.beginInsert();     // Catch: Throwable -> L14
        r12.startGroup(MovableContentKt.movableContentKey, r10.getContent$runtime_release());     // Catch: Throwable -> L14
        SlotWriter.markGroup$default(r12, 0, 1, null);     // Catch: Throwable -> L14
        r12.update(r10.getParameter$runtime_release());     // Catch: Throwable -> L14
        List<Anchor> r13 = r11.moveTo(r10.getAnchor$runtime_release(), 1, r12);     // Catch: Throwable -> L14
        r12.skipGroup();     // Catch: Throwable -> L14
        r12.endGroup();     // Catch: Throwable -> L14
        r12.endInsert();     // Catch: Throwable -> L14
        r12.close();
        MovableContentState r14 = new MovableContentState(r5);
        RecomposeScopeImpl.Companion r15 = RecomposeScopeImpl.Companion;
        if (r15.hasAnchoredRecomposeScopes$runtime_release(r5, r13) == false) goto L12;
        final ControlledComposition r16 = getComposition();
        RecomposeScopeOwner r17 = new ComposerImpl$releaseMovableGroupAtCurrent$movableContentRecomposeScopeOwner$1(r16, r10);
        SlotWriter r18 = r5.openWriter();
        r15.adoptAnchoredScopes$runtime_release(r18, r13, r17);     // Catch: Throwable -> L9
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r18.close();
    L9:
        th = move-exception;
        r18.close();
        throw th;
    L12:
        this.parentContext.movableContentStateReleased$runtime_release(r10, r14);
        return;
    L14:
        th = move-exception;
        r12.close();
        throw th;
    }

    private final void reportAllMovableContent() {
        if (this.slotTable.containsMark() == false) goto L20;
        ArrayList r5 = new ArrayList();
        this.deferredChanges = r5;
        SlotReader r10 = this.slotTable.openReader();
        this.reader = r10;     // Catch: Throwable -> L14
        List r11 = access$getChanges$p(this);     // Catch: Throwable -> L14
        access$setChanges$p(this, r5);     // Catch: Throwable -> L9
        reportFreeMovableContent(0);     // Catch: Throwable -> L9
        realizeUps();     // Catch: Throwable -> L9
        if (this.startedGroup == false) goto L11;
        record(ComposerKt.access$getSkipToGroupEndInstance$p());     // Catch: Throwable -> L9
        recordEndRoot();     // Catch: Throwable -> L9
    L11:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        access$setChanges$p(this, r11);     // Catch: Throwable -> L14
        r10.close();
        return;
    L9:
        th = move-exception;
        access$setChanges$p(this, r11);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r10.close();
        throw th;
    }

    private final void reportFreeMovableContent(int r5) {
        reportFreeMovableContent$reportGroup(this, r5, false, 0);
        realizeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(final ComposerImpl r16, int r17, boolean r18, int r19) {
        int r5 = 1;
        if (r16.reader.hasMark(r17) == false) goto L36;
        int r10 = r16.reader.groupKey(r17);
        Object r11 = r16.reader.groupObjectKey(r17);
        if (r10 != 126665345) goto L21;
        if ((r11 instanceof MovableContent) == false) goto L21;
        MovableContent r12 = (MovableContent) r11;
        Object r13 = r16.reader.groupGet(r17, 0);
        Anchor r14 = r16.reader.anchor(r17);
        List r15 = ComposerKt.access$filterToRange(r16.invalidations, r17, r16.reader.groupSize(r17) + r17);
        ArrayList r110 = new ArrayList(r15.size());
        int r20 = r15.size();
        int r21 = 0;
    L9:
        if (r21 >= r20) goto L11;
        Invalidation r22 = (Invalidation) r15.get(r21);
        r110.add(TuplesKt.to(r22.getScope(), r22.getInstances()));
        r21 = r21 + 1;
        goto L9
    L11:
        final MovableContentStateReference r23 = new MovableContentStateReference(r12, r13, r16.getComposition(), r16.slotTable, r14, r110, r16.currentCompositionLocalScope(r17));
        r16.parentContext.deletedMovableContent$runtime_release(r23);
        r16.recordSlotEditing();
        r16.record(new ComposerImpl$reportFreeMovableContent$reportGroup$1(r16, r23));
        if (r18 == false) goto L64;
        r16.realizeMovement();
        r16.realizeUps();
        r16.realizeDowns();
        if (r16.reader.isNode(r17) == true) goto L17;
        r5 = r16.reader.nodeCount(r17);
    L17:
        if (r5 <= 0) goto L62;
        r16.recordRemoveNode(r19, r5);
        return 0;
    L62:
        return 0;
    L64:
        return r16.reader.nodeCount(r17);
    L21:
        if (r10 != 206) goto L66;
        if (Intrinsics.areEqual(r11, ComposerKt.getReference()) == false) goto L66;
        Object r24 = r16.reader.groupGet(r17, 0);
        if ((r24 instanceof CompositionContextHolder) == false) goto L27;
        CompositionContextHolder r25 = (CompositionContextHolder) r24;
    L28:
        if (r25 == null) goto L65;
        Iterator<T> r26 = r25.getRef().getComposers().iterator();
    L31:
        if (r26.hasNext() == false) goto L65;
        ComposerImpl r27 = (ComposerImpl) r26.next();
        r27.reportAllMovableContent();
        r16.parentContext.reportRemovedComposition$runtime_release(r27.getComposition());
    L65:
        return r16.reader.nodeCount(r17);
    L27:
        r25 = null;
    L66:
        return r16.reader.nodeCount(r17);
    L36:
        if (r16.reader.containsMark(r17) == false) goto L56;
        int r28 = r16.reader.groupSize(r17) + r17;
        int r29 = r17 + 1;
        int r30 = 0;
    L38:
        if (r29 >= r28) goto L67;
        boolean r31 = r16.reader.isNode(r29);
        if (r31 == false) goto L42;
        r16.realizeMovement();
        r16.recordDown(r16.reader.node(r29));
    L42:
        if (r31 == true) goto L46;
        if (r18 == true) goto L46;
        boolean r32 = false;
    L47:
        if (r31 == false) goto L49;
        int r33 = 0;
    L50:
        r30 = r30 + reportFreeMovableContent$reportGroup(r16, r29, r32, r33);
        if (r31 == false) goto L53;
        r16.realizeMovement();
        r16.recordUp();
    L53:
        r29 = r29 + r16.reader.groupSize(r29);
        goto L38
    L49:
        r33 = r19 + r30;
    L46:
        r32 = true;
        goto L47
    L67:
        return r30;
    L56:
        return r16.reader.nodeCount(r17);
    }

    private final void skipGroup() {
        int r5 = this.groupNodeCount;
        this.groupNodeCount = this.reader.skipGroup() + r5;
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    /* JADX INFO: renamed from: start-BaiHCIY, reason: not valid java name */
    private final void m8startBaiHCIY(int r14, Object r15, int r16, Object r17) {
        Object r5 = r15;
        validateNodeNotExpected();
        updateCompoundKeyWhenWeEnterGroup(r14, r15, r17);
        GroupKind.Companion r10 = GroupKind.Companion;
        int r11 = 0;
        if (r16 == r10.m18getGroupULZAiWs()) goto L5;
        boolean r12 = true;
    L6:
        Pending r13 = null;
        if (getInserting() == false) goto L26;
        this.reader.beginEmpty();
        int r18 = this.writer.getCurrentGroup();
        if (r12 == false) goto L11;
        this.writer.startNode(r14, Composer.Companion.getEmpty());
    L20:
        Pending r19 = this.pending;
        if (r19 == null) goto L23;
        KeyInfo r20 = new KeyInfo(r14, -1, insertedGroupVirtualIndex(r18), -1, 0);
        r19.registerInsert(r20, this.nodeIndex - r19.getStartIndex());
        r19.recordUsed(r20);
    L23:
        enterGroup(r12, null);
        return;
    L11:
        if (r17 == null) goto L16;
        SlotWriter r21 = this.writer;
        if (r5 != null) goto L15;
        r5 = Composer.Companion.getEmpty();
    L15:
        r21.startData(r14, r5, r17);
        goto L20
    L16:
        SlotWriter r22 = this.writer;
        if (r5 != null) goto L19;
        r5 = Composer.Companion.getEmpty();
    L19:
        r22.startGroup(r14, r5);
        goto L20
    L26:
        if (r16 == r10.m19getNodeULZAiWs()) goto L29;
    L31:
        boolean r23 = false;
    L33:
        if (this.pending != null) goto L41;
        int r24 = this.reader.getGroupKey();
        if (r23 == true) goto L40;
        if (r24 != r14) goto L40;
        if (Intrinsics.areEqual(r15, this.reader.getGroupObjectKey()) == false) goto L40;
        startReaderGroup(r12, r17);
    L40:
        this.pending = new Pending(this.reader.extractKeys(), this.nodeIndex);
    L41:
        Pending r110 = this.pending;
        if (r110 == null) goto L67;
        KeyInfo r25 = r110.getNext(r14, r15);
        if (r23 == true) goto L50;
        if (r25 == null) goto L50;
        r110.recordUsed(r25);
        int r26 = r25.getLocation();
        this.nodeIndex = r110.nodePositionOf(r25) + r110.getStartIndex();
        int r27 = r110.slotPositionOf(r25);
        final int r28 = r27 - r110.getGroupIndex();
        r110.registerMoveSlot(r27, r110.getGroupIndex());
        recordReaderMoving(r26);
        this.reader.reposition(r26);
        if (r28 <= 0) goto L49;
        recordSlotEditingOperation(new ComposerImpl$start$2(r28));
    L49:
        startReaderGroup(r12, r17);
    L50:
        this.reader.beginEmpty();
        this.inserting = true;
        this.providerCache = null;
        ensureWriter();
        this.writer.beginInsert();
        int r29 = this.writer.getCurrentGroup();
        if (r12 == false) goto L53;
        this.writer.startNode(r14, Composer.Companion.getEmpty());
    L62:
        this.insertAnchor = this.writer.anchor(r29);
        KeyInfo r30 = new KeyInfo(r14, -1, insertedGroupVirtualIndex(r29), -1, 0);
        r110.registerInsert(r30, this.nodeIndex - r110.getStartIndex());
        r110.recordUsed(r30);
        ArrayList r31 = new ArrayList();
        if (r12 == true) goto L66;
        r11 = this.nodeIndex;
    L66:
        r13 = new Pending(r31, r11);
        goto L67
    L53:
        if (r17 == null) goto L58;
        SlotWriter r32 = this.writer;
        if (r5 != null) goto L57;
        r5 = Composer.Companion.getEmpty();
    L57:
        r32.startData(r14, r5, r17);
        goto L62
    L58:
        SlotWriter r33 = this.writer;
        if (r5 != null) goto L61;
        r5 = Composer.Companion.getEmpty();
    L61:
        r33.startGroup(r14, r5);
    L67:
        enterGroup(r12, r13);
        return;
    L29:
        if (this.reusing == false) goto L31;
        r23 = true;
        goto L33
    L5:
        r12 = false;
        goto L6
    }

    private final void startGroup(int r5) {
        m8startBaiHCIY(r5, null, GroupKind.Companion.m18getGroupULZAiWs(), null);
    }

    private final void startReaderGroup(boolean r5, final Object r10) {
        if (r5 == false) goto L4;
        this.reader.startNode();
        return;
    L4:
        if (r10 != null) goto L6;
    L8:
        this.reader.startGroup();
        return;
    L6:
        if (this.reader.getGroupAux() == r10) goto L8;
        recordSlotTableOperation$default(this, false, new C00481(r10), 1, null);
        goto L8
    }

    private final void startRoot() {
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = null;
        if (this.forceRecomposeScopes == true) goto L5;
        this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
    L5:
        Set<CompositionData> r5 = (Set) CompositionLocalMapKt.read(this.parentProvider, InspectionTablesKt.getLocalInspectionTables());
        if (r5 == null) goto L8;
        r5.add(this.slotTable);
        this.parentContext.recordInspectionTable$runtime_release(r5);
    L8:
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int r5, Object r10, Object r11) {
        if (r10 != null) goto L11;
        if (r11 != null) goto L5;
    L9:
        updateCompoundKeyWhenWeEnterGroupKeyHash(r5);
        return;
    L5:
        if (r5 != 207) goto L9;
        if (Intrinsics.areEqual(r11, Composer.Companion.getEmpty()) == true) goto L9;
        updateCompoundKeyWhenWeEnterGroupKeyHash(r11.hashCode());
        return;
    L11:
        if ((r10 instanceof Enum) == false) goto L13;
        updateCompoundKeyWhenWeEnterGroupKeyHash(((Enum) r10).ordinal());
        return;
    L13:
        updateCompoundKeyWhenWeEnterGroupKeyHash(r10.hashCode());
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int r5) {
        this.compoundKeyHash = r5 ^ Integer.rotateLeft(getCompoundKeyHash(), 3);
    }

    private final void updateCompoundKeyWhenWeExitGroup(int r5, Object r10, Object r11) {
        if (r10 != null) goto L11;
        if (r11 != null) goto L5;
    L9:
        updateCompoundKeyWhenWeExitGroupKeyHash(r5);
        return;
    L5:
        if (r5 != 207) goto L9;
        if (Intrinsics.areEqual(r11, Composer.Companion.getEmpty()) == true) goto L9;
        updateCompoundKeyWhenWeExitGroupKeyHash(r11.hashCode());
        return;
    L11:
        if ((r10 instanceof Enum) == false) goto L13;
        updateCompoundKeyWhenWeExitGroupKeyHash(((Enum) r10).ordinal());
        return;
    L13:
        updateCompoundKeyWhenWeExitGroupKeyHash(r10.hashCode());
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int r5) {
        int r10 = getCompoundKeyHash();
        this.compoundKeyHash = Integer.rotateRight(Integer.hashCode(r5) ^ r10, 3);
    }

    private final void updateNodeCount(int r5, int r10) {
        if (updatedNodeCount(r5) == r10) goto L14;
        if (r5 >= 0) goto L9;
        HashMap<Integer, Integer> r11 = this.nodeCountVirtualOverrides;
        if (r11 != null) goto L8;
        r11 = new HashMap();
        this.nodeCountVirtualOverrides = r11;
    L8:
        r11.put(Integer.valueOf(r5), Integer.valueOf(r10));
        return;
    L9:
        int[] r12 = this.nodeCountOverrides;
        if (r12 != null) goto L12;
        r12 = new int[this.reader.getSize()];
        ArraysKt.i(r12, -1);
        this.nodeCountOverrides = r12;
    L12:
        r12[r5] = r10;
        return;
    }

    private final void updateNodeCountOverrides(int r10, int r11) {
        int r5 = updatedNodeCount(r10);
        if (r5 == r11) goto L20;
        int r12 = r11 - r5;
        int r13 = this.pendingStack.getSize() - 1;
    L6:
        if (r10 == (-1)) goto L32;
        int r14 = updatedNodeCount(r10) + r12;
        updateNodeCount(r10, r14);
        int r15 = r13;
    L8:
        if ((-1) >= r15) goto L15;
        Pending r16 = this.pendingStack.peek(r15);
        if (r16 == null) goto L14;
        if (r16.updateNodeCount(r10, r14) == false) goto L14;
        r13 = r15 - 1;
    L14:
        r15 = r15 - 1;
    L15:
        if (r10 < 0) goto L16;
        if (this.reader.isNode(r10) == true) goto L33;
        r10 = this.reader.parent(r10);
        goto L6
    L33:
        return;
    L16:
        r10 = this.reader.getParent();
        goto L6
    L32:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap, java.lang.Object] */
    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap r5, PersistentCompositionLocalMap r10) {
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> r11 = r5.builder();
        r11.putAll(r10);
        ?? r12 = r11.build();
        startGroup(ComposerKt.providerMapsKey, ComposerKt.getProviderMaps());
        changed(r12);
        changed(r10);
        endGroup();
        return r12;
    }

    private final int updatedNodeCount(int r5) {
        if (r5 >= 0) goto L10;
        HashMap<Integer, Integer> r10 = this.nodeCountVirtualOverrides;
        if (r10 == null) goto L8;
        Integer r11 = r10.get(Integer.valueOf(r5));
        if (r11 == null) goto L8;
        return r11.intValue();
    L8:
        return 0;
    L10:
        int[] r12 = this.nodeCountOverrides;
        if (r12 == null) goto L16;
        int r13 = r12[r5];
        if (r13 < 0) goto L16;
        return r13;
    L16:
        return this.reader.nodeCount(r5);
    }

    private final void validateNodeExpected() {
        if (this.nodeExpected == false) goto L7;
        this.nodeExpected = false;
        return;
    L7:
        throw j0.z("A call to createNode(), emitNode() or useNode() expected was not expected");
    }

    private final void validateNodeNotExpected() {
        if (this.nodeExpected == true) goto L6;
        return;
    L6:
        throw j0.z("A call to createNode(), emitNode() or useNode() expected");
    }

    private final <R> R withChanges(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r5, Function0<? extends R> r10) {
        List r11 = access$getChanges$p(this);
        access$setChanges$p(this, r5);     // Catch: Throwable -> L6
        R r12 = r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        access$setChanges$p(this, r11);
        InlineMarker.finallyEnd(1);
        return r12;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        access$setChanges$p(this, r11);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private final <R> R withReader(SlotReader r5, Function0<? extends R> r10) {
        SlotReader r11 = access$getReader$p(this);
        int[] r12 = access$getNodeCountOverrides$p(this);
        access$setNodeCountOverrides$p(this, null);
        access$setReader$p(this, r5);     // Catch: Throwable -> L6
        R r13 = r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        access$setReader$p(this, r11);
        access$setNodeCountOverrides$p(this, r12);
        InlineMarker.finallyEnd(1);
        return r13;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        access$setReader$p(this, r11);
        access$setNodeCountOverrides$p(this, r12);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // androidx.compose.runtime.Composer
    public <V, T> void apply(final V r5, final Function2<? super T, ? super V, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        Function3<Applier<?>, SlotWriter, RememberManager, Unit> r11 = new ComposerImpl$apply$operation$1(r10, r5);
        if (getInserting() == false) goto L5;
        recordFixup(r11);
        return;
    L5:
        recordApplierOperation(r11);
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext buildContext() {
        startGroup(ComposerKt.referenceKey, ComposerKt.getReference());
        CompositionContextHolder r5 = null;
        if (getInserting() == false) goto L5;
        SlotWriter.markGroup$default(this.writer, 0, 1, null);
    L5:
        Object r10 = nextSlot();
        if ((r10 instanceof CompositionContextHolder) == false) goto L8;
        r5 = (CompositionContextHolder) r10;
    L8:
        if (r5 != null) goto L10;
        r5 = new CompositionContextHolder(new CompositionContextImpl(this, getCompoundKeyHash(), this.forceRecomposeScopes));
        updateValue(r5);
    L10:
        r5.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return r5.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        T r11 = (T) nextSlot();
        if (r11 == Composer.Companion.getEmpty()) goto L5;
        if (r5 == true) goto L5;
        return r11;
    L5:
        T r12 = r10.invoke();
        updateValue(r12);
        return r12;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(Object r5) {
        if (Intrinsics.areEqual(nextSlot(), r5) == true) goto L5;
        updateValue(r5);
        return true;
    L5:
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changedInstance(Object r5) {
        if (nextSlot() == r5) goto L5;
        updateValue(r5);
        return true;
    L5:
        return false;
    }

    public final void changesApplied$runtime_release() {
        createFreshInsertTable();
        this.providerUpdates.clear();
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
    }

    public final void composeContent$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r5, Function2<? super Composer, ? super Integer, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "invalidationsRequested");
        Intrinsics.checkNotNullParameter(r10, "content");
        if (this.changes.isEmpty() == false) goto L7;
        doCompose(r5, r10);
        return;
    L7:
        throw j0.z("Expected applyChanges() to have been called");
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public <T> T consume(CompositionLocal<T> r5) {
        Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
        return (T) CompositionLocalMapKt.read(currentCompositionLocalScope(), r5);
    }

    @Override // androidx.compose.runtime.Composer
    public <T> void createNode(final Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        validateNodeExpected();
        if (getInserting() == false) goto L7;
        final int r10 = this.nodeIndexStack.peek();
        SlotWriter r11 = this.writer;
        final Anchor r12 = r11.anchor(r11.getParent());
        this.groupNodeCount++;
        recordFixup(new AnonymousClass2(r5, r12, r10));
        recordInsertUpFixup(new AnonymousClass3(r12, r10));
        return;
    L7:
        throw j0.z("createNode() can only be called when inserting");
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean r5) {
        if (this.groupNodeCount != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L23;
        if (getInserting() == true) goto L28;
        if (r5 == true) goto L12;
        skipReaderToGroupEnd();
        return;
    L12:
        int r11 = this.reader.getCurrentGroup();
        int r12 = this.reader.getCurrentEnd();
        final int r13 = r11;
    L13:
        if (r13 >= r12) goto L20;
        if (this.reader.isNode(r13) == false) goto L19;
        final Object r14 = this.reader.node(r13);
        if ((r14 instanceof ComposeNodeLifecycleCallback) == false) goto L19;
        record(new C00372(r14));
    L19:
        this.reader.forEachData$runtime_release(r13, new C00383(this, r13));
        r13 = r13 + 1;
        goto L13
    L20:
        ComposerKt.access$removeRange(this.invalidations, r11, r12);
        this.reader.reposition(r11);
        this.reader.skipToGroupEnd();
        return;
    L28:
        return;
    L23:
        throw j0.z("No nodes can be emitted before calling dactivateToEndGroup");
    L5:
        r10 = false;
        goto L6
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        this.sourceInformationEnabled = false;
    }

    public final void dispose$runtime_release() {
        Trace r5 = Trace.INSTANCE;
        Object r10 = r5.beginSection("Compose:Composer.dispose");
        this.parentContext.unregisterComposer$runtime_release(this);     // Catch: Throwable -> L6
        this.invalidateStack.clear();     // Catch: Throwable -> L6
        this.invalidations.clear();     // Catch: Throwable -> L6
        this.changes.clear();     // Catch: Throwable -> L6
        this.providerUpdates.clear();     // Catch: Throwable -> L6
        getApplier().clear();     // Catch: Throwable -> L6
        this.isDisposed = true;     // Catch: Throwable -> L6
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r5.endSection(r10);
        return;
    L6:
        th = move-exception;
        Trace.INSTANCE.endSection(r10);
        throw th;
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        if (this.reusingGroup < 0) goto L5;
        boolean r5 = true;
    L6:
        this.reusing = r5;
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endDefaults() {
        endGroup();
        RecomposeScopeImpl r5 = getCurrentRecomposeScope$runtime_release();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.getUsed() == false) goto L9;
        r5.setDefaultsInScope(true);
        return;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public ScopeUpdateScope endRestartGroup() {
        RecomposeScopeImpl r5 = null;
        if (this.invalidateStack.isNotEmpty() == false) goto L5;
        RecomposeScopeImpl r10 = this.invalidateStack.pop();
    L7:
        if (r10 == null) goto L10;
        r10.setRequiresRecompose(false);
    L10:
        if (r10 == null) goto L14;
        final Function1<Composition, Unit> r11 = r10.end(this.compositionToken);
        if (r11 == null) goto L14;
        record(new ComposerImpl$endRestartGroup$1$1(r11, this));
    L14:
        if (r10 != null) goto L16;
    L29:
        end(false);
        return r5;
    L16:
        if (r10.getSkipped$runtime_release() == true) goto L29;
        if (r10.getUsed() == true) goto L22;
        if (this.forceRecomposeScopes == false) goto L29;
    L22:
        if (r10.getAnchor() == null) goto L24;
    L28:
        r10.setDefaultsInvalid(false);
        r5 = r10;
        goto L29
    L24:
        if (getInserting() == false) goto L26;
        SlotWriter r12 = this.writer;
        Anchor r13 = r12.anchor(r12.getParent());
    L27:
        r10.setAnchor(r13);
        goto L28
    L26:
        SlotReader r14 = this.reader;
        r13 = r14.anchor(r14.getParent());
        goto L27
    L5:
        r10 = null;
        goto L7
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        if (this.reusing == true) goto L5;
    L7:
        end(false);
        return;
    L5:
        if (this.reader.getParent() != this.reusingGroup) goto L7;
        this.reusingGroup = -1;
        this.reusing = false;
        goto L7
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int r5) {
        if (r5 >= 0) goto L8;
        int r10 = -r5;
        SlotWriter r11 = this.writer;
    L4:
        int r12 = r11.getParent();
        if (r12 <= r10) goto L17;
        end(r11.isNode(r12));
        goto L4
    L17:
        return;
    L8:
        if (getInserting() == false) goto L13;
        SlotWriter r13 = this.writer;
    L11:
        if (getInserting() == false) goto L13;
        end(r13.isNode(r13.getParent()));
    L13:
        SlotReader r14 = this.reader;
    L14:
        int r15 = r14.getParent();
        if (r15 <= r5) goto L21;
        end(r14.isNode(r15));
        goto L14
    }

    public final boolean forceRecomposeScopes$runtime_release() {
        if (this.forceRecomposeScopes == true) goto L5;
        this.forceRecomposeScopes = true;
        this.forciblyRecompose = true;
        return true;
    L5:
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    public Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    public final boolean getAreChildrenComposing$runtime_release() {
        if (this.childrenComposing <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getChangeCount$runtime_release() {
        return this.changes.size();
    }

    @Override // androidx.compose.runtime.Composer
    public ControlledComposition getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        return this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        if (getInserting() == false) goto L6;
        return -this.writer.getParent();
    L6:
        return this.reader.getParent();
    }

    public final RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        Stack<RecomposeScopeImpl> r5 = this.invalidateStack;
        if (this.childrenComposing == 0) goto L5;
    L7:
        return null;
    L5:
        if (r5.isNotEmpty() == false) goto L7;
        return r5.peek();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        if (this.providersInvalid == true) goto L11;
        RecomposeScopeImpl r5 = getCurrentRecomposeScope$runtime_release();
        if (r5 != null) goto L7;
    L9:
        return false;
    L7:
        if (r5.getDefaultsInvalid() != true) goto L9;
        return true;
    L11:
        return true;
    }

    public final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    public final boolean getHasInvalidations() {
        return !this.invalidations.isEmpty();
    }

    public final boolean getHasPendingChanges$runtime_release() {
        return !this.changes.isEmpty();
    }

    public final SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope getRecomposeScope() {
        return getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl r5 = getCurrentRecomposeScope$runtime_release();
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getAnchor();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        if (getInserting() == false) goto L5;
    L15:
        return false;
    L5:
        if (this.reusing == true) goto L15;
        if (this.providersInvalid == true) goto L15;
        RecomposeScopeImpl r5 = getCurrentRecomposeScope$runtime_release();
        if (r5 == null) goto L15;
        if (r5.getRequiresRecompose() == true) goto L15;
        if (this.forciblyRecompose == true) goto L15;
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContent(MovableContent<?> r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "value");
        invokeMovableContentLambda(r5, currentCompositionLocalScope(), r10, false);
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void insertMovableContentReferences(List<Pair<MovableContentStateReference, MovableContentStateReference>> r5) {
        Intrinsics.checkNotNullParameter(r5, "references");
        insertMovableContentGuarded(r5);     // Catch: Throwable -> L6
        cleanUpCompose();
        return;
    L6:
        th = move-exception;
        abortRoot();
        throw th;
    }

    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Object joinKey(Object r5, Object r10) {
        Object r11 = ComposerKt.access$getKey(this.reader.getGroupObjectKey(), r5, r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return new JoinedKey(r5, r10);
    }

    @PublishedApi
    public final Object nextSlot() {
        if (getInserting() == false) goto L5;
        validateNodeNotExpected();
        return Composer.Companion.getEmpty();
    L5:
        Object r5 = this.reader.next();
        if (this.reusing == false) goto L9;
        return Composer.Companion.getEmpty();
    L9:
        return r5;
    }

    public final int parentKey$runtime_release() {
        if (getInserting() == false) goto L5;
        SlotWriter r5 = this.writer;
        return r5.groupKey(r5.getParent());
    L5:
        SlotReader r10 = this.reader;
        return r10.groupKey(r10.getParent());
    }

    public final void prepareCompose$runtime_release(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        if (this.isComposing == true) goto L12;
        this.isComposing = true;
        r5.invoke();     // Catch: Throwable -> L8
        this.isComposing = false;
        return;
    L8:
        th = move-exception;
        this.isComposing = false;
        throw th;
    L12:
        throw j0.z("Preparing a composition while composing is not supported");
    }

    public final boolean recompose$runtime_release(IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> r5) {
        Intrinsics.checkNotNullParameter(r5, "invalidationsRequested");
        if (this.changes.isEmpty() == false) goto L16;
        if (r5.isNotEmpty() == false) goto L7;
    L13:
        doCompose(r5, null);
        return !this.changes.isEmpty();
    L7:
        if (this.invalidations.isEmpty() == false) goto L13;
        if (this.forciblyRecompose == true) goto L13;
        return false;
    L16:
        throw j0.z("Expected applyChanges() to have been called");
    }

    @Override // androidx.compose.runtime.Composer
    public void recordSideEffect(final Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "effect");
        record(new C00461(r5));
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(RecomposeScope r5) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        if ((r5 instanceof RecomposeScopeImpl) == false) goto L5;
        RecomposeScopeImpl r10 = (RecomposeScopeImpl) r5;
    L6:
        if (r10 == null) goto L10;
        r10.setUsed(true);
        return;
    L10:
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlot();
    }

    public final void setDeferredChanges$runtime_release(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> r5) {
        this.deferredChanges = r5;
    }

    public final void setInsertTable$runtime_release(SlotTable r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.insertTable = r5;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipCurrentGroup() {
        if (this.invalidations.isEmpty() == false) goto L5;
        skipGroup();
        return;
    L5:
        SlotReader r5 = this.reader;
        int r10 = r5.getGroupKey();
        Object r11 = r5.getGroupObjectKey();
        Object r12 = r5.getGroupAux();
        updateCompoundKeyWhenWeEnterGroup(r10, r11, r12);
        startReaderGroup(r5.isNode(), null);
        recomposeToGroupEnd();
        r5.endGroup();
        updateCompoundKeyWhenWeExitGroup(r10, r11, r12);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void skipToGroupEnd() {
        if (this.groupNodeCount != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L16;
        RecomposeScopeImpl r10 = getCurrentRecomposeScope$runtime_release();
        if (r10 == null) goto L11;
        r10.scopeSkipped();
    L11:
        if (this.invalidations.isEmpty() == false) goto L13;
        skipReaderToGroupEnd();
        return;
    L13:
        recomposeToGroupEnd();
        return;
    L16:
        throw j0.z("No nodes can be emitted before calling skipAndEndGroup");
    L5:
        r5 = false;
        goto L6
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformation(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sourceInformation");
        if (getInserting() == true) goto L5;
        return;
    L5:
        if (this.sourceInformationEnabled == false) goto L9;
        this.writer.insertAux(r5);
        return;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        if (this.sourceInformationEnabled == false) goto L6;
        end(false);
        return;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "sourceInformation");
        if (this.sourceInformationEnabled == false) goto L6;
        m8startBaiHCIY(r5, null, GroupKind.Companion.m18getGroupULZAiWs(), r10);
        return;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startDefaults() {
        m8startBaiHCIY(-127, null, GroupKind.Companion.m18getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startMovableGroup(int r5, Object r10) {
        m8startBaiHCIY(r5, r10, GroupKind.Companion.m18getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        m8startBaiHCIY(125, null, GroupKind.Companion.m19getNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    @InternalComposeApi
    public void startProviders(final ProvidedValue<?>[] r10) {
        Intrinsics.checkNotNullParameter(r10, "values");
        final PersistentCompositionLocalMap r5 = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        startGroup(ComposerKt.providerValuesKey, ComposerKt.getProviderValues());
        PersistentCompositionLocalMap r11 = (PersistentCompositionLocalMap) ActualJvm_jvmKt.invokeComposableForResult(this, new ComposerImpl$startProviders$currentProviders$1(r10, r5));
        endGroup();
        boolean r12 = false;
        if (getInserting() == false) goto L5;
        PersistentCompositionLocalMap r13 = updateProviderMapGroup(r5, r11);
        this.writerHasAProvider = true;
    L12:
        if (r12 == true) goto L14;
    L16:
        this.providersInvalidStack.push(ComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = r12;
        this.providerCache = r13;
        m8startBaiHCIY(ComposerKt.compositionLocalMapKey, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.m18getGroupULZAiWs(), r13);
        return;
    L14:
        if (getInserting() == true) goto L16;
        this.providerUpdates.set(this.reader.getCurrentGroup(), r13);
        goto L16
    L5:
        Object r14 = this.reader.groupGet(0);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
        PersistentCompositionLocalMap r15 = (PersistentCompositionLocalMap) r14;
        Object r16 = this.reader.groupGet(1);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
        PersistentCompositionLocalMap r17 = (PersistentCompositionLocalMap) r16;
        if (getSkipping() == true) goto L8;
    L11:
        r13 = updateProviderMapGroup(r5, r11);
        r12 = !Intrinsics.areEqual(r13, r15);
        goto L12
    L8:
        if (Intrinsics.areEqual(r17, r11) == false) goto L11;
        skipGroup();
        r13 = r15;
        goto L12
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public void startReplaceableGroup(int r5) {
        m8startBaiHCIY(r5, null, GroupKind.Companion.m18getGroupULZAiWs(), null);
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public Composer startRestartGroup(int r5) {
        m8startBaiHCIY(r5, null, GroupKind.Companion.m18getGroupULZAiWs(), null);
        addRecomposeScope();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int r5, Object r10) {
        if (this.reader.getGroupKey() == r5) goto L5;
    L9:
        m8startBaiHCIY(r5, null, GroupKind.Companion.m18getGroupULZAiWs(), r10);
        return;
    L5:
        if (Intrinsics.areEqual(this.reader.getGroupAux(), r10) == true) goto L9;
        if (this.reusingGroup >= 0) goto L9;
        this.reusingGroup = this.reader.getCurrentGroup();
        this.reusing = true;
        goto L9
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        m8startBaiHCIY(125, null, GroupKind.Companion.m20getReusableNodeULZAiWs(), null);
        this.nodeExpected = true;
    }

    public final boolean tryImminentInvalidation$runtime_release(RecomposeScopeImpl r5, Object r10) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Anchor r11 = r5.getAnchor();
        if (r11 != null) goto L5;
        return false;
    L5:
        int r12 = r11.toIndexFor(this.reader.getTable$runtime_release());
        if (this.isComposing == true) goto L8;
    L11:
        return false;
    L8:
        if (r12 < this.reader.getCurrentGroup()) goto L11;
        ComposerKt.access$insertIfMissing(this.invalidations, r12, r5, r10);
        return true;
    }

    @PublishedApi
    public final void updateCachedValue(Object r5) {
        updateValue(r5);
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object r5) {
        updateValue(r5);
    }

    @PublishedApi
    public final void updateValue(final Object r5) {
        if (getInserting() == false) goto L7;
        this.writer.update(r5);
        if ((r5 instanceof RememberObserver) == false) goto L12;
        record(new C00491(r5));
        this.abandonSet.add(r5);
        return;
    L12:
        return;
    L7:
        final int r10 = this.reader.getGroupSlotIndex() - 1;
        if ((r5 instanceof RememberObserver) == false) goto L10;
        this.abandonSet.add(r5);
    L10:
        recordSlotTableOperation(true, new C00502(r5, r10));
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        validateNodeExpected();
        if (getInserting() == true) goto L11;
        Object r5 = getNode(this.reader);
        recordDown(r5);
        if (this.reusing == true) goto L7;
        return;
    L7:
        if ((r5 instanceof ComposeNodeLifecycleCallback) == false) goto L13;
        recordApplierOperation(C00512.INSTANCE);
        return;
    L13:
        return;
    L11:
        throw j0.z("useNode() called while inserting");
    }

    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }

    private final void realizeDowns() {
        if (this.downNodes.isNotEmpty() == false) goto L6;
        realizeDowns(this.downNodes.toArray());
        this.downNodes.clear();
        return;
    }

    private final void startGroup(int r5, Object r10) {
        m8startBaiHCIY(r5, r10, GroupKind.Companion.m18getGroupULZAiWs(), null);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int r10) {
        if (getInserting() == false) goto L16;
        if (this.writerHasAProvider == false) goto L16;
        int r5 = this.writer.getParent();
    L7:
        if (r5 <= 0) goto L16;
        if (this.writer.groupKey(r5) != 202) goto L14;
        if (Intrinsics.areEqual(this.writer.groupObjectKey(r5), ComposerKt.getCompositionLocalMap()) == false) goto L14;
        Object r11 = this.writer.groupAux(r5);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
        PersistentCompositionLocalMap r12 = (PersistentCompositionLocalMap) r11;
        this.providerCache = r12;
        return r12;
    L14:
        r5 = this.writer.parent(r5);
    L16:
        if (this.reader.getSize() <= 0) goto L28;
    L17:
        if (r10 <= 0) goto L28;
        if (this.reader.groupKey(r10) != 202) goto L27;
        if (Intrinsics.areEqual(this.reader.groupObjectKey(r10), ComposerKt.getCompositionLocalMap()) == false) goto L27;
        PersistentCompositionLocalMap r13 = this.providerUpdates.get(r10);
        if (r13 != null) goto L25;
        Object r14 = this.reader.groupAux(r10);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
        r13 = (PersistentCompositionLocalMap) r14;
    L25:
        this.providerCache = r13;
        return r13;
    L27:
        r10 = this.reader.parent(r10);
    L28:
        PersistentCompositionLocalMap r15 = this.parentProvider;
        this.providerCache = r15;
        return r15;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(char r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Character) == true) goto L5;
    L8:
        updateValue(Character.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Character) r10).charValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(byte r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Byte) == true) goto L5;
    L8:
        updateValue(Byte.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Number) r10).byteValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(short r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Short) == true) goto L5;
    L8:
        updateValue(Short.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Number) r10).shortValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(boolean r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Boolean) == true) goto L5;
    L8:
        updateValue(Boolean.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Boolean) r10).booleanValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(float r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Float) == true) goto L5;
    L8:
        updateValue(Float.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Number) r10).floatValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(long r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Long) == true) goto L5;
    L8:
        updateValue(Long.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Number) r10).longValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(double r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Double) == true) goto L5;
    L8:
        updateValue(Double.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Number) r10).doubleValue()) goto L8;
        return false;
    }

    @Override // androidx.compose.runtime.Composer
    @ComposeCompilerApi
    public boolean changed(int r5) {
        Object r10 = nextSlot();
        if ((r10 instanceof Integer) == true) goto L5;
    L8:
        updateValue(Integer.valueOf(r5));
        return true;
    L5:
        if (r5 != ((Number) r10).intValue()) goto L8;
        return false;
    }
}
