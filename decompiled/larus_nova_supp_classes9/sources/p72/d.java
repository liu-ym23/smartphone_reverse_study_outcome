package p72;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import u22.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;

    public d(c r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        if (r4 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.api.emoji.b r5 = (com.bytedance.android.livesdk.interactivity.api.emoji.b) ((ExtraResponse) r4).data;
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.api.emoji.c r6 = r5.a();
        if (r6 == null) goto L15;
        this.a.c = r6;
        xs2.b r7 = xs2.b.a();
        m r0 = new m();
        String r1 = this.b;
        if (r1 == null) goto L11;
        r0.f = r1;
    L11:
        Unit r2 = Unit.INSTANCE;
        r7.post(r0);
        return;
    L15:
        return;
    L14:
        return;
    }
}
