package com.bytedance.android.live.profile.ui.component.view;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.live.base.model.user.ProfileBadgeSuffix;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdkapi.message.Text;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mb2.d;
import py.k;
import qb2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends q0 {
    public final /* synthetic */ ProfileBadgeSuffixView a;
    public final /* synthetic */ k b;
    public final /* synthetic */ ProfileBadgeSuffix c;

    public a(ProfileBadgeSuffixView r1, k r2, ProfileBadgeSuffix r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void h(k r6, int r7, int r8) {
        HSImageView r9 = this.a.b;
        k r10 = this.b;
        Intrinsics.checkNotNullParameter(r10, "$this$widthKt");
        a1.p(r9, UtilityKotlinExtentionsKt.i(r10.getWidth()));
        HSImageView r12 = this.a.b;
        k r13 = this.b;
        Intrinsics.checkNotNullParameter(r13, "$this$heightKt");
        a1.k(r12, UtilityKotlinExtentionsKt.i(r13.getHeight()));
        this.a.b.setVisibility(0);
        ProfileBadgeSuffixView r14 = this.a;
        ProfileBadgeSuffix r0 = this.c;
        k r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "$this$heightKt");
        int r15 = r1.getHeight();
        r14.getClass();
        if (r0 != null) goto L22;
        r14.a.setVisibility(8);
        r14.c.setVisibility(8);
        return;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        GradientDrawable r3 = new GradientDrawable();     // Catch: Throwable -> L11
        r3.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);     // Catch: Throwable -> L11
        if (r15 <= 0) goto L8;
        int r4 = UtilityKotlinExtentionsKt.i(r15);     // Catch: Throwable -> L11
    L9:
        r3.setCornerRadius(r4);     // Catch: Throwable -> L11
        r3.setColors(new int[]{Color.parseColor(r0.getBgStartColor()), Color.parseColor(r0.getBgEndColor())});     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = null;
    L16:
        GradientDrawable r16 = (GradientDrawable) r5;
        if (r16 == null) goto L25;
        r14.a.setBackground(r16);
        Text r17 = r0.getText();
        if (r17 == null) goto L26;
        LiveRichContentEngine.a().a().c(d.a(r17, null, 1.0f), new g(false, 0.0f, 7), new b(r14, r15));
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r4 = s1.f(14.0f);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
