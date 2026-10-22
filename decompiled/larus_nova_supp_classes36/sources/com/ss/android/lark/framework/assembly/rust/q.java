package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import dagger.Module;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Module
public final class q {
    public static final q a = null;
    public static final Set<Integer> b = null;

    public q() {
    }

    static {
        a = new q();
        b = SetsKt.setOf(new Integer[]{Integer.valueOf(Command.MAKE_USER_ONLINE.getValue()), Integer.valueOf(Command.MAKE_USER_ONLINE_V2.getValue()), Integer.valueOf(Command.MAKE_USER_OFFLINE.getValue()), Integer.valueOf(Command.MAKE_USER_OFFLINE_V2.getValue()), Integer.valueOf(Command.SWITCH_USER_STATE.getValue())});
    }
}
