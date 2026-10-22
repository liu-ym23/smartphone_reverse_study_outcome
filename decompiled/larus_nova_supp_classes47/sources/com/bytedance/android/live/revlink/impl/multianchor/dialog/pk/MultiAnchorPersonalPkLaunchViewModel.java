package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import y31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001(\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b1\u00102J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0006\u0010\f\u001a\u00020\u0005R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0011\u0010.\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u00100\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b/\u0010-¨\u00063"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorPersonalPkLaunchViewModel;", "Landroidx/lifecycle/ViewModel;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "attach", "", "Lcom/bytedance/android/livesdk/link/model/p;", "getCurrentAnchorList", "onCleared", "dismiss", "Landroidx/lifecycle/MutableLiveData;", "Ly31/u;", "personalPkSwitchMultiData", "Landroidx/lifecycle/MutableLiveData;", "getPersonalPkSwitchMultiData", "()Landroidx/lifecycle/MutableLiveData;", "", "npkInvitePageSource", "Ljava/lang/String;", "getNpkInvitePageSource", "()Ljava/lang/String;", "setNpkInvitePageSource", "(Ljava/lang/String;)V", "Lio/reactivex/subjects/CompletableSubject;", "onDismissEvent", "Lio/reactivex/subjects/CompletableSubject;", "getOnDismissEvent", "()Lio/reactivex/subjects/CompletableSubject;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lyz0/l;", "messageManager", "Lyz0/l;", "Li11/b;", "linkUserCenter", "Li11/b;", "com/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorPersonalPkLaunchViewModel$a", "linkUserCallback", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorPersonalPkLaunchViewModel$a;", "", "getHasApplicant", "()Z", "hasApplicant", "getHasInvitee", "hasInvitee", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPersonalPkLaunchViewModel extends ViewModel {
    private final CompositeDisposable cd;
    private final a linkUserCallback;
    private final i11.b linkUserCenter;
    private final yz0.l messageManager;
    private String npkInvitePageSource;
    private final CompletableSubject onDismissEvent;
    private final MutableLiveData<u> personalPkSwitchMultiData;

    public static final class a extends i11.c.a {
        public final /* synthetic */ MultiAnchorPersonalPkLaunchViewModel a;

        public a(MultiAnchorPersonalPkLaunchViewModel r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void b(int r2, List<? extends com.bytedance.android.livesdk.link.model.p> r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            i11.b r4 = MultiAnchorPersonalPkLaunchViewModel.access$getLinkUserCenter$p(this.a);
            if (r4 == null) goto L9;
            List<com.bytedance.android.livesdk.link.model.p> r5 = r4.getOnlineUserList();
            if (r5 == null) goto L9;
            int r6 = r5.size();
        L11:
            if (r6 > 2) goto L14;
            this.a.dismiss();
            return;
        L14:
            this.a.getPersonalPkSwitchMultiData().setValue(new u(CollectionsKt.toList(r3)));
            return;
        L9:
            r6 = 0;
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorPersonalPkLaunchViewModel$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(MultiAnchorPersonalPkLaunchViewModel r8) {
            super(1, r8, MultiAnchorPersonalPkLaunchViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            MultiAnchorPersonalPkLaunchViewModel.access$onMessage((MultiAnchorPersonalPkLaunchViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public final void attach() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L5;
        r0.i(this.linkUserCallback);
    L5:
        yz0.l r1 = this.messageManager;
        if (r1 == null) goto L12;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r2 = yz0.h.a.a(r1, com.bytedance.android.live.revenue.common.message.b.e, false, 6);
        if (r2 == null) goto L12;
        final AnonymousClass1 r3 = new AnonymousClass1(this);
        Disposable r4 = r2.subscribe(new b(r3));
        if (r4 == null) goto L12;
        RxUtilKt.c(r4, this.cd);
    L12:
        i11.b r5 = this.linkUserCenter;
        if (r5 == null) goto L18;
        List<com.bytedance.android.livesdk.link.model.p> r6 = r5.d();
        if (r6 == null) goto L19;
        this.personalPkSwitchMultiData.postValue(new u(r6));
        return;
    L19:
        return;
    }

    public final void dismiss() {
        this.onDismissEvent.onComplete();
    }

    public final boolean getHasApplicant() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L13;
        List<com.bytedance.android.livesdk.link.model.p> r1 = r0.a();
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        if (((com.bytedance.android.livesdk.link.model.p) r2.next()).getRoleType() != 4) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        return false;
    }

    public final boolean getHasInvitee() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L13;
        List<com.bytedance.android.livesdk.link.model.p> r1 = r0.a();
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        if (((com.bytedance.android.livesdk.link.model.p) r2.next()).getRoleType() == 4) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        return false;
    }

    public MultiAnchorPersonalPkLaunchViewModel() {
        this.personalPkSwitchMultiData = new MutableLiveData();
        this.onDismissEvent = new CompletableSubject();
        this.cd = new CompositeDisposable();
        this.messageManager = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.linkUserCenter = y.a();
        this.linkUserCallback = new a(this);
    }

    public final List<com.bytedance.android.livesdk.link.model.p> getCurrentAnchorList() {
        List<com.bytedance.android.livesdk.link.model.p> r1 = null;
        if (y.d() == false) goto L7;
        com.bytedance.android.live.revlink.impl.pk.service.b r0 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r0 == null) goto L12;
        r1 = r0.getCurrentAnchorList();
    L12:
        if (r1 == null) goto L14;
        return r1;
    L14:
        return CollectionsKt.emptyList();
    L7:
        i11.b r2 = this.linkUserCenter;
        if (r2 == null) goto L12;
        List<com.bytedance.android.livesdk.link.model.p> r3 = r2.getOnlineUserList();
        if (r3 == null) goto L12;
        r1 = CollectionsKt.toList(r3);
        goto L12
    }

    public void onCleared() {
        super.onCleared();
        this.cd.dispose();
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L6;
        r0.l(this.linkUserCallback);
        return;
    }

    public final String getNpkInvitePageSource() {
        return this.npkInvitePageSource;
    }

    public final CompletableSubject getOnDismissEvent() {
        return this.onDismissEvent;
    }

    public final MutableLiveData<u> getPersonalPkSwitchMultiData() {
        return this.personalPkSwitchMultiData;
    }

    public static final /* synthetic */ i11.b access$getLinkUserCenter$p(MultiAnchorPersonalPkLaunchViewModel r0) {
        return r0.linkUserCenter;
    }

    private final void onMessage(yh6.c r1) {
        if ((r1 instanceof r0) == false) goto L6;
        dismiss();
        return;
    }

    public final void setNpkInvitePageSource(String r1) {
        this.npkInvitePageSource = r1;
    }

    public static final /* synthetic */ void access$onMessage(MultiAnchorPersonalPkLaunchViewModel r0, yh6.c r1) {
        r0.onMessage(r1);
    }
}
