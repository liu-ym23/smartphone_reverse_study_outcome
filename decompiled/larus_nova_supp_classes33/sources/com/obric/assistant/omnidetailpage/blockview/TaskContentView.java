package com.obric.assistant.omnidetailpage.blockview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.business.markdown.api.model.CodeBlockConfig;
import com.larus.business.markdown.api.model.TableConfig;
import com.obric.assistant.card.databinding.ObricOmniBlockTaskContentBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u0003456B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00180\u001dJ<\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dH\u0002J0\u0010#\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dH\u0002J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020$H\u0002J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020$H\u0002J8\u0010)\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020$2\b\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001dH\u0002J \u0010*\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0007H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u00067"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskContentView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockTaskContentBinding;", "defaultMovementMethod", "Landroid/text/method/MovementMethod;", "getDefaultMovementMethod", "()Landroid/text/method/MovementMethod;", "defaultMovementMethod$delegate", "Lkotlin/Lazy;", "arrowDrawable", "Landroid/graphics/drawable/Drawable;", "getArrowDrawable", "()Landroid/graphics/drawable/Drawable;", "arrowDrawable$delegate", "bind", "", "item", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$Content;", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$ModeSetting;", "onClick", "Lkotlin/Function1;", "", "bindContent", "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem;", "content", "clickAction", "isModeSettingClickable", "", "buildRenderContent", "appendAction", "updateClickState", "isClickable", "applyModeSettingActionSpan", "updateContentPadding", "useCompactIndent", "topSpacingDp", "dpToPx", "dp", "updateContentTextColor", "resolveContentWidth", "buildTableConfig", "Lcom/larus/business/markdown/api/model/TableConfig;", "tableWidth", "DebouncedClickableSpan", "ModeSettingActionSpan", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskContentView extends OmniDetailVerticalLineFrameLayout {
    public static final /* synthetic */ int f = 0;
    public final ObricOmniBlockTaskContentBinding c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b extends ClickableSpan {
        public final Function0<Unit> a;
        public long b;

        public b(v r2) {
            Intrinsics.checkNotNullParameter(r2, "onClick");
            this.a = r2;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r7) {
            Intrinsics.checkNotNullParameter(r7, "widget");
            long r0 = System.currentTimeMillis();
            if ((r0 - this.b) >= 500) goto L5;
            return;
        L5:
            this.b = r0;
            this.a.invoke();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setUnderlineText(false);
        }
    }

    public static final class c extends ReplacementSpan {
        public final Drawable a;
        public final int b;
        public final Typeface c;

        public static final class a {
            public final Typeface a;
            public final boolean b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                Typeface r0 = this.a;
                if (r0 != null) goto L5;
                int r1 = 0;
            L6:
                int r2 = r1 * 31;
                if (this.b == false) goto L9;
                int r3 = 1231;
            L11:
                return r2 + r3;
            L9:
                r3 = 1237;
                goto L11
            L5:
                r1 = r0.hashCode();
                goto L6
            }

            public final String toString() {
                return "PaintState(typeface=" + this.a + ", fakeBoldText=" + this.b + ')';
            }

            public a(Typeface r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public final a a(Paint r6) {
            Typeface r0 = r6.getTypeface();
            boolean r1 = r6.isFakeBoldText();
            if (Build.VERSION.SDK_INT < 28) goto L8;
            if (r0 != null) goto L6;
            Typeface r2 = Typeface.DEFAULT;
        L7:
            Typeface r3 = Typeface.create(r2, 500, false);
        L9:
            r6.setTypeface(r3);
            r6.setFakeBoldText(false);
            return new a(r0, r1);
        L6:
            r2 = r0;
            goto L7
        L8:
            r3 = this.c;
            goto L9
        }

        public c(Drawable r1, int r2) {
            this.a = r1;
            this.b = r2;
            this.c = Typeface.create("sans-serif-medium", 0);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r1, CharSequence r2, int r3, int r4, Paint.FontMetricsInt r5) {
            Intrinsics.checkNotNullParameter(r1, "paint");
            Intrinsics.checkNotNullParameter(r2, "text");
            a r6 = a(r1);
            Drawable r7 = this.a;
            int r8 = 0;
            if (r7 == null) goto L7;
            Rect r9 = r7.getBounds();
            if (r9 == null) goto L7;
            int r10 = r9.width();
        L8:
            if (r10 <= 0) goto L10;
            r8 = this.b;
        L10:
            int r11 = MathKt.roundToInt((r1.measureText("去设置") + r8) + r10);
            r1.setTypeface(r6.a);
            r1.setFakeBoldText(r6.b);
            return r11;
        L7:
            r10 = 0;
            goto L8
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r2, "text");
            Intrinsics.checkNotNullParameter(r9, "paint");
            a r10 = a(r9);
            r1.drawText("去设置", r5, r7, r9);
            float r11 = r9.measureText("去设置");
            r9.setTypeface(r10.a);
            r9.setFakeBoldText(r10.b);
            Drawable r12 = this.a;
            if (r12 != null) goto L5;
            return;
        L5:
            float r13 = (r5 + r11) + this.b;
            int r14 = r6 + (((r8 - r6) - r12.getBounds().height()) / 2);
            r1.save();
            r1.translate(r13, r14);
            r12.draw(r1);
            r1.restore();
        }
    }

    static {
    }

    public TaskContentView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TaskContentView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Drawable getArrowDrawable() {
        return (Drawable) this.e.getValue();
    }

    private final MovementMethod getDefaultMovementMethod() {
        return (MovementMethod) this.d.getValue();
    }

    public TaskContentView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(new t(this));
        this.e = LazyKt.lazy(new u(r2));
        View r5 = LayoutInflater.from(r2).inflate(2131564043, this, false);
        addView(r5);
        CustomMarkdownTextView r6 = ViewBindings.findChildViewById(r5, 2131390013);
        if (r6 == null) goto L7;
        this.c = new ObricOmniBlockTaskContentBinding((LinearLayout) r5, r6);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131390013)));
    }

    public /* synthetic */ TaskContentView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.obric.assistant.omnidetailpage.blockview.v] */
    public final void a(ifa.f r79, String r80, final String r81, final Function1<? super String, Unit> r82) {
        setShowLine(r79.c);
        ObricOmniBlockTaskContentBinding r4 = this.c;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r79.e == true) goto L7;
    L11:
        boolean r5 = false;
    L12:
        int r8 = r79.g;
        LinearLayout r9 = r4.a;
        if (r5 == false) goto L15;
        int r10 = i5.q();
    L16:
        Resources r11 = getResources();
        r9.setPaddingRelative(r10, (int) ((r8 * WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density) + 0.5f), i5.q(), r4.a.getPaddingBottom());
        if ((r79 instanceof ifa.f.g) == false) goto L35;
        if (r81 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == true) goto L35;
        String r13 = r79.b.getBlockId();
        if (r13 != null) goto L28;
    L31:
        boolean r14 = true;
    L32:
        if (r14 == true) goto L35;
        if (r82 == null) goto L35;
        boolean r15 = true;
    L36:
        r4.b.setClickable(r15);
        r4.b.setOnClickListener(null);
        if (r15 == true) goto L39;
        r4.b.setMovementMethod(getDefaultMovementMethod());
    L39:
        int r16 = r4.b.getWidth();
        if (r16 > 0) goto L43;
        r16 = RangesKt.coerceAtLeast((com.larus.utils.i.f(getContext()) - r4.a.getPaddingStart()) - r4.a.getPaddingEnd(), 0);
    L43:
        int r17 = r16;
        if (r15 == true) goto L46;
        String r18 = r80;
    L47:
        gw8.c.a.getClass();
        gw8.c r19 = gw8.c.a.b();
        if (r19 == null) goto L50;
        Context r110 = getContext();
        int r111 = j19.c.c(8);
        int r0 = ContextCompat.getColor(getContext(), v19.c.b(2130972123, getContext(), 2131103203));
        CodeBlockConfig r21 = new CodeBlockConfig(null, null, false, null, 0, null, false, null, false, false, null, false, null, null, null, null, false, false, null, false, null, null, null, false, null, true, true, 33554431, null);
        Context r6 = getContext();
        int r7 = ContextCompat.getColor(r6, v19.c.b(2130972089, r6, 2131103169));
        int r20 = ContextCompat.getColor(r6, v19.c.b(2130972086, r6, 2131103159));
        int r112 = RangesKt.coerceAtLeast(r17 / 2, 0);
        int r113 = i5.r0();
        int r114 = i5.r0();
        lw8.l r1 = gw8.c.b.a(r19, r110, r17, r18, true, new lw8.d(0, null, null, false, Integer.valueOf(r0), 0, Float.valueOf(1.0f), 0.0f, Float.valueOf(1.0f), 0, 0, Integer.valueOf(r111), null, null, null, null, r21, new TableConfig(false, 0, Float.valueOf(we8.a.a(i5.o(), false)), Integer.valueOf(i5.b()), Integer.valueOf(r7), null, Integer.valueOf(r114), Integer.valueOf(r113), Integer.valueOf(r17), Integer.valueOf(r112), Integer.valueOf(i5.q()), Integer.valueOf(i5.r0()), null, null, false, false, false, false, false, null, Integer.valueOf(ContextCompat.getColor(r6, R.color.transparent)), Integer.valueOf(r20), 1044515, null), null, null, null, null, null, null, -6330945, 31), null, null, 224);
    L51:
        CustomMarkdownTextView r3 = r4.b;
        String r2 = r79.b.getBlockId();
        if (r2 != null) goto L54;
        r2 = "";
    L54:
        com.larus.bmhome.chat.layout.widget.handler.e.b(r3, "obric_omni_detail_block_id", r2);
        r4.b.setMarkdown(r1);
        if (r15 == false) goto L78;
        if (r81 != null) goto L58;
    L61:
        boolean r22 = true;
    L62:
        if (r22 == true) goto L78;
        if (r82 == null) goto L78;
        CharSequence r23 = r4.b.getText();
        if ((r23 instanceof Spannable) == false) goto L69;
        Spannable r115 = (Spannable) r23;
    L70:
        if (r115 == null) goto L78;
        int r24 = r115.length();
        int r25 = r24 - 3;
        if (r25 < 0) goto L78;
        if (Intrinsics.areEqual(r115.subSequence(r25, r24).toString(), "去设置") == false) goto L78;
        r115.setSpan(new c(getArrowDrawable(), i5.z()), r25, r24, 33);
        r115.setSpan(new b(new v(r82, r81)), r25, r24, 33);
        r4.b.setMovementMethod(LinkMovementMethod.getInstance());
        goto L78
    L69:
        r115 = null;
        goto L70
    L58:
        if (r81.length() == 0) goto L61;
        r22 = false;
    L78:
        if (r5 == 0) goto L80;
        int r26 = 2130972079;
    L81:
        if (r5 == false) goto L83;
        int r27 = 2131103136;
    L84:
        int r28 = ContextCompat.getColor(getContext(), v19.c.b(r26, getContext(), r27));
        r4.b.setTextColor(r28);
        Drawable r29 = getArrowDrawable();
        if (r29 == null) goto L89;
        DrawableCompat.setTint(r29, r28);
        return;
    L89:
        return;
    L83:
        r27 = 2131103146;
        goto L84
    L80:
        r26 = 2130972082;
        goto L81
    L50:
        r1 = null;
        goto L51
    L46:
        r18 = r80.concat("去设置");
        goto L47
    L28:
        if (r13.length() == 0) goto L31;
        r14 = false;
        goto L32
    L20:
        if (r81.length() == 0) goto L23;
        r12 = false;
    L35:
        r15 = false;
        goto L36
    L15:
        r10 = i5.d0();
        goto L16
    L7:
        if (r79.f == false) goto L11;
        if (r79.c == true) goto L11;
        r5 = true;
        goto L12
    }
}
