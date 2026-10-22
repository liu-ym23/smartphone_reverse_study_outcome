package com.obric.lifelog.data.bridge;

import android.content.Context;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.lifelog.data.c;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.ILifeLogBridgeAPI;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.notification.UniversalNotificationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/lifelog/data/bridge/LifeLogBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/ILifeLogBridgeAPI;", "<init>", "()V", "TAG", "", "getInst", "showNotification", "", "title", Params.CONTENT, "timestamp", "", "onLifeLogResult", "data", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifeLogBridgeImpl implements ILifeLogBridgeAPI {
    public static final LifeLogBridgeImpl INSTANCE = null;
    private static final String TAG = "LifeLogBridgeImpl";

    static {
        INSTANCE = new LifeLogBridgeImpl();
    }

    private LifeLogBridgeImpl() {
    }

    @JvmStatic
    public static final LifeLogBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ILifeLogBridgeAPI
    public void onLifeLogResult(String r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        RunLog.INSTANCE.debug(TAG, "onLifeLogResult data = " + r3);
        new c(r3).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ILifeLogBridgeAPI
    public void showNotification(String r8, String r9, long r10) {
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        UniversalNotificationUtils r1 = UniversalNotificationUtils.f13251a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        String r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        r1.a(r2, r8, r9, MapsKt.mapOf(TuplesKt.to("life_log", String.valueOf(r10))), ZeusTransformUtils.mapRes(R.drawable.ic_lifelog_app, "drawable", "ic_lifelog_app"));
    }
}
