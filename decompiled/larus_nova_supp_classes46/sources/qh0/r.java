package qh0;

import android.app.Activity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.config.eb0;
import com.bytedance.android.livesdk.config.mb1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r extends ClickableSpan {
    public final /* synthetic */ Activity a;

    public r(Activity r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        eb0 r5 = eb0.a;
        mb1 r0 = (mb1) r5.getValue();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.b();
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        IBaseLiveActionHandler r3 = jc1.k.n(IBaseLiveActionHandler.class);
        Activity r6 = this.a;
        mb1 r7 = (mb1) r5.getValue();
        if (r7 == null) goto L11;
        r1 = r7.b();
    L11:
        r3.handle(r6, r1);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        super.updateDrawState(r2);
        r2.setColor(-16776961);
        r2.setUnderlineText(true);
    }
}
