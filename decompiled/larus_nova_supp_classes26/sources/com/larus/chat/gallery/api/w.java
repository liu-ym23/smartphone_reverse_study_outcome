package com.larus.chat.gallery.api;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w {
    public final List<AttachmentSnapshot> a;
    public final String b;
    public final SuggestedAction c;
    public final String d;
    public final Map<String, String> e;
    public final Map<String, String> f;
    public final Map<String, String> g;
    public final long h;

    public w() {
        this(null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w) == true) goto L8;
        return false;
    L8:
        w r9 = (w) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        SuggestedAction r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Map<String, String> r14 = this.g;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        long r15 = this.h;
        return ((r13 + r2) * 31) + ((int) (r15 ^ (r15 >>> 32)));
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewSendSnapshot(attachments=" + this.a + ", text=" + this.b + ", suggestedAction=" + this.c + ", scene=" + this.d + ", messageExt=" + this.e + ", fileForceTraceMap=" + this.f + ", textForceTraceMap=" + this.g + ", createdAt=" + this.h + ')';
    }

    public /* synthetic */ w(List r13, String r14, SuggestedAction r15, String r16, Map r17, Map r18, Map r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        List r3 = CollectionsKt.emptyList();
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r20 & 4) == 0) goto L13;
        SuggestedAction r5 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Map r7 = null;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Map r8 = null;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Map r9 = null;
    L31:
        if ((r20 & 128) == 0) goto L33;
        long r0 = System.currentTimeMillis();
    L34:
        this(r3, r4, r5, r6, r7, r8, r9, r0);
        return;
    L33:
        r0 = 0;
        goto L34
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public static w a(w r13, String r14, SuggestedAction r15, String r16, Map r17, Map r18, Map r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        List<AttachmentSnapshot> r2 = r13.a;
    L6:
        List<AttachmentSnapshot> r4 = r2;
        if ((r20 & 2) == 0) goto L9;
        String r5 = r13.b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        SuggestedAction r6 = r13.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r7 = r13.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Map r8 = r13.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Map r9 = r13.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Map r10 = r13.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        long r1 = r13.h;
    L34:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r4, "attachments");
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        return new w(r4, r5, r6, r7, r8, r9, r10, r1);
    L33:
        r1 = 0;
        goto L34
    L29:
        r10 = r19;
        goto L31
    L25:
        r9 = r18;
        goto L27
    L21:
        r8 = r17;
        goto L23
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public w(List<AttachmentSnapshot> r2, String r3, SuggestedAction r4, String r5, Map<String, String> r6, Map<String, String> r7, Map<String, String> r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "attachments");
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
