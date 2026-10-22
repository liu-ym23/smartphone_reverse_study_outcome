package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<Integer, IWsApp> f1375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Integer, IWsChannelClient> f1376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<Integer, SocketState> f1377c;

    a() {
        this.f1375a = new ConcurrentHashMap();
        this.f1376b = new ConcurrentHashMap();
        this.f1377c = new ConcurrentHashMap();
    }
}
