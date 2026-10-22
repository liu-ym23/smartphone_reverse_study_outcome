package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import android.net.Uri;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import ic8.m0;
import ic8.n0;
import kotlin.jvm.internal.Intrinsics;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class b extends com.larus.bmhome.chat.component.bottom.multimodal.upload.a {
    public final String A;
    public final boolean B;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final Boolean G;
    public final Boolean H;
    public final String I;
    public final ReferenceInfo J;
    public final String y;
    public final UplinkFileEntity z;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.upload.a, com.larus.bmhome.chat.component.bottom.multimodal.upload.m
    public void d(n0 r37) {
        Intrinsics.checkNotNullParameter(r37, "processResult");
        this.w = r37;
        ProcessFileResultCode r2 = r37.b;
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.isSuccess() != true) goto L7;
    L8:
        String r4 = null;
        if (r3 == true) goto L42;
        LruCache r5 = ko8.a.a;
        String r6 = this.A;
        boolean r7 = this.B;
        boolean r8 = n1.d(this.z);
        boolean r9 = n1.a(this.z);
        boolean r10 = n1.e(this.z);
        String r14 = this.D;
        String r15 = this.E;
        String r11 = this.F;
        if (r37.b != ProcessFileResultCode.PREPARE_OVER_SIZE) goto L13;
        String r12 = "file over size";
    L14:
        String r13 = r12;
        m0 r1 = r37.a;
        if (r1 == null) goto L17;
        String r16 = r1.b;
    L18:
        sr9.b r17 = sr9.b.b;
        Uri r18 = this.z.getUri();
        if (r18 == null) goto L21;
        String r19 = r18.toString();
    L22:
        String r110 = "";
        if (r19 != null) goto L25;
        r19 = "";
    L25:
        String r111 = r17.c(r19);
        Uri r20 = this.z.getUri();
        if (r20 == null) goto L28;
        String r21 = r20.toString();
    L29:
        if (r21 != null) goto L31;
        r21 = "";
    L31:
        String r112 = r17.f(r21);
        Uri r22 = this.z.getUri();
        if (r22 == null) goto L34;
        String r23 = r22.toString();
    L35:
        if (r23 == null) goto L38;
        r110 = r23;
    L38:
        String r24 = r17.h(r110);
        Boolean r25 = this.G;
        Boolean r113 = this.H;
        String r114 = this.I;
        ReferenceInfo r26 = this.J;
        if (r26 == null) goto L41;
        r4 = r26.referencedMessageId;
    L41:
        ko8.a.m(r6, null, r7, r13, r8, r9, r10, false, null, r16, r14, r15, r11, null, r111, r112, r24, r25, r113, r114, r4, null, null, null, null, null, null, null, null, null, null, 2145394946);
        return;
    L34:
        r23 = null;
        goto L35
    L28:
        r21 = null;
        goto L29
    L21:
        r19 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L13:
        r12 = "copy error";
        goto L14
    L42:
        UplinkEntityContent r27 = this.z.getUplinkEntityContent();
        if (r27 == null) goto L54;
        Image r28 = r27.getUplinkImageInfo();
        if (r28 == null) goto L54;
        m0 r29 = r37.a;
        if (r29 == null) goto L49;
        String r30 = r29.f;
    L50:
        r28.md5 = r30;
        if (r29 == null) goto L53;
        r4 = r29.e;
    L53:
        r28.localResPath = r4;
        goto L54
    L49:
        r30 = null;
    L54:
        Uri r31 = this.z.getUri();
        if (r31 == null) goto L59;
        String r32 = r31.toString();
        if (r32 == null) goto L59;
        com.larus.utils.l.c(r32, "image_from_scene", this.C);
    L59:
        NestedFileCacheManagerService.b.k(this.y, this.z);
        return;
    L7:
        r3 = false;
        goto L8
    }

    public b(String r27, UplinkFileEntity r28, String r29, String r30, boolean r31, String r32, String r33, String r34, String r35, Boolean r36, Boolean r37, String r38, ReferenceInfo r39) {
        Intrinsics.checkNotNullParameter(r27, "localMsgId");
        Intrinsics.checkNotNullParameter(r28, "entity");
        super(r27, r28, r29, r30, r31, "fromScene", r32, r33, r34, r35, r36, r37, r38, r39, null, null, null, null, null, null, null, 2080768);
        this.y = r27;
        this.z = r28;
        this.A = r30;
        this.B = r31;
        this.C = "fromScene";
        this.D = r32;
        this.E = r33;
        this.F = r34;
        this.G = r36;
        this.H = r37;
        this.I = r38;
        this.J = r39;
    }
}
