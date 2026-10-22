package com.larus.uaigc.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/service/ICreationAppletDetailProviderNoop;", "Lcom/larus/uaigc/service/ICreationAppletDetailProvider;", "<init>", "()V", "createDetailFragment", "Landroidx/fragment/app/Fragment;", "bundle", "Landroid/os/Bundle;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationAppletDetailProviderNoop implements ICreationAppletDetailProvider {
    public ICreationAppletDetailProviderNoop() {
    }

    @Override // com.larus.uaigc.service.ICreationAppletDetailProvider
    public final Fragment a(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return null;
    }
}
