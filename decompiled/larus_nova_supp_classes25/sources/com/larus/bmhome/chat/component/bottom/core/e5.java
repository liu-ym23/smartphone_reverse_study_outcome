package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import com.larus.bmhome.utils.a4;
import com.larus.bmhome.view.chatinput.InputKeyboardIconPopupMenu;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e5 implements View.OnLongClickListener {
    public final /* synthetic */ CoreInputComponent a;
    public final /* synthetic */ LarusWidgetInputBinding b;

    public /* synthetic */ e5(CoreInputComponent r1, LarusWidgetInputBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.chat.component.bottom.core.m2, java.lang.Object] */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r8) {
        final CoreInputComponent r9 = this.a;
        final LarusWidgetInputBinding r0 = this.b;
        int r1 = CoreInputComponent.d3;
        boolean r2 = true;
        if (r9.k4().Z() == true) goto L6;
        FLogger.a.i("CoreInputComponent", "[canShowKeyboardIconPopupMenu] false: resolved policy");
    L11:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L23;
        a4.a.getClass();
        a4.a(a4.b);
        IFlowSdkDepend r4 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r4 == null) goto L17;
        r4.d0();
        boolean r5 = com.larus.home.impl.sdk.i1.a.h(r9.getContext(), "bpea-input-long-press");
    L18:
        if (r5 == true) goto L20;
        FLogger.a.i("CoreInputComponent", "[showKeyboardIconPopupMenu] ignore, hasPrimaryClip:false");
        r2 = false;
    L22:
        return r2;
    L20:
        final InputKeyboardIconPopupMenu r6 = new InputKeyboardIconPopupMenu(r9.getContext(), null, 6, 0);
        ?? r7 = new m2(r9);
        Intrinsics.checkNotNullParameter(r7, "block");
        r7.invoke(new InputKeyboardIconPopupMenu.c(r6));
        r0.H.post(new n2(r6, r0));
        goto L22
    L17:
        r5 = false;
        goto L18
    L23:
        return false;
    L6:
        if (com.larus.platform.service.z2.a.messageInputMenuConfig().a() == true) goto L9;
        FLogger.a.i("CoreInputComponent", "[canShowKeyboardIconPopupMenu] false: settings");
        goto L11
    L9:
        if (r9.G3() == true) goto L12;
        FLogger.a.i("CoreInputComponent", "[canShowKeyboardIconPopupMenu] false: scene");
        goto L11
    L12:
        r3 = true;
        goto L13
    }
}
