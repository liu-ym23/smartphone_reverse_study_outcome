package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public interface Check {

    public static final class DefaultImpls {
        public static String invoke(Check r5, FunctionDescriptor r10) {
            Intrinsics.checkNotNullParameter(r10, "functionDescriptor");
            if (r5.check(r10) == false) goto L7;
            return null;
        L7:
            return r5.getDescription();
        }
    }

    boolean check(FunctionDescriptor r5);

    String getDescription();

    String invoke(FunctionDescriptor r5);
}
