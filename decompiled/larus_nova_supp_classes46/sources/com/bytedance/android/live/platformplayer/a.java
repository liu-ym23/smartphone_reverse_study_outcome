package com.bytedance.android.live.platformplayer;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements as0.a {
    public a() {
    }

    @Override // as0.a
    public final RoomBaseSession d() {
        return null;
    }

    @Override // as0.a
    public final boolean e(Context r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return false;
    }

    @Override // as0.a
    public final void f(boolean r1, EndReason r2) {
    }

    @Override // as0.a
    public final LivePlayerView getLivePlayerView() {
        return null;
    }

    @Override // as0.a
    public final void h() {
    }

    @Override // as0.a
    public final void i(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
    }

    @Override // as0.a
    public final void j(as0.a.c r1) {
    }

    @Override // as0.a
    public final boolean k() {
        return false;
    }

    @Override // as0.a
    public final void l(Context r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // as0.a
    public final void log(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    @Override // as0.a
    public final boolean m() {
        return false;
    }

    @Override // as0.a
    public final IBaseStreamUrl n() {
        return null;
    }

    @Override // as0.a
    public final void o(as0.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    @Override // as0.a
    public final boolean p(EndReason.USER_CLOSE r1) {
        return false;
    }

    @Override // as0.a
    public final ILivePlayerClient player() {
        return null;
    }

    @Override // as0.a
    public final boolean q(Context r1) {
        return false;
    }

    @Override // as0.a
    public final boolean r(Bundle r1) {
        return false;
    }

    @Override // as0.a
    public final void t(Context r1) {
    }

    @Override // as0.a
    public final boolean u(String r2, RoomSession r3) {
        Intrinsics.checkNotNullParameter(r2, "resolution");
        Intrinsics.checkNotNullParameter(r3, "session");
        return false;
    }

    @Override // as0.a
    public final void v(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
    }

    @Override // as0.a
    public final LivePlayerConfig w() {
        return null;
    }

    @Override // as0.a
    public final boolean x(LiveMode r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "streamType");
        return false;
    }

    @Override // as0.a
    public final Context y() {
        return null;
    }

    @Override // as0.a
    public final long roomId() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // as0.a
    public final ILivePlayerClient g(boolean r2) {
        throw new RuntimeException("use platform player must init live sdk!");
    }

    @Override // as0.a
    public final LivePlayerView s(Context r1, long r2, boolean r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new LivePlayerView(r1, null, 2, null);
    }
}
