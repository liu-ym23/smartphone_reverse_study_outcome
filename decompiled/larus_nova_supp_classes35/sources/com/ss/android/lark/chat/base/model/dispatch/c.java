package com.ss.android.lark.chat.base.model.dispatch;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends PreprocessParams {
    public final String d;
    public final Uri e;

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final boolean a() {
        if (TextUtils.isEmpty(this.d) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.e != null) goto L8;
        return false;
    }

    public final int hashCode() {
        String r0 = this.d;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Uri r4 = this.e;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "{ fileType: " + getType() + ", hashedPath: " + ((String) this.c.getValue()) + ", " + this.b + " }";
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final String b() {
        return c();
    }

    public final String c() {
        if (a() == true) goto L6;
        return null;
    L6:
        Uri r0 = this.e;
        if (r0 == null) goto L11;
        String r1 = r0.getPath();
        if (r1 == null) goto L11;
        return r1;
    L11:
        return this.d;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof c) == false) goto L5;
        c r3 = (c) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(c(), r3.c());
    L5:
        r3 = null;
        goto L6
    }

    public c(ResourceType r2, String r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r4, "preUploadParams");
        super(r2, r4);
        this.d = r3;
        this.e = null;
    }
}
