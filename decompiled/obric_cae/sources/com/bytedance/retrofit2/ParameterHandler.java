package com.bytedance.retrofit2;

import android.aimedia.a;
import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedOutput;
import defpackage.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import we.q;
import we.u;
import we.z;

/* JADX INFO: loaded from: classes.dex */
abstract class ParameterHandler<T> {

    public static final class AddCommonParam<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        public AddCommonParam(Converter<T, String> r8) {
            this.converter = (Converter) Utils.checkNotNull(r8, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L9;
            return;
        L9:
            r8.setAddCommonParam(Boolean.parseBoolean(this.converter.convert(r10)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r10 + " to AddCommonParam", e);
        }
    }

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final boolean isCustomMethod;

        public Body(boolean r8, Converter<T, TypedOutput> r10) {
            this.isCustomMethod = r8;
            this.converter = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 == null) goto L4;
            r8.setBody(this.converter.convert(r10));
            return;
        L11:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r10 + " to TypedOutput", e);
        L4:
            if (this.isCustomMethod == false) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class ConverterBody extends ParameterHandler<z> {
        static final ConverterBody INSTANCE = null;

        static {
            INSTANCE = new ConverterBody();
        }

        public ConverterBody() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, z r10) {
            apply2(r8, r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r8, z r10) {
            if (r10 == null) goto L6;
            r8.setBody(r10);
            r8.useRequestBody();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class ConverterPart extends ParameterHandler<z> {
        private final q headers;

        public ConverterPart(q r8) {
            this.headers = r8;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, z r10) {
            apply2(r8, r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r8, z r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r8.addPart(this.headers, r10);
            r8.useRequestBody();
        }
    }

    public static final class ConverterPartMap extends ParameterHandler<Map<String, z>> {
        private final String transferEncoding;

        public ConverterPartMap(String r8) {
            this.transferEncoding = r8;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, Map<String, z> r10) {
            apply2(r8, r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r8, Map<String, z> r10) {
            if (r10 == null) goto L18;
            Iterator<Map.Entry<String, z>> r11 = r10.entrySet().iterator();
        L5:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, z> r12 = r11.next();
            String r13 = r12.getKey();
            if (r13 == null) goto L14;
            z r14 = r12.getValue();
            if (r14 == null) goto L12;
            r8.addPart(q.h(new String[]{"Content-Disposition", b.d("form-data; name=\"", r13, "\""), "Content-Transfer-Encoding", this.transferEncoding}), r14);
            goto L5
        L12:
            throw new IllegalArgumentException(b.d("Part map contained null value for key '", r13, "'."));
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            r8.useRequestBody();
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    public static final class ConverterRawPart extends ParameterHandler<u.b> {
        static final ConverterRawPart INSTANCE = null;

        static {
            INSTANCE = new ConverterRawPart();
        }

        public ConverterRawPart() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, u.b r10) {
            apply2(r8, r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public void apply2(RequestBuilder r8, u.b r10) {
            if (r10 == null) goto L4;
            r8.addPart(r10);
        L4:
            r8.useRequestBody();
        }
    }

    public static final class ExtraInfo<T> extends ParameterHandler<T> {
        private final Converter<T, Object> converter;

        public ExtraInfo(Converter<T, Object> r8) {
            this.converter = (Converter) Utils.checkNotNull(r8, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L9;
            return;
        L9:
            r8.setExtraInfo(this.converter.convert(r10));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r10 + " to ExtraInfo", e);
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String r8, Converter<T, String> r10, boolean r11) {
            this.name = (String) Utils.checkNotNull(r8, "name == null");
            this.valueConverter = r10;
            this.encode = r11;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r8.addFormField(this.name, this.valueConverter.convert(r10), this.encode);
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final Converter<T, String> valueConverter;

        public FieldMap(Converter<T, String> r8, boolean r10) {
            this.valueConverter = r8;
            this.encode = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, Object r10) {
            apply(r8, (Map) r10);
        }

        public void apply(RequestBuilder r8, Map<String, T> r10) {
            if (r10 == null) goto L17;
            Iterator<Map.Entry<String, T>> r11 = r10.entrySet().iterator();
        L5:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, T> r12 = r11.next();
            String r13 = r12.getKey();
            if (r13 == null) goto L14;
            T r14 = r12.getValue();
            if (r14 == null) goto L12;
            r8.addFormField(r13, this.valueConverter.convert(r14), this.encode);
            goto L5
        L12:
            throw new IllegalArgumentException(b.d("Field map contained null value for key '", r13, "'."));
        L14:
            throw new IllegalArgumentException("Field map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String r8, Converter<T, String> r10) {
            this.name = (String) Utils.checkNotNull(r8, "name == null");
            this.valueConverter = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r8.addHeader(this.name, this.valueConverter.convert(r10));
        }
    }

    public static final class HeaderList<T> extends ParameterHandler<List<T>> {
        private final Converter<T, com.bytedance.retrofit2.client.Header> valueConverter;

        public HeaderList(Converter<T, com.bytedance.retrofit2.client.Header> r8) {
            this.valueConverter = r8;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, Object r10) {
            apply(r8, (List) r10);
        }

        public void apply(RequestBuilder r8, List<T> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            Iterator<T> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            T r12 = r11.next();
            com.bytedance.retrofit2.client.Header r13 = this.valueConverter.convert(r12);
            r8.addHeader(r13.getName(), r13.getValue());
            goto L6
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Converter<T, String> valueConverter;

        public HeaderMap(Converter<T, String> r8) {
            this.valueConverter = r8;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, Object r10) {
            apply(r8, (Map) r10);
        }

        public void apply(RequestBuilder r8, Map<String, T> r10) {
            if (r10 == null) goto L17;
            Iterator<Map.Entry<String, T>> r11 = r10.entrySet().iterator();
        L5:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, T> r12 = r11.next();
            String r13 = r12.getKey();
            if (r13 == null) goto L14;
            T r14 = r12.getValue();
            if (r14 == null) goto L12;
            r8.addHeader(r13, this.valueConverter.convert(r14));
            goto L5
        L12:
            throw new IllegalArgumentException(b.d("Header map contained null value for key '", r13, "'."));
        L14:
            throw new IllegalArgumentException("Header map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    public static final class MaxLength<T> extends ParameterHandler<T> {
        private final Converter<T, String> converter;

        public MaxLength(Converter<T, String> r8) {
            this.converter = (Converter) Utils.checkNotNull(r8, "converter == null");
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L9;
            return;
        L9:
            r8.setMaxLength(Integer.parseInt(this.converter.convert(r10)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r10 + " to MaxLength", e);
        }
    }

    public static final class Method<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Method(String r8, Converter<T, String> r10) {
            this.name = (String) Utils.checkNotNull(r8, "name == null");
            this.valueConverter = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 == null) goto L6;
            r8.setMethod(this.name, this.valueConverter.convert(r10));
            return;
        L6:
            throw new IllegalArgumentException(a.i(new StringBuilder("Method parameter \""), this.name, "\" value must not be null."));
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, TypedOutput> converter;
        private final String name;

        public Part(String r8, Converter<T, TypedOutput> r10) {
            this.name = r8;
            this.converter = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L10;
            return;
        L10:
            r8.addPart(this.name, this.converter.convert(r10));
            return;
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r10 + " to RequestBody", e);
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final String transferEncoding;
        private final Converter<T, TypedOutput> valueConverter;

        public PartMap(Converter<T, TypedOutput> r8, String r10) {
            this.valueConverter = r8;
            this.transferEncoding = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, Object r10) {
            apply(r8, (Map) r10);
        }

        public void apply(RequestBuilder r8, Map<String, T> r10) {
            if (r10 == null) goto L17;
            Iterator<Map.Entry<String, T>> r11 = r10.entrySet().iterator();
        L5:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, T> r12 = r11.next();
            String r13 = r12.getKey();
            if (r13 == null) goto L14;
            T r14 = r12.getValue();
            if (r14 == null) goto L12;
            r8.addPart(r13, this.transferEncoding, this.valueConverter.convert(r14));
            goto L5
        L12:
            throw new IllegalArgumentException(b.d("Part map contained null value for key '", r13, "'."));
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Path(String r8, Converter<T, String> r10, boolean r11) {
            this.name = (String) Utils.checkNotNull(r8, "name == null");
            this.valueConverter = r10;
            this.encode = r11;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 == null) goto L6;
            r8.addPathParam(this.name, this.valueConverter.convert(r10), this.encode);
            return;
        L6:
            throw new IllegalArgumentException(a.i(new StringBuilder("Path parameter \""), this.name, "\" value must not be null."));
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encode;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String r8, Converter<T, String> r10, boolean r11) {
            this.name = (String) Utils.checkNotNull(r8, "name == null");
            this.valueConverter = r10;
            this.encode = r11;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r8.addQueryParam(this.name, this.valueConverter.convert(r10), this.encode);
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encode;
        private final Converter<T, String> valueConverter;

        public QueryMap(Converter<T, String> r8, boolean r10) {
            this.valueConverter = r8;
            this.encode = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder r8, Object r10) {
            apply(r8, (Map) r10);
        }

        public void apply(RequestBuilder r8, Map<String, T> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            Iterator<Map.Entry<String, T>> r11 = r10.entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L15;
            Map.Entry<String, T> r12 = r11.next();
            String r13 = r12.getKey();
            if (r13 == null) goto L14;
            T r14 = r12.getValue();
            if (r14 == null) goto L6;
            r8.addQueryParam(r13, this.valueConverter.convert(r14), this.encode);
            goto L6
        L14:
            throw new IllegalArgumentException("Query map contained null key.");
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> r8, boolean r10) {
            this.nameConverter = r8;
            this.encoded = r10;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            r8.addQueryParam(this.nameConverter.convert(r10), null, this.encoded);
        }
    }

    public static final class QueryObject<T> extends ParameterHandler<T> {
        public QueryObject() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if ((r10 instanceof QueryParamObject) == false) goto L9;
            r8.setQueryObjectParams(((QueryParamObject) r10).toQuery());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r10.getClass() + ",not implement QueryParamObject");
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        public RelativeUrl() {
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, Object r10) {
            r8.setRelativeUrl(r10);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        public Tag(Class<T> r8) {
            this.cls = r8;
        }

        @Override // com.bytedance.retrofit2.ParameterHandler
        public void apply(RequestBuilder r8, T r10) {
            r8.addTag(this.cls, r10);
        }
    }

    public ParameterHandler() {
    }

    public abstract void apply(RequestBuilder r8, T r10);

    public final ParameterHandler<Object> array() {
        return new AnonymousClass2(this);
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new AnonymousClass1(this);
    }
}
