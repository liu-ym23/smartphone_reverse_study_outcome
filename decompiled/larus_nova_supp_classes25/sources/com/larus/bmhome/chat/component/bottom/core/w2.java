package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.bmhome.chat.component.bottom.reference.a;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.trace.SendingTextEditTriggeredScene;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w2 implements Function1 {
    public final /* synthetic */ LarusWidgetInputBinding a;
    public final /* synthetic */ CoreInputComponent b;

    public /* synthetic */ w2(LarusWidgetInputBinding r1, CoreInputComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r11) {
        LarusWidgetInputBinding r0 = this.a;
        CoreInputComponent r1 = this.b;
        int r2 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((FrameLayout) r11, "it");
        if (r0.a.isEnabled() == false) goto L41;
        EditText r12 = r1.V4();
        if (r12 == null) goto L9;
        r12.clearFocus();
    L9:
        if (ObricFeatureServiceDelegate.b.a() == false) goto L11;
        r1.o7(true);
    L11:
        a r13 = r1.g5();
        Function0<Unit> r3 = null;
        if (r13 == null) goto L14;
        String r14 = r13.wf();
    L15:
        a r4 = r1.g5();
        if (r4 == null) goto L20;
        ReferenceInfo r5 = r4.T6();
        if (r5 == null) goto L20;
        String r6 = r5.referencedMessageId;
    L21:
        r1.F4().trackOnClickBottomMenuEntrance(r14, r6);
        LifecycleOwner r15 = ViewTreeLifecycleOwner.get(r0.a);
        if (r15 == null) goto L26;
        LifecycleCoroutineScope r7 = LifecycleOwnerKt.getLifecycleScope(r15);
        if (r7 == null) goto L26;
        BuildersKt.launch$default(r7, null, null, new CoreInputComponent$setActionMenuEntranceClickListener$1$1(r1, null), 3, null);
    L26:
        z8.b r16 = r1.F4().takeOverConfig().l;
        if (r16 == null) goto L29;
        r3 = r16.b;
    L29:
        if (r3 == null) goto L31;
        r3.invoke();
        return Unit.INSTANCE;
    L31:
        r1.k4().C1(!r1.F4().showBottomMenu(), false, "click_plus");
        oaa.a r17 = r1.v4();
        if (r17 == null) goto L34;
        r17.V8();
    L34:
        com.larus.bmhome.chat.component.list.u7 r18 = (com.larus.bmhome.chat.component.list.u7) r1.r.getValue();
        if (r18 == null) goto L40;
        com.larus.bmhome.chat.trace.l0 r19 = r18.ON();
        if (r19 == null) goto L40;
        r19.w(SendingTextEditTriggeredScene.ACTION_MENU_ENTRANCE);
    L40:
        return Unit.INSTANCE;
    L20:
        r6 = null;
        goto L21
    L14:
        r14 = null;
        goto L15
    L41:
        return Unit.INSTANCE;
    }
}
