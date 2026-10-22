package com.obric.assistant.spi.update;

import com.larus.home.impl.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00052\u001a\u0010\t\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\nH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/update/DefaultObricUpdateSPIServiceImpl;", "Lcom/obric/assistant/spi/update/IObricUpdateSPIService;", "<init>", "()V", "checkUpdate", "", "auto", "", "setRequestTagHeaderProvider", "provider", "Lkotlin/Function0;", "Landroid/util/Pair;", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricUpdateSPIServiceImpl implements IObricUpdateSPIService {
    public DefaultObricUpdateSPIServiceImpl() {
    }

    @Override // com.obric.assistant.spi.update.IObricUpdateSPIService
    public final void a() {
    }

    @Override // com.obric.assistant.spi.update.IObricUpdateSPIService
    public final void b(t r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
    }
}
