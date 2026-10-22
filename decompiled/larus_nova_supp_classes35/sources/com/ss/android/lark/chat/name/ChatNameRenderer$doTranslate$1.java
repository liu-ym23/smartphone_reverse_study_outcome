package com.ss.android.lark.chat.name;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/chat/name/ChatNameRenderer$doTranslate$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", BuildConfig.FLAVOR, "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/Boolean;)V", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatNameRenderer$doTranslate$1 implements IGetDataCallback<Boolean> {
    final /* synthetic */ Chat $chat;
    final /* synthetic */ Context $context;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.a, 2131890920);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        Log.i("ChatNameRenderer", "[chat_name_translate] translate fail " + this.$chat.getId());
        UICallbackExecutor.post(new a(this.$context));
    }

    public void onSuccess(Boolean r2) {
        Log.i("ChatNameRenderer", "[chat_name_translate] translate success " + this.$chat.getId());
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((Boolean) r1);
    }

    public ChatNameRenderer$doTranslate$1(Chat r1, Context r2) {
        this.$chat = r1;
        this.$context = r2;
    }
}
