package com.larus.bmhome.chat.component.camera;

import com.larus.bmhome.chat.camera.command.f;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.reference.a;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatCameraComponent$b implements f {
    public final /* synthetic */ ChatCameraComponent a;

    @Override // com.larus.bmhome.chat.camera.command.f
    public final BotModel a() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        y r2 = r0.u0();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.j0();
    }

    @Override // com.larus.bmhome.chat.camera.command.f
    public final boolean c1() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        ICoreInputAbility r2 = r0.H3();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.c1() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.chat.camera.command.f
    public final boolean i9() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        a r2 = (a) r0.H.getValue();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.i9() != true) goto L7;
        return true;
    }

    @Override // com.larus.bmhome.chat.camera.command.f
    public final boolean k5() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        g1 r2 = r0.m3();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isVisible() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public ChatCameraComponent$b(ChatCameraComponent r1) {
        this.a = r1;
    }
}
