package com.ss.android.lark.passport.cookie;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "UserNotFound", "CredentialUnavailable", "DomainUnavailable", "Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError$CredentialUnavailable;", "Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError$DomainUnavailable;", "Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError$UserNotFound;", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public abstract class PassportCookieSyncError extends Exception {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError$CredentialUnavailable;", "Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class CredentialUnavailable extends PassportCookieSyncError {
        public static final CredentialUnavailable INSTANCE = null;

        static {
            INSTANCE = new CredentialUnavailable();
        }

        private CredentialUnavailable() {
            super("credential unavailable", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError$DomainUnavailable;", "Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class DomainUnavailable extends PassportCookieSyncError {
        public static final DomainUnavailable INSTANCE = null;

        static {
            INSTANCE = new DomainUnavailable();
        }

        private DomainUnavailable() {
            super("domain unavailable", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError$UserNotFound;", "Lcom/ss/android/lark/passport/cookie/PassportCookieSyncError;", "<init>", "()V", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class UserNotFound extends PassportCookieSyncError {
        public static final UserNotFound INSTANCE = null;

        static {
            INSTANCE = new UserNotFound();
        }

        private UserNotFound() {
            super("user not found", null);
        }
    }

    public PassportCookieSyncError(String r1, DefaultConstructorMarker r2) {
        super(r1);
    }
}
