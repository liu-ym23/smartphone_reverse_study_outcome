package com.ss.android.lark.image.compose.common;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/image/compose/common/CachePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "Enabled", "Disabled", "ReadOnly", "WriteOnly", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum CachePolicy extends Enum<CachePolicy> {
    public static final CachePolicy Disabled = null;
    public static final CachePolicy Enabled = null;
    public static final CachePolicy ReadOnly = null;
    public static final CachePolicy WriteOnly = null;
    public static final /* synthetic */ CachePolicy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CachePolicy> getEntries() {
        return b;
    }

    static {
        CachePolicy r0 = new CachePolicy("Enabled", 0);
        Enabled = r0;
        CachePolicy r1 = new CachePolicy("Disabled", 1);
        Disabled = r1;
        CachePolicy r3 = new CachePolicy("ReadOnly", 2);
        ReadOnly = r3;
        CachePolicy r5 = new CachePolicy("WriteOnly", 3);
        WriteOnly = r5;
        CachePolicy[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static CachePolicy[] values() {
        return (CachePolicy[]) a.clone();
    }

    public static CachePolicy valueOf(String r1) {
        return (CachePolicy) a.a(CachePolicy.class, r1);
    }

    public CachePolicy(String r1, int r2) {
        super(r1, r2);
    }
}
