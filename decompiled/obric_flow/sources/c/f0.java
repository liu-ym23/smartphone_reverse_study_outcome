package c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.flow.cardlistpage.R$layout;
import com.obric.oui.orecyclerview.widget.x0;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class f0 extends com.obric.oui.orecyclerview.widget.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1050c;

    public f0(n r5) {
        this.f1049b = 0;
        this.f1050c = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final int getItemCount() {
        switch(this.f1049b) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        return 1;
    L5:
        return ((List) this.f1050c).size();
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public int getItemViewType(int r5) {
        switch(this.f1049b) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        com.obric.flow.cardlistpage.ui.settings.f r10 = (com.obric.flow.cardlistpage.ui.settings.f) ((List) this.f1050c).get(r5);
        if ((r10 instanceof com.obric.flow.cardlistpage.ui.settings.e) == false) goto L10;
        return 1;
    L10:
        if ((r10 instanceof com.obric.flow.cardlistpage.ui.settings.d) == false) goto L14;
        return 2;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        return super.getItemViewType(r5);
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final void onBindViewHolder(x0 r5, int r10) {
        switch(this.f1049b) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "holder");
        boolean r11 = r5 instanceof com.obric.flow.cardlistpage.ui.settings.c;
        List r12 = (List) this.f1050c;
        if (r11 == false) goto L10;
        if ((r12.get(r10) instanceof com.obric.flow.cardlistpage.ui.settings.e) == false) goto L10;
        com.obric.flow.cardlistpage.ui.settings.c r13 = (com.obric.flow.cardlistpage.ui.settings.c) r5;
        Object r14 = r12.get(r10);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.obric.flow.cardlistpage.ui.settings.CardFeedSettingsActivity.SettingEntry.Feature");
        com.obric.flow.cardlistpage.ui.settings.e r15 = (com.obric.flow.cardlistpage.ui.settings.e) r14;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r15, "item");
        int r16 = r15.f11827a;
        r13.f11822h.setImageResource(r16);
        r13.f11823i.setText(r15.f11828b);
        r13.f11824j.setText(r15.f11829c);
        ar.a r17 = new ar.a(r15, 14);
        r13.g.setOnClickListener(r17);
        return;
    L10:
        if ((r5 instanceof com.obric.flow.cardlistpage.ui.settings.a) == true) goto L12;
        return;
    L12:
        if ((r12.get(r10) instanceof com.obric.flow.cardlistpage.ui.settings.d) == false) goto L26;
        com.obric.flow.cardlistpage.ui.settings.a r18 = (com.obric.flow.cardlistpage.ui.settings.a) r5;
        Object r19 = r12.get(r10);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.obric.flow.cardlistpage.ui.settings.CardFeedSettingsActivity.SettingEntry.Action");
        com.obric.flow.cardlistpage.ui.settings.d r20 = (com.obric.flow.cardlistpage.ui.settings.d) r19;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r20, "item");
        int r21 = r20.f11825a;
        r18.f11820h.setText(r21);
        ar.a r22 = new ar.a(r20, 13);
        r18.g.setOnClickListener(r22);
        return;
    L26:
        return;
    L15:
        View r23 = ((g0) r5).itemView;
        if ((r23 instanceof ViewGroup) == false) goto L23;
        ViewGroup r24 = (ViewGroup) r23;
        int r25 = r24.getChildCount();
        n r26 = (n) this.f1050c;
        if (r25 != 0) goto L21;
    L19:
        r24.addView(n.a(r26));
        return;
    L21:
        if (r24.getChildAt(0) == n.a(r26)) goto L28;
        r24.removeAllViews();
        goto L19
    L28:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final x0 onCreateViewHolder(ViewGroup r5, int r10) {
        switch(this.f1049b) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "parent");
        LayoutInflater r11 = LayoutInflater.from(r5.getContext());
        if (r10 != 2) goto L7;
        View r12 = r11.inflate(R$layout.item_card_feed_setting_action, r5, false);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        return new com.obric.flow.cardlistpage.ui.settings.a((ViewGroup) r12);
    L7:
        View r13 = r11.inflate(R$layout.item_card_feed_setting, r5, false);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.view.ViewGroup");
        return new com.obric.flow.cardlistpage.ui.settings.c((ViewGroup) r13);
    L9:
        LinearLayout r14 = new LinearLayout(r5.getContext());
        if (((n) this.f1050c).e() == false) goto L12;
        int r15 = -1;
    L13:
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, r15));
        return new g0(r14);
    L12:
        r15 = -2;
        goto L13
    }

    public f0(List r5) {
        this.f1049b = 1;
        Intrinsics.checkNotNullParameter(r5, "items");
        this.f1050c = r5;
    }
}
