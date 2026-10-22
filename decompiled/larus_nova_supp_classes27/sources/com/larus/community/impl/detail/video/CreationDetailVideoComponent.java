package com.larus.community.impl.detail.video;

import android.util.Pair;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.community.impl.detail.c0;
import com.larus.community.impl.detail.f0;
import com.larus.platform.api.creation.UserCreation;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010(\u001a\u00020)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020+H\u0016J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0016J\b\u00108\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020)2\u0006\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020)H\u0016J\b\u0010;\u001a\u00020)H\u0016J\b\u0010<\u001a\u00020)H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000f\u001a\u0004\b%\u0010&R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/community/impl/detail/video/CreationDetailVideoComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/community/impl/detail/video/CreationDetailVideoAbility;", "<init>", "()V", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "Lkotlin/Lazy;", "creationDetailBottomToolsAbility", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "getCreationDetailBottomToolsAbility", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "creationDetailBottomToolsAbility$delegate", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "creationDetailFragmentAbility", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "getCreationDetailFragmentAbility", "()Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "creationDetailFragmentAbility$delegate", "creationTrackParams", "Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "getCreationTrackParams", "()Lcom/larus/community/impl/detail/model/CreationTrackParamsWrap;", "videoReportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "getVideoReportHelper", "()Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "videoReportHelper$delegate", "onAttach", "", "getVideoView", "Lcom/larus/community/impl/detail/video/CreationDetailVideoView;", "containerView", "progressView", "Lcom/larus/common_ui/video/progress/PlayerProgressView;", "isResumed", "", "logPlayback", "event", "", "bindView", "creationDetailVideoView", "setVideoPauseByMute", "setVideoResumeByMute", "initObserver", "creation", "onResume", "onPause", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailVideoComponent extends ComponentFeature implements a {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public CreationDetailVideoView m;
    public boolean n;

    public final void onPause() {
        this.n = false;
        L2("pause");
        CreationDetailVideoView r0 = this.m;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    public final void onResume() {
        boolean r0 = true;
        this.n = true;
        L2("resume");
        CreationDetailVideoView r1 = this.m;
        if (r1 == null) goto L25;
        nr9.g r3 = r1.g;
        String r4 = null;
        if (r3 == null) goto L7;
        String r5 = r3.b;
    L8:
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L22;
        nr9.g r2 = r1.g;
        if (r2 == null) goto L19;
        r4 = r2.h;
    L19:
        if (m5.c(r4) == true) goto L22;
        boolean r7 = false;
    L23:
        if (r7 != true) goto L25;
    L26:
        if (r0 == false) goto L31;
        CreationDetailVideoView r8 = this.m;
        if (r8 == null) goto L32;
        r8.onResume();
        return;
    L32:
        return;
    L31:
        return;
    L22:
        r7 = true;
        goto L23
    L10:
        if (r5.length() == 0) goto L13;
        r6 = false;
        goto L14
    L7:
        r5 = null;
    L25:
        r0 = false;
        goto L26
    }

    @Override // com.larus.community.impl.detail.video.a
    public final void SZ() {
        CreationDetailVideoView r0 = this.m;
        if (r0 == null) goto L6;
        VideoPlayView.H(r0.d.d, 0, 2);
        return;
    }

    @Override // com.larus.community.impl.detail.video.a
    public final void Zz() {
        CreationDetailVideoView r0 = this.m;
        if (r0 == null) goto L6;
        r0.Y5(false);
        return;
    }

    public final void onDestroy() {
        L2("destroy");
        CreationDetailVideoView r1 = this.m;
        if (r1 == null) goto L8;
        r1.V5("destroy", false);
        r1.b6();
        if (r1.e == false) goto L7;
        r1.Z5();
        goto L8
    L7:
        r1.d.d.D();
    L8:
        this.m = null;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public CreationDetailVideoComponent() {
        this.h = LazyKt.lazy(new d(this));
        this.i = LazyKt.lazy(new e(this));
        this.j = LazyKt.lazy(new f(this));
        this.k = LazyKt.lazy(new g(this));
        this.l = LazyKt.lazy(new h());
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View, android.view.ViewGroup, com.larus.community.impl.detail.video.CreationDetailVideoView] */
    public final void F2(UserCreation r7) {
        String r0 = r7.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L48:
        ConstraintLayout r8 = this.m;
        if (r8 == null) goto L57;
        e1.o(r8);
        return;
    L57:
        return;
    L10:
        if (CollectionsKt.listOf(new Integer[]{7, 6, 9, 8, 10, 11, 12}).contains(Integer.valueOf(r7.b)) == false) goto L48;
        ?? r3 = this.m;
        if (r3 == 0) goto L54;
        e1.x(r3);
        p29.b r4 = (p29.b) this.l.getValue();
        j29.a r5 = (j29.a) s1a.d.a(this).a(j29.a.class);
        if (r5 == null) goto L16;
        zp9.g r6 = r5.a;
    L17:
        r3.j = r4;
        r3.i = r6;
        r3.T5(r7);
        c0 r9 = (c0) this.k.getValue();
        if (r9 != null) goto L20;
    L22:
        r1 = false;
    L23:
        int r10 = com.larus.utils.i.d(r3.getContext());
        int r11 = com.larus.utils.i.c(r3.getContext());
        if (r1 == false) goto L44;
        nr9.g r12 = r3.g;
        if (r12 == null) goto L45;
        nr9.f r13 = r12.g;
        if (r13 == null) goto L45;
        Integer r14 = r13.e;
        if (r14 == null) goto L45;
        int r15 = r14.intValue();
        nr9.f r16 = r12.g;
        if (r16 == null) goto L45;
        Integer r17 = r16.d;
        if (r17 == null) goto L45;
        Pair r18 = new Pair(Long.valueOf(r15), Long.valueOf(r17.intValue()));
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L38
        Object r21 = Result.constructor-impl(Float.valueOf(((Number) r18.first).floatValue() / ((Number) r18.second).longValue()));     // Catch: Throwable -> L38
    L40:
        Float r22 = Float.valueOf(0.0f);
        if (Result.isFailure-impl(r21) == false) goto L43;
        r21 = r22;
    L43:
        float r23 = ((Number) r21).floatValue();
        int r24 = f0.a;
        r3.d.b.getLayoutParams().height = f0.a(r3.getContext(), r23);
        r3.d.b.requestLayout();
    L38:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L45:
        Function0<Unit> r26 = new b(this);
        Function0<Unit> r27 = new c(this);
        r3.a = r26;
        r3.b = null;
        r3.c = r27;
        if (this.n == false) goto L55;
        r3.onResume();
        return;
    L55:
        return;
    L44:
        r3.d.b.getLayoutParams().height = (int) RangesKt.coerceAtMost(c7.b(600), RangesKt.coerceAtMost(r11 * 0.7f, r10 / r3.w));
        r3.d.b.requestLayout();
        goto L45
    L20:
        if (r9.ak() != true) goto L22;
    L16:
        r6 = null;
        goto L17
    L54:
        return;
    L5:
        if (o0.d(r0) != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void L2(String r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[playback] ");
        r1.append(r5);
        r1.append(" component=");
        r1.append(hashCode());
        r1.append(" owner=");
        ConstraintLayout r6 = this.m;
        String r2 = null;
        if (r6 == null) goto L5;
        Integer r7 = Integer.valueOf(r6.hashCode());
    L6:
        r1.append(r7);
        r1.append(" creation=");
        j29.c r8 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r8 == null) goto L9;
        UserCreation r9 = r8.a;
    L10:
        if (r9 == null) goto L12;
        r2 = r9.a;
    L12:
        r1.append(r2);
        r1.append(" resumed=");
        r1.append(this.n);
        r0.i("CreationDetailVideoComponent", r1.toString());
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.community.impl.detail.video.a
    public final void jG(CreationDetailVideoView r9) {
        Intrinsics.checkNotNullParameter(r9, "creationDetailVideoView");
        CreationDetailVideoView r0 = this.m;
        if (r0 == r9) goto L10;
        if (r0 != null) goto L6;
    L9:
        this.m = r9;
        goto L10
    L6:
        if (r0.e == false) goto L9;
        r0.Z5();
    L10:
        L2("bind_view");
        ConstraintLayout r10 = this.m;
        if (r10 == null) goto L13;
        e1.o(r10);
    L13:
        j29.c r11 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r11 == null) goto L16;
        UserCreation r12 = r11.a;
    L17:
        if (r12 == null) goto L23;
        CreationDetailVideoView r1 = this.m;
        if (r1 == null) goto L21;
        F2(r12);
    L22:
        if (r1 == null) goto L23;
        return;
    L21:
        r1 = null;
    L23:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailVideoComponent$initObserver$1(this, null), 3, null);
        Unit r13 = Unit.INSTANCE;
        return;
    L16:
        r12 = null;
        goto L17
    }
}
