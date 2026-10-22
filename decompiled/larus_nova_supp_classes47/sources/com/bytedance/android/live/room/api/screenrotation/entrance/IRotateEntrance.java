package com.bytedance.android.live.room.api.screenrotation.entrance;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IRotateEntrance {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/entrance/IRotateEntrance$Type;", "", "UI", "Sensor", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Type extends Enum<Type> {
        public static final Type Sensor = null;
        public static final Type UI = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r1 = new Type("UI", 0);
            UI = r1;
            Type r2 = new Type("Sensor", 1);
            Sensor = r2;
            a = new Type[]{r1, r2};
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    Type getType();
}
