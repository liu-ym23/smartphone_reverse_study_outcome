package com.bytedance.android.livesdk.gift.vs.tray.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.m;
import com.bytedance.android.livesdk.gift.platform.business.tray2.VSGiftMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import gm2.h;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n12.e;
import n12.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\u0002H\u0014R\u001c\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R&\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0019\u0010%\u001a\u0004\u0018\u00010$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/tray/viewmodel/VSGiftTrayViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "updateState", "Lgm2/h;", "pendingMsg", BuildConfig.FLAVOR, "consumeOne", "initViewModel", "Lcom/bytedance/android/livesdk/gift/vs/tray/viewmodel/a;", "event", "sendEvent", "tryConsumeOne", "onCleared", "Ln12/f;", "kotlin.jvm.PlatformType", "strategy", "Ln12/f;", "Lcom/bytedance/android/live/core/utils/StateMachine;", "Lcom/bytedance/android/livesdk/gift/vs/tray/viewmodel/c;", "Lcom/bytedance/android/livesdk/gift/vs/tray/viewmodel/b;", "stateMachine", "Lcom/bytedance/android/live/core/utils/StateMachine;", "Landroidx/lifecycle/MutableLiveData;", "state", "Landroidx/lifecycle/MutableLiveData;", "getState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "currentMsg", "getCurrentMsg", "setCurrentMsg", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", "priorityMessageListener", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftTrayViewModel extends ViewModel {
    private MutableLiveData<NormalGiftMessage> currentMsg;
    private final DataCenter dataCenter;
    private final y priorityMessageListener;
    private final MutableLiveData<c> state;
    private final StateMachine<c, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a, b> stateMachine;
    private final f strategy;

    public static final class a implements y {
        public final /* synthetic */ VSGiftTrayViewModel a;

        public a(VSGiftTrayViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.y
        public final boolean Lc(NormalGiftMessage r2) {
            return VSGiftTrayViewModel.access$consumeOne(this.a, r2);
        }
    }

    private final void updateState() {
        this.state.setValue(this.stateMachine.b());
    }

    public final void initViewModel() {
        this.state.setValue(c.C0089c.a);
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager r1 = VSGiftMessageManager.a.a();
        r1.a = this.priorityMessageListener;
    }

    public final void tryConsumeOne() {
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().c(1);
    }

    public void onCleared() {
        super.onCleared();
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager r1 = VSGiftMessageManager.a.a();
        r1.a = null;
        r1.b = null;
        r1.c.clear();
    }

    public final MutableLiveData<NormalGiftMessage> getCurrentMsg() {
        return this.currentMsg;
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final MutableLiveData<c> getState() {
        return this.state;
    }

    public VSGiftTrayViewModel(DataCenter r3) {
        this.dataCenter = r3;
        this.strategy = e.a();
        int r4 = d.a;
        final Function1<StateMachine.c<? extends c, ? extends com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a, ? extends b>, Unit> r5 = new VSGiftTrayViewModel$stateMachine$1(this);
        Intrinsics.checkNotNullParameter(r5, "listener");
        StateMachine.a r0 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a, b>, Unit> r1 = new VSGiftTrayStateMachine$createVSGiftTrayStateMachine$1(r5);
        r0.getClass();
        this.stateMachine = StateMachine.a.a(r1);
        this.state = new NextLiveData();
        this.currentMsg = new NextLiveData();
        this.priorityMessageListener = new a(this);
        initViewModel();
    }

    public static final /* synthetic */ void access$updateState(VSGiftTrayViewModel r0) {
        r0.updateState();
    }

    private final boolean consumeOne(h r7) {
        if ((r7 instanceof NormalGiftMessage) == true) goto L6;
        return false;
    L6:
        if ((r7 instanceof m) == false) goto L9;
        sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a.c.a);
        return true;
    L9:
        DataCenter r0 = this.dataCenter;
        if (r0 == null) goto L14;
        Boolean r1 = (Boolean) r0.get("data_is_portrait", Boolean.TRUE);
        if (r1 == null) goto L14;
        boolean r2 = r1.booleanValue();
    L16:
        if (x.b() == true) goto L22;
        if (r2 == false) goto L22;
        n01.a r3 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), n01.a.class);
        if (r3 == null) goto L34;
        if (r3.Yd() == true) goto L22;
    L34:
        if (Intrinsics.areEqual((c) this.state.getValue(), c.a.a) == false) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual((c) this.state.getValue(), c.C0089c.a) == true) goto L52;
        NormalGiftMessage r4 = (NormalGiftMessage) r7;
        if (r4.p == true) goto L52;
        if (c22.a.a((NormalGiftMessage) this.currentMsg.getValue(), r4) == false) goto L51;
        NormalGiftMessage r5 = (NormalGiftMessage) this.currentMsg.getValue();
        if (r5 == null) goto L46;
        long r6 = r5.m;
    L48:
        if (r6 > r4.m) goto L50;
        this.currentMsg.postValue(r7);
    L50:
        return true;
    L46:
        r6 = 0;
        goto L48
    L51:
        return false;
    L52:
        this.currentMsg.postValue(r7);
        return true;
    L22:
        NormalGiftMessage r8 = (NormalGiftMessage) r7;
        IBaseUser r9 = r8.e;
        if (r9 == null) goto L25;
        String r10 = r9.getIdString();
    L26:
        boolean r11 = TextUtils.equals(r10, com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        if ((r7 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L29;
    L30:
        if (r11 == false) goto L32;
        com.bytedance.android.livesdk.gift.platform.business.normal.utils.b.c(r8, this.strategy);
        goto L34
    L32:
        com.bytedance.android.livesdk.gift.platform.business.normal.utils.b.b(r8, this.strategy);
        goto L34
    L29:
        if (r8.p == false) goto L34;
    L25:
        r10 = null;
    L14:
        r2 = true;
        goto L16
    }

    public final void sendEvent(com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<c, com.bytedance.android.livesdk.gift.vs.tray.viewmodel.a, b> r0 = this.stateMachine;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    public final void setCurrentMsg(MutableLiveData<NormalGiftMessage> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentMsg = r2;
    }

    public static final /* synthetic */ boolean access$consumeOne(VSGiftTrayViewModel r0, h r1) {
        return r0.consumeOne(r1);
    }
}
