package com.ss.android.lark.chat.base.model.dispatch;

import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.videosend.tools.CompressPathManager;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends PreprocessParams {
    public final String d;
    public final boolean e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResourceType.values().length];
            r0[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ResourceType.MEDIA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final boolean a() {
        return !TextUtils.isEmpty(this.d);
    }

    public final int hashCode() {
        int r0 = this.d.hashCode() * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "{ fileType: " + getType() + ", hashedPath: " + ((String) this.c.getValue()) + ", isOrigin: " + this.e + ", " + this.b + " }";
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final String b() {
        int r0 = a.a[getType().ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        Log.e("PreprocessParams", "toUniqueKey / Invalid fileType, params: " + this);
        return null;
    L11:
        return CompressPathManager.generateCompressFilePath(this.d, Boolean.valueOf(this.e));
    L9:
        return this.d + '_' + this.e;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof d) == false) goto L5;
        d r5 = (d) r4;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (getType() == r5.getType()) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r5.d) == true) goto L14;
        return false;
    L14:
        if (this.e != r5.e) goto L19;
        return true;
    L19:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    public d(ResourceType r2, String r3, boolean r4, f r5) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r5, "preUploadParams");
        super(r2, r5);
        this.d = r3;
        this.e = r4;
    }
}
