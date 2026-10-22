package yca;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.card.databinding.ObricCardMenuBinding;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import z19.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static final d a = null;

    public interface a {
        void dismiss();
    }

    static {
        a = new d();
    }

    public d() {
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [yca.a] */
    public static e a(d r18, RemoteCardContainer r19, final q0 r20, List r21, final com.obric.assistant.remote_card_container.b r22, final com.obric.assistant.remote_card_container.c r23) {
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "longClickView");
        Intrinsics.checkNotNullParameter(r21, "items");
        Intrinsics.checkNotNullParameter(r22, "onItemSelectedListener");
        Intrinsics.checkNotNullParameter(r23, "onMenuDismiss");
        if (r20 != null) goto L5;
        FLogger.a.i("MenuHelper", "showMenu: adapter is null");
        return null;
    L5:
        ArrayList r4 = (ArrayList) r21;
        if (r4.isEmpty() == false) goto L8;
        FLogger.a.w("MenuHelper", "showMenu: items is empty");
        return null;
    L8:
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        Context r3 = r19.getContext();
        final ?? r5 = new yca.a(r12, r22);
        LayoutInflater r1 = LayoutInflater.from(r3);
        boolean r13 = false;
        View r6 = r1.inflate(2131563968, null, false);
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131375718);
        if (r8 == null) goto L74;
        RelativeLayout r7 = (RelativeLayout) r6;
        ObricCardMenuBinding r9 = new ObricCardMenuBinding(r7, r8, r7);
        r7.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        Iterator r0 = r21.iterator();
        final int r10 = 0;
    L12:
        if (r0.hasNext() == false) goto L37;
        Object r11 = r0.next();
        int r16 = r10 + 1;
        if (r10 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        String r14 = (String) r11;
        LinearLayout r15 = r9.b;
        View r17 = r1.inflate(2131563969, r15, r13);
        r15.addView(r17);
        RelativeLayout r110 = (RelativeLayout) r17;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r17, 2131389991);
        if (r111 == null) goto L36;
        Iterator r112 = r0;
        if (r4.size() != 1) goto L21;
        int r113 = 2131238869;
    L27:
        r110.setBackgroundResource(r113);
        r111.setText(r14);
        r110.setOnClickListener(new c(r5, r10));
        if (r10 == (r4.size() - 1)) goto L34;
        LinearLayout r2 = r9.b;
        a.getClass();
        Drawable r24 = ContextCompat.getDrawable(r3, 2131240110);
        if (r24 == null) goto L32;
        int r114 = r24.getIntrinsicHeight();
    L33:
        View r25 = new View(r3);
        r25.setBackground(r24);
        r25.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, r114));
        r2.addView(r25);
        goto L34
    L32:
        r114 = 1;
    L34:
        r10 = r16;
        r0 = r112;
        r13 = false;
        goto L12
    L21:
        if (r10 != 0) goto L24;
        r113 = 2131238839;
        goto L27
    L24:
        if (r10 != (r4.size() - 1)) goto L26;
        r113 = 2131238849;
        goto L27
    L26:
        r113 = 2131238859;
        goto L27
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(2131389991)));
    L37:
        RelativeLayout r115 = r9.c;
        final ViewGroup r116 = null;
        r12.element = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r19, r115, false, null, null, null, new b(r23, r20, r116), 60);
        if ((r19 instanceof j) == false) goto L40;
        j r26 = (j) r19;
    L50:
        if (r26 == null) goto L54;
        Float r27 = r26.getLastMotionX();
        if (r27 == null) goto L54;
        int r28 = (int) r27.floatValue();
    L55:
        if (r26 == null) goto L59;
        Float r29 = r26.getLastMotionY();
        if (r29 == null) goto L59;
        int r30 = (int) r29.floatValue();
    L61:
        if (Build.VERSION.SDK_INT >= 26) goto L67;
        Balloon r31 = (Balloon) r12.element;
        ChatMessageList r32 = r20.B7();
        if (r32 == null) goto L65;
        Point r33 = e1.n(r19, r32);
        int r34 = 0;
        r115.measure(0, 0);
        r30 = Math.max(r115.getMeasuredHeight() - r33.y, r30);
    L66:
        r31.v(r19, r34, r30);
    L68:
        ChatMessageList r35 = r20.B7();
        if (r35 == null) goto L72;
        r35.requestDisallowInterceptTouchEvent(true);
    L72:
        return new e(r12);
    L65:
        r34 = 0;
        goto L66
    L67:
        ((Balloon) r12.element).v(r19, r28, r30);
    L59:
        r30 = r19.getHeight() / 2;
    L54:
        r28 = r19.getWidth() / 2;
        goto L55
    L40:
        j r36 = r19.getParent();
        if ((r36 instanceof ViewGroup) == false) goto L43;
        ViewGroup r37 = (ViewGroup) r36;
    L44:
        if (r37 == null) goto L49;
        if ((r37 instanceof j) == true) goto L47;
        ViewParent r38 = r37.getParent();
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type android.view.ViewGroup");
        r37 = (ViewGroup) r38;
        goto L44
    L47:
        r26 = (j) r37;
        goto L50
    L49:
        r26 = null;
        goto L50
    L43:
        r37 = null;
        goto L44
    L74:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(2131375718)));
    }
}
