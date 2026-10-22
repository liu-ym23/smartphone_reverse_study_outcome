package com.suite.lark.platform.feature.forward.doubao;

import android.content.Context;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.configuration.Forward$Source;
import com.ss.android.lark.forwardv3.configuration.ForwardCommonConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardSelectConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r7, npc.d r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "template");
        if (r8.b.getDoubaoMsgIds().isEmpty() == false) goto L6;
        Log.w("DoubaoForwardStarter", "startForward ignored: doubao msg id is empty");
        return;
    L6:
        StringBuilder r0 = new StringBuilder("startForward doubaoData present: ");
        if (r8.b.getDoubaoData() == null) goto L9;
        boolean r2 = true;
    L10:
        r0.append(r2);
        r0.append(", size=");
        byte[] r3 = r8.b.getDoubaoData();
        if (r3 == null) goto L13;
        int r4 = r3.length;
    L14:
        r0.append(r4);
        Log.i("DoubaoForwardStarter", r0.toString());
        i.a.update(r8.b);
        int r1 = u.a;
        ForwardTemplateNew.a r5 = new ForwardTemplateNew.a();
        ForwardScene r6 = r8.a;
        int r9 = w.a[r6.ordinal()];
        if (r9 != 1) goto L17;
        Forward$Source r10 = Forward$Source.DOUBAO;
    L22:
        Intrinsics.checkNotNullParameter(r10, "source");
        r5.h = r10;
        ForwardCommonConfig.a r11 = new ForwardCommonConfig.a();
        r8.d.getClass();
        ForwardCommonConfig r12 = r11.a();
        Intrinsics.checkNotNullParameter(r12, "forwardCommonConfig");
        r5.c = r12;
        int r13 = com.suite.lark.platform.feature.forward.doubao.launcher.a.a;
        npc.b r14 = r8.e;
        Intrinsics.checkNotNullParameter(r14, "config");
        ForwardTargetConfig.a r15 = new ForwardTargetConfig.a();
        r14.getClass();
        IncludeConfig.a r16 = new IncludeConfig.a();
        EntityItem.a r17 = new EntityItem.a();
        r17.f(new UserConfig.a().a());
        r16.a(r17.c());
        EntityItem.a r18 = new EntityItem.a();
        r18.d(new GroupConfig.a().a());
        r16.a(r18.c());
        EntityItem.a r19 = new EntityItem.a();
        ThreadConfig.a r20 = new ThreadConfig.a();
        r20.b(Condition$ThreadType.MSG_THREAD);
        r19.e(r20.a());
        r16.a(r19.c());
        IncludeConfig r21 = r16.b();
        Intrinsics.checkNotNullParameter(r21, "includeConfig");
        r15.d = r21;
        ForwardTargetConfig r22 = r15.a();
        Intrinsics.checkNotNullParameter(r22, "forwardTargetConfig");
        r5.a = r22;
        ForwardSelectConfig.a r23 = new ForwardSelectConfig.a();
        r23.c = r8.c;
        r23.b = false;
        r23.a = false;
        ForwardSelectConfig r24 = r23.a();
        Intrinsics.checkNotNullParameter(r24, "forwardSelectConfig");
        r5.b = r24;
        u.a(r7, r5.a(), 0, ExternalForwardSendMode.DOUBAO_ENTRY, 4);
        return;
    L17:
        if (r9 != 2) goto L20;
        r10 = Forward$Source.UNKNOWN;
        goto L22
    L20:
        throw new NoWhenBranchMatchedException();
    L13:
        r4 = 0;
        goto L14
    L9:
        r2 = false;
        goto L10
    }
}
