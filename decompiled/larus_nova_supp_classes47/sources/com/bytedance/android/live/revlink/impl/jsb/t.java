package com.bytedance.android.live.revlink.impl.jsb;

import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorLinkPanelResultModel;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInLinkSettingDialog;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.cc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends wy0.b<cc, OpenAnchorLinkPanelResultModel> {
    public final Type a;
    public final boolean b;
    public final IRoom c;
    public final com.bytedance.android.livesdk.revenue.service.room.c d;

    public static final class a {
    }

    static {
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public t(IRoom r1, com.bytedance.android.livesdk.revenue.service.room.c r2) {
        this.c = r1;
        this.d = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(cc.class));
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.revenue.room.a r3 = r2.getRoomContext();
        if (r3 == null) goto L7;
        boolean r4 = r3.getCommonIsAnchor();
    L8:
        this.b = r4;
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // wy0.b
    public final void l(vh7.j r6, CallContext r7) {
        cc r8 = (cc) r6;
        Intrinsics.checkNotNullParameter(r8, "param");
        Intrinsics.checkNotNullParameter(r7, "callContext");
        jy0.b.f("OpenAnchorLinkPanelMethod", "panelType:" + r8.T5(), null, 4);
        if (r8.T5() == 1) goto L5;
        return;
    L5:
        if (this.b == false) goto L11;
        IRoom r9 = this.c;
        if (r9 == null) goto L12;
        Intrinsics.checkNotNullParameter(r9, "room");
        Intrinsics.checkNotNullParameter(r7, "callContext");
        Context r10 = r7.getContext();
        int r0 = AnchorInLinkSettingDialog.G;
        p8.a(AnchorInLinkSettingDialog.a.a(r9, true, 4), r10);
        return;
    L12:
        return;
    }
}
