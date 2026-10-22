package com.larus.dora.impl.noti_v3.social_message.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "", "titleResId", "", "<init>", "(Ljava/lang/String;II)V", "getTitleResId", "()I", "SINGLE", "GROUP", "RHYTHM", "CONFLICT", "toOptions", "", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeOption;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageModeSheetSource extends Enum<MessageModeSheetSource> {
    public static final MessageModeSheetSource CONFLICT = null;
    public static final a Companion = null;
    public static final MessageModeSheetSource GROUP = null;
    public static final MessageModeSheetSource RHYTHM = null;
    public static final MessageModeSheetSource SINGLE = null;
    public static final /* synthetic */ MessageModeSheetSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int titleResId;

    public static final class a {
        public a() {
        }

        public static MessageModeSheetSource a(String r5) {
            MessageModeSheetSource[] r0 = MessageModeSheetSource.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            MessageModeSheetSource r3 = r0[r2];
            if (Intrinsics.areEqual(r3.name(), r5) == true) goto L9;
            r2 = r2 + 1;
        L9:
            if (r3 == null) goto L11;
            return r3;
        L11:
            return MessageModeSheetSource.GROUP;
        L8:
            r3 = null;
            goto L9
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageModeSheetSource.values().length];
            r0[MessageModeSheetSource.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MessageModeSheetSource.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MessageModeSheetSource.RHYTHM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MessageModeSheetSource.CONFLICT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static EnumEntries<MessageModeSheetSource> getEntries() {
        return b;
    }

    static {
        MessageModeSheetSource r0 = new MessageModeSheetSource("SINGLE", 0, 2131902282);
        SINGLE = r0;
        MessageModeSheetSource r1 = new MessageModeSheetSource("GROUP", 1, 2131902277);
        GROUP = r1;
        MessageModeSheetSource r3 = new MessageModeSheetSource("RHYTHM", 2, 2131902275);
        RHYTHM = r3;
        MessageModeSheetSource r5 = new MessageModeSheetSource("CONFLICT", 3, 2131902265);
        CONFLICT = r5;
        MessageModeSheetSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static MessageModeSheetSource[] values() {
        return (MessageModeSheetSource[]) a.clone();
    }

    public final List<v59.a> toOptions() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L16;
        if (r0 != 4) goto L10;
        return CollectionsKt.listOf(new v59.a[]{new v59.a(2131902263, 2131902264, "0"), new v59.a(2131902261, 2131902262, "1")});
    L10:
        throw new NoWhenBranchMatchedException();
    L16:
        return CollectionsKt.listOf(new v59.a[]{new v59.a(2131902269, 2131902270, "3"), new v59.a(2131902271, 2131902272, "10"), new v59.a(2131902273, 2131902274, "30")});
    L17:
        return CollectionsKt.listOf(new v59.a[]{new v59.a(2131902297, null, "0"), new v59.a(2131902298, 2131902276, "1"), new v59.a(2131902299, null, "2")});
    L14:
        return CollectionsKt.listOf(new v59.a[]{new v59.a(2131902297, null, "0"), new v59.a(2131902298, 2131902281, "1"), new v59.a(2131902299, null, "2")});
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public static MessageModeSheetSource valueOf(String r1) {
        return (MessageModeSheetSource) r27.a.a(MessageModeSheetSource.class, r1);
    }

    public MessageModeSheetSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.titleResId = r3;
    }
}
