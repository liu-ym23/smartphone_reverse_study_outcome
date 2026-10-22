package com.ss.android.lark.framework.assembly.rust.bridge;

import android.app.Application;
import com.bytedance.lark.office_sdk_im_android.OfficeSdkFeedCardProvider;
import com.bytedance.lark.office_sdk_im_android.SupportFeedType;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkImError;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkImResult;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkVerifyFeedResponse;
import com.ss.android.lark.log.Log;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OfficeSdkFeedCardProviderImpl implements OfficeSdkFeedCardProvider {
    public static final /* synthetic */ int b = 0;
    public final Application a;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: renamed from: preloadByFeed-4PLdz1A, reason: not valid java name */
    public final byte[] m692preloadByFeed4PLdz1A(long r1, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        return new byte[0];
    }

    /* JADX INFO: renamed from: saveDataForSyncFeed-4PLdz1A, reason: not valid java name */
    public final byte[] m693saveDataForSyncFeed4PLdz1A(long r1, byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        return new byte[0];
    }

    public static byte[] a() {
        return new OfficeSdkImResult.Builder().error(new OfficeSdkImError.Builder().type(OfficeSdkImError.Type.OFFICE_SDK_IM_ERROR_BUSINESS_ERROR).build()).build().encode();
    }

    public final qtb.b b() {
        return (qtb.b) k.a(this.a, qtb.b.class);
    L4:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "spiByDwarf(IOfficeSDKFeedApi) failed", th);
        return null;
    }

    public final SupportFeedType supportFeedType() {
        return SupportFeedType.DoubaoCustom;
    }

    public OfficeSdkFeedCardProviderImpl(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        this.a = r2;
    }

    /* JADX INFO: renamed from: packFeedChannel-4PLdz1A, reason: not valid java name */
    public final byte[] m690packFeedChannel4PLdz1A(long r3, byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "payload");
        byte[] r4 = (byte[]) BuildersKt.runBlocking(Dispatchers.getIO(), new OfficeSdkFeedCardProviderImpl$packFeedChannel$result$1(this, r5, null));     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        return r4;
    L6:
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedChannel result null, api not ready");     // Catch: Throwable -> L8
    L11:
        return a();
    L8:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedChannel async failed", th);
        goto L11
    }

    /* JADX INFO: renamed from: packFeedPreview-4PLdz1A, reason: not valid java name */
    public final byte[] m691packFeedPreview4PLdz1A(long r3, byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "payload");
        byte[] r4 = (byte[]) BuildersKt.runBlocking(Dispatchers.getIO(), new OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1(this, r5, null));     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        return r4;
    L6:
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedPreview result null, api not ready");     // Catch: Throwable -> L8
    L11:
        return a();
    L8:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "packFeedPreview async failed", th);
        goto L11
    }

    /* JADX INFO: renamed from: verifyFeedData-4PLdz1A, reason: not valid java name */
    public final byte[] m694verifyFeedData4PLdz1A(long r4, byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "payload");
        qtb.b r5 = b();     // Catch: Throwable -> L9
        if (r5 != null) goto L7;
        Log.e("OfficeSdkFeedCardProviderImpl", "verifyFeedData api not ready (IOfficeSDKFeedApi is null)");     // Catch: Throwable -> L9
        return a();
    L7:
        BuildersKt.runBlocking(Dispatchers.getIO(), new OfficeSdkFeedCardProviderImpl$verifyFeedData$1(r5, r6, null));     // Catch: Throwable -> L9
        byte[] r7 = new OfficeSdkVerifyFeedResponse.Builder().build().encode();     // Catch: Throwable -> L9
        OfficeSdkImResult.Builder r8 = new OfficeSdkImResult.Builder();     // Catch: Throwable -> L9
        ByteString.a r0 = ByteString.Companion;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L9
        return r8.success_payload(ByteString.a.e(r0, r7)).build().encode();
    L9:
        th = move-exception;
        Log.e("OfficeSdkFeedCardProviderImpl", "verifyFeedData async failed", th);
        return a();
    }
}
