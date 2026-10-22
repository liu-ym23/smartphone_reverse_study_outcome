package com.ss.android.lark.feed.shared.data.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/data/entity/BusinessType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "FILTER", "GROUP", "Companion", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BusinessType extends Enum<BusinessType> {
    public static final a Companion = null;
    public static final BusinessType FILTER = null;
    public static final BusinessType GROUP = null;
    public static final BusinessType UNKNOWN = null;
    public static final /* synthetic */ BusinessType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BusinessType> getEntries() {
        return b;
    }

    static {
        BusinessType r0 = new BusinessType("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        BusinessType r1 = new BusinessType("FILTER", 1, 1);
        FILTER = r1;
        BusinessType r3 = new BusinessType("GROUP", 2, 2);
        GROUP = r3;
        BusinessType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static BusinessType[] values() {
        return (BusinessType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BusinessType forNumber(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        return UNKNOWN;
    L14:
        return GROUP;
    L15:
        return FILTER;
    L12:
        return UNKNOWN;
    }

    public static BusinessType valueOf(String r1) {
        return (BusinessType) r27.a.a(BusinessType.class, r1);
    }

    public BusinessType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
