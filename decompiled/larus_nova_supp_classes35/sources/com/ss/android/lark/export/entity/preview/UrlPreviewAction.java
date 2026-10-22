package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001'BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\"\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "url", BuildConfig.FLAVOR, "method", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;", "parameters", "Lcom/ss/android/lark/export/entity/preview/Parameters;", "command", BuildConfig.FLAVOR, "openUrl", "Lcom/ss/android/lark/export/entity/preview/Url;", "fallbackActionId", Keys.API_PARAM_KEY_ACTION, "Lcom/ss/android/lark/export/entity/preview/BaseAction;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;Lcom/ss/android/lark/export/entity/preview/Parameters;ILcom/ss/android/lark/export/entity/preview/Url;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/BaseAction;)V", "getUrl", "()Ljava/lang/String;", "getMethod", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;", "getParameters", "()Lcom/ss/android/lark/export/entity/preview/Parameters;", "getCommand", "()I", "getOpenUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "getFallbackActionId", "getAction", "()Lcom/ss/android/lark/export/entity/preview/BaseAction;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "equals", "other", BuildConfig.FLAVOR, "hashCode", "Method", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewAction implements Serializable, b<UrlPreviewAction> {
    private final BaseAction action;
    private final int command;
    private final String fallbackActionId;
    private final Method method;
    private final Url openUrl;
    private final Parameters parameters;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction$Method;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "UNKNOWN_METHOD", "GET", "POST", "LARK_COMMAND", "OPEN_URL", "SWITCH_STATE", "SHOW_TOAST", "SHOW_DIALOG", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Method extends Enum<Method> implements Serializable {
        public static final a Companion = null;
        public static final Method GET = null;
        public static final Method LARK_COMMAND = null;
        public static final Method OPEN_URL = null;
        public static final Method POST = null;
        public static final Method SHOW_DIALOG = null;
        public static final Method SHOW_TOAST = null;
        public static final Method SWITCH_STATE = null;
        public static final Method UNKNOWN_METHOD = null;
        public static final /* synthetic */ Method[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private int value;

        public static final class a {
            public a() {
            }

            public static Method a(int r0) {
                switch(r0) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L13;
                };
            L13:
                return Method.UNKNOWN_METHOD;
            L14:
                return Method.SHOW_DIALOG;
            L15:
                return Method.SHOW_TOAST;
            L16:
                return Method.SWITCH_STATE;
            L17:
                return Method.OPEN_URL;
            L18:
                return Method.LARK_COMMAND;
            L19:
                return Method.POST;
            L20:
                return Method.GET;
            L12:
                return Method.UNKNOWN_METHOD;
            }
        }

        public static EnumEntries<Method> getEntries() {
            return b;
        }

        static {
            Method r0 = new Method("UNKNOWN_METHOD", 0, 0);
            UNKNOWN_METHOD = r0;
            Method r1 = new Method("GET", 1, 1);
            GET = r1;
            Method r3 = new Method("POST", 2, 2);
            POST = r3;
            Method r5 = new Method("LARK_COMMAND", 3, 3);
            LARK_COMMAND = r5;
            Method r7 = new Method("OPEN_URL", 4, 4);
            OPEN_URL = r7;
            Method r9 = new Method("SWITCH_STATE", 5, 5);
            SWITCH_STATE = r9;
            Method r11 = new Method("SHOW_TOAST", 6, 6);
            SHOW_TOAST = r11;
            Method r13 = new Method("SHOW_DIALOG", 7, 7);
            SHOW_DIALOG = r13;
            Method[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
            Companion = new a();
        }

        public static Method[] values() {
            return (Method[]) a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static Method valueOf(String r1) {
            return (Method) r27.a.a(Method.class, r1);
        }

        public final void setValue(int r1) {
            this.value = r1;
        }

        public Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public int hashCode() {
        int r0 = ((this.url.hashCode() * 31) + this.method.hashCode()) * 31;
        Parameters r1 = this.parameters;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + this.command) * 31;
        Url r5 = this.openUrl;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.fallbackActionId;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        BaseAction r11 = this.action;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final BaseAction getAction() {
        return this.action;
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getFallbackActionId() {
        return this.fallbackActionId;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final Url getOpenUrl() {
        return this.openUrl;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlPreviewAction) == true) goto L8;
        return false;
    L8:
        UrlPreviewAction r6 = (UrlPreviewAction) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (this.method == r6.method) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parameters, r6.parameters) == true) goto L18;
        return false;
    L18:
        if (this.command == r6.command) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.openUrl, r6.openUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fallbackActionId, r6.fallbackActionId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public boolean isContentSame(UrlPreviewAction r1) {
        if (equals(r1) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isItemSame(UrlPreviewAction r2) {
        String r0 = this.url;
        if (r2 == null) goto L5;
        String r3 = r2.url;
    L7:
        if (Intrinsics.areEqual(r0, r3) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UrlPreviewAction) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UrlPreviewAction) r1);
    }

    public UrlPreviewAction(String r2, Method r3, Parameters r4, int r5, Url r6, String r7, BaseAction r8) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "method");
        this.url = r2;
        this.method = r3;
        this.parameters = r4;
        this.command = r5;
        this.openUrl = r6;
        this.fallbackActionId = r7;
        this.action = r8;
    }
}
