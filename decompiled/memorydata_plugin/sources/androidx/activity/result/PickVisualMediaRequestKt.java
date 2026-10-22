package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"PickVisualMediaRequest", "Landroidx/activity/result/PickVisualMediaRequest;", "mediaType", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "activity_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PickVisualMediaRequestKt {
    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType r2) {
        ActivityResultContracts.PickVisualMedia.VisualMediaType r3 = (ActivityResultContracts.PickVisualMedia.VisualMediaType) ZeusTransformUtils.wrapperContextForParams(r2, ActivityResultContracts.PickVisualMedia.VisualMediaType.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(r3).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType r1, int r2, Object r3) {
        ActivityResultContracts.PickVisualMedia.VisualMediaType r4 = (ActivityResultContracts.PickVisualMedia.VisualMediaType) ZeusTransformUtils.wrapperContextForParams(r1, ActivityResultContracts.PickVisualMedia.VisualMediaType.class, "com.obric.memorydata.plugin");
        if ((r2 & 1) == 0) goto L6;
        r4 = (ActivityResultContracts.PickVisualMedia.VisualMediaType) ZeusTransformUtils.preCheckCast(ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE, ActivityResultContracts.PickVisualMedia.VisualMediaType.class, "com.obric.memorydata.plugin");
    L6:
        return PickVisualMediaRequest(r4);
    }
}
