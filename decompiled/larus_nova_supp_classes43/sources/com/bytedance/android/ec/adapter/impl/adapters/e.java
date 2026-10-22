package com.bytedance.android.ec.adapter.impl.adapters;

import android.content.Context;
import com.bytedance.android.ec.adapter.impl.converter.n;
import com.bytedance.android.ec.adapter.impl.utils.RoomStateExtensionsKt;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.bytedance.android.livesdkapi.room.state.UserState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements IStartLivePreviewController {
    public final rd.c a;

    public final void onCreate() {
        IStartLivePreviewController.DefaultImpls.onCreate(this);
        this.a.onCreate();
    }

    public final void onDestroy() {
        IStartLivePreviewController.DefaultImpls.onDestroy(this);
        this.a.onDestroy();
    }

    public final void onDestroyView() {
        IStartLivePreviewController.DefaultImpls.onDestroyView(this);
        this.a.onDestroyView();
    }

    public final void onStart() {
        IStartLivePreviewController.DefaultImpls.onStart(this);
        this.a.onStart();
    }

    public final void onStop() {
        IStartLivePreviewController.DefaultImpls.onStop(this);
        this.a.onStop();
    }

    public final void onViewCreated() {
        IStartLivePreviewController.DefaultImpls.onViewCreated(this);
        this.a.onViewCreated();
    }

    public e(rd.c r10) {
        Intrinsics.checkNotNullParameter(r10, "realController");
        this.a = r10;
    }

    public final void onContextAttached(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this.a.onContextAttached(r10);
    }

    public final void onUserInfoChanged(IUserState r10) {
        Intrinsics.checkNotNullParameter(r10, "userState");
        this.a.a(RoomStateExtensionsKt.b((UserState) r10));
    }

    public final void onViewHandlerAttached(ILiveRoomViewHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "handler");
        rd.c r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2EC");
        r0.b(n.b.a(r10));
    }
}
