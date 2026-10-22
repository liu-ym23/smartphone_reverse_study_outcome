package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface Caller<M extends Member> {

    public static final class DefaultImpls {
        public static <M extends Member> void checkArguments(Caller<? extends M> r10, Object[] r11) {
            Intrinsics.checkNotNullParameter(r11, "args");
            if (CallerKt.getArity(r10) != r11.length) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("Callable expects " + CallerKt.getArity(r10) + " arguments, but " + r11.length + " were provided.");
        }
    }

    Object call(Object[] r10);

    /* JADX INFO: renamed from: getMember */
    M mo1315getMember();

    List<Type> getParameterTypes();

    Type getReturnType();
}
