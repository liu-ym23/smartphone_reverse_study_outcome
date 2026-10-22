package com.lark.wire;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Target({ElementType.FIELD})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0013BV\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000fR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0010R\u000f\u0010\u0006\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010R\u000f\u0010\u0007\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0011R\u000f\u0010\t\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\t\u0010\u0012R\u000f\u0010\u000b\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0010R\u000f\u0010\f\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010R\u000f\u0010\r\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u0010R\u000f\u0010\u000e\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/wire/WireField;", "", "tag", "", "keyAdapter", "", "adapter", "label", "Lcom/lark/wire/WireField$Label;", "redacted", "", "declaredName", "jsonName", "oneofName", "schemaIndex", "()I", "()Ljava/lang/String;", "()Lcom/lark/wire/WireField$Label;", "()Z", "Label", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
public @interface WireField {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0011\u0010\r\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/lark/wire/WireField$Label;", "", "<init>", "(Ljava/lang/String;I)V", "REQUIRED", "OPTIONAL", "REPEATED", "ONE_OF", "PACKED", "OMIT_IDENTITY", "isRepeated", "", "()Z", "isPacked", "isOneOf", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Label extends Enum<Label> {
        public static final Label OMIT_IDENTITY = null;
        public static final Label ONE_OF = null;
        public static final Label OPTIONAL = null;
        public static final Label PACKED = null;
        public static final Label REPEATED = null;
        public static final Label REQUIRED = null;
        public static final /* synthetic */ Label[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Label> getEntries() {
            return b;
        }

        static {
            Label r0 = new Label("REQUIRED", 0);
            REQUIRED = r0;
            Label r1 = new Label("OPTIONAL", 1);
            OPTIONAL = r1;
            Label r3 = new Label("REPEATED", 2);
            REPEATED = r3;
            Label r5 = new Label("ONE_OF", 3);
            ONE_OF = r5;
            Label r7 = new Label("PACKED", 4);
            PACKED = r7;
            Label r9 = new Label("OMIT_IDENTITY", 5);
            OMIT_IDENTITY = r9;
            Label[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static Label[] values() {
            return (Label[]) a.clone();
        }

        public final boolean isOneOf() {
            if (this != ONE_OF) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isPacked() {
            if (this != PACKED) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isRepeated() {
            if (this != REPEATED) goto L5;
        L8:
            return true;
        L5:
            if (this == PACKED) goto L8;
            return false;
        }

        public static Label valueOf(String r1) {
            return (Label) r27.a.a(Label.class, r1);
        }

        public Label(String r1, int r2) {
            super(r1, r2);
        }
    }

    String adapter();

    String declaredName() default "";

    String jsonName() default "";

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    String oneofName() default "";

    boolean redacted() default false;

    int schemaIndex() default -1;

    int tag();
}
