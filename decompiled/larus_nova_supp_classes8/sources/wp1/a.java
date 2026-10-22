package wp1;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.c;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.chatroom.widget.PlayerVisibilityControllerWidget;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements c {
    public final VSPlayerViewControlContext a;
    public PlayerVisibilityControllerWidget b;
    public final CopyOnWriteArrayList<com.bytedance.android.livesdk.chatroom.vsplayer.api.a> c;
    public WidgetManager d;

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void clearControlWidget() {
        this.b = null;
        ALogger.w(k(), "clear activeWidget!");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void releaseService() {
        this.b = null;
        this.d = null;
        this.c.clear();
        ALogger.w(k(), "release service");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final boolean getLockStatus() {
        return ((Boolean) this.a.isLocked().getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final boolean getVisibilityStatus() {
        return ((Boolean) this.a.getPlayerViewVisible().getValue()).booleanValue();
    }

    public final String k() {
        return "VSPlayerViewControlService#" + hashCode();
    }

    public final boolean l() {
        Iterator<com.bytedance.android.livesdk.chatroom.vsplayer.api.a> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.a r1 = r0.next();
        if (r1.intercept() == false) goto L4;
        ALogger.w(k(), "visibility control intercepted by " + r1.getName());
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void resetHideTask() {
        this.a.getResetHideTaskEvent().post(Unit.INSTANCE);
    }

    public a() {
        this.a = new VSPlayerViewControlContext();
        this.c = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void changeVisibilityStatus() {
        if (l() == false) goto L5;
        return;
    L5:
        this.a.getPlayerViewVisible().setValue(Boolean.valueOf(!((Boolean) this.a.getPlayerViewVisible().getValue()).booleanValue()));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void markVisibilityStatusChangeByUser() {
        if (l() == false) goto L5;
        return;
    L5:
        this.a.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final WidgetManager getWidgetManager() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final VSPlayerViewControlContext provideContext() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void c(PlayerViewControl.KEY r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        PlayerVisibilityControllerWidget r0 = this.b;
        if (r0 == null) goto L12;
        if (r0 == null) goto L6;
        r0.Mq(r4);
    L6:
        String r1 = k();
        StringBuilder r2 = new StringBuilder("activeWidget[");
        PlayerVisibilityControllerWidget r3 = this.b;
        if (r3 == null) goto L9;
        int r5 = r3.hashCode();
    L10:
        r2.append(r5);
        r2.append("] not null,do remove, key:");
        r2.append(r4.getDescribe());
        ALogger.d(r1, r2.toString());
        return;
    L9:
        r5 = 0;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void e(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        PlayerVisibilityControllerWidget r0 = this.b;
        if (r0 == null) goto L9;
        r0.Bq(r4);
        String r1 = k();
        StringBuilder r2 = new StringBuilder("activeWidget[");
        PlayerVisibilityControllerWidget r3 = this.b;
        if (r3 == null) goto L7;
        int r5 = r3.hashCode();
    L8:
        r2.append(r5);
        r2.append("] not null,do direct add, key:");
        r2.append(r4.g.getDescribe());
        ALogger.d(r1, r2.toString());
        return;
    L7:
        r5 = 0;
        goto L8
    L9:
        this.a.getTmpControlItemList().add(r4);
        ALogger.w(k(), "activeWidget null,add to tmp list,key:" + r4.g.getDescribe());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void f(Widget r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        this.b = (PlayerVisibilityControllerWidget) r3;
        String r4 = k();
        StringBuilder r0 = new StringBuilder("register activeWidget![");
        PlayerVisibilityControllerWidget r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        r0.append(r2);
        r0.append(']');
        ALogger.w(r4, r0.toString());
        return;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final NextLiveData<Integer> g(PlayerViewControl.KEY r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        PlayerVisibilityControllerWidget r1 = this.b;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r5 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) ((LinkedHashMap) r1.k).get(r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.f;
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void h(PlayerViewControl.KEY r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        PlayerVisibilityControllerWidget r0 = this.b;
        if (r0 == null) goto L6;
        r0.Pq(r7, false, 0, true);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void i(RecyclableWidgetManager r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        this.b = null;
        this.d = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void j(boolean r4) {
        if (l() == false) goto L5;
        return;
    L5:
        ALogger.w(k(), "setVisibilityStatus[" + r4 + "] with customDuration:0");
        this.a.getCustomAnimDuration().setValue(0L);
        this.a.getPlayerViewVisible().setValue(Boolean.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void setVisibilityStatus(boolean r2) {
        if (l() == false) goto L5;
        return;
    L5:
        this.a.getPlayerViewVisible().setValue(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void a(PlayerViewControl.KEY r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        PlayerVisibilityControllerWidget r1 = this.b;
        if (r1 == null) goto L6;
        int r0 = PlayerVisibilityControllerWidget.A;
        r1.Pq(r8, r9, 0, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void d(PlayerViewControl.KEY r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "key");
        PlayerVisibilityControllerWidget r1 = this.b;
        if (r1 == null) goto L6;
        int r0 = PlayerVisibilityControllerWidget.A;
        r1.Pq(r8, r9, 300, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void b(PlayerViewControl.KEY r12, PlayerViewControl.Type r13, PlayerViewControl.Style r14, View r15, float r16, boolean r17, boolean r18, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "key");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "style");
        Intrinsics.checkNotNullParameter(r15, "view");
        if (r19 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r0 = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r12, r19, r15, r13, r14, r16, r17, r18, r20);
    L6:
        e(r0);
        return;
    L5:
        r0 = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r12, null, r15, r13, r14, r16, r17, r18, r20);
        goto L6
    }
}
