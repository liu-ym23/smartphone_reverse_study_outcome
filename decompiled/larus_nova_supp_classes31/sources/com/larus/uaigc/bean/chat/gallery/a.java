package com.larus.uaigc.bean.chat.gallery;

import android.app.Activity;
import android.os.Bundle;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.uaigc.service.ICreationDetailImageEditService;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.uaigc.bean.chat.gallery.a$a, reason: collision with other inner class name */
    public static final class C0037a {
        public final String a;
        public final String b;
        public final List<ResourceExt> c;
        public final Bundle d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0037a) == true) goto L8;
            return false;
        L8:
            C0037a r6 = (C0037a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "DetailImagePayload(previewUrl=" + this.a + ", rawUrl=" + this.b + ", refCreateRefInfoList=" + this.c + ", extraBundle=" + this.d + ')';
        }

        public C0037a(String r2, String r3, List<ResourceExt> r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r2, "previewUrl");
            Intrinsics.checkNotNullParameter(r4, "refCreateRefInfoList");
            Intrinsics.checkNotNullParameter(r5, "extraBundle");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public a() {
    }

    public static boolean a(Activity r13, C0037a r14, zs8.a r15, z0 r16, ChatParam r17, boolean r18, com.larus.trace.tracknode.a r19, int r20) {
        if ((r20 & 8) == 0) goto L5;
        z0 r7 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        ChatParam r8 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        int r9 = 4;
    L15:
        if ((r20 & 64) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r20 & 128) == 0) goto L21;
        com.larus.trace.tracknode.a r11 = null;
    L23:
        if ((r20 & 256) == 0) goto L25;
        boolean r12 = true;
    L26:
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "payload");
        Intrinsics.checkNotNullParameter(r15, "hitPointData");
        return ICreationDetailImageEditService.a.b(r13, r14, r15, r7, r8, r9, r10, r11, r12);
    L25:
        r12 = false;
        goto L26
    L21:
        r11 = r19;
        goto L23
    L17:
        r10 = r18;
        goto L19
    L13:
        r9 = 0;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }
}
