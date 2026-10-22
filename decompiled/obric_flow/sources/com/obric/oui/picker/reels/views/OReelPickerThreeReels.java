package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$layout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lyr/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/picker/reels/views/WheelView;", "g", "Lkotlin/Lazy;", "getWv1", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv1", "h", "getWv2", "wv2", "i", "getWv3", "wv3", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OReelPickerThreeReels extends ConstraintLayout implements yr.b {
    public final Lazy g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f14040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f14041i;

    @JvmOverloads
    public OReelPickerThreeReels(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final WheelView getWv1() {
        return (WheelView) this.g.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.f14040h.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.f14041i.getValue();
    }

    @Override // yr.b
    public final WheelView a(int r5) {
        if (r5 == 0) goto L11;
        if (r5 == 1) goto L14;
        if (r5 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    @JvmOverloads
    public OReelPickerThreeReels(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OReelPickerThreeReels(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.g = LazyKt.lazy(new OReelPickerThreeReels$wv1$2(this));
        this.f14040h = LazyKt.lazy(new OReelPickerThreeReels$wv2$2(this));
        this.f14041i = LazyKt.lazy(new OReelPickerThreeReels$wv3$2(this));
        LayoutInflater.from(r5).inflate(R$layout.o_reel_picker_3_reels, this);
    }
}
