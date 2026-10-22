package com.ss.android.lark.chatwindow.launcher;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/chatwindow/launcher/ChatLauncherV2$openChat$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chatwindow/launcher/IChatLauncherV2$ChatWrapper;", "onSuccess", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_DATA, "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatLauncherV2$openChat$1 implements IGetDataCallback<c.a> {
    final /* synthetic */ Function1<ErrorResult, Unit> $onError;
    final /* synthetic */ Function1<c.a, Unit> $onSuccess;

    public void onError(ErrorResult r2) {
        Intrinsics.checkNotNullParameter(r2, "err");
        Function1<ErrorResult, Unit> r0 = this.$onError;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    public void onSuccess(c.a r2) {
        Intrinsics.checkNotNullParameter(r2, Keys.API_RETURN_KEY_DATA);
        Function1<c.a, Unit> r0 = this.$onSuccess;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((c.a) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatLauncherV2$openChat$1(Function1<? super c.a, Unit> r1, Function1<? super ErrorResult, Unit> r2) {
        this.$onSuccess = r1;
        this.$onError = r2;
    }
}
