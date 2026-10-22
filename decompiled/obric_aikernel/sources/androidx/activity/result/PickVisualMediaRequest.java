package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class PickVisualMediaRequest {
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType;

    public static final class Builder {
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType;

        public Builder() {
            this.mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }

        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest r10 = new PickVisualMediaRequest();
            r10.setMediaType$activity_release(this.mediaType);
            return r10;
        }

        public final Builder setMediaType(ActivityResultContracts.PickVisualMedia.VisualMediaType r10) {
            Intrinsics.checkNotNullParameter(r10, "mediaType");
            this.mediaType = r10;
            return this;
        }
    }

    public PickVisualMediaRequest() {
        this.mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
    }

    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(ActivityResultContracts.PickVisualMedia.VisualMediaType r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.mediaType = r10;
    }
}
