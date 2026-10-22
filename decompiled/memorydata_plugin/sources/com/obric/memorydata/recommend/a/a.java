package com.obric.memorydata.recommend.a;

import android.content.Context;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.ha;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.d;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/account/RecommendLoginStateListener;", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "<init>", "()V", "TAG", "", "onLogin", "", "userId", "onLogout", "lastUserId", "onAgree", "onDisagree", "deleteFile", "path", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.middleware.api.app.a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12495a = null;

    static {
        f12495a = new a();
    }

    private a() {
    }

    private final void c(final String r2) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        com.obric.memorydata.sdk.d.a(new $$Lambda$a$cTYLQ8JuVWlXkGAuTM93wCxsjfM(r2));
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static final boolean c() {
        return FilesKt.deleteRecursively(new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "raw_observation_viewtree"));
    }

    private static final Unit d(String r1) {
        File r0 = new File(r1);
        if (r0.exists() == false) goto L6;
        r0.delete();
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$cTYLQ8JuVWlXkGAuTM93wCxsjfM(String r0) {
        return d(r0);
    }

    public static /* synthetic */ boolean lambda$tv1buV8wmSVt0WsLCzs5kznbB_4() {
        return c();
    }

    @Override // com.obric.memorydata.middleware.api.app.a
    public void a() {
    }

    @Override // com.obric.memorydata.middleware.api.app.d
    public void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        RunLog.INSTANCE.debug("RecommendLoginStateListener", "RecommendLoginStateListener onLogin, userID: " + r3);
    }

    @Override // com.obric.memorydata.middleware.api.app.a
    public void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendLoginStateListener", "RecommendLoginStateListener onDisagree", false, 4, null);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().deleteAll();
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getGlassesSyncStateDao().deleteAll();
    }

    @Override // com.obric.memorydata.middleware.api.app.d
    public void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "lastUserId");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendLoginStateListener", "RecommendLoginStateListener onLogout, lastUserID: " + r9, false, 4, null);
        com.obric.memorydata.recommend.c.a.f12500a.b();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        RawObservationEntity r10 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r8.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r10.getSource(), "screenshot") == false) goto L4;
        a r0 = f12495a;
        r0.c(ha.f9173a.a(r10));
        r0.c(ha.f9173a.b(r10));
        goto L4
    L8:
        com.obric.memorydata.sdk.d.a($$Lambda$a$tv1buV8wmSVt0WsLCzs5kznbB_4.INSTANCE);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao().deleteAll();
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getGlassesSyncStateDao().deleteAll();
    }
}
