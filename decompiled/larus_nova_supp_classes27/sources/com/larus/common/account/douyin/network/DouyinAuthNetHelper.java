package com.larus.common.account.douyin.network;

import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.google.gson.annotations.SerializedName;
import com.larus.common.account.douyin.f;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DouyinAuthNetHelper {
    public static final DouyinAuthNetHelper a = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/larus/common/account/douyin/network/DouyinAuthNetHelper$AuthExchangeTokenResult;", "", "isExchanged", "", "<init>", "(Z)V", "()Z", "setExchanged", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("is_exchanged")
        private boolean isExchanged;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.isExchanged == ((a) r4).isExchanged) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.isExchanged == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "AuthExchangeTokenResult(isExchanged=" + this.isExchanged + ')';
        }

        public a() {
            this.isExchanged = false;
        }

        public final boolean a() {
            return this.isExchanged;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/larus/common/account/douyin/network/DouyinAuthNetHelper$CheckAuthStatusResult;", "", "isAuthorized", "", "<init>", "(Z)V", "()Z", "setAuthorized", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "douyinlogin_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("is_authorized")
        private boolean isAuthorized;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.isAuthorized == ((b) r4).isAuthorized) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.isAuthorized == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "CheckAuthStatusResult(isAuthorized=" + this.isAuthorized + ')';
        }

        public b() {
            this.isAuthorized = false;
        }

        public final boolean a() {
            return this.isAuthorized;
        }
    }

    public interface c {
        void onResult(boolean r1);
    }

    static {
        a = new DouyinAuthNetHelper();
    }

    public DouyinAuthNetHelper() {
    }

    public static void a(Authorization.Response r6, f.a r7) {
        Intrinsics.checkNotNullParameter(r6, "resp");
        if (r6.isSuccess() == true) goto L6;
        r7.onResult(false);
        return;
    L6:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DouyinAuthNetHelper$authExchangeToken$1(r6, r7, null), 2, null);
    }

    public final Object b(String r17, String r18, String r110, Continuation<? super Boolean> r20) {
        if ((r20 instanceof DouyinAuthNetHelper$checkAuthStatus$1) == false) goto L7;
        DouyinAuthNetHelper$checkAuthStatus$1 r1 = (DouyinAuthNetHelper$checkAuthStatus$1) r20;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        DouyinAuthNetHelper$checkAuthStatus$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        boolean r15 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        y r5 = (com.larus.network.http.a) r0;
        if ((r5 instanceof y) == false) goto L24;
        b r6 = (b) ((com.larus.network.http.a) r5).b;
        if (r6 == null) goto L24;
        if (r6.a() != true) goto L24;
    L26:
        return Boxing.boxBoolean(r15);
    L24:
        r15 = false;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        JSONObject r7 = new JSONObject();
        r7.put("client_key", r17);
        r7.put("scope", r18);
        r7.put("state", r110);
        Unit r8 = Unit.INSTANCE;
        r13.label = 1;
        r0 = HttpExtKt.k("Basic", b.class, "/alice/bot/check_bot_auth", r7, null, null, false, null, null, null, r13, 1008);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new DouyinAuthNetHelper$checkAuthStatus$1(this, r20);
        goto L8
    }
}
