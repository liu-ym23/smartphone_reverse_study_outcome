package com.obric.assistant.interaction.api;

import android.app.Activity;
import android.os.Bundle;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class IAssistantChatWindow$DefaultImpls {
    public static void addWindowAnimationListener(IAssistantChatWindow r0, IWindowAnimationListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
    }

    public static void applyWindowAnimationBoost(IAssistantChatWindow r0, String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "source");
    }

    public static WindowLayoutInfo getWindowLayoutInfo(IAssistantChatWindow r0) {
        return null;
    }

    public static Boolean isMainBotActivity(IAssistantChatWindow r0, Activity r1) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        return null;
    }

    public static boolean isWindowAnimationRunning(IAssistantChatWindow r0) {
        return false;
    }

    public static void removeWindowAnimationListener(IAssistantChatWindow r0, IWindowAnimationListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
    }

    public static void updateBackgroundDimAmount(IAssistantChatWindow r0, float r1) {
    }

    public static void updateWindowAnimationLayout(IAssistantChatWindow r0, int r1, boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
    }

    public static void updateWindowAnimationNoLimitsEnabled(IAssistantChatWindow r0, boolean r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.REASON);
    }

    public static void updateWindowAnimationY(IAssistantChatWindow r0, int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.REASON);
    }

    public static /* synthetic */ void exitVirtualDisplay$default(IAssistantChatWindow r0, long r1, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        r0.exitVirtualDisplay(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitVirtualDisplay");
    }

    public static /* synthetic */ void pop$default(IAssistantChatWindow r0, WindowAnimationType r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = WindowAnimationType.None;
    L6:
        r0.pop(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pop");
    }

    public static /* synthetic */ void stash$default(IAssistantChatWindow r0, WindowAnimationType r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = WindowAnimationType.None;
    L6:
        r0.stash(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stash");
    }

    public static /* synthetic */ Bundle buildLaunchParams$default(IAssistantChatWindow r5, String r6, boolean r7, Boolean r8, Bundle r9, Map r10, Integer r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L33;
        if ((r13 & 1) == 0) goto L6;
        r6 = "";
    L6:
        boolean r0 = false;
        if ((r13 & 2) == 0) goto L9;
        boolean r15 = false;
    L10:
        Integer r1 = null;
        if ((r13 & 4) == 0) goto L13;
        Boolean r2 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        Bundle r3 = null;
    L19:
        if ((r13 & 16) == 0) goto L21;
        Map r4 = null;
    L23:
        if ((r13 & 32) != 0) goto L27;
        r1 = r11;
    L27:
        if ((r13 & 64) != 0) goto L31;
        r0 = r12;
    L31:
        return r5.buildLaunchParams(r6, r15, r2, r3, r4, r1, r0);
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r15 = r7;
        goto L10
    L33:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildLaunchParams");
    }

    public static /* synthetic */ void openChatWindow$default(IAssistantChatWindow r11, String r12, boolean r13, Boolean r14, Bundle r15, boolean r16, boolean r17, Map r18, Integer r19, boolean r20, boolean r21, int r22, Object r23) {
        if (r23 != null) goto L47;
        if ((r22 & 1) == 0) goto L7;
        String r1 = "";
    L8:
        boolean r3 = false;
        if ((r22 & 2) == 0) goto L11;
        boolean r2 = false;
    L12:
        Integer r5 = null;
        if ((r22 & 4) == 0) goto L15;
        Boolean r4 = null;
    L17:
        if ((r22 & 8) == 0) goto L19;
        Bundle r6 = null;
    L20:
        boolean r8 = true;
        if ((r22 & 16) == 0) goto L23;
        boolean r7 = true;
    L25:
        if ((r22 & 32) != 0) goto L29;
        r8 = r17;
    L29:
        if ((r22 & 64) == 0) goto L31;
        Map r9 = null;
    L33:
        if ((r22 & 128) != 0) goto L37;
        r5 = r19;
    L37:
        if ((r22 & 256) == 0) goto L39;
        boolean r10 = false;
    L41:
        if ((r22 & 512) != 0) goto L44;
        r3 = r21;
    L44:
        r11.openChatWindow(r1, r2, r4, r6, r7, r8, r9, r5, r10, r3);
        return;
    L39:
        r10 = r20;
        goto L41
    L31:
        r9 = r18;
        goto L33
    L23:
        r7 = r16;
        goto L25
    L19:
        r6 = r15;
        goto L20
    L15:
        r4 = r14;
        goto L17
    L11:
        r2 = r13;
        goto L12
    L7:
        r1 = r12;
        goto L8
    L47:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openChatWindow");
    }
}
