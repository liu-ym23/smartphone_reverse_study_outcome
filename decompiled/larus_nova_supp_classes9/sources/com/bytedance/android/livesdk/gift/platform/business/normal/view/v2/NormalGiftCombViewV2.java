package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.bytedance.android.live.revenue.common.f0;
import com.bytedance.android.live.revenue.common.h0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.configmodel.b2;
import com.bytedance.android.livesdk.gift.configmodel.v2;
import com.bytedance.android.livesdk.gift.configmodel.w;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.n3;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.o3;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.w3;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.ObjectAnimatorCompat;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.utils.GiftImageFormat;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftNitaViewInfo;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.google.gson.JsonSyntaxException;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\"\u0010\u001c\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u000e\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010*\u001a\u0004\u0018\u00010%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0014\u00103\u001a\u0002008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00107\u001a\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u0010;\u001a\u0004\u0018\u0001088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/NormalGiftCombViewV2;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/BaseNormalGiftCombView;", "Luu0/a;", "Landroid/animation/Animator;", "getGiftEntryAnimDegrade", BuildConfig.FLAVOR, "showCombo", BuildConfig.FLAVOR, "setShowCombo", BuildConfig.FLAVOR, "orientation", "setRoomOrientation", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", "setDuration", "Ls02/c;", "listener", "setClickListener", "getClickListener", "Ls02/b;", "callback", "setGiftControllerCallback", BuildConfig.FLAVOR, "b", "J", "getDuration", "()J", "(J)V", "duration", "Lio/reactivex/disposables/Disposable;", "H", "Lio/reactivex/disposables/Disposable;", "getDispose", "()Lio/reactivex/disposables/Disposable;", "setDispose", "(Lio/reactivex/disposables/Disposable;)V", "dispose", "Luu0/b;", "V", "Luu0/b;", "getPreviewData", "()Luu0/b;", "previewData", "getShowDynamicGiftIcon", "()Z", "showDynamicGiftIcon", "getAutoExit", "autoExit", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "getNormalGiftIconView", "()Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "normalGiftIconView", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getDynamicGiftIconView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "dynamicGiftIconView", "Landroid/view/View;", "getCurrentGiftIconView", "()Landroid/view/View;", "currentGiftIconView", "e", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NormalGiftCombViewV2 extends BaseNormalGiftCombView implements uu0.a {
    public static final /* synthetic */ int W = 0;
    public u3 A;
    public AnimatedDrawable2 B;
    public com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k C;
    public Disposable D;
    public final o E;
    public final TextView F;
    public final k G;
    public Disposable H;
    public int I;
    public Disposable J;
    public int K;
    public int L;
    public final dq2.d M;
    public final boolean N;
    public final Function0<Unit> O;
    public PointF P;
    public final int Q;
    public final com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.a R;
    public Animator S;
    public PointF T;
    public final boolean U;
    public final uu0.b V;
    public Map<Integer, View> a;
    public long b;
    public Animator c;
    public boolean d;
    public s02.c e;
    public NormalGiftMessage f;
    public Disposable g;
    public Disposable h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final n12.f l;
    public final q02.a m;
    public s02.a n;
    public s02.b o;
    public int p;
    public int q;
    public boolean r;
    public final boolean s;
    public final boolean t;
    public boolean u;
    public final boolean v;
    public i02.f w;
    public final int x;
    public final int y;
    public ViewGroup z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public a(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            NormalGiftCombViewV2 r4 = this.a;
            NormalGiftMessage r0 = r4.f;
            if (r0 == null) goto L10;
            IBaseUser r1 = r0.e;
            if (r1 == null) goto L11;
            s02.c r5 = r4.e;
            if (r5 == null) goto L12;
            r5.d(r1.getIdString(), this.a.f);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public b(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NormalGiftCombViewV2 r3 = this.a;
            s02.c r0 = r3.e;
            if (r0 == null) goto L6;
            r0.b(r3.f);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public c(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NormalGiftCombViewV2 r3 = this.a;
            s02.c r0 = r3.e;
            if (r0 == null) goto L6;
            r0.b(r3.f);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ NormalGiftCombViewV2 a;
        public final /* synthetic */ Context b;

        public d(NormalGiftCombViewV2 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            NormalGiftMessage r7 = this.a.f;
            int r0 = 0;
            IBaseUser r1 = null;
            if (r7 == null) goto L24;
            o7 r8 = r7.r();
            if (r8 == null) goto L24;
            o0 r9 = r8.getTrayInfo();
            if (r9 == null) goto L24;
            w3 r10 = r9.getTrayPreEffect();
            if (r10 == null) goto L24;
            String r11 = r10.getPreSchema();
            if (r11 == null) goto L24;
            if (r11.length() <= 0) goto L15;
            boolean r2 = true;
        L16:
            if (r2 == true) goto L19;
            r11 = null;
        L19:
            if (r11 == null) goto L24;
            if (StringsKt.equals$default(UriProtector.parse(r11).getHost(), "webcast_profile", false, 2, null) == false) goto L23;
            com.bytedance.android.livesdk.gift.platform.business.normal.utils.c.a(this.a.f);
        L23:
            com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(this.b, r11);
            goto L24
        L15:
            r2 = false;
        L24:
            NormalGiftMessage r13 = this.a.f;
            String r3 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
            LinkedHashMap r4 = new LinkedHashMap();
            String r5 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
            yz0.k r14 = com.bytedance.android.livesdk.gift.platform.core.utils.h.g();
            if (r14 == null) goto L29;
            IRoom r15 = r14.getRoom();
            if (r15 == null) goto L29;
            r1 = r15.getOwner();
        L29:
            r4.putAll(com.bytedance.android.livesdk.gift.platform.core.utils.h.J(r1, r13));
            if (r13 == null) goto L38;
            o7 r16 = r13.r();
            if (r16 == null) goto L38;
            o0 r17 = r16.getTrayInfo();
            if (r17 == null) goto L38;
            w3 r18 = r17.getTrayPreEffect();
            if (r18 == null) goto L38;
            r0 = r18.getPreEffectSource();
        L38:
            r4.put("effect_type", String.valueOf(r0));
            mz0.n r19 = new mz0.n();
            Map r20 = r19.a;
            Intrinsics.checkNotNullParameter(r20, "map");
            Intrinsics.checkNotNullParameter(r4, "map");
            r20.putAll(r4);
            mz0.m r21 = new mz0.m();
            r21.b(LogCommon.LIVE_SHARE_LOG);
            r21.b(LogCommon.ROOM);
            com.bytedance.android.livesdk.revenue.log.i r23 = vh6.c.b(kr2.a.class).ud();
            Intrinsics.checkNotNullParameter(r23, "pageSourceLog");
            ((ArrayList) r21.a).add(r23.a);
            ((ArrayList) r19.b).addAll(r21.a);
            cy0.e.a.getClass();
            cy0.j r24 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r25);
            ((f80.a) r25).w3("livesdk_gift_tray_pre_effect_click", r19.a, r19.b);
        }
    }

    public static final class e {
    }

    public static final class f extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ Function0 a;

        public f(Function0 r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            this.a.invoke();
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ NormalGiftCombViewV2 a;
        public final /* synthetic */ Context b;

        public g(NormalGiftCombViewV2 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            u3 r6 = this.a.A;
            int r0 = 0;
            IBaseUser r1 = null;
            if (r6 == null) goto L15;
            String r7 = r6.getPostSchema();
            if (r7 == null) goto L15;
            if (r7.length() <= 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L13;
            r7 = null;
        L13:
            if (r7 == null) goto L15;
            com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(this.b, r7);
            goto L15
        L9:
            r2 = false;
        L15:
            NormalGiftMessage r8 = this.a.f;
            String r3 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
            LinkedHashMap r4 = new LinkedHashMap();
            String r9 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
            yz0.k r10 = com.bytedance.android.livesdk.gift.platform.core.utils.h.g();
            if (r10 == null) goto L20;
            IRoom r11 = r10.getRoom();
            if (r11 == null) goto L20;
            r1 = r11.getOwner();
        L20:
            r4.putAll(com.bytedance.android.livesdk.gift.platform.core.utils.h.J(r1, r8));
            if (r8 == null) goto L29;
            o7 r13 = r8.r();
            if (r13 == null) goto L29;
            o0 r14 = r13.getTrayInfo();
            if (r14 == null) goto L29;
            u3 r15 = r14.getTrayPostEffect();
            if (r15 == null) goto L29;
            r0 = r15.getPostEffectSource();
        L29:
            r4.put("effect_type", String.valueOf(r0));
            if (r8 == null) goto L40;
            o7 r16 = r8.r();
            if (r16 == null) goto L40;
            o0 r17 = r16.getTrayInfo();
            if (r17 == null) goto L40;
            u3 r18 = r17.getTrayPostEffect();
            if (r18 == null) goto L40;
            Map<String, String> r19 = r18.getEventTrackingMap();
            if (r19 == null) goto L40;
            r4.putAll(r19);
        L40:
            mz0.n r20 = new mz0.n();
            Map r21 = r20.a;
            Intrinsics.checkNotNullParameter(r21, "map");
            Intrinsics.checkNotNullParameter(r4, "map");
            r21.putAll(r4);
            mz0.m r23 = new mz0.m();
            r23.b(LogCommon.LIVE_SHARE_LOG);
            r23.b(LogCommon.ROOM);
            com.bytedance.android.livesdk.revenue.log.i r24 = vh6.c.b(kr2.a.class).ud();
            Intrinsics.checkNotNullParameter(r24, "pageSourceLog");
            ((ArrayList) r23.a).add(r24.a);
            ((ArrayList) r20.b).addAll(r23.a);
            cy0.e.a.getClass();
            cy0.j r25 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r26);
            ((f80.a) r26).w3("livesdk_gift_tray_post_effect_click", r20.a, r20.b);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ NormalGiftCombViewV2 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ImageView c;

        public h(NormalGiftCombViewV2 r1, boolean r2, ImageView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (this.b == false) goto L8;
        L11:
            Bitmap r4 = RevBitmapTranslateUtils.b(r3);
        L12:
            if (r4 != null) goto L14;
            return;
        L14:
            if (r4.isRecycled() == true) goto L23;
            ImageView r0 = this.c;
            if (r0 == null) goto L19;
            r0.setImageBitmap(r4);
        L19:
            this.a.invalidate();
            return;
        L23:
            return;
        L8:
            if (r3.isRecycled() == true) goto L11;
            r4 = RevBitmapTranslateUtils.a(r3);
            goto L12
        }
    }

    public static final class i extends AnimatorListenerAdapter {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public i(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.G.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.G.d();
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ NormalGiftCombViewV2 a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Function1 c;

        public j(NormalGiftCombViewV2 r1, boolean r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            Bitmap r6 = (Bitmap) r5;
            NormalGiftCombViewV2 r0 = this.a;
            boolean r1 = this.b;
            if (r0.U == false) goto L6;
            float r2 = s1.e(28.0f);
        L14:
            int r3 = (int) r2;
            if (r6 != null) goto L17;
        L20:
            if (r1 == false) goto L22;
            Bitmap r7 = r0.z(BitmapFactory.decodeResource(r0.getResources(), 2131250964), r3, r3);
        L23:
            if (r7 != null) goto L25;
            return;
        L25:
            if (r7.isRecycled() == true) goto L30;
            this.c.invoke(r7);
            return;
        L30:
            return;
        L22:
            r7 = null;
            goto L23
        L17:
            if (r6.isRecycled() == true) goto L20;
            r7 = r0.z(RevBitmapTranslateUtils.a(r6), r3, r3);
            goto L23
        L6:
            if (r0.r == false) goto L11;
            if (r0.s == true) goto L11;
            r2 = s1.e(32.0f);
        L11:
            if (u.p() == false) goto L13;
            r2 = s1.e(24.0f);
            goto L14
        L13:
            r2 = s1.e(40.0f);
            goto L14
        }
    }

    public static final class k implements q02.d {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ k a;

            public a(k r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Long r2 = (Long) r1;
                this.a.f();
            }
        }

        @Override // q02.d
        public final void a() {
            NormalGiftMessage r0 = this.a.f;
            if ((r0 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L12;
            if (r0 == null) goto L12;
            h2 r1 = r0.w;
            if (r1 == null) goto L12;
            if (r1.getType() != 15) goto L12;
            NormalGiftCombViewV2 r2 = this.a;
            if (r2.K != 0) goto L12;
            NormalGiftCombViewV2.q(r2);
            this.a.A(false);
        L12:
            NormalGiftCombViewV2 r3 = this.a;
            if (r3.s == false) goto L15;
            return;
        L15:
            r3.M();
            if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.c() == false) goto L18;
        L58:
            c();
        L60:
            if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.A.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[25])).booleanValue() == false) goto L70;
            NormalGiftCombViewV2 r4 = this.a;
            com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r5 = r4.C;
            if (r5 != null) goto L64;
        L67:
            long r6 = 0;
        L68:
            NormalGiftCombViewV2.r(r4, r6 - ((long) 200));
            return;
        L64:
            if (r5.b.isEmpty() == true) goto L67;
            r6 = ((o3) ListProtector.get(r5.b, 0)).getDuration();
            goto L68
        L70:
            return;
        L18:
            if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.a() == true) goto L58;
            GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r7 == null) goto L25;
            com.bytedance.live.datacontext.m<Boolean> r8 = r7.getCancelComboForDegradeInMatch();
            if (r8 == null) goto L25;
            if (((Boolean) r8.getValue()).booleanValue() == true) goto L58;
        L25:
            NormalGiftCombViewV2 r9 = this.a;
            NormalGiftMessage r10 = r9.f;
            if ((r10 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L28;
        L43:
            boolean r11 = true;
        L44:
            if (r11 == false) goto L58;
            NormalGiftCombViewV2 r13 = this.a;
            if (r13.d == false) goto L58;
            if (r13.o(2131367231) == null) goto L58;
            NormalGiftCombViewV2 r14 = this.a;
            if (r14.K != 0) goto L52;
            NormalGiftCombViewV2.q(r14);
            this.a.A(false);
        L52:
            LinearLayout r15 = (LinearLayout) this.a.o(2131367231);
            if (r15 == null) goto L55;
            r15.setVisibility(0);
        L55:
            NormalGiftCombViewV2 r16 = this.a;
            r16.c = r16.m.d(r16.o(2131367231), this);
            NormalGiftCombViewV2 r17 = this.a;
            r17.j = true;
            Animator r18 = r17.c;
            if (r18 == null) goto L60;
            r18.start();
            goto L60
        L28:
            if (b02.a.b(r10) == false) goto L42;
            NormalGiftMessage r19 = r9.f;
            if (r19 == null) goto L32;
            List<n3> r20 = r19.F;
        L33:
            List<n3> r21 = r20;
            if (r21 != null) goto L36;
        L39:
            boolean r23 = true;
        L40:
            if (r23 == false) goto L42;
        L36:
            if (r21.isEmpty() == true) goto L39;
            r23 = false;
            goto L40
        L32:
            r20 = null;
        L42:
            r11 = false;
            goto L44
        }

        @Override // q02.d
        public final void b() {
            s02.a r0 = this.a.n;
            if (r0 == null) goto L6;
            r0.onExit();
            return;
        }

        @Override // q02.d
        public final void c() {
            Disposable r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.dispose();
        L6:
            if (NormalGiftCombViewV2.p(this.a) == false) goto L8;
            NormalGiftCombViewV2 r1 = this.a;
            r1.g = Observable.timer(r1.getDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        L8:
            NormalGiftCombViewV2 r2 = this.a;
            NormalGiftMessage r3 = r2.f;
            if (r3 == null) goto L11;
            int r4 = r3.g;
        L12:
            long r5 = r4;
            if (r3 == null) goto L15;
            long r6 = r3.k;
        L16:
            long r7 = r5 * r6;
            n12.f r8 = r2.l;
            if ((r8 instanceof n12.c) == false) goto L23;
            ((n12.c) r8).getClass();
            if (n12.c.m(r7) < 2) goto L23;
            GiftIconMaskView r9 = (GiftIconMaskView) this.a.o(2131373725);
            if (r9 == null) goto L23;
            r9.b();
        L23:
            NormalGiftCombViewV2 r10 = this.a;
            r10.j = false;
            s02.a r11 = r10.n;
            if (r11 == null) goto L27;
            r11.onWaiting();
            return;
        L27:
            return;
        L15:
            r6 = 0;
            goto L16
        L11:
            r4 = 0;
            goto L12
        }

        @Override // q02.d
        public final void d() {
            s02.b r0 = this.a.o;
            if (r0 == null) goto L5;
            r0.onPlay();
        L5:
            NormalGiftMessage r1 = this.a.f;
            if (r1 == null) goto L14;
            o7 r2 = r1.r();
            if (r2 == null) goto L14;
            o0 r3 = r2.getTrayInfo();
            if (r3 == null) goto L14;
            w3 r4 = r3.getTrayPreEffect();
            if (r4 == null) goto L14;
            Integer r5 = Integer.valueOf(r4.getPreEffectSource());
        L16:
            if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.f(r5) == false) goto L33;
            NormalGiftMessage r6 = this.a.f;
            if (r6 == null) goto L34;
            o7 r7 = r6.r();
            if (r7 == null) goto L35;
            o0 r8 = r7.getTrayInfo();
            if (r8 == null) goto L36;
            w3 r9 = r8.getTrayPreEffect();
            if (r9 == null) goto L37;
            py.k r10 = r9.getPreEffectImg();
            if (r10 != null) goto L28;
            return;
        L28:
            if (r10.isValid() != true) goto L39;
            NormalGiftCombViewV2 r11 = this.a;
            NormalGiftMessage r13 = r11.f;
            if (r13 == null) goto L40;
            r11.I(r13);
            return;
        L40:
            return;
        L39:
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L34:
            return;
        L33:
            return;
        L14:
            r5 = null;
            goto L16
        }

        @Override // q02.d
        public final void e() {
            s02.b r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.onPlay();
            return;
        }

        public final void f() {
            GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
            if (GiftTrayMessageManager.a.a().l == false) goto L6;
            this.a.k = true;
            ALogger.d("PauseAnim", "NormalGiftCombViewV2 isExitAnimationDelay=true");
            return;
        L6:
            NormalGiftCombViewV2 r1 = this.a;
            int r2 = NormalGiftCombViewV2.W;
            r1.getClass();
            r1.post(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.j(r1));
        }

        public k(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public l(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        public final void a() {
            NormalGiftCombViewV2 r0 = this.a;
            int r1 = NormalGiftCombViewV2.W;
            r0.getClass();
            int[] r2 = {0, 0};
            r0.getLocationOnScreen(r2);
            NormalGiftMessage r3 = r0.f;
            if (r3 == null) goto L13;
            h2 r4 = r3.w;
            if (r4 != null) goto L7;
            return;
        L7:
            if (r4.getType() == 15) goto L9;
            return;
        L9:
            if (r0.P != null) goto L11;
            PointF r5 = new PointF();
            r5.x = r0.Q + (r0.x / 2.0f);
            r5.y = (r2[1] + 0) + (r0.y / 2.0f);
            Unit r6 = Unit.INSTANCE;
            r0.P = r5;
        L11:
            r0.L(r0.f);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public m(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            TextView r0 = (TextView) this.a.o(2131367236);
            if (r0 == null) goto L9;
            Object r2 = r4.getAnimatedValue();
            if (r2 == null) goto L8;
            r0.setTextColor(((Integer) r2).intValue());
            goto L9
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L9:
            TextView r1 = (TextView) this.a.o(2131367247);
            if (r1 == null) goto L16;
            Object r5 = r4.getAnimatedValue();
            if (r5 == null) goto L15;
            r1.setTextColor(((Integer) r5).intValue());
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public final class n implements Runnable {
        public final /* synthetic */ Function0 a;

        public n(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.l {
        public final /* synthetic */ NormalGiftCombViewV2 a;

        public o(NormalGiftCombViewV2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.l
        public final void a(final o3 r7, final boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "seriesTray");
            final NormalGiftCombViewV2 r0 = this.a;
            int r1 = NormalGiftCombViewV2.W;
            r0.getClass();
            if (r7.getDuration() > 400) goto L7;
            com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r2 = r0.C;
            if (r2 == null) goto L7;
            r2.a();
        L7:
            py.k r3 = r7.getDynamicImage();
            if (r3 != null) goto L10;
        L22:
            py.k r4 = r7.getStaticImage();
            if (r4 != null) goto L25;
            return;
        L25:
            if (r4.isValid() == false) goto L29;
            r0.D(r4, r8, new NormalGiftCombViewV2$loadNextSeriesIcon$$inlined$let$lambda$2(r0, r8, r7));
            return;
        L29:
            return;
        L10:
            if (r3.isValid() == false) goto L22;
            if (r0.U == true) goto L22;
            GiftIconMaskView r5 = (GiftIconMaskView) r0.o(2131373725);
            if (r5 == null) goto L16;
            Integer r6 = Integer.valueOf(r5.getVisibility());
        L18:
            if (r6.intValue() != 0) goto L20;
            final boolean r9 = true;
        L21:
            r0.w(r3, new NormalGiftCombViewV2$loadNextSeriesIcon$$inlined$let$lambda$1(r9, r0, r8, r7));
            goto L22
        L20:
            r9 = false;
            goto L21
        L16:
            r6 = null;
            goto L18
        }
    }

    public static final class p implements p0 {
        public final /* synthetic */ HSImageView a;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public p(HSImageView r1) {
            this.a = r1;
        }

        public final void c(py.k r1, int r2, int r3, boolean r4) {
            HSImageView r5 = this.a;
            if (r5 == null) goto L6;
            r5.setVisibility(4);
            return;
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ HSImageView a;
        public final /* synthetic */ HSImageView b;

        public q(HSImageView r1, HSImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.isRecycled() == true) goto L14;
            HSImageView r0 = this.a;
            if (r0 == null) goto L9;
            r0.setVisibility(4);
        L9:
            HSImageView r1 = this.b;
            if (r1 == null) goto L15;
            r1.setImageBitmap(r4);
            return;
        L15:
            return;
        }
    }

    public static final class r<T> implements Consumer {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class s extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ HSImageView a;

        public s(HSImageView r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            HSImageView r5 = this.a;
            if (r5 == null) goto L6;
            r5.setVisibility(4);
            return;
        }
    }

    static {
    }

    public NormalGiftCombViewV2(Context r8) {
        this(r8, null, 0, false, null, 30);
    }

    public NormalGiftCombViewV2(Context r8, AttributeSet r9) {
        this(r8, r9, 0, false, null, 28);
    }

    public NormalGiftCombViewV2(Context r8, AttributeSet r9, int r10) {
        this(r8, r9, r10, false, null, 24);
    }

    public final View a() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setRoomOrientation(int r1) {
    }

    private final boolean getAutoExit() {
        if (this.v == false) goto L5;
    L8:
        return true;
    L5:
        if ((this.f instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L8;
        return false;
    }

    private final Animator getGiftEntryAnimDegrade() {
        int r0 = ObjectAnimatorCompat.l;
        ObjectAnimatorCompat r1 = ObjectAnimatorCompat.a.a(this, "alpha", 0.0f, 1.0f);
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.a() == false) goto L5;
        long r2 = 0;
    L6:
        r1.f = r2;
        r1.addListener(new i(this));
        return r1;
    L5:
        r2 = 250;
        goto L6
    }

    private final boolean getShowDynamicGiftIcon() {
        if (this.U == true) goto L24;
        NormalGiftMessage r0 = this.f;
        if (r0 == null) goto L13;
        o7 r1 = r0.r();
        if (r1 == null) goto L13;
        o0 r2 = r1.getTrayInfo();
        if (r2 == null) goto L13;
        py.k r3 = r2.getTrayDynamicImg();
        if (r3 == null) goto L13;
        List r4 = r3.getUrls();
    L14:
        List r5 = r4;
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == true) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r5.isEmpty() == true) goto L20;
        r6 = false;
    L13:
        r4 = null;
        goto L14
    L24:
        return false;
    }

    public final boolean J() {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 != null) goto L5;
    L17:
        return false;
    L5:
        if (r0.isCleanMode() == true) goto L17;
        NormalGiftMessage r1 = this.f;
        if (r1 == null) goto L17;
        h2 r2 = r1.w;
        if (r2 == null) goto L17;
        if (r2.getType() != 15) goto L17;
        dq2.d r3 = this.M;
        if (r3 == null) goto L17;
        if (r3.c() != true) goto L17;
        return true;
    }

    public final void N() {
        if (this.i == false) goto L5;
        return;
    L5:
        Animator r0 = this.c;
        if (r0 != null) goto L8;
    L16:
        Animator r1 = this.S;
        if (r1 != null) goto L19;
    L23:
        this.n = null;
        GiftIconMaskView r2 = (GiftIconMaskView) o(2131373725);
        if (r2 == null) goto L27;
        r2.c();
        return;
    L27:
        return;
    L19:
        if (r1.isRunning() != true) goto L23;
        Animator r3 = this.S;
        if (r3 == null) goto L23;
        r3.cancel();
        goto L23
    L8:
        if (r0.isRunning() != true) goto L16;
        Animator r4 = this.c;
        if (r4 == null) goto L12;
        r4.removeAllListeners();
    L12:
        Animator r5 = this.c;
        if (r5 == null) goto L15;
        r5.cancel();
    L15:
        this.c = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void e() {
        if (this.j == false) goto L12;
        Animator r0 = this.c;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isRunning() != true) goto L14;
        Animator r1 = this.c;
        if (r1 == null) goto L15;
        r1.cancel();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void f() {
        this.G.f();
        s02.a r0 = this.n;
        if (r0 == null) goto L6;
        r0.onExit();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void g() {
        Animator r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() != true) goto L12;
        Animator r1 = this.c;
        if (r1 == null) goto L9;
        r1.pause();
    L9:
        ALogger.d("PauseAnim", "NormalGiftCombViewV2 pauseAnimation success");
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void i() {
        if (this.i == false) goto L5;
        return;
    L5:
        NormalGiftMessage r0 = this.f;
        Integer r1 = null;
        if (r0 == null) goto L8;
        Boolean r2 = r0.i();
    L10:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L20;
        NormalGiftMessage r3 = this.f;
        if (r3 == null) goto L18;
        o7 r4 = r3.r();
        if (r4 == null) goto L18;
        o0 r5 = r4.getTrayInfo();
        if (r5 == null) goto L18;
        u3 r6 = r5.getTrayPostEffect();
    L19:
        this.A = r6;
    L18:
        r6 = null;
    L20:
        Disposable r7 = this.g;
        if (r7 == null) goto L23;
        r7.dispose();
    L23:
        A(true);
        NormalGiftMessage r8 = this.f;
        if (r8 == null) goto L26;
        int r9 = (int) r8.m;
    L27:
        if (r8 == null) goto L30;
        String r10 = r8.q();
        if (r10 == null) goto L30;
    L32:
        if ((this.f instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L37;
        if (com.bytedance.android.livesdk.gift.platform.business.j.b().L7().i6().contains(Integer.valueOf(r9)) == false) goto L39;
        K(com.bytedance.android.livesdk.gift.platform.business.j.b().L7().getDuration());
    L39:
        TextView r11 = (TextView) o(2131367236);
        int r13 = 0;
        if (r11 != null) goto L42;
    L45:
        py.k r14 = com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.h(this.f);
        if (r14 == null) goto L50;
        Integer r15 = com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.g(this.f);
        if (r15 == null) goto L50;
        int r16 = r15.intValue();
    L52:
        if (u.p() == true) goto L100;
        if (r14 == null) goto L57;
        if (r16 == this.q) goto L57;
    L66:
        NormalGiftMessage r17 = this.f;
        if (r17 == null) goto L73;
        o7 r18 = r17.r();
        if (r18 == null) goto L73;
        o0 r19 = r18.getTrayInfo();
        if (r19 == null) goto L73;
        long r20 = r19.getTrayLevel();
    L74:
        int r110 = (int) r20;
        if (this.U == true) goto L100;
        if (this.v == false) goto L100;
        this.q = r16;
        Lazy r21 = GiftImageFormat.a;
        if (r17 == null) goto L83;
        o7 r23 = r17.r();
        if (r23 == null) goto L83;
        o0 r24 = r23.getTrayInfo();
    L84:
        py.k r111 = GiftImageFormat.a(r24);
        if (r111 == null) goto L100;
        if (r17 == null) goto L92;
        o7 r25 = r17.r();
        if (r25 == null) goto L92;
        o0 r26 = r25.getTrayInfo();
        if (r26 == null) goto L92;
        r13 = (int) r26.getTrayLevel();
    L92:
        this.p = r13;
        ImageLoader.bindImage(o(2131380985), r111);
        py.k r112 = com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.h(r17);
        HSImageView r27 = o(2131380985);
        if (r27 == null) goto L96;
        r1 = Integer.valueOf(r27.getVisibility());
    L96:
        if (r1.intValue() != 0) goto L98;
        O((HSImageView) o(2131380985), (HSImageView) o(2131380986), r111, r110, r112);
        goto L100
    L98:
        O((HSImageView) o(2131380986), (HSImageView) o(2131380985), r111, r110, r112);
    L83:
        r24 = null;
    L73:
        r20 = 1;
    L57:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.r.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[16])).booleanValue() == true) goto L100;
        NormalGiftMessage r28 = this.f;
        if (r28 == null) goto L66;
        o7 r29 = r28.r();
        if (r29 == null) goto L66;
        o0 r30 = r29.getTrayInfo();
        if (r30 == null) goto L66;
        if (((int) r30.getTrayLevel()) != this.p) goto L66;
    L100:
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.c() == false) goto L102;
    L113:
        Function0<Unit> r31 = this.O;
        if (r31 == null) goto L116;
        r31 = new n(r31);
    L116:
        postDelayed((Runnable) r31, 200);
    L117:
        M();
        return;
    L102:
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.a() == true) goto L113;
        GiftContext r33 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r33 == null) goto L110;
        com.bytedance.live.datacontext.m<Boolean> r34 = r33.getCancelComboForDegradeInMatch();
        if (r34 == null) goto L110;
        if (((Boolean) r34.getValue()).booleanValue() == true) goto L113;
    L110:
        Animator r35 = this.m.d(o(2131367231), this.G);
        this.c = r35;
        this.j = true;
        if (r35 == null) goto L117;
        r35.start();
    L50:
        r16 = 0;
        goto L52
    L42:
        if (u.p() == false) goto L44;
        r10 = getContext().getString(2131920105, new Object[]{r10});
    L44:
        r11.setText(r10);
        goto L45
    L37:
        if (com.bytedance.android.livesdk.gift.platform.business.j.b().K1().i6().contains(Integer.valueOf(r9)) == false) goto L39;
        K(com.bytedance.android.livesdk.gift.platform.business.j.b().K1().getDuration());
    L30:
        r10 = String.valueOf(1);
        goto L32
    L26:
        r9 = 1;
        goto L27
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void l() {
        Animator r0 = this.c;
        if (r0 == null) goto L11;
        if (r0.isPaused() != true) goto L11;
        Animator r1 = this.c;
        if (r1 == null) goto L9;
        r1.resume();
    L9:
        ALogger.d("PauseAnim", "NormalGiftCombViewV2 resumeAnimation success");
    L11:
        if (this.k == false) goto L14;
        ALogger.d("PauseAnim", "NormalGiftCombViewV2 getGiftExitAnim when scroll idle");
        post(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.j(this));
        this.k = false;
        return;
    }

    private final View getCurrentGiftIconView() {
        GiftIconMaskView r0 = getNormalGiftIconView();
        boolean r2 = true;
        if (r0.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        ImageView r3 = getDynamicGiftIconView();
        if (r3.getVisibility() == 0) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L21;
        return r3;
    L21:
        return null;
    L5:
        r1 = false;
        goto L7
    }

    private final HSImageView getDynamicGiftIconView() {
        return o(2131370475);
    }

    private final GiftIconMaskView getNormalGiftIconView() {
        return (GiftIconMaskView) o(2131373725);
    }

    public final void M() {
        View r0 = getCurrentGiftIconView();
        if (r0 == null) goto L12;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        Rect r2 = new Rect(0, 0, r0.getWidth(), r0.getHeight());
        r2.offsetTo(r1[0], r1[1]);
        NormalGiftMessage r3 = this.f;
        if (r3 == null) goto L7;
        long r4 = r3.b;
    L8:
        com.bytedance.android.live.profit.livepet.a r5 = new com.bytedance.android.live.profit.livepet.a(r4, r2);
        com.bytedance.android.live.profit.livepet.b r6 = yt0.c.e();
        if (r6 == null) goto L13;
        r6.e3(r5);
        return;
    L13:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public final void c() {
        uu0.b.b r0 = getPreviewData();
        if (r0 == null) goto L11;
        gm2.h r1 = r0.c;
        if (r1 == null) goto L9;
        m((NormalGiftMessage) r1);
        h(null, true);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.player.profilepreview.ProfilePreviewData.GiftTray");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void j() {
        N();
        this.n = null;
        this.o = null;
        this.e = null;
        Disposable r1 = this.g;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.g = null;
        this.i = true;
        this.r = false;
        ViewGroup r2 = this.z;
        if (r2 == null) goto L8;
        r2.removeView(this);
    L8:
        Disposable r3 = this.J;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        this.I = 0;
        GiftIconMaskView r0 = (GiftIconMaskView) o(2131373725);
        if (r0 == null) goto L14;
        r0.c();
    L14:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.a r4 = this.R;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.b r5 = r4.k;
        if (r5 == null) goto L17;
        r5.b();
    L17:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.f r6 = r4.l;
        if (r6 == null) goto L20;
        r6.c();
    L20:
        AnimatedDrawable2 r7 = this.B;
        if (r7 == null) goto L24;
        r7.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void k() {
        N();
        TextView r0 = (TextView) o(2131367236);
        if (r0 == null) goto L5;
        r0.setText(String.valueOf(1));
    L5:
        LinearLayout r1 = (LinearLayout) o(2131367231);
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        setAlpha(1.0f);
        GiftIconMaskView r2 = (GiftIconMaskView) o(2131373725);
        if (r2 == null) goto L11;
        r2.c();
    L11:
        this.T = null;
        Disposable r3 = this.D;
        if (r3 == null) goto L15;
        r3.dispose();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new l(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h.dispose();
        Disposable r0 = this.H;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Function0<Unit> r1 = this.O;
        if (r1 == null) goto L8;
        r1 = new n(r1);
    L8:
        removeCallbacks((Runnable) r1);
    }

    public final void u() {
        View r0 = o(2131380985);
        Function0<String> r1 = new NormalGiftCombViewV2$addTrayAccessibility$1(this);
        int r2 = r3.a;
        Intrinsics.checkNotNullParameter(r1, "getDescription");
        if (r0 == null) goto L6;
        r3.a r4 = new r3.a(r0);
        r4.b = r1;
        r4.c = BuildConfig.FLAVOR;
        ViewCompat.setAccessibilityDelegate(r0, r4);
    L6:
        View r3 = o(2131380986);
        Function0<String> r5 = new NormalGiftCombViewV2$addTrayAccessibility$2(this);
        Intrinsics.checkNotNullParameter(r5, "getDescription");
        if (r3 == null) goto L11;
        r3.a r6 = new r3.a(r3);
        r6.b = r5;
        r6.c = BuildConfig.FLAVOR;
        ViewCompat.setAccessibilityDelegate(r3, r6);
        return;
    }

    public final void b() {
        j();
    }

    public final s02.c getClickListener() {
        return this.e;
    }

    public final Disposable getDispose() {
        return this.H;
    }

    public final long getDuration() {
        return this.b;
    }

    public uu0.b getPreviewData() {
        return this.V;
    }

    public static final /* synthetic */ boolean p(NormalGiftCombViewV2 r0) {
        return r0.getAutoExit();
    }

    public static final void q(NormalGiftCombViewV2 r2) {
        r2.getClass();
        int[] r0 = {0, 0};
        HSImageView r1 = r2.o(2131370475);
        if (r1 == null) goto L5;
        r1.getLocationOnScreen(r0);
    L5:
        r2.K = r0[0];
        r2.L = r0[1];
    }

    public final void A(boolean r4) {
        if (this.M != null) goto L5;
    L18:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("NormalGiftCombViewV2", "animService is null or needCallMultiInteractFramework is " + J());
        return;
    L5:
        if (J() == false) goto L18;
        NormalGiftMessage r0 = this.f;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.v == false) goto L12;
        B(r0, r4);
        return;
    L12:
        this.I += r0.y;
        r0.y = 0;
        Disposable r5 = this.J;
        if (r5 != null) goto L15;
    L16:
        com.bytedance.android.live.core.utils.rxutils.j.a r6 = com.bytedance.android.live.core.utils.rxutils.j.a;
        RxUtilKt.h(com.bytedance.android.live.core.utils.rxutils.j.c(((b2) com.bytedance.android.livesdk.gift.platform.business.a.s.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[17])).a(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io())).subscribe(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.f(this, r0));
        return;
    L15:
        if (r5.isDisposed() == true) goto L16;
    }

    public void C(NormalGiftMessage r13) {
        Intrinsics.checkNotNullParameter(r13, "msg");
        if ((r13 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r3 = this.C;
        if (r3 == null) goto L15;
        Iterator<o3> r4 = r3.b.iterator();
        long r6 = 0;
    L13:
        if (r4.hasNext() == false) goto L16;
        r6 = r6 + r4.next().getDuration();
    L16:
        py.k r5 = null;
        if (r6 != 0) goto L19;
    L30:
        if (r0 == true) goto L32;
        GiftIconMaskView r2 = (GiftIconMaskView) o(2131373725);
        if (r2 == null) goto L46;
        r2.setVisibility(8);
    L46:
        if (this.U == true) goto L50;
        HSImageView r7 = o(2131370475);
        if (r7 == null) goto L50;
        r7.setVisibility(8);
    L50:
        if (r0 == true) goto L52;
        return;
    L52:
        if (getShowDynamicGiftIcon() == true) goto L54;
        D(r13.o, true, new NormalGiftCombViewV2$bindNormalIconImage$1(this));
        return;
    L54:
        o7 r14 = r13.r();
        if (r14 == null) goto L59;
        o0 r15 = r14.getTrayInfo();
        if (r15 == null) goto L59;
        r5 = r15.getTrayDynamicImg();
    L59:
        w(r5, NormalGiftCombViewV2$loadSingleGiftIcon$1.INSTANCE);
        return;
    L32:
        if (getShowDynamicGiftIcon() == false) goto L39;
        GiftIconMaskView r8 = (GiftIconMaskView) o(2131373725);
        if (r8 == null) goto L36;
        r8.setVisibility(8);
    L36:
        HSImageView r9 = o(2131370475);
        if (r9 == null) goto L50;
        r9.setVisibility(0);
        goto L50
    L39:
        GiftIconMaskView r10 = (GiftIconMaskView) o(2131373725);
        if (r10 == null) goto L50;
        r10.setVisibility(0);
        goto L50
    L19:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.A.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[25])).booleanValue() == false) goto L30;
        if (r0 == true) goto L27;
        GiftIconMaskView r16 = (GiftIconMaskView) o(2131373725);
        if (r16 == null) goto L24;
        r16.setVisibility(8);
    L24:
        HSImageView r17 = o(2131370475);
        if (r17 == null) goto L62;
        r17.setVisibility(8);
        return;
    L62:
        return;
    L27:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r18 = this.C;
        if (r18 == null) goto L64;
        r18.a();
        return;
    L64:
        return;
    L15:
        r6 = 0;
        goto L16
    L5:
        if (((com.bytedance.android.livesdk.gift.platform.business.tray.a) r13).R == true) goto L8;
        r0 = false;
        goto L9
    }

    public void E(NormalGiftMessage r13) {
        Intrinsics.checkNotNullParameter(r13, "msg");
        if (u.p() == false) goto L5;
        return;
    L5:
        long r0 = r13.getTotalMoney();
        Integer r4 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.r.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[16])).booleanValue() == false) goto L11;
        int r14 = this.l.b(0);
        HSImageView r1 = o(2131380985);
        if (r1 == null) goto L53;
        r1.setBackgroundResource(r14);
        return;
    L53:
        return;
    L11:
        int r2 = this.l.b(r0);
        int r3 = this.l.c(r0);
        if (this.U == true) goto L49;
        o7 r5 = r13.r();
        if (r5 == null) goto L16;
        o0 r6 = r5.getTrayInfo();
    L17:
        py.k r8 = GiftImageFormat.a(r6);
        py.k r10 = com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.h(r13);
        int r7 = 0;
        if (r10 == null) goto L25;
        Integer r15 = com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.g(r13);
        if (r15 == null) goto L22;
        int r16 = r15.intValue();
    L23:
        this.q = r16;
        goto L25
    L22:
        r16 = 0;
    L25:
        if (this.v == false) goto L42;
        if (r8 == null) goto L42;
        List r17 = r8.getUrls();
        if (r17 == null) goto L30;
        Integer r18 = Integer.valueOf(r17.size());
    L32:
        if (r18.intValue() <= 0) goto L42;
        if (r6 == null) goto L35;
        r7 = (int) r6.getTrayLevel();
    L35:
        this.p = r7;
        HSImageView r19 = o(2131380985);
        if (r19 == null) goto L39;
        r4 = Integer.valueOf(r19.getVisibility());
    L39:
        if (r4.intValue() != 0) goto L41;
        O((HSImageView) o(2131380985), (HSImageView) o(2131380986), r8, this.p, r10);
        return;
    L41:
        O((HSImageView) o(2131380986), (HSImageView) o(2131380985), r8, this.p, r10);
        return;
    L30:
        r18 = null;
    L42:
        if (r10 == null) goto L46;
        HSImageView r110 = findViewById(2131380985);
        if (r110 == null) goto L56;
        ImageUtil.loadImage(r110, r10, 0);
        return;
    L56:
        return;
    L46:
        HSImageView r111 = o(2131380985);
        if (r111 == null) goto L58;
        r111.setBackgroundResource(r2);
        return;
    L58:
        return;
    L16:
        r6 = null;
        goto L17
    L49:
        HSImageView r112 = o(2131380985);
        if (r112 == null) goto L60;
        r112.setBackgroundResource(r3);
        return;
    }

    public void F(NormalGiftMessage r9) {
        Intrinsics.checkNotNullParameter(r9, "msg");
        if (b02.a.b(r9) == false) goto L5;
    L6:
        List<n3> r0 = r9.F;
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
    L46:
        LinearLayout r10 = (LinearLayout) o(2131367231);
        if (r10 == null) goto L49;
        r10.setVisibility(8);
    L49:
        LinearLayout r11 = (LinearLayout) o(2131373930);
        if (r11 == null) goto L52;
        r11.setVisibility(8);
    L52:
        View r13 = o(2131370387);
        if (r13 == null) goto L60;
        r13.setVisibility(0);
        return;
    L60:
        return;
    L15:
        if (this.s == true) goto L46;
        if (this.d == false) goto L29;
        LinearLayout r2 = (LinearLayout) o(2131367231);
        if (r2 == null) goto L22;
        r2.setVisibility(0);
    L22:
        TextView r3 = (TextView) o(2131367236);
        if (r3 == null) goto L29;
        if (u.p() == false) goto L27;
        String r4 = getContext().getString(2131919524, new Object[]{r9.q()});
    L28:
        r3.setText(r4);
        goto L29
    L27:
        r4 = r9.q();
    L29:
        long r5 = r9.k;
        if (r5 <= 1) goto L40;
        View r14 = o(2131370387);
        if (r14 == null) goto L34;
        r14.setVisibility(8);
    L34:
        LinearLayout r15 = (LinearLayout) o(2131373930);
        if (r15 == null) goto L37;
        r15.setVisibility(0);
    L37:
        TextView r16 = (TextView) o(2131373941);
        if (r16 == null) goto L56;
        r16.setText(String.valueOf(r5));
        return;
    L56:
        return;
    L40:
        View r17 = o(2131370387);
        if (r17 == null) goto L43;
        r17.setVisibility(0);
    L43:
        LinearLayout r18 = (LinearLayout) o(2131373930);
        if (r18 == null) goto L58;
        r18.setVisibility(8);
        return;
    L58:
        return;
    L9:
        if (r0.isEmpty() == true) goto L12;
        r1 = false;
        goto L13
    L5:
        if ((r9 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L46;
        goto L6
    }

    public void G(NormalGiftMessage r13) {
        Intrinsics.checkNotNullParameter(r13, "msg");
        TextView r1 = (TextView) o(2131392055);
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L5;
        r1.setText(BuildConfig.FLAVOR);
    L5:
        IBaseUser r3 = r13.e;
        if (r3 == null) goto L10;
        TextView r0 = (TextView) o(2131392055);
        if (r0 == null) goto L10;
        int r4 = f0.a;
        r0.setText(f0.a(r3, r13.M));
    L10:
        py.k r5 = null;
        if (r13.getTrayDisplayText() == null) goto L19;
        TextView r6 = (TextView) o(2131373680);
        if (r6 == null) goto L59;
        ur2.a r7 = vh6.c.b(ur2.a.class);
        a5 r8 = r13.getTrayDisplayText();
        String r14 = r13.c;
        if (r14 == null) goto L18;
        r2 = r14;
    L18:
        r6.setText(r7.Lf(r8, r2));
    L59:
        if (this.U == false) goto L61;
    L80:
        u();
        return;
    L61:
        if (this.t == true) goto L63;
    L77:
        HSImageView r15 = o(2131373790);
        if (r15 == null) goto L80;
        r15.setVisibility(8);
        goto L80
    L63:
        if (this.u == false) goto L77;
        if (this.s == true) goto L77;
        HSImageView r16 = o(2131373790);
        if (r16 == null) goto L69;
        r16.setVisibility(0);
    L69:
        HSImageView r17 = o(2131373790);
        NormalGiftMessage r9 = this.f;
        if (r9 == null) goto L76;
        o7 r10 = r9.r();
        if (r10 == null) goto L76;
        o0 r11 = r10.getTrayInfo();
        if (r11 == null) goto L76;
        r5 = r11.getTrayRightImgV2();
    L76:
        ImageLoader.bindImage(r17, r5);
        goto L80
    L19:
        String r18 = r13.c;
        if (r18 != null) goto L22;
        r18 = BuildConfig.FLAVOR;
    L22:
        TextView r19 = (TextView) o(2131373680);
        if (r19 == null) goto L25;
        r19.setText(r18);
    L25:
        yz0.k r20 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r20 == null) goto L28;
        IRoom r21 = r20.getRoom();
    L29:
        if (r21 == null) goto L31;
        String r23 = r21.getAnchorId();
    L32:
        IBaseUser r24 = r13.f;
        if (r24 == null) goto L35;
        String r25 = r24.getIdString();
    L37:
        if ((!Intrinsics.areEqual(r23, r25)) == false) goto L59;
        IBaseUser r26 = r13.f;
        if (r26 == null) goto L44;
        String r27 = r26.getNickName();
        if (r27 == null) goto L44;
        String r28 = r27;
    L45:
        int r29 = StringsKt.indexOf$default(r18, r28, 0, false, 6, null);
        if (r29 == (-1)) goto L59;
        String r30 = r18.substring(0, r29);
        String r31 = " <font color = '#FACE15'>" + r18.substring(r29) + "</font> ";
        StringBuilder r33 = new StringBuilder();
        r33.append(r30);
        r33.append(r31);
        h2 r110 = GiftManagerKt.l(r13.b);
        if (r110 == null) goto L50;
        String r111 = r110.getName();
    L51:
        r33.append(r111);
        String r112 = r33.toString();
        if (Build.VERSION.SDK_INT < 24) goto L54;
        Spanned r113 = Html.fromHtml(r112, 0);
    L55:
        TextView r34 = (TextView) o(2131373680);
        if (r34 == null) goto L59;
        r34.setText(r113);
        goto L59
    L54:
        r113 = Html.fromHtml(r112);
        goto L55
    L50:
        r111 = null;
    L44:
        r28 = BuildConfig.FLAVOR;
        goto L45
    L35:
        r25 = null;
        goto L37
    L31:
        r23 = null;
        goto L32
    L28:
        r21 = null;
        goto L29
    }

    public void H(NormalGiftMessage r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        ImageView r0 = (ImageView) o(2131392002);
        NormalGiftMessage r1 = this.f;
        py.k r2 = null;
        if (r1 == null) goto L7;
        IBaseUser r3 = r1.e;
        if (r3 == null) goto L7;
        py.k r4 = r3.getAvatarThumbKt();
    L8:
        boolean r5 = true;
        x(r0, r4, true);
        zt0.e r7 = yt0.c.a();
        IBaseUser r8 = r6.e;
        if (r8 == null) goto L13;
        py.f r9 = r8.getBorder();
        if (r9 == null) goto L13;
        String r10 = r9.getDressId();
    L14:
        com.bytedance.android.live.profit.dress.a r11 = r7.getDressData(r10, 1, "NormalGiftCombViewV2: loadTrayHeadImage");
        if (r11 == null) goto L18;
        py.k r13 = r11.a;
        if (r13 == null) goto L18;
    L25:
        if (r13 == null) goto L31;
        HSImageView r14 = o(2131376022);
        if (r14 == null) goto L29;
        r14.setVisibility(0);
    L29:
        ImageLoader.bindImage(o(2131376022), r13);
    L31:
        if (this.U == true) goto L69;
        NormalGiftMessage r15 = this.f;
        if (r15 == null) goto L41;
        o7 r16 = r15.r();
        if (r16 == null) goto L41;
        o0 r17 = r16.getTrayInfo();
        if (r17 == null) goto L41;
        py.k r18 = r17.getTrayHeadImg();
        if (r18 == null) goto L41;
        List r19 = r18.getUrls();
    L42:
        List r20 = r19;
        if (r20 == null) goto L49;
        if (r20.isEmpty() == true) goto L49;
        r5 = false;
    L49:
        if (r5 == false) goto L51;
    L65:
        HSImageView r21 = o(2131391999);
        if (r21 == null) goto L71;
        r21.setVisibility(8);
        return;
    L71:
        return;
    L51:
        if (this.t == true) goto L65;
        if (this.s == true) goto L65;
        HSImageView r23 = o(2131391999);
        if (r23 == null) goto L57;
        r23.setVisibility(0);
    L57:
        HSImageView r24 = o(2131391999);
        NormalGiftMessage r25 = this.f;
        if (r25 == null) goto L64;
        o7 r26 = r25.r();
        if (r26 == null) goto L64;
        o0 r27 = r26.getTrayInfo();
        if (r27 == null) goto L64;
        r2 = r27.getTrayHeadImg();
    L64:
        ImageLoader.bindImage(r24, r2);
        return;
    L41:
        r19 = null;
        goto L42
    L69:
        return;
    L18:
        IBaseUser r28 = r6.e;
        if (r28 == null) goto L23;
        py.f r29 = r28.getBorder();
        if (r29 == null) goto L23;
        r13 = r29.getIcon();
    L23:
        r13 = null;
    L13:
        r10 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final void I(NormalGiftMessage r5) {
        if (this.U == false) goto L5;
        return;
    L5:
        if (this.t == false) goto L7;
        return;
    L7:
        if (this.s == true) goto L32;
        o7 r6 = r5.r();
        if (r6 == null) goto L26;
        o0 r7 = r6.getTrayInfo();
        if (r7 == null) goto L26;
        py.k r8 = r7.getTrayRightImg();
        if (r8 == null) goto L26;
        HSImageView r1 = o(2131373780);
        boolean r2 = false;
        if (r1 == null) goto L17;
        r1.setVisibility(0);
    L17:
        List r3 = r8.getUrls();
        if (r3 != null) goto L20;
    L21:
        r2 = true;
    L22:
        if (r2 == true) goto L33;
        HSImageView r0 = o(2131373780);
        if (r0 == null) goto L34;
        r0.setController(Fresco.newDraweeControllerBuilder().setUri((String) CollectionsKt.first(r8.getUrls())).setAutoPlayAnimations(true).setControllerListener(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.e(this, new NormalGiftCombViewV2$loadTrayRightImage$$inlined$let$lambda$1(this), new NormalGiftCombViewV2$loadTrayRightImage$$inlined$let$lambda$2(this))).build());
        return;
    L34:
        return;
    L33:
        return;
    L20:
        if (r3.isEmpty() == false) goto L22;
    L26:
        HSImageView r9 = o(2131373780);
        if (r9 == null) goto L36;
        r9.setVisibility(8);
        return;
    L36:
        return;
    }

    public final void K(long r4) {
        TextView r0 = (TextView) o(2131367236);
        if (r0 == null) goto L5;
        r0.setTextColor(s1.h(2131106924));
    L5:
        TextView r1 = (TextView) o(2131367247);
        if (r1 == null) goto L8;
        r1.setTextColor(s1.h(2131106924));
    L8:
        HSImageView r2 = o(2131387072);
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{ColorProtector.parseColor("#FF1F65"), ColorProtector.parseColor("#FFFFFF")});
        r3.setEvaluator(new ArgbEvaluator());
        r3.setDuration(200);
        r3.setStartDelay(((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) * r4);
        r3.addUpdateListener(new m(this));
        AnimatedDrawable2 r5 = this.B;
        if (r5 == null) goto L14;
        r5.start();
    L14:
        r3.start();
    }

    public final void L(NormalGiftMessage r19) {
        if (r19 != null) goto L5;
        return;
    L5:
        List<String> r1 = r19.C;
        PointF r2 = this.P;
        i02.f r3 = this.w;
        if (r2 == null) goto L109;
        if (r3 == null) goto L110;
        PointF r4 = new PointF();
        r4.x = r2.x;
        r4.y = r2.y;
        int r5 = com.bytedance.android.livesdk.gift.platform.business.normal.utils.a.a;
        int r6 = this.x;
        int r7 = this.y;
        Intrinsics.checkNotNullParameter(r4, "centerPoint");
        PointF r8 = new PointF();
        float r9 = r6 / 2.0f;
        double r10 = Math.toRadians(r3.b());
        if (r3.b() != Integer.MIN_VALUE) goto L11;
        r8.x = r4.x;
        r8.y = r4.y - (r7 / 2.0f);
        String r110 = "centerPoint";
    L27:
        this.T = r8;
        if (r3.a() == false) goto L111;
        boolean r11 = true;
        if (r1.size() != 1) goto L112;
        dq2.d r13 = this.M;
        if (r13 == null) goto L34;
        PointF r14 = r13.d((String) ListProtector.get(r1, 0));
    L35:
        if (r14 != null) goto L38;
    L42:
        boolean r15 = false;
    L44:
        if (r3.b() != Integer.MIN_VALUE) goto L47;
        r11 = false;
    L47:
        String r16 = ", rotation is ";
        float r17 = 0.0f;
        if (r15 == false) goto L79;
        HSImageView r18 = o(2131370475);
        if (r18 == null) goto L52;
        r18.setScaleX(-1.0f);
    L52:
        if (r11 == false) goto L78;
        int r20 = -r3.b();
        int r21 = this.x;
        int r111 = this.y;
        Intrinsics.checkNotNullParameter(r4, r110);
        if (r14 != null) goto L56;
        r16 = ", rotation is ";
    L66:
        this.T = com.bytedance.android.livesdk.gift.platform.business.normal.utils.a.a(((-180) - (-r3.b())) + r17, r4, this.x, this.y);
        HSImageView r23 = o(2131370475);
        if (r23 == null) goto L69;
        r23.setRotation(r17);
    L69:
        StringBuilder r24 = new StringBuilder("needFlip is true, webpAngle is ");
        r24.append(r3.b());
        r24.append(", startPointFX is ");
        PointF r25 = this.T;
        if (r25 == null) goto L72;
        Float r26 = Float.valueOf(r25.x);
    L73:
        r24.append(r26);
        r24.append(", startPointFY is ");
        PointF r27 = this.T;
        if (r27 == null) goto L76;
        Float r28 = Float.valueOf(r27.y);
    L77:
        r24.append(r28);
        r24.append(r16);
        r24.append(r17);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("NormalGiftCombViewV2", r24.toString());
        return;
    L76:
        r28 = null;
        goto L77
    L72:
        r26 = null;
        goto L73
    L56:
        PointF r112 = new PointF();
        double r113 = Math.toRadians(r20);
        float r114 = r21 / 2.0f;
        if ((r20 % 90) != 0) goto L64;
        if (r20 >= 0) goto L60;
        r112.x = r4.x;
        r112.y = r4.y - (r111 / 2);
    L65:
        r17 = m02.h.a(r4, r112, r14);
        goto L66
    L60:
        if (r20 != 0) goto L62;
        r112.x = r4.x - r114;
        r112.y = r4.y;
        goto L65
    L62:
        r112.x = r4.x;
        r112.y = r4.y + (r111 / 2);
        goto L65
    L64:
        r112.x = r4.x - r114;
        r112.y = (float) (((double) r4.y) + ((Math.tan(r113) * ((double) r21)) / ((double) 2.0f)));
        goto L65
    L78:
        PointF r29 = new PointF();
        r29.x = r4.x - (this.x / 2.0f);
        r29.y = r4.y - (this.y / 2.0f);
        Unit r30 = Unit.INSTANCE;
        this.T = r29;
        return;
    L79:
        String r115 = r110;
        HSImageView r31 = o(2131370475);
        if (r31 == null) goto L82;
        r31.setScaleX(1.0f);
    L82:
        if (r11 == false) goto L107;
        int r33 = -r3.b();
        int r34 = this.x;
        int r35 = this.y;
        Intrinsics.checkNotNullParameter(r4, r115);
        if (r14 == null) goto L95;
        double r116 = Math.toRadians(r33);
        float r36 = r34 / 2.0f;
        PointF r37 = new PointF();
        if ((r33 % 90) != 0) goto L93;
        if (r33 >= 0) goto L90;
        r37.x = r4.x;
        r37.y = r4.y - (r35 / 2);
    L94:
        r17 = m02.h.a(r4, r37, r14);
        goto L95
    L90:
        if (r33 != 0) goto L92;
        r37.x = r4.x + r36;
        r37.y = r4.y;
        goto L94
    L92:
        r37.x = r4.x;
        r37.y = r4.y + (r35 / 2);
        goto L94
    L93:
        r37.x = r4.x + r36;
        r37.y = (float) (((double) r4.y) + (Math.tan(r116) * ((double) r36)));
    L95:
        this.T = com.bytedance.android.livesdk.gift.platform.business.normal.utils.a.a((-r3.b()) + r17, r4, this.x, this.y);
        HSImageView r38 = o(2131370475);
        if (r38 == null) goto L98;
        r38.setRotation(r17);
    L98:
        StringBuilder r39 = new StringBuilder("needFlip is false, webpAngle is ");
        r39.append(r3.b());
        r39.append(", startPointFX is ");
        PointF r40 = this.T;
        if (r40 == null) goto L101;
        Float r41 = Float.valueOf(r40.x);
    L102:
        r39.append(r41);
        r39.append(", startPointFY is ");
        PointF r43 = this.T;
        if (r43 == null) goto L105;
        Float r44 = Float.valueOf(r43.y);
    L106:
        r39.append(r44);
        r39.append(", rotation is ");
        r39.append(r17);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("NormalGiftCombViewV2", r39.toString());
        return;
    L105:
        r44 = null;
        goto L106
    L101:
        r41 = null;
        goto L102
    L107:
        PointF r45 = new PointF();
        r45.x = r4.x + (this.x / 2.0f);
        r45.y = r4.y - (this.y / 2.0f);
        Unit r46 = Unit.INSTANCE;
        this.T = r45;
        return;
    L38:
        if (r3.a() != true) goto L42;
        if (r4.x <= r14.x) goto L42;
        r15 = true;
        goto L44
    L34:
        r14 = null;
        goto L35
    L112:
        return;
    L111:
        return;
    L11:
        int r117 = r3.b();
        if ((-45) > r117) goto L16;
        if (45 < r117) goto L16;
        r8.x = r4.x + r9;
        r110 = "centerPoint";
        r8.y = (float) (((double) r4.y) - (Math.tan(r10) * ((double) r9)));
    L16:
        r110 = "centerPoint";
        int r47 = r3.b();
        if (45 <= r47) goto L20;
    L22:
        int r48 = r3.b();
        if ((-90) > r48) goto L27;
        if ((-45) < r48) goto L27;
        float r49 = r4.y + (r7 / 2.0f);
        r8.y = r49;
        r8.x = (float) (((double) r4.x) + (Math.abs(((double) r49) / Math.sin(r10)) * Math.cos(r10)));
        goto L27
    L20:
        if (90 < r47) goto L22;
        float r50 = r4.y - (r7 / 2.0f);
        r8.y = r50;
        r8.x = (float) (((double) r4.x) + (Math.abs(((double) r50) / Math.sin(r10)) * Math.cos(r10)));
        goto L27
    L110:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void d(ViewGroup r1) {
        this.z = r1;
        if (r1 == null) goto L6;
        r1.addView(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void m(NormalGiftMessage r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        this.f = r9;
        boolean r1 = false;
        if (this.K == (-1)) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == false) goto L12;
        this.K = 0;
    L12:
        u3 r0 = null;
        if (u.p() == false) goto L15;
    L43:
        NormalGiftMessage r11 = this.f;
        if (r11 == null) goto L122;
        List<n3> r3 = r11.F;
        if (r3 == null) goto L58;
        ArrayList r4 = new ArrayList();
        Iterator<n3> r5 = r3.iterator();
    L49:
        if (r5.hasNext() == false) goto L56;
        n3 r6 = r5.next();
        if (r6 == null) goto L49;
        o3 r7 = r6.getSeriesTrayInfo();
        if (r7 == null) goto L49;
        r4.add(r7);
        goto L49
    L56:
        if ((!r4.isEmpty()) == false) goto L58;
        this.C = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k(r4, this.E);
    L58:
        KProperty[] r8 = b02.a.a;
        String r13 = "https://lf" + ((Number) ListProtector.get(CollectionsKt.shuffled(CollectionsKt.listOf(new Integer[]{1, 3, 5, 9})), 0)).intValue() + "-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_gift_tray_special_effect.webp";
        HSImageView r14 = o(2131387072);
        if (r14 == null) goto L61;
        r14.setController(Fresco.newDraweeControllerBuilder().setUri(r13).setControllerListener(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.g(this)).build());
    L61:
        setDuration(r11);
        E(r11);
        H(r11);
        NormalGiftMessage r15 = this.f;
        if (r15 == null) goto L70;
        o7 r16 = r15.r();
        if (r16 == null) goto L70;
        o0 r17 = r16.getTrayInfo();
        if (r17 == null) goto L70;
        w3 r18 = r17.getTrayPreEffect();
        if (r18 == null) goto L70;
        Integer r19 = Integer.valueOf(r18.getPreEffectSource());
    L72:
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.f(r19) == false) goto L86;
        NormalGiftMessage r20 = this.f;
        if (r20 == null) goto L86;
        o7 r21 = r20.r();
        if (r21 == null) goto L86;
        o0 r23 = r21.getTrayInfo();
        if (r23 == null) goto L86;
        w3 r24 = r23.getTrayPreEffect();
        if (r24 == null) goto L86;
        py.k r25 = r24.getPreEffectImg();
        if (r25 == null) goto L86;
        if (r25.isValid() != true) goto L86;
    L88:
        G(r11);
        F(r11);
        i12.e r26 = i12.o.b();
        if (r26 == null) goto L91;
        Object r27 = com.bytedance.android.scope.m.e.d(r26, com.bytedance.android.livesdk.gift.platform.business.tray2.d.class);
    L92:
        com.bytedance.android.livesdk.gift.platform.business.tray2.d r28 = (com.bytedance.android.livesdk.gift.platform.business.tray2.d) r27;
        if (r28 == null) goto L120;
        iy1.a r29 = r11.z;
        if (r29 == null) goto L97;
        String r30 = r29.a;
    L98:
        if (r30 == null) goto L120;
        i02.f r31 = (i02.f) ((LinkedHashMap) r28.a).get(r30);
        if (r31 != null) goto L121;
        String r33 = File.separator;
        if (r30.endsWith(r33) == false) goto L106;
        String r34 = r30.concat("tray_config.json");
    L107:
        String r35 = m02.b.b(r34);
        if (r35 == null) goto L120;
        if (r35.length() != 0) goto L113;
        r1 = true;
    L113:
        if (r1 == true) goto L120;
        r31 = (i02.f) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r35, i02.f.class);     // Catch: JsonSyntaxException -> L117
    L118:
        if (r31 == null) goto L121;
        r28.a.put(r30, r31);
    L117:
        r31 = null;
        goto L118
    L106:
        r34 = r30 + r33 + "tray_config.json";
    L121:
        this.w = r31;
        C(r11);
        goto L122
    L97:
        r30 = null;
    L120:
        r31 = null;
        goto L121
    L91:
        r27 = null;
    L86:
        if (this.s == true) goto L88;
        I(r11);
    L70:
        r19 = null;
    L122:
        NormalGiftMessage r36 = this.f;
        if (r36 == null) goto L125;
        Boolean r37 = r36.i();
    L127:
        if (Intrinsics.areEqual(r37, Boolean.TRUE) == false) goto L146;
        NormalGiftMessage r38 = this.f;
        if (r38 == null) goto L135;
        o7 r39 = r38.r();
        if (r39 == null) goto L135;
        o0 r40 = r39.getTrayInfo();
        if (r40 == null) goto L135;
        r0 = r40.getTrayPostEffect();
    L135:
        this.A = r0;
        return;
    L146:
        return;
    L125:
        r37 = null;
        goto L127
    L15:
        if (this.U == true) goto L43;
        NormalGiftMessage r41 = this.f;
        if (r41 == null) goto L43;
        o7 r43 = r41.r();
        if (r43 == null) goto L43;
        o0 r44 = r43.getTrayInfo();
        if (r44 == null) goto L43;
        if (this.U == false) goto L27;
    L41:
        boolean r45 = false;
    L42:
        this.u = r45;
        goto L43
    L27:
        if (r44.getTrayType() <= 0) goto L41;
        py.k r46 = r44.getTrayRightImgV2();
        if (r46 == null) goto L31;
        List r47 = r46.getUrls();
    L32:
        List r48 = r47;
        if (r48 != null) goto L35;
    L38:
        boolean r49 = true;
    L39:
        if (r49 == true) goto L41;
        r45 = true;
        goto L42
    L35:
        if (r48.isEmpty() == true) goto L38;
        r49 = false;
        goto L39
    L31:
        r47 = null;
        goto L32
    L7:
        if (J() == false) goto L9;
        r10 = true;
        goto L10
    }

    public View o(int r3) {
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

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setClickListener(s02.c r1) {
        this.e = r1;
    }

    public final void setDispose(Disposable r1) {
        this.H = r1;
    }

    public void setDuration(NormalGiftMessage r8) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r0 = this.C;
        if (r0 == null) goto L8;
        Iterator<o3> r1 = r0.b.iterator();
        long r3 = 0;
    L6:
        if (r1.hasNext() == false) goto L9;
        r3 = r3 + r1.next().getDuration();
    L9:
        this.b = r3;
        if (r3 == 0) goto L12;
        return;
    L12:
        int r2 = com.bytedance.android.livesdk.gift.platform.business.tray2.k.c;
        ReadOnlyProperty r4 = com.bytedance.android.livesdk.gift.platform.business.e.f;
        KProperty[] r5 = com.bytedance.android.livesdk.gift.platform.business.e.a;
        Long r6 = null;
        boolean r7 = true;
        if (((Number) r4.getValue(null, r5[4])).intValue() == 1) goto L16;
        r7 = false;
    L16:
        if (r7 == false) goto L18;
        long r9 = 2000;
    L32:
        this.b = r9;
        return;
    L18:
        v2 r10 = com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.a;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.m.getValue(null, r5[11])).booleanValue() == false) goto L31;
        o7 r11 = r8.r();
        if (r11 == null) goto L23;
        o0 r13 = r11.getTrayInfo();
    L24:
        if (r13 == null) goto L26;
        r6 = Long.valueOf(r13.getDuration());
    L26:
        if (r6 != null) goto L28;
    L30:
        r9 = y(r8);
        goto L32
    L28:
        if (r13.getDuration() <= 0) goto L30;
        r9 = RangesKt.coerceAtLeast((long) (r13.getDuration() / com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.i(r8)), 1000);
        goto L32
    L23:
        r13 = null;
        goto L24
    L31:
        r9 = y(r8);
        goto L32
    L8:
        r3 = 0;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setGiftControllerCallback(s02.b r1) {
        this.o = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setShowCombo(boolean r1) {
        this.d = r1;
    }

    public final void v(boolean r4) {
        if (((w) com.bytedance.android.livesdk.gift.platform.business.e.G.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[31])).b() == true) goto L5;
        return;
    L5:
        TextView r0 = (TextView) findViewById(2131392055);
        if (r0 == null) goto L11;
        if (r4 == true) goto L9;
        r0.setTextSize(2, 13.0f);
    L9:
        r0.getPaint().setFakeBoldText(true);
        r0.postInvalidate();
        return;
    }

    public final long y(NormalGiftMessage r4) {
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L6;
        return this.l.k(r4.getTotalMoney(), com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.i(r4));
    L6:
        return this.l.i(((com.bytedance.android.livesdk.gift.platform.business.tray.a) r4).t(false), com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.i(r4));
    }

    public final void setDuration(long r1) {
        this.b = r1;
    }

    public static final void r(NormalGiftCombViewV2 r3, long r4) {
        if (r4 > 0) goto L7;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.k r0 = r3.C;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        r3.D = Observable.timer(r4, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.h(r3));
        return;
    L7:
        r3.getClass();
        goto L8
    }

    public static final void s(NormalGiftCombViewV2 r2, boolean r3) {
        Animator r0 = r2.S;
        if (r0 != null) goto L5;
    L9:
        if (r3 == false) goto L11;
        int r4 = 2131373725;
    L12:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r2.o(r4), "alpha", new float[]{0.1f, 1.0f});
        r2.S = r5;
        if (r5 == null) goto L15;
        r5.setDuration(200);
    L15:
        Animator r6 = r2.S;
        if (r6 == null) goto L19;
        r6.start();
        return;
    L19:
        return;
    L11:
        r4 = 2131370475;
        goto L12
    L5:
        if (r0.isRunning() != true) goto L9;
        Animator r1 = r2.S;
        if (r1 == null) goto L9;
        r1.cancel();
        goto L9
    }

    public final void B(NormalGiftMessage r29, boolean r30) {
        List<String> r2 = r29.C;
        if (r2.size() != 1) goto L19;
        PointF r3 = this.P;
        dq2.d r7 = this.M;
        if (r7 == null) goto L7;
        PointF r8 = r7.d((String) ListProtector.get(r2, 0));
    L8:
        i02.f r9 = this.w;
        if (r8 == null) goto L19;
        if (r3 == null) goto L19;
        if (r9 == null) goto L19;
        if (r9.a() != true) goto L19;
        if (r3.x <= r8.x) goto L19;
        boolean r4 = true;
    L20:
        L(r29);
        if (r30 == false) goto L29;
        HSImageView r10 = o(2131370475);
        if (r10 == null) goto L29;
        DraweeController r11 = r10.getController();
        if (r11 == null) goto L29;
        Animatable r13 = r11.getAnimatable();
        if (r13 == null) goto L29;
        r13.stop();
        r13.start();
    L29:
        iy1.a r14 = r29.z;
        if (r14 != null) goto L32;
        return;
    L32:
        if (r14.b != 15) goto L94;
        dq2.d r15 = this.M;
        if (r15 != null) goto L36;
    L91:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.b("NormalGiftCombViewV2", "animService can not execute fly mic animation");
        return;
    L36:
        if (r15.a() != true) goto L91;
        if (r4 == false) goto L40;
        int r5 = this.K;
    L45:
        PointF r16 = new PointF(r5, this.L);
        r29.e.getIdString();
        dq2.d r17 = this.M;
        if (r17 == null) goto L80;
        String r18 = r29.u();
        String r19 = r29.getFromUserId();
        List<String> r110 = r29.C;
        h2 r20 = r29.w;
        if (r20 == null) goto L50;
        int r111 = r20.getType();
    L52:
        if (r29.m != 1) goto L54;
        boolean r112 = true;
    L55:
        long r6 = r29.G;
        o7 r21 = r29.r();
        if (r21 == null) goto L58;
        int r23 = r21.getMultiSendEffectLevel();
    L59:
        h2 r24 = r29.w;
        i02.f r25 = this.w;
        if (r25 == null) goto L62;
        boolean r26 = r25.a();
    L63:
        i02.f r27 = this.w;
        if (r27 == null) goto L66;
        int r28 = r27.b();
    L67:
        eq2.c r31 = new eq2.c(r18, r19, r110, r111, r112, r6, r23, null, 0, BuildConfig.FLAVOR, r24, null, new com.bytedance.android.live.liveinteract.videotalk.emoji.model.s(r26, r28));
        iy1.a r33 = r29.z;
        if (r33 == null) goto L70;
        String r113 = r33.a;
    L71:
        PointF r34 = this.T;
        if (r34 != null) goto L74;
        r34 = r16;
    L74:
        o7 r1 = r29.r();
        if (r1 == null) goto L77;
        o0 r35 = r1.getTrayInfo();
    L78:
        r17.h(null, r31, null, r113, null, new eq2.e(r34, r2, r35));
        goto L80
    L77:
        r35 = null;
        goto L78
    L70:
        r113 = null;
        goto L71
    L66:
        r28 = Integer.MIN_VALUE;
        goto L67
    L62:
        r26 = false;
        goto L63
    L58:
        r23 = 0;
        goto L59
    L54:
        r112 = false;
        goto L55
    L50:
        r111 = 15;
    L80:
        if (this.T != null) goto L82;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("NormalGiftCombViewV2", "execute fly mic animation, pointF is " + r16.x + ", pointF is " + r16.y);
        return;
    L82:
        StringBuilder r36 = new StringBuilder("execute fly mic animation, startPointFX is ");
        PointF r37 = this.T;
        if (r37 == null) goto L85;
        Float r38 = Float.valueOf(r37.x);
    L86:
        r36.append(r38);
        r36.append(", startPointFY is ");
        PointF r39 = this.T;
        if (r39 == null) goto L89;
        Float r40 = Float.valueOf(r39.y);
    L90:
        r36.append(r40);
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a("NormalGiftCombViewV2", r36.toString());
        return;
    L89:
        r40 = null;
        goto L90
    L85:
        r38 = null;
        goto L86
    L40:
        int r41 = this.K;
        HSImageView r43 = o(2131370475);
        if (r43 == null) goto L43;
        Integer r44 = Integer.valueOf(r43.getWidth());
    L44:
        r5 = r41 + r44.intValue();
        goto L45
    L43:
        r44 = null;
        goto L44
    L94:
        return;
    L7:
        r8 = null;
    L19:
        r4 = false;
        goto L20
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void h(r02.b.C0268b r26, boolean r27) {
        this.n = r26;
        NormalGiftMessage r1 = this.f;
        if (r1 == null) goto L11;
        o7 r2 = r1.r();
        if (r2 == null) goto L11;
        o0 r3 = r2.getTrayInfo();
        if (r3 == null) goto L11;
        w3 r4 = r3.getTrayPreEffect();
        if (r4 == null) goto L11;
        Integer r5 = Integer.valueOf(r4.getPreEffectSource());
    L13:
        if (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l.f(r5) == false) goto L109;
        NormalGiftMessage r6 = this.f;
        if (r6 == null) goto L109;
        o7 r7 = r6.r();
        if (r7 == null) goto L109;
        o0 r8 = r7.getTrayInfo();
        if (r8 == null) goto L109;
        w3 r9 = r8.getTrayPreEffect();
        if (r9 == null) goto L109;
        py.k r10 = r9.getPreEffectImg();
        if (r10 == null) goto L109;
        if (r10.isValid() != true) goto L109;
        NormalGiftMessage r11 = this.f;
        if (r11 == null) goto L116;
        o7 r13 = r11.r();
        if (r13 == null) goto L117;
        o0 r14 = r13.getTrayInfo();
        if (r14 == null) goto L118;
        w3 r15 = r14.getTrayPreEffect();
        if (r15 == null) goto L119;
        py.k r16 = r15.getPreEffectImg();
        if (r16 != null) goto L37;
        return;
    L37:
        if (r16.isValid() == true) goto L40;
        r16 = null;
    L40:
        if (r16 == null) goto L121;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.a r17 = this.R;
        NormalGiftMessage r18 = this.f;
        if (r18 == null) goto L50;
        o7 r19 = r18.r();
        if (r19 == null) goto L50;
        o0 r20 = r19.getTrayInfo();
        if (r20 == null) goto L50;
        w3 r21 = r20.getTrayPreEffect();
        if (r21 == null) goto L50;
        py.k r110 = r21.getTrayRipple();
    L51:
        NormalGiftMessage r23 = this.f;
        if (r23 == null) goto L60;
        o7 r24 = r23.r();
        if (r24 == null) goto L60;
        o0 r25 = r24.getTrayInfo();
        if (r25 == null) goto L60;
        w3 r28 = r25.getTrayPreEffect();
        if (r28 == null) goto L60;
        Long r111 = Long.valueOf(r28.getTrayStartTime());
    L61:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "entryImage");
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.b r29 = r17.k;
        if (r29 == null) goto L64;
        r29.b();
    L64:
        HSImageView r112 = r17.a;
        ViewGroup r30 = r17.b;
        TrayWaveControllerView r31 = r17.c;
        q02.d r33 = r17.i;
        boolean r34 = r17.j;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.b r113 = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.b(r112, r30, r31, r33, r34, r18);
        r17.k = r113;
        Intrinsics.checkNotNullParameter(r16, "entryImage");
        if (r30 == null) goto L67;
        r30.setVisibility(8);
    L67:
        if (r112 == null) goto L70;
        r112.setController(null);
    L70:
        if (r112 == null) goto L73;
        r112.setVisibility(0);
    L73:
        if (r31 == null) goto L104;
        r31.a();
        r31.a = new ArrayList();
        r31.b = new ArrayList();
        float r35 = r31.getX();
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p r36 = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p(r31.getContext(), r110, r34);
        if (r34 == false) goto L77;
        int r37 = TrayWaveControllerView.d;
    L78:
        AnimatorSet r38 = r36.a(r35 + r37, r35, 1400, 800, 600);
        List<AnimatorSet> r39 = r31.a;
        if (r39 == null) goto L81;
        ((ArrayList) r39).add(r38);
    L81:
        List<com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p> r40 = r31.b;
        if (r40 == null) goto L84;
        ((ArrayList) r40).add(r36);
    L84:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p r41 = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p(r31.getContext(), r110, r34);
        if (r34 == false) goto L87;
        int r43 = TrayWaveControllerView.f;
    L88:
        AnimatorSet r44 = r41.a(r35 + r43, r35, 1150, 750, 400);
        List<AnimatorSet> r45 = r31.a;
        if (r45 == null) goto L91;
        ((ArrayList) r45).add(r44);
    L91:
        List<com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p> r46 = r31.b;
        if (r46 == null) goto L94;
        ((ArrayList) r46).add(r41);
    L94:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p r47 = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p(r31.getContext(), r110, r34);
        if (r34 == false) goto L97;
        int r48 = TrayWaveControllerView.h;
    L98:
        AnimatorSet r49 = r47.a(r35 + r48, r35, 850, 600, 250);
        List<AnimatorSet> r50 = r31.a;
        if (r50 == null) goto L101;
        ((ArrayList) r50).add(r49);
    L101:
        List<com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.p> r51 = r31.b;
        if (r51 == null) goto L104;
        ((ArrayList) r51).add(r47);
        goto L104
    L97:
        r48 = TrayWaveControllerView.g;
        goto L98
    L87:
        r43 = TrayWaveControllerView.e;
        goto L88
    L77:
        r37 = TrayWaveControllerView.c;
    L104:
        Ref.BooleanRef r53 = new Ref.BooleanRef();
        r53.element = false;
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.e r54 = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.e(r113, r53, r111);
        if (r30 == null) goto L107;
        r30.postDelayed(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.c(r113, r53), 5000);
    L107:
        if (r112 == null) goto L122;
        r112.setController(Fresco.newDraweeControllerBuilder().setControllerListener(r54).setUri((String) ListProtector.get(r16.getUrls(), 0)).setAutoPlayAnimations(false).build());
        return;
    L122:
        return;
    L60:
        r111 = null;
    L50:
        r110 = null;
        goto L51
    L121:
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L116:
        return;
    L109:
        if (r27 == false) goto L111;
        Animator r55 = getGiftEntryAnimDegrade();
    L112:
        this.c = r55;
        if (r55 == null) goto L124;
        r55.start();
        return;
    L124:
        return;
    L111:
        r55 = this.m.b(this, this.G);
    L11:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void n(int r2, int r3) {
        this.m.a(this, r2, r3);
    }

    public final void w(py.k r4, Function0<Unit> r5) {
        if (r4 == null) goto L16;
        List r0 = r4.getUrls();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L18;
        HSImageView r2 = o(2131370475);
        if (r2 == null) goto L17;
        r2.setController(Fresco.newDraweeControllerBuilder().setUri((String) CollectionsKt.first(r4.getUrls())).setAutoPlayAnimations(true).setControllerListener(new f(r5)).build());
        return;
    L17:
        return;
    L18:
        return;
    L6:
        if (r0.isEmpty() == true) goto L9;
        r1 = false;
        goto L10
    }

    public static final void t(NormalGiftCombViewV2 r2, boolean r3, Function0 r4) {
        Animator r0 = r2.S;
        if (r0 != null) goto L5;
    L9:
        if (r3 == false) goto L11;
        View r5 = r2.o(2131373725);
    L12:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.1f});
        r2.S = r6;
        if (r6 == null) goto L15;
        r6.setDuration(200);
    L15:
        Animator r7 = r2.S;
        if (r7 == null) goto L18;
        r7.addListener(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.i(r4));
    L18:
        Animator r8 = r2.S;
        if (r8 == null) goto L22;
        r8.start();
        return;
    L22:
        return;
    L11:
        r5 = r2.o(2131370475);
        goto L12
    L5:
        if (r0.isRunning() != true) goto L9;
        Animator r1 = r2.S;
        if (r1 == null) goto L9;
        r1.cancel();
        goto L9
    }

    public final void D(py.k r4, boolean r5, Function1<? super Bitmap, Unit> r6) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.N == false) goto L7;
        int r0 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168749);
        ResizeOptions r1 = new ResizeOptions(r0, r0);
    L8:
        GiftImageLoader.k.getClass();
        Intrinsics.checkNotNullParameter("live_gift_tray", "callerContext");
        this.h = Single.create(new com.bytedance.android.livesdk.gift.util.e(r4, r1, "live_gift_tray")).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this, r5, r6), h0.a);
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void x(ImageView r2, py.k r3, boolean r4) {
        if (com.bytedance.android.livesdk.gift.platform.business.b.d() == false) goto L7;
        if (r4 == false) goto L6;
        ImageUtil.loadRoundImage(r2, r3);
        return;
    L6:
        ImageUtil.loadImage(r2, r3, 0);
        return;
    L7:
        a1.k(r3).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r4, r2));
    }

    public final Bitmap z(Bitmap r9, int r10, int r11) {
        if (r9 == null) goto L9;
        int r4 = r9.getWidth();     // Catch: Throwable -> L6
        int r5 = r9.getHeight();     // Catch: Throwable -> L6
        Matrix r6 = new Matrix();     // Catch: Throwable -> L6
        r6.postScale(r10 / r4, r11 / r5);     // Catch: Throwable -> L6
        return Bitmap.createBitmap(r9, 0, 0, r4, r5, r6, true);
    L10:
        return null;
    L9:
        return null;
    }

    public NormalGiftCombViewV2(Context r18, AttributeSet r19, int r20, boolean r21, uu0.b r23) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        this.U = r21;
        this.V = r23;
        this.a = new LinkedHashMap();
        boolean r3 = true;
        this.d = true;
        this.h = Disposables.disposed();
        this.l = n12.e.a();
        if (r21 == false) goto L12;
        if (com.bytedance.android.livesdk.gift.platform.business.b.a() == false) goto L8;
        q02.a r4 = new com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.a();
    L18:
        this.m = r4;
        this.t = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.e.q.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[15])).booleanValue();
        this.v = true;
        this.E = new o(this);
        this.G = new k(this);
        this.K = -1;
        this.L = -1;
        this.M = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getInteractAnimationService();
        i12.e r5 = i12.o.b();
        if (r5 == null) goto L21;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d.class);
    L22:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d r7 = (com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.d) r6;
        if (r7 != null) goto L25;
    L27:
        boolean r8 = false;
    L28:
        GiftImageLoader.k.getClass();
        this.N = ((Boolean) GiftImageLoader.i.getValue()).booleanValue();
        this.O = new NormalGiftCombViewV2$degradeRunnable$1(this);
        this.R = new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.a();
        if (r21 == false) goto L39;
        GiftNitaViewInfo r9 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT;
        if (r8 == false) goto L36;
        if (r7 == null) goto L34;
        r7.c(this, r9);
    L34:
        if (r7 == null) goto L37;
        r7.d(r9);
    L37:
        this.Q = 0;
        this.x = 0;
        this.y = 0;
    L86:
        TextView r10 = (TextView) findViewById(2131382822);
        this.F = r10;
        ImageView r11 = (ImageView) o(2131392002);
        if (r11 == null) goto L90;
        r11.setOnClickListener(new a(this));
    L90:
        if (r21 == true) goto L106;
        HSImageView r2 = o(2131380986);
        if (r2 == null) goto L94;
        r2.setOnClickListener(new b(this));
    L94:
        HSImageView r13 = o(2131380985);
        if (r13 == null) goto L97;
        r13.setOnClickListener(new c(this));
    L97:
        HSImageView r14 = o(2131371684);
        if (r14 == null) goto L100;
        r14.setOnClickListener(new d(this, r18));
    L100:
        g r15 = new g(this, r18);
        HSImageView r16 = o(2131371870);
        if (r16 == null) goto L103;
        r16.setOnClickListener(r15);
    L103:
        if (r10 == null) goto L106;
        r10.setOnClickListener(r15);
    L106:
        if (x.d() == true) goto L124;
        if (r8 == false) goto L110;
        if (r7 == null) goto L110;
        Typeface r0 = r7.a(r18);     // Catch: Exception -> L121
    L111:
        TextView r17 = (TextView) o(2131367247);     // Catch: Exception -> L121
        if (r17 == null) goto L114;
        r17.setTypeface(r0);     // Catch: Exception -> L121
    L114:
        TextView r24 = (TextView) o(2131367236);     // Catch: Exception -> L121
        if (r24 == null) goto L117;
        r24.setTypeface(r0);     // Catch: Exception -> L121
    L117:
        TextView r25 = (TextView) o(2131373941);     // Catch: Exception -> L121
        if (r25 == null) goto L124;
        r25.setTypeface(r0);     // Catch: Exception -> L121
    L110:
        r0 = Typeface.createFromAsset(r18.getAssets(), "font/ttlive_base_gift_combo_opt_font.ttf");     // Catch: Exception -> L121
    L121:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("NormalGiftCombViewV2", "load font asset exception: " + e.getMessage(), null, 4);
    L124:
        if (PadConfigUtils.c() == false) goto L132;
        ConstraintLayout r1 = (TrayContainerView) o(2131380987);
        if (r1 == null) goto L128;
        com.bytedance.android.live.core.utils.a1.m(r1, s1.f(20.0f));
    L128:
        HSImageView r26 = o(2131371684);
        if (r26 == null) goto L131;
        com.bytedance.android.live.core.utils.a1.m(r26, s1.f(8.0f));
    L131:
        this.Q -= s1.f(8.0f);
    L132:
        com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation.a r27 = this.R;
        HSImageView r28 = o(2131371684);
        ViewGroup r29 = (ViewGroup) o(2131380987);
        TrayWaveControllerView r30 = (TrayWaveControllerView) o(2131393022);
        View r31 = o(2131367231);
        View r33 = o(2131373930);
        View r34 = o(2131392032);
        HSImageView r110 = o(2131371870);
        TextView r111 = this.F;
        HSImageView r112 = o(2131380985);
        HSImageView r113 = o(2131380986);
        k r114 = this.G;
        if (this.r == true) goto L135;
    L137:
        r3 = false;
    L138:
        r27.a = r28;
        r27.b = r29;
        r27.c = r30;
        r27.f = r31;
        r27.h = r33;
        r27.g = r34;
        r27.d = r110;
        r27.e = r111;
        r27.i = r114;
        r27.j = r3;
        return;
    L135:
        if (this.s == true) goto L137;
    L36:
        LayoutInflater.from(r18).inflate(2131567676, this);
        goto L37
    L39:
        if (getPreviewData() == null) goto L41;
        boolean r35 = true;
    L42:
        this.s = r35;
        int r115 = x12.b.a();
        gq2.b r116 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        r116.c();
        if (r116.d(r115, 4) == false) goto L53;
        if (r35 == true) goto L53;
        this.r = true;
        GiftNitaViewInfo r36 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3_PK;
        if (r8 == false) goto L51;
        if (r7 == null) goto L49;
        r7.c(this, r36);
    L49:
        if (r7 == null) goto L52;
        r7.d(r36);
    L52:
        this.Q = (s1.f(138.0f) - s1.f(40.0f)) + s1.f(12.0f);
        this.x = s1.f(40.0f);
        this.y = s1.f(40.0f);
        v(true);
        goto L86
    L51:
        LayoutInflater.from(r18).inflate(2131567678, this);
    L53:
        r116.k();
        if (r116.d(r115, 64) == false) goto L65;
        if (r35 == true) goto L65;
        this.r = true;
        GiftNitaViewInfo r37 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3_PK;
        if (r8 == false) goto L62;
        if (r7 == null) goto L60;
        r7.c(this, r37);
    L60:
        if (r7 == null) goto L63;
        r7.d(r37);
    L63:
        this.Q = (s1.f(12.0f) + s1.f(138.0f)) - s1.f(40.0f);
        this.x = s1.f(40.0f);
        this.y = s1.f(40.0f);
        v(true);
        goto L86
    L62:
        LayoutInflater.from(r18).inflate(2131567678, this);
    L65:
        if (u.p() == false) goto L68;
        LayoutInflater.from(r18).inflate(2131567679, this);
        goto L86
    L68:
        if (u.j() == false) goto L78;
        if (r35 == true) goto L78;
        this.r = true;
        GiftNitaViewInfo r38 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3_PK;
        if (r8 == false) goto L76;
        if (r7 == null) goto L74;
        r7.c(this, r38);
    L74:
        if (r7 == null) goto L77;
        r7.d(r38);
    L77:
        this.Q = (s1.f(12.0f) + s1.f(138.0f)) - s1.f(40.0f);
        this.x = s1.f(40.0f);
        this.y = s1.f(40.0f);
        v(true);
        goto L86
    L76:
        LayoutInflater.from(r18).inflate(2131567678, this);
    L78:
        GiftNitaViewInfo r39 = GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3;
        if (r8 == false) goto L84;
        if (r7 == null) goto L82;
        r7.c(this, r39);
    L82:
        if (r7 == null) goto L85;
        r7.d(r39);
    L85:
        this.Q = (s1.f(12.0f) + s1.f(168.0f)) - s1.f(50.0f);
        this.x = s1.f(50.0f);
        this.y = s1.f(50.0f);
        v(false);
        goto L86
    L84:
        LayoutInflater.from(r18).inflate(2131567677, this);
        goto L85
    L41:
        r35 = false;
        goto L42
    L25:
        if (r7.a.b() != true) goto L27;
        r8 = true;
        goto L28
    L21:
        r6 = null;
        goto L22
    L8:
        if (com.bytedance.android.livesdk.gift.platform.business.a.a() <= 0) goto L10;
        r4 = new q02.c();
        goto L18
    L10:
        r4 = new q02.b();
        goto L18
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.b.a() == false) goto L15;
        r4 = new com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b();
        goto L18
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.a.a() <= 0) goto L17;
        r4 = new q02.f();
        goto L18
    L17:
        r4 = new q02.e();
        goto L18
    }

    public final void O(HSImageView r4, HSImageView r5, py.k r6, int r7, py.k r8) {
        Integer r0 = null;
        if (r5 == null) goto L6;
        r5.setController(null);
    L6:
        if (r5 == null) goto L8;
        r5.setVisibility(0);
    L8:
        if (r8 == null) goto L11;
        r6 = r8;
    L11:
        s r9 = new s(r4);
        if (r7 <= 4) goto L14;
        List r10 = r6.getUrls();
        if (r10 == null) goto L21;
        r0 = Integer.valueOf(r10.size());
    L21:
        if (r0.intValue() < 1) goto L28;
        AbstractDraweeController r11 = Fresco.newDraweeControllerBuilder().setControllerListener(r9).setUri((String) ListProtector.get(r6.getUrls(), 0)).setAutoPlayAnimations(true).build();
        if (r5 == null) goto L29;
        r5.setController(r11);
        return;
    L29:
        return;
    L28:
        return;
    L14:
        if (com.bytedance.android.livesdk.gift.platform.business.b.d() == false) goto L16;
        ImageUtil.loadImage(r5, r6, new p(r4));
        return;
    L16:
        this.H = a1.k(r6).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(r4, r5), r.a);
    }

    public /* synthetic */ NormalGiftCombViewV2(Context r9, AttributeSet r10, int r11, boolean r13, uu0.b r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        AttributeSet r4 = null;
    L7:
        if ((r15 & 4) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r15 & 8) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r15 & 16) == 0) goto L17;
        uu0.b r7 = null;
    L18:
        this(r9, r4, r5, r6, r7);
        return;
    L17:
        r7 = r14;
        goto L18
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
