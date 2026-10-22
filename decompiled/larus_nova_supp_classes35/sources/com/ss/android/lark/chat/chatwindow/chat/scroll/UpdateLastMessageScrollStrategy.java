package com.ss.android.lark.chat.chatwindow.chat.scroll;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.utils.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import s2b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UpdateLastMessageScrollStrategy extends ScrollBottomController.e {
    public static final /* synthetic */ int c = 0;
    public int b;

    public static final class a {
    }

    public static final class b implements g2b.c {
        public final /* synthetic */ int a;

        @Override // g2b.c
        public final int b() {
            return this.a;
        }

        public b(int r1) {
            this.a = r1;
        }

        @Override // g2b.c
        public final View a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            return p.a(r2);
        }
    }

    public static final class c implements g2b.c {
        public final /* synthetic */ int a;

        @Override // g2b.c
        public final int b() {
            return this.a;
        }

        public c(int r1) {
            this.a = r1;
        }

        @Override // g2b.c
        public final View a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            return p.a(r2);
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.ScrollBottomController.e
    public final Function2<y6b.c<?>, y6b.c<?>, Boolean> a() {
        return new UpdateLastMessageScrollStrategy$getScrollCondition$1(this);
    }

    public UpdateLastMessageScrollStrategy() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.ScrollBottomController.e
    public final void c(ScrollBottomController.d r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        int r0 = r11.e;
        int r1 = r11.d;
        int r2 = r11.b;
        y6b.c<?> r12 = r11.f;
        if (r12 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("targetItem");
        r12 = null;
    L6:
        MessageFoldDetail r3 = r12.G;
        int r4 = 0;
        if (r1 > r2) goto L10;
        if (r2 > r0) goto L10;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L16;
        Log.i("UpdateLastMessageScroll", "position is not visible method return");
        return;
    L16:
        if (r0 == r2) goto L18;
        if (r3 == null) goto L40;
        long r8 = (r3.getLastMessagePosition() - r3.getRootMessagePosition()) + 1;
        Log.d("UpdateLastMessageScroll", "firstVisiblePosition is " + r1 + " , lastVisiblePosition is " + r0 + ", fold length is " + r8);
        if ((((long) r1) + r8) < r0) goto L41;
        Log.d("UpdateLastMessageScroll", "onItemRangeChanged: message is hit fold , scroll to message");
        n r13 = b().a;
        n.a r5 = new n.a();
        r5.a = new c(r2);
        r5.c = 100;
        r5.d = true;
        r13.a(new n.c(r5));
        return;
    L41:
        return;
    L40:
        return;
    L18:
        if (r12.K == MessageStreamStatus.Transport) goto L20;
    L33:
        n r14 = b().a;
        n.a r7 = new n.a();
        r7.a = new b(r2);
        r7.c = 100;
        r7.b = 80;
        r7.d = true;
        r14.a(new n.c(r7));
        return;
    L20:
        if (this.b != 0) goto L22;
        this.b = UIUtils.dp2px(LarkContext.getApplication(), 60.0f);
    L22:
        RecyclerView r15 = b().d();
        n r9 = b().a;
        if ((r9.a.computeVerticalScrollExtent() + r9.a.computeVerticalScrollOffset()) < r9.a.computeVerticalScrollRange()) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == true) goto L30;
        r4 = r15.computeVerticalScrollRange() - (r15.computeVerticalScrollExtent() + r15.computeVerticalScrollOffset());
    L30:
        if (r4 <= this.b) goto L33;
        Log.d("UpdateLastMessageScroll", "bottomHiddenOffset > streamingMessageScrollThreshold, method return");
        return;
    L25:
        r10 = false;
    L10:
        r6 = false;
        goto L12
    }

    public static boolean d(Map r5, Map r6) {
        if (r5.size() == r6.size()) goto L5;
        return true;
    L5:
        Iterator r7 = ((LinkedHashMap) r5).entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r0 = (Map.Entry) r7.next();
        String r1 = (String) r0.getKey();
        xcb.b r2 = (xcb.b) r0.getValue();
        xcb.b r3 = (xcb.b) ((LinkedHashMap) r6).get(r1);
        if (r3 == null) goto L10;
        if (r3.a.isContentSame(r2.a) == false) goto L13;
        if (Intrinsics.areEqual(r3.b.h, r2.b.h) == true) goto L7;
        return true;
    L13:
        return true;
    L10:
        return true;
    L17:
        return false;
    }
}
