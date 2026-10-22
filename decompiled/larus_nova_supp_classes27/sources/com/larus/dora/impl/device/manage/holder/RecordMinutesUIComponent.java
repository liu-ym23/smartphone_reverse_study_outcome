package com.larus.dora.impl.device.manage.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common_ui.widget.roundlayout.RoundRelativeLayout;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusItemDoraGDeviceManagementRecordMinutesBinding;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import com.larus.dora.impl.device.manage.t0;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u001aH\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u000fH\u0002J\b\u00103\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/RecordMinutesUIComponent;", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementRecordMinutesBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusItemDoraGDeviceManagementRecordMinutesBinding;", "cardState", "Lcom/larus/dora/impl/device/manage/holder/RecordMinutesUIComponent$CardState;", "isOnlineRecording", "", "isOfflineRecording", "selectDeviceMac", "", "selectDeviceIsConnected", "Ljava/lang/Boolean;", "avLinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "getAvLinkService", "()Lcom/larus/avlink/api/IDoraAVLinkService;", "avLinkService$delegate", "Lkotlin/Lazy;", "durationListener", "Lkotlin/Function1;", "", "", "recordingUpdateListener", "offlineRecordingUpdateListener", "onCreateAndSetupView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onBind", "data", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "initView", "renderCurrentState", "source", "adjustViewState", "newState", "formatDuration", "seconds", "onDeviceSwitch", "event", "Lcom/larus/dora/impl/device/manage/DeviceSwitchEvent;", "reportClickEvent", "button", "onDestroy", "Companion", "CardState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesUIComponent extends LifecycleUIComponent {
    public static final /* synthetic */ int n = 0;
    public LarusItemDoraGDeviceManagementRecordMinutesBinding d;
    public CardState e;
    public boolean f;
    public boolean g;
    public String h;
    public Boolean i;
    public final Lazy j;
    public final y k;
    public final z l;
    public final a0 m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/RecordMinutesUIComponent$CardState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ONLINE_RECORDING", "OFFLINE_RECORDING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CardState extends Enum<CardState> {
        public static final CardState IDLE = null;
        public static final CardState OFFLINE_RECORDING = null;
        public static final CardState ONLINE_RECORDING = null;
        public static final /* synthetic */ CardState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CardState> getEntries() {
            return b;
        }

        static {
            CardState r0 = new CardState("IDLE", 0);
            IDLE = r0;
            CardState r1 = new CardState("ONLINE_RECORDING", 1);
            ONLINE_RECORDING = r1;
            CardState r3 = new CardState("OFFLINE_RECORDING", 2);
            OFFLINE_RECORDING = r3;
            CardState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static CardState[] values() {
            return (CardState[]) a.clone();
        }

        public static CardState valueOf(String r1) {
            return (CardState) r27.a.a(CardState.class, r1);
        }

        public CardState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardState.values().length];
            r0[CardState.ONLINE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CardState.OFFLINE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CardState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final IDoraAVLinkService h() {
        return (IDoraAVLinkService) this.j.getValue();
    }

    public final LarusItemDoraGDeviceManagementRecordMinutesBinding i() {
        LarusItemDoraGDeviceManagementRecordMinutesBinding r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.manage.holder.y] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device.manage.holder.z] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device.manage.holder.a0] */
    public RecordMinutesUIComponent() {
        this.j = LazyKt.lazy(new x());
        this.k = new y(this);
        this.l = new z(this);
        this.m = new a0(this);
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void onDestroy() {
        super.onDestroy();
        IDoraAVLinkService r0 = h();
        if (r0 == null) goto L5;
        r0.y0(this.k);
    L5:
        IDoraAVLinkService r1 = h();
        if (r1 == null) goto L8;
        r1.L0(this.l);
    L8:
        IDoraAVLinkService r2 = h();
        if (r2 == null) goto L12;
        r2.g1(this.m);
        return;
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void b(p0 r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Boolean r1 = null;
        if ((r3 instanceof t0) == false) goto L5;
        t0 r4 = (t0) r3;
    L6:
        if (r4 == null) goto L8;
        r1 = Boolean.valueOf(r4.e);
    L8:
        this.i = r1;
        IDoraAVLinkService r5 = h();
        boolean r0 = false;
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        this.f = r6;
        IDoraAVLinkService r7 = h();
        if (r7 != null) goto L17;
    L19:
        this.g = r0;
        j("onBind");
        return;
    L17:
        if (r7.d() != true) goto L19;
        r0 = true;
        goto L19
    L11:
        if (r5.Y0() != true) goto L13;
        r6 = true;
        goto L14
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final void e(com.larus.dora.impl.device.manage.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        com.larus.dora.impl.device.manage.c r4 = r3.a;
        Boolean r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.c;
    L6:
        this.h = r1;
        if (r4 == null) goto L9;
        r0 = Boolean.valueOf(r4.f);
    L9:
        this.i = r0;
        j("onDeviceSwitch");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void j(String r4) {
        if (this.f == false) goto L6;
        CardState r0 = CardState.ONLINE_RECORDING;
    L9:
        g49.d.d("RecordMinutesUIComponent", "adjustViewState from " + r4 + ", state=" + r0);
        if (r0 != CardState.IDLE) goto L19;
        this.e = r0;
        e1.o(i().e);
        i().e.setText("00:00:00");
        i().c.cancelAnimation();
        e1.o(i().c);
        e1.x(i().d);
        i().b.setText(2131902678);
        Boolean r5 = this.i;
        if (r5 == null) goto L14;
        boolean r6 = r5.booleanValue();
    L15:
        if (r6 == false) goto L17;
        i().b.setTextColorWithPress(ve8.d.a(2131103136, i().a.getContext()));
        return;
    L17:
        i().b.setTextColorWithPress(ve8.d.a(2131103165, i().a.getContext()));
        return;
    L14:
        r6 = o59.a.k(DoraAdapterExtKt.h(kj4.a.g()));
        goto L15
    L19:
        if (this.e == r0) goto L33;
        this.e = r0;
        if (r0 != CardState.ONLINE_RECORDING) goto L24;
        e1.x(i().e);
    L25:
        e1.x(i().c);
        boolean r7 = v19.h.a;
        if (v19.h.b(i().a.getContext()) == false) goto L28;
        i().c.addLottieOnCompositionLoadedListener(new w(this));
    L29:
        e1.o(i().d);
        i().b.setText(2131902680);
        i().b.setTextColorWithPress(ve8.d.a(2131102625, i().a.getContext()));
        return;
    L28:
        i().c.playAnimation();
        goto L29
    L24:
        e1.o(i().e);
        i().e.setText("00:00:00");
        goto L25
    L33:
        return;
    L6:
        if (this.g == false) goto L8;
        r0 = CardState.OFFLINE_RECORDING;
        goto L9
    L8:
        r0 = CardState.IDLE;
        goto L9
    }

    public final void k(String r5) {
        DoraBuryPointManager.a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "device_management"), TuplesKt.to("card_content_type", "dora_voice_memos"), TuplesKt.to("button_type", r5)}));
    }

    @Override // com.larus.dora.impl.device.manage.LifecycleUIComponent
    public final View c(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "container");
        View r10 = r8.inflate(2131562557, r9, false);
        int r11 = 2131364844;
        RoundTextView r3 = (RoundTextView) ViewBindings.findChildViewById(r10, 2131364844);
        if (r3 == null) goto L24;
        r11 = 2131374786;
        if (((ImageView) ViewBindings.findChildViewById(r10, 2131374786)) == null) goto L24;
        r11 = 2131379221;
        LottieAnimationView r4 = ViewBindings.findChildViewById(r10, 2131379221);
        if (r4 == null) goto L24;
        r11 = 2131391257;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131391257);
        if (r5 == null) goto L24;
        r11 = 2131391258;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, 2131391258);
        if (r6 == null) goto L24;
        RoundRelativeLayout r12 = (RoundRelativeLayout) r10;
        this.d = new LarusItemDoraGDeviceManagementRecordMinutesBinding(r12, r3, r4, r5, r6);
        IDoraAVLinkService r13 = h();
        if (r13 == null) goto L15;
        r13.t1(this.k);
    L15:
        IDoraAVLinkService r14 = h();
        if (r14 == null) goto L18;
        r14.h1(this.l);
    L18:
        IDoraAVLinkService r15 = h();
        if (r15 == null) goto L21;
        r15.T0(this.m);
    L21:
        e1.d(i().a, new q(this));
        e1.d(i().b, new v(this));
        i().c.setAnimation(com.larus.dora.impl.util.u.a.b("larus_dora_record_minutes_wave"));
        return r12;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
