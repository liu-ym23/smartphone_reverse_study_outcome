package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.NitaInflateUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.gx0;
import com.bytedance.android.livesdk.gift.configmodel.k2;
import com.bytedance.android.livesdk.gift.fastgift.di.FastGiftAnimationCreator;
import com.bytedance.android.livesdk.gift.fastgift.task.FastTaskGiftConfirmDialog;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.FastGiftDialogHintView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.GiftCommonHintView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.RecommendFastGiftConfirmView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftNitaViewInfo;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.toolbar.RevResKeyEnum;
import com.bytedance.android.livesdk.revenue.toolbar.RevSkinConstants;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarConstants;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.widget.CircleProgressViewV3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveViewInflateConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/gift/fastgift/FastGiftViewV3;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", BuildConfig.FLAVOR, "N", "I", "getFastGiftImageSize", "()I", "setFastGiftImageSize", "(I)V", "fastGiftImageSize", "Lyz0/k;", "getRoomDataService", "()Lyz0/k;", "roomDataService", "Lh01/a;", "getToolbarService", "()Lh01/a;", "toolbarService", "Llr2/a;", "getPaidLiveService", "()Llr2/a;", "paidLiveService", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FastGiftViewV3 extends FrameLayout implements LifecycleOwnerCompat {
    public static final /* synthetic */ int O = 0;
    public final FastGiftViewModel A;
    public DataCenter B;
    public py.k C;
    public final CompositeDisposable D;
    public final Disposable E;
    public Disposable F;
    public final FrameLayout.LayoutParams G;
    public final FrameLayout.LayoutParams H;
    public final k2 I;
    public int J;
    public Disposable K;
    public Disposable L;
    public boolean M;
    public int N;
    public Map<Integer, View> a;
    public final LifecycleRegistry b;
    public ObjectAnimator c;
    public AnimatorSet d;
    public AnimatorSet e;
    public AnimatorSet f;
    public AnimatorSet g;
    public AnimatorSet h;
    public AnimatorSet i;
    public boolean j;
    public boolean k;
    public Dialog l;
    public Dialog m;
    public PopupGiftDialogFragment n;
    public final FastGiftComboView o;
    public final TextView p;
    public AnimatorSet q;
    public AnimatorSet r;
    public AnimatorSet s;
    public AnimatorSet t;
    public AnimatorSet u;
    public Disposable v;
    public boolean w;
    public Long x;
    public final int y;
    public boolean z;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.fastgift.FastGiftViewV3$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "p1", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1, Throwable.class, "printStackTrace", "printStackTrace()V", 0);
        }

        public final void invoke(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            r2.printStackTrace();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Throwable) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;

        public a(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            FastGiftViewV3.e(this.a, 1);
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public c(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            FastGiftViewV3 r0 = this.a;
            FragmentActivity r1 = null;
            if (Intrinsics.areEqual((Boolean) r5, Boolean.TRUE) == true) goto L6;
            r0 = null;
        L6:
            if (r0 == null) goto L41;
            PopupGiftDialogFragment r6 = r0.n;
            if (r6 != null) goto L10;
        L20:
            int r7 = PopupGiftDialogFragment.f;
            FastGiftViewModel r8 = r0.A;
            Intrinsics.checkNotNullParameter(r8, "vm");
            PopupGiftDialogFragment r2 = new PopupGiftDialogFragment();
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r2.e = r8;
            r0.n = r2;
            FragmentActivity r9 = r0.getContext();
            if ((r9 instanceof FragmentActivity) == false) goto L24;
            r1 = r9;
        L24:
            FragmentActivity r3 = r1;
            if (r3 == null) goto L42;
            FragmentManager r10 = r3.getSupportFragmentManager();
            if (r10 == null) goto L43;
            PopupGiftDialogFragment r4 = r0.n;
            if (r4 == null) goto L44;
            LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "PopupGiftDialogFragment", r11);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r4, r11) == true) goto L45;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
        L34:
            r4.show(r10, "PopupGiftDialogFragment");
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L42:
            return;
        L10:
            if (r6.isShowing() != true) goto L20;
            PopupGiftDialogFragment r13 = r0.n;
            if (r13 != null) goto L39;
        L19:
            r0.n = null;
            goto L20
        L39:
            r13.dismissAllowingStateLoss();     // Catch: Exception -> L15
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r14 = DialogFragmentLancet.sLastShowStack;
            if (r14 == null) goto L19;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L19
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public d(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (r4 == null) goto L6;
            FastGiftViewV3 r0 = this.a;
            boolean r5 = Intrinsics.areEqual(r4, Boolean.TRUE);
            int r1 = FastGiftViewV3.O;
            r0.j(false, r5);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public e(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            final FastGiftViewModel.RecommendFastGiftStatus r8 = (FastGiftViewModel.RecommendFastGiftStatus) r7;
            UtilityKotlinExtentionsKt.s(0, false, false, new FastGiftViewV3$onAttachedToWindow$10$1(this, r8), 7);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public f(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            h1 r0 = (h1) r18;
            FastGiftViewV3 r2 = this.a;
            if (r0 == null) goto L65;
            long r3 = r0.getId();
            my1.a r5 = r2.A.getFastTaskGiftModel();
            PointF r6 = null;
            if (r5 == null) goto L8;
            Long r7 = r5.c;
        L9:
            if (r7 != null) goto L12;
        L61:
            r2.o(r0);
            return;
        L12:
            if (r3 != r7.longValue()) goto L61;
            my1.a r4 = r2.A.getFastTaskGiftModel();
            if (r4 == null) goto L16;
            my1.b r8 = r4.a;
        L17:
            if (r8 == null) goto L61;
            if (((FastGiftViewModel.RecommendFastGiftStatus) r2.A.getRecommendStatus().getValue()) != FastGiftViewModel.RecommendFastGiftStatus.Idle) goto L66;
            my1.a r9 = r2.A.getFastTaskGiftModel();
            if (r9 == null) goto L67;
            my1.b r10 = r9.a;
            if (r10 == null) goto L27;
            String r11 = r10.rewardNum;
        L29:
            if (r10 == null) goto L33;
            Boolean r13 = r10.hasAnimation;
            if (r13 == null) goto L33;
            boolean r14 = r13.booleanValue();
        L34:
            boolean r15 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(r2.B).f(RevToolbarButton.FastGift);
            if (r14 == true) goto L37;
        L60:
            r2.f();
            r2.C = r0.getImage();
            r2.m();
            return;
        L37:
            if (TextUtils.isEmpty(r11) == true) goto L60;
            if (r15 == false) goto L60;
            View r16 = r2.a(2131372145);
            if (r2.j == false) goto L43;
            int[] r17 = new int[2];
            r16.getLocationOnScreen(r17);
            PointF r19 = new PointF();
            r19.x = r17[0];
            r19.y = r17[1] - s1.o();
            r6 = r19;
        L43:
            if (r6 == null) goto L47;
            ou0.a r20 = yt0.c.d();
            if (r20 == null) goto L47;
            r20.qc();
        L47:
            r2.f();
            py.k r1 = r0.getImage();
            r2.a(2131372145).setVisibility(0);
            if (r2.q != null) goto L50;
            View r21 = r2.a(2131372145);
            Lazy r23 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r21, "target");
            ObjectAnimator r24 = ObjectAnimator.ofFloat(r21, "scaleX", new float[]{1.0f, 0.0f});
            r24.setDuration(150);
            ObjectAnimator r25 = ObjectAnimator.ofFloat(r21, "scaleY", new float[]{1.0f, 0.0f});
            r25.setDuration(150);
            AnimatorSet r110 = new AnimatorSet();
            r110.playTogether(new Animator[]{r24, r25});
            r2.q = r110;
        L50:
            AnimatorSet r26 = r2.q;
            if (r26 == null) goto L53;
            r26.addListener(new y(r2, r1));
            r26.setStartDelay(3900);
            r26.start();
        L53:
            String r111 = r11;
            if (r2.s != null) goto L56;
            View r27 = r2.a(2131388219);
            Lazy r112 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r27, "target");
            ObjectAnimator r28 = ObjectAnimator.ofFloat(r27, "alpha", new float[]{0.0f, 1.0f});
            r28.setDuration(150);
            ObjectAnimator r113 = ObjectAnimator.ofFloat(r27, "scaleX", new float[]{1.0f, 1.2f});
            r113.setDuration(300);
            r113.setStartDelay(150);
            r113.setRepeatCount(1);
            r113.setRepeatMode(2);
            ObjectAnimator r114 = ObjectAnimator.ofFloat(r27, "scaleY", new float[]{1.0f, 1.2f});
            r114.setDuration(300);
            r114.setStartDelay(150);
            r114.setRepeatCount(1);
            r114.setRepeatMode(2);
            ObjectAnimator r29 = ObjectAnimator.ofFloat(r27, "scaleX", new float[]{1.0f, 0.0f});
            r29.setDuration(300);
            r29.setStartDelay(1850);
            ObjectAnimator r30 = ObjectAnimator.ofFloat(r27, "scaleY", new float[]{1.0f, 0.0f});
            r30.setDuration(300);
            r30.setStartDelay(1850);
            AnimatorSet r31 = new AnimatorSet();
            r31.playTogether(new Animator[]{r28, r113, r114, r29, r30});
            r2.s = r31;
        L56:
            AnimatorSet r33 = r2.s;
            if (r33 == null) goto L59;
            r33.setStartDelay(3900);
            r33.start();
        L59:
            r2.p.setText(r111);
            TextView r34 = r2.p;
            Lazy r35 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r34, "target");
            ObjectAnimator r36 = ObjectAnimator.ofFloat(r34, "alpha", new float[]{0.0f, 1.0f});
            r36.setDuration(200);
            ObjectAnimator r37 = ObjectAnimator.ofFloat(r34, "scaleX", new float[]{1.0f, 1.2f});
            r37.setDuration(50);
            ObjectAnimator r38 = ObjectAnimator.ofFloat(r34, "scaleY", new float[]{1.0f, 1.2f});
            r38.setDuration(50);
            AnimatorSet r39 = new AnimatorSet();
            r39.playTogether(new Animator[]{r37, r38});
            ObjectAnimator r40 = ObjectAnimator.ofFloat(r34, "scaleX", new float[]{1.2f, 1.0f});
            r40.setDuration(150);
            ObjectAnimator r115 = ObjectAnimator.ofFloat(r34, "scaleY", new float[]{1.2f, 1.0f});
            r115.setDuration(150);
            AnimatorSet r41 = new AnimatorSet();
            r41.playTogether(new Animator[]{r40, r115});
            Ref.IntRef r43 = new Ref.IntRef();
            r43.element = 1;
            AnimatorSet r116 = new AnimatorSet();
            r116.playSequentially(new Animator[]{r39, r41});
            r116.addListener(new com.bytedance.android.livesdk.gift.fastgift.di.a(r43, r116));
            ObjectAnimator r44 = ObjectAnimator.ofFloat(r34, "scaleX", new float[]{1.0f, 0.0f});
            r44.setDuration(300);
            r44.setStartDelay(1850);
            ObjectAnimator r45 = ObjectAnimator.ofFloat(r34, "scaleY", new float[]{1.0f, 0.0f});
            r45.setDuration(300);
            r45.setStartDelay(1850);
            AnimatorSet r46 = new AnimatorSet();
            r46.playTogether(new Animator[]{r44, r45});
            AnimatorSet r47 = new AnimatorSet();
            r47.playTogether(new Animator[]{r36, r116, r46});
            r2.t = r47;
            r47.addListener(new z(r2));
            r47.setStartDelay(3900);
            r47.start();
            return;
        L33:
            r14 = false;
            goto L34
        L27:
            r11 = null;
            goto L29
        L67:
            return;
        L66:
            return;
        L16:
            r8 = null;
            goto L17
        L8:
            r7 = null;
            goto L9
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public g(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            if (((Boolean) r7).booleanValue() == false) goto L23;
            FastGiftViewV3 r8 = this.a;
            int r0 = FastGiftViewV3.O;
            r8.getClass();
            if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.a() == false) goto L25;
            Long r1 = r8.x;
            if (r1 == null) goto L24;
            long r2 = r1.longValue();
            DataCenter r3 = r8.B;
            if (r3 == null) goto L12;
            IRoom r4 = (IRoom) r3.get("data_room", null);
        L14:
            if (r8.A.enableGift() == true) goto L20;
            boolean r5 = true;
            if (r4 != null) goto L18;
        L21:
            r8.h(r4, r2, r5);
            r8.x = null;
            return;
        L18:
            if (r4.isMediaRoom() != true) goto L21;
        L20:
            r5 = false;
            goto L21
        L12:
            r4 = null;
            goto L14
        L24:
            return;
        L25:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public h(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            FastGiftViewV3 r0 = this.a;
            int r1 = 0;
            if (r5 == null) goto L5;
            boolean r6 = r5.booleanValue();
        L6:
            int r2 = FastGiftViewV3.O;
            TextView r3 = (TextView) r0.a(2131374382);
            if (r3 == null) goto L13;
            if (r6 == true) goto L11;
            r1 = 8;
        L11:
            r3.setVisibility(r1);
            return;
        L13:
            return;
        L5:
            r6 = false;
            goto L6
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public i(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            if (Intrinsics.areEqual((Boolean) r15, Boolean.TRUE) == false) goto L66;
            FastGiftViewV3 r16 = this.a;
            if (r16.j == true) goto L7;
            return;
        L7:
            if (r16.A.hasGift() == false) goto L68;
            Dialog r0 = r16.l;
            if (r0 != null) goto L11;
        L13:
            DataCenter r1 = r16.B;
            String r2 = null;
            if (r1 == null) goto L16;
            IRoom r3 = (IRoom) r1.get("data_room", null);
        L17:
            StringBuilder r4 = new StringBuilder("roomId:");
            if (r3 == null) goto L20;
            Long r5 = Long.valueOf(r3.getRoomId());
        L21:
            r4.append(r5);
            r4.append(" code:");
            r4.append(r16.hashCode());
            r4.append("viewmodule:");
            r4.append(r16.A.hashCode());
            ALogger.i("showConfirm", r4.toString());
            h1 r6 = r16.A.getGift();
            my1.a r7 = r16.A.getFastTaskGiftModel();
            if (r7 == null) goto L26;
            my1.b r8 = r7.a;
            if (r8 == null) goto L26;
            my1.c r9 = r8.preSendConfirm;
        L27:
            if (r9 == null) goto L29;
            r2 = r9.mainText;
        L29:
            int r10 = 0;
            long r11 = 0;
            if (TextUtils.isEmpty(r2) == true) goto L41;
            if (r6 == null) goto L33;
            r11 = r6.getId();
        L33:
            if (r6 == null) goto L35;
            r10 = r6.getDiamondCount();
        L35:
            AppCompatDialog r13 = new FastTaskGiftConfirmDialog(r16.getContext(), r9, new com.bytedance.android.livesdk.gift.fastgift.t(r16, r11, r10));
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L64;
            DialogLancet.handleBlockedDialogShow(r13);
        L40:
            com.bytedance.android.livesdk.gift.fastgift.a.c(r11, r10, "gift_coin_task");
            return;
        L64:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L63
        L39:
            DialogLancet.beforeDialogShow(r13);
            r13.show();
            DialogLancet.afterDialogShow(r13);
            goto L40
        L41:
            Object[] r14 = new Object[3];
            if (r6 == null) goto L45;
            String r17 = r6.getName();
            if (r17 == null) goto L45;
        L46:
            r14[0] = r17;
            if (r6 == null) goto L49;
            int r18 = r6.getDiamondCount();
        L50:
            r14[1] = Integer.valueOf(r18);
            r14[2] = r3.b();
            String r19 = s1.C(2131919087, r14);
            com.bytedance.android.livesdk.gift.fastgift.a.a();
            if (r6 == null) goto L53;
            r11 = r6.getId();
        L53:
            long r20 = r11;
            if (r6 == null) goto L56;
            int r110 = r6.getDiamondCount();
        L58:
            if (r16.A.getRemindUserByGiftPrice() == false) goto L60;
            String r21 = "money_change";
        L61:
            String r111 = r21;
            com.bytedance.android.livesdk.gift.fastgift.a.c(r20, r110, r111);
            GiftCommonHintView r23 = new GiftCommonHintView(r16.getContext());
            r23.setTitle(r19);
            com.bytedance.android.livesdk.e.b().a();
            cs2.b r112 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r16.getContext(), 6);
            r112.a.setContentView(r23);
            r112.a.a(0, 2131919094, new com.bytedance.android.livesdk.gift.fastgift.n(r16, r20, r110, r111));
            r112.a.a(1, 2131919085, new com.bytedance.android.livesdk.gift.fastgift.o(r20, r110, r111));
            r112.a.setOnDismissListener(com.bytedance.android.livesdk.gift.fastgift.p.a);
            r16.l = r112.h();
            return;
        L60:
            r21 = "gift_change";
            goto L61
        L56:
            r110 = 0;
            goto L58
        L49:
            r18 = 0;
        L45:
            r17 = BuildConfig.FLAVOR;
        L26:
            r9 = null;
            goto L27
        L20:
            r5 = null;
            goto L21
        L16:
            r3 = null;
            goto L17
        L11:
            if (r0.isShowing() != true) goto L13;
            return;
        L68:
            return;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public j(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            if (Intrinsics.areEqual((Boolean) r9, Boolean.TRUE) == false) goto L24;
            FastGiftViewV3 r10 = this.a;
            if (r10.j == true) goto L7;
            return;
        L7:
            if (r10.A.hasGift() == false) goto L26;
            Dialog r0 = r10.l;
            if (r0 != null) goto L11;
        L13:
            com.bytedance.android.livesdk.gift.fastgift.a.a();
            h1 r1 = r10.A.getGift();
            String r2 = r10.A.getToolbarButtonName();
            Intrinsics.checkNotNullParameter(r2, "componentType");
            HashMap r3 = new HashMap();
            r3.put("component_type", r2);
            mz0.n r4 = new mz0.n();
            Map r5 = r4.a;
            Intrinsics.checkNotNullParameter(r5, "map");
            Intrinsics.checkNotNullParameter(r3, "map");
            r5.putAll(r3);
            mz0.m r6 = new mz0.m();
            r6.b(LogCommon.ROOM);
            r6.b(LogCommon.PAGE_SOURCE_LOG);
            List r7 = r4.b;
            ArrayList r8 = (ArrayList) r7;
            r8.addAll(r6.a);
            cy0.e.a.getClass();
            cy0.j r11 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r13);
            ((f80.a) r13).w3("livesdk_gift_convenient_popup_show", r4.a, r4.b);
            Object[] r14 = new Object[3];
            if (r1 == null) goto L17;
            String r15 = r1.getName();
            if (r15 == null) goto L17;
        L18:
            r14[0] = r15;
            if (r1 == null) goto L21;
            int r16 = r1.getDiamondCount();
        L22:
            r14[1] = Integer.valueOf(r16);
            r14[2] = r3.b();
            String r17 = s1.C(2131919087, r14);
            String r18 = s1.B(2131919089);
            String r19 = s1.B(2131919093);
            FastGiftDialogHintView r20 = new FastGiftDialogHintView(r10.getContext());
            r20.a.setText(r18);
            r20.b.setText(r17);
            r20.c.setText(r19);
            com.bytedance.android.livesdk.e.b().a();
            cs2.b r21 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r10.getContext(), 6);
            r21.a.setContentView(r20);
            com.bytedance.android.livesdk.gift.fastgift.q r23 = new com.bytedance.android.livesdk.gift.fastgift.q(r10, r20, r2);
            r21.a.a(0, 2131919094, r23);
            com.bytedance.android.livesdk.gift.fastgift.r r24 = new com.bytedance.android.livesdk.gift.fastgift.r(r2, r20);
            r21.a.a(1, 2131919085, r24);
            com.bytedance.android.livesdk.gift.fastgift.s r25 = com.bytedance.android.livesdk.gift.fastgift.s.a;
            r21.a.setOnDismissListener(r25);
            r10.l = r21.h();
            return;
        L21:
            r16 = 0;
        L17:
            r15 = BuildConfig.FLAVOR;
            goto L18
        L11:
            if (r0.isShowing() != true) goto L13;
            return;
        L26:
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public k(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            if (Intrinsics.areEqual((Boolean) r8, Boolean.TRUE) == false) goto L23;
            FastGiftViewV3 r9 = this.a;
            if (r9.j == true) goto L7;
            return;
        L7:
            if (r9.A.hasGift() == false) goto L25;
            Dialog r0 = r9.m;
            if (r0 != null) goto L11;
        L13:
            h1 r1 = r9.A.getGift();
            int r6 = 0;
            RecommendFastGiftConfirmView r2 = new RecommendFastGiftConfirmView(r9.getContext(), null, 6, 0);
            Object[] r3 = new Object[3];
            if (r1 == null) goto L17;
            String r4 = r1.getName();
            if (r4 == null) goto L17;
        L18:
            r3[0] = r4;
            if (r1 == null) goto L21;
            r6 = r1.getDiamondCount();
        L21:
            r3[1] = Integer.valueOf(r6);
            r3[2] = r3.b();
            String r5 = s1.C(2131919087, r3);
            String r7 = s1.B(2131921923);
            r2.setMainText(r5);
            r2.setCheckedText(r7);
            r2.setLeftButtonText(s1.B(2131921921));
            r2.setRightButtonText(s1.B(2131921922));
            r2.setOnClickLeftButtonListener(new w(r9, r2));
            r2.setOnClickRightButtonListener(new x(r9, r2));
            cs2.b r10 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r9.getContext(), 6);
            r10.a.c(r2);
            r9.m = r10.h();
            com.bytedance.android.livesdk.gift.fastgift.a.a();
            return;
        L17:
            r4 = BuildConfig.FLAVOR;
            goto L18
        L11:
            if (r0.isShowing() != true) goto L13;
            return;
        L25:
            return;
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public l(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r18) {
            Integer r0 = (Integer) r18;
            FastGiftViewV3 r2 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L6:
            if (r1 != 0) goto L9;
            r2.getClass();
            return;
        L9:
            if (r2.A.isCombo() == true) goto L20;
            if (r2.d != null) goto L13;
            FastGiftViewV3$refreshComboUI$1 r3 = FastGiftViewV3$refreshComboUI$1.INSTANCE;
            Lazy r4 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r2, "target");
            Intrinsics.checkNotNullParameter(r3, "onAnimationEnd");
            ObjectAnimator r5 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{1.0f, 1.3f, 1.0f});
            ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{1.0f, 1.3f, 1.0f});
            AnimatorSet r7 = new AnimatorSet();
            r7.setInterpolator(new LinearInterpolator());
            r7.setDuration(300);
            r7.addListener(new com.bytedance.android.livesdk.gift.fastgift.di.b(r3));
            r7.playTogether(new Animator[]{r5, r6});
            r2.d = r7;
        L13:
            AnimatorSet r8 = r2.d;
            if (r8 == null) goto L16;
            r8.cancel();
        L16:
            AnimatorSet r9 = r2.d;
            if (r9 == null) goto L101;
            r9.start();
            return;
        L101:
            return;
        L20:
            if (r2.A.currentIsRecommend() == false) goto L29;
            AnimatorSet r10 = r2.u;
            if (r10 == null) goto L24;
            r10.removeAllListeners();
        L24:
            AnimatorSet r11 = r2.u;
            if (r11 == null) goto L27;
            r11.cancel();
        L27:
            r2.u = null;
        L29:
            if (r2.z == true) goto L34;
            r2.z = true;
            com.bytedance.android.livesdk.revenue.service.toolbar.d r13 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.d.class);
            if (r13 == null) goto L33;
            r13.lock(r2);
        L33:
            r2.o.setVisibility(0);
        L34:
            ObjectAnimator r14 = r2.c;
            if (r14 != null) goto L40;
            ObjectAnimator r15 = ObjectAnimator.ofFloat(r2.a(2131370135), "progress", new float[]{360.0f, 0.0f});
            r2.c = r15;
            if (r15 == null) goto L44;
            r15.addListener(new com.bytedance.android.livesdk.gift.fastgift.f(r2));
        L44:
            CircleProgressViewV3 r16 = r2.a(2131370135);
            if (r16 == null) goto L47;
            r16.setVisibility(0);
        L47:
            ObjectAnimator r17 = r2.c;
            if (r17 == null) goto L50;
            r17.setDuration(((long) r2.y) * 1000);
        L50:
            ObjectAnimator r19 = r2.c;
            if (r19 == null) goto L54;
            r19.start();
        L54:
            if (r1 != 1) goto L65;
            if (r2.f != null) goto L58;
            View r20 = r2.a(2131372147);
            Lazy r110 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r20, "target");
            AnimatorSet r111 = new AnimatorSet();
            ObjectAnimator r21 = ObjectAnimator.ofFloat(r20, "scaleX", new float[]{1.0f, 1.24f});
            ObjectAnimator r23 = ObjectAnimator.ofFloat(r20, "scaleY", new float[]{1.0f, 1.24f});
            r21.setDuration(100);
            r23.setDuration(100);
            r111.playTogether(new Animator[]{r21, r23});
            r2.f = r111;
        L58:
            AnimatorSet r24 = r2.f;
            if (r24 == null) goto L61;
            r24.cancel();
        L61:
            AnimatorSet r25 = r2.f;
            if (r25 == null) goto L74;
            r25.start();
        L74:
            if (r2.h != null) goto L76;
            FastGiftComboView r26 = r2.o;
            Lazy r27 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r26, "target");
            Lazy r28 = FastGiftAnimationCreator.c;
            ObjectAnimator r29 = ObjectAnimator.ofFloat(r26, "translationY", new float[]{((Number) FastGiftAnimationCreator.a.getValue()).floatValue(), ((Number) r28.getValue()).floatValue()});
            Lazy r30 = FastGiftAnimationCreator.b;
            ObjectAnimator r112 = ObjectAnimator.ofFloat(r26, "translationY", new float[]{((Number) r28.getValue()).floatValue(), ((Number) r30.getValue()).floatValue()});
            ObjectAnimator r31 = ObjectAnimator.ofFloat(r26, "translationY", new float[]{((Number) r30.getValue()).floatValue(), -0.0f});
            ValueAnimator r33 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r29.setDuration(100);
            r112.setDuration(150);
            r33.setDuration(550);
            r31.setDuration(200);
            AnimatorSet r113 = new AnimatorSet();
            r113.playSequentially(new Animator[]{r29, r112, r33, r31});
            r2.h = r113;
        L76:
            AnimatorSet r34 = r2.h;
            if (r34 == null) goto L79;
            r34.cancel();
        L79:
            ((TextView) r2.o.a(2131367236)).setText(String.valueOf(r1));
            AnimatorSet r35 = r2.h;
            if (r35 == null) goto L83;
            r35.start();
        L83:
            if (r2.i != null) goto L85;
            FastGiftComboView r36 = r2.o;
            Lazy r37 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r36, "target");
            ObjectAnimator r38 = ObjectAnimator.ofFloat(r36, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator r39 = ObjectAnimator.ofFloat(r36, "alpha", new float[]{1.0f, 0.0f});
            ValueAnimator r40 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r38.setDuration(100);
            r39.setDuration(200);
            r40.setDuration(700);
            AnimatorSet r41 = new AnimatorSet();
            r41.playSequentially(new Animator[]{r38, r40, r39});
            r2.i = r41;
        L85:
            AnimatorSet r43 = r2.i;
            if (r43 == null) goto L88;
            r43.cancel();
        L88:
            AnimatorSet r44 = r2.i;
            if (r44 == null) goto L91;
            r44.start();
        L91:
            Disposable r45 = r2.F;
            if (r45 != null) goto L94;
        L98:
            r2.F = Observable.timer(((long) r2.y) * 1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.fastgift.g(r2));
            return;
        L94:
            if (r45.isDisposed() == true) goto L98;
            Disposable r46 = r2.F;
            if (r46 == null) goto L98;
            r46.dispose();
            goto L98
        L65:
            if (r2.e != null) goto L67;
            View r47 = r2.a(2131372147);
            Lazy r114 = FastGiftAnimationCreator.a;
            Intrinsics.checkNotNullParameter(r47, "target");
            AnimatorSet r115 = new AnimatorSet();
            ObjectAnimator r116 = ObjectAnimator.ofFloat(r47, "scaleX", new float[]{1.24f, 1.16f});
            ObjectAnimator r117 = ObjectAnimator.ofFloat(r47, "scaleY", new float[]{1.24f, 1.16f});
            r116.setDuration(50);
            r117.setDuration(50);
            ObjectAnimator r48 = ObjectAnimator.ofFloat(r47, "scaleX", new float[]{1.16f, 1.24f});
            ObjectAnimator r49 = ObjectAnimator.ofFloat(r47, "scaleY", new float[]{1.16f, 1.24f});
            r48.setDuration(100);
            r49.setDuration(100);
            r115.play(r116).with(r117).before(r48).before(r49);
            r2.e = r115;
        L67:
            AnimatorSet r50 = r2.e;
            if (r50 == null) goto L70;
            r50.cancel();
        L70:
            AnimatorSet r51 = r2.e;
            if (r51 == null) goto L74;
            r51.start();
            goto L74
        L40:
            if (r14.isRunning() != true) goto L44;
            ObjectAnimator r53 = r2.c;
            if (r53 == null) goto L44;
            r53.cancel();
            goto L44
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;

        public m(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.gift.platform.core.model.c r3 = (com.bytedance.android.livesdk.gift.platform.core.model.c) r2;
            FastGiftViewV3 r4 = this.a;
            int r0 = FastGiftViewV3.O;
            r4.m();
        }
    }

    public static final class n<T> implements Observer {
        public final /* synthetic */ FastGiftViewV3 a;

        public n(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            final Pair r8 = (Pair) r7;
            UtilityKotlinExtentionsKt.s(0, false, false, new FastGiftViewV3$onAttachedToWindow$9$1(this, r8), 7);
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;

        public o(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            FastGiftViewV3.e(this.a, 2);
        }
    }

    public static final class p<T> implements Predicate {
        public final /* synthetic */ FastGiftViewV3 a;

        public p(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final boolean test(Object r2) {
            Intrinsics.checkNotNullParameter((Long) r2, "it");
            FastGiftViewV3 r3 = this.a;
            if (r3.J >= r3.I.f()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;

        public q(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            FastGiftViewV3.e(this.a, 2);
            this.a.J++;
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;

        public r(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            FastGiftViewV3 r0 = this.a;
            if (r0.M == false) goto L10;
            FrameLayout r1 = (FrameLayout) r0.a(2131372147);
            if (r1 == null) goto L9;
            r1.setBackground(new BitmapDrawable(null, r5));
            return;
        L9:
            return;
        }
    }

    public static final class s implements p0 {
        public final /* synthetic */ FastGiftViewV3 a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ h1 c;
        public final /* synthetic */ long d;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.e0 e;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public final void c(py.k r8, int r9, int r10, boolean r11) {
            FastGiftViewV3.c(this.a, (py.k) this.b.element, this.c, this.d, null, this.e);
        }

        public s(FastGiftViewV3 r1, Ref.ObjectRef r2, h1 r3, long r4, com.bytedance.android.livesdk.gift.platform.core.model.e0 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }
    }

    public static final class t<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ h1 c;
        public final /* synthetic */ long d;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.core.model.e0 e;

        public t(FastGiftViewV3 r1, Ref.ObjectRef r2, h1 r3, long r4, com.bytedance.android.livesdk.gift.platform.core.model.e0 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r8) {
            Bitmap r5 = (Bitmap) r8;
            FastGiftViewV3.c(this.a, (py.k) this.b.element, this.c, this.d, r5, this.e);
        }
    }

    public static final class u<T> implements Consumer {
        public final /* synthetic */ FastGiftViewV3 a;

        public u(FastGiftViewV3 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            FastGiftViewV3 r4 = this.a;
            int r0 = FastGiftViewV3.O;
            r4.m();
        }
    }

    public final class v implements Consumer {
        public final /* synthetic */ Function1 a;

        public v(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public FastGiftViewV3(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FastGiftViewV3(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    private final lr2.a getPaidLiveService() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
    }

    private final yz0.k getRoomDataService() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
    }

    private final h01.a getToolbarService() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), h01.a.class);
    }

    public final void f() {
        if (this.j == true) goto L5;
        return;
    L5:
        AnimatorSet r0 = this.t;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        AnimatorSet r1 = this.s;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        AnimatorSet r2 = this.q;
        if (r2 == null) goto L14;
        r2.cancel();
    L14:
        AnimatorSet r3 = this.r;
        if (r3 == null) goto L17;
        r3.cancel();
    L17:
        a(2131388219).setVisibility(8);
        this.p.setVisibility(8);
    }

    public final h1 getGift() {
        return this.A.getGift();
    }

    public final void k() {
        if (this.j == true) goto L6;
        return;
    L6:
        if (this.L.isDisposed() == true) goto L8;
        this.L.dispose();
    L8:
        AutoRTLImageView r0 = a(2131372145);
        if (r0 == null) goto L11;
        r0.setVisibility(0);
    L11:
        HSImageView r1 = a(2131382756);
        if (r1 == null) goto L20;
        r1.setVisibility(8);
        DraweeController r2 = r1.getController();
        if (r2 == null) goto L18;
        Animatable r3 = r2.getAnimatable();
        if (r3 == null) goto L18;
        r3.stop();
    L18:
        r1.setController(null);
        return;
    }

    public final void m() {
        o(this.A.getGift());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.b.markState(Lifecycle.State.DESTROYED);
        this.j = false;
        AnimatorSet r1 = this.u;
        if (r1 == null) goto L5;
        r1.removeAllListeners();
    L5:
        AnimatorSet r2 = this.u;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        this.u = null;
        Disposable r3 = this.v;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        this.v = null;
        this.A.getRecommendGift().removeObservers(this);
        this.A.getRecommendStatus().removeObservers(this);
        this.A.reset();
        this.z = false;
        com.bytedance.android.livesdk.revenue.service.toolbar.d r4 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.d.class);
        if (r4 == null) goto L14;
        r4.lock(this);
    L14:
        Disposable r5 = this.E;
        if (r5 != null) goto L17;
    L22:
        this.x = null;
        this.D.clear();
        Disposable r6 = this.K;
        if (r6 == null) goto L25;
        r6.dispose();
    L25:
        k();
        f();
        this.J = 0;
        super.onDetachedFromWindow();
        return;
    L17:
        if ((!r5.isDisposed()) == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L22;
        r5.dispose();
        goto L22
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = true;
        this.b.markState(Lifecycle.State.STARTED);
        l(true);
        CircleProgressViewV3 r0 = a(2131370135);
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        AutoRTLImageView r1 = a(2131372145);
        if (r1 == null) goto L8;
        r1.setOnClickListener(new com.bytedance.android.livesdk.gift.fastgift.h(this));
    L8:
        HSImageView r2 = a(2131382756);
        if (r2 == null) goto L11;
        r2.setOnClickListener(new com.bytedance.android.livesdk.gift.fastgift.i(this));
    L11:
        com.bytedance.android.livesdk.r3.a(a(2131372145), getContext().getResources().getString(2131914469));
        this.A.initMessageObserver();
        this.A.getFastGift().observe(this, new f(this));
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.a() == false) goto L14;
        this.A.getBehaviorVisible().observe(this, new g(this));
    L14:
        this.A.getFastGiftHint().observe(this, new h(this));
        this.A.getNeedConfirm().observe(this, new i(this));
        this.A.getNeedErrorConfirm().observe(this, new j(this));
        this.A.getNeedRecommendConfirm().observe(this, new k(this));
        this.A.getComboCount().observe(this, new l(this));
        m();
        ((ObservableSubscribeProxy) xs2.b.a().a.ofType(com.bytedance.android.livesdk.gift.platform.core.model.c.class).observeOn(RxUtil.getLiveMainThreadP5Scheduler()).as(AutoDispose.bind(this))).subscribe(new m(this));
        this.A.getRecommendGift().observe(this, new n(this));
        this.A.getRecommendStatus().observe(this, new e(this));
    }

    public final int getFastGiftImageSize() {
        return this.N;
    }

    public Lifecycle getLifecycleCompat() {
        return this.b;
    }

    public static final /* synthetic */ lr2.a b(FastGiftViewV3 r0) {
        return r0.getPaidLiveService();
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void g(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.B = r3;
        r3.put("data_has_fast_gift", Boolean.FALSE);
        FastGiftViewModel r0 = this.A;
        yz0.k r1 = getRoomDataService();
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        r0.bindCurrentRoom(r3, r2);
        this.A.initFollowStateChanged();
        this.k = ((Boolean) r3.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        m();
        l(true);
        yz0.k r4 = getRoomDataService();
        if (r4 == null) goto L13;
        IRoom r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IBaseUser r6 = r5.getOwner();
        if (r6 == null) goto L13;
        boolean r7 = r6.isFollowing();
    L14:
        j(true, r7);
        this.A.getOpenPopupGiftDialog().observe(this, new c(this));
        this.A.getFollowState().observe(this, new d(this));
        return;
    L13:
        r7 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void i(int r13) {
        if (this.A.disallowSendGiftDurationRecommend() == false) goto L5;
        return;
    L5:
        Object r0 = getContext().getSystemService("vibrator");
        if (r0 == null) goto L66;
        ((Vibrator) r0).vibrate(50);
        DataCenter r1 = this.B;
        List<com.bytedance.android.livesdk.gift.platform.core.model.z> r2 = null;
        if (r1 == null) goto L10;
        IRoom r3 = (IRoom) r1.get("data_room", null);
    L11:
        boolean r4 = this.k;
        long r5 = this.A.getGiftId();
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r6 = GiftManagerKt.x();
        my1.a r7 = this.A.getFastTaskGiftModel();
        Map<String, String> r8 = this.A.getRecommendLog();
        int r9 = this.A.getRecommendNum();
        if (r3 == null) goto L16;
        IBaseUser r10 = r3.getOwner();
        if (r10 == null) goto L16;
        String r11 = r10.getIdString();
    L17:
        com.bytedance.android.livesdk.gift.fastgift.a.e(r4, r5, r6, r13, r7, r8, r9, r11);
        h01.a r14 = getToolbarService();
        if (r14 == null) goto L21;
        r14.y9(this.B, com.bytedance.android.livesdk.gift.platform.core.utils.u.r());
    L21:
        if (this.j == false) goto L71;
        AnimatorSet r15 = this.d;
        if (r15 != null) goto L25;
    L27:
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r16 = GiftManagerKt.x();
        if (r16 != null) goto L30;
        k();
        if (this.j == true) goto L49;
        return;
    L49:
        if (this.A.hasGift() == false) goto L74;
        GiftContext r17 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r17 == null) goto L56;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revenue.common.n> r18 = r17.getToolbarGiftAnimController();
        if (r18 == null) goto L56;
        r2 = (com.bytedance.android.live.revenue.common.n) r18.getValue();
    L56:
        if (r2 == null) goto L58;
        r2.s();
    L58:
        lr2.a r19 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r19 != null) goto L61;
    L63:
        this.A.sendGiftTransaction();
        return;
    L61:
        if (r19.Pe(PaidInteractEntry.CONTROL_ENTRY_GIFT) == true) goto L63;
        return;
    L74:
        return;
    L30:
        if (this.A.isFirstRechargePopupGiftValid() == true) goto L32;
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(getContext(), r16.d());
        return;
    L32:
        if (this.A.getRechargedState() != 2) goto L43;
        List<com.bytedance.android.livesdk.gift.platform.core.model.z> r110 = r16.b();
        if (r110 != null) goto L36;
        return;
    L36:
        if (r110.size() != 2) goto L38;
        boolean r20 = true;
    L39:
        if (r20 == false) goto L41;
        r2 = r110;
    L41:
        if (r2 == null) goto L68;
        zz0.h.b(getContext(), ((com.bytedance.android.livesdk.gift.platform.core.model.z) ListProtector.get(r2, 1)).d());
        return;
    L68:
        return;
    L38:
        r20 = false;
        goto L39
    L43:
        zz0.h.b(getContext(), r16.d());
        return;
    L25:
        if (r15.isRunning() != true) goto L27;
        return;
    L71:
        return;
    L16:
        r11 = null;
        goto L17
    L10:
        r3 = null;
        goto L11
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    public final void l(boolean r8) {
        KmpEnv r9 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L12;
        IRoom r10 = this.A.getRoom();
        if (r10 == null) goto L12;
        if (r10.isD3Room() != true) goto L12;
        if (this.A.enableGift() == false) goto L12;
        int r11 = 2131253133;
    L17:
        IRoom r1 = this.A.getRoom();
        h01.a r2 = getToolbarService();
        if (r2 == null) goto L23;
        RevToolbarConstants r4 = RevToolbarConstants.BackUpBorder;
        if (r1 == null) goto L23;
        boolean r3 = r2.wk(r4, r1, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k(), RevResKeyEnum.STATIC_ICON);
    L24:
        if (r3 == false) goto L37;
        this.M = true;
        yz0.k r13 = getRoomDataService();
        Disposable r0 = null;
        if (r13 == null) goto L32;
        dq2.a r14 = r13.getActivityRoomSkinInfo();
        if (r14 == null) goto L32;
        Map r15 = r14.b();
        if (r15 == null) goto L32;
        py.k r16 = (py.k) r15.get(Integer.valueOf(RevSkinConstants.BackUpBorder.getValue()));
    L33:
        Observable r17 = a1.k(r16).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        if (r17 == null) goto L36;
        r0 = r17.subscribe(new r(this));
    L36:
        this.K = r0;
        return;
    L32:
        r16 = null;
        goto L33
    L37:
        this.M = false;
        FrameLayout r5 = (FrameLayout) a(2131372147);
        if (r5 == null) goto L42;
        r5.setBackgroundResource(r11);
        return;
    L42:
        return;
    L23:
        r3 = false;
    L12:
        if (g02.a.e() == false) goto L14;
    L16:
        r11 = 2131252270;
        goto L17
    L14:
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L16;
        r11 = 2131252271;
        goto L17
    }

    public final void o(h1 r17) {
        if (this.j == true) goto L5;
        return;
    L5:
        if (this.w == false) goto L8;
        return;
    L8:
        if (this.A.isAnchor() == false) goto L13;
        DataCenter r0 = this.B;
        if (r0 == null) goto L56;
        r0.put("data_has_fast_gift", Boolean.FALSE);
        return;
    L56:
        return;
    L13:
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r6 = GiftManagerKt.x();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        py.k r1 = null;
        if (r6 == null) goto L17;
        py.k r3 = r6.e();
        if (r3 == null) goto L17;
    L20:
        if (r3 != null) goto L22;
        return;
    L22:
        r2.element = r3;
        if (this.A.isFirstRechargePopupGiftValid() == false) goto L26;
        long r4 = GiftManagerKt.r();
    L25:
        long r5 = r4;
        if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L40;
        py.k r7 = (py.k) r2.element;
        if (r17 == null) goto L35;
        r1 = r17.getImage();
    L35:
        if (Intrinsics.areEqual(r7, r1) == false) goto L40;
        if (r5 != 463) goto L40;
        int r8 = qy.a.a;
        r2.element = qy.a.b(BuildConfig.FLAVOR, CollectionsKt.listOf(new String[]{ev1.q.a + "live_toolbar_ic_v2_fastgift_static_2.png", ev1.q.b + "live_toolbar_ic_v2_fastgift_static_2.png", ev1.q.c + "live_toolbar_ic_v2_fastgift_static_2.png"}));
    L40:
        if (com.bytedance.android.livesdk.gift.platform.business.b.d() == false) goto L42;
        ImageView r9 = (ImageView) a(2131372145);
        py.k r10 = (py.k) r2.element;
        int r13 = this.N;
        ImageUtil.loadImage(r9, r10, r13, r13, false, 0, new s(this, r2, r17, r5, r6));
    L43:
        TextView r11 = (TextView) findViewById(2131373774);
        if (r17 == null) goto L46;
        int r14 = r17.getDiamondCount();
    L48:
        if (this.A.currentIsRecommend() == false) goto L54;
        if (r14 <= 0) goto L54;
        com.bytedance.android.livesdk.gift.platform.business.config.j r15 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r16 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        DiamondConfig r18 = (DiamondConfig) r15.c(r16, DiamondConfig.a.a());
        if (r11 == null) goto L53;
        r11.setText(String.valueOf(r14) + r18.b);
    L53:
        r11.setVisibility(0);
        return;
    L54:
        r11.setVisibility(8);
        return;
    L46:
        r14 = 0;
        goto L48
    L42:
        this.D.clear();
        this.D.add(b0.a(a1.k((py.k) r2.element).subscribeOn(Schedulers.io())).subscribe(new t(this, r2, r17, r5, r6), new u(this)));
        goto L43
    L26:
        if (r17 == null) goto L28;
        r4 = r17.getId();
        goto L25
    L28:
        r4 = 0;
    L17:
        if (r17 == null) goto L19;
        r3 = r17.getImage();
        goto L20
    L19:
        r3 = null;
        goto L20
    }

    public final void setFastGiftImageSize(int r1) {
        this.N = r1;
    }

    public static final void e(FastGiftViewV3 r7, int r8) {
        if (r7.j == true) goto L5;
        return;
    L5:
        if (((FastGiftViewModel.RecommendFastGiftStatus) r7.A.getRecommendStatus().getValue()) == FastGiftViewModel.RecommendFastGiftStatus.Idle) goto L8;
        return;
    L8:
        if (r8 != 1) goto L10;
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r0 = GiftManagerKt.x();
        if (r0 != null) goto L23;
        return;
    L23:
        if (r7.A.shouldShowIconPopUpAnim(r0) == true) goto L26;
        return;
    L26:
        if (r0.c() != null) goto L28;
        return;
    L28:
        if (r0.c().isValid() == false) goto L44;
        String r1 = (String) ListProtector.get(r0.c().getUrls(), 0);
    L31:
        HSImageView r3 = r7.a(2131382756);
        if (r3 == null) goto L34;
        r3.setVisibility(0);
    L34:
        HSImageView r2 = r7.a(2131382756);
        if (r2 == null) goto L40;
        r2.setController(Fresco.newDraweeControllerBuilder().setUri(r1).setAutoPlayAnimations(false).setControllerListener(new com.bytedance.android.livesdk.gift.fastgift.v(r7, r8)).build());
        return;
    L40:
        return;
    L44:
        return;
    L10:
        if (r8 == 2) goto L12;
        r1 = BuildConfig.FLAVOR;
        goto L31
    L12:
        r1 = com.bytedance.android.livesdk.gift.platform.business.a.e().c();
        HSImageView r4 = r7.a(2131382756);
        if (r4 == null) goto L31;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        r5.width = (int) UIUtils.dip2Px(r4.getContext(), 66.0f);
        r5.height = (int) UIUtils.dip2Px(r4.getContext(), 66.0f);
        r4.setLayoutParams(r5);
        DraweeController r6 = r4.getController();
        if (r6 == null) goto L31;
        Animatable r9 = r6.getAnimatable();
        if (r9 == null) goto L31;
        r9.stop();
        goto L31
    }

    public final void j(boolean r5, boolean r6) {
        if (this.j == false) goto L34;
        IRoom r0 = this.A.getRoom();
        boolean r1 = true;
        if (r0 == null) goto L9;
        if (r0.isMediaRoom() != true) goto L9;
        return;
    L9:
        if (((FastGiftViewModel.RecommendFastGiftStatus) this.A.getRecommendStatus().getValue()) != FastGiftViewModel.RecommendFastGiftStatus.Idle) goto L37;
        int r2 = k2.b;
        IRoom r3 = null;
        int r4 = ((Number) com.bytedance.android.livesdk.gift.platform.business.b.n.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[12])).intValue();
        if (r4 != 3) goto L14;
    L17:
        if (r1 == true) goto L19;
        return;
    L19:
        if (r5 == true) goto L23;
        if (r6 == true) goto L23;
        k();
        return;
    L23:
        if (r6 == false) goto L25;
        long r7 = this.I.d();
    L26:
        k();
        FastGiftViewModel r8 = this.A;
        yz0.k r9 = getRoomDataService();
        if (r9 == null) goto L30;
        r3 = r9.getRoom();
    L30:
        if (r8.isCommerceRoom(r3) == false) goto L32;
        this.L = b0.a(Observable.timer(r7, TimeUnit.MILLISECONDS)).subscribe(new o(this));
        return;
    L32:
        com.bytedance.android.live.core.utils.rxutils.j.a r10 = com.bytedance.android.live.core.utils.rxutils.j.a;
        this.L = b0.a(com.bytedance.android.live.core.utils.rxutils.j.a(r7, 3000 + this.I.e(), TimeUnit.MILLISECONDS).filter(new p(this))).subscribe(new q(this));
        return;
    L25:
        r7 = this.I.g();
        goto L26
    L14:
        if (r4 == 5) goto L17;
        r1 = false;
        goto L17
    L37:
        return;
    }

    public FastGiftViewV3(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.a = new LinkedHashMap();
        this.j = true;
        this.y = ((Number) com.bytedance.android.livesdk.gift.fastgift.d.g.getValue(null, com.bytedance.android.livesdk.gift.fastgift.d.a[5])).intValue();
        this.D = new CompositeDisposable();
        this.L = Disposables.disposed();
        this.N = -1;
        if (((LiveViewInflateConfig) gx0.a.getValue()).getGift() == false) goto L5;
        GiftNitaViewInfo r0 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_FAST_V3;
        NitaInflateUtil.a(r0.getResId(), r0.getTag(), (Activity) r5, this, true);
    L6:
        h01.a r8 = getToolbarService();
        if (r8 == null) goto L9;
        r8.k1(g02.a.e(), a(2131372147));
    L9:
        h01.a r9 = getToolbarService();
        if (r9 == null) goto L12;
        r9.k1(g02.a.e(), a(2131370135));
    L12:
        UIUtils.setLayoutParams(a(2131372145), com.bytedance.android.live.revenue.common.i.b(28), com.bytedance.android.live.revenue.common.i.b(28));
        UIUtils.setLayoutParams(a(2131374382), com.bytedance.android.live.revenue.common.i.b(30), com.bytedance.android.live.revenue.common.i.b(30));
        ViewGroup.LayoutParams r10 = a(2131372145).getLayoutParams();
        if (r10 == null) goto L31;
        this.G = (FrameLayout.LayoutParams) r10;
        this.H = new FrameLayout.LayoutParams(-1, -1);
        if (MultiRoomConfig.INSTANCE.fastGiftRev() == false) goto L17;
        this.A = (FastGiftViewModel) ViewModelProviders.of((FragmentActivity) r5).get(String.valueOf(hashCode()), FastGiftViewModel.class);
    L18:
        LifecycleRegistry r11 = new LifecycleRegistry(this);
        this.b = r11;
        r11.markState(Lifecycle.State.CREATED);
        FastGiftComboView r13 = (FastGiftComboView) findViewById(2131372146);
        this.o = r13;
        r13.setVisibility(8);
        TextView r14 = (TextView) findViewById(2131372165);
        this.p = r14;
        r14.setVisibility(8);
        if (com.bytedance.android.livesdk.gift.platform.core.h.d() == false) goto L21;
        this.N = com.bytedance.android.live.revenue.common.i.b(28);
    L21:
        this.I = com.bytedance.android.livesdk.gift.platform.business.a.e();
        Single r15 = Single.timer(3, TimeUnit.SECONDS);
        Intrinsics.checkNotNullParameter(r15, "$this$observeOnP4Ui");
        if (k60.b.d() == false) goto L24;
        Scheduler r16 = RxUtil.getLiveMainThreadP4Scheduler();
    L25:
        Single r17 = r15.observeOn(r16);
        a r18 = new a(this);
        Consumer r19 = AnonymousClass2.INSTANCE;
        if (r19 == null) goto L28;
        r19 = new v(r19);
    L28:
        this.E = r17.subscribe(r18, r19);
        return;
    L24:
        r16 = AndroidSchedulers.mainThread();
        goto L25
    L17:
        this.A = (FastGiftViewModel) ViewModelProviders.of((FragmentActivity) r5).get(FastGiftViewModel.class);
        goto L18
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L5:
        LayoutInflater.from(r5).inflate(2131567659, this);
        goto L6
    }

    public final void h(IRoom r17, long r18, boolean r20) {
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.a() == false) goto L9;
        if ((!Intrinsics.areEqual((Boolean) this.A.getBehaviorVisible().getValue(), Boolean.TRUE)) == false) goto L9;
        this.x = Long.valueOf(r18);
        return;
    L9:
        if (this.A.currentIsRecommend() == false) goto L11;
        return;
    L11:
        if (r17 == null) goto L48;
        String r11 = r17.getAnchorId();
        if (r11 != null) goto L16;
        return;
    L16:
        if (this.A.getPreGiftId() != r18) goto L20;
        if ((!Intrinsics.areEqual(this.A.getPreRoomOwnerId(), r11)) == true) goto L20;
        return;
    L20:
        if (r17.isMediaRoom() == true) goto L22;
    L24:
        IMainRoom r1 = r17.castToOrNull(IMainRoom.class);
        if (r1 == null) goto L29;
        Map r2 = r1.getAnchorAbMap();
        if (r2 == null) goto L29;
        String r3 = (String) r2.get("gift_hide_tip");
    L31:
        if (Intrinsics.areEqual(r3, "2") == false) goto L34;
        if (r20 == false) goto L34;
        return;
    L34:
        this.A.setPreGiftId(r18);
        this.A.setPreRoomOwnerId(r11);
        DataCenter r4 = this.B;
        if (r4 == null) goto L39;
        Long r5 = (Long) r4.get("room_enter_finish_time", -1L);
        if (r5 == null) goto L39;
        long r8 = r5.longValue();
    L40:
        DataCenter r6 = this.B;
        if (r6 == null) goto L45;
        Long r7 = (Long) r6.get("room_first_frame_time", -1L);
        if (r7 == null) goto L45;
        long r13 = r7.longValue();
    L46:
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.fastgift.a.f(r18, GiftManagerKt.x(), this.A.getFastTaskGiftModel(), r8, r13, null, this.A.getRecommendNum(), r11, 32);
        return;
    L45:
        r13 = 0;
    L39:
        r8 = 0;
    L29:
        r3 = null;
        goto L31
    L22:
        if (this.A.enableGift() == true) goto L24;
        return;
    }

    public /* synthetic */ FastGiftViewV3(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final void c(FastGiftViewV3 r8, py.k r9, h1 r10, long r11, Bitmap r13, com.bytedance.android.livesdk.gift.platform.core.model.e0 r14) {
        if (r9 != null) goto L4;
        r8.getClass();
        return;
    L4:
        r8.A.getShowInfo().a = r9;
        com.bytedance.android.livesdk.gift.platform.core.model.n r15 = r8.A.getShowInfo();
        String r0 = null;
        if (r10 == null) goto L7;
        String r1 = r10.getName();
    L8:
        boolean r3 = true;
        if ((!TextUtils.isEmpty(r1)) == true) goto L12;
        r1 = null;
    L12:
        if (r1 != null) goto L16;
        if (r10 == null) goto L15;
        r1 = r10.getDescribe();
        goto L16
    L15:
        r1 = null;
    L16:
        if (r1 != null) goto L18;
        r1 = BuildConfig.FLAVOR;
    L18:
        r15.b = r1;
        DataCenter r16 = r8.B;
        if (r16 == null) goto L21;
        IRoom r17 = (IRoom) r16.get("data_room", null);
    L23:
        if (r8.A.enableGift() == true) goto L28;
        if (r17 != null) goto L26;
    L27:
        boolean r18 = true;
    L30:
        if (r18 == false) goto L42;
        if (r17 == null) goto L38;
        IMainRoom r19 = r17.castToOrNull(IMainRoom.class);
        if (r19 == null) goto L38;
        Map r110 = r19.getAnchorAbMap();
        if (r110 == null) goto L38;
        r0 = (String) r110.get("gift_hide_tip");
    L38:
        if (Intrinsics.areEqual(r0, "2") == true) goto L40;
    L71:
        AutoRTLImageView r111 = r8.a(2131372145);
        if (r111 == null) goto L74;
        r111.setAlpha(1.0f);
    L74:
        DataCenter r112 = r8.B;
        if (r112 == null) goto L77;
        r112.put("data_has_fast_gift", Boolean.TRUE);
    L77:
        r8.h(r17, r11, r18);
        return;
    L40:
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == true) goto L71;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(r8.B).d(RevToolbarButton.FastGift);
        goto L71
    L42:
        if (r17 == null) goto L49;
        IMainRoom r6 = r17.castToOrNull(IMainRoom.class);
        if (r6 == null) goto L49;
        Map r7 = r6.getAnchorAbMap();
        if (r7 == null) goto L49;
        r0 = (String) r7.get("gift_hide_tip");
    L49:
        if (Intrinsics.areEqual(r0, "2") == false) goto L56;
        if (r8.A.enableGift() == false) goto L56;
        if (com.bytedance.android.livesdk.gift.platform.business.toolbar.c.b() == true) goto L56;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(r8.B).b(RevToolbarButton.FastGift);
    L56:
        if (com.bytedance.android.livesdk.gift.platform.business.b.d() == true) goto L61;
        if (r13 == null) goto L61;
        AutoRTLImageView r2 = r8.a(2131372145);
        if (r2 == null) goto L61;
        r2.setImageBitmap(r13);
    L61:
        if (r14 != null) goto L63;
    L69:
        FrameLayout.LayoutParams r113 = r8.G;
    L70:
        r8.a(2131372145).setLayoutParams(r113);
        goto L71
    L63:
        if (r14.a > 0) goto L66;
        r3 = false;
    L66:
        if (r3 == true) goto L69;
        r113 = r8.H;
        goto L70
    L26:
        if (r17.isMediaRoom() != true) goto L27;
    L28:
        r18 = false;
        goto L30
    L21:
        r17 = null;
        goto L23
    L7:
        r1 = null;
        goto L8
    }
}
