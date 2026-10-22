package com.larus.drive.sdk.impl.gallery.datasource;

import com.larus.bmhome.bigimg.m1;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.service.t;
import com.larus.gallery.api.GalleryType;
import e89.d;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import nr9.f;
import nr9.g;
import z79.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveDataSourceHelper {
    public static final DriveDataSourceHelper a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new DriveDataSourceHelper();
    }

    public DriveDataSourceHelper() {
    }

    public final Object a(DriveFileItem r25, Continuation<? super c> r26) {
        DriveFileItem r0 = r25;
        if ((r26 instanceof DriveDataSourceHelper$convertToGalleryData$1) == false) goto L7;
        DriveDataSourceHelper$convertToGalleryData$1 r2 = (DriveDataSourceHelper$convertToGalleryData$1) r26;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r7 = true;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        d r6 = (d) r2.L$1;
        DriveFileItem r8 = (DriveFileItem) r2.L$0;
        ResultKt.throwOnFailure(r1);
        d r9 = r6;
        r0 = r8;
        Object r10 = r1;
    L23:
        String r13 = (String) r10;
        String r16 = r9.f(r0.b, 360, 360);
        if (r13 != null) goto L26;
    L29:
        if (r7 == false) goto L31;
        DriveFileItem r11 = r0;
    L51:
        return new c(r11, null, new g(null, null, r13, null, null, null, new f(r16, r16, null, null, null, null, 60), null, null, null, 955), GalleryType.Video, r0.b, 2);
    L31:
        r11 = DriveFileItem.a(r0, null, r13, null, 4079);
        goto L51
    L26:
        if (StringsKt.isBlank(r13) == true) goto L29;
        r7 = false;
        goto L29
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d r12 = (d) r2.L$1;
        DriveFileItem r14 = (DriveFileItem) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r9 = r12;
        r0 = r14;
        Object r15 = r1;
    L36:
        String r17 = (String) r15;
        String r18 = r9.f(r0.b, 120, 120);
        if (r17 != null) goto L39;
    L42:
        if (r7 == false) goto L44;
        DriveFileItem r20 = r0;
    L45:
        String r21 = r20.e;
        if (r18 != null) goto L48;
        String r22 = r21;
    L50:
        return new c(r20, new m1(r21, r22, r21, null, null, null, 56), null, GalleryType.Image, r0.b, 4);
    L48:
        r22 = r18;
        goto L50
    L44:
        r20 = DriveFileItem.a(r0, null, r17, null, 4079);
        goto L45
    L39:
        if (StringsKt.isBlank(r17) == true) goto L42;
        r7 = false;
        goto L42
    L16:
        ResultKt.throwOnFailure(r1);
        r9 = t.b();
        DriveFileType r23 = r0.j;
        int r24 = a.a[r23.ordinal()];
        if (r24 == 1) goto L33;
        if (r24 != 2) goto L52;
        String r27 = r0.b;
        r2.L$0 = r0;
        r2.L$1 = r9;
        r2.label = 2;
        r10 = r9.b(r27, r2);
        if (r10 != r4) goto L23;
        return r4;
    L52:
        return null;
    L33:
        String r28 = r0.b;
        r2.L$0 = r0;
        r2.L$1 = r9;
        r2.label = 1;
        r15 = r9.e(r28, r2);
        if (r15 != r4) goto L36;
        return r4;
    L7:
        r2 = new DriveDataSourceHelper$convertToGalleryData$1(this, r26);
        goto L8
    }

    public final Object b(DriveFileItem r5, Continuation<? super List<c>> r6) {
        if ((r6 instanceof DriveDataSourceHelper$transformDriveFileToGalleryData$1) == false) goto L7;
        DriveDataSourceHelper$transformDriveFileToGalleryData$1 r0 = (DriveDataSourceHelper$transformDriveFileToGalleryData$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L22:
        return CollectionsKt.listOfNotNull(r7);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (r5 == null) goto L17;
        r0.label = 1;
        r7 = a(r5, r0);
        if (r7 != r2) goto L22;
        return r2;
    L17:
        return CollectionsKt.emptyList();
    L7:
        r0 = new DriveDataSourceHelper$transformDriveFileToGalleryData$1(this, r6);
        goto L8
    }
}
