package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes.dex */
@Target({})
@kotlin.annotation.Target(allowedTargets = {})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface Index {

    public static final enum Order extends Enum<Order> {
        private static final /* synthetic */ Order[] $VALUES = null;
        public static final Order ASC = null;
        public static final Order DESC = null;

        private static final /* synthetic */ Order[] $values() {
            return new Order[]{ASC, DESC};
        }

        static {
            ASC = new Order("ASC", 0);
            DESC = new Order("DESC", 1);
            $VALUES = $values();
        }

        private Order(String r10, int r11) {
            super(r10, r11);
        }

        public static Order valueOf(String r10) {
            return (Order) Enum.valueOf(Order.class, r10);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }
    }

    String name() default "";

    Order[] orders() default {};

    boolean unique() default false;

    String[] value();
}
