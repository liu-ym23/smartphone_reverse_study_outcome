package u10;

import com.bytedance.retrofit2.mime.TypedOutput;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends RequestBody {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ TypedOutput b;

    public final long contentLength() {
        return this.b.length();
    }

    public final MediaType contentType() {
        return (MediaType) this.a.element;
    }

    public final void writeTo(BufferedSink r2) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        this.b.writeTo(r2.outputStream());
    }

    public i(Ref.ObjectRef r1, TypedOutput r2) {
        this.a = r1;
        this.b = r2;
    }
}
