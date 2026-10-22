package com.obric.aivoice.core.utils;

import com.google.gson.Gson;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.aivoice.core.log.AIVoiceLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\bH\u0086\b¢\u0006\u0002\u0010\t\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"GSON", "Lcom/google/gson/Gson;", "getGSON", "()Lcom/google/gson/Gson;", "GSON$delegate", "Lkotlin/Lazy;", "toObj", "T", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/lang/String;)Ljava/lang/Object;", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class GsonExtKt {
    private static final Lazy GSON$delegate = null;

    static {
        GSON$delegate = LazyKt.lazy(GsonExtKt$GSON$2.INSTANCE);
    }

    public static final Gson getGSON() {
        return (Gson) GSON$delegate.getValue();
    }

    public static final /* synthetic */ <T> T toObj(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Gson r0 = getGSON();     // Catch: Exception -> L5
        Intrinsics.reifiedOperationMarker(4, "T");     // Catch: Exception -> L5
        return (T) r0.fromJson(r3, Object.class);
    L5:
        e = move-exception;
        AIVoiceLog.INSTANCE.e("GsonExt", "toObj error : " + e);
        return null;
    }
}
