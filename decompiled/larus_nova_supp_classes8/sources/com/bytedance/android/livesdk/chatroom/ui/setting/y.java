package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.broadcast.api.model.IMiddlewareAnchorVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.h2;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y extends mx.j {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DataCenter a;
        public final /* synthetic */ ListDialogAbility b;

        public a(DataCenter r1, ListDialogAbility r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            h2 r0 = new h2();
            r0.p4(r3, this.a);
            r0.onClick(r3);
            this.b.dismissDialog();
            r0.R9(r3, this.a);
        }
    }

    public y(DataCenter r5, ListDialogAbility r6) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "ability");
        String r0 = (String) ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt().getValue();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        super("选择清晰度", r0, false, 12);
        ((mx.j) this).l = new a(r5, r6);
    }
}
