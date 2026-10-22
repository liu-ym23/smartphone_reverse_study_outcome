package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputPanelComponentSyncData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputPanelComponentSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/InteractivityResourceServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractivityResourceServiceWidget extends MiddlewareRoomRecyclableWidget implements vlc.l {
    public InteractivityPlatformContext a;
    public vlc.d b;
    public Disposable c;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r5) {
            InputPanelComponentSyncData r6 = (InputPanelComponentSyncData) r5;
            if (r6 == null) goto L17;
            List<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r7 = r6.data;
            if (r7 == null) goto L27;
            Iterator<com.bytedance.android.livesdk.interactivity.api.comment.data.f> r8 = r7.iterator();
        L8:
            if (r8.hasNext() == false) goto L28;
            com.bytedance.android.livesdk.interactivity.api.comment.data.f r0 = r8.next();
            if (r0 == null) goto L8;
            if (r0.icon == null) goto L8;
            IHostFrescoHelper r1 = jc1.k.f(IHostFrescoHelper.class);
            if (r1 == null) goto L8;
            r1.loadFirstAvailableImageBitmap(r0.icon, new k(r0));
            goto L8
        L28:
            return;
        L27:
            return;
        }
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        vlc.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        Disposable r1 = this.c;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public InteractivityResourceServiceWidget() {
    }

    public final void onLoad(Object[] r3) {
        this.a = j.a(((Widget) this).dataCenter);
        Lazy r4 = PublicScreenABHelper.a;
        vlc.d r0 = null;
        if (((Boolean) PublicScreenABHelper.m.getValue()).booleanValue() == false) goto L18;
        InteractivityPlatformContext r5 = this.a;
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.j<InputPanelComponentSyncDataModel> r6 = r5.getInputPanelComponentSyncDataModelModel();
    L8:
        if (r6 == null) goto L18;
        InputPanelComponentSyncDataModel r7 = (InputPanelComponentSyncDataModel) r6.getValue();
        if (r7 == null) goto L16;
        dc2.c<InputPanelComponentSyncData> r8 = r7.getInputPanelComponentSyncData();
        if (r8 == null) goto L16;
        Observable<InputPanelComponentSyncData> r9 = r8.d;
        if (r9 == null) goto L16;
        Disposable r10 = r9.subscribe(a.a);
    L17:
        this.c = r10;
    L16:
        r10 = null;
        goto L17
    L7:
        r6 = null;
    L18:
        vlc.d r11 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r11 == null) goto L21;
        r11.addMessageListener("WebcastInteractionInfoMessage", this);
        Unit r1 = Unit.INSTANCE;
        r0 = r11;
    L21:
        this.b = r0;
    }

    public final void onMessage(tlc.d r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if ((r4 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.api.i) == false) goto L18;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.i r5 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.i) r4;
        List<Integer> r0 = r5.getUpdateInfoType();
        if (r0 == null) goto L30;
        Iterator<Integer> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L31;
        if (r1.next().intValue() != 1) goto L8;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r r2 = r5.getLikeIconInfo();
        if (r2 == null) goto L8;
        InteractivityPlatformContext r3 = this.a;
        if (r3 == null) goto L8;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r> r6 = r3.getLikeIconInfo();
        if (r6 == null) goto L8;
        r6.setValue(r2);
        goto L8
    L31:
        return;
    L30:
        return;
    }
}
