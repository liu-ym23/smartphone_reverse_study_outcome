package com.larus.bmhome.notification;

import android.os.Handler;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver;
import com.larus.bmhome.chat.model.repo.b2;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0002\u0010\u0013\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/bmhome/notification/NotifyRedDotLifecycleObserver;", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "repo", "Lcom/larus/bmhome/chat/model/repo/NotificationRepo;", "handler", "Landroid/os/Handler;", "unreadTask", "Ljava/lang/Runnable;", "newNotificationCMDObserver", "Landroidx/lifecycle/Observer;", "", "appBackGroundListener", "com/larus/bmhome/notification/NotifyRedDotLifecycleObserver$appBackGroundListener$1", "Lcom/larus/bmhome/notification/NotifyRedDotLifecycleObserver$appBackGroundListener$1;", "accountStatusCallback", "com/larus/bmhome/notification/NotifyRedDotLifecycleObserver$accountStatusCallback$1", "Lcom/larus/bmhome/notification/NotifyRedDotLifecycleObserver$accountStatusCallback$1;", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getUnreadCount", "Lkotlinx/coroutines/Job;", MusicAppletPage.KEY_SOURCE, "", "startUnreadPollingTask", "stopUnreadPollingTask", "onDestroy", "onCleared", "clear", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotifyRedDotLifecycleObserver implements INotifyRedDotLifecycleObserver {
    public static final /* synthetic */ int h = 0;
    public final CoroutineScope a;
    public final b2 b;
    public final Handler c;
    public final com.larus.bmhome.notification.a d;
    public final b e;
    public final d f;
    public final c g;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public final void b() {
        long r0 = ((long) z2.a.y2()) * 1000;
        if (r0 <= 0) goto L6;
        FLogger.a.i("NotifyRedDotLifecycleObserver", "startUnreadPollingTask: interval = " + r0 + " ms");
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, r0);
        return;
    }

    public final void clear() {
        this.b.getClass();
        b2.c.removeObserver(this.e);
        FLogger.a.i("NotifyRedDotLifecycleObserver", "stopUnreadPollingTask");
        this.c.removeCallbacks(this.d);
        AppHost.a.a().c(this.f);
        AccountService.a.D(this.g);
    }

    public final void onCleared() {
        clear();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.bmhome.notification.a] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.notification.b] */
    public NotifyRedDotLifecycleObserver(LifecycleCoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
        this.a = r2;
        this.b = b2.a;
        this.c = new Handler();
        this.d = new com.larus.bmhome.notification.a(this);
        this.e = new b(this);
        this.f = new d(this);
        this.g = new c(this);
    }

    public final void a(String r7) {
        BuildersKt.launch$default(this.a, null, null, new NotifyRedDotLifecycleObserver$getUnreadCount$1(this, r7, null), 3, null);
    }

    public final void onCreate(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r2);
        a(DowngradeSource.ENTER_CONVERSATION_LIST.getValue());
        this.b.getClass();
        b2.c.observeForever(this.e);
        b();
        AppHost.a.a().j(this.f);
        AccountService.a.E(this.g);
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, r2);
        clear();
    }
}
