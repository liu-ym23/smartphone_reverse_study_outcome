package kotlinx.coroutines.channels;

import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.an;
import kotlinx.coroutines.de;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.ag;
import kotlinx.coroutines.internal.ah;
import kotlinx.coroutines.internal.ai;
import kotlinx.coroutines.internal.aj;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b$\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004à\u0001á\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u007f\u001a\u00020\u0007H\u0014J\u001f\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0019\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@¢\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0095\u0001J\u001f\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0095\u0001J>\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\bJ/\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010\u009b\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0019\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0089\u0001J\u001c\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@¢\u0006\u0006\b¯\u0001\u0010\u0089\u0001J\u0082\u0002\u0010°\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u009d\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u009d\u00010³\u0001H\u0082\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\b¢\u0006\u0003\u0010·\u0001J8\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J\u001e\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J'\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J'\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J(\u0010Ë\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J5\u0010Ì\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Í\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Î\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001JK\u0010Ñ\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Õ\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÖ\u0001J$\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ú\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Û\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ü\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Þ\u0001J#\u0010ß\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006â\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "select", AutoTestConstant.PARAM, "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", IslandSession.REOPEN_VALUE_CLOSE, "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", OaidModel.KEY_ID, "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", EventBody.KEY_VALUE, "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class g<E> implements i<E> {
    private static final /* synthetic */ AtomicLongFieldUpdater e = null;
    private static final /* synthetic */ AtomicLongFieldUpdater f = null;
    private static final /* synthetic */ AtomicLongFieldUpdater g = null;
    private static final /* synthetic */ AtomicLongFieldUpdater h = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater i = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater j = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater k = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater l = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater m = null;
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<E, Unit> f17279b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private final Function3<kotlinx.coroutines.selects.m<?>, Object, Object, Function1<Throwable, Unit>> d;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u0006H\u0096B¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class a implements k<E>, de {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<E> f17280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f17281b;
        private kotlinx.coroutines.o<? super Boolean> c;

        public a(g r1) {
            this.f17280a = r1;
            this.f17281b = h.p();
        }

        private final Object a(n<E> r18, int r19, long r20, Continuation<? super Boolean> r22) {
            Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
            g<E> r9 = this.f17280a;
            kotlinx.coroutines.o r10 = kotlinx.coroutines.q.a(IntrinsicsKt.intercepted(r1));
            a(this, r10);     // Catch: Throwable -> L51
            Object r3 = g.a(r9, r18, r19, r20, (de) ZeusTransformUtils.preCheckCast(this, de.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L51
            if (r3 != h.k()) goto L6;
            g.b(r9, (de) ZeusTransformUtils.preCheckCast(this, de.class, "com.obric.memorydata.plugin"), r18, r19);     // Catch: Throwable -> L51
        L47:
            Object r0 = r10.h();
            if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
            DebugProbesKt.probeCoroutineSuspended(r1);
        L50:
            return r0;
        L6:
            Function1<Throwable, Unit> r12 = null;
            r12 = null;
            de r13 = null;
            if (r3 == h.j()) goto L9;
            r18.f();     // Catch: Throwable -> L51
            a(this, r3);     // Catch: Throwable -> L51
            a(this, null);     // Catch: Throwable -> L51
            Boolean r2 = Boxing.boxBoolean(true);     // Catch: Throwable -> L51
            Function1<E, Unit> r4 = r9.f17279b;     // Catch: Throwable -> L51
            if (r4 != null) goto L45;
        L40:
            r10.a(r2, r12);     // Catch: Throwable -> L51
            goto L47
        L45:
            r12 = kotlinx.coroutines.internal.ab.b(r4, r3, r10.getContext());     // Catch: Throwable -> L51
            goto L40
        L9:
            if (r20 >= r9.d()) goto L11;
            r18.f();     // Catch: Throwable -> L51
        L11:
            n r5 = (n) ZeusTransformUtils.preCheckCast(g.u().get(r9), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        L13:
            if (r9.q() == true) goto L14;
            long r14 = g.v().getAndIncrement(r9);     // Catch: Throwable -> L51
            long r6 = r14 / ((long) h.f17284a);     // Catch: Throwable -> L51
            int r15 = (int) (r14 % ((long) h.f17284a));     // Catch: Throwable -> L51
            if (r5.f17558a == r6) goto L21;
            n r7 = g.b(r9, r6, r5);     // Catch: Throwable -> L51
            if (r7 == null) goto L13;
            n r8 = r7;
        L22:
            n r11 = r8;
            n r16 = r8;
            Object r17 = g.a(r9, r11, r15, r14, (de) ZeusTransformUtils.preCheckCast(this, de.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L51
            if (r17 == h.k()) goto L25;
            if (r17 != h.j()) goto L36;
            if (r14 >= r9.d()) goto L34;
            r16.f();     // Catch: Throwable -> L51
        L34:
            r5 = r16;
            goto L13
        L36:
            if (r17 == h.l()) goto L42;
            r16.f();     // Catch: Throwable -> L51
            a(this, r17);     // Catch: Throwable -> L51
            a(this, null);     // Catch: Throwable -> L51
            r2 = Boxing.boxBoolean(true);     // Catch: Throwable -> L51
            Function1<E, Unit> r21 = r9.f17279b;     // Catch: Throwable -> L51
            if (r21 == null) goto L40;
            r12 = kotlinx.coroutines.internal.ab.b(r21, r17, r10.getContext());     // Catch: Throwable -> L51
            goto L40
        L42:
            throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L51
        L25:
            if (ZeusTransformUtils.instanceOf((de) ZeusTransformUtils.preCheckCast(this, de.class, "com.obric.memorydata.plugin"), de.class) == false) goto L27;
            r13 = (de) ZeusTransformUtils.preCheckCast(this, de.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L51
        L27:
            if (r13 == null) goto L47;
            g.b(r9, r13, r16, r15);     // Catch: Throwable -> L51
            goto L47
        L21:
            r8 = r5;
            goto L22
        L14:
            a(this);     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            r10.i();
            throw th;
        }

        public static final /* synthetic */ void a(a r0) {
            r0.d();
        }

        public static final /* synthetic */ void a(a r0, Object r1) {
            r0.f17281b = r1;
        }

        public static final /* synthetic */ void a(a r0, kotlinx.coroutines.o r1) {
            r0.c = r1;
        }

        private final boolean c() {
            this.f17281b = h.b();
            Throwable r1 = this.f17280a.m();
            if (r1 != null) goto L7;
            return false;
        L7:
            throw ai.a(r1);
        }

        private final void d() {
            kotlinx.coroutines.o<? super Boolean> r0 = this.c;
            Intrinsics.checkNotNull(r0);
            this.c = null;
            this.f17281b = h.b();
            Throwable r5 = this.f17280a.m();
            if (r5 != null) goto L5;
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r1 = Result.Companion;
            r6.resumeWith(Result.m1421constructorimpl(false));
            return;
        L5:
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            if (an.c() == true) goto L8;
        L11:
            Result.Companion r3 = Result.Companion;
            r2.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r5)));
            return;
        L8:
            if (ZeusTransformUtils.instanceOf((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class) == false) goto L11;
            r5 = ai.a(r5, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
            goto L11
        }

        @Override // kotlinx.coroutines.channels.k
        public E a() {
            E r0 = (E) this.f17281b;
            if (r0 == h.p()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L13;
            this.f17281b = h.p();
            if (r0 == h.b()) goto L11;
            return r0;
        L11:
            throw ai.a(g.a(this.f17280a));
        L13:
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        L5:
            r1 = false;
            goto L6
        }

        @Override // kotlinx.coroutines.channels.k
        public Object a(Continuation<? super Boolean> r15) {
            Continuation<? super Boolean> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
            g<E> r16 = this.f17280a;
            n<E> r0 = (n) ZeusTransformUtils.preCheckCast(g.u().get(r16), n.class, "com.obric.memorydata.plugin");
        L4:
            if (r16.q() == true) goto L5;
            long r5 = g.v().getAndIncrement(r16);
            long r1 = r5 / ((long) h.f17284a);
            int r4 = (int) (r5 % ((long) h.f17284a));
            if (r0.f17558a == r1) goto L13;
            n<E> r2 = g.b(r16, r1, r0);
            if (r2 == null) goto L4;
            r0 = r2;
        L13:
            Object r3 = g.a(r16, r0, r4, r5, null);
            if (r3 == h.k()) goto L27;
            if (r3 != h.j()) goto L21;
            if (r5 >= r16.d()) goto L4;
            r0.f();
            goto L4
        L21:
            if (r3 == h.l()) goto L23;
            r0.f();
            this.f17281b = r3;
            boolean r14 = true;
        L25:
            return Boxing.boxBoolean(r14);
        L23:
            return a(r0, r4, r5, r7);
        L27:
            throw new IllegalStateException("unreachable".toString());
        L5:
            r14 = c();
            goto L25
        }

        @Override // kotlinx.coroutines.de
        public void a(ag<?> r1, int r2) {
            kotlinx.coroutines.o<? super Boolean> r0 = this.c;
            if (r0 == null) goto L6;
            r0.a(r1, r2);
            return;
        }

        public final boolean a(E r5) {
            kotlinx.coroutines.o<? super Boolean> r0 = this.c;
            Intrinsics.checkNotNull(r0);
            Function1<Throwable, Unit> r1 = null;
            this.c = null;
            this.f17281b = r5;
            kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
            Function1<E, Unit> r4 = this.f17280a.f17279b;
            if (r4 == null) goto L6;
            r1 = kotlinx.coroutines.internal.ab.b(r4, r5, r0.getContext());
        L6:
            return h.a(r2, true, r1);
        }

        public final void b() {
            kotlinx.coroutines.o<? super Boolean> r0 = this.c;
            Intrinsics.checkNotNull(r0);
            this.c = null;
            this.f17281b = h.b();
            Throwable r5 = this.f17280a.m();
            if (r5 != null) goto L5;
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r1 = Result.Companion;
            r6.resumeWith(Result.m1421constructorimpl(false));
            return;
        L5:
            Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            if (an.c() == true) goto L8;
        L11:
            Result.Companion r3 = Result.Companion;
            r2.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r5)));
            return;
        L8:
            if (ZeusTransformUtils.instanceOf((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class) == false) goto L11;
            r5 = ai.a(r5, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class b implements de {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlinx.coroutines.n<Boolean> f17282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ kotlinx.coroutines.o<Boolean> f17283b;

        public b(kotlinx.coroutines.n<? super Boolean> r3) {
            kotlinx.coroutines.n<Boolean> r4 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
            this.f17282a = r4;
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f17283b = (kotlinx.coroutines.o) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.o.class, "com.obric.memorydata.plugin");
        }

        public final kotlinx.coroutines.n<Boolean> a() {
            return this.f17282a;
        }

        @Override // kotlinx.coroutines.de
        public void a(ag<?> r1, int r2) {
            this.f17283b.a(r1, r2);
        }
    }

    static {
        e = AtomicLongFieldUpdater.newUpdater(g.class, "sendersAndCloseStatus$volatile");
        f = AtomicLongFieldUpdater.newUpdater(g.class, "receivers$volatile");
        g = AtomicLongFieldUpdater.newUpdater(g.class, "bufferEnd$volatile");
        h = AtomicLongFieldUpdater.newUpdater(g.class, "completedExpandBuffersAndPauseFlag$volatile");
        i = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "sendSegment$volatile");
        j = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "receiveSegment$volatile");
        k = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "bufferEndSegment$volatile");
        l = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_closeCause$volatile");
        m = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "closeHandler$volatile");
    }

    public g(int r11, Function1<? super E, Unit> r12) {
        Function1<E, Unit> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        this.f17278a = r11;
        this.f17279b = r13;
        if (r11 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        this.bufferEnd$volatile = h.a(r11);
        this.completedExpandBuffersAndPauseFlag$volatile = a();
        n r14 = new n(0, null, this, 3);
        this.sendSegment$volatile = r14;
        this.receiveSegment$volatile = r14;
        if (b() == false) goto L10;
        r14 = h.c();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
    L10:
        this.bufferEndSegment$volatile = r14;
        if (r13 == null) goto L13;
        Function3<kotlinx.coroutines.selects.m<?>, Object, Object, Function1<Throwable, Unit>> r15 = (Function3) ZeusTransformUtils.preCheckCast(new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this), Function3.class, "com.obric.memorydata.plugin");
    L14:
        this.d = r15;
        this._closeCause$volatile = h.d();
        return;
    L13:
        r15 = null;
        goto L14
    L17:
        throw new IllegalArgumentException(("Invalid channel capacity: " + r11 + ", should be >=0").toString());
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ g(int r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        this(r2, r6);
    }

    private final void A() {
        AtomicLongFieldUpdater r6 = D();
    L3:
        long r2 = r6.get(this);
        if (((int) (r2 >> 60)) != 0) goto L7;
        if (r6.compareAndSet(this, r2, h.a(1152921504606846975L & r2, 1)) == false) goto L3;
        return;
    }

    private final void B() {
        isClosedForSend();
    }

    private final n<E> C() {
        Object r0 = J().get(this);
        n r1 = (n) ZeusTransformUtils.preCheckCast(H().get(this), n.class, "com.obric.memorydata.plugin");
        if (r1.f17558a <= ((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin")).f17558a) goto L5;
        r0 = r1;
    L5:
        n r8 = (n) ZeusTransformUtils.preCheckCast(I().get(this), n.class, "com.obric.memorydata.plugin");
        if (r8.f17558a <= ((n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin")).f17558a) goto L9;
        r0 = r8;
    L9:
        return (n) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.internal.e.a((kotlinx.coroutines.internal.f) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.internal.f.class, "com.obric.memorydata.plugin")), n.class, "com.obric.memorydata.plugin");
    }

    private static final /* synthetic */ AtomicLongFieldUpdater D() {
        return e;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater E() {
        return f;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater F() {
        return g;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater G() {
        return h;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater H() {
        return i;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater I() {
        return j;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater J() {
        return k;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater K() {
        return l;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater L() {
        return m;
    }

    public static final /* synthetic */ int a(g r0, n r1, int r2, Object r3, long r4, Object r6, boolean r7) {
        return r0.a(r1, r2, r3, r4, r6, r7);
    }

    private final int a(n<E> r4, int r5, E r6, long r7, Object r9, boolean r10) {
        r4.a(r5, r6);
        if (r10 == true) goto L5;
        Object r0 = r4.d(r5);
        if (r0 != null) goto L21;
        if (d(r7) == true) goto L11;
        if (r9 != null) goto L17;
        return 3;
    L17:
        if (r4.a(r5, null, r9) == false) goto L31;
        return 2;
    L31:
        return b(r4, r5, r6, r7, r9, r10);
    L11:
        if (r4.a(r5, null, h.f17285b) == false) goto L31;
        return 1;
    L21:
        if (ZeusTransformUtils.instanceOf(r0, de.class) == false) goto L31;
        r4.c(r5);
        if (a(r0, r6) == false) goto L26;
        r4.b(r5, h.f());
        h();
        return 0;
    L26:
        if (r4.c(r5, h.g()) == h.g()) goto L28;
        r4.a(r5, true);
    L28:
        return 5;
    L5:
        return b(r4, r5, r6, r7, r9, r10);
    }

    private final long a() {
        return F().get(this);
    }

    private final long a(n<E> r8) {
    L2:
        int r0 = h.f17284a;
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L20;
        long r3 = (r8.f17558a * ((long) h.f17284a)) + ((long) r0);
        if (r3 < e()) goto L7;
    L8:
        Object r1 = r8.d(r0);
        if (r1 == null) goto L17;
        if (r1 == h.h()) goto L17;
        if (r1 != h.f17285b) goto L3;
        return r3;
    L17:
        if (r8.a(r0, r1, h.b()) == false) goto L8;
        r8.l();
        goto L3
    L7:
        return -1;
    L20:
        r8 = (n) ZeusTransformUtils.preCheckCast(r8.e(), n.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L2;
        return -1;
    }

    public static final /* synthetic */ Object a(g r0, Object r1, Object r2) {
        return r0.b(r1, r2);
    }

    static /* synthetic */ <E> Object a(g<E> r16, E r17, Continuation<? super Unit> r18) {
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        n<E> r0 = (n) ZeusTransformUtils.preCheckCast(s().get(r16), n.class, "com.obric.memorydata.plugin");
    L3:
        long r1 = t().getAndIncrement(r16);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = a(r16, r1);
        long r2 = r11 / ((long) h.f17284a);
        int r14 = (int) (r11 % ((long) h.f17284a));
        if (r0.f17558a == r2) goto L12;
        n<E> r3 = a(r16, r2, r0);
        if (r3 == null) goto L7;
        n<E> r15 = r3;
    L13:
        int r4 = a(r16, r15, r14, r17, r11, null, r13);
        if (r4 == 0) goto L45;
        if (r4 == 1) goto L47;
        if (r4 == 2) goto L37;
        if (r4 == 3) goto L34;
        if (r4 == 4) goto L29;
        if (r4 != 5) goto L27;
        r15.f();
    L27:
        r0 = r15;
        goto L3
    L29:
        if (r11 >= r16.e()) goto L31;
        r15.f();
    L31:
        Object r5 = r16.b(r17, r10);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
        return r5;
    L34:
        Object r6 = r16.a(r15, r14, r17, r11, r10);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
        return r6;
    L37:
        if (r13 == false) goto L42;
        r15.l();
        Object r7 = r16.b(r17, r10);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
        return r7;
    L42:
        if (an.a() == false) goto L47;
        throw new AssertionError();
    L47:
        return Unit.INSTANCE;
    L45:
        r15.f();
        goto L47
    L7:
        if (r13 == false) goto L3;
        Object r8 = r16.b(r17, r10);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L47;
        return r8;
    L12:
        r15 = r0;
        goto L13
    }

    static /* synthetic */ <E> Object a(g<E> r11, Continuation<? super E> r12) {
        Continuation<? super E> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        n<E> r13 = (n) ZeusTransformUtils.preCheckCast(u().get(r11), n.class, "com.obric.memorydata.plugin");
    L4:
        if (r11.q() == true) goto L27;
        long r8 = v().getAndIncrement(r11);
        long r0 = r8 / ((long) h.f17284a);
        int r10 = (int) (r8 % ((long) h.f17284a));
        if (r13.f17558a == r0) goto L11;
        n<E> r1 = b(r11, r0, r13);
        if (r1 == null) goto L4;
        r13 = r1;
    L11:
        Object r2 = a(r11, r13, r10, r8, null);
        if (r2 == h.k()) goto L25;
        if (r2 != h.j()) goto L19;
        if (r8 >= r11.d()) goto L4;
        r13.f();
        goto L4
    L19:
        if (r2 == h.l()) goto L21;
        r13.f();
        return r2;
    L21:
        return r11.a(r13, r10, r8, r7);
    L25:
        throw new IllegalStateException("unexpected".toString());
    L27:
        throw ai.a(r11.w());
    }

    public static final /* synthetic */ Object a(g r0, n r1, int r2, long r3, Object r5) {
        return r0.a(r1, r2, r3, r5);
    }

    public static final /* synthetic */ Object a(g r6, n r7, int r8, long r9, Continuation r11) {
        return r6.b(r7, r8, r9, (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(n<E> r6, int r7, long r8, Object r10) {
        Object r0 = r6.d(r7);
        if (r0 != null) goto L14;
        if (r8 < (D().get(this) & 1152921504606846975L)) goto L20;
        if (r10 != null) goto L10;
        return h.l();
    L10:
        if (r6.a(r7, r0, r10) == false) goto L20;
        c();
        return h.k();
    L20:
        return b(r6, r7, r8, r10);
    L14:
        if (r0 != h.f17285b) goto L20;
        if (r6.a(r7, r0, h.f()) == false) goto L20;
        c();
        return r6.b(r7);
    }

    private final Object a(n<E> r11, int r12, long r13, Continuation<? super E> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r0 = kotlinx.coroutines.q.a(IntrinsicsKt.intercepted(r16));
        Object r2 = a(this, r11, r12, r13, (de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49
        if (r2 != h.k()) goto L6;
        b(this, (de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin"), r11, r12);     // Catch: Throwable -> L49
    L45:
        Object r10 = r0.h();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L48;
        DebugProbesKt.probeCoroutineSuspended(r16);
    L48:
        return r10;
    L6:
        Function1<Throwable, Unit> r3 = null;
        r3 = null;
        de r4 = null;
        if (r2 == h.j()) goto L9;
        r11.f();     // Catch: Throwable -> L49
        Function1<E, Unit> r14 = this.f17279b;     // Catch: Throwable -> L49
        if (r14 != null) goto L43;
    L38:
        r0.a(r2, r3);     // Catch: Throwable -> L49
        goto L45
    L43:
        r3 = kotlinx.coroutines.internal.ab.b(r14, r2, r0.getContext());     // Catch: Throwable -> L49
        goto L38
    L9:
        if (r13 >= d()) goto L11;
        r11.f();     // Catch: Throwable -> L49
    L11:
        n r17 = (n) ZeusTransformUtils.preCheckCast(u().get(this), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
    L13:
        if (q() == true) goto L14;
        long r18 = v().getAndIncrement(this);     // Catch: Throwable -> L49
        long r5 = r18 / ((long) h.f17284a);     // Catch: Throwable -> L49
        int r19 = (int) (r18 % ((long) h.f17284a));     // Catch: Throwable -> L49
        if (r17.f17558a == r5) goto L21;
        n r6 = b(this, r5, r17);     // Catch: Throwable -> L49
        if (r6 == null) goto L13;
        r17 = r6;
    L21:
        n r7 = r17;
        r2 = a(this, r7, r19, r18, (de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49
        if (r2 == h.k()) goto L24;
        if (r2 != h.j()) goto L34;
        if (r18 >= d()) goto L13;
        r17.f();     // Catch: Throwable -> L49
        goto L13
    L34:
        if (r2 == h.l()) goto L40;
        r17.f();     // Catch: Throwable -> L49
        Function1<E, Unit> r110 = this.f17279b;     // Catch: Throwable -> L49
        if (r110 == null) goto L38;
        r3 = kotlinx.coroutines.internal.ab.b(r110, r2, r0.getContext());     // Catch: Throwable -> L49
        goto L38
    L40:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L49
    L24:
        if (ZeusTransformUtils.instanceOf((de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin"), de.class) == false) goto L26;
        r4 = (de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
    L26:
        if (r4 == null) goto L45;
        b(this, r4, r17, r19);     // Catch: Throwable -> L49
        goto L45
    L14:
        a(this, (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r0.i();
        throw th;
    }

    private final Object a(n<E> r23, int r24, E r25, long r26, Continuation<? super Unit> r28) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r28, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r12 = kotlinx.coroutines.q.a(IntrinsicsKt.intercepted(r11));
        int r1 = a(this, r23, r24, r25, r26, (de) ZeusTransformUtils.preCheckCast(r12, de.class, "com.obric.memorydata.plugin"), false);     // Catch: Throwable -> L70
        if (r1 != 0) goto L6;
        r23.f();     // Catch: Throwable -> L70
        Continuation r0 = (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L70
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
    L50:
        r0.resumeWith(r3);     // Catch: Throwable -> L70
    L62:
        Object r4 = r12.h();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L66;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L66:
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L69;
        return r4;
    L69:
        return Unit.INSTANCE;
    L6:
        if (r1 != 1) goto L8;
        r0 = (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L70
        r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
        goto L50
    L8:
        if (r1 != 2) goto L10;
        a(this, (de) ZeusTransformUtils.preCheckCast(r12, de.class, "com.obric.memorydata.plugin"), r23, r24);     // Catch: Throwable -> L70
        goto L62
    L10:
        if (r1 == 4) goto L55;
        if (r1 != 5) goto L53;
        r23.f();     // Catch: Throwable -> L70
        n r6 = (n) ZeusTransformUtils.preCheckCast(s().get(this), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
    L14:
        long r7 = t().getAndIncrement(this);     // Catch: Throwable -> L70
        long r17 = r7 & 1152921504606846975L;     // Catch: Throwable -> L70
        boolean r19 = a(this, r7);     // Catch: Throwable -> L70
        long r8 = r17 / ((long) h.f17284a);     // Catch: Throwable -> L70
        int r9 = (int) (r17 % ((long) h.f17284a));     // Catch: Throwable -> L70
        if (r6.f17558a == r8) goto L22;
        n r10 = a(this, r8, r6);     // Catch: Throwable -> L70
        if (r10 == null) goto L18;
        n r13 = r10;
    L23:
        n r14 = r13;
        n r27 = r13;
        int r15 = a(this, r14, r9, r25, r17, (de) ZeusTransformUtils.preCheckCast(r12, de.class, "com.obric.memorydata.plugin"), r19);     // Catch: Throwable -> L70
        if (r15 == 0) goto L51;
        if (r15 == 1) goto L49;
        if (r15 == 2) goto L41;
        if (r15 == 3) goto L40;
        if (r15 == 4) goto L36;
        if (r15 != 5) goto L34;
        r27.f();     // Catch: Throwable -> L70
    L34:
        r6 = r27;
        goto L14
    L36:
        if (r17 >= e()) goto L38;
        r27.f();     // Catch: Throwable -> L70
    L38:
        kotlinx.coroutines.n r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
    L20:
        a(this, r25, r16);     // Catch: Throwable -> L70
        goto L62
    L40:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L70
    L41:
        if (r19 == false) goto L44;
        r27.l();     // Catch: Throwable -> L70
        r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        goto L20
    L44:
        if (ZeusTransformUtils.instanceOf((de) ZeusTransformUtils.preCheckCast(r12, de.class, "com.obric.memorydata.plugin"), de.class) == false) goto L46;
        de r18 = (de) ZeusTransformUtils.preCheckCast(r12, de.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
    L47:
        if (r18 == null) goto L62;
        a(this, r18, r27, r9);     // Catch: Throwable -> L70
        goto L62
    L46:
        r18 = null;
        goto L47
    L49:
        r0 = (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L70
        r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
        goto L50
    L51:
        r27.f();     // Catch: Throwable -> L70
        r0 = (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L70
        r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L70
        goto L50
    L18:
        if (r19 == false) goto L14;
        r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        goto L20
    L22:
        r13 = r6;
        goto L23
    L53:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L70
    L55:
        if (r26 >= e()) goto L57;
        r23.f();     // Catch: Throwable -> L70
    L57:
        r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        r12.i();
        throw th;
    }

    public static final /* synthetic */ Throwable a(g r0) {
        return r0.w();
    }

    private final n<E> a(long r13, n<E> r15) {
        AtomicReferenceFieldUpdater r0 = H();
        Function2 r1 = (Function2) ZeusTransformUtils.preCheckCast(h.a(), Function2.class, "com.obric.memorydata.plugin");
    L3:
        Object r2 = kotlinx.coroutines.internal.e.a((ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin"), r13, r1);
        boolean r5 = false;
        if (ah.a(r2) == true) goto L23;
        ag r4 = ah.b(r2);
    L6:
        ag r7 = (ag) ZeusTransformUtils.preCheckCast(r0.get(this), ag.class, "com.obric.memorydata.plugin");
        if (r7.f17558a >= r4.f17558a) goto L8;
        if (r4.j() == false) goto L11;
        if (r0.compareAndSet(this, r7, r4) == true) goto L15;
        if (r4.k() == false) goto L6;
        r4.i();
        goto L6
    L15:
        if (r7.k() == false) goto L8;
        r7.i();
        goto L8
    L11:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L3;
    L8:
        r6 = true;
    L23:
        if (ah.a(r2) == false) goto L27;
        B();
        if ((r15.f17558a * ((long) h.f17284a)) >= e()) goto L55;
    L26:
        r15.f();
        return null;
    L55:
        return null;
    L27:
        r15 = (n) ZeusTransformUtils.preCheckCast(ah.b(r2), n.class, "com.obric.memorydata.plugin");
        if (r15.f17558a <= r13) goto L33;
        j(r15.f17558a * ((long) h.f17284a));
        if ((r15.f17558a * ((long) h.f17284a)) < e()) goto L26;
        return null;
    L33:
        if (an.a() == false) goto L42;
        if (r15.f17558a != r13) goto L37;
        r5 = true;
    L37:
        if (r5 == true) goto L42;
        throw new AssertionError();
    L42:
        return r15;
    }

    private final n<E> a(long r17, n<E> r19, long r20) {
        AtomicReferenceFieldUpdater r2 = J();
        Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(h.a(), Function2.class, "com.obric.memorydata.plugin");
    L3:
        Object r4 = kotlinx.coroutines.internal.e.a((ag) ZeusTransformUtils.preCheckCast(r19, ag.class, "com.obric.memorydata.plugin"), r17, r3);
        boolean r9 = false;
        if (ah.a(r4) == true) goto L23;
        ag r8 = ah.b(r4);
    L6:
        ag r11 = (ag) ZeusTransformUtils.preCheckCast(r2.get(this), ag.class, "com.obric.memorydata.plugin");
        if (r11.f17558a >= r8.f17558a) goto L8;
        if (r8.j() == false) goto L11;
        if (r2.compareAndSet(this, r11, r8) == true) goto L15;
        if (r8.k() == false) goto L6;
        r8.i();
        goto L6
    L15:
        if (r11.k() == false) goto L8;
        r11.i();
        goto L8
    L11:
        boolean r10 = false;
    L17:
        if (r10 == false) goto L3;
    L8:
        r10 = true;
    L23:
        if (ah.a(r4) == false) goto L26;
        B();
        c(r17, r19);
    L25:
        a(this, 0, 1, null);
        return null;
    L26:
        n<E> r7 = (n) ZeusTransformUtils.preCheckCast(ah.b(r4), n.class, "com.obric.memorydata.plugin");
        if (r7.f17558a <= r17) goto L32;
        if (F().compareAndSet(this, r20 + 1, r7.f17558a * ((long) h.f17284a)) == false) goto L25;
        e((r7.f17558a * ((long) h.f17284a)) - r20);
        return null;
    L32:
        if (an.a() == false) goto L41;
        if (r7.f17558a != r17) goto L36;
        r9 = true;
    L36:
        if (r9 == true) goto L41;
        throw new AssertionError();
    L41:
        return r7;
    }

    public static final /* synthetic */ n a(g r0, long r1, n r3) {
        return r0.a(r1, r3);
    }

    private final void a(E r4, kotlinx.coroutines.n<? super Unit> r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Function1<E, Unit> r0 = this.f17279b;
        if (r0 == null) goto L5;
        kotlinx.coroutines.internal.ab.a(r0, r4, r6.getContext());
    L5:
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin");
        Throwable r3 = n();
        if (an.c() == true) goto L8;
    L11:
        Result.Companion r8 = Result.Companion;
        r7.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r3)));
        return;
    L8:
        if (ZeusTransformUtils.instanceOf((Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class) == false) goto L11;
        r3 = ai.a(r3, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast((Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"), CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
        goto L11
    }

    private final void a(E r3, kotlinx.coroutines.selects.m<?> r4) {
        kotlinx.coroutines.selects.m r5 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        Function1<E, Unit> r2 = this.f17279b;
        if (r2 == null) goto L5;
        kotlinx.coroutines.internal.ab.a(r2, r3, r5.getContext());
    L5:
        r5.a(h.b());
    }

    static /* synthetic */ void a(g r0, long r1, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        r0.e(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    public static final /* synthetic */ void a(g r2, Object r3, kotlinx.coroutines.n r4) {
        r2.a(r3, (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(g r2, de r3, n r4, int r5) {
        r2.a((de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static final /* synthetic */ void a(g r2, kotlinx.coroutines.n r3) {
        r2.a((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(g r2, kotlinx.coroutines.selects.m r3, Object r4) {
        r2.b((kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(n<E> r10, long r11) {
        Object r0 = kotlinx.coroutines.internal.q.a(null, 1, null);
    L4:
        if (r10 == null) goto L30;
        int r4 = h.f17284a - 1;
    L6:
        if ((-1) >= r4) goto L29;
        if (((r10.f17558a * ((long) h.f17284a)) + ((long) r4)) < r11) goto L30;
    L9:
        Object r5 = r10.d(r4);
        if (r5 == null) goto L26;
        if (r5 == h.h()) goto L26;
        if (ZeusTransformUtils.instanceOf(r5, ab.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r5, de.class) == false) goto L28;
        if (r10.a(r4, r5, h.b()) == false) goto L9;
    L19:
        r0 = kotlinx.coroutines.internal.q.a(r0, r5);
        r10.a(r4, true);
    L28:
        r4 = r4 - 1;
        goto L6
    L17:
        if (r10.a(r4, r5, h.b()) == false) goto L9;
        r5 = ((ab) ZeusTransformUtils.preCheckCast(r5, ab.class, "com.obric.memorydata.plugin")).f17273a;
    L26:
        if (r10.a(r4, r5, h.b()) == false) goto L9;
        r10.l();
        goto L28
    L29:
        r10 = (n) ZeusTransformUtils.preCheckCast(r10.e(), n.class, "com.obric.memorydata.plugin");
    L30:
        if (r0 != null) goto L32;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r0, ArrayList.class) == true) goto L34;
        a((de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin"));
        return;
    L34:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r12 = (ArrayList) ZeusTransformUtils.preCheckCast(r0, ArrayList.class, "com.obric.memorydata.plugin");
        int r13 = r12.size() - 1;
    L35:
        if ((-1) >= r13) goto L58;
        a((de) ZeusTransformUtils.preCheckCast(r12.get(r13), de.class, "com.obric.memorydata.plugin"));
        r13 = r13 - 1;
        goto L35
    }

    private final void a(de r3) {
        a((de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin"), true);
    }

    private final void a(de r2, n<E> r3, int r4) {
        ((de) ZeusTransformUtils.wrapperContextForParams(r2, de.class, "com.obric.memorydata.plugin")).a((ag) ZeusTransformUtils.preCheckCast(r3, ag.class, "com.obric.memorydata.plugin"), r4 + h.f17284a);
    }

    private final void a(de r3, boolean r4) {
        de r5 = (de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L6;
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).a(), Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r6 = Result.Companion;
        r2.resumeWith(Result.m1421constructorimpl(false));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.n.class) == false) goto L13;
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;
        if (r4 == false) goto L10;
        Throwable r8 = w();
    L11:
        Object r9 = ResultKt.createFailure(r8);
    L15:
        r7.resumeWith(Result.m1421constructorimpl(r9));
        return;
    L10:
        r8 = n();
        goto L11
    L13:
        if (ZeusTransformUtils.instanceOf(r5, x.class) == false) goto L17;
        r7 = (Continuation) ZeusTransformUtils.preCheckCast(((x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin")).f17295a, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r10 = Result.Companion;
        r9 = m.i(m.f17289a.a(m()));
        goto L15
    L17:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L20;
        ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).b();
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.selects.m.class) == false) goto L24;
        ((kotlinx.coroutines.selects.m) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin")).a(this, h.b());
        return;
    L24:
        throw new IllegalStateException(("Unexpected waiter: " + r5).toString());
    }

    private final void a(kotlinx.coroutines.n<? super E> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;
        r4.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(w())));
    }

    private final void a(kotlinx.coroutines.selects.m<?> r2) {
        ((kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin")).a(h.b());
    }

    private final boolean a(long r7, boolean r9) {
        int r0 = (int) (r7 >> 60);
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L6;
        return false;
    L6:
        if (r0 != 2) goto L8;
        f(r7 & 1152921504606846975L);
        if (r9 == true) goto L16;
    L20:
        return true;
    L16:
        if (r() == false) goto L20;
        return false;
    L8:
        if (r0 != 3) goto L12;
        g(r7 & 1152921504606846975L);
        goto L20
    L12:
        throw new IllegalStateException(("unexpected close status: " + r0).toString());
    L18:
        return false;
    }

    private final boolean a(Object r5, E r6) {
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.selects.m.class) == true) goto L23;
        Function1<Throwable, Unit> r2 = null;
        if (ZeusTransformUtils.instanceOf(r5, x.class) == false) goto L12;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
        x r0 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.n r1 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(((x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin")).f17295a, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        m r3 = m.i(m.f17289a.a(r6));
        Function1<E, Unit> r4 = this.f17279b;
        if (r4 == null) goto L24;
        r2 = kotlinx.coroutines.internal.ab.b(r4, r6, ((x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.memorydata.plugin")).f17295a.getContext());
    L24:
        return h.a(r1, r3, r2);
    L12:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L15;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        a r7 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        return ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).a(r6);
    L15:
        if (ZeusTransformUtils.instanceOf(r5, kotlinx.coroutines.n.class) == false) goto L22;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        kotlinx.coroutines.n r8 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.n r9 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Function1<E, Unit> r10 = this.f17279b;
        if (r10 == null) goto L20;
        r2 = kotlinx.coroutines.internal.ab.b(r10, r6, ((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin")).getContext());
    L20:
        return h.a(r9, r6, r2);
    L22:
        throw new IllegalStateException(("Unexpected receiver type: " + r5).toString());
    L23:
        return ((kotlinx.coroutines.selects.m) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin")).a(this, r6);
    }

    private final boolean a(Object r6, n<E> r7, int r8) {
        if (ZeusTransformUtils.instanceOf(r6, kotlinx.coroutines.n.class) == false) goto L7;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        kotlinx.coroutines.n r5 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.n<Boolean> r9 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Object r10 = Unit.INSTANCE;
    L18:
        return h.a(r9, r10, null, 2, null);
    L7:
        if (ZeusTransformUtils.instanceOf(r6, kotlinx.coroutines.selects.m.class) == false) goto L16;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        kotlinx.coroutines.selects.l r0 = (kotlinx.coroutines.selects.l) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.selects.l.class, "com.obric.memorydata.plugin");
        TrySelectDetailedResult r11 = ((kotlinx.coroutines.selects.l) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.selects.l.class, "com.obric.memorydata.plugin")).b(this, Unit.INSTANCE);
        if (r11 != TrySelectDetailedResult.REREGISTER) goto L12;
        r7.c(r8);
    L12:
        if (r11 == TrySelectDetailedResult.SUCCESSFUL) goto L22;
        return false;
    L22:
        return true;
    L16:
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L20;
        r9 = ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin")).a();
        r10 = true;
        goto L18
    L20:
        throw new IllegalStateException(("Unexpected waiter: " + r6).toString());
    }

    public static final /* synthetic */ boolean a(g r0, long r1) {
        return r0.h(r1);
    }

    private final boolean a(n<E> r4, int r5, long r6) {
        Object r0 = r4.d(r5);
        if (ZeusTransformUtils.instanceOf(r0, de.class) == false) goto L14;
        if (r6 < E().get(this)) goto L14;
        if (r4.a(r5, r0, h.m()) == false) goto L14;
        if (a(r0, r4, r5) == false) goto L11;
        r4.b(r5, h.f17285b);
        return true;
    L11:
        r4.b(r5, h.e());
        r4.a(r5, false);
        return false;
    L14:
        return b(r4, r5, r6);
    }

    private final int b(n<E> r6, int r7, E r8, long r9, Object r11, boolean r12) {
    L2:
        Object r0 = r6.d(r7);
        if (r0 == null) goto L5;
        if (r0 != h.h()) goto L28;
        if (r6.a(r7, r0, h.f17285b) == false) goto L2;
        return 1;
    L28:
        if (r0 != h.g()) goto L32;
        r6.c(r7);
        return 5;
    L32:
        if (r0 != h.i()) goto L36;
        r6.c(r7);
        return 5;
    L36:
        if (r0 != h.b()) goto L40;
        r6.c(r7);
        B();
        return 4;
    L40:
        if (an.a() == true) goto L42;
    L52:
        r6.c(r7);
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L56;
        r0 = ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.memorydata.plugin")).f17273a;
    L56:
        if (a(r0, r8) == false) goto L59;
        r6.b(r7, h.f());
        h();
        return 0;
    L59:
        if (r6.c(r7, h.g()) == h.g()) goto L62;
        r6.a(r7, true);
    L62:
        return 5;
    L42:
        if (ZeusTransformUtils.instanceOf(r0, de.class) == false) goto L44;
    L47:
        boolean r10 = true;
    L48:
        if (r10 == true) goto L52;
        throw new AssertionError();
    L44:
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == true) goto L47;
        r10 = false;
        goto L48
    L5:
        if (d(r9) == false) goto L10;
        if (r12 == true) goto L10;
        if (r6.a(r7, null, h.f17285b) == false) goto L2;
        return 1;
    L10:
        if (r12 == true) goto L12;
        if (r11 == null) goto L16;
        if (r6.a(r7, null, r11) == false) goto L2;
        return 2;
    L16:
        return 3;
    L12:
        if (r6.a(r7, null, h.e()) == false) goto L2;
        r6.a(r7, false);
        return 4;
    }

    private final Object b(Object r1, Object r2) {
        if (r2 == h.b()) goto L6;
        return this;
    L6:
        throw n();
    }

    private final Object b(E r7, Continuation<? super Unit> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r0 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r9), 1);
        r0.e();
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        Function1<E, Unit> r3 = this.f17279b;
        if (r3 == null) goto L14;
        UndeliveredElementException r10 = kotlinx.coroutines.internal.ab.a(r3, r7, null, 2, null);
        if (r10 == null) goto L14;
        ExceptionsKt.addSuppressed((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin"), n());
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r4 = Result.Companion;
        if (an.c() == true) goto L9;
    L12:
        Throwable r11 = (Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin");
    L13:
        r6.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r11)));
    L21:
        Object r12 = r0.h();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L25:
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        return r12;
    L28:
        return Unit.INSTANCE;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, CoroutineStackFrame.class) == false) goto L12;
        r11 = ai.a((Throwable) ZeusTransformUtils.preCheckCast(r10, Throwable.class, "com.obric.memorydata.plugin"), (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r6, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
    L14:
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Throwable r14 = n();
        Result.Companion r5 = Result.Companion;
        if (an.c() == true) goto L17;
    L20:
        r13.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure(r14)));
        goto L21
    L17:
        if (ZeusTransformUtils.instanceOf(r13, CoroutineStackFrame.class) == false) goto L20;
        r14 = ai.a(r14, (CoroutineStackFrame) ZeusTransformUtils.preCheckCast(r13, CoroutineStackFrame.class, "com.obric.memorydata.plugin"));
        goto L20
    }

    public static final /* synthetic */ Object b(g r0, Object r1, Object r2) {
        return r0.c(r1, r2);
    }

    static /* synthetic */ <E> Object b(g<E> r20, E r21, Continuation<? super Boolean> r22) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.o r11 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r10), 1);
        r11.e();
        kotlinx.coroutines.n r13 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        if (r20.f17279b != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L52;
        b r15 = new b(r13);
        n r1 = (n) ZeusTransformUtils.preCheckCast(s().get(r20), n.class, "com.obric.memorydata.plugin");
    L8:
        long r2 = t().getAndIncrement(r20);
        long r16 = r2 & 1152921504606846975L;
        boolean r18 = a(r20, r2);
        long r3 = r16 / ((long) h.f17284a);
        int r7 = (int) (r16 % ((long) h.f17284a));
        if (r1.f17558a == r3) goto L15;
        n r4 = a(r20, r3, r1);
        if (r4 == null) goto L12;
        n r6 = r4;
    L16:
        n r23 = r6;
        int r5 = a(r20, r6, r7, r21, r16, r15, r18);
        if (r5 == 0) goto L44;
        if (r5 == 1) goto L45;
        if (r5 == 2) goto L35;
        if (r5 == 3) goto L34;
        if (r5 == 4) goto L31;
        if (r5 != 5) goto L29;
        r23.f();
    L29:
        r1 = r23;
        goto L8
    L31:
        if (r16 >= r20.e()) goto L37;
        r23.f();
    L37:
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r9 = Result.Companion;
        Boolean r12 = Boxing.boxBoolean(false);
    L46:
        r8.resumeWith(Result.m1421constructorimpl(r12));
    L47:
        Object r14 = r11.h();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L50:
        return r14;
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r18 == false) goto L39;
        r23.l();
        goto L37
    L39:
        if (ZeusTransformUtils.instanceOf(r15, de.class) == false) goto L41;
        de r17 = (de) ZeusTransformUtils.preCheckCast(r15, de.class, "com.obric.memorydata.plugin");
    L42:
        if (r17 == null) goto L47;
        a(r20, r17, r23, r7);
        goto L47
    L41:
        r17 = null;
    L45:
        r8 = (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r19 = Result.Companion;
        r12 = Boxing.boxBoolean(true);
        goto L46
    L44:
        r23.f();
        goto L45
    L12:
        if (r18 == false) goto L8;
    L15:
        r6 = r1;
        goto L16
    L52:
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ <E> Object b(g<E> r14, Continuation<? super m<? extends E>> r15) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, BufferedChannel$receiveCatching$1.class) == false) goto L7;
        BufferedChannel$receiveCatching$1 r0 = (BufferedChannel$receiveCatching$1) ZeusTransformUtils.preCheckCast(r16, BufferedChannel$receiveCatching$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        BufferedChannel$receiveCatching$1 r7 = r0;
        Object r17 = r7.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r7.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r17);
        return ((m) ZeusTransformUtils.preCheckCast(r17, m.class, "com.obric.memorydata.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r17);
        n<E> r3 = (n) ZeusTransformUtils.preCheckCast(u().get(r14), n.class, "com.obric.memorydata.plugin");
    L16:
        if (r14.q() == true) goto L51;
        long r5 = v().getAndIncrement(r14);
        long r8 = r5 / ((long) h.f17284a);
        int r4 = (int) (r5 % ((long) h.f17284a));
        if (r3.f17558a == r8) goto L24;
        n<E> r6 = b(r14, r8, r3);
        if (r6 == null) goto L16;
        r3 = r6;
    L24:
        Object r9 = a(r14, r3, r4, r5, null);
        if (r9 == h.k()) goto L39;
        if (r9 != h.j()) goto L32;
        if (r5 >= r14.d()) goto L16;
        r3.f();
        goto L16
    L32:
        if (r9 != h.l()) goto L36;
        r7.label = 1;
        Object r18 = r14.b(r3, r4, r5, r7);
        if (r18 != r1) goto L52;
        return r1;
    L52:
        return r18;
    L36:
        r3.f();
        return m.f17289a.a(r9);
    L39:
        throw new IllegalStateException("unexpected".toString());
    L51:
        return m.f17289a.a(r14.m());
    L7:
        r0 = new BufferedChannel$receiveCatching$1(r14, r16);
        goto L8
    }

    private final Object b(n<E> r6, int r7, long r8, Object r10) {
    L2:
        Object r0 = r6.d(r7);
        if (r0 == null) goto L41;
        if (r0 == h.h()) goto L41;
        if (r0 == h.f17285b) goto L10;
        if (r0 == h.e()) goto L16;
        if (r0 == h.i()) goto L20;
        if (r0 == h.b()) goto L23;
        if (r0 == h.m()) goto L2;
        if (r6.a(r7, r0, h.n()) == false) goto L2;
        boolean r9 = ZeusTransformUtils.instanceOf(r0, ab.class);
        if (ZeusTransformUtils.instanceOf(r0, ab.class) == false) goto L33;
        r0 = ((ab) ZeusTransformUtils.preCheckCast(r0, ab.class, "com.obric.memorydata.plugin")).f17273a;
    L33:
        if (a(r0, r6, r7) == false) goto L35;
        r6.b(r7, h.f());
        c();
        return r6.b(r7);
    L35:
        r6.b(r7, h.e());
        r6.a(r7, false);
        if (r9 == false) goto L39;
        c();
    L39:
        return h.j();
    L23:
        c();
        return h.j();
    L20:
        return h.j();
    L16:
        return h.j();
    L10:
        if (r6.a(r7, r0, h.f()) == false) goto L2;
        c();
        return r6.b(r7);
    L41:
        if (r8 < (D().get(this) & 1152921504606846975L)) goto L43;
        if (r10 == null) goto L48;
        if (r6.a(r7, r0, r10) == false) goto L2;
        c();
        return h.k();
    L48:
        return h.l();
    L43:
        if (r6.a(r7, r0, h.i()) == false) goto L2;
        c();
        return h.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object b(n<E> r18, int r19, long r20, Continuation<? super m<? extends E>> r22) {
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, BufferedChannel$receiveCatchingOnNoWaiterSuspend$1.class) == false) goto L7;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r2 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) ZeusTransformUtils.preCheckCast(r1, BufferedChannel$receiveCatchingOnNoWaiterSuspend$1.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r12 = r2;
        Object r3 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r12.J$0;
        int r0 = r12.I$0;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r12.L$1, n.class, "com.obric.memorydata.plugin");
        g r7 = (g) ZeusTransformUtils.preCheckCast(r12.L$0, g.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
    L68:
        return ((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin")).a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        r12.L$0 = this;
        r12.L$1 = r18;
        r12.I$0 = r19;
        r12.J$0 = r20;
        r12.label = 1;
        kotlinx.coroutines.o r14 = kotlinx.coroutines.q.a(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin")));
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");     // Catch: Throwable -> L69
        x r15 = new x(r14);     // Catch: Throwable -> L69
        Object r8 = a(this, r18, r19, r20, (de) ZeusTransformUtils.preCheckCast(r15, de.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L69
        if (r8 != h.k()) goto L19;
        b(this, (de) ZeusTransformUtils.preCheckCast(r15, de.class, "com.obric.memorydata.plugin"), r18, r19);     // Catch: Throwable -> L69
    L62:
        r3 = r14.h();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin"));
    L65:
        if (r3 != r13) goto L68;
        return r13;
    L19:
        if (r8 == h.j()) goto L21;
        r18.f();     // Catch: Throwable -> L69
        m r9 = m.i(m.f17289a.a(r8));     // Catch: Throwable -> L69
        Function1<E, Unit> r10 = this.f17279b;     // Catch: Throwable -> L69
        if (r10 == null) goto L61;
        Function1<Throwable, Unit> r11 = kotlinx.coroutines.internal.ab.b(r10, r8, r14.getContext());     // Catch: Throwable -> L69
    L54:
        r14.a(r9, r11);     // Catch: Throwable -> L69
        goto L62
    L61:
        r11 = null;
        goto L54
    L21:
        if (r20 >= d()) goto L23;
        r18.f();     // Catch: Throwable -> L69
    L23:
        n r16 = (n) ZeusTransformUtils.preCheckCast(u().get(this), n.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
    L25:
        if (q() == true) goto L26;
        long r17 = v().getAndIncrement(this);     // Catch: Throwable -> L69
        long r21 = r17 / ((long) h.f17284a);     // Catch: Throwable -> L69
        int r23 = (int) (r17 % ((long) h.f17284a));     // Catch: Throwable -> L69
        if (r16.f17558a == r21) goto L33;
        n r24 = b(this, r21, r16);     // Catch: Throwable -> L69
        if (r24 == null) goto L25;
        n r25 = r24;
    L34:
        n r26 = r25;
        Object r27 = a(this, r25, r23, r17, (de) ZeusTransformUtils.preCheckCast(r15, de.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L69
        if (r27 == h.k()) goto L37;
        if (r27 != h.j()) goto L49;
        if (r17 >= d()) goto L47;
        r26.f();     // Catch: Throwable -> L69
    L47:
        r16 = r26;
        goto L25
    L49:
        if (r27 == h.l()) goto L56;
        r26.f();     // Catch: Throwable -> L69
        r9 = m.i(m.f17289a.a(r27));     // Catch: Throwable -> L69
        Function1<E, Unit> r28 = this.f17279b;     // Catch: Throwable -> L69
        if (r28 == null) goto L53;
        r11 = kotlinx.coroutines.internal.ab.b(r28, r27, r14.getContext());     // Catch: Throwable -> L69
        goto L54
    L53:
        r11 = null;
        goto L54
    L56:
        throw new IllegalStateException("unexpected".toString());     // Catch: Throwable -> L69
    L37:
        if (ZeusTransformUtils.instanceOf((de) ZeusTransformUtils.preCheckCast(r15, de.class, "com.obric.memorydata.plugin"), de.class) == false) goto L39;
        de r29 = (de) ZeusTransformUtils.preCheckCast(r15, de.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L69
    L40:
        if (r29 == null) goto L62;
        b(this, r29, r26, r23);     // Catch: Throwable -> L69
        goto L62
    L39:
        r29 = null;
        goto L40
    L33:
        r25 = r16;
        goto L34
    L26:
        b(this, (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r14, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r14.i();
        throw th;
    L7:
        r2 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, r1);
        goto L8
    }

    private final n<E> b(long r13, n<E> r15) {
        AtomicReferenceFieldUpdater r0 = I();
        Function2 r1 = (Function2) ZeusTransformUtils.preCheckCast(h.a(), Function2.class, "com.obric.memorydata.plugin");
    L3:
        Object r2 = kotlinx.coroutines.internal.e.a((ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin"), r13, r1);
        boolean r5 = false;
        if (ah.a(r2) == true) goto L23;
        ag r4 = ah.b(r2);
    L6:
        ag r7 = (ag) ZeusTransformUtils.preCheckCast(r0.get(this), ag.class, "com.obric.memorydata.plugin");
        if (r7.f17558a >= r4.f17558a) goto L8;
        if (r4.j() == false) goto L11;
        if (r0.compareAndSet(this, r7, r4) == true) goto L15;
        if (r4.k() == false) goto L6;
        r4.i();
        goto L6
    L15:
        if (r7.k() == false) goto L8;
        r7.i();
        goto L8
    L11:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L3;
    L8:
        r6 = true;
    L23:
        if (ah.a(r2) == false) goto L27;
        B();
        if ((r15.f17558a * ((long) h.f17284a)) >= d()) goto L79;
    L26:
        r15.f();
        return null;
    L79:
        return null;
    L27:
        r15 = (n) ZeusTransformUtils.preCheckCast(ah.b(r2), n.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L45;
        if (r13 > (a() / ((long) h.f17284a))) goto L45;
        AtomicReferenceFieldUpdater r3 = J();
    L32:
        ag r8 = (ag) ZeusTransformUtils.preCheckCast(r3.get(this), ag.class, "com.obric.memorydata.plugin");
        if (r8.f17558a >= ((ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin")).f17558a) goto L45;
        if (((ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin")).j() == false) goto L45;
        if (r3.compareAndSet(this, r8, (ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin")) == true) goto L39;
        if (((ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin")).k() == false) goto L32;
        ((ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.memorydata.plugin")).i();
        goto L32
    L39:
        if (r8.k() == false) goto L45;
        r8.i();
    L45:
        if (r15.f17558a <= r13) goto L50;
        k(r15.f17558a * ((long) h.f17284a));
        if ((r15.f17558a * ((long) h.f17284a)) < d()) goto L26;
        return null;
    L50:
        if (an.a() == false) goto L59;
        if (r15.f17558a != r13) goto L54;
        r5 = true;
    L54:
        if (r5 == true) goto L59;
        throw new AssertionError();
    L59:
        return r15;
    }

    public static final /* synthetic */ n b(g r0, long r1, n r3) {
        return r0.b(r1, r3);
    }

    public static final /* synthetic */ void b(g r2, de r3, n r4, int r5) {
        r2.b((de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public static final /* synthetic */ void b(g r2, kotlinx.coroutines.n r3) {
        r2.b((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"));
    }

    private final void b(n<E> r13) {
        Function1<E, Unit> r0 = this.f17279b;
        UndeliveredElementException r1 = null;
        Object r3 = kotlinx.coroutines.internal.q.a(null, 1, null);
    L3:
        int r4 = h.f17284a - 1;
    L5:
        if ((-1) >= r4) goto L51;
        long r7 = (r13.f17558a * ((long) h.f17284a)) + ((long) r4);
    L7:
        Object r9 = r13.d(r4);
        if (r9 == h.f()) goto L53;
        if (r9 == h.f17285b) goto L12;
        if (r9 == h.h()) goto L48;
        if (r9 == null) goto L48;
        if (ZeusTransformUtils.instanceOf(r9, de.class) == true) goto L37;
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == true) goto L37;
        if (r9 == h.m()) goto L53;
        if (r9 == h.n()) goto L53;
        if (r9 == h.m()) goto L7;
    L50:
        r4 = r4 - 1;
    L37:
        if (r7 < e()) goto L53;
        if (ZeusTransformUtils.instanceOf(r9, ab.class) == false) goto L41;
        de r10 = ((ab) ZeusTransformUtils.preCheckCast(r9, ab.class, "com.obric.memorydata.plugin")).f17273a;
    L43:
        if (r13.a(r4, r9, h.b()) == false) goto L7;
        if (r0 == null) goto L46;
        r1 = kotlinx.coroutines.internal.ab.a(r0, r13.a(r4), r1);
    L46:
        r3 = kotlinx.coroutines.internal.q.a(r3, r10);
    L17:
        r13.c(r4);
    L18:
        r13.l();
        goto L50
    L41:
        r10 = (de) ZeusTransformUtils.preCheckCast(r9, de.class, "com.obric.memorydata.plugin");
    L48:
        if (r13.a(r4, r9, h.b()) == false) goto L7;
    L12:
        if (r7 < e()) goto L53;
        if (r13.a(r4, r9, h.b()) == false) goto L7;
        if (r0 == null) goto L17;
        r1 = kotlinx.coroutines.internal.ab.a(r0, r13.a(r4), r1);
    L53:
        if (r3 != null) goto L55;
    L60:
        if (r1 != null) goto L62;
        return;
    L62:
        throw r1;
    L55:
        if (ZeusTransformUtils.instanceOf(r3, ArrayList.class) == true) goto L57;
        b((de) ZeusTransformUtils.preCheckCast(r3, de.class, "com.obric.memorydata.plugin"));
        goto L60
    L57:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList r14 = (ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin");
        int r2 = r14.size() - 1;
    L58:
        if ((-1) >= r2) goto L60;
        b((de) ZeusTransformUtils.preCheckCast(r14.get(r2), de.class, "com.obric.memorydata.plugin"));
        r2 = r2 - 1;
        goto L58
    L51:
        r13 = (n) ZeusTransformUtils.preCheckCast(r13.e(), n.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L3;
        goto L53
    }

    private final void b(de r3) {
        a((de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin"), false);
    }

    private final void b(de r3, n<E> r4, int r5) {
        de r6 = (de) ZeusTransformUtils.wrapperContextForParams(r3, de.class, "com.obric.memorydata.plugin");
        g();
        r6.a((ag) ZeusTransformUtils.preCheckCast(r4, ag.class, "com.obric.memorydata.plugin"), r5);
    }

    private final void b(kotlinx.coroutines.n<? super m<? extends E>> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;
        r4.resumeWith(Result.m1421constructorimpl(m.i(m.f17289a.a(m()))));
    }

    private final void b(kotlinx.coroutines.selects.m<?> r11, Object r12) {
        kotlinx.coroutines.selects.m<?> r13 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r11, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        n r14 = (n) ZeusTransformUtils.preCheckCast(u().get(this), n.class, "com.obric.memorydata.plugin");
    L4:
        if (q() == true) goto L5;
        long r7 = v().getAndIncrement(this);
        long r1 = r7 / ((long) h.f17284a);
        int r9 = (int) (r7 % ((long) h.f17284a));
        if (r14.f17558a == r1) goto L12;
        n r2 = b(this, r1, r14);
        if (r2 == null) goto L4;
        r14 = r2;
    L12:
        Object r3 = a(this, r14, r9, r7, r13);
        if (r3 == h.k()) goto L15;
        if (r3 != h.j()) goto L26;
        if (r7 >= d()) goto L4;
        r14.f();
        goto L4
    L26:
        if (r3 == h.l()) goto L30;
        r14.f();
        r13.a(r3);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L15:
        if (ZeusTransformUtils.instanceOf(r13, de.class) == false) goto L17;
        de r15 = (de) ZeusTransformUtils.preCheckCast(r13, de.class, "com.obric.memorydata.plugin");
    L18:
        if (r15 == null) goto L42;
        b(this, r15, r14, r9);
        return;
    L42:
        return;
    L17:
        r15 = null;
        goto L18
    L5:
        a(r13);
    }

    private final boolean b() {
        long r0 = a();
        if (r0 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r0 == Long.MAX_VALUE) goto L8;
        return false;
    }

    private final boolean b(n<E> r7, int r8, long r9) {
    L2:
        Object r0 = r7.d(r8);
        if (ZeusTransformUtils.instanceOf(r0, de.class) == true) goto L5;
        if (r0 == h.e()) goto L18;
        if (r0 == null) goto L21;
        if (r0 == h.f17285b) goto L25;
        if (r0 == h.i()) goto L41;
        if (r0 == h.f()) goto L41;
        if (r0 == h.g()) goto L41;
        if (r0 == h.b()) goto L35;
        if (r0 == h.n()) goto L2;
        throw new IllegalStateException(("Unexpected cell state: " + r0).toString());
    L35:
        return true;
    L41:
        return true;
    L25:
        return true;
    L21:
        if (r7.a(r8, r0, h.h()) == false) goto L2;
        return true;
    L18:
        return false;
    L5:
        if (r9 < E().get(this)) goto L7;
        if (r7.a(r8, r0, h.m()) == false) goto L2;
        if (a(r0, r7, r8) == false) goto L14;
        r7.b(r8, h.f17285b);
        return true;
    L14:
        r7.b(r8, h.e());
        r7.a(r8, false);
        return false;
    L7:
        if (r7.a(r8, r0, new ab((de) ZeusTransformUtils.preCheckCast(r0, de.class, "com.obric.memorydata.plugin"))) == false) goto L2;
        return true;
    }

    private final Object c(Object r1, Object r2) {
        if (r2 == h.b()) goto L6;
        return r2;
    L6:
        throw w();
    }

    public static final /* synthetic */ Object c(g r0, Object r1, Object r2) {
        return r0.e(r1, r2);
    }

    private final void c() {
        if (b() == false) goto L5;
        return;
    L5:
        n<E> r0 = (n) ZeusTransformUtils.preCheckCast(J().get(this), n.class, "com.obric.memorydata.plugin");
    L6:
        long r7 = F().getAndIncrement(this);
        long r2 = r7 / ((long) h.f17284a);
        long r4 = d();
        long r5 = r0.f17558a;
        if (r4 <= r7) goto L9;
        if (r5 == r2) goto L21;
        n<E> r1 = a(r2, r0, r7);
        if (r1 == null) goto L6;
        r0 = r1;
    L21:
        boolean r3 = a(r0, (int) (r7 % ((long) h.f17284a)), r7);
        a(this, 0, 1, null);
        if (r3 == false) goto L6;
        return;
    L9:
        if (r5 < r2) goto L11;
    L13:
        a(this, 0, 1, null);
        return;
    L11:
        if (r0.c() == 0) goto L13;
        c(r2, r0);
        goto L13
    }

    private final void c(long r7, n<E> r9) {
    L3:
        if (r9.f17558a >= r7) goto L9;
        n<E> r0 = (n) ZeusTransformUtils.preCheckCast(r9.c(), n.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        r9 = r0;
    L9:
        if (r9.h() == false) goto L14;
        n<E> r8 = (n) ZeusTransformUtils.preCheckCast(r9.c(), n.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L14;
        r9 = r8;
    L14:
        AtomicReferenceFieldUpdater r10 = J();
    L15:
        ag r11 = (ag) ZeusTransformUtils.preCheckCast(r10.get(this), ag.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r11.f17558a >= ((ag) ZeusTransformUtils.preCheckCast(r9, ag.class, "com.obric.memorydata.plugin")).f17558a) goto L26;
        if (((ag) ZeusTransformUtils.preCheckCast(r9, ag.class, "com.obric.memorydata.plugin")).j() == false) goto L20;
        if (r10.compareAndSet(this, r11, (ag) ZeusTransformUtils.preCheckCast(r9, ag.class, "com.obric.memorydata.plugin")) == true) goto L24;
        if (((ag) ZeusTransformUtils.preCheckCast(r9, ag.class, "com.obric.memorydata.plugin")).k() == false) goto L15;
        ((ag) ZeusTransformUtils.preCheckCast(r9, ag.class, "com.obric.memorydata.plugin")).i();
        goto L15
    L24:
        if (r11.k() == false) goto L26;
        r11.i();
        goto L26
    L20:
        r2 = false;
    L26:
        if (r2 == false) goto L9;
    }

    private final boolean c(long r3) {
        if (h(r3) == false) goto L7;
        return false;
    L7:
        return !d(r3 & 1152921504606846975L);
    }

    private final boolean c(n<E> r4, int r5, long r6) {
    L2:
        Object r0 = r4.d(r5);
        if (r0 == null) goto L33;
        if (r0 == h.h()) goto L33;
        if (r0 != h.f17285b) goto L11;
        return true;
    L11:
        if (r0 != h.e()) goto L14;
        return false;
    L14:
        if (r0 != h.b()) goto L17;
        return false;
    L17:
        if (r0 != h.f()) goto L20;
        return false;
    L20:
        if (r0 != h.i()) goto L23;
        return false;
    L23:
        if (r0 != h.m()) goto L26;
        return true;
    L26:
        if (r0 != h.n()) goto L29;
        return false;
    L29:
        if (r6 == e()) goto L31;
        return false;
    L31:
        return true;
    L33:
        if (r4.a(r5, r0, h.i()) == false) goto L2;
        c();
        return false;
    }

    private final Object d(Object r1, Object r2) {
        if (r2 == h.b()) goto L5;
        return r2;
    L5:
        if (m() != null) goto L8;
        return null;
    L8:
        throw w();
    }

    public static final /* synthetic */ Object d(g r0, Object r1, Object r2) {
        return r0.d(r1, r2);
    }

    private final boolean d(long r5) {
        if (r5 >= a()) goto L5;
    L8:
        return true;
    L5:
        if (r5 < (e() + ((long) this.f17278a))) goto L8;
        return false;
    }

    private final Object e(Object r1, Object r2) {
        if (r2 != h.b()) goto L5;
        Object r0 = m.f17289a.a(m());
    L7:
        return m.i(r0);
    L5:
        r0 = m.f17289a.a(r2);
        goto L7
    }

    private final void e(long r8) {
        if ((G().addAndGet(this, r8) & 4611686018427387904L) == 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
        return;
    L8:
        if ((G().get(this) & 4611686018427387904L) == 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L8;
        return;
    L10:
        r10 = false;
        goto L11
    L5:
        r9 = false;
        goto L6
    }

    private final n<E> f(long r6) {
        n<E> r0 = C();
        if (p() == false) goto L7;
        long r1 = a(r0);
        if (r1 == (-1)) goto L7;
        a(r1);
    L7:
        a(r0, r6);
        return r0;
    }

    private final void g(long r1) {
        b(f(r1));
    }

    private final boolean h(long r2) {
        return a(r2, false);
    }

    private final boolean i(long r2) {
        return a(r2, true);
    }

    private final void j(long r8) {
        AtomicLongFieldUpdater r0 = D();
    L3:
        long r3 = r0.get(this);
        long r1 = 1152921504606846975L & r3;
        if (r1 >= r8) goto L5;
        long r5 = h.a(r1, (int) (r3 >> 60));
        if (D().compareAndSet(this, r3, r5) == false) goto L3;
        return;
    }

    private final void k(long r8) {
        AtomicLongFieldUpdater r0 = E();
    L3:
        long r3 = r0.get(this);
        if (r3 >= r8) goto L5;
        if (E().compareAndSet(this, r3, r8) == false) goto L3;
        return;
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater s() {
        return H();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater t() {
        return D();
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater u() {
        return I();
    }

    public static final /* synthetic */ AtomicLongFieldUpdater v() {
        return E();
    }

    private final Throwable w() {
        Throwable r2 = m();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (Throwable) ZeusTransformUtils.preCheckCast(new ClosedReceiveChannelException("Channel was closed"), Throwable.class, "com.obric.memorydata.plugin");
    }

    private final void x() {
        AtomicReferenceFieldUpdater r0 = L();
    L3:
        Object r1 = r0.get(this);
        if (r1 != null) goto L6;
        aj r2 = h.q();
    L8:
        if (r0.compareAndSet(this, r1, r2) == false) goto L3;
        if (r1 != null) goto L11;
        return;
    L11:
        Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 1), Function1.class, "com.obric.memorydata.plugin");
        ((Function1) ZeusTransformUtils.preCheckCast(r1, Function1.class, "com.obric.memorydata.plugin")).invoke(m());
        return;
    L6:
        r2 = h.r();
        goto L8
    }

    private final void y() {
        AtomicLongFieldUpdater r6 = D();
    L3:
        long r2 = r6.get(this);
        int r0 = (int) (r2 >> 60);
        if (r0 != 0) goto L6;
        long r1 = r2 & 1152921504606846975L;
        int r4 = 2;
    L11:
        if (r6.compareAndSet(this, r2, h.a(r1, r4)) == false) goto L3;
        return;
    L6:
        if (r0 != 1) goto L7;
        r1 = r2 & 1152921504606846975L;
        r4 = 3;
        goto L11
    }

    private final void z() {
        AtomicLongFieldUpdater r6 = D();
    L3:
        long r2 = r6.get(this);
        if (r6.compareAndSet(this, r2, h.a(1152921504606846975L & r2, 3)) == false) goto L3;
    }

    public final Object a(E r17) {
        aj r9 = h.f17285b;
        n r0 = (n) ZeusTransformUtils.preCheckCast(s().get(this), n.class, "com.obric.memorydata.plugin");
    L3:
        long r1 = t().getAndIncrement(this);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = a(this, r1);
        long r2 = r11 / ((long) h.f17284a);
        int r14 = (int) (r11 % ((long) h.f17284a));
        if (r0.f17558a == r2) goto L11;
        n r3 = a(this, r2, r0);
        if (r3 == null) goto L7;
        n r15 = r3;
    L12:
        int r4 = a(this, r15, r14, r17, r11, r9, r13);
        if (r4 == 0) goto L47;
        if (r4 == 1) goto L46;
        if (r4 == 2) goto L34;
        if (r4 == 3) goto L33;
        if (r4 == 4) goto L28;
        if (r4 != 5) goto L26;
        r15.f();
    L26:
        r0 = r15;
        goto L3
    L28:
        if (r11 >= e()) goto L31;
        r15.f();
    L31:
        return m.f17289a.a(n());
    L33:
        throw new IllegalStateException("unexpected".toString());
    L34:
        if (r13 == false) goto L38;
        r15.l();
        return m.f17289a.a(n());
    L38:
        if (ZeusTransformUtils.instanceOf(r9, de.class) == false) goto L40;
        de r5 = (de) ZeusTransformUtils.preCheckCast(r9, de.class, "com.obric.memorydata.plugin");
    L41:
        if (r5 == null) goto L43;
        a(this, r5, r15, r14);
    L43:
        a((r15.f17558a * ((long) h.f17284a)) + ((long) r14));
        return m.f17289a.a(Unit.INSTANCE);
    L40:
        r5 = null;
        goto L41
    L46:
        return m.f17289a.a(Unit.INSTANCE);
    L47:
        r15.f();
        return m.f17289a.a(Unit.INSTANCE);
    L7:
        if (r13 == false) goto L3;
        return m.f17289a.a(n());
    L11:
        r15 = r0;
        goto L12
    }

    public Object a(E r3, Continuation<? super Boolean> r4) {
        return b(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.coroutines.channels.y
    public Object a(Continuation<? super E> r3) {
        return a(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final void a(long r11) {
        if (an.a() == true) goto L5;
    L9:
        n<E> r0 = (n) ZeusTransformUtils.preCheckCast(I().get(this), n.class, "com.obric.memorydata.plugin");
    L10:
        long r8 = E().get(this);
        if (r11 < Math.max(((long) this.f17278a) + r8, a())) goto L12;
        if (E().compareAndSet(this, r8, r8 + 1) == false) goto L10;
        long r1 = r8 / ((long) h.f17284a);
        int r4 = (int) (r8 % ((long) h.f17284a));
        if (r0.f17558a == r1) goto L21;
        n<E> r2 = b(r1, r0);
        if (r2 == null) goto L10;
        r0 = r2;
    L21:
        Object r3 = a(r0, r4, r8, null);
        if (r3 == h.j()) goto L24;
        r0.f();
        Function1<E, Unit> r5 = this.f17279b;
        if (r5 == null) goto L10;
        UndeliveredElementException r6 = kotlinx.coroutines.internal.ab.a(r5, r3, null, 2, null);
        if (r6 == null) goto L10;
        throw r6;
    L24:
        if (r8 >= d()) goto L10;
        r0.f();
        goto L10
    L12:
        return;
    L5:
        if (p() == true) goto L9;
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.channels.y
    public final void a(CancellationException r3) {
        a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(kotlinx.coroutines.selects.m<?> r17, Object r18) {
        kotlinx.coroutines.selects.m<?> r11 = (kotlinx.coroutines.selects.m) ZeusTransformUtils.wrapperContextForParams(r17, kotlinx.coroutines.selects.m.class, "com.obric.memorydata.plugin");
        n r0 = (n) ZeusTransformUtils.preCheckCast(s().get(this), n.class, "com.obric.memorydata.plugin");
    L3:
        long r1 = t().getAndIncrement(this);
        long r12 = r1 & 1152921504606846975L;
        boolean r14 = a(this, r1);
        long r2 = r12 / ((long) h.f17284a);
        int r15 = (int) (r12 % ((long) h.f17284a));
        if (r0.f17558a == r2) goto L10;
        n r3 = a(this, r2, r0);
        if (r3 == null) goto L7;
        n r7 = r3;
    L11:
        n r19 = r7;
        int r4 = a(this, r7, r15, r18, r12, r11, r14);
        if (r4 == 0) goto L40;
        if (r4 == 1) goto L41;
        if (r4 == 2) goto L31;
        if (r4 == 3) goto L30;
        if (r4 == 4) goto L27;
        if (r4 != 5) goto L25;
        r19.f();
    L25:
        r0 = r19;
        goto L3
    L27:
        if (r12 >= e()) goto L33;
        r19.f();
    L33:
        a(r18, r11);
        return;
    L30:
        throw new IllegalStateException("unexpected".toString());
    L31:
        if (r14 == false) goto L35;
        r19.l();
        goto L33
    L35:
        if (ZeusTransformUtils.instanceOf(r11, de.class) == false) goto L37;
        de r5 = (de) ZeusTransformUtils.preCheckCast(r11, de.class, "com.obric.memorydata.plugin");
    L38:
        if (r5 == null) goto L56;
        a(this, r5, r19, r15);
        return;
    L56:
        return;
    L37:
        r5 = null;
    L41:
        r11.a(Unit.INSTANCE);
        return;
    L40:
        r19.f();
        goto L41
    L7:
        if (r14 == false) goto L3;
    L10:
        r7 = r0;
        goto L11
    }

    public boolean a(Throwable r3) {
        if (r3 != null) goto L5;
        r3 = (Throwable) ZeusTransformUtils.preCheckCast(new CancellationException("Channel was cancelled"), Throwable.class, "com.obric.memorydata.plugin");
    L5:
        return a(r3, true);
    }

    public boolean a(Throwable r3, boolean r4) {
        if (r4 == false) goto L4;
        A();
    L4:
        boolean r5 = K().compareAndSet(this, h.d(), r3);
        if (r4 == false) goto L7;
        z();
    L8:
        B();
        o();
        if (r5 == false) goto L11;
        x();
    L11:
        return r5;
    L7:
        y();
        goto L8
    }

    @Override // kotlinx.coroutines.channels.y
    public Object b(Continuation<? super m<? extends E>> r3) {
        return b(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final void b(long r17) {
        if (b() == false) goto L6;
        return;
    L6:
        if (a() <= r17) goto L6;
        int r0 = h.o();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L16;
        long r2 = a();
        if (r2 != (G().get(this) & DurationKt.MAX_MILLIS)) goto L15;
        if (r2 != a()) goto L15;
        return;
    L15:
        r1 = r1 + 1;
        goto L9
    L16:
        AtomicLongFieldUpdater r10 = G();
    L17:
        long r3 = r10.get(this);
        if (r10.compareAndSet(this, r3, h.a(r3 & DurationKt.MAX_MILLIS, true)) == false) goto L17;
    L19:
        long r4 = a();
        long r5 = G().get(this);
        long r6 = r5 & DurationKt.MAX_MILLIS;
        if ((4611686018427387904L & r5) == 0) goto L22;
        boolean r11 = true;
    L24:
        if (r4 == r6) goto L26;
    L31:
        if (r11 == true) goto L19;
        G().compareAndSet(this, r5, h.a(r6, true));
        goto L19
    L26:
        if (r4 != a()) goto L31;
        AtomicLongFieldUpdater r12 = G();
    L28:
        long r7 = r12.get(this);
        if (r12.compareAndSet(this, r7, h.a(r7 & DurationKt.MAX_MILLIS, false)) == false) goto L28;
        return;
    L22:
        r11 = false;
        goto L24
    }

    public boolean close(Throwable r2) {
        return a(r2, false);
    }

    public final long d() {
        return D().get(this) & 1152921504606846975L;
    }

    public final long e() {
        return E().get(this);
    }

    public boolean f() {
        return c(D().get(this));
    }

    public void g() {
    }

    @Override // kotlinx.coroutines.channels.z
    public kotlinx.coroutines.selects.j<E, g<E>> getOnSend() {
        BufferedChannel$onSend$1 r0 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r0, 3), Function3.class, "com.obric.memorydata.plugin");
        BufferedChannel$onSend$2 r1 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return (kotlinx.coroutines.selects.j) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.selects.k(this, r2, (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3), Function3.class, "com.obric.memorydata.plugin"), null, 8, null), kotlinx.coroutines.selects.j.class, "com.obric.memorydata.plugin");
    }

    public void h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.y
    public Object i() {
        long r0 = E().get(this);
        long r2 = D().get(this);
        if (i(r2) == false) goto L7;
        return m.f17289a.a(m());
    L7:
        if (r0 >= (r2 & 1152921504606846975L)) goto L9;
        aj r6 = h.g();
        n r1 = (n) ZeusTransformUtils.preCheckCast(u().get(this), n.class, "com.obric.memorydata.plugin");
    L12:
        if (q() == true) goto L50;
        long r8 = v().getAndIncrement(this);
        long r3 = r8 / ((long) h.f17284a);
        int r10 = (int) (r8 % ((long) h.f17284a));
        if (r1.f17558a == r3) goto L20;
        n r4 = b(this, r3, r1);
        if (r4 == null) goto L12;
        n r11 = r4;
    L21:
        Object r5 = a(this, r11, r10, r8, r6);
        if (r5 == h.k()) goto L24;
        if (r5 != h.j()) goto L37;
        if (r8 >= d()) goto L35;
        r11.f();
    L35:
        r1 = r11;
        goto L12
    L37:
        if (r5 == h.l()) goto L41;
        r11.f();
        return m.f17289a.a(r5);
    L41:
        throw new IllegalStateException("unexpected".toString());
    L24:
        if (ZeusTransformUtils.instanceOf(r6, de.class) == false) goto L26;
        de r7 = (de) ZeusTransformUtils.preCheckCast(r6, de.class, "com.obric.memorydata.plugin");
    L27:
        if (r7 == null) goto L29;
        b(this, r7, r11, r10);
    L29:
        b(r8);
        r11.l();
        return m.f17289a.a();
    L26:
        r7 = null;
        goto L27
    L20:
        r11 = r1;
        goto L21
    L50:
        return m.f17289a.a(m());
    L9:
        return m.f17289a.a();
    }

    @Override // kotlinx.coroutines.channels.z
    public void invokeOnClose(Function1<? super Throwable, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if (L().compareAndSet(this, null, r6) == false) goto L5;
        return;
    L5:
        AtomicReferenceFieldUpdater r0 = L();
    L6:
        Object r1 = r0.get(this);
        if (r1 != h.q()) goto L13;
        if (L().compareAndSet(this, h.q(), h.r()) == false) goto L6;
        r6.invoke(m());
        return;
    L13:
        if (r1 != h.r()) goto L17;
        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
    L17:
        throw new IllegalStateException(("Another handler is already registered: " + r1).toString());
    }

    public boolean isClosedForSend() {
        return h(D().get(this));
    }

    @Override // kotlinx.coroutines.channels.y
    public kotlinx.coroutines.selects.h<E> j() {
        BufferedChannel$onReceive$1 r1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3), Function3.class, "com.obric.memorydata.plugin");
        BufferedChannel$onReceive$2 r3 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return (kotlinx.coroutines.selects.h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.selects.i(this, r2, (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), Function3.class, "com.obric.memorydata.plugin"), this.d), kotlinx.coroutines.selects.h.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.channels.y
    public kotlinx.coroutines.selects.h<m<E>> k() {
        BufferedChannel$onReceiveCatching$1 r1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 r2 = (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r1, 3), Function3.class, "com.obric.memorydata.plugin");
        BufferedChannel$onReceiveCatching$2 r3 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return (kotlinx.coroutines.selects.h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.selects.i(this, r2, (Function3) ZeusTransformUtils.preCheckCast(TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 3), Function3.class, "com.obric.memorydata.plugin"), this.d), kotlinx.coroutines.selects.h.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.coroutines.channels.y
    public k<E> l() {
        return (k) ZeusTransformUtils.preCheckCast(new a(this), k.class, "com.obric.memorydata.plugin");
    }

    public final Throwable m() {
        return (Throwable) ZeusTransformUtils.preCheckCast(K().get(this), Throwable.class, "com.obric.memorydata.plugin");
    }

    public final Throwable n() {
        Throwable r2 = m();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return (Throwable) ZeusTransformUtils.preCheckCast(new ClosedSendChannelException("Channel was closed"), Throwable.class, "com.obric.memorydata.plugin");
    }

    public void o() {
    }

    @Override // kotlinx.coroutines.channels.z
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E r1) {
        return i.a.a(this, r1);
    }

    public boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.y
    public boolean q() {
        return i(D().get(this));
    }

    public final boolean r() {
    L2:
        n<E> r0 = (n) ZeusTransformUtils.preCheckCast(I().get(this), n.class, "com.obric.memorydata.plugin");
        long r5 = e();
        if (d() <= r5) goto L4;
        long r7 = r5 / ((long) h.f17284a);
        if (r0.f17558a == r7) goto L12;
        r0 = b(r7, r0);
        if (r0 != null) goto L12;
        if (((n) ZeusTransformUtils.preCheckCast(I().get(this), n.class, "com.obric.memorydata.plugin")).f17558a >= r7) goto L2;
        return false;
    L12:
        r0.f();
        if (c(r0, (int) (r5 % ((long) h.f17284a)), r5) == true) goto L14;
        E().compareAndSet(this, r5, r5 + 1);
        goto L2
    L14:
        return true;
    L4:
        return false;
    }

    public Object send(E r3, Continuation<? super Unit> r4) {
        return a(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString() {
        StringBuilder r1 = new StringBuilder();
        int r2 = (int) (D().get(this) >> 60);
        if (r2 == 2) goto L7;
        if (r2 != 3) goto L9;
        String r3 = "cancelled,";
    L8:
        r1.append(r3);
    L9:
        r1.append("capacity=" + this.f17278a + ',');
        r1.append("data=[");
        int r6 = 0;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new n[]{I().get(this), H().get(this), J().get(this)}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r4.iterator();
    L11:
        if (r7.hasNext() == false) goto L18;
        Object r8 = r7.next();
        if (((n) ZeusTransformUtils.preCheckCast(r8, n.class, "com.obric.memorydata.plugin")) == h.c()) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == false) goto L11;
        r5.add(r8);
        goto L11
    L15:
        r9 = false;
        goto L16
    L18:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r10.hasNext() == false) goto L105;
        Object r11 = r10.next();
        if (r10.hasNext() == false) goto L29;
        long r12 = ((n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.memorydata.plugin")).f17558a;
    L24:
        Object r13 = r10.next();
        long r14 = ((n) ZeusTransformUtils.preCheckCast(r13, n.class, "com.obric.memorydata.plugin")).f17558a;
        if (r12 <= r14) goto L28;
        r11 = r13;
        r12 = r14;
    L28:
        if (r10.hasNext() == true) goto L24;
    L29:
        n r15 = (n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.memorydata.plugin");
        long r16 = e();
        long r17 = d();
    L30:
        int r0 = h.f17284a;
        int r18 = r6;
    L31:
        if (r18 >= r0) goto L96;
        long r19 = (r15.f17558a * ((long) h.f17284a)) + ((long) r18);
        if (r19 >= r17) goto L35;
    L36:
        Object r110 = r15.d(r18);
        Object r20 = r15.a(r18);
        if (ZeusTransformUtils.instanceOf(r110, kotlinx.coroutines.n.class) == false) goto L47;
        if (r19 >= r16) goto L42;
        if (r19 < r17) goto L42;
        String r21 = "receive";
    L91:
        if (r20 == null) goto L93;
        StringBuilder r22 = new StringBuilder().append('(').append(r21).append(',').append(r20).append("),");
    L94:
        r1.append(r22.toString());
    L95:
        r18 = r18 + 1;
        goto L31
    L93:
        r22 = new StringBuilder().append(r21).append(',');
    L42:
        if (r19 >= r17) goto L45;
        if (r19 < r16) goto L45;
        r21 = "send";
    L45:
        r21 = "cont";
        goto L91
    L47:
        if (ZeusTransformUtils.instanceOf(r110, kotlinx.coroutines.selects.m.class) == false) goto L57;
        if (r19 >= r16) goto L52;
        if (r19 < r17) goto L52;
        r21 = "onReceive";
    L52:
        if (r19 >= r17) goto L55;
        if (r19 < r16) goto L55;
        r21 = "onSend";
    L55:
        r21 = "select";
        goto L91
    L57:
        if (ZeusTransformUtils.instanceOf(r110, x.class) == false) goto L60;
        r21 = "receiveCatching";
        goto L91
    L60:
        if (ZeusTransformUtils.instanceOf(r110, b.class) == false) goto L63;
        r21 = "sendBroadcast";
        goto L91
    L63:
        if (ZeusTransformUtils.instanceOf(r110, ab.class) == false) goto L66;
        r21 = "EB(" + r110 + ')';
        goto L91
    L66:
        if (Intrinsics.areEqual(r110, h.n()) == false) goto L68;
        boolean r23 = true;
    L69:
        if (r23 == false) goto L71;
        r21 = "resuming_sender";
        goto L91
    L71:
        if (r110 != null) goto L73;
        boolean r24 = true;
    L74:
        if (r24 == false) goto L76;
        boolean r25 = true;
    L77:
        if (r25 == false) goto L79;
        boolean r26 = true;
    L80:
        if (r26 == false) goto L82;
        boolean r27 = true;
    L83:
        if (r27 == false) goto L85;
        boolean r28 = true;
    L86:
        if (r28 == false) goto L88;
        boolean r29 = true;
    L89:
        if (r29 == true) goto L95;
        r21 = r110.toString();
        goto L91
    L88:
        r29 = Intrinsics.areEqual(r110, h.b());
        goto L89
    L85:
        r28 = Intrinsics.areEqual(r110, h.e());
        goto L86
    L82:
        r27 = Intrinsics.areEqual(r110, h.g());
        goto L83
    L79:
        r26 = Intrinsics.areEqual(r110, h.i());
        goto L80
    L76:
        r25 = Intrinsics.areEqual(r110, h.f());
        goto L77
    L73:
        r24 = Intrinsics.areEqual(r110, h.h());
        goto L74
    L68:
        r23 = Intrinsics.areEqual(r110, h.m());
        goto L69
    L35:
        if (r19 < r16) goto L36;
    L99:
        if (StringsKt.last((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) != ',') goto L101;
        Intrinsics.checkNotNullExpressionValue(r1.deleteCharAt(r1.length() - 1), "deleteCharAt(...)");
    L101:
        r1.append("]");
        return r1.toString();
    L96:
        r15 = (n) ZeusTransformUtils.preCheckCast(r15.c(), n.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L99;
        r6 = 0;
        goto L30
    L105:
        throw new NoSuchElementException();
    L7:
        r3 = "closed,";
        goto L8
    }

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo54trySendJP2dKIU(E r17) {
        if (c(D().get(this)) == true) goto L5;
        aj r9 = h.e();
        n r0 = (n) ZeusTransformUtils.preCheckCast(s().get(this), n.class, "com.obric.memorydata.plugin");
    L7:
        long r1 = t().getAndIncrement(this);
        long r11 = r1 & 1152921504606846975L;
        boolean r13 = a(this, r1);
        long r2 = r11 / ((long) h.f17284a);
        int r14 = (int) (r11 % ((long) h.f17284a));
        if (r0.f17558a == r2) goto L14;
        n r3 = a(this, r2, r0);
        if (r3 == null) goto L11;
        n r15 = r3;
    L15:
        int r4 = a(this, r15, r14, r17, r11, r9, r13);
        if (r4 == 0) goto L45;
        if (r4 == 1) goto L47;
        if (r4 == 2) goto L35;
        if (r4 == 3) goto L34;
        if (r4 == 4) goto L31;
        if (r4 != 5) goto L29;
        r15.f();
    L29:
        r0 = r15;
        goto L7
    L31:
        if (r11 >= e()) goto L60;
        r15.f();
    L60:
        return m.f17289a.a(n());
    L34:
        throw new IllegalStateException("unexpected".toString());
    L35:
        if (r13 == false) goto L39;
        r15.l();
        goto L60
    L39:
        if (ZeusTransformUtils.instanceOf(r9, de.class) == false) goto L41;
        de r5 = (de) ZeusTransformUtils.preCheckCast(r9, de.class, "com.obric.memorydata.plugin");
    L42:
        if (r5 == null) goto L44;
        a(this, r5, r15, r14);
    L44:
        r15.l();
        return m.f17289a.a();
    L41:
        r5 = null;
    L47:
        return m.f17289a.a(Unit.INSTANCE);
    L45:
        r15.f();
        goto L47
    L11:
        if (r13 == false) goto L7;
    L14:
        r15 = r0;
        goto L15
    L5:
        return m.f17289a.a();
    }
}
