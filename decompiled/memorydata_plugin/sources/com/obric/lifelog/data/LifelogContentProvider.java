package com.obric.lifelog.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQueryBuilder;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002JS\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J3\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001bJ=\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001aH\u0002¨\u0006)"}, d2 = {"Lcom/obric/lifelog/data/LifelogContentProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "checkPermission", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getRawData", "Landroidx/sqlite/db/SupportSQLiteQuery;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", com.obric.memorydata.BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", "updateLifelogEnableState", "enabled", OaidModel.KEY_TIME, "", "updateIsLifelogStartupComponentEnabled", "Companion", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LifelogContentProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8048a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/lifelog/data/LifelogContentProvider$Companion;", "", "<init>", "()V", "TAG", "", "LIFELOG_ENABLED", "", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8048a = new a(null);
    }

    public LifelogContentProvider() {
    }

    private final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "check permission", false, 4, null);
        if (ak.f13164a.a() == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "check permission refuse", false, 4, null);
        throw new SecurityException("No permission to access LifelogContentProvider!");
    }

    private final void a(int r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("is_lifelog_startup_component_enabled", r5);
    }

    private final void a(int r9, long r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "updateLifelogEnableState enabled " + r9 + " time " + r10, false, 4, null);
        IStore r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        r8.save("is_lifelog_enabled", r9);
        r8.save("lifelog_status_change_time", r10);
        Settings.System.putLong(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "setting_lifelog_status_change_time", r10);
    }

    public final Cursor a(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r3 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        PersonalMemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();     // Catch: Throwable -> L8
        if (r1.isOpen() == true) goto L6;
        return null;
    L6:
        return RoomDatabase.query$default((RoomDatabase) ZeusTransformUtils.preCheckCast(r1, RoomDatabase.class, "com.obric.memorydata.plugin"), r3, null, 2, null);
    L8:
        th = move-exception;
        RunLog.INSTANCE.error("LifelogContentProvider", "getRawData failed", th);
        return null;
    }

    public Bundle call(String r13, String r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "method");
        a();
        int r0 = r13.hashCode();
        int r4 = 0;
        if (r0 == (-1388038769)) goto L25;
        if (r0 == 1129057800) goto L18;
        if (r0 != 2011880585) goto L32;
        if (r13.equals("cleanLifelogData") == false) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "clean call", false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("lifelog_status_change_time", System.currentTimeMillis());
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getLifelogDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        ((LifelogEntity) ZeusTransformUtils.preCheckCast(r12.next(), LifelogEntity.class, "com.obric.memorydata.plugin")).delete();
        goto L14
    L16:
        Bundle r16 = new Bundle();
    L30:
        r16.putBoolean("success", true);
        return r16;
    L32:
        return super.call(r13, r14, r15);
    L18:
        if (r13.equals("disableStartupComponent") == false) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "disable startup component " + r14, false, 4, null);
        if (r14 == null) goto L23;
        r4 = Integer.parseInt(r14);
    L23:
        a(r4);
        r16 = new Bundle();
        goto L30
    L25:
        if (r13.equals("updateLifelogEnableState") == false) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "enabled " + r14, false, 4, null);
        if (r14 == null) goto L29;
        r4 = Integer.parseInt(r14);
    L29:
        a(r4, System.currentTimeMillis());
        r16 = new Bundle();
        goto L30
    }

    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "onCreate", false, 4, null);
        boolean r3 = false;
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getInt("is_lifelog_enabled", 0) != 1) goto L5;
    L10:
        return true;
    L5:
        if (Settings.Global.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "lifelog_setting_enabled", 0) != 1) goto L7;
        r3 = true;
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "onCreate enabled " + r3, false, 4, null);
        if (r3 == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogContentProvider", "enable lifelog", false, 4, null);
        a(1, System.currentTimeMillis());
        goto L10
    }

    public Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        a();
        SupportSQLiteQueryBuilder r8 = SupportSQLiteQueryBuilder.Companion.builder("Lifelog");
        if (r4 == null) goto L7;
        List r9 = ArraysKt.filterNotNull(r4);
        if (r9 == null) goto L7;
        String[] r10 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
    L9:
        return a(r8.columns(r10).selection(r5, r6).orderBy(r7).create());
    L7:
        r10 = null;
        goto L9
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }
}
