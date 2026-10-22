package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AsrInputVoiceViewV2$mTouchThroughView$2 extends Lambda implements Function0<FrameLayout> {
    final /* synthetic */ AsrInputVoiceViewV2 this$0;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ AsrInputVoiceViewV2 a;
        public final /* synthetic */ FrameLayout b;

        public a(AsrInputVoiceViewV2 r1, FrameLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            Log.i("AsrInputVoiceViewV2", "On touch touch thorough view, event.action: " + r4.getAction());
            if (this.a.b == false) goto L5;
            return true;
        L5:
            Intrinsics.checkNotNull(r4);
            if (r3 != null) goto L10;
            AsrInputVoiceViewV2.R5(this.a).a();
            Log.i("AsrInputVoiceViewV2", "cancel asr after record by click ");
            Log.i("AsrInputVoiceViewV2", "set touch through view gone");
            this.b.setVisibility(8);
            return false;
        L10:
            throw null;
        }
    }

    public AsrInputVoiceViewV2$mTouchThroughView$2(AsrInputVoiceViewV2 r1) {
        this.this$0 = r1;
        super(0);
    }

    public final FrameLayout invoke() {
        this.this$0.getClass();
        FrameLayout r0 = new FrameLayout(null);
        AsrInputVoiceViewV2 r1 = this.this$0;
        r0.setVisibility(8);
        r0.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        r0.setAlpha(0.0f);
        r0.setOnTouchListener(new a(r1, r0));
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1158invoke() {
        return invoke();
    }
}
