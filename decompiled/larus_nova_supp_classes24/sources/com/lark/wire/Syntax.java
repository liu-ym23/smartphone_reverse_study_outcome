package com.lark.wire;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/lark/wire/Syntax;", "", "string", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PROTO_2", "PROTO_3", "toString", "Companion", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum Syntax extends Enum<Syntax> {
    public static final a Companion = null;
    public static final Syntax PROTO_2 = null;
    public static final Syntax PROTO_3 = null;
    public static final /* synthetic */ Syntax[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String string;

    public static EnumEntries<Syntax> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.lark.wire.Syntax$a] */
    static {
        Syntax r0 = new Syntax("PROTO_2", 0, "proto2");
        PROTO_2 = r0;
        Syntax r1 = new Syntax("PROTO_3", 1, "proto3");
        PROTO_3 = r1;
        Syntax[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static Syntax[] values() {
        return (Syntax[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }

    public static final /* synthetic */ String access$getString$p(Syntax r0) {
        return r0.string;
    }

    public static Syntax valueOf(String r1) {
        return (Syntax) r27.a.a(Syntax.class, r1);
    }

    public Syntax(String r1, int r2, String r3) {
        super(r1, r2);
        this.string = r3;
    }
}
