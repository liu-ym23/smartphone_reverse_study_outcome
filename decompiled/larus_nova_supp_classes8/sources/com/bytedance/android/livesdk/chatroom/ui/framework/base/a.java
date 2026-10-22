package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hh1.w0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a {
    public boolean a;
    public DataCenter b;
    public RoomContext c;
    public e0 d;
    public boolean e;
    public boolean f;
    public Room g;
    public EnterRoomExtra h;
    public LiveMode i;
    public Runnable j;
    public com.bytedance.android.live.room.h.b k;
    public final List<w0> l;
    public w0 m;
    public boolean n;
    public io1.b o;
    public com.bytedance.android.livesdk.chatroom.ui.framework.utils.e p;
    public final Fragment q;
    public final boolean r;

    public final Bundle a() {
        return this.q.getArguments();
    }

    public final DataCenter b() {
        DataCenter r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r0;
    }

    public final Room c() {
        Room r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L5:
        return r0;
    }

    public final RoomContext d() {
        RoomContext r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomContext");
    L5:
        return r0;
    }

    public final Activity getActivity() {
        return this.q.getActivity();
    }

    public final void e(View r2) {
        Runnable r0 = this.j;
        if (r0 == null) goto L8;
        if (r2 == null) goto L6;
        r2.post(r0);
    L6:
        this.j = null;
        return;
    }

    public a(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.q = r2;
        this.r = r3;
        this.a = true;
        this.i = LiveMode.VIDEO;
        this.l = new ArrayList();
    }
}
