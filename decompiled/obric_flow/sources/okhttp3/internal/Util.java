package okhttp3.internal;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import f8.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import nu.a0;
import nu.j;
import nu.k;
import nu.l;
import nu.m;
import nu.u;
import okhttp3.OkHttpClient;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okhttp3.p0;
import okhttp3.q0;
import okhttp3.s0;
import okhttp3.v;
import okhttp3.v0;
import okhttp3.w;
import okhttp3.w0;
import okhttp3.z;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010,\u001a\u0011\u0010-\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\b/\u00100\u001a\u0015\u00101\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b1\u00100\u001a)\u00102\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u0002030\u000e\"\u000203¢\u0006\u0004\b2\u00105\u001a\u0019\u00109\u001a\u000207*\u0002062\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:\u001a'\u0010>\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?\u001a\u0011\u0010@\u001a\u00020\u001b*\u00020*¢\u0006\u0004\b@\u0010A\u001a\u0017\u0010E\u001a\u00020D*\b\u0012\u0004\u0012\u00020C0B¢\u0006\u0004\bE\u0010F\u001a\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020C0B*\u00020D¢\u0006\u0004\bG\u0010H\u001a\u0019\u0010I\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\bI\u0010J\u001a\u0011\u0010M\u001a\u00020L*\u00020K¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010Q\u001a\u00020\u001b*\u00020O2\u0006\u0010P\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bQ\u0010R\u001a\u001c\u0010Q\u001a\u00020\u001b*\u00020S2\u0006\u0010P\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bQ\u0010T\u001a\u001c\u0010Q\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010P\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bQ\u0010U\u001a\u0019\u0010X\u001a\u00020\u0004*\u00020V2\u0006\u0010W\u001a\u00020\u001b¢\u0006\u0004\bX\u0010Y\u001a\u0011\u0010Z\u001a\u00020\u001b*\u000206¢\u0006\u0004\bZ\u0010[\u001a!\u0010^\u001a\u00020\t*\u00020\\2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020<¢\u0006\u0004\b^\u0010_\u001a!\u0010a\u001a\u00020\t*\u00020\\2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020<¢\u0006\u0004\ba\u0010_\u001a\u0011\u0010c\u001a\u00020\u0007*\u00020b¢\u0006\u0004\bc\u0010d\u001a\u0019\u0010f\u001a\u00020\t*\u00020b2\u0006\u0010e\u001a\u000206¢\u0006\u0004\bf\u0010g\u001a!\u0010j\u001a\u00020\u00042\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00040hH\u0086\bø\u0001\u0000¢\u0006\u0004\bj\u0010k\u001a)\u0010l\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00040hH\u0086\bø\u0001\u0000¢\u0006\u0004\bl\u0010m\u001a\u0019\u0010^\u001a\u00020\u001b*\u00020n2\u0006\u0010o\u001a\u00020O¢\u0006\u0004\b^\u0010p\u001a\u001b\u0010q\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bq\u0010r\u001a\u0011\u0010t\u001a\u00020\u0000*\u00020s¢\u0006\u0004\bt\u0010u\u001a\u0019\u0010w\u001a\u00020\u0000*\u00020\u00072\u0006\u0010v\u001a\u00020\u0000¢\u0006\u0004\bw\u0010x\u001a\u001b\u0010y\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010v\u001a\u00020\u001b¢\u0006\u0004\by\u0010r\u001a#\u0010{\u001a\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010z*\b\u0012\u0004\u0012\u00028\u00000B¢\u0006\u0004\b{\u0010|\u001a/\u0010~\u001a\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010z2\u0012\u0010}\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\b~\u0010\u007f\u001a<\u0010\u0083\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001\"\u0005\b\u0000\u0010\u0080\u0001\"\u0005\b\u0001\u0010\u0081\u0001*\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0015\u0010\u0086\u0001\u001a\u00020\u0004*\u00030\u0085\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0014\u0010\u0086\u0001\u001a\u00020\u0004*\u00020b¢\u0006\u0006\b\u0086\u0001\u0010\u0088\u0001\u001a\u0015\u0010\u0086\u0001\u001a\u00020\u0004*\u00030\u0089\u0001¢\u0006\u0006\b\u0086\u0001\u0010\u008a\u0001\u001a\u001f\u0010\u008e\u0001\u001a\u00020\t*\u00030\u008b\u00012\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0014\u0010\u0090\u0001\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0014\u0010\u0090\u0001\u001a\u00020\u0007*\u00020\u001b¢\u0006\u0006\b\u0090\u0001\u0010\u0092\u0001\u001a\u0017\u0010\u0093\u0001\u001a\u00020\u0004*\u000203H\u0086\b¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0017\u0010\u0095\u0001\u001a\u00020\u0004*\u000203H\u0086\b¢\u0006\u0006\b\u0095\u0001\u0010\u0094\u0001\u001a\u0017\u0010\u0096\u0001\u001a\u00020\u0004*\u000203H\u0086\b¢\u0006\u0006\b\u0096\u0001\u0010\u0094\u0001\u001a:\u0010\u009b\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010z2\u0007\u0010\u0097\u0001\u001a\u0002032\u000e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0098\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0007¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a-\u0010 \u0001\u001a\u00020\u0004\"\u0005\b\u0000\u0010\u009d\u0001*\t\u0012\u0004\u0012\u00028\u00000\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001\u001a\u0017\u0010¢\u0001\u001a\u00020\u0004*\u000203H\u0080\b¢\u0006\u0006\b¢\u0001\u0010\u0094\u0001\u001a\u0017\u0010£\u0001\u001a\u00020\u0004*\u000203H\u0080\b¢\u0006\u0006\b£\u0001\u0010\u0094\u0001\u001a0\u0010¨\u0001\u001a\u00030§\u0001*\b0¤\u0001j\u0003`¥\u00012\u0013\u0010¦\u0001\u001a\u000e\u0012\n\u0012\b0¤\u0001j\u0003`¥\u00010B¢\u0006\u0006\b¨\u0001\u0010©\u0001\u001aI\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010z*\t\u0012\u0004\u0012\u00028\u00000ª\u00012\u001a\u0010\u00ad\u0001\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0«\u0001¢\u0006\u0003\b¬\u0001H\u0086\bø\u0001\u0000¢\u0006\u0006\b®\u0001\u0010¯\u0001\"\u0018\u0010±\u0001\u001a\u00030°\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001\"\u0017\u0010³\u0001\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001\"\u0018\u0010¶\u0001\u001a\u00030µ\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001\"\u0018\u0010¹\u0001\u001a\u00030¸\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001\"\u0018\u0010¼\u0001\u001a\u00030»\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001\"\u0018\u0010¿\u0001\u001a\u00030¾\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001\"\u0018\u0010Â\u0001\u001a\u00030Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001\"\u0017\u0010Ä\u0001\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001\"\u0017\u0010Æ\u0001\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001\"\u0017\u0010È\u0001\u001a\u00020\u00078\u0006X\u0086T¢\u0006\b\n\u0006\bÈ\u0001\u0010Ç\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006É\u0001"}, d2 = {"", "arrayLength", "offset", "count", "", "checkOffsetAndCount", "(JJJ)V", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/e0;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/e0;Z)Ljava/lang/String;", "value", "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "isSensitiveHeader", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lnu/l;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Lnu/l;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/c0;", "toHeaders", "(Ljava/util/List;)Lokhttp3/c0;", "toHeaderList", "(Lokhttp3/c0;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/e0;Lokhttp3/e0;)Z", "Lokhttp3/w;", "Lokhttp3/v;", "asFactory", "(Lokhttp3/w;)Lokhttp3/v;", "", "mask", "and", "(BI)I", "", "(SI)I", "(IJ)J", "Lnu/k;", "medium", "writeMedium", "(Lnu/k;I)V", "readMedium", "(Lnu/l;)I", "Lnu/c0;", "timeUnit", "skipAll", "(Lnu/c0;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "discard", "Ljava/net/Socket;", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", "source", "isHealthy", "(Ljava/net/Socket;Lnu/l;)Z", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "(Lkotlin/jvm/functions/Function0;)V", "threadName", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lnu/j;", "b", "(Lnu/j;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/s0;", "headersContentLength", "(Lokhttp3/s0;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", ExifInterface.GPS_DIRECTION_TRUE, "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;)Z", "toHexString", "(J)Ljava/lang/String;", "(I)Ljava/lang/String;", "wait", "(Ljava/lang/Object;)V", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "predicate", "filterList", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "EMPTY_BYTE_ARRAY", "[B", "EMPTY_HEADERS", "Lokhttp3/c0;", "Lokhttp3/w0;", "EMPTY_RESPONSE", "Lokhttp3/w0;", "Lokhttp3/q0;", "EMPTY_REQUEST", "Lokhttp3/q0;", "Lnu/u;", "UNICODE_BOMS", "Lnu/u;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "Z", "okHttpName", "Ljava/lang/String;", "userAgent", "okhttp"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "Util")
public final class Util {

    @JvmField
    public static final byte[] EMPTY_BYTE_ARRAY = null;

    @JvmField
    public static final c0 EMPTY_HEADERS = null;

    @JvmField
    public static final q0 EMPTY_REQUEST = null;

    @JvmField
    public static final w0 EMPTY_RESPONSE = null;
    private static final u UNICODE_BOMS = null;

    @JvmField
    public static final TimeZone UTC = null;
    private static final Regex VERIFY_AS_IP_ADDRESS = null;

    @JvmField
    public static final boolean assertionsEnabled = false;

    @JvmField
    public static final String okHttpName = null;
    public static final String userAgent = "okhttp/4.9.3";

    static {
        byte[] r5 = new byte[0];
        EMPTY_BYTE_ARRAY = r5;
        EMPTY_HEADERS = z.h(new String[0]);
        w0.Companion.getClass();
        EMPTY_RESPONSE = v0.c(r5, null);
        EMPTY_REQUEST = p0.c(q0.Companion, r5, null, 0, 7);
        int r10 = u.f20340c;
        ByteString.Companion.getClass();
        UNICODE_BOMS = b.n(new ByteString[]{m.b("efbbbf"), m.b("feff"), m.b("fffe"), m.b("0000ffff"), m.b("ffff0000")});
        TimeZone r11 = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(r11);
        UTC = r11;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        okHttpName = StringsKt.B(StringsKt.A(OkHttpClient.class.getName(), "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> r5, E r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$addIfAbsent");
        if (r5.contains(r10) == true) goto L6;
        r5.add(r10);
        return;
    }

    public static final int and(byte r5, int r10) {
        return r5 & r10;
    }

    public static final v asFactory(final w r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$asFactory");
        return new AnonymousClass1(r5);
    }

    public static final void assertThreadDoesntHoldLock(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled == true) goto L5;
        return;
    L5:
        if (Thread.holdsLock(r5) == true) goto L8;
        return;
    L8:
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r5);
    }

    public static final void assertThreadHoldsLock(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$assertThreadHoldsLock");
        if (assertionsEnabled == true) goto L5;
        return;
    L5:
        if (Thread.holdsLock(r5) == false) goto L8;
        return;
    L8:
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r5);
    }

    public static final boolean canParseAsIpAddress(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(r5);
    }

    public static final boolean canReuseConnectionFor(e0 r5, e0 r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$canReuseConnectionFor");
        Intrinsics.checkNotNullParameter(r10, "other");
        if (Intrinsics.areEqual(r5.e, r10.e) == true) goto L5;
    L9:
        return false;
    L5:
        if (r5.f != r10.f) goto L9;
        if (Intrinsics.areEqual(r5.f20640b, r10.f20640b) == false) goto L9;
        return true;
    }

    public static final int checkDuration(String r10, long r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        boolean r5 = false;
        if (r11 < 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L30;
        if (r12 == null) goto L9;
        boolean r14 = true;
    L10:
        if (r14 == false) goto L28;
        long r15 = r12.toMillis(r11);
        if (r15 > Integer.MAX_VALUE) goto L14;
        boolean r16 = true;
    L15:
        if (r16 == false) goto L26;
        if (r15 != 0) goto L19;
        if (r11 <= 0) goto L19;
    L20:
        if (r5 == false) goto L24;
        return (int) r15;
    L24:
        throw new IllegalArgumentException(j0.j(r10, " too small.").toString());
    L19:
        r5 = true;
        goto L20
    L26:
        throw new IllegalArgumentException(j0.j(r10, " too large.").toString());
    L14:
        r16 = false;
        goto L15
    L28:
        throw new IllegalStateException("unit == null");
    L9:
        r14 = false;
        goto L10
    L30:
        throw new IllegalStateException(j0.j(r10, " < 0").toString());
    L5:
        r13 = false;
        goto L6
    }

    public static final void checkOffsetAndCount(long r5, long r10, long r11) {
        if ((r10 | r11) < 0) goto L10;
        if (r10 > r5) goto L10;
        if ((r5 - r10) < r11) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final void closeQuietly(Closeable r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$closeQuietly");
        r5.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final String[] concat(String[] r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$concat");
        Intrinsics.checkNotNullParameter(r10, "value");
        String[] r11 = (String[]) Arrays.copyOf(r5, r5.length + 1);
        r11[ArraysKt.getLastIndex(r11)] = r10;
        return r11;
    }

    public static final int delimiterOffset(String r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$delimiterOffset");
        Intrinsics.checkNotNullParameter(r10, "delimiters");
    L3:
        if (r11 >= r12) goto L8;
        if (StringsKt.f(r10, r5.charAt(r11)) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return r12;
    }

    public static /* synthetic */ int delimiterOffset$default(String r5, String r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = r5.length();
    L9:
        return delimiterOffset(r5, r10, r11, r12);
    }

    public static final boolean discard(nu.c0 r5, int r10, TimeUnit r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$discard");
        Intrinsics.checkNotNullParameter(r11, "timeUnit");
        return skipAll(r5, r10, r11);
    L5:
        return false;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$filterList");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        List<T> r11 = CollectionsKt.emptyList();
        Iterator<? extends T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        T r13 = r12.next();
        if (r10.invoke(r13).booleanValue() == false) goto L4;
        if (r11.isEmpty() == false) goto L10;
        r11 = new ArrayList();
    L10:
        TypeIntrinsics.asMutableList(r11).add(r13);
        goto L4
    L11:
        return r11;
    }

    public static final String format(String r5, Object... r10) {
        Intrinsics.checkNotNullParameter(r5, "format");
        Intrinsics.checkNotNullParameter(r10, "args");
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        Locale r12 = Locale.US;
        Object[] r13 = Arrays.copyOf(r10, r10.length);
        return String.format(r12, r5, Arrays.copyOf(r13, r13.length));
    }

    public static final boolean hasIntersection(String[] r10, String[] r11, Comparator<? super String> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$hasIntersection");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        if (r10.length == 0) goto L19;
        if (r11 == null) goto L19;
        if (r11.length == 0) goto L19;
        int r5 = r10.length;
        int r13 = 0;
    L10:
        if (r13 >= r5) goto L19;
        String r14 = r10[r13];
        int r15 = r11.length;
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L18;
        if (r12.compare(r14, r11[r16]) == 0) goto L15;
        r16 = r16 + 1;
        goto L12
    L15:
        return true;
    L18:
        r13 = r13 + 1;
    L19:
        return false;
    }

    public static final long headersContentLength(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$headersContentLength");
        String r10 = r5.g.b("Content-Length");
        if (r10 != null) goto L5;
        return -1;
    L5:
        return toLongOrDefault(r10, -1);
    }

    public static final void ignoreIoExceptions(Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        r5.invoke();     // Catch: IOException -> L5
        return;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        Object[] r10 = (Object[]) r5.clone();
        return Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(r10, r10.length)));
    }

    public static final int indexOf(String[] r5, String r10, Comparator<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$indexOf");
        Intrinsics.checkNotNullParameter(r10, "value");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        int r12 = r5.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        if (r11.compare(r5[r13], r10) == 0) goto L12;
        r13 = r13 + 1;
        goto L3
    L12:
        return r13;
    L8:
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$indexOfControlOrNonAscii");
        int r10 = r5.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        char r12 = r5.charAt(r11);
        if (Intrinsics.compare(r12, 31) <= 0) goto L10;
        if (Intrinsics.compare(r12, 127) >= 0) goto L10;
        r11 = r11 + 1;
    L10:
        return r11;
    L11:
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$indexOfFirstNonAsciiWhitespace");
    L3:
        if (r10 >= r11) goto L16;
        char r12 = r5.charAt(r10);
        if (r12 == '\t') goto L15;
        if (r12 == '\n') goto L15;
        if (r12 == '\f') goto L15;
        if (r12 == '\r') goto L15;
        if (r12 == ' ') goto L15;
        return r10;
    L15:
        r10 = r10 + 1;
        goto L3
    L16:
        return r11;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        return indexOfFirstNonAsciiWhitespace(r5, r10, r11);
    }

    public static final int indexOfLastNonAsciiWhitespace(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$indexOfLastNonAsciiWhitespace");
        int r12 = r11 - 1;
        if (r12 < r10) goto L18;
    L4:
        char r13 = r5.charAt(r12);
        if (r13 != '\t') goto L7;
    L16:
        if (r12 == r10) goto L18;
        r12 = r12 - 1;
        goto L4
    L7:
        if (r13 == '\n') goto L16;
        if (r13 == '\f') goto L16;
        if (r13 == '\r') goto L16;
        if (r13 == ' ') goto L16;
        return r12 + 1;
    L18:
        return r10;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        return indexOfLastNonAsciiWhitespace(r5, r10, r11);
    }

    public static final int indexOfNonWhitespace(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$indexOfNonWhitespace");
        int r11 = r5.length();
    L3:
        if (r10 >= r11) goto L11;
        char r12 = r5.charAt(r10);
        if (r12 == ' ') goto L9;
        if (r12 == '\t') goto L9;
        return r10;
    L9:
        r10 = r10 + 1;
        goto L3
    L11:
        return r5.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String r5, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        return indexOfNonWhitespace(r5, r10);
    }

    public static final String[] intersect(String[] r10, String[] r11, Comparator<? super String> r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$intersect");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "comparator");
        ArrayList r5 = new ArrayList();
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        String r15 = r10[r14];
        int r16 = r11.length;
        int r17 = 0;
    L5:
        if (r17 >= r16) goto L10;
        if (r12.compare(r15, r11[r17]) == 0) goto L8;
        r17 = r17 + 1;
        goto L5
    L8:
        r5.add(r15);
    L10:
        r14 = r14 + 1;
        goto L3
    L11:
        Object[] r18 = r5.toArray(new String[0]);
        if (r18 == null) goto L16;
        return (String[]) r18;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(FileSystem r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$isCivilized");
        Intrinsics.checkNotNullParameter(r10, "file");
        a0 r11 = r5.sink(r10);
        r5.delete(r10);     // Catch: Throwable -> L6 IOException -> L8
        CloseableKt.closeFinally(r11, null);
        return true;
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        r5.delete(r10);
        return false;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static final boolean isHealthy(Socket r5, l r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$isHealthy");
        Intrinsics.checkNotNullParameter(r10, "source");
        int r11 = r5.getSoTimeout();     // Catch: IOException -> L10 SocketTimeoutException -> L12
        r5.setSoTimeout(1);     // Catch: Throwable -> L7
        boolean r12 = !r10.y();
        r5.setSoTimeout(r11);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        return r12;
    L7:
        th = move-exception;
        r5.setSoTimeout(r11);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        throw th;     // Catch: IOException -> L10 SocketTimeoutException -> L12
    L10:
        return false;
    L17:
        return true;
    }

    public static final boolean isSensitiveHeader(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        if (StringsKt.l(r5, "Authorization") == false) goto L5;
    L12:
        return true;
    L5:
        if (StringsKt.l(r5, "Cookie") == true) goto L12;
        if (StringsKt.l(r5, "Proxy-Authorization") == true) goto L12;
        if (StringsKt.l(r5, "Set-Cookie") == true) goto L12;
        return false;
    }

    public static final void notify(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$notify");
        r5.notify();
    }

    public static final void notifyAll(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$notifyAll");
        r5.notifyAll();
    }

    public static final int parseHexDigit(char r5) {
        if ('0' > r5) goto L9;
        if ('9' < r5) goto L9;
        return r5 - '0';
    L9:
        if ('a' > r5) goto L15;
        if ('f' < r5) goto L15;
        return r5 - 'W';
    L15:
        if ('A' <= r5) goto L18;
    L20:
        return -1;
    L18:
        if ('F' < r5) goto L20;
        return r5 - '7';
    }

    public static final String peerName(Socket r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$peerName");
        SocketAddress r10 = r5.getRemoteSocketAddress();
        if ((r10 instanceof InetSocketAddress) == false) goto L6;
        return ((InetSocketAddress) r10).getHostName();
    L6:
        return r10.toString();
    }

    public static final Charset readBomAsCharset(l r5, Charset r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "$this$readBomAsCharset");
        Intrinsics.checkNotNullParameter(r10, "default");
        int r11 = r5.D(UNICODE_BOMS);
        if (r11 == (-1)) goto L21;
        if (r11 == 0) goto L20;
        if (r11 == 1) goto L25;
        if (r11 == 2) goto L24;
        if (r11 == 3) goto L23;
        if (r11 != 4) goto L15;
        return Charsets.INSTANCE.UTF32_LE();
    L15:
        throw new AssertionError();
    L23:
        return Charsets.INSTANCE.UTF32_BE();
    L24:
        return StandardCharsets.UTF_16LE;
    L25:
        return StandardCharsets.UTF_16BE;
    L20:
        return StandardCharsets.UTF_8;
    L21:
        return r10;
    }

    public static final <T> T readFieldOrNull(Object r5, Class<T> r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "instance");
        Intrinsics.checkNotNullParameter(r10, "fieldType");
        Intrinsics.checkNotNullParameter(r11, "fieldName");
        Class<?> r12 = r5.getClass();
    L3:
        T r13 = null;
        if (Intrinsics.areEqual(r12, Object.class) == true) goto L12;
        Field r14 = r12.getDeclaredField(r11);     // Catch: NoSuchFieldException -> L10
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L10
        Object r15 = r14.get(r5);     // Catch: NoSuchFieldException -> L10
        if (r10.isInstance(r15) == false) goto L9;
        r13 = r10.cast(r15);     // Catch: NoSuchFieldException -> L10
    L9:
        return r13;
    L10:
        r12 = r12.getSuperclass();
        goto L3
    L12:
        if (Intrinsics.areEqual(r11, "delegate") == true) goto L17;
        Object r16 = readFieldOrNull(r5, Object.class, "delegate");
        if (r16 == null) goto L17;
        return (T) readFieldOrNull(r16, r10, r11);
    L17:
        return null;
    }

    public static final int readMedium(l r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "$this$readMedium");
        int r10 = (and(r5.readByte(), 255) << 16) | (and(r5.readByte(), 255) << 8);
        return and(r5.readByte(), 255) | r10;
    }

    public static final boolean skipAll(nu.c0 r11, int r12, TimeUnit r13) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "$this$skipAll");
        Intrinsics.checkNotNullParameter(r13, "timeUnit");
        long r5 = System.nanoTime();
        if (r11.timeout().hasDeadline() == false) goto L5;
        long r10 = r11.timeout().deadlineNanoTime() - r5;
    L6:
        r11.timeout().deadlineNanoTime(Math.min(r10, r13.toNanos(r12)) + r5);
        j r14 = new j();     // Catch: Throwable -> L12 InterruptedIOException -> L24
    L9:
        if (r11.read(r14, 8192) == (-1)) goto L15;
        r14.b();     // Catch: Throwable -> L12 InterruptedIOException -> L24
        goto L25
    L15:
        if (r10 != Long.MAX_VALUE) goto L17;
        r11.timeout().clearDeadline();
    L18:
        return true;
    L17:
        r11.timeout().deadlineNanoTime(r5 + r10);
    L12:
        th = move-exception;
        if (r10 != Long.MAX_VALUE) goto L22;
        r11.timeout().clearDeadline();
    L23:
        throw th;
    L22:
        r11.timeout().deadlineNanoTime(r5 + r10);
    L25:
        if (r10 != Long.MAX_VALUE) goto L27;
        r11.timeout().clearDeadline();
    L28:
        return false;
    L27:
        r11.timeout().deadlineNanoTime(r5 + r10);
        goto L28
    L5:
        r10 = Long.MAX_VALUE;
        goto L6
    }

    public static final ThreadFactory threadFactory(final String r5, final boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        return new ThreadFactoryC02781(r5, r10);
    }

    public static final void threadName(String r5, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "block");
        Thread r11 = Thread.currentThread();
        String r12 = r11.getName();
        r11.setName(r5);
        r10.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r11.setName(r12);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r11.setName(r12);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final List<Header> toHeaderList(c0 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHeaderList");
        IntRange r10 = RangesKt.until(0, r5.size());
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<Integer> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        int r13 = ((IntIterator) r12).nextInt();
        r11.add(new Header(r5.c(r13), r5.e(r13)));
        goto L4
    L6:
        return r11;
    }

    public static final c0 toHeaders(List<Header> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHeaders");
        ArrayList r10 = new ArrayList(20);
        Iterator<Header> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Header r12 = r11.next();
        ByteString r13 = r12.component1();
        ByteString r14 = r12.component2();
        String r15 = r13.utf8();
        String r16 = r14.utf8();
        Intrinsics.checkNotNullParameter(r15, "name");
        Intrinsics.checkNotNullParameter(r16, "value");
        r10.add(r15);
        r10.add(StringsKt.trim(r16).toString());
        goto L4
    L6:
        Object[] r17 = r10.toArray(new String[0]);
        if (r17 == null) goto L11;
        return new c0((String[]) r17);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final String toHexString(long r5) {
        return Long.toHexString(r5);
    }

    public static final String toHostHeader(e0 r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$toHostHeader");
        boolean r11 = StringsKt.g(r5.e, ":");
        String r12 = r5.e;
        if (r11 == false) goto L5;
        r12 = a.p("[", ']', r12);
    L5:
        int r13 = r5.f;
        if (r10 == true) goto L21;
        String r14 = r5.f20640b;
        Intrinsics.checkNotNullParameter(r14, "scheme");
        int r15 = r14.hashCode();
        if (r15 == 3213448) goto L16;
        if (r15 == 99617003) goto L13;
    L18:
        int r16 = -1;
    L19:
        if (r13 != r16) goto L21;
        return r12;
    L13:
        if (r14.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L18;
        r16 = 443;
        goto L19
    L16:
        if (r14.equals("http") == false) goto L18;
        r16 = 80;
    L21:
        return r12 + ':' + r13;
    }

    public static /* synthetic */ String toHostHeader$default(e0 r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return toHostHeader(r5, r10);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toImmutableList");
        return Collections.unmodifiableList(CollectionsKt.toMutableList(r5));
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toImmutableMap");
        if (r5.isEmpty() == false) goto L6;
        return MapsKt.emptyMap();
    L6:
        return Collections.unmodifiableMap(new LinkedHashMap(r5));
    }

    public static final long toLongOrDefault(String r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$toLongOrDefault");
        return Long.parseLong(r5);
    L8:
        return r10;
    }

    public static final int toNonNegativeInt(String r5, int r10) {
        if (r5 != null) goto L14;
    L12:
        return r10;
    L14:
        long r11 = Long.parseLong(r5);     // Catch: NumberFormatException -> L13
        if (r11 <= Integer.MAX_VALUE) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r11 >= 0) goto L11;
        return 0;
    L11:
        return (int) r11;
    }

    public static final String trimSubstring(String r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$trimSubstring");
        int r12 = indexOfFirstNonAsciiWhitespace(r5, r10, r11);
        return r5.substring(r12, indexOfLastNonAsciiWhitespace(r5, r12, r11));
    }

    public static /* synthetic */ String trimSubstring$default(String r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.length();
    L9:
        return trimSubstring(r5, r10, r11);
    }

    public static final void wait(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$wait");
        r5.wait();
    }

    public static final Throwable withSuppressed(Exception r5, List<? extends Exception> r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$withSuppressed");
        Intrinsics.checkNotNullParameter(r10, "suppressed");
        if (r10.size() <= 1) goto L5;
        System.out.println(r10);
    L5:
        Iterator<? extends Exception> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        ExceptionsKt.addSuppressed(r5, r11.next());
        goto L7
    L9:
        return r5;
    }

    public static final void writeMedium(k r5, int r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "$this$writeMedium");
        r5.writeByte((r10 >>> 16) & 255);
        r5.writeByte((r10 >>> 8) & 255);
        r5.writeByte(r10 & 255);
    }

    public static final int and(short r5, int r10) {
        return r5 & r10;
    }

    public static final int delimiterOffset(String r5, char r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$delimiterOffset");
    L3:
        if (r11 >= r12) goto L8;
        if (r5.charAt(r11) == r10) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return r12;
    }

    public static /* synthetic */ int delimiterOffset$default(String r5, char r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = r5.length();
    L9:
        return delimiterOffset(r5, r10, r11, r12);
    }

    public static final String toHexString(int r5) {
        return Integer.toHexString(r5);
    }

    public static final long and(int r5, long r10) {
        return ((long) r5) & r10;
    }

    public static final void closeQuietly(Socket r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$closeQuietly");
        r5.close();     // Catch: Exception -> L12 RuntimeException -> L5 AssertionError -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), "bio == null") == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static final void closeQuietly(ServerSocket r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$closeQuietly");
        r5.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final int skipAll(j r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$skipAll");
        int r11 = 0;
    L4:
        if (r5.y() == true) goto L8;
        if (r5.m(0) != r10) goto L8;
        r11 = r11 + 1;
        r5.readByte();
    L8:
        return r11;
    }
}
