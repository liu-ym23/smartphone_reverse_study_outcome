package com.bytedance.android.livesdk.dislike.preload.loader.watchlater;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.f;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.g;
import com.bytedance.android.livesdk.config.z9;
import com.bytedance.android.livesdk.dislike.ItemType;
import com.bytedance.android.livesdk.dislike.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends com.bytedance.android.livesdk.dislike.preload.loader.a {
    public final String d;
    public final List<n> e;
    public final CompositeDisposable f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dislike.preload.loader.watchlater.a$a, reason: collision with other inner class name */
    public static final class C0117a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0117a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            if (((Boolean) r9).booleanValue() == false) goto L10;
            final a r10 = this.a;
            IRoom r0 = r10.b;
            if (r0 == null) goto L7;
            long r1 = r0.getRoomId();
        L8:
            long r3 = r1;
            ((ArrayList) r10.e).clear();
            CompositeDisposable r6 = r10.f;
            String r7 = r10.d;
            g.c(new f(r3, new LLPanelWatchLaterLoader$requestLongPanelApi$1(r10), r6, r7));
            return;
        L7:
            r1 = 0;
            goto L8
        }
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final boolean a() {
        return z9.a.getValue().getEnable();
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final void b() {
        RxUtilKt.c(this.c.c().subscribe(new C0117a(this)), this.f);
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final void c() {
        this.f.dispose();
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.loader.a
    public final List<n> d() {
        List<n> r0 = this.e;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((n) r3).a != ItemType.WATCH_LATER) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        return r1;
    }

    public a(com.bytedance.android.livesdk.dislike.preload.context.a r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.d = "LLPanelWatchLaterLoader";
        this.e = new ArrayList();
        this.f = new CompositeDisposable();
    }
}
