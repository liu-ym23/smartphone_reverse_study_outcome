package com.lark.wire;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/lark/wire/FieldEncoding;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue$wire_runtime", "()I", "VARINT", "FIXED64", "LENGTH_DELIMITED", "FIXED32", "rawProtoAdapter", "Lcom/lark/wire/ProtoAdapter;", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum FieldEncoding extends Enum<FieldEncoding> {
    public static final a Companion = null;
    public static final FieldEncoding FIXED32 = null;
    public static final FieldEncoding FIXED64 = null;
    public static final FieldEncoding LENGTH_DELIMITED = null;
    public static final FieldEncoding VARINT = null;
    public static final /* synthetic */ FieldEncoding[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FieldEncoding.values().length];
            r0[FieldEncoding.VARINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[FieldEncoding.FIXED32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[FieldEncoding.FIXED64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FieldEncoding.LENGTH_DELIMITED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static EnumEntries<FieldEncoding> getEntries() {
        return b;
    }

    static {
        FieldEncoding r0 = new FieldEncoding("VARINT", 0, 0);
        VARINT = r0;
        FieldEncoding r1 = new FieldEncoding("FIXED64", 1, 1);
        FIXED64 = r1;
        FieldEncoding r3 = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
        LENGTH_DELIMITED = r3;
        FieldEncoding r5 = new FieldEncoding("FIXED32", 3, 5);
        FIXED32 = r5;
        FieldEncoding[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static FieldEncoding[] values() {
        return (FieldEncoding[]) a.clone();
    }

    public final ProtoAdapter<?> rawProtoAdapter() {
        int r0 = b.a[ordinal()];
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 != 4) goto L12;
        return ProtoAdapter.p;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return ProtoAdapter.m;
    L19:
        return ProtoAdapter.j;
    L16:
        return ProtoAdapter.l;
    }

    public final int getValue$wire_runtime() {
        return this.value;
    }

    @JvmStatic
    public static final FieldEncoding get$wire_runtime(int r3) throws IOException {
        Companion.getClass();
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 != 5) goto L12;
        return FIXED32;
    L12:
        throw new ProtocolException("Unexpected FieldEncoding: " + r3);
    L18:
        return LENGTH_DELIMITED;
    L19:
        return FIXED64;
    L16:
        return VARINT;
    }

    public static FieldEncoding valueOf(String r1) {
        return (FieldEncoding) r27.a.a(FieldEncoding.class, r1);
    }

    public FieldEncoding(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
