package com.obric.aikernel.sdk.ext;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.config.RequestParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006\u001a#\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0013\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006\u001a\u0012\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0006\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 \u001a\u001a\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006\u001a\u0016\u0010$\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006¨\u0006&"}, d2 = {"authFilePath", "", "Lcom/obric/aikernel/sdk/config/RequestParams;", "context", "Landroid/content/Context;", Params.FILE_PATH, "", "setAssetFd", "path", "fd", "Landroid/content/res/AssetFileDescriptor;", "setCloudChatModel", Params.CONTENT, "setCustomArgs", "block", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lkotlin/ExtensionFunctionType;", "setFileFd", "Landroid/os/ParcelFileDescriptor;", "setFilePath", "setInferEvent", "event", "setLora", "type", "setMemoryTextEmbeddingV2", "setPreloadSeconds", "duration", "", "setTextModelInput", "setUpdateParams", "updateConfig", "", "setVlm2_0", Params.PROMPT, "uri", "useCloudModel", "version", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ParamsKt {
    public static final void authFilePath(RequestParams r4, Context r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, Params.FILE_PATH);
        r7.grantUriPermission("com.obric.aikernel", Uri.parse(r6), 1);
        r4.getBackend().putString(Params.FILE_PATH, r6);
    }

    public static final void setAssetFd(RequestParams r2, String r3, AssetFileDescriptor r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "fd");
        setFilePath(r2, r3);
        r2.getBackend().putParcelable(Params.FD_ASSET, (Parcelable) ZeusTransformUtils.preCheckCast(r4, Parcelable.class, "com.obric.memorydata.plugin"));
        ParcelFileDescriptor r5 = r4.getParcelFileDescriptor();
        Intrinsics.checkNotNullExpressionValue(r5, "fd.parcelFileDescriptor");
        setFileFd(r2, r5);
    }

    public static final void setCloudChatModel(RequestParams r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        useCloudModel$default(r2, null, 1, null);
        setTextModelInput(r2, r3);
    }

    public static final void setCustomArgs(RequestParams r2, Function1<? super Bundle, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        r4.invoke(r2.getBackend());
    }

    public static final void setFileFd(RequestParams r2, ParcelFileDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "fd");
        r2.getBackend().putParcelable(Params.FD, (Parcelable) ZeusTransformUtils.preCheckCast(r3, Parcelable.class, "com.obric.memorydata.plugin"));
    }

    public static final void setFilePath(RequestParams r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, Params.FILE_PATH);
        r1.getBackend().putString(Params.FILE_PATH, r2);
    }

    public static final void setInferEvent(RequestParams r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "event");
        r1.getBackend().putString(IdlKeys.Args_Infer_Event, r2);
    }

    public static final void setLora(RequestParams r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "type");
        r1.getBackend().putString(Params.LORA_TYPE, r2);
    }

    public static final void setMemoryTextEmbeddingV2(RequestParams r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        setTextModelInput(r1, r2);
    }

    public static final void setPreloadSeconds(RequestParams r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.getBackend().putBoolean(Params.NEED_PRELOAD, true);
        r3.getBackend().putInt(Params.PRELOAD_SECONDS, r4);
    }

    public static final void setTextModelInput(RequestParams r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        r1.getBackend().putString(Params.CONTENT, r2);
    }

    public static final void setUpdateParams(RequestParams r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.getBackend().putBoolean(Params.UPDATE_CONFIG, r2);
    }

    public static final void setVlm2_0(RequestParams r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, Params.PROMPT);
        Intrinsics.checkNotNullParameter(r4, "uri");
        r2.getBackend().putString(Params.PROMPT, r3);
        setFilePath(r2, r4);
        useCloudModel$default(r2, null, 1, null);
    }

    public static final void useCloudModel(RequestParams r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == null) goto L5;
        r2.getBackend().putString("version", r3);
    L5:
        r2.getBackend().putBoolean("useCloud", true);
    }

    public static /* synthetic */ void useCloudModel$default(RequestParams r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        useCloudModel(r0, r1);
    }
}
