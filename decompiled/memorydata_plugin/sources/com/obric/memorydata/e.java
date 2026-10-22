package com.obric.memorydata;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.memorydata.database.account_split.v;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.app.UserAgreeTaskController;
import com.obric.memorydata.plugin_api.login.LoginRestartClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/PersonalDbSplitTaskControllerFactory;", "", "<init>", "()V", "TAG", "", "prerequisite", "com/obric/memorydata/PersonalDbSplitTaskControllerFactory$prerequisite$1", "Lcom/obric/memorydata/PersonalDbSplitTaskControllerFactory$prerequisite$1;", "create", "Lcom/obric/memorydata/middleware/api/app/TaskController;", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f9868b = null;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/PersonalDbSplitTaskControllerFactory$prerequisite$1", "Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisite;", "isReady", "", LBSLightLocationTraceLogger.PREPARE, "", "onFinished", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/api/app/TaskControllerPrerequisiteResult;", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.app.g {
        a() {
        }

        private static final Unit a(Function1 r2, boolean r3, int r4) {
            Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            if (r3 == false) goto L6;
            if (r4 <= 0) goto L6;
            boolean r6 = true;
        L7:
            r5.invoke(new com.obric.memorydata.middleware.api.app.h(r3, r6));
            return Unit.INSTANCE;
        L6:
            r6 = false;
            goto L7
        }

        public static /* synthetic */ Unit lambda$qss1HDrwcPJQF0hWXbzZEtV9gmg(Function1 r0, boolean r1, int r2) {
            return a(r0, r1, r2);
        }

        @Override // com.obric.memorydata.middleware.api.app.g
        public void a(Function1<? super com.obric.memorydata.middleware.api.app.h, Unit> r2) {
            final Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "onFinished");
            v.f8832a.a();
            v.f8832a.a(new $$Lambda$e$a$qss1HDrwcPJQF0hWXbzZEtV9gmg(r1));
        }

        @Override // com.obric.memorydata.middleware.api.app.g
        public boolean a() {
            return v.f8832a.b();
        }
    }

    static {
        f9867a = new e();
        f9868b = new a();
    }

    private e() {
    }

    private static final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        return LoginRestartClient.restartAfterLogin((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
    }

    private static final Unit b() {
        MemoryDbEngine.INSTANCE.registerRoomDbOpeners();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalDbSplitTaskControllerFactory", "room db openers registered, lazy init on first access", false, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$NKY2TekImocrsp8ShyqqYkgSX-4, reason: not valid java name */
    public static /* synthetic */ boolean m658lambda$NKY2TekImocrsp8ShyqqYkgSX4(String r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$zxmScNl7XNMF4SRhIWne4dPkDOI() {
        return b();
    }

    public final com.obric.memorydata.middleware.api.app.f a() {
        return (com.obric.memorydata.middleware.api.app.f) ZeusTransformUtils.preCheckCast(new UserAgreeTaskController((com.obric.memorydata.middleware.api.app.g) ZeusTransformUtils.preCheckCast(f9868b, com.obric.memorydata.middleware.api.app.g.class, "com.obric.memorydata.plugin"), $$Lambda$e$zxmScNl7XNMF4SRhIWne4dPkDOI.INSTANCE, $$Lambda$e$NKY2TekImocrsp8ShyqqYkgSX4.INSTANCE), com.obric.memorydata.middleware.api.app.f.class, "com.obric.memorydata.plugin");
    }
}
