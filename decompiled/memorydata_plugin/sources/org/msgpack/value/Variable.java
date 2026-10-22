package org.msgpack.value;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessageIntegerOverflowException;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.core.MessageTypeCastException;
import org.msgpack.value.impl.ImmutableBigIntegerValueImpl;

/* JADX INFO: loaded from: classes7.dex */
public class Variable implements Value {
    private static final long BYTE_MAX = 127;
    private static final long BYTE_MIN = -128;
    private static final long INT_MAX = 2147483647L;
    private static final long INT_MIN = -2147483648L;
    private static final BigInteger LONG_MAX = null;
    private static final BigInteger LONG_MIN = null;
    private static final long SHORT_MAX = 32767;
    private static final long SHORT_MIN = -32768;
    private AbstractValueAccessor accessor;
    private final ArrayValueAccessor arrayAccessor;
    private final BinaryValueAccessor binaryAccessor;
    private final BooleanValueAccessor booleanAccessor;
    private double doubleValue;
    private final ExtensionValueAccessor extensionAccessor;
    private final FloatValueAccessor floatAccessor;
    private final IntegerValueAccessor integerAccessor;
    private long longValue;
    private final MapValueAccessor mapAccessor;
    private final NilValueAccessor nilAccessor;
    private Object objectValue;
    private final StringValueAccessor stringAccessor;
    private final TimestampValueAccessor timestampAccessor;
    private Type type;

    /* JADX INFO: renamed from: org.msgpack.value.Variable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private abstract class AbstractNumberValueAccessor extends AbstractValueAccessor implements NumberValue {
        final /* synthetic */ Variable this$0;

        private AbstractNumberValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ AbstractNumberValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public NumberValue asNumberValue() {
            return this;
        }

        @Override // org.msgpack.value.NumberValue
        public BigInteger toBigInteger() {
            if (Variable.access$1200(this.this$0) != Type.BIG_INTEGER) goto L7;
            return (BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), BigInteger.class, "com.obric.memorydata.plugin");
        L7:
            if (Variable.access$1200(this.this$0) != Type.DOUBLE) goto L11;
            return new BigDecimal(Variable.access$1400(this.this$0)).toBigInteger();
        L11:
            return BigInteger.valueOf(Variable.access$1100(this.this$0));
        }

        @Override // org.msgpack.value.NumberValue
        public byte toByte() {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L7;
            return ((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin")).byteValue();
        L7:
            return (byte) Variable.access$1100(r2);
        }

        @Override // org.msgpack.value.NumberValue
        public double toDouble() {
            if (Variable.access$1200(this.this$0) == Type.BIG_INTEGER) goto L5;
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.DOUBLE;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L11;
            return Variable.access$1400(r2);
        L11:
            return Variable.access$1100(r2);
        L5:
            return ((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), BigInteger.class, "com.obric.memorydata.plugin")).doubleValue();
        }

        @Override // org.msgpack.value.NumberValue
        public float toFloat() {
            if (Variable.access$1200(this.this$0) == Type.BIG_INTEGER) goto L5;
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.DOUBLE;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L11;
            return (float) Variable.access$1400(r2);
        L11:
            return Variable.access$1100(r2);
        L5:
            return ((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), BigInteger.class, "com.obric.memorydata.plugin")).floatValue();
        }

        @Override // org.msgpack.value.NumberValue
        public int toInt() {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L7;
            return ((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin")).intValue();
        L7:
            return (int) Variable.access$1100(r2);
        }

        @Override // org.msgpack.value.NumberValue
        public long toLong() {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L7;
            return ((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin")).longValue();
        L7:
            return Variable.access$1100(r2);
        }

        @Override // org.msgpack.value.NumberValue
        public short toShort() {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L7;
            return ((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin")).shortValue();
        L7:
            return (short) Variable.access$1100(r2);
        }
    }

    private abstract class AbstractRawValueAccessor extends AbstractValueAccessor implements RawValue {
        final /* synthetic */ Variable this$0;

        private AbstractRawValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ AbstractRawValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.RawValue
        public byte[] asByteArray() {
            return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.msgpack.value.RawValue
        public ByteBuffer asByteBuffer() {
            return ByteBuffer.wrap(asByteArray());
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public RawValue asRawValue() {
            return this;
        }

        @Override // org.msgpack.value.RawValue
        public String asString() {
            byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
            return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r2)).toString();
        L5:
            e = move-exception;
            throw new MessageStringCodingException(e);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.RawValue
        public String toString() {
            byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
            return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(ByteBuffer.wrap(r2)).toString();
        L5:
            e = move-exception;
            throw new MessageStringCodingException(e);
        }
    }

    private abstract class AbstractValueAccessor implements Value {
        final /* synthetic */ Variable this$0;

        private AbstractValueAccessor(Variable r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AbstractValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Value
        public ArrayValue asArrayValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public BinaryValue asBinaryValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public BooleanValue asBooleanValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public ExtensionValue asExtensionValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public FloatValue asFloatValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public IntegerValue asIntegerValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public MapValue asMapValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public NilValue asNilValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public NumberValue asNumberValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public RawValue asRawValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public StringValue asStringValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public TimestampValue asTimestampValue() {
            throw new MessageTypeCastException();
        }

        @Override // org.msgpack.value.Value
        public boolean equals(Object r1) {
            return this.this$0.equals(r1);
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // org.msgpack.value.Value
        public boolean isArrayValue() {
            return getValueType().isArrayType();
        }

        @Override // org.msgpack.value.Value
        public boolean isBinaryValue() {
            return getValueType().isBinaryType();
        }

        @Override // org.msgpack.value.Value
        public boolean isBooleanValue() {
            return getValueType().isBooleanType();
        }

        @Override // org.msgpack.value.Value
        public boolean isExtensionValue() {
            return getValueType().isExtensionType();
        }

        @Override // org.msgpack.value.Value
        public boolean isFloatValue() {
            return getValueType().isFloatType();
        }

        @Override // org.msgpack.value.Value
        public boolean isIntegerValue() {
            return getValueType().isIntegerType();
        }

        @Override // org.msgpack.value.Value
        public boolean isMapValue() {
            return getValueType().isMapType();
        }

        @Override // org.msgpack.value.Value
        public boolean isNilValue() {
            return getValueType().isNilType();
        }

        @Override // org.msgpack.value.Value
        public boolean isNumberValue() {
            return getValueType().isNumberType();
        }

        @Override // org.msgpack.value.Value
        public boolean isRawValue() {
            return getValueType().isRawType();
        }

        @Override // org.msgpack.value.Value
        public boolean isStringValue() {
            return getValueType().isStringType();
        }

        @Override // org.msgpack.value.Value
        public boolean isTimestampValue() {
            return false;
        }

        @Override // org.msgpack.value.Value
        public String toJson() {
            return this.this$0.toJson();
        }

        public String toString() {
            return this.this$0.toString();
        }
    }

    private class ArrayValueAccessor extends AbstractValueAccessor implements ArrayValue {
        final /* synthetic */ Variable this$0;

        private ArrayValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ ArrayValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        public Value[] array() {
            return (Value[]) ZeusTransformUtils.preCheckCast((Value[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), Value[].class, "com.obric.memorydata.plugin"), Value[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public ArrayValue asArrayValue() {
            return this;
        }

        @Override // org.msgpack.value.ArrayValue
        public Value get(int r1) {
            return array()[r1];
        }

        @Override // org.msgpack.value.ArrayValue
        public Value getOrNilValue(int r2) {
            Value[] r1 = array();
            if (r1.length >= r2) goto L8;
            if (r2 < 0) goto L8;
            return ValueFactory.newNil();
        L8:
            return r1[r2];
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.ARRAY;
        }

        @Override // org.msgpack.value.Value
        public ImmutableArrayValue immutableValue() {
            return ValueFactory.newArray(array());
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.ArrayValue, java.lang.Iterable
        public Iterator<Value> iterator() {
            return list().iterator();
        }

        @Override // org.msgpack.value.ArrayValue
        public List<Value> list() {
            return Arrays.asList(array());
        }

        @Override // org.msgpack.value.ArrayValue
        public int size() {
            return array().length;
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r1) {
            immutableValue().writeTo(r1);
        }
    }

    private class BinaryValueAccessor extends AbstractRawValueAccessor implements BinaryValue {
        final /* synthetic */ Variable this$0;

        private BinaryValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ BinaryValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public BinaryValue asBinaryValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.BINARY;
        }

        @Override // org.msgpack.value.Value
        public ImmutableBinaryValue immutableValue() {
            return ValueFactory.newBinary(asByteArray());
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r3) {
            byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
            r3.packBinaryHeader(r2.length);
            r3.writePayload(r2);
        }
    }

    private class BooleanValueAccessor extends AbstractValueAccessor implements BooleanValue {
        final /* synthetic */ Variable this$0;

        private BooleanValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ BooleanValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public BooleanValue asBooleanValue() {
            return this;
        }

        @Override // org.msgpack.value.BooleanValue
        public boolean getBoolean() {
            if (Variable.access$1100(this.this$0) != 1) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.BOOLEAN;
        }

        @Override // org.msgpack.value.Value
        public ImmutableBooleanValue immutableValue() {
            return ValueFactory.newBoolean(getBoolean());
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r5) {
            if (Variable.access$1100(this.this$0) != 1) goto L5;
            boolean r4 = true;
        L6:
            r5.packBoolean(r4);
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    private class ExtensionValueAccessor extends AbstractValueAccessor implements ExtensionValue {
        final /* synthetic */ Variable this$0;

        private ExtensionValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ ExtensionValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public ExtensionValue asExtensionValue() {
            return this;
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte[] getData() {
            return ((ImmutableExtensionValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableExtensionValue.class, "com.obric.memorydata.plugin")).getData();
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte getType() {
            return ((ImmutableExtensionValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableExtensionValue.class, "com.obric.memorydata.plugin")).getType();
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.EXTENSION;
        }

        @Override // org.msgpack.value.Value
        public ImmutableExtensionValue immutableValue() {
            return (ImmutableExtensionValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableExtensionValue.class, "com.obric.memorydata.plugin");
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r3) {
            ((ImmutableExtensionValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableExtensionValue.class, "com.obric.memorydata.plugin")).writeTo(r3);
        }
    }

    private class FloatValueAccessor extends AbstractNumberValueAccessor implements FloatValue {
        final /* synthetic */ Variable this$0;

        private FloatValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ FloatValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public FloatValue asFloatValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.FLOAT;
        }

        @Override // org.msgpack.value.Value
        public ImmutableFloatValue immutableValue() {
            return ValueFactory.newFloat(Variable.access$1400(this.this$0));
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r3) {
            r3.packDouble(Variable.access$1400(this.this$0));
        }
    }

    private class IntegerValueAccessor extends AbstractNumberValueAccessor implements IntegerValue {
        final /* synthetic */ Variable this$0;

        private IntegerValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ IntegerValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.IntegerValue
        public BigInteger asBigInteger() {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L7;
            return (BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin");
        L7:
            return BigInteger.valueOf(Variable.access$1100(r2));
        }

        @Override // org.msgpack.value.IntegerValue
        public byte asByte() {
            if (isInByteRange() == false) goto L7;
            return (byte) Variable.access$1100(this.this$0);
        L7:
            throw new MessageIntegerOverflowException(Variable.access$1100(this.this$0));
        }

        @Override // org.msgpack.value.IntegerValue
        public int asInt() {
            if (isInIntRange() == false) goto L7;
            return (int) Variable.access$1100(this.this$0);
        L7:
            throw new MessageIntegerOverflowException(Variable.access$1100(this.this$0));
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public IntegerValue asIntegerValue() {
            return this;
        }

        @Override // org.msgpack.value.IntegerValue
        public long asLong() {
            if (isInLongRange() == false) goto L7;
            return Variable.access$1100(this.this$0);
        L7:
            throw new MessageIntegerOverflowException(Variable.access$1100(this.this$0));
        }

        @Override // org.msgpack.value.IntegerValue
        public short asShort() {
            if (isInByteRange() == false) goto L7;
            return (short) Variable.access$1100(this.this$0);
        L7:
            throw new MessageIntegerOverflowException(Variable.access$1100(this.this$0));
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.INTEGER;
        }

        @Override // org.msgpack.value.Value
        public ImmutableIntegerValue immutableValue() {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L7;
            return ValueFactory.newInteger((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin"));
        L7:
            return ValueFactory.newInteger(Variable.access$1100(r2));
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInByteRange() {
            if (Variable.access$1200(this.this$0) != Type.BIG_INTEGER) goto L6;
            return false;
        L6:
            if (Variable.BYTE_MIN <= Variable.access$1100(this.this$0)) goto L8;
            return false;
        L8:
            if (Variable.access$1100(this.this$0) > Variable.BYTE_MAX) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInIntRange() {
            if (Variable.access$1200(this.this$0) != Type.BIG_INTEGER) goto L6;
            return false;
        L6:
            if (Variable.INT_MIN <= Variable.access$1100(this.this$0)) goto L8;
            return false;
        L8:
            if (Variable.access$1100(this.this$0) > Variable.INT_MAX) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInLongRange() {
            if (Variable.access$1200(this.this$0) != Type.BIG_INTEGER) goto L6;
            return false;
        L6:
            return true;
        }

        @Override // org.msgpack.value.IntegerValue
        public boolean isInShortRange() {
            if (Variable.access$1200(this.this$0) != Type.BIG_INTEGER) goto L6;
            return false;
        L6:
            if (Variable.SHORT_MIN <= Variable.access$1100(this.this$0)) goto L8;
            return false;
        L8:
            if (Variable.access$1100(this.this$0) > Variable.SHORT_MAX) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // org.msgpack.value.IntegerValue
        public MessageFormat mostSuccinctMessageFormat() {
            return ImmutableBigIntegerValueImpl.mostSuccinctMessageFormat(this);
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r3) {
            Type r0 = Variable.access$1200(this.this$0);
            Type r1 = Type.BIG_INTEGER;
            Variable r2 = this.this$0;
            if (r0 != r1) goto L5;
            r3.packBigInteger((BigInteger) ZeusTransformUtils.preCheckCast(Variable.access$1300(r2), BigInteger.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            r3.packLong(Variable.access$1100(r2));
        }
    }

    private class MapValueAccessor extends AbstractValueAccessor implements MapValue {
        final /* synthetic */ Variable this$0;

        private MapValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ MapValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public MapValue asMapValue() {
            return this;
        }

        @Override // org.msgpack.value.MapValue
        public Set<Map.Entry<Value, Value>> entrySet() {
            return immutableValue().entrySet();
        }

        @Override // org.msgpack.value.MapValue
        public Value[] getKeyValueArray() {
            return (Value[]) ZeusTransformUtils.preCheckCast((Value[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), Value[].class, "com.obric.memorydata.plugin"), Value[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.MAP;
        }

        @Override // org.msgpack.value.Value
        public ImmutableMapValue immutableValue() {
            return ValueFactory.newMap(getKeyValueArray());
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.MapValue
        public Set<Value> keySet() {
            return immutableValue().keySet();
        }

        @Override // org.msgpack.value.MapValue
        public Map<Value, Value> map() {
            return immutableValue().map();
        }

        @Override // org.msgpack.value.MapValue
        public int size() {
            return getKeyValueArray().length / 2;
        }

        @Override // org.msgpack.value.MapValue
        public Collection<Value> values() {
            return immutableValue().values();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r1) {
            immutableValue().writeTo(r1);
        }
    }

    private class NilValueAccessor extends AbstractValueAccessor implements NilValue {
        final /* synthetic */ Variable this$0;

        private NilValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ NilValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public NilValue asNilValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.NIL;
        }

        @Override // org.msgpack.value.Value
        public ImmutableNilValue immutableValue() {
            return ValueFactory.newNil();
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r1) {
            r1.packNil();
        }
    }

    private class StringValueAccessor extends AbstractRawValueAccessor implements StringValue {
        final /* synthetic */ Variable this$0;

        private StringValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ StringValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public StringValue asStringValue() {
            return this;
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.STRING;
        }

        @Override // org.msgpack.value.Value
        public ImmutableStringValue immutableValue() {
            return ValueFactory.newString((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin"));
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r3) {
            byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin");
            r3.packRawStringHeader(r2.length);
            r3.writePayload(r2);
        }
    }

    private class TimestampValueAccessor extends AbstractValueAccessor implements TimestampValue {
        final /* synthetic */ Variable this$0;

        private TimestampValueAccessor(Variable r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        /* synthetic */ TimestampValueAccessor(Variable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public TimestampValue asTimestampValue() {
            return this;
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte[] getData() {
            return ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).getData();
        }

        @Override // org.msgpack.value.TimestampValue
        public long getEpochSecond() {
            return ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).getEpochSecond();
        }

        @Override // org.msgpack.value.TimestampValue
        public int getNano() {
            return ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).getNano();
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte getType() {
            return ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).getType();
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.EXTENSION;
        }

        @Override // org.msgpack.value.Value
        public ImmutableTimestampValue immutableValue() {
            return (ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin");
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public boolean isTimestampValue() {
            return true;
        }

        @Override // org.msgpack.value.TimestampValue
        public long toEpochMillis() {
            return ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).toEpochMillis();
        }

        @Override // org.msgpack.value.TimestampValue
        public Instant toInstant() {
            return ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).toInstant();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r3) {
            ((ImmutableTimestampValue) ZeusTransformUtils.preCheckCast(Variable.access$1300(this.this$0), ImmutableTimestampValue.class, "com.obric.memorydata.plugin")).writeTo(r3);
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BIG_INTEGER = null;
        public static final Type BOOLEAN = null;
        public static final Type BYTE_ARRAY = null;
        public static final Type DOUBLE = null;
        public static final Type EXTENSION = null;
        public static final Type LIST = null;
        public static final Type LONG = null;
        public static final Type MAP = null;
        public static final Type NULL = null;
        public static final Type RAW_STRING = null;
        public static final Type TIMESTAMP = null;
        private final ValueType valueType;

        static {
            Type r0 = new Type("NULL", 0, ValueType.NIL);
            NULL = r0;
            Type r1 = new Type("BOOLEAN", 1, ValueType.BOOLEAN);
            BOOLEAN = r1;
            Type r2 = new Type("LONG", 2, ValueType.INTEGER);
            LONG = r2;
            Type r4 = new Type("BIG_INTEGER", 3, ValueType.INTEGER);
            BIG_INTEGER = r4;
            Type r6 = new Type("DOUBLE", 4, ValueType.FLOAT);
            DOUBLE = r6;
            Type r8 = new Type("BYTE_ARRAY", 5, ValueType.BINARY);
            BYTE_ARRAY = r8;
            Type r10 = new Type("RAW_STRING", 6, ValueType.STRING);
            RAW_STRING = r10;
            Type r12 = new Type("LIST", 7, ValueType.ARRAY);
            LIST = r12;
            Type r14 = new Type("MAP", 8, ValueType.MAP);
            MAP = r14;
            Type r13 = new Type("EXTENSION", 9, ValueType.EXTENSION);
            EXTENSION = r13;
            Type r11 = new Type("TIMESTAMP", 10, ValueType.EXTENSION);
            TIMESTAMP = r11;
            $VALUES = new Type[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11};
        }

        private Type(String r1, int r2, ValueType r3) {
            super(r1, r2);
            this.valueType = r3;
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }

        public ValueType getValueType() {
            return this.valueType;
        }
    }

    static {
        LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
        LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
    }

    public Variable() {
        AnonymousClass1 r1 = null;
        this.nilAccessor = new NilValueAccessor(this, r1);
        this.booleanAccessor = new BooleanValueAccessor(this, r1);
        this.integerAccessor = new IntegerValueAccessor(this, r1);
        this.floatAccessor = new FloatValueAccessor(this, r1);
        this.binaryAccessor = new BinaryValueAccessor(this, r1);
        this.stringAccessor = new StringValueAccessor(this, r1);
        this.arrayAccessor = new ArrayValueAccessor(this, r1);
        this.mapAccessor = new MapValueAccessor(this, r1);
        this.extensionAccessor = new ExtensionValueAccessor(this, r1);
        this.timestampAccessor = new TimestampValueAccessor(this, r1);
        setNilValue();
    }

    static /* synthetic */ long access$1100(Variable r2) {
        return r2.longValue;
    }

    static /* synthetic */ Type access$1200(Variable r0) {
        return r0.type;
    }

    static /* synthetic */ Object access$1300(Variable r0) {
        return r0.objectValue;
    }

    static /* synthetic */ double access$1400(Variable r2) {
        return r2.doubleValue;
    }

    @Override // org.msgpack.value.Value
    public ArrayValue asArrayValue() {
        if (isArrayValue() == false) goto L7;
        return (ArrayValue) ZeusTransformUtils.preCheckCast(this.accessor, ArrayValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public BinaryValue asBinaryValue() {
        if (isBinaryValue() == false) goto L7;
        return (BinaryValue) ZeusTransformUtils.preCheckCast(this.accessor, BinaryValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public BooleanValue asBooleanValue() {
        if (isBooleanValue() == false) goto L7;
        return (BooleanValue) ZeusTransformUtils.preCheckCast(this.accessor, BooleanValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ExtensionValue asExtensionValue() {
        if (isExtensionValue() == false) goto L7;
        return (ExtensionValue) ZeusTransformUtils.preCheckCast(this.accessor, ExtensionValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public FloatValue asFloatValue() {
        if (isFloatValue() == false) goto L7;
        return (FloatValue) ZeusTransformUtils.preCheckCast(this.accessor, FloatValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public IntegerValue asIntegerValue() {
        if (isIntegerValue() == false) goto L7;
        return (IntegerValue) ZeusTransformUtils.preCheckCast(this.accessor, IntegerValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public MapValue asMapValue() {
        if (isMapValue() == false) goto L7;
        return (MapValue) ZeusTransformUtils.preCheckCast(this.accessor, MapValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public NilValue asNilValue() {
        if (isNilValue() == false) goto L7;
        return (NilValue) ZeusTransformUtils.preCheckCast(this.accessor, NilValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public NumberValue asNumberValue() {
        if (isNumberValue() == false) goto L7;
        return (NumberValue) ZeusTransformUtils.preCheckCast(this.accessor, NumberValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public RawValue asRawValue() {
        if (isRawValue() == false) goto L7;
        return (RawValue) ZeusTransformUtils.preCheckCast(this.accessor, RawValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public StringValue asStringValue() {
        if (isStringValue() == false) goto L7;
        return (StringValue) ZeusTransformUtils.preCheckCast(this.accessor, StringValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public TimestampValue asTimestampValue() {
        if (isTimestampValue() == false) goto L7;
        return (TimestampValue) ZeusTransformUtils.preCheckCast(this.accessor, TimestampValue.class, "com.obric.memorydata.plugin");
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object r1) {
        return immutableValue().equals(r1);
    }

    @Override // org.msgpack.value.Value
    public ValueType getValueType() {
        return this.type.getValueType();
    }

    public int hashCode() {
        return immutableValue().hashCode();
    }

    @Override // org.msgpack.value.Value
    public ImmutableValue immutableValue() {
        return this.accessor.immutableValue();
    }

    @Override // org.msgpack.value.Value
    public boolean isArrayValue() {
        return getValueType().isArrayType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBinaryValue() {
        return getValueType().isBinaryType();
    }

    @Override // org.msgpack.value.Value
    public boolean isBooleanValue() {
        return getValueType().isBooleanType();
    }

    @Override // org.msgpack.value.Value
    public boolean isExtensionValue() {
        return getValueType().isExtensionType();
    }

    @Override // org.msgpack.value.Value
    public boolean isFloatValue() {
        return getValueType().isFloatType();
    }

    @Override // org.msgpack.value.Value
    public boolean isIntegerValue() {
        return getValueType().isIntegerType();
    }

    @Override // org.msgpack.value.Value
    public boolean isMapValue() {
        return getValueType().isMapType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNilValue() {
        return getValueType().isNilType();
    }

    @Override // org.msgpack.value.Value
    public boolean isNumberValue() {
        return getValueType().isNumberType();
    }

    @Override // org.msgpack.value.Value
    public boolean isRawValue() {
        return getValueType().isRawType();
    }

    @Override // org.msgpack.value.Value
    public boolean isStringValue() {
        return getValueType().isStringType();
    }

    @Override // org.msgpack.value.Value
    public boolean isTimestampValue() {
        if (this.type != Type.TIMESTAMP) goto L5;
        return true;
    L5:
        return false;
    }

    public Variable setArrayValue(List<Value> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.type = Type.LIST;
        this.accessor = this.arrayAccessor;
        this.objectValue = r4.toArray(new Value[r4.size()]);
        return this;
    }

    public Variable setArrayValue(Value[] r2) {
        this.type = Type.LIST;
        this.accessor = this.arrayAccessor;
        this.objectValue = r2;
        return this;
    }

    public Variable setBinaryValue(byte[] r2) {
        this.type = Type.BYTE_ARRAY;
        this.accessor = this.binaryAccessor;
        this.objectValue = r2;
        return this;
    }

    public Variable setBooleanValue(boolean r3) {
        this.type = Type.BOOLEAN;
        this.accessor = this.booleanAccessor;
        if (r3 == false) goto L5;
        long r0 = 1;
    L6:
        this.longValue = r0;
        return this;
    L5:
        r0 = 0;
        goto L6
    }

    public Variable setExtensionValue(byte r2, byte[] r3) {
        this.type = Type.EXTENSION;
        this.accessor = this.extensionAccessor;
        this.objectValue = ValueFactory.newExtension(r2, r3);
        return this;
    }

    public Variable setFloatValue(double r2) {
        this.type = Type.DOUBLE;
        this.accessor = this.floatAccessor;
        this.doubleValue = r2;
        this.longValue = (long) r2;
        return this;
    }

    public Variable setFloatValue(float r3) {
        this.type = Type.DOUBLE;
        this.accessor = this.floatAccessor;
        this.longValue = (long) r3;
        return this;
    }

    public Variable setIntegerValue(long r2) {
        this.type = Type.LONG;
        this.accessor = this.integerAccessor;
        this.longValue = r2;
        return this;
    }

    public Variable setIntegerValue(BigInteger r3) {
        if (r3.compareTo(LONG_MIN) >= 0) goto L5;
    L7:
        this.type = Type.BIG_INTEGER;
        this.accessor = this.integerAccessor;
        this.objectValue = r3;
    L8:
        return this;
    L5:
        if (r3.compareTo(LONG_MAX) > 0) goto L7;
        this.type = Type.LONG;
        this.accessor = this.integerAccessor;
        this.longValue = r3.longValue();
        goto L8
    }

    public Variable setMapValue(Map<Value, Value> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        this.type = Type.MAP;
        this.accessor = this.mapAccessor;
        Value[] r0 = new Value[r8.size() * 2];
        Iterator r9 = r8.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0[r2] = (Value) ZeusTransformUtils.preCheckCast(r3.getKey(), Value.class, "com.obric.memorydata.plugin");
        int r4 = r2 + 1;
        r0[r4] = (Value) ZeusTransformUtils.preCheckCast(r3.getValue(), Value.class, "com.obric.memorydata.plugin");
        r2 = r4 + 1;
        goto L4
    L6:
        this.objectValue = r0;
        return this;
    }

    public Variable setMapValue(Value[] r2) {
        this.type = Type.MAP;
        this.accessor = this.mapAccessor;
        this.objectValue = r2;
        return this;
    }

    public Variable setNilValue() {
        this.type = Type.NULL;
        this.accessor = this.nilAccessor;
        return this;
    }

    public Variable setStringValue(String r2) {
        return setStringValue(r2.getBytes(MessagePack.UTF8));
    }

    public Variable setStringValue(byte[] r2) {
        this.type = Type.RAW_STRING;
        this.accessor = this.stringAccessor;
        this.objectValue = r2;
        return this;
    }

    public Variable setTimestampValue(Instant r2) {
        this.type = Type.TIMESTAMP;
        this.accessor = this.timestampAccessor;
        this.objectValue = ValueFactory.newTimestamp(r2);
        return this;
    }

    @Override // org.msgpack.value.Value
    public String toJson() {
        return immutableValue().toJson();
    }

    public String toString() {
        return immutableValue().toString();
    }

    @Override // org.msgpack.value.Value
    public void writeTo(MessagePacker r1) {
        this.accessor.writeTo(r1);
    }
}
