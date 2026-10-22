package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import kotlin.UByte;
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

        public Blob(ReadBuf r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer r5 = ByteBuffer.wrap(this.f516bb.data());
            r5.position(this.end);
            int r10 = this.end;
            r5.limit(size() + r10);
            return r5.asReadOnlyBuffer().slice();
        }

        public byte get(int r5) {
            return this.f516bb.get(this.end + r5);
        }

        public byte[] getBytes() {
            int r5 = size();
            byte[] r10 = new byte[r5];
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            r10[r11] = this.f516bb.get(this.end + r11);
            r11 = r11 + 1;
            goto L3
        L5:
            return r10;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f516bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r5) {
            r5.append(Typography.quote);
            r5.append(this.f516bb.getString(this.end, size()));
            r5.append(Typography.quote);
            return r5;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        public FlexBufferException(String r5) {
            super(r5);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = null;

        static {
            EMPTY = new Key(FlexBuffers.access$000(), 0, 0);
        }

        public Key(ReadBuf r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        public static /* synthetic */ Key access$700() {
            return EMPTY;
        }

        public static Key empty() {
            return EMPTY;
        }

        public int compareTo(byte[] r10) {
            int r5 = this.end;
            int r11 = 0;
        L3:
            byte r12 = this.f516bb.get(r5);
            byte r13 = r10[r11];
            if (r12 == 0) goto L6;
            r5 = r5 + 1;
            r11 = r11 + 1;
            if (r11 == r10.length) goto L10;
            if (r12 == r13) goto L3;
            return r12 - r13;
        L10:
            return r12 - r13;
        L6:
            return r12 - r13;
        }

        public boolean equals(java.lang.Object r5) {
            if ((r5 instanceof Key) == true) goto L5;
            return false;
        L5:
            Key r10 = (Key) r5;
            if (r10.end == this.end) goto L8;
            return false;
        L8:
            if (r10.byteWidth != this.byteWidth) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r5 = this.end;
            return this.byteWidth ^ r5;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r5) {
            r5.append(toString());
            return r5;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int r5 = this.end;
        L4:
            if (this.f516bb.get(r5) == 0) goto L5;
            r5 = r5 + 1;
            goto L4
        L5:
            int r10 = this.end;
            ReadBuf r11 = this.f516bb;
            return r11.getString(r10, r5 - r10);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        public KeyVector(TypedVector r5) {
            this.vec = r5;
        }

        public Key get(int r5) {
            if (r5 >= size()) goto L5;
            TypedVector r10 = this.vec;
            int r11 = r10.end;
            int r12 = (r5 * r10.byteWidth) + r11;
            TypedVector r13 = this.vec;
            ReadBuf r14 = r13.f516bb;
            return new Key(r14, FlexBuffers.access$200(r14, r12, r13.byteWidth), 1);
        L5:
            return Key.access$700();
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder();
            r5.append('[');
            int r10 = 0;
        L4:
            if (r10 >= this.vec.size()) goto L9;
            this.vec.get(r10).toString(r5);
            if (r10 == (this.vec.size() - 1)) goto L8;
            r5.append(", ");
        L8:
            r10 = r10 + 1;
            goto L4
        L9:
            r5.append("]");
            return r5.toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = null;

        static {
            EMPTY_MAP = new Map(FlexBuffers.access$000(), 1, 1);
        }

        public Map(ReadBuf r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        private int binarySearch(KeyVector r5, byte[] r10) {
            int r11 = r5.size() - 1;
            int r12 = 0;
        L3:
            if (r12 > r11) goto L11;
            int r13 = (r12 + r11) >>> 1;
            int r14 = r5.get(r13).compareTo(r10);
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

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String r5) {
            return get(r5.getBytes(StandardCharsets.UTF_8));
        }

        public KeyVector keys() {
            int r5 = this.end - (this.byteWidth * 3);
            ReadBuf r10 = this.f516bb;
            int r11 = FlexBuffers.access$200(r10, r5, this.byteWidth);
            ReadBuf r12 = this.f516bb;
            int r13 = this.byteWidth;
            return new KeyVector(new TypedVector(r10, r11, FlexBuffers.access$100(r12, r5 + r13, r13), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r5) {
            r5.append("{ ");
            KeyVector r10 = keys();
            int r11 = size();
            Vector r12 = values();
            int r13 = 0;
        L3:
            if (r13 >= r11) goto L8;
            r5.append(Typography.quote);
            r5.append(r10.get(r13).toString());
            r5.append("\" : ");
            r5.append(r12.get(r13).toString());
            if (r13 == (r11 - 1)) goto L7;
            r5.append(", ");
        L7:
            r13 = r13 + 1;
            goto L3
        L8:
            r5.append(" }");
            return r5;
        }

        public Vector values() {
            return new Vector(this.f516bb, this.end, this.byteWidth);
        }

        public Reference get(byte[] r5) {
            KeyVector r10 = keys();
            int r11 = r10.size();
            int r12 = binarySearch(r10, r5);
            if (r12 < 0) goto L8;
            if (r12 >= r11) goto L8;
            return get(r12);
        L8:
            return Reference.access$600();
        }
    }

    public static abstract class Object {

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        ReadBuf f516bb;
        int byteWidth;
        int end;

        public Object(ReadBuf r5, int r10, int r11) {
            this.f516bb = r5;
            this.end = r10;
            this.byteWidth = r11;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder r5);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = null;

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        private ReadBuf f517bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        static {
            NULL_REFERENCE = new Reference(FlexBuffers.access$000(), 0, 1, 0);
        }

        public Reference(ReadBuf r10, int r11, int r12, int r13) {
            this(r10, r11, r12, 1 << (r13 & 3), r13 >> 2);
        }

        public static /* synthetic */ Reference access$600() {
            return NULL_REFERENCE;
        }

        public Blob asBlob() {
            if (isBlob() == false) goto L5;
        L9:
            ReadBuf r5 = this.f517bb;
            return new Blob(r5, FlexBuffers.access$200(r5, this.end, this.parentWidth), this.byteWidth);
        L5:
            if (isString() == true) goto L9;
            return Blob.empty();
        }

        public boolean asBoolean() {
            if (isBoolean() == false) goto L9;
            if (this.f517bb.get(this.end) != 0) goto L7;
            return false;
        L7:
            return true;
        L9:
            if (asUInt() != 0) goto L11;
            return false;
        L11:
            return true;
        }

        public double asFloat() {
            int r5 = this.type;
            if (r5 != 3) goto L7;
            return FlexBuffers.access$400(this.f517bb, this.end, this.parentWidth);
        L7:
            if (r5 == 1) goto L37;
            if (r5 == 2) goto L35;
            if (r5 == 5) goto L33;
            if (r5 != 6) goto L15;
            ReadBuf r10 = this.f517bb;
            return FlexBuffers.access$100(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r5 != 7) goto L17;
            ReadBuf r11 = this.f517bb;
            return FlexBuffers.access$300(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth);
        L17:
            if (r5 != 8) goto L19;
            ReadBuf r12 = this.f517bb;
            return FlexBuffers.access$400(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r5 == 10) goto L25;
            if (r5 == 26) goto L35;
            return 0.0d;
        L25:
            return asVector().size();
        L33:
            return Double.parseDouble(asString());
        L35:
            return FlexBuffers.access$300(this.f517bb, this.end, this.parentWidth);
        L37:
            return FlexBuffers.access$100(this.f517bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int r5 = this.type;
            if (r5 != 1) goto L7;
            return FlexBuffers.access$100(this.f517bb, this.end, this.parentWidth);
        L7:
            if (r5 == 2) goto L39;
            if (r5 == 3) goto L37;
            if (r5 == 5) goto L35;
            if (r5 != 6) goto L15;
            ReadBuf r10 = this.f517bb;
            return FlexBuffers.access$100(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r5 != 7) goto L17;
            ReadBuf r11 = this.f517bb;
            return (int) FlexBuffers.access$300(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r5 != 8) goto L19;
            ReadBuf r12 = this.f517bb;
            return (int) FlexBuffers.access$400(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r5 == 10) goto L27;
            if (r5 == 26) goto L25;
            return 0;
        L25:
            return FlexBuffers.access$100(this.f517bb, this.end, this.parentWidth);
        L27:
            return asVector().size();
        L35:
            return Integer.parseInt(asString());
        L37:
            return (int) FlexBuffers.access$400(this.f517bb, this.end, this.parentWidth);
        L39:
            return (int) FlexBuffers.access$300(this.f517bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (isKey() == false) goto L7;
            ReadBuf r5 = this.f517bb;
            return new Key(r5, FlexBuffers.access$200(r5, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Key.empty();
        }

        public long asLong() {
            int r5 = this.type;
            if (r5 != 1) goto L7;
            return FlexBuffers.access$500(this.f517bb, this.end, this.parentWidth);
        L7:
            if (r5 == 2) goto L39;
            if (r5 == 3) goto L37;
            if (r5 != 5) goto L13;
            return Long.parseLong(asString());
        L35:
            return 0;
        L13:
            if (r5 != 6) goto L15;
            ReadBuf r10 = this.f517bb;
            return FlexBuffers.access$500(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r5 != 7) goto L17;
            ReadBuf r11 = this.f517bb;
            return FlexBuffers.access$300(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r5 != 8) goto L19;
            ReadBuf r12 = this.f517bb;
            return (long) FlexBuffers.access$400(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r5 == 10) goto L26;
            if (r5 == 26) goto L24;
            return 0;
        L24:
            return FlexBuffers.access$100(this.f517bb, this.end, this.parentWidth);
        L26:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.f517bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$300(this.f517bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (isMap() == false) goto L7;
            ReadBuf r5 = this.f517bb;
            return new Map(r5, FlexBuffers.access$200(r5, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Map.empty();
        }

        public String asString() {
            if (isString() == false) goto L7;
            int r5 = FlexBuffers.access$200(this.f517bb, this.end, this.parentWidth);
            ReadBuf r10 = this.f517bb;
            int r11 = this.byteWidth;
            int r12 = (int) FlexBuffers.access$300(r10, r5 - r11, r11);
            return this.f517bb.getString(r5, r12);
        L7:
            if (isKey() == false) goto L14;
            int r13 = FlexBuffers.access$200(this.f517bb, this.end, this.byteWidth);
            int r14 = r13;
        L10:
            if (this.f517bb.get(r14) == 0) goto L12;
            r14 = r14 + 1;
            goto L10
        L12:
            return this.f517bb.getString(r13, r14 - r13);
        L14:
            return "";
        }

        public long asUInt() {
            int r5 = this.type;
            if (r5 != 2) goto L7;
            return FlexBuffers.access$300(this.f517bb, this.end, this.parentWidth);
        L7:
            if (r5 == 1) goto L39;
            if (r5 == 3) goto L37;
            if (r5 == 10) goto L35;
            if (r5 == 26) goto L33;
            if (r5 == 5) goto L31;
            if (r5 != 6) goto L19;
            ReadBuf r10 = this.f517bb;
            return FlexBuffers.access$500(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r5 != 7) goto L21;
            ReadBuf r11 = this.f517bb;
            return FlexBuffers.access$300(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth);
        L21:
            if (r5 == 8) goto L24;
            return 0;
        L24:
            ReadBuf r12 = this.f517bb;
            return (long) FlexBuffers.access$400(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.parentWidth);
        L31:
            return Long.parseLong(asString());
        L33:
            return FlexBuffers.access$100(this.f517bb, this.end, this.parentWidth);
        L35:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.f517bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$500(this.f517bb, this.end, this.parentWidth);
        }

        public Vector asVector() {
            if (isVector() == false) goto L6;
            ReadBuf r5 = this.f517bb;
            return new Vector(r5, FlexBuffers.access$200(r5, this.end, this.parentWidth), this.byteWidth);
        L6:
            int r10 = this.type;
            if (r10 != 15) goto L11;
            ReadBuf r11 = this.f517bb;
            return new TypedVector(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth, 4);
        L11:
            if (FlexBuffers.isTypedVector(r10) == false) goto L15;
            ReadBuf r12 = this.f517bb;
            return new TypedVector(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
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
            int r5 = this.type;
            if (r5 != 3) goto L5;
        L8:
            return true;
        L5:
            if (r5 == 8) goto L8;
            return false;
        }

        public boolean isInt() {
            int r5 = this.type;
            if (r5 != 1) goto L5;
            return true;
        L5:
            if (r5 == 6) goto L10;
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
            int r5 = this.type;
            if (r5 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r5 == 7) goto L8;
            return false;
        }

        public boolean isVector() {
            int r5 = this.type;
            if (r5 != 10) goto L5;
        L8:
            return true;
        L5:
            if (r5 == 9) goto L8;
            return false;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public Reference(ReadBuf r5, int r10, int r11, int r12, int r13) {
            this.f517bb = r5;
            this.end = r10;
            this.parentWidth = r11;
            this.byteWidth = r12;
            this.type = r13;
        }

        public StringBuilder toString(StringBuilder r5) {
            int r10 = this.type;
            if (r10 != 36) goto L5;
        L29:
            r5.append(asVector());
            return r5;
        L5:
            switch(r10) {
                case 0: goto L27;
                case 1: goto L25;
                case 2: goto L23;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L25;
                case 7: goto L23;
                case 8: goto L21;
                case 9: goto L16;
                case 10: goto L14;
                case 11: goto L29;
                case 12: goto L29;
                case 13: goto L29;
                case 14: goto L29;
                case 15: goto L29;
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
                case 26: goto L7;
                default: goto L6;
            };
        L6:
            return r5;
        L7:
            r5.append(asBoolean());
            return r5;
        L17:
            r5.append(Typography.quote);
            r5.append(asString());
            r5.append(Typography.quote);
            return r5;
        L19:
            Key r11 = asKey();
            r5.append(Typography.quote);
            StringBuilder r12 = r11.toString(r5);
            r12.append(Typography.quote);
            return r12;
        L21:
            r5.append(asFloat());
            return r5;
        L23:
            r5.append(asUInt());
            return r5;
        L25:
            r5.append(asLong());
            return r5;
        L27:
            r5.append("null");
            return r5;
        L10:
            return asBlob().toString(r5);
        L12:
            throw new FlexBufferException("not_implemented:" + this.type);
        L14:
            return asVector().toString(r5);
        L16:
            return asMap().toString(r5);
        }
    }

    public static abstract class Sized extends Object {
        protected final int size;

        public Sized(ReadBuf r5, int r10, int r11) {
            super(r5, r10, r11);
            this.size = FlexBuffers.access$100(this.f516bb, r10 - r11, r11);
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

        public TypedVector(ReadBuf r5, int r10, int r11, int r12) {
            super(r5, r10, r11);
            this.elemType = r12;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int r10) {
            if (r10 >= size()) goto L5;
            int r5 = this.end;
            int r11 = (r10 * this.byteWidth) + r5;
            return new Reference(this.f516bb, r11, this.byteWidth, 1, this.elemType);
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

    public static class Unsigned {
        public Unsigned() {
        }

        public static int byteToUnsignedInt(byte r5) {
            return r5 & UByte.MAX_VALUE;
        }

        public static long intToUnsignedLong(int r5) {
            return ((long) r5) & 4294967295L;
        }

        public static int shortToUnsignedInt(short r5) {
            return r5 & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = null;

        static {
            EMPTY_VECTOR = new Vector(FlexBuffers.access$000(), 1, 1);
        }

        public Vector(ReadBuf r5, int r10, int r11) {
            super(r5, r10, r11);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int r10) {
            long r5 = size();
            long r11 = r10;
            if (r11 >= r5) goto L5;
            int r12 = Unsigned.byteToUnsignedInt(this.f516bb.get((int) (((r5 * ((long) this.byteWidth)) + this.end) + r11)));
            return new Reference(this.f516bb, (r10 * this.byteWidth) + this.end, this.byteWidth, r12);
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
        public StringBuilder toString(StringBuilder r5) {
            r5.append("[ ");
            int r10 = size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            get(r11).toString(r5);
            if (r11 == (r10 - 1)) goto L7;
            r5.append(", ");
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            r5.append(" ]");
            return r5;
        }
    }

    static {
        EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    }

    public FlexBuffers() {
    }

    public static /* synthetic */ ReadBuf access$000() {
        return EMPTY_BB;
    }

    public static /* synthetic */ int access$100(ReadBuf r5, int r10, int r11) {
        return readInt(r5, r10, r11);
    }

    public static /* synthetic */ int access$200(ReadBuf r5, int r10, int r11) {
        return indirect(r5, r10, r11);
    }

    public static /* synthetic */ long access$300(ReadBuf r5, int r10, int r11) {
        return readUInt(r5, r10, r11);
    }

    public static /* synthetic */ double access$400(ReadBuf r5, int r10, int r11) {
        return readDouble(r5, r10, r11);
    }

    public static /* synthetic */ long access$500(ReadBuf r5, int r10, int r11) {
        return readLong(r5, r10, r11);
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer r5) {
        if (r5.hasArray() == false) goto L5;
        ReadBuf r10 = new ArrayReadWriteBuf(r5.array(), r5.limit());
    L7:
        return getRoot(r10);
    L5:
        r10 = new ByteBufferReadWriteBuf(r5);
        goto L7
    }

    private static int indirect(ReadBuf r5, int r10, int r11) {
        return (int) (((long) r10) - readUInt(r5, r10, r11));
    }

    public static boolean isTypeInline(int r5) {
        if (r5 > 3) goto L5;
    L8:
        return true;
    L5:
        if (r5 == 26) goto L8;
        return false;
    }

    public static boolean isTypedVector(int r5) {
        if (r5 < 11) goto L7;
        if (r5 > 15) goto L7;
    L8:
        return true;
    L7:
        if (r5 == 36) goto L8;
        return false;
    }

    public static boolean isTypedVectorElementType(int r5) {
        if (r5 < 1) goto L7;
        if (r5 > 4) goto L7;
        return true;
    L7:
        if (r5 == 26) goto L12;
        return false;
    L12:
        return true;
    }

    private static double readDouble(ReadBuf r5, int r10, int r11) {
        if (r11 == 4) goto L11;
        if (r11 == 8) goto L9;
        return -1.0d;
    L9:
        return r5.getDouble(r10);
    L11:
        return r5.getFloat(r10);
    }

    private static int readInt(ReadBuf r5, int r10, int r11) {
        return (int) readLong(r5, r10, r11);
    }

    private static long readLong(ReadBuf r5, int r10, int r11) {
        if (r11 != 1) goto L5;
        int r12 = r5.get(r10);
    L16:
        return r12;
    L5:
        if (r11 != 2) goto L7;
        r12 = r5.getShort(r10);
        goto L16
    L7:
        if (r11 != 4) goto L9;
        r12 = r5.getInt(r10);
        goto L16
    L9:
        if (r11 == 8) goto L13;
        return -1;
    L13:
        return r5.getLong(r10);
    }

    private static long readUInt(ReadBuf r5, int r10, int r11) {
        if (r11 == 1) goto L19;
        if (r11 == 2) goto L17;
        if (r11 == 4) goto L15;
        if (r11 == 8) goto L13;
        return -1;
    L13:
        return r5.getLong(r10);
    L15:
        return Unsigned.intToUnsignedLong(r5.getInt(r10));
    L17:
        return Unsigned.shortToUnsignedInt(r5.getShort(r10));
    L19:
        return Unsigned.byteToUnsignedInt(r5.get(r10));
    }

    public static int toTypedVector(int r5, int r10) {
        if (r10 == 0) goto L18;
        if (r10 == 2) goto L16;
        if (r10 == 3) goto L14;
        if (r10 == 4) goto L12;
        return 0;
    L12:
        return r5 + 21;
    L14:
        return r5 + 18;
    L16:
        return r5 + 15;
    L18:
        return r5 + 10;
    }

    public static int toTypedVectorElementType(int r5) {
        return r5 - 10;
    }

    public static Reference getRoot(ReadBuf r5) {
        int r10 = r5.limit();
        byte r11 = r5.get(r10 - 1);
        int r12 = r10 - 2;
        return new Reference(r5, r12 - r11, r11, Unsigned.byteToUnsignedInt(r5.get(r12)));
    }
}
