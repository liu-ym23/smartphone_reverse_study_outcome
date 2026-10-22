package com.bytedance.android.live.room.api.screenrotation.entrance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements IRotateEntrance {
    public static final IRotateEntrance.Type a = null;
    public static final c b = null;

    public c() {
    }

    public final String toString() {
        return "LandscapeEntrance";
    }

    static {
        b = new c();
        a = IRotateEntrance.Type.UI;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance
    public IRotateEntrance.Type getType() {
        return a;
    }
}
