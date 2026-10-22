package com.bytedance.android.live.room.api.screenrotation.entrance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements IRotateEntrance {
    public static final IRotateEntrance.Type a = null;
    public static final d b = null;

    public d() {
    }

    public final String toString() {
        return "SensorEntrance";
    }

    static {
        b = new d();
        a = IRotateEntrance.Type.Sensor;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance
    public IRotateEntrance.Type getType() {
        return a;
    }
}
