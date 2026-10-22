package com.ss.android.lark.integrator.ccm.core.image;

import android.os.SystemClock;
import ay4.d;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.bytedance.ee.bear.drive.sdk.service.g;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.image.entity.DocImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends ResourceImageDataFetcher<DocImage> {

    /* JADX INFO: renamed from: com.ss.android.lark.integrator.ccm.core.image.a$a, reason: collision with other inner class name */
    public static final class C0114a {
    }

    static {
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public final String getLogTag() {
        return "DocImageDataFetcher";
    }

    public a(DocImage r1) {
        super(r1);
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public final InputStream getResourceStream(DocImage r30) {
        final DocImage r0 = r30;
        if (r0 != null) goto L5;
        tt5.a.d("DocImageDataFetcher", "doc image is null");
    L25:
        return null;
    L5:
        long r2 = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullParameter(r0, "docImage");
        StringBuilder r4 = new StringBuilder();
        int r5 = ay4.c.a;
        r4.append(ay4.c.a.a(Biz.DOCS, null, 14).getAbsolutePath());
        String r6 = File.separator;
        r4.append(r6);
        r4.append("temp");
        r4.append(r6);
        r4.append(r0.getToken());
        String r7 = r4.toString();
        final Resource r8 = new Resource(r0.getToken(), r7, Boolean.FALSE);
        final CountDownLatch r9 = new CountDownLatch(1);
        g r14 = ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDriveSdkWrapper().d0();
        DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r13 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r25 = DriveBizScene.DriveBizScene_UNKNOWN;
        String r10 = r0.getToken();
        User r11 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r11 == null) goto L8;
        String r12 = r11.userId;
    L9:
        if (r12 != null) goto L11;
        r12 = "";
    L11:
        r14.g(new DownloadRequestInfo(r7, r10, r12, "im", 0, "", r13, "", 0, false, "", 2, new DocImageDataFetcher$getDocImage$1(r9, r8, r0), null, false, null, null, r25, null));
        r9.await(20, TimeUnit.SECONDS);
        long r15 = SystemClock.elapsedRealtime() - r2;
        String r1 = r8.b;
        r0.setErrorResult(r8.e);
        Trace r3 = r8.d;
        if (r3 == null) goto L16;
        List r16 = r3.spans;
        if (r16 == null) goto L16;
        r16.add(new Trace.Span.Builder().name("sdk_cost").duration_millis(Long.valueOf(r15)).build());
        Trace r17 = new Trace.Builder().spans(r16).build();
    L17:
        r0.setTrace(r17);
        if (r1 != null) goto L20;
    L23:
        boolean r18 = true;
    L24:
        if (r18 == true) goto L25;
        return d.a().i(r1).newInputStream();
    L20:
        if (r1.length() == 0) goto L23;
        r18 = false;
    L16:
        r17 = null;
        goto L17
    L8:
        r12 = null;
        goto L9
    }
}
