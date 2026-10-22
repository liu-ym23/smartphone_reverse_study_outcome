package com.obric.assistant;

import com.larus.setting.api.ICustomAppIcon;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/ObricCustomAppIconImpl;", "Lcom/larus/setting/api/ICustomAppIcon;", "<init>", "()V", "handleCustomAppIconChange", NameKeys.UnloadStrategy_No_Strategy, "currentSelectAppIconId", NameKeys.UnloadStrategy_No_Strategy, "cvsId", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/Integer;Ljava/lang/String;)Z", "prepareCustomAppIconChange", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCustomAppIconImpl implements ICustomAppIcon {
    public ObricCustomAppIconImpl() {
    }

    public final boolean b() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L6;
        return false;
    L6:
        t1.a.l1();
        return true;
    }

    public final boolean a(Integer r2, String r3) {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L6;
        return false;
    L6:
        t1.a.C1(r2, r3);
        return true;
    }
}
