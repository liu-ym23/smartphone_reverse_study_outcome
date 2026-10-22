package ad2;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ t a;

    public a0(t r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        UploadMediaResultModel r0 = new UploadMediaResultModel();
        UploadMediaResultModel.a r1 = new UploadMediaResultModel.a();
        List r10 = (List) r9;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L15;
        ImageModel r3 = (ImageModel) r11.next();
        UploadMediaResultModel.b r4 = new UploadMediaResultModel.b();
        String r5 = null;
        if (r3 == null) goto L10;
        List r6 = r3.mUrls;
        if (r6 == null) goto L10;
        String r7 = (String) ListProtector.get(r6, 0);
    L11:
        r4.b(r7);
        if (r3 == null) goto L14;
        r5 = r3.mUri;
    L14:
        r4.a(r5);
        r2.add(r4);
    L10:
        r7 = null;
        goto L11
    L15:
        r1.a(r2);
        Unit r13 = Unit.INSTANCE;
        r0.b(r1);
        this.a.finishWithResult(r0);
    }
}
