package a5b;

import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class h {
    public final String a;
    public final CotViewBlockType b;
    public String c;
    public final StringBuilder d;
    public CotBlockStatus e;
    public boolean f;

    public CotViewBlock a() {
        String r1 = this.a;
        CotViewBlockType r2 = this.b;
        String r3 = this.c;
        if (this.d.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r4 = null;
    L10:
        return new CotViewBlock(r1, r2, r3, r4, this.e, this.f, null);
    L8:
        r4 = this.d.toString();
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public final CotViewBlockType getType() {
        return this.b;
    }

    public final void b(CotBlockStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public h(String r2, CotViewBlockType r3) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        this.a = r2;
        this.b = r3;
        this.d = new StringBuilder();
        this.e = CotBlockStatus.PENDING;
    }
}
