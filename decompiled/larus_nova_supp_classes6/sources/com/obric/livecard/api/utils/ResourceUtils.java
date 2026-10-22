package com.obric.livecard.api.utils;

import android.content.Context;
import android.net.Uri;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils;", "", "()V", "getApplicationIcon", "", "packageName", "getAssetsFile", "context", "Landroid/content/Context;", "fileName", "type", "getDrawable", "drawableId", "", "getString", "stringId", "ResourceType", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = null;

    static {
        INSTANCE = new ResourceUtils();
    }

    private ResourceUtils() {
    }

    public final String getApplicationIcon(String r3) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("pkg", r3).appendQueryParameter("type", "app_icon").build().toString();
    }

    public final String getString(int r3) {
        return "stringId://" + r3;
    }

    public final String getDrawable(Context r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("id", String.valueOf(r4)).appendQueryParameter("pkg", r3.getPackageName()).appendQueryParameter("type", "drawable").build().toString();
    }

    public final String getAssetsFile(Context r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "fileName");
        Intrinsics.checkNotNullParameter(r7, "type");
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("fileName", r6).appendQueryParameter("pkg", r5.getPackageName()).appendQueryParameter("type", r7).build().toString();
    }
}
