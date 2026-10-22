package kotlinx.serialization.b;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.modules.d;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&JE\u0010\u001b\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001cH'¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0007H\u0017J=\u0010\"\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u0001H\u001cH&¢\u0006\u0002\u0010 J\u0018\u0010#\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010'\u001a\u00020(2\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006*"}, d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "decodeByteElement", "", "decodeCharElement", "", "decodeCollectionSize", "decodeDoubleElement", "", "decodeElementIndex", "decodeFloatElement", "", "decodeInlineElement", "Lkotlinx/serialization/encoding/Decoder;", "decodeIntElement", "decodeLongElement", "", "decodeNullableSerializableElement", ExifInterface.GPS_DIRECTION_TRUE, "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSequentially", "decodeSerializableElement", "decodeShortElement", "", "decodeStringElement", "", "endStructure", "", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17664a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/serialization/encoding/CompositeDecoder$Companion;", "", "()V", "DECODE_DONE", "", "UNKNOWN_NAME", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f17665a = null;

        static {
            f17665a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: kotlinx.serialization.b.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class C0886b {
        public static int a(b r2, f r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin"), "descriptor");
            return -1;
        }

        public static /* synthetic */ Object a(b r2, f r3, int r4, kotlinx.serialization.b r5, Object r6, int r7, Object r8) {
            b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
            kotlinx.serialization.b r11 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 8) == 0) goto L8;
            r6 = null;
        L8:
            return r9.a(r10, r4, r11, r6);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
        }

        public static boolean a(b r2) {
            b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
            return false;
        }
    }

    static {
        f17664a = a.f17665a;
    }

    <T> T a(f r1, int r2, kotlinx.serialization.b<T> r3, T r4);

    boolean a(f r1, int r2);

    byte b(f r1, int r2);

    short c(f r1, int r2);

    int d(f r1, int r2);

    void d(f r1);

    int e(f r1);

    long e(f r1, int r2);

    float f(f r1, int r2);

    int f(f r1);

    double g(f r1, int r2);

    char h(f r1, int r2);

    String i(f r1, int r2);

    c j(f r1, int r2);

    boolean m();

    d n();
}
