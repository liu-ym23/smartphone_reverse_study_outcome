package org.msgpack.value;

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

/* JADX INFO: loaded from: classes3.dex */
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

        private AbstractNumberValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ AbstractNumberValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public NumberValue asNumberValue() {
            return this;
        }

        @Override // org.msgpack.value.NumberValue
        public BigInteger toBigInteger() {
            if (Variable.access$1200(this.this$0) != Type.BIG_INTEGER) goto L7;
            return (BigInteger) Variable.access$1300(this.this$0);
        L7:
            if (Variable.access$1200(this.this$0) != Type.DOUBLE) goto L11;
            return new BigDecimal(Variable.access$1400(this.this$0)).toBigInteger();
        L11:
            return BigInteger.valueOf(Variable.access$1100(this.this$0));
        }

        @Override // org.msgpack.value.NumberValue
        public byte toByte() {
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.BIG_INTEGER;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L7;
            return ((BigInteger) Variable.access$1300(r12)).byteValue();
        L7:
            return (byte) Variable.access$1100(r12);
        }

        @Override // org.msgpack.value.NumberValue
        public double toDouble() {
            if (Variable.access$1200(this.this$0) == Type.BIG_INTEGER) goto L5;
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.DOUBLE;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L11;
            return Variable.access$1400(r12);
        L11:
            return Variable.access$1100(r12);
        L5:
            return ((BigInteger) Variable.access$1300(this.this$0)).doubleValue();
        }

        @Override // org.msgpack.value.NumberValue
        public float toFloat() {
            if (Variable.access$1200(this.this$0) == Type.BIG_INTEGER) goto L5;
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.DOUBLE;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L11;
            return (float) Variable.access$1400(r12);
        L11:
            return Variable.access$1100(r12);
        L5:
            return ((BigInteger) Variable.access$1300(this.this$0)).floatValue();
        }

        @Override // org.msgpack.value.NumberValue
        public int toInt() {
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.BIG_INTEGER;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L7;
            return ((BigInteger) Variable.access$1300(r12)).intValue();
        L7:
            return (int) Variable.access$1100(r12);
        }

        @Override // org.msgpack.value.NumberValue
        public long toLong() {
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.BIG_INTEGER;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L7;
            return ((BigInteger) Variable.access$1300(r12)).longValue();
        L7:
            return Variable.access$1100(r12);
        }

        @Override // org.msgpack.value.NumberValue
        public short toShort() {
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.BIG_INTEGER;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L7;
            return ((BigInteger) Variable.access$1300(r12)).shortValue();
        L7:
            return (short) Variable.access$1100(r12);
        }
    }

    private abstract class AbstractRawValueAccessor extends AbstractValueAccessor implements RawValue {
        final /* synthetic */ Variable this$0;

        private AbstractRawValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ AbstractRawValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // org.msgpack.value.RawValue
        public byte[] asByteArray() {
            return (byte[]) Variable.access$1300(this.this$0);
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
            byte[] r10 = (byte[]) Variable.access$1300(this.this$0);
            return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r10)).toString();
        L5:
            e = move-exception;
            throw new MessageStringCodingException(e);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.RawValue
        public String toString() {
            byte[] r10 = (byte[]) Variable.access$1300(this.this$0);
            return MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(ByteBuffer.wrap(r10)).toString();
        L5:
            e = move-exception;
            throw new MessageStringCodingException(e);
        }
    }

    private abstract class AbstractValueAccessor implements Value {
        final /* synthetic */ Variable this$0;

        private AbstractValueAccessor(Variable r10) {
            this.this$0 = r10;
        }

        /* synthetic */ AbstractValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
        public boolean equals(Object r10) {
            return this.this$0.equals(r10);
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

        private ArrayValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ ArrayValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
        }

        public Value[] array() {
            return (Value[]) Variable.access$1300(this.this$0);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public ArrayValue asArrayValue() {
            return this;
        }

        @Override // org.msgpack.value.ArrayValue
        public Value get(int r10) {
            return array()[r10];
        }

        @Override // org.msgpack.value.ArrayValue
        public Value getOrNilValue(int r10) {
            Value[] r11 = array();
            if (r11.length >= r10) goto L8;
            if (r10 < 0) goto L8;
            return ValueFactory.newNil();
        L8:
            return r11[r10];
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
        public void writeTo(MessagePacker r10) {
            immutableValue().writeTo(r10);
        }
    }

    private class BinaryValueAccessor extends AbstractRawValueAccessor implements BinaryValue {
        final /* synthetic */ Variable this$0;

        private BinaryValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ BinaryValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
        public void writeTo(MessagePacker r10) {
            byte[] r11 = (byte[]) Variable.access$1300(this.this$0);
            r10.packBinaryHeader(r11.length);
            r10.writePayload(r11);
        }
    }

    private class BooleanValueAccessor extends AbstractValueAccessor implements BooleanValue {
        final /* synthetic */ Variable this$0;

        private BooleanValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ BooleanValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
        public void writeTo(MessagePacker r10) {
            if (Variable.access$1100(this.this$0) != 1) goto L5;
            boolean r11 = true;
        L6:
            r10.packBoolean(r11);
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    private class ExtensionValueAccessor extends AbstractValueAccessor implements ExtensionValue {
        final /* synthetic */ Variable this$0;

        private ExtensionValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ ExtensionValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public ExtensionValue asExtensionValue() {
            return this;
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte[] getData() {
            return ((ImmutableExtensionValue) Variable.access$1300(this.this$0)).getData();
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte getType() {
            return ((ImmutableExtensionValue) Variable.access$1300(this.this$0)).getType();
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.EXTENSION;
        }

        @Override // org.msgpack.value.Value
        public ImmutableExtensionValue immutableValue() {
            return (ImmutableExtensionValue) Variable.access$1300(this.this$0);
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r10) {
            ((ImmutableExtensionValue) Variable.access$1300(this.this$0)).writeTo(r10);
        }
    }

    private class FloatValueAccessor extends AbstractNumberValueAccessor implements FloatValue {
        final /* synthetic */ Variable this$0;

        private FloatValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ FloatValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
        public void writeTo(MessagePacker r10) {
            r10.packDouble(Variable.access$1400(this.this$0));
        }
    }

    private class IntegerValueAccessor extends AbstractNumberValueAccessor implements IntegerValue {
        final /* synthetic */ Variable this$0;

        private IntegerValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ IntegerValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // org.msgpack.value.IntegerValue
        public BigInteger asBigInteger() {
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.BIG_INTEGER;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L7;
            return (BigInteger) Variable.access$1300(r12);
        L7:
            return BigInteger.valueOf(Variable.access$1100(r12));
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
            Type r10 = Variable.access$1200(this.this$0);
            Type r11 = Type.BIG_INTEGER;
            Variable r12 = this.this$0;
            if (r10 != r11) goto L7;
            return ValueFactory.newInteger((BigInteger) Variable.access$1300(r12));
        L7:
            return ValueFactory.newInteger(Variable.access$1100(r12));
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
        public void writeTo(MessagePacker r10) {
            Type r11 = Variable.access$1200(this.this$0);
            Type r12 = Type.BIG_INTEGER;
            Variable r13 = this.this$0;
            if (r11 != r12) goto L5;
            r10.packBigInteger((BigInteger) Variable.access$1300(r13));
            return;
        L5:
            r10.packLong(Variable.access$1100(r13));
        }
    }

    private class MapValueAccessor extends AbstractValueAccessor implements MapValue {
        final /* synthetic */ Variable this$0;

        private MapValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ MapValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
            return (Value[]) Variable.access$1300(this.this$0);
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
        public void writeTo(MessagePacker r10) {
            immutableValue().writeTo(r10);
        }
    }

    private class NilValueAccessor extends AbstractValueAccessor implements NilValue {
        final /* synthetic */ Variable this$0;

        private NilValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ NilValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
        public void writeTo(MessagePacker r10) {
            r10.packNil();
        }
    }

    private class StringValueAccessor extends AbstractRawValueAccessor implements StringValue {
        final /* synthetic */ Variable this$0;

        private StringValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ StringValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
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
            return ValueFactory.newString((byte[]) Variable.access$1300(this.this$0));
        }

        @Override // org.msgpack.value.Value
        public /* bridge */ /* synthetic */ ImmutableValue immutableValue() {
            return immutableValue();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r10) {
            byte[] r11 = (byte[]) Variable.access$1300(this.this$0);
            r10.packRawStringHeader(r11.length);
            r10.writePayload(r11);
        }
    }

    private class TimestampValueAccessor extends AbstractValueAccessor implements TimestampValue {
        final /* synthetic */ Variable this$0;

        private TimestampValueAccessor(Variable r10) {
            this.this$0 = r10;
            super(r10, null);
        }

        /* synthetic */ TimestampValueAccessor(Variable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // org.msgpack.value.Variable.AbstractValueAccessor, org.msgpack.value.Value
        public TimestampValue asTimestampValue() {
            return this;
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte[] getData() {
            return ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).getData();
        }

        @Override // org.msgpack.value.TimestampValue
        public long getEpochSecond() {
            return ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).getEpochSecond();
        }

        @Override // org.msgpack.value.TimestampValue
        public int getNano() {
            return ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).getNano();
        }

        @Override // org.msgpack.value.ExtensionValue
        public byte getType() {
            return ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).getType();
        }

        @Override // org.msgpack.value.Value
        public ValueType getValueType() {
            return ValueType.EXTENSION;
        }

        @Override // org.msgpack.value.Value
        public ImmutableTimestampValue immutableValue() {
            return (ImmutableTimestampValue) Variable.access$1300(this.this$0);
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
            return ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).toEpochMillis();
        }

        @Override // org.msgpack.value.TimestampValue
        public Instant toInstant() {
            return ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).toInstant();
        }

        @Override // org.msgpack.value.Value
        public void writeTo(MessagePacker r10) {
            ((ImmutableTimestampValue) Variable.access$1300(this.this$0)).writeTo(r10);
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
            Type r10 = new Type("NULL", 0, ValueType.NIL);
            NULL = r10;
            Type r11 = new Type("BOOLEAN", 1, ValueType.BOOLEAN);
            BOOLEAN = r11;
            ValueType r12 = ValueType.INTEGER;
            Type r13 = new Type("LONG", 2, r12);
            LONG = r13;
            Type r14 = new Type("BIG_INTEGER", 3, r12);
            BIG_INTEGER = r14;
            Type r15 = new Type("DOUBLE", 4, ValueType.FLOAT);
            DOUBLE = r15;
            Type r16 = new Type("BYTE_ARRAY", 5, ValueType.BINARY);
            BYTE_ARRAY = r16;
            Type r17 = new Type("RAW_STRING", 6, ValueType.STRING);
            RAW_STRING = r17;
            Type r18 = new Type("LIST", 7, ValueType.ARRAY);
            LIST = r18;
            Type r19 = new Type("MAP", 8, ValueType.MAP);
            MAP = r19;
            ValueType r110 = ValueType.EXTENSION;
            Type r111 = new Type("EXTENSION", 9, r110);
            EXTENSION = r111;
            Type r112 = new Type("TIMESTAMP", 10, r110);
            TIMESTAMP = r112;
            $VALUES = new Type[]{r10, r11, r13, r14, r15, r16, r17, r18, r19, r111, r112};
        }

        private Type(String r10, int r11, ValueType r12) {
            super(r10, r11);
            this.valueType = r12;
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
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
        AnonymousClass1 r10 = null;
        this.nilAccessor = new NilValueAccessor(this, r10);
        this.booleanAccessor = new BooleanValueAccessor(this, r10);
        this.integerAccessor = new IntegerValueAccessor(this, r10);
        this.floatAccessor = new FloatValueAccessor(this, r10);
        this.binaryAccessor = new BinaryValueAccessor(this, r10);
        this.stringAccessor = new StringValueAccessor(this, r10);
        this.arrayAccessor = new ArrayValueAccessor(this, r10);
        this.mapAccessor = new MapValueAccessor(this, r10);
        this.extensionAccessor = new ExtensionValueAccessor(this, r10);
        this.timestampAccessor = new TimestampValueAccessor(this, r10);
        setNilValue();
    }

    static /* synthetic */ long access$1100(Variable r10) {
        return r10.longValue;
    }

    static /* synthetic */ Type access$1200(Variable r10) {
        return r10.type;
    }

    static /* synthetic */ Object access$1300(Variable r10) {
        return r10.objectValue;
    }

    static /* synthetic */ double access$1400(Variable r10) {
        return r10.doubleValue;
    }

    @Override // org.msgpack.value.Value
    public ArrayValue asArrayValue() {
        if (isArrayValue() == false) goto L7;
        return (ArrayValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public BinaryValue asBinaryValue() {
        if (isBinaryValue() == false) goto L7;
        return (BinaryValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public BooleanValue asBooleanValue() {
        if (isBooleanValue() == false) goto L7;
        return (BooleanValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public ExtensionValue asExtensionValue() {
        if (isExtensionValue() == false) goto L7;
        return (ExtensionValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public FloatValue asFloatValue() {
        if (isFloatValue() == false) goto L7;
        return (FloatValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public IntegerValue asIntegerValue() {
        if (isIntegerValue() == false) goto L7;
        return (IntegerValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public MapValue asMapValue() {
        if (isMapValue() == false) goto L7;
        return (MapValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public NilValue asNilValue() {
        if (isNilValue() == false) goto L7;
        return (NilValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public NumberValue asNumberValue() {
        if (isNumberValue() == false) goto L7;
        return (NumberValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public RawValue asRawValue() {
        if (isRawValue() == false) goto L7;
        return (RawValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public StringValue asStringValue() {
        if (isStringValue() == false) goto L7;
        return (StringValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public TimestampValue asTimestampValue() {
        if (isTimestampValue() == false) goto L7;
        return (TimestampValue) this.accessor;
    L7:
        throw new MessageTypeCastException();
    }

    @Override // org.msgpack.value.Value
    public boolean equals(Object r10) {
        return immutableValue().equals(r10);
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

    public Variable setArrayValue(List<Value> r10) {
        this.type = Type.LIST;
        this.accessor = this.arrayAccessor;
        this.objectValue = r10.toArray(new Value[r10.size()]);
        return this;
    }

    public Variable setArrayValue(Value[] r10) {
        this.type = Type.LIST;
        this.accessor = this.arrayAccessor;
        this.objectValue = r10;
        return this;
    }

    public Variable setBinaryValue(byte[] r10) {
        this.type = Type.BYTE_ARRAY;
        this.accessor = this.binaryAccessor;
        this.objectValue = r10;
        return this;
    }

    public Variable setBooleanValue(boolean r10) {
        this.type = Type.BOOLEAN;
        this.accessor = this.booleanAccessor;
        if (r10 == false) goto L5;
        long r11 = 1;
    L6:
        this.longValue = r11;
        return this;
    L5:
        r11 = 0;
        goto L6
    }

    public Variable setExtensionValue(byte r10, byte[] r11) {
        this.type = Type.EXTENSION;
        this.accessor = this.extensionAccessor;
        this.objectValue = ValueFactory.newExtension(r10, r11);
        return this;
    }

    public Variable setFloatValue(double r10) {
        this.type = Type.DOUBLE;
        this.accessor = this.floatAccessor;
        this.doubleValue = r10;
        this.longValue = (long) r10;
        return this;
    }

    public Variable setFloatValue(float r10) {
        this.type = Type.DOUBLE;
        this.accessor = this.floatAccessor;
        this.longValue = (long) r10;
        return this;
    }

    public Variable setIntegerValue(long r10) {
        this.type = Type.LONG;
        this.accessor = this.integerAccessor;
        this.longValue = r10;
        return this;
    }

    public Variable setIntegerValue(BigInteger r10) {
        if (r10.compareTo(LONG_MIN) >= 0) goto L5;
    L7:
        this.type = Type.BIG_INTEGER;
        this.accessor = this.integerAccessor;
        this.objectValue = r10;
    L8:
        return this;
    L5:
        if (r10.compareTo(LONG_MAX) > 0) goto L7;
        this.type = Type.LONG;
        this.accessor = this.integerAccessor;
        this.longValue = r10.longValue();
        goto L8
    }

    public Variable setMapValue(Map<Value, Value> r10) {
        this.type = Type.MAP;
        this.accessor = this.mapAccessor;
        Value[] r11 = new Value[r10.size() * 2];
        Iterator<Map.Entry<Value, Value>> r12 = r10.entrySet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<Value, Value> r14 = r12.next();
        r11[r13] = r14.getKey();
        int r15 = r13 + 1;
        r11[r15] = r14.getValue();
        r13 = r15 + 1;
        goto L4
    L6:
        this.objectValue = r11;
        return this;
    }

    public Variable setMapValue(Value[] r10) {
        this.type = Type.MAP;
        this.accessor = this.mapAccessor;
        this.objectValue = r10;
        return this;
    }

    public Variable setNilValue() {
        this.type = Type.NULL;
        this.accessor = this.nilAccessor;
        return this;
    }

    public Variable setStringValue(String r10) {
        return setStringValue(r10.getBytes(MessagePack.UTF8));
    }

    public Variable setStringValue(byte[] r10) {
        this.type = Type.RAW_STRING;
        this.accessor = this.stringAccessor;
        this.objectValue = r10;
        return this;
    }

    public Variable setTimestampValue(Instant r10) {
        this.type = Type.TIMESTAMP;
        this.accessor = this.timestampAccessor;
        this.objectValue = ValueFactory.newTimestamp(r10);
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
    public void writeTo(MessagePacker r10) {
        this.accessor.writeTo(r10);
    }
}
