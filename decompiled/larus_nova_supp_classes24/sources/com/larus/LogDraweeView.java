package com.larus;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/LogDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "context", "Landroid/content/Context;", "hierarchy", "Lcom/facebook/drawee/generic/GenericDraweeHierarchy;", "<init>", "(Landroid/content/Context;Lcom/facebook/drawee/generic/GenericDraweeHierarchy;)V", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LogDraweeView extends SimpleDraweeView {
    public LogDraweeView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super/*android.widget.ImageView*/.onDraw(r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        String r7 = getResources().getResourceEntryName(getId());     // Catch: Throwable -> L5
        FLogger.a.i("CreationHookTAG", "[onDraw] invoke draw imageView id = " + r7 + ", class name = " + LogDraweeView.class.getName() + ", context = " + getContext());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public LogDraweeView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    public LogDraweeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
    }
}
