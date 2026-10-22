package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013\u001a'\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d\"\u00020\u001e¢\u0006\u0002\u0010\u001f\u001a\u0017\u0010 \u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"H\u0086\b\u001a-\u0010#\u001a\b\u0012\u0004\u0012\u0002H%0$\"\u0004\b\u0000\u0010%2\u0012\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u0002H%0\u001d\"\u0002H%H\u0007¢\u0006\u0002\u0010'\u001a1\u0010(\u001a\u0004\u0018\u0001H%\"\u0004\b\u0000\u0010%2\u0006\u0010)\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H%0+2\u0006\u0010,\u001a\u00020\u0011¢\u0006\u0002\u0010-\u001a\u0016\u0010.\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00100\u001a\u000201\u001a\u001f\u00102\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"H\u0086\b\u001a\u0015\u00103\u001a\u00020\u000f*\u0002042\u0006\u00105\u001a\u00020\u000fH\u0086\u0004\u001a\u0015\u00103\u001a\u00020\u0013*\u00020\u000f2\u0006\u00105\u001a\u00020\u0013H\u0086\u0004\u001a\u0015\u00103\u001a\u00020\u000f*\u0002062\u0006\u00105\u001a\u00020\u000fH\u0086\u0004\u001a\n\u00107\u001a\u000208*\u000209\u001a\n\u0010:\u001a\u000201*\u00020\u0011\u001a\u0012\u0010;\u001a\u000201*\u00020<2\u0006\u0010=\u001a\u00020<\u001a\n\u0010>\u001a\u00020\u0017*\u00020?\u001a\n\u0010>\u001a\u00020\u0017*\u00020@\u001a\n\u0010>\u001a\u00020\u0017*\u00020A\u001a#\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d*\b\u0012\u0004\u0012\u00020\u00110\u001d2\u0006\u0010C\u001a\u00020\u0011¢\u0006\u0002\u0010D\u001a\n\u0010E\u001a\u00020\u0011*\u00020A\u001a&\u0010F\u001a\u00020\u000f*\u00020\u00112\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u000f\u001a&\u0010F\u001a\u00020\u000f*\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\b\b\u0002\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u000f\u001a\u001a\u0010L\u001a\u000201*\u00020M2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u0015\u001a%\u0010P\u001a\u00020\u0017*\u00020Q2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0004\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"H\u0086\b\u001a5\u0010R\u001a\u000201*\b\u0012\u0004\u0012\u00020\u00110\u001d2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001d2\u000e\u0010S\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110T¢\u0006\u0002\u0010U\u001a\n\u0010V\u001a\u00020\u0013*\u00020W\u001a+\u0010X\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110\u001d2\u0006\u0010C\u001a\u00020\u00112\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00110T¢\u0006\u0002\u0010Y\u001a\n\u0010Z\u001a\u00020\u000f*\u00020\u0011\u001a\u001e\u0010[\u001a\u00020\u000f*\u00020\u00112\b\b\u0002\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u000f\u001a\u001e\u0010\\\u001a\u00020\u000f*\u00020\u00112\b\b\u0002\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u000f\u001a\u0014\u0010]\u001a\u00020\u000f*\u00020\u00112\b\b\u0002\u0010I\u001a\u00020\u000f\u001a9\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d*\b\u0012\u0004\u0012\u00020\u00110\u001d2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00110\u001d2\u000e\u0010S\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110T¢\u0006\u0002\u0010_\u001a\u0012\u0010`\u001a\u00020\u0017*\u00020\u001e2\u0006\u0010a\u001a\u00020\u0013\u001a\r\u0010b\u001a\u00020\u0017*\u00020\u001eH\u0086\b\u001a\r\u0010c\u001a\u00020\u0017*\u00020\u001eH\u0086\b\u001a\n\u0010d\u001a\u00020\u000f*\u00020H\u001a\u0012\u0010e\u001a\u00020f*\u00020g2\u0006\u0010h\u001a\u00020f\u001a\n\u0010i\u001a\u00020\u000f*\u00020g\u001a\u0012\u0010j\u001a\u00020\u000f*\u00020k2\u0006\u0010l\u001a\u000204\u001a\u001a\u0010j\u001a\u000201*\u00020M2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u0015\u001a\u0010\u0010m\u001a\b\u0012\u0004\u0012\u00020n0$*\u00020\u0003\u001a\u0010\u0010o\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020n0$\u001a\n\u0010p\u001a\u00020\u0011*\u00020\u000f\u001a\n\u0010p\u001a\u00020\u0011*\u00020\u0013\u001a\u0014\u0010q\u001a\u00020\u0011*\u00020<2\b\b\u0002\u0010r\u001a\u000201\u001a\u001c\u0010s\u001a\b\u0012\u0004\u0012\u0002H%0$\"\u0004\b\u0000\u0010%*\b\u0012\u0004\u0012\u0002H%0$\u001a.\u0010t\u001a\u000e\u0012\u0004\u0012\u0002Hv\u0012\u0004\u0012\u0002Hw0u\"\u0004\b\u0000\u0010v\"\u0004\b\u0001\u0010w*\u000e\u0012\u0004\u0012\u0002Hv\u0012\u0004\u0012\u0002Hw0u\u001a\u0012\u0010x\u001a\u00020\u0013*\u00020\u00112\u0006\u0010y\u001a\u00020\u0013\u001a\u0014\u0010z\u001a\u00020\u000f*\u0004\u0018\u00010\u00112\u0006\u0010y\u001a\u00020\u000f\u001a\u001e\u0010{\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010I\u001a\u00020\u000f2\b\b\u0002\u0010J\u001a\u00020\u000f\u001a%\u0010|\u001a\u00020\u0017*\u00020Q2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\b\u0004\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\"H\u0086\b\u001a\r\u0010}\u001a\u00020\u0017*\u00020\u001eH\u0086\b\u001a\u001c\u0010~\u001a\u00020\u0017*\u00020\u001e2\u0006\u0010N\u001a\u00020\u00132\b\b\u0002\u0010a\u001a\u00020\u000f\u001a\u0014\u0010\u007f\u001a\u00020\u0017*\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u000f\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "checkDuration", "", ActivityLifecycle.NAME, "", "duration", "", Scraps.INNER_UNIT, "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", TypedValues.CycleType.S_WAVE_OFFSET, CommonConsts.COUNT_TYPE, "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", ExifInterface.GPS_DIRECTION_TRUE, "elements", "([Ljava/lang/Object;)Ljava/util/List;", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "", "threadName", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", EventBody.KEY_VALUE, "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "connectionName", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", LocationMonitorConst.TIMEOUT, "timeUnit", "execute", "Ljava/util/concurrent/Executor;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "lockAndWaitNanos", "nanos", "notify", "notifyAll", "parseHexDigit", "readBomAsCharset", "Ljava/nio/charset/Charset;", "Lokio/BufferedSource;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "tryExecute", "wait", "waitMillis", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, k = 2, mv = {1, 1, 15})
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final Headers EMPTY_HEADERS = null;
    public static final RequestBody EMPTY_REQUEST = null;
    public static final ResponseBody EMPTY_RESPONSE = null;
    private static final Options UNICODE_BOMS = null;
    public static final TimeZone UTC = null;
    private static final Regex VERIFY_AS_IP_ADDRESS = null;

    /* JADX INFO: renamed from: okhttp3.internal.Util$execute$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
    public static final class RunnableC12871 implements Runnable {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ String $name;

        public RunnableC12871(String r3, Function0 r4) {
            Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            this.$name = r3;
            this.$block = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r0 = this.$name;
            Thread r1 = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(r1, "currentThread");
            String r2 = r1.getName();
            r1.setName(r0);
            this.$block.invoke();     // Catch: Throwable -> L6
            r1.setName(r2);
            return;
        L6:
            th = move-exception;
            r1.setName(r2);
            throw th;
        }
    }

    static {
        byte[] r2 = new byte[0];
        EMPTY_BYTE_ARRAY = r2;
        EMPTY_HEADERS = Headers.Companion.of(new String[0]);
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, r2, null, 1, null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, r2, null, 0, 0, 7, null);
        UNICODE_BOMS = Options.Companion.of(new ByteString[]{ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000")});
        TimeZone r0 = TimeZone.getTimeZone("GMT");
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        UTC = r0;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static final int and(byte r0, int r1) {
        return r0 & r1;
    }

    public static final int and(short r0, int r1) {
        return r0 & r1;
    }

    public static final long and(int r2, long r3) {
        return ((long) r2) & r3;
    }

    public static final EventListener.Factory asFactory(final EventListener r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$asFactory");
        return (EventListener.Factory) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), EventListener.Factory.class, "com.obric.memorydata.plugin");
    }

    public static final boolean canParseAsIpAddress(String r3) {
        Intrinsics.checkParameterIsNotNull(r3, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean canReuseConnectionFor(HttpUrl r2, HttpUrl r3) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$canReuseConnectionFor");
        Intrinsics.checkParameterIsNotNull(r3, "other");
        if (Intrinsics.areEqual(r2.host(), r3.host()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.port() != r3.port()) goto L9;
        if (Intrinsics.areEqual(r2.scheme(), r3.scheme()) == false) goto L9;
        return true;
    }

    public static final int checkDuration(String r9, long r10, TimeUnit r12) {
        Intrinsics.checkParameterIsNotNull(r9, ActivityLifecycle.NAME);
        boolean r3 = true;
        if (r10 < 0) goto L5;
        boolean r5 = true;
    L7:
        if (r5 == false) goto L32;
        if (r12 == null) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L30;
        long r11 = r12.toMillis(r10);
        if (r11 > Integer.MAX_VALUE) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == false) goto L28;
        if (r11 != 0) goto L22;
        if (r10 <= 0) goto L22;
        r3 = false;
    L22:
        if (r3 == false) goto L26;
        return (int) r11;
    L26:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((r9 + " too small.").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L28:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((r9 + " too large.").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        r13 = false;
        goto L16
    L30:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("unit == null".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        r6 = false;
        goto L11
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException((r9 + " < 0").toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r5 = false;
        goto L7
    }

    public static final void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final void closeQuietly(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$this$closeQuietly");
        r3.close();     // Catch: Exception -> L8 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final void closeQuietly(ServerSocket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$closeQuietly");
        r2.close();     // Catch: Exception -> L8 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final void closeQuietly(Socket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$closeQuietly");
        r2.close();     // Catch: Exception -> L11 RuntimeException -> L5 AssertionError -> L8
        return;
    L8:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static final String[] concat(String[] r2, String r3) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$concat");
        Intrinsics.checkParameterIsNotNull(r3, EventBody.KEY_VALUE);
        Object[] r4 = Arrays.copyOf(r2, r2.length + 1);
        Intrinsics.checkExpressionValueIsNotNull(r4, "java.util.Arrays.copyOf(this, newSize)");
        String[] r5 = (String[]) ZeusTransformUtils.preCheckCast(r4, String[].class, "com.obric.memorydata.plugin");
        r5[ArraysKt.getLastIndex(r5)] = r3;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
    }

    public static final String connectionName(Socket r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$connectionName");
        SocketAddress r3 = r2.getRemoteSocketAddress();
        if (ZeusTransformUtils.instanceOf(r3, InetSocketAddress.class) == false) goto L6;
        String r4 = ((InetSocketAddress) ZeusTransformUtils.preCheckCast(r3, InetSocketAddress.class, "com.obric.memorydata.plugin")).getHostName();
        Intrinsics.checkExpressionValueIsNotNull(r4, "address.hostName");
        return r4;
    L6:
        return r3.toString();
    }

    public static final int delimiterOffset(String r1, char r2, int r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$delimiterOffset");
    L3:
        if (r3 >= r4) goto L8;
        if (r1.charAt(r3) == r2) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return r4;
    }

    public static final int delimiterOffset(String r5, String r6, int r7, int r8) {
        Intrinsics.checkParameterIsNotNull(r5, "$this$delimiterOffset");
        Intrinsics.checkParameterIsNotNull(r6, "delimiters");
    L3:
        if (r7 >= r8) goto L8;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), r5.charAt(r7), false, 2, null) == true) goto L6;
        r7 = r7 + 1;
        goto L3
    L6:
        return r7;
    L8:
        return r8;
    }

    public static /* synthetic */ int delimiterOffset$default(String r0, char r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.length();
    L9:
        return delimiterOffset(r0, r1, r2, r3);
    }

    public static /* synthetic */ int delimiterOffset$default(String r0, String r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.length();
    L9:
        return delimiterOffset(r0, r1, r2, r3);
    }

    public static final boolean discard(Source r2, int r3, TimeUnit r4) {
        Source r5 = (Source) ZeusTransformUtils.wrapperContextForParams(r2, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "$this$discard");
        Intrinsics.checkParameterIsNotNull(r4, "timeUnit");
        return skipAll(r5, r3, r4);
    L5:
        return false;
    }

    public static final void execute(Executor r2, String r3, Function0<Unit> r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "$this$execute");
        Intrinsics.checkParameterIsNotNull(r3, ActivityLifecycle.NAME);
        Intrinsics.checkParameterIsNotNull(r6, "block");
        r5.execute((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC12871(r3, r6), Runnable.class, "com.obric.memorydata.plugin"));
    }

    public static final String format(String r2, Object... r3) {
        Intrinsics.checkParameterIsNotNull(r2, "format");
        Intrinsics.checkParameterIsNotNull(r3, "args");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        Locale r1 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(r1, "Locale.US");
        Object[] r4 = Arrays.copyOf(r3, r3.length);
        String r5 = String.format(r1, r2, Arrays.copyOf(r4, r4.length));
        Intrinsics.checkExpressionValueIsNotNull(r5, "java.lang.String.format(locale, format, *args)");
        return r5;
    }

    public static final boolean hasIntersection(String[] r8, String[] r9, Comparator<? super String> r10) {
        Comparator r11 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r10, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, "$this$hasIntersection");
        Intrinsics.checkParameterIsNotNull(r11, "comparator");
        if (r8.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L23;
        if (r9 == null) goto L23;
        if (r9.length != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L23;
        int r2 = r8.length;
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L23;
        String r4 = r8[r3];
        int r5 = r9.length;
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L22;
        if (r11.compare(r4, r9[r6]) == 0) goto L20;
        r6 = r6 + 1;
        goto L17
    L20:
        return true;
    L22:
        r3 = r3 + 1;
        goto L15
    L11:
        r1 = false;
    L23:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static final long headersContentLength(Response r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$headersContentLength");
        String r3 = r2.headers().get("Content-Length");
        if (r3 != null) goto L5;
        return -1;
    L5:
        return toLongOrDefault(r3, -1);
    }

    public static final void ignoreIoExceptions(Function0<Unit> r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "block");
        r3.invoke();     // Catch: IOException -> L5
        return;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... r2) {
        Intrinsics.checkParameterIsNotNull(r2, "elements");
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r2.clone(), Object[].class, "com.obric.memorydata.plugin");
        List<T> r4 = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(r3, r3.length)));
        Intrinsics.checkExpressionValueIsNotNull(r4, "Collections.unmodifiable…sList(*elements.clone()))");
        return r4;
    }

    public static final int indexOf(String[] r4, String r5, Comparator<String> r6) {
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r6, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$this$indexOf");
        Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
        Intrinsics.checkParameterIsNotNull(r7, "comparator");
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r7.compare(r4[r2], r5) != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L15;
        r2 = r2 + 1;
        goto L3
    L15:
        return r2;
    L7:
        r3 = false;
        goto L8
    L11:
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String r4) {
        Intrinsics.checkParameterIsNotNull(r4, "$this$indexOfControlOrNonAscii");
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        char r2 = r4.charAt(r1);
        if (r2 <= 31) goto L10;
        if (r2 >= 127) goto L10;
        r1 = r1 + 1;
    L10:
        return r1;
    L11:
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String r2, int r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$indexOfFirstNonAsciiWhitespace");
    L3:
        if (r3 >= r4) goto L16;
        char r0 = r2.charAt(r3);
        if (r0 == '\t') goto L15;
        if (r0 == '\n') goto L15;
        if (r0 == '\f') goto L15;
        if (r0 == '\r') goto L15;
        if (r0 == ' ') goto L15;
        return r3;
    L15:
        r3 = r3 + 1;
        goto L3
    L16:
        return r4;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return indexOfFirstNonAsciiWhitespace(r0, r1, r2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String r2, int r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$indexOfLastNonAsciiWhitespace");
        int r5 = r4 - 1;
        if (r5 < r3) goto L18;
    L4:
        char r0 = r2.charAt(r5);
        if (r0 != '\t') goto L7;
    L16:
        if (r5 == r3) goto L18;
        r5 = r5 - 1;
        goto L4
    L7:
        if (r0 == '\n') goto L16;
        if (r0 == '\f') goto L16;
        if (r0 == '\r') goto L16;
        if (r0 == ' ') goto L16;
        return r5 + 1;
    L18:
        return r3;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return indexOfLastNonAsciiWhitespace(r0, r1, r2);
    }

    public static final int indexOfNonWhitespace(String r3, int r4) {
        Intrinsics.checkParameterIsNotNull(r3, "$this$indexOfNonWhitespace");
        int r0 = r3.length();
    L3:
        if (r4 >= r0) goto L11;
        char r1 = r3.charAt(r4);
        if (r1 == ' ') goto L9;
        if (r1 == '\t') goto L9;
        return r4;
    L9:
        r4 = r4 + 1;
        goto L3
    L11:
        return r3.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return indexOfNonWhitespace(r0, r1);
    }

    public static final String[] intersect(String[] r9, String[] r10, Comparator<? super String> r11) {
        Comparator r12 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r11, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, "$this$intersect");
        Intrinsics.checkParameterIsNotNull(r10, "other");
        Intrinsics.checkParameterIsNotNull(r12, "comparator");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r2 = r9.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        String r5 = r9[r4];
        int r6 = r10.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        if (r12.compare(r5, r10[r7]) == 0) goto L8;
        r7 = r7 + 1;
        goto L5
    L8:
        r0.add(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        Object[] r13 = ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        if (r13 == null) goto L16;
        return (String[]) ZeusTransformUtils.preCheckCast(r13, String[].class, "com.obric.memorydata.plugin");
    L16:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final void lockAndWaitNanos(Object r4, long r5) {
        Intrinsics.checkParameterIsNotNull(r4, "$this$lockAndWaitNanos");
        long r2 = r5 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        long r6 = r5 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r2);
        monitor-enter(r4);
        waitMillis(r4, r2, (int) r6);     // Catch: Throwable -> L8
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static final void notify(Object r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$notify");
        r1.notify();
    }

    public static final void notifyAll(Object r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$notifyAll");
        r1.notifyAll();
    }

    public static final int parseHexDigit(char r2) {
        if ('0' <= r2) goto L6;
    L8:
        char r1 = 'a';
        if ('a' > r2) goto L13;
        if ('f' < r2) goto L13;
    L21:
        return (r2 - r1) + 10;
    L13:
        r1 = 'A';
        if ('A' > r2) goto L18;
        if ('F' >= r2) goto L21;
    L18:
        return -1;
    L6:
        if ('9' < r2) goto L8;
        return r2 - '0';
    }

    public static final Charset readBomAsCharset(BufferedSource r2, Charset r3) {
        BufferedSource r4 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r2, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$this$readBomAsCharset");
        Intrinsics.checkParameterIsNotNull(r3, "default");
        int r5 = r4.select(UNICODE_BOMS);
        if (r5 == (-1)) goto L22;
        if (r5 != 0) goto L6;
        Charset r6 = StandardCharsets.UTF_8;
        String r7 = "UTF_8";
    L20:
        Intrinsics.checkExpressionValueIsNotNull(r6, r7);
        return r6;
    L6:
        if (r5 != 1) goto L8;
        r6 = StandardCharsets.UTF_16BE;
        r7 = "UTF_16BE";
        goto L20
    L8:
        if (r5 != 2) goto L10;
        r6 = StandardCharsets.UTF_16LE;
        r7 = "UTF_16LE";
        goto L20
    L10:
        if (r5 == 3) goto L24;
        if (r5 != 4) goto L15;
        return Charsets.INSTANCE.UTF32_LE();
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError(), Throwable.class, "com.obric.memorydata.plugin"));
    L24:
        return Charsets.INSTANCE.UTF32_BE();
    L22:
        return r3;
    }

    public static final <T> T readFieldOrNull(Object r5, Class<T> r6, String r7) {
        Intrinsics.checkParameterIsNotNull(r5, "instance");
        Intrinsics.checkParameterIsNotNull(r6, "fieldType");
        Intrinsics.checkParameterIsNotNull(r7, "fieldName");
        Class<?> r0 = r5.getClass();
    L3:
        T r3 = null;
        if ((!Intrinsics.areEqual(r0, Object.class)) == false) goto L12;
        Field r1 = r0.getDeclaredField(r7);     // Catch: NoSuchFieldException -> L10
        Intrinsics.checkExpressionValueIsNotNull(r1, "field");     // Catch: NoSuchFieldException -> L10
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L10
        Object r2 = r1.get(r5);     // Catch: NoSuchFieldException -> L10
        if (ZeusTransformUtils.instanceOf(r6, r2) == false) goto L9;
        r3 = r6.cast(r2);     // Catch: NoSuchFieldException -> L10
    L9:
        return r3;
    L10:
        r0 = r0.getSuperclass();
        Intrinsics.checkExpressionValueIsNotNull(r0, "c.superclass");
        goto L3
    L12:
        if ((!Intrinsics.areEqual(r7, "delegate")) == false) goto L17;
        Object r8 = readFieldOrNull(r5, Object.class, "delegate");
        if (r8 == null) goto L17;
        return (T) readFieldOrNull(r8, r6, r7);
    L17:
        return null;
    }

    public static final int readMedium(BufferedSource r3) {
        BufferedSource r4 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$this$readMedium");
        int r0 = (and(r4.readByte(), 255) << 16) | (and(r4.readByte(), 255) << 8);
        return and(r4.readByte(), 255) | r0;
    }

    public static final int skipAll(Buffer r3, byte r4) {
        Intrinsics.checkParameterIsNotNull(r3, "$this$skipAll");
        int r0 = 0;
    L4:
        if (r3.exhausted() == true) goto L8;
        if (r3.getByte(0) != r4) goto L8;
        r0 = r0 + 1;
        r3.readByte();
    L8:
        return r0;
    }

    public static final boolean skipAll(Source r11, int r12, TimeUnit r13) {
        Source r14 = (Source) ZeusTransformUtils.wrapperContextForParams(r11, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r14, "$this$skipAll");
        Intrinsics.checkParameterIsNotNull(r13, "timeUnit");
        long r0 = System.nanoTime();
        if (r14.timeout().hasDeadline() == false) goto L5;
        long r5 = r14.timeout().deadlineNanoTime() - r0;
    L6:
        r14.timeout().deadlineNanoTime(Math.min(r5, r13.toNanos(r12)) + r0);
        Buffer r15 = new Buffer();     // Catch: Throwable -> L16 InterruptedIOException -> L22
    L9:
        if (r14.read(r15, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L12;
        r15.clear();     // Catch: Throwable -> L16 InterruptedIOException -> L22
    L12:
        boolean r16 = true;
        if (r5 != Long.MAX_VALUE) goto L15;
    L14:
        r14.timeout().clearDeadline();
    L25:
        return r16;
    L15:
        r14.timeout().deadlineNanoTime(r0 + r5);
    L22:
        r16 = false;
        if (r5 != Long.MAX_VALUE) goto L15;
    L16:
        th = move-exception;
        Timeout r17 = r14.timeout();
        if (r5 != Long.MAX_VALUE) goto L20;
        r17.clearDeadline();
    L21:
        throw th;
    L20:
        r17.deadlineNanoTime(r0 + r5);
        goto L21
    L5:
        r5 = Long.MAX_VALUE;
        goto L6
    }

    public static final ThreadFactory threadFactory(final String r1, final boolean r2) {
        Intrinsics.checkParameterIsNotNull(r1, ActivityLifecycle.NAME);
        return (ThreadFactory) ZeusTransformUtils.preCheckCast(new ThreadFactoryC12881(r1, r2), ThreadFactory.class, "com.obric.memorydata.plugin");
    }

    public static final void threadName(String r2, Function0<Unit> r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r2, ActivityLifecycle.NAME);
        Intrinsics.checkParameterIsNotNull(r4, "block");
        Thread r0 = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(r0, "currentThread");
        String r1 = r0.getName();
        r0.setName(r2);
        r4.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r0.setName(r1);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.setName(r1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final List<Header> toHeaderList(Headers r6) {
        Intrinsics.checkParameterIsNotNull(r6, "$this$toHeaderList");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r6.size()), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        int r3 = ((IntIterator) ZeusTransformUtils.preCheckCast(r2, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        r1.add(new Header(r6.name(r3), r6.value(r3)));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public static final Headers toHeaders(List<Header> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "$this$toHeaders");
        Headers.Builder r0 = new Headers.Builder();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Header r2 = (Header) ZeusTransformUtils.preCheckCast(r6.next(), Header.class, "com.obric.memorydata.plugin");
        ByteString r3 = r2.component1();
        ByteString r7 = r2.component2();
        r0.addLenient$okhttp(r3.utf8(), r7.utf8());
        goto L4
    L7:
        return r0.build();
    }

    public static final String toHexString(int r1) {
        String r2 = Integer.toHexString(r1);
        Intrinsics.checkExpressionValueIsNotNull(r2, "Integer.toHexString(this)");
        return r2;
    }

    public static final String toHexString(long r0) {
        String r1 = Long.toHexString(r0);
        Intrinsics.checkExpressionValueIsNotNull(r1, "java.lang.Long.toHexString(this)");
        return r1;
    }

    public static final String toHostHeader(HttpUrl r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r5, "$this$toHostHeader");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5.host(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
        String r0 = '[' + r5.host() + ']';
    L6:
        if (r6 == true) goto L10;
        if (r5.port() != HttpUrl.Companion.defaultPort(r5.scheme())) goto L10;
        return r0;
    L10:
        return r0 + ':' + r5.port();
    L5:
        r0 = r5.host();
        goto L6
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return toHostHeader(r0, r1);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$this$toImmutableList");
        List<T> r4 = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")));
        Intrinsics.checkExpressionValueIsNotNull(r4, "Collections.unmodifiableList(toMutableList())");
        return r4;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "$this$toImmutableMap");
        if (r3.isEmpty() == true) goto L7;
        Map<K, V> r4 = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(r3), Map.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r4, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return r4;
    L7:
        return MapsKt.emptyMap();
    }

    public static final long toLongOrDefault(String r1, long r2) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$toLongOrDefault");
        return Long.parseLong(r1);
    L8:
        return r2;
    }

    public static final int toNonNegativeInt(String r3, int r4) {
        if (r3 != null) goto L14;
    L12:
        return r4;
    L14:
        long r5 = Long.parseLong(r3);     // Catch: NumberFormatException -> L13
        if (r5 <= Integer.MAX_VALUE) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r5 >= 0) goto L11;
        return 0;
    L11:
        return (int) r5;
    }

    public static final String trimSubstring(String r1, int r2, int r3) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$trimSubstring");
        int r4 = indexOfFirstNonAsciiWhitespace(r1, r2, r3);
        String r5 = r1.substring(r4, indexOfLastNonAsciiWhitespace(r1, r4, r3));
        Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r5;
    }

    public static /* synthetic */ String trimSubstring$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return trimSubstring(r0, r1, r2);
    }

    public static final void tryExecute(Executor r2, String r3, Function0<Unit> r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "$this$tryExecute");
        Intrinsics.checkParameterIsNotNull(r3, ActivityLifecycle.NAME);
        Intrinsics.checkParameterIsNotNull(r6, "block");
        r5.execute((Runnable) ZeusTransformUtils.preCheckCast(new RunnableC12871(r3, r6), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    }

    public static final void wait(Object r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$this$wait");
        r1.wait();
    }

    public static final void waitMillis(Object r2, long r3, int r5) {
        Intrinsics.checkParameterIsNotNull(r2, "$this$waitMillis");
        if (r3 > 0) goto L5;
        if (r5 > 0) goto L5;
        return;
    L5:
        r2.wait(r3, r5);
    }

    public static /* synthetic */ void waitMillis$default(Object r0, long r1, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = 0;
    L5:
        waitMillis(r0, r1, r3);
    }

    public static final void writeMedium(BufferedSink r2, int r3) {
        BufferedSink r4 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r2, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "$this$writeMedium");
        r4.writeByte((r3 >>> 16) & 255);
        r4.writeByte((r3 >>> 8) & 255);
        r4.writeByte(r3 & 255);
    }
}
