package com.ss.android.lark.chat.chatwindow.biz.plugin.watermark;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.chat.chatwindow.biz.plugin.core.c;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class WaterMarkPlugin extends c {
    public static final /* synthetic */ int i = 0;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public ChatWatermarkViewModel h;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        ljb.a.a().qa(B());
        ChatWatermarkViewModel r0 = this.h;
        if (r0 == null) goto L5;
        r0.updateWatermarkState(2);
    L5:
        super.D();
    }

    public final void F() {
        ljb.a.a().C4(B());
        ChatWatermarkViewModel r0 = this.h;
        if (r0 == null) goto L6;
        r0.updateWatermarkState(3);
        return;
    }

    public WaterMarkPlugin() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super.C(r2, r3);
        this.g = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void z(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3, final i7b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        Intrinsics.checkNotNullParameter(r4, "initData");
        IMessageListComponent r5 = (IMessageListComponent) r3.a(IMessageListComponent.class);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r1 = this.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatApp");
        r1 = null;
    L5:
        Fragment r0 = r1.getFragment();
        if (r0 == null) goto L8;
        this.h = (ChatWatermarkViewModel) new ViewModelProvider(r0).get(ChatWatermarkViewModel.class);
    L8:
        if (r5 == null) goto L13;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L14;
        r6.addObserver(new WaterMarkPlugin$doInit$1(this, r4));
        return;
    L14:
        return;
    }
}
