package com.obric.aikernel.res.legacy;

import android.content.Context;
import com.bytedance.crypto.utils.CryptoConst;
import com.google.gson.JsonObject;
import com.obric.aikernel.runtime.utils.c;
import com.obric.aikernel.runtime.utils.d;
import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JC\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/res/legacy/Adapter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "httpClient", "Lcom/obric/aikernel/res/legacy/TTNetHttpClientImpl;", "downloadFile", "", "url", "", "fileName", CryptoConst.ALGORITHM_MD5, "savePath", "retryCount", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", Ext.KEY_REQUEST, "", TrackerImpl.PARAMS, "Lcom/google/gson/JsonObject;", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0261a f6052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f6053b;

    /* JADX INFO: renamed from: com.obric.aikernel.res.legacy.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aikernel/res/legacy/Adapter$Companion;", "", "()V", "DOWNLOADER_ID", "", "TAG", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0261a {
        private C0261a() {
        }

        public /* synthetic */ C0261a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f6052a = new C0261a(null);
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f6053b = new b(r4);
    }

    public final byte[] a(String r8, JsonObject r9) {
        Intrinsics.checkNotNullParameter(r8, "url");
        Intrinsics.checkNotNullParameter(r9, TrackerImpl.PARAMS);
        c.a.a((c) ZeusTransformUtils.preCheckCast(d.f6216a, c.class, "com.obric.memorydata.plugin"), "Adapter", "request url is " + r8 + ", params is " + r9, 0, 4, null);
        b r7 = this.f6053b;
        String r10 = r9.toString();
        Intrinsics.checkNotNullExpressionValue(r10, "params.toString()");
        byte[] r11 = r10.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).getBytes(charset)");
        return r7.a(r8, r11);
    }
}
