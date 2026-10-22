package acb;

import com.bytedance.lark.pb.media.v1.GetNutStoreFilePreviewUrlRequest;
import com.bytedance.lark.pb.media.v1.SaveToNutStoreRequest;
import com.bytedance.lark.pb.media.v1.SaveToSpaceStoreRequest;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements zbb.a {
    public final ybb.a a;

    @Override // zbb.a
    public final void a() {
        new SaveToSpaceStoreRequest.Builder();
        throw null;
    }

    @Override // zbb.a
    public final void b() {
        new GetNutStoreFilePreviewUrlRequest.Builder();
        throw null;
    }

    @Override // zbb.a
    public final void c() {
        new SaveToNutStoreRequest.Builder();
        throw null;
    }

    public f() {
        this.a = (ybb.a) ApiUtils.getApi(ybb.a.class);
    }
}
