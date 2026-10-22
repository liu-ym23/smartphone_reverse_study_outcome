package or1;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d, com.bytedance.android.scope.o {

    public static final class a implements IHostFrescoHelper.GetBitmapCallBack {
        public final /* synthetic */ Function1 a;

        public final void fail(IHostFrescoHelper.BitmapDataSource r1) {
        }

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void onNewResultImpl(Bitmap r2) {
            this.a.invoke(r2);
        }
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final String c() {
        return "/vs/ttlive_match_room_camera_playing.json";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final boolean a(LottieAnimationView r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "lottieView");
        Intrinsics.checkNotNullParameter(r4, "key");
        String r1 = i2.a;
        Intrinsics.checkNotNullParameter(r3, "$this$loadOfflineLottie");
        Intrinsics.checkNotNullParameter(r4, "key");
        return i2.f(r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final void d(py.k r3, Function1<? super Bitmap, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onNewResultImpl");
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap((py.k) com.bytedance.android.live.base.model.m.b(r3, ImageModel.class), new a(r4));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.d
    public final void f(HSImageView r1, String r2) {
        i2.e(r1, r2);
    }
}
