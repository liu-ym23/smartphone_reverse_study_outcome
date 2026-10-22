package com.bytedance.ai.bridge.method.event;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.keyboard.AbsHideKeyboardMethodIDL;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import e3.d;
import e3.e;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/HideKeyboardMethod;", "Lcom/bytedance/ai/bridge/keyboard/AbsHideKeyboardMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/keyboard/AbsHideKeyboardMethodIDL$HideKeyboardParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/keyboard/AbsHideKeyboardMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HideKeyboardMethod extends AbsHideKeyboardMethodIDL {
    public HideKeyboardMethod() {
    }

    public static View b(Window r10) {
        View r11 = r10.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r11;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsHideKeyboardMethodIDL.b) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        View r0 = r10.getEngineView();
        Activity r1 = e.a(r10);
        InputMethodManager r13 = null;
        if (r1 == null) goto L6;
        View r14 = r1.getCurrentFocus();
        if (r14 == null) goto L6;
    L15:
        if (r14 != null) goto L31;
        r14 = r10.getEngineView();
        if (r14 != null) goto L31;
        Activity r15 = r10.getOwnerActivity();
        if (r15 == null) goto L23;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L23;
        r14 = b(r16);
    L24:
        if (r14 != null) goto L31;
        Activity r17 = k.b();
        if (r17 == null) goto L30;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L30;
        r14 = b(r18);
    L30:
        r14 = null;
    L23:
        r14 = null;
    L31:
        if (r14 == null) goto L35;
        Context r19 = r14.getContext();
        if (r19 == null) goto L35;
        Object r20 = r19.getSystemService("input_method");
    L37:
        if ((r20 instanceof InputMethodManager) == false) goto L39;
        r13 = (InputMethodManager) r20;
    L39:
        if (r14 == null) goto L41;
        r14.clearFocus();
    L41:
        if (r14 == null) goto L46;
        IBinder r21 = r14.getWindowToken();
        if (r21 == null) goto L46;
        if (r13 == null) goto L46;
        r13.hideSoftInputFromWindow(r21, 0);
    L46:
        Intrinsics.checkNotNullParameter(AbsHideKeyboardMethodIDL.a.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsHideKeyboardMethodIDL.a.class), "");
        return;
    L35:
        r20 = null;
    L6:
        if (r0 == null) goto L8;
        r14 = r0.findFocus();
    L9:
        if (r14 != null) goto L15;
        if (r0 == null) goto L14;
        View r22 = r0.getRootView();
        if (r22 == null) goto L14;
        r14 = r22.findFocus();
    L14:
        r14 = null;
        goto L15
    L8:
        r14 = null;
        goto L9
    }
}
