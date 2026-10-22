package com.ss.android.lark.passport.auth;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class IPassportAuthHeaderServiceKt$cookies$raw$2 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
    public static final IPassportAuthHeaderServiceKt$cookies$raw$2 INSTANCE = null;

    static {
        INSTANCE = new IPassportAuthHeaderServiceKt$cookies$raw$2();
    }

    public IPassportAuthHeaderServiceKt$cookies$raw$2() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.getValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map.Entry) r1);
    }
}
