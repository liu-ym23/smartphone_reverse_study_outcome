package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class HttpNegotiateAuthenticator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "net_auth";
    private final String mAccountType;
    private Bundle mSpnegoContext;

    @VisibleForTesting
    public class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetAccountsCallback(HttpNegotiateAuthenticator r8, RequestData r10) {
            this.this$0 = r8;
            this.mRequestData = r10;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> r13) {
            Account[] r14 = r13.getResult();     // Catch: Throwable -> L18
            if (r14.length != 0) goto L9;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            this.this$0.nativeSetResult(this.mRequestData.nativeResultObject, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L9:
            if (r14.length <= 1) goto L13;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r14.length)});
            this.this$0.nativeSetResult(this.mRequestData.nativeResultObject, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L13:
            if (this.this$0.lacksPermission(ContextUtils.getApplicationContext(), "android.permission.USE_CREDENTIALS", true) == false) goto L16;
            Log.e(HttpNegotiateAuthenticator.TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
            this.this$0.nativeSetResult(this.mRequestData.nativeResultObject, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
            return;
        L16:
            RequestData r8 = this.mRequestData;
            Account r10 = r14[0];
            r8.account = r10;
            r8.accountManager.getAuthToken(r10, r8.authTokenType, r8.options, true, new GetTokenCallback(this.this$0, r8), new Handler(ThreadUtils.getUiThreadLooper()));
            return;
        L18:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[]{e});
            this.this$0.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
        }
    }

    @VisibleForTesting
    public class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetTokenCallback(HttpNegotiateAuthenticator r8, RequestData r10) {
            this.this$0 = r8;
            this.mRequestData = r10;
        }

        public static /* synthetic */ RequestData access$000(GetTokenCallback r8) {
            return r8.mRequestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> r8) {
            Bundle r10 = r8.getResult();     // Catch: Throwable -> L8
            if (r10.containsKey("intent") == false) goto L6;
            final Context r11 = ContextUtils.getApplicationContext();
            r11.registerReceiver(new AnonymousClass1(this, r11), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            return;
        L6:
            HttpNegotiateAuthenticator.access$100(this.this$0, r10, this.mRequestData);
            return;
        L8:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[]{e});
            this.this$0.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
        }
    }

    public static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        public RequestData() {
        }
    }

    public HttpNegotiateAuthenticator(String r8) {
        this.mAccountType = r8;
    }

    public static /* synthetic */ void access$100(HttpNegotiateAuthenticator r8, Bundle r10, RequestData r11) {
        r8.processResult(r10, r11);
    }

    @VisibleForTesting
    @CalledByNative
    public static HttpNegotiateAuthenticator create(String r8) {
        return new HttpNegotiateAuthenticator(r8);
    }

    private void processResult(Bundle r8, RequestData r10) {
        this.mSpnegoContext = r8.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        int r11 = -9;
        switch(r8.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
            case 0: goto L13;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L14;
        };
    L5:
        r11 = NetError.ERR_MALFORMED_IDENTITY;
        goto L14
    L6:
        r11 = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
        goto L14
    L7:
        r11 = NetError.ERR_MISSING_AUTH_CREDENTIALS;
        goto L14
    L8:
        r11 = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
        goto L14
    L9:
        r11 = NetError.ERR_INVALID_AUTH_CREDENTIALS;
        goto L14
    L10:
        r11 = NetError.ERR_INVALID_RESPONSE;
        goto L14
    L11:
        r11 = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
        goto L14
    L12:
        r11 = -3;
        goto L14
    L13:
        r11 = 0;
    L14:
        nativeSetResult(r10.nativeResultObject, r11, r8.getString("authtoken"));
    }

    private void requestTokenWithActivity(Context r10, Activity r11, RequestData r12, String[] r13) {
        if (lacksPermission(r10, "android.permission.GET_ACCOUNTS", false) == false) goto L6;
        Log.e(TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: %s permission not granted. Aborting authentication", new Object[]{"android.permission.GET_ACCOUNTS"});
        nativeSetResult(r12.nativeResultObject, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
        return;
    L6:
        r12.accountManager.getAuthTokenByFeatures(this.mAccountType, r12.authTokenType, r13, r11, null, r12.options, new GetTokenCallback(this, r12), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    private void requestTokenWithoutActivity(Context r8, RequestData r10, String[] r11) {
        if (lacksPermission(r8, "android.permission.GET_ACCOUNTS", true) == false) goto L6;
        Log.e(TAG, "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: GET_ACCOUNTS permission not granted. Aborting authentication.", new Object[0]);
        nativeSetResult(r10.nativeResultObject, NetError.ERR_MISCONFIGURED_AUTH_ENVIRONMENT, null);
        return;
    L6:
        r10.accountManager.getAccountsByTypeAndFeatures(this.mAccountType, r11, new GetAccountsCallback(this, r10), new Handler(ThreadUtils.getUiThreadLooper()));
    }

    @VisibleForTesting
    @CalledByNative
    public void getNextAuthToken(long r8, String r10, String r11, boolean r12) {
        Context r13 = ContextUtils.getApplicationContext();
        RequestData r14 = new RequestData();
        r14.authTokenType = defpackage.b.c(HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE, r10);
        r14.accountManager = AccountManager.get(r13);
        r14.nativeResultObject = r8;
        String[] r15 = {HttpNegotiateConstants.SPNEGO_FEATURE};
        Bundle r16 = new Bundle();
        r14.options = r16;
        if (r11 == null) goto L5;
        r16.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, r11);
    L5:
        Bundle r17 = this.mSpnegoContext;
        if (r17 == null) goto L8;
        r14.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, r17);
    L8:
        r14.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, r12);
        Activity r18 = ApplicationStatus.getLastTrackedFocusedActivity();
        if (r18 != null) goto L11;
        requestTokenWithoutActivity(r13, r14, r15);
        return;
    L11:
        requestTokenWithActivity(r13, r18, r14, r15);
    }

    @VisibleForTesting
    public boolean lacksPermission(Context r8, String r10, boolean r11) {
        if (r11 == false) goto L6;
        return false;
    L6:
        if (r8.checkPermission(r10, Process.myPid(), Process.myUid()) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    @VisibleForTesting
    public native void nativeSetResult(long r8, int r10, String r11);
}
