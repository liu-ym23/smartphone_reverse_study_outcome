package com.obric.memorydata.utils;

import android.content.Intent;
import android.net.Uri;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/utils/IntentFactory;", "", "<init>", "()V", "dial", "Landroid/content/Intent;", "number", "", "sms", "body", "geo", MemoryKeyInfoEntity.KEY_ADDRESS, "pkg", "viewUrl", "url", "addContact", MemoryKeyInfoEntity.KEY_PHONE, "normalizeUrl", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f13269a = null;

    static {
        f13269a = new z();
    }

    private z() {
    }

    private final String c(String r4) {
        if (StringsKt.startsWith$default(r4, "http://", false, 2, null) == false) goto L5;
        return r4;
    L5:
        if (StringsKt.startsWith$default(r4, ReportConsts.HTTPS, false, 2, null) == false) goto L8;
        return r4;
    L8:
        if (ax.f13189a.d(r4) == true) goto L10;
        return r4;
    L10:
        return ReportConsts.HTTPS + r4;
    }

    public final Intent a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intent r0 = new Intent("android.intent.action.VIEW", Uri.parse(c(r2)));
        r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return r0;
    }

    public final Intent a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "number");
        Intent r2 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + r3));
        if (r4 == null) goto L5;
        r2.putExtra("sms_body", r4);
    L5:
        r2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        return r2;
    }

    public final Intent b(String r3) {
        Intrinsics.checkNotNullParameter(r3, MemoryKeyInfoEntity.KEY_PHONE);
        Intent r0 = new Intent("android.intent.action.INSERT");
        r0.setType("vnd.android.cursor.dir/raw_contact");
        r0.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        r0.putExtra(MemoryKeyInfoEntity.KEY_PHONE, r3);
        return r0;
    }

    public final Intent b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, MemoryKeyInfoEntity.KEY_ADDRESS);
        Intent r2 = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + Uri.encode(r3)));
        if (r4 == null) goto L5;
        r2.setPackage(r4);
    L5:
        r2.setFlags(268468224);
        return r2;
    }
}
