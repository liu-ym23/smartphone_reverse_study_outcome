package androidx.room.jarjarred.kotlinx.metadata;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "", "()V", "AnnotationValue", "ArrayValue", "BooleanValue", "ByteValue", "CharValue", "DoubleValue", "EnumValue", "FloatValue", "IntValue", "KClassValue", "LiteralValue", "LongValue", "ShortValue", "StringValue", "UByteValue", "UIntValue", "ULongValue", "UShortValue", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$AnnotationValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ArrayValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$EnumValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$KClassValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmAnnotationArgument {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$AnnotationValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "annotation", "<init>", "(Ljava/lang/Object;)V", "component1", "()Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "copy", "(Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;)Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$AnnotationValue;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "getAnnotation", "()Ljava/lang/Object;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnnotationValue extends KmAnnotationArgument {
        private final KmAnnotation annotation;

        public AnnotationValue(KmAnnotation r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            super(null);
            this.annotation = r5;
        }

        public static /* synthetic */ AnnotationValue copy$default(AnnotationValue r5, KmAnnotation r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.annotation;
        L6:
            return r5.copy(r10);
        }

        public final KmAnnotation component1() {
            return this.annotation;
        }

        public final AnnotationValue copy(KmAnnotation r5) {
            Intrinsics.checkNotNullParameter(r5, "annotation");
            return new AnnotationValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AnnotationValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.annotation, ((AnnotationValue) r5).annotation) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final KmAnnotation getAnnotation() {
            return this.annotation;
        }

        public int hashCode() {
            return this.annotation.hashCode();
        }

        public String toString() {
            return "AnnotationValue(annotation=" + this.annotation + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ArrayValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "elements", "", "(Ljava/util/List;)V", "getElements", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ArrayValue extends KmAnnotationArgument {
        private final List<KmAnnotationArgument> elements;

        /* JADX WARN: Multi-variable type inference failed */
        public ArrayValue(List<? extends KmAnnotationArgument> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            super(null);
            this.elements = r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ArrayValue copy$default(ArrayValue r5, List r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.elements;
        L6:
            return r5.copy(r10);
        }

        public final List<KmAnnotationArgument> component1() {
            return this.elements;
        }

        public final ArrayValue copy(List<? extends KmAnnotationArgument> r5) {
            Intrinsics.checkNotNullParameter(r5, "elements");
            return new ArrayValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ArrayValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.elements, ((ArrayValue) r5).elements) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final List<KmAnnotationArgument> getElements() {
            return this.elements;
        }

        public int hashCode() {
            return this.elements.hashCode();
        }

        public String toString() {
            return a.v(new StringBuilder("ArrayValue(elements="), this.elements, ')');
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$BooleanValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BooleanValue extends LiteralValue<Boolean> {
        private final boolean value;

        public BooleanValue(boolean r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ BooleanValue copy$default(BooleanValue r5, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().booleanValue();
        L6:
            return r5.copy(r10);
        }

        public final boolean component1() {
            return getValue().booleanValue();
        }

        public final BooleanValue copy(boolean r5) {
            return new BooleanValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof BooleanValue) == true) goto L9;
            return false;
        L9:
            if (getValue().booleanValue() == ((BooleanValue) r5).getValue().booleanValue()) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "BooleanValue(value=" + getValue().booleanValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Boolean getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ByteValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(B)V", "getValue", "()Ljava/lang/Byte;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ByteValue extends LiteralValue<Byte> {
        private final byte value;

        public ByteValue(byte r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ ByteValue copy$default(ByteValue r5, byte r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().byteValue();
        L6:
            return r5.copy(r10);
        }

        public final byte component1() {
            return getValue().byteValue();
        }

        public final ByteValue copy(byte r5) {
            return new ByteValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ByteValue) == true) goto L9;
            return false;
        L9:
            if (getValue().byteValue() == ((ByteValue) r5).getValue().byteValue()) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Byte getValue() {
            return Byte.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "ByteValue(value=" + getValue().byteValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Byte getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$CharValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(C)V", "getValue", "()Ljava/lang/Character;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CharValue extends LiteralValue<Character> {
        private final char value;

        public CharValue(char r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ CharValue copy$default(CharValue r5, char r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().charValue();
        L6:
            return r5.copy(r10);
        }

        public final char component1() {
            return getValue().charValue();
        }

        public final CharValue copy(char r5) {
            return new CharValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CharValue) == true) goto L9;
            return false;
        L9:
            if (getValue().charValue() == ((CharValue) r5).getValue().charValue()) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Character getValue() {
            return Character.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "CharValue(value=" + getValue().charValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Character getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$DoubleValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(D)V", "getValue", "()Ljava/lang/Double;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DoubleValue extends LiteralValue<Double> {
        private final double value;

        public DoubleValue(double r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ DoubleValue copy$default(DoubleValue r5, double r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().doubleValue();
        L6:
            return r5.copy(r10);
        }

        public final double component1() {
            return getValue().doubleValue();
        }

        public final DoubleValue copy(double r5) {
            return new DoubleValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DoubleValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(getValue(), ((DoubleValue) r5).getValue()) == true) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Double getValue() {
            return Double.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "DoubleValue(value=" + getValue().doubleValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Double getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\r\u0010\n\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$EnumValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "enumClassName", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "enumEntryName", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnumClassName", "()Ljava/lang/String;", "getEnumEntryName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EnumValue extends KmAnnotationArgument {
        private final String enumClassName;
        private final String enumEntryName;

        public EnumValue(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "enumClassName");
            Intrinsics.checkNotNullParameter(r10, "enumEntryName");
            super(null);
            this.enumClassName = r5;
            this.enumEntryName = r10;
        }

        public static /* synthetic */ EnumValue copy$default(EnumValue r5, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.enumClassName;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.enumEntryName;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.enumClassName;
        }

        public final String component2() {
            return this.enumEntryName;
        }

        public final EnumValue copy(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "enumClassName");
            Intrinsics.checkNotNullParameter(r10, "enumEntryName");
            return new EnumValue(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof EnumValue) == true) goto L8;
            return false;
        L8:
            EnumValue r10 = (EnumValue) r5;
            if (Intrinsics.areEqual(this.enumClassName, r10.enumClassName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.enumEntryName, r10.enumEntryName) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getEnumClassName() {
            return this.enumClassName;
        }

        public final String getEnumEntryName() {
            return this.enumEntryName;
        }

        public int hashCode() {
            int r5 = this.enumClassName.hashCode() * 31;
            return this.enumEntryName.hashCode() + r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("EnumValue(enumClassName=");
            r5.append(this.enumClassName);
            r5.append(", enumEntryName=");
            return j0.p(r5, this.enumEntryName, ')');
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$FloatValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(F)V", "getValue", "()Ljava/lang/Float;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FloatValue extends LiteralValue<Float> {
        private final float value;

        public FloatValue(float r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ FloatValue copy$default(FloatValue r5, float r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().floatValue();
        L6:
            return r5.copy(r10);
        }

        public final float component1() {
            return getValue().floatValue();
        }

        public final FloatValue copy(float r5) {
            return new FloatValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof FloatValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(getValue(), ((FloatValue) r5).getValue()) == true) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Float getValue() {
            return Float.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "FloatValue(value=" + getValue().floatValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Float getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$IntValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class IntValue extends LiteralValue<Integer> {
        private final int value;

        public IntValue(int r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ IntValue copy$default(IntValue r5, int r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().intValue();
        L6:
            return r5.copy(r10);
        }

        public final int component1() {
            return getValue().intValue();
        }

        public final IntValue copy(int r5) {
            return new IntValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof IntValue) == true) goto L9;
            return false;
        L9:
            if (getValue().intValue() == ((IntValue) r5).getValue().intValue()) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Integer getValue() {
            return Integer.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "IntValue(value=" + getValue().intValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Integer getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\f\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$KClassValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "className", "", "Landroidx/room/jarjarred/kotlinx/metadata/ClassName;", "arrayDimensionCount", "", "(Ljava/lang/String;I)V", "getArrayDimensionCount", "()I", "getClassName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KClassValue extends KmAnnotationArgument {
        private final int arrayDimensionCount;
        private final String className;

        public KClassValue(String r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "className");
            super(null);
            this.className = r5;
            this.arrayDimensionCount = r10;
        }

        public static /* synthetic */ KClassValue copy$default(KClassValue r5, String r10, int r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.className;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.arrayDimensionCount;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.className;
        }

        public final int component2() {
            return this.arrayDimensionCount;
        }

        public final KClassValue copy(String r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "className");
            return new KClassValue(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof KClassValue) == true) goto L8;
            return false;
        L8:
            KClassValue r10 = (KClassValue) r5;
            if (Intrinsics.areEqual(this.className, r10.className) == true) goto L12;
            return false;
        L12:
            if (this.arrayDimensionCount == r10.arrayDimensionCount) goto L14;
            return false;
        L14:
            return true;
        }

        public final int getArrayDimensionCount() {
            return this.arrayDimensionCount;
        }

        public final String getClassName() {
            return this.className;
        }

        public int hashCode() {
            int r5 = this.className.hashCode() * 31;
            return Integer.hashCode(this.arrayDimensionCount) + r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("KClassValue(className=");
            r5.append(this.className);
            r5.append(", arrayDimensionCount=");
            return j0.n(r5, this.arrayDimensionCount, ')');
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\r\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument;", "()V", "value", "getValue", "()Ljava/lang/Object;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$BooleanValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ByteValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$CharValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$DoubleValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$FloatValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$IntValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LongValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ShortValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$StringValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$UByteValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$UIntValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ULongValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$UShortValue;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class LiteralValue<T> extends KmAnnotationArgument {
        public /* synthetic */ LiteralValue(DefaultConstructorMarker r5) {
            this();
        }

        public abstract T getValue();

        private LiteralValue() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LongValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(J)V", "getValue", "()Ljava/lang/Long;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LongValue extends LiteralValue<Long> {
        private final long value;

        public LongValue(long r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ LongValue copy$default(LongValue r5, long r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue().longValue();
        L6:
            return r5.copy(r10);
        }

        public final long component1() {
            return getValue().longValue();
        }

        public final LongValue copy(long r5) {
            return new LongValue(r5);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof LongValue) == true) goto L9;
            return false;
        L9:
            if (getValue().longValue() == ((LongValue) r10).getValue().longValue()) goto L11;
            return false;
        L11:
            return true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Long getValue() {
            return Long.valueOf(this.value);
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "LongValue(value=" + getValue().longValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Long getValue() {
            return getValue();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ShortValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(S)V", "getValue", "()Ljava/lang/Short;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ShortValue extends LiteralValue<Short> {
        private final short value;

        public ShortValue(short r5) {
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ ShortValue copy$default(ShortValue r5, short r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue2().shortValue();
        L6:
            return r5.copy(r10);
        }

        public final short component1() {
            return getValue2().shortValue();
        }

        public final ShortValue copy(short r5) {
            return new ShortValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ShortValue) == true) goto L9;
            return false;
        L9:
            if (getValue2().shortValue() == ((ShortValue) r5).getValue2().shortValue()) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ Short getValue() {
            return getValue2();
        }

        public int hashCode() {
            return getValue2().hashCode();
        }

        public String toString() {
            return "ShortValue(value=" + getValue2().shortValue() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
        public Short getValue2() {
            return Short.valueOf(this.value);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$StringValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StringValue extends LiteralValue<String> {
        private final String value;

        public StringValue(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            super(null);
            this.value = r5;
        }

        public static /* synthetic */ StringValue copy$default(StringValue r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.getValue2();
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return getValue2();
        }

        public final StringValue copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            return new StringValue(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StringValue) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(getValue2(), ((StringValue) r5).getValue2()) == true) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ String getValue() {
            return getValue2();
        }

        public int hashCode() {
            return getValue2().hashCode();
        }

        public String toString() {
            return "StringValue(value=" + getValue2() + ')';
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
        public String getValue2() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$UByteValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/UByte;", "value", "<init>", "(BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1-w2LRezQ", "()B", "component1", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "copy-7apg3OU", "(B)Ljava/lang/Object;", "copy", "B", "getValue-w2LRezQ", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @ExperimentalUnsignedTypes
    public static final class UByteValue extends LiteralValue<UByte> {
        private final byte value;

        public /* synthetic */ UByteValue(byte r5, DefaultConstructorMarker r10) {
            this(r5);
        }

        /* JADX INFO: renamed from: copy-7apg3OU$default, reason: not valid java name */
        public static /* synthetic */ UByteValue m60copy7apg3OU$default(UByteValue r5, byte r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.m63getValuew2LRezQ();
        L6:
            return r5.m62copy7apg3OU(r10);
        }

        /* JADX INFO: renamed from: component1-w2LRezQ, reason: not valid java name */
        public final byte m61component1w2LRezQ() {
            return m63getValuew2LRezQ();
        }

        /* JADX INFO: renamed from: copy-7apg3OU, reason: not valid java name */
        public final UByteValue m62copy7apg3OU(byte r5) {
            return new UByteValue(r5, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof UByteValue) == true) goto L9;
            return false;
        L9:
            if (m63getValuew2LRezQ() == ((UByteValue) r5).m63getValuew2LRezQ()) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UByte getValue() {
            return UByte.m136boximpl(m63getValuew2LRezQ());
        }

        /* JADX INFO: renamed from: getValue-w2LRezQ, reason: not valid java name */
        public byte m63getValuew2LRezQ() {
            return this.value;
        }

        public int hashCode() {
            return UByte.m154hashCodeimpl(m63getValuew2LRezQ());
        }

        public String toString() {
            return "UByteValue(value=" + UByte.m186toStringimpl(m63getValuew2LRezQ()) + ')';
        }

        private UByteValue(byte r5) {
            super(null);
            this.value = r5;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R#\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$UIntValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/UInt;", "value", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1-pVg5ArA", "()I", "component1", "", "toString", "()Ljava/lang/String;", "", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "copy-WZ4Q5Ns", "(I)Ljava/lang/Object;", "copy", "I", "getValue-pVg5ArA", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @ExperimentalUnsignedTypes
    public static final class UIntValue extends LiteralValue<UInt> {
        private final int value;

        public /* synthetic */ UIntValue(int r5, DefaultConstructorMarker r10) {
            this(r5);
        }

        /* JADX INFO: renamed from: copy-WZ4Q5Ns$default, reason: not valid java name */
        public static /* synthetic */ UIntValue m64copyWZ4Q5Ns$default(UIntValue r5, int r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.m67getValuepVg5ArA();
        L6:
            return r5.m66copyWZ4Q5Ns(r10);
        }

        /* JADX INFO: renamed from: component1-pVg5ArA, reason: not valid java name */
        public final int m65component1pVg5ArA() {
            return m67getValuepVg5ArA();
        }

        /* JADX INFO: renamed from: copy-WZ4Q5Ns, reason: not valid java name */
        public final UIntValue m66copyWZ4Q5Ns(int r5) {
            return new UIntValue(r5, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof UIntValue) == true) goto L9;
            return false;
        L9:
            if (m67getValuepVg5ArA() == ((UIntValue) r5).m67getValuepVg5ArA()) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UInt getValue() {
            return UInt.m213boximpl(m67getValuepVg5ArA());
        }

        /* JADX INFO: renamed from: getValue-pVg5ArA, reason: not valid java name */
        public int m67getValuepVg5ArA() {
            return this.value;
        }

        public int hashCode() {
            return UInt.m231hashCodeimpl(m67getValuepVg5ArA());
        }

        public String toString() {
            return "UIntValue(value=" + UInt.m265toStringimpl(m67getValuepVg5ArA()) + ')';
        }

        private UIntValue(int r5) {
            super(null);
            this.value = r5;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$ULongValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/ULong;", "value", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1-s-VKNKU", "()J", "component1", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "copy-VKZWuLQ", "(J)Ljava/lang/Object;", "copy", "J", "getValue-s-VKNKU", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @ExperimentalUnsignedTypes
    public static final class ULongValue extends LiteralValue<ULong> {
        private final long value;

        public /* synthetic */ ULongValue(long r5, DefaultConstructorMarker r10) {
            this(r5);
        }

        /* JADX INFO: renamed from: copy-VKZWuLQ$default, reason: not valid java name */
        public static /* synthetic */ ULongValue m68copyVKZWuLQ$default(ULongValue r5, long r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.m71getValuesVKNKU();
        L6:
            return r5.m70copyVKZWuLQ(r10);
        }

        /* JADX INFO: renamed from: component1-s-VKNKU, reason: not valid java name */
        public final long m69component1sVKNKU() {
            return m71getValuesVKNKU();
        }

        /* JADX INFO: renamed from: copy-VKZWuLQ, reason: not valid java name */
        public final ULongValue m70copyVKZWuLQ(long r5) {
            return new ULongValue(r5, null);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ULongValue) == true) goto L9;
            return false;
        L9:
            if (m71getValuesVKNKU() == ((ULongValue) r10).m71getValuesVKNKU()) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ ULong getValue() {
            return ULong.m292boximpl(m71getValuesVKNKU());
        }

        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name */
        public long m71getValuesVKNKU() {
            return this.value;
        }

        public int hashCode() {
            return ULong.m310hashCodeimpl(m71getValuesVKNKU());
        }

        public String toString() {
            return "ULongValue(value=" + ULong.m344toStringimpl(m71getValuesVKNKU()) + ')';
        }

        private ULongValue(long r5) {
            super(null);
            this.value = r5;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$UShortValue;", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/UShort;", "value", "<init>", "(SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1-Mh2AYeg", "()S", "component1", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "copy-xj2QHRw", "(S)Ljava/lang/Object;", "copy", ExifInterface.LATITUDE_SOUTH, "getValue-Mh2AYeg", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @ExperimentalUnsignedTypes
    public static final class UShortValue extends LiteralValue<UShort> {
        private final short value;

        public /* synthetic */ UShortValue(short r5, DefaultConstructorMarker r10) {
            this(r5);
        }

        /* JADX INFO: renamed from: copy-xj2QHRw$default, reason: not valid java name */
        public static /* synthetic */ UShortValue m72copyxj2QHRw$default(UShortValue r5, short r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.m75getValueMh2AYeg();
        L6:
            return r5.m74copyxj2QHRw(r10);
        }

        /* JADX INFO: renamed from: component1-Mh2AYeg, reason: not valid java name */
        public final short m73component1Mh2AYeg() {
            return m75getValueMh2AYeg();
        }

        /* JADX INFO: renamed from: copy-xj2QHRw, reason: not valid java name */
        public final UShortValue m74copyxj2QHRw(short r5) {
            return new UShortValue(r5, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof UShortValue) == true) goto L9;
            return false;
        L9:
            if (m75getValueMh2AYeg() == ((UShortValue) r5).m75getValueMh2AYeg()) goto L11;
            return false;
        L11:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UShort getValue() {
            return UShort.m399boximpl(m75getValueMh2AYeg());
        }

        /* JADX INFO: renamed from: getValue-Mh2AYeg, reason: not valid java name */
        public short m75getValueMh2AYeg() {
            return this.value;
        }

        public int hashCode() {
            return UShort.m417hashCodeimpl(m75getValueMh2AYeg());
        }

        public String toString() {
            return "UShortValue(value=" + UShort.m449toStringimpl(m75getValueMh2AYeg()) + ')';
        }

        private UShortValue(short r5) {
            super(null);
            this.value = r5;
        }
    }

    public /* synthetic */ KmAnnotationArgument(DefaultConstructorMarker r5) {
        this();
    }

    private KmAnnotationArgument() {
    }
}
