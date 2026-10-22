package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import df6.q;
import df6.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\b\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameRoleView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/c3;", "roleInfo", "", "setRoleInfo", "getRoleInfo", "Landroid/view/View;", "getView", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getRoleNameView", "()Landroid/widget/TextView;", "roleNameView", "Lcom/bytedance/lighten/loader/SmartImageView;", "b", "getRoleIconView", "()Lcom/bytedance/lighten/loader/SmartImageView;", "roleIconView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameRoleView extends LinearLayout implements e {
    public final Lazy a;
    public final Lazy b;
    public String c;
    public String d;
    public c3 e;

    public HokGameRoleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HokGameRoleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final SmartImageView getRoleIconView() {
        return (SmartImageView) this.b.getValue();
    }

    private final TextView getRoleNameView() {
        return (TextView) this.a.getValue();
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setRoleInfo(null);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    public final c3 getRoleInfo() {
        return this.e;
    }

    public final void setRoleInfo(c3 r5) {
        String r0 = "";
        if (r5 != null) goto L6;
        this.e = r5;
        setVisibility(8);
        this.c = "";
        this.d = "";
        return;
    L6:
        String r1 = r5.a();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L40;
        String r3 = r5.b();
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L40;
        String r6 = r5.a();
        if (r6 != null) goto L25;
        r6 = "";
    L25:
        this.c = r6;
        String r7 = r5.b();
        if (r7 == null) goto L29;
        r0 = r7;
    L29:
        this.d = r0;
        if (this.c.length() <= 0) goto L32;
        boolean r8 = true;
    L33:
        if (r8 == true) goto L35;
    L119:
        boolean r9 = false;
    L120:
        if (r9 == false) goto L123;
        this.e = r5;
        setVisibility(0);
        int r10 = g.a;
        g.a(getRoleNameView().getPaint(), 500);
        getRoleNameView().setText(this.c);
        u r11 = q.e(this.d);
        CircleOptions.a r12 = new CircleOptions.a();
        r12.a = true;
        r11.o = new CircleOptions(r12);
        r11.c = getRoleIconView().getContext();
        r11.t = getRoleIconView();
        r11.b("game_sticker");
        r11.i = 2131250679;
        r11.d(new f("role_icon"));
        return;
    L123:
        return;
    L35:
        if (this.d.length() <= 0) goto L37;
        boolean r13 = true;
    L38:
        if (r13 == false) goto L119;
    L118:
        r9 = true;
        goto L120
    L37:
        r13 = false;
        goto L38
    L32:
        r8 = false;
        goto L33
    L17:
        if (r3.length() == 0) goto L20;
        r4 = false;
    L40:
        String r14 = r5.e();
        if (r14 != null) goto L43;
    L46:
        boolean r15 = true;
    L47:
        if (r15 == true) goto L74;
        String r16 = r5.f();
        if (r16 != null) goto L51;
    L54:
        boolean r17 = true;
    L55:
        if (r17 == true) goto L74;
        String r18 = r5.e();
        if (r18 != null) goto L59;
        r18 = "";
    L59:
        this.c = r18;
        String r19 = r5.f();
        if (r19 == null) goto L63;
        r0 = r19;
    L63:
        this.d = r0;
        if (this.c.length() <= 0) goto L66;
        boolean r20 = true;
    L67:
        if (r20 == false) goto L119;
        if (this.d.length() <= 0) goto L71;
        boolean r21 = true;
    L72:
        if (r21 == false) goto L119;
    L71:
        r21 = false;
        goto L72
    L66:
        r20 = false;
        goto L67
    L51:
        if (r16.length() == 0) goto L54;
        r17 = false;
    L74:
        String r22 = r5.d();
        if (r22 != null) goto L77;
    L80:
        boolean r23 = true;
    L81:
        if (r23 == true) goto L109;
        String r24 = r5.c();
        if (r24 != null) goto L85;
    L88:
        boolean r25 = true;
    L89:
        if (r25 == true) goto L109;
        String r26 = r5.d();
        if (r26 != null) goto L93;
        r26 = "";
    L93:
        this.c = r26;
        String r27 = r5.c();
        if (r27 == null) goto L97;
        r0 = r27;
    L97:
        this.d = r0;
        if (this.c.length() <= 0) goto L100;
        boolean r28 = true;
    L101:
        if (r28 == false) goto L119;
        if (this.d.length() <= 0) goto L105;
        boolean r29 = true;
    L106:
        if (r29 == false) goto L119;
    L105:
        r29 = false;
        goto L106
    L100:
        r28 = false;
        goto L101
    L85:
        if (r24.length() == 0) goto L88;
        r25 = false;
    L109:
        if (this.c.length() <= 0) goto L111;
        boolean r30 = true;
    L112:
        if (r30 == false) goto L119;
        if (this.d.length() <= 0) goto L116;
        boolean r31 = true;
    L117:
        if (r31 == false) goto L119;
    L116:
        r31 = false;
        goto L117
    L111:
        r30 = false;
        goto L112
    L77:
        if (r22.length() == 0) goto L80;
        r23 = false;
        goto L81
    L43:
        if (r14.length() == 0) goto L46;
        r15 = false;
        goto L47
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L13
    }

    public HokGameRoleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new HokGameRoleView$roleNameView$2(this));
        this.b = LazyKt.lazy(new HokGameRoleView$roleIconView$2(this));
        this.c = "";
        this.d = "";
        LayoutInflater.from(r2).inflate(2131566103, this);
    }

    public /* synthetic */ HokGameRoleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
