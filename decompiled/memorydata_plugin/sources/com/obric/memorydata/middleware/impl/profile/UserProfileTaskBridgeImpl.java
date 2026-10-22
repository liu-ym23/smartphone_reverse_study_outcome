package com.obric.memorydata.middleware.impl.profile;

import com.obric.memorydata.middleware.api.bridge.IUserProfileTaskBridgeAPI;
import com.obric.memorydata.utils.r;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/profile/UserProfileTaskBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IUserProfileTaskBridgeAPI;", "<init>", "()V", "getInst", "checkIsWorkingDay", "", "ts", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileTaskBridgeImpl implements IUserProfileTaskBridgeAPI {
    public static final UserProfileTaskBridgeImpl INSTANCE = null;

    static {
        INSTANCE = new UserProfileTaskBridgeImpl();
    }

    private UserProfileTaskBridgeImpl() {
    }

    @JvmStatic
    public static final UserProfileTaskBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUserProfileTaskBridgeAPI
    public boolean checkIsWorkingDay(long r1) {
        return r.d(r1);
    }
}
