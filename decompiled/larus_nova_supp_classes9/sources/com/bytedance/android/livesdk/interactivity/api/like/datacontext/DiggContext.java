package com.bytedance.android.livesdk.interactivity.api.like.datacontext;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import u32.d;
import u32.h;
import u32.k;
import u32.l;
import u32.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b,\u0010-R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u001dR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u001dR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u001dR!\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/like/datacontext/DiggContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/n;", "Lu32/k;", "diggWidget$delegate", "Lcom/bytedance/live/datacontext/p;", "getDiggWidget", "()Lcom/bytedance/live/datacontext/n;", "diggWidget", "Lu32/a;", "avatarAnimationController$delegate", "getAvatarAnimationController", "avatarAnimationController", "Lu32/h;", "heartAnimationController$delegate", "getHeartAnimationController", "heartAnimationController", "Lu32/o;", "thankAnimationController$delegate", "getThankAnimationController", "thankAnimationController", "Lu32/d;", "diggCountFlipperLayoutController$delegate", "getDiggCountFlipperLayoutController", "diggCountFlipperLayoutController", "Lcom/bytedance/live/datacontext/m;", BuildConfig.FLAVOR, "diggTime$delegate", "getDiggTime", "()Lcom/bytedance/live/datacontext/m;", "diggTime", BuildConfig.FLAVOR, "inDoubleLike$delegate", "getInDoubleLike", "inDoubleLike", "vsLiveRoomDiggCountAnim$delegate", "getVsLiveRoomDiggCountAnim", "vsLiveRoomDiggCountAnim", "Lcom/bytedance/live/datacontext/j;", "Lu32/l;", "doubleLikeManager$delegate", "getDoubleLikeManager", "()Lcom/bytedance/live/datacontext/j;", "doubleLikeManager", "<init>", "()V", "Companion", "a", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p avatarAnimationController$delegate;
    private final p diggCountFlipperLayoutController$delegate;
    private final p diggTime$delegate;
    private final p diggWidget$delegate;
    private final p doubleLikeManager$delegate;
    private final p heartAnimationController$delegate;
    private final p inDoubleLike$delegate;
    private final p thankAnimationController$delegate;
    private final p vsLiveRoomDiggCountAnim$delegate;

    public static final class a {
        public a() {
        }

        public static DiggContext a(DataCenter r4) {
            return com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r4, 0, 2));
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(DiggContext.class, "diggWidget", "getDiggWidget()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "avatarAnimationController", "getAvatarAnimationController()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "heartAnimationController", "getHeartAnimationController()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "thankAnimationController", "getThankAnimationController()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "diggCountFlipperLayoutController", "getDiggCountFlipperLayoutController()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "diggTime", "getDiggTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "inDoubleLike", "getInDoubleLike()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "vsLiveRoomDiggCountAnim", "getVsLiveRoomDiggCountAnim()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(DiggContext.class, "doubleLikeManager", "getDoubleLikeManager()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    public final n<u32.a> getAvatarAnimationController() {
        return (n) this.avatarAnimationController$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<d> getDiggCountFlipperLayoutController() {
        return (n) this.diggCountFlipperLayoutController$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Long> getDiggTime() {
        return (m) this.diggTime$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<k> getDiggWidget() {
        return (n) this.diggWidget$delegate.a(this, $$delegatedProperties[0]);
    }

    public final j<l> getDoubleLikeManager() {
        return (j) this.doubleLikeManager$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<h> getHeartAnimationController() {
        return (n) this.heartAnimationController$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getInDoubleLike() {
        return (m) this.inDoubleLike$delegate.a(this, $$delegatedProperties[6]);
    }

    public final n<o> getThankAnimationController() {
        return (n) this.thankAnimationController$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Boolean> getVsLiveRoomDiggCountAnim() {
        return (m) this.vsLiveRoomDiggCountAnim$delegate.a(this, $$delegatedProperties[7]);
    }

    public DiggContext() {
        this.diggWidget$delegate = q.c(this);
        this.avatarAnimationController$delegate = q.c(this);
        this.heartAnimationController$delegate = q.c(this);
        this.thankAnimationController$delegate = q.c(this);
        this.diggCountFlipperLayoutController$delegate = q.c(this);
        this.diggTime$delegate = q.d(this, 0L);
        this.inDoubleLike$delegate = q.d(this, Boolean.FALSE);
        this.vsLiveRoomDiggCountAnim$delegate = q.d(this, Boolean.TRUE);
        this.doubleLikeManager$delegate = ConstantKt.c(this);
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        IBaseDiggService r1 = (IBaseDiggService) jc1.k.f(IBaseDiggService.class);
        if (r1 == null) goto L11;
        l r2 = r1.provideDoubleLikeManager(r0);
        if (r2 == null) goto L12;
        getDoubleLikeManager().d(r2);
        return;
    L12:
        return;
    L11:
        return;
    }
}
