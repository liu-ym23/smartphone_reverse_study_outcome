package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004\u0019\u0007\u000e\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel;", "Lw20/aa;", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "a", "(Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "getData", "()Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "c", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SearchFriendResultModel implements aa {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;
        public static final /* synthetic */ Code[] a = null;
        private final int value;

        static {
            Code r1 = new Code("Success", 0, 1);
            Success = r1;
            Code r2 = new Code("Failed", 1, 0);
            Failed = r2;
            Code r3 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r3;
            Code r4 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r4;
            a = new Code[]{r1, r2, r3, r4};
        }

        public static Code valueOf(String r1) {
            return (Code) r27.a.a(Code.class, r1);
        }

        public static Code[] values() {
            return (Code[]) a.clone();
        }

        @Override // w20.z9
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$a;", "", "", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$c;", "users", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "a", "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("users")
        private List<c> users;

        public a() {
        }

        public final void a(List<c> r1) {
            this.users = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "", "", "location", "Ljava/lang/Number;", "getLocation", "()Ljava/lang/Number;", "b", "(Ljava/lang/Number;)V", "length", "getLength", "a", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b {

        @SerializedName("length")
        private Number length;

        @SerializedName("location")
        private Number location;

        public b() {
        }

        public final void a(Number r1) {
            this.length = r1;
        }

        public final void b(Number r1) {
            this.location = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$c;", "", "", "nickname", "Ljava/lang/String;", "getNickname", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "", "userId", "Ljava/lang/Number;", "getUserId", "()Ljava/lang/Number;", "g", "(Ljava/lang/Number;)V", "secUid", "getSecUid", "f", "avatarUrl", "getAvatarUrl", "b", "account", "getAccount", "a", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "highlightRange", "Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "getHighlightRange", "()Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/SearchFriendResultModel$b;)V", "hitType", "getHitType", "d", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c {

        @SerializedName("account")
        private String account;

        @SerializedName("avatarUrl")
        private String avatarUrl;

        @SerializedName("highlightRange")
        private b highlightRange;

        @SerializedName("hitType")
        private Number hitType;

        @SerializedName("nickname")
        private String nickname;

        @SerializedName("secUid")
        private String secUid;

        @SerializedName("userId")
        private Number userId;

        public c() {
        }

        public final void a(String r1) {
            this.account = r1;
        }

        public final void b(String r1) {
            this.avatarUrl = r1;
        }

        public final void c(b r1) {
            this.highlightRange = r1;
        }

        public final void d(Number r1) {
            this.hitType = r1;
        }

        public final void e(String r1) {
            this.nickname = r1;
        }

        public final void f(String r1) {
            this.secUid = r1;
        }

        public final void g(Number r1) {
            this.userId = r1;
        }
    }

    public SearchFriendResultModel() {
    }

    public final void a(Code r1) {
        this.code = r1;
    }

    public final void b(a r1) {
        this.data = r1;
    }
}
