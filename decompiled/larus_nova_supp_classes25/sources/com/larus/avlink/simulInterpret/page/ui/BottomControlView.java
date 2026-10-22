package com.larus.avlink.simulInterpret.page.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.LayoutBottomControlViewBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\rJ\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\rJ\u000e\u0010.\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/ui/BottomControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutBottomControlViewBinding;", "isRotated", "", "onStartTranslationClick", "Lkotlin/Function0;", "", "getOnStartTranslationClick", "()Lkotlin/jvm/functions/Function0;", "setOnStartTranslationClick", "(Lkotlin/jvm/functions/Function0;)V", "onEndTranslationClick", "getOnEndTranslationClick", "setOnEndTranslationClick", "onMuteClick", "getOnMuteClick", "setOnMuteClick", "onFlipScreenClick", "Lkotlin/Function1;", "getOnFlipScreenClick", "()Lkotlin/jvm/functions/Function1;", "setOnFlipScreenClick", "(Lkotlin/jvm/functions/Function1;)V", "setMuteState", "isMuted", "updateForOnBoarding", "updateForListening", "updateForTranslating", "initView", "deviceType", "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "setStartSubTextStart", ChatDraftItem.TYPE_TEXT, "", "setSubTextEndVisible", "isVisible", "setSubTextEnd", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BottomControlView extends ConstraintLayout {
    public final LayoutBottomControlViewBinding a;
    public boolean b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public Function0<Unit> e;
    public Function1<? super Boolean, Unit> f;

    public BottomControlView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BottomControlView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final Function0<Unit> getOnEndTranslationClick() {
        return this.d;
    }

    public final Function1<Boolean, Unit> getOnFlipScreenClick() {
        return this.f;
    }

    public final Function0<Unit> getOnMuteClick() {
        return this.e;
    }

    public final Function0<Unit> getOnStartTranslationClick() {
        return this.c;
    }

    public final void setMuteState(boolean r2) {
        ImageView r0 = this.a.c;
        if (r2 == false) goto L5;
        int r3 = 2131238069;
    L6:
        r0.setImageResource(r3);
        return;
    L5:
        r3 = 2131238070;
        goto L6
    }

    public final void setOnEndTranslationClick(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setOnFlipScreenClick(Function1<? super Boolean, Unit> r1) {
        this.f = r1;
    }

    public final void setOnMuteClick(Function0<Unit> r1) {
        this.e = r1;
    }

    public final void setOnStartTranslationClick(Function0<Unit> r1) {
        this.c = r1;
    }

    public final void setStartSubTextStart(String r3) {
        Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.a.f.setVisibility(8);
        return;
    L8:
        this.a.f.setVisibility(0);
        this.a.f.setText(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setSubTextEnd(String r3) {
        Intrinsics.checkNotNullParameter(r3, ChatDraftItem.TYPE_TEXT);
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.a.e.setVisibility(8);
        return;
    L8:
        this.a.e.setVisibility(0);
        this.a.e.setText(r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setSubTextEndVisible(boolean r2) {
        TextView r0 = this.a.e;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomControlView(Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        ConstraintLayout r1 = LayoutInflater.from(r17).inflate(2131563288, this, false);
        addView(r1);
        int r2 = 2131374017;
        Group r6 = ViewBindings.findChildViewById(r1, 2131374017);
        if (r6 == null) goto L25;
        r2 = 2131374682;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r1, 2131374682);
        if (r3 == null) goto L25;
        r2 = 2131374702;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r1, 2131374702);
        if (r14 == null) goto L25;
        r2 = 2131377488;
        ConstraintLayout r15 = ViewBindings.findChildViewById(r1, 2131377488);
        if (r15 == null) goto L25;
        r2 = 2131377633;
        ConstraintLayout r13 = ViewBindings.findChildViewById(r1, 2131377633);
        if (r13 == null) goto L25;
        r2 = 2131379476;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131379476)) == null) goto L25;
        r2 = 2131379477;
        if (((TextView) ViewBindings.findChildViewById(r1, 2131379477)) == null) goto L25;
        r2 = 2131387548;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r1, 2131387548);
        if (r11 == null) goto L25;
        r2 = 2131387549;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r1, 2131387549);
        if (r12 == null) goto L25;
        r2 = 2131388448;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r1, 2131388448);
        if (r10 == null) goto L25;
        this.a = new LayoutBottomControlViewBinding(r1, r6, r3, r14, r15, r13, r11, r12, r10);
        r13.setOnClickListener(new a(this));
        r15.setOnClickListener(new b(this));
        r10.setOnClickListener(new c(this));
        r3.setOnClickListener(new d(this));
        r14.setOnClickListener(new e(this));
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public /* synthetic */ BottomControlView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
