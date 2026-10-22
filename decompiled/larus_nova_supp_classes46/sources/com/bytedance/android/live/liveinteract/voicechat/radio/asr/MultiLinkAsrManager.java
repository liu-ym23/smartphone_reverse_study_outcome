package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.content.Context;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class MultiLinkAsrManager {
    public final String a;
    public k b;
    public final Lazy c;
    public final Context d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/asr/MultiLinkAsrManager$a;", "", "", "appId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "appToken", "b", "e", "cluster", "c", "f", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("appId")
        private String appId;

        @SerializedName("appToken")
        private String appToken;

        @SerializedName("cluster")
        private String cluster;

        public a() {
        }

        public final String a() {
            return this.appId;
        }

        public final String b() {
            return this.appToken;
        }

        public final String c() {
            return this.cluster;
        }

        public final void d(String r1) {
            this.appId = r1;
        }

        public final void e(String r1) {
            this.appToken = r1;
        }

        public final void f(String r1) {
            this.cluster = r1;
        }
    }

    public MultiLinkAsrManager(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.d = r2;
        this.a = "asrStateChange";
        this.c = LazyKt.lazy(new MultiLinkAsrManager$transferStartRunnable$2(this));
    }

    public static final void a(MultiLinkAsrManager r1, AsrStateChangeEvent.Type r2, String r3, IJsBridgeManager r4) {
        if (r4 == null) goto L4;
        String r5 = r1.a;
        AsrStateChangeEvent r0 = new AsrStateChangeEvent();
        r0.b(r2);
        r0.a(r3);
        Unit r6 = Unit.INSTANCE;
        r4.sendJsEvent(r5, r0.c());
        return;
    L4:
        r1.getClass();
    }
}
