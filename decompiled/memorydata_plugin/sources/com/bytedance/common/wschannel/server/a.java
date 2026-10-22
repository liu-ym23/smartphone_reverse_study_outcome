package com.bytedance.common.wschannel.server;

import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<Integer, IWsApp> f2153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<Integer, IWsChannelClient> f2154b;
    Map<Integer, SocketState> c;

    a() {
        this.f2153a = new ConcurrentHashMap();
        this.f2154b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }
}
