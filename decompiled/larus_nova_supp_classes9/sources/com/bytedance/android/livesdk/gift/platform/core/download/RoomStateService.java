package com.bytedance.android.livesdk.gift.platform.core.download;

import android.content.Context;
import ca0.v;
import com.bytedance.android.live.gift.IRoomStateService;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v12.e;
import v12.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/download/RoomStateService;", "Lcom/bytedance/android/live/gift/IRoomStateService;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "onEnterRoom", "onExitRoom", "Lca0/v;", "listener", "registRoomStateListner", "unregistRoomStateListner", BuildConfig.FLAVOR, "roomId", "I", "getRoomId", "()I", "setRoomId", "(I)V", BuildConfig.FLAVOR, "mListeners", "Ljava/util/List;", "getMListeners", "()Ljava/util/List;", "setMListeners", "(Ljava/util/List;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomStateService implements IRoomStateService {
    private List<v> mListeners;
    private int roomId;

    public void onExitRoom() {
        this.roomId = -1;
        Iterator<v> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().onExitRoom();
        goto L4
    L10:
        d0.h();     // Catch: Exception -> L9
    L7:
        f.c.clear();
        e.a.clear();
    }

    public RoomStateService() {
        this.roomId = -1;
        this.mListeners = new ArrayList();
    }

    public final List<v> getMListeners() {
        return this.mListeners;
    }

    public final int getRoomId() {
        return this.roomId;
    }

    public void onEnterRoom(Context r2) {
        this.roomId = this.roomId;
        Iterator<v> r3 = this.mListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().onEnterRoom();
        goto L4
    }

    public void registRoomStateListner(v r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.mListeners.contains(r2) == true) goto L6;
        this.mListeners.add(r2);
        return;
    }

    public final void setMListeners(List<v> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mListeners = r2;
    }

    public final void setRoomId(int r1) {
        this.roomId = r1;
    }

    public void unregistRoomStateListner(v r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Iterator<v> r0 = this.mListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r3, r0.next()) == false) goto L4;
        r0.remove();
        goto L4
    }
}
