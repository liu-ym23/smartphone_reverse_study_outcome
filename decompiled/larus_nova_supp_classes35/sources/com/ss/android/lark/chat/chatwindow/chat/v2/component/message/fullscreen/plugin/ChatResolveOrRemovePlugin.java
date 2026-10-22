package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.im.v1.PushChatChattersResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatResolveOrRemovePlugin extends d {
    public final v a;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/plugin/ChatResolveOrRemovePlugin$RemoveChatterViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/ServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/plugin/ChatResolveOrRemovePlugin$IChatChatterPushService;", "<init>", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "removeCurrentUserLiveData", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "getRemoveCurrentUserLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setup", BuildConfig.FLAVOR, "chatId", BuildConfig.FLAVOR, "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RemoveChatterViewModel extends ViewModel implements CoroutineScope {
        private final MutableLiveData<Boolean> removeCurrentUserLiveData;

        public CoroutineContext getCoroutineContext() {
            return SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
        }

        public RemoveChatterViewModel() {
            this.removeCurrentUserLiveData = new MutableLiveData(Boolean.FALSE);
        }

        public final MutableLiveData<Boolean> getRemoveCurrentUserLiveData() {
            return this.removeCurrentUserLiveData;
        }

        public final void setup(String r8, v r9) {
            Intrinsics.checkNotNullParameter(r8, "chatId");
            Intrinsics.checkNotNullParameter(r9, "chatContainer");
            BuildersKt.launch$default(this, null, null, new ChatResolveOrRemovePlugin$RemoveChatterViewModel$setup$1(this, r8, r9, null), 3, null);
        }
    }

    public interface a {
        @SdkPush(5001)
        RucketJob<PushChatChattersResponse> chatChattersPush();
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.c a;

        public b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Chat r6 = (Chat) r5;
            if (r6.isDissolved() == true) goto L5;
            return;
        L5:
            if (r6.isFrozen() == true) goto L9;
            this.a.c.getError().postValue(new ErrorResult("chat " + r6.getId() + " is dissolved, close page"));
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.c a;
        public final /* synthetic */ String b;

        public c(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L6;
            this.a.c.getError().postValue(new ErrorResult("chat " + this.b + " remove currentUser, close page"));
            return;
        }
    }

    public ChatResolveOrRemovePlugin(v r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void a(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.c r5) {
        Intrinsics.checkNotNullParameter(r5, "pluginContext");
        Intrinsics.checkNotNullParameter(r5, "pluginContext");
        Fragment r0 = r5.b;
        r5.c.getChatLiveData().observe(r0, new b(r5));
        RemoveChatterViewModel r1 = (RemoveChatterViewModel) new ViewModelProvider(r0).get(RemoveChatterViewModel.class);
        Chat r2 = (Chat) r5.c.getChatLiveData().getValue();
        if (r2 == null) goto L9;
        String r3 = r2.getId();
        if (r3 == null) goto L10;
        r1.setup(r3, this.a);
        r1.getRemoveCurrentUserLiveData().observe(r0, new c(r5, r3));
        return;
    L10:
        return;
    }
}
