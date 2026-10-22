package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.View;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ LiveVideoCommentSelectPanelAwemeListFragment a;

    public h(LiveVideoCommentSelectPanelAwemeListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r9) {
        ud0.b r10 = (ud0.b) r9;
        LiveVideoCommentSelectPanelAwemeListFragment r0 = this.a;
        String r1 = LiveVideoCommentSelectPanelAwemeListFragment.r;
        r0.getClass();
        boolean r3 = true;
        if ((r10 instanceof ud0.b.C0276b) == false) goto L68;
        View r2 = r0.h;
        if (r2 == null) goto L7;
        r2.setVisibility(8);
    L7:
        r0.hideLoading();
        View r4 = r0.l;
        if (r4 == null) goto L10;
        r4.setVisibility(8);
    L10:
        sd0.b r11 = ((ud0.b.C0276b) r10).a;
        if (r11 == null) goto L15;
        Boolean r5 = r11.a();
        if (r5 == null) goto L15;
        boolean r6 = r5.booleanValue();
    L16:
        r0.S90(false);
        MultiTypeAdapter r7 = r0.n;
        Unit r8 = null;
        if (r7 == null) goto L19;
        List r12 = r7.a;
    L21:
        if (TypeIntrinsics.isMutableList(r12) == true) goto L24;
        r12 = null;
    L24:
        if (r11 == null) goto L44;
        List<sd0.a> r13 = r11.d();
        if (r13 == null) goto L44;
        if ((!r13.isEmpty()) == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L44;
        if (r12 == null) goto L34;
        r12.addAll(r13);
    L34:
        if (r6 == true) goto L40;
        LoadMoreScrollListener r14 = r0.o;
        if (r14 == null) goto L38;
        r14.b = 2;
    L38:
        if (r12 == null) goto L40;
        r12.add(new e(2));
    L40:
        MultiTypeAdapter r15 = r0.n;
        if (r15 == null) goto L43;
        r15.notifyDataSetChanged();
        r8 = Unit.INSTANCE;
    L43:
        if (r8 == null) goto L44;
    L64:
        r0.p = true;
        VideoTab r16 = r0.q;
        if (r16 == null) goto L111;
        r0.T90(r16);
        return;
    L111:
        return;
    L44:
        if (r6 == true) goto L61;
        if (r12 == null) goto L47;
        boolean r17 = r12.isEmpty();
    L48:
        if (r17 == false) goto L53;
        View r18 = r0.h;
        if (r18 == null) goto L52;
        r18.setVisibility(0);
    L52:
        ImageLoader.bindImage(r0.i, LiveVideoCommentSelectPanelAwemeListFragment.r);
        Unit r19 = Unit.INSTANCE;
        goto L64
    L53:
        LoadMoreScrollListener r20 = r0.o;
        if (r20 == null) goto L56;
        r20.b = 2;
    L56:
        if (r12 == null) goto L58;
        r12.add(new e(2));
    L58:
        MultiTypeAdapter r21 = r0.n;
        if (r21 == null) goto L64;
        r21.notifyDataSetChanged();
        Unit r22 = Unit.INSTANCE;
        goto L64
    L47:
        r17 = true;
        goto L48
    L61:
        MultiTypeAdapter r23 = r0.n;
        if (r23 == null) goto L64;
        r23.notifyDataSetChanged();
        Unit r24 = Unit.INSTANCE;
        goto L64
    L19:
        r12 = null;
    L15:
        r6 = true;
        goto L16
    L68:
        if ((r10 instanceof ud0.b.a) == false) goto L80;
        Throwable r25 = ((ud0.b.a) r10).a;
        r0.S90(true);
        MultiTypeAdapter r26 = r0.n;
        if (r26 == null) goto L74;
        List r27 = r26.a;
        if (r27 == null) goto L74;
        r3 = r27.isEmpty();
    L74:
        if (r3 == false) goto L78;
        r0.hideLoading();
        View r28 = r0.l;
        if (r28 == null) goto L113;
        r28.setVisibility(0);
        return;
    L113:
        return;
    L78:
        ExceptionUtils.handleException(r0.getContext(), r25);
        return;
    L80:
        if ((r10 instanceof ud0.b.c) == false) goto L89;
        r0.hideLoading();
        View r29 = r0.l;
        if (r29 == null) goto L84;
        r29.setVisibility(8);
    L84:
        View r30 = r0.h;
        if (r30 == null) goto L87;
        r30.setVisibility(0);
    L87:
        ImageLoader.bindImage(r0.i, LiveVideoCommentSelectPanelAwemeListFragment.r);
        return;
    L89:
        if ((r10 instanceof ud0.b.d) == false) goto L103;
        View r31 = r0.h;
        if (r31 == null) goto L93;
        r31.setVisibility(8);
    L93:
        View r32 = r0.l;
        if (r32 == null) goto L96;
        r32.setVisibility(8);
    L96:
        View r33 = r0.j;
        if (r33 == null) goto L99;
        r33.setVisibility(0);
    L99:
        LiveDoubleColorBallAnimationView r34 = r0.k;
        if (r34 == null) goto L117;
        r34.b();
        return;
    L117:
        return;
    L103:
        if ((r10 instanceof ud0.b.e) == false) goto L119;
        r0.hideLoading();
        View r35 = r0.h;
        if (r35 == null) goto L107;
        r35.setVisibility(8);
    L107:
        View r36 = r0.l;
        if (r36 == null) goto L120;
        r36.setVisibility(0);
        return;
    L120:
        return;
    }
}
