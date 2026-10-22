package com.larus.bmhome.music.widget;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n2 {
    public static final MusicCreationContentList a(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L42;
        return null;
    L42:
        Gson r4 = new Gson();     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        JsonArray r8 = (JsonArray) GsonProtectorUtils.fromJson(r4, r7, JsonArray.class);     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        if (r8 != null) goto L15;
        return null;
    L15:
        Iterator r9 = r8.iterator();     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
    L17:
        if (r9.hasNext() == false) goto L41;
        JsonElement r5 = (JsonElement) r9.next();     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        if (r5 == null) goto L17;
        JsonObject r6 = r5.getAsJsonObject();     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        if (r6 == null) goto L17;
        JsonElement r10 = r6.get("content");     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        if (r10 == null) goto L17;
        if (r10.isJsonNull() == true) goto L17;
        String r11 = r10.getAsString();     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        Intrinsics.checkNotNull(r11);     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        if (r11.length() != 0) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L17;
        MusicCreationContentList r13 = (MusicCreationContentList) GsonProtectorUtils.fromJson(r4, r11, MusicCreationContentList.class);     // Catch: IllegalStateException -> L37 JsonSyntaxException -> L39
        if (r13 == null) goto L17;
        return r13;
    L31:
        r12 = false;
    L41:
        return null;
    L39:
        e = move-exception;
        FLogger.a.e("MusicPlayerDetailFragment", "[parseMusicCreationContentList] json syntax error", e);
    L37:
        e = move-exception;
        FLogger.a.e("MusicPlayerDetailFragment", "[parseMusicCreationContentList] illegal block content", e);
        goto L41
    L5:
        if (r7.length() == 0) goto L8;
        r3 = false;
        goto L10
    }
}
