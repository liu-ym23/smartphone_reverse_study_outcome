package com.larus.bootprotector.impl;

import com.larus.bootprotector.IBootProtectorDebugService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/larus/bootprotector/impl/BootProtectorDebugServiceImpl;", "Lcom/larus/bootprotector/IBootProtectorDebugService;", "<init>", "()V", "isBootProtectorEnabled", "", "context", "Landroid/content/Context;", "isBootProtectorInTestChannelEnabled", "markBootProtectorInTestChannelEnabled", "", "enable", "getCurrentCrashCount", "", "getLastExceptionInfo", "Lcom/larus/bootprotector/LastExceptionInfo;", "hasEnterBootProtectorPageLastTime", "isClickOptFixSuccess", "isClickDownloadFixSuccess", "isRequestHotFixSuccess", "startBootProtectorLandingPage", "triggerRestartApp", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorDebugServiceImpl implements IBootProtectorDebugService {
    public BootProtectorDebugServiceImpl() {
    }
}
