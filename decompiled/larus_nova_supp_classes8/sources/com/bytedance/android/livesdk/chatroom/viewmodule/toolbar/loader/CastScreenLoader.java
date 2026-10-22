package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastManager;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.bytecast.k;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.KVData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/CastScreenLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastScreenLoader extends AbsDynamicLoader {
    public final String h;
    public final k i;
    public final Function0<Unit> j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        if (this.c == false) goto L6;
    L7:
        ExtendedToolbarButton.b r1 = null;
    L35:
        if (r1 == null) goto L37;
        r0.add(r1);
    L37:
        return r0;
    L6:
        if (LiveByteCastManager.a() == false) goto L7;
        ExtendedToolbarButton.a r2 = ExtendedToolbarButton.h;
        ToolbarButton r3 = ToolbarButton.CAST_SCREEN;
        r2.getClass();
        r1 = ExtendedToolbarButton.a.a(r3);
        if (this.c == true) goto L35;
        Integer r4 = (Integer) this.a.get(this.h, 0);
        if (r4 != null) goto L14;
    L20:
        if (r4 != null) goto L23;
    L25:
        if (r4 != null) goto L28;
    L30:
        if (r4 == null) goto L35;
        if (r4.intValue() != 3) goto L35;
        r1.i.setDrawableFolded(2131250183);
        r1.i.setTitleId(2131915599);
        goto L35
    L28:
        if (r4.intValue() != 2) goto L30;
        r1.i.setDrawableFolded(2131250185);
        r1.i.setTitleId(2131915600);
        goto L35
    L23:
        if (r4.intValue() != 1) goto L25;
        r1.i.setDrawableFolded(2131250184);
        r1.i.setTitleId(2131915601);
        goto L35
    L14:
        if (r4.intValue() != 0) goto L20;
        if (this.d == false) goto L18;
        r1.i.setDrawableFolded(2131250187);
    L19:
        r1.i.setTitleId(2131923373);
        goto L35
    L18:
        r1.i.setDrawableFolded(2131250188);
        goto L19
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.a.observe(this.h, this);
        boolean r0 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.a).isPaidLive();
        if (z.o(this.a).getMRoomAuthStatus() != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r2 = VrUtils.c(this.a);
        if (r1 == true) goto L12;
        if (r0 == true) goto L12;
        return;
    L12:
        if (y3.f(this.a).n(ToolbarButton.CAST_SCREEN) == true) goto L27;
        if (r2 == true) goto L28;
        int r3 = com.bytedance.android.livesdk.castscreen.api.b.a;
        Room r4 = z.o(this.a);
        RoomContext.a.c(RoomContext.Companion, this.f.a, 0, 2);
        Intrinsics.checkNotNullParameter(r4, "room");
        String r5 = LiveByteCastUIManager.a;
        c0.b r6 = null;
        if (LiveByteCastUIManager.r() == false) goto L20;
        if (LiveByteCastManager.a() == false) goto L20;
        r6 = new k(null);
    L20:
        if ((r6 instanceof c0.b) == false) goto L23;
        y3.f(this.a).k(ToolbarButton.CAST_SCREEN, r6);
    L23:
        if (this.i == null) goto L29;
        y3.i(this.a).k(ToolbarButton.CAST_SCREEN, this.i);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L5:
        if (z.o(this.a).getMRoomAuthStatus().getCastScreen() != 1) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        return LiveByteCastManager.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final void e(KVData r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r2.getKey(), this.h) == false) goto L8;
        this.j.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        e((KVData) r1);
    }

    public CastScreenLoader(e r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r6, "update");
        super(r5);
        this.j = r6;
        this.h = "live_cast_screen_connect_status_bg_change";
        int r7 = com.bytedance.android.livesdk.castscreen.api.b.a;
        Room r8 = z.o(this.a);
        RoomContext.a.c(RoomContext.Companion, this.f.a, 0, 2);
        Intrinsics.checkNotNullParameter(r8, "room");
        String r9 = LiveByteCastUIManager.a;
        k r10 = null;
        if (LiveByteCastUIManager.r() == true) goto L5;
    L7:
        k r11 = null;
    L9:
        if ((r11 instanceof c0.b) == false) goto L12;
        r10 = r11;
    L12:
        this.i = r10;
        return;
    L5:
        if (LiveByteCastManager.a() == false) goto L7;
        r11 = new k(null);
        goto L9
    }
}
