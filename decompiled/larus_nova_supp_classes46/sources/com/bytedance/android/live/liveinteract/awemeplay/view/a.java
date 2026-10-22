package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.widget.x0;
import com.google.android.material.tabs.TabLayout;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.r;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ LiveVideoCommentSelectAwemePanelView a;

    public a(LiveVideoCommentSelectAwemePanelView r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View$OnClickListener, android.view.ViewGroup, com.bytedance.android.live.liveinteract.awemeplay.view.LiveVideoCommentSelectAwemePanelView, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onChanged(Object r13) {
        ud0.d r14 = (ud0.d) r13;
        ?? r0 = this.a;
        int r1 = LiveVideoCommentSelectAwemePanelView.w;
        r0.getClass();
        if ((r14 instanceof ud0.d.f) == false) goto L22;
        if (r0.v == false) goto L12;
        TabLayout r15 = r0.c;
        if (r15 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r15);
    L9:
        LinearLayout r16 = r0.n;
        if (r16 == null) goto L12;
        UtilityKotlinExtentionsKt.t(r16);
    L12:
        View r17 = r0.h;
        if (r17 == null) goto L15;
        r17.setVisibility(8);
    L15:
        View r18 = r0.g;
        if (r18 == null) goto L18;
        r18.setVisibility(0);
    L18:
        LiveDoubleColorBallAnimationView r19 = r0.j;
        if (r19 == null) goto L195;
        r19.b();
        return;
    L195:
        return;
    L22:
        if ((r14 instanceof ud0.d.g) == false) goto L41;
        if (r0.v == false) goto L31;
        TabLayout r110 = r0.c;
        if (r110 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r110);
    L28:
        LinearLayout r111 = r0.n;
        if (r111 == null) goto L31;
        UtilityKotlinExtentionsKt.t(r111);
    L31:
        View r112 = r0.g;
        if (r112 == null) goto L34;
        r112.setVisibility(8);
    L34:
        LiveDoubleColorBallAnimationView r113 = r0.j;
        if (r113 == null) goto L37;
        r113.c();
    L37:
        View r114 = r0.h;
        if (r114 == null) goto L217;
        r114.setVisibility(0);
        return;
    L217:
        return;
    L41:
        if ((r14 instanceof ud0.d.b) == false) goto L153;
        TabLayout r2 = r0.c;
        if (r2 == null) goto L45;
        UtilityKotlinExtentionsKt.w(r2);
    L45:
        View r3 = r0.h;
        if (r3 == null) goto L48;
        r3.setVisibility(8);
    L48:
        View r4 = r0.g;
        if (r4 == null) goto L51;
        r4.setVisibility(8);
    L51:
        LiveDoubleColorBallAnimationView r5 = r0.j;
        if (r5 == null) goto L54;
        r5.c();
    L54:
        sd0.d r115 = ((ud0.d.b) r14).a;
        List<VideoTab> r6 = r115.b();
        boolean r7 = true;
        Disposable r8 = null;
        if (r6 == null) goto L68;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r6.iterator();
    L58:
        if (r10.hasNext() == false) goto L69;
        T r11 = r10.next();
        Integer r12 = ((VideoTab) r11).getType();
        if (r12 != null) goto L63;
    L64:
        boolean r20 = true;
    L66:
        if (r20 == false) goto L58;
        r9.add(r11);
        goto L58
    L63:
        if (r12.intValue() != 5) goto L64;
        r20 = false;
    L69:
        r0.b = r9;
        List<VideoTab> r21 = r115.b();
        if (r21 == null) goto L85;
        Iterator<T> r22 = r21.iterator();
    L73:
        if (r22.hasNext() == false) goto L83;
        T r23 = r22.next();
        Integer r24 = ((VideoTab) r23).getType();
        if (r24 != null) goto L78;
    L80:
        boolean r25 = false;
    L81:
        if (r25 == false) goto L73;
    L84:
        VideoTab r26 = r23;
    L86:
        if (r26 != null) goto L89;
        r7 = false;
    L89:
        if (r7 == false) goto L97;
        LinearLayout r27 = r0.n;
        if (r27 == null) goto L93;
        UtilityKotlinExtentionsKt.w(r27);
    L93:
        LinearLayout r28 = r0.n;
        if (r28 == 0) goto L96;
        r28.setOnClickListener(r0);
    L96:
        LiveVideoCommentSelectAwemePanelView.T5("show");
    L103:
        TabLayout r29 = r0.c;
        List<VideoTab> r30 = r0.b;
        if (r29 == null) goto L147;
        if (r30 == null) goto L147;
        int r31 = r30.size();
        int r32 = 0;
    L107:
        if (r32 >= r31) goto L109;
        r29.addTab(r29.newTab());
        r32 = r32 + 1;
        goto L107
    L109:
        r29.setupWithViewPager(r0.f);
        Iterator<T> r33 = r30.iterator();
        int r34 = 0;
        int r35 = 0;
    L111:
        if (r33.hasNext() == false) goto L125;
        T r36 = r33.next();
        int r37 = r34 + 1;
        if (r34 >= 0) goto L115;
        CollectionsKt.throwIndexOverflow();
    L115:
        VideoTab r38 = (VideoTab) r36;
        TabLayout.Tab r116 = r29.getTabAt(r34);
        if (r116 == null) goto L118;
        r116.setText(r38.getTitle());
    L118:
        TabLayout.Tab r117 = r29.getTabAt(r34);
        if (r117 == null) goto L122;
        r117.setTag(r38);
    L122:
        if (Intrinsics.areEqual(r38.getType(), r115.a()) == false) goto L124;
        r35 = r34;
    L124:
        r34 = r37;
        goto L111
    L125:
        Fragment r118 = r0.l;
        if (r118 == null) goto L140;
        FragmentManager r119 = r118.getChildFragmentManager();
        if (r119 == null) goto L140;
        LiveVideoCommentSelectPanelPagerAdapter r39 = new LiveVideoCommentSelectPanelPagerAdapter(r119, r30, r0.a, r0.u);
        ViewPager r120 = r0.f;
        if (r120 == null) goto L132;
        r120.setAdapter(r39);
    L132:
        ViewPager r121 = r0.f;
        if (r121 == null) goto L135;
        r121.setCurrentItem(r35);
    L135:
        if (r35 != 0) goto L140;
        if (r0.s == false) goto L139;
        r0.S5(r35);
        goto L140
    L139:
        r0.t = Integer.valueOf(r35);
    L140:
        Observable r122 = Observable.timer(3000, TimeUnit.MILLISECONDS);
        if (r122 == null) goto L147;
        Observable r123 = r122.observeOn(AndroidSchedulers.mainThread());
        if (r123 == null) goto L147;
        Disposable r124 = r123.subscribe(new d(r0));
        if (r124 == null) goto L147;
        RxUtilKt.c(r124, r0.q);
        r8 = r124;
    L147:
        if (r8 != null) goto L219;
        View r125 = r0.h;
        if (r125 == null) goto L151;
        r125.setVisibility(0);
    L151:
        Unit r126 = Unit.INSTANCE;
        return;
    L219:
        return;
    L97:
        LinearLayout r40 = r0.n;
        if (r40 == null) goto L100;
        UtilityKotlinExtentionsKt.t(r40);
    L100:
        LinearLayout r41 = r0.n;
        if (r41 == null) goto L103;
        r41.setOnClickListener(null);
        goto L103
    L78:
        if (r24.intValue() != 5) goto L80;
        r25 = true;
        goto L81
    L83:
        r23 = (T) null;
        goto L84
    L85:
        r26 = null;
        goto L86
    L68:
        r9 = null;
        goto L69
    L153:
        if ((r14 instanceof ud0.d.C0277d) == false) goto L158;
        r r42 = r0.m;
        if (r42 == null) goto L221;
        r42.e(((ud0.d.C0277d) r14).a);
        return;
    L221:
        return;
    L158:
        if ((r14 instanceof ud0.d.c) == false) goto L163;
        ExceptionUtils.handleException(r0.getContext(), ((ud0.d.c) r14).a);
        r r127 = r0.m;
        if (r127 == null) goto L223;
        r127.a();
        return;
    L223:
        return;
    L163:
        if ((r14 instanceof ud0.d.e) == false) goto L175;
        if (r0.r != null) goto L167;
        Context r128 = r0.getContext();
        x0.d r43 = new x0.d();
        r43.b = r128;
        r43.a = 2;
        r43.k = false;
        r0.r = new x0(r43.b, r43);
    L167:
        x0 r129 = r0.r;
        if (r129 != null) goto L170;
        return;
    L170:
        if (DialogLancet.shouldBlockDialogShow(r129) == false) goto L199;
        DialogLancet.handleBlockedDialogShow(r129);
        return;
    L199:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L196
    L173:
        DialogLancet.beforeDialogShow(r129);
        r129.show();
        DialogLancet.afterDialogShow(r129);
        return;
    L175:
        if ((r14 instanceof ud0.d.a) == false) goto L228;
        x0 r130 = r0.r;
        if (r130 == null) goto L229;
        Handler r44 = DialogLancet.resolveDialogHandler(r130);
        if (r44 != null) goto L181;
    L183:
        DialogLancet.beforeDialogDismiss(r130);
        r130.dismiss();     // Catch: Throwable -> L186 Exception -> L188
    L192:
        DialogLancet.afterDialogDismiss(r130);
        return;
    L188:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L186
        Throwable r45 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L186
        if (r45 == null) goto L192;
        com.bytedance.crash.d.d(r45, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L186
    L186:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r130);
        throw th;
    L181:
        if (Looper.myLooper() == r44.getLooper()) goto L183;
        r44.post(DialogLancet.createDismissRunnable(r130));
        return;
    L229:
        return;
    }
}
