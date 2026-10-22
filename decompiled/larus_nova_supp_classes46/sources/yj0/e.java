package yj0;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.api.utils.n;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.b1;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends vj0.a {
    public boolean c;
    public final IRoom d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ e b;
        public final /* synthetic */ String c;

        public a(long r1, e r3, String r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.a r6 = (com.bytedance.android.live.network.response.a) r5;
            VideoRoomPreApplyContract$View r7 = (VideoRoomPreApplyContract$View) this.b.b;
            if (r7 == null) goto L5;
            r7.da0(this.c);
        L5:
            n.m(this.c, System.currentTimeMillis() - this.a);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ e b;
        public final /* synthetic */ String c;

        public b(long r1, e r3, String r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }

        public final void accept(Object r6) {
            ApiServerException r7 = (Throwable) r6;
            if ((r7 instanceof ApiServerException) == false) goto L9;
            ApiServerException r0 = r7;
            String r1 = r0.getPrompt();
            if (r1 == null) goto L9;
            if (r2.a(r1) != true) goto L9;
            f2.c(r0.getPrompt(), 0);
        L9:
            VideoRoomPreApplyContract$View r2 = (VideoRoomPreApplyContract$View) this.b.b;
            if (r2 == null) goto L12;
            r2.ca0();
        L12:
            n.n(this.c, r7, System.currentTimeMillis() - this.a);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            if (r5 == null) goto L13;
            b1 r6 = (b1) r5.data;
            if (r6 == null) goto L14;
            e r0 = this.a;
            r0.c = r6.c();
            VideoRoomPreApplyContract$View r1 = (VideoRoomPreApplyContract$View) this.a.b;
            if (r1 == null) goto L15;
            List<c1> r2 = r6.a();
            boolean r3 = this.a.c;
            String r7 = r6.d();
            if (r7 != null) goto L11;
            r7 = "";
        L11:
            r1.ba0(r2, r3, r7);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            VideoRoomPreApplyContract$View r0 = (VideoRoomPreApplyContract$View) this.a.b;
            if (r0 == null) goto L6;
            r0.aa0(r3);
            return;
        }
    }

    @Override // vj0.a
    public final void d(String r11) {
        Intrinsics.checkNotNullParameter(r11, "uidString");
        IRoom r0 = this.d;
        if (r0 == null) goto L6;
        long r1 = System.currentTimeMillis();
        ((ObservableSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).permitPreApply(r0.getId(), d5.c(r11), r11).as(c())).subscribe(new a(r1, this, r11), new b(r1, this, r11));
        return;
    }

    public e(IRoom r2, VideoRoomPreApplyContract$View r3) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.d = r2;
        this.c = true;
    }

    @Override // vj0.a
    public final void e(boolean r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "cursor");
        if (this.c == true) goto L5;
        if (r4 == true) goto L5;
        return;
    L5:
        IRoom r7 = this.d;
        if (r7 == null) goto L10;
        ((SingleSubscribeProxy) ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getPrepareApplyList(r7.getId(), r6, r5).as(c())).subscribe(new c(this), new d(this));
        return;
    }
}
