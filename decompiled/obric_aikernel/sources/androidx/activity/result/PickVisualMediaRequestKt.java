package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequestKt {
    public static final PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType r10) {
        Intrinsics.checkNotNullParameter(r10, "mediaType");
        return new PickVisualMediaRequest.Builder().setMediaType(r10).build();
    }

    public static /* synthetic */ PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
    L6:
        return PickVisualMediaRequest(r10);
    }
}
