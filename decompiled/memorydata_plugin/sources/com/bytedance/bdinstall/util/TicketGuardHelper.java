package com.bytedance.bdinstall.util;

import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.storage.ICache;
import com.bytedance.bdinstall.ticket.ITicketGuard;
import com.bytedance.bdinstall.ticket.ITicketParseResultCallback;
import com.bytedance.bdinstall.ticket.TicketInitCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class TicketGuardHelper {
    private ITicketGuard ticketGuard;
    private ITicketParseResultCallback ticketParseResultCallback;
    private volatile String uuid;

    public TicketGuardHelper() {
    }

    static /* synthetic */ ITicketGuard access$000(TicketGuardHelper r0) {
        return r0.ticketGuard;
    }

    public void cacheTicketAndTsSign(TTResponse r6, ICache r7, List<Map<String, String>> r8) {
        ICache r9 = (ICache) ZeusTransformUtils.wrapperContextForParams(r7, ICache.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L24;
        if (r9 != null) goto L6;
        return;
    L6:
        if (this.ticketGuard == null) goto L27;
        Map<String, String> r11 = null;
        if (r10 == null) goto L18;
        int r0 = 0;
    L12:
        if (r0 >= r10.size()) goto L18;
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(r10.get(r0), Map.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        r9.cacheString(Api.KEY_TICKET, (String) ZeusTransformUtils.preCheckCast(r2.get(Api.KEY_TICKET), String.class, "com.obric.memorydata.plugin"));
        r9.cacheString(Api.KEY_TS_SIGN, (String) ZeusTransformUtils.preCheckCast(r2.get(Api.KEY_TS_SIGN), String.class, "com.obric.memorydata.plugin"));
        DrLog.d("TicketGuard# parse ticketData by response " + r2);
        r11 = r2;
    L16:
        r0 = r0 + 1;
    L18:
        if (getTicketParseResultCallback() == null) goto L26;
        DrLog.d("TicketGuard# TicketParseResultCallback , " + r11);
        getTicketParseResultCallback().onResult(r11);
        return;
    L26:
        return;
    L27:
        return;
    }

    public List<Pair<String, String>> consumerTicketDataHeader(String r1, String r2, String r3, boolean r4) {
        ITicketGuard r0 = this.ticketGuard;
        if (r0 == null) goto L7;
        return r0.consumerTicketData(r1, r2, r3, r4);
    L7:
        return new ArrayList();
    }

    public String decryptTicket(byte[] r1) {
        ITicketGuard r0 = this.ticketGuard;
        if (r0 == null) goto L8;
        byte[] r2 = r0.decryptTicket(r1);
        if (r2 != null) goto L7;
        return "";
    L7:
        return new String(r2);
    L8:
        return "";
    }

    public List<Pair<String, String>> getTicketHeader(String r2, boolean r3, boolean r4) {
        if (this.ticketGuard == null) goto L7;
        this.uuid = UUID.randomUUID().toString();
        return this.ticketGuard.providerTicketHeader(r2, r3, r4, this.uuid);
    L7:
        return new ArrayList();
    }

    public ITicketParseResultCallback getTicketParseResultCallback() {
        return this.ticketParseResultCallback;
    }

    public Map<String, Long> getTimestamp() {
        ITicketGuard r0 = this.ticketGuard;
        if (r0 == null) goto L7;
        return r0.getTimestamp();
    L7:
        return new HashMap();
    }

    public List<Map<String, String>> handleProviderResponse(long r9, String r11, String r12, boolean r13, List<Pair<String, String>> r14) {
        List<Pair<String, String>> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        ITicketGuard r0 = this.ticketGuard;
        if (r0 == null) goto L7;
        return r0.handleProviderResponse(r9, r11, r12, r13, r6, this.uuid);
    L7:
        return new ArrayList();
    }

    public void initTicketGuard(InstallOptions r7, TicketInitCallback r8) {
        final TicketInitCallback r9 = (TicketInitCallback) ZeusTransformUtils.wrapperContextForParams(r8, TicketInitCallback.class, "com.obric.memorydata.plugin");
        if (this.ticketGuard != null) goto L5;
        this.ticketGuard = (ITicketGuard) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(Constants.CLASS_TICKET_GUARD_ADAPTER, "com.obric.memorydata.plugin").getConstructor(new Class[]{InstallOptions.class}).newInstance(new Object[]{r7}), ITicketGuard.class, "com.obric.memorydata.plugin");
    L5:
        Future r6 = ExecutorUtil.submitToFirstIOExecutor(new AnonymousClass1(this, r9));
        if (BDInstall.getBDInstallConfig().getTimeoutForTicketGuard() <= 0) goto L8;
        long r10 = BDInstall.getBDInstallConfig().getTimeoutForTicketGuard();
    L9:
        r6.get(r10, TimeUnit.MILLISECONDS);
        return;
    L8:
        r10 = 200;
        goto L9
    }

    public void setTicketParseResultCallback(ITicketParseResultCallback r3) {
        this.ticketParseResultCallback = (ITicketParseResultCallback) ZeusTransformUtils.wrapperContextForParams(r3, ITicketParseResultCallback.class, "com.obric.memorydata.plugin");
    }
}
