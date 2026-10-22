package com.obric.assistant.login;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.login.impl.loginfragment.u0;
import com.obric.assistant.spi.login.IObricLoginService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/login/ObricLoginServiceImpl;", "Lcom/obric/assistant/spi/login/IObricLoginService;", "<init>", "()V", "isNotObricLogin", "", "setupWelcomeContent", "", "welcomeStub", "Landroid/view/ViewStub;", "viewsToHide", "", "Landroid/view/View;", "animatorTitle", "animatorTitleBottomAnchor", "onWelcomePrimaryClick", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoginServiceImpl implements IObricLoginService {
    public ObricLoginServiceImpl() {
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final boolean b() {
        return false;
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final void a(ViewStub r5, List r6, SimpleDraweeView r7, View r8, final u0 r9) {
        Intrinsics.checkNotNullParameter(r5, "welcomeStub");
        Intrinsics.checkNotNullParameter(r6, "viewsToHide");
        Intrinsics.checkNotNullParameter(r7, "animatorTitle");
        Intrinsics.checkNotNullParameter(r8, "animatorTitleBottomAnchor");
        Intrinsics.checkNotNullParameter(r9, "onWelcomePrimaryClick");
        Iterator r10 = r6.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((View) r10.next()).setVisibility(8);
        goto L4
    L6:
        ViewGroup.LayoutParams r11 = r7.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
    L10:
        if (r12 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r12).topMargin = r7.getResources().getDimensionPixelSize(c.b(2130971200, null, 2131166769));
        r12.bottomToTop = r8.getId();
        r7.setLayoutParams(r12);
    L12:
        r5.setLayoutResource(2131564055);
        ConstraintLayout r13 = r5.inflate();
        int r14 = 2131393158;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131393158)) == null) goto L21;
        r14 = 2131393160;
        Button r15 = (Button) ViewBindings.findChildViewById(r13, 2131393160);
        if (r15 == null) goto L21;
        r14 = 2131393161;
        if (((TextView) ViewBindings.findChildViewById(r13, 2131393161)) == null) goto L21;
        r15.setOnClickListener(new y(r9));
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    L9:
        r12 = null;
        goto L10
    }
}
