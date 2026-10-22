package com.larus.drive.sdk.impl.component.chat;

import android.view.View;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/larus/drive/sdk/impl/component/chat/DriveFloatChatComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/drive/sdk/api/ability/IDriveFloatChatAbility;", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "allowExpandAfterSend", "", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "Lkotlin/Lazy;", "floatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "getFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "floatChatFoldCoreAbility$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "onFragmentViewDestroyed", "onSendMessage", "msg", "Lcom/larus/im/bean/message/Message;", "enableExpandAfterSend", "enable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFloatChatComponent extends BaseContentWidget implements r79.b, te8.c {
    public int m;
    public boolean n;
    public final Lazy o;
    public final Lazy p;

    public static final class a {
    }

    public static final class b implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class c implements Function0<g0> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g0.class));
        }
    }

    static {
    }

    public final void A2() {
        va8.p r0 = (va8.p) this.o.getValue();
        if (r0 == null) goto L6;
        r0.aI(this);
        return;
    }

    public DriveFloatChatComponent() {
        this.m = 2131365588;
        this.o = LazyKt.lazy(new b(this));
        this.p = LazyKt.lazy(new c(this));
    }

    public final int U2() {
        return this.m;
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (this.n == true) goto L5;
    L11:
        FLogger.a.i("DriveFloatChatComponent", "[onUpdateMessage] Can not show float chat; isAllow=" + this.n);
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.T(r3) == true) goto L11;
        if (com.larus.bmhome.chat.bean.d.W0(r3) == true) goto L11;
        g0 r4 = (g0) this.p.getValue();
        if (r4 == null) goto L13;
        r4.expand("drive_preview_send_msg");
        return;
    }

    public final void N0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void Q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    @Override // r79.b
    public final void az(boolean r1) {
        this.n = r1;
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        va8.p r3 = (va8.p) this.o.getValue();
        if (r3 == null) goto L6;
        r3.hy(this);
        return;
    }

    public final void p(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void v(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
    }

    public final void v1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void y0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }
}
