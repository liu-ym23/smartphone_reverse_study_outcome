package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
public final class RpcUtil {

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }

    private RpcUtil() {
    }

    public static /* synthetic */ Message access$000(Message r8, Message r10) {
        return copyAsType(r8, r10);
    }

    private static <Type extends Message> Type copyAsType(Type r8, Message r10) {
        return (Type) r8.newBuilderForType().mergeFrom(r10).build();
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> r8, final Class<Type> r10, final Type r11) {
        return new AnonymousClass1(r10, r11, r8);
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> r8) {
        return new AnonymousClass2(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> r8) {
        return r8;
    }
}
