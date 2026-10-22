package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Deprecated(message = "Replaced by the androidx.resourceinpsection package.")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface InspectableProperty {

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface EnumEntry {
        String name();

        int value();
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    public static final enum ValueType extends Enum<ValueType> {
        private static final /* synthetic */ ValueType[] $VALUES = null;
        public static final ValueType COLOR = null;
        public static final ValueType GRAVITY = null;
        public static final ValueType INFERRED = null;
        public static final ValueType INT_ENUM = null;
        public static final ValueType INT_FLAG = null;
        public static final ValueType NONE = null;
        public static final ValueType RESOURCE_ID = null;

        private static final /* synthetic */ ValueType[] $values() {
            return new ValueType[]{NONE, INFERRED, INT_ENUM, INT_FLAG, COLOR, GRAVITY, RESOURCE_ID};
        }

        static {
            NONE = new ValueType("NONE", 0);
            INFERRED = new ValueType("INFERRED", 1);
            INT_ENUM = new ValueType("INT_ENUM", 2);
            INT_FLAG = new ValueType("INT_FLAG", 3);
            COLOR = new ValueType("COLOR", 4);
            GRAVITY = new ValueType("GRAVITY", 5);
            RESOURCE_ID = new ValueType("RESOURCE_ID", 6);
            $VALUES = $values();
        }

        private ValueType(String r10, int r11) {
            super(r10, r11);
        }

        public static ValueType valueOf(String r10) {
            return (ValueType) Enum.valueOf(ValueType.class, r10);
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
