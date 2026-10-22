package com.lark.kmp.pb.calendar.v1;

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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/ShareButtonDisplayType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HIDDEN", "SHAREABLE", "FORBIDDEN_PRIVATE", "FORBIDDEN_CALENDAR_READER", "FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ShareButtonDisplayType extends Enum<ShareButtonDisplayType> implements o0 {
    public static final ProtoAdapter<ShareButtonDisplayType> ADAPTER = null;
    public static final b Companion = null;
    public static final ShareButtonDisplayType FORBIDDEN_CALENDAR_READER = null;
    public static final ShareButtonDisplayType FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE = null;
    public static final ShareButtonDisplayType FORBIDDEN_PRIVATE = null;
    public static final ShareButtonDisplayType HIDDEN = null;
    public static final ShareButtonDisplayType SHAREABLE = null;
    public static final /* synthetic */ ShareButtonDisplayType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static ShareButtonDisplayType a(int r1) {
            if (r1 == 1) goto L18;
            if (r1 == 2) goto L23;
            if (r1 == 3) goto L22;
            if (r1 == 4) goto L21;
            if (r1 == 5) goto L20;
            return null;
        L20:
            return ShareButtonDisplayType.FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE;
        L21:
            return ShareButtonDisplayType.FORBIDDEN_CALENDAR_READER;
        L22:
            return ShareButtonDisplayType.FORBIDDEN_PRIVATE;
        L23:
            return ShareButtonDisplayType.SHAREABLE;
        L18:
            return ShareButtonDisplayType.HIDDEN;
        }
    }

    @JvmStatic
    public static final ShareButtonDisplayType fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<ShareButtonDisplayType> getEntries() {
        return b;
    }

    static {
        ShareButtonDisplayType r0 = new ShareButtonDisplayType("HIDDEN", 0, 1);
        HIDDEN = r0;
        ShareButtonDisplayType r1 = new ShareButtonDisplayType("SHAREABLE", 1, 2);
        SHAREABLE = r1;
        ShareButtonDisplayType r4 = new ShareButtonDisplayType("FORBIDDEN_PRIVATE", 2, 3);
        FORBIDDEN_PRIVATE = r4;
        ShareButtonDisplayType r6 = new ShareButtonDisplayType("FORBIDDEN_CALENDAR_READER", 3, 4);
        FORBIDDEN_CALENDAR_READER = r6;
        ShareButtonDisplayType r8 = new ShareButtonDisplayType("FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE", 4, 5);
        FORBIDDEN_EVENT_CANNOT_INVITE_ATTENDEE = r8;
        ShareButtonDisplayType[] r10 = {r0, r1, r4, r6, r8};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(ShareButtonDisplayType.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static ShareButtonDisplayType[] values() {
        return (ShareButtonDisplayType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static ShareButtonDisplayType valueOf(String r1) {
        return (ShareButtonDisplayType) r27.a.a(ShareButtonDisplayType.class, r1);
    }

    public ShareButtonDisplayType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
