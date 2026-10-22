package com.ss.android.lark.passportc.ffi;

import com.lark.kmp.basic.ActionContext;
import com.lark.kmp.basic.ActionType;
import com.lark.kmp.basic.ExecuteStrategy;
import com.lark.kmp.basic.ReturnType;
import com.lark.kmp.basic.Scene;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.g;
import f0c.h;
import gy7.p;
import gy7.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ActionType.values().length];
            r0[ActionType.Online.ordinal()] = 1;     // Catch: NoSuchFieldError -> L50
        L106:
            r0[ActionType.Offline.ordinal()] = 2;     // Catch: NoSuchFieldError -> L51
        L118:
            r0[ActionType.Clean.ordinal()] = 3;     // Catch: NoSuchFieldError -> L52
        L128:
            r0[ActionType.BringOnline.ordinal()] = 4;     // Catch: NoSuchFieldError -> L53
        L130:
            r0[ActionType.BringForeground.ordinal()] = 5;     // Catch: NoSuchFieldError -> L54
        L12:
            int[] r1 = new int[ExecuteStrategy.values().length];
            r1[ExecuteStrategy.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L55
        L92:
            r1[ExecuteStrategy.RETRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L56
        L102:
            r1[ExecuteStrategy.ROLLBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L57
        L16:
            int[] r2 = new int[Scene.values().length];
            r2[Scene.FIRST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L126:
            r2[Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L134:
            r2[Scene.FAST_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L140:
            r2[Scene.SWITCH_BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L148:
            r2[Scene.SWITCH_FOREGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L90:
            r2[Scene.CREATE_USER_COMPONENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L24:
            int[] r3 = new int[ReturnType.values().length];
            r3[ReturnType.QUICK_ONLINE_RETURN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L64
        L114:
            r3[ReturnType.Foreground.ordinal()] = 2;     // Catch: NoSuchFieldError -> L65
        L124:
            r3[ReturnType.All.ordinal()] = 3;     // Catch: NoSuchFieldError -> L66
        L28:
            int[] r4 = new int[ActionContext.values().length];
            r4[ActionContext.LoginContext.ordinal()] = 1;     // Catch: NoSuchFieldError -> L67
        L144:
            r4[ActionContext.LogoutContext.ordinal()] = 2;     // Catch: NoSuchFieldError -> L68
        L86:
            r4[ActionContext.SwitchContext.ordinal()] = 3;     // Catch: NoSuchFieldError -> L69
        L98:
            r4[ActionContext.InternalContext.ordinal()] = 4;     // Catch: NoSuchFieldError -> L70
        L33:
            int[] r5 = new int[UserState.values().length];
            r5[UserState.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L71
        L120:
            r5[UserState.OFFLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L72
        L132:
            r5[UserState.ABSENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L73
        L37:
            a = r5;
            int[] r6 = new int[com.ss.android.lark.passportc.api.Scene.values().length];
            r6[com.ss.android.lark.passportc.api.Scene.FIRST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L74
        L84:
            r6[com.ss.android.lark.passportc.api.Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L75
        L96:
            r6[com.ss.android.lark.passportc.api.Scene.FAST_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L76
        L104:
            r6[com.ss.android.lark.passportc.api.Scene.SWITCH_BACKGROUND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L77
        L112:
            r6[com.ss.android.lark.passportc.api.Scene.SWITCH_FOREGROUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L78
        L122:
            r6[com.ss.android.lark.passportc.api.Scene.CREATE_USER_COMPONENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L79
        L44:
            b = r6;
            int[] r7 = new int[com.lark.kmp.basic.UserState.values().length];
            r7[com.lark.kmp.basic.UserState.ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L80
        L146:
            r7[com.lark.kmp.basic.UserState.OFFLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L81
        L88:
            r7[com.lark.kmp.basic.UserState.PRE_ONLINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L82
        L100:
            r7[com.lark.kmp.basic.UserState.ABSENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L83
            return;
        }
    }

    static {
    }

    public static Scene a(com.ss.android.lark.passportc.api.Scene r1) {
        if (r1 != null) goto L4;
        int r2 = -1;
    L5:
        switch(r2) {
            case -1: goto L14;
            case 0: goto L7;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L7;
        };
    L14:
        return null;
    L7:
        throw new NoWhenBranchMatchedException();
    L16:
        return Scene.CREATE_USER_COMPONENT;
    L17:
        return Scene.SWITCH_FOREGROUND;
    L18:
        return Scene.SWITCH_BACKGROUND;
    L19:
        return Scene.FAST_ONLINE;
    L20:
        return Scene.SWITCH_ONLINE;
    L21:
        return Scene.FIRST_ONLINE;
    L4:
        r2 = a.b[r1.ordinal()];
        goto L5
    }

    public static p b(g r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        User r1 = r4.a;
        loa.a r2 = new loa.a(r1.userId, r1.name);
        UserSession r5 = r4.b;
        return new p(r2, r5.b, r5.a);
    }

    public static u c(h r2) {
        Intrinsics.checkNotNullParameter(r2, "userStatePayload");
        UserState r0 = r2.a;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        com.lark.kmp.basic.UserState r3 = com.lark.kmp.basic.UserState.ONLINE;
    L13:
        a(r2.b);
        Intrinsics.checkNotNullParameter(r2.getContext(), "userActionContext");
        return new u(r3, ActionContext.InternalContext);
    L5:
        if (r1 != 2) goto L7;
        r3 = com.lark.kmp.basic.UserState.OFFLINE;
        goto L13
    L7:
        if (r1 != 3) goto L10;
        r3 = com.lark.kmp.basic.UserState.ABSENT;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
