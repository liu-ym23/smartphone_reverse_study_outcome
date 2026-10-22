package com.bytedance.ai.file;

import android.net.Uri;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int b = 0;
    public final Uri a;

    /* JADX INFO: renamed from: com.bytedance.ai.file.a$a, reason: collision with other inner class name */
    public static final class C0040a {
        public static a a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "raw");
            if (r10.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L13;
            int r11 = e.a;     // Catch: Throwable -> L10
            Intrinsics.checkNotNullParameter(r10, "raw");     // Catch: Throwable -> L10
            return new a(UriProtector.parse(r10));
        L11:
            throw AppletFileError.InvalidUri.INSTANCE;
        L13:
            throw AppletFileError.InvalidUri.INSTANCE;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
    }

    public final String a() {
        return this.a.toString();
    }

    public final boolean b() {
        int r0 = e.a;
        Uri r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "uri");
        if (Intrinsics.areEqual("appletfile", r1.getScheme()) == false) goto L7;
        Uri r10 = this.a;
        Intrinsics.checkNotNullParameter(r10, "uri");
        if (Intrinsics.areEqual("temp", r10.getEncodedAuthority()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean c() {
        int r0 = e.a;
        Uri r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "uri");
        if (Intrinsics.areEqual("appletfile", r1.getScheme()) == false) goto L7;
        Uri r10 = this.a;
        Intrinsics.checkNotNullParameter(r10, "uri");
        if (Intrinsics.areEqual(AIStateLogRequest.SOURCE_USER, r10.getEncodedAuthority()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return a();
    }

    public a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        this.a = r10;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof a) == true) goto L6;
    L8:
        return false;
    L6:
        if (Intrinsics.areEqual(((a) r10).a, this.a) == false) goto L8;
        goto L8
    }
}
