package mv0;

import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.service.ILiveService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o extends qs0.a<ILiveOntologyInfoManager> implements qs0.m {
    public o() {
        super(jc1.k.n(ILiveService.class).getLiveOntologyRecord());
    }

    @Override // qs0.m
    public final String getEnterFromMerge() {
        ILiveOntologyInfoManager r0 = (ILiveOntologyInfoManager) this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEnterFromMerge();
    }
}
