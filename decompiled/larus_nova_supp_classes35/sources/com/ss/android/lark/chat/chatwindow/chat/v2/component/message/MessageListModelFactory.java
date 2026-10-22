package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.MessageListViewModelV2;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0018\u001a\u0002H\u0019\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "context", "Landroid/content/Context;", "chatWindowInitData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "dependency", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;)V", "getContext", "()Landroid/content/Context;", "getChatWindowInitData", "()Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "getChatBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getDependency", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/MessageListViewModelDependency;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageListModelFactory implements ViewModelProvider.Factory {
    public final Context a;
    public final i7b.a b;
    public final fxa.b c;
    public final v d;
    public final p e;

    public final /* synthetic */ ViewModel create(Class r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final /* synthetic */ ViewModel create(KClass r1, CreationExtras r2) {
        return ViewModelProvider.Factory.-CC.$default$create(this, r1, r2);
    }

    public final Context getContext() {
        return this.a;
    }

    public final <T extends ViewModel> T create(Class<T> r8) {
        Intrinsics.checkNotNullParameter(r8, "modelClass");
        if (Intrinsics.areEqual(r8, MessageListViewModel.class) == false) goto L7;
        return new MessageListViewModel(this.b, this.a, this.c, this.d, this.e);
    L7:
        if (Intrinsics.areEqual(r8, MessageListViewModelV2.class) == false) goto L11;
        return new MessageListViewModelV2(this.b, this.a, this.c, this.d, this.e);
    L11:
        throw new UnsupportedOperationException("module class:" + r8 + " not support");
    }

    public MessageListModelFactory(Context r2, i7b.a r3, fxa.b r4, v r5, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data.b r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatWindowInitData");
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        Intrinsics.checkNotNullParameter(r5, "chatContainer");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
