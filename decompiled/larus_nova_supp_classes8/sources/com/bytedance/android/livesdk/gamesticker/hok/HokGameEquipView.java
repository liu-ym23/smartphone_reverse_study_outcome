package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.i0;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import df6.q;
import df6.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameEquipView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/j0;", "equipState", "", "setEquipState", "Landroid/view/View;", "getView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameEquipView extends LinearLayout implements e {
    public final List<a> a;

    public static final class a {
        public final SmartImageView a;

        public a(SmartImageView r2) {
            Intrinsics.checkNotNullParameter(r2, "equipIconView");
            this.a = r2;
        }
    }

    public HokGameEquipView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HokGameEquipView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setEquipState(null);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    public final void setEquipState(j0 r10) {
        if (r10 == null) goto L52;
        long r2 = 0;
        if (r10.a() == 0) goto L52;
        if (((ArrayList) this.a).size() != 0) goto L12;
        long r0 = r10.a();
    L10:
        if (r2 >= r0) goto L12;
        SmartImageView r4 = new SmartImageView(getContext());
        List<a> r5 = this.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new a(r4));
        r2 = r2 + 1;
    L12:
        ArrayList r1 = new ArrayList();
        List r11 = r10.b();
        if (r11 != null) goto L15;
        r11 = CollectionsKt.emptyList();
    L15:
        Iterator r12 = r11.iterator();
    L16:
        int r3 = 0;
        if (r12.hasNext() == false) goto L24;
        i0 r7 = (i0) r12.next();
        int r8 = (int) r7.a();
    L19:
        if (r3 >= r8) goto L16;
        String r9 = r7.b();
        if (r9 == null) goto L23;
        r1.add(r9);
    L23:
        r3 = r3 + 1;
        goto L19
    L24:
        int r13 = ((ArrayList) this.a).size();
        int r14 = 0;
    L26:
        if (r14 >= r13) goto L43;
        a r15 = (a) ListProtector.get(this.a, r14);
        if (r14 < r1.size()) goto L30;
        String r16 = null;
    L31:
        r15.getClass();
        if (r16 != null) goto L35;
        u r17 = q.a.load(2131250679);
        r17.c = r15.a.getContext();
        r17.t = r15.a;
        r17.b("game_sticker");
        r17.c();
        r15.a.setBackground(s1.m(2131250679));
    L41:
        r14 = r14 + 1;
        goto L26
    L35:
        if (r16.length() <= 0) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L40;
        u r19 = q.e(r16);
        CircleOptions.a r20 = new CircleOptions.a();
        r20.a = true;
        r19.o = new CircleOptions(r20);
        r19.c = r15.a.getContext();
        r19.t = r15.a;
        r19.b("game_sticker");
        r19.i = 2131250679;
        r19.d(new f("equip_icon"));
        goto L41
    L40:
        u r21 = q.a.load(2131250679);
        r21.c = r15.a.getContext();
        r21.t = r15.a;
        r21.b("game_sticker");
        r21.c();
        r15.a.setBackground(s1.m(2131250679));
        goto L41
    L37:
        r18 = false;
        goto L38
    L30:
        r16 = (String) ListProtector.get(r1, r14);
        goto L31
    L43:
        if (getChildCount() != 0) goto L50;
        int r110 = ((ArrayList) this.a).size();
        int r22 = 0;
    L45:
        if (r22 >= r110) goto L50;
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(s1.f(20.0f), s1.f(20.0f));
        float r24 = 2.0f;
        r23.leftMargin = s1.f(2.0f);
        if (r22 != (((ArrayList) this.a).size() - 1)) goto L49;
        r24 = 12.0f;
    L49:
        r23.rightMargin = s1.f(r24);
        r23.gravity = 16;
        addView(((a) ListProtector.get(this.a, r22)).a, r23);
        r22 = r22 + 1;
    L50:
        setVisibility(0);
        return;
    L52:
        setVisibility(8);
    }

    public HokGameEquipView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
    }

    public /* synthetic */ HokGameEquipView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
