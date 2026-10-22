package com.larus.bmhome.chat.component.bottom.core;

import android.R;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s2 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ s2(CoreInputComponent r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.larus.bmhome.chat.component.bottom.core.x2] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.larus.bmhome.chat.component.bottom.core.y2] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.larus.bmhome.chat.component.bottom.core.v2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invoke(Object r27) {
        final CoreInputComponent r1 = this.a;
        int r3 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r27, "it");
        FragmentActivity r4 = a.c(r1).getActivity();
        if (r4 != null) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r1.f1().m() == null) goto L8;
        boolean r10 = true;
    L9:
        Integer r2 = r1.f1().m();
        if (r2 == null) goto L12;
        int r5 = r2.intValue();
    L13:
        Map<String, String> r6 = r1.F4().takeOverConfig().k;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L15:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<String, String> r8 = r7.next();
        if (d9.a.contains(r8.getKey()) == false) goto L15;
        r9.put(r8.getKey(), r8.getValue());
        goto L15
    L19:
        r1.F4().trackOnClickFullScreenEdit(r1.k4().getBotId(), r9);
        oaa.a r11 = r1.v4();
        if (r11 == null) goto L22;
        r11.V8();
    L22:
        com.larus.bmhome.chat.component.bottom.voice.a r12 = r1.Zd();
        if (r12 != null) goto L25;
    L27:
        boolean r13 = false;
    L28:
        if (r13 == false) goto L41;
        com.larus.bmhome.chat.component.bottom.voice.a r14 = r1.Zd();
        if (r14 == null) goto L41;
        com.larus.bmhome.chat.component.bottom.voice.service.h r15 = r14.Hw();
        if (r15 == null) goto L41;
        if ((!r15.b) == true) goto L37;
        r15 = null;
    L37:
        if (r15 == null) goto L41;
        CharSequence r16 = r15.a;
        if (r16 == null) goto L41;
        String r17 = r16.toString();
    L42:
        if (r17 != null) goto L53;
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r18 = r1.W4();
        if (r18 == null) goto L49;
        Editable r19 = r18.l1();
        if (r19 == null) goto L49;
        SpannableStringBuilder r20 = new SpannableStringBuilder(r19);
    L50:
        if (r20 == null) goto L52;
        CharSequence r110 = r20;
    L54:
        z8.a r21 = r1.F4().takeOverConfig();
        Function1 r22 = r1.P2;
        if (r22 == null) goto L57;
        r22.invoke(Boolean.TRUE);
    L57:
        ILegacyChatUiServiceDelegate r23 = ILegacyChatUiServiceDelegate.b;
        BotModel r24 = r1.F4().getBotModel();
        de8.c r111 = r1.f1();
        t1a.b r112 = s1a.d.a(r1);
        com.larus.bmhome.chat.component.cvs.y r113 = r1.u0();
        va8.m r114 = r1.vU();
        if (r114 == null) goto L62;
        va8.l r115 = r114.iX();
        if (r115 == null) goto L62;
        ConstraintLayout r116 = r115.getRootView();
    L64:
        if ((r116 instanceof ChatConstraintLayout) == false) goto L66;
        ChatConstraintLayout r117 = (ChatConstraintLayout) r116;
    L67:
        if (r117 == null) goto L69;
        int r25 = r117.getBottomPadding();
    L71:
        if (r1.F4().getCurrentInputStatus() == 4) goto L73;
    L75:
        boolean r26 = false;
    L76:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Fragment r118 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1);
        if ((r118 instanceof xe8.a) == true) goto L80;
        r118 = null;
    L80:
        if (r118 == null) goto L84;
        View r119 = r118.getView();
        if (r119 == null) goto L84;
        ViewParent r120 = r119.getParent();
    L86:
        if ((r120 instanceof ViewGroup) == false) goto L88;
        ViewGroup r121 = (ViewGroup) r120;
    L89:
        ViewGroup r122 = r1.O2;
        if (r122 == null) goto L94;
        r121 = r122;
    L94:
        if ((r121 instanceof FragmentContainerView) == true) goto L96;
        ViewGroup r28 = r121;
    L108:
        boolean r123 = r1.N2;
        boolean r29 = r21.s;
        IObricChatUIService r30 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r30 == null) goto L114;
        if (r30.p() != true) goto L114;
        boolean r31 = true;
    L115:
        if (r31 == false) goto L119;
        com.larus.bmhome.chat.component.bottom.core.inputtext.p0 r32 = r1.W4();
        if (r32 == null) goto L119;
        InputFilter[] r210 = r32.S0();
    L120:
        r23.L8(r4, r24, r111, r112, r113, r25, r10, Integer.valueOf(r5), r110, new v2(r1), new x2(r1), new y2(r1), r26, r123, r28, r29, r210, r9);
        r1.K2 = true;
        return Unit.INSTANCE;
    L119:
        r210 = null;
    L114:
        r31 = false;
        goto L115
    L96:
        boolean r124 = com.larus.platform.service.z2.a.getBasicExperienceBugFixConfig().a;
        if (r124 == false) goto L102;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FragmentActivity r125 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getActivity();
        if (r125 == null) goto L101;
        ViewGroup r33 = (ViewGroup) r125.findViewById(R.id.content);
    L103:
        FLogger r126 = FLogger.a;
        StringBuilder r34 = new StringBuilder("[resolveFullScreenEditTargetContainer] enableFix=");
        r34.append(r124);
        r34.append(" historicalTarget=");
        r34.append(CoreInputComponent.x6(r121));
        r34.append(" finalTarget=");
        r34.append(CoreInputComponent.x6(r33));
        r34.append(" fragment=");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r34.append(com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getClass().getSimpleName());
        r34.append(" activity=");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        FragmentActivity r127 = com.larus.ui.arch.component.internal.attach.a.b(r1, r1).getActivity();
        if (r127 == null) goto L106;
        String r128 = r127.getClass().getSimpleName();
    L107:
        r34.append(r128);
        r126.i("CoreInputComponent", r34.toString());
        r28 = r33;
        goto L108
    L106:
        r128 = null;
        goto L107
    L101:
        r33 = null;
        goto L103
    L102:
        r33 = r121;
        goto L103
    L88:
        r121 = null;
    L84:
        r120 = null;
        goto L86
    L73:
        if (r1.F4().validModifyMode() == false) goto L75;
        r26 = true;
        goto L76
    L69:
        r25 = 0;
        goto L71
    L66:
        r117 = null;
    L62:
        r116 = null;
        goto L64
    L52:
        r17 = r1.u7();
    L49:
        r20 = null;
    L53:
        r110 = r17;
    L41:
        r17 = null;
        goto L42
    L25:
        if (r12.DG() != true) goto L27;
        r13 = true;
        goto L28
    L12:
        r5 = -1;
        goto L13
    L8:
        r10 = false;
        goto L9
    }
}
