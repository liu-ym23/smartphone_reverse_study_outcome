package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/keyboard/event/IEventContext;", "from", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", "to", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImmersiveVoiceEntryView$initKeyboardEvent$2 extends Lambda implements Function3<com.ss.android.lark.keyboard.event.g, cya.h, cya.h, Unit> {
    final /* synthetic */ v this$0;

    public ImmersiveVoiceEntryView$initKeyboardEvent$2(v r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(com.ss.android.lark.keyboard.event.g r10, cya.h r11, cya.h r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$selectTransform");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "to");
        int r13 = r12.a();
        if (r13 != 4) goto L5;
    L38:
        this.this$0.getClass();
        throw null;
    L5:
        if (r13 != 2) goto L9;
        if (KeyboardVoiceFGUtils.c() == false) goto L38;
    L9:
        if (r13 == 8) goto L38;
        if (KeyboardVoiceFGUtils.c() == false) goto L44;
        if (r13 != 2) goto L34;
        cya.i r14 = (cya.i) r12.a.a(cya.i.h);
        if (r14 == null) goto L18;
        boolean r4 = true;
        if (r14.f != true) goto L18;
    L19:
        if (r4 == false) goto L34;
        v r3 = this.this$0;
        r3.getClass();
        CharSequence r15 = r14.c;
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        SpannableStringBuilder r5 = new SpannableStringBuilder(r15);
        Iterator r16 = ArrayIteratorKt.iterator((ncc.e[]) r5.getSpans(0, r5.length(), ncc.e.class));
    L25:
        if (r16.hasNext() == false) goto L34;
        ncc.e r2 = (ncc.e) r16.next();
        r2.a(new u(r3, null));
        Bitmap r6 = r2.b;
        if (r6 == null) goto L31;
        Paint r7 = new Paint();
        r7.setColorFilter(null);
        Bitmap r8 = Bitmap.createBitmap(r6.getWidth(), r6.getHeight(), Bitmap.Config.ARGB_8888);
        if (r8 == null) goto L32;
        new Canvas(r8).drawBitmap(r6, 0.0f, 0.0f, r7);
    L32:
        r2.b = r8;
        goto L25
    L31:
        r8 = null;
    L18:
        r4 = false;
    L34:
        if (r11.a() != 2) goto L45;
        if (r13 == 2) goto L46;
        this.this$0.getClass();
        return;
    L46:
        return;
    L45:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((com.ss.android.lark.keyboard.event.g) r1, (cya.h) r2, (cya.h) r3);
        return Unit.INSTANCE;
    }
}
