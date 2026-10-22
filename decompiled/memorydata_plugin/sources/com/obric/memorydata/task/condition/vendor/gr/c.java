package com.obric.memorydata.task.condition.vendor.gr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRNoHighLoadCondition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "Landroid/os/Handler$Callback;", "<init>", "()V", "lastCheckTime", "", "handler", "Landroid/os/Handler;", "register", "", "isSatisfied", "", "isInstantEntityIndexSwitchOn", "checkSystemLoad", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends com.obric.memorydata.task.condition.b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f12907b;
    private final Handler c;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/gr/GRNoHighLoadCondition$Companion;", "", "<init>", "()V", "TAG", "", "CHECK_HIGH_LOAD_THROTTLE", "", "MSG_CHECK_HIGH_LOAD", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12906a = new a(null);
    }

    public c() {
        this.c = new Handler(Looper.getMainLooper(), (Handler.Callback) ZeusTransformUtils.preCheckCast(this, Handler.Callback.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit a(c r4, GRAiTaskApi.Availability r5) {
        Intrinsics.checkNotNullParameter(r5, "availability");
        if (r5 == GRAiTaskApi.Availability.STATUS_OVERLOAD_STOP) goto L5;
        boolean r6 = true;
    L7:
        if (r6 == r4.i()) goto L11;
        RunLog.INSTANCE.info("VendorCondition", "no high load status change " + r6, true);
        r4.b(r6);
        com.obric.memorydata.task.condition.d r0 = r4.h();
        if (r0 == null) goto L11;
        r0.onConditionChange(Condition.LIGHT_POWER_CONTROL, r6);
    L11:
        if (r6 == true) goto L14;
        r4.c.sendEmptyMessageDelayed(1, 10000);
    L14:
        return Unit.INSTANCE;
    L5:
        r6 = false;
        goto L7
    }

    private static final void a(final c r6) {
        GRAiTaskApi.a(GRAiTaskApi.f12900a, 0, false, new $$Lambda$c$jbQPwZ1VVklY64Ak4sckMkehbxk(r6), 3, null);
    }

    private final boolean a() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_instant_entity_index_switch_on", false);
    }

    private final void d() {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.f12907b) > 5000) goto L5;
        return;
    L5:
        this.f12907b = r0;
        this.c.removeMessages(1);
        ThreadPoolContainer.Companion.execute(new $$Lambda$c$72LqckirOg8dQAuUYf9EnplI54(this));
    }

    /* JADX INFO: renamed from: lambda$72LqckirOg8dQAuUY-f9EnplI54, reason: not valid java name */
    public static /* synthetic */ void m1190lambda$72LqckirOg8dQAuUYf9EnplI54(c r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$jbQPwZ1VVklY64Ak4sckMkehbxk(c r0, GRAiTaskApi.Availability r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.task.condition.b
    public void b() {
        d();
    }

    @Override // com.obric.memorydata.task.condition.b
    public boolean c() {
        if (a() == false) goto L6;
        return true;
    L6:
        d();
        return i();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        if (r2.what != 1) goto L6;
        d();
        return true;
    L6:
        return false;
    }
}
