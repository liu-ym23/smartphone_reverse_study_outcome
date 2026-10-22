package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.container.dialog.BaseDialogFragment;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setLive")
public final class f2 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {
    public final HybridDialog a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/f2$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "args", "Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "a", "()Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "setArgs", "(Lcom/bytedance/android/annie/bridge/method/f2$a$a;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("args")
        private C0061a args;

        @SerializedName("type")
        private String type;

        /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.f2$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/f2$a$a;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "width", "I", "e", "()I", "setWidth", "(I)V", "height", "b", "setHeight", "radius", "c", "setRadius", "closeByMask", "a", "setCloseByMask", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final class C0061a {

            @SerializedName("close_by_mask")
            private int closeByMask;

            @SerializedName("height")
            private int height;

            @SerializedName("radius")
            private int radius;

            @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
            private String url;

            @SerializedName("width")
            private int width;

            public C0061a() {
            }

            public final int a() {
                return this.closeByMask;
            }

            public final int b() {
                return this.height;
            }

            public final int c() {
                return this.radius;
            }

            public final String d() {
                return this.url;
            }

            public final int e() {
                return this.width;
            }
        }

        public a() {
        }

        public final C0061a a() {
            return this.args;
        }

        public final String getType() {
            return this.type;
        }
    }

    public f2(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridDialog r11 = (HybridDialog) r10.c(HybridDialog.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public f2(HybridDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.a = r10;
    }

    public final Object invoke(Object r10, CallContext r11) {
        a r12 = (a) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.getType();
        if (Intrinsics.areEqual(r13, "webview_popup") == false) goto L13;
        a.C0061a r14 = r12.a();
        if (r14 == null) goto L23;
        HybridDialog r15 = this.a;
        if ((r15 instanceof BaseDialogFragment) == false) goto L9;
        BaseDialogFragment r16 = (BaseDialogFragment) r15;
    L10:
        if (r16 == null) goto L23;
        r16.la0(r14.d(), r14.e(), r14.b(), r14.c(), r14.a(), BaseHybridParamVoNew.HybridType.H5);
        goto L23
    L9:
        r16 = null;
    L23:
        return null;
    L13:
        if (Intrinsics.areEqual(r13, "lynxview_popup") == false) goto L22;
        a.C0061a r17 = r12.a();
        if (r17 == null) goto L23;
        HybridDialog r18 = this.a;
        if ((r18 instanceof BaseDialogFragment) == false) goto L19;
        BaseDialogFragment r19 = (BaseDialogFragment) r18;
    L20:
        if (r19 == null) goto L23;
        r19.la0(r17.d(), r17.e(), r17.b(), r17.c(), r17.a(), BaseHybridParamVoNew.HybridType.LYNX);
        goto L23
    L19:
        r19 = null;
        goto L20
    L22:
        terminate();
        goto L23
    }
}
