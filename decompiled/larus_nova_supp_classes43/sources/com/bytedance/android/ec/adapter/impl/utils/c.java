package com.bytedance.android.ec.adapter.impl.utils;

import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.BottomRightBanner;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.DirectedFLashSaleEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.FloatingButton;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.HourRankEntrance;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ILayoutConstraint;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.StartLivePreviewButtonCommerce;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.ToolbarMain;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.TopRightRow4thWidget;
import kotlin.jvm.internal.Intrinsics;
import xd.d;
import xd.e;
import xd.h;
import xd.i;
import xd.j;
import xd.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final ILayoutConstraint a(k r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$live");
        if ((r1 instanceof xd.b) == false) goto L6;
        return BottomRightBanner.INSTANCE;
    L6:
        if ((r1 instanceof d) == false) goto L9;
        return FloatingButton.INSTANCE;
    L9:
        if ((r1 instanceof i) == false) goto L12;
        return ToolbarMain.INSTANCE;
    L12:
        if ((r1 instanceof h) == false) goto L15;
        return StartLivePreviewButtonCommerce.INSTANCE;
    L15:
        if ((r1 instanceof e) == false) goto L18;
        return HourRankEntrance.INSTANCE;
    L18:
        if ((r1 instanceof xd.c) == false) goto L21;
        return DirectedFLashSaleEntrance.INSTANCE;
    L21:
        if ((r1 instanceof j) == false) goto L25;
        return TopRightRow4thWidget.INSTANCE;
    L25:
        throw new Exception("unknown layout constraint!!");
    }
}
