package com.larus.avlink.record.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import ba8.b;
import com.larus.avlink.impl.databinding.LayoutRecordMinutesBottomBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesBottomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordMinutesBottomBinding;", "onStartButtonClick", "Lkotlin/Function0;", "", "getOnStartButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnStartButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "onEndButtonClick", "getOnEndButtonClick", "setOnEndButtonClick", "mEntryDoraDeviceMac", "", "getMEntryDoraDeviceMac", "()Ljava/lang/String;", "setMEntryDoraDeviceMac", "(Ljava/lang/String;)V", "setRecordingView", "setOfflineRecordingView", "setEndRecordView", "refreshStartButtonEnableState", "setDuration", "duration", "setEntryDoraDeviceMac", "mac", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesBottomView extends ConstraintLayout {
    public final LayoutRecordMinutesBottomBinding a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public String d;

    public static final class a {
    }

    static {
    }

    public RecordMinutesBottomView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RecordMinutesBottomView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void R5() {
        if (this.a.c.getBackground() != null) goto L5;
        this.a.c.setBackgroundResource(2131232161);
    L5:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L12;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L12;
        boolean r2 = true;
        if (r1.K(this.d) != true) goto L12;
    L13:
        Drawable r3 = this.a.c.getBackground();
        if (r3 == null) goto L22;
        Drawable r4 = r3.mutate();
        if (r4 == null) goto L23;
        if (r2 == false) goto L19;
        int r5 = 255;
    L20:
        r4.setAlpha(r5);
        return;
    L19:
        r5 = 77;
        goto L20
    L23:
        return;
    L22:
        return;
    L12:
        r2 = false;
        goto L13
    }

    public final String getMEntryDoraDeviceMac() {
        return this.d;
    }

    public final Function0<Unit> getOnEndButtonClick() {
        return this.c;
    }

    public final Function0<Unit> getOnStartButtonClick() {
        return this.b;
    }

    public final void setDuration(int r10) {
        LinearLayout r0 = this.a.d;
        int r1 = r0.getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L27;
        View r4 = r0.getChildAt(r3);
        TextView r6 = null;
        if (r3 == 0) goto L22;
        if (r3 == 2) goto L17;
        if (r3 != 4) goto L26;
        if ((r4 instanceof TextView) == false) goto L14;
        r6 = (TextView) r4;
    L14:
        if (r6 == null) goto L26;
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r6.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r10 % 60)}, 1)));
    L26:
        r3 = r3 + 1;
        goto L3
    L17:
        if ((r4 instanceof TextView) == false) goto L19;
        r6 = (TextView) r4;
    L19:
        if (r6 == null) goto L26;
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        r6.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf((r10 % 3600) / 60)}, 1)));
        goto L26
    L22:
        if ((r4 instanceof TextView) == false) goto L24;
        r6 = (TextView) r4;
    L24:
        if (r6 == null) goto L26;
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;
        r6.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r10 / 3600)}, 1)));
        goto L26
    }

    public final void setEntryDoraDeviceMac(String r1) {
        this.d = r1;
    }

    public final void setMEntryDoraDeviceMac(String r1) {
        this.d = r1;
    }

    public final void setOnEndButtonClick(Function0<Unit> r1) {
        this.c = r1;
    }

    public final void setOnStartButtonClick(Function0<Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecordMinutesBottomView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ConstraintLayout r6 = LayoutInflater.from(r3).inflate(2131563399, this, false);
        addView(r6);
        int r7 = 2131364452;
        ConstraintLayout r8 = ViewBindings.findChildViewById(r6, 2131364452);
        if (r8 == null) goto L13;
        r7 = 2131364453;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131364453)) == null) goto L13;
        r7 = 2131364529;
        TextView r0 = (TextView) ViewBindings.findChildViewById(r6, 2131364529);
        if (r0 == null) goto L13;
        r7 = 2131383979;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r6, 2131383979);
        if (r1 == null) goto L13;
        this.a = new LayoutRecordMinutesBottomBinding(r6, r8, r0, r1);
        r0.setOnClickListener(new ba8.a(this));
        r8.setOnClickListener(new b(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }

    public /* synthetic */ RecordMinutesBottomView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
