package com.obric.matrix.platform.sdk.ones;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/MatrixOnesSdk;", "", "()V", "TAG", "", "<set-?>", "Lcom/obric/matrix/platform/sdk/ones/IMatrixBridge;", "bridge", "getBridge$sdk_platform_ones_release", "()Lcom/obric/matrix/platform/sdk/ones/IMatrixBridge;", "Landroid/content/Context;", "context", "getContext$sdk_platform_ones_release", "()Landroid/content/Context;", "isInit", "", "checkInit", "", "checkInit$sdk_platform_ones_release", "enableLog", "enable", CommonConsts.APM_INNER_EVENT_COST_INIT, "ctx", "iBridge", "sendCmd", "cmd", "", Ext.KEY_REQUEST, "Lcom/obric/matrix/proto/Request;", "sendCMDResultCallback", "Lcom/obric/matrix/platform/sdk/ones/SendCMDResultCallback;", "sendCmdSync", "Lcom/obric/matrix/proto/Response;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f8083b;
    private static a c;

    static {
        f8082a = new b();
    }

    private b() {
    }

    public final Context a() {
        return f8083b;
    }

    public final a b() {
        return c;
    }
}
