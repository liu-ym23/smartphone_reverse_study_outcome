package com.ss.android.lark.keyboard.editor;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends BaseChatEditor<FlowChatKeyboardEditor> {
    public final Context b;
    public final Chatter c;
    public final LifecycleOwner d;
    public final KeyboardViewModel e;
    public final List<ChatWindowKeyboard.a> f;
    public final boolean g;
    public final boolean h;
    public final zxa.a i;
    public final com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i j;
    public final Fragment k;
    public final boolean l;
    public FlowChatKeyboardEditor m;
    public final g n;

    public static final class a implements q {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.keyboard.event.c
        public final String getTag() {
            return com.ss.android.lark.keyboard.event.c.a.a(this);
        }
    }

    public final String getName() {
        return "input_richtext_shrink";
    }

    public final FlowChatKeyboardEditor d() {
        if (this.m != null) goto L6;
        Chat r0 = this.e.getCurrentChat();
        f r2 = new f(this, r0);
        e r3 = new e(this);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.ss.android.lark.biz.im.api.extension.keyboard.inputstate.IInputStateRepo");
        final InputStateController r8 = new InputStateController(this);
        String r4 = r0.getId();
        boolean r6 = this.h;
        Fragment r7 = this.k;
        FlowChatKeyboardEditor r1 = new FlowChatKeyboardEditor(r2, r3, r4, this.l, r6, r7);
        Function1<FlowChatKeyboardEditor, Unit> r5 = new FlowChatEditorV2$createPluginImpl$1(r8, this);
        Intrinsics.checkNotNullParameter(r5, "action");
        r1.v.add(r5);
        this.m = r1;
    L6:
        return this.m;
    }

    public final /* bridge */ /* synthetic */ Object getPlugin() {
        return d();
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // com.ss.android.lark.keyboard.editor.BaseChatEditor
    public final void b(cya.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (this.g == false) goto L6;
        super.b(r2);
        return;
    }

    @Override // com.ss.android.lark.keyboard.editor.BaseChatEditor
    public final Object a(boolean r2, Continuation<? super cya.h> r3) {
        if (this.g == false) goto L7;
        return BaseChatEditor.c(this, r2, r3);
    L7:
        return new cya.b();
    }

    public d(Context r2, ChatChatter r3, LifecycleOwner r4, KeyboardViewModel r5, List r6, boolean r7, c r8, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.e r9, Fragment r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r6, "callbacks");
        Intrinsics.checkNotNullParameter(r8, "hintInjector");
        Intrinsics.checkNotNullParameter(r10, "applyInsetFragment");
        super(r5);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = true;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
        this.n = new g(this);
    }
}
