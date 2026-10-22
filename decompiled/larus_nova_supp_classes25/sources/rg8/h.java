package rg8;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.helper.n0;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.utils.w2;
import com.larus.bmhome.view.SelectButtonListView;
import com.larus.bmhome.view.d4;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.l;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h extends bd8.b {
    public final wg8.c l;
    public final Lazy m;
    public final wg8.f n;
    public FrameLayout o;
    public final Lazy p;
    public CustomMarkdownTextView q;
    public ec8.b r;
    public boolean s;
    public FrameLayout t;
    public Message u;
    public SelectButtonListView v;

    public static final class a {
    }

    static {
    }

    public h() {
        super(true, 10);
        this.l = new wg8.c();
        this.m = LazyKt.lazy(new f(this));
        this.n = new wg8.f();
        this.p = LazyKt.lazy(new g(this));
    }

    @Override // bd8.b
    public final void B() {
        this.l.e();
    }

    @Override // bd8.b
    public final void C() {
        CustomMarkdownTextView r0 = this.q;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        SelectButtonListView r1 = this.v;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        FrameLayout r2 = this.o;
        if (r2 == null) goto L19;
        int r3 = r2.getChildCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L19;
        CustomMarkdownTextView r5 = r2.getChildAt(r4);
        if ((r5 instanceof CustomMarkdownTextView) == false) goto L15;
        CustomMarkdownTextView r6 = r5;
    L16:
        if (r6 == null) goto L18;
        l.a(r6);
        r6.a();
    L18:
        r4 = r4 + 1;
        goto L11
    L15:
        r6 = null;
    L19:
        FrameLayout r7 = this.o;
        if (r7 == null) goto L22;
        r7.removeAllViews();
    L22:
        FrameLayout r8 = this.t;
        if (r8 == null) goto L29;
        r8.removeAllViews();
        return;
    }

    @Override // bd8.b
    public final void D() {
        CustomMarkdownTextView r0 = this.q;
        if (r0 == null) goto L6;
        J(r0);
        return;
    }

    @Override // bd8.b
    public final void E() {
        CustomMarkdownTextView r0 = this.q;
        if (r0 == null) goto L10;
        i r1 = this.d;
        if (r1 == null) goto L7;
        int r2 = r1.getMaxWidth();
    L8:
        r0.setMarkdownWidth(r2);
        return;
    L7:
        r2 = -1;
        goto L8
    }

    @Override // bd8.b
    public final void z() {
        wg8.c r0 = this.l;
        r0.j.a = 0;
        r0.d = false;
    }

    @Override // bd8.b
    public final void F(boolean r2) {
        CustomMarkdownTextView r0 = this.q;
        if (r0 == null) goto L6;
        r0.setUseSubscribedColor(r2);
        return;
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return com.larus.bmhome.chat.bean.d.x0(r2);
    }

    public final void J(TextView r4) {
        i r0 = this.d;
        if (r0 == null) goto L5;
        Integer r1 = r0.getImmerseBgColor();
    L7:
        if (r1 == null) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        float r3 = we8.a.a(i5.o(), true);
    L13:
        r4.setTextSize(0, r3);
        return;
    L12:
        r3 = we8.a.a(i5.t(), false);
        goto L13
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void K(final CustomMarkdownTextView r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Message r0 = this.u;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L12;
        r4.setDownListener(null);
        return;
    L12:
        r4.setDownListener(new c(this));
        r4.setOnClickListener(new d(this, r4));
        r4.setOnLongClickListener(new e(this, r4));
        return;
    L7:
        if (com.larus.bmhome.chat.bean.d.I0(r0) != true) goto L9;
        r1 = true;
        goto L9
    }

    public final void L(Message r35, BotModel r36) {
        if (com.larus.bmhome.chat.bean.d.x0(r35) == true) goto L7;
        CustomMarkdownTextView r1 = this.q;
        if (r1 == null) goto L72;
        e1.o(r1);
        return;
    L72:
        return;
    L7:
        FrameLayout r2 = this.o;
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        lw8.l r4 = null;
        if (r3 == false) goto L62;
        Context r5 = getContext();
        if (r5 != null) goto L18;
        CustomMarkdownTextView r6 = null;
    L57:
        this.q = r6;
        if (r6 == null) goto L62;
        r6.setVisibility(8);
        FrameLayout r7 = this.o;
        if (r7 == null) goto L62;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        r8.gravity = 8388661;
        Unit r9 = Unit.INSTANCE;
        r7.addView(r6, r8);
        goto L62
    L18:
        r6 = new CustomMarkdownTextView(r5, null, 6, 0);
        i r10 = this.d;
        if (r10 == null) goto L21;
        int r11 = r10.getMaxWidth();
    L22:
        r6.setMarkdownWidth(r11);
        r6.setBottomLineWeight(i5.x0(v19.c.b(2130971253, null, 2131166876)));
        r6.setLineColor(1207959551);
        J(r6);
        Context r12 = getContext();
        if (r12 == null) goto L32;
        i r13 = this.d;
        if (r13 == null) goto L28;
        Integer r14 = r13.getImmerseBgColor();
    L29:
        if (r14 == null) goto L31;
        r6.setTextColor(ContextCompat.getColor(r12, 2131103298));
        goto L32
    L31:
        r6.setTextColor(ContextCompat.getColor(r12, v19.c.b(2130972079, r12, 2131103136)));
        goto L32
    L28:
        r14 = null;
    L32:
        r6.setLineSpacing(0.0f, 1.1f);
        Context r15 = getContext();
        if (r15 == null) goto L37;
        Resources r16 = r15.getResources();
        if (r16 == null) goto L37;
        int r17 = r16.getDimensionPixelSize(2131167561);
    L38:
        Context r18 = getContext();
        if (r18 == null) goto L43;
        Resources r19 = r18.getResources();
        if (r19 == null) goto L43;
        int r20 = r19.getDimensionPixelSize(2131167561);
    L44:
        Context r21 = getContext();
        if (r21 == null) goto L49;
        Resources r22 = r21.getResources();
        if (r22 == null) goto L49;
        int r23 = r22.getDimensionPixelSize(2131167562);
    L50:
        Context r24 = getContext();
        if (r24 == null) goto L55;
        Resources r25 = r24.getResources();
        if (r25 == null) goto L55;
        int r26 = r25.getDimensionPixelSize(2131167562);
    L56:
        FLogger.a.i("updatePaddingRelative", "view:CustomMarkdownTextView,source:,start:" + r17 + ",top:" + r23 + ",end:" + r20 + ",bottom:" + r26);
        r6.setPaddingRelative(r17, r23, r20, r26);
    L55:
        r26 = 0;
    L49:
        r23 = 0;
    L43:
        r20 = 0;
    L37:
        r17 = 0;
        goto L38
    L21:
        r11 = 0;
    L62:
        CustomMarkdownTextView r27 = this.q;
        if (r27 == null) goto L65;
        e1.x(r27);
    L65:
        K(this.q);
        String r28 = hc8.b.a.a(hc8.c.a, r35, r36, false, 12);
        CustomMarkdownTextView r29 = this.q;
        if (r29 == null) goto L74;
        gw8.c.a.getClass();
        gw8.c r30 = gw8.c.a.b();
        if (r30 == null) goto L70;
        r4 = gw8.c.b.b(r30, this.q, r28, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));
    L70:
        r29.setMarkdown(r4);
        return;
    L74:
        return;
    L10:
        if (r2.getChildCount() != 0) goto L12;
        r3 = true;
        goto L13
    }

    @Override // bd8.b
    public final void w(final Message r72, int r73, ec8.b r74) {
        Intrinsics.checkNotNullParameter(r72, "message");
        this.r = r74;
        this.u = r72;
        Intrinsics.checkNotNullParameter(r72, "message");
        y r2 = (y) this.p.getValue();
        if (r2 == null) goto L6;
        BotModel r3 = r2.j0();
        if (r3 == null) goto L6;
    L10:
        L(r72, r3);
        K(this.q);
        if (com.larus.bmhome.chat.bean.d.x0(r72) == true) goto L15;
        SelectButtonListView r1 = this.v;
        if (r1 == null) goto L54;
        r1.setVisibility(8);
        return;
    L54:
        return;
    L15:
        Context r4 = getContext();
        if (r4 == null) goto L59;
        FrameLayout r5 = this.t;
        boolean r6 = true;
        if (r5 != null) goto L21;
    L23:
        boolean r7 = false;
    L24:
        if (r7 == false) goto L29;
        SelectButtonListView r8 = new SelectButtonListView(r4, null, 6, 0);
        r8.setVisibility(8);
        FrameLayout r9 = this.t;
        if (r9 == null) goto L28;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMargins(0, i5.h(), 0, i5.h());
        Unit r11 = Unit.INSTANCE;
        r9.addView(r8, r10);
    L28:
        r8.setPadding(i5.q(), r8.getPaddingTop(), i5.Y(), r8.getPaddingBottom());
        r8.setClipToPadding(false);
        this.v = r8;
    L29:
        List r12 = r72.getSubList();
        List r13 = r12;
        if (r13 != null) goto L32;
    L35:
        boolean r14 = true;
    L36:
        if (r14 == false) goto L40;
        SelectButtonListView r15 = this.v;
        if (r15 == null) goto L56;
        r15.setVisibility(8);
        return;
    L56:
        return;
    L40:
        FLogger.a.d("MultipleMessageComponent", "setupSelectButtonList show: " + r12.size());
        n0 r16 = n0.a;
        String r17 = r72.getMessageId();
        r16.getClass();
        int r18 = w2.a(r17);
        SelectButtonListView r19 = this.v;
        if (r19 == null) goto L50;
        int r20 = r12.size();
        if (r19.i != r18) goto L46;
        r6 = false;
    L46:
        r19.i = r18;
        r19.j = r20;
        if (r20 <= 0) goto L49;
        SelectButtonListView.SelectButtonAdapter r21 = r19.getAdapter();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.larus.bmhome.view.SelectButtonListView.SelectButtonAdapter");
        r21.submitList(r19.v(), new d4(r6, r19, r18));
        r19.setVisibility(0);
        goto L50
    L49:
        r19.setVisibility(8);
    L50:
        SelectButtonListView r22 = this.v;
        if (r22 == null) goto L58;
        Function1 r23 = new b(r72, this);
        Intrinsics.checkNotNullParameter(r23, "listener");
        r22.k = r23;
        return;
    L58:
        return;
    L32:
        if (r13.isEmpty() == true) goto L35;
        r14 = false;
        goto L36
    L21:
        if (r5.getChildCount() != 0) goto L23;
        r7 = true;
        goto L24
    L59:
        return;
    L6:
        String r24 = r72.getSenderId();
        if (r24 != null) goto L9;
        r24 = "unknown";
    L9:
        r3 = new BotModel(r24, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L10
    }

    @Override // bd8.b
    public final List<View> x(int r2, Context r3, BaseMessageListCell<?> r4, i r5, q0 r6, Fragment r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.x(r2, r3, r4, r5, r6, r7);
        FrameLayout r8 = new FrameLayout(r3);
        FrameLayout r9 = new FrameLayout(r3);
        if (r5 == null) goto L5;
        r5.addView(r9, r2, new LinearLayout.LayoutParams(-2, -2));
    L5:
        if (r5 == null) goto L7;
        r5.addView(r8, r2, new LinearLayout.LayoutParams(-2, -2));
    L7:
        this.n.a = r4;
        this.o = r8;
        this.t = r9;
        wg8.c r10 = this.l;
        r10.a = r4;
        r10.b = r5;
        return CollectionsKt.listOf(new FrameLayout[]{r8, r9});
    }
}
