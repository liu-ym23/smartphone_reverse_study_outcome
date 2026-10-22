package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.app.Activity;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import kotlin.jvm.internal.Intrinsics;
import mya.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.a implements u, rgb.a.b {
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c g;
    public IMessageListComponent h;
    public rgb.a i;
    public RecyclerView j;
    public y6b.a<ShareGroupChatContentVO> k;

    public static final class a {
    }

    public static final class b implements IMessageListComponent.a {
        public final /* synthetic */ k a;

        public final /* synthetic */ void A9() {
        }

        public final void B9(ChatChatter r2) {
            Intrinsics.checkNotNullParameter(r2, "chatChatter");
        }

        public final void e(BasePageStore r2) {
            Intrinsics.checkNotNullParameter(r2, "store");
        }

        public final void w9(ThreadTopic r2) {
            Intrinsics.checkNotNullParameter(r2, "threadTopic");
        }

        public final /* synthetic */ void x9() {
        }

        public final void z9(Chat r2) {
            Intrinsics.checkNotNullParameter(r2, "chat");
        }

        public final void y9() {
            IMessageListComponent r0 = this.a.h;
            if (r0 == null) goto L8;
            mya.h r1 = r0.j5();
            if (r1 == null) goto L9;
            r1.a(u.class, this.a);
            return;
        L9:
            return;
        }

        public b(k r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void D() {
        rgb.a r0 = this.i;
        if (r0 == null) goto L5;
        int r1 = FlowBottomSheet.c;
        r0.b(true);
    L5:
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
    }

    public k() {
    }

    public final void g(y6b.a<ShareGroupChatContentVO> r9) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Chat r1 = (Chat) r9.b().b.getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        this.k = r9;
        if (r1.isMember() == false) goto L9;
        int r10 = FlowChatModule.d;
        FlowChatModule.a.a().f(getContext(), r1.getId(), null);
        return;
    L9:
        if (this.j == null) goto L17;
        Context r3 = getContext();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        rgb.a r2 = new rgb.a((Activity) r3, this);
        if ((((Number) r9.b().d.getValue()).longValue() * ((long) AudioViewModel.ASR_SESSION_IDLE)) >= System.currentTimeMillis()) goto L13;
        boolean r11 = true;
    L14:
        rgb.a.C0319a r4 = new rgb.a.C0319a(r1, r11);
        Intrinsics.checkNotNullParameter(r4, "data");
        r2.f = r4;
        r2.e();
        this.i = r2;
        r2.d();
        return;
    L13:
        r11 = false;
        goto L14
    }

    @Override // rgb.a.b
    public final void v(Chat r5) {
        Intrinsics.checkNotNullParameter(r5, "chat");
        y6b.a<ShareGroupChatContentVO> r6 = this.k;
        if (r6 != null) goto L5;
        return;
    L5:
        ShareGroupChatContentVO r0 = r6.b();
        String r1 = (String) r0.c.getValue();
        if (r1 != null) goto L9;
        return;
    L9:
        if (((ShareGroupChatContent.GroupState) r0.e.getValue()) != null) goto L11;
        ShareGroupChatContent.GroupState r2 = ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY;
    L13:
        if (r2 != ShareGroupChatContent.GroupState.CAN_JOIN_DIRECTLY) goto L19;
        final Context r3 = getContext();
        m2b.b r4 = this.g;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("chatApp");
        r4 = null;
    L17:
        w.a(r4).j0().t9(r6.getId(), r1, new UIGetDataCallback(new FlowShareGroupCardPlugin$doJoinGroupChat$callback$1(r3, this)));
        return;
    L19:
        return;
    L11:
        r2 = (ShareGroupChatContent.GroupState) r0.e.getValue();
        goto L13
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        this.g = r2;
        IMessageListComponent r4 = r2.a(IMessageListComponent.class);
        if (r4 == null) goto L5;
        SceneCoordinateRecyclerView r5 = r4.Et();
    L6:
        this.j = r5;
        IMessageListComponent r6 = r2.a(IMessageListComponent.class);
        this.h = r6;
        if (r6 == null) goto L10;
        r6.m(new b(this));
        return;
    L10:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
