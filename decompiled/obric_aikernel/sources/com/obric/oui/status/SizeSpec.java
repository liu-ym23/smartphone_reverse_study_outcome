package com.obric.oui.status;

import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/status/SizeSpec;", "", "", EventBody.KEY_VALUE, "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "LARGE", "MEDIUM", "SMALL", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum SizeSpec extends Enum<SizeSpec> {
    private static final /* synthetic */ SizeSpec[] $VALUES = null;
    public static final a Companion = null;
    public static final SizeSpec LARGE = null;
    public static final SizeSpec MEDIUM = null;
    public static final SizeSpec SMALL = null;
    private final int value;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        SizeSpec r10 = new SizeSpec("LARGE", 0, 0);
        LARGE = r10;
        SizeSpec r11 = new SizeSpec("MEDIUM", 1, 1);
        MEDIUM = r11;
        SizeSpec r12 = new SizeSpec("SMALL", 2, 2);
        SMALL = r12;
        $VALUES = new SizeSpec[]{r10, r11, r12};
        Companion = new a(null);
    }

    private SizeSpec(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static SizeSpec valueOf(String r10) {
        return (SizeSpec) Enum.valueOf(SizeSpec.class, r10);
    }

    public static SizeSpec[] values() {
        return (SizeSpec[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
