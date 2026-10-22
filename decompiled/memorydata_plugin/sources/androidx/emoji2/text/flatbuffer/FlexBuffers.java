package androidx.emoji2.text.flatbuffer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UShort;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReadBuf EMPTY_BB = null;
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = null;

        static {
            EMPTY = new Blob(FlexBuffers.access$000(), 1, 1);
        }

        Blob(ReadBuf r3, int r4, int r5) {
            super((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer r0 = ByteBuffer.wrap(this.bb.data());
            r0.position(this.end);
            r0.limit(this.end + size());
            return r0.asReadOnlyBuffer().slice();
        }

        public byte get(int r2) {
            return this.bb.get(this.end + r2);
        }

        public byte[] getBytes() {
            int r0 = size();
            byte[] r1 = new byte[r0];
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            r1[r2] = this.bb.get(this.end + r2);
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r4) {
            r4.append(Typography.quote);
            r4.append(this.bb.getString(this.end, size()));
            return r4.append(Typography.quote);
        }
    }

    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String r1) {
            super(r1);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = null;

        static {
            EMPTY = new Key(FlexBuffers.access$000(), 0, 0);
        }

        Key(ReadBuf r3, int r4, int r5) {
            super((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        static /* synthetic */ Key access$700() {
            return EMPTY;
        }

        public static Key empty() {
            return EMPTY;
        }

        int compareTo(byte[] r6) {
            int r0 = this.end;
            int r1 = 0;
        L3:
            byte r2 = this.bb.get(r0);
            byte r3 = r6[r1];
            if (r2 == 0) goto L6;
            r0 = r0 + 1;
            r1 = r1 + 1;
            if (r1 == r6.length) goto L10;
            if (r2 == r3) goto L3;
            return r2 - r3;
        L10:
            return r2 - r3;
        L6:
            return r2 - r3;
        }

        public boolean equals(java.lang.Object r6) {
            if (ZeusTransformUtils.instanceOf(r6, Key.class) == true) goto L6;
            return false;
        L6:
            if (((Key) ZeusTransformUtils.preCheckCast(r6, Key.class, "com.obric.memorydata.plugin")).end == this.end) goto L8;
            return false;
        L8:
            if (((Key) ZeusTransformUtils.preCheckCast(r6, Key.class, "com.obric.memorydata.plugin")).byteWidth != this.byteWidth) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = this.end;
            return this.byteWidth ^ r0;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int r0 = this.end;
        L4:
            if (this.bb.get(r0) == 0) goto L5;
            r0 = r0 + 1;
            goto L4
        L5:
            int r1 = r0 - this.end;
            return this.bb.getString(this.end, r1);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r1) {
            return r1.append(toString());
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector r1) {
            this.vec = r1;
        }

        public Key get(int r4) {
            if (r4 >= size()) goto L5;
            int r0 = this.vec.end + (r4 * this.vec.byteWidth);
            return new Key(this.vec.bb, FlexBuffers.access$200(this.vec.bb, r0, this.vec.byteWidth), 1);
        L5:
            return Key.access$700();
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append('[');
            int r1 = 0;
        L4:
            if (r1 >= this.vec.size()) goto L10;
            this.vec.get(r1).toString(r0);
            if (r1 == (this.vec.size() - 1)) goto L8;
            r0.append(", ");
        L8:
            r1 = r1 + 1;
            goto L4
        L10:
            return r0.append("]").toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = null;

        static {
            EMPTY_MAP = new Map(FlexBuffers.access$000(), 1, 1);
        }

        Map(ReadBuf r3, int r4, int r5) {
            super((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        private int binarySearch(KeyVector r4, byte[] r5) {
            int r3 = r4.size() - 1;
            int r0 = 0;
        L3:
            if (r0 > r3) goto L11;
            int r1 = (r0 + r3) >>> 1;
            int r2 = r4.get(r1).compareTo(r5);
            if (r2 < 0) goto L6;
            if (r2 <= 0) goto L9;
            r3 = r1 - 1;
            goto L3
        L9:
            return r1;
        L6:
            r0 = r1 + 1;
            goto L3
        L11:
            return -(r0 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String r2) {
            return get(r2.getBytes(StandardCharsets.UTF_8));
        }

        public Reference get(byte[] r3) {
            KeyVector r0 = keys();
            int r1 = r0.size();
            int r4 = binarySearch(r0, r3);
            if (r4 < 0) goto L8;
            if (r4 >= r1) goto L8;
            return get(r4);
        L8:
            return Reference.access$600();
        }

        public KeyVector keys() {
            int r0 = this.end - (this.byteWidth * 3);
            return new KeyVector(new TypedVector(this.bb, FlexBuffers.access$200(this.bb, r0, this.byteWidth), FlexBuffers.access$100(this.bb, r0 + this.byteWidth, this.byteWidth), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r6) {
            r6.append("{ ");
            KeyVector r0 = keys();
            int r1 = size();
            Vector r5 = values();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            r6.append(Typography.quote).append(r0.get(r2).toString()).append("\" : ");
            r6.append(r5.get(r2).toString());
            if (r2 == (r1 - 1)) goto L7;
            r6.append(", ");
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            r6.append(" }");
            return r6;
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }
    }

    private static abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        Object(ReadBuf r3, int r4, int r5) {
            this.bb = (ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin");
            this.end = r4;
            this.byteWidth = r5;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder r1);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = null;
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        static {
            NULL_REFERENCE = new Reference(FlexBuffers.access$000(), 0, 1, 0);
        }

        Reference(ReadBuf r7, int r8, int r9, int r10) {
            this((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r7, ReadBuf.class, "com.obric.memorydata.plugin"), r8, r9, 1 << (r10 & 3), r10 >> 2);
        }

        Reference(ReadBuf r3, int r4, int r5, int r6, int r7) {
            this.bb = (ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin");
            this.end = r4;
            this.parentWidth = r5;
            this.byteWidth = r6;
            this.type = r7;
        }

        static /* synthetic */ Reference access$600() {
            return NULL_REFERENCE;
        }

        public Blob asBlob() {
            if (isBlob() == false) goto L5;
        L9:
            ReadBuf r1 = this.bb;
            return new Blob(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L5:
            if (isString() == true) goto L9;
            return Blob.empty();
        }

        public boolean asBoolean() {
            if (isBoolean() == false) goto L10;
            if (this.bb.get(this.end) == 0) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (asUInt() == 0) goto L13;
            return true;
        L13:
            return false;
        }

        public double asFloat() {
            int r0 = this.type;
            if (r0 != 3) goto L7;
            return FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
        L7:
            if (r0 == 1) goto L37;
            if (r0 == 2) goto L35;
            if (r0 == 5) goto L33;
            if (r0 != 6) goto L15;
            ReadBuf r1 = this.bb;
            return FlexBuffers.access$100(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r0 != 7) goto L17;
            ReadBuf r2 = this.bb;
            return FlexBuffers.access$300(r2, FlexBuffers.access$200(r2, this.end, this.parentWidth), this.byteWidth);
        L17:
            if (r0 != 8) goto L19;
            ReadBuf r3 = this.bb;
            return FlexBuffers.access$400(r3, FlexBuffers.access$200(r3, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r0 == 10) goto L25;
            if (r0 == 26) goto L35;
            return 0.0d;
        L25:
            return asVector().size();
        L33:
            return Double.parseDouble(asString());
        L35:
            return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
        L37:
            return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int r0 = this.type;
            if (r0 != 1) goto L7;
            return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
        L7:
            if (r0 == 2) goto L39;
            if (r0 == 3) goto L37;
            if (r0 == 5) goto L35;
            if (r0 != 6) goto L15;
            ReadBuf r1 = this.bb;
            return FlexBuffers.access$100(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r0 != 7) goto L17;
            ReadBuf r2 = this.bb;
            return (int) FlexBuffers.access$300(r2, FlexBuffers.access$200(r2, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r0 != 8) goto L19;
            ReadBuf r3 = this.bb;
            return (int) FlexBuffers.access$400(r3, FlexBuffers.access$200(r3, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r0 == 10) goto L27;
            if (r0 == 26) goto L25;
            return 0;
        L25:
            return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
        L27:
            return asVector().size();
        L35:
            return Integer.parseInt(asString());
        L37:
            return (int) FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
        L39:
            return (int) FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (isKey() == false) goto L7;
            ReadBuf r1 = this.bb;
            return new Key(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Key.empty();
        }

        public long asLong() {
            int r0 = this.type;
            if (r0 != 1) goto L7;
            return FlexBuffers.access$500(this.bb, this.end, this.parentWidth);
        L7:
            if (r0 == 2) goto L39;
            if (r0 == 3) goto L37;
            if (r0 != 5) goto L13;
            return Long.parseLong(asString());
        L35:
            return 0;
        L13:
            if (r0 != 6) goto L15;
            ReadBuf r1 = this.bb;
            return FlexBuffers.access$500(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r0 != 7) goto L17;
            ReadBuf r2 = this.bb;
            return FlexBuffers.access$300(r2, FlexBuffers.access$200(r2, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r0 != 8) goto L19;
            ReadBuf r3 = this.bb;
            return (long) FlexBuffers.access$400(r3, FlexBuffers.access$200(r3, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r0 == 10) goto L26;
            if (r0 == 26) goto L24;
            return 0;
        L24:
            return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
        L26:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (isMap() == false) goto L7;
            ReadBuf r1 = this.bb;
            return new Map(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Map.empty();
        }

        public String asString() {
            if (isString() == false) goto L8;
            int r0 = FlexBuffers.access$200(this.bb, this.end, this.parentWidth);
            ReadBuf r1 = this.bb;
            int r2 = this.byteWidth;
            int r3 = (int) FlexBuffers.access$300(r1, r0 - r2, r2);
            ReadBuf r4 = this.bb;
        L6:
            return r4.getString(r0, r3);
        L8:
            if (isKey() == false) goto L14;
            r0 = FlexBuffers.access$200(this.bb, this.end, this.byteWidth);
            int r5 = r0;
        L11:
            if (this.bb.get(r5) == 0) goto L12;
            r5 = r5 + 1;
            goto L11
        L12:
            r4 = this.bb;
            r3 = r5 - r0;
            goto L6
        L14:
            return "";
        }

        public long asUInt() {
            int r0 = this.type;
            if (r0 != 2) goto L7;
            return FlexBuffers.access$300(this.bb, this.end, this.parentWidth);
        L7:
            if (r0 == 1) goto L39;
            if (r0 == 3) goto L37;
            if (r0 == 10) goto L35;
            if (r0 == 26) goto L33;
            if (r0 == 5) goto L31;
            if (r0 != 6) goto L19;
            ReadBuf r1 = this.bb;
            return FlexBuffers.access$500(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r0 != 7) goto L21;
            ReadBuf r2 = this.bb;
            return FlexBuffers.access$300(r2, FlexBuffers.access$200(r2, this.end, this.parentWidth), this.byteWidth);
        L21:
            if (r0 == 8) goto L24;
            return 0;
        L24:
            ReadBuf r3 = this.bb;
            return (long) FlexBuffers.access$400(r3, FlexBuffers.access$200(r3, this.end, this.parentWidth), this.parentWidth);
        L31:
            return Long.parseLong(asString());
        L33:
            return FlexBuffers.access$100(this.bb, this.end, this.parentWidth);
        L35:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$500(this.bb, this.end, this.parentWidth);
        }

        public Vector asVector() {
            if (isVector() == false) goto L6;
            ReadBuf r1 = this.bb;
            return new Vector(r1, FlexBuffers.access$200(r1, this.end, this.parentWidth), this.byteWidth);
        L6:
            int r0 = this.type;
            if (r0 != 15) goto L11;
            ReadBuf r2 = this.bb;
            return new TypedVector(r2, FlexBuffers.access$200(r2, this.end, this.parentWidth), this.byteWidth, 4);
        L11:
            if (FlexBuffers.isTypedVector(r0) == false) goto L15;
            ReadBuf r3 = this.bb;
            return new TypedVector(r3, FlexBuffers.access$200(r3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
        L15:
            return Vector.empty();
        }

        public int getType() {
            return this.type;
        }

        public boolean isBlob() {
            if (this.type != 25) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isBoolean() {
            if (this.type != 26) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isFloat() {
            int r1 = this.type;
            if (r1 != 3) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 8) goto L8;
            return false;
        }

        public boolean isInt() {
            int r2 = this.type;
            if (r2 != 1) goto L5;
            return true;
        L5:
            if (r2 == 6) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean isIntOrUInt() {
            if (isInt() == false) goto L5;
        L8:
            return true;
        L5:
            if (isUInt() == true) goto L8;
            return false;
        }

        public boolean isKey() {
            if (this.type != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isMap() {
            if (this.type != 9) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isNull() {
            if (this.type != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isNumeric() {
            if (isIntOrUInt() == false) goto L5;
        L8:
            return true;
        L5:
            if (isFloat() == true) goto L8;
            return false;
        }

        public boolean isString() {
            if (this.type != 5) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isUInt() {
            int r1 = this.type;
            if (r1 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 7) goto L8;
            return false;
        }

        public boolean isVector() {
            int r1 = this.type;
            if (r1 != 10) goto L5;
        L8:
            return true;
        L5:
            if (r1 == 9) goto L8;
            return false;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        StringBuilder toString(StringBuilder r3) {
            int r0 = this.type;
            if (r0 == 36) goto L30;
            switch(r0) {
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L18;
                case 6: goto L26;
                case 7: goto L24;
                case 8: goto L22;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L30;
                case 12: goto L30;
                case 13: goto L30;
                case 14: goto L30;
                case 15: goto L30;
                case 16: goto L12;
                case 17: goto L12;
                case 18: goto L12;
                case 19: goto L12;
                case 20: goto L12;
                case 21: goto L12;
                case 22: goto L12;
                case 23: goto L12;
                case 24: goto L12;
                case 25: goto L10;
                case 26: goto L8;
                default: goto L6;
            };
        L6:
            return r3;
        L8:
            return r3.append(asBoolean());
        L10:
            return asBlob().toString(r3);
        L12:
            throw new FlexBufferException("not_implemented:" + this.type);
        L14:
            return asVector().toString(r3);
        L16:
            return asMap().toString(r3);
        L18:
            return r3.append(Typography.quote).append(asString()).append(Typography.quote);
        L20:
            return asKey().toString(r3.append(Typography.quote)).append(Typography.quote);
        L22:
            return r3.append(asFloat());
        L24:
            return r3.append(asUInt());
        L26:
            return r3.append(asLong());
        L28:
            return r3.append("null");
        L30:
            return r3.append(asVector());
        }
    }

    private static abstract class Sized extends Object {
        protected final int size;

        Sized(ReadBuf r3, int r4, int r5) {
            super((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin"), r4, r5);
            this.size = FlexBuffers.access$100(this.bb, r4 - r5, r5);
        }

        public int size() {
            return this.size;
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = null;
        private final int elemType;

        static {
            EMPTY_VECTOR = new TypedVector(FlexBuffers.access$000(), 1, 1, 1);
        }

        TypedVector(ReadBuf r3, int r4, int r5, int r6) {
            super((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin"), r4, r5);
            this.elemType = r6;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int r8) {
            if (r8 >= size()) goto L5;
            int r3 = this.end + (r8 * this.byteWidth);
            return new Reference(this.bb, r3, this.byteWidth, 1, this.elemType);
        L5:
            return Reference.access$600();
        }

        public int getElemType() {
            return this.elemType;
        }

        public boolean isEmptyVector() {
            if (this != EMPTY_VECTOR) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static class Unsigned {
        Unsigned() {
        }

        static int byteToUnsignedInt(byte r0) {
            return r0 & 255;
        }

        static long intToUnsignedLong(int r4) {
            return ((long) r4) & 4294967295L;
        }

        static int shortToUnsignedInt(short r1) {
            return r1 & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = null;

        static {
            EMPTY_VECTOR = new Vector(FlexBuffers.access$000(), 1, 1);
        }

        Vector(ReadBuf r3, int r4, int r5) {
            super((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r3, ReadBuf.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int r10) {
            long r0 = size();
            long r2 = r10;
            if (r2 >= r0) goto L5;
            int r1 = Unsigned.byteToUnsignedInt(this.bb.get((int) ((((long) this.end) + (r0 * ((long) this.byteWidth))) + r2)));
            return new Reference(this.bb, this.end + (r10 * this.byteWidth), this.byteWidth, r1);
        L5:
            return Reference.access$600();
        }

        public boolean isEmpty() {
            if (this != EMPTY_VECTOR) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r4) {
            r4.append("[ ");
            int r0 = size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            get(r1).toString(r4);
            if (r1 == (r0 - 1)) goto L7;
            r4.append(", ");
        L7:
            r1 = r1 + 1;
            goto L3
        L8:
            r4.append(" ]");
            return r4;
        }
    }

    static {
        EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    }

    public FlexBuffers() {
    }

    static /* synthetic */ ReadBuf access$000() {
        return EMPTY_BB;
    }

    static /* synthetic */ int access$100(ReadBuf r2, int r3, int r4) {
        return readInt((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ int access$200(ReadBuf r2, int r3, int r4) {
        return indirect((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ long access$300(ReadBuf r2, int r3, int r4) {
        return readUInt((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ double access$400(ReadBuf r2, int r3, int r4) {
        return readDouble((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    static /* synthetic */ long access$500(ReadBuf r2, int r3, int r4) {
        return readLong((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static Reference getRoot(ReadBuf r4) {
        ReadBuf r5 = (ReadBuf) ZeusTransformUtils.wrapperContextForParams(r4, ReadBuf.class, "com.obric.memorydata.plugin");
        int r0 = r5.limit() - 1;
        byte r1 = r5.get(r0);
        int r2 = r0 - 1;
        return new Reference(r5, r2 - r1, r1, Unsigned.byteToUnsignedInt(r5.get(r2)));
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer r2) {
        if (r2.hasArray() == false) goto L5;
        ReadBuf r0 = new ArrayReadWriteBuf(r2.array(), r2.limit());
    L7:
        return getRoot(r0);
    L5:
        r0 = new ByteBufferReadWriteBuf(r2);
        goto L7
    }

    private static int indirect(ReadBuf r2, int r3, int r4) {
        return (int) (((long) r3) - readUInt((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4));
    }

    static boolean isTypeInline(int r1) {
        if (r1 > 3) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 26) goto L8;
        return false;
    }

    static boolean isTypedVector(int r1) {
        if (r1 < 11) goto L7;
        if (r1 > 15) goto L7;
    L8:
        return true;
    L7:
        if (r1 == 36) goto L8;
        return false;
    }

    static boolean isTypedVectorElementType(int r2) {
        if (r2 < 1) goto L7;
        if (r2 > 4) goto L7;
        return true;
    L7:
        if (r2 == 26) goto L12;
        return false;
    L12:
        return true;
    }

    private static double readDouble(ReadBuf r2, int r3, int r4) {
        ReadBuf r5 = (ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin");
        if (r4 == 4) goto L11;
        if (r4 == 8) goto L9;
        return -1.0d;
    L9:
        return r5.getDouble(r3);
    L11:
        return r5.getFloat(r3);
    }

    private static int readInt(ReadBuf r2, int r3, int r4) {
        return (int) readLong((ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    private static long readLong(ReadBuf r2, int r3, int r4) {
        ReadBuf r5 = (ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin");
        if (r4 != 1) goto L5;
        int r6 = r5.get(r3);
    L16:
        return r6;
    L5:
        if (r4 != 2) goto L7;
        r6 = r5.getShort(r3);
        goto L16
    L7:
        if (r4 != 4) goto L9;
        r6 = r5.getInt(r3);
        goto L16
    L9:
        if (r4 == 8) goto L13;
        return -1;
    L13:
        return r5.getLong(r3);
    }

    private static long readUInt(ReadBuf r2, int r3, int r4) {
        ReadBuf r5 = (ReadBuf) ZeusTransformUtils.wrapperContextForParams(r2, ReadBuf.class, "com.obric.memorydata.plugin");
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L17;
        if (r4 == 4) goto L15;
        if (r4 == 8) goto L13;
        return -1;
    L13:
        return r5.getLong(r3);
    L15:
        return Unsigned.intToUnsignedLong(r5.getInt(r3));
    L17:
        return Unsigned.shortToUnsignedInt(r5.getShort(r3));
    L19:
        return Unsigned.byteToUnsignedInt(r5.get(r3));
    }

    static int toTypedVector(int r1, int r2) {
        if (r2 == 0) goto L18;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L14;
        if (r2 == 4) goto L12;
        return 0;
    L12:
        return (r1 - 1) + 22;
    L14:
        return (r1 - 1) + 19;
    L16:
        return (r1 - 1) + 16;
    L18:
        return (r1 - 1) + 11;
    }

    static int toTypedVectorElementType(int r0) {
        return (r0 - 11) + 1;
    }
}
