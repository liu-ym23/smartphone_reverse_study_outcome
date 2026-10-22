package bca;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricBlockAskUserBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends com.obric.assistant.block.base.c<bca.a> {
    public ObricBlockAskUserBinding e;

    public static final class a extends CharacterStyle {
        public final int a;
        public final float b;

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "tp");
            if (Build.VERSION.SDK_INT < 29) goto L5;
            r3.underlineColor = this.a;
            r3.underlineThickness = this.b;
            return;
        L5:
            r3.setUnderlineText(true);
        }

        public a(int r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void i() {
        FLogger.a.i("OmniTaskAskUserBlockHolder", "onViewRecycled");
    }

    public d() {
    }

    @Override // com.obric.assistant.block.base.c
    public final void g(jc8.a r44) {
        final bca.a r1 = (bca.a) r44;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        super.g(r1);
        FLogger r2 = FLogger.a;
        r2.i("OmniTaskAskUserBlockHolder", "onBindBlockView");
        final ObricBlockAskUserBinding r3 = this.e;
        if (r3 != null) goto L5;
        r2.w("OmniTaskAskUserBlockHolder", "binding is null");
        return;
    L5:
        BlockContent r4 = ((jc8.a) r1).a.getContent();
        if (r4 == null) goto L39;
        final OClickActionBlock r5 = r4.getOClickActionBlock();
        if (r5 == null) goto L39;
        e1.x(r3.a);
        String r6 = r5.content;
        if (r6 != null) goto L13;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        String r8 = r6;
        Context r7 = r3.a.getContext();
        gw8.c.a.getClass();
        gw8.c r9 = gw8.c.a.b();
        Spannable r14 = null;
        if (r9 == null) goto L16;
        Intrinsics.checkNotNull(r7);
        l r10 = gw8.c.b.a(r9, r7, 0, r8, true, new lw8.d(0, null, null, false, Integer.valueOf(r3.c.getCurrentTextColor()), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, -39489, 31), null, null, 224);
    L17:
        r3.c.setMarkdown(r10);
        we8.a.b(r3.c, i5.t(), false, null, null, 12);
        String r11 = r5.clickAction;
        if (r11 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == false) goto L26;
        r3.c.setTextColor(ContextCompat.getColor(r7, 2131103681));
        r3.c.setOnClickListener(null);
        r3.c.setClickable(false);
    L38:
        r3.c.setOnLongClickListener(new c(this));
        return;
    L26:
        CustomMarkdownTextView r13 = r3.c;
        int r15 = ContextCompat.getColor(r7, 2131103682);
        CharSequence r16 = r13.getText();
        if (r16 == null) goto L37;
        boolean r17 = r16 instanceof Spannable;
        if (r17 == false) goto L32;
        r14 = (Spannable) r16;
    L32:
        if (r14 != null) goto L34;
        r14 = new SpannableString(r16);
    L34:
        Resources r18 = r13.getResources();
        r14.setSpan(new a(r15, WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics()).density), 0, r14.length(), 33);
        if (r17 == true) goto L37;
        r13.setText(r14);
    L37:
        r3.c.setTextColor(ContextCompat.getColorStateList(r7, 2131103792));
        e1.d(r3.c, new bca.b(r3, r5, r1));
        goto L38
    L20:
        if (r11.length() == 0) goto L23;
        r12 = false;
        goto L24
    L16:
        r10 = null;
    L39:
        e1.o(r3.a);
    }

    public final View h(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        FLogger.a.i("OmniTaskAskUserBlockHolder", "onCreatedBlockView");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563934, r4, false);
        FrameLayout r0 = (FrameLayout) r5;
        CustomMarkdownTextView r2 = ViewBindings.findChildViewById(r5, 2131389991);
        if (r2 == null) goto L7;
        this.e = new ObricBlockAskUserBinding(r0, r0, r2);
        return r0;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131389991)));
    }
}
