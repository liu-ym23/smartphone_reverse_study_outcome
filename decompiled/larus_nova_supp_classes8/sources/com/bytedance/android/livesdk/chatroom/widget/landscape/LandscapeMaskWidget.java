package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zg1.n3;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeMaskWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeMaskWidget extends RoomRecyclableWidget {
    public View a;
    public View b;
    public final Lazy c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LandscapeMaskWidget a;

        public a(LandscapeMaskWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            n3 r5 = (n3) r4;
            Intrinsics.checkNotNullParameter(r5, "event");
            LandscapeMaskWidget r0 = this.a;
            DataCenter r1 = ((Widget) r0).dataCenter;
            int r2 = 0;
            if (VrUtils.s() == true) goto L8;
            View r3 = ((Widget) r0).contentView;
            if (r3 == null) goto L8;
            r3.setVisibility(0);
        L8:
            if (VrUtils.t(((Widget) r0).dataCenter, false) == true) goto L12;
            View r6 = ((Widget) r0).contentView;
            if (r6 == null) goto L20;
            r6.setVisibility(0);
            return;
        L20:
            return;
        L12:
            View r7 = ((Widget) r0).contentView;
            if (r7 == null) goto L22;
            if (r5 != null) goto L16;
        L18:
            r7.setVisibility(r2);
            return;
        L16:
            if (r5.a != true) goto L18;
            r2 = 8;
            goto L18
        }
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final int getLayoutId() {
        return 2131566555;
    }

    public final void onUnload() {
    }

    public LandscapeMaskWidget() {
        this.c = InfraKotlinExtsKt.mainThreadLazy(LandscapeMaskWidget$maskAlpha$2.INSTANCE);
    }

    public final void onEvent(x0 r4) {
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.isOptLandscapeMargin();
        if (r1 == null) goto L9;
        int r2 = 1;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
    L10:
        int r3 = (-r4.c) - r2;
        int r5 = -r4.d;
        UIUtils.updateLayoutMargin(((Widget) this).contentView, r3, -3, r5, -3);
        return;
    L9:
        r2 = 0;
        goto L10
    }

    public final void onInit(Object[] r3) {
        this.a = findViewById(2131389183);
        this.b = findViewById(2131377118);
        View r4 = this.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMaskView");
    L5:
        r4.setAlpha(((Number) this.c.getValue()).floatValue());
        View r5 = this.b;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L8:
        r5.setAlpha(((Number) this.c.getValue()).floatValue());
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L17;
        ((ViewGroup) r6).setClipToPadding(false);
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L15;
        ((ViewGroup) r7).setClipChildren(false);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void onLoad(Object[] r6) {
        View r7 = this.a;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMaskView");
    L5:
        r7.setTranslationY(0.0f);
        View r8 = this.b;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L8:
        r8.setTranslationY(0.0f);
        if (z.o(((Widget) this).dataCenter).isMediaRoom() == false) goto L14;
        View r9 = this.b;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L13:
        r9.setVisibility(8);
    L18:
        RoomContext r10 = getDataContext();
        if (r10 == null) goto L24;
        com.bytedance.live.datacontext.m r11 = r10.getLandscapeRootChange();
        if (r11 == null) goto L24;
        onEvent((x0) r11.getValue());
        ((ObservableSubscribeProxy) r11.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b(new LandscapeMaskWidget$onLoad$1$1(this)));
    L24:
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L27;
        a r1 = new a(this);
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r1);
    L27:
        if (VrUtils.s() == true) goto L29;
    L33:
        View r12 = ((Widget) this).contentView;
        if (r12 == null) goto L39;
        r12.setVisibility(0);
        return;
    L39:
        return;
    L29:
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L33;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L37;
        r13.setVisibility(8);
        return;
    L37:
        return;
    L14:
        View r14 = this.b;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bottomMaskView");
    L17:
        r14.setVisibility(0);
        goto L18
    }
}
