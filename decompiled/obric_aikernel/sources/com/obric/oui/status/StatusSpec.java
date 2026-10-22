package com.obric.oui.status;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/status/StatusSpec;", "", "", EventBody.KEY_VALUE, "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "EMPTY", "LOADING", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum StatusSpec extends Enum<StatusSpec> {
    private static final /* synthetic */ StatusSpec[] $VALUES = null;
    public static final a Companion = null;
    public static final StatusSpec EMPTY = null;
    public static final StatusSpec LOADING = null;
    private final int value;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        StatusSpec r10 = new StatusSpec("EMPTY", 0, 0);
        EMPTY = r10;
        StatusSpec r11 = new StatusSpec("LOADING", 1, 1);
        LOADING = r11;
        $VALUES = new StatusSpec[]{r10, r11};
        Companion = new a(null);
    }

    private StatusSpec(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static StatusSpec valueOf(String r10) {
        return (StatusSpec) Enum.valueOf(StatusSpec.class, r10);
    }

    public static StatusSpec[] values() {
        return (StatusSpec[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
