package com.bytedance.android.live.revlink.impl.control;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/LinkOtherAnchorListener;", "Li11/c$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkOtherAnchorListener extends i11.c.a implements Observer<IBaseUser> {
    public kc0.f a;
    public Disposable b;
    public final Lazy c;
    public final IRoom d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LinkOtherAnchorListener a;
        public final /* synthetic */ List b;

        public a(LinkOtherAnchorListener r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            kc0.f r4 = this.a.a;
            if (r4 == null) goto L6;
            r4.a(this.b);
            return;
        }
    }

    public LinkOtherAnchorListener(IRoom r1) {
        this.d = r1;
        this.c = LazyKt.lazy(LinkOtherAnchorListener$enableCallback$2.INSTANCE);
        i11.b r2 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r2 == null) goto L5;
        r2.i(this);
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.q r3 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r3 == null) goto L13;
        PkScopeProviderService r4 = r3.a;
        if (r4 == null) goto L14;
        MutableLiveData<IBaseUser> r5 = r4.b;
        if (r5 == null) goto L15;
        r5.observeForever(this);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void j(List<String> r6) {
        long r0 = Random.Default.nextLong(0, 5);
        Disposable r2 = this.b;
        if (r2 == null) goto L5;
        r2.dispose();
    L5:
        this.b = Observable.timer(r0, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r6));
    }

    public final void onChanged(Object r2) {
        IBaseUser r3 = (IBaseUser) r2;
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.a == null) goto L15;
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.getIdString() == null) goto L16;
        j(CollectionsKt.listOf(r3.getIdString()));
        return;
    L16:
        return;
    }

    @Override // i11.c.a, i11.c.b
    public final void d(int r5, List<? extends com.bytedance.android.livesdk.link.model.p> r6) {
        Intrinsics.checkNotNullParameter(r6, "list");
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.a == null) goto L50;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L30;
        Object r0 = r8.next();
        com.bytedance.android.livesdk.link.model.p r1 = (com.bytedance.android.livesdk.link.model.p) r0;
        IBaseUser r2 = r1.getUser();
        String r3 = null;
        if (r2 == null) goto L13;
        String r4 = r2.getIdString();
    L14:
        if (r4 == null) goto L27;
        IBaseUser r9 = r1.getUser();
        if (r9 == null) goto L18;
        String r10 = r9.getIdString();
    L19:
        IRoom r12 = this.d;
        if (r12 == null) goto L25;
        IBaseUser r13 = r12.getOwner();
        if (r13 == null) goto L25;
        r3 = r13.getIdString();
    L25:
        if (Intrinsics.areEqual(r10, r3) == false) goto L27;
        boolean r14 = true;
    L28:
        if (r14 == true) goto L9;
        r7.add(r0);
        goto L9
    L18:
        r10 = null;
    L27:
        r14 = false;
        goto L28
    L13:
        r4 = null;
        goto L14
    L30:
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r16 = r7.iterator();
    L32:
        if (r16.hasNext() == false) goto L39;
        IBaseUser r17 = ((com.bytedance.android.livesdk.link.model.p) r16.next()).getUser();
        if (r17 == null) goto L37;
        String r18 = r17.getIdString();
        if (r18 == null) goto L37;
    L38:
        r15.add(r18);
    L37:
        r18 = "";
        goto L38
    L39:
        j(r15);
        return;
    }
}
