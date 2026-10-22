package dca;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockOmniTaskFinishBinding;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends com.obric.assistant.block.base.c<d> {
    public ObricBlockOmniTaskFinishBinding e;
    public Drawable f;

    public static final class a {
    }

    static {
    }

    public final void i() {
        FLogger.a.i("FeedbackBlockHolder", "onViewRecycled");
    }

    public c() {
    }

    @Override // com.obric.assistant.block.base.c
    public final void g(jc8.a r11) {
        final d r12 = (d) r11;
        Intrinsics.checkNotNullParameter(r12, "blockModel");
        super.g(r12);
        FLogger r0 = FLogger.a;
        r0.i("FeedbackBlockHolder", "onBindBlockView");
        final ObricBlockOmniTaskFinishBinding r1 = this.e;
        if (r1 != null) goto L5;
        r0.w("FeedbackBlockHolder", "binding is null");
        return;
    L5:
        BlockContent r2 = ((jc8.a) r12).a.getContent();
        if (r2 == null) goto L25;
        final OClickActionBlock r3 = r2.getOClickActionBlock();
        if (r3 == null) goto L25;
        e1.x(r1.a);
        TextView r4 = r1.b;
        String r5 = r3.content;
        if (r5 != null) goto L13;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r4.setText(r5);
        we8.a.b(r1.b, i5.q(), false, null, null, 12);
        String r6 = r3.clickAction;
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L21:
        if (r7 == false) goto L23;
        r1.b.setCompoundDrawables(null, null, null, null);
        r1.b.setOnClickListener(null);
    L24:
        r1.b.setOnLongClickListener(new b(this));
        return;
    L23:
        r1.b.setCompoundDrawables(null, null, this.f, null);
        e1.d(r1.b, new dca.a(r1, r3, r12));
        goto L24
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
    L25:
        e1.o(r1.a);
    }

    public final View h(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        FLogger.a.i("FeedbackBlockHolder", "onCreatedBlockView");
        Drawable r0 = ContextCompat.getDrawable(r5.getContext(), 2131244537);
        this.f = r0;
        if (r0 == null) goto L5;
        r0.mutate();
    L5:
        Drawable r1 = this.f;
        if (r1 == null) goto L8;
        r1.setBounds(0, 0, i5.m(), i5.m());
    L8:
        View r6 = LayoutInflater.from(r5.getContext()).inflate(2131563946, r5, false);
        RelativeLayout r2 = (RelativeLayout) r6;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, 2131389991);
        if (r3 == null) goto L13;
        this.e = new ObricBlockOmniTaskFinishBinding(r2, r3);
        return r2;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(2131389991)));
    }
}
