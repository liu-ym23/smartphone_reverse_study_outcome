package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/platform/model/UploadUiStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOCAL", "LOCAL_DRIVE", "LOCAL_DRIVE_RECENT", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum UploadUiStyle extends Enum<UploadUiStyle> {
    public static final a Companion = null;
    public static final UploadUiStyle LOCAL = null;
    public static final UploadUiStyle LOCAL_DRIVE = null;
    public static final UploadUiStyle LOCAL_DRIVE_RECENT = null;
    public static final /* synthetic */ UploadUiStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<UploadUiStyle> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.platform.model.UploadUiStyle$a] */
    static {
        UploadUiStyle r0 = new UploadUiStyle("LOCAL", 0, 0);
        LOCAL = r0;
        UploadUiStyle r1 = new UploadUiStyle("LOCAL_DRIVE", 1, 1);
        LOCAL_DRIVE = r1;
        UploadUiStyle r3 = new UploadUiStyle("LOCAL_DRIVE_RECENT", 2, 2);
        LOCAL_DRIVE_RECENT = r3;
        UploadUiStyle[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static UploadUiStyle[] values() {
        return (UploadUiStyle[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UploadUiStyle valueOf(String r1) {
        return (UploadUiStyle) r27.a.a(UploadUiStyle.class, r1);
    }

    public UploadUiStyle(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
