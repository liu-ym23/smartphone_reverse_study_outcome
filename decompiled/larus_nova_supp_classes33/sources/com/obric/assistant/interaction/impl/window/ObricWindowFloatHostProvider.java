package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricWindowFloatHostProvider;", "Lcom/larus/common_ui/floatwindow/manager/IFloatWindowHostProvider;", "<init>", "()V", "priority", "", "getPriority", "()I", "provideFloatWindowHost", "Lcom/larus/common_ui/floatwindow/manager/FloatWindowHostInfo;", "context", "Lcom/larus/common_ui/floatwindow/manager/FloatWindowHostResolveContext;", "shouldYieldToActivityFallback", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowFloatHostProvider implements IFloatWindowHostProvider {
    private static final Companion Companion = null;
    private static final String HOST_ID = "obric_window";
    private static final int PRIORITY = 100;
    private static final String TAG = "ObricWindowFloatHostProvider";
    private final int priority;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ObricWindowFloatHostProvider$Companion;", "", "<init>", "()V", "TAG", "", "HOST_ID", "PRIORITY", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public e19.b provideFloatWindowHost(e19.h r1) {
        return null;
    }

    public ObricWindowFloatHostProvider() {
        this.priority = 100;
    }

    public int getPriority() {
        return this.priority;
    }

    private final boolean shouldYieldToActivityFallback(e19.c r6) {
        Activity r0 = r6.getActivity();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (ObricChatContextServiceDelegate.b.c(r0) == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
    L21:
        return false;
    L13:
        if (WindowHost.INSTANCE.isTransitionOverlayAnimationRunning() == false) goto L21;
        FLogger r1 = FLogger.a;
        StringBuilder r3 = new StringBuilder("yield host to activity fallback, reason=");
        r3.append(r6.e);
        r3.append(", previousHost=");
        e19.b r7 = r6.d;
        if (r7 == null) goto L18;
        String r8 = r7.a;
    L19:
        r3.append(r8);
        r3.append(", activity=");
        r3.append(r0.getClass().getName());
        r1.i(TAG, r3.toString());
        return true;
    L18:
        r8 = null;
        goto L19
    L8:
        if ((r0 instanceof ChatWindowActivity) == true) goto L10;
        r2 = true;
        goto L11
    }

    public e19.b provideFloatWindowHost(e19.c r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if (shouldYieldToActivityFallback(r9) == false) goto L5;
        return null;
    L5:
        WindowHost r10 = WindowHost.INSTANCE;
        if (r10.isShowing() == true) goto L8;
        return null;
    L8:
        if (r10.isStashed() == true) goto L42;
        View r1 = r10.getDecorView();
        if ((r1 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r1;
    L14:
        if (r4 != null) goto L17;
        return null;
    L17:
        if (r4.isAttachedToWindow() == true) goto L19;
        return null;
    L19:
        if (r4.getWidth() > 0) goto L21;
        return null;
    L21:
        if (r4.getHeight() <= 0) goto L43;
        Rect r2 = r10.getWindowVisibleBounds$impl_mainlandRelease();
        if (r2 != null) goto L26;
        return null;
    L26:
        if (r2.width() > 0) goto L28;
    L30:
        boolean r3 = false;
    L31:
        if (r3 == true) goto L34;
        r2 = null;
    L34:
        if (r2 != null) goto L36;
        return null;
    L36:
        return new e19.b(HOST_ID, r4, new Rect(0, 0, r4.getWidth(), r4.getHeight()), new Rect(r2), r10.getCurrentWindowOrientation$impl_mainlandRelease());
    L28:
        if (r2.height() <= 0) goto L30;
        r3 = true;
        goto L31
    L43:
        return null;
    L13:
        r4 = null;
        goto L14
    L42:
        return null;
    }
}
