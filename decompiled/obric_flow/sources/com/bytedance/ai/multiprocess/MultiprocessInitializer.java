package com.bytedance.ai.multiprocess;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ai/multiprocess/MultiprocessInitializer;", "Landroid/content/ContentProvider;", "<init>", "()V", "ai-sdk-multiprocess_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiprocessInitializer extends ContentProvider {
    public MultiprocessInitializer() {
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r5, String r10, String[] r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r5, ContentValues r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        a r5 = new a();
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        d.f2406a = r5;
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r5, String[] r10, String r11, String[] r12, String r13) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r5, ContentValues r10, String r11, String[] r12) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        return 0;
    }
}
