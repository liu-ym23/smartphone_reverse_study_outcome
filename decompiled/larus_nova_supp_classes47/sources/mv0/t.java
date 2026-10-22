package mv0;

import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends qs0.a<IMediaLinkOutService> implements qs0.r {
    public t() {
        super(jc1.k.n(IMediaLinkOutService.class));
    }

    @Override // qs0.r
    public final boolean isUserInMediaLink(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        return ((IMediaLinkOutService) this.a).isUserInMediaLink(r2);
    }
}
