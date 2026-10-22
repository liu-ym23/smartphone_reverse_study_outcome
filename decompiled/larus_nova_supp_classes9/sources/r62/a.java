package r62;

import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements ChannelTrayListViewBinder.a {
    public final /* synthetic */ ChannelTrayListViewV2 a;

    public a(ChannelTrayListViewV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewBinder.a
    public final void a(p62.a r3) {
        Intrinsics.checkNotNullParameter(r3, "channel");
        r3.j = System.currentTimeMillis();
        Function1<p62.a, Unit> r0 = this.a.getTrayClickCallback();
        if (r0 == null) goto L6;
        Unit r4 = (Unit) r0.invoke(r3);
        return;
    }
}
