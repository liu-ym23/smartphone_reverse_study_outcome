package com.larus.bmhome.taskskill;

import com.larus.im.bean.message.AgentTaskParam;
import com.larus.im.bean.message.AgentTaskParamChange;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.utils.logger.FLogger;
import ic8.w;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class z0 implements Function1 {
    public final /* synthetic */ SkillComponent a;

    public /* synthetic */ z0(SkillComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r53) {
        SkillComponent r1 = this.a;
        Regex r3 = SkillComponent.F2;
        Intrinsics.checkNotNullParameter((w) r53, "it");
        boolean r4 = true;
        wc9.e r5 = null;
        if (r1.yW() == true) goto L14;
        int r2 = h.a;
        com.larus.bmhome.chat.component.cvs.y r6 = r1.d4();
        if (r6 == null) goto L7;
        r5 = r6.h();
    L7:
        boolean r7 = h.a(r5).a();
        if (r7 == false) goto L10;
        r1.M1 = true;
        r1.y1 = new AgentTaskParamChange(false, false, false, 7, null);
    L10:
        if (r7 == false) goto L12;
        GeneralTaskParam r8 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, new AgentTaskParamChange(false, false, false, 7, null), r1.F4(), new AgentTaskParam(1, null, null, null, null, null, null, 126, null), null, 36863, null);
    L13:
        zd9.h.a.getClass();
        return zd9.h.c(r8);
    L12:
        r8 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65535, null);
        goto L13
    L14:
        j r9 = r1.X3();
        if (r9 == null) goto L23;
        ConcurrentHashMap<a, RemoteControlAuthorizationMode> r10 = c.a;
        a r11 = r1.B3(r9.c);
        RemoteControlAuthorizationMode r12 = r9.b;
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, "mode");
        RemoteControlAuthorizationMode r13 = c.b.put(new b(r11.a, r11.b), r12);
        if (r13 == null) goto L20;
        if (r13 == r12) goto L20;
        boolean r14 = true;
    L21:
        if (r14 != true) goto L23;
        boolean r15 = true;
    L24:
        FLogger r16 = FLogger.a;
        r16.i("SkillComponent", "BeforesendMessge: " + r1.y1);
        zd9.h r17 = zd9.h.a;
        if (r1.F4() == true) goto L29;
        if (r15 == true) goto L29;
        boolean r27 = false;
    L30:
        j r18 = r1.X3();
        if (r18 == null) goto L35;
        RemoteControlAuthorizationMode r19 = r18.b;
        if (r19 == null) goto L35;
        Integer r20 = Integer.valueOf(r19.getRawValue());
    L36:
        bs8.a r21 = r1.v1;
        StringBuilder r110 = new StringBuilder("buildCurrentAgentTaskParam: ");
        if (r21 == null) goto L39;
        String r111 = r21.a;
    L40:
        r110.append(r111);
        r110.append(" - ");
        if (r21 == null) goto L43;
        Integer r112 = r21.c;
    L44:
        r110.append(r112);
        r110.append(" - ");
        if (r21 == null) goto L47;
        r5 = r21.e;
    L47:
        r110.append(r5);
        r16.i("SkillComponent", r110.toString());
        if (r21 == null) goto L55;
        Integer r22 = r21.c;
        if (r22 == null) goto L55;
        if (r22.intValue() != 2) goto L55;
        boolean r23 = true;
    L56:
        if (r23 == false) goto L65;
        String r24 = r21.e;
        if (r24 != null) goto L60;
    L63:
        if (r4 == true) goto L65;
        AgentTaskParam r25 = new AgentTaskParam(2, r21.b, r21.a, r21.d, r21.e, r21.g, r20);
    L66:
        AgentTaskParam r28 = r25;
        AgentTaskParamChange r26 = r1.y1;
        GeneralTaskParam r29 = new GeneralTaskParam(null, null, null, null, null, null, null, null, null, null, null, null, r26.copy(r26.getRuntimeChanged(), r1.y1.getDeviceChanged(), r15), r27, r28, null, 36863, null);
        r17.getClass();
        String r30 = zd9.h.c(r29);
        r1.y1 = new AgentTaskParamChange(false, false, false, 7, null);
        return r30;
    L60:
        if (StringsKt.isBlank(r24) == true) goto L63;
        r4 = false;
    L65:
        r25 = new AgentTaskParam(1, null, null, null, null, null, null);
    L55:
        r23 = false;
        goto L56
    L43:
        r112 = null;
        goto L44
    L39:
        r111 = null;
    L35:
        r20 = null;
    L29:
        r27 = true;
    L20:
        r14 = false;
    L23:
        r15 = false;
        goto L24
    }
}
