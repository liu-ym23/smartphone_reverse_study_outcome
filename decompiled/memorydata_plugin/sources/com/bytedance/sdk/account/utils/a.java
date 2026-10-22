package com.bytedance.sdk.account.utils;

import com.bytedance.sdk.account.network.dispatcher.IRequest;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.bytedance.sdk.account.network.dispatcher.c {
    public a() {
        this(null, IRequest.Priority.NORMAL);
    }

    public a(String r1, IRequest.Priority r2) {
        super(r1, r2);
    }
}
