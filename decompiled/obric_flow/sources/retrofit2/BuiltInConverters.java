package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.q0;
import okhttp3.w0;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes3.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit;

    public static final class BufferingResponseBodyConverter implements Converter<w0, w0> {
        static final BufferingResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new BufferingResponseBodyConverter();
        }

        public BufferingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ w0 convert(w0 r5) throws IOException {
            return convert2(r5);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public w0 convert2(w0 r5) throws IOException {
            w0 r10 = Utils.buffer(r5);     // Catch: Throwable -> L5
            r5.close();
            return r10;
        L5:
            th = move-exception;
            r5.close();
            throw th;
        }
    }

    public static final class RequestBodyConverter implements Converter<q0, q0> {
        static final RequestBodyConverter INSTANCE = null;

        static {
            INSTANCE = new RequestBodyConverter();
        }

        public RequestBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public q0 convert2(q0 r5) {
            return r5;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ q0 convert(q0 r5) throws IOException {
            return convert2(r5);
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<w0, w0> {
        static final StreamingResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new StreamingResponseBodyConverter();
        }

        public StreamingResponseBodyConverter() {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public w0 convert2(w0 r5) {
            return r5;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ w0 convert(w0 r5) throws IOException {
            return convert2(r5);
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = null;

        static {
            INSTANCE = new ToStringConverter();
        }

        public ToStringConverter() {
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ String convert(Object r5) throws IOException {
            return convert2(r5);
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public String convert2(Object r5) {
            return r5.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter<w0, Unit> {
        static final UnitResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new UnitResponseBodyConverter();
        }

        public UnitResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Unit convert(w0 r5) throws IOException {
            return convert2(r5);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Unit convert2(w0 r5) {
            r5.close();
            return Unit.INSTANCE;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<w0, Void> {
        static final VoidResponseBodyConverter INSTANCE = null;

        static {
            INSTANCE = new VoidResponseBodyConverter();
        }

        public VoidResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Void convert(w0 r5) throws IOException {
            return convert2(r5);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Void convert2(w0 r5) {
            r5.close();
            return null;
        }
    }

    public BuiltInConverters() {
        this.checkForKotlinUnit = true;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, q0> requestBodyConverter(Type r5, Annotation[] r10, Annotation[] r11, Retrofit r12) {
        if (q0.class.isAssignableFrom(Utils.getRawType(r5)) == true) goto L5;
        return null;
    L5:
        return RequestBodyConverter.INSTANCE;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<w0, ?> responseBodyConverter(Type r5, Annotation[] r10, Retrofit r11) {
        if (r5 != w0.class) goto L10;
        if (Utils.isAnnotationPresent(r10, Streaming.class) == false) goto L8;
        return StreamingResponseBodyConverter.INSTANCE;
    L8:
        return BufferingResponseBodyConverter.INSTANCE;
    L10:
        if (r5 != Void.class) goto L14;
        return VoidResponseBodyConverter.INSTANCE;
    L14:
        if (this.checkForKotlinUnit == true) goto L16;
        return null;
    L16:
        if (r5 != Unit.class) goto L26;
        return UnitResponseBodyConverter.INSTANCE;
    L19:
        this.checkForKotlinUnit = false;
        return null;
    L26:
        return null;
    }
}
