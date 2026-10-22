package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.load.monit;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s91.f;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/flipper/business/load/monit/BaseTabDataMonitor;", "Ls91/b;", "Ls91/f;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTabDataMonitor implements s91.b<f>, l, Observer<KVData> {
    public s91.a<f> a;
    public final CompositeDisposable b;
    public vlc.d c;
    public List<String> d;
    public final DataContext e;
    public final DataCenter f;
    public final IRoom g;

    public void d(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public void g() {
        this.d = null;
    }

    @Override // s91.b
    public void reset() {
        this.a = null;
        this.b.clear();
        vlc.d r0 = this.c;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.f.removeObserver(this);
        g();
    }

    @Override // s91.b
    public void a() {
        DataCenter r0 = this.f;
        vlc.d r2 = null;
        if (r0 == null) goto L5;
        r2 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.c = r2;
        if (r2 == null) goto L15;
        List<String> r1 = c();
        if (r1 == null) goto L24;
        Iterator<T> r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L26;
        String r4 = (String) r3.next();
        vlc.d r5 = this.c;
        if (r5 == null) goto L11;
        r5.addMessageListener(r4, this);
        goto L11
    L26:
        return;
    L24:
        return;
    L15:
        DataCenter r6 = this.f;
        if (r6 == null) goto L25;
        r6.observe("data_message_manager", this);
        return;
    }

    public List<String> c() {
        return this.d;
    }

    @Override // s91.b
    public final void b(o91.d r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    public final void e(f r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        s91.a<f> r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public void f(KVData r4) {
        if (r4 == null) goto L4;
        String r0 = r4.getKey();
    L5:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.hashCode() == (-1434292000)) goto L11;
        return;
    L11:
        if (r0.equals("data_message_manager") == false) goto L23;
        vlc.d r5 = (vlc.d) r4.getData();
        if (r5 != null) goto L15;
        return;
    L15:
        this.c = r5;
        List<String> r6 = c();
        if (r6 == null) goto L29;
        Iterator<T> r7 = r6.iterator();
    L19:
        if (r7.hasNext() == false) goto L32;
        String r1 = (String) r7.next();
        vlc.d r2 = this.c;
        if (r2 == null) goto L19;
        r2.addMessageListener(r1, this);
        goto L19
    L32:
        return;
    L29:
        return;
    L23:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        f((KVData) r1);
    }

    public final void onMessage(tlc.d r1) {
        if (r1 == null) goto L5;
        d(r1);
        return;
    }

    public BaseTabDataMonitor(DataContext r2, DataCenter r3, IRoom r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.b = new CompositeDisposable();
    }
}
