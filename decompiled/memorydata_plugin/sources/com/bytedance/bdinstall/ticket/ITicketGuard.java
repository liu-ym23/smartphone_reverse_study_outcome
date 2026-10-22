package com.bytedance.bdinstall.ticket;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ITicketGuard {
    List<Pair<String, String>> consumerTicketData(String r1, String r2, String r3, boolean r4);

    byte[] decryptTicket(byte[] r1);

    Map<String, Long> getTimestamp();

    List<Map<String, String>> handleProviderResponse(long r1, String r3, String r4, boolean r5, List<Pair<String, String>> r6, String r7);

    void init(TicketInitCallback r1);

    List<Pair<String, String>> providerTicketHeader(String r1, boolean r2, boolean r3, String r4);
}
