package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<TouchDelegate> f6400a;

    public j(View r10, Rect r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "emptyRect");
        super(r11, r10);
        this.f6400a = new ArrayList();
    }

    public /* synthetic */ j(View r10, Rect r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = new Rect();
    L5:
        this(r10, r11);
    }

    public final void a(TouchDelegate r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f6400a.add(r10);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        float r11 = r10.getX();
        float r12 = r10.getY();
        Iterator<T> r13 = this.f6400a.iterator();
    L3:
        boolean r14 = false;
    L5:
        if (r13.hasNext() == false) goto L10;
        TouchDelegate r15 = (TouchDelegate) r13.next();
        r10.setLocation(r11, r12);
        if (r15.onTouchEvent(r10) == true) goto L9;
        if (r14 == false) goto L3;
    L9:
        r14 = true;
        goto L5
    L10:
        return r14;
    }
}
