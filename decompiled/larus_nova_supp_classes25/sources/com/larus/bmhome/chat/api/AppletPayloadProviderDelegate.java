package com.larus.bmhome.chat.api;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/api/AppletPayloadProviderDelegate;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "impl", "", "kotlin.jvm.PlatformType", "", "getAppletPayload", "", "", "conversationId", "botId", "msgId", "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AppletPayloadProviderDelegate implements IAppletPayloadProviderService {
    public static final AppletPayloadProviderDelegate a = null;
    public static final Set<IAppletPayloadProviderService> b = null;

    private AppletPayloadProviderDelegate() {
    }

    static {
        a = new AppletPayloadProviderDelegate();
        b = ServiceManager.get().getServices(IAppletPayloadProviderService.class, true);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void a(t0 r3) {
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IAppletPayloadProviderService) r0.next()).a(r3);
        goto L4
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void c(CommonAppletPlugin.initAppletPayloadChangeListener.1 r3) {
        Iterator<T> r0 = b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((IAppletPayloadProviderService) r0.next()).c(r3);
        goto L4
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final Map<String, String> b(String r4, String r5, String r6) {
        Set<IAppletPayloadProviderService> r0 = b;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map<String, String> r3 = ((IAppletPayloadProviderService) r2.next()).b(r4, r5, r6);
        if (r3 != null) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        r1.putAll(r3);
        goto L4
    L9:
        return r1;
    }
}
