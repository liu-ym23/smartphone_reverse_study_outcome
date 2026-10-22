package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0019\fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "a", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenLiveEffectSelectPanelResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "", "", "effectID", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "effectName", "b", "h", "effectIconUrl", "getEffectIconUrl", "f", "", "effectEnableCustomizeDuration", "Ljava/lang/Boolean;", "getEffectEnableCustomizeDuration", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "", "effectDefaultDuration", "Ljava/lang/Number;", "getEffectDefaultDuration", "()Ljava/lang/Number;", "c", "(Ljava/lang/Number;)V", "effectMaxDuration", "getEffectMaxDuration", "g", "firstLevelEffectCategory", "getFirstLevelEffectCategory", "i", "secondLevelEffectCategory", "getSecondLevelEffectCategory", "j", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("effectDefaultDuration")
        private Number effectDefaultDuration;

        @SerializedName("effectEnableCustomizeDuration")
        private Boolean effectEnableCustomizeDuration;

        @SerializedName("effectID")
        private String effectID;

        @SerializedName("effectIconUrl")
        private String effectIconUrl;

        @SerializedName("effectMaxDuration")
        private Number effectMaxDuration;

        @SerializedName("effectName")
        private String effectName;

        @SerializedName("firstLevelEffectCategory")
        private String firstLevelEffectCategory;

        @SerializedName("secondLevelEffectCategory")
        private String secondLevelEffectCategory;

        public a() {
        }

        public final String a() {
            return this.effectID;
        }

        public final String b() {
            return this.effectName;
        }

        public final void c(Number r1) {
            this.effectDefaultDuration = r1;
        }

        public final void d(Boolean r1) {
            this.effectEnableCustomizeDuration = r1;
        }

        public final void e(String r1) {
            this.effectID = r1;
        }

        public final void f(String r1) {
            this.effectIconUrl = r1;
        }

        public final void g(Number r1) {
            this.effectMaxDuration = r1;
        }

        public final void h(String r1) {
            this.effectName = r1;
        }

        public final void i(String r1) {
            this.firstLevelEffectCategory = r1;
        }

        public final void j(String r1) {
            this.secondLevelEffectCategory = r1;
        }
    }

    public LiveOpenLiveEffectSelectPanelResultModel() {
    }

    public final a a() {
        return this.data;
    }

    public final void b(Code r1) {
        this.code = r1;
    }

    public final void c(a r1) {
        this.data = r1;
    }
}
