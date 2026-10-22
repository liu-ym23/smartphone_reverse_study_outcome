package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class MeizuOaidImpl implements OaidApi {
    private Singleton<Boolean> isSupport;

    MeizuOaidImpl() {
        this.isSupport = new AnonymousClass1(this);
    }

    private String getOaid(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.isClosed() == false) goto L8;
        return null;
    L8:
        r1.moveToFirst();
        int r0 = r1.getColumnIndex(EventBody.KEY_VALUE);
        if (r0 >= 0) goto L11;
        return null;
    L11:
        return r1.getString(r0);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Meizu";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Uri r2 = Uri.parse("content://com.meizu.flyme.openidsdk/");
        Cursor r0 = ZeusProviderTransform.query(r10.getContentResolver(), r2, null, null, new String[]{Oaid.KEY_OAID_ID}, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r0 != null) goto L26;
        if (r0 == null) goto L7;
        r0.close();
    L7:
        return null;
    L26:
        OaidApi.Result r1 = new OaidApi.Result();     // Catch: Throwable -> L12
        r1.oaid = getOaid(r0);     // Catch: Throwable -> L12
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return r1;
    L12:
        th = th;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L20
        if (r0 == null) goto L19;
        r0.close();
    L19:
        return null;
    L20:
        th = move-exception;
        if (r0 == null) goto L23;
        r0.close();
    L23:
        throw th;
    L14:
        th = th;
        r0 = null;
        goto L24
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.isSupport.get(new Object[]{r5}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }
}
