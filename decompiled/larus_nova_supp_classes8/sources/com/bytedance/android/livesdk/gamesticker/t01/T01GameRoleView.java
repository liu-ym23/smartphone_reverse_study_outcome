package com.bytedance.android.livesdk.gamesticker.t01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.t3;
import com.bytedance.android.livesdk.gamesticker.hok.f;
import com.bytedance.android.livesdk.gamesticker.hok.g;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import df6.q;
import df6.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/t01/T01GameRoleView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdk/chatroom/model/t3;", "roleInfo", "", "setRoleInfo", "Landroid/view/View;", "getView", "getRoleInfo", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getRoleNameView", "()Landroid/widget/TextView;", "roleNameView", "Lcom/bytedance/lighten/loader/SmartImageView;", "b", "getRoleIconView", "()Lcom/bytedance/lighten/loader/SmartImageView;", "roleIconView", "c", "getRoleTagView", "roleTagView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class T01GameRoleView extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public String d;
    public String e;
    public String f;
    public t3 g;

    public T01GameRoleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public T01GameRoleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final SmartImageView getRoleIconView() {
        return (SmartImageView) this.b.getValue();
    }

    private final TextView getRoleNameView() {
        return (TextView) this.a.getValue();
    }

    private final TextView getRoleTagView() {
        return (TextView) this.c.getValue();
    }

    public View getView() {
        return this;
    }

    public final t3 getRoleInfo() {
        return this.g;
    }

    public final void setRoleInfo(t3 r6) {
        int r0 = 8;
        String r1 = "";
        if (r6 != null) goto L6;
        this.g = r6;
        setVisibility(8);
        this.d = "";
        this.e = "";
        return;
    L6:
        String r2 = r6.b();
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L34;
        String r4 = r6.a();
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == true) goto L34;
        String r7 = r6.b();
        if (r7 != null) goto L26;
        r7 = "";
    L26:
        this.d = r7;
        String r8 = r6.a();
        if (r8 != null) goto L29;
        r8 = "";
    L29:
        this.e = r8;
        String r9 = r6.c();
        if (r9 == null) goto L33;
        r1 = r9;
    L33:
        this.f = r1;
        boolean r10 = true;
    L35:
        if (r10 == false) goto L44;
        this.g = r6;
        setVisibility(0);
        int r11 = g.a;
        g.a(getRoleNameView().getPaint(), 500);
        getRoleNameView().setText(this.d);
        getRoleTagView().setText(this.f);
        TextView r12 = getRoleTagView();
        if (this.f.length() <= 0) goto L39;
        boolean r13 = true;
    L40:
        if (r13 == false) goto L42;
        r0 = 0;
    L42:
        r12.setVisibility(r0);
        u r14 = q.e(this.e);
        CircleOptions.a r15 = new CircleOptions.a();
        r15.a = true;
        r14.o = new CircleOptions(r15);
        r14.c = getRoleIconView().getContext();
        r14.t = getRoleIconView();
        r14.b("game_sticker");
        r14.i = 2131250679;
        r14.d(new f("role_icon"));
        return;
    L39:
        r13 = false;
        goto L40
    L44:
        return;
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
    L34:
        r10 = false;
        goto L35
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    public T01GameRoleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new T01GameRoleView$roleNameView$2(this));
        this.b = LazyKt.lazy(new T01GameRoleView$roleIconView$2(this));
        this.c = LazyKt.lazy(new T01GameRoleView$roleTagView$2(this));
        this.d = "";
        this.e = "";
        this.f = "";
        LayoutInflater.from(r2).inflate(2131566110, this);
    }

    public /* synthetic */ T01GameRoleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
