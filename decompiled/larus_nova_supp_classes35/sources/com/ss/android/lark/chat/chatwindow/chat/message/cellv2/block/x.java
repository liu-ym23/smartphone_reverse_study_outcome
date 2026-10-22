package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x implements View.OnClickListener {
    public final /* synthetic */ MediaContentBlock a;
    public final /* synthetic */ MediaContentBlock.b b;
    public final /* synthetic */ y6b.a<MediaContentVO> c;

    public x(MediaContentBlock r1, MediaContentBlock.b r2, y6b.a<MediaContentVO> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        boolean r0 = true;
        if (NetworkUtils.d(this.a.getContext()) == true) goto L5;
    L11:
        boolean r6 = true;
    L12:
        StringBuilder r2 = new StringBuilder("click ProgressBar, mClickListener != null: ");
        if (((b3b.j) this.a.j.getValue()) != null) goto L16;
        r0 = false;
    L16:
        r2.append(r0);
        r2.append(", cancelEnable: ");
        r2.append(r6);
        Log.i("MediaContentBlock", r2.toString());
        if (r6 == false) goto L22;
        b3b.j r7 = (b3b.j) this.a.j.getValue();
        if (r7 == null) goto L23;
        r7.r(this.c.getcId(), (String) this.c.b().k.getValue());
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (this.b.c.getProgress() != 60.0f) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L11;
        r6 = false;
        goto L12
    L7:
        r8 = false;
        goto L8
    }
}
