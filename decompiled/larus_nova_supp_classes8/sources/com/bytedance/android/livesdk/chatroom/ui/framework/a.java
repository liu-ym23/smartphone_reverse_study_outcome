package com.bytedance.android.livesdk.chatroom.ui.framework;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a extends IAbility {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.ui.framework.a$a, reason: collision with other inner class name */
    public static final class C0015a {
        public static /* synthetic */ void b(a r1, Widget r2, int r3) {
            if ((r3 & 2) == 0) goto L5;
            boolean r4 = true;
        L6:
            r1.Zj(r2, r4, false);
            return;
        L5:
            r4 = false;
            goto L6
        }

        public static /* synthetic */ void a(a r0, int r1, Widget r2, boolean r3, int r4) {
            if ((r4 & 4) == 0) goto L5;
            r3 = true;
        L5:
            r0.Ro(r1, r2, r3, false);
        }
    }

    @Deprecated(message = "仅Saas同构使用")
    RecyclableWidgetManager Ao();

    <T extends LiveRecyclableWidget> void Cd(Class<T> r1, boolean r2, boolean r3);

    ViewLayerDelegate<? extends h70.b> E8();

    ah1.c E9();

    PropertyOwner Na();

    ViewLayerDelegate<? extends h70.b> Ni();

    void Og(j70.f r1);

    void Ro(int r1, Widget r2, boolean r3, boolean r4);

    void Uj(Widget r1);

    void Zj(Widget r1, boolean r2, boolean r3);

    PropertyOwner getLoadState();

    ViewLayerDelegate<? extends h70.b> hk();

    PropertyOwner i8();

    void vi(j70.f r1);

    Element<?> w8(j70.f r1);

    ah1.b xb();
}
