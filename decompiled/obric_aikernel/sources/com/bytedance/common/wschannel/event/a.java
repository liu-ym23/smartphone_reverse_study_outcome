package com.bytedance.common.wschannel.event;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChannelType f1303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectionState f1304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1306d;

    public a(@NonNull ConnectionState r10, ChannelType r11, int r12, int r13) {
        this.f1304b = r10;
        this.f1303a = r11;
        this.f1306d = r12;
        this.f1305c = r13;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.f1303a + ", connectionState=" + this.f1304b + ", mChannelId=" + this.f1306d + ", errorCode=" + this.f1305c + '}';
    }
}
