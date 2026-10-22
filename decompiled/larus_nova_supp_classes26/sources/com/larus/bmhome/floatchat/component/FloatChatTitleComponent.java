package com.larus.bmhome.floatchat.component;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/larus/bmhome/floatchat/component/FloatChatTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "<init>", "()V", "chatTitle", "Landroid/widget/TextView;", "chatSubtitle", "chatTitleContainer", "Landroid/view/View;", "chatTitleExpandIcon", "curTitleText", "", "floatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "getFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "floatChatFoldCoreAbility$delegate", "Lkotlin/Lazy;", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "showTitle", "hideTitle", "setTitle", "title", "updateSubtitle", "updateSubtitleOrHideContainer", "shouldShowSubtitleInCurrentState", "", "hideTitleViews", "showTitleViews", "shouldHideTitle", "shouldShowSubtitleWhenTitleHidden", "shouldHideTitleExpandIcon", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatChatTitleComponent extends BaseContentWidget implements np8.a {
    public static final /* synthetic */ int t = 0;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public String q;
    public final Lazy r;
    public int s;

    public final void B3() {
        TextView r0 = this.n;
        if (m3() == true) goto L9;
        if (r0 == null) goto L6;
        e1.o(r0);
    L6:
        View r1 = this.o;
        if (r1 == null) goto L17;
        e1.o(r1);
        return;
    L17:
        return;
    L9:
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.setText(r0.getContext().getString(2131910353));
        e1.x(r0);
        View r2 = this.o;
        if (r2 == null) goto L19;
        e1.x(r2);
        return;
    L19:
        return;
    L13:
        View r3 = this.o;
        if (r3 == null) goto L21;
        e1.o(r3);
        return;
    }

    public final void Y2() {
        TextView r0 = this.m;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        View r1 = this.p;
        if (r1 == null) goto L9;
        e1.o(r1);
        return;
    }

    public final boolean h3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("float_chat_hide_title") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean m3() {
        g0 r0 = (g0) this.r.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (h3() == false) goto L19;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L19;
        return false;
    L15:
        if (r2.getBoolean("float_chat_show_subtitle_when_title_hidden") != true) goto L17;
        r3 = true;
    L19:
        return true;
    L5:
        if (r0.YC() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void p3() {
        TextView r0 = this.m;
        if (r0 == null) goto L5;
        e1.x(r0);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.getBoolean("float_chat_hide_title_expand_icon") != true) goto L10;
    L11:
        if (r2 == false) goto L15;
        View r3 = this.p;
        if (r3 == null) goto L19;
        e1.o(r3);
        return;
    L19:
        return;
    L15:
        View r4 = this.p;
        if (r4 == null) goto L21;
        e1.x(r4);
        return;
    L21:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public final void z3() {
        TextView r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (m3() == true) goto L18;
        e1.o(r0);
        TextView r1 = this.m;
        if (r1 != null) goto L10;
    L12:
        if (r2 == true) goto L31;
        View r3 = this.o;
        if (r3 == null) goto L32;
        e1.o(r3);
        return;
    L32:
        return;
    L31:
        return;
    L10:
        if (r1.getVisibility() != 0) goto L12;
        r2 = true;
        goto L12
    L18:
        if (h3() == false) goto L27;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r4 != null) goto L22;
    L24:
        if (r2 == true) goto L27;
        e1.o(r0);
        return;
    L22:
        if (r4.getBoolean("float_chat_show_subtitle_when_title_hidden") != true) goto L24;
        r2 = true;
    L27:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.setText(r0.getContext().getString(2131910353));
        e1.x(r0);
        View r5 = this.o;
        if (r5 == null) goto L33;
        e1.x(r5);
        return;
    }

    public FloatChatTitleComponent() {
        this.r = LazyKt.lazy(new a0(this));
        this.s = 2131372935;
    }

    @Override // np8.a
    public final void La() {
        Y2();
        TextView r0 = this.n;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        View r1 = this.o;
        if (r1 == null) goto L9;
        e1.o(r1);
        return;
    }

    @Override // np8.a
    public final void n3() {
        if (h3() == false) goto L6;
        Y2();
        B3();
        return;
    L6:
        p3();
        View r0 = this.o;
        if (r0 == null) goto L9;
        e1.x(r0);
    L9:
        z3();
    }

    public final int U2() {
        return this.s;
    }

    public final void X2(int r1) {
        this.s = r1;
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.m = (TextView) r5.findViewById(2131372934);
        this.n = (TextView) r5.findViewById(2131372933);
        this.o = r5.findViewById(2131372935);
        this.p = r5.findViewById(2131372936);
        boolean r0 = false;
        if (h3() == false) goto L5;
        Y2();
    L15:
        z3();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r6 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r6 == null) goto L25;
        String r7 = r6.getString("argChatTitle");
        if (r7 == null) goto L25;
        if ((!StringsKt.isBlank(r7)) == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L25;
        this.q = r7;
    L25:
        View r8 = this.o;
        if (r8 == null) goto L28;
        e1.d(r8, new z(this));
    L28:
        String r9 = this.q;
        if (r9 == null) goto L43;
        TextView r1 = this.m;
        if (r1 == null) goto L33;
        r1.setText(r9);
    L33:
        g0 r10 = (g0) this.r.getValue();
        if (r10 != null) goto L36;
    L38:
        if (r0 == false) goto L44;
        View r11 = this.o;
        if (r11 == null) goto L45;
        e1.x(r11);
        return;
    L45:
        return;
    L44:
        return;
    L36:
        if (r10.YC() != true) goto L38;
        r0 = true;
        goto L38
    L43:
        return;
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r12 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r12 != null) goto L8;
    L10:
        boolean r13 = false;
    L11:
        if (r13 == false) goto L15;
        View r14 = this.p;
        if (r14 == null) goto L15;
        e1.o(r14);
        goto L15
    L8:
        if (r12.getBoolean("float_chat_hide_title_expand_icon") != true) goto L10;
        r13 = true;
        goto L11
    }

    @Override // np8.a
    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.q = r2;
        if (h3() == false) goto L6;
        Y2();
        B3();
        return;
    L6:
        p3();
        TextView r0 = this.m;
        if (r0 == null) goto L9;
        r0.setText(r2);
    L9:
        z3();
        g0 r3 = (g0) this.r.getValue();
        if (r3 == null) goto L14;
        boolean r1 = true;
        if (r3.YC() != true) goto L14;
    L15:
        if (r1 == false) goto L20;
        View r4 = this.o;
        if (r4 == null) goto L21;
        e1.x(r4);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        r1 = false;
        goto L15
    }
}
