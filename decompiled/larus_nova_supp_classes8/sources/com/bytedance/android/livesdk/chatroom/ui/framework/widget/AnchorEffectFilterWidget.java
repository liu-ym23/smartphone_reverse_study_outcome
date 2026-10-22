package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.widgetdescriptor.data.FlingViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/AnchorEffectFilterWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljo1/a;", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorEffectFilterWidget extends MiddlewareRoomWidget implements jo1.a {
    public com.bytedance.android.livesdk.chatroom.ui.framework.d a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;
    public final CompositeDisposable c;

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    private final FragmentActivity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p0();
    }

    public final View Fj() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Fj();
    }

    public AnchorEffectFilterWidget() {
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r1.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
    L8:
        this.b = r2;
        this.a = ho1.a.i(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.b;
        if (r3 == null) goto L15;
        com.bytedance.android.live.core.arch.mvvm.d<Boolean> r4 = r3.Qi();
        if (r4 == null) goto L15;
        Disposable r5 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r4, new AnonymousClass1(this));
        if (r5 == null) goto L15;
        RxUtilKt.c(r5, this.c);
    L15:
        h70.b r6 = getComponentContext();
        if (r6 == null) goto L21;
        IAbilityCenter r7 = r6.a();
        if (r7 == null) goto L22;
        r7.registerAbility(jo1.a.class, this);
        return;
    L22:
        return;
    L21:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.c.clear();
        View r0 = Fj();
        if (r0 == null) goto L5;
        r0.clearAnimation();
    L5:
        h70.b r1 = getComponentContext();
        if (r1 == null) goto L11;
        IAbilityCenter r2 = r1.a();
        if (r2 == null) goto L12;
        r2.unregisterAbility(jo1.a.class);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ FragmentActivity wq(AnchorEffectFilterWidget r0) {
        return r0.getActivity();
    }

    @Override // jo1.a
    public final void I4(boolean r8, boolean r9) {
        ViewPropertyAnimator r2 = null;
        ViewGroup r3 = null;
        if (r8 == false) goto L60;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.b;
        if (r10 == null) goto L7;
        Fragment r11 = r10.getFragment();
    L8:
        if (r11 == null) goto L17;
        MutableLiveData r12 = ViewModelProviders.of(r11).get(FlingViewModel.class).getStatus();
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = this.a;
        if (r4 == null) goto L12;
        ViewGroup r5 = r4.Wa();
    L13:
        if (r5 == null) goto L15;
        FlingViewModel.a r6 = new FlingViewModel.a(false, r5.getWidth(), r9);
    L16:
        r12.setValue(r6);
        goto L17
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = null;
    L17:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r13 = this.a;
        if (r13 == null) goto L20;
        View r14 = r13.A8();
    L21:
        if (r14 == null) goto L23;
        ViewPropertyAnimator r15 = r14.animate();
    L24:
        View r7 = Fj();
        if (r7 == null) goto L27;
        ViewPropertyAnimator r16 = r7.animate();
    L28:
        if (r9 == false) goto L33;
        if (r15 == null) goto L31;
        r15.alpha(0.0f);
    L31:
        if (r16 == null) goto L48;
        r16.alpha(0.0f);
    L48:
        if (r15 == null) goto L54;
        ViewPropertyAnimator r17 = r15.setDuration(200);
        if (r17 == null) goto L54;
        ViewPropertyAnimator r18 = r17.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r18 == null) goto L54;
        r18.start();
    L54:
        if (r16 == null) goto L99;
        ViewPropertyAnimator r19 = r16.setDuration(200);
        if (r19 == null) goto L100;
        ViewPropertyAnimator r20 = r19.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r20 == null) goto L101;
        r20.start();
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L33:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r21 = this.a;
        if (r21 == null) goto L36;
        ViewGroup r22 = r21.Wa();
    L37:
        if (r22 == null) goto L41;
        float r23 = r22.getWidth();
        if (r15 == null) goto L41;
        r15.x(r23);
    L41:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r24 = this.a;
        if (r24 == null) goto L44;
        r3 = r24.Wa();
    L44:
        if (r3 == null) goto L48;
        float r25 = r3.getWidth();
        if (r16 == null) goto L48;
        r16.x(r25);
        goto L48
    L36:
        r22 = null;
        goto L37
    L27:
        r16 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L20:
        r14 = null;
        goto L21
    L7:
        r11 = null;
        goto L8
    L60:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r26 = this.b;
        if (r26 == null) goto L63;
        Fragment r27 = r26.getFragment();
    L64:
        if (r27 == null) goto L66;
        ViewModelProviders.of(r27).get(FlingViewModel.class).getStatus().setValue(new FlingViewModel.a(true, 0.0f, r9));
    L66:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r28 = this.a;
        if (r28 == null) goto L69;
        View r29 = r28.A8();
    L70:
        if (r29 == null) goto L72;
        ViewPropertyAnimator r30 = r29.animate();
    L73:
        View r31 = Fj();
        if (r31 == null) goto L76;
        r2 = r31.animate();
    L76:
        if (r9 == true) goto L78;
        if (r30 == null) goto L84;
        r30.x(0.0f);
    L84:
        if (r2 == null) goto L86;
        r2.x(0.0f);
    L86:
        if (r30 == null) goto L92;
        ViewPropertyAnimator r32 = r30.setDuration(200);
        if (r32 == null) goto L92;
        ViewPropertyAnimator r33 = r32.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r33 == null) goto L92;
        r33.start();
    L92:
        if (r2 == null) goto L103;
        ViewPropertyAnimator r34 = r2.setDuration(200);
        if (r34 == null) goto L104;
        ViewPropertyAnimator r35 = r34.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r35 == null) goto L105;
        r35.start();
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L78:
        if (r30 == null) goto L80;
        r30.alpha(1.0f);
    L80:
        if (r2 == null) goto L86;
        r2.alpha(1.0f);
        goto L86
    L72:
        r30 = null;
        goto L73
    L69:
        r29 = null;
        goto L70
    L63:
        r27 = null;
        goto L64
    }
}
