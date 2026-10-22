package com.larus.uaigc.service;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import java.util.UUID;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class IUgcAIGCService$a {
    public static /* synthetic */ void a(IUgcAIGCService.Companion r6, UserCreation r7, FragmentActivity r8, View r9) {
        r6.J(r7, r8, r9, null, false);
    }

    public static /* synthetic */ Object b(IUgcAIGCService.Companion r8, String r9, String r10, Continuation r11) {
        return r8.D(r9, "Creation", r10, "image", false, null, r11);
    }

    public static /* synthetic */ void d(IUgcAIGCService.Companion r13, Context r14, String r15, ShareScene r16, com.larus.bmhome.share.panel.d r17, com.larus.bmhome.share.panel.h r18, UserCreationFromIM r19, UserCreation r20, String r21, int r22) {
        if ((r22 & 4) == 0) goto L5;
        ShareScene r5 = ShareScene.IMAGE_VIEWER_REPORT;
    L7:
        if ((r22 & 8) == 0) goto L9;
        com.larus.bmhome.share.panel.d r6 = null;
    L11:
        if ((r22 & 16) == 0) goto L13;
        com.larus.bmhome.share.panel.h r7 = null;
    L15:
        if ((r22 & 64) == 0) goto L17;
        UserCreationFromIM r9 = null;
    L19:
        if ((r22 & 128) == 0) goto L21;
        UserCreation r10 = null;
    L23:
        if ((r22 & 512) == 0) goto L25;
        String r12 = null;
    L26:
        r13.N(r14, r15, r5, r6, r7, null, r9, r10, null, r12);
        return;
    L25:
        r12 = r21;
        goto L26
    L21:
        r10 = r20;
        goto L23
    L17:
        r9 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    public static /* synthetic */ void c(IUgcAIGCService.Companion r14, Context r15, String r16, nr9.g r17, CoroutineScope r18, Function0 r19, boolean r20, UserCreation r21, Function4 r22, Function0 r23, int r24) {
        if ((r24 & 2) == 0) goto L5;
        String r4 = UUID.randomUUID().toString();
    L7:
        if ((r24 & 16) == 0) goto L9;
        Function0 r7 = null;
    L11:
        if ((r24 & 128) == 0) goto L13;
        UserCreation r10 = null;
    L15:
        if ((r24 & 512) == 0) goto L17;
        Function0 r12 = null;
    L18:
        r14.g(r15, r4, r17, r18, r7, r20, null, r10, r22, r12, null);
        return;
    L17:
        r12 = r23;
        goto L18
    L13:
        r10 = r21;
        goto L15
    L9:
        r7 = r19;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }
}
