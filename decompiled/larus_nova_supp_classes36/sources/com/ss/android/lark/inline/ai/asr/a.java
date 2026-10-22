package com.ss.android.lark.inline.ai.asr;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/AsrExtra;", "", "<init>", "()V", TabAppInfo.IMAGE_JSON_KEY, "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "parentKey", "getParentKey", "setParentKey", "icon", "getIcon", "setIcon", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "clientParams", "", "getClientParams", "()Ljava/util/List;", "setClientParams", "(Ljava/util/List;)V", "isVisible", "", "()Z", "setVisible", "(Z)V", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class a {
    public static final Gson a = null;

    @SerializedName("client_param")
    private List<String> clientParams;

    @SerializedName("icon")
    private String icon;

    @SerializedName("is_visible")
    private boolean isVisible;

    @SerializedName(TabAppInfo.IMAGE_JSON_KEY)
    private String key;

    @SerializedName("parent_key")
    private String parentKey;

    @SerializedName("priority")
    private int priority;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.asr.a$a, reason: collision with other inner class name */
    public static final class C0100a {
        public static Map a(Map r3) {
            Intrinsics.checkNotNullParameter(r3, "extraMap");
            String r4 = (String) r3.get("Comment");
            if (r4 != null) goto L5;
        L8:
            boolean r0 = true;
        L10:
            if (r0 == false) goto L13;
            Log.i("AsrExtra", "extra comment is empty");
            return new LinkedHashMap();
        L13:
            Gson r1 = a.a;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
            return (Map) r1.fromJson(r4, new HashMap().getClass());
        L16:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r6) == false) goto L21;
            Log.e("AsrExtra", "parse json failed", Result.exceptionOrNull-impl(r6));
        L21:
            return new LinkedHashMap();
        L5:
            if (r4.length() == 0) goto L8;
            r0 = false;
            goto L10
        }
    }

    static {
        a = new Gson();
    }

    public a() {
        this.key = "";
        this.parentKey = "";
        this.icon = "";
        this.clientParams = CollectionsKt.emptyList();
    }

    public final String a() {
        return this.icon;
    }
}
