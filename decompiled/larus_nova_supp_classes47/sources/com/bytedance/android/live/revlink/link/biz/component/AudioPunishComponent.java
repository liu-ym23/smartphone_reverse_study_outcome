package com.bytedance.android.live.revlink.link.biz.component;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.link.model.z;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AudioPunishComponent implements com.bytedance.android.live.revlink.link.biz.service.e {
    public final String a;
    public final CompositeDisposable b;
    public com.bytedance.android.live.revlink.impl.mergepk.pkbase.a c;
    public final IRoom d;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d e;
    public final com.bytedance.android.livesdk.revenue.service.room.c f;
    public final PkBaseDataContext g;
    public final com.bytedance.android.live.revlink.impl.multianchor.ui.i h;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AudioPunishComponent$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(AudioPunishComponent r8) {
            super(0, r8, AudioPunishComponent.class, "onSwitchSceneEvent", "onSwitchSceneEvent()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m880invoke() {
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r0 = ((AudioPunishComponent) ((CallableReference) this).receiver).c;
            if (r0 == null) goto L34;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.h;
            String r2 = null;
            if (r1 == null) goto L9;
            MutableLiveData<z> r3 = r1.getAudioPunishInfo();
            if (r3 == null) goto L9;
            z r4 = (z) r3.getValue();
        L10:
            if (r4 == null) goto L12;
            r2 = r4.getUserId();
        L12:
            if (r4 == null) goto L14;
            long r5 = r4.getRemainSeconds();
        L15:
            com.bytedance.android.live.revlink.impl.global.c r6 = r0.e;
            if (r6 == null) goto L21;
            com.bytedance.android.live.revlink.impl.pk.service.d r7 = r6.o9();
            if (r7 == null) goto L21;
            String r8 = r7.guestLinkMicId();
            if (r8 == null) goto L21;
        L22:
            jy0.b.d("audio_punish", "handlePunishBySwitchScene punishUserId = " + r2 + ", remainSeconds = " + r5 + ",guestLinkmicId = " + r8);
            if (r0.f == false) goto L35;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r9 = r0.h;
            if (r9 == null) goto L36;
            List<String> r10 = r9.getAudioPunishUserIds();
            if (r10 != null) goto L29;
            return;
        L29:
            if (r10.contains(r8) != true) goto L38;
            com.bytedance.android.live.revlink.impl.lynxcontainer.a r12 = com.bytedance.android.live.revlink.link.biz.service.i.U(r0);
            if (r12 == null) goto L39;
            r12.b("double_mute_status", "2");
            return;
        L39:
            return;
        L38:
            return;
        L36:
            return;
        L35:
            return;
        L21:
            r8 = "";
            goto L22
        L14:
            r5 = 0;
        L9:
            r4 = null;
            goto L10
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m880invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.AudioPunishComponent$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/r;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/link/model/r;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.link.model.r, Unit> {
        public AnonymousClass2(AudioPunishComponent r8) {
            super(1, r8, AudioPunishComponent.class, "onMetaDataChange", "onMetaDataChange(Lcom/bytedance/android/livesdk/link/model/IAnchorLinkUserList;)V", 0);
        }

        public final void invoke(com.bytedance.android.livesdk.link.model.r r2) {
            AudioPunishComponent r0 = (AudioPunishComponent) ((CallableReference) this).receiver;
            r0.getClass();
            if (r2 == null) goto L10;
            z r3 = r2.getAudioPunishInfo();
            if (r3 == null) goto L11;
            com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r1 = r0.c;
            if (r1 == null) goto L12;
            r1.b(r3);
            return;
        L12:
            return;
        L11:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.livesdk.link.model.r) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkBaseComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r7 = new com.bytedance.android.live.revlink.impl.mergepk.pkbase.a(getContext(), getContext().r9(), this.d, this.g, this.h, getContext().getLinkDataSet());
        this.c = r7;
        com.bytedance.android.live.revlink.impl.global.c r0 = r7.e;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.c r1 = r0.Oj();
    L6:
        if (r1 == null) goto L10;
        LiveData<z> r2 = r1.getAudioPunishInfo();
        if (r2 == null) goto L10;
        r2.observeForever(r7.d);
    L10:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.g(getContext().t(), new AnonymousClass1(this)), this.b);
        d51.c r3 = d51.c.A0;
        r3.getClass();
        if (((Boolean) d51.c.x0.getValue(r3, d51.c.a[74])).booleanValue() == true) goto L13;
    L14:
        com.bytedance.revenue.platform.api.core.rx.f.a(com.bytedance.android.live.revlink.link.biz.service.i.t(this).Q(new AnonymousClass2(this)), this.b);
        return;
    L13:
        if (getContext().r9() == false) goto L14;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.b.clear();
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.a r0 = this.c;
        if (r0 == null) goto L6;
        r0.detach();
        return;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return this.e;
    }

    public AudioPunishComponent(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d r2, com.bytedance.android.livesdk.revenue.service.room.c r3, PkBaseDataContext r4, com.bytedance.android.live.revlink.impl.multianchor.ui.i r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomService");
        Intrinsics.checkNotNullParameter(r4, "baseDataContext");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = "AudioPunishComponent";
        this.b = new CompositeDisposable();
        IRoom r6 = r3.getRoomContext().getCommonRoom();
        if (r6 == null) goto L7;
        this.d = r6;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoomKt /* = com.bytedance.android.livesdkapi.depend.model.live.IRoom */");
    }
}
