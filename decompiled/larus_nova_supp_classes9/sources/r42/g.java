package r42;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.android.livesdk.g7;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.com.bytedance.android.livesdk.model.LiveFirstMessageOptConfig;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r52.f3;
import r52.h3;
import r52.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final boolean b() {
        if (((Boolean) j0.a.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        Boolean r2 = null;
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L9:
        if (r1 == null) goto L12;
        r2 = r1.isAnchor();
    L12:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L14;
        return false;
    L14:
        if (r1 == null) goto L25;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L25;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L25;
        IRoomAuthStatus r5 = r4.getRoomAuthStatus();
        if (r5 == null) goto L25;
        if (r5.isEnableLoadMoreHistory() != true) goto L25;
        return true;
    L25:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean c() {
        if (((Boolean) h3.a.getValue()).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (((LiveFirstMessageOptConfig) g7.a.getValue()).getForceUseV3() == true) goto L8;
        return false;
    }

    public static int d() {
        Lazy r0 = PublicScreenABHelper.a;
        if (TextUtils.isEmpty((String) f3.a.getValue()) == false) goto L5;
        return 7;
    L5:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        com.bytedance.android.livesdk.chatroom.o r2 = null;
        if (r1 == null) goto L8;
        r2 = IRoomContextService.a.a(r1, null, 0, 3);
    L8:
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.j r3 = r2.r2();
        if (r3 == null) goto L20;
        IDynamicStrategyContext r4 = (IDynamicStrategyContext) r3.getValue();
        if (r4 == null) goto L21;
        PropertyOwner r5 = r4.getStrategy("public_screen_load_history_strategy");
        if (r5 == null) goto L22;
        ju1.n r6 = (ju1.n) r5.a;
        if (r6 != null) goto L18;
        return 7;
    L18:
        return r6.b(7);
    L22:
        return 7;
    L21:
        return 7;
    L20:
        return 7;
    L19:
        return 7;
    }

    static {
    }

    @JvmStatic
    public static final boolean a(IRoom r6, Boolean r7) {
        if (((Boolean) InteractivityOpt.c(j0.a)).booleanValue() == true) goto L5;
        return false;
    L5:
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L9:
        if (r7 != null) goto L14;
        if (r1 == null) goto L12;
        r7 = r1.isAnchor();
        goto L14
    L12:
        r7 = null;
    L14:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L16;
        return false;
    L16:
        if (r6 != null) goto L22;
        if (r1 == null) goto L21;
        com.bytedance.live.datacontext.m r8 = r1.getRoom();
        if (r8 == null) goto L21;
        r6 = (IRoom) r8.getValue();
    L21:
        r6 = null;
    L22:
        if (r6 == null) goto L29;
        IRoomAuthStatus r9 = r6.getRoomAuthStatus();
        if (r9 == null) goto L29;
        if (r9.isEnableFirstFetchHistory() != true) goto L29;
        return true;
    L29:
        return false;
    L8:
        r1 = null;
        goto L9
    }
}
