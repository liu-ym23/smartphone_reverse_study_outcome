package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0018\u001a\u0002H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/KeyboardModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "iniP2pChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "chatReplyDigestCreator", "Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModelDependency;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModelDependency;)V", "getInitChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "getIniP2pChatter", "()Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatReplyDigestCreator", "()Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/keyboard/KeyboardViewModelDependency;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyboardModelFactory implements ViewModelProvider.Factory {
    public final Chat a;
    public final ChatChatter b;
    public final v c;
    public final com.ss.android.lark.chat.chatwindow.chat.data.reply.a d;
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.a e;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final <T extends ViewModel> T create(Class<T> r8) {
        Intrinsics.checkNotNullParameter(r8, "modelClass");
        if (Intrinsics.areEqual(r8, KeyboardViewModel.class) == false) goto L7;
        return new KeyboardViewModel(this.c, this.a, this.b, this.d, this.e);
    L7:
        throw new IllegalArgumentException("unsupport model class " + r8);
    }

    public KeyboardModelFactory(Chat r2, ChatChatter r3, v r4, com.ss.android.lark.chat.chatwindow.chat.data.reply.a r5, a r6) {
        Intrinsics.checkNotNullParameter(r2, "initChat");
        Intrinsics.checkNotNullParameter(r4, "chatContainer");
        Intrinsics.checkNotNullParameter(r5, "chatReplyDigestCreator");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
