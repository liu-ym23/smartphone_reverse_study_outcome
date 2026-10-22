package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {
    public final CompositeDisposable b;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final ToolbarButton a;
        public final pp1.c b;
        public final c c;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return BubbleId.LivePlayOpt;
        }

        public a() {
            this.a = ToolbarButton.PLAY_QUALITY_OPT;
            int r0 = pp1.c.o;
            this.b = pp1.c.a.a("可在「播放优化」中修改设置");
            this.c = new c();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return this.c;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.b;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            if (((Boolean) r1).booleanValue() == true) goto L5;
            return;
        L5:
            if (TopSpeedModeUtils.d().k() == false) goto L9;
            i0.h(new e(this));
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        TopSpeedModeManager r0 = TopSpeedModeManager.l;
        if (((Boolean) r0.h.a).booleanValue() == true) goto L5;
        RxUtilKt.c(r0.h.subscribe(new b(this)), this.b);
        return;
    L5:
        if (TopSpeedModeUtils.d().k() == false) goto L9;
        a();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        this.b.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        if (TopSpeedModeUtils.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (TopSpeedModeUtils.d().k() == false) goto L7;
        return true;
    }

    public d(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.b = new CompositeDisposable();
    }
}
