package com.obric.flow.cardlistpage.domain.repository;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.d;
import kotlinx.coroutines.sync.e;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {
    public static final d d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppWidgetManager f11512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gu.d f11513c;

    static {
        d = e.a();
    }

    public b(Context r5, AppWidgetManager r10, gu.d r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r11, "appWidgetHost");
        this.f11511a = r5;
        this.f11512b = r10;
        this.f11513c = r11;
    }

    public final Object a(BaseCardModel r5, ContinuationImpl r10) {
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new CardFeedRepositoryImpl$addCard$2(r5, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public final Object b(Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CardFeedRepositoryImpl$allocateInstanceId$2(null), r5);
    }

    public final Object c(Continuation r5) {
        Object r10 = BuildersKt.withContext(Dispatchers.getIO(), new CardFeedRepositoryImpl$checkFirstInstallOrUpgrade$2(this, null), r5);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final Object d(Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CardFeedRepositoryImpl$getSortedCards$2(null), r5);
    }

    public final Object e(String r5, ContinuationImpl r10) {
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new CardFeedRepositoryImpl$removeCard$2(r5, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public final Object f(BaseCardModel r5, ContinuationImpl r10) {
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new CardFeedRepositoryImpl$updateCard$2(r5, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
