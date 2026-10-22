package com.ss.android.lark.passport.flow.core.network.handler;

import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import uzb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final class ToastCodeHandler$handleMsg$2 extends Lambda implements Function0<Unit> {
    public static final ToastCodeHandler$handleMsg$2 INSTANCE = null;

    static {
        INSTANCE = new ToastCodeHandler$handleMsg$2();
    }

    public ToastCodeHandler$handleMsg$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m612invoke() {
        UDToast.show(LarkContext.getApplication(), l.getResources(LarkContext.getApplication()).getString(2131892011));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m612invoke();
        return Unit.INSTANCE;
    }
}
