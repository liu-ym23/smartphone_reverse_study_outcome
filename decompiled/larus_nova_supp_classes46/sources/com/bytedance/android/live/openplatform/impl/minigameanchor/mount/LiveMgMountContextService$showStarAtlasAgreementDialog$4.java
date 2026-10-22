package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"protocols2Str", "", "protocols", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$4 extends Lambda implements Function1<List<? extends Integer>, String> {
    public static final LiveMgMountContextService$showStarAtlasAgreementDialog$4 INSTANCE = null;

    static {
        INSTANCE = new LiveMgMountContextService$showStarAtlasAgreementDialog$4();
    }

    public LiveMgMountContextService$showStarAtlasAgreementDialog$4() {
        super(1);
    }

    public final String invoke(List<Integer> r4) {
        StringBuilder r0 = new StringBuilder();
        if (r4 == null) goto L15;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L15;
        int r1 = ((Number) r5.next()).intValue();
        if (r0.toString().length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L12;
        r0.append(",");
        r0.append(String.valueOf(r1));
        goto L6
    L12:
        r0.append(String.valueOf(r1));
        goto L6
    L10:
        r2 = false;
    L15:
        return r0.toString();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((List) r1);
    }
}
