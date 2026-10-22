package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.graphics.drawable.Drawable;
import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003JT\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotParams;", "", "webView", "Landroid/webkit/WebView;", "url", "", "inputViewHeight", "", "bgDrawable", "Landroid/graphics/drawable/Drawable;", "listener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "justShowLoading", "", "<init>", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Z)V", "getWebView", "()Landroid/webkit/WebView;", "getUrl", "()Ljava/lang/String;", "getInputViewHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgDrawable", "()Landroid/graphics/drawable/Drawable;", "getListener", "()Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "getJustShowLoading", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;Z)Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotParams;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocShotParams {
    private final Drawable bgDrawable;
    private final Integer inputViewHeight;
    private final boolean justShowLoading;
    private final h listener;
    private final String url;
    private final WebView webView;

    public static /* synthetic */ DocShotParams copy$default(DocShotParams r4, WebView r5, String r6, Integer r7, Drawable r8, h r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.webView;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.url;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.inputViewHeight;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.bgDrawable;
    L14:
        Drawable r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.listener;
    L17:
        h r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.justShowLoading;
    L20:
        WebView r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final WebView component1() {
        return this.webView;
    }

    public final String component2() {
        return this.url;
    }

    public final Integer component3() {
        return this.inputViewHeight;
    }

    public final Drawable component4() {
        return this.bgDrawable;
    }

    public final h component5() {
        return this.listener;
    }

    public final boolean component6() {
        return this.justShowLoading;
    }

    public final DocShotParams copy(WebView r9, String r10, Integer r11, Drawable r12, h r13, boolean r14) {
        return new DocShotParams(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocShotParams) == true) goto L8;
        return false;
    L8:
        DocShotParams r6 = (DocShotParams) r5;
        if (Intrinsics.areEqual(this.webView, r6.webView) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputViewHeight, r6.inputViewHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgDrawable, r6.bgDrawable) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.listener, r6.listener) == true) goto L24;
        return false;
    L24:
        if (this.justShowLoading == r6.justShowLoading) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        WebView r0 = this.webView;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.inputViewHeight;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Drawable r10 = this.bgDrawable;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        h r13 = this.listener;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        if (this.justShowLoading == false) goto L25;
        int r15 = 1231;
    L27:
        return r14 + r15;
    L25:
        r15 = 1237;
        goto L27
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DocShotParams(webView=" + this.webView + ", url=" + this.url + ", inputViewHeight=" + this.inputViewHeight + ", bgDrawable=" + this.bgDrawable + ", listener=" + this.listener + ", justShowLoading=" + this.justShowLoading + ')';
    }

    public final Drawable getBgDrawable() {
        return this.bgDrawable;
    }

    public final Integer getInputViewHeight() {
        return this.inputViewHeight;
    }

    public final boolean getJustShowLoading() {
        return this.justShowLoading;
    }

    public final h getListener() {
        return this.listener;
    }

    public final String getUrl() {
        return this.url;
    }

    public final WebView getWebView() {
        return this.webView;
    }

    public DocShotParams(WebView r1, String r2, Integer r3, Drawable r4, h r5, boolean r6) {
        this.webView = r1;
        this.url = r2;
        this.inputViewHeight = r3;
        this.bgDrawable = r4;
        this.listener = r5;
        this.justShowLoading = r6;
    }

    public /* synthetic */ DocShotParams(WebView r8, String r9, Integer r10, Drawable r11, h r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        boolean r6 = false;
    L6:
        this(r8, r9, r10, r11, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
