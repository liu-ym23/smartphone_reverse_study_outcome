package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010\u000f\u001a\u00020\fJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/Button;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "text", BuildConfig.FLAVOR, "buttonJumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getButtonJumpUrl", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "isValid", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Button implements b<Button>, Serializable {
    private final String buttonJumpUrl;
    private final String text;

    public static /* synthetic */ Button copy$default(Button r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.buttonJumpUrl;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.buttonJumpUrl;
    }

    public final Button copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "buttonJumpUrl");
        return new Button(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Button) == true) goto L8;
        return false;
    L8:
        Button r6 = (Button) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonJumpUrl, r6.buttonJumpUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.buttonJumpUrl.hashCode();
    }

    public String toString() {
        return "Button(text=" + this.text + ", buttonJumpUrl=" + this.buttonJumpUrl + ')';
    }

    public final boolean isValid() {
        boolean r1 = true;
        if (this.text.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        r1 = false;
    L14:
        if (r1 == true) goto L16;
        Log.e("Button.isValid", "text: " + this.text + ", buttonJumpUrl: " + this.buttonJumpUrl);
    L16:
        return r1;
    L8:
        if (this.buttonJumpUrl.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
    L10:
        r2 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final String getButtonJumpUrl() {
        return this.buttonJumpUrl;
    }

    public final String getText() {
        return this.text;
    }

    public boolean isContentSame(Button r3) {
        String r0 = this.text;
        if (r3 == null) goto L5;
        String r1 = r3.text;
    L7:
        if (Intrinsics.areEqual(r0, r1) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.buttonJumpUrl, r3.buttonJumpUrl) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Button) r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Button) r1);
    }

    public boolean isItemSame(Button r1) {
        return Intrinsics.areEqual(this, r1);
    }

    public Button(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "buttonJumpUrl");
        this.text = r2;
        this.buttonJumpUrl = r3;
    }
}
