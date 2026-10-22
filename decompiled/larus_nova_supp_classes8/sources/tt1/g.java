package tt1;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.announcement.AnnouncementApi;
import com.bytedance.android.livesdk.announcement.highlight.e0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ IBaseCallbackSchemaHandler.SchemaCallback b;
    public final /* synthetic */ String c;

    public g(k r1, IBaseCallbackSchemaHandler.SchemaCallback r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        if (((AnnouncementApi.SubscribeRequestResponse) ((BaseResponse) r4).data).getResponseStatus() != 1) goto L11;
        IBaseCallbackSchemaHandler.SchemaCallback r5 = this.b;
        if (r5 == null) goto L8;
        r5.onSuccess(0, "");
    L8:
        if (Intrinsics.areEqual(this.c, "1") == false) goto L12;
        this.a.getClass();
        xs2.b.a().post(new e0(true));
        return;
    L12:
        return;
    }
}
