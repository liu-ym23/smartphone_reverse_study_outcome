package luc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@ExperimentalSerializationApi
public abstract class o {

    @ExperimentalSerializationApi
    public static final class a extends o {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    @ExperimentalSerializationApi
    public static final class b extends o {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public o() {
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
