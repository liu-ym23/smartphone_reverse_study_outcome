package com.larus.doc.sdk.impl.generalbiz.common;

import android.webkit.WebView;
import ap5.a;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.larus.doc.sdk.impl.generalbiz.state.media.SelectedMediaItemV1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p39.b;
import p39.c;
import p39.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#2\u0006\u0010\u0013\u001a\u00020\u0014J*\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/common/FlowJsCaller;", "", "<init>", "()V", "JS_FUNC_PREFIX", "", "BIZ_UTIL", "FUNC_MORE_OPERATION", "FUNC_CLICK_EDIT_ITEM", "FUNC_INSERT_MEDIA", "FUNC_PREPARE_INSERT_MEDIA", "FUNC_ASR_START", "FUNC_ASR_RESULT", "FUNC_ASR_END", "notifyMoreAction", "", "webView", "Landroid/webkit/WebView;", "type", "version", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "clickEditItem", "id", "insertMedia", "mediaList", "", "Lcom/larus/doc/sdk/impl/generalbiz/state/media/SelectedMediaItemV1;", "buildJsonData", "Lcom/google/gson/JsonObject;", "prepareInsertMedia", "startVoiceInput", "callback", "Lkotlin/Function1;", "displayAsrText", "sentence", "Lkotlin/Pair;", "stopVoiceInput", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowJsCaller {
    private static final String BIZ_UTIL = "biz.util.";
    private static final String FUNC_ASR_END = "javascript:window.flow.biz.aiSpeech.end";
    private static final String FUNC_ASR_RESULT = "javascript:window.flow.biz.aiSpeech.speaking";
    private static final String FUNC_ASR_START = "javascript:window.flow.biz.aiSpeech.start";
    private static final String FUNC_CLICK_EDIT_ITEM = "javascript:window.flow.biz.navigation.clickEditItem";
    private static final String FUNC_INSERT_MEDIA = "javascript:window.flow.biz.util.insertMedia";
    private static final String FUNC_MORE_OPERATION = "javascript:window.flow.biz.navigation.moreOperation";
    private static final String FUNC_PREPARE_INSERT_MEDIA = "javascript:window.flow.biz.util.prepareInsertMedia";
    public static final FlowJsCaller INSTANCE = null;
    private static final String JS_FUNC_PREFIX = "javascript:window.flow.";

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DocSdkVersion.values().length];
            r0[DocSdkVersion.V1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DocSdkVersion.V2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new FlowJsCaller();
    }

    private FlowJsCaller() {
    }

    public static /* synthetic */ void a(Function1 r0, String r1) {
        startVoiceInput$lambda$7(r0, r1);
    }

    public static /* synthetic */ void b(Function1 r0, String r1) {
        stopVoiceInput$lambda$17(r0, r1);
    }

    public static /* synthetic */ void c(Function1 r0, String r1) {
        stopVoiceInput$lambda$21(r0, r1);
    }

    public static /* synthetic */ void d(Function1 r0, String r1) {
        startVoiceInput$lambda$11(r0, r1);
    }

    private final JsonObject buildJsonData(List<SelectedMediaItemV1> r6) {
        JsonArray r0 = new JsonArray();
        Iterator<SelectedMediaItemV1> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        SelectedMediaItemV1 r1 = r7.next();
        JsonObject r2 = new JsonObject();
        r2.addProperty("contentType", r1.getContentType());
        r2.addProperty("uuid", r1.getUuid());
        r2.addProperty("src", r1.getMediaFile());
        r2.addProperty("width", Integer.valueOf(r1.getWidth()));
        r2.addProperty("height", Integer.valueOf(r1.getHeight()));
        r2.addProperty("fileSize", Long.valueOf(r1.getFileSize()));
        r2.addProperty("fileName", r1.getFileName());
        r0.add(r2);
        goto L4
    L6:
        JsonObject r8 = new JsonObject();
        r8.addProperty("code", 0);
        r8.add("thumbs", r0);
        r8.addProperty("type", "image");
        return r8;
    }

    private static final void startVoiceInput$lambda$11(Function1 r4, String r5) {
        FLogger.a.i("VoiceInputPlugin", "startVoiceInput: " + r5);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r6 = p0.a(r5);     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        String r7 = new JSONObject(r6).optString("context");     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L9
        r4.invoke(r7);     // Catch: Throwable -> L9
    L7:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r8) == null) goto L17;
        r4.invoke("");
        return;
    L17:
        return;
    L6:
        r4.invoke("");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void startVoiceInput$lambda$7(Function1 r4, String r5) {
        FLogger.a.i("VoiceInputPlugin", "startVoiceInput: " + r5);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r6 = p0.a(r5);     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        String r7 = new JSONObject(r6).optString("context");     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L9
        r4.invoke(r7);     // Catch: Throwable -> L9
    L7:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r8) == null) goto L17;
        r4.invoke("");
        return;
    L17:
        return;
    L6:
        r4.invoke("");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void stopVoiceInput$lambda$17(Function1 r3, String r4) {
        FLogger.a.i("VoiceInputPlugin", "stopVoiceInput: " + r4);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r5 = p0.a(r4);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r3.invoke(Integer.valueOf(new JSONObject(r5).optInt("length")));     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r6) == null) goto L17;
        r3.invoke(0);
        return;
    L17:
        return;
    L6:
        r3.invoke(0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private static final void stopVoiceInput$lambda$21(Function1 r3, String r4) {
        FLogger.a.i("VoiceInputPlugin", "stopVoiceInput: " + r4);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r5 = p0.a(r4);     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        r3.invoke(Integer.valueOf(new JSONObject(r5).optInt("length")));     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r6) == null) goto L17;
        r3.invoke(0);
        return;
    L17:
        return;
    L6:
        r3.invoke(0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void prepareInsertMedia(WebView r3, DocSdkVersion r4) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "version");
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L5;
        SafeJSExecutor.execJS(r3, FUNC_PREPARE_INSERT_MEDIA);
        return;
    L5:
        if (r5 != 2) goto L8;
        a.a(r3, FUNC_PREPARE_INSERT_MEDIA, null, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void clickEditItem(WebView r4, String r5, DocSdkVersion r6) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        Intrinsics.checkNotNullParameter(r5, "id");
        Intrinsics.checkNotNullParameter(r6, "version");
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 != 1) goto L5;
        JsonObject r8 = new JsonObject();
        r8.addProperty("id", r5);
        Unit r9 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r4, FUNC_CLICK_EDIT_ITEM, r8);
        return;
    L5:
        if (r7 != 2) goto L8;
        com.alibaba.fastjson.JSONObject r10 = new com.alibaba.fastjson.JSONObject();
        r10.put("id", r5);
        Unit r11 = Unit.INSTANCE;
        a.a(r4, FUNC_CLICK_EDIT_ITEM, r10, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void displayAsrText(WebView r5, Pair<String, String> r6, DocSdkVersion r7) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r6, "sentence");
        Intrinsics.checkNotNullParameter(r7, "version");
        int r8 = WhenMappings.$EnumSwitchMapping$0[r7.ordinal()];
        if (r8 != 1) goto L5;
        JsonObject r9 = new JsonObject();
        r9.addProperty("streamingSentence", (String) r6.getFirst());
        r9.addProperty("definiteSentence", (String) r6.getSecond());
        Unit r10 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r5, FUNC_ASR_RESULT, r9);
        return;
    L5:
        if (r8 != 2) goto L8;
        com.alibaba.fastjson.JSONObject r11 = new com.alibaba.fastjson.JSONObject();
        r11.put("streamingSentence", r6.getFirst());
        r11.put("definiteSentence", r6.getSecond());
        Unit r12 = Unit.INSTANCE;
        a.a(r5, FUNC_ASR_RESULT, r11, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void insertMedia(WebView r2, List<SelectedMediaItemV1> r3, DocSdkVersion r4) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "mediaList");
        Intrinsics.checkNotNullParameter(r4, "version");
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L5;
        SafeJSExecutor.execJS(r2, FUNC_INSERT_MEDIA, buildJsonData(r3));
        return;
    L5:
        if (r5 != 2) goto L8;
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void notifyMoreAction(WebView r4, String r5, DocSdkVersion r6) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "version");
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 != 1) goto L5;
        JsonObject r8 = new JsonObject();
        r8.addProperty("type", r5);
        Unit r9 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r4, FUNC_MORE_OPERATION, r8);
        return;
    L5:
        if (r7 != 2) goto L8;
        com.alibaba.fastjson.JSONObject r10 = new com.alibaba.fastjson.JSONObject();
        r10.put("type", r5);
        Unit r11 = Unit.INSTANCE;
        a.a(r4, FUNC_MORE_OPERATION, r10, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void startVoiceInput(WebView r3, final Function1<? super String, Unit> r4, DocSdkVersion r5) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "version");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r6 != 1) goto L5;
        SafeJSExecutor.execJS(r3, FUNC_ASR_START, new JsonObject(), new p39.a(r4));
        return;
    L5:
        if (r6 != 2) goto L8;
        a.a(r3, FUNC_ASR_START, new com.alibaba.fastjson.JSONObject(), new b(r4));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void stopVoiceInput(WebView r3, final Function1<? super Integer, Unit> r4, DocSdkVersion r5) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "version");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r6 != 1) goto L5;
        SafeJSExecutor.execJS(r3, FUNC_ASR_END, new JsonObject(), new c(r4));
        return;
    L5:
        if (r6 != 2) goto L8;
        a.a(r3, FUNC_ASR_END, new com.alibaba.fastjson.JSONObject(), new d(r4));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
