package com.obric.memorydata.personalcontext.external.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.PhotoRawDbDao;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.entity.fg;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.external.c;
import com.obric.memorydata.personalcontext.external.e;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.util.f;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/album/ExternalAlbumEntitySupplier;", "", "<init>", "()V", "TAG", "", "notifyAlbumEntityChanged", "", "albumEntityId", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12099a = null;

    static {
        f12099a = new a();
    }

    private a() {
    }

    public final void a(String r18) {
        Intrinsics.checkNotNullParameter(r18, "albumEntityId");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        boolean r4 = true;
        if (ContextCompat.checkSelfPermission(r1, "android.permission.READ_MEDIA_IMAGES") != 0) goto L5;
        boolean r3 = true;
    L7:
        if (ContextCompat.checkSelfPermission(r1, "android.permission.READ_MEDIA_VIDEO") != 0) goto L9;
        boolean r2 = true;
    L11:
        if (r3 == false) goto L106;
        if (r2 == false) goto L106;
        c.f12108a.b("ExternalAlbumEntitySupplier", "notifyAlbumEntityChanged albumEntityId: " + r18);
        Bundle r9 = new Bundle();
        r9.putString("android:query-arg-sql-selection", "bucket_id = ? AND (media_type = ? OR media_type = ?)");
        r9.putStringArray("android:query-arg-sql-selection-args", new String[]{r18, "1", "3"});
        r9.putInt("android:query-arg-limit", 1);
        Cursor r5 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), MediaStore.Files.getContentUri("external_primary"), new String[]{"bucket_display_name"}, r9, null, "com.obric.memorydata.plugin");
        Long r6 = null;
        if (r5 == null) goto L29;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r5, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r8 = (Cursor) ZeusTransformUtils.preCheckCast(r7, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r8.moveToFirst() == false) goto L20;
        String r10 = r8.getString(0);     // Catch: Throwable -> L23
    L21:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r7, null);
    L30:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L33;
    L36:
        boolean r13 = true;
    L38:
        if (r13 == false) goto L41;
        e.f12121a.a(CollectionsKt.listOf(r18), 302);
        return;
    L41:
        if (r10 != null) goto L43;
        String r14 = "";
    L44:
        EntityIndexEngine r15 = s.a();
        IAppEntityRawDbDao<d> r16 = r15.getRawDaoByEntityType(301);
        if (ZeusTransformUtils.instanceOf(r16, PhotoRawDbDao.class) == false) goto L47;
        PhotoRawDbDao r17 = (PhotoRawDbDao) ZeusTransformUtils.preCheckCast(r16, PhotoRawDbDao.class, "com.obric.memorydata.plugin");
    L48:
        IAppEntityRawDbDao<d> r19 = r15.getRawDaoByEntityType(302);
        if (r17 == null) goto L104;
        if (r19 == null) goto L104;
        int r110 = r17.getCountByAlbumId(r18);
        hb r20 = r17.queryLatestByAlbumId(r18);
        if (r20 == null) goto L55;
        String r21 = r20.a();
    L56:
        FileEntity r111 = f.c(r21);
        String r22 = g.f12138a.a(301);
        Object r23 = CollectionsKt.firstOrNull(r19.queryByEntityId(r18, r22));
        if (ZeusTransformUtils.instanceOf(r23, fg.class) == false) goto L59;
        fg r24 = (fg) ZeusTransformUtils.preCheckCast(r23, fg.class, "com.obric.memorydata.plugin");
    L60:
        if (r24 == null) goto L62;
        String r25 = r24.a();
    L63:
        if (r24 == null) goto L65;
        int r26 = r24.c();
    L66:
        if (r24 == null) goto L68;
        String r112 = r24.b();
    L69:
        FileEntity r113 = f.c(r112);
        if (r113 == null) goto L72;
        Uri r114 = r113.getContentUrl();
    L73:
        if (r111 == null) goto L75;
        Uri r115 = r111.getContentUrl();
    L76:
        boolean r116 = Intrinsics.areEqual(r114, r115);
        if (r113 == null) goto L79;
        Long r117 = Long.valueOf(r113.getFileSize());
    L80:
        if (r111 == null) goto L82;
        Long r118 = Long.valueOf(r111.getFileSize());
    L84:
        if (Intrinsics.areEqual(r117, r118) == true) goto L86;
        r116 = false;
    L86:
        if (r113 == null) goto L88;
        Long r119 = Long.valueOf(r113.getLastModifiedTime());
    L89:
        if (r111 == null) goto L92;
        r6 = Long.valueOf(r111.getLastModifiedTime());
    L92:
        if (Intrinsics.areEqual(r119, r6) == true) goto L94;
        r116 = false;
    L94:
        if (r24 != null) goto L96;
    L101:
        if (r4 == false) goto L112;
        AlbumEntity r120 = new AlbumEntity(r18, 0, 0, r14, r111);
        r120.set_packageName(r22);
        r120.setMediaCount(r110);
        e.f12121a.a(CollectionsKt.listOf(r120));
        return;
    L112:
        return;
    L96:
        if (Intrinsics.areEqual(r25, r10) == false) goto L101;
        if (r26 != r110) goto L101;
        if (r116 == false) goto L101;
        r4 = false;
        goto L101
    L88:
        r119 = null;
        goto L89
    L82:
        r118 = null;
        goto L84
    L79:
        r117 = null;
        goto L80
    L75:
        r115 = null;
        goto L76
    L72:
        r114 = null;
        goto L73
    L68:
        r112 = null;
        goto L69
    L65:
        r26 = 0;
        goto L66
    L62:
        r25 = null;
        goto L63
    L59:
        r24 = null;
        goto L60
    L55:
        r21 = null;
    L104:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ExternalAlbumEntitySupplier", "rawDao is null, photoDao: " + r17 + ", albumDao: " + r19, null, 4, null);
        return;
    L47:
        r17 = null;
        goto L48
    L43:
        r14 = r10;
        goto L44
    L33:
        if (r12.length() == 0) goto L36;
        r13 = false;
        goto L38
    L20:
        r10 = null;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L29:
        r10 = null;
    L106:
        c.f12108a.b("ExternalAlbumEntitySupplier", "notifyAlbumEntityChanged failed, albumEntityId:" + r18 + ", permission not allow");
        return;
    L9:
        r2 = false;
        goto L11
    L5:
        r3 = false;
        goto L7
    }
}
