package com.obric.assistant.window.component;

import android.os.SystemClock;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0002\u0014\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/window/component/WindowAnimationLandscapeComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "<init>", "()V", "onCreate", "", "onDestroy", "getWindowAnimators", "", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimator;", "isShow", "", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "createLandscapeWindowSlideAnimator", "shouldUseLandscapeWindowSlide", "restoreWindowLayoutFromLayoutInfo", WindowEvent.Params.REASON, "", "Companion", "LandscapeWindowSlideAnimator", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowAnimationLandscapeComponent extends ComponentFeature implements IWindowAnimationProvider {

    public static final class a {
    }

    public static final class b implements IWindowAnimator {
        public final IAssistantChatWindow a;
        public final boolean b;
        public fja.d c;
        public Integer d;
        public Boolean e;

        @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
        public final void cancel() {
            FLogger.a.i("LandscapeWindowAnimationComponent", WindowEvent.WindowOpenPerfResult.CANCEL);
            fja.d r0 = this.c;
            if (r0 != null) goto L6;
            b("landscapeWindowSlide-cancel-restore");
            return;
        L6:
            this.c = null;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
            int r4 = fja.d.d;     // Catch: Throwable -> L9
            r0.a(false);     // Catch: Throwable -> L9
            Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            Throwable r2 = Result.exceptionOrNull-impl(r1);
            if (r2 == null) goto L14;
            FLogger.a.w("LandscapeWindowAnimationComponent", "cancel animation failed", r2);
        L14:
            b("landscapeWindowSlide-cancel-restore");
            return;
        L9:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }

        public final void b(String r4) {
            IAssistantChatWindow r0 = this.a;
            if (r0 == null) goto L5;
            WindowLayoutInfo r1 = r0.getWindowLayoutInfo();
        L6:
            if (r1 == null) goto L8;
            int r2 = r1.getVisibleY();
        L11:
            if (r1 == null) goto L13;
            boolean r3 = r1.getVisibleNoLimitsEnabled();
        L16:
            IAssistantChatWindow r5 = this.a;
            if (r5 == null) goto L22;
            r5.updateWindowAnimationLayout(r2, r3, r4);
            return;
        L22:
            return;
        L13:
            Boolean r6 = this.e;
            if (r6 == null) goto L21;
            r3 = r6.booleanValue();
            goto L16
        L21:
            return;
        L8:
            Integer r7 = this.d;
            if (r7 == null) goto L20;
            r2 = r7.intValue();
            goto L11
        L20:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimator
        public final void start(final Function1<? super Boolean, Unit> r13) {
            Intrinsics.checkNotNullParameter(r13, "onEnd");
            final IAssistantChatWindow r4 = this.a;
            if (r4 != null) goto L6;
            FLogger.a.w("LandscapeWindowAnimationComponent", "start ignored, assistantWindow is null");
            r13.invoke(Boolean.TRUE);
            return;
        L6:
            WindowLayoutInfo r2 = r4.getWindowLayoutInfo();
            if (r2 == null) goto L13;
            this.d = Integer.valueOf(r2.getVisibleY());
            this.e = Boolean.valueOf(r2.getVisibleNoLimitsEnabled());
            FLogger r3 = FLogger.a;
            StringBuilder r5 = new StringBuilder("start, isShow=");
            r5.append(this.b);
            r5.append(", isLandscape=");
            r5.append(r2.isLandscapeWindowLayout());
            r5.append(", visibleY=");
            r5.append(r2.getVisibleY());
            r5.append(", offscreenY=");
            if (r2.getDisplayHeight() <= 0) goto L11;
            int r6 = r2.getDisplayHeight();
        L12:
            r5.append(r6);
            r5.append(", displayHeight=");
            r5.append(r2.getDisplayHeight());
            r5.append(", windowHeight=");
            r5.append(r2.getWindowHeight());
            r5.append(", isNoLimitsEnabled=");
            r5.append(r2.isNoLimitsEnabled());
            r5.append(", visibleNoLimitsEnabled=");
            r5.append(r2.getVisibleNoLimitsEnabled());
            r3.i("LandscapeWindowAnimationComponent", r5.toString());
        L14:
            if (r2 == null) goto L18;
            boolean r7 = true;
            if (r2.isLandscapeWindowLayout() != true) goto L18;
        L20:
            if (r7 == true) goto L22;
        L25:
            c(r4, 0.0f, "landscapeWindowSlide-start");
            final long r8 = SystemClock.elapsedRealtime();
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L32
            com.obric.common.oea.foundation.animation.builder.d.a r10 = new com.obric.common.oea.foundation.animation.builder.d.a();     // Catch: Throwable -> L32
            if (this.b == false) goto L29;
            com.obric.common.oea.foundation.animation.spec.spring.b r11 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_3, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Throwable -> L32
        L30:
            r10.b(0.0f, 1.0f, r11, null);     // Catch: Throwable -> L32
            Function3<? super String, Object, Object, Unit> r12 = new e0(this, r4);     // Catch: Throwable -> L32
            Intrinsics.checkNotNullParameter(r12, "callback");     // Catch: Throwable -> L32
            r10.d = r12;     // Catch: Throwable -> L32
            Function2<? super Boolean, ? super Throwable, Unit> r14 = new f0(this, r4, r8, r13);     // Catch: Throwable -> L32
            Intrinsics.checkNotNullParameter(r14, "callback");     // Catch: Throwable -> L32
            r10.e = r14;     // Catch: Throwable -> L32
            this.c = r10.a().a();     // Catch: Throwable -> L32
            Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
        L34:
            Throwable r1 = Result.exceptionOrNull-impl(r0);
            if (r1 == null) goto L40;
            FLogger.a.w("LandscapeWindowAnimationComponent", "start animation failed", r1);
            this.c = null;
            b("landscapeWindowSlide-start-failed-restore");
            r13.invoke(Boolean.FALSE);
            return;
        L40:
            return;
        L29:
            r11 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_2);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r0 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L34
        L22:
            if (a(r2, 0.0f) != a(r2, 1.0f)) goto L25;
            FLogger.a.i("LandscapeWindowAnimationComponent", "skip, startY == targetY, progress based");
            b("landscapeWindowSlide-skip-restore");
            r13.invoke(Boolean.TRUE);
            return;
        L18:
            r7 = false;
            goto L20
        L11:
            r6 = r2.getVisibleY() + r2.getWindowHeight();
            goto L12
        L13:
            FLogger.a.w("LandscapeWindowAnimationComponent", "start, layoutInfo is null, wait for landscape update");
            goto L14
        }

        public b(IAssistantChatWindow r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final int a(WindowLayoutInfo r4, float r5) {
            int r0 = r4.getVisibleY();
            if (r4.getDisplayHeight() <= 0) goto L5;
            int r6 = r4.getDisplayHeight();
        L6:
            boolean r1 = this.b;
            if (r1 == false) goto L9;
            int r2 = r6;
        L10:
            if (r1 == true) goto L14;
            r0 = r6;
        L14:
            return MathKt.roundToInt(r2 + ((r0 - r2) * RangesKt.coerceIn(r5, 0.0f, 1.0f)));
        L9:
            r2 = r0;
            goto L10
        L5:
            r6 = r4.getWindowHeight() + r4.getVisibleY();
            goto L6
        }

        public final void c(IAssistantChatWindow r4, float r5, String r6) {
            WindowLayoutInfo r0 = r4.getWindowLayoutInfo();
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == true) goto L10;
            return;
        L10:
            this.d = Integer.valueOf(r0.getVisibleY());
            this.e = Boolean.valueOf(r0.getVisibleNoLimitsEnabled());
            r4.updateWindowAnimationLayout(a(r0, r5), true, r6);
            return;
        L5:
            if (r0.isLandscapeWindowLayout() != true) goto L7;
            r2 = true;
            goto L8
        }
    }

    static {
    }

    public final void onCreate() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.addWindowAnimationCreator(this);
        return;
    }

    public final void onDestroy() {
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.removeWindowAnimationCreator(this);
        return;
    }

    public WindowAnimationLandscapeComponent() {
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider
    public final List<IWindowAnimator> getWindowAnimators(boolean r4, WindowAnimationType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        FLogger.a.i("LandscapeWindowAnimationComponent", "getWindowAnimators, isShow=" + r4 + ", type=" + r5);
        boolean r1 = false;
        if (r5 != WindowAnimationType.Slide) goto L11;
        IAssistantChatWindow r6 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r6 == null) goto L11;
        WindowLayoutInfo r7 = r6.getWindowLayoutInfo();
        if (r7 == null) goto L11;
        r1 = r7.isLandscapeWindowLayout();
    L11:
        if (r1 == true) goto L22;
        IAssistantChatWindow r8 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r8 == null) goto L20;
        WindowLayoutInfo r9 = r8.getWindowLayoutInfo();
        if (r9 == null) goto L20;
        r8.updateWindowAnimationLayout(r9.getVisibleY(), r9.getVisibleNoLimitsEnabled(), "landscapeWindowSlide-not-used-restore");
    L20:
        return CollectionsKt.emptyList();
    L22:
        return CollectionsKt.listOf(new b((IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class), r4));
    }
}
