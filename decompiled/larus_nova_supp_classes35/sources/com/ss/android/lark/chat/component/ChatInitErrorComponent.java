package com.ss.android.lark.chat.component;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chameleon.basewebview.BizScene;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.framework.larkwidget.Widget;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/component/ChatInitErrorComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "chatId", BuildConfig.FLAVOR, "initErrorInfo", "Landroidx/lifecycle/LiveData;", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/LiveData;)V", "hasView", BuildConfig.FLAVOR, "onCreate", BuildConfig.FLAVOR, "showOpenChatError", "errorResult", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInitErrorComponent extends ChatBaseComponent {
    public static final /* synthetic */ int n = 0;
    public final String l;
    public final LiveData<ErrorResult> m;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ChatInitErrorComponent a;

        public b(ChatInitErrorComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            final ErrorResult r5 = (ErrorResult) r4;
            if (r5 == null) goto L11;
            final ChatInitErrorComponent r0 = this.a;
            int r1 = ChatInitErrorComponent.n;
            r0.getClass();
            Function0<Unit> r2 = new ChatInitErrorComponent$showOpenChatError$1(r0, r5);
            Intrinsics.checkNotNullParameter(r2, BizScene.BLOCK);
            if (((Widget) r0).c == false) goto L12;
            Thread r6 = ThreadMethodProxy.currentThread();
            Intrinsics.checkNotNullParameter(r6, "<this>");
            if (Intrinsics.areEqual(r6, ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L9;
            r2.invoke();
            return;
        L9:
            Runnable r7 = new com.ss.android.lark.framework.larkwidget.a(r0, r2);
            Intrinsics.checkNotNullParameter(r7, "runnable");
            ((Handler) ((Widget) r0).b.getValue()).post(r7);
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final boolean v0() {
        return false;
    }

    public final void onCreate() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onCreate();
        this.m.observe(this, new b(this));
    }

    public ChatInitErrorComponent(String r2, MutableLiveData r3) {
        Intrinsics.checkNotNullParameter(r3, "initErrorInfo");
        this.l = r2;
        this.m = r3;
    }
}
