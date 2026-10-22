package com.ss.android.lark.forwardv3.doubao;

import com.bytedance.lark.pb.search.v2.SearchEntityType;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchOpenSearchInfo;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class DoubaoWorkSearchResultAdapterKt {
    public static final boolean b(SearchBaseInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        if ((r2 instanceof DoubaoWorkSearchInfo) == false) goto L5;
    L12:
        return true;
    L5:
        if ((r2 instanceof SearchOpenSearchInfo) == false) goto L11;
        SearchOpenSearchInfo r3 = (SearchOpenSearchInfo) r2;
        if (r3.getPbType() != SearchEntityType.CHAMELEON) goto L11;
        if (Intrinsics.areEqual(r3.getId(), "22") == true) goto L12;
    L11:
        return false;
    }

    public static final d a(boolean r3, ExternalForwardSendMode r4, final tib.g r5) {
        Intrinsics.checkNotNullParameter(r5, "dependency");
        boolean r0 = false;
        if (r3 == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L12:
        final boolean r7 = false;
    L13:
        String r8 = r5.getExternalTargetId();
        Function0<Boolean> r2 = new DoubaoWorkSearchResultAdapterKt$createDoubaoWorkSearchConfig$isEnabled$1(r7);
        Function0<tib.a> r9 = new DoubaoWorkSearchResultAdapterKt$createDoubaoWorkSearchConfig$targetProvider$1(r5);
        if (((Boolean) r2.invoke()).booleanValue() == false) goto L26;
        if (r8 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        if (r10 == true) goto L26;
        if (r9.invoke() == null) goto L26;
        r0 = true;
        goto L26
    L17:
        if (StringsKt.isBlank(r8) == true) goto L20;
        r10 = false;
    L26:
        return new d(r0, new e(r2, r8, r9));
    L10:
        if (r5.isDoubaoWorkTabEnabled() == false) goto L12;
        r7 = true;
        goto L13
    L5:
        if (r4 == ExternalForwardSendMode.DOUBAO_ENTRY) goto L7;
        r6 = true;
        goto L8
    }
}
