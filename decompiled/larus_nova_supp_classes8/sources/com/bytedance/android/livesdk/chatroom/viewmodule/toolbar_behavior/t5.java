package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.av0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.interfaces.DraweeController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class t5 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public RoomContext a;
    public View b;
    public HSImageView c;
    public DraweeController d;
    public boolean e;
    public boolean f;
    public long g;
    public final a h;
    public final DataCenter i;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodel.c {
        public final /* synthetic */ t5 a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.VR_MODE;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.g.b;
        }

        public a(t5 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r9) {
            this.a.a("vrAnimScheduled");
            long r10 = System.currentTimeMillis();
            int r0 = av0.a.getValue().a();
            t5 r1 = this.a;
            if ((r10 - r1.g) >= (r0 - 100)) goto L6;
            r1.a("return time=" + (r10 - this.a.g) + ",interval=" + r0);
            return false;
        L6:
            r1.g = r10;
            HSImageView r11 = r1.c;
            if (r11 != null) goto L9;
            return true;
        L9:
            if (r11 == null) goto L11;
            r11.setVisibility(0);
        L11:
            DraweeController r12 = this.a.d;
            if (r12 == null) goto L16;
            Animatable r13 = r12.getAnimatable();
            if (r13 == null) goto L16;
            r13.start();
        L16:
            t5 r14 = this.a;
            if (r14.e == false) goto L21;
            View r15 = r14.b;
            if (r15 == null) goto L21;
            r15.setVisibility(8);
        L21:
            this.a.f = true;
            return true;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
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

    public t5(DataCenter r1) {
        this.i = r1;
        this.h = new a(this);
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d("ToolbarVrModeBehavior", r2);
        return;
    }
}
