package d82;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ImageRecognitionBusiness {
    public a() {
    }

    public final ScaleConfig getScaleConfig() {
        return s32.b.d(1);
    }

    public final void onInjectExtra(Context r1, ImageRecognitionEntry r2, StreamRecognitionResponse r3, Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        Intrinsics.checkNotNullParameter(r3, "res");
        Intrinsics.checkNotNullParameter(r4, "extra");
    }

    public final ImageRecognitionButton provide(ImageRecognitionEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "entry");
        return new c(r2);
    }
}
