package com.ss.android.lark.integrator.im.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.ObjectEntity;
import com.ss.android.lark.pb.security_event.OperationType;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@OfficeSDKUserScope
public final class h implements bza.a {
    @Inject
    public h() {
    }

    public final void a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "imageKey");
        owa.a.a().getClass();
        Intrinsics.checkNotNullParameter(r9, TabAppInfo.IMAGE_JSON_KEY);
        com.ss.android.lark.auditsdk.wrapper.b r0 = com.ss.android.lark.auditsdk.wrapper.b.d.a;
        int r1 = com.ss.android.lark.auditsdk.wrapper.a.a;
        Intrinsics.checkNotNullParameter(r9, "originKey");
        if (r9.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L18;
    L16:
        ObjectEntity r10 = new ObjectEntity.Builder().Type(EntityType.EntityImage).Value(r9).build();
        ArrayList r2 = new ArrayList();
        r2.add(r10);
        r0.a(new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleIMImageAndVideo).Operation(OperationType.OperationDownload).Objects(r2));
        return;
    L18:
        String r4 = ExceptionsKt.stackTraceToString(new Throwable());     // Catch: Exception -> L14
        Log.i("AuditEventCreator", "createImageDownloadAuditEvent, originKey is empty. stackTrace:" + r4 + ' ');     // Catch: Exception -> L14
        nwa.b r5 = nwa.b.a.a;     // Catch: Exception -> L14
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L14
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L14
        r6.put("missScene", "im_image_download_miss_file_key");     // Catch: JSONException -> L10 Exception -> L14
        r7.put("stackTrace", r4);     // Catch: JSONException -> L10 Exception -> L14
    L12:
        r5.c("scs_security_audit_parameter_missing", r6, new JSONObject(), r7);     // Catch: Exception -> L14
        goto L16
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e("AuditEventCreator", "createImageDownloadAuditEvent, monitorAuditParameterMissing error, e.message: " + e.getMessage());
        goto L16
    L5:
        r3 = false;
        goto L6
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "mediaKey");
        owa.a.a().getClass();
        Intrinsics.checkNotNullParameter(r5, TabAppInfo.IMAGE_JSON_KEY);
        com.ss.android.lark.auditsdk.wrapper.b r0 = com.ss.android.lark.auditsdk.wrapper.b.d.a;
        int r1 = com.ss.android.lark.auditsdk.wrapper.a.a;
        Intrinsics.checkNotNullParameter(r5, "originKey");
        ObjectEntity r6 = new ObjectEntity.Builder().Type(EntityType.EntityVideoIM).Value(r5).build();
        ArrayList r2 = new ArrayList();
        r2.add(r6);
        r0.a(new Event.Builder().TimeStamp(String.valueOf(System.currentTimeMillis())).Module(ModuleType.ModuleIMImageAndVideo).Operation(OperationType.OperationDownload).Objects(r2));
    }
}
