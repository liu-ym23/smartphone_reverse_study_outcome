package com.obric.memorydata.memory.glasses;

import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.middleware.api.app.UserSettings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/glasses/GlassesEnvironmentMemorySettings;", "", "<init>", "()V", "isEnabled", "", "isAutomaticSyncAllowed", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10137a = null;

    static {
        f10137a = new a();
    }

    private a() {
    }

    public final boolean a() {
        return DoubaoGlassesConnectionState.INSTANCE.isEnvironmentMemoryEnabled();
    }

    public final boolean b() {
        if (a() == true) goto L5;
    L7:
        return false;
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L7;
        return true;
    }
}
