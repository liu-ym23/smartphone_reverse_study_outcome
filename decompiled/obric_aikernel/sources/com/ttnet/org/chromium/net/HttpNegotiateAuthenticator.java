package com.ttnet.org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
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
    class GetAccountsCallback implements AccountManagerCallback<Account[]> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetAccountsCallback(HttpNegotiateAuthenticator r10, RequestData r11) {
            this.this$0 = r10;
            this.mRequestData = r11;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Account[]> r10) {
            Account[] r11 = r10.getResult();     // Catch: Throwable -> L12
            if (r11.length != 0) goto L9;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L9:
            if (r11.length <= 1) goto L17;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[]{Integer.valueOf(r11.length)});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, NetError.ERR_MISSING_AUTH_CREDENTIALS, null);
            return;
        L17:
            return;
        L12:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[]{e});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, -9, null);
        }
    }

    @VisibleForTesting
    class GetTokenCallback implements AccountManagerCallback<Bundle> {
        private final RequestData mRequestData;
        final /* synthetic */ HttpNegotiateAuthenticator this$0;

        public GetTokenCallback(HttpNegotiateAuthenticator r10, RequestData r11) {
            this.this$0 = r10;
            this.mRequestData = r11;
        }

        static /* synthetic */ RequestData access$000(GetTokenCallback r10) {
            return r10.mRequestData;
        }

        @Override // android.accounts.AccountManagerCallback
        public void run(AccountManagerFuture<Bundle> r10) {
            Bundle r11 = r10.getResult();     // Catch: Throwable -> L8
            if (r11.containsKey("intent") == false) goto L6;
            final Context r12 = ContextUtils.getApplicationContext();
            r12.registerReceiver(new AnonymousClass1(this, r12), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
            return;
        L6:
            HttpNegotiateAuthenticator.access$100(this.this$0, r11, this.mRequestData);
            return;
        L8:
            e = move-exception;
            Log.w(HttpNegotiateAuthenticator.TAG, "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[]{e});
            HttpNegotiateAuthenticatorJni.get().setResult(this.mRequestData.nativeResultObject, this.this$0, -9, null);
        }
    }

    interface Natives {
        void setResult(long r10, HttpNegotiateAuthenticator r11, int r12, String r13);
    }

    static class RequestData {
        public Account account;
        public AccountManager accountManager;
        public String authTokenType;
        public long nativeResultObject;
        public Bundle options;

        RequestData() {
        }
    }

    static {
    }

    protected HttpNegotiateAuthenticator(String r10) {
        this.mAccountType = r10;
    }

    static /* synthetic */ void access$100(HttpNegotiateAuthenticator r10, Bundle r11, RequestData r12) {
        r10.processResult(r11, r12);
    }

    @CalledByNative
    @VisibleForTesting
    static HttpNegotiateAuthenticator create(String r10) {
        return new HttpNegotiateAuthenticator(r10);
    }

    private void processResult(Bundle r10, RequestData r11) {
        this.mSpnegoContext = r10.getBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT);
        int r12 = -9;
        switch(r10.getInt(HttpNegotiateConstants.KEY_SPNEGO_RESULT, 1)) {
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
        r12 = NetError.ERR_MALFORMED_IDENTITY;
        goto L14
    L6:
        r12 = NetError.ERR_UNDOCUMENTED_SECURITY_LIBRARY_STATUS;
        goto L14
    L7:
        r12 = NetError.ERR_MISSING_AUTH_CREDENTIALS;
        goto L14
    L8:
        r12 = NetError.ERR_UNSUPPORTED_AUTH_SCHEME;
        goto L14
    L9:
        r12 = NetError.ERR_INVALID_AUTH_CREDENTIALS;
        goto L14
    L10:
        r12 = NetError.ERR_INVALID_RESPONSE;
        goto L14
    L11:
        r12 = NetError.ERR_UNEXPECTED_SECURITY_LIBRARY_STATUS;
        goto L14
    L12:
        r12 = -3;
        goto L14
    L13:
        r12 = 0;
    L14:
        Natives r13 = HttpNegotiateAuthenticatorJni.get();
        long r14 = r11.nativeResultObject;
        r13.setResult(r14, this, r12, r10.getString("authtoken"));
    }

    private void requestTokenWithActivity(Context r10, Activity r11, RequestData r12, String[] r13) {
    }

    private void requestTokenWithoutActivity(Context r10, RequestData r11, String[] r12) {
    }

    @CalledByNative
    @VisibleForTesting
    void getNextAuthToken(long r10, String r11, String r12, boolean r13) {
        Context r14 = ContextUtils.getApplicationContext();
        RequestData r15 = new RequestData();
        r15.authTokenType = HttpNegotiateConstants.SPNEGO_TOKEN_TYPE_BASE + r11;
        r15.accountManager = AccountManager.get(r14);
        r15.nativeResultObject = r10;
        String[] r16 = {HttpNegotiateConstants.SPNEGO_FEATURE};
        Bundle r17 = new Bundle();
        r15.options = r17;
        if (r12 == null) goto L5;
        r17.putString(HttpNegotiateConstants.KEY_INCOMING_AUTH_TOKEN, r12);
    L5:
        Bundle r18 = this.mSpnegoContext;
        if (r18 == null) goto L8;
        r15.options.putBundle(HttpNegotiateConstants.KEY_SPNEGO_CONTEXT, r18);
    L8:
        r15.options.putBoolean(HttpNegotiateConstants.KEY_CAN_DELEGATE, r13);
        Activity r19 = ApplicationStatus.getLastTrackedFocusedActivity();
        if (r19 != null) goto L11;
        requestTokenWithoutActivity(r14, r15, r16);
        return;
    L11:
        requestTokenWithActivity(r14, r19, r15, r16);
    }

    @VisibleForTesting
    boolean lacksPermission(Context r10, String r11, boolean r12) {
        if (r12 == false) goto L8;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        return false;
    L8:
        if (r10.checkPermission(r11, Process.myPid(), Process.myUid()) == 0) goto L11;
        return true;
    L11:
        return false;
    }
}
