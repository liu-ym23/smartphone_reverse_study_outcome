package com.ss.android.lark.myai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/myai/api/AuthorizationStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "REJECT", "ACCEPT", "Companion", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum AuthorizationStatus extends Enum<AuthorizationStatus> {
    public static final AuthorizationStatus ACCEPT = null;
    public static final a Companion = null;
    public static final AuthorizationStatus REJECT = null;
    public static final AuthorizationStatus UNKNOWN = null;
    public static final /* synthetic */ AuthorizationStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AuthorizationStatus> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.myai.api.AuthorizationStatus$a] */
    static {
        AuthorizationStatus r0 = new AuthorizationStatus("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        AuthorizationStatus r1 = new AuthorizationStatus("REJECT", 1, 1);
        REJECT = r1;
        AuthorizationStatus r3 = new AuthorizationStatus("ACCEPT", 2, 2);
        ACCEPT = r3;
        AuthorizationStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static AuthorizationStatus[] values() {
        return (AuthorizationStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AuthorizationStatus valueOf(String r1) {
        return (AuthorizationStatus) r27.a.a(AuthorizationStatus.class, r1);
    }

    public AuthorizationStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
