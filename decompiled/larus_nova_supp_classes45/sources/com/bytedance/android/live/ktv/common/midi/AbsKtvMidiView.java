package com.bytedance.android.live.ktv.common.midi;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&R\"\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRT\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/AbsKtvMidiView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/bytedance/android/live/ktv/common/util/c;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "", "setConfig", "", "a", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "typeName", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isTimeOut", "", "timeStamp", "b", "Lkotlin/jvm/functions/Function2;", "getOneDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setOneDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "oneDrawCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsKtvMidiView extends ConstraintLayout implements com.bytedance.android.live.ktv.common.util.c {
    public String a;
    public Function2<? super Boolean, ? super Long, Unit> b;

    public AbsKtvMidiView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AbsKtvMidiView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void A1();

    public abstract void R2(long r1);

    public abstract void R5();

    public abstract void S5(k r1, Long r2);

    public abstract void T5(db0.a r1);

    public abstract void U5(long r1, long r3);

    public abstract void onDetach();

    public abstract void onResume();

    public abstract void reset();

    public abstract void setConfig(g0 r1);

    public abstract void xc(Pair<Integer, Integer> r1);

    public void y(MidiSkinDressInfo r1) {
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public Function2<Boolean, Long, Unit> getOneDrawCallback() {
        return this.b;
    }

    @Override // com.bytedance.android.live.ktv.common.util.b
    public String getTypeName() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
    }

    public final void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        Function2<Boolean, Long, Unit> r5 = getOneDrawCallback();
        if (r5 == null) goto L6;
        Unit r6 = (Unit) r5.invoke(Boolean.FALSE, Long.valueOf(System.currentTimeMillis()));
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.util.c
    public void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.b = r1;
    }

    public void setTypeName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public AbsKtvMidiView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = KtvSubElement.MIDI;
    }

    public /* synthetic */ AbsKtvMidiView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
