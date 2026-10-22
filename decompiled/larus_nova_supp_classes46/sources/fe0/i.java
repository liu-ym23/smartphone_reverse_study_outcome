package fe0;

import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.interact.audience.InteractAudienceVideoWindowManager;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
    public final IRoom a;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> b;
    public final a c;
    public final List<ge0.b> d;

    public interface a {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r5) {
        Iterator r6 = ((ArrayList) this.d).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        ge0.b r0 = (ge0.b) r6.next();
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) this.b.getGuestInfo(String.valueOf(r0.f()), r0.c());
        if (r1 == null) goto L4;
        r0.i(r1);
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void a(String r4, String r5) {
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        ge0.b r1 = (ge0.b) r0.next();
        if (TextUtils.isEmpty(r4) == true) goto L10;
        if (Objects.equals(r1.f(), r4) == false) goto L10;
    L13:
        ((ArrayList) this.d).remove(r1);
        return;
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (TextUtils.equals(r1.c(), r5) == false) goto L4;
    }

    public final ge0.b f(String r4, String r5) {
        Iterator r0 = ((ArrayList) this.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        ge0.b r1 = (ge0.b) r0.next();
        if (TextUtils.isEmpty(r4) == false) goto L10;
        if (Objects.equals(r1.f(), r4) == false) goto L10;
    L13:
        return r1;
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (TextUtils.equals(r1.c(), r5) == false) goto L4;
    L14:
        return null;
    }

    public i(IRoom r2, y r3, a r4) {
        this.d = new ArrayList();
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void b(String r1, String r2, boolean r3) {
        ge0.b r4 = f(r1, r2);
        if (r4 == null) goto L6;
        r4.j(!r3 ? 1 : 0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void n(List<ILinkPlayerInfoBridge> r1, long r2, n0 r4) {
        a r3 = this.c;
        ((CopyOnWriteArrayList) r1).size();
        ((InteractAudienceVideoWindowManager) r3).B();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void g(String r3, long r4, String r6, l r7) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        Iterator r8 = ((ArrayList) this.d).iterator();
    L7:
        if (r8.hasNext() == false) goto L15;
        ge0.b r0 = (ge0.b) r8.next();
        if (Objects.equals(r0.f(), r3) == false) goto L7;
        r0.k(r4, r6);
        return;
    }
}
