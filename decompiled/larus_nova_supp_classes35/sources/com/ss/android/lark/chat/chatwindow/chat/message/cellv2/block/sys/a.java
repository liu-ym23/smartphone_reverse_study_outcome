package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.button.e;
import com.ss.android.lark.image.api.SimpleTarget;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends SimpleTarget<Drawable> {
    public final /* synthetic */ SysChatGuideContentBlock a;
    public final /* synthetic */ UDButton b;
    public final /* synthetic */ String c;

    public final void onLoadFailed(Drawable r2) {
        UDButton r3 = this.b;
        String r0 = this.c;
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        e.b(r3, r0);
    }

    public final void onResourceReady(Object r4) {
        Drawable r5 = (Drawable) r4;
        if (r5 == null) goto L10;
        int r1 = this.a.h;
        r5.setBounds(new Rect(0, 0, r1, r1));
        UDButton r0 = this.b;
        com.larksuite.component.universe_design.button.a r2 = new com.larksuite.component.universe_design.button.a();
        String r3 = this.c;
        if (r3 != null) goto L8;
        r3 = BuildConfig.FLAVOR;
    L8:
        r2.b = r3;
        Unit r6 = Unit.INSTANCE;
        e.d(r0, r5, r2);
        return;
    }

    public a(SysChatGuideContentBlock r1, UDButton r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
