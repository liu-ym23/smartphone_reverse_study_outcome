package com.bytedance.android.livesdk.interactivity.multicamera;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import pp1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ MultiCameraServiceWidget a;
    public final /* synthetic */ c b;

    public a(MultiCameraServiceWidget r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        MultiCameraServiceWidget r5 = this.a;
        c r0 = this.b;
        y3.m(((Widget) r5).dataCenter).b(ToolbarButton.MULTI_CAMERA, r0);
        ((Property) this.a.i.getValue()).setValue(Boolean.FALSE);
    }
}
