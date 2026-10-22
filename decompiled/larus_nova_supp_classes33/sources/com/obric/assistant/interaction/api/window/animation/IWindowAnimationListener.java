package com.obric.assistant.interaction.api.window.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationListener;", "", "onWindowAnimationStart", "", "isShow", "", "type", "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "onWindowAnimationEnd", "isSuccess", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IWindowAnimationListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onWindowAnimationEnd(IWindowAnimationListener r0, boolean r1, WindowAnimationType r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
        }

        public static void onWindowAnimationStart(IWindowAnimationListener r0, boolean r1, WindowAnimationType r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
        }
    }

    void onWindowAnimationEnd(boolean r1, WindowAnimationType r2, boolean r3);

    void onWindowAnimationStart(boolean r1, WindowAnimationType r2);
}
