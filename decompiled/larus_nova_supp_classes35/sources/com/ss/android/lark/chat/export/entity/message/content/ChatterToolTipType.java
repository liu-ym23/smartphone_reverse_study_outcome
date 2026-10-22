package com.ss.android.lark.chat.export.entity.message.content;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/export/entity/message/content/ChatterToolTipType;", BuildConfig.FLAVOR, IPortraitService.TYPE, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "UNKNOWN", "SIMPLIFY_SYSTEM_MESSAGE", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatterToolTipType extends Enum<ChatterToolTipType> {
    public static final a Companion = null;
    public static final ChatterToolTipType SIMPLIFY_SYSTEM_MESSAGE = null;
    public static final ChatterToolTipType UNKNOWN = null;
    public static final /* synthetic */ ChatterToolTipType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<ChatterToolTipType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.export.entity.message.content.ChatterToolTipType$a] */
    static {
        ChatterToolTipType r0 = new ChatterToolTipType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        ChatterToolTipType r1 = new ChatterToolTipType("SIMPLIFY_SYSTEM_MESSAGE", 1, 1);
        SIMPLIFY_SYSTEM_MESSAGE = r1;
        ChatterToolTipType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static ChatterToolTipType[] values() {
        return (ChatterToolTipType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ChatterToolTipType valueOf(String r1) {
        return (ChatterToolTipType) r27.a.a(ChatterToolTipType.class, r1);
    }

    public ChatterToolTipType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
