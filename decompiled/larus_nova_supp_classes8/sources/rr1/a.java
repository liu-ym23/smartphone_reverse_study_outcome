package rr1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BizAdMsgPanelViewManager;
import com.bytedance.android.livesdk.chatroom.vs_impl.message.BusinessMsgView;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import dq1.c;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mq1.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements g0, c, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // dq1.c
    public final ur1.a f() {
        return new ur1.a();
    }

    @Override // dq1.c
    public final boolean a(BusinessConfigure r1) {
        return sr1.a.d(r1);
    }

    @Override // dq1.c
    public final String i(Long r1) {
        return sr1.a.b(r1);
    }

    @Override // dq1.c
    public final boolean c(String r1, BusinessConfigure r2) {
        return sr1.a.a(r1, r2);
    }

    @Override // dq1.c
    public final BusinessMsgView d(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new BusinessMsgView(r3, r4, r5, 8);
    }

    @Override // dq1.c
    public final BizAdMsgPanelViewManager g(DataCenter r2, Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        return new BizAdMsgPanelViewManager(r2, r3, r4);
    }

    @Override // dq1.c
    public final void h(String r2, String r3, BusinessConfigure r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "pagePosition");
        sr1.a.c(r2, r3, r4, r5);
    }
}
