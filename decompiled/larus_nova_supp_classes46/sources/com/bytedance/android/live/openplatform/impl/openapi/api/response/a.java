package com.bytedance.android.live.openplatform.impl.openapi.api.response;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.open.api.GetFollowAnchorStatusResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a;", "", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "followInfo", "Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "a", "()Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "setFollowInfo", "(Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("follow_info")
    protected C0183a followInfo;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.openapi.api.response.a$a, reason: collision with other inner class name */
    @ProtoMessage("webcast.open.api.GetFollowAnchorStatusResponse.Data.FollowInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/openapi/api/response/a$a;", "", "", "hasFollow", "Z", "a", "()Z", "setHasFollow", "(Z)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0183a implements h {

        @SerializedName("has_followed")
        protected boolean hasFollow;

        public C0183a() {
        }

        public C0183a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.hasFollow = am3.h.a(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
        }

        public final boolean a() {
            return this.hasFollow;
        }
    }

    public a() {
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.followInfo = new C0183a(r5);
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
    }

    public final C0183a a() {
        return this.followInfo;
    }
}
