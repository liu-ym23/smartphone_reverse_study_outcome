package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface Check {

    public static final class DefaultImpls {
        public static String invoke(Check r10, FunctionDescriptor r11) {
            Intrinsics.checkNotNullParameter(r11, "functionDescriptor");
            if (r10.check(r11) == false) goto L7;
            return null;
        L7:
            return r10.getDescription();
        }
    }

    boolean check(FunctionDescriptor r10);

    String getDescription();

    String invoke(FunctionDescriptor r10);
}
