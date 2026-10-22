package com.obric.memorydata.middleware.impl.playground;

import com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI;
import com.obric.memorydata.middleware.api.bridge.Response;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/PlaygroundAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IPlaygroundAPI;", "<init>", "()V", "skillAdapter", "Lcom/obric/memorydata/middleware/impl/playground/SkillAdapter;", "appIntentAdapter", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentAdapter;", "getInst", "getSkillList", "Lcom/obric/memorydata/middleware/api/bridge/Response;", "loadSkill", "skillId", "", "dispatchIntent", "payload", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlaygroundAPIImpl implements IPlaygroundAPI {
    public static final PlaygroundAPIImpl INSTANCE = null;
    private static final a appIntentAdapter = null;
    private static final n skillAdapter = null;

    static {
        INSTANCE = new PlaygroundAPIImpl();
        skillAdapter = new n();
        appIntentAdapter = new a();
    }

    private PlaygroundAPIImpl() {
    }

    @JvmStatic
    public static final PlaygroundAPIImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI
    public Response dispatchIntent(String r1) {
        Intrinsics.checkNotNullParameter(r1, "payload");
        return appIntentAdapter.a(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI
    public Response getSkillList() {
        return skillAdapter.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IPlaygroundAPI
    public Response loadSkill(String r1) {
        Intrinsics.checkNotNullParameter(r1, "skillId");
        return skillAdapter.a(r1);
    }
}
