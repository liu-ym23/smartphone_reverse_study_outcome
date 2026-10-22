package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"eventGson", "Lcom/google/gson/Gson;", "getEventGson", "()Lcom/google/gson/Gson;", "eventstaskkit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AppEventUtilsKt {
    private static final Gson eventGson = null;

    static {
        Gson r0 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapter(AppEvent.class, new AppEventTypeAdapter()).create();
        Intrinsics.checkNotNull(r0);
        eventGson = r0;
    }
}
