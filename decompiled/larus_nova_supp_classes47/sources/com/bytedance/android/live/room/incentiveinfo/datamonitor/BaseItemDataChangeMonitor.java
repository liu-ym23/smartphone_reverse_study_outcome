package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import android.content.Context;
import com.bytedance.android.live.room.incentiveinfo.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u81.g;
import u81.h;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/datamonitor/BaseItemDataChangeMonitor;", "Lu81/h;", "Lw81/b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "g", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseItemDataChangeMonitor implements h<w81.b>, l, Observer<KVData> {
    public g<w81.b> a;
    public final CompositeDisposable b;
    public vlc.d c;
    public boolean d;
    public final DataCenter e;
    public final IRoom f;
    public final Context g;

    public static final class a {
    }

    static {
    }

    public abstract List<String> d();

    public abstract void e(tlc.d r1);

    @Override // u81.h
    public final void reset() {
        this.a = null;
        this.b.clear();
        vlc.d r0 = this.c;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    @Override // u81.h
    public void a() {
        DataCenter r0 = this.e;
        vlc.d r2 = null;
        if (r0 == null) goto L5;
        r2 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        this.c = r2;
        if (r2 == null) goto L13;
        Iterator<T> r1 = d().iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        String r3 = (String) r1.next();
        vlc.d r4 = this.c;
        if (r4 == null) goto L9;
        r4.addMessageListener(r3, this);
        goto L9
    L23:
        return;
    L13:
        DataCenter r5 = this.e;
        if (r5 == null) goto L22;
        r5.observe("data_message_manager", this);
        return;
    }

    public final Context getContext() {
        return this.g;
    }

    @Override // u81.h
    public final void b(i r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    public final void c(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoBind");
        this.b.add(r2);
    }

    public final void f(w81.b r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        g<w81.b> r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == (-1434292000)) goto L12;
        return;
    L12:
        if (r0.equals("data_message_manager") == false) goto L22;
        vlc.d r6 = (vlc.d) r5.getData();
        if (r6 == null) goto L30;
        this.c = r6;
        Iterator<T> r7 = d().iterator();
    L18:
        if (r7.hasNext() == false) goto L31;
        String r1 = (String) r7.next();
        vlc.d r2 = this.c;
        if (r2 == null) goto L18;
        r2.addMessageListener(r1, this);
        goto L18
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onMessage(tlc.d r1) {
        if (r1 == null) goto L5;
        e(r1);
        return;
    }

    public BaseItemDataChangeMonitor(DataCenter r2, IRoom r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.b = new CompositeDisposable();
    }
}
