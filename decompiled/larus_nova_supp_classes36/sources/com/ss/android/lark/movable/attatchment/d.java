package com.ss.android.lark.movable.attatchment;

import android.content.Context;
import android.graphics.Rect;
import android.widget.FrameLayout;
import com.ss.android.lark.movable.MovableView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends FrameLayout {
    public final MovableView a;
    public b b;

    public static final class a {
    }

    static {
    }

    public final com.ss.android.lark.movable.b getMovableEventClickListener() {
        return this.a.getRootMovableView().getEventClickListener$movable_release();
    }

    public Rect getRect() {
        b r0 = this.b;
        if (r0 != null) goto L6;
        return null;
    L6:
        float r2 = r0.c;
        float r4 = r0.d;
        return new Rect((int) r2, (int) r4, ((int) r2) + ((int) r0.e), ((int) r4) + ((int) r0.f));
    }

    public final b getAttachmentInfo$movable_release() {
        return this.b;
    }

    public final MovableView getMovableView() {
        return this.a;
    }

    public final void setAttachmentInfo$movable_release(b r1) {
        this.b = r1;
    }

    public d(Context r2, MovableView r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "movableView");
        super(r2);
        this.a = r3;
    }

    public final void a(b r4, List<? extends IAttachmentBinder> r5) {
        Intrinsics.checkNotNullParameter(r4, "attachmentInfo");
        this.b = r4;
        if (r5 == null) goto L17;
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L13;
        Object r0 = r6.next();
        if (((IAttachmentBinder) r0).getAttachmentTypeId() != r4.a) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L6;
    L14:
        IAttachmentBinder r2 = (IAttachmentBinder) r0;
        if (r2 == null) goto L17;
        r2.bind(this, r4);
        return;
    L10:
        r1 = false;
        goto L11
    L13:
        r0 = null;
    L17:
        IAttachmentBinder.Companion r7 = IAttachmentBinder.a;
        int r3 = r4.a;
        r7.getClass();
        IAttachmentBinder r8 = (IAttachmentBinder) ((Map) IAttachmentBinder.Companion.b.getValue()).get(Integer.valueOf(r3));
        if (r8 == null) goto L27;
        r8.bind(this, r4);
        return;
    }
}
