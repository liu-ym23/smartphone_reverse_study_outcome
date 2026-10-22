package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class RpcUtil {

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }

    private RpcUtil() {
    }

    static /* synthetic */ Message access$000(Message r2, Message r3) {
        return copyAsType((Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin"), (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
    }

    private static <Type extends Message> Type copyAsType(Type r2, Message r3) {
        Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r2, Message.class, "com.obric.memorydata.plugin");
        Message r5 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
        return (Type) r4.newBuilderForType().mergeFrom(r5).build();
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(RpcCallback<Type> r2, final Class<Type> r3, Type r4) {
        final RpcCallback r5 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r2, RpcCallback.class, "com.obric.memorydata.plugin");
        final Message r6 = (Message) ZeusTransformUtils.wrapperContextForParams(r4, Message.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3, r6, r5);
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(RpcCallback<ParameterType> r2) {
        final RpcCallback r3 = (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r2, RpcCallback.class, "com.obric.memorydata.plugin");
        return new AnonymousClass2(r3);
    }

    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> r2) {
        return (RpcCallback) ZeusTransformUtils.wrapperContextForParams(r2, RpcCallback.class, "com.obric.memorydata.plugin");
    }
}
