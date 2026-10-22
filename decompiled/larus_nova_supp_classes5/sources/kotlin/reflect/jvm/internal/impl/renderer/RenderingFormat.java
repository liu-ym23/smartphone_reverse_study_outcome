package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract enum RenderingFormat extends Enum<RenderingFormat> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RenderingFormat[] $VALUES = null;
    public static final RenderingFormat HTML = null;
    public static final RenderingFormat PLAIN = null;

    private static final /* synthetic */ RenderingFormat[] $values() {
        return new RenderingFormat[]{PLAIN, HTML};
    }

    public /* synthetic */ RenderingFormat(String r1, int r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    public abstract String escape(String r1);

    static {
        final String r1 = "PLAIN";
        final int r2 = 0;
        PLAIN = new PLAIN(r1, r2);
        final String r3 = "HTML";
        final int r4 = 1;
        HTML = new HTML(r3, r4);
        RenderingFormat[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) $VALUES.clone();
    }

    public static RenderingFormat valueOf(String r1) {
        return (RenderingFormat) a.a(RenderingFormat.class, r1);
    }

    private RenderingFormat(String r1, int r2) {
        super(r1, r2);
    }
}
