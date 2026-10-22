package com.larksuite.component.card.component.personlist.detail;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.ui.CommonTitleBar;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListForsetiFragment;", "Lcom/larksuite/component/card/component/personlist/detail/PersonListFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonListForsetiFragment extends PersonListFragment {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PersonListForsetiFragment a;

        public a(PersonListForsetiFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            g r4 = f.b(this.a);
            if (r4 == null) goto L15;
            Boolean r5 = Boolean.valueOf(r4.g(null));
            if ((!r5.booleanValue()) == true) goto L8;
            r5 = null;
        L8:
            if (r5 == null) goto L16;
            PersonListForsetiFragment r1 = this.a;
            r5.booleanValue();
            FragmentActivity r6 = r1.getActivity();
            if (r6 == null) goto L17;
            g r7 = f.c(r6, false);
            if (r7 == null) goto L18;
            r7.g(null);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public PersonListForsetiFragment() {
    }

    @Override // com.larksuite.component.card.component.personlist.detail.PersonListFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        CommonTitleBar r4 = this.f;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r4 = null;
    L6:
        r4.setLeftClickListener(new a(this));
        com.ss.android.lark.insets.f r5 = WindowInsetsUtils.b(this);
        r5.c(true);
        r5.o(true);
        r5.k(true);
        r5.r(true);
    }
}
