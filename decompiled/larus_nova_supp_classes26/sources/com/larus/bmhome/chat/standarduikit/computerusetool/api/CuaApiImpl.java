package com.larus.bmhome.chat.standarduikit.computerusetool.api;

import com.larus.im.b;
import gd9.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/computerusetool/api/CuaApiImpl;", "Lcom/larus/bmhome/chat/standarduikit/computerusetool/api/ICuaApi;", "<init>", "()V", "getPureTextString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CuaApiImpl implements ICuaApi {
    public CuaApiImpl() {
    }

    @Override // com.larus.bmhome.chat.standarduikit.computerusetool.api.ICuaApi
    public final String a() {
        i r0 = b.a;     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L4
        return r0.getApplication().getString(2131909719);
    L4:
        return null;
    }
}
