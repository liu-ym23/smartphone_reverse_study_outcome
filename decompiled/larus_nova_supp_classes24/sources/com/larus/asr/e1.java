package com.larus.asr;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class e1 implements Runnable {
    public final /* synthetic */ String a;

    public /* synthetic */ e1(String r1, ChatBottomSpeakerComponent r2) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        Set r1 = ChatBottomSpeakerComponent.F2;
        int r2 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        FLogger.a.i("ChatBottomSpeakerComponent", "deleteOlderFile: parentPath is null or empty");
        return;
    L12:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r0);
        if (r4.exists() == true) goto L15;
    L58:
        FLogger.a.i("ChatBottomSpeakerComponent", "deleteOlderFile: directory not exists: " + r0);
        return;
    L15:
        if (r4.isDirectory() == false) goto L58;
        File[] r5 = r4.listFiles();
        if (r5 == null) goto L28;
        ArrayList r6 = new ArrayList();
        int r7 = r5.length;
        int r8 = 0;
    L20:
        if (r8 >= r7) goto L25;
        File r9 = r5[r8];
        if (r9.isFile() == false) goto L24;
        r6.add(r9);
    L24:
        r8 = r8 + 1;
        goto L20
    L25:
        List r10 = CollectionsKt.sortedWith(r6, new r1());
        if (r10 == null) goto L28;
        List r11 = CollectionsKt.toMutableList(r10);
    L29:
        if (r11 != null) goto L32;
        r11 = CollectionsKt.emptyList();
    L32:
        if (r11.size() <= 6) goto L47;
        File r12 = (File) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L47;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L38
        Object r14 = Result.constructor-impl(Boolean.valueOf(r12.delete()));     // Catch: Throwable -> L38
    L40:
        Boolean r15 = Boolean.FALSE;
        if (Result.isFailure-impl(r14) == false) goto L44;
        r14 = r15;
    L44:
        if (((Boolean) r14).booleanValue() == true) goto L46;
        FLogger.a.e("ChatBottomSpeakerComponent", "deleteOlderFile: delete failed: " + r12.getAbsolutePath());
    L46:
        r11 = CollectionsKt.toMutableList(CollectionsKt.drop(r11, 1));
    L38:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L47:
        File[] r17 = r4.listFiles();
        if (r17 == null) goto L56;
        int r19 = r17.length;
        int r20 = 0;
    L50:
        if (r2 >= r19) goto L55;
        if (r17[r2].isFile() == false) goto L54;
        r20 = r20 + 1;
    L54:
        r2 = r2 + 1;
        goto L50
    L55:
        r2 = r20;
    L56:
        if (r2 <= 6) goto L74;
        FLogger.a.e("ChatBottomSpeakerComponent", "deleteOlderFile: still too many files, current=" + r2 + ", max=6, dir=" + r0);
        return;
    L74:
        return;
    L28:
        r11 = null;
        goto L29
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }
}
