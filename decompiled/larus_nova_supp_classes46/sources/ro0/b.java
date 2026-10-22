package ro0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b<T extends d> {
    public final a a;
    public final OpenPlatformContext b;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a c;

    public static final class a implements l {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onMessage(d r2) {
            b r0 = this.a;
            if (r2 == null) goto L7;
            r0.b(r2);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
    }

    public abstract MessageType a();

    public abstract void b(T r1);

    public b(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        this.c = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.b = r2;
        this.a = new a(this);
    }
}
