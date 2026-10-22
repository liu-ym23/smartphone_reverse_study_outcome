package wo1;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.n;
import com.bytedance.android.live.browser.jsbridge.base.LiveLoadShortTouchBigCardResultModel;
import com.bytedance.android.livesdk.chatroom.view.CommonIconEntryView;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.m;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.p;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.a3;
import w20.va;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends a3<va, LiveLoadShortTouchBigCardResultModel> {
    public final p a;

    public final void onTerminate() {
    }

    public h(p r2) {
        Intrinsics.checkNotNullParameter(r2, "commonIconModel");
        this.a = r2;
    }

    public final void invoke(Object r12, CallContext r13) {
        va r14 = (va) r12;
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "context");
        p r15 = this.a;
        if (r15 == null) goto L14;
        g r1 = new g(this);
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r1, "listener");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r1, "listener");
        Integer r0 = r14.getType();
        int r2 = r15.q.type;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.intValue() != r2) goto L15;
        n r3 = r15.q;
        r3.payload = r14.a();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r16 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a(r15.getContext(), r15.q, r15.r);
        r15.f = r16;
        CommonIconEntryView r5 = r16.a();
        if (r5 == null) goto L12;
        new IIconModel.EntryView(r5, 500 + r15.q.shortTouchBigCard.duration, false, 4, null);
    L12:
        new Handler(Looper.getMainLooper()).postDelayed(new m(r15, r1), 200);
        return;
    L15:
        return;
    }
}
