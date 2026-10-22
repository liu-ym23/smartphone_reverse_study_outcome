package kotlin.reflect;

import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes3.dex */
public interface KProperty<V> extends KCallable<V> {

    public interface Accessor<V> {
        KProperty<V> getProperty();
    }

    public static final class DefaultImpls {
        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isConst$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void isLateinit$annotations() {
        }
    }

    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    Getter<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
