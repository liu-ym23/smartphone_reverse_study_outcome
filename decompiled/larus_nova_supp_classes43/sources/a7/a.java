package a7;

import com.bytedance.android.annie.api.card.IHybridComponent;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(IHybridComponent r10, String r11, Map r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = null;
    L8:
        r10.load(r11, r12);
    }
}
