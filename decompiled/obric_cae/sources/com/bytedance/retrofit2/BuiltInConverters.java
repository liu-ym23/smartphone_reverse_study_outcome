package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class BuiltInConverters extends Converter.Factory {

    public static final class BufferingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final BufferingResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new BufferingResponseBodyConverter();
        }

        public BufferingResponseBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(TypedInput r8) {
            if (r8 != null) goto L4;
        L15:
            return r8;
        L4:
            if ((r8 instanceof TypedByteArray) == true) goto L15;
            String r10 = r8.mimeType();
            InputStream r11 = r8.in();
            TypedByteArray r12 = new TypedByteArray(r10, Utils.streamToBytes(r11), new String[0]);     // Catch: Throwable -> L11
            if (r11 != null) goto L22;
        L10:
            return r12;
        L22:
            r11.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            if (r11 != null) goto L20;
        L14:
            throw th;
        L20:
            r11.close();     // Catch: IOException -> L17
            goto L14
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedInput convert(TypedInput r8) {
            return convert2(r8);
        }
    }

    public static final class HeaderConverter implements Converter<Header, Header> {
        static final HeaderConverter INSTANCE = null;

        static {
            INSTANCE = new HeaderConverter();
        }

        public HeaderConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Header convert2(Header r8) {
            return r8;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Header convert(Header r8) {
            return convert2(r8);
        }
    }

    public static final class ObjectConverter implements Converter<Object, Object> {
        static final ObjectConverter INSTANCE = null;

        static {
            INSTANCE = new ObjectConverter();
        }

        public ObjectConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public Object convert(Object r8) {
            return r8;
        }
    }

    public static final class RequestBodyConverter implements Converter<TypedOutput, TypedOutput> {
        static final RequestBodyConverter INSTANCE = null;

        static {
            INSTANCE = new RequestBodyConverter();
        }

        public RequestBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedOutput convert2(TypedOutput r8) {
            return r8;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedOutput convert(TypedOutput r8) {
            return convert2(r8);
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<TypedInput, TypedInput> {
        static final StreamingResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new StreamingResponseBodyConverter();
        }

        public StreamingResponseBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public TypedInput convert2(TypedInput r8) {
            return r8;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ TypedInput convert(TypedInput r8) {
            return convert2(r8);
        }
    }

    public static final class StringConverter implements Converter<String, String> {
        static final StringConverter INSTANCE = null;

        static {
            INSTANCE = new StringConverter();
        }

        public StringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(String r8) {
            return convert2(r8);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(String r8) {
            return r8;
        }
    }

    public static final class StringResponseBodyConverter implements Converter<TypedInput, String> {
        static final StringResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new StringResponseBodyConverter();
        }

        public StringResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(TypedInput r8) {
            return convert2(r8);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(TypedInput r8) {
            if ((r8 instanceof TypedByteArray) == false) goto L9;
            String r10 = "UTF-8";
            if (r8.mimeType() == null) goto L8;
            r10 = MimeUtil.parseCharset(r8.mimeType(), "UTF-8");
        L8:
            return new String(((TypedByteArray) r8).getBytes(), r10);
        L9:
            return null;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = null;

        static {
            INSTANCE = new ToStringConverter();
        }

        public ToStringConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(Object r8) {
            return convert2(r8);
        }

        @Override // com.bytedance.retrofit2.Converter
        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(Object r8) {
            return String.valueOf(r8);
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<TypedInput, Void> {
        static final VoidResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new VoidResponseBodyConverter();
        }

        public VoidResponseBodyConverter() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Void convert(TypedInput r8) {
            return convert2(r8);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Void convert2(TypedInput r8) {
            InputStream r10 = r8.in();
            if (r10 == null) goto L7;
            r10.close();
            return null;
        L7:
            return null;
        }
    }

    public BuiltInConverters() {
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Header> headerConverter(Type r8, Annotation[] r10, Retrofit r11) {
        if (r8 == Header.class) goto L5;
        return null;
    L5:
        return HeaderConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, Object> objectConverter(Type r8, Annotation[] r10, Retrofit r11) {
        if (r8 == Object.class) goto L5;
        return null;
    L5:
        return ObjectConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, TypedOutput> requestBodyConverter(Type r8, Annotation[] r10, Annotation[] r11, Retrofit r12) {
        if (TypedOutput.class.isAssignableFrom(Utils.getRawType(r8)) == true) goto L5;
        return null;
    L5:
        return RequestBodyConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<TypedInput, ?> responseBodyConverter(Type r8, Annotation[] r10, Retrofit r11) {
        if (r8 != TypedInput.class) goto L11;
        if (Utils.isAnnotationPresent(r10, Streaming.class) == false) goto L9;
        return StreamingResponseBodyConverter.INSTANCE;
    L9:
        return BufferingResponseBodyConverter.INSTANCE;
    L11:
        if (r8 != String.class) goto L15;
        return StringResponseBodyConverter.INSTANCE;
    L15:
        if (r8 == Void.class) goto L17;
        return null;
    L17:
        return VoidResponseBodyConverter.INSTANCE;
    }

    @Override // com.bytedance.retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type r8, Annotation[] r10, Retrofit r11) {
        if (r8 == String.class) goto L5;
        return null;
    L5:
        return StringConverter.INSTANCE;
    }
}
