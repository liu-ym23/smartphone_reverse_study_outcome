package com.larus.bmhome.chat.component.camera;

import bc8.a;
import com.larus.bmhome.chat.camera.command.p;
import com.larus.feishu.office.im.impl.base.q0;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import iq9.e;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zb8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatCameraComponent$c implements p {
    public final /* synthetic */ ChatCameraComponent a;

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void G8(q0 r1) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void d(SuggestedActionData r1) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final boolean d3() {
        ChatCameraComponent r0 = this.a;
        b r1 = r0.v;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if ((!r2) == false) goto L19;
        a r3 = (a) r0.F.getValue();
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L20;
        return true;
    L20:
        return false;
    L13:
        if (r3.d3() != true) goto L15;
        r4 = true;
        goto L16
    L19:
        return false;
    L5:
        if (r1.c == true) goto L7;
        r2 = true;
        goto L9
    }

    public ChatCameraComponent$c(ChatCameraComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void preload(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void c(String r1, e r2) {
        Intrinsics.checkNotNullParameter(r1, "bizScene");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final List<SuggestedAction> r4(SuggestedActionScene r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "bizScene");
        a r0 = (a) this.a.F.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r4(r2, r3, r4);
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void b(SuggestedActionScene r8, String r9, boolean r10, Function1<? super List<SuggestedAction>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r9, "bizScene");
        Intrinsics.checkNotNullParameter(r11, "callback");
        a r1 = (a) this.a.F.getValue();
        if (r1 == null) goto L6;
        r1.cL(r8, r9, r10, null, r11);
        return;
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void a(SuggestedActionScene r1, String r2, boolean r3, String r4, Function1<? super List<SuggestedAction>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "bizScene");
        Intrinsics.checkNotNullParameter(r5, "callback");
        b(r1, r2, r3, r5);
    }
}
