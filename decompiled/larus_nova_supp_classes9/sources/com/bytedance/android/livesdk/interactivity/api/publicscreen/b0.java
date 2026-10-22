package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 extends z implements p0 {
    public Spannable b;
    public final k0 c;

    public final a5 getRichText() {
        return null;
    }

    public final String getDefaultContent() {
        String r0 = this.c.getChatContent();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public final a5 getRichTextContent() {
        return this.c.getRichDisplayText();
    }

    public final j4 getSelfFakeRichContent() {
        return this.c.getSelfFakeRichContent();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.z, com.bytedance.android.livesdk.interactivity.api.publicscreen.d
    public final boolean i() {
        return this.c.isHotChat();
    }

    public final Spannable getRenderSpan() {
        return this.b;
    }

    public b0(k0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
        this.c = r2;
    }

    public final void setRenderSpan(Spannable r1) {
        this.b = r1;
    }

    public final void setSelfFakeRichContent(j4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c.setSelfFakeRichContent(r2);
    }
}
