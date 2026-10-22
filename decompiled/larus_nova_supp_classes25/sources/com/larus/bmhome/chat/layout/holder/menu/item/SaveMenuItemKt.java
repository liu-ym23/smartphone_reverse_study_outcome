package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.api.ChatApi;
import com.larus.bmhome.chat.resp.FileUrlData;
import com.larus.bmhome.chat.resp.FileUrlRespData;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceSignUrlData;
import com.larus.bmhome.rc.SignUrlMode;
import com.larus.im.bean.message.SendFile;
import com.larus.platform.model.upload.UploadDataType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SaveMenuItemKt {
    public static final Object a(SendFile r6, Continuation r7) {
        if ((r7 instanceof SaveMenuItemKt$requireDownloadFileUrl$1) == false) goto L7;
        SaveMenuItemKt$requireDownloadFileUrl$1 r0 = (SaveMenuItemKt$requireDownloadFileUrl$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
    L32:
        return r8;
    L17:
        r6 = (SendFile) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        r8 = (String) r8;
        if (r8 != null) goto L32;
        r0.L$0 = null;
        r0.label = 2;
        r8 = c(r6, r0);
        if (r8 != r2) goto L32;
        return r2;
    L18:
        ResultKt.throwOnFailure(r8);
        ResourceCenter.a.getClass();
        if (ResourceCenter.c() == false) goto L28;
        r0.L$0 = r6;
        r0.label = 1;
        r8 = b(r6, r0);
        if (r8 != r2) goto L23;
        return r2;
    L28:
        r0.label = 3;
        r8 = c(r6, r0);
        if (r8 != r2) goto L32;
        return r2;
    L7:
        r0 = new SaveMenuItemKt$requireDownloadFileUrl$1(r7);
        goto L8
    }

    public static final Object b(SendFile r5, Continuation<? super String> r6) {
        if ((r6 instanceof SaveMenuItemKt$requireDownloadFileUrlByResourceId$1) == false) goto L7;
        SaveMenuItemKt$requireDownloadFileUrlByResourceId$1 r0 = (SaveMenuItemKt$requireDownloadFileUrlByResourceId$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L21:
        ResourceSignUrlData r9 = (ResourceSignUrlData) ((Map) r7).get(r8);
        if (r9 == null) goto L26;
        String r10 = r9.getExternalUrl();
        if (r10 == null) goto L26;
        return com.larus.utils.p0.a(r10);
    L26:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r11 = r5.getResourceId();
        if (r11 == null) goto L26;
        r8 = com.larus.utils.p0.a(r11);
        if (r8 == null) goto L26;
        ResourceCenter r12 = ResourceCenter.a;
        List r4 = CollectionsKt.listOf(r8);
        SignUrlMode r13 = SignUrlMode.Outer;
        r0.L$0 = r8;
        r0.label = 1;
        r7 = r12.m(r4, r13, r0);
        if (r7 != r2) goto L21;
        return r2;
    L7:
        r0 = new SaveMenuItemKt$requireDownloadFileUrlByResourceId$1(r6);
        goto L8
    }

    public static final Object c(SendFile r5, Continuation<? super String> r6) {
        if ((r6 instanceof SaveMenuItemKt$requireDownloadFileUrlByTosKey$1) == false) goto L7;
        SaveMenuItemKt$requireDownloadFileUrlByTosKey$1 r0 = (SaveMenuItemKt$requireDownloadFileUrlByTosKey$1) r6;
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
    L20:
        FileUrlRespData r8 = (FileUrlRespData) ((com.larus.network.http.a) r7).b;
        if (r8 == null) goto L28;
        List<FileUrlData> r9 = r8.getFileUrlList();
        if (r9 == null) goto L29;
        FileUrlData r10 = (FileUrlData) CollectionsKt.firstOrNull(r9);
        if (r10 != null) goto L27;
        return null;
    L27:
        return r10.getMainUrl();
    L29:
        return null;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r11 = r5.getTosKey();
        if (r11 != null) goto L17;
        return null;
    L17:
        Lazy<ChatApi> r12 = ChatApi.a;
        ChatApi r13 = ChatApi.a.a();
        List r14 = CollectionsKt.listOf(r11);
        String r4 = UploadDataType.FILE.getType();
        r0.label = 1;
        r13.getClass();
        r7 = ChatApi.e(r14, r4, r0);
        if (r7 != r2) goto L20;
        return r2;
    L7:
        r0 = new SaveMenuItemKt$requireDownloadFileUrlByTosKey$1(r6);
        goto L8
    }
}
