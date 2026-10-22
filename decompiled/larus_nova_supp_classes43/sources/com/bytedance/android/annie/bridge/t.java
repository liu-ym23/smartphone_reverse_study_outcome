package com.bytedance.android.annie.bridge;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/annie/bridge/t;", "", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content", "c", "setContent", "", "showCancel", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "setShowCancel", "(Ljava/lang/Boolean;)V", "confirmText", "b", "setConfirmText", "cancelText", "a", "setCancelText", "tapMaskToDismiss", "e", "setTapMaskToDismiss", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("cancelText")
    private String cancelText;

    @SerializedName("confirmText")
    private String confirmText;

    @SerializedName("content")
    private String content;

    @SerializedName("showCancel")
    private Boolean showCancel;

    @SerializedName("tapMaskToDismiss")
    private Boolean tapMaskToDismiss;

    @SerializedName("title")
    private String title;

    public t() {
    }

    public final String a() {
        return this.cancelText;
    }

    public final String b() {
        return this.confirmText;
    }

    public final String c() {
        return this.content;
    }

    public final Boolean d() {
        return this.showCancel;
    }

    public final Boolean e() {
        return this.tapMaskToDismiss;
    }

    public final String f() {
        return this.title;
    }
}
