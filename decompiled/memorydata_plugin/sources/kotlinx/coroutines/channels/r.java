package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\u001e\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001aC\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\u00122\u001d\u0010\u0013\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\n\u0012\u0004\u0012\u0002H\u00110\u0001¢\u0006\u0002\b\u0014H\u0087\b¢\u0006\u0002\u0010\u0015\u001a2\u0010\u0016\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00060\u0001H\u0087H¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\b\u00030\nH\u0001\u001a\u001e\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aW\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u001e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u001aQ\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a&\u0010*\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010+\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010,\u001a(\u0010-\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010+\u001a\u00020\u001bH\u0087@¢\u0006\u0002\u0010,\u001aQ\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0001¢\u0006\u0002\u0010%\u001af\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 27\u0010)\u001a3\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$00H\u0007¢\u0006\u0002\u00101\u001aQ\u00102\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a$\u00103\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020$*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001a>\u00104\u001a\u0002H5\"\b\b\u0000\u0010\u000e*\u00020$\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e06*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0087@¢\u0006\u0002\u00108\u001a<\u00104\u001a\u0002H5\"\b\b\u0000\u0010\u000e*\u00020$\"\u000e\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e09*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0087@¢\u0006\u0002\u0010:\u001a\u001e\u0010;\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a \u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a]\u0010=\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2(\u0010>\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\n0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a&\u0010?\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010@\u001a\u0002H\u000eH\u0087@¢\u0006\u0002\u0010A\u001a\u001e\u0010B\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a&\u0010C\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010@\u001a\u0002H\u000eH\u0087@¢\u0006\u0002\u0010A\u001a \u0010D\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001aW\u0010E\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010>\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0001¢\u0006\u0002\u0010%\u001al\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 27\u0010>\u001a3\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$00H\u0001¢\u0006\u0002\u00101\u001ar\u0010G\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u0010\u0011*\u00020$*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 29\u0010>\u001a5\b\u0001\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$00H\u0007¢\u0006\u0002\u00101\u001a]\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00110\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u0010\u0011*\u00020$*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2$\u0010>\u001a \b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a<\u0010I\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010J\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Kj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`LH\u0087@¢\u0006\u0002\u0010M\u001a<\u0010N\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010J\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Kj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`LH\u0087@¢\u0006\u0002\u0010M\u001a\u001e\u0010O\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a$\u0010P\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020$*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a\u001e\u0010Q\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a \u0010R\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a0\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010'\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u001aQ\u0010T\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 2\"\u0010)\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0#\u0012\u0006\u0012\u0004\u0018\u00010$0\"H\u0007¢\u0006\u0002\u0010%\u001a6\u0010U\u001a\u0002H5\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e09*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0081@¢\u0006\u0002\u0010:\u001a8\u0010V\u001a\u0002H5\"\u0004\b\u0000\u0010\u000e\"\u0010\b\u0001\u00105*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e06*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00107\u001a\u0002H5H\u0081@¢\u0006\u0002\u00108\u001a<\u0010W\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002HY0X\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010Y*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002HY0Z0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001aR\u0010W\u001a\u0002H[\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010Y\"\u0018\b\u0002\u0010[*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u001e\u0012\u0006\b\u0000\u0012\u0002HY0\\*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002HY0Z0\n2\u0006\u00107\u001a\u0002H[H\u0081@¢\u0006\u0002\u0010]\u001a$\u0010^\u001a\b\u0012\u0004\u0012\u0002H\u000e0_\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a$\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u000e0a\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@¢\u0006\u0002\u0010\u000f\u001a$\u0010b\u001a\b\u0012\u0004\u0012\u0002H\u000e0c\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@¢\u0006\u0002\u0010\u000f\u001a.\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007\u001a?\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00110Z0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010g\u001a\b\u0012\u0004\u0012\u0002H\u00110\nH\u0087\u0004\u001az\u0010f\u001a\b\u0012\u0004\u0012\u0002HY0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010Y*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010g\u001a\b\u0012\u0004\u0012\u0002H\u00110\n2\b\b\u0002\u0010\u001f\u001a\u00020 26\u0010>\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(h\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(i\u0012\u0004\u0012\u0002HY0\"H\u0001¨\u0006j"}, d2 = {"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "any", "", ExifInterface.LONGITUDE_EAST, "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consume", "R", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", CommonConsts.COUNT_TYPE, "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "flatMap", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", LocationInfoConst.SINGLE, "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class r {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0099 -> B:14:0x006e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.ERROR, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object a(c<E> r8, Function1<? super E, Unit> r9, Continuation<? super Unit> r10) {
        c r11 = (c) ZeusTransformUtils.wrapperContextForParams(r8, c.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__DeprecatedKt$consumeEach$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$consumeEach$1 r0 = (ChannelsKt__DeprecatedKt$consumeEach$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__DeprecatedKt$consumeEach$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y<E> r16 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$0, Function1.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
        ChannelsKt__DeprecatedKt$consumeEach$1 r7 = r0;
        y<E> r1 = r16;
        r12 = r4;
    L14:
        Object r5 = r2;
        ChannelsKt__DeprecatedKt$consumeEach$1 r6 = r7;
    L32:
        Throwable th = th;
        r16 = r1;
    L38:
        InlineMarker.finallyStart(1);
        y.a.a(r16, null, 1, null);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
        r12.invoke(r15.a());     // Catch: Throwable -> L32
        y<E> r17 = r1;
        r0 = r6;
        r2 = r5;
    L44:
        r0.L$0 = r12;     // Catch: Throwable -> L34
        r0.L$1 = r17;     // Catch: Throwable -> L34
        r0.L$2 = r15;     // Catch: Throwable -> L34
        r0.label = 1;     // Catch: Throwable -> L34
        Object r18 = r15.a(r0);     // Catch: Throwable -> L34
        if (r18 != r2) goto L25;
        return r2;
    L25:
        r7 = r0;
        r1 = r17;
        r14 = r18;
    L34:
        th = th;
        r16 = r17;
        goto L38
    L29:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        y.a.a(r1, null, 1, null);
        InlineMarker.finallyEnd(1);
        return Unit.INSTANCE;
    L15:
        th = th;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r14);
        y<E> r20 = r11.a();
        r17 = r20;
        r15 = r20.l();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r16 = r20;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$consumeEach$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0087 -> B:26:0x008b). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r11, int r12, Continuation r13) {
        y r14 = (y) ZeusTransformUtils.wrapperContextForParams(r11, y.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, ChannelsKt__DeprecatedKt$elementAt$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAt$1 r0 = (ChannelsKt__DeprecatedKt$elementAt$1) ZeusTransformUtils.preCheckCast(r15, ChannelsKt__DeprecatedKt$elementAt$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        int r17 = r0.I$1;
        r12 = r0.I$0;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        y r7 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
    L28:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L36;
        Object r18 = r4.a();     // Catch: Throwable -> L14
        int r9 = r17 + 1;
        if (r12 != r17) goto L34;
        o.a(r7, null);
        return r18;
    L34:
        r14 = r7;
        int r19 = r9;
    L22:
        r0.L$0 = r14;     // Catch: Throwable -> L37
        r0.L$1 = r4;     // Catch: Throwable -> L37
        r0.I$0 = r12;     // Catch: Throwable -> L37
        r0.I$1 = r19;     // Catch: Throwable -> L37
        r0.label = 1;     // Catch: Throwable -> L37
        Object r8 = r4.a(r0);     // Catch: Throwable -> L37
        if (r8 != r2) goto L25;
        return r2;
    L25:
        r7 = r14;
        r17 = r19;
        r16 = r8;
        goto L28
    L36:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r12 + '.');     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L47:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r16);
        if (r12 < 0) goto L40;
        r19 = 0;
        r4 = r14.l();     // Catch: Throwable -> L37
        goto L22
    L40:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r12 + '.');     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r7 = r14;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$elementAt$1(r15);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0092 -> B:25:0x0095). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r9, Object r10, Continuation r11) {
        y r12 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__DeprecatedKt$indexOf$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$indexOf$1 r0 = (ChannelsKt__DeprecatedKt$indexOf$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__DeprecatedKt$indexOf$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$3, k.class, "com.obric.memorydata.plugin");
        y r16 = (y) ZeusTransformUtils.preCheckCast(r0.L$2, y.class, "com.obric.memorydata.plugin");
        Ref.IntRef r4 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Object r5 = r0.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L28;
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r16, null);
        return Boxing.boxInt(-1);
    L28:
        if (Intrinsics.areEqual(r5, r15.a()) == false) goto L32;
        Integer r18 = Boxing.boxInt(r4.element);     // Catch: Throwable -> L14
        o.a(r16, null);
        return r18;
    L32:
        r4.element++;     // Catch: Throwable -> L14
        Object r19 = r5;
    L21:
        r0.L$0 = r19;     // Catch: Throwable -> L14
        r0.L$1 = r4;     // Catch: Throwable -> L14
        r0.L$2 = r16;     // Catch: Throwable -> L14
        r0.L$3 = r15;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r6 = r15.a(r0);     // Catch: Throwable -> L14
        if (r6 != r2) goto L24;
        return r2;
    L24:
        r5 = r19;
        r14 = r6;
    L14:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        o.a(r16, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        Ref.IntRef r110 = new Ref.IntRef();
        r16 = r12;
        r15 = r12.l();     // Catch: Throwable -> L36
        r4 = r110;
        r19 = r10;
    L36:
        th = move-exception;
        r16 = r12;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$indexOf$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:25:0x0092). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r8, Collection r9, Continuation r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r8, y.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__DeprecatedKt$filterNotNullTo$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 r0 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__DeprecatedKt$filterNotNullTo$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r16 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$0, Collection.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L31;
        Object r17 = r15.a();     // Catch: Throwable -> L14
        if (r17 == null) goto L30;
        r4.add(r17);     // Catch: Throwable -> L14
    L30:
        Collection r18 = r4;
    L21:
        r0.L$0 = r18;     // Catch: Throwable -> L14
        r0.L$1 = r16;     // Catch: Throwable -> L14
        r0.L$2 = r15;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r5 = r15.a(r0);     // Catch: Throwable -> L14
        if (r5 != r2) goto L24;
        return r2;
    L24:
        r4 = r18;
        r14 = r5;
        goto L26
    L31:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r16, null);
        return r4;
    L14:
        Throwable th = th;
    L42:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        o.a(r16, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r16 = r11;
        r15 = r11.l();     // Catch: Throwable -> L34
        r18 = r12;
    L34:
        th = move-exception;
        r16 = r11;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ee -> B:15:0x0073). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r9, Comparator r10, Continuation r11) {
        y r12 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Comparator r13 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ChannelsKt__DeprecatedKt$maxWith$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$maxWith$1 r0 = (ChannelsKt__DeprecatedKt$maxWith$1) ZeusTransformUtils.preCheckCast(r14, ChannelsKt__DeprecatedKt$maxWith$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L25;
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L19;
        Object r16 = r0.L$3;
        k r17 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r4 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.preCheckCast(r0.L$0, Comparator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L16
        ChannelsKt__DeprecatedKt$maxWith$1 r8 = r0;
        Object r1 = r16;
        r12 = r4;
    L15:
        Object r6 = r2;
        ChannelsKt__DeprecatedKt$maxWith$1 r7 = r8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L47;
        Object r18 = r17.a();     // Catch: Throwable -> L49
        if (r5.compare(r1, r18) < 0) goto L46;
        r18 = r1;
    L46:
        r0 = r7;
        r2 = r6;
    L36:
        r0.L$0 = r5;     // Catch: Throwable -> L49
        r0.L$1 = r12;     // Catch: Throwable -> L49
        r0.L$2 = r17;     // Catch: Throwable -> L49
        r0.L$3 = r18;     // Catch: Throwable -> L49
        r0.label = 2;     // Catch: Throwable -> L49
        Object r19 = r17.a(r0);     // Catch: Throwable -> L49
        if (r19 != r2) goto L39;
        return r2;
    L39:
        r8 = r0;
        r1 = r18;
        r15 = r19;
        goto L15
    L47:
        o.a(r12, null);
        return r1;
    L49:
        th = move-exception;
        y r110 = r12;
        th = th;
    L61:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        o.a(r110, th);
        throw th;
    L16:
        th = th;
        r110 = r4;
        goto L61
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        k r20 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        r110 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Comparator r21 = (Comparator) ZeusTransformUtils.preCheckCast(r0.L$0, Comparator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L34;
        o.a(r110, null);
        return null;
    L34:
        r18 = r20.a();     // Catch: Throwable -> L23
        r5 = r21;
        y r22 = r110;
        r17 = r20;
        r12 = r22;
    L23:
        th = th;
        goto L61
    L25:
        ResultKt.throwOnFailure(r15);
        k r111 = r12.l();     // Catch: Throwable -> L49
        r0.L$0 = r13;     // Catch: Throwable -> L49
        r0.L$1 = r12;     // Catch: Throwable -> L49
        r0.L$2 = r111;     // Catch: Throwable -> L49
        r0.label = 1;     // Catch: Throwable -> L49
        Object r23 = r111.a(r0);     // Catch: Throwable -> L49
        if (r23 != r2) goto L29;
        return r2;
    L29:
        r110 = r12;
        r20 = r111;
        r15 = r23;
        r21 = r13;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$maxWith$1(r14);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:25:0x0092). Please report as a decompilation issue!!! */
    public static final <K, V, M extends Map<? super K, ? super V>> Object a(y<? extends Pair<? extends K, ? extends V>> r8, M r9, Continuation<? super M> r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r8, y.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__DeprecatedKt$toMap$2.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$toMap$2 r0 = (ChannelsKt__DeprecatedKt$toMap$2) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__DeprecatedKt$toMap$2.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r16 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(r0.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        ?? r5 = r4;
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L28;
        Pair r17 = (Pair) ZeusTransformUtils.preCheckCast(r15.a(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        r5.put(r17.getFirst(), r17.getSecond());     // Catch: Throwable -> L14
        ?? r18 = r5;
    L21:
        r0.L$0 = r18;     // Catch: Throwable -> L14
        r0.L$1 = r16;     // Catch: Throwable -> L14
        r0.L$2 = r15;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r6 = r15.a(r0);     // Catch: Throwable -> L14
        if (r6 != r2) goto L24;
        return r2;
    L24:
        r5 = r18;
        r14 = r6;
        goto L26
    L28:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r16, null);
        return r5;
    L14:
        Throwable th = th;
    L39:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        o.a(r16, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r16 = r11;
        r15 = r11.l();     // Catch: Throwable -> L31
        r18 = r12;
    L31:
        th = move-exception;
        r16 = r11;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$toMap$2(r13);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r6, Continuation r7) {
        y r8 = (y) ZeusTransformUtils.wrapperContextForParams(r6, y.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ChannelsKt__DeprecatedKt$first$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$first$1 r0 = (ChannelsKt__DeprecatedKt$first$1) ZeusTransformUtils.preCheckCast(r9, ChannelsKt__DeprecatedKt$first$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r11 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L30;
        Object r12 = r11.a();     // Catch: Throwable -> L14
        o.a(r1, null);
        return r12;
    L30:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L40:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        o.a(r1, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        k r13 = r8.l();     // Catch: Throwable -> L31
        r0.L$0 = r8;     // Catch: Throwable -> L31
        r0.L$1 = r13;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        Object r4 = r13.a(r0);     // Catch: Throwable -> L31
        if (r4 != r2) goto L22;
        return r2;
    L22:
        r1 = r8;
        r11 = r13;
        r10 = r4;
    L31:
        th = move-exception;
        r1 = r8;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$first$1(r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.channels.z] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.channels.y] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object, kotlinx.coroutines.channels.y] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, kotlinx.coroutines.channels.z] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.channels.y] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c9 -> B:36:0x00da). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00d7 -> B:36:0x00da). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(y r9, z r10, Continuation r11) {
        ?? r12 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        ?? r13 = (z) ZeusTransformUtils.wrapperContextForParams(r10, z.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ChannelsKt__DeprecatedKt$filterNotNullTo$3.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 r0 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) ZeusTransformUtils.preCheckCast(r14, ChannelsKt__DeprecatedKt$filterNotNullTo$3.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        k r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r17 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        z r4 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        ?? r5 = r4;
        ?? r18 = r17;
    L36:
        k r19 = r16;
        r12 = r18;
        ?? r110 = r5;
    L24:
        r0.L$0 = r110;     // Catch: Throwable -> L40
        r0.L$1 = r12;     // Catch: Throwable -> L40
        r0.L$2 = r19;     // Catch: Throwable -> L40
        r0.label = 1;     // Catch: Throwable -> L40
        Object r6 = r19.a(r0);     // Catch: Throwable -> L40
        if (r6 != r2) goto L27;
        return r2;
    L27:
        ?? r8 = r110;
        r13 = r12;
        r16 = r19;
        r15 = r6;
        ?? r7 = r8;
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L37;
        Object r111 = r16.a();     // Catch: Throwable -> L20
        r5 = r7;
        r18 = r13;
        if (r111 == null) goto L36;
        r0.L$0 = r7;     // Catch: Throwable -> L20
        r0.L$1 = r13;     // Catch: Throwable -> L20
        r0.L$2 = r16;     // Catch: Throwable -> L20
        r0.label = 2;     // Catch: Throwable -> L20
        Object r112 = r7.send(r111, r0);     // Catch: Throwable -> L20
        r5 = r7;
        r18 = r13;
        if (r112 != r2) goto L36;
        return r2;
    L37:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L20
        o.a(r13, null);
        return r7;
    L40:
        th = move-exception;
        r13 = r12;
        th = th;
    L48:
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        o.a(r13, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r113 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        z r21 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        r7 = r21;
        r13 = r113;
        goto L30
    L22:
        ResultKt.throwOnFailure(r15);
        r19 = r12.l();     // Catch: Throwable -> L40
        r12 = r12;
        r110 = r13;
    L20:
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(r14);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0088 -> B:27:0x008b). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r9, int r10, Continuation r11) {
        y r12 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__DeprecatedKt$elementAtOrNull$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r0 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__DeprecatedKt$elementAtOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        int r15 = r0.I$1;
        r10 = r0.I$0;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        y r6 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        int r16 = r15;
        r12 = r6;
        Object r7 = r14;
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L35;
        Object r8 = r4.a();     // Catch: Throwable -> L37
        int r17 = r16 + 1;
        if (r10 != r16) goto L34;
        o.a(r12, null);
        return r8;
    L34:
        r16 = r17;
    L24:
        r0.L$0 = r12;     // Catch: Throwable -> L37
        r0.L$1 = r4;     // Catch: Throwable -> L37
        r0.I$0 = r10;     // Catch: Throwable -> L37
        r0.I$1 = r16;     // Catch: Throwable -> L37
        r0.label = 1;     // Catch: Throwable -> L37
        r7 = r4.a(r0);     // Catch: Throwable -> L37
        if (r7 != r2) goto L27;
        return r2;
    L35:
        o.a(r12, null);
        return null;
    L37:
        th = move-exception;
        r6 = r12;
        Throwable th = th;
    L47:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        o.a(r6, th);
        throw th;
    L14:
        th = th;
        goto L47
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        if (r10 >= 0) goto L22;
        o.a(r12, null);
        return null;
    L22:
        r16 = 0;
        r4 = r12.l();     // Catch: Throwable -> L37
    L7:
        r0 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a6 -> B:25:0x00a9). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r10, Object r11, Continuation r12) {
        y r13 = (y) ZeusTransformUtils.wrapperContextForParams(r10, y.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ChannelsKt__DeprecatedKt$lastIndexOf$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastIndexOf$1 r0 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) ZeusTransformUtils.preCheckCast(r14, ChannelsKt__DeprecatedKt$lastIndexOf$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$4, k.class, "com.obric.memorydata.plugin");
        y r17 = (y) ZeusTransformUtils.preCheckCast(r0.L$3, y.class, "com.obric.memorydata.plugin");
        Ref.IntRef r4 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r5 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Object r6 = r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L28;
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r17, null);
        return Boxing.boxInt(r5.element);
    L28:
        if (Intrinsics.areEqual(r6, r16.a()) == false) goto L30;
        r5.element = r4.element;     // Catch: Throwable -> L14
    L30:
        r4.element++;     // Catch: Throwable -> L14
        Object r19 = r6;
    L21:
        r0.L$0 = r19;     // Catch: Throwable -> L14
        r0.L$1 = r5;     // Catch: Throwable -> L14
        r0.L$2 = r4;     // Catch: Throwable -> L14
        r0.L$3 = r17;     // Catch: Throwable -> L14
        r0.L$4 = r16;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r7 = r16.a(r0);     // Catch: Throwable -> L14
        if (r7 != r2) goto L24;
        return r2;
    L24:
        r6 = r19;
        r15 = r7;
    L14:
        Throwable th = th;
    L42:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        o.a(r17, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Ref.IntRef r110 = new Ref.IntRef();
        r110.element = -1;
        r4 = new Ref.IntRef();
        r17 = r13;
        r16 = r13.l();     // Catch: Throwable -> L34
        r5 = r110;
        r19 = r11;
    L34:
        th = move-exception;
        r17 = r13;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(r14);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:25:0x0092). Please report as a decompilation issue!!! */
    public static final <E, C extends Collection<? super E>> Object b(y<? extends E> r8, C r9, Continuation<? super C> r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r8, y.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ChannelsKt__DeprecatedKt$toCollection$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$toCollection$1 r0 = (ChannelsKt__DeprecatedKt$toCollection$1) ZeusTransformUtils.preCheckCast(r13, ChannelsKt__DeprecatedKt$toCollection$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r16 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r0.L$0, Collection.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        ?? r5 = r4;
    L26:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L28;
        r5.add(r15.a());     // Catch: Throwable -> L14
        ?? r17 = r5;
    L21:
        r0.L$0 = r17;     // Catch: Throwable -> L14
        r0.L$1 = r16;     // Catch: Throwable -> L14
        r0.L$2 = r15;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        Object r6 = r15.a(r0);     // Catch: Throwable -> L14
        if (r6 != r2) goto L24;
        return r2;
    L24:
        r5 = r17;
        r14 = r6;
        goto L26
    L28:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r16, null);
        return r5;
    L14:
        Throwable th = th;
    L39:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        o.a(r16, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r16 = r11;
        r15 = r11.l();     // Catch: Throwable -> L31
        r17 = r12;
    L31:
        th = move-exception;
        r16 = r11;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$toCollection$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ee -> B:15:0x0073). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r9, Comparator r10, Continuation r11) {
        y r12 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Comparator r13 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ChannelsKt__DeprecatedKt$minWith$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$minWith$1 r0 = (ChannelsKt__DeprecatedKt$minWith$1) ZeusTransformUtils.preCheckCast(r14, ChannelsKt__DeprecatedKt$minWith$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L25;
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L19;
        Object r16 = r0.L$3;
        k r17 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r4 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.preCheckCast(r0.L$0, Comparator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L16
        ChannelsKt__DeprecatedKt$minWith$1 r8 = r0;
        Object r1 = r16;
        r12 = r4;
    L15:
        Object r6 = r2;
        ChannelsKt__DeprecatedKt$minWith$1 r7 = r8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L47;
        Object r18 = r17.a();     // Catch: Throwable -> L49
        if (r5.compare(r1, r18) > 0) goto L46;
        r18 = r1;
    L46:
        r0 = r7;
        r2 = r6;
    L36:
        r0.L$0 = r5;     // Catch: Throwable -> L49
        r0.L$1 = r12;     // Catch: Throwable -> L49
        r0.L$2 = r17;     // Catch: Throwable -> L49
        r0.L$3 = r18;     // Catch: Throwable -> L49
        r0.label = 2;     // Catch: Throwable -> L49
        Object r19 = r17.a(r0);     // Catch: Throwable -> L49
        if (r19 != r2) goto L39;
        return r2;
    L39:
        r8 = r0;
        r1 = r18;
        r15 = r19;
        goto L15
    L47:
        o.a(r12, null);
        return r1;
    L49:
        th = move-exception;
        y r110 = r12;
        th = th;
    L61:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        o.a(r110, th);
        throw th;
    L16:
        th = th;
        r110 = r4;
        goto L61
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        k r20 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        r110 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Comparator r21 = (Comparator) ZeusTransformUtils.preCheckCast(r0.L$0, Comparator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L34;
        o.a(r110, null);
        return null;
    L34:
        r18 = r20.a();     // Catch: Throwable -> L23
        r5 = r21;
        y r22 = r110;
        r17 = r20;
        r12 = r22;
    L23:
        th = th;
        goto L61
    L25:
        ResultKt.throwOnFailure(r15);
        k r111 = r12.l();     // Catch: Throwable -> L49
        r0.L$0 = r13;     // Catch: Throwable -> L49
        r0.L$1 = r12;     // Catch: Throwable -> L49
        r0.L$2 = r111;     // Catch: Throwable -> L49
        r0.label = 1;     // Catch: Throwable -> L49
        Object r23 = r111.a(r0);     // Catch: Throwable -> L49
        if (r23 != r2) goto L29;
        return r2;
    L29:
        r110 = r12;
        r20 = r111;
        r15 = r23;
        r21 = r13;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$minWith$1(r14);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(y r6, Continuation r7) {
        y r8 = (y) ZeusTransformUtils.wrapperContextForParams(r6, y.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ChannelsKt__DeprecatedKt$firstOrNull$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$firstOrNull$1 r0 = (ChannelsKt__DeprecatedKt$firstOrNull$1) ZeusTransformUtils.preCheckCast(r9, ChannelsKt__DeprecatedKt$firstOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r11 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L28;
        o.a(r1, null);
        return null;
    L28:
        Object r12 = r11.a();     // Catch: Throwable -> L14
        o.a(r1, null);
        return r12;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        o.a(r1, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r10);
        k r13 = r8.l();     // Catch: Throwable -> L31
        r0.L$0 = r8;     // Catch: Throwable -> L31
        r0.L$1 = r13;     // Catch: Throwable -> L31
        r0.label = 1;     // Catch: Throwable -> L31
        Object r4 = r13.a(r0);     // Catch: Throwable -> L31
        if (r4 != r2) goto L22;
        return r2;
    L22:
        r1 = r8;
        r11 = r13;
        r10 = r4;
    L31:
        th = move-exception;
        r1 = r8;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$firstOrNull$1(r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.channels.z] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [kotlinx.coroutines.channels.y] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.Object, kotlinx.coroutines.channels.y] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, kotlinx.coroutines.channels.z] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.channels.y] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00d7 -> B:14:0x006d). Please report as a decompilation issue!!! */
    public static final <E, C extends z<? super E>> Object b(y<? extends E> r9, C r10, Continuation<? super C> r11) {
        ?? r12 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        ?? r13 = (z) ZeusTransformUtils.wrapperContextForParams(r10, z.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, ChannelsKt__DeprecatedKt$toChannel$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$toChannel$1 r0 = (ChannelsKt__DeprecatedKt$toChannel$1) ZeusTransformUtils.preCheckCast(r14, ChannelsKt__DeprecatedKt$toChannel$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        k r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r17 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        z r4 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        ?? r5 = r4;
        ?? r18 = r17;
    L14:
        k r19 = r16;
        r12 = r18;
        ?? r110 = r5;
    L24:
        r0.L$0 = r110;     // Catch: Throwable -> L37
        r0.L$1 = r12;     // Catch: Throwable -> L37
        r0.L$2 = r19;     // Catch: Throwable -> L37
        r0.label = 1;     // Catch: Throwable -> L37
        Object r6 = r19.a(r0);     // Catch: Throwable -> L37
        if (r6 != r2) goto L27;
        return r2;
    L27:
        ?? r8 = r110;
        r13 = r12;
        r16 = r19;
        r15 = r6;
        ?? r7 = r8;
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L34;
        Object r111 = r16.a();     // Catch: Throwable -> L20
        r0.L$0 = r7;     // Catch: Throwable -> L20
        r0.L$1 = r13;     // Catch: Throwable -> L20
        r0.L$2 = r16;     // Catch: Throwable -> L20
        r0.label = 2;     // Catch: Throwable -> L20
        Object r112 = r7.send(r111, r0);     // Catch: Throwable -> L20
        r5 = r7;
        r18 = r13;
        if (r112 != r2) goto L14;
        return r2;
    L34:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L20
        o.a(r13, null);
        return r7;
    L37:
        th = move-exception;
        r13 = r12;
        th = th;
    L45:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        o.a(r13, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r113 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        z r21 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        r7 = r21;
        r13 = r113;
        goto L30
    L22:
        ResultKt.throwOnFailure(r15);
        r19 = r12.l();     // Catch: Throwable -> L37
        r12 = r12;
        r110 = r13;
    L20:
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$toChannel$1(r14);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c2 -> B:37:0x00c6). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object c(y r9, Continuation r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ChannelsKt__DeprecatedKt$last$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$last$1 r0 = (ChannelsKt__DeprecatedKt$last$1) ZeusTransformUtils.preCheckCast(r12, ChannelsKt__DeprecatedKt$last$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Object r14 = r0.L$2;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        y r5 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
    L38:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L42;
        Object r15 = r4.a();     // Catch: Throwable -> L15
        r11 = r5;
    L33:
        r0.L$0 = r11;     // Catch: Throwable -> L46
        r0.L$1 = r4;     // Catch: Throwable -> L46
        r0.L$2 = r15;     // Catch: Throwable -> L46
        r0.label = 2;     // Catch: Throwable -> L46
        Object r6 = r4.a(r0);     // Catch: Throwable -> L46
        if (r6 != r2) goto L36;
        return r2;
    L36:
        r5 = r11;
        r14 = r15;
        r13 = r6;
    L46:
        th = move-exception;
        y r7 = r11;
        th = th;
    L55:
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L42:
        o.a(r5, null);
        return r14;
    L15:
        th = th;
        r7 = r5;
        goto L55
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        k r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        r7 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L45;
        r15 = r16.a();     // Catch: Throwable -> L22
        y r8 = r7;
        r4 = r16;
        r11 = r8;
        goto L33
    L45:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L55
    L24:
        ResultKt.throwOnFailure(r13);
        k r17 = r11.l();     // Catch: Throwable -> L46
        r0.L$0 = r11;     // Catch: Throwable -> L46
        r0.L$1 = r17;     // Catch: Throwable -> L46
        r0.label = 1;     // Catch: Throwable -> L46
        Object r18 = r17.a(r0);     // Catch: Throwable -> L46
        if (r18 != r2) goto L28;
        return r2;
    L28:
        r7 = r11;
        r16 = r17;
        r13 = r18;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$last$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c7 -> B:39:0x00cb). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object d(y r9, Continuation r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ChannelsKt__DeprecatedKt$lastOrNull$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastOrNull$1 r0 = (ChannelsKt__DeprecatedKt$lastOrNull$1) ZeusTransformUtils.preCheckCast(r12, ChannelsKt__DeprecatedKt$lastOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Object r14 = r0.L$2;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        y r5 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
    L39:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L43;
        Object r15 = r4.a();     // Catch: Throwable -> L15
        r11 = r5;
    L35:
        r0.L$0 = r11;     // Catch: Throwable -> L45
        r0.L$1 = r4;     // Catch: Throwable -> L45
        r0.L$2 = r15;     // Catch: Throwable -> L45
        r0.label = 2;     // Catch: Throwable -> L45
        Object r6 = r4.a(r0);     // Catch: Throwable -> L45
        if (r6 != r2) goto L38;
        return r2;
    L38:
        r5 = r11;
        r14 = r15;
        r13 = r6;
    L45:
        th = move-exception;
        y r7 = r11;
        th = th;
    L57:
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L43:
        o.a(r5, null);
        return r14;
    L15:
        th = th;
        r7 = r5;
        goto L57
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        k r16 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        r7 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L33;
        o.a(r7, null);
        return null;
    L33:
        r15 = r16.a();     // Catch: Throwable -> L22
        y r8 = r7;
        r4 = r16;
        r11 = r8;
    L22:
        th = th;
        goto L57
    L24:
        ResultKt.throwOnFailure(r13);
        k r17 = r11.l();     // Catch: Throwable -> L45
        r0.L$0 = r11;     // Catch: Throwable -> L45
        r0.L$1 = r17;     // Catch: Throwable -> L45
        r0.label = 1;     // Catch: Throwable -> L45
        Object r18 = r17.a(r0);     // Catch: Throwable -> L45
        if (r18 != r2) goto L28;
        return r2;
    L28:
        r7 = r11;
        r16 = r17;
        r13 = r18;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$lastOrNull$1(r12);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object e(y r7, Continuation r8) {
        y r9 = (y) ZeusTransformUtils.wrapperContextForParams(r7, y.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, ChannelsKt__DeprecatedKt$single$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$single$1 r0 = (ChannelsKt__DeprecatedKt$single$1) ZeusTransformUtils.preCheckCast(r10, ChannelsKt__DeprecatedKt$single$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Object r12 = r0.L$1;
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15
    L37:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L41;
        o.a(r1, null);
        return r12;
    L41:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L15
    L15:
        Throwable th = th;
        y r4 = r1;
    L55:
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        o.a(r4, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        k r13 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        r4 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L43;
        Object r14 = r13.a();     // Catch: Throwable -> L22
        r0.L$0 = r4;     // Catch: Throwable -> L22
        r0.L$1 = r14;     // Catch: Throwable -> L22
        r0.label = 2;     // Catch: Throwable -> L22
        Object r15 = r13.a(r0);     // Catch: Throwable -> L22
        if (r15 != r2) goto L34;
        return r2;
    L34:
        r1 = r4;
        r11 = r15;
        r12 = r14;
        goto L37
    L43:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L55
    L24:
        ResultKt.throwOnFailure(r11);
        k r16 = r9.l();     // Catch: Throwable -> L44
        r0.L$0 = r9;     // Catch: Throwable -> L44
        r0.L$1 = r16;     // Catch: Throwable -> L44
        r0.label = 1;     // Catch: Throwable -> L44
        Object r5 = r16.a(r0);     // Catch: Throwable -> L44
        if (r5 != r2) goto L28;
        return r2;
    L28:
        r4 = r9;
        r13 = r16;
        r11 = r5;
    L44:
        th = move-exception;
        r4 = r9;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$single$1(r10);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object f(y r8, Continuation r9) {
        y r10 = (y) ZeusTransformUtils.wrapperContextForParams(r8, y.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, ChannelsKt__DeprecatedKt$singleOrNull$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$singleOrNull$1 r0 = (ChannelsKt__DeprecatedKt$singleOrNull$1) ZeusTransformUtils.preCheckCast(r11, ChannelsKt__DeprecatedKt$singleOrNull$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        Object r13 = r0.L$1;
        y r1 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L37:
        boolean r14 = ((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L15
        o.a(r1, null);
        if (r14 == false) goto L41;
        return null;
    L41:
        return r13;
    L15:
        Throwable th = th;
        y r4 = r1;
    L48:
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        o.a(r4, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        k r15 = (k) ZeusTransformUtils.preCheckCast(r0.L$1, k.class, "com.obric.memorydata.plugin");
        r4 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L33;
        o.a(r4, null);
        return null;
    L33:
        Object r16 = r15.a();     // Catch: Throwable -> L22
        r0.L$0 = r4;     // Catch: Throwable -> L22
        r0.L$1 = r16;     // Catch: Throwable -> L22
        r0.label = 2;     // Catch: Throwable -> L22
        Object r17 = r15.a(r0);     // Catch: Throwable -> L22
        if (r17 != r2) goto L36;
        return r2;
    L36:
        r1 = r4;
        r12 = r17;
        r13 = r16;
    L22:
        th = th;
        goto L48
    L24:
        ResultKt.throwOnFailure(r12);
        k r18 = r10.l();     // Catch: Throwable -> L42
        r0.L$0 = r10;     // Catch: Throwable -> L42
        r0.L$1 = r18;     // Catch: Throwable -> L42
        r0.label = 1;     // Catch: Throwable -> L42
        Object r5 = r18.a(r0);     // Catch: Throwable -> L42
        if (r5 != r2) goto L28;
        return r2;
    L28:
        r4 = r10;
        r15 = r18;
        r12 = r5;
    L42:
        th = move-exception;
        r4 = r10;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$singleOrNull$1(r11);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object g(y r5, Continuation r6) {
        y r7 = (y) ZeusTransformUtils.wrapperContextForParams(r5, y.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ChannelsKt__DeprecatedKt$any$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$any$1 r0 = (ChannelsKt__DeprecatedKt$any$1) ZeusTransformUtils.preCheckCast(r8, ChannelsKt__DeprecatedKt$any$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L22
    L20:
        o.a(r7, null);
        return r9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        k r10 = r7.l();     // Catch: Throwable -> L22
        r0.L$0 = r7;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        r9 = r10.a(r0);     // Catch: Throwable -> L22
        if (r9 != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$any$1(r8);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008b -> B:25:0x008e). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object h(y r9, Continuation r10) {
        y r11 = (y) ZeusTransformUtils.wrapperContextForParams(r9, y.class, "com.obric.memorydata.plugin");
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ChannelsKt__DeprecatedKt$count$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$count$1 r0 = (ChannelsKt__DeprecatedKt$count$1) ZeusTransformUtils.preCheckCast(r12, ChannelsKt__DeprecatedKt$count$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        k r14 = (k) ZeusTransformUtils.preCheckCast(r0.L$2, k.class, "com.obric.memorydata.plugin");
        y r4 = (y) ZeusTransformUtils.preCheckCast(r0.L$1, y.class, "com.obric.memorydata.plugin");
        Ref.IntRef r5 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(r0.L$0, Ref.IntRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
    L27:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
        r14.a();     // Catch: Throwable -> L14
        r5.element++;     // Catch: Throwable -> L14
        y r15 = r4;
    L40:
        r0.L$0 = r5;     // Catch: Throwable -> L32
        r0.L$1 = r15;     // Catch: Throwable -> L32
        r0.L$2 = r14;     // Catch: Throwable -> L32
        r0.label = 1;     // Catch: Throwable -> L32
        Object r6 = r14.a(r0);     // Catch: Throwable -> L32
        if (r6 != r2) goto L24;
        return r2;
    L24:
        r4 = r15;
        r13 = r6;
    L32:
        Throwable th = th;
        r4 = r15;
    L46:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        o.a(r4, th);
        throw th;
    L29:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L14
        o.a(r4, null);
        return Boxing.boxInt(r5.element);
    L14:
        th = th;
        goto L46
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        r5 = new Ref.IntRef();
        r15 = r11;
        r14 = r11.l();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r4 = r11;
        th = th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$count$1(r12);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object i(y r5, Continuation r6) {
        y r7 = (y) ZeusTransformUtils.wrapperContextForParams(r5, y.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, ChannelsKt__DeprecatedKt$none$1.class) == false) goto L7;
        ChannelsKt__DeprecatedKt$none$1 r0 = (ChannelsKt__DeprecatedKt$none$1) ZeusTransformUtils.preCheckCast(r8, ChannelsKt__DeprecatedKt$none$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r7 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L27
    L21:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L24;
        r4 = false;
    L24:
        Boolean r10 = Boxing.boxBoolean(r4);     // Catch: Throwable -> L27
        o.a(r7, null);
        return r10;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        k r11 = r7.l();     // Catch: Throwable -> L27
        r0.L$0 = r7;     // Catch: Throwable -> L27
        r0.label = 1;     // Catch: Throwable -> L27
        r9 = r11.a(r0);     // Catch: Throwable -> L27
        if (r9 != r2) goto L21;
        return r2;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        o.a(r7, th);
        throw th;
    L7:
        r0 = new ChannelsKt__DeprecatedKt$none$1(r8);
        goto L8
    }
}
