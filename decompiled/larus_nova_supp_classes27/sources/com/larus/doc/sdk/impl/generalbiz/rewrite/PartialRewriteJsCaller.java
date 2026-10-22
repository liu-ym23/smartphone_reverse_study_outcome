package com.larus.doc.sdk.impl.generalbiz.rewrite;

import android.webkit.WebView;
import ap5.a;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.doc.sdk.impl.generalbiz.common.DocSdkVersion;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q39.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015J.\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/doc/sdk/impl/generalbiz/rewrite/PartialRewriteJsCaller;", "", "<init>", "()V", "TAG", "", "JS_FUNC_PREFIX", "FUNC_ENTER_STREAM_EDIT_MODE", "FUNC_LEAVE_STREAM_EDIT_MODE", "FUNC_START_STREAM_EDIT", "FUNC_STREAM_EDIT_TEXT_CONTENT", "FUNC_END_STREAM_EDIT", "FUNC_CLEAR_REFERENCE", "FUNC_UPDATE_TRACK_INFO", "enterStreamEditMode", "", "webView", "Landroid/webkit/WebView;", "callback", "Lkotlin/Function1;", "docSdkVersion", "Lcom/larus/doc/sdk/impl/generalbiz/common/DocSdkVersion;", "startStreamEdit", "streamEditTextContent", "content", "endStreamEdit", "cancelStreaming", "", "leaveStreamEditMode", "scene", "", "restoreSelection", "isKeyboardShowing", "clearReference", "notifyTrackInfoUpdate", "info", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PartialRewriteJsCaller {
    private static final String FUNC_CLEAR_REFERENCE = "javascript:window.flow.biz.util.clearReference";
    private static final String FUNC_END_STREAM_EDIT = "javascript:window.flow.biz.aiEdit.endStreamEdit";
    private static final String FUNC_ENTER_STREAM_EDIT_MODE = "javascript:window.flow.biz.aiEdit.enterStreamEditMode";
    private static final String FUNC_LEAVE_STREAM_EDIT_MODE = "javascript:window.flow.biz.aiEdit.leaveStreamEditMode";
    private static final String FUNC_START_STREAM_EDIT = "javascript:window.flow.biz.aiEdit.startStreamEdit";
    private static final String FUNC_STREAM_EDIT_TEXT_CONTENT = "javascript:window.flow.biz.aiEdit.streamEditTextContent";
    private static final String FUNC_UPDATE_TRACK_INFO = "javascript:window.flow.biz.util.updateTrackInfo";
    public static final PartialRewriteJsCaller INSTANCE = null;
    private static final String JS_FUNC_PREFIX = "javascript:window.flow.";
    private static final String TAG = "PartialRewriteJsCaller";

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
        INSTANCE = new PartialRewriteJsCaller();
    }

    private PartialRewriteJsCaller() {
    }

    public static /* synthetic */ void a(Function1 r0, String r1) {
        enterStreamEditMode$lambda$1(r0, r1);
    }

    public static /* synthetic */ void b(Function1 r0, String r1) {
        enterStreamEditMode$lambda$0(r0, r1);
    }

    private static final void enterStreamEditMode$lambda$0(Function1 r0, String r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.invoke(r1);
        return;
    }

    private static final void enterStreamEditMode$lambda$1(Function1 r0, String r1) {
        if (r0 == null) goto L7;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.invoke(r1);
        return;
    }

    public final void clearReference(WebView r3, DocSdkVersion r4) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "docSdkVersion");
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L5;
        SafeJSExecutor.execJS(r3, FUNC_CLEAR_REFERENCE, new JsonObject());
        return;
    L5:
        if (r5 != 2) goto L8;
        a.a(r3, FUNC_CLEAR_REFERENCE, new JSONObject(), null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void startStreamEdit(WebView r3, DocSdkVersion r4) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r4, "docSdkVersion");
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L5;
        SafeJSExecutor.execJS(r3, FUNC_START_STREAM_EDIT, new JsonObject());
        return;
    L5:
        if (r5 != 2) goto L8;
        a.a(r3, FUNC_START_STREAM_EDIT, new JSONObject(), null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void endStreamEdit(WebView r4, boolean r5, DocSdkVersion r6) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        Intrinsics.checkNotNullParameter(r6, "docSdkVersion");
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 != 1) goto L5;
        JsonObject r8 = new JsonObject();
        r8.addProperty("cancelStreaming", Boolean.valueOf(r5));
        Unit r9 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r4, FUNC_END_STREAM_EDIT, r8);
        return;
    L5:
        if (r7 != 2) goto L8;
        JSONObject r10 = new JSONObject();
        r10.put("cancelStreaming", Boolean.valueOf(r5));
        Unit r11 = Unit.INSTANCE;
        a.a(r4, FUNC_END_STREAM_EDIT, r10, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void enterStreamEditMode(WebView r3, final Function1<? super String, Unit> r4, DocSdkVersion r5) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        Intrinsics.checkNotNullParameter(r5, "docSdkVersion");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r6 != 1) goto L5;
        SafeJSExecutor.execJS(r3, FUNC_ENTER_STREAM_EDIT_MODE, new JsonObject(), new q39.a(r4));
        return;
    L5:
        if (r6 != 2) goto L8;
        a.a(r3, FUNC_ENTER_STREAM_EDIT_MODE, new JSONObject(), new b(r4));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void notifyTrackInfoUpdate(WebView r4, DocSdkVersion r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        Intrinsics.checkNotNullParameter(r5, "docSdkVersion");
        Intrinsics.checkNotNullParameter(r6, "info");
        int r7 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r7 != 1) goto L5;
        SafeJSExecutor.execJS(r4, FUNC_UPDATE_TRACK_INFO, JsonParser.parseString(r6).getAsJsonObject());     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        FLogger.a.e(TAG, e.getMessage(), e);
        return;
    L5:
        if (r7 != 2) goto L11;
        a.a(r4, FUNC_UPDATE_TRACK_INFO, (JSONObject) JSON.parseObject(r6, JSONObject.class), null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e(TAG, e.getMessage(), e);
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final void streamEditTextContent(WebView r4, String r5, DocSdkVersion r6) {
        Intrinsics.checkNotNullParameter(r4, "webView");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "docSdkVersion");
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 != 1) goto L5;
        JsonObject r8 = new JsonObject();
        r8.addProperty("text", r5);
        Unit r9 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r4, FUNC_STREAM_EDIT_TEXT_CONTENT, r8);
        return;
    L5:
        if (r7 != 2) goto L8;
        JSONObject r10 = new JSONObject();
        r10.put("text", r5);
        Unit r11 = Unit.INSTANCE;
        a.a(r4, FUNC_STREAM_EDIT_TEXT_CONTENT, r10, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final void leaveStreamEditMode(WebView r6, int r7, boolean r8, boolean r9, DocSdkVersion r10) {
        Intrinsics.checkNotNullParameter(r6, "webView");
        Intrinsics.checkNotNullParameter(r10, "docSdkVersion");
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 != 1) goto L5;
        JsonObject r12 = new JsonObject();
        r12.addProperty("is_keyboard_showing", Boolean.valueOf(r9));
        r12.addProperty("scene", Integer.valueOf(r7));
        r12.addProperty("restoreSelection", Boolean.valueOf(r8));
        Unit r13 = Unit.INSTANCE;
        SafeJSExecutor.execJS(r6, FUNC_LEAVE_STREAM_EDIT_MODE, r12);
        return;
    L5:
        if (r11 != 2) goto L8;
        JSONObject r14 = new JSONObject();
        r14.put("is_keyboard_showing", Boolean.valueOf(r9));
        r14.put("scene", Integer.valueOf(r7));
        r14.put("restoreSelection", Boolean.valueOf(r8));
        Unit r15 = Unit.INSTANCE;
        a.a(r6, FUNC_LEAVE_STREAM_EDIT_MODE, r14, null);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
