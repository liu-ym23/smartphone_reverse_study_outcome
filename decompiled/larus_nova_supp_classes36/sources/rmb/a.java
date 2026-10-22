package rmb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class a implements cza.a {

    /* JADX INFO: renamed from: rmb.a$a, reason: collision with other inner class name */
    public static final class C0323a {
    }

    public static final class b extends SimpleTarget<Drawable> {
        public final /* synthetic */ IGetDataCallback<Drawable> a;

        public b(IGetDataCallback<Drawable> r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r5) {
            super.onLoadFailed(r5);
            IGetDataCallback<Drawable> r6 = this.a;
            Exception r0 = new Exception("unknown error");
            ErrorResult r1 = new ErrorResult(0);
            ErrorResult.access$002(r1, 0);
            ErrorResult.access$102(r1, -9999);
            ErrorResult.access$202(r1, 0);
            ErrorResult.access$302(r1, r0);
            ErrorResult.access$402(r1, "");
            ErrorResult.access$502(r1, "");
            ErrorResult.access$602(r1, "");
            ErrorResult.access$702(r1, "");
            ErrorResult.access$802(r1, 0);
            ErrorResult.access$902(r1, null);
            ErrorResult.access$1002(r1, null);
            ErrorResult.access$1102(r1, null);
            r6.onError(r1);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r2) {
            Drawable r3 = (Drawable) r2;
            super.onResourceReady(r3);
            this.a.onSuccess(r3);
        }
    }

    static {
    }

    @Inject
    public a() {
    }

    public final void a(Context r5, cza.b r6, IGetDataCallback<Drawable> r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Log.i("OfficeAvatarService", "load avatar, " + r6.a + ", " + r6.b + ", " + r6.c + ", " + r6.d);
        ImageLoader.with(r5).load(AvatarImage.Builder.obtain(r6.a, r6.b, r6.c, r6.d).build()).override(r6.c, r6.d).asDrawable().into(new b(r7));
    }
}
