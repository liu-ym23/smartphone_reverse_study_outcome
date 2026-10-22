package com.larus.bmhome.chat.component.bottom.core.follow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.input.swipe.InputSwipePanelService;
import com.larus.bmhome.clarification.x1;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.logger.FLogger;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import jd8.g;
import jd8.l;
import jd8.m;
import jd8.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.c7;
import va8.o;
import va8.p;
import ze8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/follow/InputSwipePanelServiceImpl;", "Lcom/larus/bmhome/chat/input/swipe/InputSwipePanelService;", "<init>", "()V", "show", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelSession;", "fragment", "Landroidx/fragment/app/Fragment;", "mirrorRoot", "Landroid/view/ViewGroup;", "inputDelegate", "Landroid/view/View;", "adapter", "Lcom/larus/bmhome/chat/input/swipe/IInputSwipePanelAdapter;", "jointStyle", "", "maxPanelHeightPx", "", "showIndicator", "isSwipeTransitionActive", "viewInWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InputSwipePanelServiceImpl implements InputSwipePanelService {
    public InputSwipePanelServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.input.swipe.InputSwipePanelService
    public final boolean a(ChatMessageList r6) {
        Intrinsics.checkNotNullParameter(r6, "viewInWindow");
        WeakHashMap<View, a> r1 = a.o;
        Intrinsics.checkNotNullParameter(r6, "viewInWindow");
        IBinder r7 = r6.getWindowToken();
        if (r7 == null) goto L33;
        Set<Map.Entry<View, a>> r2 = a.o.entrySet();
        if ((r2 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L35;
        Map.Entry r4 = (Map.Entry) r3.next();
        Intrinsics.checkNotNull(r4);
        View r5 = (View) r4.getKey();
        a r8 = (a) r4.getValue();
        if (Intrinsics.areEqual(r5.getWindowToken(), r7) == false) goto L24;
        l r9 = r8.d;
        if (r9.n == false) goto L18;
    L21:
        boolean r10 = true;
    L22:
        if (r10 == false) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L12;
        return true;
    L18:
        if (r9.q == true) goto L21;
        r10 = false;
    L24:
        r11 = false;
        goto L25
    L35:
        return false;
    L8:
        if (r2.isEmpty() == false) goto L10;
        return false;
    L33:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [jd8.n] */
    @Override // com.larus.bmhome.chat.input.swipe.InputSwipePanelService
    public final b b(Fragment r19, ViewGroup r20, View r21, x1 r22, boolean r23, int r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r19, "fragment");
        Intrinsics.checkNotNullParameter(r20, "mirrorRoot");
        Intrinsics.checkNotNullParameter(r21, "inputDelegate");
        Intrinsics.checkNotNullParameter(r22, "adapter");
        final ICoreInputAbility r11 = s1a.a.g(r19).getAbility(ICoreInputAbility.class);
        if (r11 != null) goto L5;
        return null;
    L5:
        final o r13 = s1a.a.g(r19).getAbility(o.class);
        if (r13 != null) goto L8;
        return null;
    L8:
        final p r1 = s1a.a.g(r19).getAbility(p.class);
        WeakHashMap<View, a> r4 = a.o;
        if (r1 == null) goto L11;
        m r7 = new m(r1);
    L12:
        Intrinsics.checkNotNullParameter(r20, "mirrorRoot");
        Intrinsics.checkNotNullParameter(r21, "inputDelegate");
        Intrinsics.checkNotNullParameter(r22, "adapter");
        if (r22.getPageCount() > 0) goto L16;
        return null;
    L16:
        if (r22.getPageCount() <= 10) goto L18;
        FLogger.a.w("InputSwipePanelSession", "[show] pageCount=" + r22.getPageCount() + " > 10, reject");
        return null;
    L18:
        WeakHashMap<View, a> r15 = a.o;
        a r0 = r15.get(r21);
        if (r0 == null) goto L21;
        r0.dismiss();
    L21:
        g r6 = new g(r20, r21, r11, r13);
        l r5 = new l(r20.getContext(), r22, r6, r24, new n(r13, r11), r20, r7);
        if (r25 == true) goto L24;
    L29:
        l r10 = r5;
        DrawableIndicator r8 = null;
    L31:
        if (r13.TV(r10, View.generateViewId()) != true) goto L33;
        boolean r2 = true;
    L34:
        if (r2 == true) goto L36;
        FLogger.a.w("InputSwipePanelSession", "[show] failed to mount exclusive input-above panel");
        return null;
    L36:
        DrawableIndicator r12 = r8;
        final a r14 = new a(r13, r11, r6, r10, r23, r21, r12);
        r15.put(r21, r14);
        if (r12 == null) goto L39;
        r13.t50(r12, View.generateViewId());
    L39:
        if (r23 == false) goto L62;
        Context r3 = r10.getContext();
        g9.b r9 = r14.i.a;
        r9.getClass();
        View r16 = r9.a;
        if (r16 == null) goto L43;
        View r17 = r16.findViewById(2131369229);
    L44:
        if (r17 != null) goto L46;
        Boolean r18 = null;
    L51:
        r14.j = r18;
        g9.b r26 = r14.i.a;
        r26.getClass();
        View r27 = r26.a;
        if (r27 == null) goto L54;
        View r28 = r27.findViewById(2131375335);
    L55:
        if (r28 == null) goto L61;
        r14.k = r28.getBackground();
        View r29 = r21.findViewById(2131392769);
        if (r29 == null) goto L59;
        Drawable r30 = r29.getBackground();
    L60:
        r14.l = r30;
        r14.m = true;
        goto L61
    L59:
        r30 = null;
    L61:
        r13.p9(c.b(2130970690, r3, 2131239155));
        r13.e10(true);
        goto L62
    L54:
        r28 = null;
        goto L55
    L46:
        if (r17.getVisibility() != 0) goto L48;
        boolean r31 = true;
    L49:
        r18 = Boolean.valueOf(r31);
        goto L51
    L48:
        r31 = false;
        goto L49
    L43:
        r17 = null;
    L62:
        r20.post(new jd8.o(r14));
        return r14;
    L33:
        r2 = false;
        goto L34
    L24:
        if (r22.getPageCount() <= 1) goto L29;
        DrawableIndicator r32 = new DrawableIndicator(r20.getContext(), null, 6, 0);
        r32.d(2131242930, 2131242929);
        int r33 = c7.b(6);
        if (r33 < 0) goto L28;
        r32.g = r33;
        r32.postInvalidate();
    L28:
        Intrinsics.checkNotNullParameter(r32, "indicator");
        r10 = r5;
        r32.setupWithViewPager(r10.f);
        r8 = r32;
        goto L31
    L11:
        r7 = 0;
        goto L12
    }
}
