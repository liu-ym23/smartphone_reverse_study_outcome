package androidx.startup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends PluginContentProvider {
    public InitializationProvider() {
    }

    public final int delete(Uri r1, String r2, String[] r3) {
        throw new IllegalStateException("Not allowed.");
    }

    public final String getType(Uri r1) {
        throw new IllegalStateException("Not allowed.");
    }

    public final Uri insert(Uri r1, ContentValues r2) {
        throw new IllegalStateException("Not allowed.");
    }

    public final boolean onCreate() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L11;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L7;
        AppInitializer.getInstance(r3).discoverAndInitialize();
        return true;
    L7:
        StartupLogger.w("Deferring initialization because `applicationContext` is null.");
        return true;
    L11:
        throw new StartupException("Context cannot be null");
    }

    public final Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        throw new IllegalStateException("Not allowed.");
    }

    public final int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new IllegalStateException("Not allowed.");
    }
}
