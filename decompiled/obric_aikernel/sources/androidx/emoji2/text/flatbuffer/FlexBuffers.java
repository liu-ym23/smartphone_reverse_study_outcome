package androidx.emoji2.text.flatbuffer;

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

        Blob(ReadBuf r10, int r11, int r12) {
            super(r10, r11, r12);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer r10 = ByteBuffer.wrap(this.f376bb.data());
            r10.position(this.end);
            r10.limit(this.end + size());
            return r10.asReadOnlyBuffer().slice();
        }

        public byte get(int r10) {
            return this.f376bb.get(this.end + r10);
        }

        public byte[] getBytes() {
            int r10 = size();
            byte[] r11 = new byte[r10];
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            r11[r12] = this.f376bb.get(this.end + r12);
            r12 = r12 + 1;
            goto L3
        L5:
            return r11;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Sized
        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            return this.f376bb.getString(this.end, size());
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r10) {
            r10.append(Typography.quote);
            r10.append(this.f376bb.getString(this.end, size()));
            r10.append(Typography.quote);
            return r10;
        }
    }

    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String r10) {
            super(r10);
        }
    }

    public static class Key extends Object {
        private static final Key EMPTY = null;

        static {
            EMPTY = new Key(FlexBuffers.access$000(), 0, 0);
        }

        Key(ReadBuf r10, int r11, int r12) {
            super(r10, r11, r12);
        }

        static /* synthetic */ Key access$700() {
            return EMPTY;
        }

        public static Key empty() {
            return EMPTY;
        }

        int compareTo(byte[] r10) {
            int r11 = this.end;
            int r12 = 0;
        L3:
            byte r13 = this.f376bb.get(r11);
            byte r14 = r10[r12];
            if (r13 == 0) goto L6;
            r11 = r11 + 1;
            r12 = r12 + 1;
            if (r12 == r10.length) goto L10;
            if (r13 == r14) goto L3;
            return r13 - r14;
        L10:
            return r13 - r14;
        L6:
            return r13 - r14;
        }

        public boolean equals(java.lang.Object r10) {
            if ((r10 instanceof Key) == true) goto L5;
            return false;
        L5:
            Key r11 = (Key) r10;
            if (r11.end == this.end) goto L8;
            return false;
        L8:
            if (r11.byteWidth != this.byteWidth) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            int r10 = this.end;
            return this.byteWidth ^ r10;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public String toString() {
            int r10 = this.end;
        L4:
            if (this.f376bb.get(r10) == 0) goto L5;
            r10 = r10 + 1;
            goto L4
        L5:
            int r11 = this.end;
            ReadBuf r12 = this.f376bb;
            return r12.getString(r11, r10 - r11);
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r10) {
            r10.append(toString());
            return r10;
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector r10) {
            this.vec = r10;
        }

        public Key get(int r10) {
            if (r10 >= size()) goto L5;
            TypedVector r11 = this.vec;
            int r12 = r11.end + (r10 * r11.byteWidth);
            TypedVector r13 = this.vec;
            ReadBuf r14 = r13.f376bb;
            return new Key(r14, FlexBuffers.access$200(r14, r12, r13.byteWidth), 1);
        L5:
            return Key.access$700();
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append('[');
            int r11 = 0;
        L4:
            if (r11 >= this.vec.size()) goto L9;
            this.vec.get(r11).toString(r10);
            if (r11 == (this.vec.size() - 1)) goto L8;
            r10.append(", ");
        L8:
            r11 = r11 + 1;
            goto L4
        L9:
            r10.append("]");
            return r10.toString();
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = null;

        static {
            EMPTY_MAP = new Map(FlexBuffers.access$000(), 1, 1);
        }

        Map(ReadBuf r10, int r11, int r12) {
            super(r10, r11, r12);
        }

        private int binarySearch(KeyVector r10, byte[] r11) {
            int r12 = r10.size() - 1;
            int r13 = 0;
        L3:
            if (r13 > r12) goto L11;
            int r14 = (r13 + r12) >>> 1;
            int r15 = r10.get(r14).compareTo(r11);
            if (r15 < 0) goto L6;
            if (r15 <= 0) goto L9;
            r12 = r14 - 1;
            goto L3
        L9:
            return r14;
        L6:
            r13 = r14 + 1;
            goto L3
        L11:
            return -(r13 + 1);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String r10) {
            return get(r10.getBytes(StandardCharsets.UTF_8));
        }

        public Reference get(byte[] r10) {
            KeyVector r11 = keys();
            int r12 = r11.size();
            int r13 = binarySearch(r11, r10);
            if (r13 < 0) goto L8;
            if (r13 >= r12) goto L8;
            return get(r13);
        L8:
            return Reference.access$600();
        }

        public KeyVector keys() {
            int r10 = this.end - (this.byteWidth * 3);
            ReadBuf r11 = this.f376bb;
            int r12 = FlexBuffers.access$200(r11, r10, this.byteWidth);
            ReadBuf r13 = this.f376bb;
            int r14 = this.byteWidth;
            return new KeyVector(new TypedVector(r11, r12, FlexBuffers.access$100(r13, r10 + r14, r14), 4));
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector, androidx.emoji2.text.flatbuffer.FlexBuffers.Object
        public StringBuilder toString(StringBuilder r10) {
            r10.append("{ ");
            KeyVector r11 = keys();
            int r12 = size();
            Vector r13 = values();
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L8;
            r10.append(Typography.quote);
            r10.append(r11.get(r14).toString());
            r10.append("\" : ");
            r10.append(r13.get(r14).toString());
            if (r14 == (r12 - 1)) goto L7;
            r10.append(", ");
        L7:
            r14 = r14 + 1;
            goto L3
        L8:
            r10.append(" }");
            return r10;
        }

        public Vector values() {
            return new Vector(this.f376bb, this.end, this.byteWidth);
        }
    }

    private static abstract class Object {

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        ReadBuf f376bb;
        int byteWidth;
        int end;

        Object(ReadBuf r10, int r11, int r12) {
            this.f376bb = r10;
            this.end = r11;
            this.byteWidth = r12;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        public abstract StringBuilder toString(StringBuilder r10);
    }

    public static class Reference {
        private static final Reference NULL_REFERENCE = null;

        /* JADX INFO: renamed from: bb, reason: collision with root package name */
        private ReadBuf f377bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        static {
            NULL_REFERENCE = new Reference(FlexBuffers.access$000(), 0, 1, 0);
        }

        Reference(ReadBuf r10, int r11, int r12, int r13) {
            this(r10, r11, r12, 1 << (r13 & 3), r13 >> 2);
        }

        Reference(ReadBuf r10, int r11, int r12, int r13, int r14) {
            this.f377bb = r10;
            this.end = r11;
            this.parentWidth = r12;
            this.byteWidth = r13;
            this.type = r14;
        }

        static /* synthetic */ Reference access$600() {
            return NULL_REFERENCE;
        }

        public Blob asBlob() {
            if (isBlob() == false) goto L5;
        L9:
            ReadBuf r10 = this.f377bb;
            return new Blob(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L5:
            if (isString() == true) goto L9;
            return Blob.empty();
        }

        public boolean asBoolean() {
            if (isBoolean() == false) goto L10;
            if (this.f377bb.get(this.end) == 0) goto L8;
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
            int r10 = this.type;
            if (r10 != 3) goto L7;
            return FlexBuffers.access$400(this.f377bb, this.end, this.parentWidth);
        L7:
            if (r10 == 1) goto L37;
            if (r10 == 2) goto L35;
            if (r10 == 5) goto L33;
            if (r10 != 6) goto L15;
            ReadBuf r11 = this.f377bb;
            return FlexBuffers.access$100(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r10 != 7) goto L17;
            ReadBuf r12 = this.f377bb;
            return FlexBuffers.access$300(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth);
        L17:
            if (r10 != 8) goto L19;
            ReadBuf r13 = this.f377bb;
            return FlexBuffers.access$400(r13, FlexBuffers.access$200(r13, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r10 == 10) goto L25;
            if (r10 == 26) goto L35;
            return 0.0d;
        L25:
            return asVector().size();
        L33:
            return Double.parseDouble(asString());
        L35:
            return FlexBuffers.access$300(this.f377bb, this.end, this.parentWidth);
        L37:
            return FlexBuffers.access$100(this.f377bb, this.end, this.parentWidth);
        }

        public int asInt() {
            int r10 = this.type;
            if (r10 != 1) goto L7;
            return FlexBuffers.access$100(this.f377bb, this.end, this.parentWidth);
        L7:
            if (r10 == 2) goto L39;
            if (r10 == 3) goto L37;
            if (r10 == 5) goto L35;
            if (r10 != 6) goto L15;
            ReadBuf r11 = this.f377bb;
            return FlexBuffers.access$100(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r10 != 7) goto L17;
            ReadBuf r12 = this.f377bb;
            return (int) FlexBuffers.access$300(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r10 != 8) goto L19;
            ReadBuf r13 = this.f377bb;
            return (int) FlexBuffers.access$400(r13, FlexBuffers.access$200(r13, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r10 == 10) goto L27;
            if (r10 == 26) goto L25;
            return 0;
        L25:
            return FlexBuffers.access$100(this.f377bb, this.end, this.parentWidth);
        L27:
            return asVector().size();
        L35:
            return Integer.parseInt(asString());
        L37:
            return (int) FlexBuffers.access$400(this.f377bb, this.end, this.parentWidth);
        L39:
            return (int) FlexBuffers.access$300(this.f377bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (isKey() == false) goto L7;
            ReadBuf r10 = this.f377bb;
            return new Key(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Key.empty();
        }

        public long asLong() {
            int r10 = this.type;
            if (r10 != 1) goto L7;
            return FlexBuffers.access$500(this.f377bb, this.end, this.parentWidth);
        L7:
            if (r10 == 2) goto L39;
            if (r10 == 3) goto L37;
            if (r10 != 5) goto L13;
            return Long.parseLong(asString());
        L35:
            return 0;
        L13:
            if (r10 != 6) goto L15;
            ReadBuf r11 = this.f377bb;
            return FlexBuffers.access$500(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth);
        L15:
            if (r10 != 7) goto L17;
            ReadBuf r12 = this.f377bb;
            return FlexBuffers.access$300(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.parentWidth);
        L17:
            if (r10 != 8) goto L19;
            ReadBuf r13 = this.f377bb;
            return (long) FlexBuffers.access$400(r13, FlexBuffers.access$200(r13, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r10 == 10) goto L26;
            if (r10 == 26) goto L24;
            return 0;
        L24:
            return FlexBuffers.access$100(this.f377bb, this.end, this.parentWidth);
        L26:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.f377bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$300(this.f377bb, this.end, this.parentWidth);
        }

        public Map asMap() {
            if (isMap() == false) goto L7;
            ReadBuf r10 = this.f377bb;
            return new Map(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L7:
            return Map.empty();
        }

        public String asString() {
            if (isString() == false) goto L8;
            int r10 = FlexBuffers.access$200(this.f377bb, this.end, this.parentWidth);
            ReadBuf r11 = this.f377bb;
            int r12 = this.byteWidth;
            int r13 = (int) FlexBuffers.access$300(r11, r10 - r12, r12);
            ReadBuf r14 = this.f377bb;
        L6:
            return r14.getString(r10, r13);
        L8:
            if (isKey() == false) goto L14;
            r10 = FlexBuffers.access$200(this.f377bb, this.end, this.byteWidth);
            int r15 = r10;
        L11:
            if (this.f377bb.get(r15) == 0) goto L12;
            r15 = r15 + 1;
            goto L11
        L12:
            r14 = this.f377bb;
            r13 = r15 - r10;
            goto L6
        L14:
            return "";
        }

        public long asUInt() {
            int r10 = this.type;
            if (r10 != 2) goto L7;
            return FlexBuffers.access$300(this.f377bb, this.end, this.parentWidth);
        L7:
            if (r10 == 1) goto L39;
            if (r10 == 3) goto L37;
            if (r10 == 10) goto L35;
            if (r10 == 26) goto L33;
            if (r10 == 5) goto L31;
            if (r10 != 6) goto L19;
            ReadBuf r11 = this.f377bb;
            return FlexBuffers.access$500(r11, FlexBuffers.access$200(r11, this.end, this.parentWidth), this.byteWidth);
        L19:
            if (r10 != 7) goto L21;
            ReadBuf r12 = this.f377bb;
            return FlexBuffers.access$300(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth);
        L21:
            if (r10 == 8) goto L24;
            return 0;
        L24:
            ReadBuf r13 = this.f377bb;
            return (long) FlexBuffers.access$400(r13, FlexBuffers.access$200(r13, this.end, this.parentWidth), this.parentWidth);
        L31:
            return Long.parseLong(asString());
        L33:
            return FlexBuffers.access$100(this.f377bb, this.end, this.parentWidth);
        L35:
            return asVector().size();
        L37:
            return (long) FlexBuffers.access$400(this.f377bb, this.end, this.parentWidth);
        L39:
            return FlexBuffers.access$500(this.f377bb, this.end, this.parentWidth);
        }

        public Vector asVector() {
            if (isVector() == false) goto L6;
            ReadBuf r10 = this.f377bb;
            return new Vector(r10, FlexBuffers.access$200(r10, this.end, this.parentWidth), this.byteWidth);
        L6:
            int r11 = this.type;
            if (r11 != 15) goto L11;
            ReadBuf r12 = this.f377bb;
            return new TypedVector(r12, FlexBuffers.access$200(r12, this.end, this.parentWidth), this.byteWidth, 4);
        L11:
            if (FlexBuffers.isTypedVector(r11) == false) goto L15;
            ReadBuf r13 = this.f377bb;
            return new TypedVector(r13, FlexBuffers.access$200(r13, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
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
            int r10 = this.type;
            if (r10 != 3) goto L5;
        L8:
            return true;
        L5:
            if (r10 == 8) goto L8;
            return false;
        }

        public boolean isInt() {
            int r10 = this.type;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 == 6) goto L10;
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
            int r10 = this.type;
            if (r10 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r10 == 7) goto L8;
            return false;
        }

        public boolean isVector() {
            int r10 = this.type;
            if (r10 != 10) goto L5;
        L8:
            return true;
        L5:
            if (r10 == 9) goto L8;
            return false;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        StringBuilder toString(StringBuilder r10) {
            int r11 = this.type;
            if (r11 != 36) goto L5;
        L29:
            r10.append(asVector());
            return r10;
        L5:
            switch(r11) {
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
            return r10;
        L7:
            r10.append(asBoolean());
            return r10;
        L17:
            r10.append(Typography.quote);
            r10.append(asString());
            r10.append(Typography.quote);
            return r10;
        L19:
            Key r12 = asKey();
            r10.append(Typography.quote);
            StringBuilder r13 = r12.toString(r10);
            r13.append(Typography.quote);
            return r13;
        L21:
            r10.append(asFloat());
            return r10;
        L23:
            r10.append(asUInt());
            return r10;
        L25:
            r10.append(asLong());
            return r10;
        L27:
            r10.append("null");
            return r10;
        L10:
            return asBlob().toString(r10);
        L12:
            throw new FlexBufferException("not_implemented:" + this.type);
        L14:
            return asVector().toString(r10);
        L16:
            return asMap().toString(r10);
        }
    }

    private static abstract class Sized extends Object {
        protected final int size;

        Sized(ReadBuf r10, int r11, int r12) {
            super(r10, r11, r12);
            this.size = FlexBuffers.access$100(this.f376bb, r11 - r12, r12);
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

        TypedVector(ReadBuf r10, int r11, int r12, int r13) {
            super(r10, r11, r12);
            this.elemType = r13;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        @Override // androidx.emoji2.text.flatbuffer.FlexBuffers.Vector
        public Reference get(int r10) {
            if (r10 >= size()) goto L5;
            int r11 = this.end + (r10 * this.byteWidth);
            return new Reference(this.f376bb, r11, this.byteWidth, 1, this.elemType);
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

        static int byteToUnsignedInt(byte r10) {
            return r10 & 255;
        }

        static long intToUnsignedLong(int r10) {
            return ((long) r10) & 4294967295L;
        }

        static int shortToUnsignedInt(short r10) {
            return r10 & UShort.MAX_VALUE;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = null;

        static {
            EMPTY_VECTOR = new Vector(FlexBuffers.access$000(), 1, 1);
        }

        Vector(ReadBuf r10, int r11, int r12) {
            super(r10, r11, r12);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public Reference get(int r10) {
            long r11 = size();
            long r12 = r10;
            if (r12 >= r11) goto L5;
            int r13 = Unsigned.byteToUnsignedInt(this.f376bb.get((int) ((((long) this.end) + (r11 * ((long) this.byteWidth))) + r12)));
            return new Reference(this.f376bb, this.end + (r10 * this.byteWidth), this.byteWidth, r13);
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
        public StringBuilder toString(StringBuilder r10) {
            r10.append("[ ");
            int r11 = size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L8;
            get(r12).toString(r10);
            if (r12 == (r11 - 1)) goto L7;
            r10.append(", ");
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            r10.append(" ]");
            return r10;
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

    static /* synthetic */ int access$100(ReadBuf r10, int r11, int r12) {
        return readInt(r10, r11, r12);
    }

    static /* synthetic */ int access$200(ReadBuf r10, int r11, int r12) {
        return indirect(r10, r11, r12);
    }

    static /* synthetic */ long access$300(ReadBuf r10, int r11, int r12) {
        return readUInt(r10, r11, r12);
    }

    static /* synthetic */ double access$400(ReadBuf r10, int r11, int r12) {
        return readDouble(r10, r11, r12);
    }

    static /* synthetic */ long access$500(ReadBuf r10, int r11, int r12) {
        return readLong(r10, r11, r12);
    }

    public static Reference getRoot(ReadBuf r10) {
        int r11 = r10.limit() - 1;
        byte r12 = r10.get(r11);
        int r13 = r11 - 1;
        return new Reference(r10, r13 - r12, r12, Unsigned.byteToUnsignedInt(r10.get(r13)));
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L5;
        ReadBuf r11 = new ArrayReadWriteBuf(r10.array(), r10.limit());
    L7:
        return getRoot(r11);
    L5:
        r11 = new ByteBufferReadWriteBuf(r10);
        goto L7
    }

    private static int indirect(ReadBuf r10, int r11, int r12) {
        return (int) (((long) r11) - readUInt(r10, r11, r12));
    }

    static boolean isTypeInline(int r10) {
        if (r10 > 3) goto L5;
    L8:
        return true;
    L5:
        if (r10 == 26) goto L8;
        return false;
    }

    static boolean isTypedVector(int r10) {
        if (r10 < 11) goto L7;
        if (r10 > 15) goto L7;
    L8:
        return true;
    L7:
        if (r10 == 36) goto L8;
        return false;
    }

    static boolean isTypedVectorElementType(int r10) {
        if (r10 < 1) goto L7;
        if (r10 > 4) goto L7;
        return true;
    L7:
        if (r10 == 26) goto L12;
        return false;
    L12:
        return true;
    }

    private static double readDouble(ReadBuf r10, int r11, int r12) {
        if (r12 == 4) goto L11;
        if (r12 == 8) goto L9;
        return -1.0d;
    L9:
        return r10.getDouble(r11);
    L11:
        return r10.getFloat(r11);
    }

    private static int readInt(ReadBuf r10, int r11, int r12) {
        return (int) readLong(r10, r11, r12);
    }

    private static long readLong(ReadBuf r10, int r11, int r12) {
        if (r12 != 1) goto L5;
        int r13 = r10.get(r11);
    L16:
        return r13;
    L5:
        if (r12 != 2) goto L7;
        r13 = r10.getShort(r11);
        goto L16
    L7:
        if (r12 != 4) goto L9;
        r13 = r10.getInt(r11);
        goto L16
    L9:
        if (r12 == 8) goto L13;
        return -1;
    L13:
        return r10.getLong(r11);
    }

    private static long readUInt(ReadBuf r10, int r11, int r12) {
        if (r12 == 1) goto L19;
        if (r12 == 2) goto L17;
        if (r12 == 4) goto L15;
        if (r12 == 8) goto L13;
        return -1;
    L13:
        return r10.getLong(r11);
    L15:
        return Unsigned.intToUnsignedLong(r10.getInt(r11));
    L17:
        return Unsigned.shortToUnsignedInt(r10.getShort(r11));
    L19:
        return Unsigned.byteToUnsignedInt(r10.get(r11));
    }

    static int toTypedVector(int r10, int r11) {
        if (r11 == 0) goto L18;
        if (r11 == 2) goto L16;
        if (r11 == 3) goto L14;
        if (r11 == 4) goto L12;
        return 0;
    L12:
        return (r10 - 1) + 22;
    L14:
        return (r10 - 1) + 19;
    L16:
        return (r10 - 1) + 16;
    L18:
        return (r10 - 1) + 11;
    }

    static int toTypedVectorElementType(int r10) {
        return (r10 - 11) + 1;
    }
}
