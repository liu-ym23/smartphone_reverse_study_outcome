package el0;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends y {
    public final com.bytedance.android.live.livepkaudience.base.i a;
    public final a b;
    public final List<g> c;
    public final List<e> d;

    public interface a {
        void d();
    }

    public final g g(String r6) {
        LinkPlayerInfo r0 = this.a.k("0", r6);
        if (r0 != null) goto L5;
        ALogger.i("ttlive_link", "queryAllOnlineList get null userId = 0 interactId = " + r6);
        this.a.G(k.f(ILinkServiceExternal.class).getMultiDataHolderExternal().getChannelId());
    L5:
        g r1 = h("0", r6);
        if (r1 != null) goto L8;
        i r2 = new i(r6, r0);
        ((ArrayList) this.c).add(r2);
        return r2;
    L8:
        r1.g(r0);
        return r1;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r5) {
        Iterator r6 = ((ArrayList) this.c).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        g r0 = (g) r6.next();
        LinkPlayerInfo r1 = this.a.k(r0.f(), r0.c());
        if (r1 == null) goto L4;
        r0.g(r1);
        goto L4
    L8:
        Iterator r7 = ((ArrayList) this.d).iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        e r2 = (e) r7.next();
        if (this.a.k(r2.e(), r2.c()) == null) goto L10;
        r2.c();
        r2.d();
        r2.f();
        goto L10
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void a(String r4, String r5) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        g r1 = (g) r0.next();
        if (n0.b(r4) == false) goto L10;
        if (n0.a(r1.f(), r4) == false) goto L10;
    L13:
        ((ArrayList) this.c).remove(r1);
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (TextUtils.equals(r1.c(), r5) == false) goto L4;
    L14:
        Iterator r2 = ((ArrayList) this.d).iterator();
    L16:
        if (r2.hasNext() == false) goto L41;
        e r3 = (e) r2.next();
        if (n0.b(r4) == false) goto L22;
        if (n0.a(r3.e(), r4) == false) goto L22;
    L25:
        ((ArrayList) this.d).remove(r3);
        return;
    L22:
        if (TextUtils.isEmpty(r5) == true) goto L16;
        if (TextUtils.equals(r3.c(), r5) == false) goto L16;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void e(List r1, WaitingListUser r2) {
        a r3 = this.b;
        ((CopyOnWriteArrayList) r1).size();
        r3.d();
    }

    public final g h(String r4, String r5) {
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        g r1 = (g) r0.next();
        if (n0.b(r4) == false) goto L10;
        if (n0.a(r1.f(), r4) == false) goto L10;
    L13:
        return r1;
    L10:
        if (TextUtils.isEmpty(r5) == true) goto L4;
        if (TextUtils.equals(r1.c(), r5) == false) goto L4;
    L14:
        return null;
    }

    public f(Room r1, com.bytedance.android.live.livepkaudience.base.i r2, a r3) {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void b(String r1, String r2, boolean r3) {
        g r4 = h(r1, r2);
        if (r4 == null) goto L6;
        r4.h(!r3 ? 1 : 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
    public final void f(String r4, long r5, String r7) {
        if (n0.b(r4) == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) this.c).iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        g r1 = (g) r0.next();
        if (n0.a(r1.f(), r4) == false) goto L7;
        r1.i(r5, r7);
    L11:
        Iterator r2 = ((ArrayList) this.d).iterator();
    L13:
        if (r2.hasNext() == false) goto L24;
        e r3 = (e) r2.next();
        if (n0.a(r3.e(), r4) == false) goto L13;
        r3.g(r5, r7);
        return;
    }
}
