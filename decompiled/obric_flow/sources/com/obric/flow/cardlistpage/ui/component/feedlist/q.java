package com.obric.flow.cardlistpage.ui.component.feedlist;

import android.view.DragEvent;
import android.view.View;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements View.OnDragListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11598c;
    public int d;
    public boolean e;
    public final /* synthetic */ s f;

    public q(s r5) {
        this.f = r5;
        this.f11596a = -1;
        this.f11597b = -1;
        this.f11598c = -1;
        this.d = -1;
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View r13, DragEvent r14) {
        Intrinsics.checkNotNullParameter(r13, "v");
        Intrinsics.checkNotNullParameter(r14, "event");
        int r15 = r14.getAction();
        ju.a r5 = ju.a.f18481a;
        s r10 = this.f;
        switch(r15) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L53;
            case 4: goto L6;
            case 5: goto L16;
            case 6: goto L16;
            default: goto L4;
        };
    L4:
        r5.i("FeedListComponent", "onDrag event: " + r14);
        return false;
    L16:
        r10.s(r14.getX(), r14.getY());
        return true;
    L17:
        this.e = false;
        this.f11596a = -1;
        this.f11597b = -1;
        this.f11598c = -1;
        this.d = -1;
        if (r14.getClipDescription().hasMimeType(new String[]{"text/vnd.android.intent", "launcher/custom.mimetype.widget"}) == true) goto L52;
        r5.i("FeedListComponent", "onDrag ACTION_DRAG_STARTED with wrong MimeType, ignore");
        return false;
    L52:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L25
        CharSequence r17 = r14.getClipDescription().getLabel();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L25
        List r18 = StringsKt.J(r17, new char[]{','}, 0, 6);     // Catch: Throwable -> L25
        if (r18.size() == 4) goto L28;
        r5.i("FeedListComponent", "onDrag ACTION_DRAG_STARTED with label size not 4, ignore");     // Catch: Throwable -> L25
        return false;
    L28:
        Object r11 = "-1";
        if (r18.size() <= 0) goto L31;
        Object r12 = r18.get(0);     // Catch: Throwable -> L25
    L32:
        this.f11596a = Integer.parseInt((String) r12);     // Catch: Throwable -> L25
        if (1 >= r18.size()) goto L35;
        Object r19 = r18.get(1);     // Catch: Throwable -> L25
    L36:
        this.f11597b = Integer.parseInt((String) r19);     // Catch: Throwable -> L25
        if (2 >= r18.size()) goto L39;
        Object r20 = r18.get(2);     // Catch: Throwable -> L25
    L40:
        this.f11598c = Integer.parseInt((String) r20);     // Catch: Throwable -> L25
        if (3 >= r18.size()) goto L43;
        r11 = r18.get(3);     // Catch: Throwable -> L25
    L43:
        this.d = Integer.parseInt((String) r11);     // Catch: Throwable -> L25
        Object r110 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L46:
        Throwable r111 = Result.m127exceptionOrNullimpl(r110);
        if (r111 != null) goto L50;
        this.f.t(r14.getX(), r14.getY(), this.f11596a, this.f11597b, this.f11598c, this.d);
        r5.i("FeedListComponent", "onDrag ACTION_DRAG_STARTED with correct MimeType");
        return true;
    L50:
        r5.e("FeedListComponent", "onDrag ACTION_DRAG_STARTED with correct MimeType, but parse label failed", r111);
        return false;
    L39:
        r20 = "-1";
        goto L40
    L35:
        r19 = "-1";
        goto L36
    L31:
        r12 = "-1";
    L25:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r110 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L46
    L53:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L10
        r10.r(r14.getX(), r14.getY(), r14.getClipData().getItemAt(0).getIntent());     // Catch: Throwable -> L10
        this.e = true;     // Catch: Throwable -> L10
        Object r113 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r114 = Result.m127exceptionOrNullimpl(r113);
        if (r114 == null) goto L60;
        r5.e("FeedListComponent", "onDrag ACTION_DROP error", r114);
        return true;
    L60:
        return true;
    L10:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    L6:
        if (this.e == true) goto L56;
        r10.u(r14.getX(), r14.getY());
        return true;
    L56:
        return true;
    }
}
