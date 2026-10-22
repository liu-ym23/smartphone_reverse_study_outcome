package com.bytedance.retrofit2;

import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
abstract class ParameterHandler<T> {

    static final class AddCommonParam<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        AddCommonParam(Converter<T, String> r3) {
            this.converter = (Converter) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.memorydata.plugin"), "converter == null"), Converter.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.setAddCommonParam(Boolean.parseBoolean((String) ZeusTransformUtils.preCheckCast(this.converter.convert(r4), String.class, "com.obric.memorydata.plugin")));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to AddCommonParam", e);
        }
    }

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final boolean isCustomMethod;
        private final java.lang.reflect.Method method;
        private final int p;

        Body(java.lang.reflect.Method r3, int r4, boolean r5, Converter<T, TypedOutput> r6) {
            Converter<T, TypedOutput> r7 = (Converter) ZeusTransformUtils.wrapperContextForParams(r6, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.isCustomMethod = r5;
            this.converter = r7;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r5, T r6) {
            if (r6 == null) goto L5;
        L18:
            e = move-exception;
            throw Utils.parameterError(this.method, e, this.p, "Unable to convert " + r6 + " to RequestBody", new Object[0]);
        L11:
            if (this.converter.needRequestBuilder() == false) goto L14;
            Object r1 = ZeusTransformUtils.preCheckCast(this.converter.convertWithRequestBuilder(r6, r5), TypedOutput.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L18
        L13:
            r5.setBody((TypedOutput) r1);
            return;
        L14:
            r1 = ZeusTransformUtils.preCheckCast(this.converter.convert(r6), TypedOutput.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L18
            goto L13
        L5:
            if (this.isCustomMethod == false) goto L8;
            return;
        L8:
            throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
        }
    }

    static final class ConverterBody extends ParameterHandler<RequestBody> {
        static final ConverterBody INSTANCE = null;

        static {
            INSTANCE = new ConverterBody();
        }

        ConverterBody() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, RequestBody r4) {
            apply2(r3, (RequestBody) ZeusTransformUtils.preCheckCast(r4, RequestBody.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r1, RequestBody r2) {
            if (r2 == null) goto L6;
            r1.setBody(r2);
            r1.useRequestBody();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    static final class ConverterPart extends ParameterHandler<RequestBody> {
        private final Headers headers;

        ConverterPart(Headers r1) {
            this.headers = r1;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, RequestBody r4) {
            apply2(r3, (RequestBody) ZeusTransformUtils.preCheckCast(r4, RequestBody.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r1, RequestBody r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            r1.addPart(this.headers, r2);
            r1.useRequestBody();
        }
    }

    static final class ConverterPartMap extends ParameterHandler<Map<String, RequestBody>> {
        private final String transferEncoding;

        ConverterPartMap(String r1) {
            this.transferEncoding = r1;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, Map<String, RequestBody> r4) {
            apply2(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r8, Map<String, RequestBody> r9) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L19;
            Iterator r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L16;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L15;
            RequestBody r1 = (RequestBody) ZeusTransformUtils.preCheckCast(r0.getValue(), RequestBody.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L13;
            r8.addPart(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r2 + "\"", "Content-Transfer-Encoding", this.transferEncoding}), r1);
            goto L6
        L13:
            throw new IllegalArgumentException("Part map contained null value for key '" + r2 + "'.");
        L15:
            throw new IllegalArgumentException("Part map contained null key.");
        L16:
            r8.useRequestBody();
            return;
        L19:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    static final class ConverterRawPart extends ParameterHandler<MultipartBody.Part> {
        static final ConverterRawPart INSTANCE = null;

        static {
            INSTANCE = new ConverterRawPart();
        }

        ConverterRawPart() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, MultipartBody.Part r4) {
            apply2(r3, (MultipartBody.Part) ZeusTransformUtils.preCheckCast(r4, MultipartBody.Part.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        void apply2(RequestBuilder r1, MultipartBody.Part r2) {
            if (r2 == null) goto L4;
            r1.addPart(r2);
        L4:
            r1.useRequestBody();
        }
    }

    static final class ExtraInfo<T> extends ParameterHandler<T> {
        private final Converter<T, Object> converter;

        ExtraInfo(Converter<T, Object> r3) {
            this.converter = (Converter) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.memorydata.plugin"), "converter == null"), Converter.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.setExtraInfo(this.converter.convert(r4));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to ExtraInfo", e);
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        Field(String r3, Converter<T, String> r4, boolean r5) {
            Converter<T, String> r6 = (Converter) ZeusTransformUtils.wrapperContextForParams(r4, Converter.class, "com.obric.memorydata.plugin");
            this.name = (String) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r3, "name == null"), String.class, "com.obric.memorydata.plugin");
            this.valueConverter = r6;
            this.encode = r5;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert(r4), String.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L7;
            return;
        L7:
            r3.addFormField(this.name, r5, this.encode);
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        FieldMap(java.lang.reflect.Method r3, int r4, Converter<T, String> r5, boolean r6) {
            Converter<T, String> r7 = (Converter) ZeusTransformUtils.wrapperContextForParams(r5, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.valueConverter = r7;
            this.encode = r6;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, Object r4) {
            apply(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        void apply(RequestBuilder r8, Map<String, T> r9) {
            Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L22;
            Iterator r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L20;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L19;
            Object r4 = r2.getValue();
            if (r4 == null) goto L17;
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert((T) r4), String.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L15;
            r8.addFormField(r3, r5, this.encode);
            goto L6
        L15:
            throw Utils.parameterError(this.method, this.p, "Field map value '" + r4 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r3 + "'.", new Object[0]);
        L17:
            throw Utils.parameterError(this.method, this.p, "Field map contained null value for key '" + r3 + "'.", new Object[0]);
        L19:
            throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
        L20:
            return;
        L22:
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Header(String r3, Converter<T, String> r4) {
            Converter<T, String> r5 = (Converter) ZeusTransformUtils.wrapperContextForParams(r4, Converter.class, "com.obric.memorydata.plugin");
            this.name = (String) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r3, "name == null"), String.class, "com.obric.memorydata.plugin");
            this.valueConverter = r5;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert(r4), String.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L7;
            return;
        L7:
            r3.addHeader(this.name, r5);
        }
    }

    static final class HeaderList<T> extends ParameterHandler<List<T>> {
        private final Converter<T, com.bytedance.retrofit2.client.Header> valueConverter;

        HeaderList(Converter<T, com.bytedance.retrofit2.client.Header> r3) {
            this.valueConverter = (Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, Object r4) {
            apply(r3, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"));
        }

        void apply(RequestBuilder r4, List<T> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            return;
        L5:
            Iterator r7 = r6.iterator();
        L7:
            if (r7.hasNext() == false) goto L9;
            Object r0 = r7.next();
            com.bytedance.retrofit2.client.Header r1 = (com.bytedance.retrofit2.client.Header) ZeusTransformUtils.preCheckCast(this.valueConverter.convert((T) r0), com.bytedance.retrofit2.client.Header.class, "com.obric.memorydata.plugin");
            r4.addHeader(r1.getName(), r1.getValue());
            goto L7
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        HeaderMap(java.lang.reflect.Method r3, int r4, Converter<T, String> r5) {
            Converter<T, String> r6 = (Converter) ZeusTransformUtils.wrapperContextForParams(r5, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.valueConverter = r6;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, Object r4) {
            apply(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        void apply(RequestBuilder r6, Map<String, T> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L18;
            Iterator r9 = r8.entrySet().iterator();
        L6:
            if (r9.hasNext() == false) goto L16;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L15;
            Object r4 = r2.getValue();
            if (r4 == null) goto L13;
            r6.addHeader(r3, (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert((T) r4), String.class, "com.obric.memorydata.plugin"));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.p, "Header map contained null value for key '" + r3 + "'.", new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
        }
    }

    static final class MaxLength<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        MaxLength(Converter<T, String> r3) {
            this.converter = (Converter) ZeusTransformUtils.preCheckCast(Utils.checkNotNull((Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.memorydata.plugin"), "converter == null"), Converter.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L9;
            return;
        L9:
            r3.setMaxLength(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(this.converter.convert(r4), String.class, "com.obric.memorydata.plugin")));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r4 + " to MaxLength", e);
        }
    }

    static final class Method<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        Method(String r3, Converter<T, String> r4) {
            Converter<T, String> r5 = (Converter) ZeusTransformUtils.wrapperContextForParams(r4, Converter.class, "com.obric.memorydata.plugin");
            this.name = (String) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r3, "name == null"), String.class, "com.obric.memorydata.plugin");
            this.valueConverter = r5;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 == null) goto L6;
            r3.setMethod(this.name, (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert(r4), String.class, "com.obric.memorydata.plugin"));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.name + "\" value must not be null.");
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final java.lang.reflect.Method method;
        private final String name;
        private final int p;

        Part(java.lang.reflect.Method r3, int r4, String r5, Converter<T, TypedOutput> r6) {
            Converter<T, TypedOutput> r7 = (Converter) ZeusTransformUtils.wrapperContextForParams(r6, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.name = r5;
            this.converter = r7;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r4, T r5) {
            if (r5 != null) goto L10;
            return;
        L10:
            r4.addPart(this.name, (TypedOutput) ZeusTransformUtils.preCheckCast(this.converter.convert(r5), TypedOutput.class, "com.obric.memorydata.plugin"));
            return;
        L7:
            e = move-exception;
            throw Utils.parameterError(this.method, this.p, "Unable to convert " + r5 + " to RequestBody", new Object[]{e});
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final java.lang.reflect.Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter<T, TypedOutput> valueConverter;

        PartMap(java.lang.reflect.Method r3, int r4, Converter<T, TypedOutput> r5, String r6) {
            Converter<T, TypedOutput> r7 = (Converter) ZeusTransformUtils.wrapperContextForParams(r5, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.valueConverter = r7;
            this.transferEncoding = r6;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, Object r4) {
            apply(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        void apply(RequestBuilder r7, Map<String, T> r8) {
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            if (r9 == null) goto L18;
            Iterator r10 = r9.entrySet().iterator();
        L6:
            if (r10.hasNext() == false) goto L16;
            Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L15;
            Object r4 = r2.getValue();
            if (r4 == null) goto L13;
            r7.addPart(r3, this.transferEncoding, (TypedOutput) ZeusTransformUtils.preCheckCast(this.valueConverter.convert((T) r4), TypedOutput.class, "com.obric.memorydata.plugin"));
            goto L6
        L13:
            throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + r3 + "'.", new Object[0]);
        L15:
            throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
        L16:
            return;
        L18:
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final String name;
        private final int p;
        private final Converter<T, String> valueConverter;

        Path(java.lang.reflect.Method r3, int r4, String r5, Converter<T, String> r6, boolean r7) {
            Converter<T, String> r8 = (Converter) ZeusTransformUtils.wrapperContextForParams(r6, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.name = (String) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r5, "name == null"), String.class, "com.obric.memorydata.plugin");
            this.valueConverter = r8;
            this.encode = r7;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r4, T r5) {
            if (r5 == null) goto L6;
            r4.addPathParam(this.name, (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert(r5), String.class, "com.obric.memorydata.plugin"), this.encode);
            return;
        L6:
            throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        Query(String r3, Converter<T, String> r4, boolean r5) {
            Converter<T, String> r6 = (Converter) ZeusTransformUtils.wrapperContextForParams(r4, Converter.class, "com.obric.memorydata.plugin");
            this.name = (String) ZeusTransformUtils.preCheckCast(Utils.checkNotNull(r3, "name == null"), String.class, "com.obric.memorydata.plugin");
            this.valueConverter = r6;
            this.encode = r5;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert(r4), String.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L7;
            return;
        L7:
            r3.addQueryParam(this.name, r5, this.encode);
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final java.lang.reflect.Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        QueryMap(java.lang.reflect.Method r3, int r4, Converter<T, String> r5, boolean r6) {
            Converter<T, String> r7 = (Converter) ZeusTransformUtils.wrapperContextForParams(r5, Converter.class, "com.obric.memorydata.plugin");
            this.method = r3;
            this.p = r4;
            this.valueConverter = r7;
            this.encode = r6;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        /* synthetic */ void apply(RequestBuilder r3, Object r4) {
            apply(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"));
        }

        void apply(RequestBuilder r7, Map<String, T> r8) {
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L5;
            return;
        L5:
            Iterator r10 = r9.entrySet().iterator();
        L7:
            if (r10.hasNext() == false) goto L20;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L19;
            Object r1 = r0.getValue();
            if (r1 == null) goto L7;
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.valueConverter.convert((T) r1), String.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L17;
            r7.addQueryParam(r2, r4, this.encode);
            goto L7
        L17:
            throw Utils.parameterError(this.method, this.p, "Query map value '" + r1 + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + r2 + "'.", new Object[0]);
        L19:
            throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        QueryName(Converter<T, String> r3, boolean r4) {
            this.nameConverter = (Converter) ZeusTransformUtils.wrapperContextForParams(r3, Converter.class, "com.obric.memorydata.plugin");
            this.encoded = r4;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r3, T r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            r3.addQueryParam((String) ZeusTransformUtils.preCheckCast(this.nameConverter.convert(r4), String.class, "com.obric.memorydata.plugin"), null, this.encoded);
        }
    }

    static final class QueryObject<T> extends ParameterHandler<T> {
        QueryObject() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r2, T r3) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, QueryParamObject.class) == false) goto L9;
            r2.setQueryObjectParams(((QueryParamObject) ZeusTransformUtils.preCheckCast(r3, QueryParamObject.class, "com.obric.memorydata.plugin")).toQuery());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r3.getClass() + ",not implement QueryParamObject");
        }
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        private final java.lang.reflect.Method method;
        private final int p;

        RelativeUrl(java.lang.reflect.Method r1, int r2) {
            this.method = r1;
            this.p = r2;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r1, Object r2) {
            r1.setRelativeUrl(r2);
        }
    }

    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        Tag(Class<T> r1) {
            this.cls = r1;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        void apply(RequestBuilder r1, T r2) {
            r1.addTag(this.cls, r2);
        }
    }

    ParameterHandler() {
    }

    abstract void apply(RequestBuilder r1, T r2);

    final ParameterHandler<Object> array() {
        return new AnonymousClass2(this);
    }

    final ParameterHandler<Iterable<T>> iterable() {
        return new AnonymousClass1(this);
    }
}
