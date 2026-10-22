package com.ss.android.lark.chameleonv2.lkapi.resource.target;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.ResourceFile;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadRequest;
import com.bytedance.lark.pb.im.v1.CancelAsyncUploadResponse;
import com.bytedance.lark.pb.im.v1.PushUploadResourceStatus;
import com.bytedance.lark.pb.im.v1.UploadResourceRequest;
import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Internal$ResourceUploadRequest;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Ipc$ResourceUploadProgressPayload;
import com.ss.android.lark.chameleonv2.lkapi.resource.IResource$Ipc$ResourceUploadProgressPayloadStatus;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import e0c.k;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class IMResource {
    public final IChameleonHandlerContext a;
    public Disposable b;

    public static final class a {
    }

    static {
    }

    public static l c() {
        Application r0 = LarkContext.getApplication();
        if (r0 == null) goto L7;
        q1b.a r1 = (q1b.a) k.a(r0, q1b.a.class);
        if (r1 == null) goto L7;
        return r1.g();
    L7:
        return null;
    }

    public IMResource(IChameleonHandlerContext r3) {
        this.a = r3;
        j.e("LK_API_TAG_IM_Resource", "subscribe resource push");
        l r4 = c();
        if (r4 == null) goto L5;
        this.b = t.g(r4.i(Command.PUSH_UPLOAD_RESOURCE_STATUS, PushUploadResourceStatus.ADAPTER), new IMResource$subscribeResourcePush$1$1(this), IMResource$subscribeResourcePush$1$2.INSTANCE);
        return;
    L5:
        j.b("LK_API_TAG_IM_Resource", "rust client invalid");
    }

    public static void b(final j1b.a r11, final Callback r12) {
        Intrinsics.checkNotNullParameter(r11, "req");
        Intrinsics.checkNotNullParameter(r12, "callback");
        CancelAsyncUploadRequest.Builder r2 = new CancelAsyncUploadRequest.Builder();
        ArrayList r0 = new ArrayList(1);
        r11.getClass();
        r0.add(null);
        r2.upload_ids = r0;
        l r1 = c();
        if (r1 == null) goto L6;
        Command r4 = Command.CANCEL_ASYNC_UPLOAD;
        if (t.a(r1.h(new d(r2, CancelAsyncUploadResponse.ADAPTER, r4, null, null, null, null, 248)).a(), new IMResource$cancelUpload$2$1(r11, r12), new IMResource$cancelUpload$2$2(r12), new IMResource$cancelUpload$2$3(r12)) == null) goto L6;
        return;
    L6:
        r12.error(new LKAPIError(-1, "rust client invalid"));
        j.b("LK_API_TAG_IM_Resource", "rust client invalid");
        Unit r13 = Unit.INSTANCE;
    }

    public final void d(IResource$Internal$ResourceUploadRequest r19, String r20, final Callback r21) {
        Intrinsics.checkNotNullParameter(r19, "req");
        Intrinsics.checkNotNullParameter(r20, "uuid");
        Intrinsics.checkNotNullParameter(r21, "callback");
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L5;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L21;
        IChameleonHandlerContext r0 = this.a;
        if (r0 == null) goto L16;
        Context r1 = r0.getCmlContext();
        if (r1 == null) goto L16;
    L18:
        new Handler(Looper.getMainLooper()).post(new b(r1));
    L19:
        r21.error(new LKAPIError(-1, "rust client invalid"));
        return;
    L16:
        r1 = LarkContext.getApplication();
        if (r1 == null) goto L19;
    L21:
        l r7 = c();
        if (r7 == null) goto L25;
        ResourceFile.Builder r8 = new ResourceFile.Builder();
        r8.file_type = ResourceFile.FileType.IMAGE;
        r8.file_path = VFSFiles.b.i(r20).toString();
        UploadResourceRequest.Builder r10 = new UploadResourceRequest.Builder();
        r10.upload_id = r19.getUploadId();
        r10.file(r8.build());
        if (t.a(r7.h(new d(r10, UploadResourceResponse.ADAPTER, Command.UPLOAD_RESOURCE, null, null, null, null, 248)).a(), new IMResource$upload$1$1(r21), new IMResource$upload$1$2(r21), new IMResource$upload$1$3(r21)) == null) goto L25;
        return;
    L25:
        r21.error(new LKAPIError(-1, "rust client invalid"));
        j.b("LK_API_TAG_IM_Resource", "rust client invalid");
        Unit r3 = Unit.INSTANCE;
        return;
    L5:
        IOfficeSDKBizConfigProvider r4 = OfficeSDKManager.getBizConfigProvider();
        if (r4 == null) goto L8;
        r2 = r4.isEnabled(IOfficeSDKBizConfigProvider.Biz.IM);
    L9:
        j.e("LK_API_TAG_IM_Resource", "isIMEnabled=" + r2);
        goto L11
    L8:
        r2 = false;
        goto L9
    }

    public static final void a(IMResource r7, String r8, Number r9, IResource$Ipc$ResourceUploadProgressPayloadStatus r10, String r11) {
        IChameleonHandlerContext r12 = r7.a;
        if (r12 == null) goto L5;
        r12.sendEvent(IResource$Ipc$EventType.RESOURCE_UPLOAD_PUSH.getValue(), new IResource$Ipc$ResourceUploadProgressPayload(r9, r8, BuildConfig.FLAVOR, r10.getValue(), r11));
        return;
    L5:
        j.b("LK_API_TAG_IM_Resource", "chameleon context invalid");
    }
}
