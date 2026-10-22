package com.bytedance.ai.applet.moa;

import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaGrantingResult;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GRANTED", "REFUSED", "FAILED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoaGrantingResult extends Enum<MoaGrantingResult> {
    public static final MoaGrantingResult FAILED = null;
    public static final MoaGrantingResult GRANTED = null;
    public static final MoaGrantingResult REFUSED = null;
    public static final /* synthetic */ MoaGrantingResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<MoaGrantingResult> getEntries() {
        return b;
    }

    static {
        MoaGrantingResult r0 = new MoaGrantingResult("GRANTED", 0, "granted");
        GRANTED = r0;
        MoaGrantingResult r1 = new MoaGrantingResult("REFUSED", 1, "refused");
        REFUSED = r1;
        MoaGrantingResult r10 = new MoaGrantingResult("FAILED", 2, MessageIndication.STATUS_FAILED);
        FAILED = r10;
        MoaGrantingResult[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static MoaGrantingResult[] values() {
        return (MoaGrantingResult[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MoaGrantingResult valueOf(String r1) {
        return (MoaGrantingResult) r27.a.a(MoaGrantingResult.class, r1);
    }

    public MoaGrantingResult(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
