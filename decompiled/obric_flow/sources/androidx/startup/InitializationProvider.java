package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    public InitializationProvider() {
    }

    @Override // android.content.ContentProvider
    public final int delete(@NonNull Uri r5, @Nullable String r10, @Nullable String[] r11) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final String getType(@NonNull Uri r5) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Uri insert(@NonNull Uri r5, @Nullable ContentValues r10) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r5 = getContext();
        if (r5 == null) goto L10;
        if (r5.getApplicationContext() == null) goto L11;
        AppInitializer.getInstance(r5).discoverAndInitialize();
        return true;
    L11:
        return true;
    L10:
        throw new StartupException("Context cannot be null");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Cursor query(@NonNull Uri r5, @Nullable String[] r10, @Nullable String r11, @Nullable String[] r12, @Nullable String r13) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(@NonNull Uri r5, @Nullable ContentValues r10, @Nullable String r11, @Nullable String[] r12) {
        throw new IllegalStateException("Not allowed.");
    }
}
