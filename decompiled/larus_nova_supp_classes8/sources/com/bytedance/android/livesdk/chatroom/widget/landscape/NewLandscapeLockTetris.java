package com.bytedance.android.livesdk.chatroom.widget.landscape;

import am2.x;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.NetworkUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/NewLandscapeLockTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewLandscapeLockTetris extends LiveTetris<e0> implements View.OnClickListener, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public static final String y = null;
    public static final String z = null;
    public HSImageView o;
    public RoomContext p;
    public final Lazy q;
    public final Lazy r;
    public final CompositeDisposable s;
    public int t;
    public AbstractDraweeController u;
    public AbstractDraweeController v;
    public final List<ph1.a> w;
    public final b x;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ NewLandscapeLockTetris a;

        public b(NewLandscapeLockTetris r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            ((AnimatedDrawable2) r3).setAnimationListener(new v(this, r3));
            r3.start();
            return;
        }
    }

    static {
        StringBuilder r0 = new StringBuilder("http://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/webcast/vs_screen_locking_shadow.webp");
        y = r0.toString();
        z = "http://" + r2.getObjectTosPath() + "/obj/webcast/vs_screen_unlocking_shadow.webp";
    }

    public final void O() {
        HSImageView r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L5:
        r0.setActualImageResource(2131252626);
        HSImageView r1 = this.o;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L8:
        r1.setOnClickListener(this);
        HSImageView r2 = this.o;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L11:
        r3.c(r2, "锁定屏幕", true);
        RoomContext r3 = this.p;
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.m r4 = r3.isLandscapeLock();
        if (r4 == null) goto L18;
        r4.setValue(Boolean.FALSE);
        return;
    L18:
        return;
    }

    public final com.bytedance.android.livesdk.chatroom.vsplayer.api.c V() {
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.provideVSPlayerViewControlService(((d90.d) K()).h);
    }

    public NewLandscapeLockTetris() {
        this.q = LazyKt.lazy(new NewLandscapeLockTetris$interactionModel$2(this));
        this.r = LazyKt.lazy(new NewLandscapeLockTetris$vsViewControlContext$2(this));
        this.s = new CompositeDisposable();
        this.w = new ArrayList();
        this.x = new b(this);
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        RoomContext r0 = this.p;
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.isLandscapeLock();
        if (r1 == null) goto L8;
        r1.setValue(Boolean.FALSE);
    L8:
        if (VrUtils.t(((d90.d) K()).h, false) == false) goto L10;
        VrUtils.b(false, this.w, K().b());
        ((ArrayList) this.w).clear();
    L10:
        this.s.clear();
    }

    public final View G(t70.k r13) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        this.p = K().b();
        this.u = Fresco.newDraweeControllerBuilder().setControllerListener(this.x).setUri(y).setAutoPlayAnimations(false).build();
        this.v = Fresco.newDraweeControllerBuilder().setControllerListener(this.x).setUri(z).setAutoPlayAnimations(false).build();
        this.o = new HSImageView(K().getContext());
        if (VSMediaUIConfigHelper.c(K()) == false) goto L10;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = V();
        if (r2 == null) goto L10;
        PlayerViewControl.KEY r3 = PlayerViewControl.KEY.PlayerViewLock;
        PlayerViewControl.Type r4 = PlayerViewControl.Type.ALPHA;
        PlayerViewControl.Style r5 = PlayerViewControl.Style.HIDE;
        HSImageView r6 = this.o;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L9:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r2, r3, r4, r5, r6, 0.0f, true, true, this, 272);
    L10:
        List<ph1.a> r14 = this.w;
        HSImageView r7 = this.o;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L13:
        ArrayList r15 = (ArrayList) r14;
        r15.add(new ph1.a(new WeakReference(r7), false));
        if (VrUtils.t(((d90.d) K()).h, false) == false) goto L16;
        VrUtils.a(this.w, this.s, K().b());
    L16:
        HSImageView r16 = this.o;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L19:
        return r16;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        int r3 = this.t - 1;
        this.t = r3;
        if (r3 >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        HSImageView r0 = this.o;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L5:
        HSImageView r2 = this.o;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L8:
        r0.setSelected(!r2.isSelected());
        HSImageView r1 = this.o;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L11:
        boolean r3 = r1.isSelected();
        ((LandscapeInteractionModel) this.q.getValue()).isLocked().setValue(Boolean.valueOf(r3));
        RoomContext r4 = this.p;
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.m r5 = r4.isLandscapeLock();
        if (r5 == null) goto L17;
        r5.setValue(Boolean.valueOf(r3));
    L17:
        if (VSMediaUIConfigHelper.c(K()) == false) goto L28;
        VSPlayerViewControlContext r6 = (VSPlayerViewControlContext) this.r.getValue();
        if (r6 == null) goto L28;
        r6.isLocked().setValue(Boolean.valueOf(r3));
        this.t = r3 ? 1 : 0;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r7 = V();
        if (r7 == null) goto L24;
        r7.setVisibilityStatus(!r3);
    L24:
        if (((Boolean) r6.isLocked().getValue()).booleanValue() == false) goto L28;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r8 = V();
        if (r8 == null) goto L28;
        r8.resetHideTask();
    L28:
        HashMap r10 = new HashMap();
        if (r3 == false) goto L31;
        String r11 = "lock";
    L32:
        r10.put("lock_type", r11);
        if (d90.c.i(K()) == false) goto L35;
        String r12 = "0";
    L36:
        r10.put("room_orientation", r12);
        com.bytedance.android.livesdk.log.g r13 = com.bytedance.android.livesdk.log.u.l();
        x r14 = new x();
        r14.a = "live";
        r14.e = "other";
        r14.b = "live_detail";
        r13.sendLog("landscape_screen_lock_click", r10, new Object[]{r14, Room.class});
        if (r9 == null) goto L39;
        Context r15 = r9.getContext();
    L40:
        int r16 = 2131252626;
        if (NetworkUtils.isNetworkAvailable(r15) == true) goto L49;
        HSImageView r17 = this.o;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L45:
        if (r3 == false) goto L47;
        r16 = 2131252627;
    L47:
        r17.setActualImageResource(r16);
        return;
    L49:
        HSImageView r18 = this.o;
        if (r18 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L52:
        GenericDraweeHierarchy r19 = r18.getHierarchy();
        if (r19 == null) goto L58;
        if (r3 == true) goto L57;
        r16 = 2131252627;
    L57:
        r19.setPlaceholderImage(r16);
    L58:
        HSImageView r20 = this.o;
        if (r20 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L61:
        if (r3 == false) goto L63;
        AbstractDraweeController r21 = this.u;
    L64:
        r20.setController(r21);
        HSImageView r22 = this.o;
        if (r22 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("lockView");
    L67:
        if (r3 == false) goto L69;
        String r23 = "已锁定屏幕";
    L70:
        r3.c(r22, r23, true);
        return;
    L69:
        r23 = "锁定屏幕";
        goto L70
    L63:
        r21 = this.v;
        goto L64
    L39:
        r15 = null;
        goto L40
    L35:
        r12 = "1";
        goto L36
    L31:
        r11 = "unlock";
        goto L32
    }
}
