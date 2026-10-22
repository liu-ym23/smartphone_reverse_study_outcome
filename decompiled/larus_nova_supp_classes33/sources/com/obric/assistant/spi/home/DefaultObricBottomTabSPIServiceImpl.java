package com.obric.assistant.spi.home;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/spi/home/DefaultObricBottomTabSPIServiceImpl;", "Lcom/obric/assistant/spi/home/IObricBottomTabSPIService;", "<init>", "()V", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricBottomTabSPIServiceImpl implements IObricBottomTabSPIService {
    public DefaultObricBottomTabSPIServiceImpl() {
    }

    @Override // com.obric.assistant.spi.home.IObricBottomTabSPIService
    public final List<String> a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "originKeys");
        return r2;
    }

    @Override // com.obric.assistant.spi.home.IObricBottomTabSPIService
    public final List<String> b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "originKeys");
        return r2;
    }
}
