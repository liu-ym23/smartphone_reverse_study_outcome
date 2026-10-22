package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.text.Editable;
import android.widget.EditText;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterRequest;
import com.bytedance.lark.pb.contact.v2.PullDoubaoChatterResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowAskDoubaoPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c implements ggb.a {
    public IMessageListComponent g;
    public IKeyboardComponent h;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c i;
    public final CoroutineScope j;

    public interface a {
        @SdkCall(50113)
        RucketJob<PullDoubaoChatterResponse> getDoubaoChatter(PullDoubaoChatterRequest r1);
    }

    public static final class b implements IMessageListComponent.a {
        public final /* synthetic */ FlowAskDoubaoPlugin a;

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
            IMessageListComponent r0 = this.a.g;
            if (r0 == null) goto L8;
            mya.h r1 = r0.j5();
            if (r1 == null) goto L9;
            r1.a(ggb.a.class, this.a);
            return;
        L9:
            return;
        }

        public b(FlowAskDoubaoPlugin r1) {
            this.a = r1;
        }
    }

    @Override // ggb.a
    public final void m() {
        IKeyboardComponent r0 = this.h;
        cya.d r1 = null;
        if (r0 == null) goto L7;
        com.ss.android.lark.keyboard.b r2 = r0.n();
        if (r2 == null) goto L7;
        com.ss.android.lark.keyboard.keyboard2.b r3 = r2.L();
    L9:
        if ((r3 instanceof FlowChatKeyboardEditor) == false) goto L11;
        FlowChatKeyboardEditor r4 = (FlowChatKeyboardEditor) r3;
    L12:
        if (r4 == null) goto L14;
        r1 = r4.a();
    L14:
        if (r1 != null) goto L17;
        Log.e("ChatWindowLog", "exitAskDoubaoMode, controller is null ");
        return;
    L17:
        InputStateController r5 = (InputStateController) r1;
        if (r5.d().a() != 2) goto L21;
        r5.pop();
        return;
    L21:
        return;
    L11:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }

    public FlowAskDoubaoPlugin() {
        this.j = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
    }

    public final void D() {
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.D();
        CoroutineScopeKt.cancel$default(this.j, null, 1, null);
    }

    public static final Object F(FlowAskDoubaoPlugin r8, Continuation r9) {
        r8.getClass();
        if ((r9 instanceof FlowAskDoubaoPlugin$insertAtDoubao$1) == false) goto L7;
        FlowAskDoubaoPlugin$insertAtDoubao$1 r0 = (FlowAskDoubaoPlugin$insertAtDoubao$1) r9;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        Chatter r4 = null;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L13
    L28:
        PullDoubaoChatterResponse r11 = (PullDoubaoChatterResponse) r10;     // Catch: Exception -> L13
    L31:
        if (r11 == null) goto L33;
        r4 = r11.doubao;
    L33:
        com.ss.android.lark.chat.entity.chatter.Chatter r12 = com.ss.android.lark.parser.internal.j.a(r4);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r5 = r8.i;
        if (r5 == null) goto L57;
        ChatWindowOpenViewModel r6 = r5.c();
        if (r6 == null) goto L57;
        MutableLiveData r7 = r6.getChat();
        if (r7 == null) goto L57;
        if (((Chat) r7.getValue()) == null) goto L57;
        String r13 = r12.getId();
        String r14 = m.b(r12, ChatterNameDisplayRule.ALIAS_NAME, false);
        String r15 = m.b(r12, ChatterNameDisplayRule.NAME, false);
        IKeyboardComponent r16 = r8.h;
        if (r16 == null) goto L62;
        com.ss.android.lark.keyboard.b r17 = r16.n();
        if (r17 == null) goto L62;
        com.ss.android.lark.keyboard.keyboard2.b r18 = r17.L();
        if (r18 == null) goto L62;
        EditText r19 = r18.c();
        if (r19 == null) goto L62;
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r15);
        ExtensionEditTextCompatKt.j(r19, r13, r14, r15, false, false, true);
        Editable r20 = r19.getText();
        if (r20 == null) goto L61;
        r19.setSelection(r20.length());
    L61:
        return Unit.INSTANCE;
    L62:
        return Unit.INSTANCE;
    L57:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r10);
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r21 = r8.i;
        if (r21 == null) goto L23;
        v r22 = w.a(r21);
        if (r22 == null) goto L23;
        b38.b r23 = r22.y();
        if (r23 == null) goto L23;
        a r24 = (a) r23.create(a.class);
    L24:
        PullDoubaoChatterRequest.Builder r25 = new PullDoubaoChatterRequest.Builder().sync_data_strategy(SyncDataStrategy.LOCAL);
        CoroutineDispatcher r26 = Dispatchers.getIO();     // Catch: Exception -> L13
        FlowAskDoubaoPlugin$insertAtDoubao$response$1 r27 = new FlowAskDoubaoPlugin$insertAtDoubao$response$1(r24, r25, null);     // Catch: Exception -> L13
        r0.label = 1;     // Catch: Exception -> L13
        r10 = BuildersKt.withContext(r26, r27, r0);     // Catch: Exception -> L13
        if (r10 != r2) goto L28;
        return r2;
    L23:
        r24 = null;
    L30:
        r11 = null;
    L7:
        r0 = new FlowAskDoubaoPlugin$insertAtDoubao$1(r8, r9);
        goto L8
    }

    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        this.i = r2;
        this.h = r2.a(IKeyboardComponent.class);
        IMessageListComponent r4 = r2.a(IMessageListComponent.class);
        if (r4 == null) goto L6;
        this.g = r4;
        r4.m(new b(this));
        return;
    }

    @Override // ggb.a
    public final void q(String r10, int r11, PartialReplyInfo r12, boolean r13, final boolean r14, final boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "messageId");
        IMessageListComponent r0 = this.g;
        if (r0 == null) goto L57;
        final MessageInfo r16 = r0.getMessageInfoById(r10);
        if (r16 == null) goto L57;
        if (r12 == null) goto L14;
        RichText r2 = r12.getContent();
        if (r2 == null) goto L14;
        RichTextExtraInfo r3 = r2.getExtraInfo();
        if (r3 == null) goto L14;
        boolean r4 = Intrinsics.areEqual(r3.isPartialReplySelectTextEmpty(), Boolean.TRUE);
    L15:
        if (r4 == false) goto L18;
        Log.e("ChatWindowLog", "onReplyMessage: isPartialReplySelectTextEmpty is true, stops reply message and returns null");
        return;
    L18:
        IKeyboardComponent r1 = this.h;
        VoiceInnerEndPlugin r5 = null;
        if (r1 == null) goto L23;
        com.ss.android.lark.keyboard.b r6 = r1.n();
        if (r6 == null) goto L23;
        com.ss.android.lark.keyboard.keyboard2.b r7 = r6.L();
    L25:
        if ((r7 instanceof FlowChatKeyboardEditor) == false) goto L27;
        FlowChatKeyboardEditor r8 = (FlowChatKeyboardEditor) r7;
    L29:
        if (r8 == null) goto L39;
        VoiceInnerEndPlugin.b r9 = VoiceInnerEndPlugin.t;
        wnb.b r17 = r8.H();
        if (r17 == null) goto L39;
        if ((r17 instanceof VoiceInnerEndPlugin) == false) goto L35;
        r5 = (VoiceInnerEndPlugin) r17;
    L35:
        if (r5 == null) goto L39;
        if (r5.n != true) goto L39;
        final boolean r18 = true;
    L40:
        if (r18 == false) goto L43;
        if (r15 == false) goto L43;
        r13 = true;
    L43:
        IKeyboardComponent r19 = this.h;
        if (r19 == null) goto L50;
        com.ss.android.lark.keyboard.b r20 = r19.n();
        if (r20 == null) goto L50;
        com.ss.android.lark.keyboard.ime.a r21 = r20.z();
        if (r21 == null) goto L50;
        boolean r22 = r21.y();
    L51:
        if (r22 == false) goto L53;
        r13 = false;
    L53:
        IKeyboardComponent r23 = this.h;
        if (r23 == null) goto L59;
        r23.PE(r16, r11, r12, false, r13, new FlowAskDoubaoPlugin$askDoubao$1(r15, r18, this, r14, r16));
        return;
    L59:
        return;
    L50:
        r22 = false;
    L39:
        r18 = false;
        goto L40
    L27:
        r8 = null;
    L23:
        r7 = null;
    L14:
        r4 = false;
    L57:
        Log.e("ChatWindowLog", "onReEditMessage: get msg by id returns null");
    }
}
