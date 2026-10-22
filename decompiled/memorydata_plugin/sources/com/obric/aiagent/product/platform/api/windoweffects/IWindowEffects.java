package com.obric.aiagent.product.platform.api.windoweffects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/product/platform/api/windoweffects/IWindowEffects;", "", "startActivateEffect", "", "withRipple", "", "stopActivateEffect", "showScreenShotEffect", "skipWindowLayer", "windowLayerName", "", "playRippleEffect", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IWindowEffects {
    public static final Companion Companion = null;
    public static final String DEFAULT_WINDOW_LAYER_NAME = "obric-assistant-window";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/api/windoweffects/IWindowEffects$Companion;", "", "<init>", "()V", "DEFAULT_WINDOW_LAYER_NAME", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String DEFAULT_WINDOW_LAYER_NAME = "obric-assistant-window";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void playRippleEffect$default(IWindowEffects r2, boolean r3, String r4, int r5, Object r6) {
            IWindowEffects r7 = (IWindowEffects) ZeusTransformUtils.wrapperContextForParams(r2, IWindowEffects.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = false;
        L8:
            if ((r5 & 2) == 0) goto L10;
            r4 = "obric-assistant-window";
        L10:
            r7.playRippleEffect(r3, r4);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: playRippleEffect");
        }

        public static /* synthetic */ void showScreenShotEffect$default(IWindowEffects r2, boolean r3, String r4, int r5, Object r6) {
            IWindowEffects r7 = (IWindowEffects) ZeusTransformUtils.wrapperContextForParams(r2, IWindowEffects.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L13;
            if ((r5 & 1) == 0) goto L8;
            r3 = false;
        L8:
            if ((r5 & 2) == 0) goto L10;
            r4 = "obric-assistant-window";
        L10:
            r7.showScreenShotEffect(r3, r4);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showScreenShotEffect");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void playRippleEffect(boolean r1, String r2);

    void showScreenShotEffect(boolean r1, String r2);

    void startActivateEffect(boolean r1);

    void stopActivateEffect();
}
