package fb2;

import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Comparator {
    public final /* synthetic */ LinkedHashMap a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ long c;
    public final /* synthetic */ db2.b d;

    public d(LinkedHashMap r1, HashMap r2, long r3, db2.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r9, Object r10) {
        BaseEmoji r11 = (BaseEmoji) r9;
        BaseEmoji r13 = (BaseEmoji) r10;
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r0 = (com.bytedance.android.livesdk.interactivity.service.emoji.recent.b) this.a.get(r11.getDescription());
        if (r0 != null) goto L5;
        r0 = new com.bytedance.android.livesdk.interactivity.service.emoji.recent.b(r11.getDescription(), 0, new ArrayList());
    L5:
        b r3 = (b) this.b.get(r11.getDescription());
        int r4 = 1;
        if (r3 == null) goto L8;
        int r5 = r3.b;
    L9:
        float r1 = r0.a(this.c, r5, this.d);
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r6 = (com.bytedance.android.livesdk.interactivity.service.emoji.recent.b) this.a.get(r13.getDescription());
        if (r6 != null) goto L12;
        r6 = new com.bytedance.android.livesdk.interactivity.service.emoji.recent.b(r13.getDescription(), 0, new ArrayList());
    L12:
        b r2 = (b) this.b.get(r13.getDescription());
        if (r2 == null) goto L15;
        r4 = r2.b;
    L15:
        float r7 = r6.a(this.c, r4, this.d);
        r11.recommendScore = r1;
        r13.recommendScore = r7;
        return -Float.compare(r1, r7);
    L8:
        r5 = 1;
        goto L9
    }
}
