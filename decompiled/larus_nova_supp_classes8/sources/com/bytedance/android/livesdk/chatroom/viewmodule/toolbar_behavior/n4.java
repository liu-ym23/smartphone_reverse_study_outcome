package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.enterroom.EnterKey;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessInject;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, ILivePreviewBusinessInject {
    public final CompositeDisposable a;
    public ILivePreviewBusinessBridge b;
    public final a c;

    public static final class a implements ILiveEnterRoomCallback {
        public final /* synthetic */ n4 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.n4$a$a, reason: collision with other inner class name */
        public static final class C0085a implements ILiveEnterRoomParams {
            public final EnterKey.PreviewToolbar.Gift a;
            public final Bundle b;
            public final String c;
            public final Map<String, String> d;

            public final Bundle getFirstRoomLogParams() {
                return null;
            }

            public C0085a() {
                this.a = EnterKey.PreviewToolbar.Gift.INSTANCE;
                this.b = new Bundle();
                this.c = "send_gift_btn";
                this.d = MapsKt.emptyMap();
            }

            public final Bundle getBusinessBundle() {
                return this.b;
            }

            public final String getClickMethod() {
                return this.c;
            }

            public final Map<String, String> getCommonLogParams() {
                return this.d;
            }

            public final EnterKey getEnterKey() {
                return this.a;
            }
        }

        public a(n4 r1) {
            this.a = r1;
        }

        public final ILiveEnterRoomParams getEnterParams(ILivePreviewBusinessSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            return new C0085a();
        }

        public final void onBeforeEnterRoom(ILivePreviewBusinessSession r4) {
            Intrinsics.checkNotNullParameter(r4, "session");
            HashMap r0 = new HashMap();
            r0.put("module_name", "send_gift_btn");
            ILivePreviewBusinessBridge r1 = this.a.b;
            if (r1 == null) goto L5;
            r1.sendLogger("livesdk_preview_guide_click", r0);
        L5:
            ILiveEnterRoomCallback.DefaultImpls.onBeforeEnterRoom(this, r4);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ n4 a;

        public b(n4 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Unit r4 = (Unit) r3;
            ILivePreviewBusinessBridge r5 = this.a.b;
            if (r5 == null) goto L7;
            ILivePreviewBusinessSession r6 = r5.getSession();
            if (r6 == null) goto L7;
            ILiveEnterRoomScene r7 = r6.getScene();
        L9:
            if (Intrinsics.areEqual(r7, ILiveEnterRoomScene.PreviewToolbar.INSTANCE) == false) goto L14;
            HashMap r8 = new HashMap();
            r8.put("module_name", "send_gift_btn");
            ILivePreviewBusinessBridge r0 = this.a.b;
            if (r0 == null) goto L15;
            r0.sendLogger("livesdk_preview_guide_show", r8);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r7 = null;
            goto L9
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public n4() {
        this.a = new CompositeDisposable();
        this.c = new a(this);
    }

    public final ILiveEnterRoomCallback onBindBridge(ILivePreviewBusinessBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        this.b = r2;
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        View r7 = r5.findViewById(2131387276);
        HSImageView r0 = r5.findViewById(2131362952);
        View r1 = r5.findViewById(2131377125);
        ILivePreviewBusinessBridge r2 = this.b;
        if (r2 == null) goto L9;
        Observable r3 = r2.observeVHSelect();
        if (r3 == null) goto L9;
        Disposable r4 = r3.subscribe(new b(this));
        if (r4 == null) goto L9;
        RxUtilKt.c(r4, this.a);
    L9:
        int r8 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.FALSE) == false) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r7);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r1);
    L12:
        if (r7 == null) goto L14;
        r7.setBackgroundResource(2131252954);
    L14:
        com.bytedance.android.live.core.utils.a1.p(r5, UtilityKotlinExtentionsKt.i(38));
        if (r0 == null) goto L18;
        com.bytedance.android.live.core.utils.a1.l(r0, com.bytedance.android.live.core.utils.s1.f(-14.0f));
        return;
    }
}
