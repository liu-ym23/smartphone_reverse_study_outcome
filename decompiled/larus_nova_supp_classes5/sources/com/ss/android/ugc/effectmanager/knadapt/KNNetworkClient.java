package com.ss.android.ugc.effectmanager.knadapt;

import bytekn.foundation.logger.Logger;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.HTTPMethod;
import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNNetworkClient;", "Lcom/ss/ugc/effectplatform/bridge/network/INetworkClient;", "effectNetWrapper", "Lcom/ss/android/ugc/effectmanager/common/listener/IEffectNetWorker;", "(Lcom/ss/android/ugc/effectmanager/common/listener/IEffectNetWorker;)V", "fetchFromNetwork", "Lcom/ss/ugc/effectplatform/bridge/network/NetResponse;", "netRequest", "Lcom/ss/ugc/effectplatform/bridge/network/NetRequest;", "logRequestedUrl", "", "effectRequest", "Companion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class KNNetworkClient implements INetworkClient {
    public static final Companion Companion = null;
    private static final String HEADER_KEY_LOG_ID = "x-tt-logid";
    private static final String TAG = "KNNetworker";
    private final IEffectNetWorker effectNetWrapper;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/knadapt/KNNetworkClient$Companion;", "", "()V", "HEADER_KEY_LOG_ID", "", "TAG", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KNNetworkClient(IEffectNetWorker r1) {
        this.effectNetWrapper = r1;
    }

    private final void logRequestedUrl(NetRequest r5) {
        String r6 = new Regex("&?device_info=[^&]*").replace(r5.getUrl(), "");     // Catch: Exception -> L5
        Logger.INSTANCE.d(TAG, "request url: " + r6);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "error in print url", e);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public NetResponse fetchFromNetwork(NetRequest r11) {
        if (r11.getMethod() != HTTPMethod.POST) goto L5;
        String r0 = "POST";
    L6:
        logRequestedUrl(r11);
        EffectRequest r1 = new EffectRequest(r0, r11.getUrl(), r11.getUseCommParam());
        r1.setContentType(r11.getContentType());
        if (r11.getHeaders() == null) goto L10;
        r1.setHeaders(r11.getHeaders());
    L10:
        if (r11.getBodyParams() == null) goto L34;
        r1.setBodyParams(r11.getBodyParams());
    L34:
        InputStream r12 = this.effectNetWrapper.execute(r1);     // Catch: Exception -> L27
        String r2 = r1.getLogId();     // Catch: Exception -> L27
        if (r2 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == true) goto L21;
        HashMap r4 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("x-tt-logid", r1.getLogId())});     // Catch: Exception -> L27
    L22:
        HashMap r9 = r4;
        if (r12 == null) goto L26;
        return new NetResponse(200, new InputStreamByteRead(r12), r1.getContentLength(), r1.getErrorMsg(), "", r9);
    L26:
        return new NetResponse(400, new EmptyByteReadStream(), 0, r1.getErrorMsg(), "", r9);
    L21:
        r4 = new HashMap();     // Catch: Exception -> L27
        goto L22
    L15:
        if (StringsKt.isBlank(r2) == true) goto L18;
        r3 = false;
    L27:
        e = move-exception;
        e.printStackTrace();
        EmptyByteReadStream r5 = new EmptyByteReadStream();
        String r6 = r1.getErrorMsg();
        if (r6 == null) goto L31;
        String r7 = r6;
    L33:
        return new NetResponse(400, r5, 0, r7, "", r1.getResponseHeaders());
    L31:
        r7 = e.getMessage();
        goto L33
    L5:
        r0 = "GET";
        goto L6
    }
}
