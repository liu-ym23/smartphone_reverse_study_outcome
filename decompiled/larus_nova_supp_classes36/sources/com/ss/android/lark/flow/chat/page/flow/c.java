package com.ss.android.lark.flow.chat.page.flow;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b3b.f;
import b3b.h;
import b3b.i;
import b3b.q;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.blueprint.o;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.ChatAdapterV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.CoreIMBlueprintFactory;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.MessageListEventDispatchFeature;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.file.FlowFileMessageClickListener;
import com.ss.android.lark.flow.chat.message.FlowChatBlueprintFactory;
import com.ss.android.lark.flow.chat.message.image.FlowChatImageClickListener;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import v4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends h4b.b {
    public final Fragment c;
    public final Function3<m2b.a, List<? extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a<?, ?, ?>>, List<? extends xya.a>, o<y6b.a<?>>> d;
    public FlowChatImageClickListener e;
    public qgb.a f;

    public c(FrameFragment r2, Function3 r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(CoreIMBlueprintFactory.class);
        this.c = r2;
        this.d = r3;
    }

    public final h d(Chat r2, FragmentActivity r3, IMessageListViewModel r4, m2b.a r5) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        return new FlowFileMessageClickListener(r2, r3, r4, r5);
    }

    public final i b(Chat r7, v r8, FragmentActivity r9, IMessageListViewModel r10, MessageListEventDispatchFeature.a r11, m2b.a r12) {
        Intrinsics.checkNotNullParameter(r7, "chat");
        Intrinsics.checkNotNullParameter(r8, "chatContainer");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "dependency");
        FlowChatImageClickListener r13 = this.e;
        if (r13 == null) goto L5;
        return r13;
    L5:
        FlowChatImageClickListener r14 = new FlowChatImageClickListener(r8, r9, r10, r11, r12);
        this.e = r14;
        return r14;
    }

    public final q e(Chat r7, v r8, FragmentActivity r9, IMessageListViewModel r10, m2b.a r11, IMessageListComponent.f r12) {
        Intrinsics.checkNotNullParameter(r7, "chat");
        Intrinsics.checkNotNullParameter(r8, "chatContainer");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        qgb.a r13 = this.f;
        if (r13 == null) goto L5;
        return r13;
    L5:
        qgb.a r14 = new qgb.a(r8, r9, r10, r11, r12);
        this.f = r14;
        return r14;
    }

    public final /* bridge */ /* synthetic */ void g(SceneCoordinateRecyclerView r1, com.ss.android.lark.chat.chatwindow.chat.a r2, m2b.a r3, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r4, f r5, d r6, v4b.c r7, Function0 r8) {
        h(r1, (ChatAdapterV2) r2, r3, r4, r5, r6, r7, r8);
    }

    public final void h(SceneCoordinateRecyclerView r15, ChatAdapterV2 r16, m2b.a r17, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r18, f r19, d r20, v4b.c r21, Function0 r22) {
        Intrinsics.checkNotNullParameter(r15, "recyclerView");
        Intrinsics.checkNotNullParameter(r16, "adapter");
        Intrinsics.checkNotNullParameter(r17, "messageContext");
        Intrinsics.checkNotNullParameter(r18, "onCellClickHandler");
        Intrinsics.checkNotNullParameter(r19, "callbackHub");
        Intrinsics.checkNotNullParameter(r22, "complete");
        com.ss.android.lark.blueprint.d r2 = new FlowChatBlueprintFactory(r17, new b(r18), r19, r20, r21, this.c, r15, this.d).create();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r16.b = r2;
        r22.invoke();
    }
}
