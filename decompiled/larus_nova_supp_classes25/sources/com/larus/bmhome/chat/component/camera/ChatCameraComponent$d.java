package com.larus.bmhome.chat.component.camera;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.camera.command.e;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.g;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import de8.d;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatCameraComponent$d implements e {
    public final /* synthetic */ ChatCameraComponent a;

    @Override // com.larus.bmhome.chat.camera.command.e
    public final Pair<z0, Boolean> A7() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        g r2 = r0.vc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.A7();
    }

    @Override // com.larus.bmhome.chat.camera.command.e
    public final Pair<z0, Boolean> N8() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        g r2 = r0.vc();
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.N8();
    }

    @Override // com.larus.bmhome.chat.camera.command.e
    public final wc9.e O8() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        return r0.P2();
    }

    @Override // com.larus.bmhome.chat.camera.command.e
    public final void P8() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        ICoreInputAbility r2 = r0.H3();
        if (r2 == null) goto L6;
        r2.C1(false, false, "");
        return;
    }

    @Override // com.larus.bmhome.chat.camera.command.e
    public final BotModel a() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        return r0.U2();
    }

    @Override // com.larus.bmhome.chat.camera.command.e
    public final long chatKey() {
        ChatCameraComponent r0 = this.a;
        int r1 = ChatCameraComponent.S;
        return d.a(r0.f1());
    }

    public ChatCameraComponent$d(ChatCameraComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.camera.command.e
    public final void b(SuggestedAction r2) {
        this.a.k = r2;
    }
}
