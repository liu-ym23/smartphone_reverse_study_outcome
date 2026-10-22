package com.ss.android.lark.forwardv3.doubao;

import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProviderStore;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements SearchResultAdapter {
    public final Function0<Boolean> a;
    public final String b;
    public final Function0<tib.a> c;

    public final List<SearchBaseInfo> adapt(List<? extends SearchBaseInfo> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "items");
        List<? extends SearchBaseInfo> r9 = r7;
        boolean r1 = false;
        if ((r9 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r0 = r9.iterator();
    L9:
        if (r0.hasNext() == false) goto L6;
        if (DoubaoWorkSearchResultAdapterKt.b((SearchBaseInfo) r0.next()) == false) goto L9;
        boolean r2 = false;
    L13:
        if (r2 == false) goto L16;
        return r7;
    L16:
        if (((Boolean) this.a.invoke()).booleanValue() == false) goto L26;
        String r10 = this.b;
        if (r10 != null) goto L20;
    L23:
        boolean r11 = true;
    L24:
        if (r11 == true) goto L26;
        tib.a r12 = (tib.a) this.c.invoke();
    L27:
        ArrayList r3 = new ArrayList();
        Iterator<T> r13 = r9.iterator();
    L29:
        if (r13.hasNext() == false) goto L48;
        DoubaoWorkSearchInfo r4 = (SearchBaseInfo) r13.next();
        if (DoubaoWorkSearchResultAdapterKt.b(r4) == false) goto L46;
        if (r12 == null) goto L45;
        if (r1 == true) goto L45;
        ExternalTargetAvatarProviderStore.INSTANCE.register(r12.a);
        if ((r4 instanceof DoubaoWorkSearchInfo) == false) goto L39;
        r4 = r4;
    L42:
        r1 = true;
        goto L46
    L39:
        String r5 = this.b;
        if (r5 == null) goto L44;
        r4 = new DoubaoWorkSearchInfo(r4, r5);
        goto L42
    L44:
        throw new IllegalArgumentException("Required value was null.".toString());
    L45:
        r4 = null;
    L46:
        if (r4 == null) goto L29;
        r3.add(r4);
        goto L29
    L48:
        return r3;
    L20:
        if (StringsKt.isBlank(r10) == true) goto L23;
        r11 = false;
    L26:
        r12 = null;
    L6:
        r2 = true;
        goto L13
    L5:
        if (r9.isEmpty() == false) goto L7;
        goto L6
    }

    public e(Function0<Boolean> r2, String r3, Function0<tib.a> r4) {
        Intrinsics.checkNotNullParameter(r2, "isEnabled");
        Intrinsics.checkNotNullParameter(r4, "targetProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
