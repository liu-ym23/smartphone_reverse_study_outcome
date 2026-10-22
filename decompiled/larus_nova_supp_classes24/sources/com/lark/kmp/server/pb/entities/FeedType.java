package com.lark.kmp.server.pb.entities;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/server/pb/entities/FeedType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "INBOX", "DONE", "MARK_AS_DELETED", "Companion", "server-pb-wrapper"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum FeedType extends Enum<FeedType> implements o0 {
    public static final ProtoAdapter<FeedType> ADAPTER = null;
    public static final b Companion = null;
    public static final FeedType DONE = null;
    public static final FeedType INBOX = null;
    public static final FeedType MARK_AS_DELETED = null;
    public static final FeedType UNKNOWN_TYPE = null;
    public static final /* synthetic */ FeedType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }
    }

    public static EnumEntries<FeedType> getEntries() {
        return b;
    }

    static {
        final FeedType r0 = new FeedType("UNKNOWN_TYPE", 0, 0);
        UNKNOWN_TYPE = r0;
        FeedType r1 = new FeedType("INBOX", 1, 1);
        INBOX = r1;
        FeedType r3 = new FeedType("DONE", 2, 2);
        DONE = r3;
        FeedType r5 = new FeedType("MARK_AS_DELETED", 3, 3);
        MARK_AS_DELETED = r5;
        FeedType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(FeedType.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static FeedType[] values() {
        return (FeedType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final FeedType fromValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return MARK_AS_DELETED;
    L18:
        return DONE;
    L19:
        return INBOX;
    L15:
        return UNKNOWN_TYPE;
    }

    public static FeedType valueOf(String r1) {
        return (FeedType) r27.a.a(FeedType.class, r1);
    }

    public FeedType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
