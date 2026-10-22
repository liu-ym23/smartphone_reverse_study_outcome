package com.obric.memorydata.task.condition.vendor.gr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0015H&J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRTaskWindowCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "Landroid/os/Handler$Callback;", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$OnAvailabilityChangeListener;", "<init>", "()V", "taskSplitter", "Lcom/obric/memorydata/task/condition/vendor/gr/VirtualTaskSplitter;", "handler", "Landroid/os/Handler;", "registered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "register", "", "isSatisfied", "", "isInstantEntityIndexSwitchOn", "plantPoller", "refreshPoller", "stopPoller", "getCurrentRunLevel", "Lcom/obric/memorydata/task/condition/vendor/gr/GRAiTaskApi$Availability;", "getAvailabilities", "", "getCurrentCondition", "Lcom/obric/memorydata/task/condition/Condition;", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "onChange", "availability", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class d extends com.obric.memorydata.task.condition.b implements Handler.Callback, GRAiTaskApi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12908a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f12909b;
    private final Handler c;
    private final AtomicBoolean d;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRTaskWindowCondition$Companion;", "", "<init>", "()V", "TAG", "", "MSG_POLL", "", "MSG_REMOVE_POLLER", "POLL_AVAILABILITY_THROTTLE", "", "BATCH_TASK_THROTTLE", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12908a = new a(null);
    }

    public d() {
        this.f12909b = new e();
        this.c = new Handler(Looper.getMainLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(this, Handler.Callback.class, "com.obric.memorydata.plugin"));
        this.d = new AtomicBoolean(false);
    }

    private static final void a(d r4) {
        GRAiTaskApi r0 = GRAiTaskApi.f12900a;
        Pair<Long, Long> r1 = r4.f12909b.b();
        if (r1 == null) goto L5;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r1.getFirst(), Number.class, "com.obric.memorydata.plugin")).longValue();
    L6:
        r0.a(r2, r4.a().getValue());
        return;
    L5:
        r2 = System.currentTimeMillis();
        goto L6
    }

    private final boolean f() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_instant_entity_index_switch_on", false);
    }

    private final void j() {
        RunLog.INSTANCE.debug("VendorCondition", "plantPoller for " + d() + ", task=" + this.f12909b);
        this.c.removeMessages(1);
        this.c.sendEmptyMessageDelayed(1, 5000);
    }

    private final void k() {
        RunLog.INSTANCE.debug("VendorCondition", "refreshPoller for " + d() + ", task=" + this.f12909b);
        this.c.removeMessages(2);
        this.c.sendEmptyMessageDelayed(2, 60000);
    }

    private final void l() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VendorCondition", "stopPoller for " + d() + ", task=" + this.f12909b, false, 4, null);
        this.c.removeMessages(2);
        this.c.removeMessages(1);
    }

    /* JADX INFO: renamed from: lambda$3WEYe40-jsZXuLfFm_OFbOL3tyI, reason: not valid java name */
    public static /* synthetic */ void m1191lambda$3WEYe40jsZXuLfFm_OFbOL3tyI(d r0) {
        a(r0);
    }

    public abstract GRAiTaskApi.Availability a();

    @Override // com.obric.memorydata.task.condition.vendor.gr.GRAiTaskApi.a
    public void a(GRAiTaskApi.Availability r2) {
        Intrinsics.checkNotNullParameter(r2, "availability");
        b(e().contains(r2));
        com.obric.memorydata.task.condition.d r3 = h();
        if (r3 == null) goto L6;
        r3.onConditionChange(d(), i());
        return;
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        RunLog.INSTANCE.info("VendorCondition", "GRTaskWindowCondition[" + d() + "] register ", true);
        if (this.d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        GRAiTaskApi.f12900a.a((GRAiTaskApi.a) ZeusTransformUtils.preCheckCast(this, GRAiTaskApi.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        if (f() == false) goto L7;
        return true;
    L7:
        if (i() == true) goto L9;
        l();
    L14:
        return i();
    L9:
        if (this.f12909b.a() == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VendorCondition", "plant status checker for " + d(), false, 4, null);
        j();
    L11:
        k();
        goto L14
    }

    public abstract Condition d();

    public abstract Collection<GRAiTaskApi.Availability> e();

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        int r4 = r3.what;
        if (r4 != 1) goto L5;
        RunLog.INSTANCE.debug("VendorCondition", "poll task window info, task=" + this.f12909b);
        ThreadPoolContainer.Companion.execute(new $$Lambda$d$3WEYe40jsZXuLfFm_OFbOL3tyI(this));
        j();
        return false;
    L5:
        if (r4 != 2) goto L12;
        l();
        return false;
    L12:
        return false;
    }
}
