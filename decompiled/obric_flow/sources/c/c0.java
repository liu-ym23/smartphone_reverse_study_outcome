package c;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.x0;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.login.LoginNumberActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends com.obric.oui.orecyclerview.widget.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoginNumberActivity f1030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f1031c;

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final int getItemCount() {
        return this.f1031c.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final void onBindViewHolder(x0 r5, int r10) {
        b0 r11 = (b0) r5;
        List r12 = this.f1031c;
        String r13 = (String) r12.get(r10);
        r11.getClass();
        ArrayList r14 = s.f1081a;
        String r15 = r13.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        OCardListItem r16 = r11.g;
        r16.setTitle(r15);
        y r17 = new y(this, r10);
        r11.f1027h.setOnClickListener(r17);
        if (r12.size() > 1) goto L6;
        int r18 = 0;
    L5:
        r16.setCardPosition(r18);
        return;
    L6:
        if (r10 != 0) goto L9;
        r16.setCardPosition(1);
        return;
    L9:
        if (r10 != (r12.size() - 1)) goto L11;
        r18 = 3;
        goto L5
    L11:
        r18 = 2;
        goto L5
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final x0 onCreateViewHolder(ViewGroup r5, int r10) {
        OCardListItem r11 = (OCardListItem) LayoutInflater.from(this.f1030b).inflate(R.layout.express_phone_info_o_card_list_item, r5, false);
        b0 r12 = new b0(r11);
        r12.g = r11;
        r12.f1027h = (OButton) r11.findViewById(R.id.express_phone_info_custom_end_btn);
        return r12;
    }
}
