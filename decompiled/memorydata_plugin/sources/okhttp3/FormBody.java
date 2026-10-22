package okhttp3;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bJ\u001a\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\u001d"}, d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "encodedNames", "", "", "encodedValues", "(Ljava/util/List;Ljava/util/List;)V", "size", "", "()I", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "encodedName", "index", "encodedValue", ActivityLifecycle.NAME, "-deprecated_size", EventBody.KEY_VALUE, "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = null;
    public static final Companion Companion = null;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/FormBody$Builder;", "", "charset", "Ljava/nio/charset/Charset;", "(Ljava/nio/charset/Charset;)V", "names", "", "", "values", "add", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "addEncoded", "build", "Lokhttp3/FormBody;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Builder(Charset r3) {
            this.charset = r3;
            this.names = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.values = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        public /* synthetic */ Builder(Charset r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = (Charset) ZeusTransformUtils.preCheckCast(null, Charset.class, "com.obric.memorydata.plugin");
        L5:
            this(r1);
        }

        public final Builder add(String r20, String r21) {
            Intrinsics.checkParameterIsNotNull(r20, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r21, EventBody.KEY_VALUE);
            Builder r14 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            ((Collection) ZeusTransformUtils.preCheckCast(r14.names, Collection.class, "com.obric.memorydata.plugin")).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, r20, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, r14.charset, 91, null));
            ((Collection) ZeusTransformUtils.preCheckCast(r14.values, Collection.class, "com.obric.memorydata.plugin")).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, r21, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, r14.charset, 91, null));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addEncoded(String r20, String r21) {
            Intrinsics.checkParameterIsNotNull(r20, ActivityLifecycle.NAME);
            Intrinsics.checkParameterIsNotNull(r21, EventBody.KEY_VALUE);
            Builder r14 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            ((Collection) ZeusTransformUtils.preCheckCast(r14.names, Collection.class, "com.obric.memorydata.plugin")).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, r20, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, r14.charset, 83, null));
            ((Collection) ZeusTransformUtils.preCheckCast(r14.values, Collection.class, "com.obric.memorydata.plugin")).add(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, r21, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, r14.charset, 83, null));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/FormBody$Companion;", "", "()V", "CONTENT_TYPE", "Lokhttp3/MediaType;", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");
    }

    public FormBody(List<String> r3, List<String> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r5, "encodedNames");
        Intrinsics.checkParameterIsNotNull(r6, "encodedValues");
        this.encodedNames = Util.toImmutableList(r5);
        this.encodedValues = Util.toImmutableList(r6);
    }

    private final long writeOrCountBytes(BufferedSink r6, boolean r7) {
        BufferedSink r8 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r6, BufferedSink.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L5;
        Buffer r9 = new Buffer();
    L8:
        int r0 = 0;
        int r2 = this.encodedNames.size();
    L9:
        if (r0 >= r2) goto L13;
        if (r0 <= 0) goto L12;
        r9.writeByte(38);
    L12:
        r9.writeUtf8((String) ZeusTransformUtils.preCheckCast(this.encodedNames.get(r0), String.class, "com.obric.memorydata.plugin"));
        r9.writeByte(61);
        r9.writeUtf8((String) ZeusTransformUtils.preCheckCast(this.encodedValues.get(r0), String.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L9
    L13:
        if (r7 == false) goto L15;
        long r1 = r9.size();
        r9.clear();
        return r1;
    L15:
        return 0;
    L5:
        if (r8 != null) goto L7;
        Intrinsics.throwNpe();
    L7:
        r9 = r8.getBuffer();
        goto L8
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m2953deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.encodedNames.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public final String encodedValue(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.encodedValues.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    public final String name(int r8) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(r8), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int r8) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(r8), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink r3) {
        BufferedSink r4 = (BufferedSink) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSink.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "sink");
        writeOrCountBytes(r4, false);
    }
}
