package com.larus.bot.impl.feature.edit.feature.accesspermission;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uc9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/accesspermission/BotAccessPermissionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "botService", "Lcom/larus/im/service/IBotService;", "getBotService", "()Lcom/larus/im/service/IBotService;", "botService$delegate", "Lkotlin/Lazy;", "update", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "getUpdate", "()Landroidx/lifecycle/MutableLiveData;", "update$delegate", "", "botId", "", "privateStatus", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAccessPermissionViewModel extends AndroidViewModel {
    private final Lazy botService$delegate;
    private final Lazy update$delegate;

    public static final class a implements IIMCallback<t> {
        public final /* synthetic */ BotAccessPermissionViewModel a;

        public final boolean mustInMain() {
            return true;
        }

        public a(BotAccessPermissionViewModel r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            Intrinsics.checkNotNullParameter(r5, "error");
            this.a.getUpdate().postValue(new ub8.b(null, r5, 3));
        }

        public final void onSuccess(Object r5) {
            t r6 = (t) r5;
            Intrinsics.checkNotNullParameter(r6, "result");
            this.a.getUpdate().postValue(new ub8.b(r6, null, 6));
        }
    }

    public static /* synthetic */ com.larus.im.service.o Mo() {
        return botService_delegate$lambda$0();
    }

    public static /* synthetic */ MutableLiveData yo() {
        return update_delegate$lambda$1();
    }

    private final com.larus.im.service.o getBotService() {
        return (com.larus.im.service.o) this.botService$delegate.getValue();
    }

    private static final MutableLiveData update_delegate$lambda$1() {
        return new MutableLiveData();
    }

    public final MutableLiveData<ub8.b> getUpdate() {
        return (MutableLiveData) this.update$delegate.getValue();
    }

    private static final com.larus.im.service.o botService_delegate$lambda$0() {
        return com.larus.im.d.a();
    }

    public BotAccessPermissionViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.botService$delegate = LazyKt.lazy(new com.larus.bot.impl.feature.edit.feature.accesspermission.a());
        this.update$delegate = LazyKt.lazy(new b());
    }

    public final void update(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "botId");
        com.larus.im.service.o r0 = getBotService();
        if (r0 == null) goto L6;
        r0.requireUpdateBotAccessPermission(r3, r4, new a(this));
        return;
    }
}
