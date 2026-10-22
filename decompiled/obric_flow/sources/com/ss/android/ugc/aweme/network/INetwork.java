package com.ss.android.ugc.aweme.network;

import ai.q0;
import androidx.annotation.Keep;
import com.krypton.annotation.OutService;
import jt.a;
import jt.b;
import jt.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@OutService
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0014\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/network/INetwork;", "", "", "waitTTNetInit", "()V", "Ljt/a;", "config", "Ljt/b;", "listener", "init", "(Ljt/a;Ljt/b;)V", "getDependConfig", "()Ljt/a;", "Ljt/c;", "getInitConfig", "()Ljt/c;", "Lai/q0;", "response", "", "errorCode", "monitorNetwork", "(Lai/q0;I)V", "", "useMonitorRefactor", "()Z", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
public interface INetwork {
    a getDependConfig();

    c getInitConfig();

    void init(a r5, b r10);

    void monitorNetwork(q0 r5, int r10);

    boolean useMonitorRefactor();

    void waitTTNetInit();
}
