package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\u00020\u0007*\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "modeDot", "Landroid/view/View;", "modeText", "Landroid/widget/TextView;", "modeChevron", "onModeClick", "Lkotlin/Function0;", "", "isModeClickEnabled", "", "setOnModeClickListener", "listener", "render", "product", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryProduct;", "state", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeUiState;", "drawableRes", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeIndicator;", "getDrawableRes", "(Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeIndicator;)I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceModeEntryView extends FrameLayout {
    public final View a;
    public final TextView b;
    public final View c;
    public Function0<Unit> d;
    public boolean e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DoraObricDeviceModeEntryLabel.values().length];
            r0[DoraObricDeviceModeEntryLabel.ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DoraObricDeviceModeEntryLabel.HEADPHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[DoraObricDeviceModeIndicator.values().length];
            r1[DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_ON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[DoraObricDeviceModeIndicator.HEADPHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public DoraObricDeviceModeEntryView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DoraObricDeviceModeEntryView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setOnModeClickListener(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void a(DoraObricDeviceModeEntryProduct r4, h3 r5) {
        Intrinsics.checkNotNullParameter(r4, "product");
        Intrinsics.checkNotNullParameter(r5, "state");
        z1 r6 = b2.a(r4, r5);
        int r7 = 8;
        if (r6 != null) goto L6;
        setVisibility(8);
        setEnabled(false);
        this.e = false;
        return;
    L6:
        setVisibility(0);
        setEnabled(r6.b);
        this.e = r6.c;
        setAlpha(1.0f);
        this.a.setEnabled(r6.b);
        this.b.setEnabled(r6.b);
        this.c.setEnabled(r6.b);
        this.a.setAlpha(r6.e);
        this.b.setAlpha(r6.e);
        this.c.setAlpha(r6.e);
        View r1 = this.c;
        if (r6.d == false) goto L9;
        r7 = 0;
    L9:
        r1.setVisibility(r7);
        setClickable(true);
        TextView r0 = this.b;
        DoraObricDeviceModeEntryLabel r2 = r6.a;
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r8 = 2131903612;
    L16:
        r0.setText(r8);
        setContentDescription(this.b.getText());
        View r9 = this.a;
        DoraObricDeviceModeIndicator r10 = r6.f;
        int r11 = a.b[r10.ordinal()];
        if (r11 == 1) goto L25;
        if (r11 != 2) goto L20;
        int r12 = 2131240592;
    L26:
        r9.setBackgroundResource(r12);
        return;
    L20:
        if (r11 != 3) goto L23;
        r12 = 2131240591;
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        r12 = 2131240590;
        goto L26
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r8 = 2131903610;
        goto L16
    }

    public DoraObricDeviceModeEntryView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562309, this, true);
        this.a = findViewById(2131369827);
        this.b = (TextView) findViewById(2131369828);
        this.c = findViewById(2131369826);
        setVisibility(8);
        setOnClickListener(new e2(this));
    }

    public /* synthetic */ DoraObricDeviceModeEntryView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
