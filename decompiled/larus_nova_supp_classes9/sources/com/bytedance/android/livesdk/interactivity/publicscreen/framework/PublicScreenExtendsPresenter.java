package com.bytedance.android.livesdk.interactivity.publicscreen.framework;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.livesdk.interactivity.api.PSMessageRepositoryStore;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.j;
import com.bytedance.android.livesdk.interactivity.api.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.Store;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.MultiActionAndPriorityMessageBuffer;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/framework/PublicScreenExtendsPresenter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/presenter/TransTextMessagePresenter;", "Lcom/bytedance/android/livesdk/interactivity/api/m;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenExtendsPresenter extends TransTextMessagePresenter implements m {
    public final PublicScreenContext H0;
    public final Collection<h> Z;
    public final Map<String, i.a> k0;
    public final Set<String> p0;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void A0() {
        Iterator<T> r0 = this.p0.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        this.D.dynamicAddMessageType(r1);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void u0() {
        Iterator r0 = ((Iterable) this.H0.getListeners().getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s42.b) r0.next()).g();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter, s42.a
    public final void e() {
        super.e();
        ((PSMessageRepositoryStore) this.H0.getRepository().getValue()).remove(this);
        ((j) this.H0.getFeaturePluginStore().getValue()).unload();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void t0() {
        super.t0();
        Iterator r0 = ((Iterable) this.H0.getListeners().getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s42.b) r0.next()).f();
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void B0(int r2) {
        if (r2 > 0) goto L4;
        return;
    L4:
        if (this.H0.isCleared() == false) goto L6;
        return;
    L6:
        if (((Boolean) this.H0.isMessageListEmpty().getValue()).booleanValue() == false) goto L11;
        this.H0.isMessageListEmpty().setValue(Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean E0(f<?> r5) {
        if ((r5 instanceof z) == true) goto L5;
        return false;
    L5:
        Iterator<T> r0 = this.Z.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((h) r0.next()).a(((z) r5).H);
        goto L7
    L9:
        h r6 = (h) null;
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean F0(f<?> r5) {
        Iterator<T> r0 = this.Z.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((h) r1).b(r5, ShowArea.Fold) == false) goto L4;
    L10:
        if (((h) r1) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean G0(f<?> r5) {
        Iterator<T> r0 = this.Z.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((h) r1).b(r5, ShowArea.Scroll) == false) goto L4;
    L10:
        if (((h) r1) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        r1 = null;
        goto L10
    }

    public final void K0(z r4) {
        if (r4.H.e() == false) goto L8;
        q0(r4);
        if (r.b(r4) == false) goto L7;
        return;
    L7:
        k0(r4, true, true);
        i0(r4.G);
        return;
    L8:
        Iterator<T> r0 = this.Z.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        ((h) r0.next()).d(r4.H);
        goto L10
    L12:
        h r1 = (h) null;
        h0(r4);
        i0(r4.G);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter, s42.a
    public final void W(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        super.W(r2);
        ((PSMessageRepositoryStore) this.H0.getRepository().getValue()).add(this);
        ((j) this.H0.getFeaturePluginStore().getValue()).load();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public final void checkAndRegisterMessageListener(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msgMethod");
        this.D.dynamicAddMessageType(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public final void deleteMessage(i r6) {
        Intrinsics.checkNotNullParameter(r6, "messageModel");
        int r1 = 0;
    L4:
        if (r1 >= ((ArrayList) this.f).size()) goto L24;
        f r2 = (f) ListProtector.get(this.f, r1);
        i r4 = null;
        if ((r2 instanceof z) == true) goto L8;
        r2 = null;
    L8:
        z r3 = (z) r2;
        if (r3 == null) goto L12;
        r4 = r3.H;
    L12:
        if (Intrinsics.areEqual(r4, r6) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        ListProtector.remove(this.f, r1);
        ITextMessageView r7 = ((q46.b) this).a;
        if (r7 != null) goto L16;
        return;
    L16:
        if (r7.d() == false) goto L22;
        ((q46.b) this).a.V50(r1, false);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public final List<i> findMessageByType(PublicScreenConfig$MessageModelType r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.f).iterator();
    L4:
        if (r1.hasNext() == false) goto L19;
        f r2 = (f) r1.next();
        PublicScreenConfig$MessageModelType r4 = null;
        if ((r2 instanceof z) == true) goto L8;
        f r3 = null;
    L9:
        z r5 = (z) r3;
        if (r5 == null) goto L14;
        i r7 = r5.H;
        if (r7 == null) goto L14;
        r4 = r7.getType();
    L14:
        if (r4 != r6) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L4;
        r0.add(r2);
        goto L4
    L16:
        r8 = false;
        goto L17
    L8:
        r3 = r2;
        goto L9
    L19:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r10 = r0.iterator();
    L21:
        if (r10.hasNext() == false) goto L28;
        f r11 = (f) r10.next();
        if (r11 == null) goto L26;
        r9.add(((z) r11).H);
        goto L21
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.textmessage.model.PublicScreenCompatTextMessage");
    L28:
        return CollectionsKt.toMutableList(r9);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void i0(t r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Iterator r0 = ((Iterable) this.H0.getListeners().getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s42.b) r0.next()).a(r3);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public final void insertMessage(i r3) {
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r3, "messageModel");
        K0(new z(new a(), r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.m
    public final void modifyMessage(i r5) {
        Intrinsics.checkNotNullParameter(r5, "messageModel");
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.f).size()) goto L18;
        f r1 = (f) ListProtector.get(this.f, r0);
        i r3 = null;
        if ((r1 instanceof z) == true) goto L8;
        r1 = null;
    L8:
        z r2 = (z) r1;
        if (r2 == null) goto L12;
        r3 = r2.H;
    L12:
        if (Intrinsics.areEqual(r3, r5) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        s0(r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean n0(f<?> r3) {
        if ((r3 instanceof z) == true) goto L7;
        return super.n0(r3);
    L7:
        if (this.T == false) goto L17;
        PersonalizedDisplayInfo r0 = r3.t();
        if (r0 == null) goto L11;
        Boolean r1 = r0.isPersonalized();
    L13:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L17;
        return super.n0(r3);
    L11:
        r1 = null;
    L17:
        if (r3.r != null) goto L20;
        r3.r = Boolean.valueOf(((z) r3).H.g());
    L20:
        return r3.r.booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean o0(f<?> r3) {
        if ((r3 instanceof z) == false) goto L5;
        z r0 = (z) r3;
        r3.y = r0.H.h();
        return r0.y;
    L5:
        return super.o0(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void q0(f<?> r3) {
        Iterator r0 = ((Iterable) this.H0.getListeners().getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s42.b) r0.next()).i(r3);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean v0(f<?> r3) {
        Iterator<T> r0 = this.Z.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((h) r0.next()).c(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void w0(f<?> r3) {
        Iterator r0 = ((Iterable) this.H0.getListeners().getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s42.b) r0.next()).h(r3);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void r0(f<?> r3, ShowArea r4) {
        Intrinsics.checkNotNullParameter(r4, "showArea");
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator r0 = ((Iterable) this.H0.getListeners().getValue()).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((s42.b) r0.next()).j(r3, r4);
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void x0(int r2, long r3) {
        if (this.H0.isCleared() == true) goto L6;
        this.H0.getWaitMessageCount().setValue(Integer.valueOf(r2));
        this.H0.getMessageShowDelay().setValue(Long.valueOf(r3));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final boolean z0(t r7, long r8) {
        Set<String> r0 = this.p0;
        PSMessageAction r1 = null;
        if (r7 == null) goto L5;
        String r2 = r7.getMessageMethod();
    L6:
        boolean r3 = CollectionsKt.contains(r0, r2);
        boolean r4 = false;
        if (r3 == true) goto L9;
        return false;
    L9:
        Map<String, i.a> r5 = this.k0;
        if (r7 == null) goto L12;
        String r6 = r7.getMessageMethod();
    L13:
        i.a r9 = r5.get(r6);
        if (r9 == null) goto L33;
        if (r7 == null) goto L32;
        z92.a r10 = r9.a(r7);
        if (r10 == null) goto L33;
        PSMessageAction r11 = r10.i;
        PSMessageAction r13 = PSMessageAction.UNKNOW;
        if (r11 != r13) goto L30;
        int r14 = r.a;
        Intrinsics.checkNotNullParameter(r7, "message");
        if ((r7 instanceof u3) == false) goto L23;
        PSMessageAction r15 = r.a(((u3) r7).getOrInitPublicAreaCommon());
    L24:
        if (r15 == r13) goto L26;
        r4 = true;
    L26:
        if (r4 == false) goto L28;
        r1 = r15;
    L28:
        if (r1 == null) goto L30;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.i = r1;
        goto L30
    L23:
        r15 = r13;
    L30:
        r10.a = r7.isFromFirstRequest();
        r10.b = r8;
        int r16 = b.a;
        Intrinsics.checkNotNullParameter(r10, "messageModel");
        K0(new z(new a(), r10));
        goto L33
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.IBaseLiveMessage");
    L33:
        return true;
    L12:
        r6 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter
    public final void C0(Boolean r2, PublicScreenHeatState r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f r4, PSMessageHeatState r5) {
        if (this.H0.isCleared() == false) goto L5;
        return;
    L5:
        if (r2 == null) goto L7;
        r2.booleanValue();
        this.H0.isHotState().setValue(r2);
    L7:
        if (r3 == null) goto L9;
        this.H0.getMessageHeat().setValue(r3);
    L9:
        if (r4 == null) goto L11;
        this.H0.getWaitMessageState().setValue(r4);
    L11:
        if (r5 == null) goto L14;
        SimpleDateFormat r6 = PublicScreenMessageMonitor.a;
        Intrinsics.checkNotNullParameter(r5, "heatState");
        PublicScreenMessageMonitor.s = r5;
        this.H0.getMessageHeatState().setValue(r5);
        return;
    }

    public PublicScreenExtendsPresenter(PublicScreenContext r2, IPSMessageRepoManager r3, c r4, com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a r5, q92.a r6) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "repoManager");
        Intrinsics.checkNotNullParameter(r4, "updater");
        Intrinsics.checkNotNullParameter(r5, "waitBuffer");
        Intrinsics.checkNotNullParameter(r6, "config");
        super(r3, r4, r5, r6);
        this.H0 = r2;
        this.Z = ((Store) r2.getInterceptorStore().getValue()).map().values();
        Map<String, i.a> r7 = ((Store) r2.getModelFactoryStore().getValue()).map();
        this.k0 = r7;
        this.p0 = r7.keySet();
        if ((r5 instanceof MultiActionAndPriorityMessageBuffer) == true) goto L5;
        r5 = null;
    L5:
        MultiActionAndPriorityMessageBuffer r8 = (MultiActionAndPriorityMessageBuffer) r5;
        if (r8 == null) goto L8;
        com.bytedance.live.datacontext.m<PSMessageHeatState> r9 = r2.getMessageHeatState();
        Intrinsics.checkNotNullParameter(r9, "source");
        r8.i = r9;
    L8:
        r2.getMessageLogicFacade().d(this);
    }
}
