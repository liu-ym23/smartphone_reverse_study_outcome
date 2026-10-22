package com.obric.assistant.interaction.impl.keyguard;

import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.ISendMsgExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lha.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/keyguard/SendMsgExtServiceImpl;", "Lcom/obric/assistant/interaction/api/keyguard/ISendMsgExtService;", "Lcom/obric/assistant/chat/callback/ISendMessageExtCallback;", "<init>", "()V", "init", "", "getScene", "", "getExt", "", "originExt", "queryData", "Lcom/obric/assistant/chat/callback/ISendMessageExtCallback$QueryData;", "getKeyguardMsgExt", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMsgExtServiceImpl implements ISendMsgExtService, bda.b {
    public static final Companion Companion = null;
    private static final String KEYGUARD_LOCK_TIME = "keyguard_lock_time";
    private static final String TAG = "SendMsgExtServiceImpl";

    static {
        Companion = new Companion(null);
    }

    public SendMsgExtServiceImpl() {
    }

    private final Map<String, String> getKeyguardMsgExt() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        Map<String, String> r0 = MapsKt.mapOf(TuplesKt.to(KEYGUARD_LOCK_TIME, String.valueOf(f.a().b())));
    L9:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("getKeyguardMsgExt, ");
        if (r0 != null) goto L12;
        Object r3 = "{}";
    L13:
        r2.append(r3);
        r1.i(TAG, r2.toString());
        return r0;
    L12:
        r3 = r0;
        goto L13
    L5:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L7;
        r0 = MapsKt.mapOf(TuplesKt.to(KEYGUARD_LOCK_TIME, String.valueOf(f.a().b())));
        goto L9
    L7:
        r0 = null;
        goto L9
    }

    public String getScene() {
        return "o_msg_ext_hashCode_" + hashCode();
    }

    public void init() {
        FLogger.a.i(TAG, "init");
        IObricChatService r0 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r0 == null) goto L6;
        r0.g();
        MessageApiImpl.a.g(this);
        return;
    }

    public Map<String, String> getExt(Map<String, String> r1, bda.b.a r2) {
        Intrinsics.checkNotNullParameter(r1, "originExt");
        return getKeyguardMsgExt();
    }
}
