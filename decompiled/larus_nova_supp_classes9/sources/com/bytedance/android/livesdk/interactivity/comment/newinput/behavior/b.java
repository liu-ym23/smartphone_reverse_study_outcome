package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.r3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return 2131567039;
    }

    public final void e() {
        r3.a(getView(), s1.B(2131914436));
        View r0 = getView();
        if (r0 == null) goto L8;
        TextView r1 = (TextView) r0.findViewById(2131367920);
        if (r1 == null) goto L9;
        r1.setBackgroundResource(2131250265);
        return;
    L9:
        return;
    }

    public final void f() {
        r3.a(getView(), s1.B(2131914435));
        View r0 = getView();
        if (r0 == null) goto L8;
        TextView r1 = (TextView) r0.findViewById(2131367920);
        if (r1 == null) goto L9;
        r1.setBackgroundResource(2131250266);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void k(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3) {
        Intrinsics.checkNotNullParameter(r3, "bridges");
        super.k(r3);
        if (r3.f() != 0) goto L8;
        if (r3.e0() == false) goto L8;
        f();
        return;
    L8:
        if (r3.f() != 1) goto L13;
        if (r3.c0() == false) goto L13;
        e();
        return;
    L13:
        if (r3.e0() == false) goto L16;
        f();
        return;
    L16:
        if (r3.c0() == false) goto L22;
        e();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void p(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
        if (r2.f() != 0) goto L5;
        r3.a(getView(), s1.B(2131914435));
        return;
    L5:
        r3.a(getView(), s1.B(2131914436));
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r2, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        r3.getClass();
        IMiddlewareRoomService r4 = jc1.k.f(IMiddlewareRoomService.class);
        if (r4 == null) goto L7;
        boolean r0 = true;
        if (r4.checkOrLoadAudioResource() != true) goto L7;
    L8:
        if (r0 == true) goto L11;
        return;
    L11:
        if (r3.f() != 0) goto L13;
        c.d("voice", r3.i());
    L15:
        if (r3.Q() != InputSectionType.AUDIO_COMPOSE) goto L17;
        r3.D0();
        return;
    L17:
        r3.w0();
        return;
    L13:
        c.d("voice_to_text", r3.i());
    L7:
        r0 = false;
        goto L8
    }

    public b(InputFunctionEnum r2, Context r3, InputSectionType r4) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "sectionType");
        super(r2, r3, r4);
    }
}
