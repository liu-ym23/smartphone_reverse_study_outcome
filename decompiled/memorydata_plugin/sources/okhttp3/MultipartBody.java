package okhttp3;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0003\"#$B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u0015J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\u0018J\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014¨\u0006%"}, d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "Lokhttp3/MediaType;", "parts", "", "Lokhttp3/MultipartBody$Part;", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "boundary", "", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", "size", "", "()I", "()Lokhttp3/MediaType;", "-deprecated_boundary", "part", "index", "-deprecated_parts", "-deprecated_size", "-deprecated_type", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", i.f16176b, "okhttp"}, k = 1, mv = {1, 1, 15})
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE = null;
    private static final byte[] COLONSPACE = null;
    private static final byte[] CRLF = null;
    public static final Companion Companion = null;
    private static final byte[] DASHDASH = null;
    public static final MediaType DIGEST = null;
    public static final MediaType FORM = null;
    public static final MediaType MIXED = null;
    public static final MediaType PARALLEL = null;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J \u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lokhttp3/MultipartBody$Builder;", "", "boundary", "", "(Ljava/lang/String;)V", "Lokio/ByteString;", "parts", "", "Lokhttp3/MultipartBody$Part;", "type", "Lokhttp3/MediaType;", "addFormDataPart", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "filename", "body", "Lokhttp3/RequestBody;", "addPart", "headers", "Lokhttp3/Headers;", "part", "build", "Lokhttp3/MultipartBody;", "setType", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Builder(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "boundary");
            this.boundary = ByteString.Companion.encodeUtf8(r3);
            this.type = MultipartBody.MIXED;
            this.parts = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        public /* synthetic */ Builder(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(r1, "UUID.randomUUID().toString()");
        L5:
            this(r1);
        }

        public final Builder addFormDataPart(String r5, String r6) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r6, EventBody.KEY_VALUE);
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).addPart(Part.Companion.createFormData(r5, r6));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addFormDataPart(String r5, String r6, RequestBody r7) {
            Intrinsics.checkParameterIsNotNull(r5, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r7, "body");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).addPart(Part.Companion.createFormData(r5, r6, r7));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addPart(Headers r5, RequestBody r6) {
            Intrinsics.checkParameterIsNotNull(r6, "body");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).addPart(Part.Companion.create(r5, r6));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addPart(Part r5) {
            Intrinsics.checkParameterIsNotNull(r5, "part");
            ((Collection) ZeusTransformUtils.preCheckCast(((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).parts, Collection.class, "com.obric.memorydata.plugin")).add(r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addPart(RequestBody r5) {
            Intrinsics.checkParameterIsNotNull(r5, "body");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).addPart(Part.Companion.create(r5));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final MultipartBody build() {
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.parts, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
            return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("Multipart body must have at least one part.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder setType(MediaType r6) {
            Intrinsics.checkParameterIsNotNull(r6, "type");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r6.type(), "multipart") == false) goto L7;
            r2.type = r6;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("multipart != " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/MultipartBody$Companion;", "", "()V", "ALTERNATIVE", "Lokhttp3/MediaType;", "COLONSPACE", "", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "appendQuotedString", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "key", "", "appendQuotedString$okhttp", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder r5, String r6) {
            Intrinsics.checkParameterIsNotNull(r5, "$this$appendQuotedString");
            Intrinsics.checkParameterIsNotNull(r6, "key");
            r5.append(Typography.quote);
            int r0 = r6.length();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L15;
            char r2 = r6.charAt(r1);
            if (r2 != '\n') goto L9;
            String r3 = "%0A";
        L7:
            r5.append(r3);
        L14:
            r1 = r1 + 1;
            goto L3
        L9:
            if (r2 != '\r') goto L11;
            r3 = "%0D";
            goto L7
        L11:
            if (r2 != '\"') goto L13;
            r3 = "%22";
            goto L7
        L13:
            r5.append(r2);
            goto L14
        L15:
            r5.append(Typography.quote);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\tJ\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b¨\u0006\f"}, d2 = {"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Part {
        public static final Companion Companion = null;
        private final RequestBody body;
        private final Headers headers;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "createFormData", ActivityLifecycle.NAME, "", EventBody.KEY_VALUE, "filename", "okhttp"}, k = 1, mv = {1, 1, 15})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            @JvmStatic
            public final Part create(Headers r5, RequestBody r6) {
                Intrinsics.checkParameterIsNotNull(r6, "body");
                DefaultConstructorMarker r4 = null;
                if (r5 == null) goto L5;
                String r0 = r5.get(NetConst.KEY_CONTENT_TYPE);
            L6:
                boolean r1 = true;
                if (r0 != null) goto L9;
                boolean r2 = true;
            L11:
                if (r2 == false) goto L24;
                if (r5 == null) goto L14;
                String r3 = r5.get("Content-Length");
            L15:
                if (r3 == null) goto L18;
                r1 = false;
            L18:
                if (r1 == false) goto L22;
                return new Part(r5, r6, r4);
            L22:
                throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unexpected header: Content-Length".toString()), Throwable.class, "com.obric.memorydata.plugin"));
            L14:
                r3 = null;
                goto L15
            L24:
                throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Unexpected header: Content-Type".toString()), Throwable.class, "com.obric.memorydata.plugin"));
            L9:
                r2 = false;
                goto L11
            L5:
                r0 = null;
                goto L6
            }

            @JvmStatic
            public final Part create(RequestBody r3) {
                Intrinsics.checkParameterIsNotNull(r3, "body");
                return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create(null, r3);
            }

            @JvmStatic
            public final Part createFormData(String r4, String r5) {
                Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
                Intrinsics.checkParameterIsNotNull(r5, EventBody.KEY_VALUE);
                return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).createFormData(r4, null, RequestBody.Companion.create$default(RequestBody.Companion, r5, null, 1, null));
            }

            @JvmStatic
            public final Part createFormData(String r3, String r4, RequestBody r5) {
                Intrinsics.checkParameterIsNotNull(r3, ActivityLifecycle.NAME);
                Intrinsics.checkParameterIsNotNull(r5, "body");
                StringBuilder r0 = new StringBuilder();
                r0.append("form-data; name=");
                MultipartBody.Companion.appendQuotedString$okhttp(r0, r3);
                if (r4 == null) goto L5;
                r0.append("; filename=");
                MultipartBody.Companion.appendQuotedString$okhttp(r0, r4);
            L5:
                String r6 = r0.toString();
                Intrinsics.checkExpressionValueIsNotNull(r6, "StringBuilder().apply(builderAction).toString()");
                Headers r7 = new Headers.Builder().addUnsafeNonAscii("Content-Disposition", r6).build();
                return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).create(r7, r5);
            }
        }

        static {
            Companion = new Companion(null);
        }

        private Part(Headers r1, RequestBody r2) {
            this.headers = r1;
            this.body = r2;
        }

        public /* synthetic */ Part(Headers r1, RequestBody r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        @JvmStatic
        public static final Part create(Headers r1, RequestBody r2) {
            return Companion.create(r1, r2);
        }

        @JvmStatic
        public static final Part create(RequestBody r1) {
            return Companion.create(r1);
        }

        @JvmStatic
        public static final Part createFormData(String r1, String r2) {
            return Companion.createFormData(r1, r2);
        }

        @JvmStatic
        public static final Part createFormData(String r1, String r2, RequestBody r3) {
            return Companion.createFormData(r1, r2, r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
        /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m2995deprecated_body() {
            return this.body;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
        /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m2996deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    static {
        Companion = new Companion(null);
        MIXED = MediaType.Companion.get("multipart/mixed");
        ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
        DIGEST = MediaType.Companion.get("multipart/digest");
        PARALLEL = MediaType.Companion.get("multipart/parallel");
        FORM = MediaType.Companion.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte r1 = (byte) 45;
        DASHDASH = new byte[]{r1, r1};
    }

    public MultipartBody(ByteString r3, MediaType r4, List<Part> r5) {
        List<Part> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "boundaryByteString");
        Intrinsics.checkParameterIsNotNull(r4, "type");
        Intrinsics.checkParameterIsNotNull(r6, "parts");
        this.boundaryByteString = r3;
        this.type = r4;
        this.parts = r6;
        this.contentType = MediaType.Companion.get(r4 + "; boundary=" + boundary());
        this.contentLength = -1;
    }

    private final long writeOrCountBytes(BufferedSink r14, boolean r15) {
        BufferedSink r16 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r14, BufferedSink.class, "com.obric.memorydata.plugin");
        Buffer r0 = (Buffer) ZeusTransformUtils.preCheckCast(null, Buffer.class, "com.obric.memorydata.plugin");
        if (r15 == false) goto L5;
        r0 = new Buffer();
        r16 = (BufferedSink) ZeusTransformUtils.preCheckCast(r0, BufferedSink.class, "com.obric.memorydata.plugin");
    L5:
        int r2 = this.parts.size();
        long r4 = 0;
        int r6 = 0;
    L6:
        if (r6 >= r2) goto L31;
        Part r7 = (Part) ZeusTransformUtils.preCheckCast(this.parts.get(r6), Part.class, "com.obric.memorydata.plugin");
        Headers r8 = r7.headers();
        RequestBody r9 = r7.body();
        if (r16 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        r16.write(DASHDASH);
        r16.write(this.boundaryByteString);
        r16.write(CRLF);
        if (r8 == null) goto L15;
        int r10 = r8.size();
        int r11 = 0;
    L13:
        if (r11 >= r10) goto L15;
        r16.writeUtf8(r8.name(r11)).write(COLONSPACE).writeUtf8(r8.value(r11)).write(CRLF);
        r11 = r11 + 1;
    L15:
        MediaType r12 = r9.contentType();
        if (r12 == null) goto L18;
        r16.writeUtf8("Content-Type: ").writeUtf8(r12.toString()).write(CRLF);
    L18:
        long r13 = r9.contentLength();
        if (r13 == (-1)) goto L21;
        r16.writeUtf8("Content-Length: ").writeDecimalLong(r13).write(CRLF);
    L26:
        byte[] r17 = CRLF;
        r16.write(r17);
        if (r15 == false) goto L29;
        r4 = r4 + r13;
    L30:
        r16.write(r17);
        r6 = r6 + 1;
        goto L6
    L29:
        r9.writeTo(r16);
        goto L30
    L21:
        if (r15 == false) goto L26;
        if (r0 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        r0.clear();
        return -1;
    L31:
        if (r16 != null) goto L33;
        Intrinsics.throwNpe();
    L33:
        byte[] r1 = DASHDASH;
        r16.write(r1);
        r16.write(this.boundaryByteString);
        r16.write(r1);
        r16.write(CRLF);
        if (r15 == false) goto L44;
        if (r0 != null) goto L37;
        Intrinsics.throwNpe();
    L37:
        long r5 = r4 + r0.size();
        r0.clear();
        return r5;
    L44:
        return r4;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "boundary", imports = {}))
    /* JADX INFO: renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m2991deprecated_boundary() {
        return boundary();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "parts", imports = {}))
    /* JADX INFO: renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m2992deprecated_parts() {
        return this.parts;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m2993deprecated_size() {
        return size();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))
    /* JADX INFO: renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m2994deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        long r0 = this.contentLength;
        if (r0 != (-1)) goto L6;
        long r1 = writeOrCountBytes(null, true);
        this.contentLength = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int r2) {
        return (Part) ZeusTransformUtils.preCheckCast(this.parts.get(r2), Part.class, "com.obric.memorydata.plugin");
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink r3) {
        BufferedSink r4 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        writeOrCountBytes(r4, false);
    }
}
