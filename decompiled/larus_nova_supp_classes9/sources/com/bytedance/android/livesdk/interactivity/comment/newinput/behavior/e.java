package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.model.data.activityemoji.ActivityEmojiGroup;
import com.bytedance.android.live.base.model.data.activityemoji.EffectiveActivityEmojiGroup;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends c {
    public String i;

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return 2131567041;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final boolean canShowRedDot() {
        if (this.i != null) goto L7;
        return false;
    L7:
        return super.canShowRedDot();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void r(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        Intrinsics.checkNotNullParameter(r2, "bridge");
        String r0 = null;
        if (r2.d0() == false) goto L9;
        EffectiveActivityEmojiGroup r3 = q.c();
        if (r3 == null) goto L9;
        ActivityEmojiGroup r4 = r3.getEmojiGroup();
        if (r4 == null) goto L9;
        r0 = r4.getIdStr();
    L9:
        this.i = r0;
        if (r0 == null) goto L13;
        String r5 = this.e + this.i;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.e = r5;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r2, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        super.t(r2, r3);
        if (r3.Q() != InputSectionType.EMOJI) goto L5;
        r3.D0();
        return;
    L5:
        r3.y0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void u(boolean r1, boolean r2) {
        super.u(r1, r2);
    }

    public e(InputFunctionEnum r2, Context r3, InputSectionType r4) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "sectionType");
        super(r2, r3, r4);
    }
}
