package org.chromium;

import com.ttnet.org.chromium.net.TTMonitorProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends TTMonitorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f9794a;

    public b() {
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        c.c().b(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
    }

    @Override // com.ttnet.org.chromium.net.TTMonitorProvider
    public final void sendAppMonitorEvent(String r8, String r10) {
        c.c().d(r8, r10);
    }
}
