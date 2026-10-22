package com.obric.memorydata.recommend.screenshotupload;

import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/ScreenshotPipelineManager;", "Lcom/obric/memorydata/recommend/screenshotupload/BasePipelineManager;", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "pipelines", "", "Lcom/obric/memorydata/recommend/screenshotupload/Pipeline;", "<init>", "(Ljava/util/List;)V", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends a<ScreenshotData> {
    public h(List<? extends c<ScreenshotData>> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "pipelines");
        super(r4);
    }
}
