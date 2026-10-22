package s2c;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import z5c.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.ss.android.lark.newemoji.emoji_list.adapter.e a;
    public final /* synthetic */ ReactionPanelFacade b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.b.n.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int r1 = this.b.n.getMeasuredWidth();
        ReactionPanelFacade r2 = this.b;
        int r9 = v2c.a.a(r2.a, 28.0f);
        int r7 = v2c.a.a(r2.a, 42.0f);
        int r6 = v2c.a.a(r2.a, 42.0f);
        int r3 = v2c.a.a(r2.a, 4.0f) + (r2.g / 84);
        int r4 = r1 - (r6 * 7);
        int r5 = (r4 - (r3 * 2)) / 7;
        int r8 = (r1 - ((r6 + r5) * 7)) - r3;
        if (r8 >= r5) goto L5;
        r3 = r4 / 8;
        int r10 = r3;
    L6:
        if (r8 <= 0) goto L8;
        r8 = r8 - r10;
    L8:
        int r11 = r8;
        int r12 = r1 - r3;
        if (r11 <= 0) goto L11;
        r12 = r12 - r11;
    L11:
        ssb.a r13 = new ssb.a(r6, r7, r10, r9, r12, r3, r11, 7);
        View r14 = this.b.n;
        r14.setPadding(r3, r14.getPaddingTop(), r11, this.b.n.getPaddingBottom());
        this.b.o.setItemParams(r13);
        this.b.o.setLines(1);
        ReactionPanelFacade r15 = this.b;
        RecentUsedEmojiView r16 = r15.o;
        List<String> r17 = r15.i;
        s5c.a r18 = n3.e;
        ArrayList r19 = new ArrayList();
        if (r18 != n3.d) goto L14;
        boolean r20 = true;
    L15:
        Iterator r21 = ((ArrayList) r17).iterator();
        int r22 = 0;
    L17:
        if (r21.hasNext() == false) goto L22;
        String r110 = (String) r21.next();
        ReentrantLock r111 = com.ss.android.lark.newemoji.larkemoji.c.a;
        Intrinsics.checkNotNullParameter(r110, "id");
        com.ss.android.lark.newemoji.larkemoji.b r112 = new com.ss.android.lark.newemoji.larkemoji.b(r110, com.ss.android.lark.newemoji.larkemoji.c.a(r110));
        if (r112.c(false) == false) goto L17;
        r22 = r22 + 1;
        r19.add(new ssb.b.c(r112, r20, r18, Integer.valueOf(r22)));
        goto L17
    L22:
        r16.v(r19, this.b.w, this.a);
        ReactionPanelFacade r23 = this.b;
        ssb.a r24 = new ssb.a(r13.a, v2c.a.a(r23.a, 44.0f), r13.c, r13.d, r13.e, r13.f, r13.g, r13.h);
        ArrayList r25 = new ArrayList();
        if (CollectionUtils.isNotEmpty(r23.i) == false) goto L35;
        r25.add(new ssb.b.d(UIHelper.getString(2131891136), null));
        ArrayList r26 = new ArrayList(((ArrayList) r23.i).size());
        Iterator r27 = ((ArrayList) r23.i).iterator();
        int r28 = 0;
    L26:
        if (r27.hasNext() == false) goto L34;
        String r29 = (String) r27.next();
        com.ss.android.lark.newemoji.larkemoji.b r113 = com.ss.android.lark.newemoji.larkemoji.c.d(r29);
        if (r113 == null) goto L33;
        if (r113.c(false) == false) goto L33;
        r28 = r28 + 1;
        r26.add(new ssb.b.c(r113, false, n3.e, Integer.valueOf(r28)));
    L33:
        Log.w("ReactionPanelFacade", "addMruEmojiOnWholePanel, emoji [" + r29 + "] is not prepared");
        goto L26
    L34:
        Intrinsics.checkNotNullParameter(r26, "data");
        r25.add(new ssb.b.a(r26));
    L35:
        DefaultEmojiPanelData r30 = r23.z;
        if (r30 != null) goto L38;
    L62:
        r23.m.d(r24);
        r23.m.setData(r25);
        r23.m.setWindowTokenProvider(new g(r23));
        r23.m.setOnEmojiSelectListener(new com.ss.android.lark.reaction.widget.panel.b(r23));
        if (r23.f == true) goto L89;
        r23.m.setVisibility(0);
        r23.n.setVisibility(8);
        return;
    L89:
        return;
    L38:
        if (r30.d() == true) goto L62;
        Iterator r31 = ((ArrayList) r23.z.a).iterator();
    L42:
        if (r31.hasNext() == false) goto L61;
        DefaultEmojiPanelData.a r32 = (DefaultEmojiPanelData.a) r31.next();
        if (r32.getType() == DefaultEmojiPanelData.Type.UNKNOWN) goto L42;
        if (r32.c.isEmpty() == true) goto L49;
    L51:
        String r33 = r32.c;
    L52:
        r25.add(new ssb.b.d(r33, r32.b));
        List r34 = r32.b();
        if (CollectionUtils.isNotEmpty(r34) == false) goto L42;
        Iterator r35 = ((ArrayList) r34).iterator();
        int r36 = 0;
    L56:
        if (r35.hasNext() == false) goto L42;
        com.ss.android.lark.newemoji.larkemoji.a r37 = (com.ss.android.lark.newemoji.larkemoji.a) r35.next();
        if (r37.c(false) == false) goto L56;
        r36 = r36 + 1;
        r25.add(new ssb.b.c(r37, true, n3.d, Integer.valueOf(r36)));
        goto L56
    L49:
        if (r32.getType() != DefaultEmojiPanelData.Type.DEFAULT) goto L51;
        r33 = v2c.a.getResources(r23.a).getString(2131890747);
        goto L52
    L61:
        r25.add(new ssb.b.b(8));
        goto L62
    L14:
        r20 = false;
        goto L15
    L5:
        r10 = r5;
        goto L6
    }

    public h(ReactionPanelFacade r1, com.ss.android.lark.reaction.widget.panel.d r2) {
        this.b = r1;
        this.a = r2;
    }
}
