package com.larus.camera.impl.utils.album;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class AlbumThumbListManager {
    public static final AlbumThumbListManager a = null;

    static {
        a = new AlbumThumbListManager();
    }

    public AlbumThumbListManager() {
    }

    public final Object b(Context r5, Continuation<? super Boolean> r6) {
        if ((r6 instanceof AlbumThumbListManager$hasAlbumImages$1) == false) goto L7;
        AlbumThumbListManager$hasAlbumImages$1 r0 = (AlbumThumbListManager$hasAlbumImages$1) r6;
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
    L18:
        return Boxing.boxBoolean(!((List) r7).isEmpty());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        r7 = a(r5, 1, null, null, r0);
        if (r7 != r2) goto L18;
        return r2;
    L7:
        r0 = new AlbumThumbListManager$hasAlbumImages$1(this, r6);
        goto L8
    }

    public static Object a(Context r13, int r14, Function2 r15, Function1 r16, Continuation r17) {
        ArrayList r6 = new ArrayList();
        Uri r1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Ref.IntRef r9 = new Ref.IntRef();
        return BuildersKt.withContext(Dispatchers.getIO(), new AlbumThumbListManager$getAlbumImages$2(r1, r14, r13, new String[]{"_id", "date_added"}, "date_added DESC", r6, r15, r16, r9, null), r17);
    }
}
