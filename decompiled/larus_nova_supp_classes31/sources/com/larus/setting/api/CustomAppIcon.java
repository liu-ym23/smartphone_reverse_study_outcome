package com.larus.setting.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/larus/setting/api/CustomAppIcon;", "Lcom/larus/setting/api/ICustomAppIcon;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/setting/api/ICustomAppIcon;", "impl$delegate", "Lkotlin/Lazy;", "handleCustomAppIconChange", "", "currentSelectAppIconId", "", "cvsId", "", "(Ljava/lang/Integer;Ljava/lang/String;)Z", "prepareCustomAppIconChange", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CustomAppIcon implements ICustomAppIcon {
    public static final CustomAppIcon a = null;
    public static final Lazy b = null;

    private CustomAppIcon() {
    }

    static {
        a = new CustomAppIcon();
        b = LazyKt.lazy(new c());
    }

    @Override // com.larus.setting.api.ICustomAppIcon
    public final boolean b() {
        ICustomAppIcon r0 = (ICustomAppIcon) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b();
    }

    @Override // com.larus.setting.api.ICustomAppIcon
    public final boolean a(Integer r2, String r3) {
        ICustomAppIcon r0 = (ICustomAppIcon) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r2, r3);
    }
}
