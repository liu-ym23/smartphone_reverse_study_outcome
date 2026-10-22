package com.larus.bmhome.chat.manager;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.chat.view.share.ConversationShareMessageListAdapter;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.list.arch.FlowListAdapter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ShareCvsMsgPicManager {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String c(wc9.e r2) {
        if (r2 == null) goto L9;
        Integer r0 = r2.v;
        if (r0 == null) goto L9;
        if (r0.intValue() != 3) goto L9;
        boolean r1 = true;
    L10:
        String r3 = null;
        if (r1 == false) goto L21;
        wc9.e r4 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r4 == null) goto L19;
        IconImage r5 = r4.b;
        if (r5 == null) goto L19;
        ImageObj r6 = r5.imageOri;
        if (r6 == null) goto L19;
        r3 = r6.url;
    L19:
        if (r3 != null) goto L30;
    L28:
        return "";
    L30:
        return r3;
    L21:
        if (r2 == null) goto L27;
        IconImage r7 = r2.b;
        if (r7 == null) goto L27;
        ImageObj r8 = r7.imageOri;
        if (r8 == null) goto L27;
        r3 = r8.url;
    L27:
        if (r3 != null) goto L30;
    L9:
        r1 = false;
        goto L10
    }

    public static void b(final g0 r18, final Function2 r19) {
        Intrinsics.checkNotNullParameter(r18, "shareContext");
        int r1 = qo8.o.a;
        Context r11 = r18.getContext();
        List<Message> r12 = r18.d;
        String r13 = r18.c;
        Bitmap r14 = r18.f;
        Bitmap r15 = r18.g;
        wc9.e r2 = r18.e;
        MessageShareViewModel.b r3 = r18.b;
        boolean r4 = r18.h;
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "messageList");
        Intrinsics.checkNotNullParameter(r3, "provider");
        boolean r5 = r3.g().C();
        if (r5 != true) goto L5;
        final qo8.f r6 = new qo8.f(r11, r12, r13, r14, r15, r2, r3);
    L7:
        final View r7 = r6.b();
        if (r7 != null) goto L11;
        r19.invoke(-3, null);
        FLogger.a.i("ShareCvsMsgPicManager", "generateSharePic: rootView is null");
        return;
    L11:
        Activity r8 = AppHost.a.a().getCurrentActivity();
        if (r8 != null) goto L15;
        r19.invoke(-4, null);
        FLogger.a.i("ShareCvsMsgPicManager", "generateSharePic: currentActivity is null");
        return;
    L15:
        final FrameLayout r16 = (FrameLayout) r8.findViewById(R.id.content);
        if (r16 != null) goto L19;
        r19.invoke(-5, null);
        FLogger.a.i("ShareCvsMsgPicManager", "generateSharePic: contentView is null");
        return;
    L19:
        final ScrollView r17 = new ScrollView(r18.getContext());
    L35:
        e = move-exception;
        FLogger.a.e("ShareCvsMsgPicManager", "generateSharePic: error ", e);
        EnsureManager.ensureNotReachHere(e, "ShareCvsMsgPicManager generateSharePic: error");
        r16.removeView(r17);
        r19.invoke(-2, null);
        Unit r0 = Unit.INSTANCE;
        return;
    L21:
        if (r18.h == false) goto L23;
        int r9 = (com.larus.utils.i.d(r18.getContext()) * 4) / 5;     // Catch: Exception -> L35
    L24:
        r17.addView(r7, new FrameLayout.LayoutParams(com.larus.utils.i.d(r18.getContext()), r9));     // Catch: Exception -> L35
        r16.addView(r17, 0);     // Catch: Exception -> L35
        final ConversationShareMessageListAdapter r10 = ((qo8.c) r6).h;     // Catch: Exception -> L35
        if (r10 == null) goto L33;
        ViewGroup r20 = (ViewGroup) r8.findViewById(2131379994);     // Catch: Exception -> L35
        if (r20 == null) goto L29;
        Fragment r21 = e1.k(r20);     // Catch: Exception -> L35
    L30:
        if (r21 == null) goto L33;
        ((FlowListAdapter) r10).d = r21;     // Catch: Exception -> L35
        goto L33
    L29:
        r21 = null;
    L33:
        com.larus.utils.t0.a.postDelayed(new v0(r17, r6, r18, r10, r19, r7, r16), 350);     // Catch: Exception -> L35
        return;
    L23:
        r9 = r6.a();     // Catch: Exception -> L35
        goto L24
    L5:
        if (r5 == true) goto L39;
        r6 = new qo8.n(r11, r12, r13, r14, r2, r3, r4);
        goto L7
    L39:
        throw new NoWhenBranchMatchedException();
    }

    public static final void a(View r6, View r7, Canvas r8) {
        int r1 = 0;
        if ((r7 instanceof TextureView) == false) goto L8;
        Bitmap r0 = ((TextureView) r7).getBitmap();
        if (r0 == null) goto L8;
        int[] r3 = new int[2];
        r7.getLocationOnScreen(r3);
        int[] r2 = new int[2];
        r6.getLocationOnScreen(r2);
        Pair r4 = new Pair(Float.valueOf(r3[0] - r2[0]), Float.valueOf(r3[1] - r2[1]));
        r8.drawBitmap(r0, ((Number) r4.component1()).floatValue(), ((Number) r4.component2()).floatValue(), null);
    L8:
        if ((r7 instanceof ViewGroup) == false) goto L12;
        ViewGroup r9 = (ViewGroup) r7;
        int r5 = r9.getChildCount();
    L10:
        if (r1 >= r5) goto L14;
        a(r6, r9.getChildAt(r1), r8);
        r1 = r1 + 1;
        goto L10
    L14:
        return;
    }
}
