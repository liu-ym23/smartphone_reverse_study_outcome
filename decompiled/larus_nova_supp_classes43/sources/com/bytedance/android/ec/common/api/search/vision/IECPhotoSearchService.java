package com.bytedance.android.ec.common.api.search.vision;

import java.util.Map;
import kotlin.Metadata;
import nf.a;
import nf.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/common/api/search/vision/IECPhotoSearchService;", "", "Lnf/b;", "iOperation", "", "", "enterParams", "Lnf/a;", "createPhotoSearchPanel", "photoSearchPanel", "", "onFirstSlideInternalFlow", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECPhotoSearchService {
    a createPhotoSearchPanel(b r1, Map<String, String> r10);

    void onFirstSlideInternalFlow(a r1);
}
