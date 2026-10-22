package com.obric.memorydata.middleware.database;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/database/ProcessBoundIsolationProfile;", "", "<init>", "()V", "ANONYMOUS_PROFILE_ID", "", "bound", "Lcom/obric/memorydata/middleware/database/PersonalDbSplitProfile;", "getBound", "()Lcom/obric/memorydata/middleware/database/PersonalDbSplitProfile;", "bound$delegate", "Lkotlin/Lazy;", "cached", "live", "resolve", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f11664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f11665b = null;

    static {
        f11664a = new j();
        f11665b = LazyKt.lazy($$Lambda$j$CPm9FaC63ycPA8MhyGA1lKi9fmg.INSTANCE);
    }

    private j() {
    }

    private final i c() {
        return (i) ZeusTransformUtils.preCheckCast(f11665b.getValue(), i.class, "com.obric.memorydata.plugin");
    }

    private final i d() {
        String r6 = AppContext.INSTANCE.getUserId();
        Long r0 = StringsKt.toLongOrNull(r6);
        if (AppContext.INSTANCE.isLogin() == false) goto L8;
        if (r0 == null) goto L8;
        if (r0.longValue() == 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return new i(r6, r6, false);
    L12:
        return new i("anonymous", r6, true);
    L8:
        r1 = false;
        goto L9
    }

    private static final i e() {
        return f11664a.d();
    }

    public static /* synthetic */ i lambda$CPm9FaC63ycPA8MhyGA1lKi9fmg() {
        return e();
    }

    public final i a() {
        return c();
    }

    public final i b() {
        return d();
    }
}
