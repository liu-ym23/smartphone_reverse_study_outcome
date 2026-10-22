package ad2;

import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ t a;

    public y(t r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.livesdk.jsbridge.methods.upload.models.d r6 = (com.bytedance.android.livesdk.jsbridge.methods.upload.models.d) r5;
        UploadMediaResultModel r0 = new UploadMediaResultModel();
        UploadMediaResultModel.a r1 = new UploadMediaResultModel.a();
        UploadMediaResultModel.c r2 = new UploadMediaResultModel.c();
        r2.b(r6.a);
        r2.a(r6.b);
        r2.c(r6.c);
        r1.c(CollectionsKt.listOf(r2));
        r0.b(r1);
        this.a.finishWithResult(r0);
    }
}
