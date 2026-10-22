package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u009c\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004\u009c\u0001\u009d\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ$\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0007J\"\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\b\u0010 \u001a\u00020\u0000H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u0012H\u0016J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b*J\u0015\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\fH\u0007¢\u0006\u0002\b,J\b\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001cH\u0002J\u000e\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cJ\u000e\u00103\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cJ\u0010\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020(H\u0016J\u0018\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\fH\u0016J \u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u00104\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001cH\u0016J\u0018\u00104\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u0018\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\"H\u0016J\u0006\u0010>\u001a\u00020\u001cJ\b\u0010?\u001a\u00020\u0018H\u0016J\b\u0010@\u001a\u00020\u0001H\u0016J\u0018\u0010A\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001cH\u0016J(\u0010A\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u00108\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.H\u0016J0\u0010A\u001a\u00020\"2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020.2\u0006\u00108\u001a\u00020E2\u0006\u0010B\u001a\u00020.2\u0006\u0010F\u001a\u00020.H\u0002J\u0010\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020EH\u0016J \u0010G\u001a\u00020.2\u0006\u0010H\u001a\u00020E2\u0006\u0010\u0019\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.H\u0016J\u0018\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020\f2\u0006\u0010H\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020MH\u0007J\b\u0010O\u001a\u00020(H\u0016J\b\u0010P\u001a\u00020EH\u0016J\u0010\u0010P\u001a\u00020E2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010Q\u001a\u00020\u001cH\u0016J\u0010\u0010Q\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010R\u001a\u00020\fH\u0016J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020<J\u0016\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\fJ \u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010U\u001a\u00020\"H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010H\u001a\u00020EH\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010W\u001a\u00020\fH\u0016J\b\u0010X\u001a\u00020.H\u0016J\b\u0010Y\u001a\u00020.H\u0016J\b\u0010Z\u001a\u00020\fH\u0016J\b\u0010[\u001a\u00020\fH\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020]H\u0016J\u0010\u0010_\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020aH\u0016J\u0018\u0010_\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010`\u001a\u00020aH\u0016J\u0012\u0010b\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020MH\u0007J\b\u0010c\u001a\u00020\u001eH\u0016J\u0010\u0010c\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010d\u001a\u00020.H\u0016J\n\u0010e\u001a\u0004\u0018\u00010\u001eH\u0016J\u0015\u0010e\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020\fH\u0000¢\u0006\u0002\bgJ\b\u0010h\u001a\u00020\u001eH\u0016J\u0010\u0010h\u001a\u00020\u001e2\u0006\u0010i\u001a\u00020\fH\u0016J\u0010\u0010j\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010k\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\fH\u0016J8\u0010l\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\u0006\u00106\u001a\u00020\f2\u001a\u0010n\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002Hm0oH\u0082\b¢\u0006\u0002\u0010pJ\u0010\u0010q\u001a\u00020.2\u0006\u0010r\u001a\u00020sH\u0016J\u001f\u0010t\u001a\u00020.2\u0006\u0010r\u001a\u00020s2\b\b\u0002\u0010u\u001a\u00020\"H\u0000¢\u0006\u0002\bvJ\u0006\u0010w\u001a\u00020\u001cJ\u0006\u0010x\u001a\u00020\u001cJ\u0006\u0010y\u001a\u00020\u001cJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bzJ\u0010\u0010{\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0006\u0010|\u001a\u00020\u001cJ\u000e\u0010|\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020.J\b\u0010}\u001a\u00020~H\u0016J\b\u0010\u007f\u001a\u00020\u001eH\u0016J\u0018\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u00020.H\u0000¢\u0006\u0003\b\u0082\u0001J\u0012\u0010\u0083\u0001\u001a\u00020.2\u0007\u0010\u0084\u0001\u001a\u00020IH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020EH\u0016J\"\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020E2\u0006\u0010\u0019\u001a\u00020.2\u0006\u0010\u001a\u001a\u00020.H\u0016J\u001a\u0010\u0083\u0001\u001a\u00020\u00122\u0007\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0085\u0001\u001a\u00020\u001cH\u0016J\u001b\u0010\u0083\u0001\u001a\u00020\u00022\b\u0010\u0084\u0001\u001a\u00030\u0086\u00012\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0013\u0010\u0087\u0001\u001a\u00020\f2\b\u0010\u0084\u0001\u001a\u00030\u0086\u0001H\u0016J\u0011\u0010\u0088\u0001\u001a\u00020\u00002\u0006\u00105\u001a\u00020.H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020.H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008d\u0001\u001a\u00020.H\u0016J\u0012\u0010\u008f\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u008a\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0093\u0001\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020.H\u0016J\u001a\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u001e2\u0006\u0010`\u001a\u00020aH\u0016J,\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020.2\u0007\u0010\u0097\u0001\u001a\u00020.2\u0006\u0010`\u001a\u00020aH\u0016J\u001b\u0010\u0098\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\fH\u0007J\u0012\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u001eH\u0016J$\u0010\u0099\u0001\u001a\u00020\u00002\u0007\u0010\u0095\u0001\u001a\u00020\u001e2\u0007\u0010\u0096\u0001\u001a\u00020.2\u0007\u0010\u0097\u0001\u001a\u00020.H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020.H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u009e\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$jvm", "(J)V", "clear", "", "clone", IslandSession.REOPEN_VALUE_CLOSE, "completeSegmentByteCount", "copyTo", "out", "Ljava/io/OutputStream;", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "segment", "segmentPos", "", "bytesLimit", "read", "sink", "Ljava/nio/ByteBuffer;", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "newline", "readUtf8Line$jvm", "readUtf8LineStrict", "limit", Ext.KEY_REQUEST, "require", "seek", ExifInterface.GPS_DIRECTION_TRUE, "lambda", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "select", "options", "Lokio/Options;", "selectPrefix", "selectTruncated", "selectPrefix$jvm", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", LocationMonitorConst.TIMEOUT, "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$jvm", "write", AILabCheckPermissionTask.KEY_SOURCE, "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", BaseSwitches.V, "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", TypedValues.Custom.S_STRING, "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "Companion", "UnsafeCursor", "jvm"}, k = 1, mv = {1, 1, 11})
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    public static final Companion Companion = null;
    private static final byte[] DIGITS = null;
    public Segment head;
    private long size;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokio/Buffer$Companion;", "", "()V", "DIGITS", "", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "readWrite", "", "segment", "Lokio/Segment;", CommonConsts.APM_INNER_EVENT_COST_START, IslandSession.REOPEN_VALUE_CLOSE, "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end;
        public long offset;
        public boolean readWrite;
        private Segment segment;
        public int start;

        public UnsafeCursor() {
            this.offset = -1;
            this.start = -1;
            this.end = -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L11;
            this.buffer = (Buffer) ZeusTransformUtils.preCheckCast(null, Buffer.class, "com.obric.memorydata.plugin");
            this.segment = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
            this.offset = -1;
            this.data = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.memorydata.plugin");
            this.start = -1;
            this.end = -1;
            return;
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("not attached to a buffer".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r0 = false;
            goto L7
        }

        public final long expandBuffer(int r10) {
            boolean r0 = true;
            if (r10 <= 0) goto L5;
            boolean r2 = true;
        L7:
            if (r2 == false) goto L26;
            if (r10 <= 8192) goto L12;
            r0 = false;
        L12:
            if (r0 == false) goto L24;
            Buffer r1 = this.buffer;
            if (r1 == null) goto L22;
            if (this.readWrite == false) goto L20;
            long r3 = r1.size();
            Segment r11 = r1.writableSegment$jvm(r10);
            int r4 = 8192 - r11.limit;
            r11.limit = 8192;
            long r5 = r4;
            r1.setSize$jvm(r3 + r5);
            this.segment = r11;
            this.offset = r3;
            this.data = r11.data;
            this.start = 8192 - r4;
            this.end = 8192;
            return r5;
        L20:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L22:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("not attached to a buffer".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L24:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("minByteCount > Segment.SIZE: " + r10).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L26:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("minByteCount <= 0: " + r10).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            r2 = false;
            goto L7
        }

        public final int next() {
            long r0 = this.offset;
            Buffer r2 = this.buffer;
            if (r2 != null) goto L6;
            Intrinsics.throwNpe();
        L6:
            if (r0 == r2.size()) goto L8;
            boolean r1 = true;
        L9:
            if (r1 == false) goto L17;
            long r3 = this.offset;
            if (r3 != (-1)) goto L13;
            long r4 = 0;
        L15:
            return seek(r4);
        L13:
            r4 = r3 + ((long) (this.end - this.start));
            goto L15
        L17:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("no more bytes".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L8:
            r1 = false;
            goto L9
        }

        public final long resizeBuffer(long r17) {
            Buffer r3 = this.buffer;
            if (r3 == null) goto L42;
            if (this.readWrite == false) goto L40;
            long r5 = r3.size();
            int r9 = 1;
            if (r17 <= r5) goto L9;
            if (r17 <= r5) goto L37;
            long r12 = r17 - r5;
            boolean r4 = true;
        L32:
            if (r12 <= 0) goto L37;
            Segment r7 = r3.writableSegment$jvm(r9);
            int r14 = (int) Math.min(r12, 8192 - r7.limit);
            r7.limit += r14;
            r12 = r12 - ((long) r14);
            if (r4 == false) goto L36;
            this.segment = r7;
            this.offset = r5;
            this.data = r7.data;
            this.start = r7.limit - r14;
            this.end = r7.limit;
            r4 = false;
        L36:
            r9 = 1;
        L37:
            r3.setSize$jvm(r17);
            return r5;
        L9:
            if (r17 < 0) goto L11;
            boolean r8 = true;
        L12:
            if (r8 == false) goto L28;
            long r10 = r5 - r17;
        L15:
            if (r10 <= 0) goto L26;
            Segment r11 = r3.head;
            if (r11 != null) goto L19;
            Intrinsics.throwNpe();
        L19:
            Segment r13 = r11.prev;
            if (r13 != null) goto L22;
            Intrinsics.throwNpe();
        L22:
            long r15 = r13.limit - r13.pos;
            if (r15 > r10) goto L25;
            r3.head = r13.pop();
            SegmentPool.recycle(r13);
            r10 = r10 - r15;
            goto L15
        L25:
            r13.limit -= (int) r10;
        L26:
            this.segment = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
            this.offset = r17;
            this.data = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.memorydata.plugin");
            this.start = -1;
            this.end = -1;
            goto L37
        L28:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("newSize < 0: " + r17).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L11:
            r8 = false;
            goto L12
        L40:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L42:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("not attached to a buffer".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final int seek(long r13) {
            Buffer r0 = this.buffer;
            if (r0 == null) goto L61;
            if (r13 >= (-1)) goto L7;
        L58:
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            String r14 = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(r13), Long.valueOf(r0.size())}, 2));
            Intrinsics.checkExpressionValueIsNotNull(r14, "java.lang.String.format(format, *args)");
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new ArrayIndexOutOfBoundsException(r14), Throwable.class, "com.obric.memorydata.plugin"));
        L7:
            if (r13 > r0.size()) goto L58;
            if (r13 != (-1)) goto L11;
        L56:
            this.segment = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
            this.offset = r13;
            this.data = (byte[]) ZeusTransformUtils.preCheckCast(null, byte[].class, "com.obric.memorydata.plugin");
            this.start = -1;
            this.end = -1;
            return -1;
        L11:
            if (r13 == r0.size()) goto L56;
            long r1 = 0;
            long r3 = r0.size();
            Segment r5 = r0.head;
            Segment r6 = r0.head;
            Segment r7 = this.segment;
            if (r7 == null) goto L23;
            long r8 = this.offset;
            int r10 = this.start;
            if (r7 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            long r9 = r8 - ((long) (r10 - r7.pos));
            if (r9 <= r13) goto L21;
            r6 = this.segment;
            r3 = r9;
            goto L23
        L21:
            r5 = this.segment;
            r1 = r9;
        L23:
            if ((r3 - r13) <= (r13 - r1)) goto L30;
        L24:
            if (r5 != null) goto L27;
            Intrinsics.throwNpe();
        L27:
            if (r13 < (((long) (r5.limit - r5.pos)) + r1)) goto L39;
            r1 = r1 + ((long) (r5.limit - r5.pos));
            r5 = r5.next;
        L39:
            if (this.readWrite == false) goto L51;
            if (r5 != null) goto L43;
            Intrinsics.throwNpe();
        L43:
            if (r5.shared == false) goto L51;
            Segment r4 = r5.unsharedCopy();
            if (r0.head != r5) goto L47;
            r0.head = r4;
        L47:
            r5 = r5.push(r4);
            Segment r11 = r5.prev;
            if (r11 != null) goto L50;
            Intrinsics.throwNpe();
        L50:
            r11.pop();
        L51:
            this.segment = r5;
            this.offset = r13;
            if (r5 != null) goto L54;
            Intrinsics.throwNpe();
        L54:
            this.data = r5.data;
            this.start = r5.pos + ((int) (r13 - r1));
            int r15 = r5.limit;
            this.end = r15;
            return r15 - this.start;
        L30:
            if (r3 <= r13) goto L37;
            if (r6 != null) goto L33;
            Intrinsics.throwNpe();
        L33:
            r6 = r6.prev;
            if (r6 != null) goto L36;
            Intrinsics.throwNpe();
        L36:
            r3 = r3 - ((long) (r6.limit - r6.pos));
            goto L30
        L37:
            r1 = r3;
            r5 = r6;
            goto L39
        L61:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("not attached to a buffer".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
        byte[] r0 = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(r0, "(this as java.lang.String).getBytes(charset)");
        DIGITS = r0;
    }

    public Buffer() {
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, OutputStream r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = r6.size - r2;
    L9:
        return r6.copyTo(r7, r2, r10);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, Buffer r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = r6.size - r2;
    L9:
        return r6.copyTo(r7, r2, r10);
    }

    private final ByteString digest(String r6) {
        MessageDigest r7 = MessageDigest.getInstance(r6);
        Segment r5 = this.head;
        if (r5 == null) goto L11;
        r7.update(r5.data, r5.pos, r5.limit - r5.pos);
        Segment r0 = r5.next;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        if (r0 == r5) goto L11;
        r7.update(r0.data, r0.pos, r0.limit - r0.pos);
        r0 = r0.next;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L11:
        byte[] r8 = r7.digest();
        Intrinsics.checkExpressionValueIsNotNull(r8, "messageDigest.digest()");
        return new ByteString(r8);
    }

    private final ByteString hmac(String r6, ByteString r7) {
        Mac r1 = Mac.getInstance(r6);     // Catch: InvalidKeyException -> L14
        r1.init((Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r7.internalArray$jvm(), r6), Key.class, "com.obric.memorydata.plugin"));     // Catch: InvalidKeyException -> L14
        Segment r5 = this.head;     // Catch: InvalidKeyException -> L14
        if (r5 == null) goto L12;
        r1.update(r5.data, r5.pos, r5.limit - r5.pos);     // Catch: InvalidKeyException -> L14
        Segment r8 = r5.next;     // Catch: InvalidKeyException -> L14
        if (r8 != null) goto L8;
        Intrinsics.throwNpe();     // Catch: InvalidKeyException -> L14
    L8:
        if (r8 == r5) goto L12;
        r1.update(r8.data, r8.pos, r8.limit - r8.pos);     // Catch: InvalidKeyException -> L14
        r8 = r8.next;     // Catch: InvalidKeyException -> L14
        if (r8 != null) goto L8;
        Intrinsics.throwNpe();     // Catch: InvalidKeyException -> L14
    L12:
        byte[] r9 = r1.doFinal();     // Catch: InvalidKeyException -> L14
        Intrinsics.checkExpressionValueIsNotNull(r9, "mac.doFinal()");     // Catch: InvalidKeyException -> L14
        return new ByteString(r9);
    L14:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final boolean rangeEquals(Segment r5, int r6, byte[] r7, int r8, int r9) {
        int r4 = r5.limit;
        byte[] r0 = r5.data;
    L3:
        if (r8 >= r9) goto L14;
        if (r6 != r4) goto L10;
        Segment r10 = r5.next;
        if (r10 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        byte[] r11 = r10.data;
        r6 = r10.pos;
        r5 = r10;
        r4 = r10.limit;
        r0 = r11;
    L10:
        if (r0[r6] != r7[r8]) goto L11;
        r6 = r6 + 1;
        r8 = r8 + 1;
        goto L3
    L11:
        return false;
    L14:
        return true;
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer r0, UnsafeCursor r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = new UnsafeCursor();
    L6:
        return r0.readAndWriteUnsafe(r1);
    }

    private final void readFrom(InputStream r5, long r6, boolean r8) {
    L3:
        if (r6 > 0) goto L7;
        if (r8 == true) goto L7;
        return;
    L7:
        Segment r0 = writableSegment$jvm(1);
        int r1 = r5.read(r0.data, r0.limit, (int) Math.min(r6, 8192 - r0.limit));
        if (r1 == (-1)) goto L9;
        r0.limit += r1;
        long r2 = r1;
        this.size += r2;
        r6 = r6 - r2;
        goto L3
    L9:
        if (r8 == false) goto L12;
        return;
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer r0, UnsafeCursor r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = new UnsafeCursor();
    L6:
        return r0.readUnsafe(r1);
    }

    private final <T> T seek(long r6, Function2<? super Segment, ? super Long, ? extends T> r8) {
        Function2 r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r8, Function2.class, "com.obric.memorydata.plugin");
        Segment r0 = this.head;
        if (r0 == null) goto L25;
        if ((size() - r6) >= r6) goto L15;
        long r1 = size();
    L8:
        if (r1 <= r6) goto L14;
        r0 = r0.prev;
        if (r0 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L14:
        return (T) r9.invoke(r0, Long.valueOf(r1));
    L15:
        long r2 = 0;
    L16:
        long r3 = ((long) (r0.limit - r0.pos)) + r2;
        if (r3 > r6) goto L19;
        r0 = r0.next;
        if (r0 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r2 = r3;
        goto L16
    L19:
        return (T) r9.invoke(r0, Long.valueOf(r2));
    L25:
        return (T) r9.invoke(null, -1L);
    }

    public static /* synthetic */ int selectPrefix$jvm$default(Buffer r0, Options r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.selectPrefix$jvm(r1, r2);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer r0, OutputStream r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.size;
    L6:
        return r0.writeTo(r1, r2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m3047deprecated_getByte(long r1) {
        return getByte(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m3048deprecated_size() {
        return this.size;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(this.size);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m3049clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Buffer m3049clone() {
        Buffer r0 = new Buffer();
        if (this.size != 0) goto L5;
        return r0;
    L5:
        Segment r1 = this.head;
        if (r1 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        Segment r2 = r1.sharedCopy();
        r0.head = r2;
        if (r2 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r2.prev = r0.head;
        Segment r3 = r0.head;
        if (r3 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        Segment r4 = r0.head;
        if (r4 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        r3.next = r4.prev;
        Segment r5 = this.head;
        if (r5 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        r5 = r5.next;
        if (r5 == this.head) goto L31;
        Segment r6 = r0.head;
        if (r6 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        Segment r7 = r6.prev;
        if (r7 != null) goto L28;
        Intrinsics.throwNpe();
    L28:
        if (r5 != null) goto L30;
        Intrinsics.throwNpe();
    L30:
        r7.push(r5.sharedCopy());
        goto L20
    L31:
        r0.size = this.size;
        return r0;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long r0 = this.size;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        Segment r5 = this.head;
        if (r5 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        Segment r6 = r5.prev;
        if (r6 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        if (r6.limit < 8192) goto L14;
        return r0;
    L14:
        if (r6.owner == true) goto L16;
        return r0;
    L16:
        return r0 - ((long) (r6.limit - r6.pos));
    }

    public final Buffer copyTo(OutputStream r9) {
        return copyTo$default(this, r9, 0, 0, 6, null);
    }

    public final Buffer copyTo(OutputStream r9, long r10) {
        return copyTo$default(this, r9, r10, 0, 4, null);
    }

    public final Buffer copyTo(OutputStream r8, long r9, long r11) {
        Intrinsics.checkParameterIsNotNull(r8, "out");
        Util.checkOffsetAndCount(this.size, r9, r11);
        if (r11 != 0) goto L5;
        return this;
    L5:
        Segment r2 = this.head;
    L6:
        if (r2 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        if (r9 < (r2.limit - r2.pos)) goto L12;
        r9 = r9 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L12:
        if (r11 <= 0) goto L16;
        if (r2 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        int r10 = (int) (((long) r2.pos) + r9);
        int r12 = (int) Math.min(r2.limit - r10, r11);
        r8.write(r2.data, r10, r12);
        r11 = r11 - ((long) r12);
        r2 = r2.next;
        r9 = 0;
        goto L12
    L16:
        return this;
    }

    public final Buffer copyTo(Buffer r8, long r9, long r11) {
        Intrinsics.checkParameterIsNotNull(r8, "out");
        Util.checkOffsetAndCount(this.size, r9, r11);
        if (r11 != 0) goto L5;
        return this;
    L5:
        r8.size += r11;
        Segment r2 = this.head;
    L6:
        if (r2 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        if (r9 < (r2.limit - r2.pos)) goto L12;
        r9 = r9 - ((long) (r2.limit - r2.pos));
        r2 = r2.next;
    L12:
        if (r11 <= 0) goto L25;
        if (r2 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        Segment r3 = r2.sharedCopy();
        r3.pos += (int) r9;
        r3.limit = Math.min(r3.pos + ((int) r11), r3.limit);
        Segment r10 = r8.head;
        if (r10 != null) goto L18;
        r3.prev = r3;
        r3.next = r3.prev;
        r8.head = r3.next;
    L24:
        r11 = r11 - ((long) (r3.limit - r3.pos));
        r2 = r2.next;
        r9 = 0;
        goto L12
    L18:
        if (r10 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        Segment r12 = r10.prev;
        if (r12 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r12.push(r3);
        goto L24
    L25:
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink emit() {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(emit(), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink emitCompleteSegments() {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(emitCompleteSegments(), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r20) {
        if (((Buffer) ZeusTransformUtils.preCheckCast(this, Buffer.class, "com.obric.memorydata.plugin")) != r20) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r20, Buffer.class) == true) goto L9;
        return false;
    L9:
        if (this.size == ((Buffer) ZeusTransformUtils.preCheckCast(r20, Buffer.class, "com.obric.memorydata.plugin")).size) goto L12;
        return false;
    L12:
        if (this.size != 0) goto L14;
        return true;
    L14:
        Segment r4 = this.head;
        if (r4 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        Segment r1 = ((Buffer) ZeusTransformUtils.preCheckCast(r20, Buffer.class, "com.obric.memorydata.plugin")).head;
        if (r1 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        int r2 = r4.pos;
        int r3 = r1.pos;
        long r7 = 0;
    L22:
        if (r7 >= this.size) goto L43;
        long r11 = Math.min(r4.limit - r2, r1.limit - r3);
        long r13 = 0;
    L25:
        if (r13 >= r11) goto L31;
        int r16 = r2 + 1;
        int r17 = r3 + 1;
        if (r4.data[r2] != r1.data[r3]) goto L28;
        r13 = r13 + 1;
        r2 = r16;
        r3 = r17;
        goto L25
    L28:
        return false;
    L31:
        if (r2 != r4.limit) goto L37;
        Segment r5 = r4.next;
        if (r5 != null) goto L35;
        Intrinsics.throwNpe();
    L35:
        r4 = r5;
        r2 = r5.pos;
    L37:
        if (r3 != r1.limit) goto L42;
        r1 = r1.next;
        if (r1 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r3 = r1.pos;
    L42:
        r7 = r7 + r11;
        goto L22
    L43:
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long r7) {
        Util.checkOffsetAndCount(this.size, r7, 1);
        Segment r0 = this.head;
        if (r0 != null) goto L5;
        Segment r6 = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        Intrinsics.throwNpe();
        return r6.data[(int) ((((long) r6.pos) + r7) - (-1))];
    L5:
        if ((size() - r7) >= r7) goto L17;
        long r1 = size();
    L8:
        if (r1 <= r7) goto L13;
        r0 = r0.prev;
        if (r0 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r1 = r1 - ((long) (r0.limit - r0.pos));
        goto L8
    L13:
        if (r0 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        return r0.data[(int) ((((long) r0.pos) + r7) - r1)];
    L17:
        long r2 = 0;
    L18:
        long r3 = ((long) (r0.limit - r0.pos)) + r2;
        if (r3 > r7) goto L20;
        r0 = r0.next;
        if (r0 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        r2 = r3;
        goto L18
    L20:
        if (r0 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        return r0.data[(int) ((((long) r0.pos) + r7) - r2)];
    }

    public int hashCode() {
        Segment r0 = this.head;
        if (r0 == null) goto L14;
        int r1 = 1;
    L5:
        int r2 = r0.pos;
        int r3 = r0.limit;
    L6:
        if (r2 >= r3) goto L8;
        r1 = (r1 * 31) + r0.data[r2];
        r2 = r2 + 1;
        goto L6
    L8:
        r0 = r0.next;
        if (r0 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        if (r0 != this.head) goto L5;
        return r1;
    L14:
        return 0;
    }

    public final ByteString hmacSha1(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "key");
        return hmac("HmacSHA1", r2);
    }

    public final ByteString hmacSha256(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "key");
        return hmac("HmacSHA256", r2);
    }

    public final ByteString hmacSha512(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "key");
        return hmac("HmacSHA512", r2);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r11, long r12, long r14) {
        long r0 = 0;
        if (0 <= r12) goto L6;
    L8:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L66;
        long r4 = this.size;
        if (r14 <= r4) goto L15;
        r14 = r4;
    L15:
        if (r12 != r14) goto L17;
        return -1;
    L17:
        Segment r3 = this.head;
        if (r3 != null) goto L20;
        Segment r10 = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        return -1;
    L20:
        if ((size() - r12) >= r12) goto L43;
        r0 = size();
    L23:
        if (r0 <= r12) goto L28;
        r3 = r3.prev;
        if (r3 != null) goto L27;
        Intrinsics.throwNpe();
    L27:
        r0 = r0 - ((long) (r3.limit - r3.pos));
        goto L23
    L28:
        if (r3 != null) goto L30;
    L42:
        return -1;
    L30:
        if (r0 >= r14) goto L42;
        byte[] r13 = r3.data;
        int r5 = (int) Math.min(r3.limit, (((long) r3.pos) + r14) - r0);
        int r15 = (int) ((((long) r3.pos) + r12) - r0);
    L32:
        if (r15 >= r5) goto L38;
        if (r13[r15] == r11) goto L36;
        r15 = r15 + 1;
    L36:
        return ((long) (r15 - r3.pos)) + r0;
    L38:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        if (r3 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r12 = r0;
    L43:
        long r6 = ((long) (r3.limit - r3.pos)) + r0;
        if (r6 > r12) goto L45;
        r3 = r3.next;
        if (r3 != null) goto L62;
        Intrinsics.throwNpe();
    L62:
        r0 = r6;
        goto L43
    L45:
        if (r3 != null) goto L47;
    L58:
        return -1;
    L47:
        if (r0 >= r14) goto L58;
        byte[] r16 = r3.data;
        int r7 = (int) Math.min(r3.limit, (((long) r3.pos) + r14) - r0);
        r15 = (int) ((((long) r3.pos) + r12) - r0);
    L49:
        if (r15 >= r7) goto L54;
        if (r16[r15] == r11) goto L36;
        r15 = r15 + 1;
        goto L49
    L54:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        if (r3 != null) goto L57;
        Intrinsics.throwNpe();
    L57:
        r12 = r0;
        goto L47
    L66:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("size=" + this.size + " fromIndex=" + r12 + " toIndex=" + r14).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        if (r14 < r12) goto L8;
        r2 = true;
        goto L10
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) {
        Intrinsics.checkParameterIsNotNull(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r19, long r20) {
        Buffer r6 = this;
        long r0 = r20;
        Intrinsics.checkParameterIsNotNull(r19, "bytes");
        boolean r5 = true;
        if (r19.size() <= 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L78;
        long r8 = 0;
        if (r0 >= 0) goto L12;
        r5 = false;
    L12:
        if (r5 == false) goto L76;
        Segment r3 = r6.head;
        if (r3 != null) goto L16;
        Segment r1 = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        return -1;
    L16:
        if ((size() - r0) >= r0) goto L45;
        long r7 = size();
    L19:
        if (r7 <= r0) goto L24;
        r3 = r3.prev;
        if (r3 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r7 = r7 - ((long) (r3.limit - r3.pos));
        goto L19
    L24:
        if (r3 == null) goto L43;
        byte[] r9 = r19.internalArray$jvm();
        byte r14 = r9[0];
        int r15 = r19.size();
        long r10 = (r6.size - ((long) r15)) + 1;
        long r12 = r7;
        Segment r11 = r3;
    L27:
        if (r12 >= r10) goto L41;
        byte[] r13 = r11.data;
        long r16 = r10;
        int r17 = (int) Math.min(r11.limit, (((long) r11.pos) + r10) - r12);
        int r18 = (int) ((((long) r11.pos) + r0) - r12);
    L29:
        if (r18 >= r17) goto L37;
        if (r13[r18] != r14) goto L36;
        if (rangeEquals(r11, r18 + 1, r9, 1, r15) == false) goto L36;
        return ((long) (r18 - r11.pos)) + r12;
    L36:
        r18 = r18 + 1;
        goto L29
    L37:
        r12 = r12 + ((long) (r11.limit - r11.pos));
        r11 = r11.next;
        if (r11 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        r0 = r12;
        r10 = r16;
        goto L27
    L41:
        return -1;
    L43:
        return -1;
    L45:
        long r110 = ((long) (r3.limit - r3.pos)) + r8;
        if (r110 > r0) goto L47;
        r3 = r3.next;
        if (r3 != null) goto L72;
        Intrinsics.throwNpe();
    L72:
        r6 = this;
        r8 = r110;
        goto L45
    L47:
        if (r3 == null) goto L67;
        byte[] r21 = r19.internalArray$jvm();
        byte r111 = r21[0];
        int r112 = r19.size();
        long r113 = 1 + (r6.size - ((long) r112));
        long r114 = r8;
        Segment r22 = r3;
    L50:
        if (r114 >= r113) goto L65;
        byte[] r23 = r22.data;
        int r24 = (int) Math.min(r22.limit, (((long) r22.pos) + r113) - r114);
        int r25 = (int) ((((long) r22.pos) + r0) - r114);
    L52:
        if (r25 >= r24) goto L61;
        if (r23[r25] != r111) goto L59;
        int r115 = r25;
        if (rangeEquals(r22, r25 + 1, r21, 1, r112) == false) goto L60;
        return ((long) (r115 - r22.pos)) + r114;
    L60:
        r25 = r115 + 1;
        goto L52
    L59:
        r115 = r25;
        goto L60
    L61:
        r114 = r114 + ((long) (r22.limit - r22.pos));
        r22 = r22.next;
        if (r22 != null) goto L64;
        Intrinsics.throwNpe();
    L64:
        r0 = r114;
        goto L50
    L65:
        return -1;
    L67:
        return -1;
    L76:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("fromIndex < 0: " + r0).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L78:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("bytes is empty".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) {
        Intrinsics.checkParameterIsNotNull(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r12, long r13) {
        Intrinsics.checkParameterIsNotNull(r12, "targetBytes");
        long r0 = 0;
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L98;
        Segment r3 = this.head;
        if (r3 != null) goto L11;
        Segment r11 = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        return -1;
    L11:
        if ((size() - r13) >= r13) goto L55;
        r0 = size();
    L14:
        if (r0 <= r13) goto L19;
        r3 = r3.prev;
        if (r3 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        r0 = r0 - ((long) (r3.limit - r3.pos));
        goto L14
    L19:
        if (r3 != null) goto L21;
    L54:
        return -1;
    L21:
        if (r12.size() != 2) goto L38;
        byte r4 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L24:
        if (r0 >= this.size) goto L54;
        byte[] r5 = r3.data;
        int r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r16 = r3.limit;
    L26:
        if (r15 >= r16) goto L34;
        byte r6 = r5[r15];
        if (r6 == r4) goto L33;
        if (r6 == r14) goto L33;
        r15 = r15 + 1;
    L33:
        return ((long) (r15 - r3.pos)) + r0;
    L34:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        if (r3 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        r13 = r0;
        goto L24
    L38:
        byte[] r17 = r12.internalArray$jvm();
    L40:
        if (r0 >= this.size) goto L54;
        byte[] r7 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r18 = r3.limit;
    L42:
        if (r15 >= r18) goto L50;
        byte r8 = r7[r15];
        int r9 = r17.length;
        int r10 = 0;
    L44:
        if (r10 >= r9) goto L49;
        if (r8 == r17[r10]) goto L33;
        r10 = r10 + 1;
        goto L44
    L49:
        r15 = r15 + 1;
        goto L42
    L50:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        if (r3 != null) goto L53;
        Intrinsics.throwNpe();
    L53:
        r13 = r0;
    L55:
        long r19 = ((long) (r3.limit - r3.pos)) + r0;
        if (r19 > r13) goto L57;
        r3 = r3.next;
        if (r3 != null) goto L94;
        Intrinsics.throwNpe();
    L94:
        r0 = r19;
        goto L55
    L57:
        if (r3 != null) goto L59;
    L90:
        return -1;
    L59:
        if (r12.size() != 2) goto L74;
        byte r20 = r12.getByte(0);
        byte r110 = r12.getByte(1);
    L62:
        if (r0 >= this.size) goto L90;
        byte[] r21 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r111 = r3.limit;
    L64:
        if (r15 >= r111) goto L70;
        byte r22 = r21[r15];
        if (r22 == r20) goto L33;
        if (r22 == r110) goto L33;
        r15 = r15 + 1;
        goto L64
    L70:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        if (r3 != null) goto L73;
        Intrinsics.throwNpe();
    L73:
        r13 = r0;
        goto L62
    L74:
        byte[] r112 = r12.internalArray$jvm();
    L76:
        if (r0 >= this.size) goto L90;
        byte[] r23 = r3.data;
        r15 = (int) ((((long) r3.pos) + r13) - r0);
        int r113 = r3.limit;
    L78:
        if (r15 >= r113) goto L86;
        byte r24 = r23[r15];
        int r25 = r112.length;
        int r26 = 0;
    L80:
        if (r26 >= r25) goto L85;
        if (r24 == r112[r26]) goto L33;
        r26 = r26 + 1;
        goto L80
    L85:
        r15 = r15 + 1;
        goto L78
    L86:
        r0 = r0 + ((long) (r3.limit - r3.pos));
        r3 = r3.next;
        if (r3 != null) goto L89;
        Intrinsics.throwNpe();
    L89:
        r13 = r0;
        goto L76
    L98:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("fromIndex < 0: " + r13).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return (InputStream) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), InputStream.class, "com.obric.memorydata.plugin");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(CryptoConst.ALGORITHM_MD5);
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return (OutputStream) ZeusTransformUtils.preCheckCast(new C12901(this), OutputStream.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer((Source) ZeusTransformUtils.preCheckCast(new PeekSource((BufferedSource) ZeusTransformUtils.preCheckCast(this, BufferedSource.class, "com.obric.memorydata.plugin")), Source.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10) {
        Intrinsics.checkParameterIsNotNull(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9, int r10, int r11) {
        Intrinsics.checkParameterIsNotNull(r9, "bytes");
        if (r7 < 0) goto L19;
        if (r10 < 0) goto L19;
        if (r11 < 0) goto L19;
        if ((this.size - r7) < r11) goto L19;
        if ((r9.size() - r10) < r11) goto L19;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (getByte(((long) r0) + r7) != r9.getByte(r10 + r0)) goto L15;
        r0 = r0 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r7) {
        Intrinsics.checkParameterIsNotNull(r7, "sink");
        Segment r0 = this.head;
        if (r0 == null) goto L8;
        int r1 = Math.min(r7.remaining(), r0.limit - r0.pos);
        r7.put(r0.data, r0.pos, r1);
        r0.pos += r1;
        this.size -= (long) r1;
        if (r0.pos != r0.limit) goto L7;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L7:
        return r1;
    L8:
        return -1;
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) {
        Intrinsics.checkParameterIsNotNull(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r8, int r9, int r10) {
        Intrinsics.checkParameterIsNotNull(r8, "sink");
        Util.checkOffsetAndCount(r8.length, r9, r10);
        Segment r0 = this.head;
        if (r0 == null) goto L8;
        int r11 = Math.min(r10, r0.limit - r0.pos);
        System.arraycopy(r0.data, r0.pos, r8, r9, r11);
        r0.pos += r11;
        this.size -= (long) r11;
        if (r0.pos != r0.limit) goto L7;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L7:
        return r11;
    L8:
        return -1;
    }

    @Override // okio.Source
    public long read(Buffer r5, long r6) {
        Intrinsics.checkParameterIsNotNull(r5, "sink");
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        long r3 = this.size;
        if (r3 != 0) goto L12;
        return -1;
    L12:
        if (r6 <= r3) goto L14;
        r6 = r3;
    L14:
        r5.write(this, r6);
        return r6;
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r5) {
        Sink r6 = (Sink) ZeusTransformUtils.wrapperContextForParams(r5, Sink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "sink");
        long r0 = this.size;
        if (r0 <= 0) goto L5;
        r6.write(this, r0);
    L5:
        return r0;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor r4) {
        Intrinsics.checkParameterIsNotNull(r4, "unsafeCursor");
        if (r4.buffer != null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        r4.buffer = (Buffer) ZeusTransformUtils.preCheckCast(this, Buffer.class, "com.obric.memorydata.plugin");
        r4.readWrite = true;
        return r4;
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("already attached to a buffer".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        if (this.size == 0) goto L13;
        Segment r0 = this.head;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        int r1 = r0.pos;
        int r2 = r0.limit;
        int r4 = r1 + 1;
        byte r3 = r0.data[r1];
        this.size--;
        if (r4 != r2) goto L10;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L11:
        return r3;
    L10:
        r0.pos = r4;
        goto L11
    L13:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(this.size);
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r5) {
        if (r5 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L17;
        if (this.size < r5) goto L15;
        byte[] r6 = new byte[(int) r5];
        readFully(r6);
        return r6;
    L15:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount: " + r5).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (r5 > Integer.MAX_VALUE) goto L7;
        r0 = true;
        goto L9
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r2) {
        return new ByteString(readByteArray(r2));
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() {
        if (this.size == 0) goto L49;
        int r1 = 0;
        long r9 = -7;
        long r7 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L5:
        Segment r11 = this.head;
        if (r11 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        byte[] r12 = r11.data;
        int r13 = r11.pos;
        int r14 = r11.limit;
    L9:
        if (r13 >= r14) goto L36;
        byte r15 = r12[r13];
        byte r5 = (byte) 48;
        if (r15 >= r5) goto L13;
    L27:
        r11 = r11;
        r12 = r12;
        if (r15 != ((byte) 45)) goto L32;
        if (r1 != 0) goto L32;
        r9 = r9 - 1;
        r3 = true;
    L31:
        r13 = r13 + 1;
        r1 = r1 + 1;
        r11 = r11;
        r12 = r12;
    L32:
        if (r1 == 0) goto L35;
        r4 = true;
    L37:
        if (r13 != r14) goto L39;
        this.head = r11.pop();
        SegmentPool.recycle(r11);
    L40:
        if (r4 == true) goto L43;
        if (this.head != null) goto L5;
    L43:
        this.size -= (long) r1;
        if (r3 == false) goto L47;
        return r7;
    L47:
        return -r7;
    L39:
        r11.pos = r13;
        goto L40
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(r15)), Throwable.class, "com.obric.memorydata.plugin"));
    L13:
        if (r15 > ((byte) 57)) goto L27;
        int r6 = r5 - r15;
        if (r7 < (-922337203685477580L)) goto L22;
        if (r7 != (-922337203685477580L)) goto L21;
        if (r6 < r9) goto L22;
    L21:
        r7 = (r7 * 10) + ((long) r6);
    L22:
        Buffer r0 = new Buffer().writeDecimalLong(r7).writeByte(r15);
        if (r3 == true) goto L26;
        r0.readByte();
    L26:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NumberFormatException("Number too large: " + r0.readUtf8()), Throwable.class, "com.obric.memorydata.plugin"));
    L36:
        r11 = r11;
        goto L37
    L49:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final Buffer readFrom(InputStream r4) {
        Intrinsics.checkParameterIsNotNull(r4, "input");
        readFrom(r4, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream r3, long r4) {
        Intrinsics.checkParameterIsNotNull(r3, "input");
        if (r4 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        readFrom(r3, r4, false);
        return this;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount < 0: " + r4).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r4, long r5) {
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        long r0 = this.size;
        if (r0 < r5) goto L6;
        r4.write(this, r5);
        return;
    L6:
        r4.write(this, r0);
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r4) {
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        if (this.size == 0) goto L43;
        int r0 = 0;
        boolean r4 = false;
        long r5 = 0;
    L5:
        Segment r7 = this.head;
        if (r7 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        byte[] r8 = r7.data;
        int r9 = r7.pos;
        int r10 = r7.limit;
    L9:
        if (r9 >= r10) goto L34;
        byte r11 = r8[r9];
        byte r12 = (byte) 48;
        if (r11 >= r12) goto L13;
    L15:
        byte r13 = (byte) 97;
        if (r11 >= r13) goto L18;
    L20:
        r13 = (byte) 65;
        if (r11 < r13) goto L30;
        if (r11 > ((byte) 70)) goto L30;
    L19:
        int r14 = (r11 - r13) + 10;
    L26:
        if (((-1152921504606846976L) & r5) != 0) goto L29;
        r5 = (r5 << 4) | ((long) r14);
        r9 = r9 + 1;
        r0 = r0 + 1;
        goto L9
    L29:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r5).writeByte(r11).readUtf8()), Throwable.class, "com.obric.memorydata.plugin"));
    L30:
        if (r0 == 0) goto L33;
        r4 = true;
        goto L34
    L33:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(r11)), Throwable.class, "com.obric.memorydata.plugin"));
    L18:
        if (r11 > ((byte) 102)) goto L20;
    L13:
        if (r11 > ((byte) 57)) goto L15;
        r14 = r11 - r12;
    L34:
        if (r9 != r10) goto L36;
        this.head = r7.pop();
        SegmentPool.recycle(r7);
    L37:
        if (r4 == true) goto L40;
        if (this.head != null) goto L5;
    L40:
        this.size -= (long) r0;
        return r5;
    L36:
        r7.pos = r9;
        goto L37
    L43:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public int readInt() {
        if (this.size < 4) goto L17;
        Segment r0 = this.head;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 4) goto L10;
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 24) | ((r5[r6] & 255) << 16);
        int r8 = r7 + 1;
        int r3 = r2 | ((r5[r7] & 255) << 8);
        int r9 = r8 + 1;
        int r10 = r3 | (r5[r8] & 255);
        this.size -= 4;
        if (r9 != r4) goto L14;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L15:
        return r10;
    L14:
        r0.pos = r9;
        goto L15
    L10:
        return (readByte() & 255) | ((((readByte() & 255) << 24) | ((readByte() & 255) << 16)) | ((readByte() & 255) << 8));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        if (this.size < 8) goto L17;
        Segment r0 = this.head;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 8) goto L10;
        byte[] r5 = r0.data;
        int r7 = r1 + 1;
        long r8 = (((long) r5[r1]) & 255) << 56;
        int r2 = r7 + 1;
        int r9 = r2 + 1;
        long r10 = (r8 | ((((long) r5[r7]) & 255) << 48)) | ((((long) r5[r2]) & 255) << 40);
        int r3 = r9 + 1;
        int r11 = r3 + 1;
        long r6 = (r10 | ((((long) r5[r9]) & 255) << 32)) | ((((long) r5[r3]) & 255) << 24);
        int r12 = r11 + 1;
        long r13 = r6 | ((((long) r5[r11]) & 255) << 16);
        int r14 = r12 + 1;
        long r15 = r13 | ((((long) r5[r12]) & 255) << 8);
        int r16 = r14 + 1;
        long r17 = r15 | (((long) r5[r14]) & 255);
        this.size -= 8;
        if (r16 != r4) goto L14;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L15:
        return r17;
    L14:
        r0.pos = r16;
        goto L15
    L10:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytes(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        if (this.size < 2) goto L18;
        Segment r0 = this.head;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        int r1 = r0.pos;
        int r4 = r0.limit;
        if ((r4 - r1) < 2) goto L10;
        byte[] r5 = r0.data;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & 255) << 8) | (r5[r6] & 255);
        this.size -= 2;
        if (r7 != r4) goto L14;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L16:
        return (short) r2;
    L14:
        r0.pos = r7;
        goto L16
    L10:
        return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(long r6, Charset r8) {
        Intrinsics.checkParameterIsNotNull(r8, "charset");
        if (r6 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L29;
        if (this.size < r6) goto L27;
        if (r6 != 0) goto L15;
        return "";
    L15:
        Segment r0 = this.head;
        if (r0 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        if ((((long) r0.pos) + r6) > r0.limit) goto L21;
        int r3 = (int) r6;
        String r4 = new String(r0.data, r0.pos, r3, r8);
        r0.pos += r3;
        this.size -= r6;
        if (r0.pos != r0.limit) goto L25;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
    L25:
        return r4;
    L21:
        return new String(readByteArray(r6), r8);
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L29:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("byteCount: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (r6 > Integer.MAX_VALUE) goto L7;
        r1 = true;
        goto L9
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) {
        Intrinsics.checkParameterIsNotNull(r3, "charset");
        return readString(this.size, r3);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor r4) {
        Intrinsics.checkParameterIsNotNull(r4, "unsafeCursor");
        if (r4.buffer != null) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        r4.buffer = (Buffer) ZeusTransformUtils.preCheckCast(this, Buffer.class, "com.obric.memorydata.plugin");
        r4.readWrite = false;
        return r4;
    L11:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("already attached to a buffer".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r2) {
        return readString(r2, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        if (this.size == 0) goto L41;
        byte r0 = getByte(0);
        int r3 = 1;
        if ((r0 & 128) != 0) goto L8;
        int r2 = r0 & ByteCompanionObject.MAX_VALUE;
        int r7 = 0;
        int r6 = 1;
    L16:
        long r10 = r6;
        if (this.size < r10) goto L37;
    L18:
        if (r3 >= r6) goto L24;
        long r1 = r3;
        byte r8 = getByte(r1);
        if ((r8 & MessagePack.Code.NIL) != 128) goto L22;
        r2 = (r2 << 6) | (r8 & Utf8.REPLACEMENT_BYTE);
        r3 = r3 + 1;
        goto L18
    L22:
        skip(r1);
        return Utf8.REPLACEMENT_CODE_POINT;
    L24:
        skip(r10);
        if (r2 <= 1114111) goto L28;
        return Utf8.REPLACEMENT_CODE_POINT;
    L28:
        if (55296 > r2) goto L32;
        if (57343 < r2) goto L32;
        return Utf8.REPLACEMENT_CODE_POINT;
    L32:
        if (r2 >= r7) goto L35;
        return Utf8.REPLACEMENT_CODE_POINT;
    L35:
        return r2;
    L37:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException("size < " + r6 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(r0) + ")"), Throwable.class, "com.obric.memorydata.plugin"));
    L8:
        if ((r0 & MessagePack.Code.NEGFIXINT_PREFIX) != 192) goto L11;
        r2 = r0 & 31;
        r6 = 2;
        r7 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r2 = r0 & 15;
        r6 = 3;
        r7 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L38;
        r2 = r0 & 7;
        r6 = 4;
        r7 = 65536;
        goto L16
    L38:
        skip(1);
        return Utf8.REPLACEMENT_CODE_POINT;
    L41:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() {
        long r0 = indexOf((byte) 10);
        if (r0 != (-1)) goto L10;
        long r1 = this.size;
        if (r1 != 0) goto L11;
        return null;
    L11:
        return readUtf8(r1);
    L10:
        return readUtf8Line$jvm(r0);
    }

    public final String readUtf8Line$jvm(long r7) {
        if (r7 <= 0) goto L7;
        long r3 = r7 - 1;
        if (getByte(r3) != ((byte) 13)) goto L7;
        String r8 = readUtf8(r3);
        skip(2);
        return r8;
    L7:
        String r9 = readUtf8(r7);
        skip(1);
        return r9;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r13) {
        if (r13 < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L27;
        long r2 = Long.MAX_VALUE;
        if (r13 == Long.MAX_VALUE) goto L12;
        r2 = r13 + 1;
    L12:
        byte r1 = (byte) 10;
        long r6 = indexOf(r1, 0, r2);
        if (r6 == (-1)) goto L17;
        return readUtf8Line$jvm(r6);
    L17:
        if (r2 < this.size) goto L19;
    L24:
        Buffer r3 = new Buffer();
        copyTo(r3, 0, Math.min(32, this.size));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException("\\n not found: limit=" + Math.min(this.size, r13) + " content=" + r3.readByteString().hex() + Typography.ellipsis), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        if (getByte(r2 - 1) != ((byte) 13)) goto L24;
        if (getByte(r2) != r1) goto L24;
        return readUtf8Line$jvm(r2);
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("limit < 0: " + r13).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L7
    }

    @Override // okio.BufferedSource
    public boolean request(long r3) {
        if (this.size < r3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r3) {
        if (this.size < r3) goto L6;
        return;
    L6:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSource
    public int select(Options r4) {
        Intrinsics.checkParameterIsNotNull(r4, "options");
        int r0 = selectPrefix$jvm$default(this, r4, false, 2, null);
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        skip(r4.getByteStrings$jvm()[r0].size());
        return r0;
    }

    public final int selectPrefix$jvm(Options r18, boolean r19) {
        Intrinsics.checkParameterIsNotNull(r18, "options");
        Segment r0 = this.head;
        int r2 = -2;
        if (r0 == null) goto L55;
        byte[] r4 = r0.data;
        int r5 = r0.pos;
        int r6 = r0.limit;
        int[] r1 = r18.getTrie$jvm();
        Segment r9 = r0;
        int r10 = -1;
        int r8 = 0;
    L5:
        int r11 = r8 + 1;
        int r12 = r1[r8];
        int r13 = r11 + 1;
        int r14 = r1[r11];
        if (r14 == (-1)) goto L8;
        r10 = r14;
    L8:
        if (r9 == null) goto L28;
        if (r12 >= 0) goto L37;
        int r15 = r13 + (r12 * (-1));
    L13:
        int r16 = r5 + 1;
        int r17 = r13 + 1;
        if ((r4[r5] & 255) != r1[r13]) goto L15;
        if (r17 != r15) goto L18;
        boolean r7 = true;
    L19:
        if (r16 != r6) goto L33;
        if (r9 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        Segment r20 = r9.next;
        if (r20 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        int r21 = r20.pos;
        byte[] r22 = r20.data;
        int r23 = r20.limit;
        if (r20 != r0) goto L32;
        if (r7 == false) goto L28;
        r20 = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
    L32:
        Segment r24 = r20;
        r4 = r22;
    L34:
        if (r7 == true) goto L35;
        r5 = r21;
        r6 = r23;
        r13 = r17;
        r9 = r24;
        goto L13
    L35:
        int r25 = r1[r17];
        int r3 = r21;
        r6 = r23;
        r9 = r24;
    L51:
        if (r25 >= 0) goto L52;
        r8 = -r25;
        r5 = r3;
        r2 = -2;
        goto L5
    L52:
        return r25;
    L33:
        Segment r110 = r9;
        r23 = r6;
        r21 = r16;
        r24 = r110;
        goto L34
    L18:
        r7 = false;
        goto L19
    L15:
        return r10;
    L37:
        int r111 = r5 + 1;
        int r26 = r4[r5] & 255;
        int r112 = r13 + r12;
    L38:
        if (r13 == r112) goto L39;
        if (r26 == r1[r13]) goto L42;
        r13 = r13 + 1;
        goto L38
    L42:
        r25 = r1[r13 + r12];
        if (r111 != r6) goto L50;
        r9 = r9.next;
        if (r9 != null) goto L47;
        Intrinsics.throwNpe();
    L47:
        r3 = r9.pos;
        r4 = r9.data;
        r6 = r9.limit;
        if (r9 != r0) goto L51;
        r9 = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        goto L51
    L50:
        r3 = r111;
        goto L51
    L39:
        return r10;
    L28:
        if (r19 == false) goto L30;
        return r2;
    L30:
        return r10;
    L55:
        if (r19 == false) goto L58;
        return -2;
    L58:
        return -1;
    }

    public final void setSize$jvm(long r1) {
        this.size = r1;
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest(CryptoConst.ALGORITHM_SHA256);
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long r7) {
    L3:
        if (r7 <= 0) goto L11;
        Segment r0 = this.head;
        if (r0 == null) goto L10;
        int r1 = (int) Math.min(r7, r0.limit - r0.pos);
        long r4 = r1;
        this.size -= r4;
        r7 = r7 - r4;
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L3;
        this.head = r0.pop();
        SegmentPool.recycle(r0);
        goto L3
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final ByteString snapshot() {
        long r0 = this.size;
        if (r0 > Integer.MAX_VALUE) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L10;
        return snapshot((int) r0);
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException(("size > Integer.MAX_VALUE: " + this.size).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L6
    }

    public final ByteString snapshot(int r2) {
        if (r2 != 0) goto L5;
        return ByteString.EMPTY;
    L5:
        return SegmentedByteString.Companion.of(this, r2);
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$jvm(int r3) {
        boolean r1 = true;
        if (r3 < 1) goto L6;
        if (r3 > 8192) goto L6;
    L7:
        if (r1 == false) goto L24;
        Segment r2 = this.head;
        if (r2 != null) goto L12;
        Segment r4 = SegmentPool.take();
        this.head = r4;
        r4.prev = r4;
        r4.next = r4;
        return r4;
    L12:
        if (r2 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        Segment r5 = r2.prev;
        if (r5 != null) goto L18;
        Intrinsics.throwNpe();
    L18:
        if ((r5.limit + r3) > 8192) goto L22;
        if (r5.owner == false) goto L22;
        return r5;
    L22:
        return r5.push(SegmentPool.take());
    L24:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("unexpected capacity".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L6:
        r1 = false;
        goto L7
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r7) {
        Intrinsics.checkParameterIsNotNull(r7, AILabCheckPermissionTask.KEY_SOURCE);
        int r0 = r7.remaining();
        int r1 = r0;
    L3:
        if (r1 <= 0) goto L5;
        Segment r2 = writableSegment$jvm(1);
        int r3 = Math.min(r1, 8192 - r2.limit);
        r7.get(r2.data, r2.limit, r3);
        r1 = r1 - r3;
        r2.limit += r3;
        goto L3
    L5:
        this.size += (long) r0;
        return r0;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r2) {
        Intrinsics.checkParameterIsNotNull(r2, "byteString");
        r2.write$jvm(this);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r3) {
        Intrinsics.checkParameterIsNotNull(r3, AILabCheckPermissionTask.KEY_SOURCE);
        return write(r3, 0, r3.length);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r10, int r11, int r12) {
        Intrinsics.checkParameterIsNotNull(r10, AILabCheckPermissionTask.KEY_SOURCE);
        long r7 = r12;
        Util.checkOffsetAndCount(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        Segment r0 = writableSegment$jvm(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.limit);
        System.arraycopy(r10, r11, r0.data, r0.limit, r1);
        r11 = r11 + r1;
        r0.limit += r1;
        goto L3
    L5:
        this.size += r7;
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink write(ByteString r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(write(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source r7, long r8) {
        Source r9 = (Source) ZeusTransformUtils.wrapperContextForParams(r7, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r9, AILabCheckPermissionTask.KEY_SOURCE);
    L4:
        if (r8 <= 0) goto L11;
        long r2 = r9.read(this, r8);
        if (r2 == (-1)) goto L9;
        r8 = r8 - r2;
        goto L4
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new EOFException(), Throwable.class, "com.obric.memorydata.plugin"));
    L11:
        return (BufferedSink) ZeusTransformUtils.preCheckCast(this, BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink write(byte[] r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(write(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink write(byte[] r1, int r2, int r3) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(write(r1, r2, r3), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.Sink
    public void write(Buffer r10, long r11) {
        Intrinsics.checkParameterIsNotNull(r10, AILabCheckPermissionTask.KEY_SOURCE);
        if (r10 == ((Buffer) ZeusTransformUtils.preCheckCast(this, Buffer.class, "com.obric.memorydata.plugin"))) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L57;
        Util.checkOffsetAndCount(r10.size, 0, r11);
    L9:
        if (r11 <= 0) goto L55;
        Segment r1 = r10.head;
        if (r1 != null) goto L13;
        Intrinsics.throwNpe();
    L13:
        int r2 = r1.limit;
        Segment r3 = r10.head;
        if (r3 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        if (r11 >= (r2 - r3.pos)) goto L42;
        Segment r4 = this.head;
        if (r4 == null) goto L23;
        if (r4 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        Segment r5 = r4.prev;
    L24:
        if (r5 != null) goto L26;
    L38:
        Segment r6 = r10.head;
        if (r6 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r10.head = r6.split((int) r11);
        goto L42
    L26:
        if (r5.owner == false) goto L38;
        long r7 = ((long) r5.limit) + r11;
        if (r5.shared == false) goto L30;
        int r8 = 0;
    L32:
        if ((r7 - ((long) r8)) > 8192) goto L38;
        Segment r9 = r10.head;
        if (r9 != null) goto L36;
        Intrinsics.throwNpe();
    L36:
        r9.writeTo(r5, (int) r11);
        r10.size -= r11;
        this.size += r11;
        return;
    L30:
        r8 = r5.pos;
        goto L32
    L23:
        r5 = null;
    L42:
        Segment r12 = r10.head;
        if (r12 != null) goto L45;
        Intrinsics.throwNpe();
    L45:
        long r13 = r12.limit - r12.pos;
        r10.head = r12.pop();
        Segment r14 = this.head;
        if (r14 != null) goto L48;
        this.head = r12;
        r12.prev = r12;
        r12.next = r12.prev;
    L54:
        r10.size -= r13;
        this.size += r13;
        r11 = r11 - r13;
        goto L9
    L48:
        if (r14 != null) goto L50;
        Intrinsics.throwNpe();
    L50:
        Segment r15 = r14.prev;
        if (r15 != null) goto L53;
        Intrinsics.throwNpe();
    L53:
        r15.push(r12).compact();
        goto L54
    L55:
        return;
    L57:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("source == this".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r7) {
        Source r8 = (Source) ZeusTransformUtils.wrapperContextForParams(r7, Source.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r8, AILabCheckPermissionTask.KEY_SOURCE);
        long r0 = 0;
    L3:
        long r2 = r8.read(this, 8192);
        if (r2 == (-1)) goto L5;
        r0 = r0 + r2;
        goto L3
    L5:
        return r0;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int r5) {
        Segment r0 = writableSegment$jvm(1);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        r0.limit = r2 + 1;
        r1[r2] = (byte) r5;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeByte(int r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeByte(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long r13) {
        if (r13 == 0) goto L5;
        boolean r3 = false;
        int r4 = 1;
        if (r13 >= 0) goto L14;
        r13 = -r13;
        if (r13 < 0) goto L11;
        r3 = true;
        goto L14
    L11:
        return writeUtf8("-9223372036854775808");
    L14:
        if (r13 >= 100000000) goto L39;
        if (r13 >= 10000) goto L29;
        if (r13 >= 100) goto L24;
        if (r13 < 10) goto L69;
        r4 = 2;
    L69:
        if (r3 == false) goto L71;
        r4 = r4 + 1;
    L71:
        Segment r2 = writableSegment$jvm(r4);
        byte[] r6 = r2.data;
        int r7 = r2.limit + r4;
    L73:
        if (r13 == 0) goto L75;
        long r8 = 10;
        r7 = r7 - 1;
        r6[r7] = DIGITS[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L73
    L75:
        if (r3 == false) goto L77;
        r6[r7 - 1] = (byte) 45;
    L77:
        r2.limit += r4;
        this.size += (long) r4;
        return this;
    L24:
        if (r13 >= 1000) goto L26;
        int r5 = 3;
    L27:
        r4 = r5;
        goto L69
    L26:
        r5 = 4;
        goto L27
    L29:
        if (r13 >= TimeUtils.NANOSECONDS_PER_MILLISECOND) goto L35;
        if (r13 >= 100000) goto L33;
        r5 = 5;
        goto L27
    L33:
        r5 = 6;
        goto L27
    L35:
        if (r13 >= StackLeakChecker.CHECK_INTERVAL_10_SEC) goto L37;
        r5 = 7;
        goto L27
    L37:
        r5 = 8;
        goto L27
    L39:
        if (r13 >= 1000000000000L) goto L51;
        if (r13 >= 10000000000L) goto L47;
        if (r13 >= 1000000000) goto L45;
        r4 = 9;
        goto L69
    L45:
        r4 = 10;
        goto L69
    L47:
        if (r13 >= 100000000000L) goto L49;
        r5 = 11;
        goto L27
    L49:
        r5 = 12;
        goto L27
    L51:
        if (r13 >= 1000000000000000L) goto L60;
        if (r13 >= 10000000000000L) goto L56;
        r4 = 13;
        goto L69
    L56:
        if (r13 >= 100000000000000L) goto L58;
        r5 = 14;
        goto L27
    L58:
        r5 = 15;
        goto L27
    L60:
        if (r13 >= 100000000000000000L) goto L66;
        if (r13 >= 10000000000000000L) goto L64;
        r4 = 16;
        goto L69
    L64:
        r4 = 17;
        goto L69
    L66:
        if (r13 >= 1000000000000000000L) goto L68;
        r4 = 18;
        goto L69
    L68:
        r4 = 19;
        goto L69
    L5:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeDecimalLong(long r1) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeDecimalLong(r1), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long r10) {
        if (r10 == 0) goto L5;
        int r0 = (Long.numberOfTrailingZeros(Long.highestOneBit(r10)) / 4) + 1;
        Segment r2 = writableSegment$jvm(r0);
        byte[] r3 = r2.data;
        int r4 = (r2.limit + r0) - 1;
        int r5 = r2.limit;
    L7:
        if (r4 < r5) goto L9;
        r3[r4] = DIGITS[(int) (15 & r10)];
        r10 = r10 >>> 4;
        r4 = r4 - 1;
        goto L7
    L9:
        r2.limit += r0;
        this.size += (long) r0;
        return this;
    L5:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r1) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeHexadecimalUnsignedLong(r1), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int r6) {
        Segment r0 = writableSegment$jvm(4);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & 255);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & 255);
        int r5 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & 255);
        r1[r5] = (byte) (r6 & 255);
        r0.limit = r5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeInt(int r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeInt(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int r1) {
        return writeInt(Util.reverseBytes(r1));
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeIntLe(int r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeIntLe(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long r10) {
        Segment r1 = writableSegment$jvm(8);
        byte[] r2 = r1.data;
        int r3 = r1.limit;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r9 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r11 = r9 + 1;
        r2[r9] = (byte) ((r10 >>> 8) & 255);
        r2[r11] = (byte) (r10 & 255);
        r1.limit = r11 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeLong(long r1) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeLong(r1), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long r1) {
        return writeLong(Util.reverseBytes(r1));
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeLongLe(long r1) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeLongLe(r1), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int r6) {
        Segment r0 = writableSegment$jvm(2);
        byte[] r1 = r0.data;
        int r2 = r0.limit;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & 255);
        r1[r3] = (byte) (r6 & 255);
        r0.limit = r3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeShort(int r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeShort(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int r1) {
        return writeShort(Util.reverseBytes((short) r1));
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeShortLe(int r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeShortLe(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r5, int r6, int r7, Charset r8) {
        Intrinsics.checkParameterIsNotNull(r5, TypedValues.Custom.S_STRING);
        Intrinsics.checkParameterIsNotNull(r8, "charset");
        boolean r0 = true;
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L32;
        if (r7 < r6) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L30;
        if (r7 <= r5.length()) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L28;
        if (Intrinsics.areEqual(r8, Charsets.UTF_8) == true) goto L20;
        String r9 = r5.substring(r6, r7);
        Intrinsics.checkExpressionValueIsNotNull(r9, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (r9 == null) goto L26;
        byte[] r10 = r9.getBytes(r8);
        Intrinsics.checkExpressionValueIsNotNull(r10, "(this as java.lang.String).getBytes(charset)");
        return write(r10, 0, r10.length);
    L26:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L20:
        return writeUtf8(r5, r6, r7);
    L28:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex > string.length: " + r7 + " > " + r5.length()).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L30:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex < beginIndex: " + r7 + " < " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        r3 = false;
        goto L11
    L32:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("beginIndex < 0: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r3, Charset r4) {
        Intrinsics.checkParameterIsNotNull(r3, TypedValues.Custom.S_STRING);
        Intrinsics.checkParameterIsNotNull(r4, "charset");
        return writeString(r3, 0, r3.length(), r4);
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeString(String r1, int r2, int r3, Charset r4) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeString(r1, r2, r3, r4), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeString(String r1, Charset r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeString(r1, r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    public final Buffer writeTo(OutputStream r7) {
        return writeTo$default(this, r7, 0, 2, null);
    }

    public final Buffer writeTo(OutputStream r8, long r9) {
        Intrinsics.checkParameterIsNotNull(r8, "out");
        Util.checkOffsetAndCount(this.size, 0, r9);
        Segment r0 = this.head;
    L4:
        if (r9 <= 0) goto L10;
        if (r0 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        int r1 = (int) Math.min(r9, r0.limit - r0.pos);
        r8.write(r0.data, r0.pos, r1);
        r0.pos += r1;
        long r4 = r1;
        this.size -= r4;
        r9 = r9 - r4;
        if (r0.pos != r0.limit) goto L4;
        Segment r2 = r0.pop();
        this.head = r2;
        SegmentPool.recycle(r0);
        r0 = r2;
        goto L4
    L10:
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r3) {
        Intrinsics.checkParameterIsNotNull(r3, TypedValues.Custom.S_STRING);
        return writeUtf8(r3, 0, r3.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r13, int r14, int r15) {
        Intrinsics.checkParameterIsNotNull(r13, TypedValues.Custom.S_STRING);
        if (r14 < 0) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L56;
        if (r15 < r14) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L54;
        if (r15 > r13.length()) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L52;
    L17:
        if (r14 >= r15) goto L50;
        char r5 = r13.charAt(r14);
        if (r5 < 128) goto L20;
        if (r5 < 2048) goto L30;
        if (r5 < 55296) goto L49;
        if (r5 > 57343) goto L49;
        int r8 = r14 + 1;
        if (r8 >= r15) goto L40;
        char r9 = r13.charAt(r8);
    L42:
        if (r5 > 56319) goto L48;
        if (56320 > r9) goto L48;
        if (57343 < r9) goto L48;
        int r6 = (((r5 & 1023) << 10) | (r9 & 1023)) + 65536;
        Segment r10 = writableSegment$jvm(4);
        r10.data[r10.limit] = (byte) ((r6 >> 18) | 240);
        r10.data[r10.limit + 1] = (byte) (((r6 >> 12) & 63) | 128);
        r10.data[r10.limit + 2] = (byte) (((r6 >> 6) & 63) | 128);
        r10.data[r10.limit + 3] = (byte) ((r6 & 63) | 128);
        r10.limit += 4;
        this.size += 4;
        r14 = r14 + 2;
    L48:
        writeByte(63);
    L27:
        r14 = r8;
        goto L17
    L40:
        r9 = 0;
    L49:
        Segment r7 = writableSegment$jvm(3);
        r7.data[r7.limit] = (byte) ((r5 >> '\f') | 224);
        r7.data[r7.limit + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r7.data[r7.limit + 2] = (byte) ((r5 & '?') | 128);
        r7.limit += 3;
        long r11 = this.size;
        long r12 = 3;
    L31:
        this.size = r11 + r12;
        r14 = r14 + 1;
        goto L17
    L30:
        Segment r16 = writableSegment$jvm(2);
        r16.data[r16.limit] = (byte) ((r5 >> 6) | 192);
        r16.data[r16.limit + 1] = (byte) ((r5 & '?') | 128);
        r16.limit += 2;
        r11 = this.size;
        r12 = 2;
        goto L31
    L20:
        Segment r17 = writableSegment$jvm(1);
        byte[] r18 = r17.data;
        int r19 = r17.limit - r14;
        int r20 = Math.min(r15, 8192 - r19);
        r8 = r14 + 1;
        r18[r14 + r19] = (byte) r5;
    L21:
        if (r8 >= r20) goto L26;
        char r110 = r13.charAt(r8);
        if (r110 >= 128) goto L26;
        r18[r8 + r19] = (byte) r110;
        r8 = r8 + 1;
    L26:
        int r21 = (r19 + r8) - r17.limit;
        r17.limit += r21;
        this.size += (long) r21;
        goto L27
    L50:
        return this;
    L52:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex > string.length: " + r15 + " > " + r13.length()).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L15:
        r4 = false;
        goto L16
    L54:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("endIndex < beginIndex: " + r15 + " < " + r14).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L10:
        r3 = false;
        goto L11
    L56:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("beginIndex < 0: " + r14).toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r2 = false;
        goto L7
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeUtf8(String r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeUtf8(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeUtf8(String r1, int r2, int r3) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeUtf8(r1, r2, r3), BufferedSink.class, "com.obric.memorydata.plugin");
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int r10) {
        if (r10 >= 128) goto L6;
        writeByte(r10);
    L20:
        return this;
    L6:
        if (r10 >= 2048) goto L10;
        Segment r1 = writableSegment$jvm(2);
        r1.data[r1.limit] = (byte) ((r10 >> 6) | 192);
        r1.data[r1.limit + 1] = (byte) ((r10 & 63) | 128);
        r1.limit += 2;
        long r0 = this.size;
        long r2 = 2;
    L8:
        this.size = r0 + r2;
        goto L20
    L10:
        if (55296 > r10) goto L15;
        if (57343 < r10) goto L15;
        writeByte(63);
    L15:
        if (r10 >= 65536) goto L18;
        Segment r3 = writableSegment$jvm(3);
        r3.data[r3.limit] = (byte) ((r10 >> 12) | 224);
        r3.data[r3.limit + 1] = (byte) (((r10 >> 6) & 63) | 128);
        r3.data[r3.limit + 2] = (byte) ((r10 & 63) | 128);
        r3.limit += 3;
        r0 = this.size;
        r2 = 3;
        goto L8
    L18:
        if (r10 > 1114111) goto L22;
        Segment r5 = writableSegment$jvm(4);
        r5.data[r5.limit] = (byte) ((r10 >> 18) | 240);
        r5.data[r5.limit + 1] = (byte) (((r10 >> 12) & 63) | 128);
        r5.data[r5.limit + 2] = (byte) (((r10 >> 6) & 63) | 128);
        r5.data[r5.limit + 3] = (byte) ((r10 & 63) | 128);
        r5.limit += 4;
        r0 = this.size;
        r2 = 4;
        goto L8
    L22:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(r10)), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // okio.BufferedSink
    public /* synthetic */ BufferedSink writeUtf8CodePoint(int r2) {
        return (BufferedSink) ZeusTransformUtils.preCheckCast(writeUtf8CodePoint(r2), BufferedSink.class, "com.obric.memorydata.plugin");
    }
}
