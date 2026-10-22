package wba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OLoadingBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockLoadingBinding;
import j19.c;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends uba.a<wba.a> {
    public ObricBlockLoadingBinding d;

    public static final class a {
    }

    static {
    }

    public final void i() {
        FLogger.a.i("LoadingBlockHolder", "onViewRecycled");
        ObricBlockLoadingBinding r0 = this.d;
        if (r0 == null) goto L8;
        ShimmerTextView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.x();
        return;
    L9:
        return;
    }

    public b() {
    }

    public final void g(jc8.a r11) {
        wba.a r12 = (wba.a) r11;
        Intrinsics.checkNotNullParameter(r12, "blockModel");
        FLogger r0 = FLogger.a;
        r0.i("LoadingBlockHolder", "onBindBlockView");
        ObricBlockLoadingBinding r1 = this.d;
        if (r1 != null) goto L5;
        r0.w("LoadingBlockHolder", "onBindBlockView: binding is null");
        return;
    L5:
        BlockContent r3 = ((jc8.a) r12).a.getContent();
        if (r3 == null) goto L8;
        OLoadingBlock r4 = r3.getOLoadingBlock();
    L9:
        if (r4 != null) goto L11;
        r0.w("LoadingBlockHolder", "onBindBlockView: loadingBlock is null");
        e1.o(r1.a);
        return;
    L11:
        c.f(r1.a);
        e1.o(r1.b);
        we8.a.b(r1.c, i5.o(), false, null, null, 12);
        String r2 = r4.text;
        if (r2 != null) goto L14;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L14:
        r1.c.setText(r2);
        c.f(r1.c);
        if (((jc8.a) r12).a.isFinish() == false) goto L17;
    L23:
        r1.c.x();
    L24:
        LinearLayout r13 = r1.a;
        ViewGroup.LayoutParams r5 = r13.getLayoutParams();
        if (r5 == null) goto L29;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        Lazy r7 = gca.c.a;
        r6.leftMargin = ((Number) r7.getValue()).intValue();
        r6.rightMargin = ((Number) r7.getValue()).intValue();
        r13.setLayoutParams(r6);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        if (r2.length() != 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == true) goto L23;
        r1.c.z(false);
        goto L24
    L19:
        r14 = false;
        goto L20
    L8:
        r4 = null;
        goto L9
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("LoadingBlockHolder", "onCreatedBlockView");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563938, r4, false);
        int r0 = 2131374718;
        SimpleDraweeView r1 = ViewBindings.findChildViewById(r5, 2131374718);
        if (r1 == null) goto L9;
        r0 = 2131388367;
        ShimmerTextView r2 = ViewBindings.findChildViewById(r5, 2131388367);
        if (r2 == null) goto L9;
        LinearLayout r6 = (LinearLayout) r5;
        this.d = new ObricBlockLoadingBinding(r6, r1, r2);
        return r6;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r0)));
    }
}
