package ry9;

import com.larus.platform.model.creation.ResourceExt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class l {
    public final boolean a;
    public final ArrayList<ResourceExt> b;
    public final boolean c;

    public l() {
        this(false, 7);
    }

    public /* synthetic */ l(boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        ArrayList r5 = new ArrayList();
    L9:
        this(r3, r5, false);
        return;
    L8:
        r5 = null;
        goto L9
    }

    public l(boolean r2, ArrayList<ResourceExt> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dataList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
