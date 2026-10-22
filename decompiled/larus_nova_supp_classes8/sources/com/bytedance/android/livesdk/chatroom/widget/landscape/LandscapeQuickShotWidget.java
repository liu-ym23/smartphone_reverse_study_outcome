package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.live.IAnchorBacktrackService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.QuickShotShotControl, needDynamicControl = true, type = PlayerViewControl.Type.ALPHA)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotAndRecordBaseWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/QuickShotPresenter$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeQuickShotWidget extends LandscapeQuickShotAndRecordBaseWidget implements QuickShotPresenter.b, Observer<KVData>, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public static final /* synthetic */ int h = 0;
    public ImageView a;
    public IAnchorBacktrackService b;
    public QuickShotPresenter c;
    public IRoom d;
    public boolean e;
    public final CompositeDisposable f;
    public final CompositeDisposable g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LandscapeQuickShotWidget a;

        public b(LandscapeQuickShotWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LandscapeQuickShotWidget r5 = this.a;
            int r0 = LandscapeQuickShotWidget.h;
            r5.getClass();
            long r1 = System.currentTimeMillis();
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.m().logQuickShotBtnClick(r1);
            QuickShotPresenter r6 = r5.c;
            if (r6 == null) goto L6;
            r6.b(r1);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LandscapeQuickShotWidget a;

        public c(LandscapeQuickShotWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            ImageView r0 = this.a.a;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
        L6:
            if (((PadOrientation) sh6.c.b(r4)) != PadOrientation.LANDSCAPE) goto L8;
            boolean r5 = true;
        L9:
            UtilityKotlinExtentionsKt.z(r0, r5);
            return;
        L8:
            r5 = false;
            goto L9
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LandscapeQuickShotWidget a;

        public d(LandscapeQuickShotWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            boolean r1 = false;
            if (((Boolean) r5).booleanValue() == false) goto L9;
            ImageView r6 = this.a.a;
            if (r6 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
        L7:
            UtilityKotlinExtentionsKt.z(r6, false);
            return;
        L9:
            if (PadConfigUtils.c() == false) goto L22;
            ImageView r7 = this.a.a;
            if (r7 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
        L13:
            PadOrientation r3 = null;
            vr1.u r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this.a, 1);
            if (r0 == null) goto L19;
            com.bytedance.live.datacontext.n<PadOrientation> r2 = r0.w();
            if (r2 == null) goto L19;
            r3 = (PadOrientation) r2.getValue();
        L19:
            if (r3 != PadOrientation.LANDSCAPE) goto L21;
            r1 = true;
        L21:
            UtilityKotlinExtentionsKt.z(r7, r1);
            return;
        L22:
            ImageView r8 = this.a.a;
            if (r8 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
        L25:
            UtilityKotlinExtentionsKt.z(r8, true);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567246;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        List r1 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_layer_show", "data_live_quick_shot_layer_hide", "data_audience_backtrace_service", "data_backtrack_service", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.removeObserver((String) r2.next(), this);
    L10:
        this.f.clear();
        this.g.clear();
    }

    public LandscapeQuickShotWidget() {
        this.e = true;
        this.f = new CompositeDisposable();
        this.g = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.e;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Intrinsics.checkNotNullParameter(r6, "t");
        String r7 = r6.getKey();
        boolean r1 = false;
        IAnchorBacktrackService.State r2 = null;
        switch(r7.hashCode()) {
            case -1956533084: goto L41;
            case -904942447: goto L38;
            case 118051045: goto L29;
            case 836394094: goto L20;
            case 2132946469: goto L13;
            case 2133273568: goto L6;
            default: goto L65;
        };
    L65:
        return;
    L6:
        if (r7.equals("data_live_quick_shot_layer_show") == false) goto L48;
        this.e = false;
        gr1.a r8 = jr1.c.a();
        if (r8 == null) goto L49;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r9 = r8.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r9 == null) goto L50;
        r9.j(false);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L13:
        if (r7.equals("data_live_quick_shot_layer_hide") == false) goto L52;
        this.e = true;
        gr1.a r10 = jr1.c.a();
        if (r10 == null) goto L53;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r11 = r10.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r11 == null) goto L54;
        r11.j(false);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L20:
        if (r7.equals("data_audience_backtrace_service") == false) goto L56;
        IAnchorBacktrackService r12 = this.b;
        if (r12 == null) goto L25;
        r2 = r12.getState();
    L25:
        if (r2 != IAnchorBacktrackService.State.BACKTRACK_DOING) goto L27;
        r1 = true;
    L27:
        xq(r1);
        return;
    L56:
        return;
    L29:
        if (r7.equals("data_backtrack_service") == false) goto L58;
        IAnchorBacktrackService r13 = this.b;
        if (r13 == null) goto L34;
        r2 = r13.getState();
    L34:
        if (r2 != IAnchorBacktrackService.State.BACKTRACK_DOING) goto L36;
        r1 = true;
    L36:
        xq(r1);
        return;
    L58:
        return;
    L38:
        if (r7.equals("data_live_quick_record_finish") == false) goto L60;
        this.e = true;
        return;
    L60:
        return;
    L41:
        if (r7.equals("data_live_quick_record_start") == false) goto L62;
        this.e = true;
        gr1.a r14 = jr1.c.a();
        if (r14 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r15 = r14.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r15 == null) goto L64;
        r15.j(false);
        return;
    L64:
        return;
    L63:
        return;
    }

    public final void onLoad(Object[] r9) {
        this.b = (IAnchorBacktrackService) ((Widget) this).dataCenter.get("data_backtrack_service", null);
        gr1.a r10 = jr1.c.a();
        if (r10 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r11 = r10.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r11 == null) goto L13;
        VSPlayerViewControlContext r12 = r11.provideContext();
        if (r12 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.getPlayerViewVisible();
        if (r13 == null) goto L13;
        Disposable r14 = i80.a.a(r13, new AnonymousClass1(this));
        if (r14 == null) goto L13;
        RxUtilKt.c(r14, this.g);
    L13:
        this.a = (ImageView) findViewById(2131389924);
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L88;
        IRoom r16 = (IRoom) r15.get("data_room");
        if (r16 == null) goto L89;
        this.d = r16;
        this.c = new QuickShotPresenter(getContext(), ((Widget) this).dataCenter, r16, this);
        ImageView r17 = this.a;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L21:
        r17.setOnClickListener(new b(this));
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L29;
        List r2 = CollectionsKt.mutableListOf(new String[]{"data_live_quick_shot_layer_show", "data_live_quick_shot_layer_hide", "data_audience_backtrace_service", "data_backtrack_service", "data_live_quick_record_start", "data_live_quick_record_finish"});
        if (r2 == null) goto L29;
        Iterator r3 = r2.iterator();
    L27:
        if (r3.hasNext() == false) goto L29;
        r18.observe((String) r3.next(), this);
    L29:
        xq(false);
        if (PadConfigUtils.c() == false) goto L40;
        vr1.u r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r4 == null) goto L40;
        com.bytedance.live.datacontext.n<PadOrientation> r5 = r4.w();
        if (r5 == null) goto L40;
        Observable r6 = r5.a();
        if (r6 == null) goto L40;
        ObservableSubscribeProxy r7 = (ObservableSubscribeProxy) r6.as(autoDispose());
        if (r7 == null) goto L40;
        r7.subscribe(new q(this));
    L40:
        ImageView r8 = this.a;
        if (r8 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L43:
        if (r8 == null) goto L46;
        r3.c(r8, "快拍", true);
    L46:
        if (PadConfigUtils.c() == false) goto L67;
        ImageView r19 = this.a;
        if (r19 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L50:
        vr1.u r20 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r20 == null) goto L55;
        com.bytedance.live.datacontext.n<PadOrientation> r21 = r20.w();
        if (r21 == null) goto L55;
        PadOrientation r22 = (PadOrientation) r21.getValue();
    L57:
        if (r22 != PadOrientation.LANDSCAPE) goto L59;
        boolean r23 = true;
    L60:
        UtilityKotlinExtentionsKt.z(r19, r23);
        vr1.u r1 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(null, this, 1);
        if (r1 == null) goto L67;
        com.bytedance.live.datacontext.n<PadOrientation> r24 = r1.w();
        if (r24 == null) goto L67;
        Observable r25 = r24.a();
        if (r25 == null) goto L67;
        r25.subscribe(new c(this));
        goto L67
    L59:
        r23 = false;
    L55:
        r22 = null;
    L67:
        com.bytedance.live.datacontext.m<Boolean> r26 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(((Widget) this).dataCenter);
        if (r26 == null) goto L74;
        Observable r27 = r26.a();
        if (r27 == null) goto L74;
        Disposable r28 = r27.subscribe(new d(this));
        if (r28 == null) goto L74;
        RxUtilKt.c(r28, this.f);
    L74:
        com.bytedance.live.datacontext.m<Boolean> r29 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.b().castScreenMode(((Widget) this).dataCenter);
        if (r29 != null) goto L77;
    L82:
        ImageView r30 = this.a;
        if (r30 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L85:
        r30.setImageResource(2131251386);
        return;
    L77:
        if (((Boolean) r29.getValue()).booleanValue() != true) goto L82;
        ImageView r31 = this.a;
        if (r31 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L81:
        UtilityKotlinExtentionsKt.z(r31, false);
        goto L82
    L89:
        return;
    }

    public final void xq(boolean r4) {
        IRoom r0 = this.d;
        if (r0 == null) goto L13;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L13;
        if (r1.enableLandscapeQuickShot() != true) goto L13;
        ImageView r2 = this.a;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L12:
        UtilityKotlinExtentionsKt.z(r2, !r4);
        return;
    L13:
        ImageView r5 = this.a;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("quickShotBtn");
    L16:
        UtilityKotlinExtentionsKt.t(r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter.b
    public final PopupWindow Xc(long r8, Bitmap r10, VideoViewParams r11) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "videoParam");
        bs1.b r12 = new bs1.b(((Widget) this).contentView, r10, "", r8);
        int r9 = bs1.a.a;
        DataCenter r13 = ((Widget) this).dataCenter;
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "param");
        r13.put("data_live_quick_shot_bitmap", r12);
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter.b
    public final void vp(long r2, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "failReason");
        bs1.a.a(r2, r4, r5);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter.b
    public final void ya(String r8, long r9, Bitmap r11, VideoViewParams r12) {
        Intrinsics.checkNotNullParameter(r8, "path");
        Intrinsics.checkNotNullParameter(r11, "bitmap");
        Intrinsics.checkNotNullParameter(r12, "videoParam");
        bs1.b r13 = new bs1.b(((Widget) this).contentView, r11, r8, r9);
        int r10 = bs1.a.a;
        bs1.a.b(((Widget) this).dataCenter, r13);
    }
}
