package ad2;

import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadApi;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T, R> implements Function {
    public final /* synthetic */ String a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ CallContext c;
    public final /* synthetic */ int d;

    public f(String r1, AtomicInteger r2, CallContext r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object apply(Object r5) {
        String r6 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "path");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6);
        TypedOutput r1 = new MultipartTypedOutput();
        r1.addPart("file", new TypedFile("multipart/form-data", r0));
        return ((UploadApi) com.bytedance.android.live.network.c.b().e(UploadApi.class)).uploadImage(this.a, r1).subscribeOn(Schedulers.io()).map(new e(this, r6));
    }
}
