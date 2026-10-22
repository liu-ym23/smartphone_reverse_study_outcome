package com.ss.android.lark.picker.base.view.avataritem.userduty;

import android.view.View;
import b08.b;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.ShrinkDutyView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w3c.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avataritem/userduty/UserDutyBinder;", "Lcom/larksuite/component/ui/list/IComponentBinder;", "Lcom/ss/android/lark/picker/base/view/ShrinkDutyView;", "Lcom/ss/android/lark/search/dto/bindermodel/UserDutyModel;", "<init>", "()V", "bind", "", "view", "model", "unbind", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class UserDutyBinder implements b<ShrinkDutyView, i> {
    public static final UserDutyBinder INSTANCE = null;

    static {
        INSTANCE = new UserDutyBinder();
    }

    private UserDutyBinder() {
    }

    public void unbind(ShrinkDutyView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        r2.setVisibility(8);
    }

    public /* bridge */ /* synthetic */ void unbind(View r1) {
        unbind((ShrinkDutyView) r1);
    }

    public void bind(ShrinkDutyView r3, i r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "model");
        r3.setVisibility(8);
        r3.setDividerVisibility(0);
        r4.getClass();
        r3.setSectionVisibility(8);
        r3.setDividerVisibility(8);
        r3.setSection("");
        r3.setDutyVisibility(8);
        r3.setDividerVisibility(8);
        r3.setDuty("");
    }

    public /* bridge */ /* synthetic */ void bind(View r1, Object r2) {
        bind((ShrinkDutyView) r1, (i) r2);
    }
}
