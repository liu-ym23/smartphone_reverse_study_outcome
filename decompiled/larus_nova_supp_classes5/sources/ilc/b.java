package ilc;

import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final String a(ModelInfo r0) {
        ExtendedUrlModel r1 = r0.getFile_url();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getUri();
    }
}
