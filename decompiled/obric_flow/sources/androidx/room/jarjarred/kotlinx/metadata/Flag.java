package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\n\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u001b\b\u0010\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u000fH\u0086\u0002J\u001e\u0010\u0010\u001a\u00060\u0005j\u0002`\u000f2\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u000fH\u0080\u0002¢\u0006\u0002\b\u0011R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "", "field", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/Flags$FlagField;", "value", "", "(Lorg/jetbrains/kotlin/metadata/deserialization/Flags$FlagField;I)V", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/Flags$BooleanFlagField;", "(Lorg/jetbrains/kotlin/metadata/deserialization/Flags$BooleanFlagField;)V", "offset", "bitWidth", "(III)V", "invoke", "", "flags", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "plus", "plus$kotlinx_metadata", "Class", "Common", "Constructor", "EffectExpression", "Function", "Property", "PropertyAccessor", "Type", "TypeParameter", "ValueParameter", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Flag {
    public static final Common Common = null;

    @JvmField
    public static final Flag HAS_ANNOTATIONS = null;

    @JvmField
    public static final Flag IS_ABSTRACT = null;

    @JvmField
    public static final Flag IS_FINAL = null;

    @JvmField
    public static final Flag IS_INTERNAL = null;

    @JvmField
    public static final Flag IS_LOCAL = null;

    @JvmField
    public static final Flag IS_OPEN = null;

    @JvmField
    public static final Flag IS_PRIVATE = null;

    @JvmField
    public static final Flag IS_PRIVATE_TO_THIS = null;

    @JvmField
    public static final Flag IS_PROTECTED = null;

    @JvmField
    public static final Flag IS_PUBLIC = null;

    @JvmField
    public static final Flag IS_SEALED = null;
    private final int bitWidth;
    private final int offset;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$Class;", "", "()V", "IS_ANNOTATION_CLASS", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_CLASS", "IS_COMPANION_OBJECT", "IS_DATA", "IS_ENUM_CLASS", "IS_ENUM_ENTRY", "IS_EXPECT", "IS_EXTERNAL", "IS_FUN", "IS_INLINE", "getIS_INLINE$annotations", "IS_INNER", "IS_INTERFACE", "IS_OBJECT", "IS_VALUE", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Class {
        public static final Class INSTANCE = null;

        @JvmField
        public static final Flag IS_ANNOTATION_CLASS = null;

        @JvmField
        public static final Flag IS_CLASS = null;

        @JvmField
        public static final Flag IS_COMPANION_OBJECT = null;

        @JvmField
        public static final Flag IS_DATA = null;

        @JvmField
        public static final Flag IS_ENUM_CLASS = null;

        @JvmField
        public static final Flag IS_ENUM_ENTRY = null;

        @JvmField
        public static final Flag IS_EXPECT = null;

        @JvmField
        public static final Flag IS_EXTERNAL = null;

        @JvmField
        public static final Flag IS_FUN = null;

        @JvmField
        public static final Flag IS_INLINE = null;

        @JvmField
        public static final Flag IS_INNER = null;

        @JvmField
        public static final Flag IS_INTERFACE = null;

        @JvmField
        public static final Flag IS_OBJECT = null;

        @JvmField
        public static final Flag IS_VALUE = null;

        static {
            INSTANCE = new Class();
            Flags.FlagField<ProtoBuf.Class.Kind> r5 = Flags.CLASS_KIND;
            IS_CLASS = new Flag(r5, 0);
            IS_INTERFACE = new Flag(r5, 1);
            IS_ENUM_CLASS = new Flag(r5, 2);
            IS_ENUM_ENTRY = new Flag(r5, 3);
            IS_ANNOTATION_CLASS = new Flag(r5, 4);
            IS_OBJECT = new Flag(r5, 5);
            IS_COMPANION_OBJECT = new Flag(r5, 6);
            IS_INNER = new Flag(Flags.IS_INNER);
            IS_DATA = new Flag(Flags.IS_DATA);
            IS_EXTERNAL = new Flag(Flags.IS_EXTERNAL_CLASS);
            IS_EXPECT = new Flag(Flags.IS_EXPECT_CLASS);
            Flags.BooleanFlagField r10 = Flags.IS_VALUE_CLASS;
            IS_INLINE = new Flag(r10);
            IS_VALUE = new Flag(r10);
            IS_FUN = new Flag(Flags.IS_FUN_INTERFACE);
        }

        private Class() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use IS_VALUE instead, which returns true if the class is either a pre-1.5 inline class, or a 1.5+ value class.")
        public static /* synthetic */ void getIS_INLINE$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$Common;", "", "()V", "HAS_ANNOTATIONS", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_ABSTRACT", "IS_FINAL", "IS_INTERNAL", "IS_LOCAL", "IS_OPEN", "IS_PRIVATE", "IS_PRIVATE_TO_THIS", "IS_PROTECTED", "IS_PUBLIC", "IS_SEALED", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Common {
        public /* synthetic */ Common(DefaultConstructorMarker r5) {
            this();
        }

        private Common() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$Constructor;", "", "()V", "HAS_NON_STABLE_PARAMETER_NAMES", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_PRIMARY", "getIS_PRIMARY$annotations", "IS_SECONDARY", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Constructor {

        @JvmField
        public static final Flag HAS_NON_STABLE_PARAMETER_NAMES = null;
        public static final Constructor INSTANCE = null;

        @JvmField
        public static final Flag IS_PRIMARY = null;

        @JvmField
        public static final Flag IS_SECONDARY = null;

        static {
            INSTANCE = new Constructor();
            Flags.BooleanFlagField r5 = Flags.IS_SECONDARY;
            IS_PRIMARY = new Flag(r5, 0);
            IS_SECONDARY = new Flag(r5);
            HAS_NON_STABLE_PARAMETER_NAMES = new Flag(Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES);
        }

        private Constructor() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use IS_SECONDARY which holds inverted value instead.")
        public static /* synthetic */ void getIS_PRIMARY$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$EffectExpression;", "", "()V", "IS_NEGATED", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_NULL_CHECK_PREDICATE", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EffectExpression {
        public static final EffectExpression INSTANCE = null;

        @JvmField
        public static final Flag IS_NEGATED = null;

        @JvmField
        public static final Flag IS_NULL_CHECK_PREDICATE = null;

        static {
            INSTANCE = new EffectExpression();
            IS_NEGATED = new Flag(Flags.IS_NEGATED);
            IS_NULL_CHECK_PREDICATE = new Flag(Flags.IS_NULL_CHECK_PREDICATE);
        }

        private EffectExpression() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$Function;", "", "()V", "HAS_NON_STABLE_PARAMETER_NAMES", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_DECLARATION", "IS_DELEGATION", "IS_EXPECT", "IS_EXTERNAL", "IS_FAKE_OVERRIDE", "IS_INFIX", "IS_INLINE", "IS_OPERATOR", "IS_SUSPEND", "IS_SYNTHESIZED", "IS_TAILREC", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Function {

        @JvmField
        public static final Flag HAS_NON_STABLE_PARAMETER_NAMES = null;
        public static final Function INSTANCE = null;

        @JvmField
        public static final Flag IS_DECLARATION = null;

        @JvmField
        public static final Flag IS_DELEGATION = null;

        @JvmField
        public static final Flag IS_EXPECT = null;

        @JvmField
        public static final Flag IS_EXTERNAL = null;

        @JvmField
        public static final Flag IS_FAKE_OVERRIDE = null;

        @JvmField
        public static final Flag IS_INFIX = null;

        @JvmField
        public static final Flag IS_INLINE = null;

        @JvmField
        public static final Flag IS_OPERATOR = null;

        @JvmField
        public static final Flag IS_SUSPEND = null;

        @JvmField
        public static final Flag IS_SYNTHESIZED = null;

        @JvmField
        public static final Flag IS_TAILREC = null;

        static {
            INSTANCE = new Function();
            Flags.FlagField<ProtoBuf.MemberKind> r5 = Flags.MEMBER_KIND;
            IS_DECLARATION = new Flag(r5, 0);
            IS_FAKE_OVERRIDE = new Flag(r5, 1);
            IS_DELEGATION = new Flag(r5, 2);
            IS_SYNTHESIZED = new Flag(r5, 3);
            IS_OPERATOR = new Flag(Flags.IS_OPERATOR);
            IS_INFIX = new Flag(Flags.IS_INFIX);
            IS_INLINE = new Flag(Flags.IS_INLINE);
            IS_TAILREC = new Flag(Flags.IS_TAILREC);
            IS_EXTERNAL = new Flag(Flags.IS_EXTERNAL_FUNCTION);
            IS_SUSPEND = new Flag(Flags.IS_SUSPEND);
            IS_EXPECT = new Flag(Flags.IS_EXPECT_FUNCTION);
            HAS_NON_STABLE_PARAMETER_NAMES = new Flag(Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES);
        }

        private Function() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$Property;", "", "()V", "HAS_CONSTANT", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "HAS_GETTER", "HAS_SETTER", "IS_CONST", "IS_DECLARATION", "IS_DELEGATED", "IS_DELEGATION", "IS_EXPECT", "IS_EXTERNAL", "IS_FAKE_OVERRIDE", "IS_LATEINIT", "IS_SYNTHESIZED", "IS_VAR", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Property {

        @JvmField
        public static final Flag HAS_CONSTANT = null;

        @JvmField
        public static final Flag HAS_GETTER = null;

        @JvmField
        public static final Flag HAS_SETTER = null;
        public static final Property INSTANCE = null;

        @JvmField
        public static final Flag IS_CONST = null;

        @JvmField
        public static final Flag IS_DECLARATION = null;

        @JvmField
        public static final Flag IS_DELEGATED = null;

        @JvmField
        public static final Flag IS_DELEGATION = null;

        @JvmField
        public static final Flag IS_EXPECT = null;

        @JvmField
        public static final Flag IS_EXTERNAL = null;

        @JvmField
        public static final Flag IS_FAKE_OVERRIDE = null;

        @JvmField
        public static final Flag IS_LATEINIT = null;

        @JvmField
        public static final Flag IS_SYNTHESIZED = null;

        @JvmField
        public static final Flag IS_VAR = null;

        static {
            INSTANCE = new Property();
            Flags.FlagField<ProtoBuf.MemberKind> r5 = Flags.MEMBER_KIND;
            IS_DECLARATION = new Flag(r5, 0);
            IS_FAKE_OVERRIDE = new Flag(r5, 1);
            IS_DELEGATION = new Flag(r5, 2);
            IS_SYNTHESIZED = new Flag(r5, 3);
            IS_VAR = new Flag(Flags.IS_VAR);
            HAS_GETTER = new Flag(Flags.HAS_GETTER);
            HAS_SETTER = new Flag(Flags.HAS_SETTER);
            IS_CONST = new Flag(Flags.IS_CONST);
            IS_LATEINIT = new Flag(Flags.IS_LATEINIT);
            HAS_CONSTANT = new Flag(Flags.HAS_CONSTANT);
            IS_EXTERNAL = new Flag(Flags.IS_EXTERNAL_PROPERTY);
            IS_DELEGATED = new Flag(Flags.IS_DELEGATED);
            IS_EXPECT = new Flag(Flags.IS_EXPECT_PROPERTY);
        }

        private Property() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$PropertyAccessor;", "", "()V", "IS_EXTERNAL", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_INLINE", "IS_NOT_DEFAULT", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PropertyAccessor {
        public static final PropertyAccessor INSTANCE = null;

        @JvmField
        public static final Flag IS_EXTERNAL = null;

        @JvmField
        public static final Flag IS_INLINE = null;

        @JvmField
        public static final Flag IS_NOT_DEFAULT = null;

        static {
            INSTANCE = new PropertyAccessor();
            IS_NOT_DEFAULT = new Flag(Flags.IS_NOT_DEFAULT);
            IS_EXTERNAL = new Flag(Flags.IS_EXTERNAL_ACCESSOR);
            IS_INLINE = new Flag(Flags.IS_INLINE_ACCESSOR);
        }

        private PropertyAccessor() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$Type;", "", "()V", "IS_DEFINITELY_NON_NULL", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_NULLABLE", "IS_SUSPEND", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Type {
        public static final Type INSTANCE = null;

        @JvmField
        public static final Flag IS_DEFINITELY_NON_NULL = null;

        @JvmField
        public static final Flag IS_NULLABLE = null;

        @JvmField
        public static final Flag IS_SUSPEND = null;

        static {
            INSTANCE = new Type();
            IS_NULLABLE = new Flag(0, 1, 1);
            Flags.BooleanFlagField r5 = Flags.SUSPEND_TYPE;
            IS_SUSPEND = new Flag(r5.offset + 1, r5.bitWidth, 1);
            Flags.BooleanFlagField r10 = Flags.DEFINITELY_NOT_NULL_TYPE;
            IS_DEFINITELY_NON_NULL = new Flag(r10.offset + 1, r10.bitWidth, 1);
        }

        private Type() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$TypeParameter;", "", "()V", "IS_REIFIED", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class TypeParameter {
        public static final TypeParameter INSTANCE = null;

        @JvmField
        public static final Flag IS_REIFIED = null;

        static {
            INSTANCE = new TypeParameter();
            IS_REIFIED = new Flag(0, 1, 1);
        }

        private TypeParameter() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/Flag$ValueParameter;", "", "()V", "DECLARES_DEFAULT_VALUE", "Landroidx/room/jarjarred/kotlinx/metadata/Flag;", "IS_CROSSINLINE", "IS_NOINLINE", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ValueParameter {

        @JvmField
        public static final Flag DECLARES_DEFAULT_VALUE = null;
        public static final ValueParameter INSTANCE = null;

        @JvmField
        public static final Flag IS_CROSSINLINE = null;

        @JvmField
        public static final Flag IS_NOINLINE = null;

        static {
            INSTANCE = new ValueParameter();
            DECLARES_DEFAULT_VALUE = new Flag(Flags.DECLARES_DEFAULT_VALUE);
            IS_CROSSINLINE = new Flag(Flags.IS_CROSSINLINE);
            IS_NOINLINE = new Flag(Flags.IS_NOINLINE);
        }

        private ValueParameter() {
        }
    }

    static {
        Common = new Common(null);
        HAS_ANNOTATIONS = new Flag(Flags.HAS_ANNOTATIONS);
        Flags.FlagField<ProtoBuf.Visibility> r5 = Flags.VISIBILITY;
        IS_INTERNAL = new Flag(r5, 0);
        IS_PRIVATE = new Flag(r5, 1);
        IS_PROTECTED = new Flag(r5, 2);
        IS_PUBLIC = new Flag(r5, 3);
        IS_PRIVATE_TO_THIS = new Flag(r5, 4);
        IS_LOCAL = new Flag(r5, 5);
        Flags.FlagField<ProtoBuf.Modality> r10 = Flags.MODALITY;
        IS_FINAL = new Flag(r10, 0);
        IS_OPEN = new Flag(r10, 1);
        IS_ABSTRACT = new Flag(r10, 2);
        IS_SEALED = new Flag(r10, 3);
    }

    public Flag(int r5, int r10, int r11) {
        this.offset = r5;
        this.bitWidth = r10;
        this.value = r11;
    }

    public final boolean invoke(int r5) {
        if (((r5 >>> this.offset) & ((1 << this.bitWidth) - 1)) == this.value) goto L7;
        return false;
    L7:
        return true;
    }

    public final int plus$kotlinx_metadata(int r5) {
        int r10 = (1 << this.bitWidth) - 1;
        int r11 = this.offset;
        return (r5 & (~(r10 << r11))) + (this.value << r11);
    }

    public Flag(Flags.FlagField<?> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "field");
        this(r5.offset, r5.bitWidth, r10);
    }

    public Flag(Flags.BooleanFlagField r5) {
        Intrinsics.checkNotNullParameter(r5, "field");
        this(r5, 1);
    }
}
