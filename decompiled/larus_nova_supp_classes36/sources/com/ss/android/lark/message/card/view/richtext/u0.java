package com.ss.android.lark.message.card.view.richtext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u0 implements TextWatcher {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ RichTextRenderAdapter c;
    public final /* synthetic */ RichTextElement.SelectMenuProperty d;
    public final /* synthetic */ TextView e;
    public final /* synthetic */ c0.q f;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
        if (r6.length() > 0) goto L7;
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        c0.q r10 = this.f;
        CharSequence[] r11 = r10.d;
        if (r11 == null) goto L27;
        this.c.A2(c0.q.a(r10, r11));
        return;
    L27:
        return;
    L7:
        c0.q r12 = this.f;
        List r0 = this.d.getOptions();
        r12.getClass();
        ArrayList r1 = new ArrayList();
        CharSequence[] r3 = null;
        if (com.larksuite.framework.utils.f0.a(r6.toString()) == true) goto L20;
        int r2 = 0;
    L12:
        if (r2 >= r0.size()) goto L18;
        if (((RichTextElement.MenuOption) ListProtector.get(r0, r2)).getText().contains(r6) == false) goto L16;
        r1.add(((RichTextElement.MenuOption) ListProtector.get(r0, r2)).getText());
    L16:
        r2 = r2 + 1;
        goto L12
    L18:
        if (r1.size() <= 0) goto L20;
        r3 = (CharSequence[]) r1.toArray(new CharSequence[r1.size()]);
        r12.c = r3;
    L20:
        if (r3 != null) goto L22;
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        c0.q r13 = this.f;
        TextView r14 = this.e;
        r13.getClass();
        String r15 = UIHelper.mustacheFormat(2131892028, "search_key", r6.toString());
        int r4 = r15.indexOf(r6.toString());
        r14.setText(y0.b(r15, r4, r6.length() + r4, r6.toString(), ContextCompat.getColor(r13.g.d, 2131103456)));
        return;
    L22:
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.c.A2(c0.q.a(this.f, r3));
    }

    public u0(c0.q r1, RecyclerView r2, LinearLayout r3, RichTextRenderAdapter r4, RichTextElement.SelectMenuProperty r5, TextView r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
