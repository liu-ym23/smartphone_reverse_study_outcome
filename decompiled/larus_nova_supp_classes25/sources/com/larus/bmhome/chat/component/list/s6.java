package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.trace.z;
import com.larus.bmhome.view.utils.SwipingControlVm;
import kotlin.Lazy;
import qd8.b;
import s1a.a;
import xa8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s6 implements com.larus.bmhome.chat.api.q0.a {
    public final /* synthetic */ ChatListComponent a;

    @Override // com.larus.bmhome.chat.api.q0.a
    public final maa.e C9() {
        return (maa.e) this.a.c3.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.instruction.g D9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.vc();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final z E9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (z) r0.K2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final LifecycleCoroutineScope F9() {
        LifecycleOwner r0 = (LifecycleOwner) a.c(this.a).getViewLifecycleOwnerLiveData().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r0);
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.showcase.x G9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.l4();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final b H9() {
        return (b) this.a.R2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final va8.k I9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (va8.k) r0.j3.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final IChatMessageShareAbility J9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (IChatMessageShareAbility) r0.I2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final ld8.n K9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.d5();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.showcase.y L9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.x5();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final ry8.b M9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.B4();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.bottom.reference.a N9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (com.larus.bmhome.chat.component.bottom.reference.a) r0.T2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final SwipingControlVm O9() {
        if (a.c(this.a).isAdded() == true) goto L5;
        return null;
    L5:
        if (a.c(this.a).isRemoving() == false) goto L7;
        return null;
    L7:
        if (a.c(this.a).isDetached() == false) goto L10;
        return null;
    L10:
        return (SwipingControlVm) ((Lazy) this.a.V1.getValue()).getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final zb8.e P8() {
        return (zb8.e) this.a.d3.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final zd8.b P9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (zd8.b) r0.x2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final d Z8() {
        return (d) this.a.e3.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.push.a a9() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (com.larus.bmhome.chat.component.push.a) r0.b3.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.api.q0 e() {
        return this.a.O;
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final gd8.g h2() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (gd8.g) r0.E2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final o i2() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.F4();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.bottom.multimodal.g r5() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) this.a.U2.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.regen.a s5() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return (com.larus.bmhome.chat.component.regen.a) r0.a3.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final com.larus.bmhome.chat.component.cvs.y u0() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.u0();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final ICoreInputAbility v0() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.T4();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final va8.o w0() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        return r0.q4();
    }

    @Override // com.larus.bmhome.chat.api.q0.a
    public final u7 u3() {
        return this.a;
    }

    public s6(ChatListComponent r1) {
        this.a = r1;
    }
}
