package obric.flow.app;

import android.content.Context;
import android.os.Build;
import androidx.room.Room;
import androidx.room.migration.Migration;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.lynx.tasm.utils.k;
import com.obric.flow.cardlistpage.data.CardDatabase;
import com.obric.flow.cardlistpage.data.n;
import com.obric.flow.cardlistpage.fluid.LauncherMaterialToken;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialToken;
import eq.b;
import iu.d;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import nq.e;
import nq.f;
import obric.flow.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lobric/flow/app/FlowApplication;", "Lobric/flow/a;", "<init>", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class FlowApplication extends a {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f9.a f20426c;
    public final Lazy d;

    public FlowApplication() {
        this.f20426c = new f9.a(13);
        this.d = LazyKt.lazy(FlowApplication$appInitExecutor$2.INSTANCE);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "base");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r5 == null) goto L19;
        Context r10 = r5.getApplicationContext();
        if (r10 != null) goto L9;
        r10 = r5;
    L9:
        if (Build.TYPE.equals("userdebug") == false) goto L11;
        int r11 = 31457280;
    L12:
        qq.a r12 = new qq.a();
        r12.f21560a = r10;
        r12.f21561b = 3;
        r12.f21562c = true;
        r12.d = r11;
        r12.e = 30;
        OLog.c(r12);
        OLog.g(true);
        obric.flow.inittask.a.a(this, r5);
        TaskConfig.Builder r13 = new TaskConfig.Builder(r5, "obric.home.flow".equals(r5.getPackageName()), "obric.home.flow");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L17;
        TaskConfig.Builder r15 = r13.isDebug(((d) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(d.class), null)).a()).setTimeOut(60000);
        Lazy r16 = this.d;
        InitScheduler.config(r15.setExecutorService((ThreadPoolExecutor) r16.getValue()).build());
        ((ThreadPoolExecutor) r16.getValue()).execute(new f3.a(2));
        InitPeriod r17 = InitPeriod.APP_ATTACHBASE2SUPER;
        this.f20426c.getClass();
        Intrinsics.checkNotNullParameter(r17, "initPeriod");
        InitScheduler.onPeriodStart(r17);
        InitScheduler.onPeriodEnd(r17);
        super.attachBaseContext(r5);
        InitPeriod r18 = InitPeriod.APP_SUPER2ATTACHBASEEND;
        Intrinsics.checkNotNullParameter(r18, "initPeriod");
        InitScheduler.onPeriodStart(r18);
        InitScheduler.onPeriodEnd(r18);
        return;
    L17:
        throw new IllegalStateException("KoinApplication has not been started");
    L11:
        r11 = 20971520;
        goto L12
    L19:
        throw new RuntimeException("context must not be null");
    }

    @Override // android.app.Application
    public final void onCreate() {
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        a.f20424a = this;
        f9.a r5 = this.f20426c;
        InitPeriod r10 = InitPeriod.APP_ONCREATE2SUPER;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r10, "initPeriod");
        InitScheduler.onPeriodStart(r10);
        InitScheduler.onPeriodEnd(r10);
        super.onCreate();
        f9.a r11 = this.f20426c;
        InitPeriod r12 = InitPeriod.APP_SUPER2ONCREATEEND;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "initPeriod");
        InitScheduler.onPeriodStart(r12);
        InitScheduler.onPeriodEnd(r12);
        LauncherMaterialToken r13 = LauncherMaterialToken.INSTANCE;
        MaterialToken.register(r13, true);
        MaterialToken.registerSet(r13, true);
        Intrinsics.checkNotNullParameter(this, "context");
        if (isDeviceProtectedStorage() == false) goto L5;
        Context r14 = getApplicationContext();
    L6:
        Intrinsics.checkNotNull(r14);
        n.f11500a = (CardDatabase) Room.databaseBuilder(r14, CardDatabase.class, "card_database").addMigrations(new Migration[]{CardDatabase.f11465a}).fallbackToDestructiveMigrationOnDowngrade().build();
        fu.a r15 = fu.a.f17012a;
        Intrinsics.checkNotNullParameter(this, "application");
        registerActivityLifecycleCallbacks(r15);
        b r16 = k.r();
        Context r17 = getApplicationContext();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter("1.0.3", "versionName");
        r16.f16856a = false;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L9
        String r19 = r17.getPackageName();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r19, "pkgName");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("1.0.3", "versionName");     // Catch: Throwable -> L9
        e r20 = new e(r19);     // Catch: Throwable -> L9
        MatrixTeaManager.Companion.getClass();     // Catch: Throwable -> L9
        f.a(r17, r20);     // Catch: Throwable -> L9
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Object r21 = obric.flow.thermal.a.f20538i;
        monitor-enter(r21);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (obric.flow.thermal.a.f20537h != null) goto L18;
        obric.flow.thermal.a.f20537h = new obric.flow.thermal.a();     // Catch: Throwable -> L16
    L18:
        obric.flow.thermal.a r22 = obric.flow.thermal.a.f20537h;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L16
        monitor-exit(r21);
        r22.a(new AnonymousClass1(this));
        return;
    L9:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        r14 = getApplicationContext().createDeviceProtectedStorageContext();
        goto L6
    }

    @Override // android.app.Application
    public final void onTerminate() {
        Object r5 = obric.flow.thermal.a.f20538i;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (obric.flow.thermal.a.f20537h != null) goto L9;
        obric.flow.thermal.a.f20537h = new obric.flow.thermal.a();     // Catch: Throwable -> L7
    L9:
        obric.flow.thermal.a r10 = obric.flow.thermal.a.f20537h;     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L7
        monitor-exit(r5);
        r10.d();
        super.onTerminate();
    }
}
