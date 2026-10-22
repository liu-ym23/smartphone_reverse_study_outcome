package ad2;

import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ t a;

    public w(t r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        UploadMediaResultModel r0 = new UploadMediaResultModel();
        UploadMediaResultModel.a r1 = new UploadMediaResultModel.a();
        r1.d(CollectionsKt.listOf((com.bytedance.android.livesdk.jsbridge.methods.upload.models.e) r3));
        r0.b(r1);
        r0.a(UploadMediaResultModel.Code.Success);
        this.a.finishWithResult(r0);
    }
}
