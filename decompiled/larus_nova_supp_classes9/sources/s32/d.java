package s32;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdkapi.depend.model.live.imagerecognition.StreamRecognitionResponse;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements ImageRecognitionBusiness {
    public final ImageRecognitionBusiness a;

    public static final class a implements ImageRecognitionButton {
        public final int a;
        public final int b;
        public final int c;
        public final ImageRecognitionButton d;
        public final ImageRecognitionEntry e;

        public final boolean canShow() {
            return this.d.canShow();
        }

        public final boolean canShowRedDot() {
            return this.d.canShowRedDot();
        }

        public final void onHide() {
            this.d.onHide();
        }

        public final void onShow() {
            this.d.onShow();
            int r0 = e.a;
            int r1 = this.a;
            ImageRecognitionEntry r2 = this.e;
            Intrinsics.checkNotNullParameter(r2, "entry");
            e.a("livesdk_identify_object_button_show", r1, r2);
        }

        public final int getDescRes() {
            return this.b;
        }

        public final int getIconRes() {
            return this.c;
        }

        public final int getScene() {
            return this.a;
        }

        public final String getBtmToken(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            return this.d.getBtmToken(r2);
        }

        public final void onClick(View r5) {
            Intrinsics.checkNotNullParameter(r5, "v");
            String r0 = this.d.getBtmToken(r5);
            IImageRecognitionService r1 = (IImageRecognitionService) k.f(IImageRecognitionService.class);
            if (r1 == null) goto L5;
            r1.recognize(this.d.getScene(), this.e, r0);
        L5:
            this.d.onClick(r5);
            int r6 = e.a;
            int r7 = this.a;
            ImageRecognitionEntry r2 = this.e;
            Intrinsics.checkNotNullParameter(r2, "entry");
            e.a("livesdk_identify_object_button_click", r7, r2);
        }

        public a(ImageRecognitionButton r2, ImageRecognitionEntry r3) {
            Intrinsics.checkNotNullParameter(r2, "button");
            Intrinsics.checkNotNullParameter(r3, "entry");
            this.d = r2;
            this.e = r3;
            this.a = r2.getScene();
            this.b = r2.getDescRes();
            this.c = r2.getIconRes();
        }
    }

    public final ScaleConfig getScaleConfig() {
        return this.a.getScaleConfig();
    }

    public d(ImageRecognitionBusiness r2) {
        Intrinsics.checkNotNullParameter(r2, "business");
        this.a = r2;
    }

    public final ImageRecognitionButton provide(ImageRecognitionEntry r3) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        ImageRecognitionButton r0 = this.a.provide(r3);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new a(r0, r3);
    }

    public final void onInjectExtra(Context r2, ImageRecognitionEntry r3, StreamRecognitionResponse r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        Intrinsics.checkNotNullParameter(r4, "res");
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.a.onInjectExtra(r2, r3, r4, r5);
    }
}
