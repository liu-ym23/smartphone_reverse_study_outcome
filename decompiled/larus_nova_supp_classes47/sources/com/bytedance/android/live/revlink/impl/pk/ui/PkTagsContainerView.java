package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleRivalTag;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkTagsContainerView;", "Landroid/widget/LinearLayout;", "", "d", "Z", "isOldTag", "()Z", "setOldTag", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkTagsContainerView extends LinearLayout {
    public IRoom a;
    public int b;
    public int c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public PkTagsContainerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PkTagsContainerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public static int c(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        if (r1.getWidth() != 0) goto L7;
        r1.measure(0, 0);
        return r1.getMeasuredWidth();
    L7:
        return r1.getWidth();
    }

    public final void setOldTag(boolean r1) {
        this.d = r1;
    }

    public final void a(List r3, IRoom r4) {
        Intrinsics.checkNotNullParameter("invited_window", "showFrom");
        removeAllViews();
        this.a = r4;
        if (r3 == null) goto L8;
        Iterator r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        View r6 = b((IBattleRivalTag) r5.next(), false, false);
        ((TextView) r6.findViewById(2131391552)).setTextSize(9);
        addView(r6);
        goto L6
    L10:
        return;
    }

    public PkTagsContainerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131566370, this);
        setGravity(8388627);
    }

    public final View b(IBattleRivalTag r9, boolean r10, boolean r12) {
        if (r10 == true) goto L5;
        View r1 = LayoutInflater.from(getContext()).inflate(2131566290, this, false);
    L7:
        if (a1.j(r9.getIconImage()) == false) goto L11;
        r1.findViewById(2131374714).setVisibility(0);
        ImageUtil.loadImage((ImageView) r1.findViewById(2131374714), r9.getIconImage(), 0);
        if (this.d == false) goto L13;
        ViewGroup.LayoutParams r2 = r1.findViewById(2131374714).getLayoutParams();
        r2.width = s1.f(8.0f);
        ViewGroup.LayoutParams r3 = r1.findViewById(2131374714).getLayoutParams();
        r3.height = s1.f(10.0f);
    L13:
        if (r9.getContent() == null) goto L34;
        ((TextView) r1.findViewById(2131391552)).setVisibility(0);
        ((TextView) r1.findViewById(2131391552)).setText(r9.getContent());
    L34:
        ((TextView) r1.findViewById(2131391552)).setTextColor(Color.parseColor(r9.getFontColor()));     // Catch: Throwable -> L17
    L19:
        if (r12 == false) goto L22;
        ((LinearLayout) r1.findViewById(2131388092)).setBackgroundResource(2131252612);
        ((LinearLayout) r1.findViewById(2131388092)).setPadding(s1.f(3.0f), 0, s1.f(4.0f), 0);
        ((TextView) r1.findViewById(2131391552)).setTextColor(ColorProtector.parseColor("#80FFFFFF"));
        r1.findViewById(2131374714).setVisibility(8);
    L33:
        return r1;
    L22:
        if (a1.j(r9.getBackgroundImage()) == false) goto L32;
        View r13 = r1.findViewById(2131388092);
        r13.post(new s(r9.getBackgroundImage(), r13));
        if (a1.j(r9.getIconImage()) == false) goto L31;
        if (r10 == true) goto L28;
        ((LinearLayout) r1.findViewById(2131388092)).setPadding(0, 0, s1.f(4.0f), 0);
    L28:
        if (this.d == false) goto L33;
        if (r10 == true) goto L33;
        ((LinearLayout) r1.findViewById(2131388092)).setPadding(s1.f(4.0f), 0, s1.f(4.0f), 0);
        goto L33
    L31:
        ((LinearLayout) r1.findViewById(2131388092)).setPadding(s1.f(3.0f), 0, s1.f(4.0f), 0);
        goto L33
    L32:
        ((LinearLayout) r1.findViewById(2131388092)).setPadding(0, 0, 0, 0);
        goto L33
    L11:
        r1.findViewById(2131374714).setVisibility(8);
        goto L13
    L5:
        r1 = LayoutInflater.from(getContext()).inflate(2131566281, this, false);
        goto L7
    }

    public final void d(IBattleRivalTag r2, int r3, boolean r4) {
        View r5 = b(r2, false, r4);
        ((TextView) r5.findViewById(2131391552)).setTextSize(r3);
        if ((c(r5) + s1.f(4.0f)) >= this.b) goto L6;
        addView(r5);
        this.b -= c(r5) + s1.f(4.0f);
        return;
    }

    public /* synthetic */ PkTagsContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void g(List r6, List r7, IRoom r8, Function1 r9) {
        Intrinsics.checkNotNullParameter("record_banner", "showFrom");
        if (r6 != null) goto L6;
        if (r7 != null) goto L6;
        return;
    L6:
        this.a = r8;
        removeAllViews();
        int r10 = 0;
        if (r6 == null) goto L13;
        Iterator r12 = r6.iterator();
        int r1 = 0;
    L10:
        if (r12.hasNext() == false) goto L12;
        View r2 = b((IBattleRivalTag) r12.next(), false, false);
        ((TextView) r2.findViewById(2131391552)).setTextSize(9);
        addView(r2);
        r1 = r1 + (c(r2) + s1.f(4.0f));
        goto L10
    L12:
        r10 = r1;
    L13:
        if (r7 == null) goto L28;
        Iterator r13 = r7.iterator();
    L16:
        if (r13.hasNext() == false) goto L28;
        View r14 = (View) r13.next();
        ViewParent r3 = r14.getParent();
        if ((r3 instanceof ViewGroup) == true) goto L20;
        r3 = null;
    L20:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L23;
        r4.removeView(r14);
    L23:
        addView(r14);
        int r5 = r14.getLayoutParams().width;
        if (r5 > 0) goto L27;
        r5 = c(r14);
    L27:
        r10 = r10 + (r5 + s1.f(4.0f));
    L28:
        if (r9 == null) goto L35;
        Unit r15 = (Unit) r9.invoke(Integer.valueOf(r10));
        return;
    }

    public final void e(List r2, IRoom r3, int r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "showFrom");
        if (r2 != null) goto L5;
        return;
    L5:
        this.a = r3;
        removeAllViews();
        int r7 = this.c;
        if (r7 != 0) goto L8;
        post(new t(this, r2, r4, r6));
        return;
    L8:
        this.b = r7;
        Iterator r8 = r2.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        d((IBattleRivalTag) r8.next(), r4, r6);
        goto L10
    }

    public static /* synthetic */ void f(PkTagsContainerView r6, List r7, boolean r8, IRoom r9, int r10, String r12, int r13) {
        if ((r13 & 4) == 0) goto L5;
        r9 = null;
    L5:
        IRoom r2 = r9;
        if ((r13 & 8) == 0) goto L8;
        int r3 = 9;
    L10:
        if ((r13 & 16) == 0) goto L12;
        r12 = "";
    L12:
        r6.e(r7, r2, r3, r12, false);
        return;
    L8:
        r3 = r10;
        goto L10
    }
}
