package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkPush;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class RecallThreadPlugin extends d {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/plugin/RecallThreadPlugin$ThreadsUpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/ServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/plugin/RecallThreadPlugin$IThreadPushService;", "<init>", "()V", "threadLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "getThreadLiveData", "()Landroidx/lifecycle/MutableLiveData;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setup", BuildConfig.FLAVOR, "threadId", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ThreadsUpdateViewModel extends ViewModel implements CoroutineScope {
        private final MutableLiveData<ThreadTopic> threadLiveData;

        public CoroutineContext getCoroutineContext() {
            return SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
        }

        public ThreadsUpdateViewModel() {
            this.threadLiveData = new MutableLiveData();
        }

        public final MutableLiveData<ThreadTopic> getThreadLiveData() {
            return this.threadLiveData;
        }

        public final void setup(String r8) {
            Intrinsics.checkNotNullParameter(r8, "threadId");
            BuildersKt.launch$default(this, null, null, new RecallThreadPlugin$ThreadsUpdateViewModel$setup$1(this, r8, null), 3, null);
        }
    }

    public interface a {
        @SdkPush(5028)
        RucketJob<Entity> threadsPush();
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        public b(c r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r4) {
            if (((ThreadTopic) r4).isNoTraceDelete() == false) goto L6;
            this.a.c.getError().postValue(new ErrorResult("thread " + this.b + " no trace delete, close page"));
            return;
        }
    }

    public RecallThreadPlugin() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.a
    public final void a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "pluginContext");
        Intrinsics.checkNotNullParameter(r5, "pluginContext");
        Fragment r0 = r5.b;
        MessageFullScreenViewModel.c r1 = (MessageFullScreenViewModel.c) r5.c.getLaunch().getValue();
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.a.getPageType() == PageType.THREAD_DETAIL) goto L8;
        return;
    L8:
        Message r2 = r1.b;
        if (r2 == null) goto L15;
        String r3 = r2.getThreadId();
        if (r3 == null) goto L16;
        ThreadsUpdateViewModel r4 = (ThreadsUpdateViewModel) new ViewModelProvider(r0).get(ThreadsUpdateViewModel.class);
        r4.setup(r3);
        r4.getThreadLiveData().observe(r0, new b(r5, r3));
        return;
    L16:
        return;
    }
}
