package com.bytedance.android.live.openplatform.impl.miniappcommon.monitor;

import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MiniAppMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/monitor/MiniAppMonitor$ExceptionType;", "", "Mount", "Unmount", "Room", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ExceptionType extends Enum<ExceptionType> {
        public static final ExceptionType Mount = null;
        public static final ExceptionType Room = null;
        public static final ExceptionType Unmount = null;
        public static final /* synthetic */ ExceptionType[] a = null;

        static {
            ExceptionType r1 = new ExceptionType("Mount", 0);
            Mount = r1;
            ExceptionType r2 = new ExceptionType("Unmount", 1);
            Unmount = r2;
            ExceptionType r3 = new ExceptionType("Room", 2);
            Room = r3;
            a = new ExceptionType[]{r1, r2, r3};
        }

        public static ExceptionType valueOf(String r1) {
            return (ExceptionType) a.a(ExceptionType.class, r1);
        }

        public static ExceptionType[] values() {
            return (ExceptionType[]) a.clone();
        }

        public ExceptionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public static void a(ExceptionType r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "exceptionType");
        Intrinsics.checkNotNullParameter(r4, "exceptionMsg");
        g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("exception_type", r3.name());
        r1.put("exception_msg", r4);
        Unit r5 = Unit.INSTANCE;
        r0.sendLog("livesdk_miniapp_exception_monitor", r1, new Object[]{Room.class});
    }
}
