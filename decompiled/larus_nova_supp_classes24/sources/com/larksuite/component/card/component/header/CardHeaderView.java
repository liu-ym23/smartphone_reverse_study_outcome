package com.larksuite.component.card.component.header;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.base.TraceEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/header/CardHeaderView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "Lcom/larksuite/component/card/component/header/CardHeaderView$HeaderConfig;", "getConfig", "()Lcom/larksuite/component/card/component/header/CardHeaderView$HeaderConfig;", "setConfig", "(Lcom/larksuite/component/card/component/header/CardHeaderView$HeaderConfig;)V", "updateConfig", "", "template", "", "startColor", "endColor", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "onDraw", "canvas", "Landroid/graphics/Canvas;", "HeaderConfig", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardHeaderView extends View {
    public a a;

    public static final class a {
        public final String a;
        public final Integer b;
        public final Integer c;

        public a(String r1, Integer r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final a getConfig() {
        return this.a;
    }

    public CardHeaderView(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        TraceEvent.beginSection("CardHeaderView.onDraw");
        super.onDraw(r2);
        TraceEvent.endSection("CardHeaderView.onDraw");
    }

    public final void setConfig(a r1) {
        this.a = r1;
    }

    public CardHeaderView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CardHeaderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
