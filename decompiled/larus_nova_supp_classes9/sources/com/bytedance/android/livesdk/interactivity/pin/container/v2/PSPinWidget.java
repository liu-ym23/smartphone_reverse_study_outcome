package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.PinContainerAppLogger;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/container/v2/PSPinWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "Lg42/g;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSPinWidget extends RoomWidget implements g42.g, Observer<KVData> {
    public a b;
    public com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b c;
    public String d;
    public Boolean e;
    public final g42.c f;

    public static final class a {
        public final HighlightItem a;
        public final g42.e b;
        public final AbsPSHighlightComp c;

        public a(HighlightItem r2, g42.e r3, AbsPSHighlightComp r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "comp");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PSPinWidget a;

        public b(PSPinWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            List r13 = (List) r11;
            PSPinWidget r0 = this.a;
            r0.getClass();
            AbsPSHighlightComp r2 = null;
            if (r13.isEmpty() == false) goto L13;
            o32.a.a("highlight items is empty");
            com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r14 = r0.c;
            if (r14 == null) goto L7;
            r14.a(CollectionsKt.emptyList());
        L7:
            a r15 = r0.b;
            if (r15 == null) goto L12;
            AbsPSHighlightComp r16 = r15.c;
            if (r16 == null) goto L12;
            r16.b();
        L12:
            r0.b = null;
            return;
        L13:
            HighlightItem r17 = (HighlightItem) CollectionsKt.firstOrNull(r13);
            if (r17 == null) goto L74;
            g42.f r1 = r0.f.m(r17);
            if (r1 == null) goto L70;
            String r4 = r1.c(r17);
            if (r4 == null) goto L75;
            a r3 = r0.b;
            if (r3 == null) goto L26;
            HighlightItem r5 = r3.a;
            if (r5 == null) goto L26;
            String r6 = r5.getUniqueKey();
        L28:
            if (Intrinsics.areEqual(r6, r4) == false) goto L43;
            a r7 = r0.b;
            if (r7 == null) goto L43;
            AbsPSHighlightComp r8 = r7.c;
            if (r8 == null) goto L43;
            if (((IPSHighlightCompLifecycle$State) r8.b.a) != IPSHighlightCompLifecycle$State.Showed) goto L36;
            boolean r9 = true;
        L37:
            if (r9 != true) goto L43;
            if (r7 == null) goto L42;
            g42.e r10 = r7.b;
            if (r10 == null) goto L42;
            r10.update(r0.f, r17);
        L42:
            o32.a.a("highlight item is same");
            r0.wq();
            return;
        L36:
            r9 = false;
        L43:
            a r18 = r0.b;
            if (r18 == null) goto L48;
            AbsPSHighlightComp r19 = r18.c;
            if (r19 == null) goto L48;
            r19.b();
        L48:
            r0.b = null;
            g42.f r20 = r0.f.m(r17);
            if (r20 == null) goto L72;
            g42.e r21 = r20.g(((Widget) r0).context);
            if (r21 == null) goto L76;
            IPublicScreenService r23 = (IPublicScreenService) jc1.k.f(IPublicScreenService.class);
            if (r23 == null) goto L63;
            HighlightAreaPriorityConfig r24 = r17.getHighlightAreaPriorityConfig();
            long r25 = 200;
            if (r24 == null) goto L58;
            long r26 = r24.getShowPriority();
        L59:
            HighlightAreaPriorityConfig r27 = r17.getHighlightAreaPriorityConfig();
            if (r27 == null) goto L62;
            r25 = r27.getLocationPriority();
        L62:
            r2 = r23.createFastHighlightComp(r4, new PSHighlightType.a(r26, r25), ((Widget) r0).context, ((Widget) r0).dataCenter, new PSPinWidget$bindPSHighlightItems$comp$1(r0, r21, r17));
            goto L63
        L58:
            r26 = 200;
        L63:
            if (r2 == null) goto L77;
            r0.b = new a(r17, r21, r2);
            r2.q();
            com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r28 = r0.c;
            if (r28 == null) goto L73;
            r28.a(CollectionsKt.listOf(r17));
            return;
        L73:
            return;
        L77:
            return;
        L76:
            return;
        L72:
            return;
        L26:
            r6 = null;
            goto L28
        L75:
            return;
        L70:
            return;
        }
    }

    public final int getLayoutId() {
        return 2131566663;
    }

    public final void onDestroy() {
        this.f.d(this);
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        a r0 = this.b;
        if (r0 == null) goto L7;
        AbsPSHighlightComp r1 = r0.c;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        this.b = null;
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r2 = this.c;
        if (r2 == null) goto L10;
        r2.a(CollectionsKt.emptyList());
    L10:
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r3 = this.c;
        if (r3 == null) goto L13;
        ((LinkedHashMap) r3.a).clear();
    L13:
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public final void wq() {
        a r0 = this.b;
        if (r0 == null) goto L18;
        HighlightItem r1 = r0.a;
        if (r1 == null) goto L19;
        String r2 = this.f.c(r1);
        boolean r3 = this.f.i(r1);
        if ((!Intrinsics.areEqual(r2, this.d)) == false) goto L10;
    L11:
        g42.f r4 = this.f.m(r1);
        if (r4 == null) goto L14;
        PinType r5 = r4.f();
    L15:
        int r6 = PinContainerAppLogger.a;
        PinContainerAppLogger.g(r1, r5, "user", this.f.g(r5));
    L16:
        this.d = r2;
        this.e = Boolean.valueOf(r3);
        return;
    L14:
        r5 = null;
        goto L15
    L10:
        if ((!Intrinsics.areEqual(Boolean.valueOf(r3), this.e)) == false) goto L16;
    L19:
        return;
    }

    public final void onCreate() {
        super.onCreate();
        this.c = new com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b(this.f);
        ((ObservableSubscribeProxy) this.f.k().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b(this));
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.observe("cmd_anchor_broadcast_end", this);
    L5:
        this.f.a(this);
    }

    public PSPinWidget(com.bytedance.android.livesdk.interactivity.pin.container.v2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "pinContainer");
        this.f = r2;
    }

    public final void onChanged(Object r10) {
        KVData r11 = (KVData) r10;
        if (r11 == null) goto L34;
        String r13 = r11.getKey();
        if (r13.hashCode() == (-1677062600)) goto L9;
        return;
    L9:
        if (r13.equals("cmd_anchor_broadcast_end") == true) goto L11;
        return;
    L11:
        if (z.e(this.f.getDataCenter(), false) == false) goto L28;
        a r14 = this.b;
        if (r14 == null) goto L28;
        HighlightItem r1 = r14.a;
        g42.f r15 = this.f.m(r1);
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r2 = null;
        if (r15 == null) goto L17;
        PinType r3 = r15.f();
    L18:
        if (r15 == null) goto L20;
        r2 = r15.q(r1);
    L20:
        if (r2 == null) goto L22;
        long r4 = r2.getMessageId();
    L23:
        if (r2 == null) goto L26;
        String r16 = r2.getCommentContent();
        if (r16 == null) goto L26;
    L27:
        int r5 = PinContainerAppLogger.a;
        PinContainerAppLogger.f(r1, r3, r4, r16, z.e(((Widget) this).dataCenter, false), "live_end", this.f.g(r3));
    L26:
        r16 = BuildConfig.FLAVOR;
        goto L27
    L22:
        r4 = 0;
        goto L23
    L17:
        r3 = null;
    L28:
        com.bytedance.android.livesdk.interactivity.pin.container.v2.utils.b r17 = this.c;
        if (r17 == null) goto L33;
        r17.a(CollectionsKt.emptyList());
        return;
    L33:
        return;
    }
}
