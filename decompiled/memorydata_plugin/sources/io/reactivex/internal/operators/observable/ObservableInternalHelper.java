package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableInternalHelper {

    static final enum MapToInt extends Enum<MapToInt> implements h<Object, Object> {
        private static final /* synthetic */ MapToInt[] $VALUES = null;
        public static final MapToInt INSTANCE = null;

        static {
            MapToInt r0 = new MapToInt("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new MapToInt[]{r0};
        }

        private MapToInt(String r1, int r2) {
            super(r1, r2);
        }

        public static MapToInt valueOf(String r2) {
            return (MapToInt) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapToInt.class, r2), MapToInt.class, "com.obric.memorydata.plugin");
        }

        public static MapToInt[] values() {
            return (MapToInt[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapToInt[].class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.b.h
        public Object apply(Object r1) {
            return 0;
        }
    }
}
