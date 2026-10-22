package com.ss.android.lark.flow.chat.page.flow.plugin;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMessageEditPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {
    public static final /* synthetic */ int l = 0;
    public IMessageListComponent g;
    public IKeyboardComponent h;
    public volatile boolean i;
    public View j;
    public final b k;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ FlowMessageEditPlugin a;

        public b(FlowMessageEditPlugin r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            if (r5 != null) goto L5;
            return false;
        L5:
            int r6 = r5.getAction();
            if (r6 != 1) goto L8;
        L10:
            IKeyboardComponent r7 = this.a.h;
            if (r7 == null) goto L15;
            com.ss.android.lark.keyboard.b r8 = r7.n();
            if (r8 == null) goto L15;
            cya.d r9 = com.ss.android.lark.keyboard.a.a(r8);
        L16:
            if (r9 == null) goto L20;
            cya.h r0 = r9.d();
            if (r0 == null) goto L20;
            Integer r1 = Integer.valueOf(r0.a());
        L22:
            if ((r1 instanceof Integer) == true) goto L25;
        L35:
            return true;
        L25:
            if (4 != r1.intValue()) goto L35;
            Log.i("FlowMessageEditPlugin", "CLEAR_REEDIT_DRAFT");
            if (r9 == null) goto L33;
            cya.h r2 = r9.d();
            if (r2 == null) goto L33;
            n r3 = r2.a;
            if (r3 == null) goto L33;
            r3.b(com.ss.android.lark.keyboard.inputstate.b.h, Boolean.TRUE);
        L33:
            if (r9 == null) goto L35;
            r9.pop();
        L20:
            r1 = cya.h.b;
        L15:
            r9 = null;
            goto L16
        L8:
            if (r6 == 2) goto L10;
            goto L10
        }
    }

    static {
    }

    public FlowMessageEditPlugin() {
        this.k = new b(this);
    }

    public static final void F(FlowMessageEditPlugin r1, boolean r2) {
        if (r2 == false) goto L6;
        View r3 = r1.j;
        if (r3 == null) goto L10;
        r3.setVisibility(0);
        r3.setClickable(true);
        r3.setOnTouchListener(r1.k);
        return;
    L10:
        return;
    L6:
        View r4 = r1.j;
        if (r4 == null) goto L12;
        r4.setVisibility(8);
        r4.setOnTouchListener(null);
        return;
    }

    public final void C(final com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2, i7b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "chatApp");
        Intrinsics.checkNotNullParameter(r3, "initData");
        super/*com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin*/.C(r2, r3);
        IMessageListComponent r4 = r2.a(IMessageListComponent.class);
        this.g = r4;
        if (r4 == null) goto L5;
        r4.W2();
    L5:
        IMessageListComponent r5 = this.g;
        View r0 = null;
        if (r5 == null) goto L8;
        RelativeLayout r6 = r5.UI();
    L9:
        if (r6 == null) goto L11;
        r0 = r6.findViewById(2131365558);
    L11:
        this.j = r0;
        IKeyboardComponent r7 = r2.a(IKeyboardComponent.class);
        this.h = r7;
        if (r7 == null) goto L15;
        r7.m7(new FlowMessageEditPlugin$onCreate$1$1(r2, this));
        return;
    L15:
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void G(boolean r11, String r12) {
        IMessageListComponent r0 = this.g;
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.getMessageList();
        if (r1 == null) goto L7;
        List r2 = (List) r1.getValue();
    L8:
        if (r2 != null) goto L10;
        return;
    L10:
        boolean r3 = false;
        if (r11 == false) goto L46;
        if (r12 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
        return;
    L21:
        Iterator r5 = r2.iterator();
        int r6 = 0;
        int r7 = -1;
    L23:
        if (r5.hasNext() == false) goto L31;
        Object r8 = r5.next();
        int r9 = r6 + 1;
        if (r6 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        y6b.c r10 = (y6b.c) r8;
        String r13 = r10.c;
        if (Intrinsics.areEqual(r13, r12) == false) goto L30;
        r3 = r10.Q2;
        r7 = r6;
    L30:
        r10.L2 = !Intrinsics.areEqual(r13, r12);
        Log.i("FlowMessageEditPlugin", "updateMessage, setInEditMode: " + r10.c);
        r6 = r9;
        goto L23
    L31:
        if (r3 == false) goto L51;
        if (r7 > 0) goto L34;
        return;
    L34:
        if (r7 < r2.size()) goto L36;
        return;
    L36:
        if (((y6b.c) ListProtector.get(r2, r7)).Q2 == false) goto L60;
        int r14 = r7 - 1;
        if (r14 < 0) goto L61;
    L39:
        int r15 = r14 - 1;
        y6b.c r16 = (y6b.c) ListProtector.get(r2, r14);
        if (r16.Q2 == false) goto L41;
        if (r15 < 0) goto L64;
        r14 = r15;
        goto L39
    L64:
        return;
    L41:
        r16.M2 = true;
        Log.i("FlowMessageEditPlugin", "updateMessage, setHighLightAvatarInEditMode: " + r16.c);
        return;
    L61:
        return;
    L60:
        return;
    L51:
        return;
    L15:
        if (r12.length() == 0) goto L18;
        r4 = false;
        goto L19
    L46:
        if (this.i == false) goto L63;
        Log.i("FlowMessageEditPlugin", "updateMessage, isCurInEditMode: true, isInEditMode: false");
        Iterator r17 = r2.iterator();
    L49:
        if (r17.hasNext() == false) goto L65;
        y6b.c r18 = (y6b.c) r17.next();
        r18.L2 = false;
        r18.M2 = false;
        goto L49
    L65:
        return;
    L63:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
