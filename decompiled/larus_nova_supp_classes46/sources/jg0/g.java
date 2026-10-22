package jg0;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.MultiLinkMicSeatGiftIconElement;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.theme.MultiLinkThemedCompetitionBusinessLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline.MultiLinkPreOnlineMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.ThemedCompetitionQuickInteractView;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import tf0.e;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class g<T extends tf0.e> implements f<T> {
    public final List<f<T>> a;
    public ViewGroup b;
    public final ViewGroup c;

    public static final class a {
    }

    static {
    }

    public final PointF c() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L3:
        View r2 = null;
        if (r0.hasNext() == false) goto L41;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L3;
        MultiLinkMicSeatGiftIconElement r3 = ((com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r1).m;
        if (r3 == null) goto L37;
        LinkMicQuickInteractView r4 = r3.c;
        if (r4 != null) goto L16;
        return null;
    L16:
        if (r4.getVisibility() != 0) goto L40;
        LinkMicQuickInteractView r5 = r3.c;
        if (r5 == null) goto L39;
        int[] r6 = new int[2];
        r5.f.getLocationOnScreen(r6);
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r7 = r5.n;
        View r8 = r7.f.a.getCurrentView();
        if ((r8 instanceof TextView) == false) goto L24;
        r2 = r8;
    L24:
        TextView r9 = (TextView) r2;
        if (r9 != null) goto L27;
        Pair r10 = new Pair(Integer.valueOf(r7.f.a.getCurrentView().getWidth()), Integer.valueOf(r7.f.a.getWidth()));
    L28:
        int r11 = ((Number) r10.getFirst()).intValue();
        if (r11 <= ((Number) r10.getSecond()).intValue()) goto L32;
        r6[0] = r6[0] - (r11 - r5.n.f.a.getWidth());
    L32:
        return new PointF(r6[0], r6[1]);
    L27:
        int r12 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r13 = View.MeasureSpec.makeMeasureSpec(0, 0);
        CharSequence r14 = r9.getText();
        r9.setText(r5.x);
        r9.measure(r12, r13);
        r7.f.a.measure(r12, r13);
        int r15 = r7.f.a.getMeasuredWidth();
        int r16 = r9.getMeasuredWidth();
        r9.setText(r14);
        r10 = new Pair(Integer.valueOf(r16), Integer.valueOf(r15));
        goto L28
    L39:
        return null;
    L40:
        return null;
    L37:
        return null;
    L8:
        return ((g) r1).c();
    L41:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    public final bd0.c f() {
        Iterator r1 = ((ArrayList) this.a).iterator();
    L3:
        Object r3 = null;
        if (r1.hasNext() == false) goto L59;
        f r2 = (f) r1.next();
        if ((r2 instanceof g) == true) goto L8;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) == true) goto L11;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == true) goto L18;
        if ((r2 instanceof MultiLinkPreOnlineMicSeatBasicLayer) == true) goto L22;
        if ((r2 instanceof e) == true) goto L26;
        if ((r2 instanceof ng0.b) == false) goto L3;
        ng0.b r4 = (ng0.b) r2;
        r4.getClass();
        VoiceChatRoomAnchorView r5 = r4.e;
        if (r5 == null) goto L33;
        View r6 = r5.a(2131389468);
    L34:
        MultiLinkGuestViewBinder.a r7 = r4.d;
        if (r7 == null) goto L43;
        ch0.e r8 = r7.k;
        if (r8 == null) goto L43;
        ILinkPlayerInfoBridge r9 = r8.a;
        if (r9 == null) goto L43;
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L43;
        String r11 = r10.getIdString();
    L44:
        MultiLinkGuestViewBinder.a r12 = r4.d;
        if (r12 == null) goto L58;
        ch0.e r13 = r12.k;
        if (r13 == null) goto L58;
        ILinkPlayerInfoBridge r14 = r13.a;
        if (r14 == null) goto L58;
        IBaseUser r15 = r14.getUser();
        if (r15 == null) goto L58;
        k r16 = je0.d.n(r15, AvatarType.AVATAR_THUMB.getValue());
        if (r16 == null) goto L58;
        List r17 = r16.getUrls();
        if (r17 == null) goto L58;
        r3 = (String) ListProtector.get(r17, 0);
    L58:
        return new bd0.c(r6, null, r11, false, 0.0f, 0.0f, r3, false, null, null, null, null, 4024);
    L43:
        r11 = null;
        goto L44
    L33:
        r6 = null;
        goto L34
    L26:
        e r18 = (e) r2;
        r18.i();
        return r18.f();
    L22:
        MultiLinkPreOnlineMicSeatBasicLayer r19 = (MultiLinkPreOnlineMicSeatBasicLayer) r2;
        r19.getClass();
        return new bd0.c(r19.d, null, null, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
    L18:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r20 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r2;
        r20.i();
        return r20.f();
    L11:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r21 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) r2;
        r21.getClass();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r22 = r21.i;
        if (r22 == null) goto L15;
        r3 = r22.j;
    L15:
        return new bd0.c(r3, null, null, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
    L8:
        return ((g) r2).f();
    L59:
        return null;
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b g() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) == false) goto L4;
        return (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) r1;
    L8:
        return ((g) r1).g();
    L13:
        return null;
    }

    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g h() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r2 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r1;
        if (r2.z() == false) goto L4;
        return r2;
    L8:
        return ((g) r1).h();
    L14:
        return null;
    }

    @Override // jg0.f
    public final View l() {
        View r0 = LayoutInflater.from(this.c.getContext()).inflate(2131566329, this.c, false);
        if (r0 == null) goto L13;
        ViewGroup r1 = (ViewGroup) r0;
        this.b = r1;
        Intrinsics.checkNotNull(r1);
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.width = -1;
        r2.height = -1;
        Iterator r3 = ((ArrayList) this.a).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        View r4 = ((f) r3.next()).l();
        if (r4 == null) goto L6;
        ViewGroup r5 = this.b;
        Intrinsics.checkNotNull(r5);
        r5.addView(r4);
        goto L6
    L10:
        ViewGroup r6 = this.b;
        Intrinsics.checkNotNull(r6);
        r6.setClipChildren(false);
        this.c.setClipChildren(false);
        ViewGroup r7 = this.b;
        Intrinsics.checkNotNull(r7);
        return r7;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final ig0.b n() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof ig0.b) == false) goto L4;
        return (ig0.b) r1;
    L8:
        return ((g) r1).n();
    L13:
        return null;
    }

    public final MultiLinkPreOnlineMicSeatBasicLayer o() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof MultiLinkPreOnlineMicSeatBasicLayer) == false) goto L4;
        return (MultiLinkPreOnlineMicSeatBasicLayer) r1;
    L8:
        return ((g) r1).o();
    L13:
        return null;
    }

    @Override // jg0.f
    public final void onDetach() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onDetach();
        goto L4
    }

    public final View p() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r2 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r1;
        r2.i();
        return r2.x();
    L8:
        return ((g) r1).p();
    L13:
        return null;
    }

    public final Integer q() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) == false) goto L4;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g r2 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g) r1;
        r2.i();
        return r2.y();
    L8:
        return ((g) r1).q();
    L13:
        return null;
    }

    public final og0.a r() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof og0.a) == false) goto L4;
        return (og0.a) r1;
    L8:
        return ((g) r1).r();
    L13:
        return null;
    }

    public final pg0.e s() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof pg0.e) == false) goto L4;
        return (pg0.e) r1;
    L8:
        return ((g) r1).s();
    L13:
        return null;
    }

    public final PointF t() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L3:
        View r2 = null;
        if (r0.hasNext() == false) goto L45;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof MultiLinkThemedCompetitionBusinessLayer) == false) goto L3;
        MultiLinkThemedCompetitionBusinessLayer r3 = (MultiLinkThemedCompetitionBusinessLayer) r1;
        ThemedCompetitionQuickInteractView r4 = r3.f;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L15:
        if (r4.getVisibility() != 0) goto L44;
        ThemedCompetitionQuickInteractView r5 = r3.f;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("themedCompetitionScore");
    L20:
        int r6 = r3.h;
        int[] r7 = new int[2];
        r5.d.getLocationOnScreen(r7);
        if (r6 == 5) goto L23;
        if (r6 == 12) goto L23;
    L39:
        return new PointF(r7[0], r7[1]);
    L23:
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.a r8 = r5.i;
        View r9 = r8.f.a.getCurrentView();
        if ((r9 instanceof TextView) == false) goto L27;
        r2 = r9;
    L27:
        TextView r10 = (TextView) r2;
        if (r10 != null) goto L30;
        int r11 = r8.f.a.getCurrentView().getWidth();
    L32:
        if (r11 <= r5.i.f.a.getWidth()) goto L39;
        if (r6 == 5) goto L37;
        if (r6 != 12) goto L39;
        r7[0] = r7[0] - (r11 - r5.i.f.a.getWidth());
        goto L39
    L37:
        r7[0] = r7[0] - ((r11 - r5.i.f.a.getWidth()) / 2);
        goto L39
    L30:
        int r12 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r13 = View.MeasureSpec.makeMeasureSpec(0, 0);
        CharSequence r14 = r10.getText();
        r10.setText(r5.j);
        r10.measure(r12, r13);
        int r15 = r10.getMeasuredWidth();
        r10.setText(r14);
        r11 = r15;
        goto L32
    L44:
        return null;
    L8:
        return ((g) r1).t();
    L45:
        return null;
    }

    public final MultiLinkThemedCompetitionBusinessLayer u() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof MultiLinkThemedCompetitionBusinessLayer) == false) goto L4;
        return (MultiLinkThemedCompetitionBusinessLayer) r1;
    L8:
        return ((g) r1).u();
    L13:
        return null;
    }

    public g(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        this.c = r2;
        this.a = new ArrayList();
    }

    @Override // jg0.f
    public void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).a(r3);
        goto L4
    }

    public final void b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "layer");
        ((ArrayList) this.a).add(r2);
    }

    @Override // jg0.f
    public final void j(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).j(r3);
        goto L4
    }

    public final View m(int r4) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L8;
        if ((r1 instanceof jg0.a) == false) goto L4;
        View r2 = ((jg0.a) r1).m(r4);
        if (r2 == null) goto L4;
        return r2;
    L8:
        return ((g) r1).m(r4);
    L14:
        return null;
    }

    public final void x(int r3) {
        ViewGroup r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(r3);
    L5:
        List<f<T>> r1 = this.a;
        if (r1 == null) goto L13;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L19;
        View r4 = ((f) r2.next()).l();
        if (r4 == null) goto L9;
        r4.setVisibility(r3);
        goto L9
    L19:
        return;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        v((tf0.e) r1, r2);
    }

    public void v(T r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).d(r3, r4);
        goto L4
    }

    public final void e(int r4, p r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "action");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        f r1 = (f) r0.next();
        if ((r1 instanceof g) == true) goto L7;
        if ((r1 instanceof d) == false) goto L4;
        ((d) r1).e(r4, r5, r6);
        goto L4
    L7:
        ((g) r1).e(r4, r5, r6);
        return;
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        w((tf0.e) r1, r2, r3);
    }

    public void w(T r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "itemData");
        Intrinsics.checkNotNullParameter(r5, "payload");
        Iterator r0 = ((ArrayList) this.a).iterator();     // Catch: Exception -> L9
    L5:
        if (r0.hasNext() == false) goto L14;
        ((f) r0.next()).k(r3, r4, r5);     // Catch: Exception -> L9
    L14:
        return;
    }
}
