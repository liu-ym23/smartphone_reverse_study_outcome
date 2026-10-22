package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p6 implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ InteractPlayViewManager a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ LivePlayerView e;
    public final /* synthetic */ IRoom f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;

    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2) {
        Intrinsics.checkNotNullParameter(r2, "request");
        com.bytedance.android.live.core.utils.f2.g();
    }

    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r10, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "response");
        InteractPlayViewManager r0 = this.a;
        InteractPlayViewManager.a(r0, r11.a, this.b, this.c, this.d, this.e, this.g, this.h, r0.b);
    }

    public p6(InteractPlayViewManager r1, int r2, int r3, JSONObject r4, LivePlayerView r5, IRoom r6, int r7, int r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
