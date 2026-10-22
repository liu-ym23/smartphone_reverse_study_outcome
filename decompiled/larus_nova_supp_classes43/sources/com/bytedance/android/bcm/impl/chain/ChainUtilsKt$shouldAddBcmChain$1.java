package com.bytedance.android.bcm.impl.chain;

import com.byted.cast.sink.api.IAPI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"prefixMatch", "", "prefixList", "", "", "btm", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class ChainUtilsKt$shouldAddBcmChain$1 extends Lambda implements Function2<List<? extends String>, String, Boolean> {
    public static final ChainUtilsKt$shouldAddBcmChain$1 INSTANCE = null;

    static {
        INSTANCE = new ChainUtilsKt$shouldAddBcmChain$1();
    }

    public ChainUtilsKt$shouldAddBcmChain$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return Boolean.valueOf(invoke((List) r1, (String) r10));
    }

    public final boolean invoke(List<String> r10, String r11) {
        if (r11 == null) goto L19;
        List<String> r12 = r10;
        if ((r12 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L21;
        if (StringsKt.startsWith$default(r11, ((String) r13.next()) + '.', false, 2, null) == false) goto L11;
        return true;
    L21:
        return false;
    L7:
        if (r12.isEmpty() == false) goto L9;
        return false;
    L19:
        return false;
    }
}
