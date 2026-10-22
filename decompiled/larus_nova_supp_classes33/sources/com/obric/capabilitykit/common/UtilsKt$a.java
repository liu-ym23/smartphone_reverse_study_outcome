package com.obric.capabilitykit.common;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke", "()Lcom/google/gson/Gson;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class UtilsKt$a extends Lambda implements Function0<Gson> {
    public static final UtilsKt$a a = null;

    static {
        a = new UtilsKt$a();
    }

    public UtilsKt$a() {
        super(0);
    }

    public final Gson a() {
        return new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return a();
    }
}
