package com.larus.bmhome;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.INotifyRedDotLifecycleObserver;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.bmhome.chat.model.repo.b2;
import com.larus.bmhome.chat.model.repo.w1;
import com.larus.bmhome.notification.NotifyRedDotLifecycleObserver;
import com.larus.bmhome.notification.NotifyTabFragment;
import com.larus.bot.api.IBotCreateService;
import com.larus.commercemembership.impl.component.d;
import com.larus.utils.logger.FLogger;
import hq9.n3;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nq9.c;
import nr8.b;
import tx9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/NotifyService;", "Lcom/larus/bmhome/chat/model/repo/INotifyService;", "<init>", "()V", "createNotifyFragment", "Lcom/larus/bmhome/notification/NotifyTabFragment;", "createNotifyRedDotLifecycleObserver", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "repo", "Lcom/larus/bmhome/chat/model/repo/NotificationRepo;", "handleSchema", "", "bannerSchema", "", "parent", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "enterMethod", "pushInnerNotification", "request", "Lcom/larus/platform/model/NotificationRequest;", "dismissNotification", "", "addInnerNotificationSlotIdleListener", "listener", "Lcom/larus/platform/model/OnInnerNotificationSlotIdleListener;", "removeInnerNotificationSlotIdleListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NotifyService implements INotifyService {
    public NotifyService() {
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final void d() {
        i0.a.getClass();
        if (i0.b == false) goto L10;
        WeakReference<b> r0 = i0.c;
        if (r0 == null) goto L11;
        b r1 = r0.get();
        if (r1 == null) goto L12;
        i0.a(r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final Fragment h() {
        return new NotifyTabFragment();
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final w1 e() {
        return b2.a;
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        i0.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        i0.e.remove(r3);
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final void b(d r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        i0.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        i0.e.add(r3);
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final boolean c(n3 r7) {
        boolean r0 = false;
        if (r7 == null) goto L30;
        i0 r1 = i0.a;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r7, "request");     // Catch: Throwable -> L27
        FLogger.a.i("NotificationControlManager", "triggerNotification, isShow:" + i0.b);     // Catch: Throwable -> L27
        if (i0.b == false) goto L11;
        monitor-exit(r1);
    L24:
        return r0;
    L11:
        i0.b = true;     // Catch: Throwable -> L27
    L18:
        th = move-exception;
        i0.b(r1, null, 1);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L14:
        if (i0.c(r7) == false) goto L16;
    L20:
        r0 = true;
    L21:
        if (r0 == true) goto L23;
        i0.b(r1, null, 1);     // Catch: Throwable -> L18
    L23:
        monitor-exit(r1);
        goto L24
    L16:
        if (i0.d(r7) == false) goto L21;
    L27:
        th = move-exception;
        throw th;
    L30:
        return false;
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final INotifyRedDotLifecycleObserver g(LifecycleCoroutineScope r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
        return new NotifyRedDotLifecycleObserver(r2);
    }

    @Override // com.larus.bmhome.chat.model.repo.INotifyService
    public final boolean f(String r18, by7.e r19, Context r20, String r21) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "enterMethod");
        int r4 = com.larus.bmhome.notification.util.e.a;
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "enterMethod");
        Uri r12 = UriProtector.parse(r18);
        boolean r13 = false;
        String r2 = null;
        if (r18 != null) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L17;
        c r1 = IBotCreateService.a.i("notify", r21);
        if (r1 == null) goto L13;
        String r16 = r1.b;
    L14:
        if (r1 == null) goto L16;
        r2 = r1.a;
    L16:
        String r3 = r2;
        c0.l("notify", null, null, r21, r16, r3, null, null, r19, 909);
        r2 = r16;
    L18:
        Uri.Builder r5 = r12.buildUpon();
        String r6 = UriProtector.getQueryParameter(r12, "enter_method");
        if (r6 != null) goto L21;
    L22:
        r13 = true;
    L23:
        if (r13 == false) goto L25;
        r5.appendQueryParameter("enter_method", "click_banner");
    L25:
        if (r2 == null) goto L27;
        r5.appendQueryParameter("create_way", r2);
    L27:
        if (r3 == null) goto L29;
        r5.appendQueryParameter("creation_id", r3);
    L29:
        com.bytedance.router.i r7 = SmartRouter.buildRoute(r20, r5.appendQueryParameter("previous_page", "notify").appendQueryParameter("android_no_clear_top", "1").build().toString());
        if (r3 == null) goto L32;
        r7.d = 2130772400;
        r7.e = 2130772399;
    L32:
        r7.d();
        return true;
    L21:
        if (r6.length() != 0) goto L23;
    L13:
        r16 = null;
        goto L14
    L17:
        r3 = null;
        goto L18
    L5:
        if (StringsKt.contains$default(r18, IBotCreateService.a.k(), false, 2, null) != true) goto L7;
        r0 = true;
        goto L9
    }
}
