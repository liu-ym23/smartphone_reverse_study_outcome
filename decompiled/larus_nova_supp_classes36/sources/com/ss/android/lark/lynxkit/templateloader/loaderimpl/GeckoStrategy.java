package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/templateloader/loaderimpl/GeckoStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "NO_WAIT_FOR_REMOTE", "WAIT_FOR_REMOTE", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum GeckoStrategy extends Enum<GeckoStrategy> {
    public static final GeckoStrategy NO_WAIT_FOR_REMOTE = null;
    public static final GeckoStrategy WAIT_FOR_REMOTE = null;
    public static final /* synthetic */ GeckoStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<GeckoStrategy> getEntries() {
        return b;
    }

    static {
        GeckoStrategy r0 = new GeckoStrategy("NO_WAIT_FOR_REMOTE", 0);
        NO_WAIT_FOR_REMOTE = r0;
        GeckoStrategy r1 = new GeckoStrategy("WAIT_FOR_REMOTE", 1);
        WAIT_FOR_REMOTE = r1;
        GeckoStrategy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static GeckoStrategy[] values() {
        return (GeckoStrategy[]) a.clone();
    }

    public static GeckoStrategy valueOf(String r1) {
        return (GeckoStrategy) r27.a.a(GeckoStrategy.class, r1);
    }

    public GeckoStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
