package w92;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.ChatLikeLinkedHashMap;
import com.bytedance.live.datacontext.i;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ long a;

    public d(long r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Map<Long, com.bytedance.android.live.base.model.data.b> r4 = ((com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.b) r3).a();
        if (r4 == null) goto L22;
        l r0 = q.i();
        if ((r0 instanceof PublicScreenContext) == true) goto L7;
        r0 = null;
    L7:
        PublicScreenContext r1 = (PublicScreenContext) r0;
        if (r1 == null) goto L14;
        i<ChatLikeLinkedHashMap> r2 = r1.getLocalLikeStatusInfoMap();
        if (r2 == null) goto L14;
        ChatLikeLinkedHashMap r5 = (ChatLikeLinkedHashMap) r2.getValue();
        if (r5 == null) goto L14;
        r5.putAll(r4);
    L14:
        com.bytedance.android.live.base.model.data.b r6 = r4.get(Long.valueOf(this.a));
        if (r6 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r7 = q.a();
        if (r7 == null) goto L24;
        PropertyOwner<com.bytedance.android.live.base.model.data.b> r8 = r7.d();
        if (r8 == null) goto L25;
        r8.a(r6);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }
}
