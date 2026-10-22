package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.livesdk.link.model.bridge.i;
import com.bytedance.android.livesdk.link.model.n;
import com.bytedance.android.livesdk.link.model.z;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR.\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/LinkAudioPunishContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "reset", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/link/model/z;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "audioPunishInfo", "Landroidx/lifecycle/MutableLiveData;", "getAudioPunishInfo", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/global/c;Lyz0/f;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkAudioPunishContext extends DataContext implements c {
    private final MutableLiveData<z> audioPunishInfo;
    private final CompositeDisposable cd;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.LinkAudioPunishContext$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(LinkAudioPunishContext r8) {
            super(1, r8, LinkAudioPunishContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            LinkAudioPunishContext.access$onMessage((LinkAudioPunishContext) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements Action {
        public final /* synthetic */ LinkAudioPunishContext a;

        public a(LinkAudioPunishContext r1) {
            this.a = r1;
        }

        public final void run() {
            LinkAudioPunishContext.access$getCd$p(this.a).dispose();
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.c
    public /* bridge */ /* synthetic */ LiveData getAudioPunishInfo() {
        return m586getAudioPunishInfo();
    }

    @Override // com.bytedance.android.live.revlink.impl.mergepk.pkbase.c
    public void reset() {
        m586getAudioPunishInfo().postValue(null);
    }

    /* JADX INFO: renamed from: getAudioPunishInfo, reason: collision with other method in class */
    public MutableLiveData<z> m586getAudioPunishInfo() {
        return this.audioPunishInfo;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(LinkAudioPunishContext r0) {
        return r0.cd;
    }

    private final void onMessage(yh6.c r2) {
        if ((r2 instanceof i) == false) goto L6;
        n r3 = ((vh7.c) r2).castTo(n.class);
        m586getAudioPunishInfo().postValue(r3.getAudioPunishInfo());
        return;
    }

    public LinkAudioPunishContext(com.bytedance.android.live.revlink.impl.global.c r4, yz0.f r5) {
        this.linkFakeGlobalService = r4;
        this.messageService = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.cd = r6;
        this.audioPunishInfo = new MutableLiveData();
        if (r5 == null) goto L9;
        com.bytedance.android.live.revenue.common.message.a r0 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r1 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r0, "$this$ANCHOR_LINK_MIC_AUDIO_PUNISH");
        Observable r7 = h.a.a(r5, (yh6.b) CommonMessageTypeKt.r.getValue(), false, 6);
        if (r7 == null) goto L9;
        final AnonymousClass1 r2 = new AnonymousClass1(this);
        Disposable r8 = r7.subscribe(new b(r2));
        if (r8 == null) goto L9;
        com.bytedance.revenue.platform.api.core.rx.f.a(r8, r6);
    L9:
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r6);
    }

    public static final /* synthetic */ void access$onMessage(LinkAudioPunishContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }
}
