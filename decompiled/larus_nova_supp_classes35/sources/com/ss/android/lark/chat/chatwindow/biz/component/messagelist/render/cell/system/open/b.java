package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.system.open;

import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.log.Log;
import h7b.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends n {
    public long c;
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.message.system.c d;
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.message.system.a e;
    public final /* synthetic */ ContentValue f;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        long r0 = SystemClock.uptimeMillis();
        long r2 = r0 - this.c;
        this.c = r0;
        if (r2 >= 500) goto L6;
        Log.i("SystemContentUtilV2", "elapsedTime is short than LENGTH_SHORT");
        return;
    L6:
        com.ss.android.lark.biz.im.api.extension.message.system.b r6 = this.d.d(this.e);
        if (r6 == null) goto L10;
        r6.x(this.f, this.e);
        return;
    }

    public b(com.ss.android.lark.biz.im.api.extension.message.system.c r1, c r2, ContentValue r3, FragmentActivity r4) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        super(r4);
    }
}
