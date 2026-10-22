package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import ns8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class MultimodalInputComponent$createMultimodalDataProcessor$1 extends FunctionReferenceImpl implements Function1<Boolean, b> {
    public MultimodalInputComponent$createMultimodalDataProcessor$1(Object r8) {
        super(1, r8, MultimodalInputComponent.class, "resolveImageProcessConfig", "resolveImageProcessConfig(Z)Lcom/larus/bmhome/uploadmedia/bean/ProcessConfig;", 0);
    }

    public final b invoke(boolean r18) {
        MultimodalInputComponent r1 = (MultimodalInputComponent) ((CallableReference) this).receiver;
        if (r18 == true) goto L7;
        b r2 = r1.E;
        if (r2 != null) goto L69;
        return null;
    L69:
        return b.a(r2, false, false, 63);
    L7:
        int r5 = MultimodalInputComponent.N;
        r1.getClass();
        int r6 = l.a;
        int r7 = sa9.a.a;
        b r8 = new b(0);
        AtomicReference r9 = ga9.a.a;
        ga9.e.a.getClass();
        if (((b) ga9.e.a(ga9.a.c("chat_image_skip_resize_config", ga9.e.c(r8)), b.class, r8)).a() == true) goto L15;
        FLogger r10 = FLogger.a;
        if (r10.isDebug() == false) goto L12;
        r10.i("MultimodalInputWrapper", "[图片清晰度策略][场景判断] 入口符合=是，开关开启=否，跳过降采样=否");
    L12:
        b r3 = r1.E;
        if (r3 != null) goto L71;
        return null;
    L71:
        return b.a(r3, false, false, 63);
    L15:
        sd8.a r11 = s1a.d.a(r1).getAbility(sd8.a.class);
        if (r11 == null) goto L20;
        qy8.a r12 = r11.yu();
        if (r12 == null) goto L20;
        Boolean r13 = r12.j;
    L21:
        com.larus.bmhome.chat.component.cvs.y r14 = r1.u0();
        if (r14 == null) goto L24;
        wc9.e r15 = r14.h();
    L25:
        boolean r16 = com.larus.bmhome.utils.i.f(r15);
        com.larus.bmhome.instruction.g r17 = r1.vc();
        if (r17 != null) goto L28;
    L30:
        boolean r19 = false;
    L31:
        if (r13 == null) goto L33;
        boolean r110 = r13.booleanValue();
    L37:
        FLogger r111 = FLogger.a;
        if (r111.isDebug() == false) goto L59;
        String r112 = "是";
        if (r13 != null) goto L42;
        String r20 = "未设置";
    L46:
        StringBuilder r113 = new StringBuilder("[图片清晰度策略][场景判断] 入口符合=是，开关开启=是，宿主覆盖=");
        r113.append(r20);
        r113.append("，主Bot会话=");
        if (r16 == false) goto L49;
        String r21 = "是";
    L50:
        r113.append(r21);
        r113.append("，任务模式=");
        if (r19 == false) goto L53;
        String r22 = "是";
    L54:
        r113.append(r22);
        r113.append("，跳过降采样=");
        if (r110 == true) goto L58;
        r112 = "否";
    L58:
        r113.append(r112);
        r113.append("，线上放大保留=是");
        r111.i("MultimodalInputWrapper", r113.toString());
        goto L59
    L53:
        r22 = "否";
        goto L54
    L49:
        r21 = "否";
        goto L50
    L42:
        if (r13.booleanValue() == false) goto L44;
        r20 = "是";
        goto L46
    L44:
        r20 = "否";
    L59:
        if (r110 == false) goto L64;
        b r4 = r1.E;
        if (r4 != null) goto L72;
        r4 = new b(false, false, false, false, false, 127);
    L72:
        return b.a(r4, false, true, 63);
    L64:
        b r23 = r1.E;
        if (r23 != null) goto L67;
        return null;
    L67:
        return b.a(r23, false, false, 63);
    L33:
        if (r16 == false) goto L36;
        if (r19 == false) goto L36;
        r110 = true;
    L36:
        r110 = false;
        goto L37
    L28:
        if (r17.yW() != true) goto L30;
        r19 = true;
        goto L31
    L24:
        r15 = null;
    L20:
        r13 = null;
        goto L21
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Boolean) r1).booleanValue());
    }
}
