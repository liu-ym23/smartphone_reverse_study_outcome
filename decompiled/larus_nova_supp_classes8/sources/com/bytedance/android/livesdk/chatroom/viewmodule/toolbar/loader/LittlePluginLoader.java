package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.IGameManagerService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.u0;
import com.bytedance.android.livesdk.config.wi0;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/LittlePluginLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LittlePluginLoader extends AbsDynamicLoader {
    public u0 h;
    public final Context i;
    public final Function0<Unit> j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        if (f() == false) goto L36;
        c0.b r1 = null;
        Pair r2 = (Pair) this.a.get("data_little_plugin", null);     // Catch: Exception -> L8
    L9:
        if (r2 == null) goto L36;
        com.bytedance.android.live.broadcastgame.api.model.e r7 = (com.bytedance.android.live.broadcastgame.api.model.e) r2.getFirst();
        IGameManagerService.OpenPlatformAppState r3 = (IGameManagerService.OpenPlatformAppState) r2.getSecond();
        if (r7 == null) goto L36;
        if (r3 == null) goto L36;
        if (TextUtils.isEmpty(r7.c()) == true) goto L36;
        if (CollectionUtils.isEmpty(r7.a()) == true) goto L36;
        if (r3 != IGameManagerService.OpenPlatformAppState.OpenPlatformAppStateRunning) goto L21;
        boolean r4 = true;
    L22:
        ExtendedToolbarButton.d r5 = new ExtendedToolbarButton.d(r4, r7.a(), r7.c(), String.valueOf(r7.b()));
        if (this.h != null) goto L25;
        this.h = new u0(r4, this.i, r7, this.a, null);
    L25:
        g3 r6 = y3.f(this.a);
        if ((r6 instanceof x3) == true) goto L28;
        r6 = null;
    L28:
        if (r6 == null) goto L30;
        r1 = r6.s(r5);
    L30:
        if (r1 != null) goto L32;
        g3 r8 = y3.f(this.a);
        u0 r9 = this.h;
        Intrinsics.checkNotNull(r9);
        r8.p(r5, r9);
    L32:
        u0 r10 = this.h;
        if (r10 == null) goto L35;
        r10.a = r4;
    L35:
        r0.add(r5);
        goto L36
    L21:
        r4 = false;
    L8:
        r2 = null;
    L36:
        return r0;
    }

    public final boolean f() {
        Integer r0 = wi0.a.getValue();
        if (r0 != null) goto L6;
    L8:
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = this.a;
        r1.getClass();
        RoomContext r3 = RoomContext.a.a(r2, 0);
        if (r3 == null) goto L13;
        n r4 = r3.getPermissionContext();
        if (r4 == null) goto L13;
        RoomPermissionContext r5 = (RoomPermissionContext) r4.getValue();
    L14:
        if (r5 == null) goto L25;
        RoomPermissionContext r6 = (RoomPermissionContext) r3.getPermissionContext().getValue();
        if (r6 == null) goto L25;
        com.bytedance.live.datacontext.i r7 = r6.getShouldRefinePermission();
        if (r7 == null) goto L25;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L25;
        RoomPermissionContext.a r8 = RoomPermissionContext.Companion;
        DataCenter r9 = this.a;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r10 = LiveRoomPermission.p;
        r8.getClass();
        if (RoomPermissionContext.a.e(r9, r10) == false) goto L25;
        return true;
    L25:
        return false;
    L13:
        r5 = null;
        goto L14
    L6:
        if (r0.intValue() != 0) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.a.observe("data_little_plugin", this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
        if (f() == false) goto L6;
        this.a.put("cmd_fetch_little_plugin", Boolean.TRUE);
        return;
    }

    public final Context getContext() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final void e(KVData r3) {
        if (r3 == null) goto L32;
        String r0 = r3.getKey();
        if (r0 == null) goto L33;
        boolean r1 = true;
        if (r0.equals("data_little_plugin") == true) goto L8;
        return;
    L8:
        if (this.h == null) goto L37;
        com.bytedance.android.live.broadcastgame.api.model.e r2 = null;
        Pair r4 = (Pair) r3.getData();     // Catch: Exception -> L13
    L14:
        if (r4 == null) goto L16;
        r2 = (com.bytedance.android.live.broadcastgame.api.model.e) r4.getFirst();
    L16:
        if (r2 != null) goto L18;
        return;
    L18:
        if (r4.getSecond() != null) goto L21;
        return;
    L21:
        if (((IGameManagerService.OpenPlatformAppState) r4.getSecond()) == IGameManagerService.OpenPlatformAppState.OpenPlatformAppStateRunning) goto L24;
        r1 = false;
    L24:
        u0 r5 = this.h;
        if (r5 != null) goto L27;
    L28:
        this.j.invoke();
        return;
    L27:
        if (r5.a != r1) goto L28;
        return;
    L13:
        r4 = null;
        goto L14
    L37:
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        e((KVData) r1);
    }

    public LittlePluginLoader(Context r2, e r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "env");
        Intrinsics.checkNotNullParameter(r4, "update");
        super(r3);
        this.i = r2;
        this.j = r4;
    }
}
