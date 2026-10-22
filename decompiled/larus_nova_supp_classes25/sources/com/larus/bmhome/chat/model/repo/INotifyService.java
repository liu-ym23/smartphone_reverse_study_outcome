package com.larus.bmhome.chat.model.repo;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.n3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH&J\u0014\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/INotifyService;", "", "createNotifyFragment", "Landroidx/fragment/app/Fragment;", "createNotifyRedDotLifecycleObserver", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "repo", "Lcom/larus/bmhome/chat/model/repo/INotificationRepoService;", "handleSchema", "", "bannerSchema", "", "parent", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "enterMethod", "pushInnerNotification", "request", "Lcom/larus/platform/model/NotificationRequest;", "dismissNotification", "", "addInnerNotificationSlotIdleListener", "listener", "Lcom/larus/platform/model/OnInnerNotificationSlotIdleListener;", "removeInnerNotificationSlotIdleListener", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface INotifyService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J-\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u0096\u0001¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/INotifyService$Companion;", "Lcom/larus/bmhome/chat/model/repo/INotifyService;", "<init>", "()V", "addInnerNotificationSlotIdleListener", "", "listener", "Lcom/larus/platform/model/OnInnerNotificationSlotIdleListener;", "createNotifyFragment", "Landroidx/fragment/app/Fragment;", "createNotifyRedDotLifecycleObserver", "Lcom/larus/bmhome/chat/model/repo/INotifyRedDotLifecycleObserver;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "dismissNotification", "handleSchema", "", "bannerSchema", "", "parent", "Lcom/ixigua/lib/track/ITrackNode;", "context", "Landroid/content/Context;", "enterMethod", "pushInnerNotification", "request", "Lcom/larus/platform/model/NotificationRequest;", "removeInnerNotificationSlotIdleListener", "repo", "Lcom/larus/bmhome/chat/model/repo/INotificationRepoService;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class Companion implements INotifyService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ INotifyService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final void a(com.larus.commercemembership.impl.component.d r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.b.a(r2);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final void b(com.larus.commercemembership.impl.component.d r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.b.b(r2);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final boolean c(n3 r2) {
            return this.b.c(r2);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final void d() {
            this.b.d();
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final w1 e() {
            return this.b.e();
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final boolean f(String r2, by7.e r3, Context r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "enterMethod");
            return this.b.f(r2, r3, r4, r5);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final INotifyRedDotLifecycleObserver g(LifecycleCoroutineScope r2) {
            Intrinsics.checkNotNullParameter(r2, "lifecycleScope");
            return this.b.g(r2);
        }

        @Override // com.larus.bmhome.chat.model.repo.INotifyService
        public final Fragment h() {
            return this.b.h();
        }

        private Companion() {
            Object r0 = ServiceManager.get().getService(INotifyService.class);
            Intrinsics.checkNotNull(r0);
            this.b = (INotifyService) r0;
        }
    }

    static {
        a = Companion.c;
    }

    void a(com.larus.commercemembership.impl.component.d r1);

    void b(com.larus.commercemembership.impl.component.d r1);

    boolean c(n3 r1);

    void d();

    w1 e();

    boolean f(String r1, by7.e r2, Context r3, String r4);

    INotifyRedDotLifecycleObserver g(LifecycleCoroutineScope r1);

    Fragment h();
}
