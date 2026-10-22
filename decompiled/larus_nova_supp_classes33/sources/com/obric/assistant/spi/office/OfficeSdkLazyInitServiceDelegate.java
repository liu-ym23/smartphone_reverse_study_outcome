package com.obric.assistant.spi.office;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import sga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/obric/assistant/spi/office/OfficeSdkLazyInitServiceDelegate;", "Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/obric/assistant/spi/office/IOfficeSdkLazyInitService;", "delegate$delegate", "Lkotlin/Lazy;", "tryInitOnUiEntry", "", "tryInitOnFirstFeedShown", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSdkLazyInitServiceDelegate implements IOfficeSdkLazyInitService {
    public static final OfficeSdkLazyInitServiceDelegate a = null;
    public static final Lazy b = null;

    private OfficeSdkLazyInitServiceDelegate() {
    }

    static {
        a = new OfficeSdkLazyInitServiceDelegate();
        b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitService
    public final void a() {
        IOfficeSdkLazyInitService r0 = (IOfficeSdkLazyInitService) b.getValue();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.obric.assistant.spi.office.IOfficeSdkLazyInitService
    public final boolean b() {
        IOfficeSdkLazyInitService r0 = (IOfficeSdkLazyInitService) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }
}
