package com.lark.kmp.pb.todo.v1;

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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/todo/v1/TodoSource;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_SOURCE", "TODO", "CHAT", "DOC", "DOC_PRODUCT", "OAPI", "DOCX", "MEEGO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TodoSource extends Enum<TodoSource> implements o0 {
    public static final ProtoAdapter<TodoSource> ADAPTER = null;
    public static final TodoSource CHAT = null;
    public static final b Companion = null;
    public static final TodoSource DOC = null;
    public static final TodoSource DOCX = null;
    public static final TodoSource DOC_PRODUCT = null;
    public static final TodoSource MEEGO = null;
    public static final TodoSource OAPI = null;
    public static final TodoSource TODO = null;
    public static final TodoSource UNKNOWN_SOURCE = null;
    public static final /* synthetic */ TodoSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static TodoSource a(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L34;
            if (r1 == 2) goto L33;
            if (r1 == 3) goto L32;
            if (r1 == 4) goto L31;
            if (r1 == 6) goto L30;
            if (r1 == 8) goto L29;
            if (r1 == 9) goto L28;
            return null;
        L28:
            return TodoSource.MEEGO;
        L29:
            return TodoSource.DOCX;
        L30:
            return TodoSource.OAPI;
        L31:
            return TodoSource.DOC_PRODUCT;
        L32:
            return TodoSource.DOC;
        L33:
            return TodoSource.CHAT;
        L34:
            return TodoSource.TODO;
        L26:
            return TodoSource.UNKNOWN_SOURCE;
        }
    }

    @JvmStatic
    public static final TodoSource fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<TodoSource> getEntries() {
        return b;
    }

    static {
        final TodoSource r0 = new TodoSource("UNKNOWN_SOURCE", 0, 0);
        UNKNOWN_SOURCE = r0;
        TodoSource r1 = new TodoSource("TODO", 1, 1);
        TODO = r1;
        TodoSource r3 = new TodoSource("CHAT", 2, 2);
        CHAT = r3;
        TodoSource r5 = new TodoSource("DOC", 3, 3);
        DOC = r5;
        TodoSource r7 = new TodoSource("DOC_PRODUCT", 4, 4);
        DOC_PRODUCT = r7;
        TodoSource r9 = new TodoSource("OAPI", 5, 6);
        OAPI = r9;
        TodoSource r11 = new TodoSource("DOCX", 6, 8);
        DOCX = r11;
        TodoSource r14 = new TodoSource("MEEGO", 7, 9);
        MEEGO = r14;
        TodoSource[] r10 = {r0, r1, r3, r5, r7, r9, r11, r14};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TodoSource.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TodoSource[] values() {
        return (TodoSource[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static TodoSource valueOf(String r1) {
        return (TodoSource) r27.a.a(TodoSource.class, r1);
    }

    public TodoSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
