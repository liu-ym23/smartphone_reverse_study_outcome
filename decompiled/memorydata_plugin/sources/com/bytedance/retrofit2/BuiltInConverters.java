package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit;

    static final class BufferingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final BufferingResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new BufferingResponseBodyConverter();
        }

        BufferingResponseBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(TypedInput r4) {
            TypedInput r3 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r4, TypedInput.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L5;
        L16:
            return r3;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, TypedByteArray.class) == true) goto L16;
            String r5 = r3.mimeType();
            InputStream r6 = r3.in();
            TypedByteArray r1 = new TypedByteArray(r5, Utils.streamToBytes(r6), new String[0]);     // Catch: Throwable -> L12
            if (r6 != null) goto L21;
        L11:
            return r1;
        L21:
            r6.close();     // Catch: IOException -> L17
        L12:
            th = move-exception;
            if (r6 != null) goto L19;
        L15:
            throw th;
        L19:
            r6.close();     // Catch: IOException -> L18
            goto L15
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ TypedInput convert(TypedInput r3) {
            return convert2((TypedInput) ZeusTransformUtils.preCheckCast(r3, TypedInput.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class HeaderConverter implements Converter<Header, Header> {
        static final HeaderConverter INSTANCE = null;

        static {
            INSTANCE = new HeaderConverter();
        }

        HeaderConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Header convert2(Header r1) {
            return r1;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ Header convert(Header r3) {
            return convert2((Header) ZeusTransformUtils.preCheckCast(r3, Header.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class ObjectConverter implements Converter<Object, Object> {
        static final ObjectConverter INSTANCE = null;

        static {
            INSTANCE = new ObjectConverter();
        }

        ObjectConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public Object convert(Object r1) {
            return r1;
        }
    }

    static final class RequestBodyConverter implements Converter<TypedOutput, TypedOutput> {
        static final RequestBodyConverter INSTANCE = null;

        static {
            INSTANCE = new RequestBodyConverter();
        }

        RequestBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedOutput convert2(TypedOutput r2) {
            return (TypedOutput) ZeusTransformUtils.wrapperContextForParams(r2, TypedOutput.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ TypedOutput convert(TypedOutput r3) {
            return convert2((TypedOutput) ZeusTransformUtils.preCheckCast(r3, TypedOutput.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final StreamingResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new StreamingResponseBodyConverter();
        }

        StreamingResponseBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(TypedInput r2) {
            return (TypedInput) ZeusTransformUtils.wrapperContextForParams(r2, TypedInput.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ TypedInput convert(TypedInput r3) {
            return convert2((TypedInput) ZeusTransformUtils.preCheckCast(r3, TypedInput.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class StringConverter implements Converter<String, String> {
        static final StringConverter INSTANCE = null;

        static {
            INSTANCE = new StringConverter();
        }

        StringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ String convert(String r3) {
            return convert2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(String r1) {
            return r1;
        }
    }

    static final class StringResponseBodyConverter implements Converter<TypedInput, String> {
        static final StringResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new StringResponseBodyConverter();
        }

        StringResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ String convert(TypedInput r3) {
            return convert2((TypedInput) ZeusTransformUtils.preCheckCast(r3, TypedInput.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(TypedInput r4) {
            TypedInput r3 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r4, TypedInput.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r3, TypedByteArray.class) == false) goto L9;
            String r5 = RpcUtils.CHARSET_UTF8;
            if (r3.mimeType() == null) goto L8;
            r5 = MimeUtil.parseCharset(r3.mimeType(), RpcUtils.CHARSET_UTF8);
        L8:
            return new String(((TypedByteArray) ZeusTransformUtils.preCheckCast(r3, TypedByteArray.class, "com.obric.memorydata.plugin")).getBytes(), r5);
        L9:
            return null;
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = null;

        static {
            INSTANCE = new ToStringConverter();
        }

        ToStringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(Object r1) {
            return convert2(r1);
        }

        @Override // com.bytedance.retrofit2.Converter
        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(Object r1) {
            return r1.toString();
        }
    }

    static final class UnitResponseBodyConverter implements Converter<TypedInput, Unit> {
        static final UnitResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new UnitResponseBodyConverter();
        }

        UnitResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ Unit convert(TypedInput r3) {
            return convert2((TypedInput) ZeusTransformUtils.preCheckCast(r3, TypedInput.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Unit convert2(TypedInput r2) {
            ((TypedInput) ZeusTransformUtils.wrapperContextForParams(r2, TypedInput.class, "com.obric.memorydata.plugin")).in().close();     // Catch: IOException -> L5
        L8:
            return Unit.INSTANCE;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    static final class VoidResponseBodyConverter implements Converter<TypedInput, Void> {
        static final VoidResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new VoidResponseBodyConverter();
        }

        VoidResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* synthetic */ Void convert(TypedInput r3) {
            return convert2((TypedInput) ZeusTransformUtils.preCheckCast(r3, TypedInput.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Void convert2(TypedInput r2) {
            InputStream r1 = ((TypedInput) ZeusTransformUtils.wrapperContextForParams(r2, TypedInput.class, "com.obric.memorydata.plugin")).in();
            if (r1 == null) goto L7;
            r1.close();
            return null;
        L7:
            return null;
        }
    }

    BuiltInConverters() {
        this.checkForKotlinUnit = true;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Header> headerConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin")) == Header.class) goto L5;
        return null;
    L5:
        return HeaderConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Object> objectConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin")) == Object.class) goto L5;
        return null;
    L5:
        return ObjectConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
        if (TypedOutput.class.isAssignableFrom(Utils.getRawType((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin"))) == true) goto L5;
        return null;
    L5:
        return RequestBodyConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<TypedInput, ?> responseBodyConverter(Type r2, Annotation[] r3, Retrofit r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (r5 != TypedInput.class) goto L11;
        if (Utils.isAnnotationPresent(r3, Streaming.class) == false) goto L9;
        return StreamingResponseBodyConverter.INSTANCE;
    L9:
        return BufferingResponseBodyConverter.INSTANCE;
    L11:
        if (r5 != String.class) goto L15;
        return StringResponseBodyConverter.INSTANCE;
    L15:
        if (r5 != Void.class) goto L19;
        return VoidResponseBodyConverter.INSTANCE;
    L19:
        if (this.checkForKotlinUnit == true) goto L21;
        return null;
    L21:
        if (r5 != Unit.class) goto L30;
        return UnitResponseBodyConverter.INSTANCE;
    L24:
        this.checkForKotlinUnit = false;
        return null;
    L30:
        return null;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (((Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin")) == String.class) goto L5;
        return null;
    L5:
        return StringConverter.INSTANCE;
    }
}
