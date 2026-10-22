package com.xiphias.browser.scanner;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiphias/browser/scanner/ScannerUiRegistry;", "", "<init>", "()V", "factories", "", "", "Lkotlin/Function0;", "Lcom/xiphias/browser/scanner/BaseScannerUi;", "register", "", "key", "factory", "unregister", "create", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f16348a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Function0<a>> f16349b = null;

    static {
        f16348a = new i();
        f16349b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private i() {
    }

    public final a a(String r2) {
        if (r2 == null) goto L10;
        Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(f16349b.get(r2), Function0.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.invoke(), a.class, "com.obric.memorydata.plugin");
    L8:
        if (r4 == null) goto L10;
        return r4;
    L7:
        r4 = null;
    L10:
        return (a) ZeusTransformUtils.preCheckCast(new b(), a.class, "com.obric.memorydata.plugin");
    }
}
