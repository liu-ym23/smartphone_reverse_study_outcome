package com.larus.chat.search.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/chat/search/api/model/SectionViewType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "EMPTY", "NORMAL", "TIME", "LAST", "EXTERNAL", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SectionViewType extends Enum<SectionViewType> {
    public static final a Companion = null;
    public static final SectionViewType EMPTY = null;
    public static final SectionViewType EXTERNAL = null;
    public static final SectionViewType LAST = null;
    public static final SectionViewType NORMAL = null;
    public static final SectionViewType TIME = null;
    public static final /* synthetic */ SectionViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static final class a {
        public a() {
        }

        public static SectionViewType a(int r6) {
            SectionViewType[] r0 = SectionViewType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            SectionViewType r4 = r0[r3];
            if (r4.getType() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return SectionViewType.EMPTY;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    public static EnumEntries<SectionViewType> getEntries() {
        return b;
    }

    static {
        SectionViewType r0 = new SectionViewType("EMPTY", 0, -1);
        EMPTY = r0;
        SectionViewType r1 = new SectionViewType("NORMAL", 1, 0);
        NORMAL = r1;
        SectionViewType r3 = new SectionViewType("TIME", 2, 1);
        TIME = r3;
        SectionViewType r5 = new SectionViewType("LAST", 3, 2);
        LAST = r5;
        SectionViewType r7 = new SectionViewType("EXTERNAL", 4, 3);
        EXTERNAL = r7;
        SectionViewType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static SectionViewType[] values() {
        return (SectionViewType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static SectionViewType valueOf(String r1) {
        return (SectionViewType) r27.a.a(SectionViewType.class, r1);
    }

    public SectionViewType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
