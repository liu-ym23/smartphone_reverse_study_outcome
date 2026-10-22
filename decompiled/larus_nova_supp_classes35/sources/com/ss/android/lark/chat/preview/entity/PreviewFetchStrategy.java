package com.ss.android.lark.chat.preview.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/PreviewFetchStrategy;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOCAL", "TRY_LOCAL", "FORCE_SERVER", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewFetchStrategy extends Enum<PreviewFetchStrategy> {
    public static final a Companion = null;
    public static final PreviewFetchStrategy FORCE_SERVER = null;
    public static final PreviewFetchStrategy LOCAL = null;
    public static final PreviewFetchStrategy TRY_LOCAL = null;
    public static final /* synthetic */ PreviewFetchStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<PreviewFetchStrategy> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.preview.entity.PreviewFetchStrategy$a] */
    static {
        PreviewFetchStrategy r0 = new PreviewFetchStrategy("LOCAL", 0, 1);
        LOCAL = r0;
        PreviewFetchStrategy r1 = new PreviewFetchStrategy("TRY_LOCAL", 1, 2);
        TRY_LOCAL = r1;
        PreviewFetchStrategy r4 = new PreviewFetchStrategy("FORCE_SERVER", 2, 3);
        FORCE_SERVER = r4;
        PreviewFetchStrategy[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
        Companion = new a();
    }

    public static PreviewFetchStrategy[] values() {
        return (PreviewFetchStrategy[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static PreviewFetchStrategy valueOf(String r1) {
        return (PreviewFetchStrategy) r27.a.a(PreviewFetchStrategy.class, r1);
    }

    public PreviewFetchStrategy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
