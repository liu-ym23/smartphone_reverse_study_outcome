package qi0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.h;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a implements g {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void b(h r2) {
            Intrinsics.checkNotNullParameter(r2, "request");
            this.a.b(r2);
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
        public final void a(h r3, i r4) {
            Intrinsics.checkNotNullParameter(r3, "request");
            Intrinsics.checkNotNullParameter(r4, "response");
            m r0 = r4.a;
            r0.z(12);
            r0.F(15);
            r0.C(30);
            r0.D(6);
            this.a.a(r3, r4);
        }
    }

    static {
    }

    public static void a(boolean r15, int r16, int r17, DataCenter r18, g r19) {
        Intrinsics.checkNotNullParameter(r19, "listener");
        if (r15 == false) goto L5;
        int r3 = 113;
    L6:
        ln0.a r1 = yg0.h.a;
        yg0.h.k(new h(r3, 0, null, false, 0, je0.d.r(), null, new Triple(Integer.valueOf(r16), Integer.valueOf(r17), "LinkMicGameLayoutConfigProvider#getLayoutConfigFromGecko"), null, null, r18, 862), new a(r19), null);
        return;
    L5:
        r3 = 15;
        goto L6
    }
}
